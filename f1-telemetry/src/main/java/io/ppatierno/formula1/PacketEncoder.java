/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import io.netty.buffer.ByteBuf;
import io.netty.buffer.Unpooled;
import io.ppatierno.formula1.packets.Packet;
import io.ppatierno.formula1.packets.PacketMotionData;

/**
 * Packet encoder
 */
public class PacketEncoder {
    
    /**
     * Encode the input Packet instance in the corresponding raw bytes representation
     * 
     * @param packet Packet instance to encode
     * @return raw bytes representation of the Packet instance
     */
    public ByteBuf encode(Packet packet) {
        ByteBuf bb = null;
        switch (packet.getHeader().getPacketId()) {
            case CAR_SETUPS:
                break;
            case CAR_STATUS:
                break;
            case CAR_TELEMETRY:
                break;
            case EVENT:
                break;
            case FINAL_CLASSIFICATION:
                break;
            case LAP_DATA:
                break;
            case LOBBY_INFO:
                break;
            case MOTION:
                bb = Unpooled.buffer(PacketMotionData.SIZE);
                break;
            case PARTICIPANTS:
                break;
            case SESSION:
                break;
            default:
                throw new IllegalArgumentException("PacketId=" + packet.getHeader().getPacketId() + " not supported");
        }
        return bb != null ? packet.fillBuffer(bb) : null;
    }
}