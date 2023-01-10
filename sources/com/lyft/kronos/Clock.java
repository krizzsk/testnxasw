package com.lyft.kronos;

import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo148868d2 = {"Lcom/lyft/kronos/Clock;", "", "getCurrentTimeMs", "", "getElapsedTimeMs", "kronos-java"}, mo148869k = 1, mo148870mv = {1, 4, 0})
/* compiled from: Clock.kt */
public interface Clock {
    long getCurrentTimeMs();

    long getElapsedTimeMs();
}
