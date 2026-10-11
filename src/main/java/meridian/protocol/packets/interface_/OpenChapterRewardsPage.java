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


public class OpenChapterRewardsPage implements Packet, ToClientPacket {
    public static final int PACKET_ID = 220;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 2;
    public static final int VARIABLE_FIELD_COUNT = 5;
    public static final int VARIABLE_BLOCK_START = 22;
    public static final int MAX_SIZE = 81920047;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nullable public String chapterId;
    @Nullable public String titleKey;
    @Nullable public String subtitleKey;
    @Nullable public String leaveKey;
    @Nullable public String stayKey;
    public boolean showRewards;

    public OpenChapterRewardsPage() {
    }

    public OpenChapterRewardsPage(@Nullable String chapterId, @Nullable String titleKey, @Nullable String subtitleKey, @Nullable String leaveKey, @Nullable String stayKey, boolean showRewards) {
        this.chapterId = chapterId;
        this.titleKey = titleKey;
        this.subtitleKey = subtitleKey;
        this.leaveKey = leaveKey;
        this.stayKey = stayKey;
        this.showRewards = showRewards;
    }

    public OpenChapterRewardsPage(@Nonnull OpenChapterRewardsPage other) {
        this.chapterId = other.chapterId;
        this.titleKey = other.titleKey;
        this.subtitleKey = other.subtitleKey;
        this.leaveKey = other.leaveKey;
        this.stayKey = other.stayKey;
        this.showRewards = other.showRewards;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("OpenChapterRewardsPage", offset, (int) mem.byteSize());
        long needed = (long) offset + 22;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("OpenChapterRewardsPage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    @Nullable
    public static String getChapterId(MemorySegment mem) {
        return getChapterId(mem, 0);
    }
    
    @Nullable
    public static String getChapterId(MemorySegment mem, int offset) {
        return hasChapterId(mem, offset) ? PacketIO.readVarString("ChapterId", mem, offset + getValidatedOffset(mem, offset, 2, 22, "ChapterId"), 4096000): null;
    }
    
    @Nullable
    public static String getTitleKey(MemorySegment mem) {
        return getTitleKey(mem, 0);
    }
    
    @Nullable
    public static String getTitleKey(MemorySegment mem, int offset) {
        return hasTitleKey(mem, offset) ? PacketIO.readVarString("TitleKey", mem, offset + getValidatedOffset(mem, offset, 6, 22, "TitleKey"), 4096000): null;
    }
    
    @Nullable
    public static String getSubtitleKey(MemorySegment mem) {
        return getSubtitleKey(mem, 0);
    }
    
    @Nullable
    public static String getSubtitleKey(MemorySegment mem, int offset) {
        return hasSubtitleKey(mem, offset) ? PacketIO.readVarString("SubtitleKey", mem, offset + getValidatedOffset(mem, offset, 10, 22, "SubtitleKey"), 4096000): null;
    }
    
    @Nullable
    public static String getLeaveKey(MemorySegment mem) {
        return getLeaveKey(mem, 0);
    }
    
    @Nullable
    public static String getLeaveKey(MemorySegment mem, int offset) {
        return hasLeaveKey(mem, offset) ? PacketIO.readVarString("LeaveKey", mem, offset + getValidatedOffset(mem, offset, 14, 22, "LeaveKey"), 4096000): null;
    }
    
    @Nullable
    public static String getStayKey(MemorySegment mem) {
        return getStayKey(mem, 0);
    }
    
    @Nullable
    public static String getStayKey(MemorySegment mem, int offset) {
        return hasStayKey(mem, offset) ? PacketIO.readVarString("StayKey", mem, offset + getValidatedOffset(mem, offset, 18, 22, "StayKey"), 4096000): null;
    }
    
    public static boolean getShowRewards(MemorySegment mem) {
        return getShowRewards(mem, 0);
    }
    
    public static boolean getShowRewards(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 1);
    }
    
    public static boolean hasChapterId(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasTitleKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasSubtitleKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasLeaveKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasStayKey(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
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
    
    public static OpenChapterRewardsPage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static OpenChapterRewardsPage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one OpenChapterRewardsPage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static OpenChapterRewardsPage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 22;
        var varPos = 0;
        String v0 = null;
        if (hasChapterId(mem, offset)) {
            requireSlot(mem, offset + 2, varPos, "ChapterId");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readVarString("ChapterId", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 2, -1, "ChapterId");
        }
        
        String v1 = null;
        if (hasTitleKey(mem, offset)) {
            requireSlot(mem, offset + 6, varPos, "TitleKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readVarString("TitleKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 6, -1, "TitleKey");
        }
        
        String v2 = null;
        if (hasSubtitleKey(mem, offset)) {
            requireSlot(mem, offset + 10, varPos, "SubtitleKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readVarString("SubtitleKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 10, -1, "SubtitleKey");
        }
        
        String v3 = null;
        if (hasLeaveKey(mem, offset)) {
            requireSlot(mem, offset + 14, varPos, "LeaveKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readVarString("LeaveKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 14, -1, "LeaveKey");
        }
        
        String v4 = null;
        if (hasStayKey(mem, offset)) {
            requireSlot(mem, offset + 18, varPos, "StayKey");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readVarString("StayKey", mem, off, 0, 4096000, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 18, -1, "StayKey");
        }
        var result = new OpenChapterRewardsPage(
            v0,
            v1,
            v2,
            v3,
            v4,
            mem.get(PacketIO.PROTO_BOOL, offset + 1)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.chapterId != null) nullBits |= 0x01;
        if (this.titleKey != null) nullBits |= 0x02;
        if (this.subtitleKey != null) nullBits |= 0x04;
        if (this.leaveKey != null) nullBits |= 0x08;
        if (this.stayKey != null) nullBits |= 0x10;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_BOOL, offset + 1, this.showRewards);
        var varOffset = offset + 22;
        if (this.chapterId != null) {
            mem.set(PacketIO.PROTO_INT, offset + 2, varOffset - offset - 22);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.chapterId, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 2, -1);
        }
        if (this.titleKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 6, varOffset - offset - 22);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.titleKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 6, -1);
        }
        if (this.subtitleKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 10, varOffset - offset - 22);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.subtitleKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 10, -1);
        }
        if (this.leaveKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 14, varOffset - offset - 22);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.leaveKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 14, -1);
        }
        if (this.stayKey != null) {
            mem.set(PacketIO.PROTO_INT, offset + 18, varOffset - offset - 22);
            varOffset += PacketIO.writeVarString(mem, varOffset, this.stayKey, 4096000);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 18, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 22;
        if (chapterId != null) size += PacketIO.stringSize(chapterId);
    if (titleKey != null) size += PacketIO.stringSize(titleKey);
    if (subtitleKey != null) size += PacketIO.stringSize(subtitleKey);
    if (leaveKey != null) size += PacketIO.stringSize(leaveKey);
    if (stayKey != null) size += PacketIO.stringSize(stayKey);

        return size;
    }

    public OpenChapterRewardsPage clone() {
        OpenChapterRewardsPage copy = new OpenChapterRewardsPage();
        copy.chapterId = this.chapterId;
        copy.titleKey = this.titleKey;
        copy.subtitleKey = this.subtitleKey;
        copy.leaveKey = this.leaveKey;
        copy.stayKey = this.stayKey;
        copy.showRewards = this.showRewards;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof OpenChapterRewardsPage other)) return false;
        return java.util.Objects.equals(this.chapterId, other.chapterId) && java.util.Objects.equals(this.titleKey, other.titleKey) && java.util.Objects.equals(this.subtitleKey, other.subtitleKey) && java.util.Objects.equals(this.leaveKey, other.leaveKey) && java.util.Objects.equals(this.stayKey, other.stayKey) && this.showRewards == other.showRewards;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(chapterId, titleKey, subtitleKey, leaveKey, stayKey, showRewards);
    }

}