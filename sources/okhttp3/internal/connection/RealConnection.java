package okhttp3.internal.connection;

import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import javax.annotation.Nullable;
import javax.net.ssl.SSLPeerUnverifiedException;
import okhttp3.Address;
import okhttp3.Call;
import okhttp3.Connection;
import okhttp3.ConnectionPool;
import okhttp3.EventListener;
import okhttp3.Handshake;
import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import okhttp3.Route;
import okhttp3.internal.C3000Util;
import okhttp3.internal.Internal;
import okhttp3.internal.Version;
import okhttp3.internal.http.HttpCodec;
import okhttp3.internal.http.HttpHeaders;
import okhttp3.internal.http1.Http1Codec;
import okhttp3.internal.http2.ErrorCode;
import okhttp3.internal.http2.Http2Codec;
import okhttp3.internal.http2.Http2Connection;
import okhttp3.internal.http2.Http2Stream;
import okhttp3.internal.p073ws.RealWebSocket;
import okhttp3.internal.platform.Platform;
import okhttp3.internal.tls.OkHostnameVerifier;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Source;

public final class RealConnection extends Http2Connection.Listener implements Connection {

    /* renamed from: a */
    private static final String f7175a = "throw with null exception";

    /* renamed from: b */
    private static final int f7176b = 21;
    public int allocationLimit = 1;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();

    /* renamed from: c */
    private final ConnectionPool f7177c;

    /* renamed from: d */
    private final Route f7178d;

    /* renamed from: e */
    private Socket f7179e;

    /* renamed from: f */
    private Socket f7180f;

    /* renamed from: g */
    private Handshake f7181g;

    /* renamed from: h */
    private Protocol f7182h;

    /* renamed from: i */
    private Http2Connection f7183i;
    public long idleAtNanos = Long.MAX_VALUE;

    /* renamed from: j */
    private BufferedSource f7184j;

    /* renamed from: k */
    private BufferedSink f7185k;
    public boolean noNewStreams;
    public int successCount;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.f7177c = connectionPool;
        this.f7178d = route;
    }

    public static RealConnection testConnection(ConnectionPool connectionPool, Route route, Socket socket, long j) {
        RealConnection realConnection = new RealConnection(connectionPool, route);
        realConnection.f7180f = socket;
        realConnection.idleAtNanos = j;
        return realConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0090 A[Catch:{ IOException -> 0x00f9 }] */
    /* JADX WARNING: Removed duplicated region for block: B:21:0x00a9  */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x00d3  */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x00e0  */
    /* JADX WARNING: Removed duplicated region for block: B:51:0x012f  */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x0135  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(int r17, int r18, int r19, int r20, boolean r21, okhttp3.Call r22, okhttp3.EventListener r23) {
        /*
            r16 = this;
            r7 = r16
            r8 = r22
            r9 = r23
            okhttp3.Protocol r0 = r7.f7182h
            if (r0 != 0) goto L_0x0150
            okhttp3.Route r0 = r7.f7178d
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.connectionSpecs()
            okhttp3.internal.connection.ConnectionSpecSelector r10 = new okhttp3.internal.connection.ConnectionSpecSelector
            r10.<init>(r0)
            okhttp3.Route r1 = r7.f7178d
            okhttp3.Address r1 = r1.address()
            javax.net.ssl.SSLSocketFactory r1 = r1.sslSocketFactory()
            if (r1 != 0) goto L_0x0074
            okhttp3.ConnectionSpec r1 = okhttp3.ConnectionSpec.CLEARTEXT
            boolean r0 = r0.contains(r1)
            if (r0 == 0) goto L_0x0067
            okhttp3.Route r0 = r7.f7178d
            okhttp3.Address r0 = r0.address()
            okhttp3.HttpUrl r0 = r0.url()
            java.lang.String r0 = r0.host()
            okhttp3.internal.platform.Platform r1 = okhttp3.internal.platform.Platform.get()
            boolean r1 = r1.isCleartextTrafficPermitted(r0)
            if (r1 == 0) goto L_0x0046
            goto L_0x0086
        L_0x0046:
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "CLEARTEXT communication to "
            r3.append(r4)
            r3.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r3.append(r0)
            java.lang.String r0 = r3.toString()
            r2.<init>(r0)
            r1.<init>(r2)
            throw r1
        L_0x0067:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "CLEARTEXT communication not enabled for client"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0074:
            okhttp3.Route r0 = r7.f7178d
            okhttp3.Address r0 = r0.address()
            java.util.List r0 = r0.protocols()
            okhttp3.Protocol r1 = okhttp3.Protocol.H2_PRIOR_KNOWLEDGE
            boolean r0 = r0.contains(r1)
            if (r0 != 0) goto L_0x0143
        L_0x0086:
            r11 = 0
            r12 = r11
        L_0x0088:
            okhttp3.Route r0 = r7.f7178d     // Catch:{ IOException -> 0x00f9 }
            boolean r0 = r0.requiresTunnel()     // Catch:{ IOException -> 0x00f9 }
            if (r0 == 0) goto L_0x00a9
            r1 = r16
            r2 = r17
            r3 = r18
            r4 = r19
            r5 = r22
            r6 = r23
            r1.m6808a(r2, r3, r4, r5, r6)     // Catch:{ IOException -> 0x00f9 }
            java.net.Socket r0 = r7.f7179e     // Catch:{ IOException -> 0x00f9 }
            if (r0 != 0) goto L_0x00a4
            goto L_0x00c6
        L_0x00a4:
            r13 = r17
            r14 = r18
            goto L_0x00b0
        L_0x00a9:
            r13 = r17
            r14 = r18
            r7.m6809a((int) r13, (int) r14, (okhttp3.Call) r8, (okhttp3.EventListener) r9)     // Catch:{ IOException -> 0x00f7 }
        L_0x00b0:
            r15 = r20
            r7.m6811a((okhttp3.internal.connection.ConnectionSpecSelector) r10, (int) r15, (okhttp3.Call) r8, (okhttp3.EventListener) r9)     // Catch:{ IOException -> 0x00f5 }
            okhttp3.Route r0 = r7.f7178d     // Catch:{ IOException -> 0x00f5 }
            java.net.InetSocketAddress r0 = r0.socketAddress()     // Catch:{ IOException -> 0x00f5 }
            okhttp3.Route r1 = r7.f7178d     // Catch:{ IOException -> 0x00f5 }
            java.net.Proxy r1 = r1.proxy()     // Catch:{ IOException -> 0x00f5 }
            okhttp3.Protocol r2 = r7.f7182h     // Catch:{ IOException -> 0x00f5 }
            r9.connectEnd(r8, r0, r1, r2)     // Catch:{ IOException -> 0x00f5 }
        L_0x00c6:
            okhttp3.Route r0 = r7.f7178d
            boolean r0 = r0.requiresTunnel()
            if (r0 == 0) goto L_0x00e0
            java.net.Socket r0 = r7.f7179e
            if (r0 == 0) goto L_0x00d3
            goto L_0x00e0
        L_0x00d3:
            java.net.ProtocolException r0 = new java.net.ProtocolException
            java.lang.String r1 = "Too many tunnel connections attempted: 21"
            r0.<init>(r1)
            okhttp3.internal.connection.RouteException r1 = new okhttp3.internal.connection.RouteException
            r1.<init>(r0)
            throw r1
        L_0x00e0:
            okhttp3.internal.http2.Http2Connection r0 = r7.f7183i
            if (r0 == 0) goto L_0x00f4
            okhttp3.ConnectionPool r1 = r7.f7177c
            monitor-enter(r1)
            okhttp3.internal.http2.Http2Connection r0 = r7.f7183i     // Catch:{ all -> 0x00f1 }
            int r0 = r0.maxConcurrentStreams()     // Catch:{ all -> 0x00f1 }
            r7.allocationLimit = r0     // Catch:{ all -> 0x00f1 }
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            goto L_0x00f4
        L_0x00f1:
            r0 = move-exception
            monitor-exit(r1)     // Catch:{ all -> 0x00f1 }
            throw r0
        L_0x00f4:
            return
        L_0x00f5:
            r0 = move-exception
            goto L_0x0100
        L_0x00f7:
            r0 = move-exception
            goto L_0x00fe
        L_0x00f9:
            r0 = move-exception
            r13 = r17
            r14 = r18
        L_0x00fe:
            r15 = r20
        L_0x0100:
            java.net.Socket r1 = r7.f7180f
            okhttp3.internal.C3000Util.closeQuietly((java.net.Socket) r1)
            java.net.Socket r1 = r7.f7179e
            okhttp3.internal.C3000Util.closeQuietly((java.net.Socket) r1)
            r7.f7180f = r11
            r7.f7179e = r11
            r7.f7184j = r11
            r7.f7185k = r11
            r7.f7181g = r11
            r7.f7182h = r11
            r7.f7183i = r11
            okhttp3.Route r1 = r7.f7178d
            java.net.InetSocketAddress r3 = r1.socketAddress()
            okhttp3.Route r1 = r7.f7178d
            java.net.Proxy r4 = r1.proxy()
            r5 = 0
            r1 = r23
            r2 = r22
            r6 = r0
            r1.connectFailed(r2, r3, r4, r5, r6)
            if (r12 != 0) goto L_0x0135
            okhttp3.internal.connection.RouteException r12 = new okhttp3.internal.connection.RouteException
            r12.<init>(r0)
            goto L_0x0138
        L_0x0135:
            r12.addConnectException(r0)
        L_0x0138:
            if (r21 == 0) goto L_0x0142
            boolean r0 = r10.connectionFailed(r0)
            if (r0 == 0) goto L_0x0142
            goto L_0x0088
        L_0x0142:
            throw r12
        L_0x0143:
            okhttp3.internal.connection.RouteException r0 = new okhttp3.internal.connection.RouteException
            java.net.UnknownServiceException r1 = new java.net.UnknownServiceException
            java.lang.String r2 = "H2_PRIOR_KNOWLEDGE cannot be used with HTTPS"
            r1.<init>(r2)
            r0.<init>(r1)
            throw r0
        L_0x0150:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r1 = "already connected"
            r0.<init>(r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.connect(int, int, int, int, boolean, okhttp3.Call, okhttp3.EventListener):void");
    }

    /* renamed from: a */
    private void m6808a(int i, int i2, int i3, Call call, EventListener eventListener) throws IOException {
        Request a = m6805a();
        HttpUrl url = a.url();
        int i4 = 0;
        while (i4 < 21) {
            m6809a(i, i2, call, eventListener);
            a = m6806a(i2, i3, a, url);
            if (a != null) {
                C3000Util.closeQuietly(this.f7179e);
                this.f7179e = null;
                this.f7185k = null;
                this.f7184j = null;
                eventListener.connectEnd(call, this.f7178d.socketAddress(), this.f7178d.proxy(), (Protocol) null);
                i4++;
            } else {
                return;
            }
        }
    }

    /* renamed from: a */
    private void m6809a(int i, int i2, Call call, EventListener eventListener) throws IOException {
        Socket socket;
        Proxy proxy = this.f7178d.proxy();
        Address address = this.f7178d.address();
        if (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) {
            socket = address.socketFactory().createSocket();
        } else {
            socket = new Socket(proxy);
        }
        this.f7179e = socket;
        eventListener.connectStart(call, this.f7178d.socketAddress(), proxy);
        this.f7179e.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.f7179e, this.f7178d.socketAddress(), i);
            try {
                this.f7184j = Okio.buffer(Okio.source(this.f7179e));
                this.f7185k = Okio.buffer(Okio.sink(this.f7179e));
            } catch (NullPointerException e) {
                if (f7175a.equals(e.getMessage())) {
                    throw new IOException(e);
                }
            }
        } catch (ConnectException e2) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f7178d.socketAddress());
            connectException.initCause(e2);
            throw connectException;
        }
    }

    /* renamed from: a */
    private void m6811a(ConnectionSpecSelector connectionSpecSelector, int i, Call call, EventListener eventListener) throws IOException {
        if (this.f7178d.address().sslSocketFactory() != null) {
            eventListener.secureConnectStart(call);
            m6810a(connectionSpecSelector);
            eventListener.secureConnectEnd(call, this.f7181g);
            if (this.f7182h == Protocol.HTTP_2) {
                m6807a(i);
            }
        } else if (this.f7178d.address().protocols().contains(Protocol.H2_PRIOR_KNOWLEDGE)) {
            this.f7180f = this.f7179e;
            this.f7182h = Protocol.H2_PRIOR_KNOWLEDGE;
            m6807a(i);
        } else {
            this.f7180f = this.f7179e;
            this.f7182h = Protocol.HTTP_1_1;
        }
    }

    /* renamed from: a */
    private void m6807a(int i) throws IOException {
        this.f7180f.setSoTimeout(0);
        Http2Connection build = new Http2Connection.Builder(true).socket(this.f7180f, this.f7178d.address().url().host(), this.f7184j, this.f7185k).listener(this).pingIntervalMillis(i).build();
        this.f7183i = build;
        build.start();
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v7, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v9, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v10, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:31:0x010f A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:33:0x0115 A[Catch:{ all -> 0x0106 }] */
    /* JADX WARNING: Removed duplicated region for block: B:35:0x0118  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m6810a(okhttp3.internal.connection.ConnectionSpecSelector r8) throws java.io.IOException {
        /*
            r7 = this;
            okhttp3.Route r0 = r7.f7178d
            okhttp3.Address r0 = r0.address()
            javax.net.ssl.SSLSocketFactory r1 = r0.sslSocketFactory()
            r2 = 0
            java.net.Socket r3 = r7.f7179e     // Catch:{ AssertionError -> 0x0108 }
            okhttp3.HttpUrl r4 = r0.url()     // Catch:{ AssertionError -> 0x0108 }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x0108 }
            okhttp3.HttpUrl r5 = r0.url()     // Catch:{ AssertionError -> 0x0108 }
            int r5 = r5.port()     // Catch:{ AssertionError -> 0x0108 }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x0108 }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x0108 }
            okhttp3.ConnectionSpec r8 = r8.configureSecureSocket(r1)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            boolean r3 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r3 == 0) goto L_0x0041
            okhttp3.internal.platform.Platform r3 = okhttp3.internal.platform.Platform.get()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            okhttp3.HttpUrl r4 = r0.url()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.util.List r5 = r0.protocols()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.configureTlsExtensions(r1, r4, r5)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x0041:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            okhttp3.Handshake r4 = okhttp3.Handshake.get(r3)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            javax.net.ssl.HostnameVerifier r5 = r0.hostnameVerifier()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            okhttp3.HttpUrl r6 = r0.url()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r6 = r6.host()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r3 == 0) goto L_0x00ae
            okhttp3.CertificatePinner r3 = r0.certificatePinner()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.util.List r5 = r4.peerCertificates()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.check((java.lang.String) r0, (java.util.List<java.security.cert.Certificate>) r5)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            boolean r8 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r8 == 0) goto L_0x007f
            okhttp3.internal.platform.Platform r8 = okhttp3.internal.platform.Platform.get()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r2 = r8.getSelectedProtocol(r1)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x007f:
            r7.f7180f = r1     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            okio.Source r8 = okio.Okio.source((java.net.Socket) r1)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            okio.BufferedSource r8 = okio.Okio.buffer((okio.Source) r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r7.f7184j = r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.net.Socket r8 = r7.f7180f     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            okio.Sink r8 = okio.Okio.sink((java.net.Socket) r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            okio.BufferedSink r8 = okio.Okio.buffer((okio.Sink) r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r7.f7185k = r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r7.f7181g = r4     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r2 == 0) goto L_0x00a0
            okhttp3.Protocol r8 = okhttp3.Protocol.get(r2)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            goto L_0x00a2
        L_0x00a0:
            okhttp3.Protocol r8 = okhttp3.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x00a2:
            r7.f7182h = r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            if (r1 == 0) goto L_0x00ad
            okhttp3.internal.platform.Platform r8 = okhttp3.internal.platform.Platform.get()
            r8.afterHandshake(r1)
        L_0x00ad:
            return
        L_0x00ae:
            java.util.List r8 = r4.peerCertificates()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.StringBuilder r3 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.<init>()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r4 = "Hostname "
            r3.append(r4)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            okhttp3.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = okhttp3.CertificatePinner.pin(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = "\n    DN: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r3.append(r0)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.util.List r8 = okhttp3.internal.tls.OkHostnameVerifier.allSubjectAltNames(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r3.append(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            java.lang.String r8 = r3.toString()     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
            throw r2     // Catch:{ AssertionError -> 0x0103, all -> 0x0100 }
        L_0x0100:
            r8 = move-exception
            r2 = r1
            goto L_0x0116
        L_0x0103:
            r8 = move-exception
            r2 = r1
            goto L_0x0109
        L_0x0106:
            r8 = move-exception
            goto L_0x0116
        L_0x0108:
            r8 = move-exception
        L_0x0109:
            boolean r0 = okhttp3.internal.C3000Util.isAndroidGetsocknameError(r8)     // Catch:{ all -> 0x0106 }
            if (r0 == 0) goto L_0x0115
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x0106 }
            r0.<init>(r8)     // Catch:{ all -> 0x0106 }
            throw r0     // Catch:{ all -> 0x0106 }
        L_0x0115:
            throw r8     // Catch:{ all -> 0x0106 }
        L_0x0116:
            if (r2 == 0) goto L_0x011f
            okhttp3.internal.platform.Platform r0 = okhttp3.internal.platform.Platform.get()
            r0.afterHandshake(r2)
        L_0x011f:
            okhttp3.internal.C3000Util.closeQuietly((java.net.Socket) r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.connection.RealConnection.m6810a(okhttp3.internal.connection.ConnectionSpecSelector):void");
    }

    /* renamed from: a */
    private Request m6806a(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + C3000Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec((OkHttpClient) null, (StreamAllocation) null, this.f7184j, this.f7185k);
            this.f7184j.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.f7185k.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1Codec.writeRequest(request.headers(), str);
            http1Codec.finishRequest();
            Response build = http1Codec.readResponseHeaders(false).request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
            C3000Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.f7178d.address().proxyAuthenticator().authenticate(this.f7178d, build);
                    if (authenticate == null) {
                        throw new IOException("Failed to authenticate with proxy");
                    } else if ("close".equalsIgnoreCase(build.header(com.google.common.net.HttpHeaders.CONNECTION))) {
                        return authenticate;
                    } else {
                        request = authenticate;
                    }
                } else {
                    throw new IOException("Unexpected response code for CONNECT: " + build.code());
                }
            } else if (this.f7184j.buffer().exhausted() && this.f7185k.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    /* renamed from: a */
    private Request m6805a() throws IOException {
        Request build = new Request.Builder().url(this.f7178d.address().url()).method("CONNECT", (RequestBody) null).header(com.google.common.net.HttpHeaders.HOST, C3000Util.hostHeader(this.f7178d.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", Version.userAgent()).build();
        Request authenticate = this.f7178d.address().proxyAuthenticator().authenticate(this.f7178d, new Response.Builder().request(build).protocol(Protocol.HTTP_1_1).code(407).message("Preemptive Authenticate").body(C3000Util.EMPTY_RESPONSE).sentRequestAtMillis(-1).receivedResponseAtMillis(-1).header(com.google.common.net.HttpHeaders.PROXY_AUTHENTICATE, "OkHttp-Preemptive").build());
        return authenticate != null ? authenticate : build;
    }

    public boolean isEligible(Address address, @Nullable Route route) {
        if (this.allocations.size() >= this.allocationLimit || this.noNewStreams || !Internal.instance.equalsNonHost(this.f7178d.address(), address)) {
            return false;
        }
        if (address.url().host().equals(route().address().url().host())) {
            return true;
        }
        if (this.f7183i == null || route == null || route.proxy().type() != Proxy.Type.DIRECT || this.f7178d.proxy().type() != Proxy.Type.DIRECT || !this.f7178d.socketAddress().equals(route.socketAddress()) || route.address().hostnameVerifier() != OkHostnameVerifier.INSTANCE || !supportsUrl(address.url())) {
            return false;
        }
        try {
            address.certificatePinner().check(address.url().host(), handshake().peerCertificates());
            return true;
        } catch (SSLPeerUnverifiedException unused) {
            return false;
        }
    }

    public boolean supportsUrl(HttpUrl httpUrl) {
        if (httpUrl.port() != this.f7178d.address().url().port()) {
            return false;
        }
        if (httpUrl.host().equals(this.f7178d.address().url().host())) {
            return true;
        }
        if (this.f7181g == null || !OkHostnameVerifier.INSTANCE.verify(httpUrl.host(), (X509Certificate) this.f7181g.peerCertificates().get(0))) {
            return false;
        }
        return true;
    }

    public HttpCodec newCodec(OkHttpClient okHttpClient, Interceptor.Chain chain, StreamAllocation streamAllocation) throws SocketException {
        Http2Connection http2Connection = this.f7183i;
        if (http2Connection != null) {
            return new Http2Codec(okHttpClient, chain, streamAllocation, http2Connection);
        }
        this.f7180f.setSoTimeout(chain.readTimeoutMillis());
        this.f7184j.timeout().timeout((long) chain.readTimeoutMillis(), TimeUnit.MILLISECONDS);
        this.f7185k.timeout().timeout((long) chain.writeTimeoutMillis(), TimeUnit.MILLISECONDS);
        return new Http1Codec(okHttpClient, streamAllocation, this.f7184j, this.f7185k);
    }

    public RealWebSocket.Streams newWebSocketStreams(StreamAllocation streamAllocation) {
        final StreamAllocation streamAllocation2 = streamAllocation;
        return new RealWebSocket.Streams(true, this.f7184j, this.f7185k) {
            public void close() throws IOException {
                StreamAllocation streamAllocation = streamAllocation2;
                streamAllocation.streamFinished(true, streamAllocation.codec(), -1, (IOException) null);
            }
        };
    }

    public Route route() {
        return this.f7178d;
    }

    public void cancel() {
        C3000Util.closeQuietly(this.f7179e);
    }

    public Socket socket() {
        return this.f7180f;
    }

    public boolean isHealthy(boolean z) {
        int soTimeout;
        if (this.f7180f.isClosed() || this.f7180f.isInputShutdown() || this.f7180f.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f7183i;
        if (http2Connection != null) {
            return !http2Connection.isShutdown();
        }
        if (z) {
            try {
                soTimeout = this.f7180f.getSoTimeout();
                this.f7180f.setSoTimeout(1);
                if (this.f7184j.exhausted()) {
                    this.f7180f.setSoTimeout(soTimeout);
                    return false;
                }
                this.f7180f.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f7180f.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    public void onSettings(Http2Connection http2Connection) {
        synchronized (this.f7177c) {
            this.allocationLimit = http2Connection.maxConcurrentStreams();
        }
    }

    public Handshake handshake() {
        return this.f7181g;
    }

    public boolean isMultiplexed() {
        return this.f7183i != null;
    }

    public Protocol protocol() {
        return this.f7182h;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f7178d.address().url().host());
        sb.append(":");
        sb.append(this.f7178d.address().url().port());
        sb.append(", proxy=");
        sb.append(this.f7178d.proxy());
        sb.append(" hostAddress=");
        sb.append(this.f7178d.socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f7181g;
        sb.append(handshake != null ? handshake.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.f7182h);
        sb.append('}');
        return sb.toString();
    }
}
