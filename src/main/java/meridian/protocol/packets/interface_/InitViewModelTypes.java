// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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


public class InitViewModelTypes implements Packet, ToClientPacket {
    public static final int PACKET_ID = 208;
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

    @Nonnull public ViewModelClassDefinition[] typeDefinitions = new ViewModelClassDefinition[0];
    @Nonnull public ViewModelEnumDefinition[] enumDefinitions = new ViewModelEnumDefinition[0];

    public InitViewModelTypes() {
    }

    public InitViewModelTypes(@Nonnull ViewModelClassDefinition[] typeDefinitions, @Nonnull ViewModelEnumDefinition[] enumDefinitions) {
        this.typeDefinitions = typeDefinitions;
        this.enumDefinitions = enumDefinitions;
    }

    public InitViewModelTypes(@Nonnull InitViewModelTypes other) {
        this.typeDefinitions = other.typeDefinitions;
        this.enumDefinitions = other.enumDefinitions;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InitViewModelTypes", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InitViewModelTypes", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ViewModelClassDefinition[] getTypeDefinitions(MemorySegment mem) {
        return getTypeDefinitions(mem, 0);
    }
    
    public static ViewModelClassDefinition[] getTypeDefinitions(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 0, 8, "TypeDefinitions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("TypeDefinitions");
        var len = (int) packed;
        if (len > 10000) throw ProtocolException.arrayTooLong("TypeDefinitions", len, 10000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TypeDefinitions", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ViewModelClassDefinition[len];
        for (var i = 0; i < len; i++) {
            data[i] = ViewModelClassDefinition.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static ViewModelEnumDefinition[] getEnumDefinitions(MemorySegment mem) {
        return getEnumDefinitions(mem, 0);
    }
    
    public static ViewModelEnumDefinition[] getEnumDefinitions(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 4, 8, "EnumDefinitions");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("EnumDefinitions");
        var len = (int) packed;
        if (len > 10000) throw ProtocolException.arrayTooLong("EnumDefinitions", len, 10000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EnumDefinitions", (int) java.lang.Math.min(off + lenOffset + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new ViewModelEnumDefinition[len];
        for (var i = 0; i < len; i++) {
            data[i] = ViewModelEnumDefinition.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
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
    
    public static InitViewModelTypes toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InitViewModelTypes toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InitViewModelTypes and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InitViewModelTypes toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        ViewModelClassDefinition[] v0;
        requireSlot(mem, offset + 0, varPos, "TypeDefinitions");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("TypeDefinitions");
            var len = (int) packed;
            if (len > 10000) throw ProtocolException.arrayTooLong("TypeDefinitions", len, 10000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 13 > mem.byteSize()) throw ProtocolException.bufferTooSmall("TypeDefinitions", (int) java.lang.Math.min(off + lenOffset + (long) len * 13, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new ViewModelClassDefinition[len];
            for (var i = 0; i < len; i++) {
                v0[i] = ViewModelClassDefinition.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        
        ViewModelEnumDefinition[] v1;
        requireSlot(mem, offset + 4, varPos, "EnumDefinitions");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("EnumDefinitions");
            var len = (int) packed;
            if (len > 10000) throw ProtocolException.arrayTooLong("EnumDefinitions", len, 10000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 8 > mem.byteSize()) throw ProtocolException.bufferTooSmall("EnumDefinitions", (int) java.lang.Math.min(off + lenOffset + (long) len * 8, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new ViewModelEnumDefinition[len];
            for (var i = 0; i < len; i++) {
                v1[i] = ViewModelEnumDefinition.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new InitViewModelTypes(
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
        if (typeDefinitions.length > 10000) throw ProtocolException.arrayTooLong("TypeDefinitions", typeDefinitions.length, 10000);
        varOffset += VarInt.set(mem, varOffset, this.typeDefinitions.length);
        
        var typeDefinitionsValueOffset = 0;
        for (var i = 0; i < this.typeDefinitions.length; i++) {
            typeDefinitionsValueOffset += this.typeDefinitions[i].serialize(mem, varOffset + typeDefinitionsValueOffset);
        }
        varOffset += typeDefinitionsValueOffset;
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 8);
        if (enumDefinitions.length > 10000) throw ProtocolException.arrayTooLong("EnumDefinitions", enumDefinitions.length, 10000);
        varOffset += VarInt.set(mem, varOffset, this.enumDefinitions.length);
        
        var enumDefinitionsValueOffset = 0;
        for (var i = 0; i < this.enumDefinitions.length; i++) {
            enumDefinitionsValueOffset += this.enumDefinitions[i].serialize(mem, varOffset + enumDefinitionsValueOffset);
        }
        varOffset += enumDefinitionsValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 8;
        int typeDefinitionsSize = 0;
for (var elem : typeDefinitions) typeDefinitionsSize += elem.computeSize();
size += VarInt.size(typeDefinitions.length) + typeDefinitionsSize;
    int enumDefinitionsSize = 0;
for (var elem : enumDefinitions) enumDefinitionsSize += elem.computeSize();
size += VarInt.size(enumDefinitions.length) + enumDefinitionsSize;

        return size;
    }

    public InitViewModelTypes clone() {
        InitViewModelTypes copy = new InitViewModelTypes();
        copy.typeDefinitions = java.util.Arrays.stream(this.typeDefinitions).map(e -> e.clone()).toArray(ViewModelClassDefinition[]::new);
        copy.enumDefinitions = java.util.Arrays.stream(this.enumDefinitions).map(e -> e.clone()).toArray(ViewModelEnumDefinition[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InitViewModelTypes other)) return false;
        return java.util.Arrays.equals(this.typeDefinitions, other.typeDefinitions) && java.util.Arrays.equals(this.enumDefinitions, other.enumDefinitions);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(typeDefinitions);
        result = 31 * result + java.util.Arrays.hashCode(enumDefinitions);
        return result;
    }

}