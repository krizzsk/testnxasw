package com.didi.map.global.flow.scene.order.bluetooth_meet.model;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\b\u0018\u00002\u00020\u0001BA\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\b\b\u0002\u0010\b\u001a\u00020\u0003¢\u0006\u0002\u0010\tJ\t\u0010\u0011\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0013\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0014\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003JE\u0010\u0017\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0018\u001a\u00020\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u001b\u001a\u00020\u001cHÖ\u0001J\t\u0010\u001d\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000bR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000bR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000b¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/bluetooth_meet/model/SctxBTMDriverParam;", "", "carNumber", "", "carManufacture", "driverAvatar", "carColor", "carAvatar", "driverName", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getCarAvatar", "()Ljava/lang/String;", "getCarColor", "getCarManufacture", "getCarNumber", "getDriverAvatar", "getDriverName", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SctxBTMDriverParam.kt */
public final class SctxBTMDriverParam {

    /* renamed from: a */
    private final String f29022a;

    /* renamed from: b */
    private final String f29023b;

    /* renamed from: c */
    private final String f29024c;

    /* renamed from: d */
    private final String f29025d;

    /* renamed from: e */
    private final String f29026e;

    /* renamed from: f */
    private final String f29027f;

    public SctxBTMDriverParam() {
        this((String) null, (String) null, (String) null, (String) null, (String) null, (String) null, 63, (DefaultConstructorMarker) null);
    }

    public static /* synthetic */ SctxBTMDriverParam copy$default(SctxBTMDriverParam sctxBTMDriverParam, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sctxBTMDriverParam.f29022a;
        }
        if ((i & 2) != 0) {
            str2 = sctxBTMDriverParam.f29023b;
        }
        String str7 = str2;
        if ((i & 4) != 0) {
            str3 = sctxBTMDriverParam.f29024c;
        }
        String str8 = str3;
        if ((i & 8) != 0) {
            str4 = sctxBTMDriverParam.f29025d;
        }
        String str9 = str4;
        if ((i & 16) != 0) {
            str5 = sctxBTMDriverParam.f29026e;
        }
        String str10 = str5;
        if ((i & 32) != 0) {
            str6 = sctxBTMDriverParam.f29027f;
        }
        return sctxBTMDriverParam.copy(str, str7, str8, str9, str10, str6);
    }

    public final String component1() {
        return this.f29022a;
    }

    public final String component2() {
        return this.f29023b;
    }

    public final String component3() {
        return this.f29024c;
    }

    public final String component4() {
        return this.f29025d;
    }

    public final String component5() {
        return this.f29026e;
    }

    public final String component6() {
        return this.f29027f;
    }

    public final SctxBTMDriverParam copy(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "carNumber");
        Intrinsics.checkNotNullParameter(str2, "carManufacture");
        Intrinsics.checkNotNullParameter(str3, "driverAvatar");
        Intrinsics.checkNotNullParameter(str4, "carColor");
        Intrinsics.checkNotNullParameter(str5, "carAvatar");
        Intrinsics.checkNotNullParameter(str6, "driverName");
        return new SctxBTMDriverParam(str, str2, str3, str4, str5, str6);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SctxBTMDriverParam)) {
            return false;
        }
        SctxBTMDriverParam sctxBTMDriverParam = (SctxBTMDriverParam) obj;
        return Intrinsics.areEqual((Object) this.f29022a, (Object) sctxBTMDriverParam.f29022a) && Intrinsics.areEqual((Object) this.f29023b, (Object) sctxBTMDriverParam.f29023b) && Intrinsics.areEqual((Object) this.f29024c, (Object) sctxBTMDriverParam.f29024c) && Intrinsics.areEqual((Object) this.f29025d, (Object) sctxBTMDriverParam.f29025d) && Intrinsics.areEqual((Object) this.f29026e, (Object) sctxBTMDriverParam.f29026e) && Intrinsics.areEqual((Object) this.f29027f, (Object) sctxBTMDriverParam.f29027f);
    }

    public int hashCode() {
        return (((((((((this.f29022a.hashCode() * 31) + this.f29023b.hashCode()) * 31) + this.f29024c.hashCode()) * 31) + this.f29025d.hashCode()) * 31) + this.f29026e.hashCode()) * 31) + this.f29027f.hashCode();
    }

    public String toString() {
        return "SctxBTMDriverParam(carNumber=" + this.f29022a + ", carManufacture=" + this.f29023b + ", driverAvatar=" + this.f29024c + ", carColor=" + this.f29025d + ", carAvatar=" + this.f29026e + ", driverName=" + this.f29027f + VersionRange.RIGHT_OPEN;
    }

    public SctxBTMDriverParam(String str, String str2, String str3, String str4, String str5, String str6) {
        Intrinsics.checkNotNullParameter(str, "carNumber");
        Intrinsics.checkNotNullParameter(str2, "carManufacture");
        Intrinsics.checkNotNullParameter(str3, "driverAvatar");
        Intrinsics.checkNotNullParameter(str4, "carColor");
        Intrinsics.checkNotNullParameter(str5, "carAvatar");
        Intrinsics.checkNotNullParameter(str6, "driverName");
        this.f29022a = str;
        this.f29023b = str2;
        this.f29024c = str3;
        this.f29025d = str4;
        this.f29026e = str5;
        this.f29027f = str6;
    }

    /* JADX WARNING: Illegal instructions before constructor call */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public /* synthetic */ SctxBTMDriverParam(java.lang.String r6, java.lang.String r7, java.lang.String r8, java.lang.String r9, java.lang.String r10, java.lang.String r11, int r12, kotlin.jvm.internal.DefaultConstructorMarker r13) {
        /*
            r5 = this;
            r13 = r12 & 1
            java.lang.String r0 = ""
            if (r13 == 0) goto L_0x0008
            r13 = r0
            goto L_0x0009
        L_0x0008:
            r13 = r6
        L_0x0009:
            r6 = r12 & 2
            if (r6 == 0) goto L_0x000f
            r1 = r0
            goto L_0x0010
        L_0x000f:
            r1 = r7
        L_0x0010:
            r6 = r12 & 4
            if (r6 == 0) goto L_0x0016
            r2 = r0
            goto L_0x0017
        L_0x0016:
            r2 = r8
        L_0x0017:
            r6 = r12 & 8
            if (r6 == 0) goto L_0x001d
            r3 = r0
            goto L_0x001e
        L_0x001d:
            r3 = r9
        L_0x001e:
            r6 = r12 & 16
            if (r6 == 0) goto L_0x0024
            r4 = r0
            goto L_0x0025
        L_0x0024:
            r4 = r10
        L_0x0025:
            r6 = r12 & 32
            if (r6 == 0) goto L_0x002b
            r12 = r0
            goto L_0x002c
        L_0x002b:
            r12 = r11
        L_0x002c:
            r6 = r5
            r7 = r13
            r8 = r1
            r9 = r2
            r10 = r3
            r11 = r4
            r6.<init>(r7, r8, r9, r10, r11, r12)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.bluetooth_meet.model.SctxBTMDriverParam.<init>(java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, java.lang.String, int, kotlin.jvm.internal.DefaultConstructorMarker):void");
    }

    public final String getCarNumber() {
        return this.f29022a;
    }

    public final String getCarManufacture() {
        return this.f29023b;
    }

    public final String getDriverAvatar() {
        return this.f29024c;
    }

    public final String getCarColor() {
        return this.f29025d;
    }

    public final String getCarAvatar() {
        return this.f29026e;
    }

    public final String getDriverName() {
        return this.f29027f;
    }
}
