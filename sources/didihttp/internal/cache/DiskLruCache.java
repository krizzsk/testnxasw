package didihttp.internal.cache;

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
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.Executor;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;
import okio.BufferedSink;
import okio.Okio;
import okio.Sink;
import okio.Source;

public final class DiskLruCache implements Closeable, Flushable {

    /* renamed from: a */
    static final String f59363a = "journal";

    /* renamed from: b */
    static final String f59364b = "journal.tmp";

    /* renamed from: c */
    static final String f59365c = "journal.bkp";

    /* renamed from: d */
    static final String f59366d = "libcore.io.DiskLruCache";

    /* renamed from: e */
    static final String f59367e = "1";

    /* renamed from: f */
    static final long f59368f = -1;

    /* renamed from: g */
    static final Pattern f59369g = Pattern.compile("[a-z0-9_-]{1,120}");

    /* renamed from: s */
    static final /* synthetic */ boolean f59370s = (!DiskLruCache.class.desiredAssertionStatus());

    /* renamed from: t */
    private static final String f59371t = "CLEAN";

    /* renamed from: u */
    private static final String f59372u = "DIRTY";

    /* renamed from: v */
    private static final String f59373v = "REMOVE";

    /* renamed from: w */
    private static final String f59374w = "READ";

    /* renamed from: A */
    private final int f59375A;

    /* renamed from: B */
    private long f59376B;

    /* renamed from: C */
    private long f59377C = 0;

    /* renamed from: D */
    private long f59378D = 0;

    /* renamed from: E */
    private final Executor f59379E;

    /* renamed from: F */
    private final Runnable f59380F = new Runnable() {
        /* JADX WARNING: Code restructure failed: missing block: B:20:?, code lost:
            r5.this$0.f59391r = true;
            r5.this$0.f59384k = okio.Okio.buffer(okio.Okio.blackhole());
         */
        /* JADX WARNING: Exception block dominator not found, dom blocks: [] */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x0033 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void run() {
            /*
                r5 = this;
                didihttp.internal.cache.DiskLruCache r0 = didihttp.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                didihttp.internal.cache.DiskLruCache r1 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0045 }
                boolean r1 = r1.f59388o     // Catch:{ all -> 0x0045 }
                r2 = 0
                r3 = 1
                if (r1 != 0) goto L_0x000d
                r1 = 1
                goto L_0x000e
            L_0x000d:
                r1 = 0
            L_0x000e:
                didihttp.internal.cache.DiskLruCache r4 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0045 }
                boolean r4 = r4.f59389p     // Catch:{ all -> 0x0045 }
                r1 = r1 | r4
                if (r1 == 0) goto L_0x0017
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                return
            L_0x0017:
                didihttp.internal.cache.DiskLruCache r1 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x001d }
                r1.mo179767c()     // Catch:{ IOException -> 0x001d }
                goto L_0x0021
            L_0x001d:
                didihttp.internal.cache.DiskLruCache r1 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0045 }
                r1.f59390q = r3     // Catch:{ all -> 0x0045 }
            L_0x0021:
                didihttp.internal.cache.DiskLruCache r1 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x0033 }
                boolean r1 = r1.mo179766b()     // Catch:{ IOException -> 0x0033 }
                if (r1 == 0) goto L_0x0043
                didihttp.internal.cache.DiskLruCache r1 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x0033 }
                r1.mo179763a()     // Catch:{ IOException -> 0x0033 }
                didihttp.internal.cache.DiskLruCache r1 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x0033 }
                r1.f59386m = r2     // Catch:{ IOException -> 0x0033 }
                goto L_0x0043
            L_0x0033:
                didihttp.internal.cache.DiskLruCache r1 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0045 }
                r1.f59391r = r3     // Catch:{ all -> 0x0045 }
                didihttp.internal.cache.DiskLruCache r1 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ all -> 0x0045 }
                okio.Sink r2 = okio.Okio.blackhole()     // Catch:{ all -> 0x0045 }
                okio.BufferedSink r2 = okio.Okio.buffer((okio.Sink) r2)     // Catch:{ all -> 0x0045 }
                r1.f59384k = r2     // Catch:{ all -> 0x0045 }
            L_0x0043:
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                return
            L_0x0045:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0045 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.cache.DiskLruCache.C217541.run():void");
        }
    };

    /* renamed from: h */
    final FileSystem f59381h;

    /* renamed from: i */
    final File f59382i;

    /* renamed from: j */
    final int f59383j;

    /* renamed from: k */
    BufferedSink f59384k;

    /* renamed from: l */
    final LinkedHashMap<String, Entry> f59385l = new LinkedHashMap<>(0, 0.75f, true);

    /* renamed from: m */
    int f59386m;

    /* renamed from: n */
    boolean f59387n;

    /* renamed from: o */
    boolean f59388o;

    /* renamed from: p */
    boolean f59389p;

    /* renamed from: q */
    boolean f59390q;

    /* renamed from: r */
    boolean f59391r;

    /* renamed from: x */
    private final File f59392x;

    /* renamed from: y */
    private final File f59393y;

    /* renamed from: z */
    private final File f59394z;

    DiskLruCache(FileSystem fileSystem, File file, int i, int i2, long j, Executor executor) {
        this.f59381h = fileSystem;
        this.f59382i = file;
        this.f59375A = i;
        this.f59392x = new File(file, "journal");
        this.f59393y = new File(file, "journal.tmp");
        this.f59394z = new File(file, "journal.bkp");
        this.f59383j = i2;
        this.f59376B = j;
        this.f59379E = executor;
    }

    public synchronized void initialize() throws IOException {
        if (!f59370s) {
            if (!Thread.holdsLock(this)) {
                throw new AssertionError();
            }
        }
        if (!this.f59388o) {
            if (this.f59381h.exists(this.f59394z)) {
                if (this.f59381h.exists(this.f59392x)) {
                    this.f59381h.delete(this.f59394z);
                } else {
                    this.f59381h.rename(this.f59394z, this.f59392x);
                }
            }
            if (this.f59381h.exists(this.f59392x)) {
                try {
                    m44778d();
                    m44780f();
                    this.f59388o = true;
                    return;
                } catch (IOException e) {
                    Platform platform = Platform.get();
                    platform.log(5, "DiskLruCache " + this.f59382i + " is corrupt: " + e.getMessage() + ", removing", e);
                    delete();
                    this.f59389p = false;
                } catch (Throwable th) {
                    this.f59389p = false;
                    throw th;
                }
            }
            mo179763a();
            this.f59388o = true;
        }
    }

    public static DiskLruCache create(FileSystem fileSystem, File file, int i, int i2, long j) {
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
        r9.f59386m = r0 - r9.f59385l.size();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:18:0x006a, code lost:
        if (r1.exhausted() == false) goto L_0x006c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:19:0x006c, code lost:
        mo179763a();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:20:0x0070, code lost:
        r9.f59384k = m44779e();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:22:0x0079, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:16:0x005d */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:23:0x007a=Splitter:B:23:0x007a, B:16:0x005d=Splitter:B:16:0x005d} */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m44778d() throws java.io.IOException {
        /*
            r9 = this;
            java.lang.String r0 = ", "
            didihttp.internal.io.FileSystem r1 = r9.f59381h
            java.io.File r2 = r9.f59392x
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
            int r7 = r9.f59375A     // Catch:{ all -> 0x00a8 }
            java.lang.String r7 = java.lang.Integer.toString(r7)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r7.equals(r4)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            int r4 = r9.f59383j     // Catch:{ all -> 0x00a8 }
            java.lang.String r4 = java.lang.Integer.toString(r4)     // Catch:{ all -> 0x00a8 }
            boolean r4 = r4.equals(r5)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            java.lang.String r4 = ""
            boolean r4 = r4.equals(r6)     // Catch:{ all -> 0x00a8 }
            if (r4 == 0) goto L_0x007a
            r0 = 0
        L_0x0053:
            java.lang.String r2 = r1.readUtf8LineStrict()     // Catch:{ EOFException -> 0x005d }
            r9.m44776a((java.lang.String) r2)     // Catch:{ EOFException -> 0x005d }
            int r0 = r0 + 1
            goto L_0x0053
        L_0x005d:
            java.util.LinkedHashMap<java.lang.String, didihttp.internal.cache.DiskLruCache$Entry> r2 = r9.f59385l     // Catch:{ all -> 0x00a8 }
            int r2 = r2.size()     // Catch:{ all -> 0x00a8 }
            int r0 = r0 - r2
            r9.f59386m = r0     // Catch:{ all -> 0x00a8 }
            boolean r0 = r1.exhausted()     // Catch:{ all -> 0x00a8 }
            if (r0 != 0) goto L_0x0070
            r9.mo179763a()     // Catch:{ all -> 0x00a8 }
            goto L_0x0076
        L_0x0070:
            okio.BufferedSink r0 = r9.m44779e()     // Catch:{ all -> 0x00a8 }
            r9.f59384k = r0     // Catch:{ all -> 0x00a8 }
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
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.cache.DiskLruCache.m44778d():void");
    }

    /* renamed from: e */
    private BufferedSink m44779e() throws FileNotFoundException {
        return Okio.buffer((Sink) new C21758a(this.f59381h.appendingSink(this.f59392x)) {
            static final /* synthetic */ boolean $assertionsDisabled = false;

            static {
                Class<DiskLruCache> cls = DiskLruCache.class;
            }

            /* access modifiers changed from: protected */
            public void onException(IOException iOException) {
                DiskLruCache.this.f59387n = true;
            }
        });
    }

    /* renamed from: a */
    private void m44776a(String str) throws IOException {
        String str2;
        int indexOf = str.indexOf(32);
        if (indexOf != -1) {
            int i = indexOf + 1;
            int indexOf2 = str.indexOf(32, i);
            if (indexOf2 == -1) {
                str2 = str.substring(i);
                if (indexOf == 6 && str.startsWith("REMOVE")) {
                    this.f59385l.remove(str2);
                    return;
                }
            } else {
                str2 = str.substring(i, indexOf2);
            }
            Entry entry = this.f59385l.get(str2);
            if (entry == null) {
                entry = new Entry(str2);
                this.f59385l.put(str2, entry);
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

    /* renamed from: f */
    private void m44780f() throws IOException {
        this.f59381h.delete(this.f59393y);
        Iterator<Entry> it = this.f59385l.values().iterator();
        while (it.hasNext()) {
            Entry next = it.next();
            int i = 0;
            if (next.currentEditor == null) {
                while (i < this.f59383j) {
                    this.f59377C += next.lengths[i];
                    i++;
                }
            } else {
                next.currentEditor = null;
                while (i < this.f59383j) {
                    this.f59381h.delete(next.cleanFiles[i]);
                    this.f59381h.delete(next.dirtyFiles[i]);
                    i++;
                }
                it.remove();
            }
        }
    }

    /* JADX INFO: finally extract failed */
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo179763a() throws IOException {
        if (this.f59384k != null) {
            this.f59384k.close();
        }
        BufferedSink buffer = Okio.buffer(this.f59381h.sink(this.f59393y));
        try {
            buffer.writeUtf8(f59366d).writeByte(10);
            buffer.writeUtf8("1").writeByte(10);
            buffer.writeDecimalLong((long) this.f59375A).writeByte(10);
            buffer.writeDecimalLong((long) this.f59383j).writeByte(10);
            buffer.writeByte(10);
            for (Entry next : this.f59385l.values()) {
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
            if (this.f59381h.exists(this.f59392x)) {
                this.f59381h.rename(this.f59392x, this.f59394z);
            }
            this.f59381h.rename(this.f59393y, this.f59392x);
            this.f59381h.delete(this.f59394z);
            this.f59384k = m44779e();
            this.f59387n = false;
            this.f59391r = false;
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
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized didihttp.internal.cache.DiskLruCache.Snapshot get(java.lang.String r4) throws java.io.IOException {
        /*
            r3 = this;
            monitor-enter(r3)
            r3.initialize()     // Catch:{ all -> 0x0050 }
            r3.m44781g()     // Catch:{ all -> 0x0050 }
            r3.m44777b(r4)     // Catch:{ all -> 0x0050 }
            java.util.LinkedHashMap<java.lang.String, didihttp.internal.cache.DiskLruCache$Entry> r0 = r3.f59385l     // Catch:{ all -> 0x0050 }
            java.lang.Object r0 = r0.get(r4)     // Catch:{ all -> 0x0050 }
            didihttp.internal.cache.DiskLruCache$Entry r0 = (didihttp.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0050 }
            r1 = 0
            if (r0 == 0) goto L_0x004e
            boolean r2 = r0.readable     // Catch:{ all -> 0x0050 }
            if (r2 != 0) goto L_0x001a
            goto L_0x004e
        L_0x001a:
            didihttp.internal.cache.DiskLruCache$Snapshot r0 = r0.snapshot()     // Catch:{ all -> 0x0050 }
            if (r0 != 0) goto L_0x0022
            monitor-exit(r3)
            return r1
        L_0x0022:
            int r1 = r3.f59386m     // Catch:{ all -> 0x0050 }
            int r1 = r1 + 1
            r3.f59386m = r1     // Catch:{ all -> 0x0050 }
            okio.BufferedSink r1 = r3.f59384k     // Catch:{ all -> 0x0050 }
            java.lang.String r2 = "READ"
            okio.BufferedSink r1 = r1.writeUtf8(r2)     // Catch:{ all -> 0x0050 }
            r2 = 32
            okio.BufferedSink r1 = r1.writeByte(r2)     // Catch:{ all -> 0x0050 }
            okio.BufferedSink r4 = r1.writeUtf8(r4)     // Catch:{ all -> 0x0050 }
            r1 = 10
            r4.writeByte(r1)     // Catch:{ all -> 0x0050 }
            boolean r4 = r3.mo179766b()     // Catch:{ all -> 0x0050 }
            if (r4 == 0) goto L_0x004c
            java.util.concurrent.Executor r4 = r3.f59379E     // Catch:{ all -> 0x0050 }
            java.lang.Runnable r1 = r3.f59380F     // Catch:{ all -> 0x0050 }
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
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.cache.DiskLruCache.get(java.lang.String):didihttp.internal.cache.DiskLruCache$Snapshot");
    }

    public Editor edit(String str) throws IOException {
        return mo179762a(str, -1);
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:9:0x0022, code lost:
        return null;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized didihttp.internal.cache.DiskLruCache.Editor mo179762a(java.lang.String r6, long r7) throws java.io.IOException {
        /*
            r5 = this;
            monitor-enter(r5)
            r5.initialize()     // Catch:{ all -> 0x0074 }
            r5.m44781g()     // Catch:{ all -> 0x0074 }
            r5.m44777b(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, didihttp.internal.cache.DiskLruCache$Entry> r0 = r5.f59385l     // Catch:{ all -> 0x0074 }
            java.lang.Object r0 = r0.get(r6)     // Catch:{ all -> 0x0074 }
            didihttp.internal.cache.DiskLruCache$Entry r0 = (didihttp.internal.cache.DiskLruCache.Entry) r0     // Catch:{ all -> 0x0074 }
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
            didihttp.internal.cache.DiskLruCache$Editor r7 = r0.currentEditor     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x002b
            monitor-exit(r5)
            return r3
        L_0x002b:
            boolean r7 = r5.f59390q     // Catch:{ all -> 0x0074 }
            if (r7 != 0) goto L_0x006b
            boolean r7 = r5.f59391r     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0034
            goto L_0x006b
        L_0x0034:
            okio.BufferedSink r7 = r5.f59384k     // Catch:{ all -> 0x0074 }
            java.lang.String r8 = "DIRTY"
            okio.BufferedSink r7 = r7.writeUtf8(r8)     // Catch:{ all -> 0x0074 }
            r8 = 32
            okio.BufferedSink r7 = r7.writeByte(r8)     // Catch:{ all -> 0x0074 }
            okio.BufferedSink r7 = r7.writeUtf8(r6)     // Catch:{ all -> 0x0074 }
            r8 = 10
            r7.writeByte(r8)     // Catch:{ all -> 0x0074 }
            okio.BufferedSink r7 = r5.f59384k     // Catch:{ all -> 0x0074 }
            r7.flush()     // Catch:{ all -> 0x0074 }
            boolean r7 = r5.f59387n     // Catch:{ all -> 0x0074 }
            if (r7 == 0) goto L_0x0056
            monitor-exit(r5)
            return r3
        L_0x0056:
            if (r0 != 0) goto L_0x0062
            didihttp.internal.cache.DiskLruCache$Entry r0 = new didihttp.internal.cache.DiskLruCache$Entry     // Catch:{ all -> 0x0074 }
            r0.<init>(r6)     // Catch:{ all -> 0x0074 }
            java.util.LinkedHashMap<java.lang.String, didihttp.internal.cache.DiskLruCache$Entry> r7 = r5.f59385l     // Catch:{ all -> 0x0074 }
            r7.put(r6, r0)     // Catch:{ all -> 0x0074 }
        L_0x0062:
            didihttp.internal.cache.DiskLruCache$Editor r6 = new didihttp.internal.cache.DiskLruCache$Editor     // Catch:{ all -> 0x0074 }
            r6.<init>(r0)     // Catch:{ all -> 0x0074 }
            r0.currentEditor = r6     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r6
        L_0x006b:
            java.util.concurrent.Executor r6 = r5.f59379E     // Catch:{ all -> 0x0074 }
            java.lang.Runnable r7 = r5.f59380F     // Catch:{ all -> 0x0074 }
            r6.execute(r7)     // Catch:{ all -> 0x0074 }
            monitor-exit(r5)
            return r3
        L_0x0074:
            r6 = move-exception
            monitor-exit(r5)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.cache.DiskLruCache.mo179762a(java.lang.String, long):didihttp.internal.cache.DiskLruCache$Editor");
    }

    public File getDirectory() {
        return this.f59382i;
    }

    public synchronized long getMaxSize() {
        return this.f59376B;
    }

    public synchronized void setMaxSize(long j) {
        this.f59376B = j;
        if (this.f59388o) {
            this.f59379E.execute(this.f59380F);
        }
    }

    public synchronized long size() throws IOException {
        initialize();
        return this.f59377C;
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:43:0x00f4, code lost:
        return;
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void mo179764a(didihttp.internal.cache.DiskLruCache.Editor r10, boolean r11) throws java.io.IOException {
        /*
            r9 = this;
            monitor-enter(r9)
            didihttp.internal.cache.DiskLruCache$Entry r0 = r10.entry     // Catch:{ all -> 0x00fb }
            didihttp.internal.cache.DiskLruCache$Editor r1 = r0.currentEditor     // Catch:{ all -> 0x00fb }
            if (r1 != r10) goto L_0x00f5
            r1 = 0
            if (r11 == 0) goto L_0x0047
            boolean r2 = r0.readable     // Catch:{ all -> 0x00fb }
            if (r2 != 0) goto L_0x0047
            r2 = 0
        L_0x000f:
            int r3 = r9.f59383j     // Catch:{ all -> 0x00fb }
            if (r2 >= r3) goto L_0x0047
            boolean[] r3 = r10.written     // Catch:{ all -> 0x00fb }
            boolean r3 = r3[r2]     // Catch:{ all -> 0x00fb }
            if (r3 == 0) goto L_0x002d
            didihttp.internal.io.FileSystem r3 = r9.f59381h     // Catch:{ all -> 0x00fb }
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
            int r10 = r9.f59383j     // Catch:{ all -> 0x00fb }
            if (r1 >= r10) goto L_0x007f
            java.io.File[] r10 = r0.dirtyFiles     // Catch:{ all -> 0x00fb }
            r10 = r10[r1]     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x0077
            didihttp.internal.io.FileSystem r2 = r9.f59381h     // Catch:{ all -> 0x00fb }
            boolean r2 = r2.exists(r10)     // Catch:{ all -> 0x00fb }
            if (r2 == 0) goto L_0x007c
            java.io.File[] r2 = r0.cleanFiles     // Catch:{ all -> 0x00fb }
            r2 = r2[r1]     // Catch:{ all -> 0x00fb }
            didihttp.internal.io.FileSystem r3 = r9.f59381h     // Catch:{ all -> 0x00fb }
            r3.rename(r10, r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x00fb }
            r3 = r10[r1]     // Catch:{ all -> 0x00fb }
            didihttp.internal.io.FileSystem r10 = r9.f59381h     // Catch:{ all -> 0x00fb }
            long r5 = r10.size(r2)     // Catch:{ all -> 0x00fb }
            long[] r10 = r0.lengths     // Catch:{ all -> 0x00fb }
            r10[r1] = r5     // Catch:{ all -> 0x00fb }
            long r7 = r9.f59377C     // Catch:{ all -> 0x00fb }
            long r7 = r7 - r3
            long r7 = r7 + r5
            r9.f59377C = r7     // Catch:{ all -> 0x00fb }
            goto L_0x007c
        L_0x0077:
            didihttp.internal.io.FileSystem r2 = r9.f59381h     // Catch:{ all -> 0x00fb }
            r2.delete(r10)     // Catch:{ all -> 0x00fb }
        L_0x007c:
            int r1 = r1 + 1
            goto L_0x0047
        L_0x007f:
            int r10 = r9.f59386m     // Catch:{ all -> 0x00fb }
            r1 = 1
            int r10 = r10 + r1
            r9.f59386m = r10     // Catch:{ all -> 0x00fb }
            r10 = 0
            r0.currentEditor = r10     // Catch:{ all -> 0x00fb }
            boolean r10 = r0.readable     // Catch:{ all -> 0x00fb }
            r10 = r10 | r11
            r2 = 10
            r3 = 32
            if (r10 == 0) goto L_0x00bb
            r0.readable = r1     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f59384k     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = "CLEAN"
            okio.BufferedSink r10 = r10.writeUtf8(r1)     // Catch:{ all -> 0x00fb }
            r10.writeByte(r3)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f59384k     // Catch:{ all -> 0x00fb }
            java.lang.String r1 = r0.key     // Catch:{ all -> 0x00fb }
            r10.writeUtf8(r1)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f59384k     // Catch:{ all -> 0x00fb }
            r0.writeLengths(r10)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f59384k     // Catch:{ all -> 0x00fb }
            r10.writeByte(r2)     // Catch:{ all -> 0x00fb }
            if (r11 == 0) goto L_0x00d9
            long r10 = r9.f59378D     // Catch:{ all -> 0x00fb }
            r1 = 1
            long r1 = r1 + r10
            r9.f59378D = r1     // Catch:{ all -> 0x00fb }
            r0.sequenceNumber = r10     // Catch:{ all -> 0x00fb }
            goto L_0x00d9
        L_0x00bb:
            java.util.LinkedHashMap<java.lang.String, didihttp.internal.cache.DiskLruCache$Entry> r10 = r9.f59385l     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x00fb }
            r10.remove(r11)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f59384k     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = "REMOVE"
            okio.BufferedSink r10 = r10.writeUtf8(r11)     // Catch:{ all -> 0x00fb }
            r10.writeByte(r3)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f59384k     // Catch:{ all -> 0x00fb }
            java.lang.String r11 = r0.key     // Catch:{ all -> 0x00fb }
            r10.writeUtf8(r11)     // Catch:{ all -> 0x00fb }
            okio.BufferedSink r10 = r9.f59384k     // Catch:{ all -> 0x00fb }
            r10.writeByte(r2)     // Catch:{ all -> 0x00fb }
        L_0x00d9:
            okio.BufferedSink r10 = r9.f59384k     // Catch:{ all -> 0x00fb }
            r10.flush()     // Catch:{ all -> 0x00fb }
            long r10 = r9.f59377C     // Catch:{ all -> 0x00fb }
            long r0 = r9.f59376B     // Catch:{ all -> 0x00fb }
            int r2 = (r10 > r0 ? 1 : (r10 == r0 ? 0 : -1))
            if (r2 > 0) goto L_0x00ec
            boolean r10 = r9.mo179766b()     // Catch:{ all -> 0x00fb }
            if (r10 == 0) goto L_0x00f3
        L_0x00ec:
            java.util.concurrent.Executor r10 = r9.f59379E     // Catch:{ all -> 0x00fb }
            java.lang.Runnable r11 = r9.f59380F     // Catch:{ all -> 0x00fb }
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
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.cache.DiskLruCache.mo179764a(didihttp.internal.cache.DiskLruCache$Editor, boolean):void");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo179766b() {
        int i = this.f59386m;
        return i >= 2000 && i >= this.f59385l.size();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:14:0x0028, code lost:
        return r7;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized boolean remove(java.lang.String r7) throws java.io.IOException {
        /*
            r6 = this;
            monitor-enter(r6)
            r6.initialize()     // Catch:{ all -> 0x0029 }
            r6.m44781g()     // Catch:{ all -> 0x0029 }
            r6.m44777b(r7)     // Catch:{ all -> 0x0029 }
            java.util.LinkedHashMap<java.lang.String, didihttp.internal.cache.DiskLruCache$Entry> r0 = r6.f59385l     // Catch:{ all -> 0x0029 }
            java.lang.Object r7 = r0.get(r7)     // Catch:{ all -> 0x0029 }
            didihttp.internal.cache.DiskLruCache$Entry r7 = (didihttp.internal.cache.DiskLruCache.Entry) r7     // Catch:{ all -> 0x0029 }
            r0 = 0
            if (r7 != 0) goto L_0x0017
            monitor-exit(r6)
            return r0
        L_0x0017:
            boolean r7 = r6.mo179765a((didihttp.internal.cache.DiskLruCache.Entry) r7)     // Catch:{ all -> 0x0029 }
            if (r7 == 0) goto L_0x0027
            long r1 = r6.f59377C     // Catch:{ all -> 0x0029 }
            long r3 = r6.f59376B     // Catch:{ all -> 0x0029 }
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 > 0) goto L_0x0027
            r6.f59390q = r0     // Catch:{ all -> 0x0029 }
        L_0x0027:
            monitor-exit(r6)
            return r7
        L_0x0029:
            r7 = move-exception
            monitor-exit(r6)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.cache.DiskLruCache.remove(java.lang.String):boolean");
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public boolean mo179765a(Entry entry) throws IOException {
        if (entry.currentEditor != null) {
            entry.currentEditor.detach();
        }
        for (int i = 0; i < this.f59383j; i++) {
            this.f59381h.delete(entry.cleanFiles[i]);
            this.f59377C -= entry.lengths[i];
            entry.lengths[i] = 0;
        }
        this.f59386m++;
        this.f59384k.writeUtf8("REMOVE").writeByte(32).writeUtf8(entry.key).writeByte(10);
        this.f59385l.remove(entry.key);
        if (mo179766b()) {
            this.f59379E.execute(this.f59380F);
        }
        return true;
    }

    public synchronized boolean isClosed() {
        return this.f59389p;
    }

    /* renamed from: g */
    private synchronized void m44781g() {
        if (isClosed()) {
            throw new IllegalStateException("cache is closed");
        }
    }

    public synchronized void flush() throws IOException {
        if (this.f59388o) {
            m44781g();
            mo179767c();
            this.f59384k.flush();
        }
    }

    public synchronized void close() throws IOException {
        if (this.f59388o) {
            if (!this.f59389p) {
                for (Entry entry : (Entry[]) this.f59385l.values().toArray(new Entry[this.f59385l.size()])) {
                    if (entry.currentEditor != null) {
                        entry.currentEditor.abort();
                    }
                }
                mo179767c();
                this.f59384k.close();
                this.f59384k = null;
                this.f59389p = true;
                return;
            }
        }
        this.f59389p = true;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo179767c() throws IOException {
        while (this.f59377C > this.f59376B) {
            mo179765a(this.f59385l.values().iterator().next());
        }
        this.f59390q = false;
    }

    public void delete() throws IOException {
        close();
        this.f59381h.deleteContents(this.f59382i);
    }

    public synchronized void evictAll() throws IOException {
        initialize();
        for (Entry a : (Entry[]) this.f59385l.values().toArray(new Entry[this.f59385l.size()])) {
            mo179765a(a);
        }
        this.f59390q = false;
    }

    /* renamed from: b */
    private void m44777b(String str) {
        if (!f59369g.matcher(str).matches()) {
            throw new IllegalArgumentException("keys must match regex [a-z0-9_-]{1,120}: \"" + str + Const.jsQuote);
        }
    }

    public synchronized Iterator<Snapshot> snapshots() throws IOException {
        initialize();
        return new Iterator<Snapshot>() {
            final Iterator<Entry> delegate = new ArrayList(DiskLruCache.this.f59385l.values()).iterator();
            Snapshot nextSnapshot;
            Snapshot removeSnapshot;

            public boolean hasNext() {
                if (this.nextSnapshot != null) {
                    return true;
                }
                synchronized (DiskLruCache.this) {
                    if (DiskLruCache.this.f59389p) {
                        return false;
                    }
                    while (this.delegate.hasNext()) {
                        Snapshot snapshot = this.delegate.next().snapshot();
                        if (snapshot != null) {
                            this.nextSnapshot = snapshot;
                            return true;
                        }
                    }
                    return false;
                }
            }

            public Snapshot next() {
                if (hasNext()) {
                    Snapshot snapshot = this.nextSnapshot;
                    this.removeSnapshot = snapshot;
                    this.nextSnapshot = null;
                    return snapshot;
                }
                throw new NoSuchElementException();
            }

            public void remove() {
                Snapshot snapshot = this.removeSnapshot;
                if (snapshot != null) {
                    try {
                        DiskLruCache.this.remove(snapshot.key);
                    } catch (IOException unused) {
                    } catch (Throwable th) {
                        this.removeSnapshot = null;
                        throw th;
                    }
                    this.removeSnapshot = null;
                    return;
                }
                throw new IllegalStateException("remove() before next()");
            }
        };
    }

    public final class Snapshot implements Closeable {
        /* access modifiers changed from: private */
        public final String key;
        private final long[] lengths;
        private final long sequenceNumber;
        private final Source[] sources;

        Snapshot(String str, long j, Source[] sourceArr, long[] jArr) {
            this.key = str;
            this.sequenceNumber = j;
            this.sources = sourceArr;
            this.lengths = jArr;
        }

        public String key() {
            return this.key;
        }

        public Editor edit() throws IOException {
            return DiskLruCache.this.mo179762a(this.key, this.sequenceNumber);
        }

        public Source getSource(int i) {
            return this.sources[i];
        }

        public long getLength(int i) {
            return this.lengths[i];
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
            this.written = entry2.readable ? null : new boolean[DiskLruCache.this.f59383j];
        }

        /* access modifiers changed from: package-private */
        public void detach() {
            if (this.entry.currentEditor == this) {
                for (int i = 0; i < DiskLruCache.this.f59383j; i++) {
                    try {
                        DiskLruCache.this.f59381h.delete(this.entry.dirtyFiles[i]);
                    } catch (IOException unused) {
                    }
                }
                this.entry.currentEditor = null;
            }
        }

        /* JADX WARNING: Code restructure failed: missing block: B:18:0x0028, code lost:
            return null;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public okio.Source newSource(int r5) {
            /*
                r4 = this;
                didihttp.internal.cache.DiskLruCache r0 = didihttp.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r4.done     // Catch:{ all -> 0x002f }
                if (r1 != 0) goto L_0x0029
                didihttp.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x002f }
                boolean r1 = r1.readable     // Catch:{ all -> 0x002f }
                r2 = 0
                if (r1 == 0) goto L_0x0027
                didihttp.internal.cache.DiskLruCache$Entry r1 = r4.entry     // Catch:{ all -> 0x002f }
                didihttp.internal.cache.DiskLruCache$Editor r1 = r1.currentEditor     // Catch:{ all -> 0x002f }
                if (r1 == r4) goto L_0x0015
                goto L_0x0027
            L_0x0015:
                didihttp.internal.cache.DiskLruCache r1 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ FileNotFoundException -> 0x0025 }
                didihttp.internal.io.FileSystem r1 = r1.f59381h     // Catch:{ FileNotFoundException -> 0x0025 }
                didihttp.internal.cache.DiskLruCache$Entry r3 = r4.entry     // Catch:{ FileNotFoundException -> 0x0025 }
                java.io.File[] r3 = r3.cleanFiles     // Catch:{ FileNotFoundException -> 0x0025 }
                r5 = r3[r5]     // Catch:{ FileNotFoundException -> 0x0025 }
                okio.Source r5 = r1.source(r5)     // Catch:{ FileNotFoundException -> 0x0025 }
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                return r5
            L_0x0025:
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                return r2
            L_0x0027:
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                return r2
            L_0x0029:
                java.lang.IllegalStateException r5 = new java.lang.IllegalStateException     // Catch:{ all -> 0x002f }
                r5.<init>()     // Catch:{ all -> 0x002f }
                throw r5     // Catch:{ all -> 0x002f }
            L_0x002f:
                r5 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x002f }
                throw r5
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.cache.DiskLruCache.Editor.newSource(int):okio.Source");
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
                        C217571 r1 = new C21758a(DiskLruCache.this.f59381h.sink(this.entry.dirtyFiles[i])) {
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
                        DiskLruCache.this.mo179764a(this, true);
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
                        DiskLruCache.this.mo179764a(this, false);
                    }
                    this.done = true;
                } else {
                    throw new IllegalStateException();
                }
            }
        }

        /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|(2:7|8)|9|10) */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0013 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void abortUnlessCommitted() {
            /*
                r3 = this;
                didihttp.internal.cache.DiskLruCache r0 = didihttp.internal.cache.DiskLruCache.this
                monitor-enter(r0)
                boolean r1 = r3.done     // Catch:{ all -> 0x0015 }
                if (r1 != 0) goto L_0x0013
                didihttp.internal.cache.DiskLruCache$Entry r1 = r3.entry     // Catch:{ all -> 0x0015 }
                didihttp.internal.cache.DiskLruCache$Editor r1 = r1.currentEditor     // Catch:{ all -> 0x0015 }
                if (r1 != r3) goto L_0x0013
                didihttp.internal.cache.DiskLruCache r1 = didihttp.internal.cache.DiskLruCache.this     // Catch:{ IOException -> 0x0013 }
                r2 = 0
                r1.mo179764a((didihttp.internal.cache.DiskLruCache.Editor) r3, (boolean) r2)     // Catch:{ IOException -> 0x0013 }
            L_0x0013:
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                return
            L_0x0015:
                r1 = move-exception
                monitor-exit(r0)     // Catch:{ all -> 0x0015 }
                throw r1
            */
            throw new UnsupportedOperationException("Method not decompiled: didihttp.internal.cache.DiskLruCache.Editor.abortUnlessCommitted():void");
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
            this.lengths = new long[DiskLruCache.this.f59383j];
            this.cleanFiles = new File[DiskLruCache.this.f59383j];
            this.dirtyFiles = new File[DiskLruCache.this.f59383j];
            StringBuilder sb = new StringBuilder(str);
            sb.append('.');
            int length = sb.length();
            for (int i = 0; i < DiskLruCache.this.f59383j; i++) {
                sb.append(i);
                this.cleanFiles[i] = new File(DiskLruCache.this.f59382i, sb.toString());
                sb.append(DefaultDiskStorage.FileType.TEMP);
                this.dirtyFiles[i] = new File(DiskLruCache.this.f59382i, sb.toString());
                sb.setLength(length);
            }
        }

        /* access modifiers changed from: package-private */
        public void setLengths(String[] strArr) throws IOException {
            if (strArr.length == DiskLruCache.this.f59383j) {
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
                Source[] sourceArr = new Source[DiskLruCache.this.f59383j];
                long[] jArr = (long[]) this.lengths.clone();
                int i = 0;
                int i2 = 0;
                while (i2 < DiskLruCache.this.f59383j) {
                    try {
                        sourceArr[i2] = DiskLruCache.this.f59381h.source(this.cleanFiles[i2]);
                        i2++;
                    } catch (FileNotFoundException unused) {
                        while (i < DiskLruCache.this.f59383j && sourceArr[i] != null) {
                            C21750Util.closeQuietly((Closeable) sourceArr[i]);
                            i++;
                        }
                        try {
                            DiskLruCache.this.mo179765a(this);
                            return null;
                        } catch (IOException unused2) {
                            return null;
                        }
                    }
                }
                return new Snapshot(this.key, this.sequenceNumber, sourceArr, jArr);
            }
            throw new AssertionError();
        }
    }
}
