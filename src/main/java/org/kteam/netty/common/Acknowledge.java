
package org.kteam.netty.common;

/**
 * ACK确认
 */
public class Acknowledge {

    public Acknowledge() {}

    public Acknowledge(long sequence,short status) {
        this.sequence = sequence;
        this.status = status;
    }

    private long sequence; // ACK序号

    private short status; //请求相应状态

    public short Status() {
        return status;
    }

    public void Status(short status) {
        this.status = status;
    }

    public long sequence() {
        return sequence;
    }

    public void sequence(long sequence) {
        this.sequence = sequence;
    }
}
