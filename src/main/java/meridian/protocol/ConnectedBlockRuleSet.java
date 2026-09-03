// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public abstract class ConnectedBlockRuleSet {
    public static final int MAX_SIZE = 1677721605;

    


    public static ConnectedBlockRuleSet toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }

    public static ConnectedBlockRuleSet toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }

    public static ConnectedBlockRuleSet toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // The subtype starts after the type id as encoded, which VarInt.size cannot report.
        long typeIdPacked = VarInt.getWithLength(mem, offset);
        int typeId = (int) typeIdPacked;
        int typeIdLen = (int) (typeIdPacked >>> 32);

        // A subtype may hold further values of this type, and decoding such a chain recurses
        // once per link. The cursor counts the links so the chain cannot outrun the stack.
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        walkCursor.enterNested("ConnectedBlockRuleSet");
        try {
            return switch (typeId) {
                case 0 -> StairConnectedBlockRuleSet.toObject(mem, offset + typeIdLen, walkCursor);
                case 1 -> RoofConnectedBlockRuleSet.toObject(mem, offset + typeIdLen, walkCursor);
                case 2 -> PatternedConnectedBlockRuleSet.toObject(mem, offset + typeIdLen, walkCursor);
                default -> throw ProtocolException.unknownPolymorphicType("ConnectedBlockRuleSet", typeId);
            };
        } finally {
            walkCursor.exitNested();
        }
    }


    public int getTypeId() {
        if (this instanceof StairConnectedBlockRuleSet sub) { return 0; }
            if (this instanceof RoofConnectedBlockRuleSet sub) { return 1; }
            if (this instanceof PatternedConnectedBlockRuleSet sub) { return 2; }
        throw new IllegalStateException("Unknown subtype: " + getClass().getName());
    }

    public abstract int serialize(@Nonnull MemorySegment mem, int offset);
    public abstract int computeSize();


    public int serializeWithTypeId(@Nonnull MemorySegment mem, int offset) {
        var len = VarInt.set(mem, offset, getTypeId());
        return len + serialize(mem, offset + len);
    }

    public int computeSizeWithTypeId() {
        return VarInt.size(getTypeId()) + computeSize();
    }
}