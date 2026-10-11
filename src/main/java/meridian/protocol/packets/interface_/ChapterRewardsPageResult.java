// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

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


public class ChapterRewardsPageResult implements Packet, ToServerPacket {
    public static final int PACKET_ID = 221;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public boolean leave;

    public ChapterRewardsPageResult() {
    }

    public ChapterRewardsPageResult(boolean leave) {
        this.leave = leave;
    }

    public ChapterRewardsPageResult(@Nonnull ChapterRewardsPageResult other) {
        this.leave = other.leave;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ChapterRewardsPageResult", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ChapterRewardsPageResult", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getLeave(MemorySegment mem) {
        return getLeave(mem, 0);
    }
    
    public static boolean getLeave(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 0);
    }
    
    
    
    
    
    public static ChapterRewardsPageResult toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ChapterRewardsPageResult toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ChapterRewardsPageResult and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ChapterRewardsPageResult toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new ChapterRewardsPageResult(
            mem.get(PacketIO.PROTO_BOOL, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BOOL, offset + 0, this.leave);
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public ChapterRewardsPageResult clone() {
        ChapterRewardsPageResult copy = new ChapterRewardsPageResult();
        copy.leave = this.leave;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ChapterRewardsPageResult other)) return false;
        return this.leave == other.leave;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(leave);
    }

}