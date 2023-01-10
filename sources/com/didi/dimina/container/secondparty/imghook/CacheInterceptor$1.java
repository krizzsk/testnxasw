package com.didi.dimina.container.secondparty.imghook;

import didihttp.internal.C21750Util;
import didihttp.internal.cache.CacheRequest;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

class CacheInterceptor$1 implements Source {
    boolean cacheRequestClosed;
    final /* synthetic */ C8160a this$0;
    final /* synthetic */ BufferedSink val$cacheBody;
    final /* synthetic */ CacheRequest val$cacheRequest;
    final /* synthetic */ BufferedSource val$source;

    CacheInterceptor$1(C8160a aVar, BufferedSource bufferedSource, CacheRequest cacheRequest, BufferedSink bufferedSink) {
        this.this$0 = aVar;
        this.val$source = bufferedSource;
        this.val$cacheRequest = cacheRequest;
        this.val$cacheBody = bufferedSink;
    }

    public long read(Buffer buffer, long j) throws IOException {
        try {
            long read = this.val$source.read(buffer, j);
            if (read == -1) {
                if (!this.cacheRequestClosed) {
                    this.cacheRequestClosed = true;
                    this.val$cacheBody.close();
                }
                return -1;
            }
            buffer.copyTo(this.val$cacheBody.buffer(), buffer.size() - read, read);
            this.val$cacheBody.emitCompleteSegments();
            return read;
        } catch (IOException e) {
            if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = true;
                this.val$cacheRequest.abort();
            }
            throw e;
        }
    }

    public Timeout timeout() {
        return this.val$source.timeout();
    }

    public void close() throws IOException {
        if (!this.cacheRequestClosed && !C21750Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.cacheRequestClosed = true;
            this.val$cacheRequest.abort();
        }
        this.val$source.close();
    }
}
