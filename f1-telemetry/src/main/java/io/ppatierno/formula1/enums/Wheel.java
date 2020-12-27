/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Wheel
 * (represents wheel indexes in the corresponding arrays)
 */
public enum Wheel {
    REAR_LEFT(0),
    REAR_RIGHT(1),
    FRONT_LEFT(2),
    FRONT_RIGHT(3);

    private static Map<Integer, Wheel> map = new HashMap<>();

    static {
        for (Wheel wheel : Wheel.values()) {
            map.put(wheel.value, wheel);
        }
    }

    private int value;

    Wheel(int value) {
        this.value = value;
    }

    public static Wheel valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}
