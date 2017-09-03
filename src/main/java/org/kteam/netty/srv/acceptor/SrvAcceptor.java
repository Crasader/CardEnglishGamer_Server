package org.kteam.netty.srv.acceptor;

import java.net.SocketAddress;

/**
 * NettyServer标准接口
 * @author Mo
 *
 */
public interface SrvAcceptor {
	
	SocketAddress localAddress();
	
	void start() throws InterruptedException;
	
	void shutdownGracefully();
	
	void start(boolean sync) throws InterruptedException;

}
