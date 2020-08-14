/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import java.util.HashMap;
import java.util.Map;

/**
 * Formula
 */
public enum Formula {
    F1_MODERN(0),
    F1_CLASSIC(1),
    F2(2),
    F1_GENERIC(3);
    
    private static Map<Integer, Formula> map = new HashMap<>();

    static {
        for (Formula formula : Formula.values()) {
            map.put(formula.value, formula);
        }
    }

    private int value;
    
    private Formula(int value) {
        this.value = value;
    }

    public static Formula valueOf(int value) {
        return (Formula) map.get(value);
    }
}