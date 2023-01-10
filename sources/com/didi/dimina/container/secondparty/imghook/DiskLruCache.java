package com.didi.dimina.container.secondparty.imghook;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.facebook.cache.disk.DefaultDiskStorage;
import didihttp.internal.C21750Util;
import didihttp.internal.p231io.FileSystem;
import didihttp.internal.platform.Platform;
import java.io.Closeable;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.Flushable;
import java.io.IOException;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.Buffer;
import okio.BufferedSink;
import okio.ForwardingSink;
import okio.Okio;
import okio.Sink;
import okio.Source;

final class DiskLruCache implements Closeable, Flushable {

    /* renamed from: a */
    static final String f19023a = "journal";

    /* renamed from: b */
    static final String f19024b = "journal.tmp";

    /* renamed from: c */
    static final String f19025c = "journal.bkp";

    /* renamed from: d */
    static final String f19026d = "libcore.io.DiskLruCache";

    /* renamed from: e */
    static final String f19027e = "1";

    /* renamed from: f */
    static final long f19028f = -1;

    /* renamed from: g */
    static final Pattern f19029g = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: s */
    static final /* synthetic */ boolean f19030s = (!DiskLruCache.class.desiredAssertionStatus());

    /* renamed from: t */
    private static final String f19031t = "CLEAN";

    /* renamed from: u */
    private static final String f19032u = "DIRTY";

    /* renamed from: v */
    private static final String f19033v = "REMOVE";

    /* renamed from: w */
    private static final String f19034w = "READ";

    /* renamed from: A */
    private final int f19035A;

    /* renamed from: B */
    private final long f19036B;

    /* renamed from: C */
    private long f19037C = 0;

    /* renamed from: D */
    private long f19038D = 0;

    /* renamed from: E */
    private final Executor f19039E;

    /* renamed from: F */
    private final Runnable f19040F = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r5.this$0.f19051r = true;
            r5.this$0.f19044k = okio.Okio.buffer(okio.Okio.blackhole());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0033 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                com.didi.dimina.container.secondparty.imghook.DiskLruCache r0 = com.didi.dimina.container.secondparty.imghook.DiskLruCache.this
                monitor-enter(r0)
                com.didi.dimina.container.secondparty.imghook.DiskLruCache r1 = com.didi.dimina.container.secondparty.imghook.DiskLruCache.this     // Catch:{ all -> 0x0045 }
                boolean r1 = r1.f19048o     // Catch:{ all -> 0x0045 }
                r2 = 0
                r3 = 1
                if (r1 != 0) goto L_0x000d
                r1 = 1
                goto L_0x000e
            L_0x000d:
                r1 = 0
            L_0x000e:
                com.didi.dimina.container.secondparty.imghook.DiskLruCache r4 = com.didi.dimina.container.secondparty.imghook.DiskLruCache.this     // Catch:{ all -> 0x0045 }
                boolean r4 = r4.f19049p     // Catch:{ all -> 0x0045 }
                r1 = r1 | r4
                if (r1 == 0) goto L_0x0017
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                return
            L_0x0017:
                com.didi.dimina.container.secondparty.imghook.DiskLruCache r1 = com.didi.dimina.container.secondparty.imghook.DiskLruCache.this     // Catch:{ IOException -> 0x001d }
                r1.mo60627g()     // Catch:{ IOException -> 0x001d }
                goto L_0x0021
            L_0x001d:
                com.didi.dimina.container.secondparty.imghook.DiskLruCache r1 = com.didi.dimina.container.secondparty.imghook.DiskLruCache.this     // Catch:{ all -> 0x0045 }
                r1.f19050q = r3     // Catch:{ all -> 0x0045 }
            L_0x0021:
                com.didi.dimina.container.secondparty.imghook.DiskLruCache r1 = com.didi.dimina.container.secondparty.imghook.DiskLruCache.this     // Catch:{ IOException -> 0x0033 }
                boolean r1 = r1.mo60624e()     // Catch:{ IOException -> 0x0033 }
                if (r1 == 0) goto L_0x0043
                com.didi.dimina.container.secondparty.imghook.DiskLruCache r1 = com.didi.dimina.container.secondparty.imghook.DiskLruCache.this     // Catch:{ IOException -> 0x0033 }
                r1.mo60619b()     // Catch:{ IOException -> 0x0033 }
                com.didi.dimina.container.secondparty.imghook.DiskLruCache r1 = com.didi.dimina.container.secondparty.imghook.DiskLruCache.this     // Catch:{ IOException -> 0x0033 }
                r1.f19046m = r2     // Catch:{ IOException -> 0x0033 }
                goto L_0x0043
            L_0x0033:
                com.didi.dimina.container.secondparty.imghook.DiskLruCache r1 = com.didi.dimina.container.secondparty.imghook.DiskLruCache.this     // Catch:{ all -> 0x0045 }
                r1.f19051r = r3     // Catch:{ all -> 0x0045 }
                com.didi.dimina.container.secondparty.imghook.DiskLruCache r1 = com.didi.dimina.container.secondparty.imghook.DiskLruCache.this     // Catch:{ all -> 0x0045 }
                okio.Sink r2 = okio.Okio.blackhole()     // Catch:{ all -> 0x0045 }
                okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x0045 }
                r1.f19044k = r2     // Catch:{ all -> 0x0045 }
            L_0x0043:
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                return
            L_0x0045:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.imghook.DiskLruCache.C81561.run():void");
        }
    };

    /* renamed from: h */
    final FileSystem f19041h;

    /* renamed from: i */
    final File f19042i;

    /* renamed from: j */
    final int f19043j;

    /* renamed from: k */
    BufferedSink f19044k;

    /* renamed from: l */
    final LinkedHashMap<String, Entry> f19045l = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m */
    int f19046m;

    /* renamed from: n */
    boolean f19047n;

    /* renamed from: o */
    boolean f19048o;

    /* renamed from: p */
    boolean f19049p;

    /* renamed from: q */
    boolean f19050q;

    /* renamed from: r */
    boolean f19051r;

    /* renamed from: x */
    private final File f19052x;

    /* renamed from: y */
    private final File f19053y;

    /* renamed from: z */
    private final File f19054z;

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.f19041h = fileSystem;
        this.f19042i = file;
        this.f19035A = i;
        this.f19052x = new File(file, "journal");
        this.f19053y = new File(file, "journal.tmp");
        this.f19054z = new File(file, "journal.bkp");
        this.f19043j = i2;
        this.f19036B = j;
        this.f19039E = executor;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo60616a(Runnable runnable) {
        Executor executor = this.f19039E;
        if (executor != null) {
            executor.execute(runnable);
        }
    }

    /* renamed from: a */
    public synchronized void mo60614a() throws IOException {
        if (!f19030s) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (!this.f19048o) {
            if (this.f19041h.exists(this.f19054z)) {
                if (this.f19041h.exists(this.f19052x)) {
                    this.f19041h.delete(this.f19054z);
                } else {
                    this.f19041h.rename(this.f19054z, this.f19052x);
                }
            }
            if (this.f19041h.exists(this.f19052x)) {
                try {
                    m16162j();
                    m16164l();
                    this.f19048o = true;
                    return;
                } catch (IOException e) {
                    Platform platform = Platform.get();
                    platform.log(5, "DiskLruCache " + this.f19042i + " is corrupt: " + e.getMessage() + ", removing", e);
                    mo60628h();
                    this.f19049p = false;
                } catch (Throwable th) {
                    this.f19049p = false;
                    throw th;
                }
            }
            mo60619b();
            this.f19048o = true;
        }
    }

    /* renamed from: a */
    public static DiskLruCache m16159a(FileSystem fileSystem, File file, int i, int i2, long j) {
        if (j <= 0) {
            throw new IllegalArgumentException("maxSize <= 0");
        } else if (i2 > 0) {
            return new DiskLruCache(fileSystem, file, i, i2, j, new ThreadPoolExecutor(0, 1, 60, TimeUnit.SECONDS, new LinkedBlockingQueue(), C21750Util.threadFactory("OkHttp DiskLruCache", true)));
        } else {
            throw new IllegalArgumentException("valueCount <= 0");
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:16|17|(1:19)(1:20)|21|22) */
    /* JADX WARNING: Code restructure failed: missing block: B:17:?, code lost:
        r9.f19046m = r0 - r9.f19045l.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r1.exhausted() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        mo60619b();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9.f19044k = m16163k();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x007a=Splitter:B:23:0x007a, B:16:0x005d=Splitter:B:16:0x005d} */
    /* renamed from: j */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m16162j() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            didihttp.internal.io.FileSystem r1 = r9.f19041h
            java.io.File r2 = r9.f19052x
            okio.Source r1 = r1.source(r2)
            okio.BufferedSource r1 = okio.Okio.buffer((okio.Source) r1)
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r3 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r5 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r6 = r1.readUtf8LineStrict()     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = "libcore.io.DiskLruCache"
            boolean r7 = r7.equals(r2)     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x007a
            java.lang.String r7 = "1"
            boolean r7 = r7.equals(r3)     // Catch:{ all -> 0x00a8 }
            if (r7 == 0) goto L_0x007a
            int r7 = r9.f19035A     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            int r4 = r9.f19043j     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x005d }
            r9.m16160d(r2)     // Catch:{ EOFException -> 0x005d }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry> r2 = r9.f19045l     // Catch:{ all -> 0x00a8 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a8 }
            int r0 = r0 - r2
            r9.f19046m = r0     // Catch:{ all -> 0x00a8 }
            boolean r0 = r1.exhausted()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x0070
            r9.mo60619b()     // Catch:{ all -> 0x00a8 }
            goto L_0x0076
        L_0x0070:
            okio.BufferedSink r0 = r9.m16163k()     // Catch:{ all -> 0x00a8 }
            r9.f19044k = r0     // Catch:{ all -> 0x00a8 }
        L_0x0076:
            didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r1)
            return
        L_0x007a:
            java.io.IOException r4 = new java.io.IOException     // Catch:{ all -> 0x00a8 }
            java.lang.StringBuilder r7 = new java.lang.StringBuilder     // Catch:{ all -> 0x00a8 }
            r7.<init>()     // Catch:{ all -> 0x00a8 }
            java.lang.String r8 = "unexpected journal header: ["
            r7.append(r8)     // Catch:{ all -> 0x00a8 }
            r7.append(r2)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r3)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r5)     // Catch:{ all -> 0x00a8 }
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            r7.append(r6)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = "]"
            r7.append(r0)     // Catch:{ all -> 0x00a8 }
            java.lang.String r0 = r7.toString()     // Catch:{ all -> 0x00a8 }
            r4.<init>(r0)     // Catch:{ all -> 0x00a8 }
            throw r4     // Catch:{ all -> 0x00a8 }
        L_0x00a8:
            r0 = move-exception
            didihttp.internal.C21750Util.closeQuietly((java.io.Closeable) r1)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.imghook.DiskLruCache.m16162j():void");
    }

    /* renamed from: k */
    private BufferedSink m16163k() throws FileNotFoundException {
        return Okio.buffer((Sink) new FaultHidingSink(this.f19041h.appendingSink(this.f19052x)) {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<DiskLruCache> cls = DiskLruCache.class;
            }

            /* access modifiers changed from: protected */
            public void onException(IOException iOException) {
                DiskLruCache.this.f19047n = true;
            }
        });
    }

    /* renamed from: d */
    private void m16160d(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f19045l.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            Entry entry = this.f19045l.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.f19045l.put(str2, entry);
            }
            if (indexOf2 != -1 && indexOf == 5 && str.startsWith("CLEAN")) {
                String[] split = str.substring(indexOf2 + 1).split(" ");
                entry.readable = true;
                entry.currentEditor = null;
                entry.setLengths(split);
            } else if (indexOf2 == -1 && indexOf == 5 && str.startsWith("DIRTY")) {
                entry.currentEditor = new Editor(entry);
            } else if (indexOf2 != -1 || indexOf != 4 || !str.startsWith("READ")) {
                throw new IOException("unexpected journal line: " + str);
            }
        } else {
            throw new IOException("unexpected journal line: " + str);
        }
    }

    /* renamed from: l */
    private void m16164l() throws IOException {
        this.f19041h.delete(this.f19053y);
        Iterator<Entry> it = this.f19045l.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.f19043j) {
                    this.f19037C += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.f19043j) {
                    this.f19041h.delete(next.cleanFiles[i]);
                    this.f19041h.delete(next.dirtyFiles[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized void mo60619b() throws IOException {
        if (this.f19044k != null) {
            this.f19044k.close();
        }
        BufferedSink buffer = Okio.buffer(this.f19041h.sink(this.f19053y));
        try {
            buffer.writeUtf8(f19026d).writeByte(10);
            buffer.writeUtf8("1").writeByte(10);
            buffer.writeDecimalLong((long) this.f19035A).writeByte(10);
            buffer.writeDecimalLong((long) this.f19043j).writeByte(10);
            buffer.writeByte(10);
            for (Entry next : this.f19045l.values()) {
                if (next.currentEditor != null) {
                    buffer.writeUtf8("DIRTY").writeByte(32);
                    buffer.writeUtf8(next.key);
                    buffer.writeByte(10);
                } else {
                    buffer.writeUtf8("CLEAN").writeByte(32);
                    buffer.writeUtf8(next.key);
                    next.writeLengths(buffer);
                    buffer.writeByte(10);
                }
            }
            buffer.close();
            if (this.f19041h.exists(this.f19052x)) {
                this.f19041h.rename(this.f19052x, this.f19054z);
            }
            this.f19041h.rename(this.f19053y, this.f19052x);
            this.f19041h.delete(this.f19054z);
            this.f19044k = m16163k();
            this.f19047n = false;
            this.f19051r = false;
        } catch (Throwable th) {
            buffer.close();
            throw th;
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:16:0x004d, code lost:
        return r0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x004f, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.didi.dimina.container.secondparty.imghook.DiskLruCache.Snapshot mo60613a(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.mo60614a()     // Catch:{ all -> 0x0050 }
            r3.m16165m()     // Catch:{ all -> 0x0050 }
            r3.m16161e(r4)     // Catch:{ all -> 0x0050 }
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry> r0 = r3.f19045l     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0050 }
            com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry r0 = (com.didi.dimina.container.secondparty.imghook.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0050 }
            r1 = 0
            if (r0 == 0) goto L_0x004e
            boolean r2 = r0.readable     // Catch:{ all -> 0x0050 }
            if (r2 != 0) goto L_0x001a
            goto L_0x004e
        L_0x001a:
            com.didi.dimina.container.secondparty.imghook.DiskLruCache$Snapshot r0 = r0.snapshot()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.f19046m     // Catch:{ all -> 0x0050 }
            int r1 = r1 + 1
            r3.f19046m = r1     // Catch:{ all -> 0x0050 }
            okio.BufferedSink r1 = r3.f19044k     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = "READ"
            okio.BufferedSink r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x0050 }
            r2 = 32
            okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x0050 }
            okio.BufferedSink r4 = r1.writeUtf8(r4)     // Catch:{ all -> 0x0050 }
            r1 = 10
            r4.writeByte(r1)     // Catch:{ all -> 0x0050 }
            boolean r4 = r3.mo60624e()     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x004c
            java.util.concurrent.Executor r4 = r3.f19039E     // Catch:{ all -> 0x0050 }
            java.lang.Runnable r1 = r3.f19040F     // Catch:{ all -> 0x0050 }
            r4.execute(r1)     // Catch:{ all -> 0x0050 }
        L_0x004c:
            monitor-exit(r3)
            return r0
        L_0x004e:
            monitor-exit(r3)
            return r1
        L_0x0050:
            r4 = move-exception
            monitor-exit(r3)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.imghook.DiskLruCache.mo60613a(java.lang.String):com.didi.dimina.container.secondparty.imghook.DiskLruCache$Snapshot");
    }

    /* renamed from: b */
    public Editor mo60618b(String str) throws IOException {
        return mo60612a(str, -1);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.didi.dimina.container.secondparty.imghook.DiskLruCache.Editor mo60612a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.mo60614a()     // Catch:{ all -> 0x0074 }
            r5.m16165m()     // Catch:{ all -> 0x0074 }
            r5.m16161e(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry> r0 = r5.f19045l     // Catch:{ all -> 0x0074 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0074 }
            com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry r0 = (com.didi.dimina.container.secondparty.imghook.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0074 }
            r1 = -1
            r3 = 0
            int r4 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
            if (r4 == 0) goto L_0x0023
            if (r0 == 0) goto L_0x0021
            long r1 = r0.sequenceNumber     // Catch:{ all -> 0x0074 }
            int r4 = (r1 > r7 ? 1 : (r1 == r7 ? 0 : -1))
            if (r4 == 0) goto L_0x0023
        L_0x0021:
            monitor-exit(r5)
            return r3
        L_0x0023:
            if (r0 == 0) goto L_0x002b
            com.didi.dimina.container.secondparty.imghook.DiskLruCache$Editor r7 = r0.currentEditor     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x002b
            monitor-exit(r5)
            return r3
        L_0x002b:
            boolean r7 = r5.f19050q     // Catch:{ all -> 0x0074 }
            if (r7 != 0) goto L_0x006b
            boolean r7 = r5.f19051r     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0034
            goto L_0x006b
        L_0x0034:
            okio.BufferedSink r7 = r5.f19044k     // Catch:{ all -> 0x0074 }
            java.lang.String r8 = "DIRTY"
            okio.BufferedSink r7 = r7.writeUtf8(r8)     // Catch:{ all -> 0x0074 }
            r8 = 32
            okio.BufferedSink r7 = r7.writeByte(r8)     // Catch:{ all -> 0x0074 }
            okio.BufferedSink r7 = r7.writeUtf8(r6)     // Catch:{ all -> 0x0074 }
            r8 = 10
            r7.writeByte(r8)     // Catch:{ all -> 0x0074 }
            okio.BufferedSink r7 = r5.f19044k     // Catch:{ all -> 0x0074 }
            r7.flush()     // Catch:{ all -> 0x0074 }
            boolean r7 = r5.f19047n     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0056
            monitor-exit(r5)
            return r3
        L_0x0056:
            if (r0 != 0) goto L_0x0062
            com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry r0 = new com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry     // Catch:{ all -> 0x0074 }
            r0.<init>(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry> r7 = r5.f19045l     // Catch:{ all -> 0x0074 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0074 }
        L_0x0062:
            com.didi.dimina.container.secondparty.imghook.DiskLruCache$Editor r6 = new com.didi.dimina.container.secondparty.imghook.DiskLruCache$Editor     // Catch:{ all -> 0x0074 }
            r6.<init>(r0)     // Catch:{ all -> 0x0074 }
            r0.currentEditor = r6     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r6
        L_0x006b:
            java.util.concurrent.Executor r6 = r5.f19039E     // Catch:{ all -> 0x0074 }
            java.lang.Runnable r7 = r5.f19040F     // Catch:{ all -> 0x0074 }
            r6.execute(r7)     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r3
        L_0x0074:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.imghook.DiskLruCache.mo60612a(java.lang.String, long):com.didi.dimina.container.secondparty.imghook.DiskLruCache$Editor");
    }

    /* renamed from: c */
    public File mo60620c() {
        return this.f19042i;
    }

    /* renamed from: d */
    public synchronized long mo60623d() throws IOException {
        mo60614a();
        return this.f19037C;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f4, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo60615a(com.didi.dimina.container.secondparty.imghook.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry r0 = r10.entry     // Catch:{ all -> 0x00fb }
            com.didi.dimina.container.secondparty.imghook.DiskLruCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x00fb }
            if (r1 != r10) goto L_0x00f5
            r1 = 0
            if (r11 == 0) goto L_0x0047
            boolean r2 = r0.readable     // Catch:{ all -> 0x00fb }
            if (r2 != 0) goto L_0x0047
            r2 = 0
        L_0x000f:
            int r3 = r9.f19043j     // Catch:{ all -> 0x00fb }
            if (r2 >= r3) goto L_0x0047
            boolean[] r3 = r10.written     // Catch:{ all -> 0x00fb }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fb }
            if (r3 == 0) goto L_0x002d
            didihttp.internal.io.FileSystem r3 = r9.f19041h     // Catch:{ all -> 0x00fb }
            java.io.File[] r4 = r0.dirtyFiles     // Catch:{ all -> 0x00fb }
            r4 = r4[r2]     // Catch:{ all -> 0x00fb }
            boolean r3 = r3.exists(r4)     // Catch:{ all -> 0x00fb }
            if (r3 != 0) goto L_0x002a
            r10.abort()     // Catch:{ all -> 0x00fb }
            monitor-exit(r9)
            return
        L_0x002a:
            int r2 = r2 + 1
            goto L_0x000f
        L_0x002d:
            r10.abort()     // Catch:{ all -> 0x00fb }
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            java.lang.StringBuilder r11 = new java.lang.StringBuilder     // Catch:{ all -> 0x00fb }
            r11.<init>()     // Catch:{ all -> 0x00fb }
            java.lang.String r0 = "Newly created entry didn't create value for index "
            r11.append(r0)     // Catch:{ all -> 0x00fb }
            r11.append(r2)     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r11.toString()     // Catch:{ all -> 0x00fb }
            r10.<init>(r11)     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x0047:
            int r10 = r9.f19043j     // Catch:{ all -> 0x00fb }
            if (r1 >= r10) goto L_0x007f
            java.io.File[] r10 = r0.dirtyFiles     // Catch:{ all -> 0x00fb }
            r10 = r10[r1]     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x0077
            didihttp.internal.io.FileSystem r2 = r9.f19041h     // Catch:{ all -> 0x00fb }
            boolean r2 = r2.exists(r10)     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x007c
            java.io.File[] r2 = r0.cleanFiles     // Catch:{ all -> 0x00fb }
            r2 = r2[r1]     // Catch:{ all -> 0x00fb }
            didihttp.internal.io.FileSystem r3 = r9.f19041h     // Catch:{ all -> 0x00fb }
            r3.rename(r10, r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x00fb }
            r3 = r10[r1]     // Catch:{ all -> 0x00fb }
            didihttp.internal.io.FileSystem r10 = r9.f19041h     // Catch:{ all -> 0x00fb }
            long r5 = r10.size(r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x00fb }
            r10[r1] = r5     // Catch:{ all -> 0x00fb }
            long r7 = r9.f19037C     // Catch:{ all -> 0x00fb }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f19037C = r7     // Catch:{ all -> 0x00fb }
            goto L_0x007c
        L_0x0077:
            didihttp.internal.io.FileSystem r2 = r9.f19041h     // Catch:{ all -> 0x00fb }
            r2.delete(r10)     // Catch:{ all -> 0x00fb }
        L_0x007c:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x007f:
            int r10 = r9.f19046m     // Catch:{ all -> 0x00fb }
            r1 = 1
            int r10 = r10 + r1
            r9.f19046m = r10     // Catch:{ all -> 0x00fb }
            r10 = 0
            r0.currentEditor = r10     // Catch:{ all -> 0x00fb }
            boolean r10 = r0.readable     // Catch:{ all -> 0x00fb }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00bb
            r0.readable = r1     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f19044k     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "CLEAN"
            okio.BufferedSink r10 = r10.writeUtf8(r1)     // Catch:{ all -> 0x00fb }
            r10.writeByte(r3)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f19044k     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = r0.key     // Catch:{ all -> 0x00fb }
            r10.writeUtf8(r1)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f19044k     // Catch:{ all -> 0x00fb }
            r0.writeLengths(r10)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f19044k     // Catch:{ all -> 0x00fb }
            r10.writeByte(r2)     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x00d9
            long r10 = r9.f19038D     // Catch:{ all -> 0x00fb }
            r1 = 1
            long r1 = r1 + r10
            r9.f19038D = r1     // Catch:{ all -> 0x00fb }
            r0.sequenceNumber = r10     // Catch:{ all -> 0x00fb }
            goto L_0x00d9
        L_0x00bb:
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry> r10 = r9.f19045l     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x00fb }
            r10.remove(r11)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f19044k     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = "REMOVE"
            okio.BufferedSink r10 = r10.writeUtf8(r11)     // Catch:{ all -> 0x00fb }
            r10.writeByte(r3)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f19044k     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x00fb }
            r10.writeUtf8(r11)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f19044k     // Catch:{ all -> 0x00fb }
            r10.writeByte(r2)     // Catch:{ all -> 0x00fb }
        L_0x00d9:
            okio.BufferedSink r10 = r9.f19044k     // Catch:{ all -> 0x00fb }
            r10.flush()     // Catch:{ all -> 0x00fb }
            long r10 = r9.f19037C     // Catch:{ all -> 0x00fb }
            long r0 = r9.f19036B     // Catch:{ all -> 0x00fb }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ec
            boolean r10 = r9.mo60624e()     // Catch:{ all -> 0x00fb }
            if (r10 == 0) goto L_0x00f3
        L_0x00ec:
            java.util.concurrent.Executor r10 = r9.f19039E     // Catch:{ all -> 0x00fb }
            java.lang.Runnable r11 = r9.f19040F     // Catch:{ all -> 0x00fb }
            r10.execute(r11)     // Catch:{ all -> 0x00fb }
        L_0x00f3:
            monitor-exit(r9)
            return
        L_0x00f5:
            java.lang.IllegalStateException r10 = new java.lang.IllegalStateException     // Catch:{ all -> 0x00fb }
            r10.<init>()     // Catch:{ all -> 0x00fb }
            throw r10     // Catch:{ all -> 0x00fb }
        L_0x00fb:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.imghook.DiskLruCache.mo60615a(com.didi.dimina.container.secondparty.imghook.DiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public boolean mo60624e() {
        int i = this.f19046m;
        return i >= 2000 && i >= this.f19045l.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r7;
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean mo60621c(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.mo60614a()     // Catch:{ all -> 0x0029 }
            r6.m16165m()     // Catch:{ all -> 0x0029 }
            r6.m16161e(r7)     // Catch:{ all -> 0x0029 }
            java.util.LinkedHashMap<java.lang.String, com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry> r0 = r6.f19045l     // Catch:{ all -> 0x0029 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0029 }
            com.didi.dimina.container.secondparty.imghook.DiskLruCache$Entry r7 = (com.didi.dimina.container.secondparty.imghook.DiskLruCache.Entry) r7     // Catch:{ all -> 0x0029 }
            r0 = 0
            if (r7 != 0) goto L_0x0017
            monitor-exit(r6)
            return r0
        L_0x0017:
            boolean r7 = r6.mo60617a((com.didi.dimina.container.secondparty.imghook.DiskLruCache.Entry) r7)     // Catch:{ all -> 0x0029 }
            if (r7 == 0) goto L_0x0027
            long r1 = r6.f19037C     // Catch:{ all -> 0x0029 }
            long r3 = r6.f19036B     // Catch:{ all -> 0x0029 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0027
            r6.f19050q = r0     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r6)
            return r7
        L_0x0029:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.secondparty.imghook.DiskLruCache.mo60621c(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo60617a(Entry entry) throws IOException {
        if (entry.currentEditor != null) {
            entry.currentEditor.detach();
        }
        for (int i = 0; i < this.f19043j; i++) {
            this.f19041h.delete(entry.cleanFiles[i]);
            this.f19037C -= entry.lengths[i];
            entry.lengths[i] = 0;
        }
        this.f19046m++;
        this.f19044k.writeUtf8("REMOVE").writeByte(32).writeUtf8(entry.key).writeByte(10);
        this.f19045l.remove(entry.key);
        if (mo60624e()) {
            this.f19039E.execute(this.f19040F);
        }
        return true;
    }

    /* renamed from: f */
    public synchronized boolean mo60625f() {
        return this.f19049p;
    }

    /* renamed from: m */
    private synchronized void m16165m() {
        if (mo60625f()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        if (this.f19048o) {
            m16165m();
            mo60627g();
            this.f19044k.flush();
        }
    }

    public synchronized void close() throws IOException {
        if (this.f19048o) {
            if (!this.f19049p) {
                for (Entry entry : (Entry[]) this.f19045l.values().toArray(new Entry[this.f19045l.size()])) {
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
                mo60627g();
                this.f19044k.close();
                this.f19044k = null;
                this.f19049p = true;
                return;
            }
        }
        this.f19049p = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public void mo60627g() throws IOException {
        while (this.f19037C > this.f19036B) {
            mo60617a(this.f19045l.values().iterator().next());
        }
        this.f19050q = false;
    }

    /* renamed from: h */
    public void mo60628h() throws IOException {
        close();
        this.f19041h.deleteContents(this.f19042i);
    }

    /* renamed from: i */
    public synchronized void mo60629i() throws IOException {
        mo60614a();
        for (Entry a : (Entry[]) this.f19045l.values().toArray(new Entry[this.f19045l.size()])) {
            mo60617a(a);
        }
        this.f19050q = false;
    }

    /* renamed from: e */
    private void m16161e(String str) {
        if (!f19029g.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + Const.jsQuote);
        }
    }

    public final class Snapshot implements Closeable {
        private final File[] files;
        private final String key;
        private final long sequenceNumber;
        private final Source[] sources;

        Snapshot(String str, long j, File[] fileArr, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.files = fileArr;
        }

        public String key() {
            return this.key;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.mo60612a(this.key, this.sequenceNumber);
        }

        public Source getSource(int i) {
            return this.sources[i];
        }

        public File getFile(int i) {
            return this.files[i];
        }

        public void close() {
            for (Source closeQuietly : this.sources) {
                C21750Util.closeQuietly((Closeable) closeQuietly);
            }
        }
    }

    public final class Editor {
        private boolean done;
        final Entry entry;
        final boolean[] written;

        Editor(Entry entry2) {
            this.entry = entry2;
            this.written = entry2.readable ? null : new boolean[DiskLruCache.this.f19043j];
        }

        /* access modifiers changed from: package-private */
        public void detach() {
            if (this.entry.currentEditor == this) {
                for (int i = 0; i < DiskLruCache.this.f19043j; i++) {
                    try {
                        DiskLruCache.this.f19041h.delete(this.entry.dirtyFiles[i]);
                    } catch (IOException unused) {
                    }
                }
                this.entry.currentEditor = null;
            }
        }

        public Sink newSink(int i) {
            synchronized (DiskLruCache.this) {
                if (this.done) {
                    throw new IllegalStateException();
                } else if (this.entry.currentEditor != this) {
                    Sink blackhole = Okio.blackhole();
                    return blackhole;
                } else {
                    if (!this.entry.readable) {
                        this.written[i] = true;
                    }
                    try {
                        C81581 r1 = new FaultHidingSink(DiskLruCache.this.f19041h.sink(this.entry.dirtyFiles[i])) {
                            /* access modifiers changed from: protected */
                            public void onException(IOException iOException) {
                                synchronized (DiskLruCache.this) {
                                    Editor.this.detach();
                                }
                            }
                        };
                        return r1;
                    } catch (FileNotFoundException unused) {
                        return Okio.blackhole();
                    }
                }
            }
        }

        public void commit() throws IOException {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    if (this.entry.currentEditor == this) {
                        DiskLruCache.this.mo60615a(this, true);
                    }
                    this.done = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        public void abort() throws IOException {
            synchronized (DiskLruCache.this) {
                if (!this.done) {
                    if (this.entry.currentEditor == this) {
                        DiskLruCache.this.mo60615a(this, false);
                    }
                    this.done = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }
    }

    private final class Entry {
        final File[] cleanFiles;
        Editor currentEditor;
        final File[] dirtyFiles;
        final String key;
        final long[] lengths;
        boolean readable;
        long sequenceNumber;

        Entry(String str) {
            this.key = str;
            this.lengths = new long[DiskLruCache.this.f19043j];
            this.cleanFiles = new File[DiskLruCache.this.f19043j];
            this.dirtyFiles = new File[DiskLruCache.this.f19043j];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.this.f19043j; i++) {
                sb.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.f19042i, sb.toString());
                sb.append(DefaultDiskStorage.FileType.TEMP);
                this.dirtyFiles[i] = new File(DiskLruCache.this.f19042i, sb.toString());
                sb.setLength(length);
            }
        }

        /* access modifiers changed from: package-private */
        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.f19043j) {
                int i = 0;
                while (i < strArr.length) {
                    try {
                        this.lengths[i] = Long.parseLong(strArr[i]);
                        i++;
                    } catch (NumberFormatException unused) {
                        throw invalidLengths(strArr);
                    }
                }
                return;
            }
            throw invalidLengths(strArr);
        }

        /* access modifiers changed from: package-private */
        public void writeLengths(BufferedSink bufferedSink) throws IOException {
            for (long writeDecimalLong : this.lengths) {
                bufferedSink.writeByte(32).writeDecimalLong(writeDecimalLong);
            }
        }

        private IOException invalidLengths(String[] strArr) throws IOException {
            throw new IOException("unexpected journal line: " + Arrays.toString(strArr));
        }

        /* access modifiers changed from: package-private */
        public Snapshot snapshot() {
            if (Thread.holdsLock(DiskLruCache.this)) {
                Source[] sourceArr = new Source[DiskLruCache.this.f19043j];
                long[] jArr = (long[]) this.lengths.clone();
                int i = 0;
                int i2 = 0;
                while (i2 < DiskLruCache.this.f19043j) {
                    try {
                        sourceArr[i2] = DiskLruCache.this.f19041h.source(this.cleanFiles[i2]);
                        i2++;
                    } catch (FileNotFoundException unused) {
                        while (i < DiskLruCache.this.f19043j && sourceArr[i] != null) {
                            C21750Util.closeQuietly((Closeable) sourceArr[i]);
                            i++;
                        }
                        try {
                            DiskLruCache.this.mo60617a(this);
                            return null;
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                }
                return new Snapshot(this.key, this.sequenceNumber, this.cleanFiles, sourceArr, jArr);
            }
            throw new AssertionError();
        }
    }

    static class FaultHidingSink extends ForwardingSink {
        private boolean hasErrors;

        /* access modifiers changed from: protected */
        public void onException(IOException iOException) {
        }

        FaultHidingSink(Sink sink) {
            super(sink);
        }

        public void write(Buffer buffer, long j) throws IOException {
            if (this.hasErrors) {
                buffer.skip(j);
                return;
            }
            try {
                super.write(buffer, j);
            } catch (IOException e) {
                this.hasErrors = true;
                onException(e);
            }
        }

        public void flush() {
            if (!this.hasErrors) {
                try {
                    super.flush();
                } catch (IOException e) {
                    this.hasErrors = true;
                    onException(e);
                }
            }
        }

        public void close() {
            if (!this.hasErrors) {
                try {
                    super.close();
                } catch (IOException e) {
                    this.hasErrors = true;
                    onException(e);
                }
            }
        }
    }
}
