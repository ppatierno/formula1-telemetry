/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import io.netty.buffer.ByteBuf;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.socket.DatagramPacket;
import io.netty.handler.codec.MessageToMessageDecoder;
import io.ppatierno.formula1.packets.Packet;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.List;

public class PacketEventDecoder extends MessageToMessageDecoder<DatagramPacket> {

    private static final Logger log = LogManager.getLogger(PacketEventDecoder.class);

    PacketDecoder packetDecoder = new PacketDecoder();

    @Override
    protected void decode(ChannelHandlerContext channelHandlerContext, DatagramPacket datagramPacket, List<Object> list) throws Exception {
        ByteBuf buffer = datagramPacket.content();
        Packet packet = packetDecoder.decode(buffer);
        log.debug(packet);
        list.add(packet);
    }
}