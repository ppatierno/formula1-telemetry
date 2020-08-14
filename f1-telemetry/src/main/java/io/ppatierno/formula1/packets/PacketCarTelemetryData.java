/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.enums.MfdPanel;
import io.ppatierno.formula1.enums.SurfaceType;

/**
 * Car Telemetry Packet
 * 
 * This packet details telemetry for all the cars in the race. It details
 * various values that would be recorded on the car such as speed, throttle
 * application, DRS etc.
 */
public class PacketCarTelemetryData extends Packet {
    
    private List<CarTelemetryData> carTelemetryData = new ArrayList<>(PacketConstants.CARS);
    private long buttonStatus;
    private MfdPanel mfdPanelIndex;
    private MfdPanel mfdPanelIndexSecondaryPlayer;
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
    public MfdPanel getMfdPanelIndex() {
        return mfdPanelIndex;
    }

    public void setMfdPanelIndex(MfdPanel mfdPanelIndex) {
        this.mfdPanelIndex = mfdPanelIndex;
    }

    /**
     * @return Index of MFD panel open for secondary player
     */
    public MfdPanel getMfdPanelIndexSecondaryPlayer() {
        return mfdPanelIndexSecondaryPlayer;
    }

    public void setMfdPanelIndexSecondaryPlayer(MfdPanel mfdPanelIndexSecondaryPlayer) {
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

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        for (int i = 0; i < PacketConstants.CARS; i++) {
            CarTelemetryData ctd = new CarTelemetryData();
            ctd.setSpeed(buffer.readUnsignedShortLE());
            ctd.setThrottle(buffer.readFloatLE());
            ctd.setSteer(buffer.readFloatLE());
            ctd.setBrake(buffer.readFloatLE());
            ctd.setClutch(buffer.readUnsignedByte());
            ctd.setGear(buffer.readByte());
            ctd.setEngineRPM(buffer.readUnsignedShortLE());
            ctd.setDrs(buffer.readUnsignedByte());
            ctd.setRevLightsPercent(buffer.readUnsignedByte());
            for (int j = 0; j < PacketConstants.TYRES; j++) {
                ctd.getBrakesTemperature()[j] = buffer.readUnsignedShortLE();
            }
            for (int j = 0; j < PacketConstants.TYRES; j++) {
                ctd.getTyresSurfaceTemperature()[j] = buffer.readUnsignedByte();
            }
            for (int j = 0; j < PacketConstants.TYRES; j++) {
                ctd.getTyresInnerTemperature()[j] = buffer.readUnsignedByte();
            }
            ctd.setEngineTemperature(buffer.readUnsignedShortLE());
            for (int j = 0; j < PacketConstants.TYRES; j++) {
                ctd.getTyresPressure()[j] = buffer.readFloatLE();
            }
            for (int j = 0; j < PacketConstants.TYRES; j++) {
                ctd.getSurfaceType()[j] = SurfaceType.valueOf(buffer.readUnsignedByte());
            }
            this.carTelemetryData.add(ctd);
        }
        this.buttonStatus = buffer.readUnsignedIntLE();
        this.mfdPanelIndex = MfdPanel.valueOf(buffer.readUnsignedByte());
        this.mfdPanelIndexSecondaryPlayer = MfdPanel.valueOf(buffer.readUnsignedByte());
        this.suggestedGear = buffer.readByte();
        return this;
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
        private int brakesTemperature[] = new int[PacketConstants.TYRES];
        private short tyresSurfaceTemperature[] = new short[PacketConstants.TYRES];
        private short tyresInnerTemperature[] = new short[PacketConstants.TYRES];
        private int engineTemperature;
        private float tyresPressure[] = new float[PacketConstants.TYRES];
        private SurfaceType surfaceType[] = new SurfaceType[PacketConstants.TYRES];

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
        public SurfaceType[] getSurfaceType() {
            return surfaceType;
        }

        public void setSurfaceType(SurfaceType[] surfaceType) {
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
                    ",brakesTemperature=" + Arrays.toString(this.brakesTemperature) +
                    ",tyresSurfaceTemperature=" + Arrays.toString(this.tyresSurfaceTemperature) +
                    ",tyresInnerTemperature=" + Arrays.toString(this.tyresInnerTemperature) +
                    ",engineTemperature=" + this.engineTemperature +
                    ",tyresPressure=" + Arrays.toString(this.tyresPressure) +
                    ",surfaceType=" + Arrays.toString(this.surfaceType) +
                    "]";
        }
    }
}