/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.data.CarTelemetryData;
import io.ppatierno.formula1.enums.MfdPanel;

/**
 * Car Telemetry Packet
 * 
 * This packet details telemetry for all the cars in the race. It details
 * various values that would be recorded on the car such as speed, throttle
 * application, DRS etc.
 * Frequency: Rate as specified in menus
 */
public class PacketCarTelemetryData extends Packet {

    // 1307
    public static final int SIZE = PacketHeader.SIZE +
                                    CarTelemetryData.SIZE * PacketConstants.CARS +
                                    7;
    
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
        StringBuilder sb = new StringBuilder("CarTelemetry[");
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
            this.carTelemetryData.add(ctd.fill(buffer));
        }
        this.buttonStatus = buffer.readUnsignedIntLE();
        this.mfdPanelIndex = MfdPanel.valueOf(buffer.readUnsignedByte());
        this.mfdPanelIndexSecondaryPlayer = MfdPanel.valueOf(buffer.readUnsignedByte());
        this.suggestedGear = buffer.readByte();
        return this;
    }

    @Override
    public ByteBuf fillBuffer(ByteBuf buffer) {
        super.fillBuffer(buffer);
        for (CarTelemetryData ctd : this.carTelemetryData) {
            ctd.fillBuffer(buffer);
        }
        buffer.writeIntLE((int)this.buttonStatus);
        buffer.writeByte(this.mfdPanelIndex.getValue());
        buffer.writeByte(this.mfdPanelIndexSecondaryPlayer.getValue());
        buffer.writeByte(this.suggestedGear);
        return buffer;
    }
}