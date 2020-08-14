/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Vehicle FIA flag
 */
public enum VehicleFiaFlag {
    INVALID_UNKNOWN(-1),
    NONE(0),
    GREEN(1),
    BLUE(2),
    YELLOW(3),
    RED(4);
    
    private static Map<Integer, VehicleFiaFlag> map = new HashMap<>();

    static {
        for (VehicleFiaFlag vehicleFiaFlag : VehicleFiaFlag.values()) {
            map.put(vehicleFiaFlag.value, vehicleFiaFlag);
        }
    }

    private int value;
    
    private VehicleFiaFlag(int value) {
        this.value = value;
    }

    public static VehicleFiaFlag valueOf(int value) {
        return (VehicleFiaFlag) map.get(value);
    }
}