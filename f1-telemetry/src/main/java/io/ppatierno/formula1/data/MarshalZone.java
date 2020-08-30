package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.enums.ZoneFlag;

public class MarshalZone {

    public static final int SIZE = 5;

    private float zoneStart;
    public ZoneFlag zoneFlag;

    /**
     * Fill the current MarshalZone with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled MarshalZone instance
     */
    public MarshalZone fill(ByteBuf buffer) {
        this.zoneStart = buffer.readFloatLE();
        this.zoneFlag = ZoneFlag.valueOf(buffer.readByte());
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current MarshalZone instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeFloatLE(this.zoneStart);
        buffer.writeByte(this.zoneFlag.getValue());
        return buffer;
    }

    /**
     * @return Zone start
     * Fraction (0..1) of way through the lap the marshal zone starts
     */
    public float getZoneStart() {
        return zoneStart;
    }

    public void setZoneStart(float zoneStart) {
        this.zoneStart = zoneStart;
    }

    /**
     * @return Zone flag
     * -1 = invalid/unknown, 0 = none, 1 = green, 2 = blue, 3 = yellow, 4 = red
     */
    public ZoneFlag getZoneFlag() {
        return zoneFlag;
    }

    public void setZoneFlag(ZoneFlag zoneFlag) {
        this.zoneFlag = zoneFlag;
    }

    @Override
    public String toString() {
        return "MarshalZone[zoneStart=" + this.zoneStart +
                ",zoneFlag=" + this.zoneFlag +
                "]";
    }
}
