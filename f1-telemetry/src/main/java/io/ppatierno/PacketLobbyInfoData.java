/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;

/**
 * Lobby Info Packet
 * 
 * This packet details the players currently in a multiplayer lobby. It details
 * each player’s selected car, any AI involved in the game and also the ready
 * status of each of the participants.
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
        StringBuilder sb = new StringBuilder("LobbyInfoData[");
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
            lid.setAiControlled(buffer.readUnsignedByte());
            lid.setTeamId(buffer.readUnsignedByte());
            lid.setNationality(buffer.readUnsignedByte());
            lid.setName(PacketUtils.readString(buffer, LobbyInfoData.NAME_LENGTH));
            lid.setReadyStatus(buffer.readUnsignedByte());
            this.lobbyInfoData.add(lid);
        }
        return this;
    }

    class LobbyInfoData {

        public static final int NAME_LENGTH = 48;

        private short aiControlled;
        private short teamId;
        private short nationality;
        private String name;
        private short readyStatus;

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
        public short getTeamId() {
            return teamId;
        }

        public void setTeamId(short teamId) {
            this.teamId = teamId;
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
        public short getReadyStatus() {
            return readyStatus;
        }

        public void setReadyStatus(short readyStatus) {
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