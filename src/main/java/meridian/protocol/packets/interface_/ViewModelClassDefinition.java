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
import java.util.HashMap;

public class ViewModelClassDefinition {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String typeName = "";
    @Nonnull public java.util.Map<String, String> properties = new java.util.HashMap<>();
    @Nullable public String baseTypeName;

    public ViewModelClassDefinition() {
    }

    public ViewModelClassDefinition(@Nonnull String typeName, @Nonnull java.util.Map<String, String> properties, @Nullable String baseTypeName) {
        this.typeName = typeName;
        this.properties = properties;
        this.baseTypeName = baseTypeName;
    }

    public ViewModelClassDefinition(@Nonnull ViewModelClassDefinition other) {
        this.typeName = other.typeName;
        this.properties = other.properties;
        this.baseTypeName = other.baseTypeName;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ViewModelClassDefinition", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ViewModelClassDefinition", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getTypeName(MemorySegment mem) {
        return getTypeName(mem, 0);
    }
    
    public static String getTypeName(MemorySegment mem, int offset) {
        return PacketIO.readVarString("TypeName", mem, offset + getValidatedOffset(mem, offset, 1, 13, "TypeName"), 255);
    }
    
    public static java.util.Map<String, String> getProperties(MemorySegment mem) {
        return getProperties(mem, 0);
    }
    
    public static java.util.Map<String, String> getProperties(MemorySegment mem, int offset) {
        var off = offset + getValidatedOffset(mem, offset, 5, 13, "Properties");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Properties");
        var len = (int) packed;
        if (len > 256) throw ProtocolException.dictionaryTooLarge("Properties", len, 256);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Properties", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, String> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var valuePacked = VarInt.getWithLength(mem, off);
                var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                off += (int) valuePacked + (int) (valuePacked >>> 32);
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Properties", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String getBaseTypeName(MemorySegment mem) {
        return getBaseTypeName(mem, 0);
    }
    
    @Nullable
    public static String getBaseTypeName(MemorySegment mem, int offset) {
        return hasBaseTypeName(mem, offset) ? PacketIO.readVarString("BaseTypeName", mem, offset + getValidatedOffset(mem, offset, 9, 13, "BaseTypeName"), 255): null;
    }
    
    public static boolean hasBaseTypeName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
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
    
    public static ViewModelClassDefinition toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ViewModelClassDefinition toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ViewModelClassDefinition and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ViewModelClassDefinition toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        String v0;
        requireSlot(mem, offset + 1, varPos, "TypeName");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("TypeName", mem, off, 0, 255, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        java.util.Map<String, String> v1;
        requireSlot(mem, offset + 5, varPos, "Properties");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Properties");
            var len = (int) packed;
            if (len > 256) throw ProtocolException.dictionaryTooLarge("Properties", len, 256);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Properties", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v1 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var valuePacked = VarInt.getWithLength(mem, off);
                    var value = PacketIO.readVarString("value", mem, off, 0, 4096000, valuePacked);
                    off += (int) valuePacked + (int) (valuePacked >>> 32);
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Properties", key);
                }
            }
            varPos = off - varBase;
        }
        
        String v2 = null;
        if (hasBaseTypeName(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "BaseTypeName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("BaseTypeName", mem, off, 0, 255, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "BaseTypeName");
        }
        var result = new ViewModelClassDefinition(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.baseTypeName != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.typeName, 255);
        mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
        if (this.properties.size() > 256) throw ProtocolException.dictionaryTooLarge("Properties", properties.size(), 256);
        varOffset += VarInt.set(mem, varOffset, this.properties.size());
        for (var e : this.properties.entrySet()) {
            varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
            varOffset += PacketIO.writeVarString(mem, varOffset, e.getValue(), 4096000);
        }
        if (this.baseTypeName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.baseTypeName, 255);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 13;
        size += PacketIO.stringSize(typeName);
    int propertiesSize = 0;
for (var kvp : properties.entrySet()) propertiesSize += PacketIO.stringSize(kvp.getKey()) + PacketIO.stringSize(kvp.getValue());
size += VarInt.size(properties.size()) + propertiesSize;
    if (baseTypeName != null) size += PacketIO.stringSize(baseTypeName);

        return size;
    }

    public ViewModelClassDefinition clone() {
        ViewModelClassDefinition copy = new ViewModelClassDefinition();
        copy.typeName = this.typeName;
        copy.properties = new java.util.HashMap<>(this.properties);
        copy.baseTypeName = this.baseTypeName;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ViewModelClassDefinition other)) return false;
        return java.util.Objects.equals(this.typeName, other.typeName) && java.util.Objects.equals(this.properties, other.properties) && java.util.Objects.equals(this.baseTypeName, other.baseTypeName);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(typeName, properties, baseTypeName);
    }

}