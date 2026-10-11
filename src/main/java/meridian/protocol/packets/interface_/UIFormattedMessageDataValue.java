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
import meridian.protocol.FormattedMessage;

public class UIFormattedMessageDataValue extends UIDataValue {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public FormattedMessage value = new FormattedMessage();

    public UIFormattedMessageDataValue() {
    }

    public UIFormattedMessageDataValue(@Nonnull FormattedMessage value) {
        this.value = value;
    }

    public UIFormattedMessageDataValue(@Nonnull UIFormattedMessageDataValue other) {
        this.value = other.value;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UIFormattedMessageDataValue", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UIFormattedMessageDataValue", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static FormattedMessage getValue(MemorySegment mem) {
        return getValue(mem, 0);
    }
    
    public static FormattedMessage getValue(MemorySegment mem, int offset) {
        return FormattedMessage.toObject(mem, offset + 0);
    }
    
    
    
    
    
    public static UIFormattedMessageDataValue toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UIFormattedMessageDataValue toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UIFormattedMessageDataValue and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UIFormattedMessageDataValue toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage v0;
        {
            v0 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        }
        var result = new UIFormattedMessageDataValue(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        varOffset += this.value.serialize(mem, varOffset);
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 0;
        size += value.computeSize();

        return size;
    }

    public UIFormattedMessageDataValue clone() {
        UIFormattedMessageDataValue copy = new UIFormattedMessageDataValue();
        copy.value = this.value.clone();
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UIFormattedMessageDataValue other)) return false;
        return java.util.Objects.equals(this.value, other.value);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(value);
    }

}