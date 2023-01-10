package didihttp.internal.http2;

import didihttp.Protocol;
import didihttp.internal.C21750Util;
import didihttp.internal.NamedRunnable;
import didihttp.internal.http2.Http2Reader;
import java.io.Closeable;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.ByteString;
import okio.Okio;

public final class Http2Connection implements Closeable {

    /* renamed from: a */
    static final ExecutorService f59550a = new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60, TimeUnit.SECONDS, new SynchronousQueue(), C21750Util.threadFactory("OkHttp Http2Connection", true));

    /* renamed from: s */
    static final /* synthetic */ boolean f59551s = (!Http2Connection.class.desiredAssertionStatus());

    /* renamed from: w */
    private static final int f59552w = 16777216;

    /* renamed from: b */
    final boolean f59553b;

    /* renamed from: c */
    final Listener f59554c;

    /* renamed from: d */
    final Map<Integer, Http2Stream> f59555d = new LinkedHashMap();

    /* renamed from: e */
    final String f59556e;

    /* renamed from: f */
    int f59557f;

    /* renamed from: g */
    int f59558g;

    /* renamed from: h */
    boolean f59559h;

    /* renamed from: i */
    final PushObserver f59560i;

    /* renamed from: j */
    long f59561j = 0;

    /* renamed from: k */
    long f59562k;

    /* renamed from: l */
    Settings f59563l = new Settings();

    /* renamed from: m */
    final Settings f59564m = new Settings();

    /* renamed from: n */
    boolean f59565n = false;

    /* renamed from: o */
    final Socket f59566o;

    /* renamed from: p */
    final C21775a f59567p;

    /* renamed from: q */
    final ReaderRunnable f59568q;

    /* renamed from: r */
    final Set<Integer> f59569r = new LinkedHashSet();

    /* renamed from: t */
    private final ExecutorService f59570t;

    /* renamed from: u */
    private Map<Integer, C21776b> f59571u;

    /* renamed from: v */
    private int f59572v;

    public static abstract class Listener {
        public static final Listener REFUSE_INCOMING_STREAMS = new Listener() {
            public void onStream(Http2Stream http2Stream) throws IOException {
                http2Stream.close(ErrorCode.REFUSED_STREAM);
            }
        };

        public void onSettings(Http2Connection http2Connection) {
        }

        public abstract void onStream(Http2Stream http2Stream) throws IOException;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public boolean mo179916d(int i) {
        return i != 0 && (i & 1) == 0;
    }

    Http2Connection(Builder builder) {
        this.f59560i = builder.pushObserver;
        this.f59553b = builder.client;
        this.f59554c = builder.listener;
        int i = 2;
        this.f59558g = builder.client ? 1 : 2;
        if (builder.client) {
            this.f59558g += 2;
        }
        this.f59572v = builder.client ? 1 : i;
        if (builder.client) {
            this.f59563l.mo179979a(7, 16777216);
        }
        this.f59556e = builder.hostname;
        this.f59570t = new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C21750Util.threadFactory(C21750Util.format("OkHttp %s Push Observer", this.f59556e), true));
        this.f59564m.mo179979a(7, 65535);
        this.f59564m.mo179979a(5, 16384);
        this.f59562k = (long) this.f59564m.mo179988d();
        this.f59566o = builder.socket;
        this.f59567p = new C21775a(builder.sink, this.f59553b);
        this.f59568q = new ReaderRunnable(new Http2Reader(builder.source, this.f59553b));
    }

    public Protocol getProtocol() {
        return Protocol.HTTP_2;
    }

    public synchronized int openStreamCount() {
        return this.f59555d.size();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized Http2Stream mo179899a(int i) {
        return this.f59555d.get(Integer.valueOf(i));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized Http2Stream mo179910b(int i) {
        Http2Stream remove;
        remove = this.f59555d.remove(Integer.valueOf(i));
        notifyAll();
        return remove;
    }

    public synchronized int maxConcurrentStreams() {
        return this.f59564m.mo179987c(Integer.MAX_VALUE);
    }

    public Http2Stream pushStream(int i, List<Header> list, boolean z) throws IOException {
        if (!this.f59553b) {
            return m44845b(i, list, z);
        }
        throw new IllegalStateException("Client cannot push requests.");
    }

    public Http2Stream newStream(List<Header> list, boolean z) throws IOException {
        return m44845b(0, list, z);
    }

    /* JADX WARNING: Removed duplicated region for block: B:18:0x0037  */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private didihttp.internal.http2.Http2Stream m44845b(int r11, java.util.List<didihttp.internal.http2.Header> r12, boolean r13) throws java.io.IOException {
        /*
            r10 = this;
            r6 = r13 ^ 1
            r4 = 0
            didihttp.internal.http2.a r7 = r10.f59567p
            monitor-enter(r7)
            monitor-enter(r10)     // Catch:{ all -> 0x006c }
            boolean r0 = r10.f59559h     // Catch:{ all -> 0x0069 }
            if (r0 != 0) goto L_0x0063
            int r8 = r10.f59558g     // Catch:{ all -> 0x0069 }
            int r0 = r10.f59558g     // Catch:{ all -> 0x0069 }
            int r0 = r0 + 2
            r10.f59558g = r0     // Catch:{ all -> 0x0069 }
            didihttp.internal.http2.Http2Stream r9 = new didihttp.internal.http2.Http2Stream     // Catch:{ all -> 0x0069 }
            r0 = r9
            r1 = r8
            r2 = r10
            r3 = r6
            r5 = r12
            r0.<init>(r1, r2, r3, r4, r5)     // Catch:{ all -> 0x0069 }
            if (r13 == 0) goto L_0x0030
            long r0 = r10.f59562k     // Catch:{ all -> 0x0069 }
            r2 = 0
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 == 0) goto L_0x0030
            long r0 = r9.f59580b     // Catch:{ all -> 0x0069 }
            int r13 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r13 != 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r13 = 0
            goto L_0x0031
        L_0x0030:
            r13 = 1
        L_0x0031:
            boolean r0 = r9.isOpen()     // Catch:{ all -> 0x0069 }
            if (r0 == 0) goto L_0x0040
            java.util.Map<java.lang.Integer, didihttp.internal.http2.Http2Stream> r0 = r10.f59555d     // Catch:{ all -> 0x0069 }
            java.lang.Integer r1 = java.lang.Integer.valueOf(r8)     // Catch:{ all -> 0x0069 }
            r0.put(r1, r9)     // Catch:{ all -> 0x0069 }
        L_0x0040:
            monitor-exit(r10)     // Catch:{ all -> 0x0069 }
            if (r11 != 0) goto L_0x0049
            didihttp.internal.http2.a r0 = r10.f59567p     // Catch:{ all -> 0x006c }
            r0.mo180001a((boolean) r6, (int) r8, (int) r11, (java.util.List<didihttp.internal.http2.Header>) r12)     // Catch:{ all -> 0x006c }
            goto L_0x0052
        L_0x0049:
            boolean r0 = r10.f59553b     // Catch:{ all -> 0x006c }
            if (r0 != 0) goto L_0x005b
            didihttp.internal.http2.a r0 = r10.f59567p     // Catch:{ all -> 0x006c }
            r0.mo179994a((int) r11, (int) r8, (java.util.List<didihttp.internal.http2.Header>) r12)     // Catch:{ all -> 0x006c }
        L_0x0052:
            monitor-exit(r7)     // Catch:{ all -> 0x006c }
            if (r13 == 0) goto L_0x005a
            didihttp.internal.http2.a r11 = r10.f59567p
            r11.mo180004b()
        L_0x005a:
            return r9
        L_0x005b:
            java.lang.IllegalArgumentException r11 = new java.lang.IllegalArgumentException     // Catch:{ all -> 0x006c }
            java.lang.String r12 = "client streams shouldn't have associated stream IDs"
            r11.<init>(r12)     // Catch:{ all -> 0x006c }
            throw r11     // Catch:{ all -> 0x006c }
        L_0x0063:
            didihttp.internal.http2.ConnectionShutdownException r11 = new didihttp.internal.http2.ConnectionShutdownException     // Catch:{ all -> 0x0069 }
            r11.<init>()     // Catch:{ all -> 0x0069 }
            throw r11     // Catch:{ all -> 0x0069 }
        L_0x0069:
            r11 = move-exception
            monitor-exit(r10)     // Catch:{ all -> 0x0069 }
            throw r11     // Catch:{ all -> 0x006c }
        L_0x006c:
            r11 = move-exception
            monitor-exit(r7)     // Catch:{ all -> 0x006c }
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.http2.Http2Connection.m44845b(int, java.util.List, boolean):didihttp.internal.http2.Http2Stream");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179905a(int i, boolean z, List<Header> list) throws IOException {
        this.f59567p.mo180002a(z, i, list);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(3:26|27|28) */
    /* JADX WARNING: Code restructure failed: missing block: B:16:?, code lost:
        r3 = java.lang.Math.min((int) java.lang.Math.min(r12, r8.f59562k), r8.f59567p.mo180007c());
        r6 = (long) r3;
        r8.f59562k -= r6;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005f, code lost:
        throw new java.io.InterruptedIOException();
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x005a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void writeData(int r9, boolean r10, okio.Buffer r11, long r12) throws java.io.IOException {
        /*
            r8 = this;
            r0 = 0
            r1 = 0
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 != 0) goto L_0x000d
            didihttp.internal.http2.a r12 = r8.f59567p
            r12.mo180003a((boolean) r10, (int) r9, (okio.Buffer) r11, (int) r0)
            return
        L_0x000d:
            int r3 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r3 <= 0) goto L_0x0062
            monitor-enter(r8)
        L_0x0012:
            long r3 = r8.f59562k     // Catch:{ InterruptedException -> 0x005a }
            int r5 = (r3 > r1 ? 1 : (r3 == r1 ? 0 : -1))
            if (r5 > 0) goto L_0x0030
            java.util.Map<java.lang.Integer, didihttp.internal.http2.Http2Stream> r3 = r8.f59555d     // Catch:{ InterruptedException -> 0x005a }
            java.lang.Integer r4 = java.lang.Integer.valueOf(r9)     // Catch:{ InterruptedException -> 0x005a }
            boolean r3 = r3.containsKey(r4)     // Catch:{ InterruptedException -> 0x005a }
            if (r3 == 0) goto L_0x0028
            r8.wait()     // Catch:{ InterruptedException -> 0x005a }
            goto L_0x0012
        L_0x0028:
            java.io.IOException r9 = new java.io.IOException     // Catch:{ InterruptedException -> 0x005a }
            java.lang.String r10 = "stream closed"
            r9.<init>(r10)     // Catch:{ InterruptedException -> 0x005a }
            throw r9     // Catch:{ InterruptedException -> 0x005a }
        L_0x0030:
            long r3 = r8.f59562k     // Catch:{ all -> 0x0058 }
            long r3 = java.lang.Math.min(r12, r3)     // Catch:{ all -> 0x0058 }
            int r4 = (int) r3     // Catch:{ all -> 0x0058 }
            didihttp.internal.http2.a r3 = r8.f59567p     // Catch:{ all -> 0x0058 }
            int r3 = r3.mo180007c()     // Catch:{ all -> 0x0058 }
            int r3 = java.lang.Math.min(r4, r3)     // Catch:{ all -> 0x0058 }
            long r4 = r8.f59562k     // Catch:{ all -> 0x0058 }
            long r6 = (long) r3     // Catch:{ all -> 0x0058 }
            long r4 = r4 - r6
            r8.f59562k = r4     // Catch:{ all -> 0x0058 }
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            long r12 = r12 - r6
            didihttp.internal.http2.a r4 = r8.f59567p
            if (r10 == 0) goto L_0x0053
            int r5 = (r12 > r1 ? 1 : (r12 == r1 ? 0 : -1))
            if (r5 != 0) goto L_0x0053
            r5 = 1
            goto L_0x0054
        L_0x0053:
            r5 = 0
        L_0x0054:
            r4.mo180003a((boolean) r5, (int) r9, (okio.Buffer) r11, (int) r3)
            goto L_0x000d
        L_0x0058:
            r9 = move-exception
            goto L_0x0060
        L_0x005a:
            java.io.InterruptedIOException r9 = new java.io.InterruptedIOException     // Catch:{ all -> 0x0058 }
            r9.<init>()     // Catch:{ all -> 0x0058 }
            throw r9     // Catch:{ all -> 0x0058 }
        L_0x0060:
            monitor-exit(r8)     // Catch:{ all -> 0x0058 }
            throw r9
        L_0x0062:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.http2.Http2Connection.writeData(int, boolean, okio.Buffer, long):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179906a(long j) {
        this.f59562k += j;
        if (j > 0) {
            notifyAll();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179901a(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        f59550a.execute(new NamedRunnable("OkHttp %s stream %d", new Object[]{this.f59556e, Integer.valueOf(i)}) {
            public void execute() {
                try {
                    Http2Connection.this.mo179911b(i2, errorCode2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo179911b(int i, ErrorCode errorCode) throws IOException {
        this.f59567p.mo179996a(i, errorCode);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179900a(int i, long j) {
        final int i2 = i;
        final long j2 = j;
        f59550a.execute(new NamedRunnable("OkHttp Window Update %s stream %d", new Object[]{this.f59556e, Integer.valueOf(i)}) {
            public void execute() {
                try {
                    Http2Connection.this.f59567p.mo179995a(i2, j2);
                } catch (IOException unused) {
                }
            }
        });
    }

    public C21776b ping() throws IOException {
        int i;
        C21776b bVar = new C21776b();
        synchronized (this) {
            if (!this.f59559h) {
                i = this.f59572v;
                this.f59572v += 2;
                if (this.f59571u == null) {
                    this.f59571u = new LinkedHashMap();
                }
                this.f59571u.put(Integer.valueOf(i), bVar);
            } else {
                throw new ConnectionShutdownException();
            }
        }
        mo179912b(false, i, 1330343787, bVar);
        return bVar;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179909a(boolean z, int i, int i2, C21776b bVar) {
        final boolean z2 = z;
        final int i3 = i;
        final int i4 = i2;
        final C21776b bVar2 = bVar;
        f59550a.execute(new NamedRunnable("OkHttp %s ping %08x%08x", new Object[]{this.f59556e, Integer.valueOf(i), Integer.valueOf(i2)}) {
            public void execute() {
                try {
                    Http2Connection.this.mo179912b(z2, i3, i4, bVar2);
                } catch (IOException unused) {
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo179912b(boolean z, int i, int i2, C21776b bVar) throws IOException {
        synchronized (this.f59567p) {
            if (bVar != null) {
                bVar.mo180010a();
            }
            this.f59567p.mo180000a(z, i, i2);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized C21776b mo179913c(int i) {
        return this.f59571u != null ? this.f59571u.remove(Integer.valueOf(i)) : null;
    }

    public void flush() throws IOException {
        this.f59567p.mo180004b();
    }

    public void shutdown(ErrorCode errorCode) throws IOException {
        synchronized (this.f59567p) {
            synchronized (this) {
                if (!this.f59559h) {
                    this.f59559h = true;
                    int i = this.f59557f;
                    this.f59567p.mo179997a(i, errorCode, C21750Util.EMPTY_BYTE_ARRAY);
                }
            }
        }
    }

    public void close() throws IOException {
        mo179907a(ErrorCode.NO_ERROR, ErrorCode.CANCEL);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179907a(ErrorCode errorCode, ErrorCode errorCode2) throws IOException {
        Http2Stream[] http2StreamArr;
        if (f59551s || !Thread.holdsLock(this)) {
            C21776b[] bVarArr = null;
            try {
                shutdown(errorCode);
                e = null;
            } catch (IOException e) {
                e = e;
            }
            synchronized (this) {
                if (!this.f59555d.isEmpty()) {
                    http2StreamArr = (Http2Stream[]) this.f59555d.values().toArray(new Http2Stream[this.f59555d.size()]);
                    this.f59555d.clear();
                } else {
                    http2StreamArr = null;
                }
                if (this.f59571u != null) {
                    this.f59571u = null;
                    bVarArr = (C21776b[]) this.f59571u.values().toArray(new C21776b[this.f59571u.size()]);
                }
            }
            if (http2StreamArr != null) {
                for (Http2Stream close : http2StreamArr) {
                    try {
                        close.close(errorCode2);
                    } catch (IOException e2) {
                        if (e != null) {
                            e = e2;
                        }
                    }
                }
            }
            if (bVarArr != null) {
                for (C21776b c : bVarArr) {
                    c.mo180012c();
                }
            }
            try {
                this.f59567p.close();
            } catch (IOException e3) {
                if (e == null) {
                    e = e3;
                }
            }
            try {
                this.f59566o.close();
            } catch (IOException e4) {
                e = e4;
            }
            if (e != null) {
                throw e;
            }
            return;
        }
        throw new AssertionError();
    }

    public void start() throws IOException {
        mo179908a(true);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179908a(boolean z) throws IOException {
        if (z) {
            this.f59567p.mo179991a();
            this.f59567p.mo180005b(this.f59563l);
            int d = this.f59563l.mo179988d();
            if (d != 65535) {
                this.f59567p.mo179995a(0, (long) (d - 65535));
            }
        }
        new Thread(this.f59568q).start();
    }

    public void setSettings(Settings settings) throws IOException {
        synchronized (this.f59567p) {
            synchronized (this) {
                if (!this.f59559h) {
                    this.f59563l.mo179981a(settings);
                    this.f59567p.mo180005b(settings);
                } else {
                    throw new ConnectionShutdownException();
                }
            }
        }
    }

    public synchronized boolean isShutdown() {
        return this.f59559h;
    }

    public static class Builder {
        boolean client;
        String hostname;
        Listener listener = Listener.REFUSE_INCOMING_STREAMS;
        PushObserver pushObserver = PushObserver.CANCEL;
        BufferedSink sink;
        Socket socket;
        BufferedSource source;

        public Builder(boolean z) {
            this.client = z;
        }

        public Builder socket(Socket socket2) throws IOException {
            return socket(socket2, ((InetSocketAddress) socket2.getRemoteSocketAddress()).getHostName(), Okio.buffer(Okio.source(socket2)), Okio.buffer(Okio.sink(socket2)));
        }

        public Builder socket(Socket socket2, String str, BufferedSource bufferedSource, BufferedSink bufferedSink) {
            this.socket = socket2;
            this.hostname = str;
            this.source = bufferedSource;
            this.sink = bufferedSink;
            return this;
        }

        public Builder listener(Listener listener2) {
            this.listener = listener2;
            return this;
        }

        public Builder pushObserver(PushObserver pushObserver2) {
            this.pushObserver = pushObserver2;
            return this;
        }

        public Http2Connection build() throws IOException {
            return new Http2Connection(this);
        }
    }

    class ReaderRunnable extends NamedRunnable implements Http2Reader.Handler {
        final Http2Reader reader;

        public void ackSettings() {
        }

        public void alternateService(int i, String str, ByteString byteString, String str2, int i2, long j) {
        }

        public void priority(int i, int i2, int i3, boolean z) {
        }

        ReaderRunnable(Http2Reader http2Reader) {
            super("OkHttp %s", Http2Connection.this.f59556e);
            this.reader = http2Reader;
        }

        /* access modifiers changed from: protected */
        /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
            r0 = didihttp.internal.http2.ErrorCode.PROTOCOL_ERROR;
            r1 = didihttp.internal.http2.ErrorCode.PROTOCOL_ERROR;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
            r2 = r4.this$0;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:19:?, code lost:
            r4.this$0.mo179907a(r0, r1);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:20:0x0030, code lost:
            didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r4.reader);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:22:0x0035, code lost:
            throw r2;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:9:0x001a, code lost:
            r2 = move-exception;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:10:0x001c */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void execute() {
            /*
                r4 = this;
                didihttp.internal.http2.ErrorCode r0 = didihttp.internal.http2.ErrorCode.INTERNAL_ERROR
                didihttp.internal.http2.ErrorCode r1 = didihttp.internal.http2.ErrorCode.INTERNAL_ERROR
                didihttp.internal.http2.Http2Reader r2 = r4.reader     // Catch:{ IOException -> 0x001c }
                r2.mo179945a((didihttp.internal.http2.Http2Reader.Handler) r4)     // Catch:{ IOException -> 0x001c }
            L_0x0009:
                didihttp.internal.http2.Http2Reader r2 = r4.reader     // Catch:{ IOException -> 0x001c }
                r3 = 0
                boolean r2 = r2.mo179946a((boolean) r3, (didihttp.internal.http2.Http2Reader.Handler) r4)     // Catch:{ IOException -> 0x001c }
                if (r2 == 0) goto L_0x0013
                goto L_0x0009
            L_0x0013:
                didihttp.internal.http2.ErrorCode r0 = didihttp.internal.http2.ErrorCode.NO_ERROR     // Catch:{ IOException -> 0x001c }
                didihttp.internal.http2.ErrorCode r1 = didihttp.internal.http2.ErrorCode.CANCEL     // Catch:{ IOException -> 0x001c }
                didihttp.internal.http2.Http2Connection r2 = didihttp.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0025 }
                goto L_0x0022
            L_0x001a:
                r2 = move-exception
                goto L_0x002b
            L_0x001c:
                didihttp.internal.http2.ErrorCode r0 = didihttp.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x001a }
                didihttp.internal.http2.ErrorCode r1 = didihttp.internal.http2.ErrorCode.PROTOCOL_ERROR     // Catch:{ all -> 0x001a }
                didihttp.internal.http2.Http2Connection r2 = didihttp.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0025 }
            L_0x0022:
                r2.mo179907a((didihttp.internal.http2.ErrorCode) r0, (didihttp.internal.http2.ErrorCode) r1)     // Catch:{ IOException -> 0x0025 }
            L_0x0025:
                didihttp.internal.http2.Http2Reader r0 = r4.reader
                didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r0)
                return
            L_0x002b:
                didihttp.internal.http2.Http2Connection r3 = didihttp.internal.http2.Http2Connection.this     // Catch:{ IOException -> 0x0030 }
                r3.mo179907a((didihttp.internal.http2.ErrorCode) r0, (didihttp.internal.http2.ErrorCode) r1)     // Catch:{ IOException -> 0x0030 }
            L_0x0030:
                didihttp.internal.http2.Http2Reader r0 = r4.reader
                didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r0)
                throw r2
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.http2.Http2Connection.ReaderRunnable.execute():void");
        }

        public void data(boolean z, int i, BufferedSource bufferedSource, int i2) throws IOException {
            if (Http2Connection.this.mo179916d(i)) {
                Http2Connection.this.mo179904a(i, bufferedSource, i2, z);
                return;
            }
            Http2Stream a = Http2Connection.this.mo179899a(i);
            if (a == null) {
                Http2Connection.this.mo179901a(i, ErrorCode.PROTOCOL_ERROR);
                bufferedSource.skip((long) i2);
                return;
            }
            a.mo179952a(bufferedSource, i2);
            if (z) {
                a.mo179948a();
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:25:0x006f, code lost:
            r0.mo179951a(r13);
         */
        /* JADX WARNING: Code restructure failed: missing block: B:26:0x0072, code lost:
            if (r10 == false) goto L_?;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:27:0x0074, code lost:
            r0.mo179948a();
         */
        /* JADX WARNING: Code restructure failed: missing block: B:35:?, code lost:
            return;
         */
        /* JADX WARNING: Code restructure failed: missing block: B:36:?, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void headers(boolean r10, int r11, int r12, java.util.List<didihttp.internal.http2.Header> r13) {
            /*
                r9 = this;
                didihttp.internal.http2.Http2Connection r12 = didihttp.internal.http2.Http2Connection.this
                boolean r12 = r12.mo179916d(r11)
                if (r12 == 0) goto L_0x000e
                didihttp.internal.http2.Http2Connection r12 = didihttp.internal.http2.Http2Connection.this
                r12.mo179903a((int) r11, (java.util.List<didihttp.internal.http2.Header>) r13, (boolean) r10)
                return
            L_0x000e:
                didihttp.internal.http2.Http2Connection r12 = didihttp.internal.http2.Http2Connection.this
                monitor-enter(r12)
                didihttp.internal.http2.Http2Connection r0 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0078 }
                boolean r0 = r0.f59559h     // Catch:{ all -> 0x0078 }
                if (r0 == 0) goto L_0x0019
                monitor-exit(r12)     // Catch:{ all -> 0x0078 }
                return
            L_0x0019:
                didihttp.internal.http2.Http2Connection r0 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0078 }
                didihttp.internal.http2.Http2Stream r0 = r0.mo179899a((int) r11)     // Catch:{ all -> 0x0078 }
                if (r0 != 0) goto L_0x006e
                didihttp.internal.http2.Http2Connection r0 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0078 }
                int r0 = r0.f59557f     // Catch:{ all -> 0x0078 }
                if (r11 > r0) goto L_0x0029
                monitor-exit(r12)     // Catch:{ all -> 0x0078 }
                return
            L_0x0029:
                int r0 = r11 % 2
                didihttp.internal.http2.Http2Connection r1 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0078 }
                int r1 = r1.f59558g     // Catch:{ all -> 0x0078 }
                r2 = 2
                int r1 = r1 % r2
                if (r0 != r1) goto L_0x0035
                monitor-exit(r12)     // Catch:{ all -> 0x0078 }
                return
            L_0x0035:
                didihttp.internal.http2.Http2Stream r0 = new didihttp.internal.http2.Http2Stream     // Catch:{ all -> 0x0078 }
                didihttp.internal.http2.Http2Connection r5 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0078 }
                r6 = 0
                r3 = r0
                r4 = r11
                r7 = r10
                r8 = r13
                r3.<init>(r4, r5, r6, r7, r8)     // Catch:{ all -> 0x0078 }
                didihttp.internal.http2.Http2Connection r10 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0078 }
                r10.f59557f = r11     // Catch:{ all -> 0x0078 }
                didihttp.internal.http2.Http2Connection r10 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0078 }
                java.util.Map<java.lang.Integer, didihttp.internal.http2.Http2Stream> r10 = r10.f59555d     // Catch:{ all -> 0x0078 }
                java.lang.Integer r13 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0078 }
                r10.put(r13, r0)     // Catch:{ all -> 0x0078 }
                java.util.concurrent.ExecutorService r10 = didihttp.internal.http2.Http2Connection.f59550a     // Catch:{ all -> 0x0078 }
                didihttp.internal.http2.Http2Connection$ReaderRunnable$1 r13 = new didihttp.internal.http2.Http2Connection$ReaderRunnable$1     // Catch:{ all -> 0x0078 }
                java.lang.String r1 = "OkHttp %s stream %d"
                java.lang.Object[] r2 = new java.lang.Object[r2]     // Catch:{ all -> 0x0078 }
                r3 = 0
                didihttp.internal.http2.Http2Connection r4 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0078 }
                java.lang.String r4 = r4.f59556e     // Catch:{ all -> 0x0078 }
                r2[r3] = r4     // Catch:{ all -> 0x0078 }
                r3 = 1
                java.lang.Integer r11 = java.lang.Integer.valueOf(r11)     // Catch:{ all -> 0x0078 }
                r2[r3] = r11     // Catch:{ all -> 0x0078 }
                r13.<init>(r1, r2, r0)     // Catch:{ all -> 0x0078 }
                r10.execute(r13)     // Catch:{ all -> 0x0078 }
                monitor-exit(r12)     // Catch:{ all -> 0x0078 }
                return
            L_0x006e:
                monitor-exit(r12)     // Catch:{ all -> 0x0078 }
                r0.mo179951a((java.util.List<didihttp.internal.http2.Header>) r13)
                if (r10 == 0) goto L_0x0077
                r0.mo179948a()
            L_0x0077:
                return
            L_0x0078:
                r10 = move-exception
                monitor-exit(r12)     // Catch:{ all -> 0x0078 }
                throw r10
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.http2.Http2Connection.ReaderRunnable.headers(boolean, int, int, java.util.List):void");
        }

        public void rstStream(int i, ErrorCode errorCode) {
            if (Http2Connection.this.mo179916d(i)) {
                Http2Connection.this.mo179914c(i, errorCode);
                return;
            }
            Http2Stream b = Http2Connection.this.mo179910b(i);
            if (b != null) {
                b.mo179950a(errorCode);
            }
        }

        /* JADX WARNING: type inference failed for: r1v13, types: [java.lang.Object[]] */
        /* JADX WARNING: Multi-variable type inference failed */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void settings(boolean r11, didihttp.internal.http2.Settings r12) {
            /*
                r10 = this;
                didihttp.internal.http2.Http2Connection r0 = didihttp.internal.http2.Http2Connection.this
                monitor-enter(r0)
                didihttp.internal.http2.Http2Connection r1 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Settings r1 = r1.f59564m     // Catch:{ all -> 0x0092 }
                int r1 = r1.mo179988d()     // Catch:{ all -> 0x0092 }
                if (r11 == 0) goto L_0x0014
                didihttp.internal.http2.Http2Connection r11 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Settings r11 = r11.f59564m     // Catch:{ all -> 0x0092 }
                r11.mo179980a()     // Catch:{ all -> 0x0092 }
            L_0x0014:
                didihttp.internal.http2.Http2Connection r11 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Settings r11 = r11.f59564m     // Catch:{ all -> 0x0092 }
                r11.mo179981a((didihttp.internal.http2.Settings) r12)     // Catch:{ all -> 0x0092 }
                r10.applyAndAckSettings(r12)     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Http2Connection r11 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Settings r11 = r11.f59564m     // Catch:{ all -> 0x0092 }
                int r11 = r11.mo179988d()     // Catch:{ all -> 0x0092 }
                r12 = -1
                r2 = 0
                r4 = 1
                r5 = 0
                if (r11 == r12) goto L_0x0064
                if (r11 == r1) goto L_0x0064
                int r11 = r11 - r1
                long r11 = (long) r11     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Http2Connection r1 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                boolean r1 = r1.f59565n     // Catch:{ all -> 0x0092 }
                if (r1 != 0) goto L_0x0040
                didihttp.internal.http2.Http2Connection r1 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                r1.mo179906a((long) r11)     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Http2Connection r1 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                r1.f59565n = r4     // Catch:{ all -> 0x0092 }
            L_0x0040:
                didihttp.internal.http2.Http2Connection r1 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                java.util.Map<java.lang.Integer, didihttp.internal.http2.Http2Stream> r1 = r1.f59555d     // Catch:{ all -> 0x0092 }
                boolean r1 = r1.isEmpty()     // Catch:{ all -> 0x0092 }
                if (r1 != 0) goto L_0x0065
                didihttp.internal.http2.Http2Connection r1 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                java.util.Map<java.lang.Integer, didihttp.internal.http2.Http2Stream> r1 = r1.f59555d     // Catch:{ all -> 0x0092 }
                java.util.Collection r1 = r1.values()     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Http2Connection r5 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                java.util.Map<java.lang.Integer, didihttp.internal.http2.Http2Stream> r5 = r5.f59555d     // Catch:{ all -> 0x0092 }
                int r5 = r5.size()     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Http2Stream[] r5 = new didihttp.internal.http2.Http2Stream[r5]     // Catch:{ all -> 0x0092 }
                java.lang.Object[] r1 = r1.toArray(r5)     // Catch:{ all -> 0x0092 }
                r5 = r1
                didihttp.internal.http2.Http2Stream[] r5 = (didihttp.internal.http2.Http2Stream[]) r5     // Catch:{ all -> 0x0092 }
                goto L_0x0065
            L_0x0064:
                r11 = r2
            L_0x0065:
                java.util.concurrent.ExecutorService r1 = didihttp.internal.http2.Http2Connection.f59550a     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Http2Connection$ReaderRunnable$2 r6 = new didihttp.internal.http2.Http2Connection$ReaderRunnable$2     // Catch:{ all -> 0x0092 }
                java.lang.String r7 = "OkHttp %s settings"
                java.lang.Object[] r4 = new java.lang.Object[r4]     // Catch:{ all -> 0x0092 }
                didihttp.internal.http2.Http2Connection r8 = didihttp.internal.http2.Http2Connection.this     // Catch:{ all -> 0x0092 }
                java.lang.String r8 = r8.f59556e     // Catch:{ all -> 0x0092 }
                r9 = 0
                r4[r9] = r8     // Catch:{ all -> 0x0092 }
                r6.<init>(r7, r4)     // Catch:{ all -> 0x0092 }
                r1.execute(r6)     // Catch:{ all -> 0x0092 }
                monitor-exit(r0)     // Catch:{ all -> 0x0092 }
                if (r5 == 0) goto L_0x0091
                int r0 = (r11 > r2 ? 1 : (r11 == r2 ? 0 : -1))
                if (r0 == 0) goto L_0x0091
                int r0 = r5.length
            L_0x0082:
                if (r9 >= r0) goto L_0x0091
                r1 = r5[r9]
                monitor-enter(r1)
                r1.mo179949a((long) r11)     // Catch:{ all -> 0x008e }
                monitor-exit(r1)     // Catch:{ all -> 0x008e }
                int r9 = r9 + 1
                goto L_0x0082
            L_0x008e:
                r11 = move-exception
                monitor-exit(r1)     // Catch:{ all -> 0x008e }
                throw r11
            L_0x0091:
                return
            L_0x0092:
                r11 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0092 }
                throw r11
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.http2.Http2Connection.ReaderRunnable.settings(boolean, didihttp.internal.http2.Settings):void");
        }

        private void applyAndAckSettings(final Settings settings) {
            Http2Connection.f59550a.execute(new NamedRunnable("OkHttp %s ACK Settings", new Object[]{Http2Connection.this.f59556e}) {
                public void execute() {
                    try {
                        Http2Connection.this.f59567p.mo179999a(settings);
                    } catch (IOException unused) {
                    }
                }
            });
        }

        public void ping(boolean z, int i, int i2) {
            if (z) {
                C21776b c = Http2Connection.this.mo179913c(i);
                if (c != null) {
                    c.mo180011b();
                    return;
                }
                return;
            }
            Http2Connection.this.mo179909a(true, i, i2, (C21776b) null);
        }

        public void goAway(int i, ErrorCode errorCode, ByteString byteString) {
            Http2Stream[] http2StreamArr;
            byteString.size();
            synchronized (Http2Connection.this) {
                http2StreamArr = (Http2Stream[]) Http2Connection.this.f59555d.values().toArray(new Http2Stream[Http2Connection.this.f59555d.size()]);
                Http2Connection.this.f59559h = true;
            }
            for (Http2Stream http2Stream : http2StreamArr) {
                if (http2Stream.getId() > i && http2Stream.isLocallyInitiated()) {
                    http2Stream.mo179950a(ErrorCode.REFUSED_STREAM);
                    Http2Connection.this.mo179910b(http2Stream.getId());
                }
            }
        }

        public void windowUpdate(int i, long j) {
            if (i == 0) {
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f59562k += j;
                    Http2Connection.this.notifyAll();
                }
                return;
            }
            Http2Stream a = Http2Connection.this.mo179899a(i);
            if (a != null) {
                synchronized (a) {
                    a.mo179949a(j);
                }
            }
        }

        public void pushPromise(int i, int i2, List<Header> list) {
            Http2Connection.this.mo179902a(i2, list);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179902a(int i, List<Header> list) {
        synchronized (this) {
            if (this.f59569r.contains(Integer.valueOf(i))) {
                mo179901a(i, ErrorCode.PROTOCOL_ERROR);
                return;
            }
            this.f59569r.add(Integer.valueOf(i));
            final int i2 = i;
            final List<Header> list2 = list;
            this.f59570t.execute(new NamedRunnable("OkHttp %s Push Request[%s]", new Object[]{this.f59556e, Integer.valueOf(i)}) {
                public void execute() {
                    if (Http2Connection.this.f59560i.onRequest(i2, list2)) {
                        try {
                            Http2Connection.this.f59567p.mo179996a(i2, ErrorCode.CANCEL);
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.f59569r.remove(Integer.valueOf(i2));
                            }
                        } catch (IOException unused) {
                        }
                    }
                }
            });
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179903a(int i, List<Header> list, boolean z) {
        final int i2 = i;
        final List<Header> list2 = list;
        final boolean z2 = z;
        this.f59570t.execute(new NamedRunnable("OkHttp %s Push Headers[%s]", new Object[]{this.f59556e, Integer.valueOf(i)}) {
            public void execute() {
                boolean onHeaders = Http2Connection.this.f59560i.onHeaders(i2, list2, z2);
                if (onHeaders) {
                    try {
                        Http2Connection.this.f59567p.mo179996a(i2, ErrorCode.CANCEL);
                    } catch (IOException unused) {
                        return;
                    }
                }
                if (onHeaders || z2) {
                    synchronized (Http2Connection.this) {
                        Http2Connection.this.f59569r.remove(Integer.valueOf(i2));
                    }
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo179904a(int i, BufferedSource bufferedSource, int i2, boolean z) throws IOException {
        final Buffer buffer = new Buffer();
        long j = (long) i2;
        bufferedSource.require(j);
        bufferedSource.read(buffer, j);
        if (buffer.size() == j) {
            final int i3 = i;
            final int i4 = i2;
            final boolean z2 = z;
            this.f59570t.execute(new NamedRunnable("OkHttp %s Push Data[%s]", new Object[]{this.f59556e, Integer.valueOf(i)}) {
                public void execute() {
                    try {
                        boolean onData = Http2Connection.this.f59560i.onData(i3, buffer, i4, z2);
                        if (onData) {
                            Http2Connection.this.f59567p.mo179996a(i3, ErrorCode.CANCEL);
                        }
                        if (onData || z2) {
                            synchronized (Http2Connection.this) {
                                Http2Connection.this.f59569r.remove(Integer.valueOf(i3));
                            }
                        }
                    } catch (IOException unused) {
                    }
                }
            });
            return;
        }
        throw new IOException(buffer.size() + " != " + i2);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo179914c(int i, ErrorCode errorCode) {
        final int i2 = i;
        final ErrorCode errorCode2 = errorCode;
        this.f59570t.execute(new NamedRunnable("OkHttp %s Push Reset[%s]", new Object[]{this.f59556e, Integer.valueOf(i)}) {
            public void execute() {
                Http2Connection.this.f59560i.onReset(i2, errorCode2);
                synchronized (Http2Connection.this) {
                    Http2Connection.this.f59569r.remove(Integer.valueOf(i2));
                }
            }
        });
    }
}
