package org.kteam.netty;

import io.netty.channel.Channel;

import org.kteam.netty.srv.acceptor.ChannelEventListener;
import org.kteam.netty.srv.acceptor.DefaultCommonSrvAcceptor;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.swing.*;

public class QuickStart {

    public static void main(String[] args) throws InterruptedException {
        // TODO Auto-generated method stub
//
//
//        DefaultCommonSrvAcceptor acceptor = new DefaultCommonSrvAcceptor(8082, new ChannelEventListener() {
//
//            @Override
//            public void onChannelIdle(String remoteAddr, Channel channel) {
//                // TODO Auto-generated method stub
//
//            }
//            @Override
//            public void onChannelException(String remoteAddr, Channel channel) {
//                // TODO Auto-generated method stub
//
//            }
//
//            public void onChannelConnect(String remoteAddr, Channel channel) {
//                // TODO Auto-generated method stub
//
//            }
//
//            public void onChannelClose(String remoteAddr, Channel channel) {
//                // TODO Auto-generated method stub
//
//            }
//        });
//
//        acceptor.start();
    }

}
