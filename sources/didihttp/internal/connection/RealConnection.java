package didihttp.internal.connection;

import didihttp.Address;
import didihttp.Call;
import didihttp.Connection;
import didihttp.ConnectionPool;
import didihttp.DidiHttpClient;
import didihttp.Handshake;
import didihttp.HttpUrl;
import didihttp.LogEventListener;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.Response;
import didihttp.Route;
import didihttp.ServerCallItem;
import didihttp.internal.C21750Util;
import didihttp.internal.http.HttpCodec;
import didihttp.internal.http.HttpHeaders;
import didihttp.internal.http1.Http1Codec;
import didihttp.internal.http2.ErrorCode;
import didihttp.internal.http2.Http2Codec;
import didihttp.internal.http2.Http2Connection;
import didihttp.internal.http2.Http2Stream;
import didihttp.internal.p232ws.RealWebSocket;
import didihttp.internal.platform.Platform;
import java.io.Closeable;
import java.io.IOException;
import java.lang.ref.Reference;
import java.net.ConnectException;
import java.net.ProtocolException;
import java.net.Proxy;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.channels.Selector;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class RealConnection extends Http2Connection.Listener implements Connection {

    /* renamed from: a */
    private final ConnectionPool f59424a;
    public int allocationLimit = 1;
    public final List<Reference<StreamAllocation>> allocations = new ArrayList();

    /* renamed from: b */
    private final Route f59425b;

    /* renamed from: c */
    private RouteSelector f59426c;

    /* renamed from: d */
    private Socket f59427d;

    /* renamed from: e */
    private Socket f59428e;

    /* renamed from: f */
    private Handshake f59429f;

    /* renamed from: g */
    private Protocol f59430g;

    /* renamed from: h */
    private Http2Connection f59431h;

    /* renamed from: i */
    private BufferedSource f59432i;
    public long idleAtNanos = Long.MAX_VALUE;

    /* renamed from: j */
    private BufferedSink f59433j;

    /* renamed from: k */
    private FlowSource f59434k;

    /* renamed from: l */
    private FlowSink f59435l;
    public boolean noNewStreams;
    public int successCount;

    public RealConnection(ConnectionPool connectionPool, Route route) {
        this.f59424a = connectionPool;
        this.f59425b = route;
    }

    public RealConnection(ConnectionPool connectionPool, Route route, RouteSelector routeSelector) {
        this.f59424a = connectionPool;
        this.f59425b = route;
        this.f59426c = routeSelector;
    }

    public static RealConnection testConnection(ConnectionPool connectionPool, Route route, Socket socket, long j) {
        RealConnection realConnection = new RealConnection(connectionPool, route);
        realConnection.f59428e = socket;
        realConnection.idleAtNanos = j;
        return realConnection;
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x008c A[Catch:{ IOException -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x0090 A[Catch:{ IOException -> 0x00c0 }] */
    /* JADX WARNING: Removed duplicated region for block: B:23:0x00ad  */
    /* JADX WARNING: Removed duplicated region for block: B:48:? A[ORIG_RETURN, RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void connect(int r15, int r16, int r17, boolean r18, didihttp.ServerCallItem r19, didihttp.Call r20, didihttp.LogEventListener r21) {
        /*
            r14 = this;
            r1 = r14
            r8 = r20
            r9 = r21
            didihttp.Protocol r0 = r1.f59430g
            if (r0 != 0) goto L_0x0107
            didihttp.Route r0 = r1.f59425b
            didihttp.Address r0 = r0.address()
            java.util.List r0 = r0.connectionSpecs()
            didihttp.internal.connection.ConnectionSpecSelector r10 = new didihttp.internal.connection.ConnectionSpecSelector
            r10.<init>(r0)
            didihttp.Route r2 = r1.f59425b
            didihttp.Address r2 = r2.address()
            javax.net.ssl.SSLSocketFactory r2 = r2.sslSocketFactory()
            if (r2 != 0) goto L_0x0073
            didihttp.ConnectionSpec r2 = didihttp.ConnectionSpec.CLEARTEXT
            boolean r0 = r0.contains(r2)
            if (r0 == 0) goto L_0x0066
            didihttp.Route r0 = r1.f59425b
            didihttp.Address r0 = r0.address()
            didihttp.HttpUrl r0 = r0.url()
            java.lang.String r0 = r0.host()
            didihttp.internal.platform.Platform r2 = didihttp.internal.platform.Platform.get()
            boolean r2 = r2.isCleartextTrafficPermitted(r0)
            if (r2 == 0) goto L_0x0045
            goto L_0x0073
        L_0x0045:
            didihttp.internal.connection.RouteException r2 = new didihttp.internal.connection.RouteException
            java.net.UnknownServiceException r3 = new java.net.UnknownServiceException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r5 = "CLEARTEXT communication to "
            r4.append(r5)
            r4.append(r0)
            java.lang.String r0 = " not permitted by network security policy"
            r4.append(r0)
            java.lang.String r0 = r4.toString()
            r3.<init>(r0)
            r2.<init>(r3)
            throw r2
        L_0x0066:
            didihttp.internal.connection.RouteException r0 = new didihttp.internal.connection.RouteException
            java.net.UnknownServiceException r2 = new java.net.UnknownServiceException
            java.lang.String r3 = "CLEARTEXT communication not enabled for client"
            r2.<init>(r3)
            r0.<init>(r2)
            throw r0
        L_0x0073:
            r11 = 0
            r12 = r11
        L_0x0075:
            didihttp.Route r0 = r1.f59425b     // Catch:{ IOException -> 0x00c0 }
            java.net.InetSocketAddress r0 = r0.socketAddress()     // Catch:{ IOException -> 0x00c0 }
            didihttp.Route r2 = r1.f59425b     // Catch:{ IOException -> 0x00c0 }
            java.net.Proxy r2 = r2.proxy()     // Catch:{ IOException -> 0x00c0 }
            r9.connectStart(r8, r0, r2)     // Catch:{ IOException -> 0x00c0 }
            didihttp.Route r0 = r1.f59425b     // Catch:{ IOException -> 0x00c0 }
            boolean r0 = r0.requiresTunnel()     // Catch:{ IOException -> 0x00c0 }
            if (r0 == 0) goto L_0x0090
            r14.m44802a(r15, r16, r17)     // Catch:{ IOException -> 0x00c0 }
            goto L_0x0093
        L_0x0090:
            r14.m44807b(r15, r16)     // Catch:{ IOException -> 0x00c0 }
        L_0x0093:
            r13 = r19
            r14.m44804a((didihttp.internal.connection.ConnectionSpecSelector) r10, (didihttp.ServerCallItem) r13, (didihttp.Call) r8, (didihttp.LogEventListener) r9)     // Catch:{ IOException -> 0x00be }
            didihttp.Route r0 = r1.f59425b     // Catch:{ IOException -> 0x00be }
            java.net.InetSocketAddress r0 = r0.socketAddress()     // Catch:{ IOException -> 0x00be }
            didihttp.Route r2 = r1.f59425b     // Catch:{ IOException -> 0x00be }
            java.net.Proxy r2 = r2.proxy()     // Catch:{ IOException -> 0x00be }
            didihttp.Protocol r3 = r1.f59430g     // Catch:{ IOException -> 0x00be }
            r9.connectEnd(r8, r0, r2, r3)     // Catch:{ IOException -> 0x00be }
            didihttp.internal.http2.Http2Connection r0 = r1.f59431h
            if (r0 == 0) goto L_0x00bd
            didihttp.ConnectionPool r2 = r1.f59424a
            monitor-enter(r2)
            didihttp.internal.http2.Http2Connection r0 = r1.f59431h     // Catch:{ all -> 0x00ba }
            int r0 = r0.maxConcurrentStreams()     // Catch:{ all -> 0x00ba }
            r1.allocationLimit = r0     // Catch:{ all -> 0x00ba }
            monitor-exit(r2)     // Catch:{ all -> 0x00ba }
            goto L_0x00bd
        L_0x00ba:
            r0 = move-exception
            monitor-exit(r2)     // Catch:{ all -> 0x00ba }
            throw r0
        L_0x00bd:
            return
        L_0x00be:
            r0 = move-exception
            goto L_0x00c3
        L_0x00c0:
            r0 = move-exception
            r13 = r19
        L_0x00c3:
            java.net.Socket r2 = r1.f59428e
            m44805a((java.lang.Object) r2)
            java.net.Socket r2 = r1.f59427d
            m44805a((java.lang.Object) r2)
            r1.f59428e = r11
            r1.f59427d = r11
            r1.f59432i = r11
            r1.f59433j = r11
            r1.f59429f = r11
            r1.f59430g = r11
            r1.f59431h = r11
            didihttp.Route r2 = r1.f59425b
            java.net.InetSocketAddress r4 = r2.socketAddress()
            didihttp.Route r2 = r1.f59425b
            java.net.Proxy r5 = r2.proxy()
            didihttp.Protocol r6 = r1.f59430g
            r2 = r21
            r3 = r20
            r7 = r0
            r2.connectFail(r3, r4, r5, r6, r7)
            if (r12 != 0) goto L_0x00f9
            didihttp.internal.connection.RouteException r12 = new didihttp.internal.connection.RouteException
            r12.<init>(r0)
            goto L_0x00fc
        L_0x00f9:
            r12.addConnectException(r0)
        L_0x00fc:
            if (r18 == 0) goto L_0x0106
            boolean r0 = r10.connectionFailed(r0)
            if (r0 == 0) goto L_0x0106
            goto L_0x0075
        L_0x0106:
            throw r12
        L_0x0107:
            java.lang.IllegalStateException r0 = new java.lang.IllegalStateException
            java.lang.String r2 = "already connected"
            r0.<init>(r2)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.connection.RealConnection.connect(int, int, int, boolean, didihttp.ServerCallItem, didihttp.Call, didihttp.LogEventListener):void");
    }

    /* renamed from: a */
    private void m44802a(int i, int i2, int i3) throws IOException {
        Request a = m44799a();
        HttpUrl url = a.url();
        int i4 = 0;
        while (true) {
            i4++;
            if (i4 <= 21) {
                m44807b(i, i2);
                a = m44800a(i2, i3, a, url);
                if (a != null) {
                    m44805a((Object) this.f59427d);
                    this.f59427d = null;
                    this.f59433j = null;
                    this.f59432i = null;
                } else {
                    return;
                }
            } else {
                throw new ProtocolException("Too many tunnel connections attempted: " + 21);
            }
        }
    }

    /* renamed from: a */
    private void m44801a(int i, int i2) throws IOException {
        Proxy proxy = this.f59425b.proxy();
        Socket createSocket = (proxy.type() == Proxy.Type.DIRECT || proxy.type() == Proxy.Type.HTTP) ? this.f59425b.address().socketFactory().createSocket() : new Socket(proxy);
        this.f59427d = createSocket;
        createSocket.setSoTimeout(i2);
        try {
            Platform.get().connectSocket(this.f59427d, this.f59425b.socketAddress(), i);
            m44806a(this.f59427d);
        } catch (ConnectException e) {
            ConnectException connectException = new ConnectException("Failed to connect to " + this.f59425b.socketAddress());
            connectException.initCause(e);
            throw connectException;
        }
    }

    /*  JADX ERROR: StackOverflow in pass: MarkFinallyVisitor
        jadx.core.utils.exceptions.JadxOverflowException: 
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:47)
        	at jadx.core.utils.ErrorsCounter.methodError(ErrorsCounter.java:81)
        */
    /* renamed from: b */
    private void m44807b(int r20, int r21) throws java.io.IOException {
        /*
            r19 = this;
            r1 = r19
            didihttp.Route r0 = r1.f59425b
            java.net.Proxy r0 = r0.proxy()
            didinet.NetEngine r2 = didinet.NetEngine.getInstance()
            didinet.NetConfig r2 = r2.getNetConfig()
            boolean r3 = r2.usePositiveConnection()
            if (r3 == 0) goto L_0x01dd
            java.net.Proxy$Type r3 = r0.type()
            java.net.Proxy$Type r4 = java.net.Proxy.Type.DIRECT
            if (r3 == r4) goto L_0x0028
            java.net.Proxy$Type r0 = r0.type()
            java.net.Proxy$Type r3 = java.net.Proxy.Type.HTTP
            if (r0 == r3) goto L_0x0028
            goto L_0x01dd
        L_0x0028:
            java.nio.channels.Selector r3 = java.nio.channels.Selector.open()
            java.util.LinkedList r4 = new java.util.LinkedList
            r4.<init>()
            java.util.LinkedList r5 = new java.util.LinkedList
            r5.<init>()
            didihttp.Route r0 = r1.f59425b
            int r2 = r2.getRetryTimeout()
            r6 = r20
            if (r2 > r6) goto L_0x0041
            goto L_0x0042
        L_0x0041:
            r2 = r6
        L_0x0042:
            long r6 = (long) r2
            long r8 = android.os.SystemClock.uptimeMillis()
            r10 = r6
            r12 = 0
        L_0x0049:
            java.lang.String r13 = "conn"
            if (r0 == 0) goto L_0x0099
            java.nio.channels.SocketChannel r14 = java.nio.channels.SocketChannel.open()     // Catch:{ all -> 0x0096 }
            r4.add(r14)     // Catch:{ all -> 0x0096 }
            r15 = 0
            r14.configureBlocking(r15)     // Catch:{ all -> 0x0096 }
            java.net.InetSocketAddress r0 = r0.socketAddress()     // Catch:{ all -> 0x0096 }
            r5.add(r0)     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r15 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r15.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = "try to connect to "
            r15.append(r2)     // Catch:{ all -> 0x0096 }
            r15.append(r14)     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = r15.toString()     // Catch:{ all -> 0x0096 }
            didinet.Logger.m45047d(r13, r2)     // Catch:{ all -> 0x0096 }
            boolean r0 = r14.connect(r0)     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x008f
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r0.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r2 = "Async connect success "
            r0.append(r2)     // Catch:{ all -> 0x0096 }
            r0.append(r14)     // Catch:{ all -> 0x0096 }
            java.lang.String r0 = r0.toString()     // Catch:{ all -> 0x0096 }
            didinet.Logger.m45047d(r13, r0)     // Catch:{ all -> 0x0096 }
            goto L_0x0169
        L_0x008f:
            r0 = 8
            r14.register(r3, r0)     // Catch:{ all -> 0x0096 }
            r2 = 0
            goto L_0x009a
        L_0x0096:
            r0 = move-exception
            goto L_0x01c0
        L_0x0099:
            r2 = r0
        L_0x009a:
            java.lang.String r0 = "start to select"
            didinet.Logger.m45047d(r13, r0)     // Catch:{ all -> 0x0096 }
            int r0 = r3.select(r10)     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r14 = new java.lang.StringBuilder     // Catch:{ all -> 0x0096 }
            r14.<init>()     // Catch:{ all -> 0x0096 }
            java.lang.String r15 = "ret -> "
            r14.append(r15)     // Catch:{ all -> 0x0096 }
            r14.append(r0)     // Catch:{ all -> 0x0096 }
            java.lang.String r14 = r14.toString()     // Catch:{ all -> 0x0096 }
            didinet.Logger.m45047d(r13, r14)     // Catch:{ all -> 0x0096 }
            if (r0 <= 0) goto L_0x0136
            java.util.Set r0 = r3.selectedKeys()     // Catch:{ all -> 0x0096 }
            java.util.Iterator r14 = r0.iterator()     // Catch:{ all -> 0x0096 }
        L_0x00c1:
            boolean r0 = r14.hasNext()     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x012f
            java.lang.Object r0 = r14.next()     // Catch:{ all -> 0x0096 }
            r15 = r0
            java.nio.channels.SelectionKey r15 = (java.nio.channels.SelectionKey) r15     // Catch:{ all -> 0x0096 }
            boolean r0 = r15.isConnectable()     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0123
            java.nio.channels.SelectableChannel r0 = r15.channel()     // Catch:{ all -> 0x0096 }
            r16 = r2
            r2 = r0
            java.nio.channels.SocketChannel r2 = (java.nio.channels.SocketChannel) r2     // Catch:{ all -> 0x0096 }
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x0111 }
            r0.<init>()     // Catch:{ IOException -> 0x0111 }
            r17 = r6
            java.lang.String r6 = "start to finishConnect -> "
            r0.append(r6)     // Catch:{ IOException -> 0x010f }
            r0.append(r2)     // Catch:{ IOException -> 0x010f }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x010f }
            didinet.Logger.m45047d(r13, r0)     // Catch:{ IOException -> 0x010f }
            boolean r0 = r2.finishConnect()     // Catch:{ IOException -> 0x010f }
            if (r0 == 0) goto L_0x0127
            java.lang.StringBuilder r0 = new java.lang.StringBuilder     // Catch:{ IOException -> 0x010f }
            r0.<init>()     // Catch:{ IOException -> 0x010f }
            java.lang.String r6 = "success to call finishConnect "
            r0.append(r6)     // Catch:{ IOException -> 0x010f }
            r0.append(r2)     // Catch:{ IOException -> 0x010f }
            java.lang.String r0 = r0.toString()     // Catch:{ IOException -> 0x010f }
            didinet.Logger.m45047d(r13, r0)     // Catch:{ IOException -> 0x010f }
            r12 = r2
            goto L_0x0133
        L_0x010f:
            r0 = move-exception
            goto L_0x0114
        L_0x0111:
            r0 = move-exception
            r17 = r6
        L_0x0114:
            java.lang.String r6 = ""
            didinet.Logger.m45048d(r13, r6, r0)     // Catch:{ all -> 0x0096 }
            r15.cancel()     // Catch:{ all -> 0x0096 }
            r4.remove(r2)     // Catch:{ all -> 0x0096 }
            m44805a((java.lang.Object) r2)     // Catch:{ all -> 0x0096 }
            goto L_0x0127
        L_0x0123:
            r16 = r2
            r17 = r6
        L_0x0127:
            r14.remove()     // Catch:{ all -> 0x0096 }
            r2 = r16
            r6 = r17
            goto L_0x00c1
        L_0x012f:
            r16 = r2
            r17 = r6
        L_0x0133:
            if (r12 == 0) goto L_0x013a
            goto L_0x0168
        L_0x0136:
            r16 = r2
            r17 = r6
        L_0x013a:
            long r6 = android.os.SystemClock.uptimeMillis()     // Catch:{ all -> 0x0096 }
            long r8 = r6 - r8
            long r10 = r10 - r8
            r8 = 0
            int r0 = (r10 > r8 ? 1 : (r10 == r8 ? 0 : -1))
            if (r0 <= 0) goto L_0x0153
            boolean r0 = r4.isEmpty()     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x014e
            goto L_0x0153
        L_0x014e:
            r8 = r21
            r0 = r16
            goto L_0x01bb
        L_0x0153:
            didihttp.internal.connection.RouteSelector r0 = r1.f59426c     // Catch:{ all -> 0x0096 }
            boolean r0 = r0.hasNext()     // Catch:{ all -> 0x0096 }
            if (r0 == 0) goto L_0x0164
            didihttp.internal.connection.RouteSelector r0 = r1.f59426c     // Catch:{ all -> 0x0096 }
            didihttp.Route r2 = r0.tryNext()     // Catch:{ all -> 0x0096 }
            r10 = r17
            goto L_0x0166
        L_0x0164:
            r2 = r16
        L_0x0166:
            if (r2 != 0) goto L_0x01b8
        L_0x0168:
            r14 = r12
        L_0x0169:
            m44805a((java.lang.Object) r3)
            java.util.Iterator r0 = r4.iterator()
        L_0x0170:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0182
            java.lang.Object r2 = r0.next()
            java.nio.channels.SocketChannel r2 = (java.nio.channels.SocketChannel) r2
            if (r2 == r14) goto L_0x0170
            m44805a((java.lang.Object) r2)
            goto L_0x0170
        L_0x0182:
            r4.clear()
            if (r14 == 0) goto L_0x019c
            r0 = 1
            r14.configureBlocking(r0)
            java.net.Socket r0 = r14.socket()
            r1.f59427d = r0
            r8 = r21
            r0.setSoTimeout(r8)
            java.net.Socket r0 = r1.f59427d
            r1.m44806a((java.net.Socket) r0)
            return
        L_0x019c:
            didihttp.internal.connection.RouteExException r0 = new didihttp.internal.connection.RouteExException
            java.net.SocketException r2 = new java.net.SocketException
            java.lang.StringBuilder r3 = new java.lang.StringBuilder
            r3.<init>()
            java.lang.String r4 = "Failed to connect to "
            r3.append(r4)
            r3.append(r5)
            java.lang.String r3 = r3.toString()
            r2.<init>(r3)
            r0.<init>(r2)
            throw r0
        L_0x01b8:
            r8 = r21
            r0 = r2
        L_0x01bb:
            r8 = r6
            r6 = r17
            goto L_0x0049
        L_0x01c0:
            m44805a((java.lang.Object) r3)
            java.util.Iterator r2 = r4.iterator()
        L_0x01c7:
            boolean r3 = r2.hasNext()
            if (r3 == 0) goto L_0x01d9
            java.lang.Object r3 = r2.next()
            java.nio.channels.SocketChannel r3 = (java.nio.channels.SocketChannel) r3
            if (r3 == r12) goto L_0x01c7
            m44805a((java.lang.Object) r3)
            goto L_0x01c7
        L_0x01d9:
            r4.clear()
            throw r0
        L_0x01dd:
            r6 = r20
            r8 = r21
            r19.m44801a(r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.connection.RealConnection.m44807b(int, int):void");
    }

    /* renamed from: a */
    private static void m44805a(Object obj) {
        try {
            if (obj instanceof Selector) {
                ((Selector) obj).close();
            } else if (obj instanceof Closeable) {
                ((Closeable) obj).close();
            }
        } catch (IOException unused) {
        }
    }

    /* renamed from: a */
    private void m44804a(ConnectionSpecSelector connectionSpecSelector, ServerCallItem serverCallItem, Call call, LogEventListener logEventListener) throws IOException {
        if (this.f59425b.address().sslSocketFactory() == null) {
            this.f59430g = Protocol.HTTP_1_1;
            this.f59428e = this.f59427d;
            return;
        }
        serverCallItem.traceHandShakeStart();
        logEventListener.tlsConnectStart(call);
        m44803a(connectionSpecSelector);
        logEventListener.tlsConnectEnd(call, this.f59429f);
        serverCallItem.traceHandShakeEnd();
        if (this.f59430g == Protocol.HTTP_2) {
            this.f59428e.setSoTimeout(0);
            Http2Connection build = new Http2Connection.Builder(true).socket(this.f59428e, this.f59425b.address().url().hostAndPath(), this.f59432i, this.f59433j).listener(this).build();
            this.f59431h = build;
            build.start();
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v0, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v2, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v3, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v4, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v5, resolved type: java.lang.String} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v11, resolved type: javax.net.ssl.SSLSocket} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v12, resolved type: java.lang.String} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x0135 A[Catch:{ all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x013b A[Catch:{ all -> 0x012c }] */
    /* JADX WARNING: Removed duplicated region for block: B:52:0x013e  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m44803a(didihttp.internal.connection.ConnectionSpecSelector r8) throws java.io.IOException {
        /*
            r7 = this;
            didihttp.Route r0 = r7.f59425b
            didihttp.Address r0 = r0.address()
            javax.net.ssl.SSLSocketFactory r1 = r0.sslSocketFactory()
            r2 = 0
            java.net.Socket r3 = r7.f59427d     // Catch:{ AssertionError -> 0x012e }
            didihttp.HttpUrl r4 = r0.url()     // Catch:{ AssertionError -> 0x012e }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x012e }
            didihttp.HttpUrl r5 = r0.url()     // Catch:{ AssertionError -> 0x012e }
            int r5 = r5.port()     // Catch:{ AssertionError -> 0x012e }
            r6 = 1
            java.net.Socket r1 = r1.createSocket(r3, r4, r5, r6)     // Catch:{ AssertionError -> 0x012e }
            javax.net.ssl.SSLSocket r1 = (javax.net.ssl.SSLSocket) r1     // Catch:{ AssertionError -> 0x012e }
            didihttp.ConnectionSpec r8 = r8.configureSecureSocket(r1)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            boolean r3 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            if (r3 == 0) goto L_0x0041
            didihttp.internal.platform.Platform r3 = didihttp.internal.platform.Platform.get()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            didihttp.HttpUrl r4 = r0.url()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r4 = r4.host()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.util.List r5 = r0.protocols()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r3.configureTlsExtensions(r1, r4, r5)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x0041:
            r1.startHandshake()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            javax.net.ssl.SSLSession r3 = r1.getSession()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            if (r3 == 0) goto L_0x011e
            didihttp.Handshake r4 = didihttp.Handshake.get(r3)     // Catch:{ NullPointerException -> 0x0117 }
            javax.net.ssl.HostnameVerifier r5 = r0.hostnameVerifier()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            didihttp.HttpUrl r6 = r0.url()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r6 = r6.host()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            boolean r3 = r5.verify(r6, r3)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            if (r3 != 0) goto L_0x00da
            java.util.List r8 = r4.peerCertificates()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            boolean r2 = r8.isEmpty()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r3 = "Hostname "
            if (r2 != 0) goto L_0x00b8
            r2 = 0
            java.lang.Object r8 = r8.get(r2)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.security.cert.X509Certificate r8 = (java.security.cert.X509Certificate) r8     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            javax.net.ssl.SSLPeerUnverifiedException r2 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.<init>()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.append(r3)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            didihttp.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = " not verified:\n    certificate: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = didihttp.CertificatePinner.pin(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = "\n    DN: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.security.Principal r0 = r8.getSubjectDN()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = r0.getName()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = "\n    subjectAltNames: "
            r4.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.util.List r8 = didihttp.internal.tls.OkHostnameVerifier.allSubjectAltNames(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r4.append(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r8 = r4.toString()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r2.<init>(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            throw r2     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x00b8:
            javax.net.ssl.SSLPeerUnverifiedException r8 = new javax.net.ssl.SSLPeerUnverifiedException     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r2.<init>()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r2.append(r3)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            didihttp.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r2.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = " not verified (no certificates)"
            r2.append(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = r2.toString()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r8.<init>(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            throw r8     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x00da:
            didihttp.CertificatePinner r3 = r0.certificatePinner()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            didihttp.HttpUrl r0 = r0.url()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = r0.host()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.util.List r5 = r4.peerCertificates()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r3.check((java.lang.String) r0, (java.util.List<java.security.cert.Certificate>) r5)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            boolean r8 = r8.supportsTlsExtensions()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            if (r8 == 0) goto L_0x00fb
            didihttp.internal.platform.Platform r8 = didihttp.internal.platform.Platform.get()     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r2 = r8.getSelectedProtocol(r1)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x00fb:
            r7.f59428e = r1     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r7.m44806a((java.net.Socket) r1)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r7.f59429f = r4     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            if (r2 == 0) goto L_0x0109
            didihttp.Protocol r8 = didihttp.Protocol.get(r2)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            goto L_0x010b
        L_0x0109:
            didihttp.Protocol r8 = didihttp.Protocol.HTTP_1_1     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x010b:
            r7.f59430g = r8     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            if (r1 == 0) goto L_0x0116
            didihttp.internal.platform.Platform r8 = didihttp.internal.platform.Platform.get()
            r8.afterHandshake(r1)
        L_0x0116:
            return
        L_0x0117:
            r8 = move-exception
            java.io.IOException r0 = new java.io.IOException     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            r0.<init>(r8)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            throw r0     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x011e:
            java.io.IOException r8 = new java.io.IOException     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            java.lang.String r0 = "SSLSession is null"
            r8.<init>(r0)     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
            throw r8     // Catch:{ AssertionError -> 0x0129, all -> 0x0126 }
        L_0x0126:
            r8 = move-exception
            r2 = r1
            goto L_0x013c
        L_0x0129:
            r8 = move-exception
            r2 = r1
            goto L_0x012f
        L_0x012c:
            r8 = move-exception
            goto L_0x013c
        L_0x012e:
            r8 = move-exception
        L_0x012f:
            boolean r0 = didihttp.internal.C21750Util.isAndroidGetsocknameError(r8)     // Catch:{ all -> 0x012c }
            if (r0 == 0) goto L_0x013b
            java.io.IOException r0 = new java.io.IOException     // Catch:{ all -> 0x012c }
            r0.<init>(r8)     // Catch:{ all -> 0x012c }
            throw r0     // Catch:{ all -> 0x012c }
        L_0x013b:
            throw r8     // Catch:{ all -> 0x012c }
        L_0x013c:
            if (r2 == 0) goto L_0x0145
            didihttp.internal.platform.Platform r0 = didihttp.internal.platform.Platform.get()
            r0.afterHandshake(r2)
        L_0x0145:
            m44805a((java.lang.Object) r2)
            throw r8
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.connection.RealConnection.m44803a(didihttp.internal.connection.ConnectionSpecSelector):void");
    }

    /* renamed from: a */
    private Request m44800a(int i, int i2, Request request, HttpUrl httpUrl) throws IOException {
        String str = "CONNECT " + C21750Util.hostHeader(httpUrl, true) + " HTTP/1.1";
        while (true) {
            Http1Codec http1Codec = new Http1Codec((DidiHttpClient) null, (StreamAllocation) null, this.f59432i, this.f59433j);
            this.f59432i.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
            this.f59433j.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
            http1Codec.writeRequest(request.headers(), str);
            http1Codec.finishRequest();
            Response build = http1Codec.readResponseHeaders(false).request(request).build();
            long contentLength = HttpHeaders.contentLength(build);
            if (contentLength == -1) {
                contentLength = 0;
            }
            Source newFixedLengthSource = http1Codec.newFixedLengthSource(contentLength);
            C21750Util.skipAll(newFixedLengthSource, Integer.MAX_VALUE, TimeUnit.MILLISECONDS);
            newFixedLengthSource.close();
            int code = build.code();
            if (code != 200) {
                if (code == 407) {
                    Request authenticate = this.f59425b.address().proxyAuthenticator().authenticate(this.f59425b, build);
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
            } else if (this.f59432i.buffer().exhausted() && this.f59433j.buffer().exhausted()) {
                return null;
            } else {
                throw new IOException("TLS tunnel buffered too many bytes!");
            }
        }
    }

    /* renamed from: a */
    private Request m44799a() {
        return new Request.Builder().url(this.f59425b.address().url()).header(com.google.common.net.HttpHeaders.HOST, C21750Util.hostHeader(this.f59425b.address().url(), true)).header("Proxy-Connection", "Keep-Alive").header("User-Agent", "didihttp").build();
    }

    /* renamed from: a */
    private void m44806a(Socket socket) throws IOException {
        FlowSource flowSource = new FlowSource(Okio.source(socket));
        this.f59434k = flowSource;
        this.f59432i = Okio.buffer((Source) flowSource);
        FlowSink flowSink = new FlowSink(Okio.sink(socket));
        this.f59435l = flowSink;
        this.f59433j = Okio.buffer((Sink) flowSink);
    }

    public void resetFlowsStream() {
        FlowSource flowSource = this.f59434k;
        if (flowSource != null) {
            flowSource.reset();
        }
        FlowSink flowSink = this.f59435l;
        if (flowSink != null) {
            flowSink.reset();
        }
    }

    public long getSourceCount() {
        FlowSource flowSource = this.f59434k;
        if (flowSource != null) {
            return flowSource.getCount();
        }
        return -1;
    }

    public long getSinkCount() {
        FlowSink flowSink = this.f59435l;
        if (flowSink != null) {
            return flowSink.getCount();
        }
        return -1;
    }

    public boolean isEligible(Address address) {
        return this.allocations.size() < this.allocationLimit && address.equals(route().address()) && !this.noNewStreams;
    }

    public HttpCodec newCodec(DidiHttpClient didiHttpClient, StreamAllocation streamAllocation, int i, int i2) throws SocketException {
        Http2Connection http2Connection = this.f59431h;
        if (http2Connection != null) {
            return new Http2Codec(didiHttpClient, streamAllocation, http2Connection, i, i2);
        }
        this.f59428e.setSoTimeout(i);
        this.f59432i.timeout().timeout((long) i, TimeUnit.MILLISECONDS);
        this.f59433j.timeout().timeout((long) i2, TimeUnit.MILLISECONDS);
        return new Http1Codec(didiHttpClient, streamAllocation, this.f59432i, this.f59433j);
    }

    public RealWebSocket.Streams newWebSocketStreams(StreamAllocation streamAllocation) {
        final StreamAllocation streamAllocation2 = streamAllocation;
        return new RealWebSocket.Streams(true, this.f59432i, this.f59433j) {
            public void close() throws IOException {
                StreamAllocation streamAllocation = streamAllocation2;
                streamAllocation.streamFinished(true, streamAllocation.codec());
            }
        };
    }

    public Route route() {
        return this.f59425b;
    }

    public void cancel() {
        m44805a((Object) this.f59427d);
    }

    public Socket socket() {
        return this.f59428e;
    }

    public boolean isHealthy(boolean z) {
        int soTimeout;
        if (this.f59428e.isClosed() || this.f59428e.isInputShutdown() || this.f59428e.isOutputShutdown()) {
            return false;
        }
        Http2Connection http2Connection = this.f59431h;
        if (http2Connection != null) {
            return !http2Connection.isShutdown();
        }
        if (z) {
            try {
                soTimeout = this.f59428e.getSoTimeout();
                this.f59428e.setSoTimeout(1);
                if (this.f59432i.exhausted()) {
                    this.f59428e.setSoTimeout(soTimeout);
                    return false;
                }
                this.f59428e.setSoTimeout(soTimeout);
                return true;
            } catch (SocketTimeoutException unused) {
            } catch (IOException unused2) {
                return false;
            } catch (Throwable th) {
                this.f59428e.setSoTimeout(soTimeout);
                throw th;
            }
        }
        return true;
    }

    public void onStream(Http2Stream http2Stream) throws IOException {
        http2Stream.close(ErrorCode.REFUSED_STREAM);
    }

    public void onSettings(Http2Connection http2Connection) {
        synchronized (this.f59424a) {
            this.allocationLimit = http2Connection.maxConcurrentStreams();
        }
    }

    public Handshake handshake() {
        return this.f59429f;
    }

    public boolean isMultiplexed() {
        return this.f59431h != null;
    }

    public Protocol protocol() {
        return this.f59430g;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Connection{");
        sb.append(this.f59425b.address().url().host());
        sb.append(":");
        sb.append(this.f59425b.address().url().port());
        sb.append(", proxy=");
        sb.append(this.f59425b.proxy());
        sb.append(" hostAddress=");
        sb.append(this.f59425b.socketAddress());
        sb.append(" cipherSuite=");
        Handshake handshake = this.f59429f;
        sb.append(handshake != null ? handshake.cipherSuite() : "none");
        sb.append(" protocol=");
        sb.append(this.f59430g);
        sb.append('}');
        return sb.toString();
    }
}
