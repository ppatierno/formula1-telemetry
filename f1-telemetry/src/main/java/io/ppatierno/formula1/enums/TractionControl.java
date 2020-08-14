/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Traction control
 */
public enum TractionControl {
    OFF(0),
    MEDIUM(1),
    HIGH(2);

    private static Map<Integer, TractionControl> map = new HashMap<>();

    static {
        for (TractionControl tractionControl : TractionControl.values()) {
            map.put(tractionControl.value, tractionControl);
        }
    }

    private int value;
    
    private TractionControl(int value) {
        this.value = value;
    }

    public static TractionControl valueOf(int value) {
        return (TractionControl) map.get(value);
    }
}