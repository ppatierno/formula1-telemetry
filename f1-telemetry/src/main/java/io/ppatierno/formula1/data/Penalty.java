/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.enums.InfringementType;
import io.ppatierno.formula1.enums.PenaltyType;

public class Penalty {

    private PenaltyType penaltyType;
    private InfringementType infringementType;
    private short vehicleIdx;
    private short otherVehicleIdx;
    private short time;
    private short lapNum;
    private short placesGained;

    /**
     * Fill the current Penalty with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled Penalty instance
     */
    public Penalty fill(ByteBuf buffer) {
        this.penaltyType = PenaltyType.valueOf(buffer.readUnsignedByte());
        this.infringementType = InfringementType.valueOf(buffer.readUnsignedByte());
        this.vehicleIdx = buffer.readUnsignedByte();
        this.otherVehicleIdx = buffer.readUnsignedByte();
        this.time = buffer.readUnsignedByte();
        this.lapNum = buffer.readUnsignedByte();
        this.placesGained = buffer.readUnsignedByte();
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current Penalty instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeByte(this.penaltyType.getValue());
        buffer.writeByte(this.infringementType.getValue());
        buffer.writeByte(this.vehicleIdx);
        buffer.writeByte(this.otherVehicleIdx);
        buffer.writeByte(this.time);
        buffer.writeByte(this.lapNum);
        buffer.writeByte(this.placesGained);
        return buffer;
    }

    /**
     * @return Penalty type
     */
    public PenaltyType getPenaltyType() {
        return penaltyType;
    }

    public void setPenaltyType(PenaltyType penaltyType) {
        this.penaltyType = penaltyType;
    }

    /**
     * @return Infringement type
     */
    public InfringementType getInfringementType() {
        return infringementType;
    }

    public void setInfringementType(InfringementType infringementType) {
        this.infringementType = infringementType;
    }

    /**
     * @return Vehicle index of the car the penalty is applied to
     */
    public short getVehicleIdx() {
        return vehicleIdx;
    }

    public void setVehicleIdx(short vehicleIdx) {
        this.vehicleIdx = vehicleIdx;
    }

    /**
     * @return Vehicle index of the other car involved
     */
    public short getOtherVehicleIdx() {
        return otherVehicleIdx;
    }

    public void setOtherVehicleIdx(short otherVehicleIdx) {
        this.otherVehicleIdx = otherVehicleIdx;
    }

    /**
     * @return Time gained, or time spent doing action in seconds
     */
    public short getTime() {
        return time;
    }

    public void setTime(short time) {
        this.time = time;
    }

    /**
     * @return Lap the penalty occurred on
     */
    public short getLapNum() {
        return lapNum;
    }

    public void setLapNum(short lapNum) {
        this.lapNum = lapNum;
    }

    /**
     * @return Number of places gained by this
     */
    public short getPlacesGained() {
        return placesGained;
    }

    public void setPlacesGained(short placesGained) {
        this.placesGained = placesGained;
    }

    @Override
    public String toString() {
        return "Penalty[penaltyType=" + this.penaltyType +
                ",infringementType=" + this.infringementType +
                ",vehicleIdx=" + this.vehicleIdx +
                ",otherVehicleIdx=" + this.otherVehicleIdx +
                ",time=" + this.time +
                ",lapNum=" + this.lapNum +
                ",placesGained=" + this.placesGained +
                "]";
    }
}
