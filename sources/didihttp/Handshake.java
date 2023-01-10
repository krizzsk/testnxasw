package didihttp;

import didihttp.internal.C21750Util;
import java.security.Principal;
import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLPeerUnverifiedException;
import javax.net.ssl.SSLSession;

public final class Handshake {

    /* renamed from: a */
    private final TlsVersion f59203a;

    /* renamed from: b */
    private final CipherSuite f59204b;

    /* renamed from: c */
    private final List<Certificate> f59205c;

    /* renamed from: d */
    private final List<Certificate> f59206d;

    /* renamed from: e */
    private byte[] f59207e;

    private Handshake(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        this.f59203a = tlsVersion;
        this.f59204b = cipherSuite;
        this.f59205c = list;
        this.f59206d = list2;
    }

    public static Handshake get(SSLSession sSLSession) {
        Certificate[] certificateArr;
        List list;
        List list2;
        String cipherSuite = sSLSession.getCipherSuite();
        if (cipherSuite != null) {
            CipherSuite forJavaName = CipherSuite.forJavaName(cipherSuite);
            String protocol = sSLSession.getProtocol();
            if (protocol != null) {
                TlsVersion forJavaName2 = TlsVersion.forJavaName(protocol);
                try {
                    certificateArr = sSLSession.getPeerCertificates();
                } catch (SSLPeerUnverifiedException unused) {
                    certificateArr = null;
                }
                if (certificateArr != null) {
                    list = C21750Util.immutableList((T[]) certificateArr);
                } else {
                    list = Collections.emptyList();
                }
                Certificate[] localCertificates = sSLSession.getLocalCertificates();
                if (localCertificates != null) {
                    list2 = C21750Util.immutableList((T[]) localCertificates);
                } else {
                    list2 = Collections.emptyList();
                }
                Handshake handshake = new Handshake(forJavaName2, forJavaName, list, list2);
                handshake.f59207e = sSLSession.getId();
                return handshake;
            }
            throw new IllegalStateException("tlsVersion == null");
        }
        throw new IllegalStateException("cipherSuite == null");
    }

    public static Handshake get(TlsVersion tlsVersion, CipherSuite cipherSuite, List<Certificate> list, List<Certificate> list2) {
        if (cipherSuite != null) {
            return new Handshake(tlsVersion, cipherSuite, C21750Util.immutableList(list), C21750Util.immutableList(list2));
        }
        throw new NullPointerException("cipherSuite == null");
    }

    public TlsVersion tlsVersion() {
        return this.f59203a;
    }

    public CipherSuite cipherSuite() {
        return this.f59204b;
    }

    public List<Certificate> peerCertificates() {
        return this.f59205c;
    }

    public Principal peerPrincipal() {
        if (!this.f59205c.isEmpty()) {
            return ((X509Certificate) this.f59205c.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public List<Certificate> localCertificates() {
        return this.f59206d;
    }

    public Principal localPrincipal() {
        if (!this.f59206d.isEmpty()) {
            return ((X509Certificate) this.f59206d.get(0)).getSubjectX500Principal();
        }
        return null;
    }

    public byte[] getSessionId() {
        return this.f59207e;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Handshake)) {
            return false;
        }
        Handshake handshake = (Handshake) obj;
        if (!C21750Util.equal(this.f59204b, handshake.f59204b) || !this.f59204b.equals(handshake.f59204b) || !this.f59205c.equals(handshake.f59205c) || !this.f59206d.equals(handshake.f59206d)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        TlsVersion tlsVersion = this.f59203a;
        return ((((((527 + (tlsVersion != null ? tlsVersion.hashCode() : 0)) * 31) + this.f59204b.hashCode()) * 31) + this.f59205c.hashCode()) * 31) + this.f59206d.hashCode();
    }
}
