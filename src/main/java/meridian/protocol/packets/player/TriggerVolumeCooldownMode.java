// Auto-generated - do not edit
package meridian.protocol.packets.player;

import meridian.protocol.io.ProtocolException;

public enum TriggerVolumeCooldownMode {
    PerEntity(0),
    Total(1);

    public static final TriggerVolumeCooldownMode[] VALUES = values();

    private final int value;

    TriggerVolumeCooldownMode(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static TriggerVolumeCooldownMode fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("TriggerVolumeCooldownMode", value);
    }
}