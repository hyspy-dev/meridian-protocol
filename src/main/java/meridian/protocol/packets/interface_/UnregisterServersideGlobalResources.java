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


public class UnregisterServersideGlobalResources implements Packet, ToClientPacket {
    public static final int PACKET_ID = 265;
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

    @Nonnull public String[] filePaths = new String[0];

    public UnregisterServersideGlobalResources() {
    }

    public UnregisterServersideGlobalResources(@Nonnull String[] filePaths) {
        this.filePaths = filePaths;
    }

    public UnregisterServersideGlobalResources(@Nonnull UnregisterServersideGlobalResources other) {
        this.filePaths = other.filePaths;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("UnregisterServersideGlobalResources", offset, (int) mem.byteSize());
        long needed = (long) offset + 0;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("UnregisterServersideGlobalResources", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String[] getFilePaths(MemorySegment mem) {
        return getFilePaths(mem, 0);
    }
    
    public static String[] getFilePaths(MemorySegment mem, int offset) {
        var off = offset + 0;
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("FilePaths");
        var len = (int) packed;
        if (len > 256) throw ProtocolException.arrayTooLong("FilePaths", len, 256);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("FilePaths", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("FilePaths", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    
    
    
    
    public static UnregisterServersideGlobalResources toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static UnregisterServersideGlobalResources toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one UnregisterServersideGlobalResources and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static UnregisterServersideGlobalResources toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 0;
        var varPos = 0;
        String[] v0;
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("FilePaths");
            var len = (int) packed;
            if (len > 256) throw ProtocolException.arrayTooLong("FilePaths", len, 256);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("FilePaths", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v0 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v0[i] = PacketIO.readVarString("FilePaths", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        }
        var result = new UnregisterServersideGlobalResources(
            v0
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        
        var varOffset = offset + 0;
        if (filePaths.length > 256) throw ProtocolException.arrayTooLong("FilePaths", filePaths.length, 256);
        varOffset += VarInt.set(mem, varOffset, this.filePaths.length);
        
        var filePathsValueOffset = 0;
        for (var i = 0; i < this.filePaths.length; i++) {
            filePathsValueOffset += PacketIO.writeVarString(mem, varOffset + filePathsValueOffset, this.filePaths[i], 4096000);
        }
        varOffset += filePathsValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 0;
        int filePathsSize = 0;
for (var elem : filePaths) filePathsSize += PacketIO.stringSize(elem);
size += VarInt.size(filePaths.length) + filePathsSize;

        return size;
    }

    public UnregisterServersideGlobalResources clone() {
        UnregisterServersideGlobalResources copy = new UnregisterServersideGlobalResources();
        copy.filePaths = java.util.Arrays.copyOf(this.filePaths, this.filePaths.length);
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UnregisterServersideGlobalResources other)) return false;
        return java.util.Arrays.equals(this.filePaths, other.filePaths);
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Arrays.hashCode(filePaths);
        return result;
    }

}