// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import meridian.protocol.io.ProtocolException;

public enum EventTitleStyle {
    Default(0),
    Major(1),
    GoblinBreach(2),
    VoidEviction(3);

    public static final EventTitleStyle[] VALUES = values();

    private final int value;

    EventTitleStyle(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static EventTitleStyle fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("EventTitleStyle", value);
    }
}