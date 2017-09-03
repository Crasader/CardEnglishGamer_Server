package org.kteam.netty.srv.acceptor;

import io.netty.channel.Channel;

/**
 * 管道事件监听器
 * @author Mo
 *
 */
public interface ChannelEventListener {
    void onChannelConnect(final String remoteAddr, final Channel channel);


    void onChannelClose(final String remoteAddr, final Channel channel);


    void onChannelException(final String remoteAddr, final Channel channel);


    void onChannelIdle(final String remoteAddr, final Channel channel);
}
