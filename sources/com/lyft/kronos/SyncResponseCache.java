package com.lyft.kronos;

import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\bf\u0018\u00002\u00020\u0001J\b\u0010\u000e\u001a\u00020\u000fH&R\u0018\u0010\u0002\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007R\u0018\u0010\b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\t\u0010\u0005\"\u0004\b\n\u0010\u0007R\u0018\u0010\u000b\u001a\u00020\u0003X¦\u000e¢\u0006\f\u001a\u0004\b\f\u0010\u0005\"\u0004\b\r\u0010\u0007¨\u0006\u0010"}, mo148868d2 = {"Lcom/lyft/kronos/SyncResponseCache;", "", "currentOffset", "", "getCurrentOffset", "()J", "setCurrentOffset", "(J)V", "currentTime", "getCurrentTime", "setCurrentTime", "elapsedTime", "getElapsedTime", "setElapsedTime", "clear", "", "kronos-java"}, mo148869k = 1, mo148870mv = {1, 4, 0})
/* compiled from: SyncResponseCache.kt */
public interface SyncResponseCache {
    void clear();

    long getCurrentOffset();

    long getCurrentTime();

    long getElapsedTime();

    void setCurrentOffset(long j);

    void setCurrentTime(long j);

    void setElapsedTime(long j);
}
