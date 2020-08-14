/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import java.util.HashMap;
import java.util.Map;

/**
 * Driver
 */
public enum Driver {
    CARLOS_SAINZ(0),
    DANIIL_KVYAT(1),
    DANIEL_RICCIARDO(2),
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

    private static Map<Integer, Driver> map = new HashMap<>();

    static {
        for (Driver driver : Driver.values()) {
            map.put(driver.value, driver);
        }
    }

    private int value;
    
    private Driver(int value) {
        this.value = value;
    }

    public static Driver valueOf(int value) {
        return (Driver) map.get(value);
    }
}