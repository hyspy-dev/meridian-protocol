// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum AbilitySlot {
    Primary(0),
    Support(1);

    public static final AbilitySlot[] VALUES = values();

    private final int value;

    AbilitySlot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AbilitySlot fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("AbilitySlot", value);
    }
}