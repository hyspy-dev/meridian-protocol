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


public class OpenPortalActivePage implements Packet, ToClientPacket {
    public static final int PACKET_ID = 259;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 28;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 36;
    public static final int MAX_SIZE = 81920066;

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
    public int timeLimitSeconds;
    public int remainingSeconds;
    public boolean timerStarted;
    public int allowedEntryCount;
    public int entriesUsed;
    public boolean anyoneEntered;
    public int playerCount;
    @Nullable public String[] playerNames;
    public boolean isForming;

    public OpenPortalActivePage() {
    }

    public OpenPortalActivePage(int promptId, @Nullable String nameKey, int timeLimitSeconds, int remainingSeconds, boolean timerStarted, int allowedEntryCount, int entriesUsed, boolean anyoneEntered, int playerCount, @Nullable String[] playerNames, boolean isForming) {
        this.promptId = promptId;
        this.nameKey = nameKey;
        this.timeLimitSeconds = timeLimitSeconds;
        this.remainingSeconds = remainingSeconds;
        this.timerStarted = timerStarted;
        this.allowedEntryCount = allowedEntryCount;
        this.entriesUsed = entriesUsed;
        this.anyoneEntered = anyoneEntered;
        this.playerCount = playerCount;
        this.playerNames = playerNames;
        this.isForming = isForming;
    }

    public OpenPortalActivePage(@Nonnull OpenPortalActivePage other) {
        this.promptId = other.promptId;
        this.nameKey = other.nameKey;
        this.timeLimitSeconds = other.timeLimitSeconds;
        this.remainingSeconds = other.remainingSeconds;
        this.timerStarted = other.timerStarted;
        this.allowedEntryCount = other.allowedEntryCount;
        this.entriesUsed = other.entriesUsed;
        this.anyoneEntered = other.anyoneEntered;
        this.playerCount = other.playerCount;
        this.playerNames = other.playerNames;
        this.isForming = other.isForming;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("OpenPortalActivePage", offset, (int) mem.byteSize());
        long needed = (long) offset + 36;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("OpenPortalActivePage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
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
        return hasNameKey(mem, offset) ? PacketIO.readVarString("NameKey", mem, offset + getValidatedOffset(mem, offset, 28, 36, "NameKey"), 4096000): null;
    }
    
    public static int getTimeLimitSeconds(MemorySegment mem) {
        return getTimeLimitSeconds(mem, 0);
    }
    
    public static int getTimeLimitSeconds(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 5);
    }
    
    public static int getRemainingSeconds(MemorySegment mem) {
        return getRemainingSeconds(mem, 0);
    }
    
    public static int getRemainingSeconds(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 9);
    }
    
    public static boolean getTimerStarted(MemorySegment mem) {
        return getTimerStarted(mem, 0);
    }
    
    public static boolean getTimerStarted(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 13);
    }
    
    public static int getAllowedEntryCount(MemorySegment mem) {
        return getAllowedEntryCount(mem, 0);
    }
    
    public static int getAllowedEntryCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 14);
    }
    
    public static int getEntriesUsed(MemorySegment mem) {
        return getEntriesUsed(mem, 0);
    }
    
    public static int getEntriesUsed(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 18);
    }
    
    public static boolean getAnyoneEntered(MemorySegment mem) {
        return getAnyoneEntered(mem, 0);
    }
    
    public static boolean getAnyoneEntered(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 22);
    }
    
    public static int getPlayerCount(MemorySegment mem) {
        return getPlayerCount(mem, 0);
    }
    
    public static int getPlayerCount(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 23);
    }
    
    @Nullable
    public static String[] getPlayerNames(MemorySegment mem) {
        return getPlayerNames(mem, 0);
    }
    
    @Nullable
    public static String[] getPlayerNames(MemorySegment mem, int offset) {
        if (!hasPlayerNames(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 32, 36, "PlayerNames");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("PlayerNames");
        var len = (int) packed;
        if (len > 4) throw ProtocolException.arrayTooLong("PlayerNames", len, 4);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlayerNames", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("PlayerNames", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    public static boolean getIsForming(MemorySegment mem) {
        return getIsForming(mem, 0);
    }
    
    public static boolean getIsForming(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 27);
    }
    
    public static boolean hasNameKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasPlayerNames(MemorySegment mem, int offset) {
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
    
    public static OpenPortalActivePage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static OpenPortalActivePage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one OpenPortalActivePage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static OpenPortalActivePage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 36;
        var varPos = 0;
        String v1 = null;
        if (hasNameKey(mem, offset)) {
            requireSlot(mem, offset + 28, varPos, "NameKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("NameKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 28, -1, "NameKey");
        }
        
        String[] v9 = null;
        if (hasPlayerNames(mem, offset)) {
            requireSlot(mem, offset + 32, varPos, "PlayerNames");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("PlayerNames");
            var len = (int) packed;
            if (len > 4) throw ProtocolException.arrayTooLong("PlayerNames", len, 4);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlayerNames", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v9 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v9[i] = PacketIO.readVarString("PlayerNames", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 32, -1, "PlayerNames");
        }
        var result = new OpenPortalActivePage(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            v1,
            mem.get(PacketIO.PROTO_INT, offset + 5),
            mem.get(PacketIO.PROTO_INT, offset + 9),
            mem.get(PacketIO.PROTO_BOOL, offset + 13),
            mem.get(PacketIO.PROTO_INT, offset + 14),
            mem.get(PacketIO.PROTO_INT, offset + 18),
            mem.get(PacketIO.PROTO_BOOL, offset + 22),
            mem.get(PacketIO.PROTO_INT, offset + 23),
            v9,
            mem.get(PacketIO.PROTO_BOOL, offset + 27)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.nameKey != null) nullBits |= 0x01;
        if (this.playerNames != null) nullBits |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.promptId);
        mem.set(PacketIO.PROTO_INT, offset + 5, this.timeLimitSeconds);
        mem.set(PacketIO.PROTO_INT, offset + 9, this.remainingSeconds);
        mem.set(PacketIO.PROTO_BOOL, offset + 13, this.timerStarted);
        mem.set(PacketIO.PROTO_INT, offset + 14, this.allowedEntryCount);
        mem.set(PacketIO.PROTO_INT, offset + 18, this.entriesUsed);
        mem.set(PacketIO.PROTO_BOOL, offset + 22, this.anyoneEntered);
        mem.set(PacketIO.PROTO_INT, offset + 23, this.playerCount);
        mem.set(PacketIO.PROTO_BOOL, offset + 27, this.isForming);
        var varOffset = offset + 36;
        if (this.nameKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 28, varOffset - offset - 36);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.nameKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 28, -1);
        }
        if (this.playerNames != null) {
            mem.set(PacketIO.PROTO_INT, offset + 32, varOffset - offset - 36);
            if (playerNames.length > 4) throw ProtocolException.arrayTooLong("PlayerNames", playerNames.length, 4);
            varOffset += VarInt.set(mem, varOffset, this.playerNames.length);
            
            var playerNamesValueOffset = 0;
            for (var i = 0; i < this.playerNames.length; i++) {
                playerNamesValueOffset += PacketIO.writeVarString(mem, varOffset + playerNamesValueOffset, this.playerNames[i], 4096000);
            }
            varOffset += playerNamesValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 32, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 36;
        if (nameKey != null) size += PacketIO.stringSize(nameKey);
    if (playerNames != null) {
        int playerNamesSize = 0;
for (var elem : playerNames) playerNamesSize += PacketIO.stringSize(elem);
size += VarInt.size(playerNames.length) + playerNamesSize;
    }

        return size;
    }

    public OpenPortalActivePage clone() {
        OpenPortalActivePage copy = new OpenPortalActivePage();
        copy.promptId = this.promptId;
        copy.nameKey = this.nameKey;
        copy.timeLimitSeconds = this.timeLimitSeconds;
        copy.remainingSeconds = this.remainingSeconds;
        copy.timerStarted = this.timerStarted;
        copy.allowedEntryCount = this.allowedEntryCount;
        copy.entriesUsed = this.entriesUsed;
        copy.anyoneEntered = this.anyoneEntered;
        copy.playerCount = this.playerCount;
        copy.playerNames = this.playerNames != null ? java.util.Arrays.copyOf(this.playerNames, this.playerNames.length) : null;
        copy.isForming = this.isForming;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OpenPortalActivePage other)) return false;
        return this.promptId == other.promptId && java.util.Objects.equals(this.nameKey, other.nameKey) && this.timeLimitSeconds == other.timeLimitSeconds && this.remainingSeconds == other.remainingSeconds && this.timerStarted == other.timerStarted && this.allowedEntryCount == other.allowedEntryCount && this.entriesUsed == other.entriesUsed && this.anyoneEntered == other.anyoneEntered && this.playerCount == other.playerCount && java.util.Arrays.equals(this.playerNames, other.playerNames) && this.isForming == other.isForming;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + Integer.hashCode(promptId);
        result = 31 * result + java.util.Objects.hashCode(nameKey);
        result = 31 * result + Integer.hashCode(timeLimitSeconds);
        result = 31 * result + Integer.hashCode(remainingSeconds);
        result = 31 * result + Boolean.hashCode(timerStarted);
        result = 31 * result + Integer.hashCode(allowedEntryCount);
        result = 31 * result + Integer.hashCode(entriesUsed);
        result = 31 * result + Boolean.hashCode(anyoneEntered);
        result = 31 * result + Integer.hashCode(playerCount);
        result = 31 * result + java.util.Arrays.hashCode(playerNames);
        result = 31 * result + Boolean.hashCode(isForming);
        return result;
    }

}