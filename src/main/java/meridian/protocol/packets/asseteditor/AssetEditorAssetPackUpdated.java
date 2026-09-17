// Auto-generated - do not edit
package meridian.protocol.packets.asseteditor;

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


public class AssetEditorAssetPackUpdated implements Packet, ToClientPacket {
    public static final int PACKET_ID = 315;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String id = "";
    @Nonnull public AssetPack pack = new AssetPack();

    public AssetEditorAssetPackUpdated() {
    }

    public AssetEditorAssetPackUpdated(@Nonnull String id, @Nonnull AssetPack pack) {
        this.id = id;
        this.pack = pack;
    }

    public AssetEditorAssetPackUpdated(@Nonnull AssetEditorAssetPackUpdated other) {
        this.id = other.id;
        this.pack = other.pack;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AssetEditorAssetPackUpdated", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AssetEditorAssetPackUpdated", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static String getId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 0, 8, "Id"), 4096000);
    }
    
    public static AssetPack getPack(MemorySegment mem) {
        return getPack(mem, 0);
    }
    
    public static AssetPack getPack(MemorySegment mem, int offset) {
        return AssetPack.toObject(mem, offset + getValidatedOffset(mem, offset, 4, 8, "Pack"));
    }
    
    
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static AssetEditorAssetPackUpdated toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AssetEditorAssetPackUpdated toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AssetEditorAssetPackUpdated and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AssetEditorAssetPackUpdated toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 0, varPos, "Id");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Id", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        AssetPack v1;
        requireSlot(mem, offset + 4, varPos, "Pack");
        {
            v1 = AssetPack.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new AssetEditorAssetPackUpdated(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 8;
        mem.set(PacketIO.PROTO_INT, offset + 0, varOffset - offset - 8);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 4096000);
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 8);
        varOffset += this.pack.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 8;
        size += PacketIO.stringSize(id);
    size += pack.computeSize();

        return size;
    }

    public AssetEditorAssetPackUpdated clone() {
        AssetEditorAssetPackUpdated copy = new AssetEditorAssetPackUpdated();
        copy.id = this.id;
        copy.pack = this.pack.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AssetEditorAssetPackUpdated other)) return false;
        return java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.pack, other.pack);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(id, pack);
    }

}