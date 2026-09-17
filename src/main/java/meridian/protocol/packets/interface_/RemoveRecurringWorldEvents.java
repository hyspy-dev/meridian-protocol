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
import java.util.UUID;

public class RemoveRecurringWorldEvents implements Packet, ToClientPacket {
    public static final int PACKET_ID = 256;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 65536005;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public java.util.UUID[] events = new java.util.UUID[0];

    public RemoveRecurringWorldEvents() {
    }

    public RemoveRecurringWorldEvents(@Nonnull java.util.UUID[] events) {
        this.events = events;
    }

    public RemoveRecurringWorldEvents(@Nonnull RemoveRecurringWorldEvents other) {
        this.events = other.events;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RemoveRecurringWorldEvents", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemoveRecurringWorldEvents", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID[] getEvents(MemorySegment mem) {
        return getEvents(mem, 0);
    }
    
    public static java.util.UUID[] getEvents(MemorySegment mem, int offset) {
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Events");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Events", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 16 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Events", (int) java.lang.Math.min(off + lenOffset + (long) len * 16, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new java.util.UUID[len];
        for (var i = 0; i < len; i++) {
            data[i] = PacketIO.readUUID(mem, off + i * 16);
        }
        return data;
    }
    
    
    
    
    
    public static RemoveRecurringWorldEvents toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RemoveRecurringWorldEvents toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RemoveRecurringWorldEvents and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RemoveRecurringWorldEvents toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        java.util.UUID[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Events");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Events", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 16 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Events", (int) java.lang.Math.min(off + lenOffset + (long) len * 16, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new java.util.UUID[len];
            for (var i = 0; i < len; i++) {
                v0[i] = PacketIO.readUUID(mem, off + i * 16);
            }
            varPos = off + len * 16 - varBase;
        }
        var result = new RemoveRecurringWorldEvents(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (events.length > 4096000) throw ProtocolException.arrayTooLong("Events", events.length, 4096000);
        varOffset += VarInt.set(mem, varOffset, this.events.length);
        
        for (var i = 0; i < this.events.length; i++) {
            PacketIO.writeUUID(mem, varOffset + i * 16, this.events[i]);
        }
        varOffset += this.events.length * 16;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        size += VarInt.size(events.length) + events.length * 16;

        return size;
    }

    public RemoveRecurringWorldEvents clone() {
        RemoveRecurringWorldEvents copy = new RemoveRecurringWorldEvents();
        copy.events = java.util.Arrays.copyOf(this.events, this.events.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RemoveRecurringWorldEvents other)) return false;
        return java.util.Arrays.equals(this.events, other.events);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(events);
        return result;
    }

}