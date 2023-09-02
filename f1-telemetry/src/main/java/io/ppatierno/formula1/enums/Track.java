/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

public interface Track {

    static Track valueOf(int season, int value) {
        switch (season) {
            case 2020:
                return Track2020.valueOf(value);
            case 2021:
                return Track2021.valueOf(value);
            case 2022:
                return Track2022.valueOf(value);
            default:
                throw new IllegalArgumentException("Season season " + season + " not supported");
        }
    }

    int getValue();

    String name();

    /**
     * Track 2020
     */
    enum Track2020 implements Track {
        MELBOURNE(0),
        PAUL_RICARD(1),
        SHANGHAI(2),
        SAKHIR_BAHRAIN(3),
        CATALUNYA(4),
        MONACO(5),
        MONTREAL(6),
        SILVERSTONE(7),
        HOCKENHEIM(8),
        HUNGARORING(9),
        SPA(10),
        MONZA(11),
        SINGAPORE(12),
        SUZUKA(13),
        ABU_DHABI(14),
        TEXAS(15),
        BRAZIL(16),
        AUSTRIA(17),
        SOCHI(18),
        MEXICO(19),
        BAKU_AZERBAIJAN(20),
        SAKHIR_SHORT(21),
        SILVERSTONE_SHORT(22),
        TEXAS_SHORT(23),
        SUZUKA_SHORT(24),
        HANOI(25),
        ZANDVOORT(26);

        private static Map<Integer, Track2020> map = new HashMap<>();

        static {
            for (Track2020 track : Track2020.values()) {
                map.put(track.value, track);
            }
        }

        private int value;

        Track2020(int value) {
            this.value = value;
        }

        public static Track2020 valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Track 2021
     */
    enum Track2021 implements Track {
        MELBOURNE(0),
        PAUL_RICARD(1),
        SHANGHAI(2),
        SAKHIR_BAHRAIN(3),
        CATALUNYA(4),
        MONACO(5),
        MONTREAL(6),
        SILVERSTONE(7),
        HOCKENHEIM(8),
        HUNGARORING(9),
        SPA(10),
        MONZA(11),
        SINGAPORE(12),
        SUZUKA(13),
        ABU_DHABI(14),
        TEXAS(15),
        BRAZIL(16),
        AUSTRIA(17),
        SOCHI(18),
        MEXICO(19),
        BAKU_AZERBAIJAN(20),
        SAKHIR_SHORT(21),
        SILVERSTONE_SHORT(22),
        TEXAS_SHORT(23),
        SUZUKA_SHORT(24),
        HANOI(25),
        ZANDVOORT(26),
        IMOLA(27),
        PORTIMÃO(28),
        JEDDAH(29);

        private static Map<Integer, Track2021> map = new HashMap<>();

        static {
            for (Track2021 track : Track2021.values()) {
                map.put(track.value, track);
            }
        }

        private int value;

        Track2021(int value) {
            this.value = value;
        }

        public static Track2021 valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Track 2022
     */
    enum Track2022 implements Track {
        MELBOURNE(0),
        PAUL_RICARD(1),
        SHANGHAI(2),
        SAKHIR_BAHRAIN(3),
        CATALUNYA(4),
        MONACO(5),
        MONTREAL(6),
        SILVERSTONE(7),
        HOCKENHEIM(8),
        HUNGARORING(9),
        SPA(10),
        MONZA(11),
        SINGAPORE(12),
        SUZUKA(13),
        ABU_DHABI(14),
        TEXAS(15),
        BRAZIL(16),
        AUSTRIA(17),
        SOCHI(18),
        MEXICO(19),
        BAKU_AZERBAIJAN(20),
        SAKHIR_SHORT(21),
        SILVERSTONE_SHORT(22),
        TEXAS_SHORT(23),
        SUZUKA_SHORT(24),
        HANOI(25),
        ZANDVOORT(26),
        IMOLA(27),
        PORTIMÃO(28),
        JEDDAH(29),
        MIAMI(30);

        private static Map<Integer, Track2022> map = new HashMap<>();

        static {
            for (Track2022 track : Track2022.values()) {
                map.put(track.value, track);
            }
        }

        private int value;

        Track2022(int value) {
            this.value = value;
        }

        public static Track2022 valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }
}