package io.ppatierno;

import java.math.BigInteger;

/**
 * Packet header
 */
public class PacketHeader {

    private int packetFormat;
    private short gameMajorVersion;
    private short gameMinorVersion;
    private short packetVersion;
    private short packetId;
    private BigInteger sessionUid;
    private float sessionTime;
    private long frameIdentifier;
    private short playerCarIndex;
    private short secondaryPlayerCarIndex;

    /**
     * @return packet format (i.e. 2020)
     */
    public int getPacketFormat() {
        return packetFormat;
    }

    public void setPacketFormat(int packetFormat) {
        this.packetFormat = packetFormat;
    }

    /**
     * @return game major version - "X.00"
     */
    public short getGameMajorVersion() {
        return gameMajorVersion;
    }

    public void setGameMajorVersion(short gameMajorVersion) {
        this.gameMajorVersion = gameMajorVersion;
    }

    /**
     * @return game minor version - "1.XX"
     */
    public short getGameMinorVersion() {
        return gameMinorVersion;
    }

    public void setGameMinorVersion(short gameMinorVersion) {
        this.gameMinorVersion = gameMinorVersion;
    }

    /**
     * @return version of this packet type, all start from 1
     */
    public short getPacketVersion() {
        return packetVersion;
    }

    public void setPacketVersion(short packetVersion) {
        this.packetVersion = packetVersion;
    }

    /**
     * @return identifier for the packet type
     */
    public short getPacketId() {
        return packetId;
    }

    public void setPacketId(short packetId) {
        this.packetId = packetId;
    }

    /**
     * @return unique identifier for the session
     */
    public BigInteger getSessionUid() {
        return sessionUid;
    }

    public void setSessionUid(BigInteger sessionUid) {
        this.sessionUid = sessionUid;
    }

    /**
     * @return session timestamp
     */
    public float getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(float sessionTime) {
        this.sessionTime = sessionTime;
    }

    /**
     * @return identifier for the frame the data was retrieved on
     */
    public long getFrameIdentifier() {
        return frameIdentifier;
    }

    public void setFrameIdentifier(long frameIdentifier) {
        this.frameIdentifier = frameIdentifier;
    }

    /**
     * @return index of player's car in the array
     */
    public short getPlayerCarIndex() {
        return playerCarIndex;
    }

    public void setPlayerCarIndex(short playerCarIndex) {
        this.playerCarIndex = playerCarIndex;
    }

    /**
     * @return index of secondary player's car in the array (splitscreen). 255 if no second player.
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