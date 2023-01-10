package didihttp.internal.p232ws;

import com.didichuxing.diface.logger.DiFaceLogger;
import com.google.common.net.HttpHeaders;
import didihttp.Call;
import didihttp.Callback;
import didihttp.DidiHttpClient;
import didihttp.Protocol;
import didihttp.Request;
import didihttp.Response;
import didihttp.WebSocket;
import didihttp.WebSocketListener;
import didihttp.internal.C21750Util;
import didihttp.internal.Internal;
import didihttp.internal.connection.StreamAllocation;
import didihttp.internal.p232ws.WebSocketReader;
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
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;

/* renamed from: didihttp.internal.ws.RealWebSocket */
public final class RealWebSocket implements WebSocket, WebSocketReader.FrameCallback {

    /* renamed from: d */
    static final /* synthetic */ boolean f59680d = (!RealWebSocket.class.desiredAssertionStatus());

    /* renamed from: e */
    private static final List<Protocol> f59681e = Collections.singletonList(Protocol.HTTP_1_1);

    /* renamed from: f */
    private static final long f59682f = 16777216;

    /* renamed from: g */
    private static final long f59683g = 60000;

    /* renamed from: a */
    final WebSocketListener f59684a;

    /* renamed from: b */
    int f59685b;

    /* renamed from: c */
    int f59686c;

    /* renamed from: h */
    private final Request f59687h;

    /* renamed from: i */
    private final Random f59688i;

    /* renamed from: j */
    private final String f59689j;

    /* renamed from: k */
    private Call f59690k;

    /* renamed from: l */
    private final Runnable f59691l;

    /* renamed from: m */
    private WebSocketReader f59692m;

    /* renamed from: n */
    private WebSocketWriter f59693n;

    /* renamed from: o */
    private ScheduledExecutorService f59694o;

    /* renamed from: p */
    private Streams f59695p;

    /* renamed from: q */
    private final ArrayDeque<ByteString> f59696q = new ArrayDeque<>();

    /* renamed from: r */
    private final ArrayDeque<Object> f59697r = new ArrayDeque<>();

    /* renamed from: s */
    private long f59698s;

    /* renamed from: t */
    private boolean f59699t;

    /* renamed from: u */
    private ScheduledFuture<?> f59700u;

    /* renamed from: v */
    private int f59701v = -1;

    /* renamed from: w */
    private String f59702w;

    /* renamed from: x */
    private boolean f59703x;

    public RealWebSocket(Request request, WebSocketListener webSocketListener, Random random) {
        if ("GET".equals(request.method())) {
            this.f59687h = request;
            this.f59684a = webSocketListener;
            this.f59688i = random;
            byte[] bArr = new byte[16];
            random.nextBytes(bArr);
            this.f59689j = ByteString.m6997of(bArr).base64();
            this.f59691l = new Runnable() {
                public void run() {
                    do {
                        try {
                        } catch (IOException e) {
                            RealWebSocket.this.failWebSocket(e, (Response) null);
                            return;
                        }
                    } while (RealWebSocket.this.mo180182e());
                }
            };
            return;
        }
        throw new IllegalArgumentException("Request must be GET: " + request.method());
    }

    public Request request() {
        return this.f59687h;
    }

    public synchronized long queueSize() {
        return this.f59698s;
    }

    public void cancel() {
        this.f59690k.cancel();
    }

    public void connect(DidiHttpClient didiHttpClient) {
        DidiHttpClient build = didiHttpClient.newBuilder().protocols(f59681e).build();
        final int pingIntervalMillis = build.pingIntervalMillis();
        final Request build2 = this.f59687h.newBuilder().header(HttpHeaders.UPGRADE, p218io.socket.engineio.client.transports.WebSocket.NAME).header(HttpHeaders.CONNECTION, HttpHeaders.UPGRADE).header(HttpHeaders.SEC_WEBSOCKET_KEY, this.f59689j).header(HttpHeaders.SEC_WEBSOCKET_VERSION, DiFaceLogger.EVENT_ID_BIOASSAY_ACTION_SUCCESS).build();
        Call newWebSocketCall = Internal.instance.newWebSocketCall(build, build2);
        this.f59690k = newWebSocketCall;
        newWebSocketCall.enqueue(new Callback() {
            public void onResponse(Call call, Response response) {
                try {
                    RealWebSocket.this.mo180174a(response);
                    StreamAllocation streamAllocation = Internal.instance.streamAllocation(call);
                    streamAllocation.noNewStreams();
                    Streams newWebSocketStreams = streamAllocation.connection().newWebSocketStreams(streamAllocation);
                    try {
                        RealWebSocket.this.f59684a.onOpen(RealWebSocket.this, response);
                        RealWebSocket.this.initReaderAndWriter("OkHttp WebSocket " + build2.url().redact(), (long) pingIntervalMillis, newWebSocketStreams);
                        streamAllocation.connection().socket().setSoTimeout(0);
                        RealWebSocket.this.loopReader();
                    } catch (Exception e) {
                        RealWebSocket.this.failWebSocket(e, (Response) null);
                    }
                } catch (ProtocolException e2) {
                    RealWebSocket.this.failWebSocket(e2, response);
                    C21750Util.closeQuietly((Closeable) response);
                }
            }

            public void onFailure(Call call, IOException iOException) {
                RealWebSocket.this.failWebSocket(iOException, (Response) null);
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo180174a(Response response) throws ProtocolException {
        if (response.code() == 101) {
            String header = response.header(HttpHeaders.CONNECTION);
            if (HttpHeaders.UPGRADE.equalsIgnoreCase(header)) {
                String header2 = response.header(HttpHeaders.UPGRADE);
                if (p218io.socket.engineio.client.transports.WebSocket.NAME.equalsIgnoreCase(header2)) {
                    String header3 = response.header(HttpHeaders.SEC_WEBSOCKET_ACCEPT);
                    String base64 = ByteString.encodeUtf8(this.f59689j + "258EAFA5-E914-47DA-95CA-C5AB0DC85B11").sha1().base64();
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

    public void initReaderAndWriter(String str, long j, Streams streams) throws IOException {
        synchronized (this) {
            this.f59695p = streams;
            this.f59693n = new WebSocketWriter(streams.client, streams.sink, this.f59688i);
            ScheduledThreadPoolExecutor scheduledThreadPoolExecutor = new ScheduledThreadPoolExecutor(1, C21750Util.threadFactory(str, false));
            this.f59694o = scheduledThreadPoolExecutor;
            if (j != 0) {
                scheduledThreadPoolExecutor.scheduleAtFixedRate(new PingRunnable(), j, j, TimeUnit.MILLISECONDS);
            }
            if (!this.f59697r.isEmpty()) {
                m44985g();
            }
        }
        this.f59692m = new WebSocketReader(streams.client, streams.source, this);
    }

    public void loopReader() throws IOException {
        while (this.f59701v == -1) {
            this.f59692m.mo180195a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo180175a() throws IOException {
        try {
            this.f59692m.mo180195a();
            if (this.f59701v == -1) {
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
    public void mo180173a(int i, TimeUnit timeUnit) throws InterruptedException {
        this.f59694o.awaitTermination((long) i, timeUnit);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo180178b() throws InterruptedException {
        ScheduledFuture<?> scheduledFuture = this.f59700u;
        if (scheduledFuture != null) {
            scheduledFuture.cancel(false);
        }
        this.f59694o.shutdown();
        this.f59694o.awaitTermination(10, TimeUnit.SECONDS);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized int mo180179c() {
        return this.f59685b;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized int mo180181d() {
        return this.f59686c;
    }

    public void onReadMessage(String str) throws IOException {
        this.f59684a.onMessage((WebSocket) this, str);
    }

    public void onReadMessage(ByteString byteString) throws IOException {
        this.f59684a.onMessage((WebSocket) this, byteString);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0023, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void onReadPing(okio.ByteString r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r0 = r1.f59703x     // Catch:{ all -> 0x0024 }
            if (r0 != 0) goto L_0x0022
            boolean r0 = r1.f59699t     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            java.util.ArrayDeque<java.lang.Object> r0 = r1.f59697r     // Catch:{ all -> 0x0024 }
            boolean r0 = r0.isEmpty()     // Catch:{ all -> 0x0024 }
            if (r0 == 0) goto L_0x0012
            goto L_0x0022
        L_0x0012:
            java.util.ArrayDeque<okio.ByteString> r0 = r1.f59696q     // Catch:{ all -> 0x0024 }
            r0.add(r2)     // Catch:{ all -> 0x0024 }
            r1.m44985g()     // Catch:{ all -> 0x0024 }
            int r2 = r1.f59685b     // Catch:{ all -> 0x0024 }
            int r2 = r2 + 1
            r1.f59685b = r2     // Catch:{ all -> 0x0024 }
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
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.p232ws.RealWebSocket.onReadPing(okio.ByteString):void");
    }

    public synchronized void onReadPong(ByteString byteString) {
        this.f59686c++;
    }

    public void onReadClose(int i, String str) {
        Streams streams;
        if (i != -1) {
            synchronized (this) {
                if (this.f59701v == -1) {
                    this.f59701v = i;
                    this.f59702w = str;
                    streams = null;
                    if (this.f59699t && this.f59697r.isEmpty()) {
                        Streams streams2 = this.f59695p;
                        this.f59695p = streams;
                        if (this.f59700u != null) {
                            this.f59700u.cancel(false);
                        }
                        this.f59694o.shutdown();
                        streams = streams2;
                    }
                } else {
                    throw new IllegalStateException("already closed");
                }
            }
            try {
                this.f59684a.onClosing(this, i, str);
                if (streams != null) {
                    this.f59684a.onClosed(this, i, str);
                }
            } finally {
                C21750Util.closeQuietly((Closeable) streams);
            }
        } else {
            throw new IllegalArgumentException();
        }
    }

    public boolean send(String str) {
        if (str != null) {
            return m44984a(ByteString.encodeUtf8(str), 1);
        }
        throw new NullPointerException("text == null");
    }

    public boolean send(ByteString byteString) {
        if (byteString != null) {
            return m44984a(byteString, 2);
        }
        throw new NullPointerException("bytes == null");
    }

    /* JADX WARNING: Code restructure failed: missing block: B:18:0x003d, code lost:
        return false;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private synchronized boolean m44984a(okio.ByteString r7, int r8) {
        /*
            r6 = this;
            monitor-enter(r6)
            boolean r0 = r6.f59703x     // Catch:{ all -> 0x003e }
            r1 = 0
            if (r0 != 0) goto L_0x003c
            boolean r0 = r6.f59699t     // Catch:{ all -> 0x003e }
            if (r0 == 0) goto L_0x000b
            goto L_0x003c
        L_0x000b:
            long r2 = r6.f59698s     // Catch:{ all -> 0x003e }
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
            long r0 = r6.f59698s     // Catch:{ all -> 0x003e }
            int r2 = r7.size()     // Catch:{ all -> 0x003e }
            long r2 = (long) r2     // Catch:{ all -> 0x003e }
            long r0 = r0 + r2
            r6.f59698s = r0     // Catch:{ all -> 0x003e }
            java.util.ArrayDeque<java.lang.Object> r0 = r6.f59697r     // Catch:{ all -> 0x003e }
            didihttp.internal.ws.RealWebSocket$Message r1 = new didihttp.internal.ws.RealWebSocket$Message     // Catch:{ all -> 0x003e }
            r1.<init>(r8, r7)     // Catch:{ all -> 0x003e }
            r0.add(r1)     // Catch:{ all -> 0x003e }
            r6.m44985g()     // Catch:{ all -> 0x003e }
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
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.p232ws.RealWebSocket.m44984a(okio.ByteString, int):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo180177a(ByteString byteString) {
        if (!this.f59703x) {
            if (!this.f59699t || !this.f59697r.isEmpty()) {
                this.f59696q.add(byteString);
                m44985g();
                return true;
            }
        }
        return false;
    }

    public boolean close(int i, String str) {
        return mo180176a(i, str, 60000);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo180176a(int i, String str, long j) {
        WebSocketProtocol.m44998b(i);
        ByteString byteString = null;
        if (str != null) {
            byteString = ByteString.encodeUtf8(str);
            if (((long) byteString.size()) > 123) {
                throw new IllegalArgumentException("reason.size() > 123: " + str);
            }
        }
        if (!this.f59703x) {
            if (!this.f59699t) {
                this.f59699t = true;
                this.f59697r.add(new Close(i, byteString, j));
                m44985g();
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private void m44985g() {
        if (f59680d || Thread.holdsLock(this)) {
            ScheduledExecutorService scheduledExecutorService = this.f59694o;
            if (scheduledExecutorService != null) {
                scheduledExecutorService.execute(this.f59691l);
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
        r0.mo180201b(r2);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:25:0x005e, code lost:
        if ((r4 instanceof didihttp.internal.p232ws.RealWebSocket.Message) == false) goto L_0x008c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:26:0x0060, code lost:
        r2 = ((didihttp.internal.p232ws.RealWebSocket.Message) r4).data;
        r0 = okio.Okio.buffer(r0.mo180197a(((didihttp.internal.p232ws.RealWebSocket.Message) r4).formatOpcode, (long) r2.size()));
        r0.write(r2);
        r0.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:27:0x007c, code lost:
        monitor-enter(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:29:?, code lost:
        r12.f59698s -= (long) r2.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:0x0087, code lost:
        monitor-exit(r12);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:37:0x008e, code lost:
        if ((r4 instanceof didihttp.internal.p232ws.RealWebSocket.Close) == false) goto L_0x00a5;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:38:0x0090, code lost:
        r4 = (didihttp.internal.p232ws.RealWebSocket.Close) r4;
        r0.mo180199a(r4.code, r4.reason);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:0x0099, code lost:
        if (r1 == null) goto L_0x00a0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x009b, code lost:
        r12.f59684a.onClosed(r12, r3, r6);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:41:0x00a0, code lost:
        didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r1);
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
        didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x00af, code lost:
        throw r0;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean mo180182e() throws java.io.IOException {
        /*
            r12 = this;
            monitor-enter(r12)
            boolean r0 = r12.f59703x     // Catch:{ all -> 0x00b0 }
            r1 = 0
            if (r0 == 0) goto L_0x0008
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            return r1
        L_0x0008:
            didihttp.internal.ws.WebSocketWriter r0 = r12.f59693n     // Catch:{ all -> 0x00b0 }
            java.util.ArrayDeque<okio.ByteString> r2 = r12.f59696q     // Catch:{ all -> 0x00b0 }
            java.lang.Object r2 = r2.poll()     // Catch:{ all -> 0x00b0 }
            okio.ByteString r2 = (okio.ByteString) r2     // Catch:{ all -> 0x00b0 }
            r3 = -1
            r4 = 0
            if (r2 != 0) goto L_0x0053
            java.util.ArrayDeque<java.lang.Object> r5 = r12.f59697r     // Catch:{ all -> 0x00b0 }
            java.lang.Object r5 = r5.poll()     // Catch:{ all -> 0x00b0 }
            boolean r6 = r5 instanceof didihttp.internal.p232ws.RealWebSocket.Close     // Catch:{ all -> 0x00b0 }
            if (r6 == 0) goto L_0x004b
            int r1 = r12.f59701v     // Catch:{ all -> 0x00b0 }
            java.lang.String r6 = r12.f59702w     // Catch:{ all -> 0x00b0 }
            if (r1 == r3) goto L_0x0034
            didihttp.internal.ws.RealWebSocket$Streams r3 = r12.f59695p     // Catch:{ all -> 0x00b0 }
            r12.f59695p = r4     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ScheduledExecutorService r4 = r12.f59694o     // Catch:{ all -> 0x00b0 }
            r4.shutdown()     // Catch:{ all -> 0x00b0 }
            r4 = r5
            r11 = r3
            r3 = r1
            r1 = r11
            goto L_0x0055
        L_0x0034:
            java.util.concurrent.ScheduledExecutorService r3 = r12.f59694o     // Catch:{ all -> 0x00b0 }
            didihttp.internal.ws.RealWebSocket$CancelRunnable r7 = new didihttp.internal.ws.RealWebSocket$CancelRunnable     // Catch:{ all -> 0x00b0 }
            r7.<init>()     // Catch:{ all -> 0x00b0 }
            r8 = r5
            didihttp.internal.ws.RealWebSocket$Close r8 = (didihttp.internal.p232ws.RealWebSocket.Close) r8     // Catch:{ all -> 0x00b0 }
            long r8 = r8.cancelAfterCloseMillis     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.TimeUnit r10 = java.util.concurrent.TimeUnit.MILLISECONDS     // Catch:{ all -> 0x00b0 }
            java.util.concurrent.ScheduledFuture r3 = r3.schedule(r7, r8, r10)     // Catch:{ all -> 0x00b0 }
            r12.f59700u = r3     // Catch:{ all -> 0x00b0 }
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
            r0.mo180201b(r2)     // Catch:{ all -> 0x00ab }
            goto L_0x00a0
        L_0x005c:
            boolean r2 = r4 instanceof didihttp.internal.p232ws.RealWebSocket.Message     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x008c
            r2 = r4
            didihttp.internal.ws.RealWebSocket$Message r2 = (didihttp.internal.p232ws.RealWebSocket.Message) r2     // Catch:{ all -> 0x00ab }
            okio.ByteString r2 = r2.data     // Catch:{ all -> 0x00ab }
            didihttp.internal.ws.RealWebSocket$Message r4 = (didihttp.internal.p232ws.RealWebSocket.Message) r4     // Catch:{ all -> 0x00ab }
            int r3 = r4.formatOpcode     // Catch:{ all -> 0x00ab }
            int r4 = r2.size()     // Catch:{ all -> 0x00ab }
            long r4 = (long) r4     // Catch:{ all -> 0x00ab }
            okio.Sink r0 = r0.mo180197a((int) r3, (long) r4)     // Catch:{ all -> 0x00ab }
            okio.BufferedSink r0 = okio.Okio.buffer((okio.Sink) r0)     // Catch:{ all -> 0x00ab }
            r0.write((okio.ByteString) r2)     // Catch:{ all -> 0x00ab }
            r0.close()     // Catch:{ all -> 0x00ab }
            monitor-enter(r12)     // Catch:{ all -> 0x00ab }
            long r3 = r12.f59698s     // Catch:{ all -> 0x0089 }
            int r0 = r2.size()     // Catch:{ all -> 0x0089 }
            long r5 = (long) r0     // Catch:{ all -> 0x0089 }
            long r3 = r3 - r5
            r12.f59698s = r3     // Catch:{ all -> 0x0089 }
            monitor-exit(r12)     // Catch:{ all -> 0x0089 }
            goto L_0x00a0
        L_0x0089:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x0089 }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x008c:
            boolean r2 = r4 instanceof didihttp.internal.p232ws.RealWebSocket.Close     // Catch:{ all -> 0x00ab }
            if (r2 == 0) goto L_0x00a5
            didihttp.internal.ws.RealWebSocket$Close r4 = (didihttp.internal.p232ws.RealWebSocket.Close) r4     // Catch:{ all -> 0x00ab }
            int r2 = r4.code     // Catch:{ all -> 0x00ab }
            okio.ByteString r4 = r4.reason     // Catch:{ all -> 0x00ab }
            r0.mo180199a((int) r2, (okio.ByteString) r4)     // Catch:{ all -> 0x00ab }
            if (r1 == 0) goto L_0x00a0
            didihttp.WebSocketListener r0 = r12.f59684a     // Catch:{ all -> 0x00ab }
            r0.onClosed(r12, r3, r6)     // Catch:{ all -> 0x00ab }
        L_0x00a0:
            r0 = 1
            didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r1)
            return r0
        L_0x00a5:
            java.lang.AssertionError r0 = new java.lang.AssertionError     // Catch:{ all -> 0x00ab }
            r0.<init>()     // Catch:{ all -> 0x00ab }
            throw r0     // Catch:{ all -> 0x00ab }
        L_0x00ab:
            r0 = move-exception
            didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r1)
            throw r0
        L_0x00b0:
            r0 = move-exception
            monitor-exit(r12)     // Catch:{ all -> 0x00b0 }
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.p232ws.RealWebSocket.mo180182e():boolean");
    }

    /* renamed from: didihttp.internal.ws.RealWebSocket$PingRunnable */
    private final class PingRunnable implements Runnable {
        PingRunnable() {
        }

        public void run() {
            RealWebSocket.this.mo180183f();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public void mo180183f() {
        synchronized (this) {
            if (!this.f59703x) {
                WebSocketWriter webSocketWriter = this.f59693n;
                try {
                    webSocketWriter.mo180200a(ByteString.EMPTY);
                } catch (IOException e) {
                    failWebSocket(e, (Response) null);
                }
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:?, code lost:
        r3.f59684a.onFailure(r3, r4, r5);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x002b, code lost:
        return;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x002c, code lost:
        r4 = move-exception;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x002d, code lost:
        didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r0);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0030, code lost:
        throw r4;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void failWebSocket(java.lang.Exception r4, didihttp.Response r5) {
        /*
            r3 = this;
            monitor-enter(r3)
            boolean r0 = r3.f59703x     // Catch:{ all -> 0x0031 }
            if (r0 == 0) goto L_0x0007
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            return
        L_0x0007:
            r0 = 1
            r3.f59703x = r0     // Catch:{ all -> 0x0031 }
            didihttp.internal.ws.RealWebSocket$Streams r0 = r3.f59695p     // Catch:{ all -> 0x0031 }
            r1 = 0
            r3.f59695p = r1     // Catch:{ all -> 0x0031 }
            java.util.concurrent.ScheduledFuture<?> r1 = r3.f59700u     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0019
            java.util.concurrent.ScheduledFuture<?> r1 = r3.f59700u     // Catch:{ all -> 0x0031 }
            r2 = 0
            r1.cancel(r2)     // Catch:{ all -> 0x0031 }
        L_0x0019:
            java.util.concurrent.ScheduledExecutorService r1 = r3.f59694o     // Catch:{ all -> 0x0031 }
            if (r1 == 0) goto L_0x0022
            java.util.concurrent.ScheduledExecutorService r1 = r3.f59694o     // Catch:{ all -> 0x0031 }
            r1.shutdown()     // Catch:{ all -> 0x0031 }
        L_0x0022:
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            didihttp.WebSocketListener r1 = r3.f59684a     // Catch:{ all -> 0x002c }
            r1.onFailure(r3, r4, r5)     // Catch:{ all -> 0x002c }
            didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r0)
            return
        L_0x002c:
            r4 = move-exception
            didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r0)
            throw r4
        L_0x0031:
            r4 = move-exception
            monitor-exit(r3)     // Catch:{ all -> 0x0031 }
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.p232ws.RealWebSocket.failWebSocket(java.lang.Exception, didihttp.Response):void");
    }

    /* renamed from: didihttp.internal.ws.RealWebSocket$Message */
    static final class Message {
        final ByteString data;
        final int formatOpcode;

        Message(int i, ByteString byteString) {
            this.formatOpcode = i;
            this.data = byteString;
        }
    }

    /* renamed from: didihttp.internal.ws.RealWebSocket$Close */
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

    /* renamed from: didihttp.internal.ws.RealWebSocket$Streams */
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

    /* renamed from: didihttp.internal.ws.RealWebSocket$CancelRunnable */
    final class CancelRunnable implements Runnable {
        CancelRunnable() {
        }

        public void run() {
            RealWebSocket.this.cancel();
        }
    }
}
