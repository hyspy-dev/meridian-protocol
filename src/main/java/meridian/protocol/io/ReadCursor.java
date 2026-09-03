package meridian.protocol.io;

import javax.annotation.Nonnull;

/**
 * Receives the end position of a decode. toObject reports through this where the encoding of the
 * value it decoded ends, so a caller reading a sequence of variable-size values can advance to the
 * next one without measuring the decoded value a second time.
 * <p>
 * One cursor serves a whole decode, so it also counts how deep that decode has walked. A
 * polymorphic value may hold further values of its own base type, and the decode of such a chain
 * recurses once per link. The count bounds the chain, which bounds the stack the decode needs.
 */
public final class ReadCursor {

    /**
     * Longest chain of nested polymorphic values one decode may walk. Well above what the protocol
     * uses, and far below the depth that would exhaust the stack of the thread doing the decode.
     * This is a wire limit, so the C# reader (see NestingDepth.Max) uses the same value.
     */
    public static final int MAX_NESTING_DEPTH = 32;

    /** Absolute segment position of the first byte after the decoded value. */
    public int position;

    private int depth;

    /**
     * Counts entry into a nested value. Rejects a value nested past {@link #MAX_NESTING_DEPTH}.
     * Every call that returns must be paired with {@link #exitNested()}.
     */
    public void enterNested(@Nonnull String typeName) {
        if (depth == MAX_NESTING_DEPTH) throw ProtocolException.nestingTooDeep(typeName, MAX_NESTING_DEPTH);
        depth++;
    }

    /** Counts the end of the nested value that the matching {@link #enterNested(String)} started. */
    public void exitNested() {
        depth--;
    }
}
