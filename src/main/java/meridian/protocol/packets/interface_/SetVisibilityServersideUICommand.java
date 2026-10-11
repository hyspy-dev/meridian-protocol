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


public class SetVisibilityServersideUICommand extends ServersideUICommand {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    public boolean visible;

    public SetVisibilityServersideUICommand() {
    }

    public SetVisibilityServersideUICommand(boolean visible) {
        this.visible = visible;
    }

    public SetVisibilityServersideUICommand(@Nonnull SetVisibilityServersideUICommand other) {
        this.visible = other.visible;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("SetVisibilityServersideUICommand", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("SetVisibilityServersideUICommand", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getVisible(MemorySegment mem) {
        return getVisible(mem, 0);
    }
    
    public static boolean getVisible(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_BOOL, offset + 0);
    }
    
    
    
    
    
    public static SetVisibilityServersideUICommand toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static SetVisibilityServersideUICommand toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one SetVisibilityServersideUICommand and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static SetVisibilityServersideUICommand toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new SetVisibilityServersideUICommand(
            mem.get(PacketIO.PROTO_BOOL, offset + 0)
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    @Override
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BOOL, offset + 0, this.visible);
        
        
    
       return 1;
    }
    @Override
    public int computeSize() {
        return 1;
    }

    public SetVisibilityServersideUICommand clone() {
        SetVisibilityServersideUICommand copy = new SetVisibilityServersideUICommand();
        copy.visible = this.visible;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof SetVisibilityServersideUICommand other)) return false;
        return this.visible == other.visible;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(visible);
    }

}