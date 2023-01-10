package okhttp3.internal.connection;

import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;
import okhttp3.ConnectionSpec;
import okhttp3.internal.Internal;

public final class ConnectionSpecSelector {

    /* renamed from: a */
    private final List<ConnectionSpec> f7171a;

    /* renamed from: b */
    private int f7172b = 0;

    /* renamed from: c */
    private boolean f7173c;

    /* renamed from: d */
    private boolean f7174d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f7171a = list;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i = this.f7172b;
        int size = this.f7171a.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f7171a.get(i);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.f7172b = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec != null) {
            this.f7173c = m6804a(sSLSocket);
            Internal.instance.apply(connectionSpec, sSLSocket, this.f7174d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f7174d + ", modes=" + this.f7171a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean connectionFailed(IOException iOException) {
        this.f7174d = true;
        if (!this.f7173c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z || (iOException instanceof SSLProtocolException) || (iOException instanceof SSLException)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m6804a(SSLSocket sSLSocket) {
        for (int i = this.f7172b; i < this.f7171a.size(); i++) {
            if (this.f7171a.get(i).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
