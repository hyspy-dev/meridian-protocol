// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class AssetPack {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public AssetPackManifest manifest = new AssetPackManifest();
    public boolean isReadOnly;
    public boolean canBeDeleted;

    public AssetPack() {
    }

    public AssetPack(@Nonnull AssetPackManifest manifest, boolean isReadOnly, boolean canBeDeleted) {
        this.manifest = manifest;
        this.isReadOnly = isReadOnly;
        this.canBeDeleted = canBeDeleted;
    }

    public AssetPack(@Nonnull AssetPack other) {
        this.manifest = other.manifest;
        this.isReadOnly = other.isReadOnly;
        this.canBeDeleted = other.canBeDeleted;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetPack", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetPack", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static AssetPackManifest getManifest(MemorySegment mem) {
        return getManifest(mem, 0);
    }
    
    public static AssetPackManifest getManifest(MemorySegment mem, int offset) {
        return AssetPackManifest.toObject(mem, offset + 1);
    }
    
    public static boolean getIsReadOnly(MemorySegment mem) {
        return getIsReadOnly(mem, 0);
    }
    
    public static boolean getIsReadOnly(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0;
    }
    
    public static boolean getCanBeDeleted(MemorySegment mem) {
        return getCanBeDeleted(mem, 0);
    }
    
    public static boolean getCanBeDeleted(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0;
    }
    
    
    
    
    
    public static AssetPack toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetPack toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetPack and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetPack toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 1;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        AssetPackManifest v0;
        {
            v0 = AssetPackManifest.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new AssetPack(
            v0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        byte boolBits0_0 = 0;
        if (this.isReadOnly) boolBits0_0 |= 0x01;
        if (this.canBeDeleted) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 0, boolBits0_0);
        var varOffset = offset + 1;
        varOffset += this.manifest.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 1;
        size += manifest.computeSize();

        return size;
    }

    public AssetPack clone() {
        AssetPack copy = new AssetPack();
        copy.manifest = this.manifest.clone();
        copy.isReadOnly = this.isReadOnly;
        copy.canBeDeleted = this.canBeDeleted;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetPack other)) return false;
        return java.util.Objects.equals(this.manifest, other.manifest) && this.isReadOnly == other.isReadOnly && this.canBeDeleted == other.canBeDeleted;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(manifest, isReadOnly, canBeDeleted);
    }

}