package com.datadog.android.core.internal.persistence;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\u0004H\u0016J\n\u0010\b\u001a\u0004\u0018\u00010\u0006H\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\n"}, mo148868d2 = {"Lcom/datadog/android/core/internal/persistence/NoOpDataReader;", "Lcom/datadog/android/core/internal/persistence/DataReader;", "()V", "drop", "", "data", "Lcom/datadog/android/core/internal/persistence/Batch;", "dropAll", "lockAndReadNext", "release", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: NoOpDataReader.kt */
public final class NoOpDataReader implements DataReader {
    public void drop(Batch batch) {
        Intrinsics.checkNotNullParameter(batch, "data");
    }

    public void dropAll() {
    }

    public Batch lockAndReadNext() {
        return null;
    }

    public void release(Batch batch) {
        Intrinsics.checkNotNullParameter(batch, "data");
    }
}
