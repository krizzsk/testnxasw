package didihttp.internal.connection;

import didihttp.Address;
import didihttp.Call;
import didihttp.HttpUrl;
import didihttp.LogEventListener;
import didihttp.Route;
import didihttp.internal.C21750Util;
import didihttpdns.HttpDnsApolloConfig;
import didihttpdns.HttpDnsManager;
import didinet.ApolloAPI;
import didinet.NetEngine;
import java.io.IOException;
import java.net.Inet6Address;
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

public final class RouteSelector {

    /* renamed from: a */
    private static final String f59437a = "android_http_disable_ipv6";

    /* renamed from: b */
    private final Address f59438b;

    /* renamed from: c */
    private final RouteDatabase f59439c;

    /* renamed from: d */
    private Proxy f59440d;

    /* renamed from: e */
    private InetSocketAddress f59441e;

    /* renamed from: f */
    private List<Proxy> f59442f = Collections.emptyList();

    /* renamed from: g */
    private int f59443g;

    /* renamed from: h */
    private List<InetSocketAddress> f59444h = Collections.emptyList();

    /* renamed from: i */
    private int f59445i;

    /* renamed from: j */
    private int f59446j;

    /* renamed from: k */
    private final List<Route> f59447k = new ArrayList();

    /* renamed from: l */
    private Call f59448l;

    /* renamed from: m */
    private LogEventListener f59449m;

    public RouteSelector(Address address, RouteDatabase routeDatabase, Call call, LogEventListener logEventListener) {
        this.f59438b = address;
        this.f59439c = routeDatabase;
        this.f59448l = call;
        this.f59449m = logEventListener;
        m44809a(address.url(), address.proxy());
    }

    public boolean hasNext() {
        return m44814d() || m44812b() || m44816f();
    }

    public Route next() throws IOException {
        if (!m44814d()) {
            if (m44812b()) {
                this.f59440d = m44813c();
            } else if (m44816f()) {
                return m44817g();
            } else {
                if (m44811a()) {
                    int i = this.f59446j + 1;
                    this.f59446j = i;
                    this.f59446j = i % this.f59444h.size();
                    return new Route(this.f59438b, this.f59440d, this.f59444h.get(this.f59446j));
                }
                throw new NoSuchElementException();
            }
        }
        InetSocketAddress e = m44815e();
        this.f59441e = e;
        Route route = new Route(this.f59438b, this.f59440d, e);
        if (!this.f59439c.shouldPostpone(route)) {
            return route;
        }
        this.f59447k.add(route);
        return next();
    }

    public Route tryNext() {
        try {
            return next();
        } catch (IOException unused) {
            return null;
        }
    }

    /* renamed from: a */
    private boolean m44811a() {
        return NetEngine.getInstance().getNetConfig().useTotalTimeout() && hasInetSocketAddress();
    }

    public boolean hasInetSocketAddress() {
        return this.f59444h.size() > 0;
    }

    public void resetProxy() {
        m44809a(this.f59438b.url(), this.f59438b.proxy());
    }

    public void connectFailed(Route route, IOException iOException) {
        if (!(route.proxy().type() == Proxy.Type.DIRECT || this.f59438b.proxySelector() == null)) {
            this.f59438b.proxySelector().connectFailed(this.f59438b.url().uri(), route.proxy().address(), iOException);
        }
        this.f59439c.failed(route);
    }

    /* renamed from: a */
    private void m44809a(HttpUrl httpUrl, Proxy proxy) {
        List<Proxy> list;
        if (proxy != null) {
            this.f59442f = Collections.singletonList(proxy);
        } else {
            List<Proxy> select = this.f59438b.proxySelector().select(httpUrl.uri());
            if (select == null || select.isEmpty()) {
                list = C21750Util.immutableList((T[]) new Proxy[]{Proxy.NO_PROXY});
            } else {
                list = C21750Util.immutableList(select);
            }
            this.f59442f = list;
        }
        this.f59443g = 0;
    }

    /* renamed from: b */
    private boolean m44812b() {
        return this.f59443g < this.f59442f.size();
    }

    /* renamed from: c */
    private Proxy m44813c() throws IOException {
        if (m44812b()) {
            List<Proxy> list = this.f59442f;
            int i = this.f59443g;
            this.f59443g = i + 1;
            Proxy proxy = list.get(i);
            m44810a(proxy);
            return proxy;
        }
        throw new SocketException("No route to " + this.f59438b.url().host() + "; exhausted proxy configurations: " + this.f59442f);
    }

    /* renamed from: a */
    private void m44810a(Proxy proxy) throws IOException {
        String str;
        int i;
        this.f59444h = new ArrayList();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.SOCKS) {
            str = this.f59438b.url().host();
            i = this.f59438b.url().port();
        } else {
            SocketAddress address = proxy.address();
            if (address instanceof InetSocketAddress) {
                InetSocketAddress inetSocketAddress = (InetSocketAddress) address;
                str = m44808a(inetSocketAddress);
                i = inetSocketAddress.getPort();
            } else {
                throw new IllegalArgumentException("Proxy.address() is not an InetSocketAddress: " + address.getClass());
            }
        }
        if (i < 1 || i > 65535) {
            throw new SocketException("No route to " + str + ":" + i + "; port is out of range");
        }
        if (proxy.type() == Proxy.Type.SOCKS) {
            this.f59444h.add(InetSocketAddress.createUnresolved(str, i));
        } else {
            this.f59449m.dnsStart(this.f59448l, str);
            try {
                List<InetAddress> lookup = this.f59438b.dns().lookup(str);
                ArrayList arrayList = new ArrayList();
                ApolloAPI.Toggle toggle = NetEngine.getInstance().getApolloAPI().getToggle(f59437a);
                if (toggle == null || !toggle.allow()) {
                    for (InetAddress next : lookup) {
                        if (next instanceof Inet6Address) {
                            arrayList.add(next);
                        }
                    }
                    for (InetAddress next2 : lookup) {
                        if (!arrayList.contains(next2)) {
                            arrayList.add(next2);
                        }
                    }
                } else {
                    for (InetAddress next3 : lookup) {
                        if (!(next3 instanceof Inet6Address)) {
                            arrayList.add(next3);
                        }
                    }
                }
                this.f59449m.dnsEnd(this.f59448l, str, arrayList);
                int size = arrayList.size();
                for (int i2 = 0; i2 < size; i2++) {
                    this.f59444h.add(new InetSocketAddress((InetAddress) arrayList.get(i2), i));
                }
            } catch (UnknownHostException e) {
                this.f59449m.dnsFailed(this.f59448l, str, e);
                throw new UnknownHostException("unable to resolve host " + str);
            }
        }
        this.f59445i = 0;
    }

    /* renamed from: a */
    static String m44808a(InetSocketAddress inetSocketAddress) {
        InetAddress address = inetSocketAddress.getAddress();
        if (address == null) {
            return inetSocketAddress.getHostName();
        }
        return address.getHostAddress();
    }

    /* renamed from: d */
    private boolean m44814d() {
        return this.f59445i < this.f59444h.size();
    }

    /* renamed from: e */
    private InetSocketAddress m44815e() throws IOException {
        if (m44814d()) {
            List<InetSocketAddress> list = this.f59444h;
            int i = this.f59445i;
            this.f59445i = i + 1;
            InetSocketAddress inetSocketAddress = list.get(i);
            if (!HttpDnsManager.getInstance().ignoreIpv6Limit(inetSocketAddress)) {
                while (inetSocketAddress.getAddress() != null && (inetSocketAddress.getAddress() instanceof Inet6Address) && (!NetEngine.getInstance().supportIpv6() || (HttpDnsApolloConfig.getConfig().isEnableIpv6Apollo() && !HttpDnsApolloConfig.getConfig().isIpv6Permit(this.f59438b.url().toString())))) {
                    if (m44814d()) {
                        List<InetSocketAddress> list2 = this.f59444h;
                        int i2 = this.f59445i;
                        this.f59445i = i2 + 1;
                        inetSocketAddress = list2.get(i2);
                    } else {
                        throw new SocketException("No route to " + this.f59438b.url().host() + "; exhausted inet socket addresses: " + this.f59444h);
                    }
                }
            }
            return inetSocketAddress;
        }
        throw new SocketException("No route to " + this.f59438b.url().host() + "; exhausted inet socket addresses: " + this.f59444h);
    }

    /* renamed from: f */
    private boolean m44816f() {
        return !this.f59447k.isEmpty();
    }

    /* renamed from: g */
    private Route m44817g() {
        return this.f59447k.remove(0);
    }
}
