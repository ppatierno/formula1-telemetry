/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.data;

public class EventDataDetails {

    public static final int SIZE = 7;

    private FastestLap fastestLap;
    private Retirement retirement;
    private TeamMateInPits teamMateInPits;
    private RaceWinner raceWinner;
    private Penalty penalty;
    private SpeedTrap speedTrap;

    /**
     * @return Fastest lap
     */
    public FastestLap getFastestLap() {
        return fastestLap;
    }

    public void setFastestLap(FastestLap fastestLap) {
        this.fastestLap = fastestLap;
    }

    /**
     * @return Retirement
     */
    public Retirement getRetirement() {
        return retirement;
    }

    public void setRetirement(Retirement retirement) {
        this.retirement = retirement;
    }

    /**
     * @return Teammate in pits
     */
    public TeamMateInPits getTeamMateInPits() {
        return teamMateInPits;
    }

    public void setTeamMateInPits(TeamMateInPits teamMateInPits) {
        this.teamMateInPits = teamMateInPits;
    }

    /**
     * @return Race winner
     */
    public RaceWinner getRaceWinner() {
        return raceWinner;
    }

    public void setRaceWinner(RaceWinner raceWinner) {
        this.raceWinner = raceWinner;
    }

    /**
     * @return Penalty
     */
    public Penalty getPenalty() {
        return penalty;
    }

    public void setPenalty(Penalty penalty) {
        this.penalty = penalty;
    }

    /**
     * @return Speed trap
     */
    public SpeedTrap getSpeedTrap() {
        return speedTrap;
    }

    public void setSpeedTrap(SpeedTrap speedTrap) {
        this.speedTrap = speedTrap;
    }

    @Override
    public String toString() {
        return "EventDataDetails[fastestLap=" + this.fastestLap +
                ",retirement=" + this.retirement +
                ",teamMateInPits=" + this.teamMateInPits +
                ",raceWinner=" + this.raceWinner +
                ",penalty=" + this.penalty +
                ",speedTrap=" + this.speedTrap +
                "]";
    }
}


