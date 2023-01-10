package didihttp;

import didihttp.internal.C21750Util;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import javax.net.ssl.SSLSocket;

public final class ConnectionSpec {
    public static final ConnectionSpec CLEARTEXT = new Builder(false).build();
    public static final ConnectionSpec COMPATIBLE_TLS;
    public static final ConnectionSpec MODERN_TLS;

    /* renamed from: e */
    private static final CipherSuite[] f59124e = {CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_128_GCM_SHA256, CipherSuite.TLS_RSA_WITH_AES_256_GCM_SHA384, CipherSuite.TLS_RSA_WITH_AES_128_CBC_SHA, CipherSuite.TLS_RSA_WITH_AES_256_CBC_SHA, CipherSuite.TLS_RSA_WITH_3DES_EDE_CBC_SHA};

    /* renamed from: a */
    final boolean f59125a;

    /* renamed from: b */
    final boolean f59126b;

    /* renamed from: c */
    final String[] f59127c;

    /* renamed from: d */
    final String[] f59128d;

    static {
        ConnectionSpec build = new Builder(true).cipherSuites(f59124e).tlsVersions(TlsVersion.TLS_1_3, TlsVersion.TLS_1_2, TlsVersion.TLS_1_1, TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
        MODERN_TLS = build;
        COMPATIBLE_TLS = new Builder(build).tlsVersions(TlsVersion.TLS_1_0).supportsTlsExtensions(true).build();
    }

    ConnectionSpec(Builder builder) {
        this.f59125a = builder.tls;
        this.f59127c = builder.cipherSuites;
        this.f59128d = builder.tlsVersions;
        this.f59126b = builder.supportsTlsExtensions;
    }

    public boolean isTls() {
        return this.f59125a;
    }

    public List<CipherSuite> cipherSuites() {
        if (this.f59127c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f59127c.length);
        for (String forJavaName : this.f59127c) {
            arrayList.add(CipherSuite.forJavaName(forJavaName));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public List<TlsVersion> tlsVersions() {
        if (this.f59128d == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList(this.f59128d.length);
        for (String forJavaName : this.f59128d) {
            arrayList.add(TlsVersion.forJavaName(forJavaName));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public boolean supportsTlsExtensions() {
        return this.f59126b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179236a(SSLSocket sSLSocket, boolean z) {
        ConnectionSpec b = m44692b(sSLSocket, z);
        String[] strArr = b.f59128d;
        if (strArr != null) {
            sSLSocket.setEnabledProtocols(strArr);
        }
        String[] strArr2 = b.f59127c;
        if (strArr2 != null) {
            sSLSocket.setEnabledCipherSuites(strArr2);
        }
    }

    /* renamed from: b */
    private ConnectionSpec m44692b(SSLSocket sSLSocket, boolean z) {
        String[] strArr;
        String[] strArr2;
        String[] strArr3 = this.f59127c;
        if (strArr3 != null) {
            strArr = (String[]) C21750Util.intersect(String.class, strArr3, sSLSocket.getEnabledCipherSuites());
        } else {
            strArr = sSLSocket.getEnabledCipherSuites();
        }
        String[] strArr4 = this.f59128d;
        if (strArr4 != null) {
            strArr2 = (String[]) C21750Util.intersect(String.class, strArr4, sSLSocket.getEnabledProtocols());
        } else {
            strArr2 = sSLSocket.getEnabledProtocols();
        }
        if (z && C21750Util.indexOf(sSLSocket.getSupportedCipherSuites(), "TLS_FALLBACK_SCSV") != -1) {
            strArr = C21750Util.concat(strArr, "TLS_FALLBACK_SCSV");
        }
        return new Builder(this).cipherSuites(strArr).tlsVersions(strArr2).build();
    }

    public boolean isCompatible(SSLSocket sSLSocket) {
        if (!this.f59125a) {
            return false;
        }
        String[] strArr = this.f59128d;
        if (strArr != null && !m44691a(strArr, sSLSocket.getEnabledProtocols())) {
            return false;
        }
        String[] strArr2 = this.f59127c;
        if (strArr2 == null || m44691a(strArr2, sSLSocket.getEnabledCipherSuites())) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static boolean m44691a(String[] strArr, String[] strArr2) {
        if (!(strArr == null || strArr2 == null || strArr.length == 0 || strArr2.length == 0)) {
            for (String indexOf : strArr) {
                if (C21750Util.indexOf(strArr2, indexOf) != -1) {
                    return true;
                }
            }
        }
        return false;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ConnectionSpec)) {
            return false;
        }
        if (obj == this) {
            return true;
        }
        ConnectionSpec connectionSpec = (ConnectionSpec) obj;
        boolean z = this.f59125a;
        if (z != connectionSpec.f59125a) {
            return false;
        }
        return !z || (Arrays.equals(this.f59127c, connectionSpec.f59127c) && Arrays.equals(this.f59128d, connectionSpec.f59128d) && this.f59126b == connectionSpec.f59126b);
    }

    public int hashCode() {
        if (this.f59125a) {
            return ((((527 + Arrays.hashCode(this.f59127c)) * 31) + Arrays.hashCode(this.f59128d)) * 31) + (this.f59126b ^ true ? 1 : 0);
        }
        return 17;
    }

    public String toString() {
        if (!this.f59125a) {
            return "ConnectionSpec()";
        }
        String str = "[all enabled]";
        String obj = this.f59127c != null ? cipherSuites().toString() : str;
        if (this.f59128d != null) {
            str = tlsVersions().toString();
        }
        return "ConnectionSpec(cipherSuites=" + obj + ", tlsVersions=" + str + ", supportsTlsExtensions=" + this.f59126b + ")";
    }

    public static final class Builder {
        String[] cipherSuites;
        boolean supportsTlsExtensions;
        boolean tls;
        String[] tlsVersions;

        Builder(boolean z) {
            this.tls = z;
        }

        public Builder(ConnectionSpec connectionSpec) {
            this.tls = connectionSpec.f59125a;
            this.cipherSuites = connectionSpec.f59127c;
            this.tlsVersions = connectionSpec.f59128d;
            this.supportsTlsExtensions = connectionSpec.f59126b;
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
                    strArr[i] = cipherSuiteArr[i].f59115a;
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
