// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class ViewModelEnumDefinition {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String typeName = "";
    @Nonnull public String[] values = new String[0];

    public ViewModelEnumDefinition() {
    }

    public ViewModelEnumDefinition(@Nonnull String typeName, @Nonnull String[] values) {
        this.typeName = typeName;
        this.values = values;
    }

    public ViewModelEnumDefinition(@Nonnull ViewModelEnumDefinition other) {
        this.typeName = other.typeName;
        this.values = other.values;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ViewModelEnumDefinition", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ViewModelEnumDefinition", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getTypeName(MemorySegment mem) {
        return getTypeName(mem, 0);
    }
    
    public static String getTypeName(MemorySegment mem, int offset) {
        return PacketIO.readVarString("TypeName", mem, offset + getValidatedOffset(mem, offset, 0, 8, "TypeName"), 255);
    }
    
    public static String[] getValues(MemorySegment mem) {
        return getValues(mem, 0);
    }
    
    public static String[] getValues(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 4, 8, "Values");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Values");
        var len = (int) packed;
        if (len > 1024) throw ProtocolException.arrayTooLong("Values", len, 1024);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Values", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Values", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
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
    
    public static ViewModelEnumDefinition toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ViewModelEnumDefinition toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ViewModelEnumDefinition and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ViewModelEnumDefinition toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        String v0;
        requireSlot(mem, offset + 0, varPos, "TypeName");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("TypeName", mem, off, 0, 255, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String[] v1;
        requireSlot(mem, offset + 4, varPos, "Values");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Values");
            var len = (int) packed;
            if (len > 1024) throw ProtocolException.arrayTooLong("Values", len, 1024);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Values", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v1 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v1[i] = PacketIO.readVarString("Values", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new ViewModelEnumDefinition(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 8;
        mem.set(PacketIO.PROTO_INT, offset + 0, varOffset - offset - 8);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.typeName, 255);
        mem.set(PacketIO.PROTO_INT, offset + 4, varOffset - offset - 8);
        if (values.length > 1024) throw ProtocolException.arrayTooLong("Values", values.length, 1024);
        varOffset += VarInt.set(mem, varOffset, this.values.length);
        
        var valuesValueOffset = 0;
        for (var i = 0; i < this.values.length; i++) {
            valuesValueOffset += PacketIO.writeVarString(mem, varOffset + valuesValueOffset, this.values[i], 4096000);
        }
        varOffset += valuesValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 8;
        size += PacketIO.stringSize(typeName);
    int valuesSize = 0;
for (var elem : values) valuesSize += PacketIO.stringSize(elem);
size += VarInt.size(values.length) + valuesSize;

        return size;
    }

    public ViewModelEnumDefinition clone() {
        ViewModelEnumDefinition copy = new ViewModelEnumDefinition();
        copy.typeName = this.typeName;
        copy.values = java.util.Arrays.copyOf(this.values, this.values.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ViewModelEnumDefinition other)) return false;
        return java.util.Objects.equals(this.typeName, other.typeName) && java.util.Arrays.equals(this.values, other.values);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(typeName);
        result = 31 * result + java.util.Arrays.hashCode(values);
        return result;
    }

}