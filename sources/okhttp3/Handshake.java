package okhttp3;

import com.didi.travel.p172v2.store.IStoreCallback;
import java.io.IOException;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;
import okhttp3.internal.C3000Util;

public final class Handshake {

    /* renamed from: a */
    private final TlsVersion f7010a;

    /* renamed from: b */
    private final CipherSuite f7011b;

    /* renamed from: c */
    private final List<Certificate> f7012c;

    /* renamed from: d */
    private final List<Certificate> f7013d;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f7010a = tlsVersion;
        this.f7011b = cipherSuite;
        this.f7012c = list;
        this.f7013d = list2;
    }

    public static Handshake get(SSLSession sSLSession) throws IOException {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite == null) {
            throw new IllegalStateException("cipherSuite == null");
        } else if (!"SSL_NULL_WITH_NULL_NULL".equals(cipherSuite)) {
            CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol == null) {
                throw new IllegalStateException("tlsVersion == null");
            } else if (!IStoreCallback.DEFAULT_API_DETAIL_KEY.equals(protocol)) {
                TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = C3000Util.immutableList((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = C3000Util.immutableList((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                return new Handshake(forJavaName2, forJavaName, list, list2);
            } else {
                throw new IOException("tlsVersion == NONE");
            }
        } else {
            throw new IOException("cipherSuite == SSL_NULL_WITH_NULL_NULL");
        }
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (tlsVersion == null) {
            throw new NullPointerException("tlsVersion == null");
        } else if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, C3000Util.immutableList(list), C3000Util.immutableList(list2));
        } else {
            throw new NullPointerException("cipherSuite == null");
        }
    }

    public TlsVersion tlsVersion() {
        return this.f7010a;
    }

    public CipherSuite cipherSuite() {
        return this.f7011b;
    }

    public List<Certificate> peerCertificates() {
        return this.f7012c;
    }

    @Nullable
    public Principal peerPrincipal() {
        if (!this.f7012c.isEmpty()) {
            return ((X509Certificate) this.f7012c.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public List<Certificate> localCertificates() {
        return this.f7013d;
    }

    @Nullable
    public Principal localPrincipal() {
        if (!this.f7013d.isEmpty()) {
            return ((X509Certificate) this.f7013d.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        if (!this.f7010a.equals(handshake.f7010a) || !this.f7011b.equals(handshake.f7011b) || !this.f7012c.equals(handshake.f7012c) || !this.f7013d.equals(handshake.f7013d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((((527 + this.f7010a.hashCode()) * 31) + this.f7011b.hashCode()) * 31) + this.f7012c.hashCode()) * 31) + this.f7013d.hashCode();
    }
}
