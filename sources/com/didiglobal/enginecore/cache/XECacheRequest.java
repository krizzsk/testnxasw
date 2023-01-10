package com.didiglobal.enginecore.cache;

import java.io.IOException;
import kotlin.Metadata;
import okio.Sink;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo148868d2 = {"Lcom/didiglobal/enginecore/cache/XECacheRequest;", "", "abort", "", "body", "Lokio/Sink;", "engine-core_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: XECacheRequest.kt */
public interface XECacheRequest {
    void abort();

    Sink body() throws IOException;
}
