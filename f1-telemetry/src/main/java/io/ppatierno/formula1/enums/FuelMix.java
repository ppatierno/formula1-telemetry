/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Fuel mix
 */
public enum FuelMix {
    LEAN(0),
    STANDARD(1),
    RICH(2),
    MAX(3);
    
    private static Map<Integer, FuelMix> map = new HashMap<>();

    static {
        for (FuelMix fuelMix : FuelMix.values()) {
            map.put(fuelMix.value, fuelMix);
        }
    }

    private int value;
    
    private FuelMix(int value) {
        this.value = value;
    }

    public static FuelMix valueOf(int value) {
        return (FuelMix) map.get(value);
    }
}