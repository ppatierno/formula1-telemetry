/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import java.util.ArrayList;
import java.util.List;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketConstants;
import io.ppatierno.formula1.data.LobbyInfoData;

/**
 * Lobby Info Packet
 * 
 * This packet details the players currently in a multiplayer lobby. It details
 * each player’s selected car, any AI involved in the game and also the ready
 * status of each of the participants.
 * Frequency: Two every second when in the lobby
 */
public class PacketLobbyInfoData extends Packet {

    // 1169
    public static final int SIZE = PacketHeader.SIZE +
                                    1 +
                                    LobbyInfoData.SIZE * PacketConstants.LOBBY_PLAYERS;
    
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
}