// Auto-generated - do not edit
package meridian.protocol.packets.world;

import meridian.protocol.io.ProtocolException;

public enum ArmorVisibilityOption {
    All(0),
    HelmetOnly(1),
    None(2);

    public static final ArmorVisibilityOption[] VALUES = values();

    private final int value;

    ArmorVisibilityOption(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ArmorVisibilityOption fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ArmorVisibilityOption", value);
    }
}