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
public interface Team {

    static Team valueOf(int season, int value) {
        switch (season) {
            case 2020:
                return Team2020.valueOf(value);
            case 2021:
                return Team2021.valueOf(value);
            case 2022:
                return Team2022.valueOf(value);
            default:
                throw new IllegalArgumentException("Season season " + season + " not supported");
        }
    }

    int getValue();

    String name();

    /**
     * Team 2020
     */
    enum Team2020 implements Team {
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

        private static Map<Integer, Team2020> map = new HashMap<>();

        static {
            for (Team2020 team : Team2020.values()) {
                map.put(team.value, team);
            }
        }

        private int value;

        Team2020(int value) {
            this.value = value;
        }

        public static Team2020 valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Team 2021
     */
    enum Team2021 implements Team {
        MERCEDES(0),
        FERRARI(1),
        RED_BULL_RACING(2),
        WILLIAMS(3),
        ASTON_MARTIN(4),
        ALPINE(5),
        ALPHA_TAURI(6),
        HAAS(7),
        MCLAREN(8),
        ALFA_ROMEO(9),
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
        ART_GP_20(70),
        CAMPOS_20(71),
        CARLIN_20(72),
        CHAROUZ_20(73),
        DAMS_20(74),
        UNI_VIRTUOSI_20(75),
        MP_MOTORSPORT_20(76),
        PREMA_20(77),
        TRIDENT_20(78),
        BWT_20(79),
        HITECH_20(80),
        MERCEDES_2020(85),
        FERRARI_2020(86),
        RED_BULL_2020(87),
        WILLIAMS_2020(88),
        RACING_POINT_2020(89),
        RENAULT_2020(90),
        ALPHA_TAURI_2020(91),
        HAAS_2020(92),
        MCLAREN_2020(93),
        ALFA_ROMEO_2020(94),
        PREMA_21(106),
        UNI_VIRTUOSI_21(107),
        CARLIN_21(108),
        HITECH_21(109),
        ART_GP_21(110),
        MP_MOTORSPORT_21(111),
        CHAROUZ_21(112),
        DAMS_21(113),
        CAMPOS_21(114),
        BWT_21(115),
        TRIDENT_21(116);

        private static Map<Integer, Team2021> map = new HashMap<>();

        static {
            for (Team2021 team : Team2021.values()) {
                map.put(team.value, team);
            }
        }

        private int value;

        Team2021(int value) {
            this.value = value;
        }

        public static Team2021 valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Team 2022
     */
    enum Team2022 implements Team {
        MERCEDES(0),
        FERRARI(1),
        RED_BULL_RACING(2),
        WILLIAMS(3),
        ASTON_MARTIN(4),
        ALPINE(5),
        ALPHA_TAURI(6),
        HAAS(7),
        MCLAREN(8),
        ALFA_ROMEO(9),
        MERCEDES_2020(85),
        FERRARI_2020(86),
        RED_BULL_2020(87),
        WILLIAMS_2020(88),
        RACING_POINT_2020(89),
        RENAULT_2020(90),
        ALPHA_TAURI_2020(91),
        HAAS_2020(92),
        MCLAREN_2020(93),
        ALFA_ROMEO_2020(94),
        ASTON_MARTIN_DB11_V12(95),
        ASTON_MARTIN_VANTAGE_F1_EDITION(96),
        ASTON_MARTIN_VAMTAGE_SAFETY_CAR(97),
        FERRARI_F8_TRIBUTO(98),
        FERRARI_ROMA(99),
        MCLAREN_720S(100),
        MCLAREN_ARTURA(101),
        MERCEDES_AMG_GT_BLACK_SERIES_SAFETY_CAR(102),
        MERCEDES_AMG_GTR_PRO(103),
        F1_CUSTOM_TEAM(104),
        PREMA_21(106),
        UNI_VIRTUOSI_21(107),
        CARLIN_21(108),
        HITECH_21(109),
        ART_GP_21(110),
        MP_MOTORSPORT_21(111),
        CHAROUZ_21(112),
        DAMS_21(113),
        CAMPOS_21(114),
        BWT_21(115),
        TRIDENT_21(116),
        MERCEDES_AMG_GT_BLACK_SERIES(117);

        private static Map<Integer, Team2022> map = new HashMap<>();

        static {
            for (Team2022 team : Team2022.values()) {
                map.put(team.value, team);
            }
        }

        private int value;

        Team2022(int value) {
            this.value = value;
        }

        public static Team2022 valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }
}

