/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

/**
 * Car Setups Packet
 * 
 * This packet details the car setups for each vehicle in the session. 
 * Note that in multiplayer games, other player cars will appear as blank, you will only be able to see your car setup and AI cars.
 */
public class PacketCarSetupData extends Packet {
    // TODO

    @Override
    public String toString() {
        return super.toString();
        // TODO return complete instance
    }
}