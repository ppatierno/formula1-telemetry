/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

import java.util.ArrayList;
import java.util.List;

/**
 * Lap Data Packet
 * 
 * The lap data packet gives details of all the cars in the session.
 */
public class PacketLapData extends Packet {
    
    private List<LapData> lapData = new ArrayList<>();

    /**
     * @return Lap data for all cars on track
     */
    public List<LapData> getLapData() {
        return lapData;
    }

    public void setLapData(List<LapData> lapData) {
        this.lapData = lapData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LapData[");
        sb.append(super.toString());
        sb.append(",lapData=");
        for (LapData l : lapData) {
            sb.append(l.toString() + ",");
        }
        sb.append("]");
        return sb.toString();
    }

    class LapData {

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
        private short pitStatus;
        private short sector;
        private short currentLapInvalid;
        private short penalties;
        private short gridPosition;
        private short driverStatus;
        private short resultStatus;

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
        public short getPitStatus() {
            return pitStatus;
        }

        public void setPitStatus(short pitStatus) {
            this.pitStatus = pitStatus;
        }

        /**
         * @return Sector
         * 0 = sector1, 1 = sector2, 2 = sector3
         */
        public short getSector() {
            return sector;
        }

        public void setSector(short sector) {
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
        public short getDriverStatus() {
            return driverStatus;
        }

        public void setDriverStatus(short driverStatus) {
            this.driverStatus = driverStatus;
        }

        /**
         * @return Result status
         * 0 = invalid, 1 = inactive, 2 = active
         * 3 = finished, 4 = disqualified, 5 = not classified
         * 6 = retired
         */
        public short getResultStatus() {
            return resultStatus;
        }

        public void setResultStatus(short resultStatus) {
            this.resultStatus = resultStatus;
        }

        @Override
        public String toString() {
            return "LapData[lastLapTime=" + this.lastLapTime +
                    ",currentLapTime=" + this.currentLapTime +
                    ",sector1TimeInMS=" + this.sector1TimeInMS +
                    ",sector2TimeInMS=" + this.sector2TimeInMS +
                    ",bestLapTime" + this.bestLapTime +
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
}