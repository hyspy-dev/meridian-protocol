package meridian.protocol.io;

import java.net.SocketAddress;
import java.util.concurrent.Future;

public interface ServerListener {
    Future<Void> close();

    SocketAddress localAddress();

    /**
     * Total UDP payload bytes received on this listener's socket, or -1 when the transport does not
     * expose wire-level counters.
     * <p>
     * Application-layer packet statistics undercount by the QUIC framing, acknowledgements, and
     * retransmits that a relay provider bills for, so relay cost estimates need this instead.
     */
    default long wireBytesReceived() {
        return -1;
    }

    /**
     * Total UDP payload bytes sent from this listener's socket, or -1 when the transport does not
     * expose wire-level counters.
     */
    default long wireBytesSent() {
        return -1;
    }
}
