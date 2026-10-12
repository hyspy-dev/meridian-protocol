// Auto-generated - do not edit
package meridian.protocol;

public final class ProtocolSettings {
    public static final int PROTOCOL_CRC = -386561135;
    public static final int PROTOCOL_VERSION = 3;
    public static final int PROTOCOL_BUILD_NUMBER = 258;
    public static final int PACKET_COUNT = 389;
    public static final int STRUCT_COUNT = 445;
    public static final int ENUM_COUNT = 177;
    public static final int MAX_PACKET_SIZE = 1677721600;

    private ProtocolSettings() {}

    public static boolean validateCrc(int crc) {
        return PROTOCOL_CRC == crc;
    }
}