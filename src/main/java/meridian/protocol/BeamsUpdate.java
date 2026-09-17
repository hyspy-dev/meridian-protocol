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


public class BeamsUpdate extends ComponentUpdate {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 16837;

    @Nonnull public BeamInstance[] beams = new BeamInstance[0];

    public BeamsUpdate() {
    }

    public BeamsUpdate(@Nonnull BeamInstance[] beams) {
        this.beams = beams;
    }

    public BeamsUpdate(@Nonnull BeamsUpdate other) {
        this.beams = other.beams;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BeamsUpdate", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BeamsUpdate", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static BeamInstance[] getBeams(MemorySegment mem) {
        return getBeams(mem, 0);
    }
    
    public static BeamInstance[] getBeams(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Beams");
        var len = (int) packed;
        if (len > 64) throw ProtocolException.arrayTooLong("Beams", len, 64);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 61 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Beams", (int) java.lang.Math.min(off + lenOffset + (long) len * 61, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new BeamInstance[len];
        for (var i = 0; i < len; i++) {
            data[i] = BeamInstance.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    
    
    
    
    public static BeamsUpdate toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BeamsUpdate toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BeamsUpdate and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BeamsUpdate toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        BeamInstance[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Beams");
            var len = (int) packed;
            if (len > 64) throw ProtocolException.arrayTooLong("Beams", len, 64);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 61 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Beams", (int) java.lang.Math.min(off + lenOffset + (long) len * 61, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new BeamInstance[len];
            for (var i = 0; i < len; i++) {
                v0[i] = BeamInstance.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new BeamsUpdate(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (beams.length > 64) throw ProtocolException.arrayTooLong("Beams", beams.length, 64);
        varOffset += VarInt.set(mem, varOffset, this.beams.length);
        
        var beamsValueOffset = 0;
        for (var i = 0; i < this.beams.length; i++) {
            beamsValueOffset += this.beams[i].serialize(mem, varOffset + beamsValueOffset);
        }
        varOffset += beamsValueOffset;
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 0;
        int beamsSize = 0;
for (var elem : beams) beamsSize += elem.computeSize();
size += VarInt.size(beams.length) + beamsSize;

        return size;
    }

    public BeamsUpdate clone() {
        BeamsUpdate copy = new BeamsUpdate();
        copy.beams = java.util.Arrays.stream(this.beams).map(e -> e.clone()).toArray(BeamInstance[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BeamsUpdate other)) return false;
        return java.util.Arrays.equals(this.beams, other.beams);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(beams);
        return result;
    }

}