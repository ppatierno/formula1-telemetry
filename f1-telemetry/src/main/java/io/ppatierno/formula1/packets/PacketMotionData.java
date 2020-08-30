/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.data.CarMotionData;
import io.ppatierno.formula1.data.ExtraCarMotionData;

/**
 * Motion Packet
 * 
 * The motion packet gives physics data for all the cars being driven. 
 * There is additional data for the car being driven with the goal of being able to drive a motion platform setup.
 * Frequency: Rate as specified in menus
 */
public class PacketMotionData extends Packet {

    // 1464
    public static final int SIZE = PacketHeader.SIZE + 
                                    CarMotionData.SIZE * PacketConstants.CARS +
                                    ExtraCarMotionData.SIZE;
    
    private List<CarMotionData> carMotionData = new ArrayList<>(PacketConstants.CARS);
    private ExtraCarMotionData extraCarMotionData = new ExtraCarMotionData();

    /**
     * @return Cars motion data
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
        StringBuilder sb = new StringBuilder("Motion[");
        sb.append(super.toString());
        sb.append(",carMotionData=");
        for (CarMotionData cmd : this.carMotionData) {
            sb.append(cmd.toString() + ",");
        }
        sb.append("extraCarMotionData=" + this.extraCarMotionData.toString());
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        for (int i = 0; i < PacketConstants.CARS; i++) {
            CarMotionData cmd = new CarMotionData();
            this.carMotionData.add(cmd.fill(buffer));
        }
        this.extraCarMotionData.fill(buffer);
        return this;
    }

    @Override
    public ByteBuf fillBuffer(ByteBuf buffer) {
        super.fillBuffer(buffer);
        for (CarMotionData cmd : this.carMotionData) {
            cmd.fillBuffer(buffer);
        }
        this.extraCarMotionData.fillBuffer(buffer);
        return buffer;
    }
}