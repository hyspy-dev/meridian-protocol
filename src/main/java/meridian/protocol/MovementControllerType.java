// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum MovementControllerType {
    Default(0),
    Glider(1),
    Mount(2),
    Seat(3),
    Bed(4),
    Minecart(5);

    public static final MovementControllerType[] VALUES = values();

    private final int value;

    MovementControllerType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MovementControllerType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("MovementControllerType", value);
    }
}