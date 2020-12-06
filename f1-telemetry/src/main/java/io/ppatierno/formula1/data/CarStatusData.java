/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.enums.DrsAllowed;
import io.ppatierno.formula1.enums.ErsDeployMode;
import io.ppatierno.formula1.enums.FuelMix;
import io.ppatierno.formula1.enums.TractionControl;
import io.ppatierno.formula1.enums.ActualTyreCompound;
import io.ppatierno.formula1.enums.VehicleFiaFlag;
import io.ppatierno.formula1.enums.VisualTyreCompound;


import java.util.Arrays;

public class CarStatusData {

    public static final int SIZE = 60;

    private TractionControl tractionControl;
    private short antiLockBrakes;
    private FuelMix fuelMix;
    private short frontBrakeBias;
    private short pitLimiterStatus;
    private float fuelInTank;
    private float fuelCapacity;
    private float fuelRemainingLaps;
    private int maxRPM;
    private int idleRPM;
    private short maxGears;
    private DrsAllowed drsAllowed;
    private int drsActivationDistance;
    private short tyresWear[] = new short[PacketConstants.TYRES];
    private ActualTyreCompound actualTyreCompound;
    private VisualTyreCompound visualTyreCompound;
    private short tyresAgeLaps;
    private short tyresDamage[] = new short[PacketConstants.TYRES];
    private short frontLeftWingDamage;
    private short frontRightWingDamage;
    private short rearWingDamage;
    private short drsFault;
    private short engineDamage;
    private short gearBoxDamage;
    private VehicleFiaFlag vehicleFiaFlags;
    private float ersStoreEnergy;
    private ErsDeployMode ersDeployMode;
    private float ersHarvestedThisLapMGUK;
    private float ersHarvestedThisLapMGUH;
    private float ersDeployedThisLap;

    /**
     * Fill the current CarStatusData with the raw bytes representation
     *
     * @param buffer buffer with the raw bytes representation
     * @return current filled CarStatusData instance
     */
    public CarStatusData fill(ByteBuf buffer) {
        this.tractionControl = TractionControl.valueOf(buffer.readUnsignedByte());
        this.antiLockBrakes = buffer.readUnsignedByte();
        this.fuelMix = FuelMix.valueOf(buffer.readUnsignedByte());
        this.frontBrakeBias = buffer.readUnsignedByte();
        this.pitLimiterStatus = buffer.readUnsignedByte();
        this.fuelInTank = buffer.readFloatLE();
        this.fuelCapacity = buffer.readFloatLE();
        this.fuelRemainingLaps = buffer.readFloatLE();
        this.maxRPM = buffer.readUnsignedShortLE();
        this.idleRPM = buffer.readUnsignedShortLE();
        this.maxGears = buffer.readUnsignedByte();
        this.drsAllowed = DrsAllowed.valueOf(buffer.readUnsignedByte());
        this.drsActivationDistance = buffer.readUnsignedShortLE();
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            this.tyresWear[j] = buffer.readUnsignedByte();
        }
        this.actualTyreCompound = ActualTyreCompound.valueOf(buffer.readUnsignedByte());
        this.visualTyreCompound = VisualTyreCompound.valueOf(buffer.readUnsignedByte());
        this.tyresAgeLaps = buffer.readUnsignedByte();
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            this.tyresDamage[j] = buffer.readUnsignedByte();
        }
        this.frontLeftWingDamage = buffer.readUnsignedByte();
        this.frontRightWingDamage = buffer.readUnsignedByte();
        this.rearWingDamage = buffer.readUnsignedByte();
        this.drsFault = buffer.readUnsignedByte();
        this.engineDamage = buffer.readUnsignedByte();
        this.gearBoxDamage = buffer.readUnsignedByte();
        this.vehicleFiaFlags = VehicleFiaFlag.valueOf(buffer.readByte());
        this.ersStoreEnergy = buffer.readFloatLE();
        this.ersDeployMode = ErsDeployMode.valueOf(buffer.readUnsignedByte());
        this.ersHarvestedThisLapMGUK = buffer.readFloatLE();
        this.ersHarvestedThisLapMGUH = buffer.readFloatLE();
        this.ersDeployedThisLap = buffer.readFloatLE();
        return this;
    }

    /**
     * Fill the buffer with the raw bytes representation of the current CarStatusData instance
     *
     * @param buffer buffer to fill
     * @return filled buffer
     */
    public ByteBuf fillBuffer(ByteBuf buffer) {
        buffer.writeByte(this.tractionControl.getValue());
        buffer.writeByte(this.antiLockBrakes);
        buffer.writeByte(this.fuelMix.getValue());
        buffer.writeByte(this.frontBrakeBias);
        buffer.writeByte(this.pitLimiterStatus);
        buffer.writeFloatLE(this.fuelInTank);
        buffer.writeFloatLE(this.fuelCapacity);
        buffer.writeFloatLE(this.fuelRemainingLaps);
        buffer.writeShortLE(this.maxRPM);
        buffer.writeShortLE(this.idleRPM);
        buffer.writeByte(this.maxGears);
        buffer.writeByte(this.drsAllowed.getValue());
        buffer.writeShortLE(this.drsActivationDistance);
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            buffer.writeByte(this.tyresWear[j]);
        }
        buffer.writeByte(this.actualTyreCompound.getValue());
        buffer.writeByte(this.visualTyreCompound.getValue());
        buffer.writeByte(this.tyresAgeLaps);
        for (int j = 0; j < PacketConstants.TYRES; j++) {
            buffer.writeByte(this.tyresDamage[j]);
        }
        buffer.writeByte(this.frontLeftWingDamage);
        buffer.writeByte(this.frontRightWingDamage);
        buffer.writeByte(this.rearWingDamage);
        buffer.writeByte(this.drsFault);
        buffer.writeByte(this.engineDamage);
        buffer.writeByte(this.gearBoxDamage);
        buffer.writeByte(this.vehicleFiaFlags.getValue());
        buffer.writeFloatLE(this.ersStoreEnergy);
        buffer.writeByte(this.ersDeployMode.getValue());
        buffer.writeFloatLE(this.ersHarvestedThisLapMGUK);
        buffer.writeFloatLE(this.ersHarvestedThisLapMGUH);
        buffer.writeFloatLE(this.ersDeployedThisLap);
        return buffer;
    }

    /**
     * @return Traction control
     * 0 (off) - 2 (high)
     */
    public TractionControl getTractionControl() {
        return tractionControl;
    }

    public void setTractionControl(TractionControl tractionControl) {
        this.tractionControl = tractionControl;
    }

    /**
     * @return Antilock brakes
     * 0 (off) - 1 (on)
     */
    public short getAntiLockBrakes() {
        return antiLockBrakes;
    }

    public void setAntiLockBrakes(short antiLockBrakes) {
        this.antiLockBrakes = antiLockBrakes;
    }

    /**
     * @return Fuel mix
     * 0 = lean, 1 = standard, 2 = rich, 3 = max
     */
    public FuelMix getFuelMix() {
        return fuelMix;
    }

    public void setFuelMix(FuelMix fuelMix) {
        this.fuelMix = fuelMix;
    }

    /**
     * @return Front brake bias (percentage)
     */
    public short getFrontBrakeBias() {
        return frontBrakeBias;
    }

    public void setFrontBrakeBias(short frontBrakeBias) {
        this.frontBrakeBias = frontBrakeBias;
    }

    /**
     * @return Pit limiter status
     * 0 = off, 1 = on
     */
    public short getPitLimiterStatus() {
        return pitLimiterStatus;
    }

    public void setPitLimiterStatus(short pitLimiterStatus) {
        this.pitLimiterStatus = pitLimiterStatus;
    }

    /**
     * @return Current fuel mass
     */
    public float getFuelInTank() {
        return fuelInTank;
    }

    public void setFuelInTank(float fuelInTank) {
        this.fuelInTank = fuelInTank;
    }

    /**
     * @return Fuel capacity
     */
    public float getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(float fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    /**
     * @return Fuel remaining in terms of laps (value on MFD)
     */
    public float getFuelRemainingLaps() {
        return fuelRemainingLaps;
    }

    public void setFuelRemainingLaps(float fuelRemainingLaps) {
        this.fuelRemainingLaps = fuelRemainingLaps;
    }

    /**
     * @return Cars max RPM, point of rev limiter
     */
    public int getMaxRPM() {
        return maxRPM;
    }

    public void setMaxRPM(int maxRPM) {
        this.maxRPM = maxRPM;
    }

    /**
     * @return Cars idle RPM
     */
    public int getIdleRPM() {
        return idleRPM;
    }

    public void setIdleRPM(int idleRPM) {
        this.idleRPM = idleRPM;
    }

    /**
     * @return Maximum number of gears
     */
    public short getMaxGears() {
        return maxGears;
    }

    public void setMaxGears(short maxGears) {
        this.maxGears = maxGears;
    }

    /**
     * @return DRS allowed
     * 0 = not allowed, 1 = allowed, -1 = unknown
     */
    public DrsAllowed getDrsAllowed() {
        return drsAllowed;
    }

    public void setDrsAllowed(DrsAllowed drsAllowed) {
        this.drsAllowed = drsAllowed;
    }

    /**
     * @return DRS activation distance
     * 0 = DRS not available, non-zero - DRS will be available in [X] metres
     */
    public int getDrsActivationDistance() {
        return drsActivationDistance;
    }

    public void setDrsActivationDistance(int drsActivationDistance) {
        this.drsActivationDistance = drsActivationDistance;
    }

    /**
     * @return Tyre wear percentage
     */
    public short[] getTyresWear() {
        return tyresWear;
    }

    public void setTyresWear(short[] tyresWear) {
        this.tyresWear = tyresWear;
    }

    /**
     * @return Actual tyre compound
     * F1 Modern - 16 = C5, 17 = C4, 18 = C3, 19 = C2, 20 = C1, 7 = inter, 8 = wet
     * F1 Classic - 9 = dry, 10 = wet
     * F2 – 11 = super soft, 12 = soft, 13 = medium, 14 = hard, 15 = wet
     */
    public ActualTyreCompound getActualTyreCompound() {
        return actualTyreCompound;
    }

    public void setActualTyreCompound(ActualTyreCompound actualTyreCompound) {
        this.actualTyreCompound = actualTyreCompound;
    }

    /**
     * @return Visual tyre compound
     * F1 visual (can be different from actual compound) 16 = soft, 17 = medium, 18 = hard, 7 = inter, 8 = wet
     * F1 Classic – same as above
     * F2 – same as above
     */
    public VisualTyreCompound getVisualTyreCompound() {
        return visualTyreCompound;
    }

    public void setVisualTyreCompound(VisualTyreCompound visualTyreCompound) {
        this.visualTyreCompound = visualTyreCompound;
    }

    /**
     * @return Age in laps of the current set of tyres
     */
    public short getTyresAgeLaps() {
        return tyresAgeLaps;
    }

    public void setTyresAgeLaps(short tyresAgeLaps) {
        this.tyresAgeLaps = tyresAgeLaps;
    }

    /**
     * @return Tyre damage (percentage)
     */
    public short[] getTyresDamage() {
        return tyresDamage;
    }

    public void setTyresDamage(short[] tyresDamage) {
        this.tyresDamage = tyresDamage;
    }

    /**
     * @return Front left wing damage (percentage)
     */
    public short getFrontLeftWingDamage() {
        return frontLeftWingDamage;
    }

    public void setFrontLeftWingDamage(short frontLeftWingDamage) {
        this.frontLeftWingDamage = frontLeftWingDamage;
    }

    /**
     * @return Front right wing damage (percentage)
     */
    public short getFrontRightWingDamage() {
        return frontRightWingDamage;
    }

    public void setFrontRightWingDamage(short frontRightWingDamage) {
        this.frontRightWingDamage = frontRightWingDamage;
    }

    /**
     * @return Rear wing damage (percentage)
     */
    public short getRearWingDamage() {
        return rearWingDamage;
    }

    public void setRearWingDamage(short rearWingDamage) {
        this.rearWingDamage = rearWingDamage;
    }

    /**
     * @return Indicator for DRS fault
     * 0 = OK, 1 = fault
     */
    public short getDrsFault() {
        return drsFault;
    }

    public void setDrsFault(short drsFault) {
        this.drsFault = drsFault;
    }

    /**
     * @return Engine damage (percentage)
     */
    public short getEngineDamage() {
        return engineDamage;
    }

    public void setEngineDamage(short engineDamage) {
        this.engineDamage = engineDamage;
    }

    /**
     * @return Gear box damage (percentage)
     */
    public short getGearBoxDamage() {
        return gearBoxDamage;
    }

    public void setGearBoxDamage(short gearBoxDamage) {
        this.gearBoxDamage = gearBoxDamage;
    }

    /**
     * @return Vehicle FIA flags
     * -1 = invalid/unknown, 0 = none, 1 = green
     * 2 = blue, 3 = yellow, 4 = red
     */
    public VehicleFiaFlag getVehicleFiaFlags() {
        return vehicleFiaFlags;
    }

    public void setVehicleFiaFlags(VehicleFiaFlag vehicleFiaFlags) {
        this.vehicleFiaFlags = vehicleFiaFlags;
    }

    /**
     * @return ERS energy store in Joules
     */
    public float getErsStoreEnergy() {
        return ersStoreEnergy;
    }

    public void setErsStoreEnergy(float ersStoreEnergy) {
        this.ersStoreEnergy = ersStoreEnergy;
    }

    /**
     * @return ERS deploy mode
     * 0 = none, 1 = medium, 2 = overtake, 3 = hotlap
     */
    public ErsDeployMode getErsDeployMode() {
        return ersDeployMode;
    }

    public void setErsDeployMode(ErsDeployMode ersDeployMode) {
        this.ersDeployMode = ersDeployMode;
    }

    /**
     * @return ERS energy harvested this lap by MGU-K
     */
    public float getErsHarvestedThisLapMGUK() {
        return ersHarvestedThisLapMGUK;
    }

    public void setErsHarvestedThisLapMGUK(float ersHarvestedThisLapMGUK) {
        this.ersHarvestedThisLapMGUK = ersHarvestedThisLapMGUK;
    }

    /**
     * @return ERS energy harvested this lap by MGU-H
     */
    public float getErsHarvestedThisLapMGUH() {
        return ersHarvestedThisLapMGUH;
    }

    public void setErsHarvestedThisLapMGUH(float ersHarvestedThisLapMGUH) {
        this.ersHarvestedThisLapMGUH = ersHarvestedThisLapMGUH;
    }

    /**
     * @return ERS energy deployed this lap
     */
    public float getErsDeployedThisLap() {
        return ersDeployedThisLap;
    }

    public void setErsDeployedThisLap(float ersDeployedThisLap) {
        this.ersDeployedThisLap = ersDeployedThisLap;
    }

    @Override
    public String toString() {
        return "CarStatusData[tractionControl=" + this.tractionControl +
                ",antiLockBrakes=" + this.antiLockBrakes +
                ",fuelMix=" + this.fuelMix +
                ",frontBrakeBias=" + this.frontBrakeBias +
                ",pitLimiterStatus=" + this.pitLimiterStatus +
                ",fuelInTank=" + this.fuelInTank +
                ",fuelCapacity=" + this.fuelCapacity +
                ",fuelRemainingLaps=" + this.fuelRemainingLaps +
                ",maxRPM=" + this.maxRPM +
                ",idleRPM=" + this.idleRPM +
                ",maxGears=" + this.maxGears +
                ",drsAllowed=" + this.drsAllowed +
                ",drsActivationDistance=" + this.drsActivationDistance +
                ",tyresWear=" + Arrays.toString(this.tyresWear) +
                ",actualTyreCompound=" + this.actualTyreCompound +
                ",visualTyreCompound=" + this.visualTyreCompound +
                ",tyresAgeLaps=" + this.tyresAgeLaps +
                ",tyresDamage=" + Arrays.toString(this.tyresDamage) +
                ",frontLeftWingDamage=" + this.frontLeftWingDamage +
                ",frontRightWingDamage=" + this.frontRightWingDamage +
                ",rearWingDamage=" + this.rearWingDamage +
                ",drsFault=" + this.drsFault +
                ",engineDamage=" + this.engineDamage +
                ",gearBoxDamage=" + this.gearBoxDamage +
                ",vehicleFiaFlags=" + this.vehicleFiaFlags +
                ",ersStoreEnergy=" + this.ersStoreEnergy +
                ",ersDeployMode=" + this.ersDeployMode +
                ",ersHarvestedThisLapMGUK=" + this.ersHarvestedThisLapMGUK +
                ",ersHarvestedThisLapMGUH=" + this.ersHarvestedThisLapMGUH +
                ",ersDeployedThisLap=" + this.ersDeployedThisLap +
                "]";
    }
}
