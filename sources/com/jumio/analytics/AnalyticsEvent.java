package com.jumio.analytics;

import java.io.Serializable;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0016\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010%\u001a\u00020$¢\u0006\u0004\b&\u0010'B#\b\u0016\u0012\u0006\u0010#\u001a\u00020\u0004\u0012\u0006\u0010(\u001a\u00020\u0002\u0012\b\u0010)\u001a\u0004\u0018\u00010$¢\u0006\u0004\b&\u0010*J\b\u0010\u0003\u001a\u00020\u0002H\u0016J\b\u0010\u0005\u001a\u00020\u0004H\u0016J\u0013\u0010\t\u001a\u00020\b2\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006H\u0002R\u0019\u0010\u000f\u001a\u00020\n8\u0006@\u0006¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u0019\u0010\u0014\u001a\u00020\u00048\u0006@\u0006¢\u0006\f\n\u0004\b\u0010\u0010\u0011\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u001a\u001a\u0006\u0012\u0002\b\u00030\u00158\u0006@\u0006¢\u0006\f\n\u0004\b\u0016\u0010\u0017\u001a\u0004\b\u0018\u0010\u0019R$\u0010\"\u001a\u0004\u0018\u00010\u001b8\u0006@\u0006X\u000e¢\u0006\u0012\n\u0004\b\u001c\u0010\u001d\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!¨\u0006+"}, mo148868d2 = {"Lcom/jumio/analytics/AnalyticsEvent;", "Ljava/io/Serializable;", "", "toString", "", "hashCode", "", "other", "", "equals", "", "a", "J", "getTimestamp", "()J", "timestamp", "b", "I", "getEventType", "()I", "eventType", "Lcom/jumio/analytics/b;", "c", "Lcom/jumio/analytics/b;", "getPayload", "()Lcom/jumio/analytics/b;", "payload", "Ljava/util/UUID;", "d", "Ljava/util/UUID;", "getSessionId", "()Ljava/util/UUID;", "setSessionId", "(Ljava/util/UUID;)V", "sessionId", "type", "Lcom/jumio/analytics/MetaInfo;", "valueAsMap", "<init>", "(ILcom/jumio/analytics/MetaInfo;)V", "payloadValue", "payloadMetaInfo", "(ILjava/lang/String;Lcom/jumio/analytics/MetaInfo;)V", "jumio-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1})
/* compiled from: AnalyticsEvent.kt */
public final class AnalyticsEvent implements Serializable {

    /* renamed from: a */
    public final long f57368a = System.currentTimeMillis();

    /* renamed from: b */
    public final int f57369b;

    /* renamed from: c */
    public final C20922b<?> f57370c;

    /* renamed from: d */
    public UUID f57371d;

    public AnalyticsEvent(int i, MetaInfo metaInfo) {
        Intrinsics.checkNotNullParameter(metaInfo, "valueAsMap");
        this.f57369b = i;
        this.f57370c = new C20922b<>(metaInfo, (MetaInfo) null);
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof AnalyticsEvent)) {
            return false;
        }
        AnalyticsEvent analyticsEvent = (AnalyticsEvent) obj;
        if (analyticsEvent.f57368a == this.f57368a && Intrinsics.areEqual((Object) analyticsEvent.f57371d, (Object) this.f57371d) && analyticsEvent.f57369b == this.f57369b) {
            return true;
        }
        return false;
    }

    public final int getEventType() {
        return this.f57369b;
    }

    public final C20922b<?> getPayload() {
        return this.f57370c;
    }

    public final UUID getSessionId() {
        return this.f57371d;
    }

    public final long getTimestamp() {
        return this.f57368a;
    }

    public int hashCode() {
        long j = this.f57368a;
        int i = (((int) (j ^ (j >>> 32))) + 31) * 31;
        UUID uuid = this.f57371d;
        return ((i + ((uuid == null || uuid == null) ? 0 : uuid.hashCode())) * 31) + this.f57369b;
    }

    public final void setSessionId(UUID uuid) {
        this.f57371d = uuid;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("AnalyticsEvent ");
        sb.append(this.f57369b);
        sb.append(" | ");
        sb.append(this.f57368a);
        sb.append(" // ");
        sb.append(this.f57370c.mo171748b());
        sb.append(this.f57370c.mo171747a() != null ? Intrinsics.stringPlus(" | ", this.f57370c.mo171747a()) : "");
        return sb.toString();
    }

    public AnalyticsEvent(int i, String str, MetaInfo metaInfo) {
        Intrinsics.checkNotNullParameter(str, "payloadValue");
        this.f57369b = i;
        this.f57370c = new C20922b<>(str, metaInfo);
    }
}
