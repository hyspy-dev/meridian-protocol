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
import java.util.UUID;

public class RecurringWorldEvent {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 37;
    public static final int VARIABLE_FIELD_COUNT = 4;
    public static final int VARIABLE_BLOCK_START = 53;
    public static final int MAX_SIZE = 65536073;

    @Nonnull public java.util.UUID uuid = new java.util.UUID(0L, 0L);
    @Nonnull public java.util.UUID worldUuid = new java.util.UUID(0L, 0L);
    @Nullable public String asset;
    @Nullable public String nameKey;
    @Nullable public String mapIntervalKey;
    @Nullable public String icon;
    public float remainingSeconds;

    public RecurringWorldEvent() {
    }

    public RecurringWorldEvent(@Nonnull java.util.UUID uuid, @Nonnull java.util.UUID worldUuid, @Nullable String asset, @Nullable String nameKey, @Nullable String mapIntervalKey, @Nullable String icon, float remainingSeconds) {
        this.uuid = uuid;
        this.worldUuid = worldUuid;
        this.asset = asset;
        this.nameKey = nameKey;
        this.mapIntervalKey = mapIntervalKey;
        this.icon = icon;
        this.remainingSeconds = remainingSeconds;
    }

    public RecurringWorldEvent(@Nonnull RecurringWorldEvent other) {
        this.uuid = other.uuid;
        this.worldUuid = other.worldUuid;
        this.asset = other.asset;
        this.nameKey = other.nameKey;
        this.mapIntervalKey = other.mapIntervalKey;
        this.icon = other.icon;
        this.remainingSeconds = other.remainingSeconds;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("RecurringWorldEvent", offset, (int) mem.byteSize());
        long needed = (long) offset + 53;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("RecurringWorldEvent", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static java.util.UUID getUuid(MemorySegment mem) {
        return getUuid(mem, 0);
    }
    
    public static java.util.UUID getUuid(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 1);
    }
    
    public static java.util.UUID getWorldUuid(MemorySegment mem) {
        return getWorldUuid(mem, 0);
    }
    
    public static java.util.UUID getWorldUuid(MemorySegment mem, int offset) {
        return PacketIO.readUUID(mem, offset + 17);
    }
    
    @Nullable
    public static String getAsset(MemorySegment mem) {
        return getAsset(mem, 0);
    }
    
    @Nullable
    public static String getAsset(MemorySegment mem, int offset) {
        return hasAsset(mem, offset) ? PacketIO.readVarString("Asset", mem, offset + getValidatedOffset(mem, offset, 37, 53, "Asset"), 4096000): null;
    }
    
    @Nullable
    public static String getNameKey(MemorySegment mem) {
        return getNameKey(mem, 0);
    }
    
    @Nullable
    public static String getNameKey(MemorySegment mem, int offset) {
        return hasNameKey(mem, offset) ? PacketIO.readVarString("NameKey", mem, offset + getValidatedOffset(mem, offset, 41, 53, "NameKey"), 4096000): null;
    }
    
    @Nullable
    public static String getMapIntervalKey(MemorySegment mem) {
        return getMapIntervalKey(mem, 0);
    }
    
    @Nullable
    public static String getMapIntervalKey(MemorySegment mem, int offset) {
        return hasMapIntervalKey(mem, offset) ? PacketIO.readVarString("MapIntervalKey", mem, offset + getValidatedOffset(mem, offset, 45, 53, "MapIntervalKey"), 4096000): null;
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem) {
        return getIcon(mem, 0);
    }
    
    @Nullable
    public static String getIcon(MemorySegment mem, int offset) {
        return hasIcon(mem, offset) ? PacketIO.readVarString("Icon", mem, offset + getValidatedOffset(mem, offset, 49, 53, "Icon"), 4096000): null;
    }
    
    public static float getRemainingSeconds(MemorySegment mem) {
        return getRemainingSeconds(mem, 0);
    }
    
    public static float getRemainingSeconds(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "RemainingSeconds");
    }
    
    public static boolean hasAsset(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasNameKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasMapIntervalKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasIcon(MemorySegment mem, int offset) {
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
    
    public static RecurringWorldEvent toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static RecurringWorldEvent toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one RecurringWorldEvent and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static RecurringWorldEvent toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 53;
        var varPos = 0;
        String v2 = null;
        if (hasAsset(mem, offset)) {
            requireSlot(mem, offset + 37, varPos, "Asset");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("Asset", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 37, -1, "Asset");
        }
        
        String v3 = null;
        if (hasNameKey(mem, offset)) {
            requireSlot(mem, offset + 41, varPos, "NameKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("NameKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 41, -1, "NameKey");
        }
        
        String v4 = null;
        if (hasMapIntervalKey(mem, offset)) {
            requireSlot(mem, offset + 45, varPos, "MapIntervalKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("MapIntervalKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 45, -1, "MapIntervalKey");
        }
        
        String v5 = null;
        if (hasIcon(mem, offset)) {
            requireSlot(mem, offset + 49, varPos, "Icon");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v5 = PacketIO.readVarString("Icon", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 49, -1, "Icon");
        }
        var result = new RecurringWorldEvent(
            PacketIO.readUUID(mem, offset + 1),
            PacketIO.readUUID(mem, offset + 17),
            v2,
            v3,
            v4,
            v5,
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 33), "RemainingSeconds")
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.asset != null) nullBits |= 0x01;
        if (this.nameKey != null) nullBits |= 0x02;
        if (this.mapIntervalKey != null) nullBits |= 0x04;
        if (this.icon != null) nullBits |= 0x08;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        PacketIO.writeUUID(mem, offset + 1, this.uuid);
        PacketIO.writeUUID(mem, offset + 17, this.worldUuid);
        PacketIO.requireFinite(this.remainingSeconds, "RemainingSeconds"); mem.set(PacketIO.PROTO_FLOAT, offset + 33, this.remainingSeconds);
        var varOffset = offset + 53;
        if (this.asset != null) {
            mem.set(PacketIO.PROTO_INT, offset + 37, varOffset - offset - 53);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.asset, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 37, -1);
        }
        if (this.nameKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 41, varOffset - offset - 53);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.nameKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 41, -1);
        }
        if (this.mapIntervalKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 45, varOffset - offset - 53);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.mapIntervalKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 45, -1);
        }
        if (this.icon != null) {
            mem.set(PacketIO.PROTO_INT, offset + 49, varOffset - offset - 53);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.icon, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 49, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 53;
        if (asset != null) size += PacketIO.stringSize(asset);
    if (nameKey != null) size += PacketIO.stringSize(nameKey);
    if (mapIntervalKey != null) size += PacketIO.stringSize(mapIntervalKey);
    if (icon != null) size += PacketIO.stringSize(icon);

        return size;
    }

    public RecurringWorldEvent clone() {
        RecurringWorldEvent copy = new RecurringWorldEvent();
        copy.uuid = this.uuid;
        copy.worldUuid = this.worldUuid;
        copy.asset = this.asset;
        copy.nameKey = this.nameKey;
        copy.mapIntervalKey = this.mapIntervalKey;
        copy.icon = this.icon;
        copy.remainingSeconds = this.remainingSeconds;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof RecurringWorldEvent other)) return false;
        return java.util.Objects.equals(this.uuid, other.uuid) && java.util.Objects.equals(this.worldUuid, other.worldUuid) && java.util.Objects.equals(this.asset, other.asset) && java.util.Objects.equals(this.nameKey, other.nameKey) && java.util.Objects.equals(this.mapIntervalKey, other.mapIntervalKey) && java.util.Objects.equals(this.icon, other.icon) && this.remainingSeconds == other.remainingSeconds;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(uuid, worldUuid, asset, nameKey, mapIntervalKey, icon, remainingSeconds);
    }

}