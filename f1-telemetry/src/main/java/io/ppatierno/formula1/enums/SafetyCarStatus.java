/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

public enum SafetyCarStatus {
    NO_SAFETY_CAR(0),
    FULL_SAFETY_CAR(1),
    VIRTUAL_SAFETY_CAR(2);
    
    private static Map<Integer, SafetyCarStatus> map = new HashMap<>();

    static {
        for (SafetyCarStatus safetyCarStatus : SafetyCarStatus.values()) {
            map.put(safetyCarStatus.value, safetyCarStatus);
        }
    }

    private int value;
    
    private SafetyCarStatus(int value) {
        this.value = value;
    }

    public static SafetyCarStatus valueOf(int value) {
        return (SafetyCarStatus) map.get(value);
    }
}