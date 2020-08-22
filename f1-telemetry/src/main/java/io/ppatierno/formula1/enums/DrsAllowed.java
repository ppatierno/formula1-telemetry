/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * DRS allowed
 */
public enum DrsAllowed {
    UNKNOWN(-1),
    NOT_ALLOWED(0),
    ALLOWED(1);

    private static Map<Integer, DrsAllowed> map = new HashMap<>();

    static {
        for (DrsAllowed drsAllowed : DrsAllowed.values()) {
            map.put(drsAllowed.value, drsAllowed);
        }
    }

    private int value;
    
    DrsAllowed(int value) {
        this.value = value;
    }

    public static DrsAllowed valueOf(int value) {
        return map.get(value);
    }

    public int getValue() {
        return value;
    }
}