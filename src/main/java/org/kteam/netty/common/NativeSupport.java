
package org.kteam.netty.common;

/**
 * 环境监测类
 * 主要监测是否存在Epoll传输服务
 * Nio（Netty原生）：使用java.nio.channels包将使用以基于selector为基础的方法
 * Epoll（Linux）：	使用JNI的epoll和非阻塞I/O,这种传输服务支持的一些特性在Li
 * nux上才能有效，例如SO_REUSEPORT并且比NIO和完全非阻塞都要更加快捷
 * 
 * 主要用于EventLoopGroup的初始化。
 * @author Mo
 *
 */
public final class NativeSupport {

    private static final boolean SUPPORT_NATIVE_ET;

    static {
        boolean epoll;
        try {
            Class.forName("io.netty.channel.epoll.Native");
            epoll = true;
        } catch (Throwable e) {
            epoll = false;
        }
        SUPPORT_NATIVE_ET = epoll;
    }

    /**
     * The native socket transport for Linux using JNI.
     */
    public static boolean isSupportNativeET() {
        return SUPPORT_NATIVE_ET;
    }
}
