package okhttp3;

import com.didiglobal.privacy.domainmonitor.okhttp.OkHttpHooker;
import java.io.IOException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.security.GeneralSecurityException;
import java.security.SecureRandom;
import java.time.Duration;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;
import okhttp3.Call;
import okhttp3.EventListener;
import okhttp3.Headers;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.internal.C3000Util;
import okhttp3.internal.Internal;
import okhttp3.internal.cache.InternalCache;
import okhttp3.internal.connection.RealConnection;
import okhttp3.internal.connection.RouteDatabase;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.p073ws.RealWebSocket;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.proxy.NullProxySelector;
import okhttp3.internal.tls.CertificateChainCleaner;
import okhttp3.internal.tls.OkHostnameVerifier;

public class OkHttpClient implements Cloneable, Call.Factory, WebSocket.Factory {

    /* renamed from: a */
    static final List<Protocol> f7052a = C3000Util.immutableList((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});

    /* renamed from: b */
    static final List<ConnectionSpec> f7053b = C3000Util.immutableList((T[]) new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.CLEARTEXT});

    /* renamed from: A */
    final int f7054A;

    /* renamed from: B */
    final int f7055B;

    /* renamed from: C */
    final int f7056C;

    /* renamed from: D */
    final int f7057D;

    /* renamed from: c */
    final Dispatcher f7058c;
    @Nullable

    /* renamed from: d */
    final Proxy f7059d;

    /* renamed from: e */
    final List<Protocol> f7060e;

    /* renamed from: f */
    final List<ConnectionSpec> f7061f;

    /* renamed from: g */
    final List<Interceptor> f7062g;

    /* renamed from: h */
    final List<Interceptor> f7063h;

    /* renamed from: i */
    final EventListener.Factory f7064i;

    /* renamed from: j */
    final ProxySelector f7065j;

    /* renamed from: k */
    final CookieJar f7066k;
    @Nullable

    /* renamed from: l */
    final Cache f7067l;
    @Nullable

    /* renamed from: m */
    final InternalCache f7068m;

    /* renamed from: n */
    final SocketFactory f7069n;

    /* renamed from: o */
    final SSLSocketFactory f7070o;

    /* renamed from: p */
    final CertificateChainCleaner f7071p;

    /* renamed from: q */
    final HostnameVerifier f7072q;

    /* renamed from: r */
    final CertificatePinner f7073r;

    /* renamed from: s */
    final Authenticator f7074s;

    /* renamed from: t */
    final Authenticator f7075t;

    /* renamed from: u */
    final ConnectionPool f7076u;

    /* renamed from: v */
    final Dns f7077v;

    /* renamed from: w */
    final boolean f7078w;

    /* renamed from: x */
    final boolean f7079x;

    /* renamed from: y */
    final boolean f7080y;

    /* renamed from: z */
    final int f7081z;

    static {
        Internal.instance = new Internal() {
            public void addLenient(Headers.Builder builder, String str) {
                builder.addLenient(str);
            }

            public void addLenient(Headers.Builder builder, String str, String str2) {
                builder.addLenient(str, str2);
            }

            public void setCache(Builder builder, InternalCache internalCache) {
                builder.setInternalCache(internalCache);
            }

            public boolean connectionBecameIdle(ConnectionPool connectionPool, RealConnection realConnection) {
                return connectionPool.mo29968b(realConnection);
            }

            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation, Route route) {
                return connectionPool.mo29966a(address, streamAllocation, route);
            }

            public boolean equalsNonHost(Address address, Address address2) {
                return address.mo29849a(address2);
            }

            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.mo29965a(address, streamAllocation);
            }

            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.mo29967a(realConnection);
            }

            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.f6974a;
            }

            public int code(Response.Builder builder) {
                return builder.code;
            }

            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.mo29973a(sSLSocket, z);
            }

            public boolean isInvalidHttpUrlHost(IllegalArgumentException illegalArgumentException) {
                return illegalArgumentException.getMessage().startsWith("Invalid URL host");
            }

            public StreamAllocation streamAllocation(Call call) {
                return ((RealCall) call).mo30256b();
            }

            @Nullable
            public IOException timeoutExit(Call call, @Nullable IOException iOException) {
                return ((RealCall) call).mo30254a(iOException);
            }

            public Call newWebSocketCall(OkHttpClient okHttpClient, Request request) {
                return RealCall.m6765a(okHttpClient, request, true);
            }
        };
    }

    public OkHttpClient() {
        this(new Builder());
    }

    OkHttpClient(Builder builder) {
        boolean z;
        this.f7058c = builder.dispatcher;
        this.f7059d = builder.proxy;
        this.f7060e = builder.protocols;
        this.f7061f = builder.connectionSpecs;
        this.f7062g = C3000Util.immutableList(builder.interceptors);
        this.f7063h = C3000Util.immutableList(builder.networkInterceptors);
        this.f7064i = builder.eventListenerFactory;
        this.f7065j = builder.proxySelector;
        this.f7066k = builder.cookieJar;
        this.f7067l = builder.cache;
        this.f7068m = builder.internalCache;
        this.f7069n = builder.socketFactory;
        Iterator<ConnectionSpec> it = this.f7061f.iterator();
        loop0:
        while (true) {
            z = false;
            while (true) {
                if (!it.hasNext()) {
                    break loop0;
                }
                ConnectionSpec next = it.next();
                if (z || next.isTls()) {
                    z = true;
                }
            }
        }
        if (builder.sslSocketFactory != null || !z) {
            this.f7070o = builder.sslSocketFactory;
            this.f7071p = builder.certificateChainCleaner;
        } else {
            X509TrustManager platformTrustManager = C3000Util.platformTrustManager();
            this.f7070o = m6762a(platformTrustManager);
            this.f7071p = CertificateChainCleaner.get(platformTrustManager);
        }
        if (this.f7070o != null) {
            Platform.get().configureSslSocketFactory(this.f7070o);
        }
        this.f7072q = builder.hostnameVerifier;
        this.f7073r = builder.certificatePinner.mo29937a(this.f7071p);
        this.f7074s = builder.proxyAuthenticator;
        this.f7075t = builder.authenticator;
        this.f7076u = builder.connectionPool;
        this.f7077v = builder.dns;
        this.f7078w = builder.followSslRedirects;
        this.f7079x = builder.followRedirects;
        this.f7080y = builder.retryOnConnectionFailure;
        this.f7081z = builder.callTimeout;
        this.f7054A = builder.connectTimeout;
        this.f7055B = builder.readTimeout;
        this.f7056C = builder.writeTimeout;
        this.f7057D = builder.pingInterval;
        if (this.f7062g.contains((Object) null)) {
            throw new IllegalStateException("Null interceptor: " + this.f7062g);
        } else if (this.f7063h.contains((Object) null)) {
            throw new IllegalStateException("Null network interceptor: " + this.f7063h);
        }
    }

    /* renamed from: a */
    private static SSLSocketFactory m6762a(X509TrustManager x509TrustManager) {
        try {
            SSLContext sSLContext = Platform.get().getSSLContext();
            sSLContext.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return sSLContext.getSocketFactory();
        } catch (GeneralSecurityException e) {
            throw C3000Util.assertionError("No System TLS", e);
        }
    }

    public int callTimeoutMillis() {
        return this.f7081z;
    }

    public int connectTimeoutMillis() {
        return this.f7054A;
    }

    public int readTimeoutMillis() {
        return this.f7055B;
    }

    public int writeTimeoutMillis() {
        return this.f7056C;
    }

    public int pingIntervalMillis() {
        return this.f7057D;
    }

    @Nullable
    public Proxy proxy() {
        return this.f7059d;
    }

    public ProxySelector proxySelector() {
        return this.f7065j;
    }

    public CookieJar cookieJar() {
        return this.f7066k;
    }

    @Nullable
    public Cache cache() {
        return this.f7067l;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InternalCache mo30172a() {
        Cache cache = this.f7067l;
        return cache != null ? cache.f6945a : this.f7068m;
    }

    public Dns dns() {
        return this.f7077v;
    }

    public SocketFactory socketFactory() {
        return this.f7069n;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f7070o;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f7072q;
    }

    public CertificatePinner certificatePinner() {
        return this.f7073r;
    }

    public Authenticator authenticator() {
        return this.f7075t;
    }

    public Authenticator proxyAuthenticator() {
        return this.f7074s;
    }

    public ConnectionPool connectionPool() {
        return this.f7076u;
    }

    public boolean followSslRedirects() {
        return this.f7078w;
    }

    public boolean followRedirects() {
        return this.f7079x;
    }

    public boolean retryOnConnectionFailure() {
        return this.f7080y;
    }

    public Dispatcher dispatcher() {
        return this.f7058c;
    }

    public List<Protocol> protocols() {
        return this.f7060e;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f7061f;
    }

    public List<Interceptor> interceptors() {
        return this.f7062g;
    }

    public List<Interceptor> networkInterceptors() {
        return this.f7063h;
    }

    public EventListener.Factory eventListenerFactory() {
        return this.f7064i;
    }

    public Call newCall(Request request) {
        return RealCall.m6765a(this, request, false);
    }

    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new Random(), (long) this.f7057D);
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {
        Authenticator authenticator;
        @Nullable
        Cache cache;
        int callTimeout;
        @Nullable
        CertificateChainCleaner certificateChainCleaner;
        CertificatePinner certificatePinner;
        int connectTimeout;
        ConnectionPool connectionPool;
        List<ConnectionSpec> connectionSpecs;
        CookieJar cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        EventListener.Factory eventListenerFactory;
        boolean followRedirects;
        boolean followSslRedirects;
        HostnameVerifier hostnameVerifier;
        final List<Interceptor> interceptors;
        @Nullable
        InternalCache internalCache;
        final List<Interceptor> networkInterceptors;
        int pingInterval;
        List<Protocol> protocols;
        @Nullable
        Proxy proxy;
        Authenticator proxyAuthenticator;
        ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SocketFactory socketFactory;
        @Nullable
        SSLSocketFactory sslSocketFactory;
        int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = new Dispatcher();
            this.protocols = OkHttpClient.f7052a;
            this.connectionSpecs = OkHttpClient.f7053b;
            this.eventListenerFactory = EventListener.factory(EventListener.NONE);
            ProxySelector proxySelector2 = ProxySelector.getDefault();
            this.proxySelector = proxySelector2;
            if (proxySelector2 == null) {
                this.proxySelector = new NullProxySelector();
            }
            this.cookieJar = CookieJar.NO_COOKIES;
            this.socketFactory = SocketFactory.getDefault();
            this.hostnameVerifier = OkHostnameVerifier.INSTANCE;
            this.certificatePinner = CertificatePinner.DEFAULT;
            this.proxyAuthenticator = Authenticator.NONE;
            this.authenticator = Authenticator.NONE;
            this.connectionPool = new ConnectionPool();
            this.dns = Dns.SYSTEM;
            this.followSslRedirects = true;
            this.followRedirects = true;
            this.retryOnConnectionFailure = true;
            this.callTimeout = 0;
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
            this.networkInterceptors.addAll(OkHttpHooker.globalNetworkInterceptors);
        }

        Builder(OkHttpClient okHttpClient) {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.dispatcher = okHttpClient.f7058c;
            this.proxy = okHttpClient.f7059d;
            this.protocols = okHttpClient.f7060e;
            this.connectionSpecs = okHttpClient.f7061f;
            this.interceptors.addAll(okHttpClient.f7062g);
            this.networkInterceptors.addAll(okHttpClient.f7063h);
            this.eventListenerFactory = okHttpClient.f7064i;
            this.proxySelector = okHttpClient.f7065j;
            this.cookieJar = okHttpClient.f7066k;
            this.internalCache = okHttpClient.f7068m;
            this.cache = okHttpClient.f7067l;
            this.socketFactory = okHttpClient.f7069n;
            this.sslSocketFactory = okHttpClient.f7070o;
            this.certificateChainCleaner = okHttpClient.f7071p;
            this.hostnameVerifier = okHttpClient.f7072q;
            this.certificatePinner = okHttpClient.f7073r;
            this.proxyAuthenticator = okHttpClient.f7074s;
            this.authenticator = okHttpClient.f7075t;
            this.connectionPool = okHttpClient.f7076u;
            this.dns = okHttpClient.f7077v;
            this.followSslRedirects = okHttpClient.f7078w;
            this.followRedirects = okHttpClient.f7079x;
            this.retryOnConnectionFailure = okHttpClient.f7080y;
            this.callTimeout = okHttpClient.f7081z;
            this.connectTimeout = okHttpClient.f7054A;
            this.readTimeout = okHttpClient.f7055B;
            this.writeTimeout = okHttpClient.f7056C;
            this.pingInterval = okHttpClient.f7057D;
            this.networkInterceptors.addAll(OkHttpHooker.globalNetworkInterceptors);
        }

        public Builder callTimeout(long j, TimeUnit timeUnit) {
            this.callTimeout = C3000Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder callTimeout(Duration duration) {
            this.callTimeout = C3000Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = C3000Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder connectTimeout(Duration duration) {
            this.connectTimeout = C3000Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = C3000Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder readTimeout(Duration duration) {
            this.readTimeout = C3000Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.writeTimeout = C3000Util.checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder writeTimeout(Duration duration) {
            this.writeTimeout = C3000Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder pingInterval(long j, TimeUnit timeUnit) {
            this.pingInterval = C3000Util.checkDuration("interval", j, timeUnit);
            return this;
        }

        public Builder pingInterval(Duration duration) {
            this.pingInterval = C3000Util.checkDuration("timeout", duration.toMillis(), TimeUnit.MILLISECONDS);
            return this;
        }

        public Builder proxy(@Nullable Proxy proxy2) {
            this.proxy = proxy2;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector2) {
            if (proxySelector2 != null) {
                this.proxySelector = proxySelector2;
                return this;
            }
            throw new NullPointerException("proxySelector == null");
        }

        public Builder cookieJar(CookieJar cookieJar2) {
            if (cookieJar2 != null) {
                this.cookieJar = cookieJar2;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        /* access modifiers changed from: package-private */
        public void setInternalCache(@Nullable InternalCache internalCache2) {
            this.internalCache = internalCache2;
            this.cache = null;
        }

        public Builder cache(@Nullable Cache cache2) {
            this.cache = cache2;
            this.internalCache = null;
            return this;
        }

        public Builder dns(Dns dns2) {
            if (dns2 != null) {
                this.dns = dns2;
                return this;
            }
            throw new NullPointerException("dns == null");
        }

        public Builder socketFactory(SocketFactory socketFactory2) {
            if (socketFactory2 != null) {
                this.socketFactory = socketFactory2;
                return this;
            }
            throw new NullPointerException("socketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory) {
            if (sSLSocketFactory != null) {
                this.sslSocketFactory = sSLSocketFactory;
                this.certificateChainCleaner = Platform.get().buildCertificateChainCleaner(sSLSocketFactory);
                return this;
            }
            throw new NullPointerException("sslSocketFactory == null");
        }

        public Builder sslSocketFactory(SSLSocketFactory sSLSocketFactory, X509TrustManager x509TrustManager) {
            if (sSLSocketFactory == null) {
                throw new NullPointerException("sslSocketFactory == null");
            } else if (x509TrustManager != null) {
                this.sslSocketFactory = sSLSocketFactory;
                this.certificateChainCleaner = CertificateChainCleaner.get(x509TrustManager);
                return this;
            } else {
                throw new NullPointerException("trustManager == null");
            }
        }

        public Builder hostnameVerifier(HostnameVerifier hostnameVerifier2) {
            if (hostnameVerifier2 != null) {
                this.hostnameVerifier = hostnameVerifier2;
                return this;
            }
            throw new NullPointerException("hostnameVerifier == null");
        }

        public Builder certificatePinner(CertificatePinner certificatePinner2) {
            if (certificatePinner2 != null) {
                this.certificatePinner = certificatePinner2;
                return this;
            }
            throw new NullPointerException("certificatePinner == null");
        }

        public Builder authenticator(Authenticator authenticator2) {
            if (authenticator2 != null) {
                this.authenticator = authenticator2;
                return this;
            }
            throw new NullPointerException("authenticator == null");
        }

        public Builder proxyAuthenticator(Authenticator authenticator2) {
            if (authenticator2 != null) {
                this.proxyAuthenticator = authenticator2;
                return this;
            }
            throw new NullPointerException("proxyAuthenticator == null");
        }

        public Builder connectionPool(ConnectionPool connectionPool2) {
            if (connectionPool2 != null) {
                this.connectionPool = connectionPool2;
                return this;
            }
            throw new NullPointerException("connectionPool == null");
        }

        public Builder followSslRedirects(boolean z) {
            this.followSslRedirects = z;
            return this;
        }

        public Builder followRedirects(boolean z) {
            this.followRedirects = z;
            return this;
        }

        public Builder retryOnConnectionFailure(boolean z) {
            this.retryOnConnectionFailure = z;
            return this;
        }

        public Builder dispatcher(Dispatcher dispatcher2) {
            if (dispatcher2 != null) {
                this.dispatcher = dispatcher2;
                return this;
            }
            throw new IllegalArgumentException("dispatcher == null");
        }

        public Builder protocols(List<Protocol> list) {
            ArrayList arrayList = new ArrayList(list);
            if (!arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && !arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols must contain h2_prior_knowledge or http/1.1: " + arrayList);
            } else if (arrayList.contains(Protocol.H2_PRIOR_KNOWLEDGE) && arrayList.size() > 1) {
                throw new IllegalArgumentException("protocols containing h2_prior_knowledge cannot use other protocols: " + arrayList);
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (!arrayList.contains((Object) null)) {
                arrayList.remove(Protocol.SPDY_3);
                this.protocols = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.connectionSpecs = C3000Util.immutableList(list);
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.interceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            if (interceptor != null) {
                this.networkInterceptors.add(interceptor);
                return this;
            }
            throw new IllegalArgumentException("interceptor == null");
        }

        public Builder eventListener(EventListener eventListener) {
            if (eventListener != null) {
                this.eventListenerFactory = EventListener.factory(eventListener);
                return this;
            }
            throw new NullPointerException("eventListener == null");
        }

        public Builder eventListenerFactory(EventListener.Factory factory) {
            if (factory != null) {
                this.eventListenerFactory = factory;
                return this;
            }
            throw new NullPointerException("eventListenerFactory == null");
        }

        public OkHttpClient build() {
            return new OkHttpClient(this);
        }
    }
}
