// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class AbilityDescriptionValue {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 16384011;

    @Nullable public String attribute;
    public float value;
    @Nonnull public AbilityDescriptionScaling scaling = AbilityDescriptionScaling.Replace;

    public AbilityDescriptionValue() {
    }

    public AbilityDescriptionValue(@Nullable String attribute, float value, @Nonnull AbilityDescriptionScaling scaling) {
        this.attribute = attribute;
        this.value = value;
        this.scaling = scaling;
    }

    public AbilityDescriptionValue(@Nonnull AbilityDescriptionValue other) {
        this.attribute = other.attribute;
        this.value = other.value;
        this.scaling = other.scaling;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("AbilityDescriptionValue", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("AbilityDescriptionValue", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getAttribute(MemorySegment mem) {
        return getAttribute(mem, 0);
    }
    
    @Nullable
    public static String getAttribute(MemorySegment mem, int offset) {
        return hasAttribute(mem, offset) ? PacketIO.readVarString("Attribute", mem, offset + 6, 4096000): null;
    }
    
    public static float getValue(MemorySegment mem) {
        return getValue(mem, 0);
    }
    
    public static float getValue(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Value");
    }
    
    public static AbilityDescriptionScaling getScaling(MemorySegment mem) {
        return getScaling(mem, 0);
    }
    
    public static AbilityDescriptionScaling getScaling(MemorySegment mem, int offset) {
        return AbilityDescriptionScaling.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5));
    }
    
    public static boolean hasAttribute(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static AbilityDescriptionValue toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static AbilityDescriptionValue toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one AbilityDescriptionValue and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static AbilityDescriptionValue toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 6;
        var varPos = 0;
        String v0 = null;
        if (hasAttribute(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Attribute", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new AbilityDescriptionValue(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "Value"),
            AbilityDescriptionScaling.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 5))
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.attribute != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.value, "Value"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.value);
        mem.set(PacketIO.PROTO_BYTE, offset + 5, (byte) this.scaling.getValue());
        var varOffset = offset + 6;
        if (this.attribute != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.attribute, 4096000);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 6;
        if (attribute != null) size += PacketIO.stringSize(attribute);

        return size;
    }

    public AbilityDescriptionValue clone() {
        AbilityDescriptionValue copy = new AbilityDescriptionValue();
        copy.attribute = this.attribute;
        copy.value = this.value;
        copy.scaling = this.scaling;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof AbilityDescriptionValue other)) return false;
        return java.util.Objects.equals(this.attribute, other.attribute) && this.value == other.value && java.util.Objects.equals(this.scaling, other.scaling);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(attribute, value, scaling);
    }

}