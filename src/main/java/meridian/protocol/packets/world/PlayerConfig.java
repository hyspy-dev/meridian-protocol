// Auto-generated - do not edit
package meridian.protocol.packets.world;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public class PlayerConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    @Nonnull public ArmorVisibilityOption armorVisibilityOption = ArmorVisibilityOption.None;

    public PlayerConfig() {
    }

    public PlayerConfig(@Nonnull ArmorVisibilityOption armorVisibilityOption) {
        this.armorVisibilityOption = armorVisibilityOption;
    }

    public PlayerConfig(@Nonnull PlayerConfig other) {
        this.armorVisibilityOption = other.armorVisibilityOption;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("PlayerConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("PlayerConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static ArmorVisibilityOption getArmorVisibilityOption(MemorySegment mem) {
        return getArmorVisibilityOption(mem, 0);
    }
    
    public static ArmorVisibilityOption getArmorVisibilityOption(MemorySegment mem, int offset) {
        return ArmorVisibilityOption.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0));
    }
    
    
    
    
    
    public static PlayerConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static PlayerConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one PlayerConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static PlayerConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new PlayerConfig(
            ArmorVisibilityOption.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 0))
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_BYTE, offset + 0, (byte) this.armorVisibilityOption.getValue());
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public PlayerConfig clone() {
        PlayerConfig copy = new PlayerConfig();
        copy.armorVisibilityOption = this.armorVisibilityOption;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof PlayerConfig other)) return false;
        return java.util.Objects.equals(this.armorVisibilityOption, other.armorVisibilityOption);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(armorVisibilityOption);
    }

}