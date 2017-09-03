package org.kteam.listener;

//import org.kteam.netty.MyNettyThread;

import org.kteam.entity.Account;
import org.kteam.netty.MyNettyThread;
import org.kteam.service.impl.AccountManagerImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * Created by Administrator on 2017/8/10 0010.
 */
public class NettyListener implements ServletContextListener {

    public void contextDestroyed(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("contextDestroyed");
    }

    public void contextInitialized(ServletContextEvent arg0) {
        // TODO Auto-generated method stub
        System.out.println("contextInitialized");
        WebApplicationContext webApplicationContext = WebApplicationContextUtils.getWebApplicationContext(arg0.getServletContext());
        new Thread(new MyNettyThread(webApplicationContext)).start();
    }
}
