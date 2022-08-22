/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.ppatierno.formula1.data.ParticipantData;
import io.ppatierno.formula1.enums.PacketId;
import io.ppatierno.formula1.packets.Packet;
import io.ppatierno.formula1.packets.PacketParticipantsData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class PacketEventHandler extends SimpleChannelInboundHandler<Packet> {

    private static final Logger log = LogManager.getLogger(PacketEventHandler.class);
    private int count = 0;

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx,
        Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, Packet msg) throws Exception {
        log.debug("Packet nr.{} [FrameId={}, SessionTime={}, PacketId={}]",
                ++count,
                msg.getHeader().getFrameIdentifier(),
                msg.getHeader().getSessionTime(),
                msg.getHeader().getPacketId());
        logParticipants(msg);
    }

    private void logParticipants(Packet msg) {
        if (msg.getHeader().getPacketId() == PacketId.PARTICIPANTS) {
            PacketParticipantsData packetParticipantsData = (PacketParticipantsData) msg;
            for (ParticipantData participantData : packetParticipantsData.getParticipants()) {
                log.debug(participantData.getDriverId().name() + "[" + participantData.getDriverId().getValue() + "] " +
                        participantData.getTeamId().name() + "[" + participantData.getTeamId().getValue() + "]");
            }
        }
    }
}