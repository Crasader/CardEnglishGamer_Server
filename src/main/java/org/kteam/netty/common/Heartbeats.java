package org.kteam.netty.common;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;

import static org.kteam.netty.common.protocol.NettyCommonProtocol.*;

/**
 * 心跳包
 * @author Mo
 *
 */
public class Heartbeats {

    private static final ByteBuf HEARTBEAT_BUF;

    //静态块，防止多次初始化影响性能
    //初始化心跳包的ByteBuf（根据Message自定义格式）
    static {
        ByteBuf buf = Unpooled.buffer(HEAD_LENGTH);
        buf.writeShort(MAGIC);
        buf.writeByte(HEARTBEAT);
        buf.writeByte(0);
        buf.writeLong(0);
        buf.writeInt(0);
        HEARTBEAT_BUF = Unpooled.unmodifiableBuffer(Unpooled.unreleasableBuffer(buf));
    }

    public static ByteBuf heartbeatContent() {
        return HEARTBEAT_BUF.duplicate();
    }
}
