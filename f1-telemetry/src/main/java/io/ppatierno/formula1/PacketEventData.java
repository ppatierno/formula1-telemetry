/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import io.netty.buffer.ByteBuf;

/**
 * Event Packet
 * 
 * This packet gives details of events that happen during the course of a
 * session.
 */
public class PacketEventData extends Packet {
    
    private EventCode eventCode;
    private EventDataDetails eventDataDetails = new EventDataDetails();

    /**
     * @return Event code
     */
    public EventCode getEventCode() {
        return eventCode;
    }

    public void setEventCode(EventCode eventCode) {
        this.eventCode = eventCode;
    }

    /**
     * @return Event details 
     */
    public EventDataDetails getEventDataDetails() {
        return eventDataDetails;
    }

    public void setEventDataDetails(EventDataDetails eventDataDetails) {
        this.eventDataDetails = eventDataDetails;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("EventData[");
        sb.append(super.toString());
        sb.append(",eventStringCode=" +  this.eventCode);
        sb.append(",eventDataDetails=" + this.eventDataDetails);
        sb.append("]");
        return sb.toString();
    }

    @Override
    public Packet fill(ByteBuf buffer) {
        super.fill(buffer);
        this.eventCode = EventCode.valueFrom(PacketUtils.readString(buffer, 4));
        switch (this.eventCode) {
            case SESSION_STARTED:
                break;
            case SESSION_ENDED:
                break;
            case FASTEST_LAP:
                FastestLap fl = new FastestLap();
                fl.setVehicleIdx(buffer.readUnsignedByte());
                fl.setLapTime(buffer.readFloatLE());
                this.eventDataDetails.setFastestLap(fl);
                break;
            case RETIREMENT:
                Retirement r = new Retirement();
                r.setVehicleIdx(buffer.readUnsignedByte());
                this.eventDataDetails.setRetirement(r);
                break;
            case DRS_ENABLED:
                break;
            case DRS_DISABLED:
                break;
            case TEAM_MATE_IN_PITS:
                TeamMateInPits tmip = new TeamMateInPits();
                tmip.setVehicleIdx(buffer.readUnsignedByte());
                this.eventDataDetails.setTeamMateInPits(tmip);
                break;
            case CHEQUERED_FLAG:
                break;
            case RACE_WINNER:
                RaceWinner rw = new RaceWinner();
                rw.setVehicleIdx(buffer.readUnsignedByte());
                this.eventDataDetails.setRaceWinner(rw);
                break;
            case PENALTY_ISSUED:
                Penalty p = new Penalty();
                p.setPenaltyType(PenaltyType.valueOf(buffer.readUnsignedByte()));
                p.setInfringementType(InfringementType.valueOf(buffer.readUnsignedByte()));
                p.setVehicleIdx(buffer.readUnsignedByte());
                p.setOtherVehicleIdx(buffer.readUnsignedByte());
                p.setTime(buffer.readUnsignedByte());
                p.setLapNum(buffer.readUnsignedByte());
                p.setPlacesGained(buffer.readUnsignedByte());
                this.eventDataDetails.setPenalty(p);
                break;
            case SPEED_TRAP_TRIGGERED:
                SpeedTrap st = new SpeedTrap();
                st.setVehicleIdx(buffer.readUnsignedByte());
                st.setSpeed(buffer.readFloatLE());
                this.eventDataDetails.setSpeedTrap(st);
                break;
        }
        return this;
    }

    class EventDataDetails {

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

    class FastestLap {

        private short vehicleIdx;
        private float lapTime;

        /**
         * @return Vehicle index of car achieving fastest lap
         */
        public short getVehicleIdx() {
            return vehicleIdx;
        }

        public void setVehicleIdx(short vehicleIdx) {
            this.vehicleIdx = vehicleIdx;
        }

        /**
         * @return Lap time is in seconds
         */
        public float getLapTime() {
            return lapTime;
        }

        public void setLapTime(float lapTime) {
            this.lapTime = lapTime;
        }
        
        @Override
        public String toString() {
            return "FastestLap[vehicleIdx=" + this.vehicleIdx +
                    ",lapTime=" + this.lapTime +
                    "]";
        }
    }

    class Retirement {

        private short vehicleIdx;

        /**
         * @return Vehicle index of car retiring
         */
        public short getVehicleIdx() {
            return vehicleIdx;
        }

        public void setVehicleIdx(short vehicleIdx) {
            this.vehicleIdx = vehicleIdx;
        }

        @Override
        public String toString() {
            return "Retirement[vehicleIdx=" + this.vehicleIdx +
                    "]";
        }
    }

    class TeamMateInPits {

        private short vehicleIdx;

        /**
         * @return Vehicle index of team mate
         */
        public short getVehicleIdx() {
            return vehicleIdx;
        }

        public void setVehicleIdx(short vehicleIdx) {
            this.vehicleIdx = vehicleIdx;
        }

        @Override
        public String toString() {
            return "TeamMateInPits[vehicleIdx=" + this.vehicleIdx +
                    "]";
        }
    }

    class RaceWinner {

        private short vehicleIdx;

        /**
         * @return Vehicle index of the race winner
         */
        public short getVehicleIdx() {
            return vehicleIdx;
        }

        public void setVehicleIdx(short vehicleIdx) {
            this.vehicleIdx = vehicleIdx;
        }

        @Override
        public String toString() {
            return "RaceWinner[vehicleIdx=" + this.vehicleIdx +
                    "]";
        }
    }

    class Penalty {

        private PenaltyType penaltyType;
        private InfringementType infringementType;
        private short vehicleIdx;
        private short otherVehicleIdx;
        private short time;
        private short lapNum;
        private short placesGained;

        /**
         * @return Penalty type
         */
        public PenaltyType getPenaltyType() {
            return penaltyType;
        }

        public void setPenaltyType(PenaltyType penaltyType) {
            this.penaltyType = penaltyType;
        }

        /**
         * @return Infringement type
         */
        public InfringementType getInfringementType() {
            return infringementType;
        }

        public void setInfringementType(InfringementType infringementType) {
            this.infringementType = infringementType;
        }

        /**
         * @return Vehicle index of the car the penalty is applied to
         */
        public short getVehicleIdx() {
            return vehicleIdx;
        }

        public void setVehicleIdx(short vehicleIdx) {
            this.vehicleIdx = vehicleIdx;
        }

        /**
         * @return Vehicle index of the other car involved
         */
        public short getOtherVehicleIdx() {
            return otherVehicleIdx;
        }

        public void setOtherVehicleIdx(short otherVehicleIdx) {
            this.otherVehicleIdx = otherVehicleIdx;
        }

        /**
         * @return Time gained, or time spent doing action in seconds
         */
        public short getTime() {
            return time;
        }

        public void setTime(short time) {
            this.time = time;
        }

        /**
         * @return Lap the penalty occurred on
         */
        public short getLapNum() {
            return lapNum;
        }

        public void setLapNum(short lapNum) {
            this.lapNum = lapNum;
        }

        /**
         * @return Number of places gained by this
         */
        public short getPlacesGained() {
            return placesGained;
        }

        public void setPlacesGained(short placesGained) {
            this.placesGained = placesGained;
        }

        @Override
        public String toString() {
            return "Penalty[penaltyType=" + this.penaltyType +
                    ",infringementType=" + this.infringementType +
                    ",vehicleIdx=" + this.vehicleIdx +
                    ",otherVehicleIdx=" + this.otherVehicleIdx +
                    ",time=" + this.time +
                    ",lapNum=" + this.lapNum +
                    ",placesGained=" + this.placesGained +
                    "]";
        }
    }

    class SpeedTrap {

        private short vehicleIdx;
        private float speed;

        /**
         * @return Vehicle index of the vehicle triggering speed trap
         */
        public short getVehicleIdx() {
            return vehicleIdx;
        }

        public void setVehicleIdx(short vehicleIdx) {
            this.vehicleIdx = vehicleIdx;
        }

        /**
         * @return Top speed achieved in kilometres per hour
         */
        public float getSpeed() {
            return speed;
        }

        public void setSpeed(float speed) {
            this.speed = speed;
        }
        
        @Override
        public String toString() {
            return "SpeedTrap[vehicleIdx=" + this.vehicleIdx +
                    ",speed=" + this.speed +
                    "]";
        }
    }
}