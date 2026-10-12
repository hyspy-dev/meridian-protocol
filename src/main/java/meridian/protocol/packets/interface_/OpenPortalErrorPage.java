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
import meridian.protocol.FormattedMessage;

public class OpenPortalErrorPage implements Packet, ToClientPacket {
    public static final int PACKET_ID = 264;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 9;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public FormattedMessage title;
    @Nullable public FormattedMessage message;

    public OpenPortalErrorPage() {
    }

    public OpenPortalErrorPage(@Nullable FormattedMessage title, @Nullable FormattedMessage message) {
        this.title = title;
        this.message = message;
    }

    public OpenPortalErrorPage(@Nonnull OpenPortalErrorPage other) {
        this.title = other.title;
        this.message = other.message;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("OpenPortalErrorPage", offset, (int) mem.byteSize());
        long needed = (long) offset + 9;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("OpenPortalErrorPage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static FormattedMessage getTitle(MemorySegment mem) {
        return getTitle(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getTitle(MemorySegment mem, int offset) {
        return hasTitle(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 1, 9, "Title")): null;
    }
    
    @Nullable
    public static FormattedMessage getMessage(MemorySegment mem) {
        return getMessage(mem, 0);
    }
    
    @Nullable
    public static FormattedMessage getMessage(MemorySegment mem, int offset) {
        return hasMessage(mem, offset) ? FormattedMessage.toObject(mem, offset + getValidatedOffset(mem, offset, 5, 9, "Message")): null;
    }
    
    public static boolean hasTitle(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasMessage(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    private static int getValidatedOffset(MemorySegment buffer, int base, int slotPosition, int varBlockStart, String fieldName) {
        int offset = buffer.get(PacketIO.PROTO_INT, base + slotPosition);
        if (offset < 0 || offset > buffer.byteSize() - base - varBlockStart)
            throw ProtocolException.invalidOffset(fieldName, offset, (int) buffer.byteSize());
        return varBlockStart + offset;
    }
    
    /**
     * Rejects an offset slot that does not name the position the field-order walk reached. A
     * present field must sit where the previous field ended, and an absent field carries -1, so
     * the slot a random-access getter resolves and the walk describe the same bytes.
     */
    private static void requireSlot(MemorySegment mem, int slotPosition, int expected, String fieldName) {
        int slot = mem.get(PacketIO.PROTO_INT, slotPosition);
        if (slot != expected) throw ProtocolException.nonCanonicalLayout(fieldName, slot, expected);
    }
    
    public static OpenPortalErrorPage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static OpenPortalErrorPage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one OpenPortalErrorPage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static OpenPortalErrorPage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 9;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        FormattedMessage v0 = null;
        if (hasTitle(mem, offset)) {
            requireSlot(mem, offset + 1, varPos, "Title");
            v0 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 1, -1, "Title");
        }
        
        FormattedMessage v1 = null;
        if (hasMessage(mem, offset)) {
            requireSlot(mem, offset + 5, varPos, "Message");
            v1 = FormattedMessage.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 5, -1, "Message");
        }
        var result = new OpenPortalErrorPage(
            v0,
            v1
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.title != null) nullBits |= 0x01;
        if (this.message != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        
        var varOffset = offset + 9;
        if (this.title != null) {
            mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 9);
            varOffset += this.title.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 1, -1);
        }
        if (this.message != null) {
            mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 9);
            varOffset += this.message.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 5, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 9;
        if (title != null) size += title.computeSize();
    if (message != null) size += message.computeSize();

        return size;
    }

    public OpenPortalErrorPage clone() {
        OpenPortalErrorPage copy = new OpenPortalErrorPage();
        copy.title = this.title != null ? this.title.clone() : null;
        copy.message = this.message != null ? this.message.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OpenPortalErrorPage other)) return false;
        return java.util.Objects.equals(this.title, other.title) && java.util.Objects.equals(this.message, other.message);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(title, message);
    }

}