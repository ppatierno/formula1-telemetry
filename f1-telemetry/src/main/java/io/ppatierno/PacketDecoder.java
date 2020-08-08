/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

import io.netty.buffer.ByteBuf;

import java.math.BigInteger;
import java.util.function.Supplier;

/**
 * Packet decoder
 */
public class PacketDecoder {
    
    public Packet decode(ByteBuf buffer, Supplier<? extends Packet> ctor) {
        Packet packet = ctor.get();
        decodeHeader(buffer, packet.getHeader());

        switch (packet.getHeader().getPacketId()) {
            case CAR_SETUPS:
                // TODO: logic to decode PacketCarSetupData
                break;
            case CAR_STATUS:
                // TODO: logic to decode PacketCarStatusData
                break;
            case CAR_TELEMETRY:
                // TODO: logic to decode PacketCarTelemetryData
                break;
            case EVENT:
                // TODO: logic to decode PacketEventData
                break;
            case FINAL_CLASSIFICATION:
                // TODO: logic to decode PacketFinalClassificationData
                break;
            case LAP_DATA:
                // TODO: logic to decode PacketLapData
                break;
            case LOBBY_INFO:
                // TODO: logic to decode PacketLobbyInfoData
                break;
            case MOTION:
                // TODO: logic to decode PacketMotionData
                break;
            case PARTICIPANTS:
                // TODO: logic to decode PacketParticipantsData
                break;
            case SESSION:
                // TODO: logic to decode PacketSessionData
                break;
            default:
                break;
        }
        return packet;
    }

    private void decodeHeader(ByteBuf buffer, PacketHeader header) {
        header.setPacketFormat(buffer.readUnsignedShortLE());
        header.setGameMajorVersion(buffer.readUnsignedByte());
        header.setGameMinorVersion(buffer.readUnsignedByte());
        header.setPacketVersion(buffer.readUnsignedByte());
        header.setPacketId(PacketId.valueOf(buffer.readUnsignedByte()));
        header.setSessionUid(BigInteger.valueOf(buffer.readLongLE()));
        header.setSessionTime(buffer.readFloatLE());
        header.setFrameIdentifier(buffer.readIntLE());
        header.setPlayerCarIndex(buffer.readUnsignedByte());
        header.setSecondaryPlayerCarIndex(buffer.readUnsignedByte());
    }
}