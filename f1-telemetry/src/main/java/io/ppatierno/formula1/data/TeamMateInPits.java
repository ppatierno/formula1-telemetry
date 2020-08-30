/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;

public class TeamMateInPits {

    private short vehicleIdx;

    /**
     * Fill the current TeamMateInPits with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled TeamMateInPits instance
     */
    public TeamMateInPits fill(ByteBuf buffer) {
        this.vehicleIdx = buffer.readUnsignedByte();
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current TeamMateInPits instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeByte(this.vehicleIdx);
        return buffer;
    }

    /**
     * @return Vehicle index of team mate
     */
    public short getVehicleIdx() {
        return vehicleIdx;
    }

    public void setVehicleIdx(short vehicleIdx) {
        this.vehicleIdx = vehicleIdx;
    }

    @Override
    public String toString() {
        return "TeamMateInPits[vehicleIdx=" + this.vehicleIdx +
                "]";
    }
}
