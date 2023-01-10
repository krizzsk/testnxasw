package com.datadog.android.log.internal.user;

import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.core.model.UserInfo;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001B\u0013\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003¢\u0006\u0002\u0010\u0005J\b\u0010\f\u001a\u00020\u0004H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0004H\u0016R\u001a\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001e\u0010\t\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u0004@BX\u000e¢\u0006\b\n\u0000\"\u0004\b\n\u0010\u000b¨\u0006\u0010"}, mo148868d2 = {"Lcom/datadog/android/log/internal/user/DatadogUserInfoProvider;", "Lcom/datadog/android/log/internal/user/MutableUserInfoProvider;", "dataWriter", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "Lcom/datadog/android/core/model/UserInfo;", "(Lcom/datadog/android/core/internal/persistence/DataWriter;)V", "getDataWriter$dd_sdk_android_release", "()Lcom/datadog/android/core/internal/persistence/DataWriter;", "value", "internalUserInfo", "setInternalUserInfo", "(Lcom/datadog/android/core/model/UserInfo;)V", "getUserInfo", "setUserInfo", "", "userInfo", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DatadogUserInfoProvider.kt */
public final class DatadogUserInfoProvider implements MutableUserInfoProvider {

    /* renamed from: a */
    private final DataWriter<UserInfo> f3638a;

    /* renamed from: b */
    private UserInfo f3639b = new UserInfo((String) null, (String) null, (String) null, (Map) null, 15, (DefaultConstructorMarker) null);

    public DatadogUserInfoProvider(DataWriter<UserInfo> dataWriter) {
        Intrinsics.checkNotNullParameter(dataWriter, "dataWriter");
        this.f3638a = dataWriter;
    }

    public final DataWriter<UserInfo> getDataWriter$dd_sdk_android_release() {
        return this.f3638a;
    }

    /* renamed from: a */
    private final void m2403a(UserInfo userInfo) {
        this.f3639b = userInfo;
        this.f3638a.write(userInfo);
    }

    public void setUserInfo(UserInfo userInfo) {
        Intrinsics.checkNotNullParameter(userInfo, "userInfo");
        m2403a(userInfo);
    }

    public UserInfo getUserInfo() {
        return this.f3639b;
    }
}
