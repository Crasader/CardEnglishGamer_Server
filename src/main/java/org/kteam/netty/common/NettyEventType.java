
package org.kteam.netty.common;

/**
 * 与客户端交互产生的事件类型
 * @author Mo
 */
public enum NettyEventType {
    CONNECT,//建立连接
    CLOSE,  //断开连接
    IDLE,   //对方发送心跳包
    EXCEPTION//通信过程产生了异常
}
