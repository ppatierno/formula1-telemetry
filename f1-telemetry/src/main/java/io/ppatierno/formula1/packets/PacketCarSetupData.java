/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.data.CarSetupData;

/**
 * Car Setups Packet
 * 
 * This packet details the car setups for each vehicle in the session. Note that
 * in multiplayer games, other player cars will appear as blank, you will only
 * be able to see your car setup and AI cars.
 * Frequency: 2 per second
 */
public class PacketCarSetupData extends Packet {

    // 1102
    public static final int SIZE = PacketHeader.SIZE +
                                    CarSetupData.SIZE * PacketConstants.CARS ;
    
    private List<CarSetupData> carSetupData = new ArrayList<>(PacketConstants.CARS);

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
        StringBuilder sb = new StringBuilder("CarSetup[");
        sb.append(super.toString());
        sb.append(",carSetupData=");
        for (CarSetupData c: carSetupData) {
            sb.append(c.toString() + ",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        for (int i = 0; i < PacketConstants.CARS; i++) {
            CarSetupData csd = new CarSetupData();
            this.carSetupData.add(csd.fill(buffer));
        }
        return this;
    }

    @Override
    public ByteBuf fillBuffer(ByteBuf buffer) {
        super.fillBuffer(buffer);
        for (CarSetupData csd : this.carSetupData) {
            csd.fillBuffer(buffer);
        }
        return buffer;
    }
}