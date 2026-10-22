// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum AbilityDescriptionScaling {
    Replace(0),
    Multiply(1);

    public static final AbilityDescriptionScaling[] VALUES = values();

    private final int value;

    AbilityDescriptionScaling(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AbilityDescriptionScaling fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("AbilityDescriptionScaling", value);
    }
}