package didihttp;

import didihttp.internal.C21750Util;
import java.net.Proxy;
import java.net.ProxySelector;
import java.util.List;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLSocketFactory;

public final class Address {

    /* renamed from: a */
    final HttpUrl f59076a;

    /* renamed from: b */
    final Dns f59077b;

    /* renamed from: c */
    final SocketFactory f59078c;

    /* renamed from: d */
    final Authenticator f59079d;

    /* renamed from: e */
    final List<Protocol> f59080e;

    /* renamed from: f */
    final List<ConnectionSpec> f59081f;

    /* renamed from: g */
    final ProxySelector f59082g;

    /* renamed from: h */
    final Proxy f59083h;

    /* renamed from: i */
    final SSLSocketFactory f59084i;

    /* renamed from: j */
    final HostnameVerifier f59085j;

    /* renamed from: k */
    final CertificatePinner f59086k;

    public Address(HttpUrl httpUrl, Dns dns, SocketFactory socketFactory, SSLSocketFactory sSLSocketFactory, HostnameVerifier hostnameVerifier, CertificatePinner certificatePinner, Authenticator authenticator, Proxy proxy, List<Protocol> list, List<ConnectionSpec> list2, ProxySelector proxySelector) {
        this.f59076a = httpUrl;
        if (dns != null) {
            this.f59077b = dns;
            if (socketFactory != null) {
                this.f59078c = socketFactory;
                if (authenticator != null) {
                    this.f59079d = authenticator;
                    if (list != null) {
                        this.f59080e = C21750Util.immutableList(list);
                        if (list2 != null) {
                            this.f59081f = C21750Util.immutableList(list2);
                            if (proxySelector != null) {
                                this.f59082g = proxySelector;
                                this.f59083h = proxy;
                                this.f59084i = sSLSocketFactory;
                                this.f59085j = hostnameVerifier;
                                this.f59086k = certificatePinner;
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
        return this.f59076a;
    }

    public Dns dns() {
        return this.f59077b;
    }

    public SocketFactory socketFactory() {
        return this.f59078c;
    }

    public Authenticator proxyAuthenticator() {
        return this.f59079d;
    }

    public List<Protocol> protocols() {
        return this.f59080e;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f59081f;
    }

    public ProxySelector proxySelector() {
        return this.f59082g;
    }

    public Proxy proxy() {
        return this.f59083h;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f59084i;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f59085j;
    }

    public CertificatePinner certificatePinner() {
        return this.f59086k;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Address)) {
            return false;
        }
        Address address = (Address) obj;
        if (!this.f59076a.equals(address.f59076a) || !this.f59077b.equals(address.f59077b) || !this.f59079d.equals(address.f59079d) || !this.f59080e.equals(address.f59080e) || !this.f59081f.equals(address.f59081f) || !this.f59082g.equals(address.f59082g) || !C21750Util.equal(this.f59083h, address.f59083h) || !C21750Util.equal(this.f59084i, address.f59084i) || !C21750Util.equal(this.f59085j, address.f59085j) || !C21750Util.equal(this.f59086k, address.f59086k)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        int hashCode = (((((((((((527 + this.f59076a.hashCode()) * 31) + this.f59077b.hashCode()) * 31) + this.f59079d.hashCode()) * 31) + this.f59080e.hashCode()) * 31) + this.f59081f.hashCode()) * 31) + this.f59082g.hashCode()) * 31;
        Proxy proxy = this.f59083h;
        int i = 0;
        int hashCode2 = (hashCode + (proxy != null ? proxy.hashCode() : 0)) * 31;
        SSLSocketFactory sSLSocketFactory = this.f59084i;
        int hashCode3 = (hashCode2 + (sSLSocketFactory != null ? sSLSocketFactory.hashCode() : 0)) * 31;
        HostnameVerifier hostnameVerifier = this.f59085j;
        int hashCode4 = (hashCode3 + (hostnameVerifier != null ? hostnameVerifier.hashCode() : 0)) * 31;
        CertificatePinner certificatePinner = this.f59086k;
        if (certificatePinner != null) {
            i = certificatePinner.hashCode();
        }
        return hashCode4 + i;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Address{");
        sb.append(this.f59076a.host());
        sb.append(":");
        sb.append(this.f59076a.port());
        if (this.f59083h != null) {
            sb.append(", proxy=");
            sb.append(this.f59083h);
        } else {
            sb.append(", proxySelector=");
            sb.append(this.f59082g);
        }
        sb.append("}");
        return sb.toString();
    }
}
