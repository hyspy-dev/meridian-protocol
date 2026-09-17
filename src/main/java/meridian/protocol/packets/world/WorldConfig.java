// Auto-generated - do not edit
package meridian.protocol.packets.world;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class WorldConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 6;

    public boolean allowBlockBreaking;
    public int blockBreakingBypassTagIndex;
    public boolean allowBlockGathering;
    public boolean allowBlockPlacement;

    public WorldConfig() {
    }

    public WorldConfig(boolean allowBlockBreaking, int blockBreakingBypassTagIndex, boolean allowBlockGathering, boolean allowBlockPlacement) {
        this.allowBlockBreaking = allowBlockBreaking;
        this.blockBreakingBypassTagIndex = blockBreakingBypassTagIndex;
        this.allowBlockGathering = allowBlockGathering;
        this.allowBlockPlacement = allowBlockPlacement;
    }

    public WorldConfig(@Nonnull WorldConfig other) {
        this.allowBlockBreaking = other.allowBlockBreaking;
        this.blockBreakingBypassTagIndex = other.blockBreakingBypassTagIndex;
        this.allowBlockGathering = other.allowBlockGathering;
        this.allowBlockPlacement = other.allowBlockPlacement;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("WorldConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("WorldConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getAllowBlockBreaking(MemorySegment mem) {
        return getAllowBlockBreaking(mem, 0);
    }
    
    public static boolean getAllowBlockBreaking(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 0);
    }
    
    public static int getBlockBreakingBypassTagIndex(MemorySegment mem) {
        return getBlockBreakingBypassTagIndex(mem, 0);
    }
    
    public static int getBlockBreakingBypassTagIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static boolean getAllowBlockGathering(MemorySegment mem) {
        return getAllowBlockGathering(mem, 0);
    }
    
    public static boolean getAllowBlockGathering(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 5) & 0x01) != 0;
    }
    
    public static boolean getAllowBlockPlacement(MemorySegment mem) {
        return getAllowBlockPlacement(mem, 0);
    }
    
    public static boolean getAllowBlockPlacement(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 5) & 0x02) != 0;
    }
    
    
    
    
    
    public static WorldConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static WorldConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one WorldConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static WorldConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new WorldConfig(
            mem.get(PacketIO.PROTO_BOOL, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 1),
            (mem.get(PacketIO.PROTO_BYTE, offset + 5) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 5) & 0x02) != 0
        );
        if (cursor != null) cursor.position = offset + 6;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BOOL, offset + 0, this.allowBlockBreaking);
        mem.set(PacketIO.PROTO_INT, offset + 1, this.blockBreakingBypassTagIndex);
        byte boolBits0_0 = 0;
        if (this.allowBlockGathering) boolBits0_0 |= 0x01;
        if (this.allowBlockPlacement) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 5 + 0, boolBits0_0);
        
        
    
       return 6;
    }
    public int computeSize() {
        return 6;
    }

    public WorldConfig clone() {
        WorldConfig copy = new WorldConfig();
        copy.allowBlockBreaking = this.allowBlockBreaking;
        copy.blockBreakingBypassTagIndex = this.blockBreakingBypassTagIndex;
        copy.allowBlockGathering = this.allowBlockGathering;
        copy.allowBlockPlacement = this.allowBlockPlacement;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WorldConfig other)) return false;
        return this.allowBlockBreaking == other.allowBlockBreaking && this.blockBreakingBypassTagIndex == other.blockBreakingBypassTagIndex && this.allowBlockGathering == other.allowBlockGathering && this.allowBlockPlacement == other.allowBlockPlacement;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(allowBlockBreaking, blockBreakingBypassTagIndex, allowBlockGathering, allowBlockPlacement);
    }

}