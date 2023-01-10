package com.didiglobal.enginecore.cache;

import java.io.IOException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okio.Buffer;
import okio.BufferedSink;
import okio.BufferedSource;
import okio.Source;
import okio.Timeout;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0004\u001a\u00020\u0005H\u0016J\u0018\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0007H\u0016J\b\u0010\u000b\u001a\u00020\fH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000¨\u0006\r"}, mo148868d2 = {"com/didiglobal/enginecore/cache/XEngineCache$cacheWritingResponse$cacheWritingSource$1", "Lokio/Source;", "cacheRequestClosed", "", "close", "", "read", "", "sink", "Lokio/Buffer;", "byteCount", "timeout", "Lokio/Timeout;", "engine-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: XEngineCache.kt */
public final class XEngineCache$cacheWritingResponse$cacheWritingSource$1 implements Source {
    final /* synthetic */ BufferedSink $cacheBody;
    final /* synthetic */ XECacheRequest $cacheRequest;
    final /* synthetic */ BufferedSource $source;
    private boolean cacheRequestClosed;

    XEngineCache$cacheWritingResponse$cacheWritingSource$1(BufferedSource bufferedSource, XECacheRequest xECacheRequest, BufferedSink bufferedSink) {
        this.$source = bufferedSource;
        this.$cacheRequest = xECacheRequest;
        this.$cacheBody = bufferedSink;
    }

    public long read(Buffer buffer, long j) throws IOException {
        Intrinsics.checkParameterIsNotNull(buffer, "sink");
        try {
            long read = this.$source.read(buffer, j);
            if (read == -1) {
                if (!this.cacheRequestClosed) {
                    this.cacheRequestClosed = true;
                    this.$cacheBody.close();
                }
                return -1;
            }
            buffer.copyTo(this.$cacheBody.getBuffer(), buffer.size() - read, read);
            this.$cacheBody.emitCompleteSegments();
            return read;
        } catch (IOException e) {
            if (!this.cacheRequestClosed) {
                this.cacheRequestClosed = true;
                this.$cacheRequest.abort();
            }
            throw e;
        }
    }

    public Timeout timeout() {
        return this.$source.timeout();
    }

    public void close() throws IOException {
        if (!this.cacheRequestClosed && !C13315Util.discard(this, 100, TimeUnit.MILLISECONDS)) {
            this.cacheRequestClosed = true;
            this.$cacheRequest.abort();
        }
        this.$source.close();
    }
}
