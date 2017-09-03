package org.kteam.netty.handler;

import com.alibaba.fastjson.JSON;
import io.netty.channel.*;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;
import org.kteam.entity.Account;
import org.kteam.netty.common.Acknowledge;
import org.kteam.netty.common.Message;
import org.kteam.netty.common.protocol.NettyCommonProtocol;
import org.kteam.netty.srv.acceptor.DefaultCommonSrvAcceptor;
import org.kteam.service.AccountManager;
import org.kteam.service.impl.AccountManagerImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import static org.kteam.netty.common.protocol.MessageTypeProtocol.*;

@ChannelHandler.Sharable
public class MessageHandler extends SimpleChannelInboundHandler<Message> {

	private static WebApplicationContext webApplicationContext;

	public void getWebApplicationContext(WebApplicationContext webApplicationContext){
		this.webApplicationContext = webApplicationContext;
	}

	private static final Logger logger = LoggerFactory.getLogger(DefaultCommonSrvAcceptor.class);
	public static ChannelGroup channels = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);
	@Override
	public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		Channel in = ctx.channel();
		logger.info("[Server] - " + in.remoteAddress() +"join /n");
		for(Channel channel : channels){
			channel.writeAndFlush(new Message(NettyCommonProtocol.SERVICE_1,"[Server] - " + in.remoteAddress() +"join /n",0));
		}
		channels.add(in);
	}

	@Override
	public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
		// TODO Auto-generated method stub
		Channel out = ctx.channel();
		logger.info("[Server] - " + out.remoteAddress() +"left /n");
		for(Channel channel : channels){
			channel.writeAndFlush(new Message(NettyCommonProtocol.SERVICE_1,"[Server] - " + out.remoteAddress() +"Left /n",0));
		}
		channels.add(out);
	}

	@Override
	protected void channelRead0(ChannelHandlerContext ctx, Message message) throws Exception {
		Channel incoming = ctx.channel();


		switch (message.Type()) {

			case CHAT: {
				for (Channel channel : channels) {
					if (channel != incoming) {
						logger.info("[" + incoming.remoteAddress() + "]" + message.data() + "\n");
						channel.writeAndFlush(new Message(NettyCommonProtocol.SERVICE_1, "[" + incoming.remoteAddress() + "]" + message.data() + "\n", 0));
					} else {
						logger.info("[" + incoming.remoteAddress() + "]" + message.data() + "\n");
						channel.writeAndFlush(new Message(NettyCommonProtocol.SERVICE_2, "" + message.data(), 0));
					}
				}
				break;
			}
			case LOGIN: {
				AccountManagerImpl accountManager = webApplicationContext.getBean(AccountManagerImpl.class);
				short statu = accountManager.Login(JSON.parseObject(message.data().toString(),Account.class));
				incoming.writeAndFlush(new Acknowledge(message.sequence(),statu)).addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
				break;
			}
			case REGISTER: {
				AccountManagerImpl accountManager = webApplicationContext.getBean(AccountManagerImpl.class);
				short statu = accountManager.Register(JSON.parseObject(message.data().toString(),Account.class));
				incoming.writeAndFlush(new Acknowledge(message.sequence(),statu)).addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
			}
			default:
				throw new IllegalAccessException();

		}
		// 接收到发布信息的时候，要给Client端回复ACK
//		incoming.writeAndFlush(new Acknowledge(message.sequence(),0)).addListener(ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE);
	}


}
