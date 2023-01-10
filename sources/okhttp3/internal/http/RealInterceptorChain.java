package okhttp3.internal.http;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.EventListener;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.internal.C3000Util;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.StreamAllocation;

public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a */
    private final List<Interceptor> f7214a;

    /* renamed from: b */
    private final StreamAllocation f7215b;

    /* renamed from: c */
    private final HttpCodec f7216c;

    /* renamed from: d */
    private final RealConnection f7217d;

    /* renamed from: e */
    private final int f7218e;

    /* renamed from: f */
    private final Request f7219f;

    /* renamed from: g */
    private final Call f7220g;

    /* renamed from: h */
    private final EventListener f7221h;

    /* renamed from: i */
    private final int f7222i;

    /* renamed from: j */
    private final int f7223j;

    /* renamed from: k */
    private final int f7224k;

    /* renamed from: l */
    private int f7225l;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection, int i, Request request, Call call, EventListener eventListener, int i2, int i3, int i4) {
        this.f7214a = list;
        this.f7217d = realConnection;
        this.f7215b = streamAllocation;
        this.f7216c = httpCodec;
        this.f7218e = i;
        this.f7219f = request;
        this.f7220g = call;
        this.f7221h = eventListener;
        this.f7222i = i2;
        this.f7223j = i3;
        this.f7224k = i4;
    }

    public Connection connection() {
        return this.f7217d;
    }

    public int connectTimeoutMillis() {
        return this.f7222i;
    }

    public Interceptor.Chain withConnectTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f7214a, this.f7215b, this.f7216c, this.f7217d, this.f7218e, this.f7219f, this.f7220g, this.f7221h, C3000Util.checkDuration("timeout", (long) i, timeUnit), this.f7223j, this.f7224k);
    }

    public int readTimeoutMillis() {
        return this.f7223j;
    }

    public Interceptor.Chain withReadTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f7214a, this.f7215b, this.f7216c, this.f7217d, this.f7218e, this.f7219f, this.f7220g, this.f7221h, this.f7222i, C3000Util.checkDuration("timeout", (long) i, timeUnit), this.f7224k);
    }

    public int writeTimeoutMillis() {
        return this.f7224k;
    }

    public Interceptor.Chain withWriteTimeout(int i, TimeUnit timeUnit) {
        return new RealInterceptorChain(this.f7214a, this.f7215b, this.f7216c, this.f7217d, this.f7218e, this.f7219f, this.f7220g, this.f7221h, this.f7222i, this.f7223j, C3000Util.checkDuration("timeout", (long) i, timeUnit));
    }

    public StreamAllocation streamAllocation() {
        return this.f7215b;
    }

    public HttpCodec httpStream() {
        return this.f7216c;
    }

    public Call call() {
        return this.f7220g;
    }

    public EventListener eventListener() {
        return this.f7221h;
    }

    public Request request() {
        return this.f7219f;
    }

    public Response proceed(Request request) throws IOException {
        return proceed(request, this.f7215b, this.f7216c, this.f7217d);
    }

    public Response proceed(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, RealConnection realConnection) throws IOException {
        if (this.f7218e < this.f7214a.size()) {
            this.f7225l++;
            if (this.f7216c != null && !this.f7217d.supportsUrl(request.url())) {
                throw new IllegalStateException("network interceptor " + this.f7214a.get(this.f7218e - 1) + " must retain the same host and port");
            } else if (this.f7216c == null || this.f7225l <= 1) {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f7214a, streamAllocation, httpCodec, realConnection, this.f7218e + 1, request, this.f7220g, this.f7221h, this.f7222i, this.f7223j, this.f7224k);
                Interceptor interceptor = this.f7214a.get(this.f7218e);
                Response intercept = interceptor.intercept(realInterceptorChain);
                if (httpCodec != null && this.f7218e + 1 < this.f7214a.size() && realInterceptorChain.f7225l != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept == null) {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                } else if (intercept.body() != null) {
                    return intercept;
                } else {
                    throw new IllegalStateException("interceptor " + interceptor + " returned a response with no body");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f7214a.get(this.f7218e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }
}
