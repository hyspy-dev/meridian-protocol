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
import meridian.protocol.BlockPosition;

public class BuilderToolStackArea implements Packet, ToServerPacket {
    public static final int PACKET_ID = 404;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 40;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 40;
    public static final int MAX_SIZE = 40;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public BlockPosition selectionMin = new BlockPosition();
    @Nonnull public BlockPosition selectionMax = new BlockPosition();
    public int xNormal;
    public int yNormal;
    public int zNormal;
    public int numStacks;

    public BuilderToolStackArea() {
    }

    public BuilderToolStackArea(@Nonnull BlockPosition selectionMin, @Nonnull BlockPosition selectionMax, int xNormal, int yNormal, int zNormal, int numStacks) {
        this.selectionMin = selectionMin;
        this.selectionMax = selectionMax;
        this.xNormal = xNormal;
        this.yNormal = yNormal;
        this.zNormal = zNormal;
        this.numStacks = numStacks;
    }

    public BuilderToolStackArea(@Nonnull BuilderToolStackArea other) {
        this.selectionMin = other.selectionMin;
        this.selectionMax = other.selectionMax;
        this.xNormal = other.xNormal;
        this.yNormal = other.yNormal;
        this.zNormal = other.zNormal;
        this.numStacks = other.numStacks;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BuilderToolStackArea", offset, (int) mem.byteSize());
        long needed = (long) offset + 40;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BuilderToolStackArea", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static BlockPosition getSelectionMin(MemorySegment mem) {
        return getSelectionMin(mem, 0);
    }
    
    public static BlockPosition getSelectionMin(MemorySegment mem, int offset) {
        return BlockPosition.toObject(mem, offset + 0);
    }
    
    public static BlockPosition getSelectionMax(MemorySegment mem) {
        return getSelectionMax(mem, 0);
    }
    
    public static BlockPosition getSelectionMax(MemorySegment mem, int offset) {
        return BlockPosition.toObject(mem, offset + 12);
    }
    
    public static int getXNormal(MemorySegment mem) {
        return getXNormal(mem, 0);
    }
    
    public static int getXNormal(MemorySegment mem, int offset) {
        var value = mem.get(PacketIO.PROTO_INT, offset + 24);
        if (value < -1 || value > 1) throw ProtocolException.valueOutOfRange("XNormal", value, -1, 1);
        return value;
    }
    
    public static int getYNormal(MemorySegment mem) {
        return getYNormal(mem, 0);
    }
    
    public static int getYNormal(MemorySegment mem, int offset) {
        var value = mem.get(PacketIO.PROTO_INT, offset + 28);
        if (value < -1 || value > 1) throw ProtocolException.valueOutOfRange("YNormal", value, -1, 1);
        return value;
    }
    
    public static int getZNormal(MemorySegment mem) {
        return getZNormal(mem, 0);
    }
    
    public static int getZNormal(MemorySegment mem, int offset) {
        var value = mem.get(PacketIO.PROTO_INT, offset + 32);
        if (value < -1 || value > 1) throw ProtocolException.valueOutOfRange("ZNormal", value, -1, 1);
        return value;
    }
    
    public static int getNumStacks(MemorySegment mem) {
        return getNumStacks(mem, 0);
    }
    
    public static int getNumStacks(MemorySegment mem, int offset) {
        var value = mem.get(PacketIO.PROTO_INT, offset + 36);
        if (value < 0 || value > 20000) throw ProtocolException.valueOutOfRange("NumStacks", value, 0, 20000);
        return value;
    }
    
    
    
    
    
    public static BuilderToolStackArea toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BuilderToolStackArea toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BuilderToolStackArea and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BuilderToolStackArea toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        int v2 = mem.get(PacketIO.PROTO_INT, offset + 24);
        if (v2 < -1 || v2 > 1) throw ProtocolException.valueOutOfRange("XNormal", v2, -1, 1);
        
        int v3 = mem.get(PacketIO.PROTO_INT, offset + 28);
        if (v3 < -1 || v3 > 1) throw ProtocolException.valueOutOfRange("YNormal", v3, -1, 1);
        
        int v4 = mem.get(PacketIO.PROTO_INT, offset + 32);
        if (v4 < -1 || v4 > 1) throw ProtocolException.valueOutOfRange("ZNormal", v4, -1, 1);
        
        int v5 = mem.get(PacketIO.PROTO_INT, offset + 36);
        if (v5 < 0 || v5 > 20000) throw ProtocolException.valueOutOfRange("NumStacks", v5, 0, 20000);
        var result = new BuilderToolStackArea(
            BlockPosition.toObject(mem, offset + 0),
            BlockPosition.toObject(mem, offset + 12),
            v2,
            v3,
            v4,
            v5
        );
        if (cursor != null) cursor.position = offset + 40;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        this.selectionMin.serialize(mem, offset + 0);
        this.selectionMax.serialize(mem, offset + 12);
        if (this.xNormal < -1 || this.xNormal > 1) throw ProtocolException.valueOutOfRange("XNormal", this.xNormal, -1, 1); mem.set(PacketIO.PROTO_INT, offset + 24, this.xNormal);
        if (this.yNormal < -1 || this.yNormal > 1) throw ProtocolException.valueOutOfRange("YNormal", this.yNormal, -1, 1); mem.set(PacketIO.PROTO_INT, offset + 28, this.yNormal);
        if (this.zNormal < -1 || this.zNormal > 1) throw ProtocolException.valueOutOfRange("ZNormal", this.zNormal, -1, 1); mem.set(PacketIO.PROTO_INT, offset + 32, this.zNormal);
        if (this.numStacks < 0 || this.numStacks > 20000) throw ProtocolException.valueOutOfRange("NumStacks", this.numStacks, 0, 20000); mem.set(PacketIO.PROTO_INT, offset + 36, this.numStacks);
        
        
    
       return 40;
    }
    public int computeSize() {
        return 40;
    }

    public BuilderToolStackArea clone() {
        BuilderToolStackArea copy = new BuilderToolStackArea();
        copy.selectionMin = this.selectionMin.clone();
        copy.selectionMax = this.selectionMax.clone();
        copy.xNormal = this.xNormal;
        copy.yNormal = this.yNormal;
        copy.zNormal = this.zNormal;
        copy.numStacks = this.numStacks;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BuilderToolStackArea other)) return false;
        return java.util.Objects.equals(this.selectionMin, other.selectionMin) && java.util.Objects.equals(this.selectionMax, other.selectionMax) && this.xNormal == other.xNormal && this.yNormal == other.yNormal && this.zNormal == other.zNormal && this.numStacks == other.numStacks;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(selectionMin, selectionMax, xNormal, yNormal, zNormal, numStacks);
    }

}