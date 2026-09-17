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


public class CombatConfig {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 1;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 1;
    public static final int MAX_SIZE = 1;

    public boolean displayHealthBars;
    public boolean displayCombatText;

    public CombatConfig() {
    }

    public CombatConfig(boolean displayHealthBars, boolean displayCombatText) {
        this.displayHealthBars = displayHealthBars;
        this.displayCombatText = displayCombatText;
    }

    public CombatConfig(@Nonnull CombatConfig other) {
        this.displayHealthBars = other.displayHealthBars;
        this.displayCombatText = other.displayCombatText;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("CombatConfig", offset, (int) mem.byteSize());
        long needed = (long) offset + 1;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("CombatConfig", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static boolean getDisplayHealthBars(MemorySegment mem) {
        return getDisplayHealthBars(mem, 0);
    }
    
    public static boolean getDisplayHealthBars(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0;
    }
    
    public static boolean getDisplayCombatText(MemorySegment mem) {
        return getDisplayCombatText(mem, 0);
    }
    
    public static boolean getDisplayCombatText(MemorySegment mem, int offset) {
        return (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0;
    }
    
    
    
    
    
    public static CombatConfig toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static CombatConfig toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one CombatConfig and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static CombatConfig toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new CombatConfig(
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x01) != 0,
            (mem.get(PacketIO.PROTO_BYTE, offset + 0) & 0x02) != 0
        );
        if (cursor != null) cursor.position = offset + 1;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        byte boolBits0_0 = 0;
        if (this.displayHealthBars) boolBits0_0 |= 0x01;
        if (this.displayCombatText) boolBits0_0 |= 0x02;
        mem.set(PacketIO.PROTO_BYTE, offset + 0 + 0, boolBits0_0);
        
        
    
       return 1;
    }
    public int computeSize() {
        return 1;
    }

    public CombatConfig clone() {
        CombatConfig copy = new CombatConfig();
        copy.displayHealthBars = this.displayHealthBars;
        copy.displayCombatText = this.displayCombatText;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof CombatConfig other)) return false;
        return this.displayHealthBars == other.displayHealthBars && this.displayCombatText == other.displayCombatText;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(displayHealthBars, displayCombatText);
    }

}