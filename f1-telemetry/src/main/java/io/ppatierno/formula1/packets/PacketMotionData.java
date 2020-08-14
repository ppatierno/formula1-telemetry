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
import io.ppatierno.formula1.PacketUtils;

/**
 * Motion Packet
 * 
 * The motion packet gives physics data for all the cars being driven. 
 * There is additional data for the car being driven with the goal of being able to drive a motion platform setup.
 */
public class PacketMotionData extends Packet {
    
    private List<CarMotionData> carMotionData = new ArrayList<>(PacketConstants.CARS);
    private ExtraCarMotionData extraCarMotionData = new ExtraCarMotionData();

    /**
     * @return Car(s) motion data
     */
    public List<CarMotionData> getCarMotionData() {
        return carMotionData;
    }

    public void setCarMotionData(List<CarMotionData> carMotionData) {
        this.carMotionData = carMotionData;
    }

    /**
     * @return Extra player car only data
     */
    public ExtraCarMotionData getExtraCarMotionData() {
        return extraCarMotionData;
    }

    public void setExtraCarMotionData(ExtraCarMotionData extraCarMotionData) {
        this.extraCarMotionData = extraCarMotionData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("MotionData[");
        sb.append(super.toString());
        sb.append(",carMotionData=");
        for (CarMotionData cmd : carMotionData) {
            sb.append(cmd.toString() + ",");
        }
        sb.append("extraCarMotionData=" + extraCarMotionData.toString());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        for (int i = 0; i < PacketConstants.CARS; i++) {
            CarMotionData cmd = new CarMotionData();
            cmd.setWorldPositionX(buffer.readFloatLE());
            cmd.setWorldPositionY(buffer.readFloatLE());
            cmd.setWorldPositionZ(buffer.readFloatLE());
            cmd.setWorldVelocityX(buffer.readFloatLE());
            cmd.setWorldVelocityY(buffer.readFloatLE());
            cmd.setWorldVelocityZ(buffer.readFloatLE());
            cmd.setWorldForwardDirX(PacketUtils.normalizedVectorToFloat(buffer.readShortLE()));
            cmd.setWorldForwardDirY(PacketUtils.normalizedVectorToFloat(buffer.readShortLE()));
            cmd.setWorldForwardDirZ(PacketUtils.normalizedVectorToFloat(buffer.readShortLE()));
            cmd.setWorldRightDirX(PacketUtils.normalizedVectorToFloat(buffer.readShortLE()));
            cmd.setWorldRightDirY(PacketUtils.normalizedVectorToFloat(buffer.readShortLE()));
            cmd.setWorldRightDirZ(PacketUtils.normalizedVectorToFloat(buffer.readShortLE()));
            cmd.setgForceLateral(buffer.readFloatLE());
            cmd.setgForceLongitudinal(buffer.readFloatLE());
            cmd.setgForceVertical(buffer.readFloatLE());
            cmd.setYaw(buffer.readFloatLE());
            cmd.setPitch(buffer.readFloatLE());
            cmd.setRoll(buffer.readFloatLE());
            this.carMotionData.add(cmd);
        }
        for (int i = 0; i < PacketConstants.WHEELS; i++) {
            this.extraCarMotionData.getSuspensionPosition()[i] = buffer.readFloatLE();
        }
        for (int i = 0; i < PacketConstants.WHEELS; i++) {
            this.extraCarMotionData.getSuspensionVelocity()[i] = buffer.readFloatLE();
        }
        for (int i = 0; i < PacketConstants.WHEELS; i++) {
            this.extraCarMotionData.getSuspensionAcceleration()[i] = buffer.readFloatLE();
        }
        for (int i = 0; i < PacketConstants.WHEELS; i++) {
            this.extraCarMotionData.getWheelSpeed()[i] = buffer.readFloatLE();
        }
        for (int i = 0; i < PacketConstants.WHEELS; i++) {
            this.extraCarMotionData.getWheelSlip()[i] = buffer.readFloatLE();
        }
        this.extraCarMotionData.setLocalVelocityX(buffer.readFloatLE());
        this.extraCarMotionData.setLocalVelocityY(buffer.readFloatLE());
        this.extraCarMotionData.setLocalVelocityZ(buffer.readFloatLE());
        this.extraCarMotionData.setAngularVelocityX(buffer.readFloatLE());
        this.extraCarMotionData.setAngularVelocityY(buffer.readFloatLE());
        this.extraCarMotionData.setAngularVelocityZ(buffer.readFloatLE());
        this.extraCarMotionData.setAngularAccelerationX(buffer.readFloatLE());
        this.extraCarMotionData.setAngularAccelerationY(buffer.readFloatLE());
        this.extraCarMotionData.setAngularAccelerationZ(buffer.readFloatLE());
        this.extraCarMotionData.setFrontWheelsAngle(buffer.readFloatLE());
        return this;
    }

    class CarMotionData {

        private float worldPositionX;
        private float worldPositionY;
        private float worldPositionZ;
        private float worldVelocityX;
        private float worldVelocityY;
        private float worldVelocityZ;
        private float worldForwardDirX;
        private float worldForwardDirY;
        private float worldForwardDirZ;
        private float worldRightDirX;
        private float worldRightDirY;
        private float worldRightDirZ;
        private float gForceLateral;
        private float gForceLongitudinal;
        private float gForceVertical;
        private float yaw;
        private float pitch;
        private float roll;

        /**
         * @return World space X position
         */
        public float getWorldPositionX() {
            return worldPositionX;
        }

        public void setWorldPositionX(float worldPositionX) {
            this.worldPositionX = worldPositionX;
        }

        /**
         * @return World space Y position
         */
        public float getWorldPositionY() {
            return worldPositionY;
        }

        public void setWorldPositionY(float worldPositionY) {
            this.worldPositionY = worldPositionY;
        }

        /**
         * @return World space Z position
         */
        public float getWorldPositionZ() {
            return worldPositionZ;
        }

        public void setWorldPositionZ(float worldPositionZ) {
            this.worldPositionZ = worldPositionZ;
        }

        /**
         * @return Velocity in world space X
         */
        public float getWorldVelocityX() {
            return worldVelocityX;
        }

        public void setWorldVelocityX(float worldVelocityX) {
            this.worldVelocityX = worldVelocityX;
        }

        /**
         * @return Velocity in world space Y
         */
        public float getWorldVelocityY() {
            return worldVelocityY;
        }

        public void setWorldVelocityY(float worldVelocityY) {
            this.worldVelocityY = worldVelocityY;
        }

        /**
         * @return Velocity in world space Z
         */
        public float getWorldVelocityZ() {
            return worldVelocityZ;
        }

        public void setWorldVelocityZ(float worldVelocityZ) {
            this.worldVelocityZ = worldVelocityZ;
        }

        /**
         * @return World space forward X direction (normalised)
         */
        public float getWorldForwardDirX() {
            return worldForwardDirX;
        }

        public void setWorldForwardDirX(float worldForwardDirX) {
            this.worldForwardDirX = worldForwardDirX;
        }

        /**
         * @return World space forward Y direction (normalised)
         */
        public float getWorldForwardDirY() {
            return worldForwardDirY;
        }

        public void setWorldForwardDirY(float worldForwardDirY) {
            this.worldForwardDirY = worldForwardDirY;
        }

        /**
         * @return World space forward Z direction (normalised)
         */
        public float getWorldForwardDirZ() {
            return worldForwardDirZ;
        }

        public void setWorldForwardDirZ(float worldForwardDirZ) {
            this.worldForwardDirZ = worldForwardDirZ;
        }

        /**
         * @return World space right X direction (normalised)
         */
        public float getWorldRightDirX() {
            return worldRightDirX;
        }

        public void setWorldRightDirX(float worldRightDirX) {
            this.worldRightDirX = worldRightDirX;
        }

        /**
         * @return World space right Y direction (normalised)
         */
        public float getWorldRightDirY() {
            return worldRightDirY;
        }

        public void setWorldRightDirY(float worldRightDirY) {
            this.worldRightDirY = worldRightDirY;
        }

        /**
         * @return World space right Z direction (normalised)
         */
        public float getWorldRightDirZ() {
            return worldRightDirZ;
        }

        public void setWorldRightDirZ(float worldRightDirZ) {
            this.worldRightDirZ = worldRightDirZ;
        }

        /**
         * @return Lateral G-Force component
         */
        public float getgForceLateral() {
            return gForceLateral;
        }

        public void setgForceLateral(float gForceLateral) {
            this.gForceLateral = gForceLateral;
        }

        /**
         * @return Longitudinal G-Force component
         */
        public float getgForceLongitudinal() {
            return gForceLongitudinal;
        }

        public void setgForceLongitudinal(float gForceLongitudinal) {
            this.gForceLongitudinal = gForceLongitudinal;
        }

        /**
         * @return Vertical G-Force component
         */
        public float getgForceVertical() {
            return gForceVertical;
        }

        public void setgForceVertical(float gForceVertical) {
            this.gForceVertical = gForceVertical;
        }

        /**
         * @return Yaw angle in radians
         */
        public float getYaw() {
            return yaw;
        }

        public void setYaw(float yaw) {
            this.yaw = yaw;
        }

        /**
         * @return Pitch angle in radians
         */
        public float getPitch() {
            return pitch;
        }

        public void setPitch(float pitch) {
            this.pitch = pitch;
        }

        /**
         * @return Roll angle in radians
         */
        public float getRoll() {
            return roll;
        }

        public void setRoll(float roll) {
            this.roll = roll;
        }

        @Override
        public String toString() {
            return "CarMotionData[worldPositionX=" + this.worldPositionX + 
                    ",worldPositionY=" + this.worldPositionY +
                    ",worldPositionZ=" + this.worldPositionZ +
                    ",worldVelocityX=" + this.worldVelocityX + 
                    ",worldVelocityY=" + this.worldVelocityY +
                    ",worldVelocityZ=" + this.worldVelocityZ +
                    ",worldForwardDirX=" + this.worldForwardDirX +
                    ",worldForwardDirY=" + this.worldForwardDirY +
                    ",worldForwardDirZ=" + this.worldForwardDirZ +
                    ",worldRightDirX=" + this.worldRightDirX +
                    ",worldRightDirY=" + this.worldRightDirY +
                    ",worldRightDirZ=" + this.worldRightDirZ +
                    ",gForceLateral=" + this.gForceLateral +
                    ",gForceLongitudinal" + this.gForceLongitudinal +
                    ",gForceVertical=" + this.gForceVertical +
                    ",yaw=" + this.yaw +
                    ",pitch=" + this.pitch +
                    ",roll=" + this.roll +
                    "]";
        }
    }

    class ExtraCarMotionData {

        // Wheels in order: RL, RR, FL, FR.
        private float[] suspensionPosition = new float[PacketConstants.WHEELS];
        private float[] suspensionVelocity = new float[PacketConstants.WHEELS];
        private float[] suspensionAcceleration = new float[PacketConstants.WHEELS];
        private float[] wheelSpeed = new float[PacketConstants.WHEELS];
        private float[] wheelSlip = new float[PacketConstants.WHEELS];
        private float localVelocityX;
        private float localVelocityY;
        private float localVelocityZ;
        private float angularVelocityX;
        private float angularVelocityY;
        private float angularVelocityZ;
        private float angularAccelerationX;
        private float angularAccelerationY;
        private float angularAccelerationZ;
        private float frontWheelsAngle;

        /**
         * @return Suspension position of each wheel
         */
        public float[] getSuspensionPosition() {
            return suspensionPosition;
        }

        public void setSuspensionPosition(float[] suspensionPosition) {
            this.suspensionPosition = suspensionPosition;
        }

        /**
         * @return Suspension velocity of each wheel
         */
        public float[] getSuspensionVelocity() {
            return suspensionVelocity;
        }

        public void setSuspensionVelocity(float[] suspensionVelocity) {
            this.suspensionVelocity = suspensionVelocity;
        }

        /**
         * @return Suspension acceleration of each wheel
         */
        public float[] getSuspensionAcceleration() {
            return suspensionAcceleration;
        }

        public void setSuspensionAcceleration(float[] suspensionAcceleration) {
            this.suspensionAcceleration = suspensionAcceleration;
        }

        /**
         * @return Speed of each wheel
         */
        public float[] getWheelSpeed() {
            return wheelSpeed;
        }

        public void setWheelSpeed(float[] wheelSpeed) {
            this.wheelSpeed = wheelSpeed;
        }

        /**
         * @return Slip ratio for each wheel
         */
        public float[] getWheelSlip() {
            return wheelSlip;
        }

        public void setWheelSlip(float[] wheelSlip) {
            this.wheelSlip = wheelSlip;
        }

        /**
         * @return Velocity in local space
         */
        public float getLocalVelocityX() {
            return localVelocityX;
        }

        public void setLocalVelocityX(float localVelocityX) {
            this.localVelocityX = localVelocityX;
        }

        /**
         * @return Velocity in local space
         */
        public float getLocalVelocityY() {
            return localVelocityY;
        }

        public void setLocalVelocityY(float localVelocityY) {
            this.localVelocityY = localVelocityY;
        }

        /**
         * @return Velocity in local space
         */
        public float getLocalVelocityZ() {
            return localVelocityZ;
        }

        public void setLocalVelocityZ(float localVelocityZ) {
            this.localVelocityZ = localVelocityZ;
        }

        /**
         * @return Angular velocity x-component
         */
        public float getAngularVelocityX() {
            return angularVelocityX;
        }

        public void setAngularVelocityX(float angularVelocityX) {
            this.angularVelocityX = angularVelocityX;
        }

        /**
         * @return Angular velocity y-component
         */
        public float getAngularVelocityY() {
            return angularVelocityY;
        }

        public void setAngularVelocityY(float angularVelocityY) {
            this.angularVelocityY = angularVelocityY;
        }

        /**
         * @return Angular velocity z-component
         */
        public float getAngularVelocityZ() {
            return angularVelocityZ;
        }

        public void setAngularVelocityZ(float angularVelocityZ) {
            this.angularVelocityZ = angularVelocityZ;
        }

        /**
         * @return Angular acceleration x-component
         */
        public float getAngularAccelerationX() {
            return angularAccelerationX;
        }

        public void setAngularAccelerationX(float angularAccelerationX) {
            this.angularAccelerationX = angularAccelerationX;
        }

        /**
         * @return Angular acceleration y-component
         */
        public float getAngularAccelerationY() {
            return angularAccelerationY;
        }

        public void setAngularAccelerationY(float angularAccelerationY) {
            this.angularAccelerationY = angularAccelerationY;
        }

        /**
         * @return Angular acceleration z-component
         */
        public float getAngularAccelerationZ() {
            return angularAccelerationZ;
        }

        public void setAngularAccelerationZ(float angularAccelerationZ) {
            this.angularAccelerationZ = angularAccelerationZ;
        }

        /**
         * @return Current front wheels angle in radians
         */
        public float getFrontWheelsAngle() {
            return frontWheelsAngle;
        }

        public void setFrontWheelsAngle(float frontWheelsAngle) {
            this.frontWheelsAngle = frontWheelsAngle;
        }

        @Override
        public String toString() {
            return "ExtraCarMotionData[suspensionPosition=" + Arrays.toString(this.suspensionPosition) +
                    ",suspensionVelocity=" + Arrays.toString(this.suspensionVelocity) +
                    ",suspensionAcceleration= " + Arrays.toString(this.suspensionAcceleration) +
                    ",wheelSpeed=" + Arrays.toString(this.wheelSpeed) +
                    ",wheelSlip=" + Arrays.toString(this.wheelSlip) +
                    ",localVelocityX=" + this.localVelocityX +
                    ",localVelocityY=" + this.localVelocityY +
                    ",localVelocityZ=" + this.localVelocityZ +
                    ",angularVelocityX=" + this.angularVelocityX +
                    ",angularVelocityY=" + this.angularVelocityY +
                    ",angularVelocityZ=" + this.angularVelocityZ +
                    ",angularAccelerationX=" + this.angularAccelerationX +
                    ",angularAccelerationY=" + this.angularAccelerationY +
                    ",angularAccelerationZ=" + this.angularAccelerationZ +
                    ",frontWheelsAngle=" + this.frontWheelsAngle +
                    "]";
        }
    }
}