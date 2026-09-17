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


public class StateTransition {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 34;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 42;
    public static final int MAX_SIZE = 32768070;

    public int fromValueIndex;
    public int toValueIndex;
    @Nullable public BarBeatDuration duration;
    @Nonnull public FadeCurve curve = FadeCurve.Linear;
    @Nullable public MusicSync syncTo;
    @Nullable public BarBeatDuration delay;
    @Nullable public String postEvent;

    public StateTransition() {
    }

    public StateTransition(int fromValueIndex, int toValueIndex, @Nullable BarBeatDuration duration, @Nonnull FadeCurve curve, @Nullable MusicSync syncTo, @Nullable BarBeatDuration delay, @Nullable String postEvent) {
        this.fromValueIndex = fromValueIndex;
        this.toValueIndex = toValueIndex;
        this.duration = duration;
        this.curve = curve;
        this.syncTo = syncTo;
        this.delay = delay;
        this.postEvent = postEvent;
    }

    public StateTransition(@Nonnull StateTransition other) {
        this.fromValueIndex = other.fromValueIndex;
        this.toValueIndex = other.toValueIndex;
        this.duration = other.duration;
        this.curve = other.curve;
        this.syncTo = other.syncTo;
        this.delay = other.delay;
        this.postEvent = other.postEvent;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("StateTransition", offset, (int) mem.byteSize());
        long needed = (long) offset + 42;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateTransition", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getFromValueIndex(MemorySegment mem) {
        return getFromValueIndex(mem, 0);
    }
    
    public static int getFromValueIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static int getToValueIndex(MemorySegment mem) {
        return getToValueIndex(mem, 0);
    }
    
    public static int getToValueIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    @Nullable
    public static BarBeatDuration getDuration(MemorySegment mem) {
        return getDuration(mem, 0);
    }
    
    @Nullable
    public static BarBeatDuration getDuration(MemorySegment mem, int offset) {
        return hasDuration(mem, offset) ? BarBeatDuration.toObject(mem, offset + 9): null;
    }
    
    public static FadeCurve getCurve(MemorySegment mem) {
        return getCurve(mem, 0);
    }
    
    public static FadeCurve getCurve(MemorySegment mem, int offset) {
        return FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 21));
    }
    
    @Nullable
    public static MusicSync getSyncTo(MemorySegment mem) {
        return getSyncTo(mem, 0);
    }
    
    @Nullable
    public static MusicSync getSyncTo(MemorySegment mem, int offset) {
        return hasSyncTo(mem, offset) ? MusicSync.toObject(mem, offset + getValidatedOffset(mem, offset, 34, 42, "SyncTo")): null;
    }
    
    @Nullable
    public static BarBeatDuration getDelay(MemorySegment mem) {
        return getDelay(mem, 0);
    }
    
    @Nullable
    public static BarBeatDuration getDelay(MemorySegment mem, int offset) {
        return hasDelay(mem, offset) ? BarBeatDuration.toObject(mem, offset + 22): null;
    }
    
    @Nullable
    public static String getPostEvent(MemorySegment mem) {
        return getPostEvent(mem, 0);
    }
    
    @Nullable
    public static String getPostEvent(MemorySegment mem, int offset) {
        return hasPostEvent(mem, offset) ? PacketIO.readVarString("PostEvent", mem, offset + getValidatedOffset(mem, offset, 38, 42, "PostEvent"), 4096000): null;
    }
    
    public static boolean hasDuration(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasDelay(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSyncTo(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasPostEvent(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static StateTransition toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StateTransition toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StateTransition and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StateTransition toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 42;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        MusicSync v4 = null;
        if (hasSyncTo(mem, offset)) {
            requireSlot(mem, offset + 34, varPos, "SyncTo");
            v4 = MusicSync.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 34, -1, "SyncTo");
        }
        
        String v6 = null;
        if (hasPostEvent(mem, offset)) {
            requireSlot(mem, offset + 38, varPos, "PostEvent");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v6 = PacketIO.readVarString("PostEvent", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 38, -1, "PostEvent");
        }
        var result = new StateTransition(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            mem.get(PacketIO.PROTO_INT, offset + 5),
            hasDuration(mem, offset) ? BarBeatDuration.toObject(mem, offset + 9) : null,
            FadeCurve.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 21)),
            v4,
            hasDelay(mem, offset) ? BarBeatDuration.toObject(mem, offset + 22) : null,
            v6
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.duration != null) nullBits |= 0x01;
        if (this.delay != null) nullBits |= 0x02;
        if (this.syncTo != null) nullBits |= 0x04;
        if (this.postEvent != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.fromValueIndex);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.toValueIndex);
        if (this.duration != null) {
            this.duration.serialize(mem, offset + 9);
        } else {
            mem.asSlice(offset + 9, 12).fill((byte) 0); 
        }
        mem.set(PacketIO.PROTO_BYTE, offset + 21, (byte) this.curve.getValue());
        if (this.delay != null) {
            this.delay.serialize(mem, offset + 22);
        } else {
            mem.asSlice(offset + 22, 12).fill((byte) 0); 
        }
        var varOffset = offset + 42;
        if (this.syncTo != null) {
            mem.set(PacketIO.PROTO_INT, offset + 34, varOffset - offset - 42);
            varOffset += this.syncTo.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 34, -1);
        }
        if (this.postEvent != null) {
            mem.set(PacketIO.PROTO_INT, offset + 38, varOffset - offset - 42);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.postEvent, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 38, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 42;
        if (syncTo != null) size += syncTo.computeSize();
    if (postEvent != null) size += PacketIO.stringSize(postEvent);

        return size;
    }

    public StateTransition clone() {
        StateTransition copy = new StateTransition();
        copy.fromValueIndex = this.fromValueIndex;
        copy.toValueIndex = this.toValueIndex;
        copy.duration = this.duration != null ? this.duration.clone() : null;
        copy.curve = this.curve;
        copy.syncTo = this.syncTo != null ? this.syncTo.clone() : null;
        copy.delay = this.delay != null ? this.delay.clone() : null;
        copy.postEvent = this.postEvent;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StateTransition other)) return false;
        return this.fromValueIndex == other.fromValueIndex && this.toValueIndex == other.toValueIndex && java.util.Objects.equals(this.duration, other.duration) && java.util.Objects.equals(this.curve, other.curve) && java.util.Objects.equals(this.syncTo, other.syncTo) && java.util.Objects.equals(this.delay, other.delay) && java.util.Objects.equals(this.postEvent, other.postEvent);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(fromValueIndex, toValueIndex, duration, curve, syncTo, delay, postEvent);
    }

}