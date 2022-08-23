/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

public interface Driver {

    static Driver valueOf(int season, int value) {
        switch (season) {
            case 2020:
                return Driver2020.valueOf(value);
            case 2021:
                return Driver2021.valueOf(value);
            case 2022:
                return Driver2022.valueOf(value);
            default:
                throw new IllegalArgumentException("Season season " + season + " not supported");
        }
    }

    int getValue();

    String name();

    /**
     * Driver 2020
     */
    enum Driver2020 implements Driver {
        CARLOS_SAINZ(0),
        DANIIL_KVYAT(1),
        DANIEL_RICCIARDO(2),
        KIMI_RAIKKONEN(6),
        LEWIS_HAMILTON(7),
        MAX_VERSTAPPEN(9),
        NICO_HULKENBERG(10),
        KEVIN_MAGNUSSEN(11),
        ROMAIN_GROSJEAN(12),
        SEBASTIAN_VETTEL(13),
        SERGIO_PEREZ(14),
        VALTTERI_BOTTAS(15),
        ESTEBAN_OCON(17),
        LANCE_STROLL(19),
        ARRON_BARNES(20),
        MARTIN_GILES(21),
        ALEX_MURRAY(22),
        LUCAS_ROTH(23),
        IGOR_CORREIA(24),
        SOPHIE_LEVASSEUR(25),
        JONAS_SCHIFFER(26),
        ALAIN_FOREST(27),
        JAY_LETOURNEAU(28),
        ESTO_SAARI(29),
        YASAR_ATIYEH(30),
        CALLISTO_CALABRESI(31),
        NAOTA_IZUM(32),
        HOWARD_CLARKE(33),
        WILHEIM_KAUFMANN(34),
        MARIE_LAURSEN(35),
        FLAVIO_NIEVES(36),
        PETER_BELOUSOV(37),
        KLIMEK_MICHALSKI(38),
        SANTIAGO_MORENO(39),
        BENJAMIN_COPPENS(40),
        NOAH_VISSER(41),
        GERT_WALDMULLER(42),
        JULIAN_QUESADA(43),
        DANIEL_JONES(44),
        ARTEM_MARKELOV(45),
        TADASUKE_MAKINO(46),
        SEAN_GELAEL(47),
        NYCK_DE_VRIES(48),
        JACK_AITKEN(49),
        GEORGE_RUSSELL(50),
        MAXIMILIAN_GUNTHER(51),
        NIREI_FUKUZUMI(52),
        LUCA_GHIOTTO(53),
        LANDO_NORRIS(54),
        SERGIO_SETTE_CAMARA(55),
        LOUIS_DELETRAZ(56),
        ANTONIO_FUOCO(57),
        CHARLES_LECLERC(58),
        PIERRE_GASLY(59),
        ALEXANDER_ALBON(62),
        NICHOLAS_LATIFI(63),
        DORIAN_BOCCOLACCI(64),
        NIKO_KARI(65),
        ROBERTO_MERHI(66),
        ARJUN_MAINI(67),
        ALESSIO_LORANDI(68),
        RUBEN_MEIJER(69),
        RASHID_NAIR(70),
        JACK_TREMBLAY(71),
        ANTONIO_GIOVINAZZI(74),
        ROBERT_KUBICA(75),
        NOBUHARU_MATSUSHITA(78),
        NIKITA_MAZEPIN(79),
        GUANYA_ZHOU(80),
        MICK_SHUMACHER(81),
        CALLUM_ILOTT(82),
        JUAN_MANUEL_CORREA(83),
        JORDAN_KING(84),
        MAHAVEER_RAGHUNATHAN(85),
        TATIANA_CALDERON(86),
        ANTHOINE_HUBERT(87),
        GUILIANO_ALESI(88),
        RALPH_BOSCHUNG(89);

        private static Map<Integer, Driver2020> map = new HashMap<>();

        static {
            for (Driver2020 driver : Driver2020.values()) {
                map.put(driver.value, driver);
            }
        }

        private int value;

        Driver2020(int value) {
            this.value = value;
        }

        public static Driver2020 valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Driver 2021
     */
    enum Driver2021 implements Driver {
        CARLOS_SAINZ(0),
        DANIIL_KVYAT(1),
        DANIEL_RICCIARDO(2),
        FERNANDO_ALONSO(3),
        FELIPE_MASSA(4),
        KIMI_RAIKKONEN(6),
        LEWIS_HAMILTON(7),
        MAX_VERSTAPPEN(9),
        NICO_HULKENBURG(10),
        KEVIN_MAGNUSSEN(11),
        ROMAIN_GROSJEAN(12),
        SEBASTIAN_VETTEL(13),
        SERGIO_PEREZ(14),
        VALTTERI_BOTTAS(15),
        ESTEBAN_OCON(17),
        LANCE_STROLL(19),
        ARRON_BARNES(20),
        MARTIN_GILES(21),
        ALEX_MURRAY(22),
        LUCAS_ROTH(23),
        IGOR_CORREIA(24),
        SOPHIE_LEVASSEUR(25),
        JONAS_SCHIFFER(26),
        ALAIN_FOREST(27),
        JAY_LETOURNEAU(28),
        ESTO_SAARI(29),
        YASAR_ATIYEH(30),
        CALLISTO_CALABRESI(31),
        NAOTA_IZUM(32),
        HOWARD_CLARKE(33),
        WILHEIM_KAUFMANN(34),
        MARIE_LAURSEN(35),
        FLAVIO_NIEVES(36),
        PETER_BELOUSOV(37),
        KLIMEK_MICHALSKI(38),
        SANTIAGO_MORENO(39),
        BENJAMIN_COPPENS(40),
        NOAH_VISSER(41),
        GERT_WALDMULLER(42),
        JULIAN_QUESADA(43),
        DANIEL_JONES(44),
        ARTEM_MARKELOV(45),
        TADASUKE_MAKINO(46),
        SEAN_GELAEL(47),
        NYCK_DE_VRIES(48),
        JACK_AITKEN(49),
        GEORGE_RUSSELL(50),
        MAXIMILIAN_GÜNTHER(51),
        NIREI_FUKUZUMI(52),
        LUCA_GHIOTTO(53),
        LANDO_NORRIS(54),
        SÉRGIO_SETTE_CÂMARA(55),
        LOUIS_DELÉTRAZ(56),
        ANTONIO_FUOCO(57),
        CHARLES_LECLERC(58),
        PIERRE_GASLY(59),
        ALEXANDER_ALBON(62),
        NICHOLAS_LATIFI(63),
        DORIAN_BOCCOLACCI(64),
        NIKO_KARI(65),
        ROBERTO_MERHI(66),
        ARJUN_MAINI(67),
        ALESSIO_LORANDI(68),
        RUBEN_MEIJER(69),
        RASHID_NAIR(70),
        JACK_TREMBLAY(71),
        DEVON_BUTLER(72),
        LUKAS_WEBER(73),
        ANTONIO_GIOVINAZZI(74),
        ROBERT_KUBICA(75),
        ALAIN_PROST(76),
        AYRTON_SENNA(77),
        NOBUHARU_MATSUSHITA(78),
        NIKITA_MAZEPIN(79),
        GUANYA_ZHOU(80),
        MICK_SCHUMACHER(81),
        CALLUM_ILOTT(82),
        JUAN_MANUEL_CORREA(83),
        JORDAN_KING(84),
        MAHAVEER_RAGHUNATHAN(85),
        TATIANA_CALDERON(86),
        ANTHOINE_HUBERT(87),
        GUILIANO_ALESI(88),
        RALPH_BOSCHUNG(89),
        MICHAEL_SCHUMACHER(90),
        DAN_TICKTUM(91),
        MARCUS_ARMSTRONG(92),
        CHRISTIAN_LUNDGAARD(93),
        YUKI_TSUNODA(94),
        JEHAN_DARUVALA(95),
        GULHERME_SAMAIA(96),
        PEDRO_PIQUET(97),
        FELIPE_DRUGOVICH(98),
        ROBERT_SCHWARTZMAN(99),
        ROY_NISSANY(100),
        MARINO_SATO(101),
        AIDAN_JACKSON(102),
        CASPER_AKKERMAN(103),
        JENSON_BUTTON(109),
        DAVID_COULTHARD(110),
        NICO_ROSBERG(111),
        OSCAR_PIASTRI(112),
        LIAM_LAWSON(113),
        JURI_VIPS(114),
        THEO_POURCHAIRE(115),
        RICHARD_VERSCHOOR(116),
        LIRIM_ZENDELI(117),
        DAVID_BECKMANN(118),
        GIANLUCA_PETECOF(119),
        MATTEO_NANNINI(120),
        ALESSIO_DELEDDA(121),
        BENT_VISCAAL(122),
        ENZO_FITTIPALDI(123);

        private static Map<Integer, Driver2021> map = new HashMap<>();

        static {
            for (Driver2021 driver : Driver2021.values()) {
                map.put(driver.value, driver);
            }
        }

        private int value;

        Driver2021(int value) {
            this.value = value;
        }

        public static Driver2021 valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }

    /**
     * Driver 2022
     */
    enum Driver2022 implements Driver {
        CARLOS_SAINZ(0),
        DANIIL_KVYAT(1),
        DANIEL_RICCIARDO(2),
        FERNANDO_ALONSO(3),
        FELIPE_MASSA(4),
        KIMI_RAIKKONEN(6),
        LEWIS_HAMILTON(7),
        MAX_VERSTAPPEN(9),
        NICO_HULKENBURG(10),
        KEVIN_MAGNUSSEN(11),
        ROMAIN_GROSJEAN(12),
        SEBASTIAN_VETTEL(13),
        SERGIO_PEREZ(14),
        VALTTERI_BOTTAS(15),
        ESTEBAN_OCON(17),
        LANCE_STROLL(19),
        ARRON_BARNES(20),
        MARTIN_GILES(21),
        ALEX_MURRAY(22),
        LUCAS_ROTH(23),
        IGOR_CORREIA(24),
        SOPHIE_LEVASSEUR(25),
        JONAS_SCHIFFER(26),
        ALAIN_FOREST(27),
        JAY_LETOURNEAU(28),
        ESTO_SAARI(29),
        YASAR_ATIYEH(30),
        CALLISTO_CALABRESI(31),
        NAOTA_IZUM(32),
        HOWARD_CLARKE(33),
        WILHEIM_KAUFMANN(34),
        MARIE_LAURSEN(35),
        FLAVIO_NIEVES(36),
        PETER_BELOUSOV(37),
        KLIMEK_MICHALSKI(38),
        SANTIAGO_MORENO(39),
        BENJAMIN_COPPENS(40),
        NOAH_VISSER(41),
        GERT_WALDMULLER(42),
        JULIAN_QUESADA(43),
        DANIEL_JONES(44),
        ARTEM_MARKELOV(45),
        TADASUKE_MAKINO(46),
        SEAN_GELAEL(47),
        NYCK_DE_VRIES(48),
        JACK_AITKEN(49),
        GEORGE_RUSSELL(50),
        MAXIMILIAN_GÜNTHER(51),
        NIREI_FUKUZUMI(52),
        LUCA_GHIOTTO(53),
        LANDO_NORRIS(54),
        SÉRGIO_SETTE_CÂMARA(55),
        LOUIS_DELÉTRAZ(56),
        ANTONIO_FUOCO(57),
        CHARLES_LECLERC(58),
        PIERRE_GASLY(59),
        ALEXANDER_ALBON(62),
        NICHOLAS_LATIFI(63),
        DORIAN_BOCCOLACCI(64),
        NIKO_KARI(65),
        ROBERTO_MERHI(66),
        ARJUN_MAINI(67),
        ALESSIO_LORANDI(68),
        RUBEN_MEIJER(69),
        RASHID_NAIR(70),
        JACK_TREMBLAY(71),
        DEVON_BUTLER(72),
        LUKAS_WEBER(73),
        ANTONIO_GIOVINAZZI(74),
        ROBERT_KUBICA(75),
        ALAIN_PROST(76),
        AYRTON_SENNA(77),
        NOBUHARU_MATSUSHITA(78),
        NIKITA_MAZEPIN(79),
        GUANYA_ZHOU(80),
        MICK_SCHUMACHER(81),
        CALLUM_ILOTT(82),
        JUAN_MANUEL_CORREA(83),
        JORDAN_KING(84),
        MAHAVEER_RAGHUNATHAN(85),
        TATIANA_CALDERON(86),
        ANTHOINE_HUBERT(87),
        GUILIANO_ALESI(88),
        RALPH_BOSCHUNG(89),
        MICHAEL_SCHUMACHER(90),
        DAN_TICKTUM(91),
        MARCUS_ARMSTRONG(92),
        CHRISTIAN_LUNDGAARD(93),
        YUKI_TSUNODA(94),
        JEHAN_DARUVALA(95),
        GULHERME_SAMAIA(96),
        PEDRO_PIQUET(97),
        FELIPE_DRUGOVICH(98),
        ROBERT_SCHWARTZMAN(99),
        ROY_NISSANY(100),
        MARINO_SATO(101),
        AIDAN_JACKSON(102),
        CASPER_AKKERMAN(103),
        JENSON_BUTTON(109),
        DAVID_COULTHARD(110),
        NICO_ROSBERG(111),
        OSCAR_PIASTRI(112),
        LIAM_LAWSON(113),
        JURI_VIPS(114),
        THEO_POURCHAIRE(115),
        RICHARD_VERSCHOOR(116),
        LIRIM_ZENDELI(117),
        DAVID_BECKMANN(118),
        ALESSIO_DELEDDA(121),
        BENT_VISCAAL(122),
        ENZO_FITTIPALDI(123),
        MARK_WEBBER(125),
        JACQUES_VILLENEUVE(126);

        private static Map<Integer, Driver2022> map = new HashMap<>();

        static {
            for (Driver2022 driver : Driver2022.values()) {
                map.put(driver.value, driver);
            }
        }

        private int value;

        Driver2022(int value) {
            this.value = value;
        }

        public static Driver2022 valueOf(int value) {
            return map.get(value);
        }

        public int getValue() {
            return value;
        }
    }
}