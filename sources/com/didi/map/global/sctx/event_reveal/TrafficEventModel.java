package com.didi.map.global.sctx.event_reveal;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0005\b\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000b\u001a\u00020\u0007\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003¢\u0006\u0002\u0010\rJ\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\tHÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0007HÆ\u0003J\t\u0010\u001f\u001a\u00020\u0003HÆ\u0003JQ\u0010 \u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u00072\b\b\u0002\u0010\f\u001a\u00020\u0003HÆ\u0001J\u0013\u0010!\u001a\u00020\"2\b\u0010#\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010$\u001a\u00020\u0007HÖ\u0001J\u0006\u0010%\u001a\u00020\"J\t\u0010&\u001a\u00020\u0005HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u000fR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u000f¨\u0006'"}, mo148868d2 = {"Lcom/didi/map/global/sctx/event_reveal/TrafficEventModel;", "", "eventId", "", "eventTitle", "", "eventType", "", "eventPoint", "Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "linkId", "eventOper", "reportTime", "(JLjava/lang/String;ILcom/didi/map/sdk/proto/driver_gl/DoublePoint;JIJ)V", "getEventId", "()J", "getEventOper", "()I", "getEventPoint", "()Lcom/didi/map/sdk/proto/driver_gl/DoublePoint;", "getEventTitle", "()Ljava/lang/String;", "getEventType", "getLinkId", "getReportTime", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "isValid", "toString", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: TriggeredTrafficEventShowModel.kt */
public final class TrafficEventModel {

    /* renamed from: a */
    private final long f30039a;

    /* renamed from: b */
    private final String f30040b;

    /* renamed from: c */
    private final int f30041c;

    /* renamed from: d */
    private final DoublePoint f30042d;

    /* renamed from: e */
    private final long f30043e;

    /* renamed from: f */
    private final int f30044f;

    /* renamed from: g */
    private final long f30045g;

    public TrafficEventModel() {
        this(0, (String) null, 0, (DoublePoint) null, 0, 0, 0, 127, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ TrafficEventModel copy$default(TrafficEventModel trafficEventModel, long j, String str, int i, DoublePoint doublePoint, long j2, int i2, long j3, int i3, Object obj) {
        TrafficEventModel trafficEventModel2 = trafficEventModel;
        return trafficEventModel.copy((i3 & 1) != 0 ? trafficEventModel2.f30039a : j, (i3 & 2) != 0 ? trafficEventModel2.f30040b : str, (i3 & 4) != 0 ? trafficEventModel2.f30041c : i, (i3 & 8) != 0 ? trafficEventModel2.f30042d : doublePoint, (i3 & 16) != 0 ? trafficEventModel2.f30043e : j2, (i3 & 32) != 0 ? trafficEventModel2.f30044f : i2, (i3 & 64) != 0 ? trafficEventModel2.f30045g : j3);
    }

    public final long component1() {
        return this.f30039a;
    }

    public final String component2() {
        return this.f30040b;
    }

    public final int component3() {
        return this.f30041c;
    }

    public final DoublePoint component4() {
        return this.f30042d;
    }

    public final long component5() {
        return this.f30043e;
    }

    public final int component6() {
        return this.f30044f;
    }

    public final long component7() {
        return this.f30045g;
    }

    public final TrafficEventModel copy(long j, String str, int i, DoublePoint doublePoint, long j2, int i2, long j3) {
        Intrinsics.checkNotNullParameter(str, "eventTitle");
        return new TrafficEventModel(j, str, i, doublePoint, j2, i2, j3);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof TrafficEventModel)) {
            return false;
        }
        TrafficEventModel trafficEventModel = (TrafficEventModel) obj;
        return this.f30039a == trafficEventModel.f30039a && Intrinsics.areEqual((Object) this.f30040b, (Object) trafficEventModel.f30040b) && this.f30041c == trafficEventModel.f30041c && Intrinsics.areEqual((Object) this.f30042d, (Object) trafficEventModel.f30042d) && this.f30043e == trafficEventModel.f30043e && this.f30044f == trafficEventModel.f30044f && this.f30045g == trafficEventModel.f30045g;
    }

    public int hashCode() {
        int hashCode = ((((C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f30039a) * 31) + this.f30040b.hashCode()) * 31) + this.f30041c) * 31;
        DoublePoint doublePoint = this.f30042d;
        return ((((((hashCode + (doublePoint == null ? 0 : doublePoint.hashCode())) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f30043e)) * 31) + this.f30044f) * 31) + C$r8$backportedMethods$utility$Long$1$hashCode.hashCode(this.f30045g);
    }

    public String toString() {
        return "TrafficEventModel(eventId=" + this.f30039a + ", eventTitle=" + this.f30040b + ", eventType=" + this.f30041c + ", eventPoint=" + this.f30042d + ", linkId=" + this.f30043e + ", eventOper=" + this.f30044f + ", reportTime=" + this.f30045g + VersionRange.RIGHT_OPEN;
    }

    public TrafficEventModel(long j, String str, int i, DoublePoint doublePoint, long j2, int i2, long j3) {
        Intrinsics.checkNotNullParameter(str, "eventTitle");
        this.f30039a = j;
        this.f30040b = str;
        this.f30041c = i;
        this.f30042d = doublePoint;
        this.f30043e = j2;
        this.f30044f = i2;
        this.f30045g = j3;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ TrafficEventModel(long r12, java.lang.String r14, int r15, com.didi.map.sdk.proto.driver_gl.DoublePoint r16, long r17, int r19, long r20, int r22, kotlin.jvm.internal.DefaultConstructorMarker r23) {
        /*
            r11 = this;
            r0 = r22 & 1
            r1 = 0
            if (r0 == 0) goto L_0x0008
            r3 = r1
            goto L_0x0009
        L_0x0008:
            r3 = r12
        L_0x0009:
            r0 = r22 & 2
            if (r0 == 0) goto L_0x0010
            java.lang.String r0 = ""
            goto L_0x0011
        L_0x0010:
            r0 = r14
        L_0x0011:
            r5 = r22 & 4
            r6 = 0
            if (r5 == 0) goto L_0x0018
            r5 = 0
            goto L_0x0019
        L_0x0018:
            r5 = r15
        L_0x0019:
            r7 = r22 & 8
            if (r7 == 0) goto L_0x001f
            r7 = 0
            goto L_0x0021
        L_0x001f:
            r7 = r16
        L_0x0021:
            r8 = r22 & 16
            if (r8 == 0) goto L_0x0027
            r8 = r1
            goto L_0x0029
        L_0x0027:
            r8 = r17
        L_0x0029:
            r10 = r22 & 32
            if (r10 == 0) goto L_0x002e
            goto L_0x0030
        L_0x002e:
            r6 = r19
        L_0x0030:
            r10 = r22 & 64
            if (r10 == 0) goto L_0x0035
            goto L_0x0037
        L_0x0035:
            r1 = r20
        L_0x0037:
            r12 = r11
            r13 = r3
            r15 = r0
            r16 = r5
            r17 = r7
            r18 = r8
            r20 = r6
            r21 = r1
            r12.<init>(r13, r15, r16, r17, r18, r20, r21)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.TrafficEventModel.<init>(long, java.lang.String, int, com.didi.map.sdk.proto.driver_gl.DoublePoint, long, int, long, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final long getEventId() {
        return this.f30039a;
    }

    public final String getEventTitle() {
        return this.f30040b;
    }

    public final int getEventType() {
        return this.f30041c;
    }

    public final DoublePoint getEventPoint() {
        return this.f30042d;
    }

    public final long getLinkId() {
        return this.f30043e;
    }

    public final int getEventOper() {
        return this.f30044f;
    }

    public final long getReportTime() {
        return this.f30045g;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x0010, code lost:
        r0 = r0.dlat;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final boolean isValid() {
        /*
            r5 = this;
            long r0 = r5.f30039a
            r2 = 0
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 <= 0) goto L_0x002f
            com.didi.map.sdk.proto.driver_gl.DoublePoint r0 = r5.f30042d
            r1 = 0
            if (r0 != 0) goto L_0x0010
        L_0x000e:
            r3 = r1
            goto L_0x0019
        L_0x0010:
            java.lang.Double r0 = r0.dlat
            if (r0 != 0) goto L_0x0015
            goto L_0x000e
        L_0x0015:
            double r3 = r0.doubleValue()
        L_0x0019:
            com.didi.map.sdk.proto.driver_gl.DoublePoint r0 = r5.f30042d
            if (r0 != 0) goto L_0x001e
            goto L_0x0027
        L_0x001e:
            java.lang.Double r0 = r0.dlng
            if (r0 != 0) goto L_0x0023
            goto L_0x0027
        L_0x0023:
            double r1 = r0.doubleValue()
        L_0x0027:
            boolean r0 = com.didi.common.map.util.LatLngUtils.locateCorrect(r3, r1)
            if (r0 == 0) goto L_0x002f
            r0 = 1
            goto L_0x0030
        L_0x002f:
            r0 = 0
        L_0x0030:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.sctx.event_reveal.TrafficEventModel.isValid():boolean");
    }
}
