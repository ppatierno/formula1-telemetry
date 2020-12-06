/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Actual tyre compound
 */
public enum ActualTyreCompound {
    UNKNOWN(0),
    F1_C5(16),
    F1_C4(17),
    F1_C3(18),
    F1_C2(19),
    F1_C1(20),
    F1_INTER(7),
    F1_WET(8),
    F1_CLASSIC_DRY(9),
    F1_CLASSIC_WET(10),
    F2_SUPER_SOFT(11),
    F2_SOFT(12),
    F2_MEDIUM(13),
    F2_HARD(14),
    F2_WET(15);
    
    private static Map<Integer, ActualTyreCompound> map = new HashMap<>();

    static {
        for (ActualTyreCompound actualTyreCompound : ActualTyreCompound.values()) {
            map.put(actualTyreCompound.value, actualTyreCompound);
        }
    }

    private int value;
    
    ActualTyreCompound(int value) {
        this.value = value;
    }

    public static ActualTyreCompound valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}