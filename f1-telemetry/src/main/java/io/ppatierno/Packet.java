package io.ppatierno;

/**
 * Base class for all packets
 */
public class Packet {

    // header
    private PacketHeader header = new PacketHeader();

    public PacketHeader getHeader() {
        return header;
    }

    public void setHeader(PacketHeader header) {
        this.header = header;
    }   
}