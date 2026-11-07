package meridian.protocol.io;

import meridian.protocol.NetworkChannel;
import meridian.protocol.ToServerPacket;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;

/**
 * Interface for a connection-level packet handler that transports can invoke.
 * Implemented by {@code PacketHandler} in CoreServer.
 */
public interface ConnectionHandler {

    /**
     * Called to handle the given incoming packet.
     *
     * @param packet The packet to be handled
     */
    void handle(@Nonnull ToServerPacket packet);

    /**
     * Tests if this handler accepts packets with the given ID in its current state. Transports call
     * this when the frame header arrives, before they buffer or decompress the payload, and close
     * the connection if it returns {@code false}.
     *
     * @param packetId The ID of the received packet
     */
    default boolean handlesPacket(int packetId) {
        return true;
    }

    /**
     * Called when the affiliated network channel has been closed.
     *
     * @param networkChannel The network channel that was closed, or null if unknown
     */
    void closed(@Nullable NetworkChannel networkChannel);

    /**
     * Called to log that this handler's connection has been closed.
     */
    void logCloseMessage();

    /**
     * Called when this handler is registered on a connection, potentially replacing an old handler.
     *
     * @param oldHandler The previous handler, or null if this is the first handler
     */
    void registered(@Nullable ConnectionHandler oldHandler);

    /**
     * Called when this handler is unregistered from a connection, potentially being replaced by a new handler.
     *
     * @param newHandler The new handler replacing this one, or null
     */
    void unregistered(@Nullable ConnectionHandler newHandler);
}
