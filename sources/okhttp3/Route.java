package okhttp3;

import java.net.InetSocketAddress;
import java.net.Proxy;
import javax.annotation.Nullable;

public final class Route {

    /* renamed from: a */
    final Address f7108a;

    /* renamed from: b */
    final Proxy f7109b;

    /* renamed from: c */
    final InetSocketAddress f7110c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f7108a = address;
            this.f7109b = proxy;
            this.f7110c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public Address address() {
        return this.f7108a;
    }

    public Proxy proxy() {
        return this.f7109b;
    }

    public InetSocketAddress socketAddress() {
        return this.f7110c;
    }

    public boolean requiresTunnel() {
        return this.f7108a.f6938i != null && this.f7109b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(@Nullable Object obj) {
        if (obj instanceof Route) {
            Route route = (Route) obj;
            return route.f7108a.equals(this.f7108a) && route.f7109b.equals(this.f7109b) && route.f7110c.equals(this.f7110c);
        }
    }

    public int hashCode() {
        return ((((527 + this.f7108a.hashCode()) * 31) + this.f7109b.hashCode()) * 31) + this.f7110c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f7110c + "}";
    }
}
