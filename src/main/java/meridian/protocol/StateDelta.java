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


public class StateDelta {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 40;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 40;
    public static final int MAX_SIZE = 40;

    public int valueIndex;
    public float volumeDb;
    public boolean mute;
    public float pitchSemitones;
    @Nullable public StateFade fade;

    public StateDelta() {
    }

    public StateDelta(int valueIndex, float volumeDb, boolean mute, float pitchSemitones, @Nullable StateFade fade) {
        this.valueIndex = valueIndex;
        this.volumeDb = volumeDb;
        this.mute = mute;
        this.pitchSemitones = pitchSemitones;
        this.fade = fade;
    }

    public StateDelta(@Nonnull StateDelta other) {
        this.valueIndex = other.valueIndex;
        this.volumeDb = other.volumeDb;
        this.mute = other.mute;
        this.pitchSemitones = other.pitchSemitones;
        this.fade = other.fade;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("StateDelta", offset, (int) mem.byteSize());
        long needed = (long) offset + 40;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("StateDelta", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getValueIndex(MemorySegment mem) {
        return getValueIndex(mem, 0);
    }
    
    public static int getValueIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static float getVolumeDb(MemorySegment mem) {
        return getVolumeDb(mem, 0);
    }
    
    public static float getVolumeDb(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "VolumeDb");
    }
    
    public static boolean getMute(MemorySegment mem) {
        return getMute(mem, 0);
    }
    
    public static boolean getMute(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 9);
    }
    
    public static float getPitchSemitones(MemorySegment mem) {
        return getPitchSemitones(mem, 0);
    }
    
    public static float getPitchSemitones(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "PitchSemitones");
    }
    
    @Nullable
    public static StateFade getFade(MemorySegment mem) {
        return getFade(mem, 0);
    }
    
    @Nullable
    public static StateFade getFade(MemorySegment mem, int offset) {
        return hasFade(mem, offset) ? StateFade.toObject(mem, offset + 14): null;
    }
    
    public static boolean hasFade(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    
    
    public static StateDelta toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static StateDelta toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one StateDelta and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static StateDelta toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new StateDelta(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "VolumeDb"),
            mem.get(PacketIO.PROTO_BOOL, offset + 9),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 10), "PitchSemitones"),
            hasFade(mem, offset) ? StateFade.toObject(mem, offset + 14) : null
        );
        if (cursor != null) cursor.position = offset + 40;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.fade != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.valueIndex);
        PacketIO.requireFinite(this.volumeDb, "VolumeDb"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.volumeDb);
        mem.set(PacketIO.PROTO_BOOL, offset + 9, this.mute);
        PacketIO.requireFinite(this.pitchSemitones, "PitchSemitones"); mem.set(PacketIO.PROTO_FLOAT, offset + 10, this.pitchSemitones);
        if (this.fade != null) {
            this.fade.serialize(mem, offset + 14);
        } else {
            mem.asSlice(offset + 14, 26).fill((byte) 0); 
        }
        
        
    
       return 40;
    }
    public int computeSize() {
        return 40;
    }

    public StateDelta clone() {
        StateDelta copy = new StateDelta();
        copy.valueIndex = this.valueIndex;
        copy.volumeDb = this.volumeDb;
        copy.mute = this.mute;
        copy.pitchSemitones = this.pitchSemitones;
        copy.fade = this.fade != null ? this.fade.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof StateDelta other)) return false;
        return this.valueIndex == other.valueIndex && this.volumeDb == other.volumeDb && this.mute == other.mute && this.pitchSemitones == other.pitchSemitones && java.util.Objects.equals(this.fade, other.fade);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(valueIndex, volumeDb, mute, pitchSemitones, fade);
    }

}