// Auto-generated - do not edit
package meridian.protocol.packets.serveraccess;

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
import meridian.protocol.HostAddress;

public class ConfigureIcePeer implements Packet, ToServerPacket {
    public static final int PACKET_ID = 254;
    public static final boolean IS_COMPRESSED = false;
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 6;
    public static final int VARIABLE_BLOCK_START = 25;
    public static final int MAX_SIZE = 17639;

    @Override
    public int getId() {
        return PACKET_ID;
    }

    @Override
    public NetworkChannel getChannel() {
        return NetworkChannel.Default;
    }

    @Nonnull public String sessionId = "";
    @Nonnull public String localUfrag = "";
    @Nonnull public String localPassword = "";
    @Nonnull public String remoteUfrag = "";
    @Nonnull public String remotePassword = "";
    @Nonnull public HostAddress[] remoteCandidates = new HostAddress[0];
    public boolean remove;

    public ConfigureIcePeer() {
    }

    public ConfigureIcePeer(@Nonnull String sessionId, @Nonnull String localUfrag, @Nonnull String localPassword, @Nonnull String remoteUfrag, @Nonnull String remotePassword, @Nonnull HostAddress[] remoteCandidates, boolean remove) {
        this.sessionId = sessionId;
        this.localUfrag = localUfrag;
        this.localPassword = localPassword;
        this.remoteUfrag = remoteUfrag;
        this.remotePassword = remotePassword;
        this.remoteCandidates = remoteCandidates;
        this.remove = remove;
    }

    public ConfigureIcePeer(@Nonnull ConfigureIcePeer other) {
        this.sessionId = other.sessionId;
        this.localUfrag = other.localUfrag;
        this.localPassword = other.localPassword;
        this.remoteUfrag = other.remoteUfrag;
        this.remotePassword = other.remotePassword;
        this.remoteCandidates = other.remoteCandidates;
        this.remove = other.remove;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ConfigureIcePeer", offset, (int) mem.byteSize());
        long needed = (long) offset + 25;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ConfigureIcePeer", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static String getSessionId(MemorySegment mem) {
        return getSessionId(mem, 0);
    }
    
    public static String getSessionId(MemorySegment mem, int offset) {
        return PacketIO.readValidatedAsciiString("SessionId", mem, offset + getValidatedOffset(mem, offset, 1, 25, "SessionId"), 64);
    }
    
    public static String getLocalUfrag(MemorySegment mem) {
        return getLocalUfrag(mem, 0);
    }
    
    public static String getLocalUfrag(MemorySegment mem, int offset) {
        return PacketIO.readValidatedAsciiString("LocalUfrag", mem, offset + getValidatedOffset(mem, offset, 5, 25, "LocalUfrag"), 256);
    }
    
    public static String getLocalPassword(MemorySegment mem) {
        return getLocalPassword(mem, 0);
    }
    
    public static String getLocalPassword(MemorySegment mem, int offset) {
        return PacketIO.readValidatedAsciiString("LocalPassword", mem, offset + getValidatedOffset(mem, offset, 9, 25, "LocalPassword"), 256);
    }
    
    public static String getRemoteUfrag(MemorySegment mem) {
        return getRemoteUfrag(mem, 0);
    }
    
    public static String getRemoteUfrag(MemorySegment mem, int offset) {
        return PacketIO.readValidatedAsciiString("RemoteUfrag", mem, offset + getValidatedOffset(mem, offset, 13, 25, "RemoteUfrag"), 256);
    }
    
    public static String getRemotePassword(MemorySegment mem) {
        return getRemotePassword(mem, 0);
    }
    
    public static String getRemotePassword(MemorySegment mem, int offset) {
        return PacketIO.readValidatedAsciiString("RemotePassword", mem, offset + getValidatedOffset(mem, offset, 17, 25, "RemotePassword"), 256);
    }
    
    public static HostAddress[] getRemoteCandidates(MemorySegment mem) {
        return getRemoteCandidates(mem, 0);
    }
    
    public static HostAddress[] getRemoteCandidates(MemorySegment mem, int offset) {
        var walkCursor = new ReadCursor();
        var off = offset + getValidatedOffset(mem, offset, 21, 25, "RemoteCandidates");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("RemoteCandidates");
        var len = (int) packed;
        if (len > 16) throw ProtocolException.arrayTooLong("RemoteCandidates", len, 16);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemoteCandidates", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new HostAddress[len];
        for (var i = 0; i < len; i++) {
            data[i] = HostAddress.toObject(mem, off, walkCursor);
            off = walkCursor.position;
        }
        return data;
    }
    
    public static boolean getRemove(MemorySegment mem) {
        return getRemove(mem, 0);
    }
    
    public static boolean getRemove(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 0);
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
    
    public static ConfigureIcePeer toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ConfigureIcePeer toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ConfigureIcePeer and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ConfigureIcePeer toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 25;
        var varPos = 0;
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        String v0;
        requireSlot(mem, offset + 1, varPos, "SessionId");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v0 = PacketIO.readValidatedAsciiString("SessionId", mem, off, 0, 64, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v1;
        requireSlot(mem, offset + 5, varPos, "LocalUfrag");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v1 = PacketIO.readValidatedAsciiString("LocalUfrag", mem, off, 0, 256, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v2;
        requireSlot(mem, offset + 9, varPos, "LocalPassword");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readValidatedAsciiString("LocalPassword", mem, off, 0, 256, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v3;
        requireSlot(mem, offset + 13, varPos, "RemoteUfrag");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v3 = PacketIO.readValidatedAsciiString("RemoteUfrag", mem, off, 0, 256, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        String v4;
        requireSlot(mem, offset + 17, varPos, "RemotePassword");
        {
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v4 = PacketIO.readValidatedAsciiString("RemotePassword", mem, off, 0, 256, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        }
        
        HostAddress[] v5;
        requireSlot(mem, offset + 21, varPos, "RemoteCandidates");
        {
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("RemoteCandidates");
            var len = (int) packed;
            if (len > 16) throw ProtocolException.arrayTooLong("RemoteCandidates", len, 16);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("RemoteCandidates", (int) java.lang.Math.min(off + lenOffset + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new HostAddress[len];
            for (var i = 0; i < len; i++) {
                v5[i] = HostAddress.toObject(mem, off, walkCursor);
                off = walkCursor.position;
            }
            varPos = off - varBase;
        }
        var result = new ConfigureIcePeer(
            v0,
            v1,
            v2,
            v3,
            v4,
            v5,
            mem.get(PacketIO.PROTO_BOOL, offset + 0)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BOOL, offset + 0, this.remove);
        var varOffset = offset + 25;
        mem.set(PacketIO.PROTO_INT, offset + 1, varOffset - offset - 25);
        varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.sessionId, 64);
        mem.set(PacketIO.PROTO_INT, offset + 5, varOffset - offset - 25);
        varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.localUfrag, 256);
        mem.set(PacketIO.PROTO_INT, offset + 9, varOffset - offset - 25);
        varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.localPassword, 256);
        mem.set(PacketIO.PROTO_INT, offset + 13, varOffset - offset - 25);
        varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.remoteUfrag, 256);
        mem.set(PacketIO.PROTO_INT, offset + 17, varOffset - offset - 25);
        varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.remotePassword, 256);
        mem.set(PacketIO.PROTO_INT, offset + 21, varOffset - offset - 25);
        if (remoteCandidates.length > 16) throw ProtocolException.arrayTooLong("RemoteCandidates", remoteCandidates.length, 16);
        varOffset += VarInt.set(mem, varOffset, this.remoteCandidates.length);
        
        var remoteCandidatesValueOffset = 0;
        for (var i = 0; i < this.remoteCandidates.length; i++) {
            remoteCandidatesValueOffset += this.remoteCandidates[i].serialize(mem, varOffset + remoteCandidatesValueOffset);
        }
        varOffset += remoteCandidatesValueOffset;
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 25;
        size += VarInt.size(sessionId.length()) + sessionId.length();
    size += VarInt.size(localUfrag.length()) + localUfrag.length();
    size += VarInt.size(localPassword.length()) + localPassword.length();
    size += VarInt.size(remoteUfrag.length()) + remoteUfrag.length();
    size += VarInt.size(remotePassword.length()) + remotePassword.length();
    int remoteCandidatesSize = 0;
for (var elem : remoteCandidates) remoteCandidatesSize += elem.computeSize();
size += VarInt.size(remoteCandidates.length) + remoteCandidatesSize;

        return size;
    }

    public ConfigureIcePeer clone() {
        ConfigureIcePeer copy = new ConfigureIcePeer();
        copy.sessionId = this.sessionId;
        copy.localUfrag = this.localUfrag;
        copy.localPassword = this.localPassword;
        copy.remoteUfrag = this.remoteUfrag;
        copy.remotePassword = this.remotePassword;
        copy.remoteCandidates = java.util.Arrays.stream(this.remoteCandidates).map(e -> e.clone()).toArray(HostAddress[]::new);
        copy.remove = this.remove;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ConfigureIcePeer other)) return false;
        return java.util.Objects.equals(this.sessionId, other.sessionId) && java.util.Objects.equals(this.localUfrag, other.localUfrag) && java.util.Objects.equals(this.localPassword, other.localPassword) && java.util.Objects.equals(this.remoteUfrag, other.remoteUfrag) && java.util.Objects.equals(this.remotePassword, other.remotePassword) && java.util.Arrays.equals(this.remoteCandidates, other.remoteCandidates) && this.remove == other.remove;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(sessionId);
        result = 31 * result + java.util.Objects.hashCode(localUfrag);
        result = 31 * result + java.util.Objects.hashCode(localPassword);
        result = 31 * result + java.util.Objects.hashCode(remoteUfrag);
        result = 31 * result + java.util.Objects.hashCode(remotePassword);
        result = 31 * result + java.util.Arrays.hashCode(remoteCandidates);
        result = 31 * result + Boolean.hashCode(remove);
        return result;
    }

}