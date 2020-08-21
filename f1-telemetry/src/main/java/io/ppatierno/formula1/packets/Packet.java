/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.math.BigInteger;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketUtils;
import io.ppatierno.formula1.enums.PacketId;

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
        this.header.setSessionUid(PacketUtils.toUnsignedBigInteger(buffer.readLongLE()));
        this.header.setSessionTime(buffer.readFloatLE());
        this.header.setFrameIdentifier(buffer.readUnsignedIntLE());
        this.header.setPlayerCarIndex(buffer.readUnsignedByte());
        this.header.setSecondaryPlayerCarIndex(buffer.readUnsignedByte());
        return this;
    }

    /**
     * Fill the provided buffer with the raw bytes representation of the current Packet instance
     * 
     * @param buffer buffer to fill with the packet raw bytes
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeShortLE(this.header.getPacketFormat());
        buffer.writeByte(this.header.getGameMajorVersion());
        buffer.writeByte(this.header.getGameMinorVersion());
        buffer.writeByte(this.header.getPacketVersion());
        buffer.writeByte(this.header.getPacketId().getValue());
        buffer.writeLongLE(this.header.getSessionUid().longValue());
        buffer.writeFloatLE(this.header.getSessionTime());
        buffer.writeIntLE((int)this.header.getFrameIdentifier());
        buffer.writeByte(this.header.getPlayerCarIndex());
        buffer.writeByte(this.header.getSecondaryPlayerCarIndex());
        return buffer;
    }
    
    @Override
    public String toString() {
        return this.header.toString();
    }
}