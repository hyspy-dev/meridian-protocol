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


public class PortalSummonPageResult implements Packet, ToServerPacket {
    public static final int PACKET_ID = 258;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 5;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 5;
    public static final int MAX_SIZE = 5;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int promptId;
    public boolean summon;

    public PortalSummonPageResult() {
    }

    public PortalSummonPageResult(int promptId, boolean summon) {
        this.promptId = promptId;
        this.summon = summon;
    }

    public PortalSummonPageResult(@Nonnull PortalSummonPageResult other) {
        this.promptId = other.promptId;
        this.summon = other.summon;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PortalSummonPageResult", offset, (int) mem.byteSize());
        long needed = (long) offset + 5;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PortalSummonPageResult", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getPromptId(MemorySegment mem) {
        return getPromptId(mem, 0);
    }
    
    public static int getPromptId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 0);
    }
    
    public static boolean getSummon(MemorySegment mem) {
        return getSummon(mem, 0);
    }
    
    public static boolean getSummon(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 4);
    }
    
    
    
    
    
    public static PortalSummonPageResult toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PortalSummonPageResult toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PortalSummonPageResult and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PortalSummonPageResult toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new PortalSummonPageResult(
            mem.get(PacketIO.PROTO_INT, offset + 0),
            mem.get(PacketIO.PROTO_BOOL, offset + 4)
        );
        if (cursor != null) cursor.position = offset + 5;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_INT, offset + 0, this.promptId);
        mem.set(PacketIO.PROTO_BOOL, offset + 4, this.summon);
        
        
    
       return 5;
    }
    public int computeSize() {
        return 5;
    }

    public PortalSummonPageResult clone() {
        PortalSummonPageResult copy = new PortalSummonPageResult();
        copy.promptId = this.promptId;
        copy.summon = this.summon;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PortalSummonPageResult other)) return false;
        return this.promptId == other.promptId && this.summon == other.summon;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(promptId, summon);
    }

}