// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum AbilityCostType {
    None(0),
    Mana(1),
    Stamina(2),
    Health(3);

    public static final AbilityCostType[] VALUES = values();

    private final int value;

    AbilityCostType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static AbilityCostType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("AbilityCostType", value);
    }
}