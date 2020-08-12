/*
 * Copyright Paolo Patierno.
 * License: Apache License 2.0 (see the file LICENSE or http://apache.org/licenses/LICENSE-2.0.html).
 */
package io.ppatierno;

import java.nio.charset.Charset;

import io.netty.buffer.ByteBuf;

public class PacketUtils {
    
    /**
     * Get the String instance from the related bytes in the input buffer
     * representing a null terminated string
     * 
     * @param buffer buffer containing the string bytes
     * @param maxLength max length of the string
     * @return String instace
     */
    public static String readNullTerminatedString(ByteBuf buffer, int maxLength) {
        int result = buffer.bytesBefore(maxLength, (byte) 0);
        String s = buffer.readBytes(result).toString(Charset.forName("UTF-8"));
        buffer.skipBytes(maxLength - result);
        return s;
    }
}