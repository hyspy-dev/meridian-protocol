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


public class HitSphere {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 8;

    public double radius;

    public HitSphere() {
    }

    public HitSphere(double radius) {
        this.radius = radius;
    }

    public HitSphere(@Nonnull HitSphere other) {
        this.radius = other.radius;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("HitSphere", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("HitSphere", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static double getRadius(MemorySegment mem) {
        return getRadius(mem, 0);
    }
    
    public static double getRadius(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 0), "Radius");
    }
    
    
    
    
    
    public static HitSphere toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static HitSphere toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one HitSphere and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static HitSphere toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new HitSphere(
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_DOUBLE, offset + 0), "Radius")
        );
        if (cursor != null) cursor.position = offset + 8;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        PacketIO.requireFinite(this.radius, "Radius"); mem.set(PacketIO.PROTO_DOUBLE, offset + 0, this.radius);
        
        
    
       return 8;
    }
    public int computeSize() {
        return 8;
    }

    public HitSphere clone() {
        HitSphere copy = new HitSphere();
        copy.radius = this.radius;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof HitSphere other)) return false;
        return this.radius == other.radius;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(radius);
    }

}