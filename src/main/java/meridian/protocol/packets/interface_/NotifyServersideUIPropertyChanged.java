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


public class NotifyServersideUIPropertyChanged implements Packet, ToServerPacket {
    public static final int PACKET_ID = 206;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 18;
    public static final int MAX_SIZE = 1677721600;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public UISurfaceKind kind = UISurfaceKind.Page;
    @Nonnull public String id = "";
    @Nonnull public String propertyName = "";
    @Nonnull public String context = "";
    @Nullable public UIDataValue newValue;

    public NotifyServersideUIPropertyChanged() {
    }

    public NotifyServersideUIPropertyChanged(@Nonnull UISurfaceKind kind, @Nonnull String id, @Nonnull String propertyName, @Nonnull String context, @Nullable UIDataValue newValue) {
        this.kind = kind;
        this.id = id;
        this.propertyName = propertyName;
        this.context = context;
        this.newValue = newValue;
    }

    public NotifyServersideUIPropertyChanged(@Nonnull NotifyServersideUIPropertyChanged other) {
        this.kind = other.kind;
        this.id = other.id;
        this.propertyName = other.propertyName;
        this.context = other.context;
        this.newValue = other.newValue;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("NotifyServersideUIPropertyChanged", offset, (int) mem.byteSize());
        long needed = (long) offset + 18;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("NotifyServersideUIPropertyChanged", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static UISurfaceKind getKind(MemorySegment mem) {
        return getKind(mem, 0);
    }
    
    public static UISurfaceKind getKind(MemorySegment mem, int offset) {
        return UISurfaceKind.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1));
    }
    
    public static String getId(MemorySegment mem) {
        return getId(mem, 0);
    }
    
    public static String getId(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Id", mem, offset + getValidatedOffset(mem, offset, 2, 18, "Id"), 128);
    }
    
    public static String getPropertyName(MemorySegment mem) {
        return getPropertyName(mem, 0);
    }
    
    public static String getPropertyName(MemorySegment mem, int offset) {
        return PacketIO.readVarString("PropertyName", mem, offset + getValidatedOffset(mem, offset, 6, 18, "PropertyName"), 128);
    }
    
    public static String getContext(MemorySegment mem) {
        return getContext(mem, 0);
    }
    
    public static String getContext(MemorySegment mem, int offset) {
        return PacketIO.readVarString("Context", mem, offset + getValidatedOffset(mem, offset, 10, 18, "Context"), 128);
    }
    
    @Nullable
    public static UIDataValue getNewValue(MemorySegment mem) {
        return getNewValue(mem, 0);
    }
    
    @Nullable
    public static UIDataValue getNewValue(MemorySegment mem, int offset) {
        return hasNewValue(mem, offset) ? UIDataValue.toObject(mem, offset + getValidatedOffset(mem, offset, 14, 18, "NewValue")): null;
    }
    
    public static boolean hasNewValue(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
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
    
    public static NotifyServersideUIPropertyChanged toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static NotifyServersideUIPropertyChanged toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one NotifyServersideUIPropertyChanged and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static NotifyServersideUIPropertyChanged toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 18;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v1;
        requireSlot(mem, offset + 2, varPos, "Id");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("Id", mem, off, 0, 128, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v2;
        requireSlot(mem, offset + 6, varPos, "PropertyName");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("PropertyName", mem, off, 0, 128, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v3;
        requireSlot(mem, offset + 10, varPos, "Context");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("Context", mem, off, 0, 128, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        UIDataValue v4 = null;
        if (hasNewValue(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "NewValue");
            v4 = UIDataValue.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 14, -1, "NewValue");
        }
        var result = new NotifyServersideUIPropertyChanged(
            UISurfaceKind.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)),
            v1,
            v2,
            v3,
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.newValue != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.kind.getValue());
        var varOffset = offset + 18;
        mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 18);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.id, 128);
        mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 18);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.propertyName, 128);
        mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 18);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.context, 128);
        if (this.newValue != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 18);
            varOffset += this.newValue.serializeWithTypeId(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 18;
        size += PacketIO.stringSize(id);
    size += PacketIO.stringSize(propertyName);
    size += PacketIO.stringSize(context);
    if (newValue != null) size += newValue.computeSizeWithTypeId();

        return size;
    }

    public NotifyServersideUIPropertyChanged clone() {
        NotifyServersideUIPropertyChanged copy = new NotifyServersideUIPropertyChanged();
        copy.kind = this.kind;
        copy.id = this.id;
        copy.propertyName = this.propertyName;
        copy.context = this.context;
        copy.newValue = this.newValue;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof NotifyServersideUIPropertyChanged other)) return false;
        return java.util.Objects.equals(this.kind, other.kind) && java.util.Objects.equals(this.id, other.id) && java.util.Objects.equals(this.propertyName, other.propertyName) && java.util.Objects.equals(this.context, other.context) && java.util.Objects.equals(this.newValue, other.newValue);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(kind, id, propertyName, context, newValue);
    }

}