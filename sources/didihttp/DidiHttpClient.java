package didihttp;

import android.os.Build;
import didihttp.Call;
import didihttp.Headers;
import didihttp.Response;
import didihttp.WebSocket;
import didihttp.internal.C21750Util;
import didihttp.internal.Internal;
import didihttp.internal.cache.InternalCache;
import didihttp.internal.connection.RealConnection;
import didihttp.internal.connection.RouteDatabase;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.p232ws.RealWebSocket;
import didihttp.internal.platform.Platform;
import didihttp.internal.tls.CertificateChainCleaner;
import didihttp.internal.tls.OkHostnameVerifier;
import didihttp.internal.tls.TLSSocketFactory;
import java.net.MalformedURLException;
import java.net.Proxy;
import java.net.ProxySelector;
import java.net.Socket;
import java.net.UnknownHostException;
import java.security.GeneralSecurityException;
import java.security.KeyStore;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.net.SocketFactory;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.KeyManager;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocket;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManager;
import javax.net.ssl.TrustManagerFactory;
import javax.net.ssl.X509TrustManager;

public class DidiHttpClient implements Call.Factory, WebSocket.Factory, Cloneable {

    /* renamed from: a */
    static final List<Protocol> f59150a = C21750Util.immutableList((T[]) new Protocol[]{Protocol.HTTP_2, Protocol.HTTP_1_1});

    /* renamed from: b */
    static final List<ConnectionSpec> f59151b = C21750Util.immutableList((T[]) new ConnectionSpec[]{ConnectionSpec.MODERN_TLS, ConnectionSpec.COMPATIBLE_TLS, ConnectionSpec.CLEARTEXT});

    /* renamed from: A */
    int f59152A;

    /* renamed from: B */
    final int f59153B;

    /* renamed from: C */
    final StatisticalCallback f59154C;

    /* renamed from: D */
    final boolean f59155D;

    /* renamed from: E */
    final boolean f59156E;

    /* renamed from: c */
    final Dispatcher f59157c;

    /* renamed from: d */
    final Proxy f59158d;

    /* renamed from: e */
    final List<Protocol> f59159e;

    /* renamed from: f */
    final List<ConnectionSpec> f59160f;

    /* renamed from: g */
    final List<Interceptor> f59161g;

    /* renamed from: h */
    final List<Interceptor> f59162h;

    /* renamed from: i */
    final ProxySelector f59163i;

    /* renamed from: j */
    final CookieJar f59164j;

    /* renamed from: k */
    final Cache f59165k;

    /* renamed from: l */
    final InternalCache f59166l;

    /* renamed from: m */
    final SocketFactory f59167m;

    /* renamed from: n */
    final SSLSocketFactory f59168n;

    /* renamed from: o */
    final CertificateChainCleaner f59169o;

    /* renamed from: p */
    final HostnameVerifier f59170p;

    /* renamed from: q */
    final CertificatePinner f59171q;

    /* renamed from: r */
    final Authenticator f59172r;

    /* renamed from: s */
    final Authenticator f59173s;

    /* renamed from: t */
    final ConnectionPool f59174t;

    /* renamed from: u */
    Dns f59175u;

    /* renamed from: v */
    final boolean f59176v;

    /* renamed from: w */
    final boolean f59177w;

    /* renamed from: x */
    boolean f59178x;

    /* renamed from: y */
    int f59179y;

    /* renamed from: z */
    int f59180z;

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
                return connectionPool.mo179231b(realConnection);
            }

            public RealConnection get(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.mo179228a(address, streamAllocation);
            }

            public Socket deduplicate(ConnectionPool connectionPool, Address address, StreamAllocation streamAllocation) {
                return connectionPool.mo179230b(address, streamAllocation);
            }

            public void put(ConnectionPool connectionPool, RealConnection realConnection) {
                connectionPool.mo179229a(realConnection);
            }

            public RouteDatabase routeDatabase(ConnectionPool connectionPool) {
                return connectionPool.f59118a;
            }

            public int code(Response.Builder builder) {
                return builder.code;
            }

            public void apply(ConnectionSpec connectionSpec, SSLSocket sSLSocket, boolean z) {
                connectionSpec.mo179236a(sSLSocket, z);
            }

            public HttpUrl getHttpUrlChecked(String str) throws MalformedURLException, UnknownHostException {
                return HttpUrl.m44744b(str);
            }

            public StreamAllocation streamAllocation(Call call) {
                return ((RealCall) call).mo179528b();
            }

            public Call newWebSocketCall(DidiHttpClient didiHttpClient, Request request) {
                return RealCall.m44750a(didiHttpClient, request, true);
            }
        };
    }

    public DidiHttpClient() {
        this(new Builder());
    }

    DidiHttpClient(Builder builder) {
        boolean z;
        this.f59157c = builder.dispatcher;
        this.f59158d = builder.proxy;
        this.f59159e = builder.protocols;
        this.f59160f = builder.connectionSpecs;
        this.f59161g = C21750Util.immutableList(builder.interceptors);
        this.f59162h = C21750Util.immutableList(builder.networkInterceptors);
        this.f59163i = builder.proxySelector;
        this.f59164j = builder.cookieJar;
        this.f59165k = builder.cache;
        this.f59166l = builder.internalCache;
        this.f59167m = builder.socketFactory;
        this.f59154C = builder.callback;
        this.f59155D = builder.useGlobalStatisticalDataManagerCallback;
        this.f59156E = builder.httpDnsOwner;
        Iterator<ConnectionSpec> it = this.f59160f.iterator();
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
            this.f59168n = builder.sslSocketFactory;
            this.f59169o = builder.certificateChainCleaner;
        } else {
            X509TrustManager b = m44707b();
            this.f59168n = m44706a(b);
            this.f59169o = CertificateChainCleaner.get(b);
        }
        this.f59170p = builder.hostnameVerifier;
        this.f59171q = builder.certificatePinner.mo179204a(this.f59169o);
        this.f59172r = builder.proxyAuthenticator;
        this.f59173s = builder.authenticator;
        this.f59174t = builder.connectionPool;
        this.f59175u = builder.dns;
        this.f59176v = builder.followSslRedirects;
        this.f59177w = builder.followRedirects;
        this.f59178x = builder.retryOnConnectionFailure;
        this.f59179y = builder.connectTimeout;
        this.f59180z = builder.readTimeout;
        this.f59152A = builder.writeTimeout;
        this.f59153B = builder.pingInterval;
    }

    /* renamed from: b */
    private X509TrustManager m44707b() {
        try {
            TrustManagerFactory instance = TrustManagerFactory.getInstance(TrustManagerFactory.getDefaultAlgorithm());
            instance.init((KeyStore) null);
            TrustManager[] trustManagers = instance.getTrustManagers();
            if (trustManagers.length == 1 && (trustManagers[0] instanceof X509TrustManager)) {
                return (X509TrustManager) trustManagers[0];
            }
            throw new IllegalStateException("Unexpected default trust managers:" + Arrays.toString(trustManagers));
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m44706a(X509TrustManager x509TrustManager) {
        try {
            SSLContext instance = SSLContext.getInstance("TLS");
            instance.init((KeyManager[]) null, new TrustManager[]{x509TrustManager}, (SecureRandom) null);
            return m44705a(instance);
        } catch (GeneralSecurityException unused) {
            throw new AssertionError();
        }
    }

    /* renamed from: a */
    private SSLSocketFactory m44705a(SSLContext sSLContext) {
        if (Build.VERSION.SDK_INT <= 19) {
            return new TLSSocketFactory(sSLContext);
        }
        return sSLContext.getSocketFactory();
    }

    public int connectTimeoutMillis() {
        return this.f59179y;
    }

    public void setConnectTimeout(int i) {
        this.f59179y = i;
    }

    public int readTimeoutMillis() {
        return this.f59180z;
    }

    public void setReadTimeout(int i) {
        this.f59180z = i;
    }

    public int writeTimeoutMillis() {
        return this.f59152A;
    }

    public void setWriteTimeout(int i) {
        this.f59152A = i;
    }

    public int pingIntervalMillis() {
        return this.f59153B;
    }

    public Proxy proxy() {
        return this.f59158d;
    }

    public ProxySelector proxySelector() {
        return this.f59163i;
    }

    public CookieJar cookieJar() {
        return this.f59164j;
    }

    public Cache cache() {
        return this.f59165k;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InternalCache mo179301a() {
        Cache cache = this.f59165k;
        return cache != null ? cache.f59091a : this.f59166l;
    }

    public void setDns(Dns dns) {
        this.f59175u = dns;
    }

    public Dns dns() {
        return this.f59175u;
    }

    public SocketFactory socketFactory() {
        return this.f59167m;
    }

    public SSLSocketFactory sslSocketFactory() {
        return this.f59168n;
    }

    public HostnameVerifier hostnameVerifier() {
        return this.f59170p;
    }

    public CertificatePinner certificatePinner() {
        return this.f59171q;
    }

    public Authenticator authenticator() {
        return this.f59173s;
    }

    public Authenticator proxyAuthenticator() {
        return this.f59172r;
    }

    public ConnectionPool connectionPool() {
        return this.f59174t;
    }

    public boolean followSslRedirects() {
        return this.f59176v;
    }

    public boolean followRedirects() {
        return this.f59177w;
    }

    public void setRetryOnConnectionFailure(boolean z) {
        this.f59178x = z;
    }

    public boolean retryOnConnectionFailure() {
        return this.f59178x;
    }

    public Dispatcher dispatcher() {
        return this.f59157c;
    }

    public List<Protocol> protocols() {
        return this.f59159e;
    }

    public List<ConnectionSpec> connectionSpecs() {
        return this.f59160f;
    }

    public List<Interceptor> interceptors() {
        return this.f59161g;
    }

    public List<Interceptor> networkInterceptors() {
        return this.f59162h;
    }

    public Call newCall(Request request) {
        return RealCall.m44750a(this, request, false);
    }

    public WebSocket newWebSocket(Request request, WebSocketListener webSocketListener) {
        RealWebSocket realWebSocket = new RealWebSocket(request, webSocketListener, new SecureRandom());
        realWebSocket.connect(this);
        return realWebSocket;
    }

    public Builder newBuilder() {
        return new Builder(this);
    }

    public static final class Builder {
        Authenticator authenticator;
        Cache cache;
        StatisticalCallback callback;
        CertificateChainCleaner certificateChainCleaner;
        CertificatePinner certificatePinner;
        int connectTimeout;
        ConnectionPool connectionPool;
        List<ConnectionSpec> connectionSpecs;
        CookieJar cookieJar;
        Dispatcher dispatcher;
        Dns dns;
        boolean followRedirects;
        boolean followSslRedirects;
        HostnameVerifier hostnameVerifier;
        boolean httpDnsOwner;
        final List<Interceptor> interceptors;
        InternalCache internalCache;
        final List<Interceptor> networkInterceptors;
        int pingInterval;
        List<Protocol> protocols;
        Proxy proxy;
        Authenticator proxyAuthenticator;
        ProxySelector proxySelector;
        int readTimeout;
        boolean retryOnConnectionFailure;
        SocketFactory socketFactory;
        SSLSocketFactory sslSocketFactory;
        boolean useGlobalStatisticalDataManagerCallback;
        int writeTimeout;

        public Builder() {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.useGlobalStatisticalDataManagerCallback = true;
            this.httpDnsOwner = false;
            this.dispatcher = new Dispatcher();
            this.protocols = DidiHttpClient.f59150a;
            this.connectionSpecs = DidiHttpClient.f59151b;
            this.proxySelector = ProxySelector.getDefault();
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
            this.connectTimeout = 10000;
            this.readTimeout = 10000;
            this.writeTimeout = 10000;
            this.pingInterval = 0;
        }

        Builder(DidiHttpClient didiHttpClient) {
            this.interceptors = new ArrayList();
            this.networkInterceptors = new ArrayList();
            this.useGlobalStatisticalDataManagerCallback = true;
            this.httpDnsOwner = false;
            this.dispatcher = didiHttpClient.f59157c;
            this.proxy = didiHttpClient.f59158d;
            this.protocols = didiHttpClient.f59159e;
            this.connectionSpecs = didiHttpClient.f59160f;
            this.interceptors.addAll(didiHttpClient.f59161g);
            this.networkInterceptors.addAll(didiHttpClient.f59162h);
            this.proxySelector = didiHttpClient.f59163i;
            this.cookieJar = didiHttpClient.f59164j;
            this.internalCache = didiHttpClient.f59166l;
            this.cache = didiHttpClient.f59165k;
            this.socketFactory = didiHttpClient.f59167m;
            this.sslSocketFactory = didiHttpClient.f59168n;
            this.certificateChainCleaner = didiHttpClient.f59169o;
            this.hostnameVerifier = didiHttpClient.f59170p;
            this.certificatePinner = didiHttpClient.f59171q;
            this.proxyAuthenticator = didiHttpClient.f59172r;
            this.authenticator = didiHttpClient.f59173s;
            this.connectionPool = didiHttpClient.f59174t;
            this.dns = didiHttpClient.f59175u;
            this.followSslRedirects = didiHttpClient.f59176v;
            this.followRedirects = didiHttpClient.f59177w;
            this.retryOnConnectionFailure = didiHttpClient.f59178x;
            this.connectTimeout = didiHttpClient.f59179y;
            this.readTimeout = didiHttpClient.f59180z;
            this.writeTimeout = didiHttpClient.f59152A;
            this.pingInterval = didiHttpClient.f59153B;
            this.callback = didiHttpClient.f59154C;
            this.useGlobalStatisticalDataManagerCallback = didiHttpClient.f59155D;
            this.httpDnsOwner = didiHttpClient.f59156E;
        }

        public Builder connectTimeout(long j, TimeUnit timeUnit) {
            this.connectTimeout = checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder readTimeout(long j, TimeUnit timeUnit) {
            this.readTimeout = checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder writeTimeout(long j, TimeUnit timeUnit) {
            this.writeTimeout = checkDuration("timeout", j, timeUnit);
            return this;
        }

        public Builder pingInterval(long j, TimeUnit timeUnit) {
            this.pingInterval = checkDuration("interval", j, timeUnit);
            return this;
        }

        private static int checkDuration(String str, long j, TimeUnit timeUnit) {
            int i = (j > 0 ? 1 : (j == 0 ? 0 : -1));
            if (i < 0) {
                throw new IllegalArgumentException(str + " < 0");
            } else if (timeUnit != null) {
                long millis = timeUnit.toMillis(j);
                if (millis > 2147483647L) {
                    throw new IllegalArgumentException(str + " too large.");
                } else if (millis != 0 || i <= 0) {
                    return (int) millis;
                } else {
                    throw new IllegalArgumentException(str + " too small.");
                }
            } else {
                throw new NullPointerException("unit == null");
            }
        }

        public Builder proxy(Proxy proxy2) {
            this.proxy = proxy2;
            return this;
        }

        public Builder proxySelector(ProxySelector proxySelector2) {
            this.proxySelector = proxySelector2;
            return this;
        }

        public Builder cookieJar(CookieJar cookieJar2) {
            if (cookieJar2 != null) {
                this.cookieJar = cookieJar2;
                return this;
            }
            throw new NullPointerException("cookieJar == null");
        }

        /* access modifiers changed from: package-private */
        public void setInternalCache(InternalCache internalCache2) {
            this.internalCache = internalCache2;
            this.cache = null;
        }

        public Builder cache(Cache cache2) {
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
                X509TrustManager trustManager = Platform.get().trustManager(sSLSocketFactory);
                if (trustManager != null) {
                    this.sslSocketFactory = sSLSocketFactory;
                    this.certificateChainCleaner = CertificateChainCleaner.get(trustManager);
                    return this;
                }
                throw new IllegalStateException("Unable to extract the trust manager on " + Platform.get() + ", sslSocketFactory is " + sSLSocketFactory.getClass());
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
            if (!arrayList.contains(Protocol.HTTP_1_1)) {
                throw new IllegalArgumentException("protocols doesn't contain http/1.1: " + arrayList);
            } else if (arrayList.contains(Protocol.HTTP_1_0)) {
                throw new IllegalArgumentException("protocols must not contain http/1.0: " + arrayList);
            } else if (!arrayList.contains((Object) null)) {
                if (arrayList.contains(Protocol.SPDY_3)) {
                    arrayList.remove(Protocol.SPDY_3);
                }
                this.protocols = Collections.unmodifiableList(arrayList);
                return this;
            } else {
                throw new IllegalArgumentException("protocols must not contain null");
            }
        }

        public Builder connectionSpecs(List<ConnectionSpec> list) {
            this.connectionSpecs = C21750Util.immutableList(list);
            return this;
        }

        public List<Interceptor> interceptors() {
            return this.interceptors;
        }

        public Builder addInterceptor(Interceptor interceptor) {
            this.interceptors.add(interceptor);
            return this;
        }

        public List<Interceptor> networkInterceptors() {
            return this.networkInterceptors;
        }

        public Builder addNetworkInterceptor(Interceptor interceptor) {
            this.networkInterceptors.add(interceptor);
            return this;
        }

        public Builder setStatisticalCallback(StatisticalCallback statisticalCallback) {
            this.callback = statisticalCallback;
            return this;
        }

        public void setUseGlobalStatisticalManagerCallback(boolean z) {
            this.useGlobalStatisticalDataManagerCallback = z;
        }

        public void setHttpDnsOwner(boolean z) {
            this.httpDnsOwner = z;
        }

        public DidiHttpClient build() {
            return new DidiHttpClient(this);
        }
    }
}
