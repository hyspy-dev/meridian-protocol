// Auto-generated - do not edit
package meridian.protocol;

import meridian.protocol.io.ProtocolException;

public enum InteractionType {
    Primary(0),
    Secondary(1),
    Ability1(2),
    Ability2(3),
    Ability3(4),
    Ability4(5),
    Use(6),
    Pick(7),
    Pickup(8),
    CollisionEnter(9),
    CollisionLeave(10),
    Collision(11),
    EntityStatEffect(12),
    SwapTo(13),
    SwapFrom(14),
    Death(15),
    Wielding(16),
    ProjectileSpawn(17),
    ProjectileHit(18),
    ProjectileMiss(19),
    ProjectileBounce(20),
    Held(21),
    HeldOffhand(22),
    Equipped(23),
    Dodge(24),
    GameModeSwap(25),
    OnBreak(26),
    OnBreakImpact(27);

    public static final InteractionType[] VALUES = values();

    private final int value;

    InteractionType(int value) {
        this.value = value;
    }

    public int getValue() {
        return value;
    }

    public static InteractionType fromValue(int value) {
        if (value >= 0 && value < VALUES.length) {
            return VALUES[value];
        }
        throw ProtocolException.invalidEnumValue("InteractionType", value);
    }
}