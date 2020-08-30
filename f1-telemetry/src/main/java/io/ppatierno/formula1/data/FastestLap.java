/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;

public class FastestLap {

    private short vehicleIdx;
    private float lapTime;

    /**
     * Fill the current FastestLap with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled FastestLap instance
     */
    public FastestLap fill(ByteBuf buffer) {
        this.vehicleIdx = buffer.readUnsignedByte();
        this.lapTime = buffer.readFloatLE();
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current FastestLap instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeByte(this.vehicleIdx);
        buffer.writeFloatLE(this.lapTime);
        return buffer;
    }

    /**
     * @return Vehicle index of car achieving fastest lap
     */
    public short getVehicleIdx() {
        return vehicleIdx;
    }

    public void setVehicleIdx(short vehicleIdx) {
        this.vehicleIdx = vehicleIdx;
    }

    /**
     * @return Lap time is in seconds
     */
    public float getLapTime() {
        return lapTime;
    }

    public void setLapTime(float lapTime) {
        this.lapTime = lapTime;
    }

    @Override
    public String toString() {
        return "FastestLap[vehicleIdx=" + this.vehicleIdx +
                ",lapTime=" + this.lapTime +
                "]";
    }
}
