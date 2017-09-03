package org.kteam.netty;

import io.netty.channel.Channel;
import org.kteam.entity.Account;
import org.kteam.netty.srv.acceptor.ChannelEventListener;
import org.kteam.netty.srv.acceptor.DefaultCommonSrvAcceptor;
import org.kteam.service.impl.AccountManagerImpl;
import org.kteam.utils.SpringContextUtil;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public class MyNettyThread implements Runnable{

    private WebApplicationContext webApplicationContext;

    public MyNettyThread(WebApplicationContext webApplicationContext) {
        this.webApplicationContext = webApplicationContext;
    }

    public void run() {

        DefaultCommonSrvAcceptor acceptor = new DefaultCommonSrvAcceptor(8082,webApplicationContext, new ChannelEventListener() {

            public void onChannelIdle(String remoteAddr, Channel channel) {
                // TODO Auto-generated method stub

            }

            public void onChannelException(String remoteAddr, Channel channel) {
                // TODO Auto-generated method stub

            }

            public void onChannelConnect(String remoteAddr, Channel channel) {
                // TODO Auto-generated method stub

            }

            public void onChannelClose(String remoteAddr, Channel channel) {
                // TODO Auto-generated method stub

            }
        });
        try {
            acceptor.start();
        }catch(InterruptedException e)
        {
            e.printStackTrace();
        }
    }

}

