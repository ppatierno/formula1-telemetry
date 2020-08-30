/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;

public class CarSetupData {

    public static final int SIZE = 49;

    private short frontWing;
    private short rearWing;
    private short onThrottle;
    private short offThrottle;
    private float frontCamber;
    private float rearCamber;
    private float frontToe;
    private float rearToe;
    private short frontSuspension;
    private short rearSuspension;
    private short frontAntiRollBar;
    private short rearAntiRollBar;
    private short frontSuspensionHeight;
    private short rearSuspensionHeight;
    private short brakePressure;
    private short brakeBias;
    private float rearLeftTyrePressure;
    private float rearRightTyrePressure;
    private float frontLeftTyrePressure;
    private float frontRightTyrePressure;
    private short ballast;
    private float fuelLoad;

    /**
     * Fill the current CarSetupData with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled CarSetupData instance
     */
    public CarSetupData fill(ByteBuf buffer) {
        this.frontWing = buffer.readUnsignedByte();
        this.rearWing = buffer.readUnsignedByte();
        this.onThrottle = buffer.readUnsignedByte();
        this.offThrottle = buffer.readUnsignedByte();
        this.frontCamber = buffer.readFloatLE();
        this.rearCamber = buffer.readFloatLE();
        this.frontToe = buffer.readFloatLE();
        this.rearToe = buffer.readFloatLE();
        this.frontSuspension = buffer.readUnsignedByte();
        this.rearSuspension = buffer.readUnsignedByte();
        this.frontAntiRollBar = buffer.readUnsignedByte();
        this.rearAntiRollBar = buffer.readUnsignedByte();
        this.frontSuspensionHeight = buffer.readUnsignedByte();
        this.rearSuspensionHeight = buffer.readUnsignedByte();
        this.brakePressure = buffer.readUnsignedByte();
        this.brakeBias = buffer.readUnsignedByte();
        this.rearLeftTyrePressure = buffer.readFloatLE();
        this.rearRightTyrePressure = buffer.readFloatLE();
        this.frontLeftTyrePressure = buffer.readFloatLE();
        this.frontRightTyrePressure = buffer.readFloatLE();
        this.ballast = buffer.readUnsignedByte();
        this.fuelLoad = buffer.readFloatLE();
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current CarSetupData instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeByte(this.frontWing);
        buffer.writeByte(this.rearWing);
        buffer.writeByte(this.onThrottle);
        buffer.writeByte(this.offThrottle);
        buffer.writeFloatLE(this.frontCamber);
        buffer.writeFloatLE(this.rearCamber);
        buffer.writeFloatLE(this.frontToe);
        buffer.writeFloatLE(this.rearToe);
        buffer.writeByte(this.frontSuspension);
        buffer.writeByte(this.rearSuspension);
        buffer.writeByte(this.frontAntiRollBar);
        buffer.writeByte(this.rearAntiRollBar);
        buffer.writeByte(this.frontSuspensionHeight);
        buffer.writeByte(this.rearSuspensionHeight);
        buffer.writeByte(this.brakePressure);
        buffer.writeByte(this.brakeBias);
        buffer.writeFloatLE(this.rearLeftTyrePressure);
        buffer.writeFloatLE(this.rearRightTyrePressure);
        buffer.writeFloatLE(this.frontLeftTyrePressure);
        buffer.writeFloatLE(this.frontRightTyrePressure);
        buffer.writeByte(this.ballast);
        buffer.writeFloatLE(this.fuelLoad);
        return buffer;
    }

    /**
     * @return Front wing aero
     */
    public short getFrontWing() {
        return frontWing;
    }

    public void setFrontWing(short frontWing) {
        this.frontWing = frontWing;
    }

    /**
     * @return Rear wing aero
     */
    public short getRearWing() {
        return rearWing;
    }

    public void setRearWing(short rearWing) {
        this.rearWing = rearWing;
    }

    /**
     * @return Differential adjustment on throttle (percentage)
     */
    public short getOnThrottle() {
        return onThrottle;
    }

    public void setOnThrottle(short onThrottle) {
        this.onThrottle = onThrottle;
    }

    /**
     * @return Differential adjustment off throttle (percentage)
     */
    public short getOffThrottle() {
        return offThrottle;
    }

    public void setOffThrottle(short offThrottle) {
        this.offThrottle = offThrottle;
    }

    /**
     * @return Front camber angle (suspension geometry)
     */
    public float getFrontCamber() {
        return frontCamber;
    }

    public void setFrontCamber(float frontCamber) {
        this.frontCamber = frontCamber;
    }

    /**
     * @return Rear camber angle (suspension geometry)
     */
    public float getRearCamber() {
        return rearCamber;
    }

    public void setRearCamber(float rearCamber) {
        this.rearCamber = rearCamber;
    }

    /**
     * @return Front toe angle (suspension geometry)
     */
    public float getFrontToe() {
        return frontToe;
    }

    public void setFrontToe(float frontToe) {
        this.frontToe = frontToe;
    }

    /**
     * @return Rear toe angle (suspension geometry)
     */
    public float getRearToe() {
        return rearToe;
    }

    public void setRearToe(float rearToe) {
        this.rearToe = rearToe;
    }

    /**
     * @return Front suspension
     */
    public short getFrontSuspension() {
        return frontSuspension;
    }

    public void setFrontSuspension(short frontSuspension) {
        this.frontSuspension = frontSuspension;
    }

    /**
     * @return Rear suspension
     */
    public short getRearSuspension() {
        return rearSuspension;
    }

    public void setRearSuspension(short rearSuspension) {
        this.rearSuspension = rearSuspension;
    }

    /**
     * @return Front anti-roll bar
     */
    public short getFrontAntiRollBar() {
        return frontAntiRollBar;
    }

    public void setFrontAntiRollBar(short frontAntiRollBar) {
        this.frontAntiRollBar = frontAntiRollBar;
    }

    /**
     * @return Rear anti-roll bar
     */
    public short getRearAntiRollBar() {
        return rearAntiRollBar;
    }

    public void setRearAntiRollBar(short rearAntiRollBar) {
        this.rearAntiRollBar = rearAntiRollBar;
    }

    /**
     * @return Front ride height
     */
    public short getFrontSuspensionHeight() {
        return frontSuspensionHeight;
    }

    public void setFrontSuspensionHeight(short frontSuspensionHeight) {
        this.frontSuspensionHeight = frontSuspensionHeight;
    }

    /**
     * @return Rear ride height
     */
    public short getRearSuspensionHeight() {
        return rearSuspensionHeight;
    }

    public void setRearSuspensionHeight(short rearSuspensionHeight) {
        this.rearSuspensionHeight = rearSuspensionHeight;
    }

    /**
     * @return Brake pressure (percentage)
     */
    public short getBrakePressure() {
        return brakePressure;
    }

    public void setBrakePressure(short brakePressure) {
        this.brakePressure = brakePressure;
    }

    /**
     * @return Brake bias (percentage)
     */
    public short getBrakeBias() {
        return brakeBias;
    }

    public void setBrakeBias(short brakeBias) {
        this.brakeBias = brakeBias;
    }

    /**
     * @return Rear left tyre pressure (PSI)
     */
    public float getRearLeftTyrePressure() {
        return rearLeftTyrePressure;
    }

    public void setRearLeftTyrePressure(float rearLeftTyrePressure) {
        this.rearLeftTyrePressure = rearLeftTyrePressure;
    }

    /**
     * @return Rear right tyre pressure (PSI)
     */
    public float getRearRightTyrePressure() {
        return rearRightTyrePressure;
    }

    public void setRearRightTyrePressure(float rearRightTyrePressure) {
        this.rearRightTyrePressure = rearRightTyrePressure;
    }

    /**
     * @return Front left tyre pressure (PSI)
     */
    public float getFrontLeftTyrePressure() {
        return frontLeftTyrePressure;
    }

    public void setFrontLeftTyrePressure(float frontLeftTyrePressure) {
        this.frontLeftTyrePressure = frontLeftTyrePressure;
    }

    /**
     * @return Front right tyre pressure (PSI)
     */
    public float getFrontRightTyrePressure() {
        return frontRightTyrePressure;
    }

    public void setFrontRightTyrePressure(float frontRightTyrePressure) {
        this.frontRightTyrePressure = frontRightTyrePressure;
    }

    /**
     * @return Ballast
     */
    public short getBallast() {
        return ballast;
    }

    public void setBallast(short ballast) {
        this.ballast = ballast;
    }

    /**
     * @return Fuel load
     */
    public float getFuelLoad() {
        return fuelLoad;
    }

    public void setFuelLoad(float fuelLoad) {
        this.fuelLoad = fuelLoad;
    }

    @Override
    public String toString() {
        return "CarSetupData[frontWing=" + this.frontWing +
                ",rearWing=" + this.rearWing +
                ",onThrottle=" + this.onThrottle +
                ",offThrottle=" + this.offThrottle +
                ",frontCamber=" + this.frontCamber +
                ",rearCamber=" + this.rearCamber +
                ",frontToe=" + this.frontToe +
                ",rearToe=" + this.rearToe +
                ",frontSuspension=" + this.frontSuspension +
                ",rearSuspension=" + this.rearSuspension +
                ",frontAntiRollBar=" + this.frontAntiRollBar +
                ",rearAntiRollBar=" + this.rearAntiRollBar +
                ",frontSuspensionHeight=" + this.frontSuspensionHeight +
                ",rearSuspensionHeight=" + this.rearSuspensionHeight +
                ",brakePressure=" + this.brakePressure +
                ",brakeBias=" + this.brakeBias +
                ",rearLeftTyrePressure=" + this.rearLeftTyrePressure +
                ",rearRightTyrePressure=" + this.rearRightTyrePressure +
                ",frontLeftTyrePressure=" + this.frontLeftTyrePressure +
                ",frontRightTyrePressure=" + this.frontRightTyrePressure +
                ",ballast=" + this.ballast +
                ",fuelLoad=" + this.fuelLoad +
                "]";
    }
}
