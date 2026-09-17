// Auto-generated - do not edit
package meridian.protocol.packets.worldmap;

import meridian.protocol.io.ProtocolException;

public enum MapMarkerIconSize {
    Default(0),
    Major(1);

    public static final MapMarkerIconSize[] VALUES = values();

    private final int value;

    MapMarkerIconSize(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static MapMarkerIconSize fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("MapMarkerIconSize", value);
    }
}