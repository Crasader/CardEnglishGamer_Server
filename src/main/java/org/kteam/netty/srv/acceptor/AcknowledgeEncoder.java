package org.kteam.netty.srv.acceptor;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandler;
import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.MessageToByteEncoder;
import org.kteam.netty.common.Acknowledge;

import static org.kteam.netty.common.protocol.NettyCommonProtocol.ACK;
import static org.kteam.netty.common.protocol.NettyCommonProtocol.MAGIC;
import static org.kteam.netty.serializer.SerializerHolder.serializerImpl;


/**
 * @description ack的编码器
 * @author Mo
 */
@ChannelHandler.Sharable
public class AcknowledgeEncoder extends MessageToByteEncoder<Acknowledge> {

    @Override
    protected void encode(ChannelHandlerContext ctx, Acknowledge ack, ByteBuf out) throws Exception {
        byte[] bytes = serializerImpl().writeObject(ack);
        out.writeShort(MAGIC)
                .writeByte(ACK)
                .writeByte(ack.Status())
                .writeLong(ack.sequence())
                .writeInt(bytes.length)
                .writeBytes(bytes);
    }
}
