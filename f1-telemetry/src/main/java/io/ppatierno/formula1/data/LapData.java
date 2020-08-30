/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.enums.DriverStatus;
import io.ppatierno.formula1.enums.PitStatus;
import io.ppatierno.formula1.enums.ResultStatus;
import io.ppatierno.formula1.enums.Sector;

public class LapData {

    public static final int SIZE = 53;

    private float lastLapTime;
    private float currentLapTime;
    private int sector1TimeInMS;
    private int sector2TimeInMS;
    private float bestLapTime;
    private int bestLapNum;
    private int bestLapSector1TimeInMS;
    private int bestLapSector2TimeInMS;
    private int bestLapSector3TimeInMS;
    private int bestOverallSector1TimeInMS;
    private short bestOverallSector1LapNum;
    private int bestOverallSector2TimeInMS;
    private short bestOverallSector2LapNum;
    private int bestOverallSector3TimeInMS;
    private short bestOverallSector3LapNum;
    private float lapDistance;
    private float totalDistance;
    private float safetyCarDelta;
    private short carPosition;
    private short currentLapNum;
    private PitStatus pitStatus;
    private Sector sector;
    private short currentLapInvalid;
    private short penalties;
    private short gridPosition;
    private DriverStatus driverStatus;
    private ResultStatus resultStatus;

    /**
     * Fill the current LapData with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled LapData instance
     */
    public LapData fill(ByteBuf buffer) {
        this.lastLapTime = buffer.readFloatLE();
        this.currentLapTime = buffer.readFloatLE();
        this.sector1TimeInMS = buffer.readUnsignedShortLE();
        this.sector2TimeInMS = buffer.readUnsignedShortLE();
        this.bestLapTime = buffer.readFloatLE();
        this.bestLapNum = buffer.readUnsignedByte();
        this.bestLapSector1TimeInMS = buffer.readUnsignedShortLE();
        this.bestLapSector2TimeInMS = buffer.readUnsignedShortLE();
        this.bestLapSector3TimeInMS = buffer.readUnsignedShortLE();
        this.bestOverallSector1TimeInMS = buffer.readUnsignedShortLE();
        this.bestOverallSector1LapNum = buffer.readUnsignedByte();
        this.bestOverallSector2TimeInMS = buffer.readUnsignedShortLE();
        this.bestOverallSector2LapNum = buffer.readUnsignedByte();
        this.bestOverallSector3TimeInMS = buffer.readUnsignedShortLE();
        this.bestOverallSector3LapNum = buffer.readUnsignedByte();
        this.lapDistance = buffer.readFloatLE();
        this.totalDistance = buffer.readFloatLE();
        this.safetyCarDelta = buffer.readFloatLE();
        this.carPosition = buffer.readUnsignedByte();
        this.currentLapNum = buffer.readUnsignedByte();
        this.pitStatus = PitStatus.valueOf(buffer.readUnsignedByte());
        this.sector = Sector.valueOf(buffer.readUnsignedByte());
        this.currentLapInvalid = buffer.readUnsignedByte();
        this.penalties = buffer.readUnsignedByte();
        this.gridPosition = buffer.readUnsignedByte();
        this.driverStatus = DriverStatus.valueOf(buffer.readUnsignedByte());
        this.resultStatus = ResultStatus.valueOf(buffer.readUnsignedByte());
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current LapData instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeFloatLE(this.lastLapTime);
        buffer.writeFloatLE(this.currentLapTime);
        buffer.writeShortLE(this.sector1TimeInMS);
        buffer.writeShortLE(this.sector2TimeInMS);
        buffer.writeFloatLE(this.bestLapTime);
        buffer.writeByte(this.bestLapNum);
        buffer.writeShortLE(this.bestLapSector1TimeInMS);
        buffer.writeShortLE(this.bestLapSector2TimeInMS);
        buffer.writeShortLE(this.bestLapSector3TimeInMS);
        buffer.writeShortLE(this.bestOverallSector1TimeInMS);
        buffer.writeByte(this.bestOverallSector1LapNum);
        buffer.writeShortLE(this.bestOverallSector2TimeInMS);
        buffer.writeByte(this.bestOverallSector2LapNum);
        buffer.writeShortLE(this.bestOverallSector3TimeInMS);
        buffer.writeByte(this.bestOverallSector3LapNum);
        buffer.writeFloatLE(this.lapDistance);
        buffer.writeFloatLE(this.totalDistance);
        buffer.writeFloatLE(this.safetyCarDelta);
        buffer.writeByte(this.carPosition);
        buffer.writeByte(this.currentLapNum);
        buffer.writeByte(this.pitStatus.getValue());
        buffer.writeByte(this.sector.getValue());
        buffer.writeByte(this.currentLapInvalid);
        buffer.writeByte(this.penalties);
        buffer.writeByte(this.gridPosition);
        buffer.writeByte(this.driverStatus.getValue());
        buffer.writeByte(this.resultStatus.getValue());
        return buffer;
    }

    /**
     * @return Last lap time in seconds
     */
    public float getLastLapTime() {
        return lastLapTime;
    }

    public void setLastLapTime(float lastLapTime) {
        this.lastLapTime = lastLapTime;
    }

    /**
     * @return Current time around the lap in seconds
     */
    public float getCurrentLapTime() {
        return currentLapTime;
    }

    public void setCurrentLapTime(float currentLapTime) {
        this.currentLapTime = currentLapTime;
    }

    /**
     * @return Sector 1 time in milliseconds
     */
    public int getSector1TimeInMS() {
        return sector1TimeInMS;
    }

    public void setSector1TimeInMS(int sector1TimeInMS) {
        this.sector1TimeInMS = sector1TimeInMS;
    }

    /**
     * @return Sector 2 time in milliseconds
     */
    public int getSector2TimeInMS() {
        return sector2TimeInMS;
    }

    public void setSector2TimeInMS(int sector2TimeInMS) {
        this.sector2TimeInMS = sector2TimeInMS;
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
     * @return Lap number best time achieved on
     */
    public int getBestLapNum() {
        return bestLapNum;
    }

    public void setBestLapNum(int bestLapNum) {
        this.bestLapNum = bestLapNum;
    }

    /**
     * @return Sector 1 time of best lap in the session in milliseconds
     */
    public int getBestLapSector1TimeInMS() {
        return bestLapSector1TimeInMS;
    }

    public void setBestLapSector1TimeInMS(int bestLapSector1TimeInMS) {
        this.bestLapSector1TimeInMS = bestLapSector1TimeInMS;
    }

    /**
     * @return Sector 2 time of best lap in the session in milliseconds
     */
    public int getBestLapSector2TimeInMS() {
        return bestLapSector2TimeInMS;
    }

    public void setBestLapSector2TimeInMS(int bestLapSector2TimeInMS) {
        this.bestLapSector2TimeInMS = bestLapSector2TimeInMS;
    }

    /**
     * @return Sector 3 time of best lap in the session in milliseconds
     */
    public int getBestLapSector3TimeInMS() {
        return bestLapSector3TimeInMS;
    }

    public void setBestLapSector3TimeInMS(int bestLapSector3TimeInMS) {
        this.bestLapSector3TimeInMS = bestLapSector3TimeInMS;
    }

    /**
     * @return Best overall sector 1 time of the session in milliseconds
     */
    public int getBestOverallSector1TimeInMS() {
        return bestOverallSector1TimeInMS;
    }

    public void setBestOverallSector1TimeInMS(int bestOverallSector1TimeInMS) {
        this.bestOverallSector1TimeInMS = bestOverallSector1TimeInMS;
    }

    /**
     * @return Lap number best overall sector 1 time achieved on
     */
    public short getBestOverallSector1LapNum() {
        return bestOverallSector1LapNum;
    }

    public void setBestOverallSector1LapNum(short bestOverallSector1LapNum) {
        this.bestOverallSector1LapNum = bestOverallSector1LapNum;
    }

    /**
     * @return Best overall sector 2 time of the session in milliseconds
     */
    public int getBestOverallSector2TimeInMS() {
        return bestOverallSector2TimeInMS;
    }

    public void setBestOverallSector2TimeInMS(int bestOverallSector2TimeInMS) {
        this.bestOverallSector2TimeInMS = bestOverallSector2TimeInMS;
    }

    /**
     * @return Lap number best overall sector 2 time achieved on
     */
    public short getBestOverallSector2LapNum() {
        return bestOverallSector2LapNum;
    }

    public void setBestOverallSector2LapNum(short bestOverallSector2LapNum) {
        this.bestOverallSector2LapNum = bestOverallSector2LapNum;
    }

    /**
     * @return Best overall sector 3 time of the session in milliseconds
     */
    public int getBestOverallSector3TimeInMS() {
        return bestOverallSector3TimeInMS;
    }

    public void setBestOverallSector3TimeInMS(int bestOverallSector3TimeInMS) {
        this.bestOverallSector3TimeInMS = bestOverallSector3TimeInMS;
    }

    /**
     * @return Lap number best overall sector 3 time achieved on
     */
    public short getBestOverallSector3LapNum() {
        return bestOverallSector3LapNum;
    }

    public void setBestOverallSector3LapNum(short bestOverallSector3LapNum) {
        this.bestOverallSector3LapNum = bestOverallSector3LapNum;
    }

    /**
     * @return Distance vehicle is around current lap in metres
     * could be negative if line hasn’t been crossed yet
     */
    public float getLapDistance() {
        return lapDistance;
    }

    public void setLapDistance(float lapDistance) {
        this.lapDistance = lapDistance;
    }

    /**
     * @return Total distance travelled in session in metres
     * could be negative if line hasn’t been crossed yet
     */
    public float getTotalDistance() {
        return totalDistance;
    }

    public void setTotalDistance(float totalDistance) {
        this.totalDistance = totalDistance;
    }

    /**
     * @return Delta in seconds for safety car
     */
    public float getSafetyCarDelta() {
        return safetyCarDelta;
    }

    public void setSafetyCarDelta(float safetyCarDelta) {
        this.safetyCarDelta = safetyCarDelta;
    }

    /**
     * @return Car race position
     */
    public short getCarPosition() {
        return carPosition;
    }

    public void setCarPosition(short carPosition) {
        this.carPosition = carPosition;
    }

    /**
     * @return Current lap number
     */
    public short getCurrentLapNum() {
        return currentLapNum;
    }

    public void setCurrentLapNum(short currentLapNum) {
        this.currentLapNum = currentLapNum;
    }

    /**
     * @return Pit status
     * 0 = none, 1 = pitting, 2 = in pit area
     */
    public PitStatus getPitStatus() {
        return pitStatus;
    }

    public void setPitStatus(PitStatus pitStatus) {
        this.pitStatus = pitStatus;
    }

    /**
     * @return Sector
     * 0 = sector1, 1 = sector2, 2 = sector3
     */
    public Sector getSector() {
        return sector;
    }

    public void setSector(Sector sector) {
        this.sector = sector;
    }

    /**
     * @return Current lap invalid
     * 0 = valid, 1 = invalid
     */
    public short getCurrentLapInvalid() {
        return currentLapInvalid;
    }

    public void setCurrentLapInvalid(short currentLapInvalid) {
        this.currentLapInvalid = currentLapInvalid;
    }

    /**
     * @return Accumulated time penalties in seconds to be added
     */
    public short getPenalties() {
        return penalties;
    }

    public void setPenalties(short penalties) {
        this.penalties = penalties;
    }

    /**
     * @return Grid position the vehicle started the race in
     */
    public short getGridPosition() {
        return gridPosition;
    }

    public void setGridPosition(short gridPosition) {
        this.gridPosition = gridPosition;
    }

    /**
     * @return Status of driver
     * 0 = in garage, 1 = flying lap
     * 2 = in lap, 3 = out lap, 4 = on track
     */
    public DriverStatus getDriverStatus() {
        return driverStatus;
    }

    public void setDriverStatus(DriverStatus driverStatus) {
        this.driverStatus = driverStatus;
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

    @Override
    public String toString() {
        return "LapData[lastLapTime=" + this.lastLapTime +
                ",currentLapTime=" + this.currentLapTime +
                ",sector1TimeInMS=" + this.sector1TimeInMS +
                ",sector2TimeInMS=" + this.sector2TimeInMS +
                ",bestLapTime=" + this.bestLapTime +
                ",bestLapNum=" + this.bestLapNum +
                ",bestLapSector1TimeInMS=" + this.bestLapSector1TimeInMS +
                ",bestLapSector2TimeInMS=" + this.bestLapSector2TimeInMS +
                ",bestLapSector3TimeInMS=" + this.bestLapSector3TimeInMS +
                ",bestOverallSector1TimeInMS=" + this.bestOverallSector1TimeInMS +
                ",bestOverallSector1LapNum=" + this.bestOverallSector1LapNum +
                ",bestOverallSector2TimeInMS=" + this.bestOverallSector2TimeInMS +
                ",bestOverallSector2LapNum=" + this.bestOverallSector2LapNum +
                ",bestOverallSector3TimeInMS=" + this.bestOverallSector3TimeInMS +
                ",bestOverallSector3LapNum=" + this.bestOverallSector3LapNum +
                ",lapDistance=" + this.lapDistance +
                ",totalDistance=" + this.totalDistance +
                ",safetyCarDelta=" + this.safetyCarDelta +
                ",carPosition=" + this.carPosition +
                ",currentLapNum=" + this.currentLapNum +
                ",pitStatus=" + this.pitStatus +
                ",sector=" + this.sector +
                ",currentLapInvalid=" + this.currentLapInvalid +
                ",penalties=" + this.penalties +
                ",gridPosition=" + this.gridPosition +
                ",driverStatus=" + this.driverStatus +
                ",resultStatus=" + this.resultStatus +
                "]";
    }
}