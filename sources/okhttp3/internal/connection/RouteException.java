package okhttp3.internal.connection;

import java.io.IOException;
import okhttp3.internal.C3000Util;

public final class RouteException extends RuntimeException {
    private IOException firstException;
    private IOException lastException;

    public RouteException(IOException iOException) {
        super(iOException);
        this.firstException = iOException;
        this.lastException = iOException;
    }

    public IOException getFirstConnectException() {
        return this.firstException;
    }

    public IOException getLastConnectException() {
        return this.lastException;
    }

    public void addConnectException(IOException iOException) {
        C3000Util.addSuppressedIfPossible(this.firstException, iOException);
        this.lastException = iOException;
    }
}
