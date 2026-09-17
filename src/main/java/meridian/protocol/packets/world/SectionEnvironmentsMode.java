// Auto-generated - do not edit
package meridian.protocol.packets.world;

import meridian.protocol.io.ProtocolException;

public enum SectionEnvironmentsMode {
    Uniform(0),
    Columns(1);

    public static final SectionEnvironmentsMode[] VALUES = values();

    private final int value;

    SectionEnvironmentsMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static SectionEnvironmentsMode fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("SectionEnvironmentsMode", value);
    }
}