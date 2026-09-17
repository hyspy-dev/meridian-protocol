// Auto-generated - do not edit
package meridian.protocol;

public final class ProtocolSettings {
    public static final int PROTOCOL_CRC = -628210764;
    public static final int PROTOCOL_VERSION = 3;
    public static final int PROTOCOL_BUILD_NUMBER = 242;
    public static final int PACKET_COUNT = 377;
    public static final int STRUCT_COUNT = 436;
    public static final int ENUM_COUNT = 175;
    public static final int MAX_PACKET_SIZE = 1677721600;

    private ProtocolSettings() {}

    public static boolean validateCrc(int crc) {
        return PROTOCOL_CRC == crc;
    }
}