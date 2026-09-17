// Auto-generated - do not edit
package meridian.protocol.packets.world;

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


public class ServerSetHeights implements Packet, ToClientPacket {
    public static final int PACKET_ID = 184;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 8;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 8;
    public static final int MAX_SIZE = 6157;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Chunks;
    }

    public int x;
    public int z;
    @Nonnull public SetHeightCmd[] heights = new SetHeightCmd[0];

    public ServerSetHeights() {
    }

    public ServerSetHeights(int x, int z, @Nonnull SetHeightCmd[] heights) {
        this.x = x;
        this.z = z;
        this.heights = heights;
    }

    public ServerSetHeights(@Nonnull ServerSetHeights other) {
        this.x = other.x;
        this.z = other.z;
        this.heights = other.heights;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ServerSetHeights", offset, (int) mem.byteSize());
        long needed = (long) offset + 8;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ServerSetHeights", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getX(MemorySegment mem) {
        return getX(mem, 0);
    }
    
    public static int getX(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static int getZ(MemorySegment mem) {
        return getZ(mem, 0);
    }
    
    public static int getZ(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 4);
    }
    
    public static SetHeightCmd[] getHeights(MemorySegment mem) {
        return getHeights(mem, 0);
    }
    
    public static SetHeightCmd[] getHeights(MemorySegment mem, int offset) {
        var off = offset + 8;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Heights");
        var len = (int) packed;
        if (len > 1024) throw ProtocolException.arrayTooLong("Heights", len, 1024);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 6 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Heights", (int) java.lang.Math.min(off + lenOffset + (long) len * 6, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new SetHeightCmd[len];
        for (var i = 0; i < len; i++) {
            data[i] = SetHeightCmd.toObject(mem, off + i * 6);
        }
        return data;
    }
    
    
    
    
    
    public static ServerSetHeights toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ServerSetHeights toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ServerSetHeights and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ServerSetHeights toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 8;
        var varPos = 0;
        SetHeightCmd[] v2;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Heights");
            var len = (int) packed;
            if (len > 1024) throw ProtocolException.arrayTooLong("Heights", len, 1024);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 6 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Heights", (int) java.lang.Math.min(off + lenOffset + (long) len * 6, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v2 = new SetHeightCmd[len];
            for (var i = 0; i < len; i++) {
                v2[i] = SetHeightCmd.toObject(mem, off + i * 6);
            }
            varPos = off + len * 6 - varBase;
        }
        var result = new ServerSetHeights(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_INT, offset + 4),
            v2
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.x);
        mem.set(PacketIO.PROTO_INT, offset + 4, this.z);
        var varOffset = offset + 8;
        if (heights.length > 1024) throw ProtocolException.arrayTooLong("Heights", heights.length, 1024);
        varOffset += VarInt.set(mem, varOffset, this.heights.length);
        
        var heightsValueOffset = 0;
        for (var i = 0; i < this.heights.length; i++) {
            heightsValueOffset += this.heights[i].serialize(mem, varOffset + heightsValueOffset);
        }
        varOffset += heightsValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 8;
        size += VarInt.size(heights.length) + heights.length * 6;

        return size;
    }

    public ServerSetHeights clone() {
        ServerSetHeights copy = new ServerSetHeights();
        copy.x = this.x;
        copy.z = this.z;
        copy.heights = java.util.Arrays.stream(this.heights).map(e -> e.clone()).toArray(SetHeightCmd[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ServerSetHeights other)) return false;
        return this.x == other.x && this.z == other.z && java.util.Arrays.equals(this.heights, other.heights);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(x);
        result = 31 * result + Integer.hashCode(z);
        result = 31 * result + java.util.Arrays.hashCode(heights);
        return result;
    }

}