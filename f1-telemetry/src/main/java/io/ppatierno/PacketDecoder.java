package io.ppatierno;

import io.netty.buffer.ByteBuf;

import java.util.function.Supplier;

/**
 * Packet decoder
 */
public class PacketDecoder {
    
    public Packet decode(ByteBuf buffer, Supplier<? extends Packet> ctor) {
        Packet packet = ctor.get();
        // TODO: logic to decode packets
        return packet;
    }
}