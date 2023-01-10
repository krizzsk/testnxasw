package com.koushikdutta.async.http.cache;

import android.net.Uri;
import android.util.Base64;
import com.google.common.net.HttpHeaders;
import com.koushikdutta.async.AsyncSSLSocket;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.AsyncSocket;
import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.FilteredDataEmitter;
import com.koushikdutta.async.callback.CompletedCallback;
import com.koushikdutta.async.callback.WritableCallback;
import com.koushikdutta.async.future.Cancellable;
import com.koushikdutta.async.future.SimpleCancellable;
import com.koushikdutta.async.http.AsyncHttpClient;
import com.koushikdutta.async.http.AsyncHttpClientMiddleware;
import com.koushikdutta.async.http.AsyncHttpRequest;
import com.koushikdutta.async.http.Headers;
import com.koushikdutta.async.http.SimpleMiddleware;
import com.koushikdutta.async.util.Allocator;
import com.koushikdutta.async.util.Charsets;
import com.koushikdutta.async.util.FileCache;
import com.koushikdutta.async.util.StreamUtility;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.CacheResponse;
import java.nio.ByteBuffer;
import java.security.cert.Certificate;
import java.security.cert.CertificateEncodingException;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import javax.net.ssl.SSLEngine;

public class ResponseCacheMiddleware extends SimpleMiddleware {
    public static final String CACHE = "cache";
    public static final String CONDITIONAL_CACHE = "conditional-cache";
    public static final int ENTRY_BODY = 1;
    public static final int ENTRY_COUNT = 2;
    public static final int ENTRY_METADATA = 0;
    public static final String SERVED_FROM = "X-Served-From";

    /* renamed from: a */
    private static final String f58183a = "AsyncHttpCache";

    /* renamed from: b */
    private boolean f58184b = true;

    /* renamed from: c */
    private int f58185c;

    /* renamed from: d */
    private int f58186d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public FileCache f58187e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public AsyncServer f58188f;

    /* renamed from: g */
    private int f58189g;

    /* renamed from: h */
    private int f58190h;

    /* renamed from: i */
    private int f58191i;

    /* renamed from: j */
    private int f58192j;

    public static class CacheData {
        C21203d cachedResponseHeaders;
        EntryCacheResponse candidate;
        long contentLength;
        FileInputStream[] snapshot;
    }

    /* renamed from: c */
    static /* synthetic */ int m44074c(ResponseCacheMiddleware responseCacheMiddleware) {
        int i = responseCacheMiddleware.f58185c;
        responseCacheMiddleware.f58185c = i + 1;
        return i;
    }

    /* renamed from: d */
    static /* synthetic */ int m44075d(ResponseCacheMiddleware responseCacheMiddleware) {
        int i = responseCacheMiddleware.f58186d;
        responseCacheMiddleware.f58186d = i + 1;
        return i;
    }

    private ResponseCacheMiddleware() {
    }

    public static ResponseCacheMiddleware addCache(AsyncHttpClient asyncHttpClient, File file, long j) throws IOException {
        for (AsyncHttpClientMiddleware asyncHttpClientMiddleware : asyncHttpClient.getMiddleware()) {
            if (asyncHttpClientMiddleware instanceof ResponseCacheMiddleware) {
                throw new IOException("Response cache already added to http client");
            }
        }
        ResponseCacheMiddleware responseCacheMiddleware = new ResponseCacheMiddleware();
        responseCacheMiddleware.f58188f = asyncHttpClient.getServer();
        responseCacheMiddleware.f58187e = new FileCache(file, j, false);
        asyncHttpClient.insertMiddleware(responseCacheMiddleware);
        return responseCacheMiddleware;
    }

    public FileCache getFileCache() {
        return this.f58187e;
    }

    public boolean getCaching() {
        return this.f58184b;
    }

    public void setCaching(boolean z) {
        this.f58184b = z;
    }

    public void removeFromCache(Uri uri) {
        getFileCache().remove(FileCache.toKeyString(uri));
    }

    public Cancellable getSocket(final AsyncHttpClientMiddleware.GetSocketData getSocketData) {
        FileInputStream[] fileInputStreamArr;
        C21202c cVar = new C21202c(getSocketData.request.getUri(), C21201b.m44078a((Map<String, List<String>>) getSocketData.request.getHeaders().getMultiMap()));
        getSocketData.state.put("request-headers", cVar);
        if (this.f58187e == null || !this.f58184b || cVar.mo173641e()) {
            this.f58191i++;
            return null;
        }
        try {
            fileInputStreamArr = this.f58187e.get(FileCache.toKeyString(getSocketData.request.getUri()), 2);
            if (fileInputStreamArr == null) {
                try {
                    this.f58191i++;
                    return null;
                } catch (IOException unused) {
                    this.f58191i++;
                    StreamUtility.closeQuietly(fileInputStreamArr);
                    return null;
                }
            } else {
                long available = (long) fileInputStreamArr[1].available();
                Entry entry = new Entry(fileInputStreamArr[0]);
                if (!entry.matches(getSocketData.request.getUri(), getSocketData.request.getMethod(), getSocketData.request.getHeaders().getMultiMap())) {
                    this.f58191i++;
                    StreamUtility.closeQuietly(fileInputStreamArr);
                    return null;
                }
                EntryCacheResponse entryCacheResponse = new EntryCacheResponse(entry, fileInputStreamArr[1]);
                try {
                    Map<String, List<String>> headers = entryCacheResponse.getHeaders();
                    FileInputStream body = entryCacheResponse.getBody();
                    if (headers == null || body == null) {
                        this.f58191i++;
                        StreamUtility.closeQuietly(fileInputStreamArr);
                        return null;
                    }
                    C21201b a = C21201b.m44078a(headers);
                    C21203d dVar = new C21203d(getSocketData.request.getUri(), a);
                    a.mo173621b(HttpHeaders.CONTENT_LENGTH, String.valueOf(available));
                    a.mo173623c(HttpHeaders.CONTENT_ENCODING);
                    a.mo173623c(HttpHeaders.TRANSFER_ENCODING);
                    dVar.mo173661a(System.currentTimeMillis(), System.currentTimeMillis());
                    ResponseSource a2 = dVar.mo173660a(System.currentTimeMillis(), cVar);
                    if (a2 == ResponseSource.CACHE) {
                        getSocketData.request.logi("Response retrieved from cache");
                        final CachedSocket cachedSSLSocket = entry.isHttps() ? new CachedSSLSocket(entryCacheResponse, available) : new CachedSocket(entryCacheResponse, available);
                        cachedSSLSocket.pending.add(ByteBuffer.wrap(a.mo173627f().getBytes()));
                        this.f58188f.post(new Runnable() {
                            public void run() {
                                getSocketData.connectCallback.onConnectCompleted((Exception) null, cachedSSLSocket);
                                cachedSSLSocket.sendCachedDataOnNetworkThread();
                            }
                        });
                        this.f58190h++;
                        getSocketData.state.put("socket-owner", this);
                        SimpleCancellable simpleCancellable = new SimpleCancellable();
                        simpleCancellable.setComplete();
                        return simpleCancellable;
                    } else if (a2 == ResponseSource.CONDITIONAL_CACHE) {
                        getSocketData.request.logi("Response may be served from conditional cache");
                        CacheData cacheData = new CacheData();
                        cacheData.snapshot = fileInputStreamArr;
                        cacheData.contentLength = available;
                        cacheData.cachedResponseHeaders = dVar;
                        cacheData.candidate = entryCacheResponse;
                        getSocketData.state.put("cache-data", cacheData);
                        return null;
                    } else {
                        getSocketData.request.logd("Response can not be served from cache");
                        this.f58191i++;
                        StreamUtility.closeQuietly(fileInputStreamArr);
                        return null;
                    }
                } catch (Exception unused2) {
                    this.f58191i++;
                    StreamUtility.closeQuietly(fileInputStreamArr);
                    return null;
                }
            }
        } catch (IOException unused3) {
            fileInputStreamArr = null;
            this.f58191i++;
            StreamUtility.closeQuietly(fileInputStreamArr);
            return null;
        }
    }

    public int getConditionalCacheHitCount() {
        return this.f58189g;
    }

    public int getCacheHitCount() {
        return this.f58190h;
    }

    public int getNetworkCount() {
        return this.f58191i;
    }

    public int getCacheStoreCount() {
        return this.f58192j;
    }

    public void onBodyDecoder(AsyncHttpClientMiddleware.OnBodyDecoderData onBodyDecoderData) {
        if (((CachedSocket) C21121Util.getWrappedSocket(onBodyDecoderData.socket, CachedSocket.class)) != null) {
            onBodyDecoderData.response.headers().set(SERVED_FROM, "cache");
            return;
        }
        CacheData cacheData = (CacheData) onBodyDecoderData.state.get("cache-data");
        C21201b a = C21201b.m44078a((Map<String, List<String>>) onBodyDecoderData.response.headers().getMultiMap());
        a.mo173623c(HttpHeaders.CONTENT_LENGTH);
        a.mo173615a(String.format(Locale.ENGLISH, "%s %s %s", new Object[]{onBodyDecoderData.response.protocol(), Integer.valueOf(onBodyDecoderData.response.code()), onBodyDecoderData.response.message()}));
        C21203d dVar = new C21203d(onBodyDecoderData.request.getUri(), a);
        onBodyDecoderData.state.put("response-headers", dVar);
        if (cacheData != null) {
            if (cacheData.cachedResponseHeaders.mo173664a(dVar)) {
                onBodyDecoderData.request.logi("Serving response from conditional cache");
                C21203d b = cacheData.cachedResponseHeaders.mo173666b(dVar);
                onBodyDecoderData.response.headers(new Headers(b.mo173671f().mo173628g()));
                onBodyDecoderData.response.code(b.mo173671f().mo173622c());
                onBodyDecoderData.response.message(b.mo173671f().mo173624d());
                onBodyDecoderData.response.headers().set(SERVED_FROM, CONDITIONAL_CACHE);
                this.f58189g++;
                CachedBodyEmitter cachedBodyEmitter = new CachedBodyEmitter(cacheData.candidate, cacheData.contentLength);
                cachedBodyEmitter.setDataEmitter(onBodyDecoderData.bodyEmitter);
                onBodyDecoderData.bodyEmitter = cachedBodyEmitter;
                cachedBodyEmitter.sendCachedData();
                return;
            }
            onBodyDecoderData.state.remove("cache-data");
            StreamUtility.closeQuietly(cacheData.snapshot);
        }
        if (this.f58184b) {
            C21202c cVar = (C21202c) onBodyDecoderData.state.get("request-headers");
            if (cVar == null || !dVar.mo173663a(cVar) || !onBodyDecoderData.request.getMethod().equals("GET")) {
                this.f58191i++;
                onBodyDecoderData.request.logd("Response is not cacheable");
                return;
            }
            String keyString = FileCache.toKeyString(onBodyDecoderData.request.getUri());
            Entry entry = new Entry(onBodyDecoderData.request.getUri(), cVar.mo173638d().mo173611a(dVar.mo173682q()), onBodyDecoderData.request, dVar.mo173671f());
            BodyCacher bodyCacher = new BodyCacher();
            EntryEditor entryEditor = new EntryEditor(keyString);
            try {
                entry.writeTo(entryEditor);
                entryEditor.newOutputStream(1);
                bodyCacher.editor = entryEditor;
                bodyCacher.setDataEmitter(onBodyDecoderData.bodyEmitter);
                onBodyDecoderData.bodyEmitter = bodyCacher;
                onBodyDecoderData.state.put("body-cacher", bodyCacher);
                onBodyDecoderData.request.logd("Caching response");
                this.f58192j++;
            } catch (Exception unused) {
                entryEditor.abort();
                this.f58191i++;
            }
        }
    }

    public void onResponseComplete(AsyncHttpClientMiddleware.OnResponseCompleteData onResponseCompleteData) {
        CacheData cacheData = (CacheData) onResponseCompleteData.state.get("cache-data");
        if (!(cacheData == null || cacheData.snapshot == null)) {
            StreamUtility.closeQuietly(cacheData.snapshot);
        }
        CachedSocket cachedSocket = (CachedSocket) C21121Util.getWrappedSocket(onResponseCompleteData.socket, CachedSocket.class);
        if (cachedSocket != null) {
            StreamUtility.closeQuietly(cachedSocket.cacheResponse.getBody());
        }
        BodyCacher bodyCacher = (BodyCacher) onResponseCompleteData.state.get("body-cacher");
        if (bodyCacher == null) {
            return;
        }
        if (onResponseCompleteData.exception != null) {
            bodyCacher.abort();
        } else {
            bodyCacher.commit();
        }
    }

    public void clear() {
        FileCache fileCache = this.f58187e;
        if (fileCache != null) {
            fileCache.clear();
        }
    }

    private static class BodyCacher extends FilteredDataEmitter {
        ByteBufferList cached;
        EntryEditor editor;

        private BodyCacher() {
        }

        /* access modifiers changed from: protected */
        public void report(Exception exc) {
            super.report(exc);
            if (exc != null) {
                abort();
            }
        }

        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0047 */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public void onDataAvailable(com.koushikdutta.async.DataEmitter r4, com.koushikdutta.async.ByteBufferList r5) {
            /*
                r3 = this;
                com.koushikdutta.async.ByteBufferList r0 = r3.cached
                if (r0 == 0) goto L_0x0013
                super.onDataAvailable(r4, r0)
                com.koushikdutta.async.ByteBufferList r0 = r3.cached
                int r0 = r0.remaining()
                if (r0 <= 0) goto L_0x0010
                return
            L_0x0010:
                r0 = 0
                r3.cached = r0
            L_0x0013:
                com.koushikdutta.async.ByteBufferList r0 = new com.koushikdutta.async.ByteBufferList
                r0.<init>()
                com.koushikdutta.async.http.cache.ResponseCacheMiddleware$EntryEditor r1 = r3.editor     // Catch:{ Exception -> 0x0047 }
                if (r1 == 0) goto L_0x003e
                com.koushikdutta.async.http.cache.ResponseCacheMiddleware$EntryEditor r1 = r3.editor     // Catch:{ Exception -> 0x0047 }
                r2 = 1
                java.io.FileOutputStream r1 = r1.newOutputStream(r2)     // Catch:{ Exception -> 0x0047 }
                if (r1 == 0) goto L_0x003b
            L_0x0025:
                boolean r2 = r5.isEmpty()     // Catch:{ Exception -> 0x0047 }
                if (r2 != 0) goto L_0x003e
                java.nio.ByteBuffer r2 = r5.remove()     // Catch:{ Exception -> 0x0047 }
                com.koushikdutta.async.ByteBufferList.writeOutputStream(r1, r2)     // Catch:{ all -> 0x0036 }
                r0.add((java.nio.ByteBuffer) r2)     // Catch:{ Exception -> 0x0047 }
                goto L_0x0025
            L_0x0036:
                r1 = move-exception
                r0.add((java.nio.ByteBuffer) r2)     // Catch:{ Exception -> 0x0047 }
                throw r1     // Catch:{ Exception -> 0x0047 }
            L_0x003b:
                r3.abort()     // Catch:{ Exception -> 0x0047 }
            L_0x003e:
                r5.get((com.koushikdutta.async.ByteBufferList) r0)
                r0.get((com.koushikdutta.async.ByteBufferList) r5)
                goto L_0x004b
            L_0x0045:
                r4 = move-exception
                goto L_0x0063
            L_0x0047:
                r3.abort()     // Catch:{ all -> 0x0045 }
                goto L_0x003e
            L_0x004b:
                super.onDataAvailable(r4, r5)
                com.koushikdutta.async.http.cache.ResponseCacheMiddleware$EntryEditor r4 = r3.editor
                if (r4 == 0) goto L_0x0062
                int r4 = r5.remaining()
                if (r4 <= 0) goto L_0x0062
                com.koushikdutta.async.ByteBufferList r4 = new com.koushikdutta.async.ByteBufferList
                r4.<init>()
                r3.cached = r4
                r5.get((com.koushikdutta.async.ByteBufferList) r4)
            L_0x0062:
                return
            L_0x0063:
                r5.get((com.koushikdutta.async.ByteBufferList) r0)
                r0.get((com.koushikdutta.async.ByteBufferList) r5)
                throw r4
            */
            throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.cache.ResponseCacheMiddleware.BodyCacher.onDataAvailable(com.koushikdutta.async.DataEmitter, com.koushikdutta.async.ByteBufferList):void");
        }

        public void close() {
            abort();
            super.close();
        }

        public void abort() {
            EntryEditor entryEditor = this.editor;
            if (entryEditor != null) {
                entryEditor.abort();
                this.editor = null;
            }
        }

        public void commit() {
            EntryEditor entryEditor = this.editor;
            if (entryEditor != null) {
                entryEditor.commit();
                this.editor = null;
            }
        }
    }

    private static class CachedBodyEmitter extends FilteredDataEmitter {
        static final /* synthetic */ boolean $assertionsDisabled = false;
        private Allocator allocator = new Allocator();
        boolean allowEnd;
        EntryCacheResponse cacheResponse;
        private boolean paused;
        ByteBufferList pending = new ByteBufferList();
        Runnable sendCachedDataRunnable = new Runnable() {
            public void run() {
                CachedBodyEmitter.this.sendCachedDataOnNetworkThread();
            }
        };

        static {
            Class<ResponseCacheMiddleware> cls = ResponseCacheMiddleware.class;
        }

        public CachedBodyEmitter(EntryCacheResponse entryCacheResponse, long j) {
            this.cacheResponse = entryCacheResponse;
            this.allocator.setCurrentAlloc((int) j);
        }

        /* access modifiers changed from: package-private */
        public void sendCachedDataOnNetworkThread() {
            if (this.pending.remaining() > 0) {
                super.onDataAvailable(this, this.pending);
                if (this.pending.remaining() > 0) {
                    return;
                }
            }
            try {
                ByteBuffer allocate = this.allocator.allocate();
                int read = this.cacheResponse.getBody().read(allocate.array(), allocate.arrayOffset(), allocate.capacity());
                if (read == -1) {
                    ByteBufferList.reclaim(allocate);
                    this.allowEnd = true;
                    report((Exception) null);
                    return;
                }
                this.allocator.track((long) read);
                allocate.limit(read);
                this.pending.add(allocate);
                super.onDataAvailable(this, this.pending);
                if (this.pending.remaining() <= 0) {
                    getServer().postDelayed(this.sendCachedDataRunnable, 10);
                }
            } catch (IOException e) {
                this.allowEnd = true;
                report(e);
            }
        }

        /* access modifiers changed from: package-private */
        public void sendCachedData() {
            getServer().post(this.sendCachedDataRunnable);
        }

        public void resume() {
            this.paused = false;
            sendCachedData();
        }

        public boolean isPaused() {
            return this.paused;
        }

        public void close() {
            if (getServer().getAffinity() != Thread.currentThread()) {
                getServer().post(new Runnable() {
                    public void run() {
                        CachedBodyEmitter.this.close();
                    }
                });
                return;
            }
            this.pending.recycle();
            StreamUtility.closeQuietly(this.cacheResponse.getBody());
            super.close();
        }

        /* access modifiers changed from: protected */
        public void report(Exception exc) {
            if (this.allowEnd) {
                StreamUtility.closeQuietly(this.cacheResponse.getBody());
                super.report(exc);
            }
        }
    }

    private static final class Entry {
        private final String cipherSuite;
        private final Certificate[] localCertificates;
        private final Certificate[] peerCertificates;
        private final String requestMethod;
        /* access modifiers changed from: private */
        public final C21201b responseHeaders;
        private final String uri;
        private final C21201b varyHeaders;

        public Entry(InputStream inputStream) throws IOException {
            C21204e eVar;
            Throwable th;
            try {
                eVar = new C21204e(inputStream, Charsets.US_ASCII);
                try {
                    this.uri = eVar.mo173689a();
                    this.requestMethod = eVar.mo173689a();
                    this.varyHeaders = new C21201b();
                    int b = eVar.mo173690b();
                    for (int i = 0; i < b; i++) {
                        this.varyHeaders.mo173620b(eVar.mo173689a());
                    }
                    C21201b bVar = new C21201b();
                    this.responseHeaders = bVar;
                    bVar.mo173615a(eVar.mo173689a());
                    int b2 = eVar.mo173690b();
                    for (int i2 = 0; i2 < b2; i2++) {
                        this.responseHeaders.mo173620b(eVar.mo173689a());
                    }
                    this.cipherSuite = null;
                    this.peerCertificates = null;
                    this.localCertificates = null;
                    StreamUtility.closeQuietly(eVar, inputStream);
                } catch (Throwable th2) {
                    th = th2;
                    StreamUtility.closeQuietly(eVar, inputStream);
                    throw th;
                }
            } catch (Throwable th3) {
                Throwable th4 = th3;
                eVar = null;
                th = th4;
                StreamUtility.closeQuietly(eVar, inputStream);
                throw th;
            }
        }

        public Entry(Uri uri2, C21201b bVar, AsyncHttpRequest asyncHttpRequest, C21201b bVar2) {
            this.uri = uri2.toString();
            this.varyHeaders = bVar;
            this.requestMethod = asyncHttpRequest.getMethod();
            this.responseHeaders = bVar2;
            this.cipherSuite = null;
            this.peerCertificates = null;
            this.localCertificates = null;
        }

        public void writeTo(EntryEditor entryEditor) throws IOException {
            BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(entryEditor.newOutputStream(0), Charsets.UTF_8));
            bufferedWriter.write(this.uri + 10);
            bufferedWriter.write(this.requestMethod + 10);
            bufferedWriter.write(Integer.toString(this.varyHeaders.mo173626e()) + 10);
            for (int i = 0; i < this.varyHeaders.mo173626e(); i++) {
                bufferedWriter.write(this.varyHeaders.mo173613a(i) + ": " + this.varyHeaders.mo173619b(i) + 10);
            }
            bufferedWriter.write(this.responseHeaders.mo173612a() + 10);
            bufferedWriter.write(Integer.toString(this.responseHeaders.mo173626e()) + 10);
            for (int i2 = 0; i2 < this.responseHeaders.mo173626e(); i2++) {
                bufferedWriter.write(this.responseHeaders.mo173613a(i2) + ": " + this.responseHeaders.mo173619b(i2) + 10);
            }
            if (isHttps()) {
                bufferedWriter.write(10);
                bufferedWriter.write(this.cipherSuite + 10);
                writeCertArray(bufferedWriter, this.peerCertificates);
                writeCertArray(bufferedWriter, this.localCertificates);
            }
            bufferedWriter.close();
        }

        /* access modifiers changed from: private */
        public boolean isHttps() {
            return this.uri.startsWith("https://");
        }

        private Certificate[] readCertArray(C21204e eVar) throws IOException {
            int b = eVar.mo173690b();
            if (b == -1) {
                return null;
            }
            try {
                CertificateFactory instance = CertificateFactory.getInstance("X.509");
                Certificate[] certificateArr = new Certificate[b];
                for (int i = 0; i < b; i++) {
                    certificateArr[i] = instance.generateCertificate(new ByteArrayInputStream(Base64.decode(eVar.mo173689a(), 0)));
                }
                return certificateArr;
            } catch (CertificateException e) {
                throw new IOException(e.getMessage());
            }
        }

        private void writeCertArray(Writer writer, Certificate[] certificateArr) throws IOException {
            if (certificateArr == null) {
                writer.write("-1\n");
                return;
            }
            try {
                writer.write(Integer.toString(certificateArr.length) + 10);
                for (Certificate encoded : certificateArr) {
                    writer.write(Base64.encodeToString(encoded.getEncoded(), 0) + 10);
                }
            } catch (CertificateEncodingException e) {
                throw new IOException(e.getMessage());
            }
        }

        public boolean matches(Uri uri2, String str, Map<String, List<String>> map) {
            return this.uri.equals(uri2.toString()) && this.requestMethod.equals(str) && new C21203d(uri2, this.responseHeaders).mo173665a(this.varyHeaders.mo173628g(), map);
        }
    }

    static class EntryCacheResponse extends CacheResponse {
        private final Entry entry;
        private final FileInputStream snapshot;

        public EntryCacheResponse(Entry entry2, FileInputStream fileInputStream) {
            this.entry = entry2;
            this.snapshot = fileInputStream;
        }

        public Map<String, List<String>> getHeaders() {
            return this.entry.responseHeaders.mo173628g();
        }

        public FileInputStream getBody() {
            return this.snapshot;
        }
    }

    private class CachedSSLSocket extends CachedSocket implements AsyncSSLSocket {
        public X509Certificate[] getPeerCertificates() {
            return null;
        }

        public SSLEngine getSSLEngine() {
            return null;
        }

        public CachedSSLSocket(EntryCacheResponse entryCacheResponse, long j) {
            super(entryCacheResponse, j);
        }
    }

    private class CachedSocket extends CachedBodyEmitter implements AsyncSocket {
        boolean closed;
        CompletedCallback closedCallback;
        boolean open;

        public void end() {
        }

        public WritableCallback getWriteableCallback() {
            return null;
        }

        public void setWriteableCallback(WritableCallback writableCallback) {
        }

        public CachedSocket(EntryCacheResponse entryCacheResponse, long j) {
            super(entryCacheResponse, j);
            this.allowEnd = true;
        }

        /* access modifiers changed from: protected */
        public void report(Exception exc) {
            super.report(exc);
            if (!this.closed) {
                this.closed = true;
                CompletedCallback completedCallback = this.closedCallback;
                if (completedCallback != null) {
                    completedCallback.onCompleted(exc);
                }
            }
        }

        public void write(ByteBufferList byteBufferList) {
            byteBufferList.recycle();
        }

        public boolean isOpen() {
            return this.open;
        }

        public void close() {
            this.open = false;
        }

        public CompletedCallback getClosedCallback() {
            return this.closedCallback;
        }

        public void setClosedCallback(CompletedCallback completedCallback) {
            this.closedCallback = completedCallback;
        }

        public AsyncServer getServer() {
            return ResponseCacheMiddleware.this.f58188f;
        }
    }

    class EntryEditor {
        boolean done;
        String key;
        FileOutputStream[] outs = new FileOutputStream[2];
        File[] temps;

        public EntryEditor(String str) {
            this.key = str;
            this.temps = ResponseCacheMiddleware.this.f58187e.getTempFiles(2);
        }

        /* access modifiers changed from: package-private */
        public void commit() {
            StreamUtility.closeQuietly(this.outs);
            if (!this.done) {
                ResponseCacheMiddleware.this.f58187e.commitTempFiles(this.key, this.temps);
                ResponseCacheMiddleware.m44074c(ResponseCacheMiddleware.this);
                this.done = true;
            }
        }

        /* access modifiers changed from: package-private */
        public FileOutputStream newOutputStream(int i) throws IOException {
            FileOutputStream[] fileOutputStreamArr = this.outs;
            if (fileOutputStreamArr[i] == null) {
                fileOutputStreamArr[i] = new FileOutputStream(this.temps[i]);
            }
            return this.outs[i];
        }

        /* access modifiers changed from: package-private */
        public void abort() {
            StreamUtility.closeQuietly(this.outs);
            FileCache.removeFiles(this.temps);
            if (!this.done) {
                ResponseCacheMiddleware.m44075d(ResponseCacheMiddleware.this);
                this.done = true;
            }
        }
    }
}
