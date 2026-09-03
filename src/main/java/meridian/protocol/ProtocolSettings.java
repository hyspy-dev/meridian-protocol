// Auto-generated - do not edit
package meridian.protocol;

public final class ProtocolSettings {
    public static final int PROTOCOL_CRC = 636045167;
    public static final int PROTOCOL_VERSION = 3;
    public static final int PROTOCOL_BUILD_NUMBER = 227;
    public static final int PACKET_COUNT = 371;
    public static final int STRUCT_COUNT = 431;
    public static final int ENUM_COUNT = 173;
    public static final int MAX_PACKET_SIZE = 1677721600;

    private ProtocolSettings() {}

    public static boolean validateCrc(int crc) {
        return PROTOCOL_CRC == crc;
    }
}