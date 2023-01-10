package okhttp3;

import java.util.Arrays;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.ssl.SSLSocket;
import okhttp3.internal.C3000Util;

public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
    public static final ConnectionSpec COMPATIBLE_TLS = new Builder(true).cipherSuites(f6981f).tlsVersions(TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final ConnectionSpec MODERN_TLS = new Builder(true).cipherSuites(f6981f).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    public static final ConnectionSpec RESTRICTED_TLS = new Builder(true).cipherSuites(f6980e).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2).supportsTlsExtensions(true).build();

    /* renamed from: e */
    private static final CipherSuite[] f6980e = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_AES_128_CCM_SHA256, CipherSuite.TLS_AES_256_CCM_8_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256};

    /* renamed from: f */
    private static final CipherSuite[] f6981f = {CipherSuite.TLS_AES_128_GCM_SHA256, CipherSuite.TLS_AES_256_GCM_SHA384, CipherSuite.TLS_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_AES_128_CCM_SHA256, CipherSuite.TLS_AES_256_CCM_8_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};

    /* renamed from: a */
    final boolean f6982a;

    /* renamed from: b */
    final boolean f6983b;
    @Nullable

    /* renamed from: c */
    final String[] f6984c;
    @Nullable

    /* renamed from: d */
    final String[] f6985d;

    ConnectionSpec(Builder builder) {
        this.f6982a = builder.tls;
        this.f6984c = builder.cipherSuites;
        this.f6985d = builder.tlsVersions;
        this.f6983b = builder.supportsTlsExtensions;
    }

    public boolean isTls() {
        return this.f6982a;
    }

    @Nullable
    public List<CipherSuite> cipherSuites() {
        String[] strArr = this.f6984c;
        if (strArr != null) {
            return CipherSuite.m6717a(strArr);
        }
        return null;
    }

    @Nullable
    public List<TlsVersion> tlsVersions() {
        String[] strArr = this.f6985d;
        if (strArr != null) {
            return TlsVersion.forJavaNames(strArr);
        }
        return null;
    }

    public boolean supportsTlsExtensions() {
        return this.f6983b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo29973a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec b = m6725b(sSLSocket, z);
        String[] strArr = b.f6985d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b.f6984c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    private ConnectionSpec m6725b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        if (this.f6984c != null) {
            strArr = C3000Util.intersect(CipherSuite.f6969a, sSLSocket.getEnabledCipherSuites(), this.f6984c);
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        if (this.f6985d != null) {
            strArr2 = C3000Util.intersect(C3000Util.NATURAL_ORDER, sSLSocket.getEnabledProtocols(), this.f6985d);
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        String[] supportedCipherSuites = sSLSocket.getSupportedCipherSuites();
        int indexOf = C3000Util.indexOf(CipherSuite.f6969a, supportedCipherSuites, "TLS_FALLBACK_SCSV");
        if (z && indexOf != -1) {
            strArr = C3000Util.concat(strArr, supportedCipherSuites[indexOf]);
        }
        return new Builder(this).cipherSuites(strArr).tlsVersions(strArr2).build();
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.f6982a) {
            return false;
        }
        if (this.f6985d != null && !C3000Util.nonEmptyIntersection(C3000Util.NATURAL_ORDER, this.f6985d, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        if (this.f6984c == null || C3000Util.nonEmptyIntersection(CipherSuite.f6969a, this.f6984c, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    public boolean equals(@Nullable Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = this.f6982a;
        if (z != connectionSpec.f6982a) {
            return false;
        }
        return !z || (Arrays.equals(this.f6984c, connectionSpec.f6984c) && Arrays.equals(this.f6985d, connectionSpec.f6985d) && this.f6983b == connectionSpec.f6983b);
    }

    public int hashCode() {
        if (this.f6982a) {
            return ((((527 + Arrays.hashCode(this.f6984c)) * 31) + Arrays.hashCode(this.f6985d)) * 31) + (this.f6983b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f6982a) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f6984c != null ? cipherSuites().toString() : str;
        if (this.f6985d != null) {
            str = tlsVersions().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f6983b + ")";
    }

    public static final class Builder {
        @Nullable
        String[] cipherSuites;
        boolean supportsTlsExtensions;
        boolean tls;
        @Nullable
        String[] tlsVersions;

        Builder(boolean z) {
            this.tls = z;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.f6982a;
            this.cipherSuites = connectionSpec.f6984c;
            this.tlsVersions = connectionSpec.f6985d;
            this.supportsTlsExtensions = connectionSpec.f6983b;
        }

        public Builder allEnabledCipherSuites() {
            if (this.tls) {
                this.cipherSuites = null;
                return this;
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder cipherSuites(CipherSuite... cipherSuiteArr) {
            if (this.tls) {
                String[] strArr = new String[cipherSuiteArr.length];
                for (int i = 0; i < cipherSuiteArr.length; i++) {
                    strArr[i] = cipherSuiteArr[i].f6971b;
                }
                return cipherSuites(strArr);
            }
            throw new IllegalStateException("no cipher suites for cleartext connections");
        }

        public Builder cipherSuites(String... strArr) {
            if (!this.tls) {
                throw new IllegalStateException("no cipher suites for cleartext connections");
            } else if (strArr.length != 0) {
                this.cipherSuites = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one cipher suite is required");
            }
        }

        public Builder allEnabledTlsVersions() {
            if (this.tls) {
                this.tlsVersions = null;
                return this;
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder tlsVersions(TlsVersion... tlsVersionArr) {
            if (this.tls) {
                String[] strArr = new String[tlsVersionArr.length];
                for (int i = 0; i < tlsVersionArr.length; i++) {
                    strArr[i] = tlsVersionArr[i].javaName;
                }
                return tlsVersions(strArr);
            }
            throw new IllegalStateException("no TLS versions for cleartext connections");
        }

        public Builder tlsVersions(String... strArr) {
            if (!this.tls) {
                throw new IllegalStateException("no TLS versions for cleartext connections");
            } else if (strArr.length != 0) {
                this.tlsVersions = (String[]) strArr.clone();
                return this;
            } else {
                throw new IllegalArgumentException("At least one TLS version is required");
            }
        }

        public Builder supportsTlsExtensions(boolean z) {
            if (this.tls) {
                this.supportsTlsExtensions = z;
                return this;
            }
            throw new IllegalStateException("no TLS extensions for cleartext connections");
        }

        public ConnectionSpec build() {
            return new ConnectionSpec(this);
        }
    }
}
