// Auto-generated - do not edit
package meridian.protocol.packets.player;

public final class ClientRuleVolumeRule {
    private ClientRuleVolumeRule() {
    }

    public static final byte NoBuild = (byte) 1;
    public static final byte NoDestroy = (byte) 2;
    public static final byte NoHarvest = (byte) 4;
    public static final byte NoDamageAll = (byte) 8;
    public static final byte NoDamagePlayers = (byte) 16;
    public static final byte ALL = (byte) 31;

    public static boolean has(byte value, byte flag) {
        return (value & flag) == flag;
    }

    public static byte with(byte value, byte flag) {
        return (byte) (value | flag);
    }

    public static byte without(byte value, byte flag) {
        return (byte) (value & ~flag);
    }

    public static byte none() {
        return (byte) 0;
    }
}