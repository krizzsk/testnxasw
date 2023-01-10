package com.datadog.android.event;

import com.datadog.android.tracing.model.SpanEvent;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bg\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001J\u0010\u0010\u0003\u001a\u00020\u00022\u0006\u0010\u0004\u001a\u00020\u0002H&¨\u0006\u0005"}, mo148868d2 = {"Lcom/datadog/android/event/SpanEventMapper;", "Lcom/datadog/android/event/EventMapper;", "Lcom/datadog/android/tracing/model/SpanEvent;", "map", "event", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SpanEventMapper.kt */
public interface SpanEventMapper extends EventMapper<SpanEvent> {
    SpanEvent map(SpanEvent spanEvent);
}
