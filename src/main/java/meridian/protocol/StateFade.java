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


public class StateFade {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 26;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 26;
    public static final int MAX_SIZE = 26;

    @Nullable public BarBeatDuration duration;
    @Nonnull public FadeCurve curve = FadeCurve.Linear;
    @Nullable public BarBeatDuration delay;

    public StateFade() {
    }

    public StateFade(@Nullable BarBeatDuration duration, @Nonnull FadeCurve curve, @Nullable BarBeatDuration delay) {
        this.duration = duration;
        this.curve = curve;
        this.delay = delay;
    }

    public StateFade(@Nonnull StateFade other) {
        this.duration = other.duration;
        this.curve = other.curve;
        this.delay = other.delay;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("StateFade", offset, (int) mem.byteSize());
        long needed = (long) offset + 26;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateFade", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static BarBeatDuration getDuration(MemorySegment mem) {
        return getDuration(mem, 0);
    }
    
    @Nullable
    public static BarBeatDuration getDuration(MemorySegment mem, int offset) {
        return hasDuration(mem, offset) ? BarBeatDuration.toObject(mem, offset + 1): null;
    }
    
    public static FadeCurve getCurve(MemorySegment mem) {
        return getCurve(mem, 0);
    }
    
    public static FadeCurve getCurve(MemorySegment mem, int offset) {
        return FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13));
    }
    
    @Nullable
    public static BarBeatDuration getDelay(MemorySegment mem) {
        return getDelay(mem, 0);
    }
    
    @Nullable
    public static BarBeatDuration getDelay(MemorySegment mem, int offset) {
        return hasDelay(mem, offset) ? BarBeatDuration.toObject(mem, offset + 14): null;
    }
    
    public static boolean hasDuration(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasDelay(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static StateFade toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StateFade toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StateFade and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StateFade toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new StateFade(
            hasDuration(mem, offset) ? BarBeatDuration.toObject(mem, offset + 1) : null,
            FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 13)),
            hasDelay(mem, offset) ? BarBeatDuration.toObject(mem, offset + 14) : null
        );
        if (cursor != null) cursor.position = offset + 26;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.duration != null) nullBits |= 0x01;
        if (this.delay != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.duration != null) {
            this.duration.serialize(mem, offset + 1);
        } else {
            mem.asSlice(offset + 1, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 13, (byte) this.curve.getValue());
        if (this.delay != null) {
            this.delay.serialize(mem, offset + 14);
        } else {
            mem.asSlice(offset + 14, 12).fill((byte) 0); 
        }
        
        
    
       return 26;
    }
    public int computeSize() {
        return 26;
    }

    public StateFade clone() {
        StateFade copy = new StateFade();
        copy.duration = this.duration != null ? this.duration.clone() : null;
        copy.curve = this.curve;
        copy.delay = this.delay != null ? this.delay.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StateFade other)) return false;
        return java.util.Objects.equals(this.duration, other.duration) && java.util.Objects.equals(this.curve, other.curve) && java.util.Objects.equals(this.delay, other.delay);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(duration, curve, delay);
    }

}