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


public class UpdateRecurringWorldEvents implements Packet, ToClientPacket {
    public static final int PACKET_ID = 255;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public RecurringWorldEvent[] events = new RecurringWorldEvent[0];

    public UpdateRecurringWorldEvents() {
    }

    public UpdateRecurringWorldEvents(@Nonnull RecurringWorldEvent[] events) {
        this.events = events;
    }

    public UpdateRecurringWorldEvents(@Nonnull UpdateRecurringWorldEvents other) {
        this.events = other.events;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateRecurringWorldEvents", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateRecurringWorldEvents", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static RecurringWorldEvent[] getEvents(MemorySegment mem) {
        return getEvents(mem, 0);
    }
    
    public static RecurringWorldEvent[] getEvents(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Events");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Events", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 53 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Events", (int) java.lang.Math.min(off + lenOffset + (long) len * 53, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new RecurringWorldEvent[len];
        for (var i = 0; i < len; i++) {
            data[i] = RecurringWorldEvent.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    
    
    
    
    public static UpdateRecurringWorldEvents toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateRecurringWorldEvents toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateRecurringWorldEvents and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateRecurringWorldEvents toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        RecurringWorldEvent[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Events");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Events", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 53 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Events", (int) java.lang.Math.min(off + lenOffset + (long) len * 53, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new RecurringWorldEvent[len];
            for (var i = 0; i < len; i++) {
                v0[i] = RecurringWorldEvent.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new UpdateRecurringWorldEvents(
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
        
        var eventsValueOffset = 0;
        for (var i = 0; i < this.events.length; i++) {
            eventsValueOffset += this.events[i].serialize(mem, varOffset + eventsValueOffset);
        }
        varOffset += eventsValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        int eventsSize = 0;
for (var elem : events) eventsSize += elem.computeSize();
size += VarInt.size(events.length) + eventsSize;

        return size;
    }

    public UpdateRecurringWorldEvents clone() {
        UpdateRecurringWorldEvents copy = new UpdateRecurringWorldEvents();
        copy.events = java.util.Arrays.stream(this.events).map(e -> e.clone()).toArray(RecurringWorldEvent[]::new);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateRecurringWorldEvents other)) return false;
        return java.util.Arrays.equals(this.events, other.events);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(events);
        return result;
    }

}