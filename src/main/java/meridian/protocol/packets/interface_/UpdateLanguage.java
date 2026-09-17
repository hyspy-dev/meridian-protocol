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


public class UpdateLanguage implements Packet, ToServerPacket {
    public static final int PACKET_ID = 232;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 0;
    public static final int VARIABLE_FIELD_COUNT = 1;
    public static final int VARIABLE_BLOCK_START = 0;
    public static final int MAX_SIZE = 105;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String language = "";

    public UpdateLanguage() {
    }

    public UpdateLanguage(@Nonnull String language) {
        this.language = language;
    }

    public UpdateLanguage(@Nonnull UpdateLanguage other) {
        this.language = other.language;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UpdateLanguage", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UpdateLanguage", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getLanguage(MemorySegment mem) {
        return getLanguage(mem, 0);
    }
    
    public static String getLanguage(MemorySegment mem, int offset) {
        return PacketIO.readValidatedAsciiString("Language", mem, offset + 0, 100);
    }
    
    
    
    
    
    public static UpdateLanguage toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UpdateLanguage toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UpdateLanguage and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UpdateLanguage toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        String v0;
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readValidatedAsciiString("Language", mem, off, 0, 100, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        var result = new UpdateLanguage(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.language, 100);
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        size += VarInt.size(language.length()) + language.length();

        return size;
    }

    public UpdateLanguage clone() {
        UpdateLanguage copy = new UpdateLanguage();
        copy.language = this.language;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UpdateLanguage other)) return false;
        return java.util.Objects.equals(this.language, other.language);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(language);
    }

}