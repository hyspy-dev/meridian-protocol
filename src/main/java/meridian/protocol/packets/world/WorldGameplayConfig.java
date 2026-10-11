// Auto-generated - do not edit
package meridian.protocol.packets.world;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class WorldGameplayConfig implements Packet, ToClientPacket {
    public static final int PACKET_ID = 185;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 2;
    public static final int MAX_SIZE = 16384014;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public WorldConfig worldConfig = new WorldConfig();
    @Nonnull public CombatConfig combatConfig = new CombatConfig();
    @Nonnull public PlayerConfig playerConfig = new PlayerConfig();

    public WorldGameplayConfig() {
    }

    public WorldGameplayConfig(@Nonnull WorldConfig worldConfig, @Nonnull CombatConfig combatConfig, @Nonnull PlayerConfig playerConfig) {
        this.worldConfig = worldConfig;
        this.combatConfig = combatConfig;
        this.playerConfig = playerConfig;
    }

    public WorldGameplayConfig(@Nonnull WorldGameplayConfig other) {
        this.worldConfig = other.worldConfig;
        this.combatConfig = other.combatConfig;
        this.playerConfig = other.playerConfig;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("WorldGameplayConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 2;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("WorldGameplayConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static WorldConfig getWorldConfig(MemorySegment mem) {
        return getWorldConfig(mem, 0);
    }
    
    public static WorldConfig getWorldConfig(MemorySegment mem, int offset) {
        return WorldConfig.toObject(mem, offset + 2);
    }
    
    public static CombatConfig getCombatConfig(MemorySegment mem) {
        return getCombatConfig(mem, 0);
    }
    
    public static CombatConfig getCombatConfig(MemorySegment mem, int offset) {
        return CombatConfig.toObject(mem, offset + 0);
    }
    
    public static PlayerConfig getPlayerConfig(MemorySegment mem) {
        return getPlayerConfig(mem, 0);
    }
    
    public static PlayerConfig getPlayerConfig(MemorySegment mem, int offset) {
        return PlayerConfig.toObject(mem, offset + 1);
    }
    
    
    
    
    
    public static WorldGameplayConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static WorldGameplayConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one WorldGameplayConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static WorldGameplayConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 2;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        WorldConfig v0;
        {
            v0 = WorldConfig.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new WorldGameplayConfig(
            v0,
            CombatConfig.toObject(mem, offset + 0),
            PlayerConfig.toObject(mem, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        this.combatConfig.serialize(mem, offset + 0);
        this.playerConfig.serialize(mem, offset + 1);
        var varOffset = offset + 2;
        varOffset += this.worldConfig.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 2;
        size += worldConfig.computeSize();

        return size;
    }

    public WorldGameplayConfig clone() {
        WorldGameplayConfig copy = new WorldGameplayConfig();
        copy.worldConfig = this.worldConfig.clone();
        copy.combatConfig = this.combatConfig.clone();
        copy.playerConfig = this.playerConfig.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WorldGameplayConfig other)) return false;
        return java.util.Objects.equals(this.worldConfig, other.worldConfig) && java.util.Objects.equals(this.combatConfig, other.combatConfig) && java.util.Objects.equals(this.playerConfig, other.playerConfig);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(worldConfig, combatConfig, playerConfig);
    }

}