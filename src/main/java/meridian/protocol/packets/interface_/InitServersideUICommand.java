// Auto-generated - do not edit
package meridian.protocol.packets.interface_;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class InitServersideUICommand extends ServersideUICommand {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 7;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 15;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public String filePath = "";
    @Nullable public HudWidgetSlot slot;
    @Nullable public Integer order;
    @Nullable public ServersidePageLifetime lifetime;
    @Nullable public UIObjectDataValue dataContext;

    public InitServersideUICommand() {
    }

    public InitServersideUICommand(@Nonnull String filePath, @Nullable HudWidgetSlot slot, @Nullable Integer order, @Nullable ServersidePageLifetime lifetime, @Nullable UIObjectDataValue dataContext) {
        this.filePath = filePath;
        this.slot = slot;
        this.order = order;
        this.lifetime = lifetime;
        this.dataContext = dataContext;
    }

    public InitServersideUICommand(@Nonnull InitServersideUICommand other) {
        this.filePath = other.filePath;
        this.slot = other.slot;
        this.order = other.order;
        this.lifetime = other.lifetime;
        this.dataContext = other.dataContext;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("InitServersideUICommand", offset, (int) mem.byteSize());
        long needed = (long) offset + 15;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("InitServersideUICommand", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getFilePath(MemorySegment mem) {
        return getFilePath(mem, 0);
    }
    
    public static String getFilePath(MemorySegment mem, int offset) {
        return PacketIO.readVarString("FilePath", mem, offset + getValidatedOffset(mem, offset, 7, 15, "FilePath"), 512);
    }
    
    @Nullable
    public static HudWidgetSlot getSlot(MemorySegment mem) {
        return getSlot(mem, 0);
    }
    
    @Nullable
    public static HudWidgetSlot getSlot(MemorySegment mem, int offset) {
        return hasSlot(mem, offset) ? HudWidgetSlot.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)): null;
    }
    
    @Nullable
    public static Integer getOrder(MemorySegment mem) {
        return getOrder(mem, 0);
    }
    
    @Nullable
    public static Integer getOrder(MemorySegment mem, int offset) {
        return hasOrder(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 2): null;
    }
    
    @Nullable
    public static ServersidePageLifetime getLifetime(MemorySegment mem) {
        return getLifetime(mem, 0);
    }
    
    @Nullable
    public static ServersidePageLifetime getLifetime(MemorySegment mem, int offset) {
        return hasLifetime(mem, offset) ? ServersidePageLifetime.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 6)): null;
    }
    
    @Nullable
    public static UIObjectDataValue getDataContext(MemorySegment mem) {
        return getDataContext(mem, 0);
    }
    
    @Nullable
    public static UIObjectDataValue getDataContext(MemorySegment mem, int offset) {
        return hasDataContext(mem, offset) ? UIObjectDataValue.toObject(mem, offset + getValidatedOffset(mem, offset, 11, 15, "DataContext")): null;
    }
    
    public static boolean hasSlot(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasOrder(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasLifetime(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasDataContext(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
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
    
    public static InitServersideUICommand toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static InitServersideUICommand toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one InitServersideUICommand and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static InitServersideUICommand toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 15;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 7, varPos, "FilePath");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("FilePath", mem, off, 0, 512, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        UIObjectDataValue v4 = null;
        if (hasDataContext(mem, offset)) {
            requireSlot(mem, offset + 11, varPos, "DataContext");
            v4 = UIObjectDataValue.toObject(mem, varBase + varPos, walkCursor);
            varPos = walkCursor.position - varBase;
        } else {
            requireSlot(mem, offset + 11, -1, "DataContext");
        }
        var result = new InitServersideUICommand(
            v0,
            hasSlot(mem, offset) ? HudWidgetSlot.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 1)) : null,
            hasOrder(mem, offset) ? mem.get(PacketIO.PROTO_INT, offset + 2) : null,
            hasLifetime(mem, offset) ? ServersidePageLifetime.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 6)) : null,
            v4
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.slot != null) nullBits |= 0x01;
        if (this.order != null) nullBits |= 0x02;
        if (this.lifetime != null) nullBits |= 0x04;
        if (this.dataContext != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        if (this.slot != null) {
            mem.set(PacketIO.PROTO_BYTE, offset + 1, (byte) this.slot.getValue());
        } else {
            mem.asSlice(offset + 1, 1).fill((byte) 0); 
        }
        if (this.order != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, this.order);
        } else {
            mem.asSlice(offset + 2, 4).fill((byte) 0); 
        }
        if (this.lifetime != null) {
            mem.set(PacketIO.PROTO_BYTE, offset + 6, (byte) this.lifetime.getValue());
        } else {
            mem.asSlice(offset + 6, 1).fill((byte) 0); 
        }
        var varOffset = offset + 15;
        mem.set(PacketIO.PROTO_INT, offset + 7, varOffset - offset - 15);
        varOffset += PacketIO.writeVarString(mem, varOffset, this.filePath, 512);
        if (this.dataContext != null) {
            mem.set(PacketIO.PROTO_INT, offset + 11, varOffset - offset - 15);
            varOffset += this.dataContext.serialize(mem, varOffset);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 11, -1);
        }
    
       return varOffset - offset;
    }
    @Override
    public int computeSize() {
        int size = 15;
        size += PacketIO.stringSize(filePath);
    if (dataContext != null) size += dataContext.computeSize();

        return size;
    }

    public InitServersideUICommand clone() {
        InitServersideUICommand copy = new InitServersideUICommand();
        copy.filePath = this.filePath;
        copy.slot = this.slot;
        copy.order = this.order;
        copy.lifetime = this.lifetime;
        copy.dataContext = this.dataContext != null ? this.dataContext.clone() : null;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof InitServersideUICommand other)) return false;
        return java.util.Objects.equals(this.filePath, other.filePath) && java.util.Objects.equals(this.slot, other.slot) && java.util.Objects.equals(this.order, other.order) && java.util.Objects.equals(this.lifetime, other.lifetime) && java.util.Objects.equals(this.dataContext, other.dataContext);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(filePath, slot, order, lifetime, dataContext);
    }

}