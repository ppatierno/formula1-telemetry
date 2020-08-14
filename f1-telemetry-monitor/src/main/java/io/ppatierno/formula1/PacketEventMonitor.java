/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno.formula1;

import java.net.InetSocketAddress;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelOption;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class PacketEventMonitor {

    private static final int DEFAULT_PORT = 20777;

    private final EventLoopGroup group;
    private final Bootstrap bootstrap;

    public PacketEventMonitor(InetSocketAddress address) {
        this.group = new NioEventLoopGroup();
        this.bootstrap = new Bootstrap();
        this.bootstrap.group(group)
            .channel(NioDatagramChannel.class)
            .option(ChannelOption.SO_BROADCAST, true)
            .handler( new ChannelInitializer<Channel>() {
                @Override
                protected void initChannel(Channel channel)
                    throws Exception {
                    ChannelPipeline pipeline = channel.pipeline();
                    pipeline.addLast(new PacketEventDecoder());
                    pipeline.addLast(new PacketEventHandler());
                }
            } )
            .localAddress(address);
    }

    public Channel bind() {
        return this.bootstrap.bind().syncUninterruptibly().channel();
    }

    public void stop() {
        this.group.shutdownGracefully();
    }

    public static void main(String[] args) throws Exception {
        PacketEventMonitor monitor = new PacketEventMonitor(
            new InetSocketAddress(DEFAULT_PORT)
        );
        try {
            Channel channel = monitor.bind();
            System.out.println("PacketEventMonitor running");
            channel.closeFuture().sync();
        } finally {
            monitor.stop();
        }
    }
    
}