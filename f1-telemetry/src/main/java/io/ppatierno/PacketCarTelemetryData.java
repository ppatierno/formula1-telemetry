/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

import java.util.ArrayList;
import java.util.List;

/**
 * Car Telemetry Packet
 * 
 * This packet details telemetry for all the cars in the race. It details
 * various values that would be recorded on the car such as speed, throttle
 * application, DRS etc.
 */
public class PacketCarTelemetryData extends Packet {
    
    private List<CarTelemetryData> carTelemetryData = new ArrayList<>();
    private long buttonStatus;
    private short mfdPanelIndex;
    private short mfdPanelIndexSecondaryPlayer;
    private short suggestedGear;

    /**
     * @return Car telemetry data for all cars
     */
    public List<CarTelemetryData> getCarTelemetryData() {
        return carTelemetryData;
    }

    public void setCarTelemetryData(List<CarTelemetryData> carTelemetryData) {
        this.carTelemetryData = carTelemetryData;
    }

    /**
     * @return Bit flags specifying which buttons are being pressed currently
     */
    public long getButtonStatus() {
        return buttonStatus;
    }

    public void setButtonStatus(long buttonStatus) {
        this.buttonStatus = buttonStatus;
    }

    /**
     * @return Index of MFD panel open
     * 255 = MFD closed
     * Single player, race – 0 = Car setup, 1 = Pits
     * 2 = Damage, 3 =  Engine, 4 = Temperatures
     * May vary depending on game mode
     */
    public short getMfdPanelIndex() {
        return mfdPanelIndex;
    }

    public void setMfdPanelIndex(short mfdPanelIndex) {
        this.mfdPanelIndex = mfdPanelIndex;
    }

    /**
     * @return Index of MFD panel open for secondary player
     */
    public short getMfdPanelIndexSecondaryPlayer() {
        return mfdPanelIndexSecondaryPlayer;
    }

    public void setMfdPanelIndexSecondaryPlayer(short mfdPanelIndexSecondaryPlayer) {
        this.mfdPanelIndexSecondaryPlayer = mfdPanelIndexSecondaryPlayer;
    }

    /**
     * @return Suggested gear for the player (1-8)
     * 0 if no gear suggested
     */
    public short getSuggestedGear() {
        return suggestedGear;
    }

    public void setSuggestedGear(short suggestedGear) {
        this.suggestedGear = suggestedGear;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CarTelemetryData[");
        sb.append(super.toString());
        sb.append(",carTelemetryData=");
        for (CarTelemetryData c : carTelemetryData) {
            sb.append(c.toString() + ",");
        }
        sb.append("buttonStatus=" + this.buttonStatus);
        sb.append(",mfdPanelIndex=" + this.mfdPanelIndex);
        sb.append(",mfdPanelIndexSecondaryPlayer=" + this.mfdPanelIndexSecondaryPlayer);
        sb.append(",suggestedGear=" + this.suggestedGear);
        sb.append("]");
        return sb.toString();
    }

    class CarTelemetryData {

        private int speed;
        private float throttle;
        private float steer;
        private float brake;
        private short clutch;
        private short gear;
        private int engineRPM;
        private short drs;
        private short revLightsPercent;
        private int brakesTemperature[];
        private short tyresSurfaceTemperature[];
        private short tyresInnerTemperature[];
        private int engineTemperature;
        private float tyresPressure[];
        private short surfaceType[];

        /**
         * @return Speed of car in kilometres per hour
         */
        public int getSpeed() {
            return speed;
        }

        public void setSpeed(int speed) {
            this.speed = speed;
        }

        /**
         * @return Amount of throttle applied (0.0 to 1.0)
         */
        public float getThrottle() {
            return throttle;
        }

        public void setThrottle(float throttle) {
            this.throttle = throttle;
        }

        /**
         * @return Steering (-1.0 (full lock left) to 1.0 (full lock right))
         */
        public float getSteer() {
            return steer;
        }

        public void setSteer(float steer) {
            this.steer = steer;
        }

        /**
         * @return Amount of brake applied (0.0 to 1.0)
         */
        public float getBrake() {
            return brake;
        }

        public void setBrake(float brake) {
            this.brake = brake;
        }

        /**
         * @return Amount of clutch applied (0 to 100)
         */
        public short getClutch() {
            return clutch;
        }

        public void setClutch(short clutch) {
            this.clutch = clutch;
        }

        /**
         * @return Gear selected (1-8, N=0, R=-1)
         */
        public short getGear() {
            return gear;
        }

        public void setGear(short gear) {
            this.gear = gear;
        }

        /**
         * @return Engine RPM
         */
        public int getEngineRPM() {
            return engineRPM;
        }

        public void setEngineRPM(int engineRPM) {
            this.engineRPM = engineRPM;
        }

        /**
         * @return DRS
         * 0 = off, 1 = on
         */
        public short getDrs() {
            return drs;
        }

        public void setDrs(short drs) {
            this.drs = drs;
        }

        /**
         * @return Rev lights indicator (percentage)
         */
        public short getRevLightsPercent() {
            return revLightsPercent;
        }

        public void setRevLightsPercent(short revLightsPercent) {
            this.revLightsPercent = revLightsPercent;
        }

        /**
         * @return Brakes temperature (celsius)
         */
        public int[] getBrakesTemperature() {
            return brakesTemperature;
        }

        public void setBrakesTemperature(int[] brakesTemperature) {
            this.brakesTemperature = brakesTemperature;
        }

        /**
         * @return Tyres surface temperature (celsius)
         */
        public short[] getTyresSurfaceTemperature() {
            return tyresSurfaceTemperature;
        }

        public void setTyresSurfaceTemperature(short[] tyresSurfaceTemperature) {
            this.tyresSurfaceTemperature = tyresSurfaceTemperature;
        }

        /**
         * @return Tyres inner temperature (celsius)
         */
        public short[] getTyresInnerTemperature() {
            return tyresInnerTemperature;
        }

        public void setTyresInnerTemperature(short[] tyresInnerTemperature) {
            this.tyresInnerTemperature = tyresInnerTemperature;
        }

        /**
         * @return Engine temperature (celsius)
         */
        public int getEngineTemperature() {
            return engineTemperature;
        }

        public void setEngineTemperature(int engineTemperature) {
            this.engineTemperature = engineTemperature;
        }

        /**
         * @return Tyres pressure (PSI)
         */
        public float[] getTyresPressure() {
            return tyresPressure;
        }

        public void setTyresPressure(float[] tyresPressure) {
            this.tyresPressure = tyresPressure;
        }

        /**
         * @return Driving surface
         */
        public short[] getSurfaceType() {
            return surfaceType;
        }

        public void setSurfaceType(short[] surfaceType) {
            this.surfaceType = surfaceType;
        }

        @Override
        public String toString() {
            return "CarTelemetryData[speed=" + this.speed +
                    ",throttle=" + this.throttle +
                    ",steer=" + this.steer +
                    ",brake=" + this.brake +
                    ",clutch=" + this.clutch +
                    ",gear=" + this.gear +
                    ",engineRPM=" + this.engineRPM +
                    ",drs=" + this.drs +
                    ",revLightsPercent=" + this.revLightsPercent +
                    ",brakesTemperature=" + this.brakesTemperature +
                    ",tyresSurfaceTemperature=" + this.tyresSurfaceTemperature +
                    ",tyresInnerTemperature=" + this.tyresInnerTemperature +
                    ",engineTemperature=" + this.engineTemperature +
                    ",tyresPressure=" + this.tyresPressure +
                    ",surfaceType=" + this.surfaceType +
                    "]";
        }
    }
}