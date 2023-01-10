package com.datadog.android.tracing.internal.domain.event;

import com.datadog.android.core.internal.CoreFeature;
import com.datadog.android.core.internal.Mapper;
import com.datadog.android.core.internal.net.info.NetworkInfoProvider;
import com.datadog.android.core.internal.time.TimeProvider;
import com.datadog.android.core.internal.utils.BigIntegerExtKt;
import com.datadog.android.core.model.NetworkInfo;
import com.datadog.android.core.model.UserInfo;
import com.datadog.android.log.internal.user.UserInfoProvider;
import com.datadog.android.tracing.model.SpanEvent;
import com.datadog.opentracing.DDSpan;
import java.math.BigInteger;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0000\u0018\u00002\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001B\u001d\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0010\u0010\u000b\u001a\u00020\u00032\u0006\u0010\f\u001a\u00020\u0002H\u0016J\u0010\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u000f\u001a\u00020\u0002H\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, mo148868d2 = {"Lcom/datadog/android/tracing/internal/domain/event/DdSpanToSpanEventMapper;", "Lcom/datadog/android/core/internal/Mapper;", "Lcom/datadog/opentracing/DDSpan;", "Lcom/datadog/android/tracing/model/SpanEvent;", "timeProvider", "Lcom/datadog/android/core/internal/time/TimeProvider;", "networkInfoProvider", "Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;", "userInfoProvider", "Lcom/datadog/android/log/internal/user/UserInfoProvider;", "(Lcom/datadog/android/core/internal/time/TimeProvider;Lcom/datadog/android/core/internal/net/info/NetworkInfoProvider;Lcom/datadog/android/log/internal/user/UserInfoProvider;)V", "map", "model", "resolveMeta", "Lcom/datadog/android/tracing/model/SpanEvent$Meta;", "event", "resolveMetrics", "Lcom/datadog/android/tracing/model/SpanEvent$Metrics;", "resolveSimCarrier", "Lcom/datadog/android/tracing/model/SpanEvent$SimCarrier;", "networkInfo", "Lcom/datadog/android/core/model/NetworkInfo;", "dd-sdk-android_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DdSpanToSpanEventMapper.kt */
public final class DdSpanToSpanEventMapper implements Mapper<DDSpan, SpanEvent> {

    /* renamed from: a */
    private final TimeProvider f4052a;

    /* renamed from: b */
    private final NetworkInfoProvider f4053b;

    /* renamed from: c */
    private final UserInfoProvider f4054c;

    public DdSpanToSpanEventMapper(TimeProvider timeProvider, NetworkInfoProvider networkInfoProvider, UserInfoProvider userInfoProvider) {
        Intrinsics.checkNotNullParameter(timeProvider, "timeProvider");
        Intrinsics.checkNotNullParameter(networkInfoProvider, "networkInfoProvider");
        Intrinsics.checkNotNullParameter(userInfoProvider, "userInfoProvider");
        this.f4052a = timeProvider;
        this.f4053b = networkInfoProvider;
        this.f4054c = userInfoProvider;
    }

    public SpanEvent map(DDSpan dDSpan) {
        Intrinsics.checkNotNullParameter(dDSpan, "model");
        long serverOffsetNanos = this.f4052a.getServerOffsetNanos();
        SpanEvent.Metrics a = m2543a(dDSpan);
        SpanEvent.Meta b = m2545b(dDSpan);
        BigInteger traceId = dDSpan.getTraceId();
        Intrinsics.checkNotNullExpressionValue(traceId, "model.traceId");
        String hexString = BigIntegerExtKt.toHexString(traceId);
        BigInteger spanId = dDSpan.getSpanId();
        Intrinsics.checkNotNullExpressionValue(spanId, "model.spanId");
        String hexString2 = BigIntegerExtKt.toHexString(spanId);
        BigInteger parentId = dDSpan.getParentId();
        Intrinsics.checkNotNullExpressionValue(parentId, "model.parentId");
        String hexString3 = BigIntegerExtKt.toHexString(parentId);
        String resourceName = dDSpan.getResourceName();
        String operationName = dDSpan.getOperationName();
        String serviceName = dDSpan.getServiceName();
        long durationNano = dDSpan.getDurationNano();
        long startTime = dDSpan.getStartTime() + serverOffsetNanos;
        Boolean isError = dDSpan.isError();
        Intrinsics.checkNotNullExpressionValue(isError, "model.isError");
        long j = isError.booleanValue() ? 1 : 0;
        Intrinsics.checkNotNullExpressionValue(resourceName, "resourceName");
        Intrinsics.checkNotNullExpressionValue(operationName, "operationName");
        Intrinsics.checkNotNullExpressionValue(serviceName, "serviceName");
        return new SpanEvent(hexString, hexString2, hexString3, resourceName, operationName, serviceName, durationNano, startTime, j, a, b);
    }

    /* renamed from: a */
    private final SpanEvent.Metrics m2543a(DDSpan dDSpan) {
        long j = dDSpan.getParentId().longValue() == 0 ? 1L : null;
        Map<String, Number> metrics = dDSpan.getMetrics();
        Intrinsics.checkNotNullExpressionValue(metrics, "event.metrics");
        return new SpanEvent.Metrics(j, metrics);
    }

    /* renamed from: b */
    private final SpanEvent.Meta m2545b(DDSpan dDSpan) {
        NetworkInfo latestNetworkInfo = this.f4053b.getLatestNetworkInfo();
        SpanEvent.SimCarrier a = m2544a(latestNetworkInfo);
        Long strength = latestNetworkInfo.getStrength();
        String l = strength == null ? null : strength.toString();
        Long downKbps = latestNetworkInfo.getDownKbps();
        String l2 = downKbps == null ? null : downKbps.toString();
        Long upKbps = latestNetworkInfo.getUpKbps();
        SpanEvent.Network network = new SpanEvent.Network(new SpanEvent.Client(a, l, l2, upKbps == null ? null : upKbps.toString(), latestNetworkInfo.getConnectivity().toString()));
        UserInfo userInfo = this.f4054c.getUserInfo();
        SpanEvent.Usr usr = new SpanEvent.Usr(userInfo.getId(), userInfo.getName(), userInfo.getEmail(), userInfo.getAdditionalProperties());
        String packageVersion$dd_sdk_android_release = CoreFeature.INSTANCE.getPackageVersion$dd_sdk_android_release();
        SpanEvent.C2212Dd dd = new SpanEvent.C2212Dd((String) null, 1, (DefaultConstructorMarker) null);
        SpanEvent.Span span = new SpanEvent.Span();
        SpanEvent.Tracer tracer = new SpanEvent.Tracer(CoreFeature.INSTANCE.getSdkVersion$dd_sdk_android_release());
        Map<String, String> meta = dDSpan.getMeta();
        Intrinsics.checkNotNullExpressionValue(meta, "event.meta");
        return new SpanEvent.Meta(packageVersion$dd_sdk_android_release, dd, span, tracer, usr, network, meta);
    }

    /* renamed from: a */
    private final SpanEvent.SimCarrier m2544a(NetworkInfo networkInfo) {
        String str = null;
        if (networkInfo.getCarrierId() == null && networkInfo.getCarrierName() == null) {
            return null;
        }
        Long carrierId = networkInfo.getCarrierId();
        if (carrierId != null) {
            str = carrierId.toString();
        }
        return new SpanEvent.SimCarrier(str, networkInfo.getCarrierName());
    }
}
