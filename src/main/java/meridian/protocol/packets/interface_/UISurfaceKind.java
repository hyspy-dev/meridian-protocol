// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import meridian.protocol.io.ProtocolException;

public enum UISurfaceKind {
    Page(0),
    Hud(1);

    public static final UISurfaceKind[] VALUES = values();

    private final int value;

    UISurfaceKind(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static UISurfaceKind fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("UISurfaceKind", value);
    }
}