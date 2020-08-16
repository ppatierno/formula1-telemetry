/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Penalty type
 */
public enum PenaltyType {
    DRIVE_THROUGH(0),
    STOP_GO(1),
    GRID_PENALTY(2),
    PENALTY_REMINDER(3),
    TIME_PENALTY(4),
    WARNING(5),
    DISQUALIFIED(6),
    REMOVED_FROM_FORMATION_LAP(7),
    PARKED_TOO_LONG_TIMER(8),
    TYRE_REGULATIONS(9),
    THIS_LAP_INVALIDATED(10),
    THIS_AND_NEXT_LAP_INVALIDATED(11),
    THIS_LAP_INVALIDATED_WITHOUT_REASON(12),
    THIS_AND_NEXT_LAP_INVALIDATED_WITHOUT_REASON(13),
    THIS_AND_PREVIOUS_LAP_INVALIDATED(14),
    THIS_AND_PREVIOUS_LAP_INVALIDATED_WITHOUT_REASON(15),
    RETIRED(16),
    BLACK_FLAG_TIMER(17);
    
    private static Map<Integer, PenaltyType> map = new HashMap<>();

    static {
        for (PenaltyType penaltyType : PenaltyType.values()) {
            map.put(penaltyType.value, penaltyType);
        }
    }

    private int value;
    
    PenaltyType(int value) {
        this.value = value;
    }

    public static PenaltyType valueOf(int value) {
        return map.get(value);
    }
}