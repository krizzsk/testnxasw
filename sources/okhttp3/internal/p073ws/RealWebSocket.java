package okhttp3.internal.p073ws;

import com.didichuxing.diface.logger.DiFaceLogger;
import com.google.common.net.HttpHeaders;
import java.io.Closeable;
import java.io.IOException;
import java.net.ProtocolException;
import java.util.ArrayDeque;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ScheduledFuture;
import java.util.concurrent.ScheduledThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.EventListener;
import okhttp3.OkHttpClient;
import okhttp3.Protocol;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.WebSocket;
import okhttp3.WebSocketListener;
import okhttp3.internal.C3000Util;
import okhttp3.internal.Internal;
import okhttp3.internal.connection.StreamAllocation;
import okhttp3.internal.p073ws.WebSocketReader;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: okhttp3.internal.ws.RealWebSocket */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {

    /* renamed from: b */
    static final /* synthetic */ boolean f7396b = (!RealWebSocket.class.desiredAssertionStatus());

    /* renamed from: c */
    private static final List<Protocol> f7397c = Collections.singletonList(Protocol.HTTP_1_1);

    /* renamed from: d */
    private static final long f7398d = 16777216;

    /* renamed from: e */
    private static final long f7399e = 60000;

    /* renamed from: A */
    private boolean f7400A;

    /* renamed from: a */
    final WebSocketListener f7401a;

    /* renamed from: f */
    private final Request f7402f;

    /* renamed from: g */
    private final Random f7403g;

    /* renamed from: h */
    private final long f7404h;

    /* renamed from: i */
    private final String f7405i;

    /* renamed from: j */
    private Call f7406j;

    /* renamed from: k */
    private final Runnable f7407k;

    /* renamed from: l */
    private WebSocketReader f7408l;

    /* renamed from: m */
    private WebSocketWriter f7409m;

    /* renamed from: n */
    private ScheduledExecutorService f7410n;

    /* renamed from: o */
    private Streams f7411o;

    /* renamed from: p */
    private final ArrayDeque<ByteString> f7412p = new ArrayDeque<>();

    /* renamed from: q */
    private final ArrayDeque<Object> f7413q = new ArrayDeque<>();

    /* renamed from: r */
    private long f7414r;

    /* renamed from: s */
    private boolean f7415s;

    /* renamed from: t */
    private ScheduledFuture<?> f7416t;

    /* renamed from: u */
    private int f7417u = -1;

    /* renamed from: v */
    private String f7418v;

    /* renamed from: w */
    private boolean f7419w;

    /* renamed from: x */
    private int f7420x;

    /* renamed from: y */
    private int f7421y;

    /* renamed from: z */
    private int f7422z;

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random, long j) {
        if ("GET".equals(request.method())) {
            this.f7402f = request;
            this.f7401a = webSocketListener;
            this.f7403g = random;
            this.f7404h = j;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.f7405i = ByteString.m6997of(bArr).base64();
            this.f7407k = new Runnable() {
                public void run() {
                    do {
                        try {
                        } catch (IOException e) {
                            RealWebSocket.this.failWebSocket(e, (Response) null);
                            return;
                        }
                    } while (RealWebSocket.this.mo30668f());
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }

    public Request request() {
        return this.f7402f;
    }

    public synchronized long queueSize() {
        return this.f7414r;
    }

    public void cancel() {
        this.f7406j.cancel();
    }

    public void connect(OkHttpClient okHttpClient) {
        OkHttpClient build = okHttpClient.newBuilder().eventListener(EventListener.NONE).protocols(f7397c).build();
        final Request build2 = this.f7402f.newBuilder().header(HttpHeaders.UPGRADE, p218io.socket.engineio.client.transports.WebSocket.NAME).header(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE).header(HttpHeaders.SEC_WEBSOCKET_KEY, this.f7405i).header(HttpHeaders.SEC_WEBSOCKET_VERSION, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS).build();
        Call newWebSocketCall = Internal.instance.newWebSocketCall(build, build2);
        this.f7406j = newWebSocketCall;
        newWebSocketCall.timeout().clearTimeout();
        this.f7406j.enqueue(new Callback() {
            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.mo30659a(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket.this.f7401a.onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, (Response) null);
                    }
                } catch (ProtocolException e2) {
                    RealWebSocket.this.failWebSocket(e2, response);
                    C3000Util.closeQuietly((Closeable) response);
                }
            }

            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, (Response) null);
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30659a(Response response) throws ProtocolException {
        if (response.code() == 101) {
            String header = response.header(HttpHeaders.CONNECTION);
            if (HttpHeaders.UPGRADE.equalsIgnoreCase(header)) {
                String header2 = response.header(HttpHeaders.UPGRADE);
                if (p218io.socket.engineio.client.transports.WebSocket.NAME.equalsIgnoreCase(header2)) {
                    String header3 = response.header(HttpHeaders.SEC_WEBSOCKET_ACCEPT);
                    String base64 = ByteString.encodeUtf8(this.f7405i + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
                    if (!base64.equals(header3)) {
                        throw new ProtocolException("Expected 'Sec-WebSocket-Accept' header value '" + base64 + "' but was '" + header3 + "'");
                    }
                    return;
                }
                throw new ProtocolException("Expected 'Upgrade' header value 'websocket' but was '" + header2 + "'");
            }
            throw new ProtocolException("Expected 'Connection' header value 'Upgrade' but was '" + header + "'");
        }
        throw new ProtocolException("Expected HTTP 101 response but was '" + response.code() + " " + response.message() + "'");
    }

    public void initReaderAndWriter(String str, Streams streams) throws IOException {
        synchronized (this) {
            this.f7411o = streams;
            this.f7409m = new WebSocketWriter(streams.client, streams.sink, this.f7403g);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C3000Util.threadFactory(str, false));
            this.f7410n = scheduledThreadPoolExecutor;
            if (this.f7404h != 0) {
                scheduledThreadPoolExecutor.scheduleAtFixedRate(new PingRunnable(), this.f7404h, this.f7404h, TimeUnit.MILLISECONDS);
            }
            if (!this.f7413q.isEmpty()) {
                m6969h();
            }
        }
        this.f7408l = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws IOException {
        while (this.f7417u == -1) {
            this.f7408l.mo30681a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo30660a() throws IOException {
        try {
            this.f7408l.mo30681a();
            if (this.f7417u == -1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            failWebSocket(e, (Response) null);
            return false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo30658a(int i, TimeUnit timeUnit) throws InterruptedException {
        this.f7410n.awaitTermination((long) i, timeUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo30663b() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.f7416t;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f7410n.shutdown();
        this.f7410n.awaitTermination(10, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized int mo30664c() {
        return this.f7420x;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized int mo30666d() {
        return this.f7421y;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized int mo30667e() {
        return this.f7422z;
    }

    public void onReadMessage(String str) throws IOException {
        this.f7401a.onMessage((WebSocket) this, str);
    }

    public void onReadMessage(ByteString byteString) throws IOException {
        this.f7401a.onMessage((WebSocket) this, byteString);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f7419w     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0022
            boolean r0 = r1.f7415s     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            java.util.ArrayDeque<java.lang.Object> r0 = r1.f7413q     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.f7412p     // Catch:{ all -> 0x0024 }
            r0.add(r2)     // Catch:{ all -> 0x0024 }
            r1.m6969h()     // Catch:{ all -> 0x0024 }
            int r2 = r1.f7421y     // Catch:{ all -> 0x0024 }
            int r2 = r2 + 1
            r1.f7421y = r2     // Catch:{ all -> 0x0024 }
            monitor-exit(r1)
            return
        L_0x0022:
            monitor-exit(r1)
            return
        L_0x0024:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p073ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString byteString) {
        this.f7422z++;
        this.f7400A = false;
    }

    public void onReadClose(int i, String str) {
        Streams streams;
        if (i != -1) {
            synchronized (this) {
                if (this.f7417u == -1) {
                    this.f7417u = i;
                    this.f7418v = str;
                    streams = null;
                    if (this.f7415s && this.f7413q.isEmpty()) {
                        Streams streams2 = this.f7411o;
                        this.f7411o = streams;
                        if (this.f7416t != null) {
                            this.f7416t.cancel(false);
                        }
                        this.f7410n.shutdown();
                        streams = streams2;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.f7401a.onClosing(this, i, str);
                if (streams != null) {
                    this.f7401a.onClosed(this, i, str);
                }
            } finally {
                C3000Util.closeQuietly((Closeable) streams);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean send(String str) {
        if (str != null) {
            return m6968a(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return m6968a(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m6968a(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f7419w     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.f7415s     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.f7414r     // Catch:{ all -> 0x003e }
            int r0 = r7.size()     // Catch:{ all -> 0x003e }
            long r4 = (long) r0     // Catch:{ all -> 0x003e }
            long r2 = r2 + r4
            r4 = 16777216(0x1000000, double:8.289046E-317)
            int r0 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r0 <= 0) goto L_0x0022
            r7 = 1001(0x3e9, float:1.403E-42)
            r8 = 0
            r6.close(r7, r8)     // Catch:{ all -> 0x003e }
            monitor-exit(r6)
            return r1
        L_0x0022:
            long r0 = r6.f7414r     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.f7414r = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.f7413q     // Catch:{ all -> 0x003e }
            okhttp3.internal.ws.RealWebSocket$Message r1 = new okhttp3.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.m6969h()     // Catch:{ all -> 0x003e }
            r7 = 1
            monitor-exit(r6)
            return r7
        L_0x003c:
            monitor-exit(r6)
            return r1
        L_0x003e:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p073ws.RealWebSocket.m6968a(okio.ByteString, int):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo30662a(ByteString byteString) {
        if (!this.f7419w) {
            if (!this.f7415s || !this.f7413q.isEmpty()) {
                this.f7412p.add(byteString);
                m6969h();
                return true;
            }
        }
        return false;
    }

    public boolean close(int i, String str) {
        return mo30661a(i, str, 60000);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo30661a(int i, String str, long j) {
        WebSocketProtocol.m6983b(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (((long) byteString.size()) > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.f7419w) {
            if (!this.f7415s) {
                this.f7415s = true;
                this.f7413q.add(new Close(i, byteString, j));
                m6969h();
                return true;
            }
        }
        return false;
    }

    /* renamed from: h */
    private void m6969h() {
        if (f7396b || Thread.holdsLock(this)) {
            ScheduledExecutorService scheduledExecutorService = this.f7410n;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.execute(this.f7407k);
                return;
            }
            return;
        }
        throw new AssertionError();
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0056, code lost:
        if (r2 == null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:23:?, code lost:
        r0.mo30686b(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        if ((r4 instanceof okhttp3.internal.p073ws.RealWebSocket.Message) == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        r2 = ((okhttp3.internal.p073ws.RealWebSocket.Message) r4).data;
        r0 = okio.Okio.buffer(r0.mo30682a(((okhttp3.internal.p073ws.RealWebSocket.Message) r4).formatOpcode, (long) r2.size()));
        r0.write(r2);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        monitor-enter(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r12.f7414r -= (long) r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
        monitor-exit(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008e, code lost:
        if ((r4 instanceof okhttp3.internal.p073ws.RealWebSocket.Close) == false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0090, code lost:
        r4 = (okhttp3.internal.p073ws.RealWebSocket.Close) r4;
        r0.mo30684a(r4.code, r4.reason);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r1 == null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009b, code lost:
        r12.f7401a.onClosed(r12, r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a0, code lost:
        okhttp3.internal.C3000Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:0x00a4, code lost:
        return true;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x00aa, code lost:
        throw new java.lang.AssertionError();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:46:0x00ab, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x00ac, code lost:
        okhttp3.internal.C3000Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00af, code lost:
        throw r0;
     */
    /* renamed from: f */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo30668f() throws java.io.IOException {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.f7419w     // Catch:{ all -> 0x00b0 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x0008:
            okhttp3.internal.ws.WebSocketWriter r0 = r12.f7409m     // Catch:{ all -> 0x00b0 }
            java.util.ArrayDeque<okio.ByteString> r2 = r12.f7412p     // Catch:{ all -> 0x00b0 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x00b0 }
            okio.ByteString r2 = (okio.ByteString) r2     // Catch:{ all -> 0x00b0 }
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x0053
            java.util.ArrayDeque<java.lang.Object> r5 = r12.f7413q     // Catch:{ all -> 0x00b0 }
            java.lang.Object r5 = r5.poll()     // Catch:{ all -> 0x00b0 }
            boolean r6 = r5 instanceof okhttp3.internal.p073ws.RealWebSocket.Close     // Catch:{ all -> 0x00b0 }
            if (r6 == 0) goto L_0x004b
            int r1 = r12.f7417u     // Catch:{ all -> 0x00b0 }
            java.lang.String r6 = r12.f7418v     // Catch:{ all -> 0x00b0 }
            if (r1 == r3) goto L_0x0034
            okhttp3.internal.ws.RealWebSocket$Streams r3 = r12.f7411o     // Catch:{ all -> 0x00b0 }
            r12.f7411o = r4     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ScheduledExecutorService r4 = r12.f7410n     // Catch:{ all -> 0x00b0 }
            r4.shutdown()     // Catch:{ all -> 0x00b0 }
            r4 = r5
            r11 = r3
            r3 = r1
            r1 = r11
            goto L_0x0055
        L_0x0034:
            java.util.concurrent.ScheduledExecutorService r3 = r12.f7410n     // Catch:{ all -> 0x00b0 }
            okhttp3.internal.ws.RealWebSocket$CancelRunnable r7 = new okhttp3.internal.ws.RealWebSocket$CancelRunnable     // Catch:{ all -> 0x00b0 }
            r7.<init>()     // Catch:{ all -> 0x00b0 }
            r8 = r5
            okhttp3.internal.ws.RealWebSocket$Close r8 = (okhttp3.internal.p073ws.RealWebSocket.Close) r8     // Catch:{ all -> 0x00b0 }
            long r8 = r8.cancelAfterCloseMillis     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ScheduledFuture r3 = r3.schedule(r7, r8, r10)     // Catch:{ all -> 0x00b0 }
            r12.f7416t = r3     // Catch:{ all -> 0x00b0 }
            r3 = r1
            r1 = r4
            goto L_0x0051
        L_0x004b:
            if (r5 != 0) goto L_0x004f
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x004f:
            r1 = r4
            r6 = r1
        L_0x0051:
            r4 = r5
            goto L_0x0055
        L_0x0053:
            r1 = r4
            r6 = r1
        L_0x0055:
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            if (r2 == 0) goto L_0x005c
            r0.mo30686b(r2)     // Catch:{ all -> 0x00ab }
            goto L_0x00a0
        L_0x005c:
            boolean r2 = r4 instanceof okhttp3.internal.p073ws.RealWebSocket.Message     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x008c
            r2 = r4
            okhttp3.internal.ws.RealWebSocket$Message r2 = (okhttp3.internal.p073ws.RealWebSocket.Message) r2     // Catch:{ all -> 0x00ab }
            okio.ByteString r2 = r2.data     // Catch:{ all -> 0x00ab }
            okhttp3.internal.ws.RealWebSocket$Message r4 = (okhttp3.internal.p073ws.RealWebSocket.Message) r4     // Catch:{ all -> 0x00ab }
            int r3 = r4.formatOpcode     // Catch:{ all -> 0x00ab }
            int r4 = r2.size()     // Catch:{ all -> 0x00ab }
            long r4 = (long) r4     // Catch:{ all -> 0x00ab }
            okio.Sink r0 = r0.mo30682a((int) r3, (long) r4)     // Catch:{ all -> 0x00ab }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ all -> 0x00ab }
            r0.write((okio.ByteString) r2)     // Catch:{ all -> 0x00ab }
            r0.close()     // Catch:{ all -> 0x00ab }
            monitor-enter(r12)     // Catch:{ all -> 0x00ab }
            long r3 = r12.f7414r     // Catch:{ all -> 0x0089 }
            int r0 = r2.size()     // Catch:{ all -> 0x0089 }
            long r5 = (long) r0     // Catch:{ all -> 0x0089 }
            long r3 = r3 - r5
            r12.f7414r = r3     // Catch:{ all -> 0x0089 }
            monitor-exit(r12)     // Catch:{ all -> 0x0089 }
            goto L_0x00a0
        L_0x0089:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0089 }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x008c:
            boolean r2 = r4 instanceof okhttp3.internal.p073ws.RealWebSocket.Close     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x00a5
            okhttp3.internal.ws.RealWebSocket$Close r4 = (okhttp3.internal.p073ws.RealWebSocket.Close) r4     // Catch:{ all -> 0x00ab }
            int r2 = r4.code     // Catch:{ all -> 0x00ab }
            okio.ByteString r4 = r4.reason     // Catch:{ all -> 0x00ab }
            r0.mo30684a((int) r2, (okio.ByteString) r4)     // Catch:{ all -> 0x00ab }
            if (r1 == 0) goto L_0x00a0
            okhttp3.WebSocketListener r0 = r12.f7401a     // Catch:{ all -> 0x00ab }
            r0.onClosed(r12, r3, r6)     // Catch:{ all -> 0x00ab }
        L_0x00a0:
            r0 = 1
            okhttp3.internal.C3000Util.closeQuietly((java.io.Closeable) r1)
            return r0
        L_0x00a5:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x00ab }
            r0.<init>()     // Catch:{ all -> 0x00ab }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r0 = move-exception
            okhttp3.internal.C3000Util.closeQuietly((java.io.Closeable) r1)
            throw r0
        L_0x00b0:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p073ws.RealWebSocket.mo30668f():boolean");
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$PingRunnable */
    private final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        public void run() {
            RealWebSocket.this.mo30670g();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x001c, code lost:
        if (r1 == -1) goto L_0x0048;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x001e, code lost:
        failWebSocket(new java.net.SocketTimeoutException("sent ping but didn't receive pong within " + r7.f7404h + "ms (after " + (r1 - 1) + " successful ping/pongs)"), (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x0047, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r0.mo30685a(okio.ByteString.EMPTY);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004e, code lost:
        r0 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x004f, code lost:
        failWebSocket(r0, (okhttp3.Response) null);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:?, code lost:
        return;
     */
    /* renamed from: g */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo30670g() {
        /*
            r7 = this;
            monitor-enter(r7)
            boolean r0 = r7.f7419w     // Catch:{ all -> 0x0053 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r7)     // Catch:{ all -> 0x0053 }
            return
        L_0x0007:
            okhttp3.internal.ws.WebSocketWriter r0 = r7.f7409m     // Catch:{ all -> 0x0053 }
            boolean r1 = r7.f7400A     // Catch:{ all -> 0x0053 }
            r2 = -1
            if (r1 == 0) goto L_0x0011
            int r1 = r7.f7420x     // Catch:{ all -> 0x0053 }
            goto L_0x0012
        L_0x0011:
            r1 = -1
        L_0x0012:
            int r3 = r7.f7420x     // Catch:{ all -> 0x0053 }
            r4 = 1
            int r3 = r3 + r4
            r7.f7420x = r3     // Catch:{ all -> 0x0053 }
            r7.f7400A = r4     // Catch:{ all -> 0x0053 }
            monitor-exit(r7)     // Catch:{ all -> 0x0053 }
            r3 = 0
            if (r1 == r2) goto L_0x0048
            java.net.SocketTimeoutException r0 = new java.net.SocketTimeoutException
            java.lang.StringBuilder r2 = new java.lang.StringBuilder
            r2.<init>()
            java.lang.String r5 = "sent ping but didn't receive pong within "
            r2.append(r5)
            long r5 = r7.f7404h
            r2.append(r5)
            java.lang.String r5 = "ms (after "
            r2.append(r5)
            int r1 = r1 - r4
            r2.append(r1)
            java.lang.String r1 = " successful ping/pongs)"
            r2.append(r1)
            java.lang.String r1 = r2.toString()
            r0.<init>(r1)
            r7.failWebSocket(r0, r3)
            return
        L_0x0048:
            okio.ByteString r1 = okio.ByteString.EMPTY     // Catch:{ IOException -> 0x004e }
            r0.mo30685a(r1)     // Catch:{ IOException -> 0x004e }
            goto L_0x0052
        L_0x004e:
            r0 = move-exception
            r7.failWebSocket(r0, r3)
        L_0x0052:
            return
        L_0x0053:
            r0 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x0053 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p073ws.RealWebSocket.mo30670g():void");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3.f7401a.onFailure(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        okhttp3.internal.C3000Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void failWebSocket(java.lang.Exception r4, @javax.annotation.Nullable okhttp3.Response r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f7419w     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0007:
            r0 = 1
            r3.f7419w = r0     // Catch:{ all -> 0x0031 }
            okhttp3.internal.ws.RealWebSocket$Streams r0 = r3.f7411o     // Catch:{ all -> 0x0031 }
            r1 = 0
            r3.f7411o = r1     // Catch:{ all -> 0x0031 }
            java.util.concurrent.ScheduledFuture<?> r1 = r3.f7416t     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0019
            java.util.concurrent.ScheduledFuture<?> r1 = r3.f7416t     // Catch:{ all -> 0x0031 }
            r2 = 0
            r1.cancel(r2)     // Catch:{ all -> 0x0031 }
        L_0x0019:
            java.util.concurrent.ScheduledExecutorService r1 = r3.f7410n     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0022
            java.util.concurrent.ScheduledExecutorService r1 = r3.f7410n     // Catch:{ all -> 0x0031 }
            r1.shutdown()     // Catch:{ all -> 0x0031 }
        L_0x0022:
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            okhttp3.WebSocketListener r1 = r3.f7401a     // Catch:{ all -> 0x002c }
            r1.onFailure(r3, r4, r5)     // Catch:{ all -> 0x002c }
            okhttp3.internal.C3000Util.closeQuietly((java.io.Closeable) r0)
            return
        L_0x002c:
            r4 = move-exception
            okhttp3.internal.C3000Util.closeQuietly((java.io.Closeable) r0)
            throw r4
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: okhttp3.internal.p073ws.RealWebSocket.failWebSocket(java.lang.Exception, okhttp3.Response):void");
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$Message */
    static final class Message {
        final ByteString data;
        final int formatOpcode;

        Message(int i, ByteString byteString) {
            this.formatOpcode = i;
            this.data = byteString;
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$Close */
    static final class Close {
        final long cancelAfterCloseMillis;
        final int code;
        final ByteString reason;

        Close(int i, ByteString byteString, long j) {
            this.code = i;
            this.reason = byteString;
            this.cancelAfterCloseMillis = j;
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$Streams */
    public static abstract class Streams implements Closeable {
        public final boolean client;
        public final BufferedSink sink;
        public final BufferedSource source;

        public Streams(boolean z, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.client = z;
            this.source = bufferedSource;
            this.sink = bufferedSink;
        }
    }

    /* renamed from: okhttp3.internal.ws.RealWebSocket$CancelRunnable */
    final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        public void run() {
            RealWebSocket.this.cancel();
        }
    }
}
