/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Packets IDs
 */
public enum PacketId {
    // Contains all motion data for player’s car – only sent while player is in control
    MOTION(0),
    // Data about the session – track, time left
    SESSION(1),
    // Data about all the lap times of cars in the session
    LAP_DATA(2),
    // Various notable events that happen during a session
    EVENT(3),
    // List of participants in the session, mostly relevant for multiplayer
    PARTICIPANTS(4),
    // Packet detailing car setups for cars in the race
    CAR_SETUPS(5),
    // Telemetry data for all cars
    CAR_TELEMETRY(6),
    // Status data for all cars such as damage
    CAR_STATUS(7),
    // Final classification confirmation at the end of a race
    FINAL_CLASSIFICATION(8),
    // Information about players in a multiplayer lobby
    LOBBY_INFO(9);

    private static Map<Integer, PacketId> map = new HashMap<>();

    static {
        for (PacketId packetId : PacketId.values()) {
            map.put(packetId.value, packetId);
        }
    }

    private int value;
    
    private PacketId(int value) {
        this.value = value;
    }

    public static PacketId valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}