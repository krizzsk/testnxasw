package didihttp.internal.http;

import didihttp.Call;
import didihttp.Connection;
import didihttp.HttpUrl;
import didihttp.Interceptor;
import didihttp.LogEventListener;
import didihttp.Request;
import didihttp.Response;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.trace.Node;
import didihttp.internal.trace.Tree;
import java.io.IOException;
import java.util.List;

public final class RealInterceptorChain implements Interceptor.Chain {

    /* renamed from: a */
    private final List<Interceptor> f59470a;

    /* renamed from: b */
    private final StreamAllocation f59471b;

    /* renamed from: c */
    private final HttpCodec f59472c;

    /* renamed from: d */
    private final Connection f59473d;

    /* renamed from: e */
    private final int f59474e;

    /* renamed from: f */
    private final Request f59475f;

    /* renamed from: g */
    private int f59476g;

    /* renamed from: h */
    private Call f59477h;

    /* renamed from: i */
    private LogEventListener f59478i;

    /* renamed from: j */
    private Object f59479j;

    /* renamed from: k */
    private Tree f59480k;

    public RealInterceptorChain(List<Interceptor> list, StreamAllocation streamAllocation, HttpCodec httpCodec, Connection connection, int i, Request request, Call call, LogEventListener logEventListener, Tree tree) {
        this.f59470a = list;
        this.f59473d = connection;
        this.f59471b = streamAllocation;
        this.f59472c = httpCodec;
        this.f59474e = i;
        this.f59475f = request;
        this.f59477h = call;
        this.f59478i = logEventListener;
        this.f59480k = tree;
    }

    public Connection connection() {
        return this.f59473d;
    }

    public StreamAllocation streamAllocation() {
        return this.f59471b;
    }

    public HttpCodec httpStream() {
        return this.f59472c;
    }

    public Request request() {
        return this.f59475f;
    }

    public Call call() {
        return this.f59477h;
    }

    public LogEventListener logEventListener() {
        return this.f59478i;
    }

    public Tree tree() {
        return this.f59480k;
    }

    public Response proceed(Request request) throws IOException {
        return proceed(request, this.f59471b, this.f59472c, this.f59473d);
    }

    public Response proceed(Request request, StreamAllocation streamAllocation, HttpCodec httpCodec, Connection connection) throws IOException {
        if (this.f59474e < this.f59470a.size()) {
            this.f59476g++;
            if (this.f59472c != null && !m44826a(request.url())) {
                throw new IllegalStateException("network interceptor " + this.f59470a.get(this.f59474e - 1) + " must retain the same host and port");
            } else if (this.f59472c == null || this.f59476g <= 1) {
                RealInterceptorChain realInterceptorChain = new RealInterceptorChain(this.f59470a, streamAllocation, httpCodec, connection, this.f59474e + 1, request, this.f59477h, this.f59478i, this.f59480k);
                realInterceptorChain.f59479j = this.f59479j;
                Interceptor interceptor = this.f59470a.get(this.f59474e);
                Node node = new Node();
                node.value = interceptor;
                this.f59480k.push(node);
                this.f59478i.interceptorStart(this.f59477h, interceptor);
                Response intercept = interceptor.intercept(realInterceptorChain);
                this.f59478i.interceptorEnd(this.f59477h, interceptor);
                this.f59480k.pop(node);
                if (httpCodec != null && this.f59474e + 1 < this.f59470a.size() && realInterceptorChain.f59476g != 1) {
                    throw new IllegalStateException("network interceptor " + interceptor + " must call proceed() exactly once");
                } else if (intercept != null) {
                    return intercept;
                } else {
                    throw new NullPointerException("interceptor " + interceptor + " returned null");
                }
            } else {
                throw new IllegalStateException("network interceptor " + this.f59470a.get(this.f59474e - 1) + " must call proceed() exactly once");
            }
        } else {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private boolean m44826a(HttpUrl httpUrl) {
        return httpUrl.host().equals(this.f59473d.route().address().url().host()) && httpUrl.port() == this.f59473d.route().address().url().port();
    }

    public Object getExtraData() {
        return this.f59479j;
    }

    public void setExtraData(Object obj) {
        this.f59479j = obj;
    }
}
