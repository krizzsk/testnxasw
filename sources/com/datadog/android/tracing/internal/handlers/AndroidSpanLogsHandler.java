package com.datadog.android.tracing.internal.handlers;

import com.datadog.android.core.internal.utils.ThrowableExtKt;
import com.datadog.android.log.Logger;
import com.datadog.opentracing.DDSpan;
import com.datadog.opentracing.LogHandler;
import com.datadog.trace.api.DDTags;
import com.facebook.GraphRequest;
import java.util.Map;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import p218io.opentracing.log.Fields;

@Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010$\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0000\u0018\u0000 \u00192\u00020\u0001:\u0001\u0019B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\u0010\u0010\t\u001a\f\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u00030\n2\u0006\u0010\f\u001a\u00020\rH\u0002J \u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J*\u0010\u000e\u001a\u00020\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0010\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u00030\u00132\u0006\u0010\f\u001a\u00020\rH\u0016J\u0018\u0010\u000e\u001a\u00020\b2\u0006\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0016J\"\u0010\u000e\u001a\u00020\b2\u0010\u0010\u0012\u001a\f\u0012\u0004\u0012\u00020\u000b\u0012\u0002\b\u00030\u00132\u0006\u0010\f\u001a\u00020\rH\u0016J7\u0010\u0014\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\r2\u0014\u0010\u0012\u001a\u0010\u0012\u0004\u0012\u00020\u000b\u0012\u0006\u0012\u0004\u0018\u00010\u00150\n2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0016J\u0019\u0010\u0017\u001a\u0004\u0018\u00010\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002¢\u0006\u0002\u0010\u0018R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u001a"}, mo148868d2 = {"Lcom/datadog/android/tracing/internal/handlers/AndroidSpanLogsHandler;", "Lcom/datadog/opentracing/LogHandler;", "logger", "Lcom/datadog/android/log/Logger;", "(Lcom/datadog/android/log/Logger;)V", "getLogger", "()Lcom/datadog/android/log/Logger;", "extractError", "", "map", "", "", "span", "Lcom/datadog/opentracing/DDSpan;", "log", "timestampMicroseconds", "", "event", "fields", "", "logFields", "", "(Lcom/datadog/opentracing/DDSpan;Ljava/util/Map;Ljava/lang/Long;)V", "toMilliseconds", "(Ljava/lang/Long;)Ljava/lang/Long;", "Companion", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: AndroidSpanLogsHandler.kt */
public final class AndroidSpanLogsHandler implements LogHandler {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DEFAULT_EVENT_MESSAGE = "Span event";

    /* renamed from: a */
    private final Logger f4061a;

    public AndroidSpanLogsHandler(Logger logger) {
        Intrinsics.checkNotNullParameter(logger, "logger");
        this.f4061a = logger;
    }

    public final Logger getLogger() {
        return this.f4061a;
    }

    public void log(String str, DDSpan dDSpan) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(dDSpan, "span");
        m2552a(dDSpan, MapsKt.mutableMapOf(TuplesKt.m41339to("event", str)), (Long) null);
    }

    public void log(long j, String str, DDSpan dDSpan) {
        Intrinsics.checkNotNullParameter(str, "event");
        Intrinsics.checkNotNullParameter(dDSpan, "span");
        m2552a(dDSpan, MapsKt.mutableMapOf(TuplesKt.m41339to("event", str)), Long.valueOf(j));
    }

    public void log(Map<String, ?> map, DDSpan dDSpan) {
        Intrinsics.checkNotNullParameter(map, GraphRequest.FIELDS_PARAM);
        Intrinsics.checkNotNullParameter(dDSpan, "span");
        Map<String, ?> mutableMap = MapsKt.toMutableMap(map);
        m2553a(mutableMap, dDSpan);
        m2551a(this, dDSpan, mutableMap, (Long) null, 4, (Object) null);
    }

    public void log(long j, Map<String, ?> map, DDSpan dDSpan) {
        Intrinsics.checkNotNullParameter(map, GraphRequest.FIELDS_PARAM);
        Intrinsics.checkNotNullParameter(dDSpan, "span");
        Map<String, ?> mutableMap = MapsKt.toMutableMap(map);
        m2553a(mutableMap, dDSpan);
        m2552a(dDSpan, mutableMap, Long.valueOf(j));
    }

    /* renamed from: a */
    private final Long m2550a(Long l) {
        if (l == null) {
            return null;
        }
        return Long.valueOf(TimeUnit.MICROSECONDS.toMillis(l.longValue()));
    }

    /* renamed from: a */
    static /* synthetic */ void m2551a(AndroidSpanLogsHandler androidSpanLogsHandler, DDSpan dDSpan, Map map, Long l, int i, Object obj) {
        if ((i & 4) != 0) {
            l = null;
        }
        androidSpanLogsHandler.m2552a(dDSpan, map, l);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x000c, code lost:
        r0 = r0.toString();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m2552a(com.datadog.opentracing.DDSpan r9, java.util.Map<java.lang.String, java.lang.Object> r10, java.lang.Long r11) {
        /*
            r8 = this;
            java.lang.String r0 = "message"
            java.lang.Object r0 = r10.remove(r0)
            java.lang.String r1 = "Span event"
            if (r0 != 0) goto L_0x000c
        L_0x000a:
            r4 = r1
            goto L_0x0014
        L_0x000c:
            java.lang.String r0 = r0.toString()
            if (r0 != 0) goto L_0x0013
            goto L_0x000a
        L_0x0013:
            r4 = r0
        L_0x0014:
            java.math.BigInteger r0 = r9.getTraceId()
            java.lang.String r0 = r0.toString()
            java.lang.String r1 = "dd.trace_id"
            r10.put(r1, r0)
            java.math.BigInteger r9 = r9.getSpanId()
            java.lang.String r9 = r9.toString()
            java.lang.String r0 = "dd.span_id"
            r10.put(r0, r9)
            com.datadog.android.log.Logger r2 = r8.f4061a
            r3 = 2
            r5 = 0
            java.lang.Long r7 = r8.m2550a(r11)
            r6 = r10
            r2.internalLog$dd_sdk_android_release(r3, r4, r5, r6, r7)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.datadog.android.tracing.internal.handlers.AndroidSpanLogsHandler.m2552a(com.datadog.opentracing.DDSpan, java.util.Map, java.lang.Long):void");
    }

    /* renamed from: a */
    private final void m2553a(Map<String, ?> map, DDSpan dDSpan) {
        String str;
        String str2;
        String str3;
        Class<?> cls;
        Object remove = map.remove(Fields.ERROR_OBJECT);
        String str4 = null;
        Throwable th = remove instanceof Throwable ? (Throwable) remove : null;
        Object remove2 = map.remove("error.kind");
        if (remove2 == null) {
            str = null;
        } else {
            str = remove2.toString();
        }
        if (str == null) {
            str = (th == null || (cls = th.getClass()) == null) ? null : cls.getName();
        }
        if (str != null) {
            Object remove3 = map.remove("stack");
            Object obj = map.get("message");
            if (remove3 == null) {
                str2 = null;
            } else {
                str2 = remove3.toString();
            }
            if (str2 == null) {
                str2 = th == null ? null : ThrowableExtKt.loggableStackTrace(th);
            }
            if (obj == null) {
                str3 = null;
            } else {
                str3 = obj.toString();
            }
            if (str3 != null) {
                str4 = str3;
            } else if (th != null) {
                str4 = th.getMessage();
            }
            dDSpan.setError(true);
            dDSpan.setTag(DDTags.ERROR_TYPE, str);
            dDSpan.setTag(DDTags.ERROR_MSG, str4);
            dDSpan.setTag("error.stack", str2);
        }
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/datadog/android/tracing/internal/handlers/AndroidSpanLogsHandler$Companion;", "", "()V", "DEFAULT_EVENT_MESSAGE", "", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: AndroidSpanLogsHandler.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
