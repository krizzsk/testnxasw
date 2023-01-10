package didihttp;

import java.net.InetSocketAddress;
import java.net.Proxy;

public final class Route {

    /* renamed from: a */
    final Address f59273a;

    /* renamed from: b */
    final Proxy f59274b;

    /* renamed from: c */
    final InetSocketAddress f59275c;

    public Route(Address address, Proxy proxy, InetSocketAddress inetSocketAddress) {
        if (address == null) {
            throw new NullPointerException("address == null");
        } else if (proxy == null) {
            throw new NullPointerException("proxy == null");
        } else if (inetSocketAddress != null) {
            this.f59273a = address;
            this.f59274b = proxy;
            this.f59275c = inetSocketAddress;
        } else {
            throw new NullPointerException("inetSocketAddress == null");
        }
    }

    public Address address() {
        return this.f59273a;
    }

    public Proxy proxy() {
        return this.f59274b;
    }

    public InetSocketAddress socketAddress() {
        return this.f59275c;
    }

    public boolean requiresTunnel() {
        return this.f59273a.f59084i != null && this.f59274b.type() == Proxy.Type.HTTP;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Route)) {
            return false;
        }
        Route route = (Route) obj;
        if (!this.f59273a.equals(route.f59273a) || !this.f59274b.equals(route.f59274b) || !this.f59275c.equals(route.f59275c)) {
            return false;
        }
        return true;
    }

    public int hashCode() {
        return ((((527 + this.f59273a.hashCode()) * 31) + this.f59274b.hashCode()) * 31) + this.f59275c.hashCode();
    }

    public String toString() {
        return "Route{" + this.f59275c + "}";
    }
}
