/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Team
 */
public enum Team {
    MERCEDES(0),
    FERRARI(1),
    RED_BULL_RACING(2),
    WILLIAMS(3),
    RACING_POINT(4),
    RENAULT(5),
    ALPHA_TAURI(6),
    HAAS(7),
    MCLAREN(8),
    ALFA_ROMEO(9),
    MCLAREN_1988(10),
    MCLAREN_1991(11),
    WILLIAM_1992(12),
    FERRARI_1995(13),
    WILLIAMS_1996(14),
    MCLAREN_1998(15),
    FERRARI_2002(16),
    FERRARI_2004(17),
    RENAULT_2006(18),
    FERRARI_2007(19),
    MCLAREN_2008(20),
    RED_BULL_2010(21),
    FERRARI_1976(22),
    ART_GRAND_PRIX(23),
    CAMPOS_VEXATEC_RACING(24),
    CARLIN(25),
    CHAROUZ_RACING_SYSTEM(26),
    DAMS(27),
    RUSSIAN_TIME(28),
    MP_MOTORSPORT(29),
    PERTAMINA(30),
    MCLAREN_1990(31),
    TRIDENT(32),
    BWT_ARDEN(33),
    MCLAREN_1976(34),
    LOTUS_1972(35),
    FERRARI_1979(36),
    MCLAREN_1982(37),
    WILLIAMS_2003(38),
    BRAWN_2009(39),
    LOTUS_1978(40),
    F1_GENERIC_CAR(41),
    ART_GP_19(42),
    CAMPOS_19(43),
    CARLIN_19(44),
    SAUBER_JUNIOR_CHAROUZ_19(45),
    DAMS_19(46),
    UNI_VIRTUOSI_19(47),
    MP_MOTORSPORT_19(48),
    PREMA_19(49),
    TRIDENT_19(50),
    ARDEN_19(51),
    BENETTON_1994(53),
    BENETTON_1995(54),
    FERRARI_2000(55),
    JORDAN_1991(56);

    private static Map<Integer, Team> map = new HashMap<>();

    static {
        for (Team team : Team.values()) {
            map.put(team.value, team);
        }
    }

    private int value;
    
    Team(int value) {
        this.value = value;
    }

    public static Team valueOf(int value) {
        return map.get(value);
    }
}