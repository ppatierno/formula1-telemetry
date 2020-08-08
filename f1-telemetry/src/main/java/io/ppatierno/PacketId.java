/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

import java.util.HashMap;
import java.util.Map;

/**
 * Packets IDs
 */
public enum PacketId {
    MOTION(0),
    SESSION(1),
    LAP_DATA(2),
    EVENT(3),
    PARTICIPANTS(4),
    CAR_SETUPS(5),
    CAR_TELEMETRY(6),
    CAR_STATUS(7),
    FINAL_CLASSIFICATION(8),
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
        return (PacketId) map.get(value);
    }
}