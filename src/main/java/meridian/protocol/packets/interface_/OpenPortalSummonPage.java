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


public class OpenPortalSummonPage implements Packet, ToClientPacket {
    public static final int PACKET_ID = 257;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 25;
    public static final int VARIABLE_FIELD_COUNT = 3;
    public static final int VARIABLE_BLOCK_START = 37;
    public static final int MAX_SIZE = 49152052;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    public int promptId;
    @Nullable public String nameKey;
    @Nullable public String loreKey;
    public int timeLimitSeconds;
    public int bonusSeconds;
    public int allowedEntryCount;
    @Nullable public String keyItemId;
    public int keysHeld;
    public int keysRequired;

    public OpenPortalSummonPage() {
    }

    public OpenPortalSummonPage(int promptId, @Nullable String nameKey, @Nullable String loreKey, int timeLimitSeconds, int bonusSeconds, int allowedEntryCount, @Nullable String keyItemId, int keysHeld, int keysRequired) {
        this.promptId = promptId;
        this.nameKey = nameKey;
        this.loreKey = loreKey;
        this.timeLimitSeconds = timeLimitSeconds;
        this.bonusSeconds = bonusSeconds;
        this.allowedEntryCount = allowedEntryCount;
        this.keyItemId = keyItemId;
        this.keysHeld = keysHeld;
        this.keysRequired = keysRequired;
    }

    public OpenPortalSummonPage(@Nonnull OpenPortalSummonPage other) {
        this.promptId = other.promptId;
        this.nameKey = other.nameKey;
        this.loreKey = other.loreKey;
        this.timeLimitSeconds = other.timeLimitSeconds;
        this.bonusSeconds = other.bonusSeconds;
        this.allowedEntryCount = other.allowedEntryCount;
        this.keyItemId = other.keyItemId;
        this.keysHeld = other.keysHeld;
        this.keysRequired = other.keysRequired;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("OpenPortalSummonPage", offset, (int) mem.byteSize());
        long needed = (long) offset + 37;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("OpenPortalSummonPage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getPromptId(MemorySegment mem) {
        return getPromptId(mem, 0);
    }
    
    public static int getPromptId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    @Nullable
    public static String getNameKey(MemorySegment mem) {
        return getNameKey(mem, 0);
    }
    
    @Nullable
    public static String getNameKey(MemorySegment mem, int offset) {
        return hasNameKey(mem, offset) ? PacketIO.readVarString("NameKey", mem, offset + getValidatedOffset(mem, offset, 25, 37, "NameKey"), 4096000): null;
    }
    
    @Nullable
    public static String getLoreKey(MemorySegment mem) {
        return getLoreKey(mem, 0);
    }
    
    @Nullable
    public static String getLoreKey(MemorySegment mem, int offset) {
        return hasLoreKey(mem, offset) ? PacketIO.readVarString("LoreKey", mem, offset + getValidatedOffset(mem, offset, 29, 37, "LoreKey"), 4096000): null;
    }
    
    public static int getTimeLimitSeconds(MemorySegment mem) {
        return getTimeLimitSeconds(mem, 0);
    }
    
    public static int getTimeLimitSeconds(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getBonusSeconds(MemorySegment mem) {
        return getBonusSeconds(mem, 0);
    }
    
    public static int getBonusSeconds(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    public static int getAllowedEntryCount(MemorySegment mem) {
        return getAllowedEntryCount(mem, 0);
    }
    
    public static int getAllowedEntryCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 13);
    }
    
    @Nullable
    public static String getKeyItemId(MemorySegment mem) {
        return getKeyItemId(mem, 0);
    }
    
    @Nullable
    public static String getKeyItemId(MemorySegment mem, int offset) {
        return hasKeyItemId(mem, offset) ? PacketIO.readVarString("KeyItemId", mem, offset + getValidatedOffset(mem, offset, 33, 37, "KeyItemId"), 4096000): null;
    }
    
    public static int getKeysHeld(MemorySegment mem) {
        return getKeysHeld(mem, 0);
    }
    
    public static int getKeysHeld(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 17);
    }
    
    public static int getKeysRequired(MemorySegment mem) {
        return getKeysRequired(mem, 0);
    }
    
    public static int getKeysRequired(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 21);
    }
    
    public static boolean hasNameKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasLoreKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasKeyItemId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static OpenPortalSummonPage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static OpenPortalSummonPage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one OpenPortalSummonPage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static OpenPortalSummonPage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 37;
        var varPos = 0;
        String v1 = null;
        if (hasNameKey(mem, offset)) {
            requireSlot(mem, offset + 25, varPos, "NameKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("NameKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 25, -1, "NameKey");
        }
        
        String v2 = null;
        if (hasLoreKey(mem, offset)) {
            requireSlot(mem, offset + 29, varPos, "LoreKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("LoreKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 29, -1, "LoreKey");
        }
        
        String v6 = null;
        if (hasKeyItemId(mem, offset)) {
            requireSlot(mem, offset + 33, varPos, "KeyItemId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v6 = PacketIO.readVarString("KeyItemId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 33, -1, "KeyItemId");
        }
        var result = new OpenPortalSummonPage(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            v2,
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            mem.get(PacketIO.PROTO_INT, offset + 13),
            v6,
            mem.get(PacketIO.PROTO_INT, offset + 17),
            mem.get(PacketIO.PROTO_INT, offset + 21)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.nameKey != null) nullBits |= 0x01;
        if (this.loreKey != null) nullBits |= 0x02;
        if (this.keyItemId != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.promptId);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.timeLimitSeconds);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.bonusSeconds);
        mem.set(PacketIO.PROTO_INT, offset + 13, this.allowedEntryCount);
        mem.set(PacketIO.PROTO_INT, offset + 17, this.keysHeld);
        mem.set(PacketIO.PROTO_INT, offset + 21, this.keysRequired);
        var varOffset = offset + 37;
        if (this.nameKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 25, varOffset - offset - 37);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.nameKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 25, -1);
        }
        if (this.loreKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 29, varOffset - offset - 37);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.loreKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 29, -1);
        }
        if (this.keyItemId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 33, varOffset - offset - 37);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.keyItemId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 33, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 37;
        if (nameKey != null) size += PacketIO.stringSize(nameKey);
    if (loreKey != null) size += PacketIO.stringSize(loreKey);
    if (keyItemId != null) size += PacketIO.stringSize(keyItemId);

        return size;
    }

    public OpenPortalSummonPage clone() {
        OpenPortalSummonPage copy = new OpenPortalSummonPage();
        copy.promptId = this.promptId;
        copy.nameKey = this.nameKey;
        copy.loreKey = this.loreKey;
        copy.timeLimitSeconds = this.timeLimitSeconds;
        copy.bonusSeconds = this.bonusSeconds;
        copy.allowedEntryCount = this.allowedEntryCount;
        copy.keyItemId = this.keyItemId;
        copy.keysHeld = this.keysHeld;
        copy.keysRequired = this.keysRequired;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OpenPortalSummonPage other)) return false;
        return this.promptId == other.promptId && java.util.Objects.equals(this.nameKey, other.nameKey) && java.util.Objects.equals(this.loreKey, other.loreKey) && this.timeLimitSeconds == other.timeLimitSeconds && this.bonusSeconds == other.bonusSeconds && this.allowedEntryCount == other.allowedEntryCount && java.util.Objects.equals(this.keyItemId, other.keyItemId) && this.keysHeld == other.keysHeld && this.keysRequired == other.keysRequired;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(promptId, nameKey, loreKey, timeLimitSeconds, bonusSeconds, allowedEntryCount, keyItemId, keysHeld, keysRequired);
    }

}