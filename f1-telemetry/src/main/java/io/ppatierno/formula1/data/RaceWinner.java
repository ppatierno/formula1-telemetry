/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;

public class RaceWinner {

    private short vehicleIdx;

    /**
     * Fill the current RaceWinner with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled RaceWinner instance
     */
    public RaceWinner fill(ByteBuf buffer) {
        this.vehicleIdx = buffer.readUnsignedByte();
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current RaceWinner instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeByte(this.vehicleIdx);
        return buffer;
    }

    /**
     * @return Vehicle index of the race winner
     */
    public short getVehicleIdx() {
        return vehicleIdx;
    }

    public void setVehicleIdx(short vehicleIdx) {
        this.vehicleIdx = vehicleIdx;
    }

    @Override
    public String toString() {
        return "RaceWinner[vehicleIdx=" + this.vehicleIdx +
                "]";
    }
}
