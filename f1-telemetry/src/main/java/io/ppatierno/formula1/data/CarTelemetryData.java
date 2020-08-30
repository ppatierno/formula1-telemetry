/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.enums.SurfaceType;

import java.util.Arrays;

public class CarTelemetryData {

    public static final int SIZE = 58;

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
     * Fill the current CarTelemetryData with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled CarTelemetryData instance
     */
    public CarTelemetryData fill(ByteBuf buffer) {
        this.speed = buffer.readUnsignedShortLE();
        this.throttle = buffer.readFloatLE();
        this.steer = buffer.readFloatLE();
        this.brake = buffer.readFloatLE();
        this.clutch = buffer.readUnsignedByte();
        this.gear = buffer.readByte();
        this.engineRPM = buffer.readUnsignedShortLE();
        this.drs = buffer.readUnsignedByte();
        this.revLightsPercent = buffer.readUnsignedByte();
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            this.brakesTemperature[j] = buffer.readUnsignedShortLE();
        }
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            this.tyresSurfaceTemperature[j] = buffer.readUnsignedByte();
        }
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            this.tyresInnerTemperature[j] = buffer.readUnsignedByte();
        }
        this.engineTemperature = buffer.readUnsignedShortLE();
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            this.tyresPressure[j] = buffer.readFloatLE();
        }
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            this.surfaceType[j] = SurfaceType.valueOf(buffer.readUnsignedByte());
        }
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current CarTelemetryData instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeShortLE(this.speed);
        buffer.writeFloatLE(this.throttle);
        buffer.writeFloatLE(this.steer);
        buffer.writeFloatLE(this.brake);
        buffer.writeByte(this.clutch);
        buffer.writeByte(this.gear);
        buffer.writeShortLE(this.engineRPM);
        buffer.writeByte(this.drs);
        buffer.writeByte(this.revLightsPercent);
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            buffer.writeShortLE(this.brakesTemperature[j]);
        }
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            buffer.writeByte(this.tyresSurfaceTemperature[j]);
        }
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            buffer.writeByte(this.tyresInnerTemperature[j]);
        }
        buffer.writeShortLE(this.engineTemperature);
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            buffer.writeFloatLE(this.tyresPressure[j]);
        }
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            buffer.writeByte(this.surfaceType[j].getValue());
        }
        return buffer;
    }

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
