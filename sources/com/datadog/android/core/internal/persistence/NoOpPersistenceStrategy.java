package com.datadog.android.core.internal.persistence;

import com.datadog.android.core.internal.data.upload.Flusher;
import com.datadog.android.core.internal.data.upload.NoOpFlusher;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\b\u0012\u0004\u0012\u0002H\u00010\u0003B\u0005¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J\b\u0010\u0007\u001a\u00020\bH\u0016J\u000e\u0010\t\u001a\b\u0012\u0004\u0012\u00028\u00000\nH\u0016¨\u0006\u000b"}, mo148868d2 = {"Lcom/datadog/android/core/internal/persistence/NoOpPersistenceStrategy;", "T", "", "Lcom/datadog/android/core/internal/persistence/PersistenceStrategy;", "()V", "getFlusher", "Lcom/datadog/android/core/internal/data/upload/Flusher;", "getReader", "Lcom/datadog/android/core/internal/persistence/DataReader;", "getWriter", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: NoOpPersistenceStrategy.kt */
public final class NoOpPersistenceStrategy<T> implements PersistenceStrategy<T> {
    public DataWriter<T> getWriter() {
        return new NoOpDataWriter<>();
    }

    public DataReader getReader() {
        return new NoOpDataReader();
    }

    public Flusher getFlusher() {
        return new NoOpFlusher();
    }
}
