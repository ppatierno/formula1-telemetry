/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.enums;

import java.util.HashMap;
import java.util.Map;

/**
 * Nationality
 */
public enum Nationality {
    USA(1),
    ARGENTINA(2),
    AUSTRALIA(3),
    AUSTRIA(4),
    AZERBAIJAN(5),
    BAHRAIN(6),
    BELGIUM(7),
    BOLIVIA(8),
    BRAZIL(9),
    UK(10),
    BULGARIA(11),
    CAMEROON(12),
    CANADA(13),
    CHILE(14),
    CHINA(15),
    COLOMBIA(16),
    COSTA_RICA(17),
    CROATIA(18),
    CYPRUS(19),
    CZECHIA(20),
    DANMARK(21),
    NETHERLANDS(22),
    ECUADOR(23),
    ENGLAND(24),
    EMIRATES(25),
    ESTONIA(26),
    FINLAND(27),
    FRANCE(28),
    GERMANY(29),
    GHANA(30),
    GREECE(31),
    GUATEMALA(32),
    HONDURAS(33),
    HONK_KONG(34),
    HUNGARY(35),
    ICELAND(36),
    INDIA(37),
    INDONESIA(38),
    IRELAND(39),
    ISRAEL(40),
    ITALY(41),
    JAMAICA(42),
    JAPAN(43),
    JORDAN(44),
    KUWAIT(45),
    LATVIA(46),
    LEBANON(47),
    LITHUANIA(48),
    LUXEMBOURG(49),
    MALAYSIA(50),
    MALTA(51),
    MEXICO(52),
    MONACO(53),
    NEW_ZEALAND(54),
    NICARAGUA(55),
    NORTH_KOREA(56),
    NORTHERN_IRELAND(57),
    NORWAY(58),
    OMAN(59),
    PAKISTAN(60),
    PANAMA(61),
    PARAGUAY(62),
    PERU(63),
    POLAND(64),
    PORTUGAL(65),
    QATAR(66),
    ROMANIA(67),
    RUSSIA(68),
    EL_SALVADOR(69),
    SAUDI_ARABIA(70),
    SCOTLAND(71),
    SERBIA(72),
    SINGAPORE(73),
    SLOVAKIA(74),
    SLOVENIA(75),
    SOUTH_KOREA(76),
    SOUTH_AFRICA(77),
    SPAIN(78),
    SWEDEN(79),
    SWITZERLAND(80),
    THAILAND(81),
    TURKEY(82),
    URUGUAY(83),
    UKRAINE(84),
    VENEZUELA(85),
    WALES(86),
    BARBADOS(87),
    VIETNAM(88);

    private static Map<Integer, Nationality> map = new HashMap<>();

    static {
        for (Nationality nationality : Nationality.values()) {
            map.put(nationality.value, nationality);
        }
    }

    private int value;
    
    Nationality(int value) {
        this.value = value;
    }

    public static Nationality valueOf(int value) {
        return map.get(value);
    }
}