// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import meridian.protocol.io.ProtocolException;

public enum HudWidgetSlot {
    Underlay(0),
    TopLeft(1),
    TopCenter(2),
    TopRight(3),
    MiddleLeft(4),
    MiddleCenter(5),
    MiddleRight(6),
    BottomLeft(7),
    BottomCenter(8),
    BottomRight(9),
    Overlay(10);

    public static final HudWidgetSlot[] VALUES = values();

    private final int value;

    HudWidgetSlot(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static HudWidgetSlot fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("HudWidgetSlot", value);
    }
}