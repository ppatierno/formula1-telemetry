/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;

/**
 * Participants Packet
 * 
 * This is a list of participants in the race. If the vehicle is controlled by
 * AI, then the name will be the driver name. If this is a multiplayer game, the
 * names will be the Steam Id on PC, or the LAN name if appropriate.
 */
public class PacketParticipantsData extends Packet {
    
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
        StringBuilder sb = new StringBuilder("ParticipantsData[");
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
            pd.setAiControlled(buffer.readUnsignedByte());
            pd.setDriverId(buffer.readUnsignedByte());
            pd.setTeamId(buffer.readUnsignedByte());
            pd.setRaceNumber(buffer.readUnsignedByte());
            pd.setNationality(buffer.readUnsignedByte());
            pd.setName(PacketUtils.readNullTerminatedString(buffer, ParticipantData.NAME_LENGTH));
            pd.setYourTelemetry(buffer.readUnsignedByte());
            this.participants.add(pd);
        }
        return this;
    }

    class ParticipantData {

        public static final int NAME_LENGTH = 48;

        private short aiControlled;
        private short driverId;
        private short teamId;
        private short raceNumber;
        private short nationality;
        private String name;
        private short yourTelemetry;

        /**
         * @return Whether the vehicle is AI (1) or Human (0) controlled
         */
        public short getAiControlled() {
            return aiControlled;
        }

        public void setAiControlled(short aiControlled) {
            this.aiControlled = aiControlled;
        }

        /**
         * @return Driver Id
         */
        public short getDriverId() {
            return driverId;
        }

        public void setDriverId(short driverId) {
            this.driverId = driverId;
        }

        /**
         * @return Team Id
         */
        public short getTeamId() {
            return teamId;
        }

        public void setTeamId(short teamId) {
            this.teamId = teamId;
        }

        /**
         * @return Race number of the car
         */
        public short getRaceNumber() {
            return raceNumber;
        }

        public void setRaceNumber(short raceNumber) {
            this.raceNumber = raceNumber;
        }

        /**
         * @return Nationality of the driver
         */
        public short getNationality() {
            return nationality;
        }

        public void setNationality(short nationality) {
            this.nationality = nationality;
        }

        /**
         * @return Name of participant in UTF-8 format – null terminated
         * Will be truncated with … (U+2026) if too long
         */
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return The player's UDP setting, 0 = restricted, 1 = public
         */
        public short getYourTelemetry() {
            return yourTelemetry;
        }

        public void setYourTelemetry(short yourTelemetry) {
            this.yourTelemetry = yourTelemetry;
        }

        @Override
        public String toString() {
            return "ParticipantData[aiControlled=" + this.aiControlled +
                    ",driverId=" + this.driverId +
                    ",teamId=" + this.teamId +
                    ",raceNumber=" + this.raceNumber +
                    ",nationality=" + this.nationality +
                    ",name=" + this.name +
                    ",yourTelemetry=" + this.yourTelemetry +
                    "]";
        }
    }
}