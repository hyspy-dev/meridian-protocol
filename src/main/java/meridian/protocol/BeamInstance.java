// Auto-generated - do not edit
package meridian.protocol;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.ValueLayout;
import meridian.protocol.io.PacketIO;
import meridian.protocol.io.ProtocolException;
import meridian.protocol.io.ReadCursor;
import meridian.protocol.io.VarInt;
import org.joml.*;

public class BeamInstance {
    public static final int NULLABLE_BIT_FIELD_SIZE = 1;
    public static final int FIXED_BLOCK_SIZE = 53;
    public static final int VARIABLE_FIELD_COUNT = 2;
    public static final int VARIABLE_BLOCK_START = 61;
    public static final int MAX_SIZE = 263;

    public int beamIndex;
    public float sourceScale;
    @Nullable public String sourceNodeName;
    @Nonnull public Vector3fc sourceOffset = PacketIO.ZERO_VECTOR3;
    public float targetScale;
    public int targetNetworkId;
    @Nullable public String targetNodeName;
    @Nonnull public Vector3fc targetOffset = PacketIO.ZERO_VECTOR3;
    @Nullable public Vector3fc targetPosition;

    public BeamInstance() {
    }

    public BeamInstance(int beamIndex, float sourceScale, @Nullable String sourceNodeName, @Nonnull Vector3fc sourceOffset, float targetScale, int targetNetworkId, @Nullable String targetNodeName, @Nonnull Vector3fc targetOffset, @Nullable Vector3fc targetPosition) {
        this.beamIndex = beamIndex;
        this.sourceScale = sourceScale;
        this.sourceNodeName = sourceNodeName;
        this.sourceOffset = sourceOffset;
        this.targetScale = targetScale;
        this.targetNetworkId = targetNetworkId;
        this.targetNodeName = targetNodeName;
        this.targetOffset = targetOffset;
        this.targetPosition = targetPosition;
    }

    public BeamInstance(@Nonnull BeamInstance other) {
        this.beamIndex = other.beamIndex;
        this.sourceScale = other.sourceScale;
        this.sourceNodeName = other.sourceNodeName;
        this.sourceOffset = other.sourceOffset;
        this.targetScale = other.targetScale;
        this.targetNetworkId = other.targetNetworkId;
        this.targetNodeName = other.targetNodeName;
        this.targetOffset = other.targetOffset;
        this.targetPosition = other.targetPosition;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("BeamInstance", offset, (int) mem.byteSize());
        long needed = (long) offset + 61;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("BeamInstance", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static int getBeamIndex(MemorySegment mem) {
        return getBeamIndex(mem, 0);
    }
    
    public static int getBeamIndex(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 1);
    }
    
    public static float getSourceScale(MemorySegment mem) {
        return getSourceScale(mem, 0);
    }
    
    public static float getSourceScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "SourceScale");
    }
    
    @Nullable
    public static String getSourceNodeName(MemorySegment mem) {
        return getSourceNodeName(mem, 0);
    }
    
    @Nullable
    public static String getSourceNodeName(MemorySegment mem, int offset) {
        return hasSourceNodeName(mem, offset) ? PacketIO.readValidatedAsciiString("SourceNodeName", mem, offset + getValidatedOffset(mem, offset, 53, 61, "SourceNodeName"), 96): null;
    }
    
    public static Vector3fc getSourceOffset(MemorySegment mem) {
        return getSourceOffset(mem, 0);
    }
    
    public static Vector3fc getSourceOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 9), "SourceOffset");
    }
    
    public static float getTargetScale(MemorySegment mem) {
        return getTargetScale(mem, 0);
    }
    
    public static float getTargetScale(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 21), "TargetScale");
    }
    
    public static int getTargetNetworkId(MemorySegment mem) {
        return getTargetNetworkId(mem, 0);
    }
    
    public static int getTargetNetworkId(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 25);
    }
    
    @Nullable
    public static String getTargetNodeName(MemorySegment mem) {
        return getTargetNodeName(mem, 0);
    }
    
    @Nullable
    public static String getTargetNodeName(MemorySegment mem, int offset) {
        return hasTargetNodeName(mem, offset) ? PacketIO.readValidatedAsciiString("TargetNodeName", mem, offset + getValidatedOffset(mem, offset, 57, 61, "TargetNodeName"), 96): null;
    }
    
    public static Vector3fc getTargetOffset(MemorySegment mem) {
        return getTargetOffset(mem, 0);
    }
    
    public static Vector3fc getTargetOffset(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 29), "TargetOffset");
    }
    
    @Nullable
    public static Vector3fc getTargetPosition(MemorySegment mem) {
        return getTargetPosition(mem, 0);
    }
    
    @Nullable
    public static Vector3fc getTargetPosition(MemorySegment mem, int offset) {
        return hasTargetPosition(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 41), "TargetPosition"): null;
    }
    
    public static boolean hasTargetPosition(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasSourceNodeName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasTargetNodeName(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
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
    
    public static BeamInstance toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static BeamInstance toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one BeamInstance and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static BeamInstance toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 61;
        var varPos = 0;
        String v2 = null;
        if (hasSourceNodeName(mem, offset)) {
            requireSlot(mem, offset + 53, varPos, "SourceNodeName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v2 = PacketIO.readValidatedAsciiString("SourceNodeName", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 53, -1, "SourceNodeName");
        }
        
        String v6 = null;
        if (hasTargetNodeName(mem, offset)) {
            requireSlot(mem, offset + 57, varPos, "TargetNodeName");
            var off = varBase + varPos;
            var sp = VarInt.getWithLength(mem, off);
            v6 = PacketIO.readValidatedAsciiString("TargetNodeName", mem, off, 0, 96, sp);
            varPos += (int) sp + (int) (sp >>> 32);
        } else {
            requireSlot(mem, offset + 57, -1, "TargetNodeName");
        }
        var result = new BeamInstance(
            mem.get(PacketIO.PROTO_INT, offset + 1),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 5), "SourceScale"),
            v2,
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 9), "SourceOffset"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 21), "TargetScale"),
            mem.get(PacketIO.PROTO_INT, offset + 25),
            v6,
            PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 29), "TargetOffset"),
            hasTargetPosition(mem, offset) ? PacketIO.requireFinite(PacketIO.readVector3f(mem, offset + 41), "TargetPosition") : null
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.targetPosition != null) nullBits |= 0x01;
        if (this.sourceNodeName != null) nullBits |= 0x02;
        if (this.targetNodeName != null) nullBits |= 0x04;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        
        mem.set(PacketIO.PROTO_INT, offset + 1, this.beamIndex);
        PacketIO.requireFinite(this.sourceScale, "SourceScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 5, this.sourceScale);
        PacketIO.requireFinite(this.sourceOffset, "SourceOffset"); PacketIO.writeVector3f(mem, offset + 9, this.sourceOffset);
        PacketIO.requireFinite(this.targetScale, "TargetScale"); mem.set(PacketIO.PROTO_FLOAT, offset + 21, this.targetScale);
        mem.set(PacketIO.PROTO_INT, offset + 25, this.targetNetworkId);
        PacketIO.requireFinite(this.targetOffset, "TargetOffset"); PacketIO.writeVector3f(mem, offset + 29, this.targetOffset);
        if (this.targetPosition != null) {
            PacketIO.requireFinite(this.targetPosition, "TargetPosition"); PacketIO.writeVector3f(mem, offset + 41, this.targetPosition);
        } else {
            mem.asSlice(offset + 41, 12).fill((byte) 0); 
        }
        var varOffset = offset + 61;
        if (this.sourceNodeName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 53, varOffset - offset - 61);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.sourceNodeName, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 53, -1);
        }
        if (this.targetNodeName != null) {
            mem.set(PacketIO.PROTO_INT, offset + 57, varOffset - offset - 61);
            varOffset += PacketIO.writeVarAsciiString(mem, varOffset, this.targetNodeName, 96);
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 57, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 61;
        if (sourceNodeName != null) size += VarInt.size(sourceNodeName.length()) + sourceNodeName.length();
    if (targetNodeName != null) size += VarInt.size(targetNodeName.length()) + targetNodeName.length();

        return size;
    }

    public BeamInstance clone() {
        BeamInstance copy = new BeamInstance();
        copy.beamIndex = this.beamIndex;
        copy.sourceScale = this.sourceScale;
        copy.sourceNodeName = this.sourceNodeName;
        copy.sourceOffset = this.sourceOffset;
        copy.targetScale = this.targetScale;
        copy.targetNetworkId = this.targetNetworkId;
        copy.targetNodeName = this.targetNodeName;
        copy.targetOffset = this.targetOffset;
        copy.targetPosition = this.targetPosition;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof BeamInstance other)) return false;
        return this.beamIndex == other.beamIndex && this.sourceScale == other.sourceScale && java.util.Objects.equals(this.sourceNodeName, other.sourceNodeName) && java.util.Objects.equals(this.sourceOffset, other.sourceOffset) && this.targetScale == other.targetScale && this.targetNetworkId == other.targetNetworkId && java.util.Objects.equals(this.targetNodeName, other.targetNodeName) && java.util.Objects.equals(this.targetOffset, other.targetOffset) && java.util.Objects.equals(this.targetPosition, other.targetPosition);
    }

    @Override
    public int hashCode() {
        return java.util.Objects.hash(beamIndex, sourceScale, sourceNodeName, sourceOffset, targetScale, targetNetworkId, targetNodeName, targetOffset, targetPosition);
    }

}