package okhttp3.internal.connection;

import java.util.LinkedHashSet;
import java.util.Set;
import okhttp3.Route;

public final class RouteDatabase {

    /* renamed from: a */
    private final Set<Route> f7186a = new LinkedHashSet();

    public synchronized void failed(Route route) {
        this.f7186a.add(route);
    }

    public synchronized void connected(Route route) {
        this.f7186a.remove(route);
    }

    public synchronized boolean shouldPostpone(Route route) {
        return this.f7186a.contains(route);
    }
}
