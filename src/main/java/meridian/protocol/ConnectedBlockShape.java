// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;


public abstract class ConnectedBlockShape {
    public static final int MAX_SIZE = 1677721605;

        @Nullable public ConnectedBlockFaceTags faceTags;
    public int relativeRotationIndex;



    public static ConnectedBlockShape toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }

    public static ConnectedBlockShape toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }

    public static ConnectedBlockShape toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // The subtype starts after the type id as encoded, which VarInt.size cannot report.
        long typeIdPacked = VarInt.getWithLength(mem, offset);
        int typeId = (int) typeIdPacked;
        int typeIdLen = (int) (typeIdPacked >>> 32);

        // A subtype may hold further values of this type, and decoding such a chain recurses
        // once per link. The cursor counts the links so the chain cannot outrun the stack.
        var walkCursor = cursor != null ? cursor : new ReadCursor();
        walkCursor.enterNested("ConnectedBlockShape");
        try {
            return switch (typeId) {
                case 0 -> TagPatternConnectedBlockShape.toObject(mem, offset + typeIdLen, walkCursor);
                case 1 -> TemplatedConnectedBlockShape.toObject(mem, offset + typeIdLen, walkCursor);
                case 2 -> BlockTypeConnectedBlockShape.toObject(mem, offset + typeIdLen, walkCursor);
                default -> throw ProtocolException.unknownPolymorphicType("ConnectedBlockShape", typeId);
            };
        } finally {
            walkCursor.exitNested();
        }
    }


    public int getTypeId() {
        if (this instanceof TagPatternConnectedBlockShape sub) { return 0; }
            if (this instanceof TemplatedConnectedBlockShape sub) { return 1; }
            if (this instanceof BlockTypeConnectedBlockShape sub) { return 2; }
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