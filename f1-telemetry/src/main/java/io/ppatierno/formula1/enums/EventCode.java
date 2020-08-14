/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Event code
 */
public enum EventCode {
    SESSION_STARTED("SSTA"),
    SESSION_ENDED("SEND"),
    FASTEST_LAP("FTLP"),
    RETIREMENT("RTMT"),
    DRS_ENABLED("DRSE"),
    DRS_DISABLED("DRSD"),
    TEAM_MATE_IN_PITS("TMPT"),
    CHEQUERED_FLAG("CHQF"),
    RACE_WINNER("RCWN"),
    PENALTY_ISSUED("PENA"),
    SPEED_TRAP_TRIGGERED("SPTP");

    private static Map<String, EventCode> map = new HashMap<>();

    static {
        for (EventCode eventCode : EventCode.values()) {
            map.put(eventCode.value, eventCode);
        }
    }

    private String value;
    
    private EventCode(String value) {
        this.value = value;
    }
    
    public static EventCode valueFrom(String value) {
        return (EventCode) map.get(value);
    }
}