package com.didi.sdk.cache;

import android.os.SystemClock;
import com.didi.sdk.cache.Cache;
import java.io.EOFException;
import java.io.File;
import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;

public class DiskBasedCache implements Cache {

    /* renamed from: a */
    private static final int f38377a = 5242880;

    /* renamed from: b */
    private static final float f38378b = 0.9f;

    /* renamed from: c */
    private static final int f38379c = 538247942;

    /* renamed from: d */
    private final Map<String, CacheHeader> f38380d;

    /* renamed from: e */
    private final File f38381e;

    /* renamed from: f */
    private final int f38382f;

    /* renamed from: g */
    private long f38383g;

    public DiskBasedCache(File file, int i) {
        this.f38380d = new LinkedHashMap(16, 0.75f, true);
        this.f38383g = 0;
        this.f38381e = file;
        this.f38382f = i;
    }

    public DiskBasedCache(File file) {
        this(file, f38377a);
    }

    /* renamed from: a */
    private static byte[] m28954a(InputStream inputStream, int i) throws IOException {
        byte[] bArr = new byte[i];
        int i2 = 0;
        while (i2 < i) {
            int read = inputStream.read(bArr, i2, i - i2);
            if (read == -1) {
                break;
            }
            i2 += read;
        }
        if (i2 == i) {
            return bArr;
        }
        throw new IOException("Expected " + i + " bytes, read " + i2 + " bytes");
    }

    /* renamed from: e */
    private static int m28959e(InputStream inputStream) throws IOException {
        int read = inputStream.read();
        if (read != -1) {
            return read;
        }
        throw new EOFException();
    }

    /* renamed from: a */
    static void m28949a(OutputStream outputStream, int i) throws IOException {
        outputStream.write((i >> 0) & 255);
        outputStream.write((i >> 8) & 255);
        outputStream.write((i >> 16) & 255);
        outputStream.write((i >> 24) & 255);
    }

    /* renamed from: a */
    static int m28946a(InputStream inputStream) throws IOException {
        return (m28959e(inputStream) << 24) | (m28959e(inputStream) << 0) | 0 | (m28959e(inputStream) << 8) | (m28959e(inputStream) << 16);
    }

    /* renamed from: a */
    static void m28950a(OutputStream outputStream, long j) throws IOException {
        outputStream.write((byte) ((int) (j >>> 0)));
        outputStream.write((byte) ((int) (j >>> 8)));
        outputStream.write((byte) ((int) (j >>> 16)));
        outputStream.write((byte) ((int) (j >>> 24)));
        outputStream.write((byte) ((int) (j >>> 32)));
        outputStream.write((byte) ((int) (j >>> 40)));
        outputStream.write((byte) ((int) (j >>> 48)));
        outputStream.write((byte) ((int) (j >>> 56)));
    }

    /* renamed from: b */
    static long m28955b(InputStream inputStream) throws IOException {
        return ((((long) m28959e(inputStream)) & 255) << 0) | 0 | ((((long) m28959e(inputStream)) & 255) << 8) | ((((long) m28959e(inputStream)) & 255) << 16) | ((((long) m28959e(inputStream)) & 255) << 24) | ((((long) m28959e(inputStream)) & 255) << 32) | ((((long) m28959e(inputStream)) & 255) << 40) | ((((long) m28959e(inputStream)) & 255) << 48) | ((255 & ((long) m28959e(inputStream))) << 56);
    }

    /* renamed from: a */
    static void m28951a(OutputStream outputStream, String str) throws IOException {
        byte[] bytes = str.getBytes("UTF-8");
        m28950a(outputStream, (long) bytes.length);
        outputStream.write(bytes, 0, bytes.length);
    }

    /* renamed from: c */
    static String m28957c(InputStream inputStream) throws IOException {
        return new String(m28954a(inputStream, (int) m28955b(inputStream)), "UTF-8");
    }

    /* renamed from: a */
    static void m28953a(Map<String, String> map, OutputStream outputStream) throws IOException {
        if (map != null) {
            m28949a(outputStream, map.size());
            for (Map.Entry next : map.entrySet()) {
                m28951a(outputStream, (String) next.getKey());
                m28951a(outputStream, (String) next.getValue());
            }
            return;
        }
        m28949a(outputStream, 0);
    }

    /* renamed from: d */
    static Map<String, String> m28958d(InputStream inputStream) throws IOException {
        int a = m28946a(inputStream);
        Map<String, String> emptyMap = a == 0 ? Collections.emptyMap() : new HashMap<>(a);
        for (int i = 0; i < a; i++) {
            emptyMap.put(m28957c(inputStream).intern(), m28957c(inputStream).intern());
        }
        return emptyMap;
    }

    public synchronized void clear() {
        File[] listFiles = this.f38381e.listFiles();
        if (listFiles != null) {
            for (File delete : listFiles) {
                delete.delete();
            }
        }
        this.f38380d.clear();
        this.f38383g = 0;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:27:?, code lost:
        remove(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:28:0x005a, code lost:
        if (r3 != null) goto L_0x005c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:30:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:33:0x0061, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:35:0x0063, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:39:?, code lost:
        remove(r10);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:40:0x0068, code lost:
        if (r3 != null) goto L_0x006a;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:42:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:45:0x006f, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:47:0x0071, code lost:
        return null;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:48:0x0072, code lost:
        r10 = th;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:51:?, code lost:
        r3.close();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:54:0x007a, code lost:
        return null;
     */
    /* JADX WARNING: Exception block dominator not found, dom blocks: [B:26:0x0057, B:38:0x0065] */
    /* JADX WARNING: Missing exception handler attribute for start block: B:26:0x0057 */
    /* JADX WARNING: Missing exception handler attribute for start block: B:38:0x0065 */
    /* JADX WARNING: Removed duplicated region for block: B:50:0x0075 A[SYNTHETIC, Splitter:B:50:0x0075] */
    /* JADX WARNING: Unknown top exception splitter block from list: {B:38:0x0065=Splitter:B:38:0x0065, B:26:0x0057=Splitter:B:26:0x0057} */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized com.didi.sdk.cache.Cache.Entry get(java.lang.String r10) {
        /*
            r9 = this;
            monitor-enter(r9)
            java.util.Map<java.lang.String, com.didi.sdk.cache.DiskBasedCache$CacheHeader> r0 = r9.f38380d     // Catch:{ all -> 0x007c }
            java.lang.Object r0 = r0.get(r10)     // Catch:{ all -> 0x007c }
            com.didi.sdk.cache.DiskBasedCache$CacheHeader r0 = (com.didi.sdk.cache.DiskBasedCache.CacheHeader) r0     // Catch:{ all -> 0x007c }
            java.io.File r1 = r9.getFileForKey(r10)     // Catch:{ all -> 0x007c }
            r2 = 0
            if (r0 != 0) goto L_0x0018
            boolean r3 = r1.exists()     // Catch:{ all -> 0x007c }
            if (r3 != 0) goto L_0x0018
            monitor-exit(r9)
            return r2
        L_0x0018:
            com.didi.sdk.cache.DiskBasedCache$CountingInputStream r3 = new com.didi.sdk.cache.DiskBasedCache$CountingInputStream     // Catch:{ IOException -> 0x0064, NegativeArraySizeException -> 0x0056, all -> 0x0053 }
            java.io.BufferedInputStream r4 = new java.io.BufferedInputStream     // Catch:{ IOException -> 0x0064, NegativeArraySizeException -> 0x0056, all -> 0x0053 }
            java.io.FileInputStream r5 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0064, NegativeArraySizeException -> 0x0056, all -> 0x0053 }
            r5.<init>(r1)     // Catch:{ IOException -> 0x0064, NegativeArraySizeException -> 0x0056, all -> 0x0053 }
            r4.<init>(r5)     // Catch:{ IOException -> 0x0064, NegativeArraySizeException -> 0x0056, all -> 0x0053 }
            r3.<init>(r4)     // Catch:{ IOException -> 0x0064, NegativeArraySizeException -> 0x0056, all -> 0x0053 }
            com.didi.sdk.cache.DiskBasedCache$CacheHeader r4 = com.didi.sdk.cache.DiskBasedCache.CacheHeader.readHeader(r3)     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            long r5 = r1.length()     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            int r7 = r3.bytesRead     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            long r7 = (long) r7     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            long r5 = r5 - r7
            int r6 = (int) r5     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            byte[] r5 = m28954a((java.io.InputStream) r3, (int) r6)     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            if (r0 != 0) goto L_0x0048
            long r0 = r1.length()     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            r4.size = r0     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            java.lang.String r0 = r4.key     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            r9.m28952a((java.lang.String) r0, (com.didi.sdk.cache.DiskBasedCache.CacheHeader) r4)     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            r0 = r4
        L_0x0048:
            com.didi.sdk.cache.Cache$Entry r10 = r0.toCacheEntry(r5)     // Catch:{ IOException -> 0x0065, NegativeArraySizeException -> 0x0057 }
            r3.close()     // Catch:{ IOException -> 0x0051 }
            monitor-exit(r9)
            return r10
        L_0x0051:
            monitor-exit(r9)
            return r2
        L_0x0053:
            r10 = move-exception
            r3 = r2
            goto L_0x0073
        L_0x0056:
            r3 = r2
        L_0x0057:
            r9.remove(r10)     // Catch:{ all -> 0x0072 }
            if (r3 == 0) goto L_0x0062
            r3.close()     // Catch:{ IOException -> 0x0060 }
            goto L_0x0062
        L_0x0060:
            monitor-exit(r9)
            return r2
        L_0x0062:
            monitor-exit(r9)
            return r2
        L_0x0064:
            r3 = r2
        L_0x0065:
            r9.remove(r10)     // Catch:{ all -> 0x0072 }
            if (r3 == 0) goto L_0x0070
            r3.close()     // Catch:{ IOException -> 0x006e }
            goto L_0x0070
        L_0x006e:
            monitor-exit(r9)
            return r2
        L_0x0070:
            monitor-exit(r9)
            return r2
        L_0x0072:
            r10 = move-exception
        L_0x0073:
            if (r3 == 0) goto L_0x007b
            r3.close()     // Catch:{ IOException -> 0x0079 }
            goto L_0x007b
        L_0x0079:
            monitor-exit(r9)
            return r2
        L_0x007b:
            throw r10     // Catch:{ all -> 0x007c }
        L_0x007c:
            r10 = move-exception
            monitor-exit(r9)
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.cache.DiskBasedCache.get(java.lang.String):com.didi.sdk.cache.Cache$Entry");
    }

    public synchronized void initialize() {
        if (!this.f38381e.exists()) {
            this.f38381e.mkdirs();
        }
    }

    public synchronized void invalidate(String str, boolean z) {
        Cache.Entry entry = get(str);
        if (entry != null) {
            entry.softTtl = 0;
            if (z) {
                entry.ttl = 0;
            }
            put(str, entry);
        }
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(4:12|13|14|15) */
    /* JADX WARNING: Code restructure failed: missing block: B:13:?, code lost:
        r0.delete();
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x003a, code lost:
        return;
     */
    /* JADX WARNING: Missing exception handler attribute for start block: B:12:0x0036 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void put(java.lang.String r5, com.didi.sdk.cache.Cache.Entry r6) {
        /*
            r4 = this;
            monitor-enter(r4)
            byte[] r0 = r6.data     // Catch:{ all -> 0x003b }
            int r0 = r0.length     // Catch:{ all -> 0x003b }
            r4.m28948a((int) r0)     // Catch:{ all -> 0x003b }
            java.io.File r0 = r4.getFileForKey(r5)     // Catch:{ all -> 0x003b }
            java.io.BufferedOutputStream r1 = new java.io.BufferedOutputStream     // Catch:{ IOException -> 0x0036 }
            java.io.FileOutputStream r2 = new java.io.FileOutputStream     // Catch:{ IOException -> 0x0036 }
            r2.<init>(r0)     // Catch:{ IOException -> 0x0036 }
            r1.<init>(r2)     // Catch:{ IOException -> 0x0036 }
            com.didi.sdk.cache.DiskBasedCache$CacheHeader r2 = new com.didi.sdk.cache.DiskBasedCache$CacheHeader     // Catch:{ IOException -> 0x0036 }
            r2.<init>(r5, r6)     // Catch:{ IOException -> 0x0036 }
            boolean r3 = r2.writeHeader(r1)     // Catch:{ IOException -> 0x0036 }
            if (r3 == 0) goto L_0x002d
            byte[] r6 = r6.data     // Catch:{ IOException -> 0x0036 }
            r1.write(r6)     // Catch:{ IOException -> 0x0036 }
            r1.close()     // Catch:{ IOException -> 0x0036 }
            r4.m28952a((java.lang.String) r5, (com.didi.sdk.cache.DiskBasedCache.CacheHeader) r2)     // Catch:{ IOException -> 0x0036 }
            monitor-exit(r4)
            return
        L_0x002d:
            r1.close()     // Catch:{ IOException -> 0x0036 }
            java.io.IOException r5 = new java.io.IOException     // Catch:{ IOException -> 0x0036 }
            r5.<init>()     // Catch:{ IOException -> 0x0036 }
            throw r5     // Catch:{ IOException -> 0x0036 }
        L_0x0036:
            r0.delete()     // Catch:{ all -> 0x003b }
            monitor-exit(r4)
            return
        L_0x003b:
            r5 = move-exception
            monitor-exit(r4)
            throw r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.cache.DiskBasedCache.put(java.lang.String, com.didi.sdk.cache.Cache$Entry):void");
    }

    public synchronized void remove(String str) {
        getFileForKey(str).delete();
        m28956b(str);
    }

    /* renamed from: a */
    private String m28947a(String str) {
        int length = str.length() / 2;
        String valueOf = String.valueOf(str.substring(0, length).hashCode());
        return valueOf + String.valueOf(str.substring(length).hashCode());
    }

    public File getFileForKey(String str) {
        return new File(this.f38381e, m28947a(str));
    }

    /* renamed from: a */
    private void m28948a(int i) {
        long j = (long) i;
        if (this.f38383g + j >= ((long) this.f38382f)) {
            SystemClock.elapsedRealtime();
            Iterator<Map.Entry<String, CacheHeader>> it = this.f38380d.entrySet().iterator();
            while (it.hasNext()) {
                CacheHeader cacheHeader = (CacheHeader) it.next().getValue();
                if (getFileForKey(cacheHeader.key).delete()) {
                    this.f38383g -= cacheHeader.size;
                }
                it.remove();
                if (((float) (this.f38383g + j)) < ((float) this.f38382f) * f38378b) {
                    return;
                }
            }
        }
    }

    /* renamed from: a */
    private void m28952a(String str, CacheHeader cacheHeader) {
        if (!this.f38380d.containsKey(str)) {
            this.f38383g += cacheHeader.size;
        } else {
            this.f38383g += cacheHeader.size - this.f38380d.get(str).size;
        }
        this.f38380d.put(str, cacheHeader);
    }

    /* renamed from: b */
    private void m28956b(String str) {
        CacheHeader cacheHeader = this.f38380d.get(str);
        if (cacheHeader != null) {
            this.f38383g -= cacheHeader.size;
            this.f38380d.remove(str);
        }
    }

    static class CacheHeader {
        public String etag;
        public String key;
        public long lastModified;
        public Map<String, String> responseHeaders;
        public long serverDate;
        public long size;
        public long softTtl;
        public long ttl;

        private CacheHeader() {
        }

        public CacheHeader(String str, Cache.Entry entry) {
            this.key = str;
            this.size = (long) entry.data.length;
            this.etag = entry.etag;
            this.serverDate = entry.serverDate;
            this.lastModified = entry.lastModified;
            this.ttl = entry.ttl;
            this.softTtl = entry.softTtl;
            this.responseHeaders = entry.responseHeaders;
        }

        public static CacheHeader readHeader(InputStream inputStream) throws IOException {
            CacheHeader cacheHeader = new CacheHeader();
            if (DiskBasedCache.m28946a(inputStream) == DiskBasedCache.f38379c) {
                cacheHeader.key = DiskBasedCache.m28957c(inputStream);
                String c = DiskBasedCache.m28957c(inputStream);
                cacheHeader.etag = c;
                if (c.equals("")) {
                    cacheHeader.etag = null;
                }
                cacheHeader.serverDate = DiskBasedCache.m28955b(inputStream);
                cacheHeader.lastModified = DiskBasedCache.m28955b(inputStream);
                cacheHeader.ttl = DiskBasedCache.m28955b(inputStream);
                cacheHeader.softTtl = DiskBasedCache.m28955b(inputStream);
                cacheHeader.responseHeaders = DiskBasedCache.m28958d(inputStream);
                return cacheHeader;
            }
            throw new IOException();
        }

        public Cache.Entry toCacheEntry(byte[] bArr) {
            Cache.Entry entry = new Cache.Entry();
            entry.data = bArr;
            entry.etag = this.etag;
            entry.serverDate = this.serverDate;
            entry.lastModified = this.lastModified;
            entry.ttl = this.ttl;
            entry.softTtl = this.softTtl;
            entry.responseHeaders = this.responseHeaders;
            return entry;
        }

        public boolean writeHeader(OutputStream outputStream) {
            try {
                DiskBasedCache.m28949a(outputStream, (int) DiskBasedCache.f38379c);
                DiskBasedCache.m28951a(outputStream, this.key);
                DiskBasedCache.m28951a(outputStream, this.etag == null ? "" : this.etag);
                DiskBasedCache.m28950a(outputStream, this.serverDate);
                DiskBasedCache.m28950a(outputStream, this.lastModified);
                DiskBasedCache.m28950a(outputStream, this.ttl);
                DiskBasedCache.m28950a(outputStream, this.softTtl);
                DiskBasedCache.m28953a(this.responseHeaders, outputStream);
                outputStream.flush();
                return true;
            } catch (IOException unused) {
                return false;
            }
        }
    }

    private static class CountingInputStream extends FilterInputStream {
        /* access modifiers changed from: private */
        public int bytesRead;

        private CountingInputStream(InputStream inputStream) {
            super(inputStream);
            this.bytesRead = 0;
        }

        public int read() throws IOException {
            int read = super.read();
            if (read != -1) {
                this.bytesRead++;
            }
            return read;
        }

        public int read(byte[] bArr, int i, int i2) throws IOException {
            int read = super.read(bArr, i, i2);
            if (read != -1) {
                this.bytesRead += read;
            }
            return read;
        }
    }
}
