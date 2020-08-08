/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

/**
 * Final Classification Packet
 * 
 * This packet details the final classification at the end of the race, and the data will match with the post race results screen.
 * This is especially useful for multiplayer games where it is not always possible to send lap times on the final frame because of network delay.
 */
public class PacketFinalClassificationData extends Packet {
    // TODO

    @Override
    public String toString() {
        return super.toString();
        // TODO return complete instance
    }
}