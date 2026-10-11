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
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 7;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 7;
    public static final int MAX_SIZE = 16384012;

    public boolean allowBlockBreaking;
    public int blockBreakingBypassTagIndex;
    public boolean allowBlockGathering;
    public boolean allowBlockPlacement;
    @Nullable public int[] blockedRootInteractionTagIndexes;

    public WorldConfig() {
    }

    public WorldConfig(boolean allowBlockBreaking, int blockBreakingBypassTagIndex, boolean allowBlockGathering, boolean allowBlockPlacement, @Nullable int[] blockedRootInteractionTagIndexes) {
        this.allowBlockBreaking = allowBlockBreaking;
        this.blockBreakingBypassTagIndex = blockBreakingBypassTagIndex;
        this.allowBlockGathering = allowBlockGathering;
        this.allowBlockPlacement = allowBlockPlacement;
        this.blockedRootInteractionTagIndexes = blockedRootInteractionTagIndexes;
    }

    public WorldConfig(@Nonnull WorldConfig other) {
        this.allowBlockBreaking = other.allowBlockBreaking;
        this.blockBreakingBypassTagIndex = other.blockBreakingBypassTagIndex;
        this.allowBlockGathering = other.allowBlockGathering;
        this.allowBlockPlacement = other.allowBlockPlacement;
        this.blockedRootInteractionTagIndexes = other.blockedRootInteractionTagIndexes;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("WorldConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 7;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("WorldConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getAllowBlockBreaking(MemorySegment mem) {
        return getAllowBlockBreaking(mem, 0);
    }
    
    public static boolean getAllowBlockBreaking(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static int getBlockBreakingBypassTagIndex(MemorySegment mem) {
        return getBlockBreakingBypassTagIndex(mem, 0);
    }
    
    public static int getBlockBreakingBypassTagIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    public static boolean getAllowBlockGathering(MemorySegment mem) {
        return getAllowBlockGathering(mem, 0);
    }
    
    public static boolean getAllowBlockGathering(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x01) != 0;
    }
    
    public static boolean getAllowBlockPlacement(MemorySegment mem) {
        return getAllowBlockPlacement(mem, 0);
    }
    
    public static boolean getAllowBlockPlacement(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x02) != 0;
    }
    
    @Nullable
    public static int[] getBlockedRootInteractionTagIndexes(MemorySegment mem) {
        return getBlockedRootInteractionTagIndexes(mem, 0);
    }
    
    @Nullable
    public static int[] getBlockedRootInteractionTagIndexes(MemorySegment mem, int offset) {
        if (!hasBlockedRootInteractionTagIndexes(mem, offset)) return null;
        var off = offset + 7;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("BlockedRootInteractionTagIndexes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("BlockedRootInteractionTagIndexes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockedRootInteractionTagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    public static boolean hasBlockedRootInteractionTagIndexes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
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
        var varBase = offset + 7;
        var varPos = 0;
        int[] v4 = null;
        if (hasBlockedRootInteractionTagIndexes(mem, offset)) {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("BlockedRootInteractionTagIndexes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("BlockedRootInteractionTagIndexes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockedRootInteractionTagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v4, 0, len);
            varPos = off + len * 4 - varBase;
        }
        var result = new WorldConfig(
            mem.get(PacketIO.PROTO_BOOL, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 2),
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 6) & 0x02) != 0,
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.blockedRootInteractionTagIndexes != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.allowBlockBreaking);
        mem.set(PacketIO.PROTO_INT, offset + 2, this.blockBreakingBypassTagIndex);
        byte boolBits0_0 = 0;
        if (this.allowBlockGathering) boolBits0_0 |= 0x01;
        if (this.allowBlockPlacement) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 6 + 0, boolBits0_0);
        var varOffset = offset + 7;
        if (this.blockedRootInteractionTagIndexes != null) {
            
            if (blockedRootInteractionTagIndexes.length > 4096000) throw ProtocolException.arrayTooLong("BlockedRootInteractionTagIndexes", blockedRootInteractionTagIndexes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.blockedRootInteractionTagIndexes.length);
            
            MemorySegment.copy(this.blockedRootInteractionTagIndexes, 0, mem, PacketIO.PROTO_INT, varOffset, this.blockedRootInteractionTagIndexes.length);
            varOffset += this.blockedRootInteractionTagIndexes.length * 4;
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 7;
        if (blockedRootInteractionTagIndexes != null) size += VarInt.size(blockedRootInteractionTagIndexes.length) + blockedRootInteractionTagIndexes.length * 4;

        return size;
    }

    public WorldConfig clone() {
        WorldConfig copy = new WorldConfig();
        copy.allowBlockBreaking = this.allowBlockBreaking;
        copy.blockBreakingBypassTagIndex = this.blockBreakingBypassTagIndex;
        copy.allowBlockGathering = this.allowBlockGathering;
        copy.allowBlockPlacement = this.allowBlockPlacement;
        copy.blockedRootInteractionTagIndexes = this.blockedRootInteractionTagIndexes != null ? java.util.Arrays.copyOf(this.blockedRootInteractionTagIndexes, this.blockedRootInteractionTagIndexes.length) : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof WorldConfig other)) return false;
        return this.allowBlockBreaking == other.allowBlockBreaking && this.blockBreakingBypassTagIndex == other.blockBreakingBypassTagIndex && this.allowBlockGathering == other.allowBlockGathering && this.allowBlockPlacement == other.allowBlockPlacement && java.util.Arrays.equals(this.blockedRootInteractionTagIndexes, other.blockedRootInteractionTagIndexes);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Boolean.hashCode(allowBlockBreaking);
        result = 31 * result + Integer.hashCode(blockBreakingBypassTagIndex);
        result = 31 * result + Boolean.hashCode(allowBlockGathering);
        result = 31 * result + Boolean.hashCode(allowBlockPlacement);
        result = 31 * result + java.util.Arrays.hashCode(blockedRootInteractionTagIndexes);
        return result;
    }

}