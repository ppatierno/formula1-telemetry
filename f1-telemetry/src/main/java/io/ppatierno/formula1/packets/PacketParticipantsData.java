/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.data.ParticipantData;

/**
 * Participants Packet
 * 
 * This is a list of participants in the race. If the vehicle is controlled by
 * AI, then the name will be the driver name. If this is a multiplayer game, the
 * names will be the Steam Id on PC, or the LAN name if appropriate.
 * Frequency: Every 5 seconds
 */
public class PacketParticipantsData extends Packet {

    // 1213
    public static final int SIZE = PacketHeader.SIZE + 
                                    1 + 
                                    ParticipantData.SIZE * PacketConstants.CARS;
    
    private short numActiveCars;
    private List<ParticipantData> participants = new ArrayList<>(PacketConstants.CARS);

    /**
     * @return Number of active cars in the data – should match number of cats on HUD
     */
    public short getNumActiveCars() {
        return numActiveCars;
    }

    public void setNumActiveCars(short numActiveCars) {
        this.numActiveCars = numActiveCars;
    }

    /**
     * @return Participants
     */
    public List<ParticipantData> getParticipants() {
        return participants;
    }

    public void setParticipants(List<ParticipantData> participants) {
        this.participants = participants;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("Participants[");
        sb.append(super.toString());
        sb.append(",numActiveCars=" + this.numActiveCars);
        sb.append(",participants=");
        for (ParticipantData p : participants) {
            sb.append(p.toString() + ",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        this.numActiveCars = buffer.readUnsignedByte();
        for (int i = 0; i < this.numActiveCars; i++) {
            ParticipantData pd = new ParticipantData();
            this.participants.add(pd.fill(buffer));
        }
        return this;
    }

    @Override
    public ByteBuf fillBuffer(ByteBuf buffer) {
        super.fillBuffer(buffer);
        buffer.writeByte(this.numActiveCars);
        for (ParticipantData pd : this.participants) {
            pd.fillBuffer(buffer);
        }
        return buffer;
    }
}