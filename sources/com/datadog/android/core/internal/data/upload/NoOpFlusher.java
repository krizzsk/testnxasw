package com.datadog.android.core.internal.data.upload;

import com.datadog.android.core.internal.net.DataUploader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo148868d2 = {"Lcom/datadog/android/core/internal/data/upload/NoOpFlusher;", "Lcom/datadog/android/core/internal/data/upload/Flusher;", "()V", "flush", "", "uploader", "Lcom/datadog/android/core/internal/net/DataUploader;", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: NoOpFlusher.kt */
public final class NoOpFlusher implements Flusher {
    public void flush(DataUploader dataUploader) {
        Intrinsics.checkNotNullParameter(dataUploader, "uploader");
    }
}
