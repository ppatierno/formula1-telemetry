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
        // TODO: logic to decode packets
        return packet;
    }

    private void decodeHeader(ByteBuf buffer, PacketHeader header) {
        header.setPacketFormat(buffer.readUnsignedShortLE());
        header.setGameMajorVersion(buffer.readUnsignedByte());
        header.setGameMinorVersion(buffer.readUnsignedByte());
        header.setPacketVersion(buffer.readUnsignedByte());
        header.setPacketId(buffer.readUnsignedByte());
        header.setSessionUid(BigInteger.valueOf(buffer.readLongLE()));
        header.setSessionTime(buffer.readFloatLE());
        header.setFrameIdentifier(buffer.readIntLE());
        header.setPlayerCarIndex(buffer.readUnsignedByte());
        header.setSecondaryPlayerCarIndex(buffer.readUnsignedByte());
    }
}