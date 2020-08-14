/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import java.util.HashMap;
import java.util.Map;

/**
 * Result status
 */
public enum ResultStatus {
    INVALID(0),
    INACTIVE(1),
    ACTIVE(2),
    FINISHED(3),
    DISQUALIFIED(4),
    NOT_CLASSIFIED(5),
    RETIRED(6);

    private static Map<Integer, ResultStatus> map = new HashMap<>();

    static {
        for (ResultStatus resultStatus : ResultStatus.values()) {
            map.put(resultStatus.value, resultStatus);
        }
    }

    private int value;
    
    private ResultStatus(int value) {
        this.value = value;
    }

    public static ResultStatus valueOf(int value) {
        return (ResultStatus) map.get(value);
    }
}