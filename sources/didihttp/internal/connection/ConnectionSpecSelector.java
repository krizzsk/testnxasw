package didihttp.internal.connection;

import didihttp.ConnectionSpec;
import didihttp.internal.Internal;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.net.ProtocolException;
import java.net.UnknownServiceException;
import java.security.cert.CertificateException;
import java.util.Arrays;
import java.util.List;
import javax.net.ssl.SSLHandshakeException;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLProtocolException;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpecSelector {

    /* renamed from: a */
    private final List<ConnectionSpec> f59414a;

    /* renamed from: b */
    private int f59415b = 0;

    /* renamed from: c */
    private boolean f59416c;

    /* renamed from: d */
    private boolean f59417d;

    public ConnectionSpecSelector(List<ConnectionSpec> list) {
        this.f59414a = list;
    }

    public ConnectionSpec configureSecureSocket(SSLSocket sSLSocket) throws IOException {
        ConnectionSpec connectionSpec;
        int i = this.f59415b;
        int size = this.f59414a.size();
        while (true) {
            if (i >= size) {
                connectionSpec = null;
                break;
            }
            connectionSpec = this.f59414a.get(i);
            if (connectionSpec.isCompatible(sSLSocket)) {
                this.f59415b = i + 1;
                break;
            }
            i++;
        }
        if (connectionSpec != null) {
            this.f59416c = m44798a(sSLSocket);
            Internal.instance.apply(connectionSpec, sSLSocket, this.f59417d);
            return connectionSpec;
        }
        throw new UnknownServiceException("Unable to find acceptable protocols. isFallback=" + this.f59417d + ", modes=" + this.f59414a + ", supported protocols=" + Arrays.toString(sSLSocket.getEnabledProtocols()));
    }

    public boolean connectionFailed(IOException iOException) {
        this.f59417d = true;
        if (!this.f59416c || (iOException instanceof ProtocolException) || (iOException instanceof InterruptedIOException)) {
            return false;
        }
        boolean z = iOException instanceof SSLHandshakeException;
        if ((z && (iOException.getCause() instanceof CertificateException)) || (iOException instanceof SSLPeerUnverifiedException)) {
            return false;
        }
        if (z || (iOException instanceof SSLProtocolException)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m44798a(SSLSocket sSLSocket) {
        for (int i = this.f59415b; i < this.f59414a.size(); i++) {
            if (this.f59414a.get(i).isCompatible(sSLSocket)) {
                return true;
            }
        }
        return false;
    }
}
