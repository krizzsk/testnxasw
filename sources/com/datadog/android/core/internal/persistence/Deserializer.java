package com.datadog.android.core.internal.persistence;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b`\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0002J\u0017\u0010\u0003\u001a\u0004\u0018\u00018\u00002\u0006\u0010\u0004\u001a\u00020\u0005H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, mo148868d2 = {"Lcom/datadog/android/core/internal/persistence/Deserializer;", "T", "", "deserialize", "model", "", "(Ljava/lang/String;)Ljava/lang/Object;", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: Deserializer.kt */
public interface Deserializer<T> {
    T deserialize(String str);
}
