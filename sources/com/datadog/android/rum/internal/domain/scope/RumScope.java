package com.datadog.android.rum.internal.domain.scope;

import com.datadog.android.core.internal.persistence.DataWriter;
import com.datadog.android.rum.internal.domain.RumContext;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\ba\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J \u0010\u0004\u001a\u0004\u0018\u00010\u00002\u0006\u0010\u0005\u001a\u00020\u00062\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00010\bH&¨\u0006\t"}, mo148868d2 = {"Lcom/datadog/android/rum/internal/domain/scope/RumScope;", "", "getRumContext", "Lcom/datadog/android/rum/internal/domain/RumContext;", "handleEvent", "event", "Lcom/datadog/android/rum/internal/domain/scope/RumRawEvent;", "writer", "Lcom/datadog/android/core/internal/persistence/DataWriter;", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: RumScope.kt */
public interface RumScope {
    RumContext getRumContext();

    RumScope handleEvent(RumRawEvent rumRawEvent, DataWriter<Object> dataWriter);
}
