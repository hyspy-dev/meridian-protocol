// Auto-generated - do not edit
package meridian.protocol.packets.player;

public final class TriggerVolumeEntityTargetType {
    private TriggerVolumeEntityTargetType() {
    }

    public static final byte Player = (byte) 1;
    public static final byte NPC = (byte) 2;
    public static final byte ItemDrop = (byte) 4;
    public static final byte Projectile = (byte) 8;
    public static final byte ALL = (byte) 15;

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