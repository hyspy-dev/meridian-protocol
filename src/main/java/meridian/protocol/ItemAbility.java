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
import java.util.HashMap;

public class ItemAbility {
    public static final int NULLABLE_BIT_FIELD_SIZE = 2;
    public static final int FIXED_BLOCK_SIZE = 16;
    public static final int VARIABLE_FIELD_COUNT = 9;
    public static final int VARIABLE_BLOCK_START = 52;
    public static final int MAX_SIZE = 1677721600;

    @Nonnull public AbilitySlot slot = AbilitySlot.Primary;
    public float cooldown;
    public float cost;
    @Nonnull public AbilityCostType costType = AbilityCostType.None;
    @Nullable public String[] weapons;
    @Nullable public int[] weaponTagIndexes;
    @Nullable public String[] tags;
    @Nullable public int[] expandedTagIndexes;
    @Nullable public String[] appliesTo;
    @Nullable public int[] appliesToIndexes;
    @Nullable public String[] onHitEffects;
    @Nullable public java.util.Map<String, Float> attributes;
    @Nullable public java.util.Map<String, Modifier[]> attributeModifiers;
    public int cast = Integer.MIN_VALUE;

    public ItemAbility() {
    }

    public ItemAbility(@Nonnull AbilitySlot slot, float cooldown, float cost, @Nonnull AbilityCostType costType, @Nullable String[] weapons, @Nullable int[] weaponTagIndexes, @Nullable String[] tags, @Nullable int[] expandedTagIndexes, @Nullable String[] appliesTo, @Nullable int[] appliesToIndexes, @Nullable String[] onHitEffects, @Nullable java.util.Map<String, Float> attributes, @Nullable java.util.Map<String, Modifier[]> attributeModifiers, int cast) {
        this.slot = slot;
        this.cooldown = cooldown;
        this.cost = cost;
        this.costType = costType;
        this.weapons = weapons;
        this.weaponTagIndexes = weaponTagIndexes;
        this.tags = tags;
        this.expandedTagIndexes = expandedTagIndexes;
        this.appliesTo = appliesTo;
        this.appliesToIndexes = appliesToIndexes;
        this.onHitEffects = onHitEffects;
        this.attributes = attributes;
        this.attributeModifiers = attributeModifiers;
        this.cast = cast;
    }

    public ItemAbility(@Nonnull ItemAbility other) {
        this.slot = other.slot;
        this.cooldown = other.cooldown;
        this.cost = other.cost;
        this.costType = other.costType;
        this.weapons = other.weapons;
        this.weaponTagIndexes = other.weaponTagIndexes;
        this.tags = other.tags;
        this.expandedTagIndexes = other.expandedTagIndexes;
        this.appliesTo = other.appliesTo;
        this.appliesToIndexes = other.appliesToIndexes;
        this.onHitEffects = other.onHitEffects;
        this.attributes = other.attributes;
        this.attributeModifiers = other.attributeModifiers;
        this.cast = other.cast;
    }

    /**
     * Checks that the fixed block fits. The per-field getters read without their own bound
     * check, so call this once before reading fields out of an untrusted segment.
     */
    public static void requireBounds(MemorySegment mem, int offset) {
        if (offset < 0) throw ProtocolException.invalidOffset("ItemAbility", offset, (int) mem.byteSize());
        long needed = (long) offset + 52;
        if (needed > mem.byteSize()) throw ProtocolException.bufferTooSmall("ItemAbility", (int) java.lang.Math.min(needed, Integer.MAX_VALUE), (int) mem.byteSize());
    }
    
    public static AbilitySlot getSlot(MemorySegment mem) {
        return getSlot(mem, 0);
    }
    
    public static AbilitySlot getSlot(MemorySegment mem, int offset) {
        return AbilitySlot.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2));
    }
    
    public static float getCooldown(MemorySegment mem) {
        return getCooldown(mem, 0);
    }
    
    public static float getCooldown(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "Cooldown");
    }
    
    public static float getCost(MemorySegment mem) {
        return getCost(mem, 0);
    }
    
    public static float getCost(MemorySegment mem, int offset) {
        return PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 7), "Cost");
    }
    
    public static AbilityCostType getCostType(MemorySegment mem) {
        return getCostType(mem, 0);
    }
    
    public static AbilityCostType getCostType(MemorySegment mem, int offset) {
        return AbilityCostType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 11));
    }
    
    @Nullable
    public static String[] getWeapons(MemorySegment mem) {
        return getWeapons(mem, 0);
    }
    
    @Nullable
    public static String[] getWeapons(MemorySegment mem, int offset) {
        if (!hasWeapons(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 16, 52, "Weapons");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Weapons");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Weapons", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Weapons", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Weapons", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static int[] getWeaponTagIndexes(MemorySegment mem) {
        return getWeaponTagIndexes(mem, 0);
    }
    
    @Nullable
    public static int[] getWeaponTagIndexes(MemorySegment mem, int offset) {
        if (!hasWeaponTagIndexes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 20, 52, "WeaponTagIndexes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("WeaponTagIndexes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("WeaponTagIndexes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("WeaponTagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static String[] getTags(MemorySegment mem) {
        return getTags(mem, 0);
    }
    
    @Nullable
    public static String[] getTags(MemorySegment mem, int offset) {
        if (!hasTags(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 24, 52, "Tags");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("Tags", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("Tags", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static int[] getExpandedTagIndexes(MemorySegment mem) {
        return getExpandedTagIndexes(mem, 0);
    }
    
    @Nullable
    public static int[] getExpandedTagIndexes(MemorySegment mem, int offset) {
        if (!hasExpandedTagIndexes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 28, 52, "ExpandedTagIndexes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("ExpandedTagIndexes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("ExpandedTagIndexes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ExpandedTagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static String[] getAppliesTo(MemorySegment mem) {
        return getAppliesTo(mem, 0);
    }
    
    @Nullable
    public static String[] getAppliesTo(MemorySegment mem, int offset) {
        if (!hasAppliesTo(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 32, 52, "AppliesTo");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AppliesTo");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("AppliesTo", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("AppliesTo", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("AppliesTo", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static int[] getAppliesToIndexes(MemorySegment mem) {
        return getAppliesToIndexes(mem, 0);
    }
    
    @Nullable
    public static int[] getAppliesToIndexes(MemorySegment mem, int offset) {
        if (!hasAppliesToIndexes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 36, 52, "AppliesToIndexes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AppliesToIndexes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("AppliesToIndexes", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AppliesToIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new int[len];
        MemorySegment.copy(mem, PacketIO.PROTO_INT, off, data, 0, len);
        return data;
    }
    
    @Nullable
    public static String[] getOnHitEffects(MemorySegment mem) {
        return getOnHitEffects(mem, 0);
    }
    
    @Nullable
    public static String[] getOnHitEffects(MemorySegment mem, int offset) {
        if (!hasOnHitEffects(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 40, 52, "OnHitEffects");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("OnHitEffects");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.arrayTooLong("OnHitEffects", len, 4096000);
        var lenOffset = (int) (packed >>> 32);
        if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("OnHitEffects", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
        off += lenOffset;
        var data = new String[len];
        for (var i = 0; i < len; i++) {
            var sp = VarInt.getWithLength(mem, off);
            data[i] = PacketIO.readVarString("OnHitEffects", mem, off, 0, 4096000, sp);
            off += (int) sp + (int) (sp >>> 32);
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<String, Float> getAttributes(MemorySegment mem) {
        return getAttributes(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, Float> getAttributes(MemorySegment mem, int offset) {
        if (!hasAttributes(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 44, 52, "Attributes");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("Attributes");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Attributes", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Attributes", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, Float> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var value = mem.get(PacketIO.PROTO_FLOAT, off);
                off += 4;
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("Attributes", key);
            }
        }
        return data;
    }
    
    @Nullable
    public static java.util.Map<String, Modifier[]> getAttributeModifiers(MemorySegment mem) {
        return getAttributeModifiers(mem, 0);
    }
    
    @Nullable
    public static java.util.Map<String, Modifier[]> getAttributeModifiers(MemorySegment mem, int offset) {
        if (!hasAttributeModifiers(mem, offset)) return null;
        var off = offset + getValidatedOffset(mem, offset, 48, 52, "AttributeModifiers");
        var packed = VarInt.getWithLength(mem, off);
        if (packed == -1L) throw ProtocolException.invalidVarInt("AttributeModifiers");
        var len = (int) packed;
        if (len > 4096000) throw ProtocolException.dictionaryTooLarge("AttributeModifiers", len, 4096000);
        
        off += (int) (packed >>> 32);
        if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AttributeModifiers", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
        java.util.Map<String, Modifier[]> data = new HashMap<>(len);
        for (var i = 0; i < len; i++) {
            var keyPacked = VarInt.getWithLength(mem, off);
                var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                off += (int) keyPacked + (int) (keyPacked >>> 32);
            var valuePacked = VarInt.getWithLength(mem, off);
                if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                var valueLen = (int) valuePacked;
                var valueVarLen = (int) (valuePacked >>> 32);
                if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                if (off + valueVarLen + (long) valueLen * 6 > mem.byteSize())
                    throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 6, (int) mem.byteSize());
                off += valueVarLen;
                var value = new Modifier[valueLen];
                for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                    value[valueIdx] = Modifier.toObject(mem, off);
                    off += 6;
                }
            if (data.put(key, value) != null) {
                throw ProtocolException.duplicateKey("AttributeModifiers", key);
            }
        }
        return data;
    }
    
    public static int getCast(MemorySegment mem) {
        return getCast(mem, 0);
    }
    
    public static int getCast(MemorySegment mem, int offset) {
        return mem.get(PacketIO.PROTO_INT, offset + 12);
    }
    
    public static boolean hasWeapons(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x01) != 0;
    }
    
    public static boolean hasWeaponTagIndexes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x02) != 0;
    }
    
    public static boolean hasTags(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x04) != 0;
    }
    
    public static boolean hasExpandedTagIndexes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x08) != 0;
    }
    
    public static boolean hasAppliesTo(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x10) != 0;
    }
    
    public static boolean hasAppliesToIndexes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x20) != 0;
    }
    
    public static boolean hasOnHitEffects(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x40) != 0;
    }
    
    public static boolean hasAttributes(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 0);
        return (b & 0x80) != 0;
    }
    
    public static boolean hasAttributeModifiers(MemorySegment mem, int offset) {
        var b = mem.get(PacketIO.PROTO_BYTE, offset + 1);
        return (b & 0x01) != 0;
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
    
    public static ItemAbility toObject(MemorySegment mem) {
        return toObject(mem, 0, null);
    }
    
    public static ItemAbility toObject(MemorySegment mem, int offset) {
        return toObject(mem, offset, null);
    }
    
    /**
     * Decodes one ItemAbility and reports the end of its encoding through the cursor.
     * The variable block is decoded in field order against a running position, and each
     * offset slot must name that position, so the fields decoded are the bytes walked.
     */
    public static ItemAbility toObject(MemorySegment mem, int offset, @Nullable ReadCursor cursor) {
        // Checking the whole fixed block up front lets the JIT elide the per-field bound checks.
        requireBounds(mem, offset);
        var varBase = offset + 52;
        var varPos = 0;
        String[] v4 = null;
        if (hasWeapons(mem, offset)) {
            requireSlot(mem, offset + 16, varPos, "Weapons");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Weapons");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Weapons", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Weapons", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v4 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v4[i] = PacketIO.readVarString("Weapons", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 16, -1, "Weapons");
        }
        
        int[] v5 = null;
        if (hasWeaponTagIndexes(mem, offset)) {
            requireSlot(mem, offset + 20, varPos, "WeaponTagIndexes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("WeaponTagIndexes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("WeaponTagIndexes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("WeaponTagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v5 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v5, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 20, -1, "WeaponTagIndexes");
        }
        
        String[] v6 = null;
        if (hasTags(mem, offset)) {
            requireSlot(mem, offset + 24, varPos, "Tags");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Tags");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("Tags", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("Tags", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v6 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v6[i] = PacketIO.readVarString("Tags", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 24, -1, "Tags");
        }
        
        int[] v7 = null;
        if (hasExpandedTagIndexes(mem, offset)) {
            requireSlot(mem, offset + 28, varPos, "ExpandedTagIndexes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("ExpandedTagIndexes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("ExpandedTagIndexes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("ExpandedTagIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v7 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v7, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 28, -1, "ExpandedTagIndexes");
        }
        
        String[] v8 = null;
        if (hasAppliesTo(mem, offset)) {
            requireSlot(mem, offset + 32, varPos, "AppliesTo");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AppliesTo");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("AppliesTo", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("AppliesTo", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v8 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v8[i] = PacketIO.readVarString("AppliesTo", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 32, -1, "AppliesTo");
        }
        
        int[] v9 = null;
        if (hasAppliesToIndexes(mem, offset)) {
            requireSlot(mem, offset + 36, varPos, "AppliesToIndexes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AppliesToIndexes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("AppliesToIndexes", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + (long) len * 4 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AppliesToIndexes", (int) java.lang.Math.min(off + lenOffset + (long) len * 4, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v9 = new int[len];
            MemorySegment.copy(mem, PacketIO.PROTO_INT, off, v9, 0, len);
            varPos = off + len * 4 - varBase;
        } else {
            requireSlot(mem, offset + 36, -1, "AppliesToIndexes");
        }
        
        String[] v10 = null;
        if (hasOnHitEffects(mem, offset)) {
            requireSlot(mem, offset + 40, varPos, "OnHitEffects");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("OnHitEffects");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.arrayTooLong("OnHitEffects", len, 4096000);
            var lenOffset = (int) (packed >>> 32);
            if (off + lenOffset + len > mem.byteSize()) throw ProtocolException.bufferTooSmall("OnHitEffects", (int) java.lang.Math.min(off + lenOffset + len, Integer.MAX_VALUE), (int) mem.byteSize());
            off += lenOffset;
            v10 = new String[len];
            for (var i = 0; i < len; i++) {
                var sp = VarInt.getWithLength(mem, off);
                v10[i] = PacketIO.readVarString("OnHitEffects", mem, off, 0, 4096000, sp);
                off += (int) sp + (int) (sp >>> 32);
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 40, -1, "OnHitEffects");
        }
        
        java.util.Map<String, Float> v11 = null;
        if (hasAttributes(mem, offset)) {
            requireSlot(mem, offset + 44, varPos, "Attributes");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("Attributes");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("Attributes", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 5 > mem.byteSize()) throw ProtocolException.bufferTooSmall("Attributes", (int) java.lang.Math.min(off + (long) len * 5, Integer.MAX_VALUE), (int) mem.byteSize());
            v11 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var value = mem.get(PacketIO.PROTO_FLOAT, off);
                    off += 4;
                if (v11.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("Attributes", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 44, -1, "Attributes");
        }
        
        java.util.Map<String, Modifier[]> v12 = null;
        if (hasAttributeModifiers(mem, offset)) {
            requireSlot(mem, offset + 48, varPos, "AttributeModifiers");
            var off = varBase + varPos;
            var packed = VarInt.getWithLength(mem, off);
            if (packed == -1L) throw ProtocolException.invalidVarInt("AttributeModifiers");
            var len = (int) packed;
            if (len > 4096000) throw ProtocolException.dictionaryTooLarge("AttributeModifiers", len, 4096000);
            
            off += (int) (packed >>> 32);
            if (off + (long) len * 2 > mem.byteSize()) throw ProtocolException.bufferTooSmall("AttributeModifiers", (int) java.lang.Math.min(off + (long) len * 2, Integer.MAX_VALUE), (int) mem.byteSize());
            v12 = new HashMap<>(len);
            for (var i = 0; i < len; i++) {
                var keyPacked = VarInt.getWithLength(mem, off);
                    var key = PacketIO.readVarString("key", mem, off, 0, 4096000, keyPacked);
                    off += (int) keyPacked + (int) (keyPacked >>> 32);
                var valuePacked = VarInt.getWithLength(mem, off);
                    if (valuePacked == -1L) throw ProtocolException.invalidVarInt("value");
                    var valueLen = (int) valuePacked;
                    var valueVarLen = (int) (valuePacked >>> 32);
                    if (valueLen > 4096000) throw ProtocolException.arrayTooLong("value", valueLen, 4096000);
                    if (off + valueVarLen + (long) valueLen * 6 > mem.byteSize())
                        throw ProtocolException.bufferTooSmall("value", off + valueVarLen + valueLen * 6, (int) mem.byteSize());
                    off += valueVarLen;
                    var value = new Modifier[valueLen];
                    for (var valueIdx = 0; valueIdx < valueLen; valueIdx++) {
                        value[valueIdx] = Modifier.toObject(mem, off);
                        off += 6;
                    }
                if (v12.put(key, value) != null) {
                    throw ProtocolException.duplicateKey("AttributeModifiers", key);
                }
            }
            varPos = off - varBase;
        } else {
            requireSlot(mem, offset + 48, -1, "AttributeModifiers");
        }
        var result = new ItemAbility(
            AbilitySlot.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 2)),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 3), "Cooldown"),
            PacketIO.requireFinite(mem.get(PacketIO.PROTO_FLOAT, offset + 7), "Cost"),
            AbilityCostType.fromValue(mem.get(PacketIO.PROTO_BYTE, offset + 11)),
            v4,
            v5,
            v6,
            v7,
            v8,
            v9,
            v10,
            v11,
            v12,
            mem.get(PacketIO.PROTO_INT, offset + 12)
        );
        if (cursor != null) cursor.position = varBase + varPos;
        return result;
    }
    public int serialize(@Nonnull MemorySegment mem, int offset) {
        byte nullBits;
        nullBits = 0;
        if (this.weapons != null) nullBits |= 0x01;
        if (this.weaponTagIndexes != null) nullBits |= 0x02;
        if (this.tags != null) nullBits |= 0x04;
        if (this.expandedTagIndexes != null) nullBits |= 0x08;
        if (this.appliesTo != null) nullBits |= 0x10;
        if (this.appliesToIndexes != null) nullBits |= 0x20;
        if (this.onHitEffects != null) nullBits |= 0x40;
        if (this.attributes != null) nullBits |= 0x80;
        mem.set(PacketIO.PROTO_BYTE, offset + 0, nullBits);
        nullBits = 0;
        if (this.attributeModifiers != null) nullBits |= 0x01;
        mem.set(PacketIO.PROTO_BYTE, offset + 1, nullBits);
        
        mem.set(PacketIO.PROTO_BYTE, offset + 2, (byte) this.slot.getValue());
        PacketIO.requireFinite(this.cooldown, "Cooldown"); mem.set(PacketIO.PROTO_FLOAT, offset + 3, this.cooldown);
        PacketIO.requireFinite(this.cost, "Cost"); mem.set(PacketIO.PROTO_FLOAT, offset + 7, this.cost);
        mem.set(PacketIO.PROTO_BYTE, offset + 11, (byte) this.costType.getValue());
        mem.set(PacketIO.PROTO_INT, offset + 12, this.cast);
        var varOffset = offset + 52;
        if (this.weapons != null) {
            mem.set(PacketIO.PROTO_INT, offset + 16, varOffset - offset - 52);
            if (weapons.length > 4096000) throw ProtocolException.arrayTooLong("Weapons", weapons.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.weapons.length);
            
            var weaponsValueOffset = 0;
            for (var i = 0; i < this.weapons.length; i++) {
                weaponsValueOffset += PacketIO.writeVarString(mem, varOffset + weaponsValueOffset, this.weapons[i], 4096000);
            }
            varOffset += weaponsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 16, -1);
        }
        if (this.weaponTagIndexes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 20, varOffset - offset - 52);
            if (weaponTagIndexes.length > 4096000) throw ProtocolException.arrayTooLong("WeaponTagIndexes", weaponTagIndexes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.weaponTagIndexes.length);
            
            MemorySegment.copy(this.weaponTagIndexes, 0, mem, PacketIO.PROTO_INT, varOffset, this.weaponTagIndexes.length);
            varOffset += this.weaponTagIndexes.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 20, -1);
        }
        if (this.tags != null) {
            mem.set(PacketIO.PROTO_INT, offset + 24, varOffset - offset - 52);
            if (tags.length > 4096000) throw ProtocolException.arrayTooLong("Tags", tags.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.tags.length);
            
            var tagsValueOffset = 0;
            for (var i = 0; i < this.tags.length; i++) {
                tagsValueOffset += PacketIO.writeVarString(mem, varOffset + tagsValueOffset, this.tags[i], 4096000);
            }
            varOffset += tagsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 24, -1);
        }
        if (this.expandedTagIndexes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 28, varOffset - offset - 52);
            if (expandedTagIndexes.length > 4096000) throw ProtocolException.arrayTooLong("ExpandedTagIndexes", expandedTagIndexes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.expandedTagIndexes.length);
            
            MemorySegment.copy(this.expandedTagIndexes, 0, mem, PacketIO.PROTO_INT, varOffset, this.expandedTagIndexes.length);
            varOffset += this.expandedTagIndexes.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 28, -1);
        }
        if (this.appliesTo != null) {
            mem.set(PacketIO.PROTO_INT, offset + 32, varOffset - offset - 52);
            if (appliesTo.length > 4096000) throw ProtocolException.arrayTooLong("AppliesTo", appliesTo.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.appliesTo.length);
            
            var appliesToValueOffset = 0;
            for (var i = 0; i < this.appliesTo.length; i++) {
                appliesToValueOffset += PacketIO.writeVarString(mem, varOffset + appliesToValueOffset, this.appliesTo[i], 4096000);
            }
            varOffset += appliesToValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 32, -1);
        }
        if (this.appliesToIndexes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 36, varOffset - offset - 52);
            if (appliesToIndexes.length > 4096000) throw ProtocolException.arrayTooLong("AppliesToIndexes", appliesToIndexes.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.appliesToIndexes.length);
            
            MemorySegment.copy(this.appliesToIndexes, 0, mem, PacketIO.PROTO_INT, varOffset, this.appliesToIndexes.length);
            varOffset += this.appliesToIndexes.length * 4;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 36, -1);
        }
        if (this.onHitEffects != null) {
            mem.set(PacketIO.PROTO_INT, offset + 40, varOffset - offset - 52);
            if (onHitEffects.length > 4096000) throw ProtocolException.arrayTooLong("OnHitEffects", onHitEffects.length, 4096000);
            varOffset += VarInt.set(mem, varOffset, this.onHitEffects.length);
            
            var onHitEffectsValueOffset = 0;
            for (var i = 0; i < this.onHitEffects.length; i++) {
                onHitEffectsValueOffset += PacketIO.writeVarString(mem, varOffset + onHitEffectsValueOffset, this.onHitEffects[i], 4096000);
            }
            varOffset += onHitEffectsValueOffset;
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 40, -1);
        }
        if (this.attributes != null) {
            mem.set(PacketIO.PROTO_INT, offset + 44, varOffset - offset - 52);
            if (this.attributes.size() > 4096000) throw ProtocolException.dictionaryTooLarge("Attributes", attributes.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.attributes.size());
            for (var e : this.attributes.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                mem.set(PacketIO.PROTO_FLOAT, varOffset, e.getValue());
                varOffset += 4;
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 44, -1);
        }
        if (this.attributeModifiers != null) {
            mem.set(PacketIO.PROTO_INT, offset + 48, varOffset - offset - 52);
            if (this.attributeModifiers.size() > 4096000) throw ProtocolException.dictionaryTooLarge("AttributeModifiers", attributeModifiers.size(), 4096000);
            varOffset += VarInt.set(mem, varOffset, this.attributeModifiers.size());
            for (var e : this.attributeModifiers.entrySet()) {
                varOffset += PacketIO.writeVarString(mem, varOffset, e.getKey(), 4096000);
                varOffset += VarInt.set(mem, varOffset, e.getValue().length);
                for (var arrItem : e.getValue()) {
                    varOffset += arrItem.serialize(mem, varOffset);
                }
            }
        } else {
            mem.set(PacketIO.PROTO_INT, offset + 48, -1);
        }
    
       return varOffset - offset;
    }
    public int computeSize() {
        int size = 52;
        if (weapons != null) {
        int weaponsSize = 0;
for (var elem : weapons) weaponsSize += PacketIO.stringSize(elem);
size += VarInt.size(weapons.length) + weaponsSize;
    }
    if (weaponTagIndexes != null) size += VarInt.size(weaponTagIndexes.length) + weaponTagIndexes.length * 4;
    if (tags != null) {
        int tagsSize = 0;
for (var elem : tags) tagsSize += PacketIO.stringSize(elem);
size += VarInt.size(tags.length) + tagsSize;
    }
    if (expandedTagIndexes != null) size += VarInt.size(expandedTagIndexes.length) + expandedTagIndexes.length * 4;
    if (appliesTo != null) {
        int appliesToSize = 0;
for (var elem : appliesTo) appliesToSize += PacketIO.stringSize(elem);
size += VarInt.size(appliesTo.length) + appliesToSize;
    }
    if (appliesToIndexes != null) size += VarInt.size(appliesToIndexes.length) + appliesToIndexes.length * 4;
    if (onHitEffects != null) {
        int onHitEffectsSize = 0;
for (var elem : onHitEffects) onHitEffectsSize += PacketIO.stringSize(elem);
size += VarInt.size(onHitEffects.length) + onHitEffectsSize;
    }
    if (attributes != null) {
        int attributesSize = 0;
for (var kvp : attributes.entrySet()) attributesSize += PacketIO.stringSize(kvp.getKey()) + 4;
size += VarInt.size(attributes.size()) + attributesSize;
    }
    if (attributeModifiers != null) {
        int attributeModifiersSize = 0;
for (var kvp : attributeModifiers.entrySet()) attributeModifiersSize += PacketIO.stringSize(kvp.getKey()) + VarInt.size(kvp.getValue().length) + kvp.getValue().length * 6;
size += VarInt.size(attributeModifiers.size()) + attributeModifiersSize;
    }

        return size;
    }

    public ItemAbility clone() {
        ItemAbility copy = new ItemAbility();
        copy.slot = this.slot;
        copy.cooldown = this.cooldown;
        copy.cost = this.cost;
        copy.costType = this.costType;
        copy.weapons = this.weapons != null ? java.util.Arrays.copyOf(this.weapons, this.weapons.length) : null;
        copy.weaponTagIndexes = this.weaponTagIndexes != null ? java.util.Arrays.copyOf(this.weaponTagIndexes, this.weaponTagIndexes.length) : null;
        copy.tags = this.tags != null ? java.util.Arrays.copyOf(this.tags, this.tags.length) : null;
        copy.expandedTagIndexes = this.expandedTagIndexes != null ? java.util.Arrays.copyOf(this.expandedTagIndexes, this.expandedTagIndexes.length) : null;
        copy.appliesTo = this.appliesTo != null ? java.util.Arrays.copyOf(this.appliesTo, this.appliesTo.length) : null;
        copy.appliesToIndexes = this.appliesToIndexes != null ? java.util.Arrays.copyOf(this.appliesToIndexes, this.appliesToIndexes.length) : null;
        copy.onHitEffects = this.onHitEffects != null ? java.util.Arrays.copyOf(this.onHitEffects, this.onHitEffects.length) : null;
        copy.attributes = this.attributes != null ? new java.util.HashMap<>(this.attributes) : null;
        if (this.attributeModifiers != null) {
            java.util.Map<String, Modifier[]> m = new java.util.HashMap<>();
            for (var e : this.attributeModifiers.entrySet()) { m.put(e.getKey(), java.util.Arrays.stream(e.getValue()).map(x -> x.clone()).toArray(Modifier[]::new)); }
            copy.attributeModifiers = m;
        }
        copy.cast = this.cast;
        return copy;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof ItemAbility other)) return false;
        return java.util.Objects.equals(this.slot, other.slot) && this.cooldown == other.cooldown && this.cost == other.cost && java.util.Objects.equals(this.costType, other.costType) && java.util.Arrays.equals(this.weapons, other.weapons) && java.util.Arrays.equals(this.weaponTagIndexes, other.weaponTagIndexes) && java.util.Arrays.equals(this.tags, other.tags) && java.util.Arrays.equals(this.expandedTagIndexes, other.expandedTagIndexes) && java.util.Arrays.equals(this.appliesTo, other.appliesTo) && java.util.Arrays.equals(this.appliesToIndexes, other.appliesToIndexes) && java.util.Arrays.equals(this.onHitEffects, other.onHitEffects) && java.util.Objects.equals(this.attributes, other.attributes) && java.util.Objects.equals(this.attributeModifiers, other.attributeModifiers) && this.cast == other.cast;
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = 31 * result + java.util.Objects.hashCode(slot);
        result = 31 * result + Float.hashCode(cooldown);
        result = 31 * result + Float.hashCode(cost);
        result = 31 * result + java.util.Objects.hashCode(costType);
        result = 31 * result + java.util.Arrays.hashCode(weapons);
        result = 31 * result + java.util.Arrays.hashCode(weaponTagIndexes);
        result = 31 * result + java.util.Arrays.hashCode(tags);
        result = 31 * result + java.util.Arrays.hashCode(expandedTagIndexes);
        result = 31 * result + java.util.Arrays.hashCode(appliesTo);
        result = 31 * result + java.util.Arrays.hashCode(appliesToIndexes);
        result = 31 * result + java.util.Arrays.hashCode(onHitEffects);
        result = 31 * result + java.util.Objects.hashCode(attributes);
        result = 31 * result + java.util.Objects.hashCode(attributeModifiers);
        result = 31 * result + Integer.hashCode(cast);
        return result;
    }

}