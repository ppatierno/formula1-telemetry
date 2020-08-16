/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Weather
 */
public enum Weather {
    CLEAR(0),
    LIGHT_CLOUD(1),
    OVERCAST(2),
    LIGHT_RAIN(3),
    HEAVY_RAIN(4),
    STORM(5);

    private static Map<Integer, Weather> map = new HashMap<>();

    static {
        for (Weather weather : Weather.values()) {
            map.put(weather.value, weather);
        }
    }

    private int value;
    
    Weather(int value) {
        this.value = value;
    }

    public static Weather valueOf(int value) {
        return map.get(value);
    }
}