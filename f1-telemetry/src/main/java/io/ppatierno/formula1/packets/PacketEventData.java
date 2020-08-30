/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1.packets;

import io.netty.buffer.ByteBuf;
import io.ppatierno.formula1.PacketUtils;
import io.ppatierno.formula1.data.EventDataDetails;
import io.ppatierno.formula1.data.FastestLap;
import io.ppatierno.formula1.data.Penalty;
import io.ppatierno.formula1.data.RaceWinner;
import io.ppatierno.formula1.data.Retirement;
import io.ppatierno.formula1.data.SpeedTrap;
import io.ppatierno.formula1.data.TeamMateInPits;
import io.ppatierno.formula1.enums.EventCode;

/**
 * Event Packet
 * 
 * This packet gives details of events that happen during the course of a session.
 * Frequency: When the event occurs
 */
public class PacketEventData extends Packet {

    // 35
    public static final int SIZE = PacketHeader.SIZE + 
                                    4 + 
                                    EventDataDetails.SIZE;
    
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
}