package okhttp3;

import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;
import okhttp3.HttpUrl;
import okhttp3.internal.C3000Util;

public final class Address {

    /* renamed from: a */
    final HttpUrl f6930a;

    /* renamed from: b */
    final Dns f6931b;

    /* renamed from: c */
    final SocketFactory f6932c;

    /* renamed from: d */
    final Authenticator f6933d;

    /* renamed from: e */
    final List<Protocol> f6934e;

    /* renamed from: f */
    final List<ConnectionSpec> f6935f;

    /* renamed from: g */
    final ProxySelector f6936g;
    @Nullable

    /* renamed from: h */
    final Proxy f6937h;
    @Nullable

    /* renamed from: i */
    final SSLSocketFactory f6938i;
    @Nullable

    /* renamed from: j */
    final HostnameVerifier f6939j;
    @Nullable

    /* renamed from: k */
    final CertificatePinner f6940k;

    public Address(String str, int i, Dns dns, SocketFactory socketFactory, @Nullable SSLSocketFactory sSLSocketFactory, @Nullable HostnameVerifier hostnameVerifier, @Nullable CertificatePinner certificatePinner, Authenticator authenticator, @Nullable Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f6930a = new HttpUrl.Builder().scheme(sSLSocketFactory != null ? "https" : "http").host(str).port(i).build();
        if (dns != null) {
            this.f6931b = dns;
            if (socketFactory != null) {
                this.f6932c = socketFactory;
                if (authenticator != null) {
                    this.f6933d = authenticator;
                    if (list != null) {
                        this.f6934e = C3000Util.immutableList(list);
                        if (list2 != null) {
                            this.f6935f = C3000Util.immutableList(list2);
                            if (proxySelector != null) {
                                this.f6936g = proxySelector;
                                this.f6937h = proxy;
                                this.f6938i = sSLSocketFactory;
                                this.f6939j = hostnameVerifier;
                                this.f6940k = certificatePinner;
                                return;
                            }
                            throw new NullPointerException("proxySelector == null");
                        }
                        throw new NullPointerException("connectionSpecs == null");
                    }
                    throw new NullPointerException("protocols == null");
                }
                throw new NullPointerException("proxyAuthenticator == null");
            }
            throw new NullPointerException("socketFactory == null");
        }
        throw new NullPointerException("dns == null");
    }

    public HttpUrl url() {
        return this.f6930a;
    }

    public Dns dns() {
        return this.f6931b;
    }

    public SocketFactory socketFactory() {
        return this.f6932c;
    }

    public Authenticator proxyAuthenticator() {
        return this.f6933d;
    }

    public List<Protocol> protocols() {
        return this.f6934e;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f6935f;
    }

    public ProxySelector proxySelector() {
        return this.f6936g;
    }

    @Nullable
    public Proxy proxy() {
        return this.f6937h;
    }

    @Nullable
    public SSLSocketFactory sslSocketFactory() {
        return this.f6938i;
    }

    @Nullable
    public HostnameVerifier hostnameVerifier() {
        return this.f6939j;
    }

    @Nullable
    public CertificatePinner certificatePinner() {
        return this.f6940k;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Address) {
            Address address = (Address) obj;
            return this.f6930a.equals(address.f6930a) && mo29849a(address);
        }
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f6930a.hashCode()) * 31) + this.f6931b.hashCode()) * 31) + this.f6933d.hashCode()) * 31) + this.f6934e.hashCode()) * 31) + this.f6935f.hashCode()) * 31) + this.f6936g.hashCode()) * 31;
        Proxy proxy = this.f6937h;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f6938i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f6939j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f6940k;
        if (certificatePinner != null) {
            i = certificatePinner.hashCode();
        }
        return hashCode4 + i;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo29849a(Address address) {
        return this.f6931b.equals(address.f6931b) && this.f6933d.equals(address.f6933d) && this.f6934e.equals(address.f6934e) && this.f6935f.equals(address.f6935f) && this.f6936g.equals(address.f6936g) && C3000Util.equal(this.f6937h, address.f6937h) && C3000Util.equal(this.f6938i, address.f6938i) && C3000Util.equal(this.f6939j, address.f6939j) && C3000Util.equal(this.f6940k, address.f6940k) && url().port() == address.url().port();
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f6930a.host());
        sb.append(":");
        sb.append(this.f6930a.port());
        if (this.f6937h != null) {
            sb.append(", proxy=");
            sb.append(this.f6937h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f6936g);
        }
        sb.append("}");
        return sb.toString();
    }
}
