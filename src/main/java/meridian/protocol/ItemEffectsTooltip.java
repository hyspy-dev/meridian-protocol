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


public class ItemEffectsTooltip {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 4;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 4;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public FormattedMessage[] effects = new FormattedMessage[0];
    public float cooldownS;

    public ItemEffectsTooltip() {
    }

    public ItemEffectsTooltip(@Nonnull FormattedMessage[] effects, float cooldownS) {
        this.effects = effects;
        this.cooldownS = cooldownS;
    }

    public ItemEffectsTooltip(@Nonnull ItemEffectsTooltip other) {
        this.effects = other.effects;
        this.cooldownS = other.cooldownS;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemEffectsTooltip", offset, (int) mem.byteSize());
        long needed = (long) offset + 4;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemEffectsTooltip", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static FormattedMessage[] getEffects(MemorySegment mem) {
        return getEffects(mem, 0);
    }
    
    public static FormattedMessage[] getEffects(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + 4;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Effects");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Effects", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 40 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Effects", (int) java.lang.Math.min(off + lenOffset + (long) len * 40, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new FormattedMessage[len];
        for (var i = 0; i < len; i++) {
            data[i] = FormattedMessage.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static float getCooldownS(MemorySegment mem) {
        return getCooldownS(mem, 0);
    }
    
    public static float getCooldownS(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "CooldownS");
    }
    
    
    
    
    
    public static ItemEffectsTooltip toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemEffectsTooltip toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemEffectsTooltip and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemEffectsTooltip toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 4;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Effects");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Effects", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 40 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Effects", (int) java.lang.Math.min(off + lenOffset + (long) len * 40, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new FormattedMessage[len];
            for (var i = 0; i < len; i++) {
                v0[i] = FormattedMessage.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new ItemEffectsTooltip(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 0), "CooldownS")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.cooldownS, "CooldownS"); mem.set(PacketIO.PROTO_FLOAT, offset + 0, this.cooldownS);
        var varOffset = offset + 4;
        if (effects.length > 4096000) throw ProtocolException.arrayTooLong("Effects", effects.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.effects.length);
        
        var effectsValueOffset = 0;
        for (var i = 0; i < this.effects.length; i++) {
            effectsValueOffset += this.effects[i].serialize(mem, varOffset + effectsValueOffset);
        }
        varOffset += effectsValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 4;
        int effectsSize = 0;
for (var elem : effects) effectsSize += elem.computeSize();
size += VarInt.size(effects.length) + effectsSize;

        return size;
    }

    public ItemEffectsTooltip clone() {
        ItemEffectsTooltip copy = new ItemEffectsTooltip();
        copy.effects = java.util.Arrays.stream(this.effects).map(e -> e.clone()).toArray(FormattedMessage[]::new);
        copy.cooldownS = this.cooldownS;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemEffectsTooltip other)) return false;
        return java.util.Arrays.equals(this.effects, other.effects) && this.cooldownS == other.cooldownS;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(effects);
        result = 31 * result + Float.hashCode(cooldownS);
        return result;
    }

}