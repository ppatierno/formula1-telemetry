/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Driver status
 */
public enum DriverStatus {
    IN_GARAGE(0),
    FLYING_LAP(1),
    IN_LAP(2),
    OUT_LAP(3),
    ON_TRACK(4);

    private static Map<Integer, DriverStatus> map = new HashMap<>();

    static {
        for (DriverStatus driverStatus : DriverStatus.values()) {
            map.put(driverStatus.value, driverStatus);
        }
    }

    private int value;
    
    DriverStatus(int value) {
        this.value = value;
    }

    public static DriverStatus valueOf(int value) {
        return map.get(value);
    }
}