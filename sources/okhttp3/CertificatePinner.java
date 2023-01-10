package okhttp3;

import java.security.cert.Certificate;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.internal.C3000Util;
import okhttp3.internal.tls.CertificateChainCleaner;
import okio.ByteString;

public final class CertificatePinner {
    public static final CertificatePinner DEFAULT = new Builder().build();

    /* renamed from: a */
    private final Set<Pin> f6965a;
    @Nullable

    /* renamed from: b */
    private final CertificateChainCleaner f6966b;

    CertificatePinner(Set<Pin> set, @Nullable CertificateChainCleaner certificateChainCleaner) {
        this.f6965a = set;
        this.f6966b = certificateChainCleaner;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof CertificatePinner) {
            CertificatePinner certificatePinner = (CertificatePinner) obj;
            if (!C3000Util.equal(this.f6966b, certificatePinner.f6966b) || !this.f6965a.equals(certificatePinner.f6965a)) {
                return false;
            }
            return true;
        }
        return false;
    }

    public int hashCode() {
        CertificateChainCleaner certificateChainCleaner = this.f6966b;
        return ((certificateChainCleaner != null ? certificateChainCleaner.hashCode() : 0) * 31) + this.f6965a.hashCode();
    }

    public void check(String str, List<Certificate> list) throws SSLPeerUnverifiedException {
        List<Pin> a = mo29936a(str);
        if (!a.isEmpty()) {
            CertificateChainCleaner certificateChainCleaner = this.f6966b;
            if (certificateChainCleaner != null) {
                list = certificateChainCleaner.clean(list, str);
            }
            int size = list.size();
            for (int i = 0; i < size; i++) {
                X509Certificate x509Certificate = (X509Certificate) list.get(i);
                int size2 = a.size();
                ByteString byteString = null;
                ByteString byteString2 = null;
                for (int i2 = 0; i2 < size2; i2++) {
                    Pin pin = a.get(i2);
                    if (pin.hashAlgorithm.equals("sha256/")) {
                        if (byteString == null) {
                            byteString = m6713b(x509Certificate);
                        }
                        if (pin.hash.equals(byteString)) {
                            return;
                        }
                    } else if (pin.hashAlgorithm.equals("sha1/")) {
                        if (byteString2 == null) {
                            byteString2 = m6712a(x509Certificate);
                        }
                        if (pin.hash.equals(byteString2)) {
                            return;
                        }
                    } else {
                        throw new AssertionError("unsupported hashAlgorithm: " + pin.hashAlgorithm);
                    }
                }
            }
            StringBuilder sb = new StringBuilder();
            sb.append("Certificate pinning failure!");
            sb.append("\n  Peer certificate chain:");
            int size3 = list.size();
            for (int i3 = 0; i3 < size3; i3++) {
                X509Certificate x509Certificate2 = (X509Certificate) list.get(i3);
                sb.append("\n    ");
                sb.append(pin(x509Certificate2));
                sb.append(": ");
                sb.append(x509Certificate2.getSubjectDN().getName());
            }
            sb.append("\n  Pinned certificates for ");
            sb.append(str);
            sb.append(":");
            int size4 = a.size();
            for (int i4 = 0; i4 < size4; i4++) {
                sb.append("\n    ");
                sb.append(a.get(i4));
            }
            throw new SSLPeerUnverifiedException(sb.toString());
        }
    }

    public void check(String str, Certificate... certificateArr) throws SSLPeerUnverifiedException {
        check(str, (List<Certificate>) Arrays.asList(certificateArr));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public List<Pin> mo29936a(String str) {
        List<Pin> emptyList = Collections.emptyList();
        for (Pin next : this.f6965a) {
            if (next.matches(str)) {
                if (emptyList.isEmpty()) {
                    emptyList = new ArrayList<>();
                }
                emptyList.add(next);
            }
        }
        return emptyList;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public CertificatePinner mo29937a(@Nullable CertificateChainCleaner certificateChainCleaner) {
        if (C3000Util.equal(this.f6966b, certificateChainCleaner)) {
            return this;
        }
        return new CertificatePinner(this.f6965a, certificateChainCleaner);
    }

    public static String pin(Certificate certificate) {
        if (certificate instanceof X509Certificate) {
            return "sha256/" + m6713b((X509Certificate) certificate).base64();
        }
        throw new IllegalArgumentException("Certificate pinning requires X509 certificates");
    }

    /* renamed from: a */
    static ByteString m6712a(X509Certificate x509Certificate) {
        return ByteString.m6997of(x509Certificate.getPublicKey().getEncoded()).sha1();
    }

    /* renamed from: b */
    static ByteString m6713b(X509Certificate x509Certificate) {
        return ByteString.m6997of(x509Certificate.getPublicKey().getEncoded()).sha256();
    }

    static final class Pin {
        private static final String WILDCARD = "*.";
        final String canonicalHostname;
        final ByteString hash;
        final String hashAlgorithm;
        final String pattern;

        Pin(String str, String str2) {
            String str3;
            this.pattern = str;
            if (str.startsWith(WILDCARD)) {
                str3 = HttpUrl.get("http://" + str.substring(2)).host();
            } else {
                str3 = HttpUrl.get("http://" + str).host();
            }
            this.canonicalHostname = str3;
            if (str2.startsWith("sha1/")) {
                this.hashAlgorithm = "sha1/";
                this.hash = ByteString.decodeBase64(str2.substring(5));
            } else if (str2.startsWith("sha256/")) {
                this.hashAlgorithm = "sha256/";
                this.hash = ByteString.decodeBase64(str2.substring(7));
            } else {
                throw new IllegalArgumentException("pins must start with 'sha256/' or 'sha1/': " + str2);
            }
            if (this.hash == null) {
                throw new IllegalArgumentException("pins must be base64: " + str2);
            }
        }

        /* access modifiers changed from: package-private */
        public boolean matches(String str) {
            if (!this.pattern.startsWith(WILDCARD)) {
                return str.equals(this.canonicalHostname);
            }
            int indexOf = str.indexOf(46);
            if ((str.length() - indexOf) - 1 == this.canonicalHostname.length()) {
                String str2 = this.canonicalHostname;
                if (str.regionMatches(false, indexOf + 1, str2, 0, str2.length())) {
                    return true;
                }
            }
            return false;
        }

        public boolean equals(Object obj) {
            if (obj instanceof Pin) {
                Pin pin = (Pin) obj;
                return this.pattern.equals(pin.pattern) && this.hashAlgorithm.equals(pin.hashAlgorithm) && this.hash.equals(pin.hash);
            }
        }

        public int hashCode() {
            return ((((527 + this.pattern.hashCode()) * 31) + this.hashAlgorithm.hashCode()) * 31) + this.hash.hashCode();
        }

        public String toString() {
            return this.hashAlgorithm + this.hash.base64();
        }
    }

    public static final class Builder {
        private final List<Pin> pins = new ArrayList();

        public Builder add(String str, String... strArr) {
            if (str != null) {
                for (String pin : strArr) {
                    this.pins.add(new Pin(str, pin));
                }
                return this;
            }
            throw new NullPointerException("pattern == null");
        }

        public CertificatePinner build() {
            return new CertificatePinner(new LinkedHashSet(this.pins), (CertificateChainCleaner) null);
        }
    }
}
