/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import io.netty.buffer.ByteBuf;

/**
 * Base class for all packets
 */
public abstract class Packet {

    // header
    protected PacketHeader header = new PacketHeader();

    public PacketHeader getHeader() {
        return header;
    }

    public void setHeader(PacketHeader header) {
        this.header = header;
    }

    /**
     * Fill the current Packet instance decoding the proper bytes from the buffer
     * 
     * @param buffer buffer with the packet raw bytes
     * @return current instance
     */
    public Packet fill(ByteBuf buffer) {
        this.header.fill(buffer);
        return this;
    }

    /**
     * Fill the provided buffer with the raw bytes representation of the current Packet instance
     * 
     * @param buffer buffer to fill with the packet raw bytes
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        this.header.fillBuffer(buffer);
        return buffer;
    }
    
    @Override
    public String toString() {
        return this.header.toString();
    }
}