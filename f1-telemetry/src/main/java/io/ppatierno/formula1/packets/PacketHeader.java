/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketUtils;
import io.ppatierno.formula1.enums.PacketId;

import java.math.BigInteger;

/**
 * Packet header
 */
public class PacketHeader {

    // offset in the raw bytes where the packetId is
    public static final int PACKET_ID_OFFSET = 5;

    private int packetFormat;
    private short gameMajorVersion;
    private short gameMinorVersion;
    private short packetVersion;
    private PacketId packetId;
    private BigInteger sessionUid;
    private float sessionTime;
    private long frameIdentifier;
    private short playerCarIndex;
    private short secondaryPlayerCarIndex;

    /**
     * Fill the current PacketHeader with the raw bytes representation
     * 
     * @param buffer buffer with the raw bytes representation
     * @return current filled PacketHeader instance
     */
    public PacketHeader fill(ByteBuf buffer) {
        this.packetFormat = buffer.readUnsignedShortLE();
        this.gameMajorVersion = buffer.readUnsignedByte();
        this.gameMinorVersion = buffer.readUnsignedByte();
        this.packetVersion = buffer.readUnsignedByte();
        this.packetId = PacketId.valueOf(buffer.readUnsignedByte());
        this.sessionUid = PacketUtils.toUnsignedBigInteger(buffer.readLongLE());
        this.sessionTime = buffer.readFloatLE();
        this.frameIdentifier = buffer.readUnsignedIntLE();
        this.playerCarIndex = buffer.readUnsignedByte();
        this.secondaryPlayerCarIndex = buffer.readUnsignedByte();
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current PacketHeader instance
     * 
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeShortLE(this.packetFormat);
        buffer.writeByte(this.gameMajorVersion);
        buffer.writeByte(this.gameMinorVersion);
        buffer.writeByte(this.packetVersion);
        buffer.writeByte(this.packetId.getValue());
        buffer.writeLongLE(this.sessionUid.longValue());
        buffer.writeFloatLE(this.sessionTime);
        buffer.writeIntLE((int)this.frameIdentifier);
        buffer.writeByte(this.playerCarIndex);
        buffer.writeByte(this.secondaryPlayerCarIndex);
        return buffer;
    }

    /**
     * @return Packet format (i.e. 2020)
     */
    public int getPacketFormat() {
        return packetFormat;
    }

    public void setPacketFormat(int packetFormat) {
        this.packetFormat = packetFormat;
    }

    /**
     * @return Game major version - "X.00"
     */
    public short getGameMajorVersion() {
        return gameMajorVersion;
    }

    public void setGameMajorVersion(short gameMajorVersion) {
        this.gameMajorVersion = gameMajorVersion;
    }

    /**
     * @return Game minor version - "1.XX"
     */
    public short getGameMinorVersion() {
        return gameMinorVersion;
    }

    public void setGameMinorVersion(short gameMinorVersion) {
        this.gameMinorVersion = gameMinorVersion;
    }

    /**
     * @return Version of this packet type, all start from 1
     */
    public short getPacketVersion() {
        return packetVersion;
    }

    public void setPacketVersion(short packetVersion) {
        this.packetVersion = packetVersion;
    }

    /**
     * @return Identifier for the packet type
     */
    public PacketId getPacketId() {
        return packetId;
    }

    public void setPacketId(PacketId packetId) {
        this.packetId = packetId;
    }

    /**
     * @return Unique identifier for the session
     */
    public BigInteger getSessionUid() {
        return sessionUid;
    }

    public void setSessionUid(BigInteger sessionUid) {
        this.sessionUid = sessionUid;
    }

    /**
     * @return Session timestamp
     */
    public float getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(float sessionTime) {
        this.sessionTime = sessionTime;
    }

    /**
     * @return Identifier for the frame the data was retrieved on
     */
    public long getFrameIdentifier() {
        return frameIdentifier;
    }

    public void setFrameIdentifier(long frameIdentifier) {
        this.frameIdentifier = frameIdentifier;
    }

    /**
     * @return Index of player's car in the array
     */
    public short getPlayerCarIndex() {
        return playerCarIndex;
    }

    public void setPlayerCarIndex(short playerCarIndex) {
        this.playerCarIndex = playerCarIndex;
    }

    /**
     * @return Index of secondary player's car in the array (splitscreen). 255 if no second player.
     */
    public short getSecondaryPlayerCarIndex() {
        return secondaryPlayerCarIndex;
    }

    public void setSecondaryPlayerCarIndex(short secondaryPlayerCarIndex) {
        this.secondaryPlayerCarIndex = secondaryPlayerCarIndex;
    }

    @Override
    public String toString() {
        return "Header[format=" + this.packetFormat +
                ",major=" + this.gameMajorVersion +
                ",minor=" + this.gameMinorVersion +
                ",version=" + this.packetVersion + 
                ",id=" + this.packetId +
                ",sessionUid=" + this.sessionUid +
                ",sessionTime=" + this.sessionTime +
                ",frameIdentifier=" + this.frameIdentifier +
                ",playerCarIndex=" + this.playerCarIndex +
                ",secondaryPlayerCarIndex=" + this.secondaryPlayerCarIndex +
                "]";
    }
}