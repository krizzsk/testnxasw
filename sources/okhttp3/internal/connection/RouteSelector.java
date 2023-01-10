package okhttp3.internal.connection;

import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.SocketAddress;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.HttpUrl;
import okhttp3.Route;
import okhttp3.internal.C3000Util;

public final class RouteSelector {

    /* renamed from: a */
    private final Address f7187a;

    /* renamed from: b */
    private final RouteDatabase f7188b;

    /* renamed from: c */
    private final Call f7189c;

    /* renamed from: d */
    private final EventListener f7190d;

    /* renamed from: e */
    private List<Proxy> f7191e = Collections.emptyList();

    /* renamed from: f */
    private int f7192f;

    /* renamed from: g */
    private List<InetSocketAddress> f7193g = Collections.emptyList();

    /* renamed from: h */
    private final List<Route> f7194h = new ArrayList();

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, EventListener eventListener) {
        this.f7187a = address;
        this.f7188b = routeDatabase;
        this.f7189c = call;
        this.f7190d = eventListener;
        m6814a(address.url(), address.proxy());
    }

    public boolean hasNext() {
        return m6815a() || !this.f7194h.isEmpty();
    }

    public Selection next() throws IOException {
        if (hasNext()) {
            ArrayList arrayList = new ArrayList();
            while (m6815a()) {
                Proxy b = m6816b();
                int size = this.f7193g.size();
                for (int i = 0; i < size; i++) {
                    Route route = new Route(this.f7187a, b, this.f7193g.get(i));
                    if (this.f7188b.shouldPostpone(route)) {
                        this.f7194h.add(route);
                    } else {
                        arrayList.add(route);
                    }
                }
                if (!arrayList.isEmpty()) {
                    break;
                }
            }
            if (arrayList.isEmpty()) {
                arrayList.addAll(this.f7194h);
                this.f7194h.clear();
            }
            return new Selection(arrayList);
        }
        throw new NoSuchElementException();
    }

    public void connectFailed(Route route, IOException iOException) {
        if (!(route.proxy().type() == Proxy.Type.DIRECT || this.f7187a.proxySelector() == null)) {
            this.f7187a.proxySelector().connectFailed(this.f7187a.url().uri(), route.proxy().address(), iOException);
        }
        this.f7188b.failed(route);
    }

    /* renamed from: a */
    private void m6814a(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f7191e = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f7187a.proxySelector().select(httpUrl.uri());
            if (select == null || select.isEmpty()) {
                list = C3000Util.immutableList((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = C3000Util.immutableList(select);
            }
            this.f7191e = list;
        }
        this.f7192f = 0;
    }

    /* renamed from: a */
    private boolean m6815a() {
        return this.f7192f < this.f7191e.size();
    }

    /* renamed from: b */
    private Proxy m6816b() throws IOException {
        if (m6815a()) {
            List<Proxy> list = this.f7191e;
            int i = this.f7192f;
            this.f7192f = i + 1;
            Proxy proxy = list.get(i);
            m6813a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f7187a.url().host() + "; exhausted proxy configurations: " + this.f7191e);
    }

    /* renamed from: a */
    private void m6813a(Proxy proxy) throws IOException {
        String str;
        int i;
        this.f7193g = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f7187a.url().host();
            i = this.f7187a.url().port();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m6812a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        } else if (proxy.type() == Proxy.Type.SOCKS) {
            this.f7193g.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f7190d.dnsStart(this.f7189c, str);
            List<InetAddress> lookup = this.f7187a.dns().lookup(str);
            if (!lookup.isEmpty()) {
                this.f7190d.dnsEnd(this.f7189c, str, lookup);
                int size = lookup.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f7193g.add(new InetSocketAddress(lookup.get(i2), i));
                }
                return;
            }
            throw new UnknownHostException(this.f7187a.dns() + " returned no addresses for " + str);
        }
    }

    /* renamed from: a */
    static String m6812a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    public static final class Selection {
        private int nextRouteIndex = 0;
        private final List<Route> routes;

        Selection(List<Route> list) {
            this.routes = list;
        }

        public boolean hasNext() {
            return this.nextRouteIndex < this.routes.size();
        }

        public Route next() {
            if (hasNext()) {
                List<Route> list = this.routes;
                int i = this.nextRouteIndex;
                this.nextRouteIndex = i + 1;
                return list.get(i);
            }
            throw new NoSuchElementException();
        }

        public List<Route> getAll() {
            return new ArrayList(this.routes);
        }
    }
}
