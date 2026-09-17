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


public class BlockDamageCmd {
    public static final int NULLABLE_BIT_FIELD_SIZE = 0;
    public static final int FIXED_BLOCK_SIZE = 10;
    public static final int VARIABLE_FIELD_COUNT = 0;
    public static final int VARIABLE_BLOCK_START = 10;
    public static final int MAX_SIZE = 10;

    public short index;
    public float damage;
    public float delta;

    public BlockDamageCmd() {
    }

    public BlockDamageCmd(short index, float damage, float delta) {
        this.index = index;
        this.damage = damage;
        this.delta = delta;
    }

    public BlockDamageCmd(@Nonnull BlockDamageCmd other) {
        this.index = other.index;
        this.damage = other.damage;
        this.delta = other.delta;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BlockDamageCmd", offset, (int) mem.byteSize());
        long needed = (long) offset + 10;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BlockDamageCmd", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static short getIndex(MemorySegment mem) {
        return getIndex(mem, 0);
    }
    
    public static short getIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_SHORT, offset + 0);
    }
    
    public static float getDamage(MemorySegment mem) {
        return getDamage(mem, 0);
    }
    
    public static float getDamage(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Damage");
    }
    
    public static float getDelta(MemorySegment mem) {
        return getDelta(mem, 0);
    }
    
    public static float getDelta(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "Delta");
    }
    
    
    
    
    
    public static BlockDamageCmd toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BlockDamageCmd toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BlockDamageCmd and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BlockDamageCmd toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var result = new BlockDamageCmd(
            mem.get(PacketIO.PROTO_SHORT, offset + 0),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 2), "Damage"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 6), "Delta")
        );
        if (cursor != null) cursor.position = offset + 10;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        
        mem.set(PacketIO.PROTO_SHORT, offset + 0, this.index);
        PacketIO.requireFinite(this.damage, "Damage"); mem.set(PacketIO.PROTO_FLOAT, offset + 2, this.damage);
        PacketIO.requireFinite(this.delta, "Delta"); mem.set(PacketIO.PROTO_FLOAT, offset + 6, this.delta);
        
        
    
       return 10;
    }
    public int computeSize() {
        return 10;
    }

    public BlockDamageCmd clone() {
        BlockDamageCmd copy = new BlockDamageCmd();
        copy.index = this.index;
        copy.damage = this.damage;
        copy.delta = this.delta;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BlockDamageCmd other)) return false;
        return this.index == other.index && this.damage == other.damage && this.delta == other.delta;
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(index, damage, delta);
    }

}