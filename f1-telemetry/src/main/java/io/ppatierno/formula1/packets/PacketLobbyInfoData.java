/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.PacketUtils;
import io.ppatierno.formula1.enums.Nationality;
import io.ppatierno.formula1.enums.ReadyStatus;
import io.ppatierno.formula1.enums.Team;

/**
 * Lobby Info Packet
 * 
 * This packet details the players currently in a multiplayer lobby. It details
 * each player’s selected car, any AI involved in the game and also the ready
 * status of each of the participants.
 * Frequency: Two every second when in the lobby
 */
public class PacketLobbyInfoData extends Packet {
    
    private short numPlayers;
    private List<LobbyInfoData> lobbyInfoData = new ArrayList<>(PacketConstants.LOBBY_PLAYERS);

    /**
     * @return Number of players in the lobby data
     */
    public short getNumPlayers() {
        return numPlayers;
    }

    public void setNumPlayers(short numPlayers) {
        this.numPlayers = numPlayers;
    }

    /**
     * @return Lobby info data for all cars
     */
    public List<LobbyInfoData> getLobbyInfoData() {
        return lobbyInfoData;
    }

    public void setLobbyInfoData(List<LobbyInfoData> lobbyInfoData) {
        this.lobbyInfoData = lobbyInfoData;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("LobbyInfo[");
        sb.append(super.toString());
        sb.append(",numPlayers=" + this.numPlayers);
        sb.append(",lobbyInfoData=");
        for (LobbyInfoData l : lobbyInfoData) {
            sb.append(l.toString() + ",");
        }
        sb.replace(sb.length() - 1, sb.length() - 1, "]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        this.numPlayers = buffer.readUnsignedByte();
        for (int i = 0; i < this.numPlayers; i++) {
            LobbyInfoData lid = new LobbyInfoData();
            this.lobbyInfoData.add(lid.fill(buffer));
        }
        return this;
    }

    @Override
    public ByteBuf fillBuffer(ByteBuf buffer) {
        super.fillBuffer(buffer);
        buffer.writeByte(this.numPlayers);
        for (LobbyInfoData lid : this.lobbyInfoData) {
            lid.fillBuffer(buffer);
        }
        return buffer;
    }

    public class LobbyInfoData {

        public static final int NAME_LENGTH = 48;

        private short aiControlled;
        private Team teamId;
        private Nationality nationality;
        private String name;
        private ReadyStatus readyStatus;

        /**
         * Fill the current LobbyInfoData with the raw bytes representation
         * 
         * @param buffer buffer with the raw bytes representation
         * @return current filled LobbyInfoData instance
         */
        public LobbyInfoData fill(ByteBuf buffer) {
            this.aiControlled = buffer.readUnsignedByte();
            this.teamId = Team.valueOf(buffer.readUnsignedByte());
            this.nationality = Nationality.valueOf(buffer.readUnsignedByte());
            this.name = PacketUtils.readString(buffer, LobbyInfoData.NAME_LENGTH);
            this.readyStatus = ReadyStatus.valueOf(buffer.readUnsignedByte());
            return this;
        }

        /**
         * Fill the buffer with the raw bytes representation of the current LobbyInfoData instance
         * 
         * @param buffer buffer to fill
         * @return filled buffer
         */
        public ByteBuf fillBuffer(ByteBuf buffer) {
            buffer.writeByte(this.aiControlled);
            buffer.writeByte(this.teamId.getValue());
            buffer.writeByte(this.nationality.getValue());
            PacketUtils.writeString(this.name, buffer, LobbyInfoData.NAME_LENGTH);
            buffer.writeByte(this.readyStatus.getValue());
            return buffer;
        }

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
         * @return Team id - see appendix (255 if no team currently selected)
         */
        public Team getTeamId() {
            return teamId;
        }

        public void setTeamId(Team teamId) {
            this.teamId = teamId;
        }

        /**
         * @return Nationality of the driver
         */
        public Nationality getNationality() {
            return nationality;
        }

        public void setNationality(Nationality nationality) {
            this.nationality = nationality;
        }

        /**
         * @return Name of participant in UTF-8 format – null terminated
         * Will be truncated with ... (U+2026) if too long
         */
        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        /**
         * @return Ready status
         * 0 = not ready, 1 = ready, 2 = spectating
         */
        public ReadyStatus getReadyStatus() {
            return readyStatus;
        }

        public void setReadyStatus(ReadyStatus readyStatus) {
            this.readyStatus = readyStatus;
        }

        @Override
        public String toString() {
            return "LobbyInfoData[" +
                    ",aiControlled=" + this.aiControlled +
                    ",teamId=" + this.teamId +
                    ",nationality=" + this.nationality +
                    ",name=" + this.name +
                    ",readyStatus=" + this.readyStatus +
                    "]";
        }
    }
}