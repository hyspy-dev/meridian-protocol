// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import meridian.protocol.io.ProtocolException;

public enum ServersidePageLifetime {
    CantClose(0),
    CanDismiss(1),
    CanDismissOrCloseThroughInteraction(2);

    public static final ServersidePageLifetime[] VALUES = values();

    private final int value;

    ServersidePageLifetime(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static ServersidePageLifetime fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("ServersidePageLifetime", value);
    }
}