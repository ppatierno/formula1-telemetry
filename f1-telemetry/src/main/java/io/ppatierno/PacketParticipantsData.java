package io.ppatierno;

/**
 * Participants Packet
 * 
 * This is a list of participants in the race. 
 * If the vehicle is controlled by AI, then the name will be the driver name. 
 * If this is a multiplayer game, the names will be the Steam Id on PC, or the LAN name if appropriate.
 */
public class PacketParticipantsData extends Packet {
    // TODO

    @Override
    public String toString() {
        return super.toString();
        // TODO return complete instance
    }
}