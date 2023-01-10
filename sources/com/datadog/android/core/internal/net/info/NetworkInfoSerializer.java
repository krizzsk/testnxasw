package com.datadog.android.core.internal.net.info;

import com.datadog.android.core.internal.persistence.Serializer;
import com.datadog.android.core.model.NetworkInfo;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0002H\u0016¨\u0006\u0007"}, mo148868d2 = {"Lcom/datadog/android/core/internal/net/info/NetworkInfoSerializer;", "Lcom/datadog/android/core/internal/persistence/Serializer;", "Lcom/datadog/android/core/model/NetworkInfo;", "()V", "serialize", "", "model", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: NetworkInfoSerializer.kt */
public final class NetworkInfoSerializer implements Serializer<NetworkInfo> {
    public String serialize(NetworkInfo networkInfo) {
        Intrinsics.checkNotNullParameter(networkInfo, "model");
        String jsonObject = networkInfo.toJson().getAsJsonObject().toString();
        Intrinsics.checkNotNullExpressionValue(jsonObject, "model.toJson().asJsonObject.toString()");
        return jsonObject;
    }
}
