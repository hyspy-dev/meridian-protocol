// Auto-generated - do not edit
package meridian.protocol.packets.worldmap;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import meridian.protocol.Color;

public class CompassAlertComponent extends MapMarkerComponent {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 12;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 12;
    public static final int MAX_SIZE = 1041;

    @Nullable public String image;
    public float durationSeconds;
    public float timeoutSeconds;
    @Nullable public Color tint;

    public CompassAlertComponent() {
    }

    public CompassAlertComponent(@Nullable String image, float durationSeconds, float timeoutSeconds, @Nullable Color tint) {
        this.image = image;
        this.durationSeconds = durationSeconds;
        this.timeoutSeconds = timeoutSeconds;
        this.tint = tint;
    }

    public CompassAlertComponent(@Nonnull CompassAlertComponent other) {
        this.image = other.image;
        this.durationSeconds = other.durationSeconds;
        this.timeoutSeconds = other.timeoutSeconds;
        this.tint = other.tint;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CompassAlertComponent", offset, (int) mem.byteSize());
        long needed = (long) offset + 12;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CompassAlertComponent", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getImage(MemorySegment mem) {
        return getImage(mem, 0);
    }
    
    @Nullable
    public static String getImage(MemorySegment mem, int offset) {
        return hasImage(mem, offset) ? PacketIO.readVarString("Image", mem, offset + 12, 256): null;
    }
    
    public static float getDurationSeconds(MemorySegment mem) {
        return getDurationSeconds(mem, 0);
    }
    
    public static float getDurationSeconds(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "DurationSeconds");
    }
    
    public static float getTimeoutSeconds(MemorySegment mem) {
        return getTimeoutSeconds(mem, 0);
    }
    
    public static float getTimeoutSeconds(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "TimeoutSeconds");
    }
    
    @Nullable
    public static Color getTint(MemorySegment mem) {
        return getTint(mem, 0);
    }
    
    @Nullable
    public static Color getTint(MemorySegment mem, int offset) {
        return hasTint(mem, offset) ? Color.toObject(mem, offset + 9): null;
    }
    
    public static boolean hasTint(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasImage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    
    
    public static CompassAlertComponent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CompassAlertComponent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CompassAlertComponent and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CompassAlertComponent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 12;
        var varPos = 0;
        String v0 = null;
        if (hasImage(mem, offset)) {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("Image", mem, off, 0, 256, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new CompassAlertComponent(
            v0,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 1), "DurationSeconds"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "TimeoutSeconds"),
            hasTint(mem, offset) ? Color.toObject(mem, offset + 9) : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.tint != null) nullBits |= 0x01;
        if (this.image != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.requireFinite(this.durationSeconds, "DurationSeconds"); mem.set(PacketIO.PROTO_FLOAT, offset + 1, this.durationSeconds);
        PacketIO.requireFinite(this.timeoutSeconds, "TimeoutSeconds"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.timeoutSeconds);
        if (this.tint != null) {
            this.tint.serialize(mem, offset + 9);
        } else {
            mem.asSlice(offset + 9, 3).fill((byte) 0); 
        }
        var varOffset = offset + 12;
        if (this.image != null) {
            
            varOffset += PacketIO.writeVarString(mem, varOffset, this.image, 256);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 12;
        if (image != null) size += PacketIO.stringSize(image);

        return size;
    }

    public CompassAlertComponent clone() {
        CompassAlertComponent copy = new CompassAlertComponent();
        copy.image = this.image;
        copy.durationSeconds = this.durationSeconds;
        copy.timeoutSeconds = this.timeoutSeconds;
        copy.tint = this.tint != null ? this.tint.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CompassAlertComponent other)) return false;
        return java.util.Objects.equals(this.image, other.image) && this.durationSeconds == other.durationSeconds && this.timeoutSeconds == other.timeoutSeconds && java.util.Objects.equals(this.tint, other.tint);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(image, durationSeconds, timeoutSeconds, tint);
    }

}