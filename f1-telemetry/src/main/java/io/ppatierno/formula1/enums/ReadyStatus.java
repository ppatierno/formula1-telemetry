/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Ready status
 */
public enum ReadyStatus {
    NOT_READY(0),
    READY(1),
    SPECTATING(2);
    
    private static Map<Integer, ReadyStatus> map = new HashMap<>();

    static {
        for (ReadyStatus readyStatus : ReadyStatus.values()) {
            map.put(readyStatus.value, readyStatus);
        }
    }

    private int value;
    
    private ReadyStatus(int value) {
        this.value = value;
    }

    public static ReadyStatus valueOf(int value) {
        return (ReadyStatus) map.get(value);
    }
}