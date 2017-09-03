
package org.kteam.netty.common;

import io.protostuff.Tag;

import java.util.concurrent.atomic.AtomicLong;

/**
 * Netty传输的基本单位
 * @author Mo
 *
 */
public class Message {

	//自动累加器
    private static final AtomicLong sequenceGenerator = new AtomicLong(0);

    //ACK序号
    @Tag(1)
    private final long sequence;
    //标志位
    @Tag(2)
    private short sign;
    @Tag(3)
    private long version; // 版本号
    @Tag(4)
    private Object data;
    @Tag(5)
    private short type;

    public short Type() {
        return type;
    }

    public void Type(byte type) {
        this.type = type;
    }

    public Message() {
        this(sequenceGenerator.getAndIncrement(),(short) 0,null,0);
    }

    public Message(long sequence) {
        this(sequence,(short) 0,null,0);
    }

    public Message(short sign,String data,long version){
    	this.sequence = sequenceGenerator.getAndIncrement();
    	this.sign = sign;
    	this.data = data;
    	this.version = version;
    }
    public Message(long sequence,short sign,String data,long version){
    	this.sequence = sequence;
    	this.sign = sign;
    	this.data = data;
    	this.version = version;
    }
    public long sequence() {
        return sequence;
    }

    public short sign() {
        return sign;
    }

    public void sign(short sign) {
        this.sign = sign;
    }

    public long getVersion() {
        return version;
    }

    public void setVersion(long version) {
        this.version = version;
    }

    public Object data() {
        return data;
    }

    public void data(Object data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Message{" +
                "sequence=" + sequence +
                ", sign=" + sign +
                ", version=" + version +
                ", data=" + data +
                '}';
    }

}
