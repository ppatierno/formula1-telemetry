/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.data.FinalClassificationData;

/**
 * Final Classification Packet
 * 
 * This packet details the final classification at the end of the race, and the
 * data will match with the post race results screen. This is especially useful
 * for multiplayer games where it is not always possible to send lap times on
 * the final frame because of network delay.
 * Frequency: Once at the end of a race
 */
public class PacketFinalClassificationData extends Packet {

    // 839
    public static final int SIZE = PacketHeader.SIZE +
                                    1 +
                                    FinalClassificationData.SIZE * PacketConstants.CARS;
    
    private short numCars;
    private List<FinalClassificationData> finalClassificationData = new ArrayList<>(PacketConstants.CARS);

    /**
     * @return Number of cars in the final classification
     */
    public short getNumCars() {
        return numCars;
    }

    public void setNumCars(short numCars) {
        this.numCars = numCars;
    }

    /**
     * @return Final classification data for all cars
     */
    public List<FinalClassificationData> getFinalClassificationData() {
        return finalClassificationData;
    }

    public void setFinalClassificationData(List<FinalClassificationData> finalClassificationData) {
        this.finalClassificationData = finalClassificationData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("FinalClassification[");
        sb.append(super.toString());
        sb.append("numCars=" + this.numCars);
        sb.append(",finalClassificationData=");
        for (FinalClassificationData f : finalClassificationData) {
            sb.append(f.toString() + ",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        return  sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        this.numCars = buffer.readUnsignedByte();
        for (int i = 0; i < this.numCars; i++) {
            FinalClassificationData fcd = new FinalClassificationData();
            this.finalClassificationData.add(fcd.fill(buffer));
        }
        return this;
    }

    @Override
    public ByteBuf fillBuffer(ByteBuf buffer) {
        super.fillBuffer(buffer);
        buffer.writeByte(this.numCars);
        for (FinalClassificationData fcd : this.finalClassificationData) {
            fcd.fillBuffer(buffer);
        }
        return buffer;
    }
}