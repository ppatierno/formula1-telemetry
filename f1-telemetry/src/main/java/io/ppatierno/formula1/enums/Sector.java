/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Sector
 */
public enum Sector {
    SECTOR1(0),
    SECTOR2(1),
    SECTOR3(2);

    private static Map<Integer, Sector> map = new HashMap<>();

    static {
        for (Sector sector : Sector.values()) {
            map.put(sector.value, sector);
        }
    }

    private int value;
    
    private Sector(int value) {
        this.value = value;
    }

    public static Sector valueOf(int value) {
        return (Sector) map.get(value);
    }
}