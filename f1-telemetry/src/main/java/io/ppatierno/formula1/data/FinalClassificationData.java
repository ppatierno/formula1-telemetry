/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.enums.ResultStatus;

import java.util.Arrays;

public class FinalClassificationData {

    public static final int SIZE = 37;

    private short position;
    private short numLaps;
    private short gridPosition;
    private short points;
    private short numPitStops;
    private ResultStatus resultStatus;
    private float bestLapTime;
    private double totalRaceTime;
    private short penaltiesTime;
    private short numPenalties;
    private short numTyreStints;
    private short tyreStintsActual[] = new short[PacketConstants.TYRE_STINTS];
    private short tyreStintsVisual[] = new short[PacketConstants.TYRE_STINTS];

    /**
     * Fill the current FinalClassificationData with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled FinalClassificationData instance
     */
    public FinalClassificationData fill(ByteBuf buffer) {
        this.position = buffer.readUnsignedByte();
        this.numLaps = buffer.readUnsignedByte();
        this.gridPosition = buffer.readUnsignedByte();
        this.points = buffer.readUnsignedByte();
        this.numPitStops = buffer.readUnsignedByte();
        this.resultStatus = ResultStatus.valueOf(buffer.readUnsignedByte());
        this.bestLapTime = buffer.readFloatLE();
        this.totalRaceTime = buffer.readDoubleLE();
        this.penaltiesTime = buffer.readUnsignedByte();
        this.numPenalties = buffer.readUnsignedByte();
        this.numTyreStints = buffer.readUnsignedByte();
        for (int j = 0; j < PacketConstants.TYRE_STINTS; j++) {
            this.tyreStintsActual[j] = buffer.readUnsignedByte();
        }
        for (int j = 0; j < PacketConstants.TYRE_STINTS; j++) {
            this.tyreStintsVisual[j] = buffer.readUnsignedByte();
        }
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current FinalClassificationData instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeByte(this.position);
        buffer.writeByte(this.numLaps);
        buffer.writeByte(this.gridPosition);
        buffer.writeByte(this.points);
        buffer.writeByte(this.numPitStops);
        buffer.writeByte(this.resultStatus.getValue());
        buffer.writeFloatLE(this.bestLapTime);
        buffer.writeDoubleLE(this.totalRaceTime);
        buffer.writeByte(this.penaltiesTime);
        buffer.writeByte(this.numPenalties);
        buffer.writeByte(this.numTyreStints);
        for (int j = 0; j < PacketConstants.TYRE_STINTS; j++) {
            buffer.writeByte(this.tyreStintsActual[j]);
        }
        for (int j = 0; j < PacketConstants.TYRE_STINTS; j++) {
            buffer.writeByte(this.tyreStintsVisual[j]);
        }
        return buffer;
    }

    /**
     * @return Finishing position
     */
    public short getPosition() {
        return position;
    }

    public void setPosition(short position) {
        this.position = position;
    }

    /**
     * @return Number of laps completed
     */
    public short getNumLaps() {
        return numLaps;
    }

    public void setNumLaps(short numLaps) {
        this.numLaps = numLaps;
    }

    /**
     * @return Grid position of the car
     */
    public short getGridPosition() {
        return gridPosition;
    }

    public void setGridPosition(short gridPosition) {
        this.gridPosition = gridPosition;
    }

    /**
     * @return Number of points scored
     */
    public short getPoints() {
        return points;
    }

    public void setPoints(short points) {
        this.points = points;
    }

    /**
     * @return Number of pit stops made
     */
    public short getNumPitStops() {
        return numPitStops;
    }

    public void setNumPitStops(short numPitStops) {
        this.numPitStops = numPitStops;
    }

    /**
     * @return Result status
     * 0 = invalid, 1 = inactive, 2 = active
     * 3 = finished, 4 = disqualified, 5 = not classified
     * 6 = retired
     */
    public ResultStatus getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(ResultStatus resultStatus) {
        this.resultStatus = resultStatus;
    }

    /**
     * @return Best lap time of the session in seconds
     */
    public float getBestLapTime() {
        return bestLapTime;
    }

    public void setBestLapTime(float bestLapTime) {
        this.bestLapTime = bestLapTime;
    }

    /**
     * @return Total race time in seconds without penalties
     */
    public double getTotalRaceTime() {
        return totalRaceTime;
    }

    public void setTotalRaceTime(double totalRaceTime) {
        this.totalRaceTime = totalRaceTime;
    }

    /**
     * @return Total penalties accumulated in seconds
     */
    public short getPenaltiesTime() {
        return penaltiesTime;
    }

    public void setPenaltiesTime(short penaltiesTime) {
        this.penaltiesTime = penaltiesTime;
    }

    /**
     * @return Number of penalties applied to this driver
     */
    public short getNumPenalties() {
        return numPenalties;
    }

    public void setNumPenalties(short numPenalties) {
        this.numPenalties = numPenalties;
    }

    /**
     * @return Number of tyres stints up to maximum
     */
    public short getNumTyreStints() {
        return numTyreStints;
    }

    public void setNumTyreStints(short numTyreStints) {
        this.numTyreStints = numTyreStints;
    }

    /**
     * @return Actual tyres used by this driver
     */
    public short[] getTyreStintsActual() {
        return tyreStintsActual;
    }

    public void setTyreStintsActual(short[] tyreStintsActual) {
        this.tyreStintsActual = tyreStintsActual;
    }

    /**
     * @return Visual tyres used by this driver
     */
    public short[] getTyreStintsVisual() {
        return tyreStintsVisual;
    }

    public void setTyreStintsVisual(short[] tyreStintsVisual) {
        this.tyreStintsVisual = tyreStintsVisual;
    }

    @Override
    public String toString() {
        return "FinalClassificationData[" +
                ",position=" + this.position +
                ",numLaps=" + this.numLaps +
                ",gridPosition=" + this.gridPosition +
                ",points=" + this.points +
                ",numPitStops=" + this.numPitStops +
                ",resultStatus=" + this.resultStatus +
                ",bestLapTime=" + this.bestLapTime +
                ",totalRaceTime=" + this.totalRaceTime +
                ",penaltiesTime=" + this.penaltiesTime +
                ",numPenalties=" + this.numPenalties +
                ",numTyreStints=" + this.numTyreStints +
                ",tyreStintsActual=" + Arrays.toString(tyreStintsActual) +
                ",tyreStintsVisual=" + Arrays.toString(this.tyreStintsVisual) +
                "]";
    }
}
