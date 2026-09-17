// Auto-generated - do not edit
package meridian.protocol.packets.world;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class SetHeightCmd {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 6;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 6;
    public static final int MAX_SIZE = 6;

    public short index;
    public int height;

    public SetHeightCmd() {
    }

    public SetHeightCmd(short index, int height) {
        this.index = index;
        this.height = height;
    }

    public SetHeightCmd(@Nonnull SetHeightCmd other) {
        this.index = other.index;
        this.height = other.height;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetHeightCmd", offset, (int) mem.byteSize());
        long needed = (long) offset + 6;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetHeightCmd", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static short getIndex(MemorySegment mem) {
        return getIndex(mem, 0);
    }
    
    public static short getIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 0);
    }
    
    public static int getHeight(MemorySegment mem) {
        return getHeight(mem, 0);
    }
    
    public static int getHeight(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 2);
    }
    
    
    
    
    
    public static SetHeightCmd toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetHeightCmd toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetHeightCmd and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetHeightCmd toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SetHeightCmd(
            mem.get(PacketIO.PROTO_SHORT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 2)
        );
        if (cursor != null) cursor.position = offset + 6;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_SHORT, offset + 0, this.index);
        mem.set(PacketIO.PROTO_INT, offset + 2, this.height);
        
        
    
       return 6;
    }
    public int computeSize() {
        return 6;
    }

    public SetHeightCmd clone() {
        SetHeightCmd copy = new SetHeightCmd();
        copy.index = this.index;
        copy.height = this.height;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetHeightCmd other)) return false;
        return this.index == other.index && this.height == other.height;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(index, height);
    }

}