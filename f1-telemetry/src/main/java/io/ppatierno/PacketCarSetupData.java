/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

import java.util.ArrayList;
import java.util.List;

/**
 * Car Setups Packet
 * 
 * This packet details the car setups for each vehicle in the session. Note that
 * in multiplayer games, other player cars will appear as blank, you will only
 * be able to see your car setup and AI cars.
 */
public class PacketCarSetupData extends Packet {
    
    private List<CarSetupData> carSetupData = new ArrayList<>();

    /**
     * @return Car setup data for all cars
     */
    public List<CarSetupData> getCarSetupData() {
        return carSetupData;
    }

    public void setCarSetupData(List<CarSetupData> carSetupData) {
        this.carSetupData = carSetupData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("CarSetupData[");
        sb.append(super.toString());
        for (CarSetupData c: carSetupData) {
            sb.append(c.toString() + ",");
        }
        sb.append("]");
        return sb.toString();
    }

    class CarSetupData {

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
}