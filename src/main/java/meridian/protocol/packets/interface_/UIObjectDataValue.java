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

public class UIObjectDataValue extends UIDataValue {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String typeName = "";
    @Nonnull public java.util.Map<String, UIDataValue> properties = new java.util.HashMap<>();
    @Nullable public String propertyChangedNotificationContext;

    public UIObjectDataValue() {
    }

    public UIObjectDataValue(@Nonnull String typeName, @Nonnull java.util.Map<String, UIDataValue> properties, @Nullable String propertyChangedNotificationContext) {
        this.typeName = typeName;
        this.properties = properties;
        this.propertyChangedNotificationContext = propertyChangedNotificationContext;
    }

    public UIObjectDataValue(@Nonnull UIObjectDataValue other) {
        this.typeName = other.typeName;
        this.properties = other.properties;
        this.propertyChangedNotificationContext = other.propertyChangedNotificationContext;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UIObjectDataValue", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UIObjectDataValue", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getTypeName(MemorySegment mem) {
        return getTypeName(mem, 0);
    }
    
    public static String getTypeName(MemorySegment mem, int offset) {
        return PacketIO.readVarString("TypeName", mem, offset + getValidatedOffset(mem, offset, 1, 13, "TypeName"), 255);
    }
    
    public static java.util.Map<String, UIDataValue> getProperties(MemorySegment mem) {
        return getProperties(mem, 0);
    }
    
    public static java.util.Map<String, UIDataValue> getProperties(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 5, 13, "Properties");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Properties");
        var len = (int) packed;
        if (len > 256) throw ProtocolException.dictionaryTooLarge("Properties", len, 256);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Properties", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, UIDataValue> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = UIDataValue.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Properties", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static String getPropertyChangedNotificationContext(MemorySegment mem) {
        return getPropertyChangedNotificationContext(mem, 0);
    }
    
    @Nullable
    public static String getPropertyChangedNotificationContext(MemorySegment mem, int offset) {
        return hasPropertyChangedNotificationContext(mem, offset) ? PacketIO.readVarString("PropertyChangedNotificationContext", mem, offset + getValidatedOffset(mem, offset, 9, 13, "PropertyChangedNotificationContext"), 128): null;
    }
    
    public static boolean hasPropertyChangedNotificationContext(MemorySegment mem, int offset) {
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
    
    public static UIObjectDataValue toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UIObjectDataValue toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UIObjectDataValue and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UIObjectDataValue toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 13;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 1, varPos, "TypeName");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("TypeName", mem, off, 0, 255, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        java.util.Map<String, UIDataValue> v1;
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
                var value = UIDataValue.toObject(mem, off, walkCursor);
                    off = walkCursor.position;
                if (v1.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Properties", key);
                }
            }
            varPos = off - varBase;
        }
        
        String v2 = null;
        if (hasPropertyChangedNotificationContext(mem, offset)) {
            requireSlot(mem, offset + 9, varPos, "PropertyChangedNotificationContext");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("PropertyChangedNotificationContext", mem, off, 0, 128, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 9, -1, "PropertyChangedNotificationContext");
        }
        var result = new UIObjectDataValue(
            v0,
            v1,
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.propertyChangedNotificationContext != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 13;
        mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 13);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.typeName, 255);
        mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 13);
        if (this.properties.size() > 256) throw ProtocolException.dictionaryTooLarge("Properties", properties.size(), 256);
        varOffset += VarInt.set(mem, varOffset, this.properties.size());
        for (var e : this.properties.entrySet()) {
            varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
            varOffset += e.getValue().serializeWithTypeId(mem, varOffset);
        }
        if (this.propertyChangedNotificationContext != null) {
            mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 13);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.propertyChangedNotificationContext, 128);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 9, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 13;
        size += PacketIO.stringSize(typeName);
    int propertiesSize = 0;
for (var kvp : properties.entrySet()) propertiesSize += PacketIO.stringSize(kvp.getKey()) + kvp.getValue().computeSizeWithTypeId();
size += VarInt.size(properties.size()) + propertiesSize;
    if (propertyChangedNotificationContext != null) size += PacketIO.stringSize(propertyChangedNotificationContext);

        return size;
    }

    public UIObjectDataValue clone() {
        UIObjectDataValue copy = new UIObjectDataValue();
        copy.typeName = this.typeName;
        copy.properties = new java.util.HashMap<>(this.properties);
        copy.propertyChangedNotificationContext = this.propertyChangedNotificationContext;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UIObjectDataValue other)) return false;
        return java.util.Objects.equals(this.typeName, other.typeName) && java.util.Objects.equals(this.properties, other.properties) && java.util.Objects.equals(this.propertyChangedNotificationContext, other.propertyChangedNotificationContext);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(typeName, properties, propertyChangedNotificationContext);
    }

}