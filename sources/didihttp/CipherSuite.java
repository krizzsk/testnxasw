package didihttp;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

public final class CipherSuite {
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA = m44684a("TLS_ECDHE_ECDSA_WITH_AES_128_CBC_SHA", 49161);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256 = m44684a("TLS_ECDHE_ECDSA_WITH_AES_128_GCM_SHA256", 49195);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA = m44684a("TLS_ECDHE_ECDSA_WITH_AES_256_CBC_SHA", 49162);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384 = m44684a("TLS_ECDHE_ECDSA_WITH_AES_256_GCM_SHA384", 49196);
    public static final CipherSuite TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256 = m44684a("TLS_ECDHE_ECDSA_WITH_CHACHA20_POLY1305_SHA256", 52393);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA = m44684a("TLS_ECDHE_RSA_WITH_AES_128_CBC_SHA", 49171);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256 = m44684a("TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256", 49199);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA = m44684a("TLS_ECDHE_RSA_WITH_AES_256_CBC_SHA", 49172);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384 = m44684a("TLS_ECDHE_RSA_WITH_AES_256_GCM_SHA384", 49200);
    public static final CipherSuite TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256 = m44684a("TLS_ECDHE_RSA_WITH_CHACHA20_POLY1305_SHA256", 52392);
    public static final CipherSuite TLS_RSA_WITH_3DES_EDE_CBC_SHA = m44684a("SSL_RSA_WITH_3DES_EDE_CBC_SHA", 10);
    public static final CipherSuite TLS_RSA_WITH_AES_128_CBC_SHA = m44684a("TLS_RSA_WITH_AES_128_CBC_SHA", 47);
    public static final CipherSuite TLS_RSA_WITH_AES_128_GCM_SHA256 = m44684a("TLS_RSA_WITH_AES_128_GCM_SHA256", 156);
    public static final CipherSuite TLS_RSA_WITH_AES_256_CBC_SHA = m44684a("TLS_RSA_WITH_AES_256_CBC_SHA", 53);
    public static final CipherSuite TLS_RSA_WITH_AES_256_GCM_SHA384 = m44684a("TLS_RSA_WITH_AES_256_GCM_SHA384", 157);

    /* renamed from: b */
    private static final ConcurrentMap<String, CipherSuite> f59114b = new ConcurrentHashMap();

    /* renamed from: a */
    final String f59115a;

    public static CipherSuite forJavaName(String str) {
        CipherSuite cipherSuite = (CipherSuite) f59114b.get(str);
        if (cipherSuite != null) {
            return cipherSuite;
        }
        CipherSuite cipherSuite2 = new CipherSuite(str);
        CipherSuite putIfAbsent = f59114b.putIfAbsent(str, cipherSuite2);
        return putIfAbsent == null ? cipherSuite2 : putIfAbsent;
    }

    private CipherSuite(String str) {
        if (str != null) {
            this.f59115a = str;
            return;
        }
        throw null;
    }

    /* renamed from: a */
    private static CipherSuite m44684a(String str, int i) {
        return forJavaName(str);
    }

    public String javaName() {
        return this.f59115a;
    }

    public String toString() {
        return this.f59115a;
    }
}
