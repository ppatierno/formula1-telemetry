/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

import java.math.BigInteger;

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
        this.header.setPacketFormat(buffer.readUnsignedShortLE());
        this.header.setGameMajorVersion(buffer.readUnsignedByte());
        this.header.setGameMinorVersion(buffer.readUnsignedByte());
        this.header.setPacketVersion(buffer.readUnsignedByte());
        this.header.setPacketId(PacketId.valueOf(buffer.readUnsignedByte()));
        this.header.setSessionUid(BigInteger.valueOf(buffer.readLongLE()));
        this.header.setSessionTime(buffer.readFloatLE());
        this.header.setFrameIdentifier(buffer.readIntLE());
        this.header.setPlayerCarIndex(buffer.readUnsignedByte());
        this.header.setSecondaryPlayerCarIndex(buffer.readUnsignedByte());
        return this;
    }
    
    @Override
    public String toString() {
        return this.header.toString();
    }
}