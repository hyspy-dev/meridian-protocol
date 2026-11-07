// Auto-generated - do not edit
package meridian.protocol.packets.buildertools;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.NetworkChannel;
import meridian.protocol.Packet;
import meridian.protocol.ToServerPacket;
import meridian.protocol.ToClientPacket;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class BuilderToolRandomizeClipboard implements Packet, ToServerPacket {
    public static final int PACKET_ID = 428;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 13;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 13;
    public static final int MAX_SIZE = 13;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int deltaX;
    public int deltaY;
    public int deltaZ;
    public boolean flipX;
    public boolean flipY;
    public boolean flipZ;

    public BuilderToolRandomizeClipboard() {
    }

    public BuilderToolRandomizeClipboard(int deltaX, int deltaY, int deltaZ, boolean flipX, boolean flipY, boolean flipZ) {
        this.deltaX = deltaX;
        this.deltaY = deltaY;
        this.deltaZ = deltaZ;
        this.flipX = flipX;
        this.flipY = flipY;
        this.flipZ = flipZ;
    }

    public BuilderToolRandomizeClipboard(@Nonnull BuilderToolRandomizeClipboard other) {
        this.deltaX = other.deltaX;
        this.deltaY = other.deltaY;
        this.deltaZ = other.deltaZ;
        this.flipX = other.flipX;
        this.flipY = other.flipY;
        this.flipZ = other.flipZ;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolRandomizeClipboard", offset, (int) mem.byteSize());
        long needed = (long) offset + 13;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolRandomizeClipboard", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getDeltaX(MemorySegment mem) {
        return getDeltaX(mem, 0);
    }
    
    public static int getDeltaX(MemorySegment mem, int offset) {
        var value = mem.get(PacketIO.PROTO_INT, offset + 0);
        if (value < 0 || value > 359) throw ProtocolException.valueOutOfRange("DeltaX", value, 0, 359);
        return value;
    }
    
    public static int getDeltaY(MemorySegment mem) {
        return getDeltaY(mem, 0);
    }
    
    public static int getDeltaY(MemorySegment mem, int offset) {
        var value = mem.get(PacketIO.PROTO_INT, offset + 4);
        if (value < 0 || value > 359) throw ProtocolException.valueOutOfRange("DeltaY", value, 0, 359);
        return value;
    }
    
    public static int getDeltaZ(MemorySegment mem) {
        return getDeltaZ(mem, 0);
    }
    
    public static int getDeltaZ(MemorySegment mem, int offset) {
        var value = mem.get(PacketIO.PROTO_INT, offset + 8);
        if (value < 0 || value > 359) throw ProtocolException.valueOutOfRange("DeltaZ", value, 0, 359);
        return value;
    }
    
    public static boolean getFlipX(MemorySegment mem) {
        return getFlipX(mem, 0);
    }
    
    public static boolean getFlipX(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x01) != 0;
    }
    
    public static boolean getFlipY(MemorySegment mem) {
        return getFlipY(mem, 0);
    }
    
    public static boolean getFlipY(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x02) != 0;
    }
    
    public static boolean getFlipZ(MemorySegment mem) {
        return getFlipZ(mem, 0);
    }
    
    public static boolean getFlipZ(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x04) != 0;
    }
    
    
    
    
    
    public static BuilderToolRandomizeClipboard toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolRandomizeClipboard toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolRandomizeClipboard and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolRandomizeClipboard toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        int v0 = mem.get(PacketIO.PROTO_INT, offset + 0);
        if (v0 < 0 || v0 > 359) throw ProtocolException.valueOutOfRange("DeltaX", v0, 0, 359);
        
        int v1 = mem.get(PacketIO.PROTO_INT, offset + 4);
        if (v1 < 0 || v1 > 359) throw ProtocolException.valueOutOfRange("DeltaY", v1, 0, 359);
        
        int v2 = mem.get(PacketIO.PROTO_INT, offset + 8);
        if (v2 < 0 || v2 > 359) throw ProtocolException.valueOutOfRange("DeltaZ", v2, 0, 359);
        var result = new BuilderToolRandomizeClipboard(
            v0,
            v1,
            v2,
            (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x02) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 12) & 0x04) != 0
        );
        if (cursor != null) cursor.position = offset + 13;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        if (this.deltaX < 0 || this.deltaX > 359) throw ProtocolException.valueOutOfRange("DeltaX", this.deltaX, 0, 359); mem.set(PacketIO.PROTO_INT, offset + 0, this.deltaX);
        if (this.deltaY < 0 || this.deltaY > 359) throw ProtocolException.valueOutOfRange("DeltaY", this.deltaY, 0, 359); mem.set(PacketIO.PROTO_INT, offset + 4, this.deltaY);
        if (this.deltaZ < 0 || this.deltaZ > 359) throw ProtocolException.valueOutOfRange("DeltaZ", this.deltaZ, 0, 359); mem.set(PacketIO.PROTO_INT, offset + 8, this.deltaZ);
        byte boolBits0_0 = 0;
        if (this.flipX) boolBits0_0 |= 0x01;
        if (this.flipY) boolBits0_0 |= 0x02;
        if (this.flipZ) boolBits0_0 |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 12 + 0, boolBits0_0);
        
        
    
       return 13;
    }
    public int computeSize() {
        return 13;
    }

    public BuilderToolRandomizeClipboard clone() {
        BuilderToolRandomizeClipboard copy = new BuilderToolRandomizeClipboard();
        copy.deltaX = this.deltaX;
        copy.deltaY = this.deltaY;
        copy.deltaZ = this.deltaZ;
        copy.flipX = this.flipX;
        copy.flipY = this.flipY;
        copy.flipZ = this.flipZ;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolRandomizeClipboard other)) return false;
        return this.deltaX == other.deltaX && this.deltaY == other.deltaY && this.deltaZ == other.deltaZ && this.flipX == other.flipX && this.flipY == other.flipY && this.flipZ == other.flipZ;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(deltaX, deltaY, deltaZ, flipX, flipY, flipZ);
    }

}