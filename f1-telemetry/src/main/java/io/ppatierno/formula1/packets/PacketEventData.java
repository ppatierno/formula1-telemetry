/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketUtils;
import io.ppatierno.formula1.enums.EventCode;
import io.ppatierno.formula1.enums.InfringementType;
import io.ppatierno.formula1.enums.PenaltyType;

/**
 * Event Packet
 * 
 * This packet gives details of events that happen during the course of a session.
 * Frequency: When the event occurs
 */
public class PacketEventData extends Packet {

    public static final int SIZE = 35;
    
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
        StringBuilder sb = new StringBuilder("Event[");
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
                this.eventDataDetails.setFastestLap(fl.fill(buffer));
                break;
            case RETIREMENT:
                Retirement r = new Retirement();
                this.eventDataDetails.setRetirement(r.fill(buffer));
                break;
            case DRS_ENABLED:
                break;
            case DRS_DISABLED:
                break;
            case TEAM_MATE_IN_PITS:
                TeamMateInPits tmip = new TeamMateInPits();
                this.eventDataDetails.setTeamMateInPits(tmip.fill(buffer));
                break;
            case CHEQUERED_FLAG:
                break;
            case RACE_WINNER:
                RaceWinner rw = new RaceWinner();
                this.eventDataDetails.setRaceWinner(rw.fill(buffer));
                break;
            case PENALTY_ISSUED:
                Penalty p = new Penalty();
                this.eventDataDetails.setPenalty(p.fill(buffer));
                break;
            case SPEED_TRAP_TRIGGERED:
                SpeedTrap st = new SpeedTrap();
                this.eventDataDetails.setSpeedTrap(st.fill(buffer));
                break;
            default:
                throw new IllegalArgumentException("EventCode=" + this.eventCode + " not supported");
        }
        return this;
    }

    @Override
    public ByteBuf fillBuffer(ByteBuf buffer) {
        super.fillBuffer(buffer);
        PacketUtils.writeString(this.eventCode.getValue(), buffer, 4);
        switch (this.eventCode) {
            case SESSION_STARTED:
                break;
            case SESSION_ENDED:
                break;
            case FASTEST_LAP:
                this.eventDataDetails.getFastestLap().fillBuffer(buffer);
                break;
            case RETIREMENT:
                this.eventDataDetails.getRetirement().fillBuffer(buffer);
                break;
            case DRS_ENABLED:
                break;
            case DRS_DISABLED:
                break;
            case TEAM_MATE_IN_PITS:
                this.eventDataDetails.getTeamMateInPits().fillBuffer(buffer);
                break;
            case CHEQUERED_FLAG:
                break;
            case RACE_WINNER:
                this.eventDataDetails.getRaceWinner().fillBuffer(buffer);
                break;
            case PENALTY_ISSUED:
                this.eventDataDetails.getPenalty().fillBuffer(buffer);
                break;
            case SPEED_TRAP_TRIGGERED:
                this.eventDataDetails.getSpeedTrap().fillBuffer(buffer);
                break;
            default:
                throw new IllegalArgumentException("EventCode=" + this.eventCode + " not supported");
        }
        return buffer;
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

    public class FastestLap {

        private short vehicleIdx;
        private float lapTime;

        /**
         * Fill the current FastestLap with the raw bytes representation
         * 
         * @param buffer buffer with the raw bytes representation
         * @return current filled FastestLap instance
         */
        public FastestLap fill(ByteBuf buffer) {
            this.vehicleIdx = buffer.readUnsignedByte();
            this.lapTime = buffer.readFloatLE();
            return this;
        }

        /**
         * Fill the buffer with the raw bytes representation of the current FastestLap instance
         * 
         * @param buffer buffer to fill
         * @return filled buffer
         */
        public ByteBuf fillBuffer(ByteBuf buffer) {
            buffer.writeByte(this.vehicleIdx);
            buffer.writeFloatLE(this.lapTime);
            return buffer;
        }

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

    public class Retirement {

        private short vehicleIdx;

        /**
         * Fill the current Retirement with the raw bytes representation
         * 
         * @param buffer buffer with the raw bytes representation
         * @return current filled Retirement instance
         */
        public Retirement fill(ByteBuf buffer) {
            this.vehicleIdx = buffer.readUnsignedByte();
            return this;
        }

        /**
         * Fill the buffer with the raw bytes representation of the current Retirement instance
         * 
         * @param buffer buffer to fill
         * @return filled buffer
         */
        public ByteBuf fillBuffer(ByteBuf buffer) {
            buffer.writeByte(this.vehicleIdx);
            return buffer;
        }

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

    public class TeamMateInPits {

        private short vehicleIdx;

        /**
         * Fill the current TeamMateInPits with the raw bytes representation
         * 
         * @param buffer buffer with the raw bytes representation
         * @return current filled TeamMateInPits instance
         */
        public TeamMateInPits fill(ByteBuf buffer) {
            this.vehicleIdx = buffer.readUnsignedByte();
            return this;
        }

        /**
         * Fill the buffer with the raw bytes representation of the current TeamMateInPits instance
         * 
         * @param buffer buffer to fill
         * @return filled buffer
         */
        public ByteBuf fillBuffer(ByteBuf buffer) {
            buffer.writeByte(this.vehicleIdx);
            return buffer;
        }

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

    public class RaceWinner {

        private short vehicleIdx;

        /**
         * Fill the current RaceWinner with the raw bytes representation
         * 
         * @param buffer buffer with the raw bytes representation
         * @return current filled RaceWinner instance
         */
        public RaceWinner fill(ByteBuf buffer) {
            this.vehicleIdx = buffer.readUnsignedByte();
            return this;
        }

        /**
         * Fill the buffer with the raw bytes representation of the current RaceWinner instance
         * 
         * @param buffer buffer to fill
         * @return filled buffer
         */
        public ByteBuf fillBuffer(ByteBuf buffer) {
            buffer.writeByte(this.vehicleIdx);
            return buffer;
        }

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

    public class Penalty {

        private PenaltyType penaltyType;
        private InfringementType infringementType;
        private short vehicleIdx;
        private short otherVehicleIdx;
        private short time;
        private short lapNum;
        private short placesGained;

        /**
         * Fill the current Penalty with the raw bytes representation
         * 
         * @param buffer buffer with the raw bytes representation
         * @return current filled Penalty instance
         */
        public Penalty fill(ByteBuf buffer) {
            this.penaltyType = PenaltyType.valueOf(buffer.readUnsignedByte());
            this.infringementType = InfringementType.valueOf(buffer.readUnsignedByte());
            this.vehicleIdx = buffer.readUnsignedByte();
            this.otherVehicleIdx = buffer.readUnsignedByte();
            this.time = buffer.readUnsignedByte();
            this.lapNum = buffer.readUnsignedByte();
            this.placesGained = buffer.readUnsignedByte();
            return this;
        }

        /**
         * Fill the buffer with the raw bytes representation of the current Penalty instance
         * 
         * @param buffer buffer to fill
         * @return filled buffer
         */
        public ByteBuf fillBuffer(ByteBuf buffer) {
            buffer.writeByte(this.penaltyType.getValue());
            buffer.writeByte(this.infringementType.getValue());
            buffer.writeByte(this.vehicleIdx);
            buffer.writeByte(this.otherVehicleIdx);
            buffer.writeByte(this.time);
            buffer.writeByte(this.lapNum);
            buffer.writeByte(this.placesGained);
            return buffer;
        }

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

    public class SpeedTrap {

        private short vehicleIdx;
        private float speed;

        /**
         * Fill the current SpeedTrap with the raw bytes representation
         * 
         * @param buffer buffer with the raw bytes representation
         * @return current filled SpeedTrap instance
         */
        public SpeedTrap fill(ByteBuf buffer) {
            this.vehicleIdx = buffer.readUnsignedByte();
            this.speed = buffer.readFloatLE();
            return this;
        }

        /**
         * Fill the buffer with the raw bytes representation of the current SpeedTrap instance
         * 
         * @param buffer buffer to fill
         * @return filled buffer
         */
        public ByteBuf fillBuffer(ByteBuf buffer) {
            buffer.writeByte(this.vehicleIdx);
            buffer.writeFloatLE(this.speed);
            return buffer;
        }

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