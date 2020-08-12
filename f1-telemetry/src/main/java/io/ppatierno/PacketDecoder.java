/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

import io.netty.buffer.ByteBuf;

import java.util.function.Function;

/**
 * Packet decoder
 */
public class PacketDecoder {

    /**
     * Decode the input buffer containing the packet raw bytes filling a
     * concrete Packet instance provided by the contructor parameter.
     * This is useful to allow the caller to pre-allocate a pool of Packet instances
     * and using them to be filled instead of creating a new one every time.
     * 
     * @param buffer buffer with the packet raw bytes
     * @param ctor function providing the empty Packet instance to fill
     * @return decoded Packet instance
     */
    public Packet decode(ByteBuf buffer, Function<PacketId, ? extends Packet> ctor) {
        PacketId packetId = getPacketId(buffer);
        Packet packet = ctor.apply(packetId);
        return packet.fill(buffer);
    }

    /**
     * Decode the input buffer containing the packet raw bytes filling
     * a new concrete Packet instance.
     * 
     * @param buffer buffer with the packet raw bytes
     * @return decoded Packet instance
     */
    public Packet decode(ByteBuf buffer) {
        return decode(buffer, packetId -> {
           switch (packetId) {
                case CAR_SETUPS:
                    return new PacketCarSetupData();
                case CAR_STATUS:
                    return new PacketCarStatusData();
                case CAR_TELEMETRY:
                    return new PacketCarTelemetryData();
                case EVENT:
                    return new PacketEventData();
                case FINAL_CLASSIFICATION:
                    return new PacketFinalClassificationData();
                case LAP_DATA:
                    return new PacketLapData();
                case LOBBY_INFO:
                    return new PacketLobbyInfoData();
                case MOTION:
                    return new PacketMotionData();
                case PARTICIPANTS:
                    return new PacketParticipantsData();
                case SESSION:
                    return new PacketSessionData();
                default:
                    throw new IllegalArgumentException("PacketId=" + packetId + " not supported");
           } 
        });
    }

    /**
     * Get the Packet Id from the input buffer containing the packet raw bytes
     * 
     * @param buffer buffer with the packet raw bytes
     * @return Packet Id
     */
    private PacketId getPacketId(ByteBuf buffer) {
        return PacketId.valueOf(buffer.getUnsignedByte(PacketHeader.PACKET_ID_OFFSET));
    }
}