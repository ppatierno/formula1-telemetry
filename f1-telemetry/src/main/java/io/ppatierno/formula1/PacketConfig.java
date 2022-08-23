/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

public abstract class PacketConfig {

    private static final String F1_TELEMETRY_SEASON_ENV_VAR = "F1_TELEMETRY_SEASON";

    private static final String DEFAULT_F1_TELEMETRY_SEASON = "2020";

    /**
     * @return Formula 1 season for getting teams, drivers, tracks accordingly
     */
    public static int getSeason() {
        return Integer.parseInt(System.getenv().getOrDefault(F1_TELEMETRY_SEASON_ENV_VAR, DEFAULT_F1_TELEMETRY_SEASON));
    }
}
