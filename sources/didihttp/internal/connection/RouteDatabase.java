package didihttp.internal.connection;

import didihttp.Route;
import java.util.LinkedHashSet;
import java.util.Set;

public final class RouteDatabase {

    /* renamed from: a */
    private final Set<Route> f59436a = new LinkedHashSet();

    public synchronized void failed(Route route) {
        this.f59436a.add(route);
    }

    public synchronized void connected(Route route) {
        this.f59436a.remove(route);
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.f59436a.contains(route);
    }
}
