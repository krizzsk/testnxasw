package com.didi.map.utils;

import com.didi.common.map.model.LatLng;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.osgi.framework.VersionRange;

@Metadata(mo148867d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\b\b\u0018\u00002\u00020\u0001B%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0003¢\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0010\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0005HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003J1\u0010\u0013\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u0003HÆ\u0001J\u0013\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0006\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\n¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/map/utils/SegmentInfo;", "", "index", "", "point_s", "Lcom/didi/common/map/model/LatLng;", "point_e", "segDis", "(ILcom/didi/common/map/model/LatLng;Lcom/didi/common/map/model/LatLng;I)V", "getIndex", "()I", "getPoint_e", "()Lcom/didi/common/map/model/LatLng;", "getPoint_s", "getSegDis", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "toString", "", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: MatchPointDisHandler.kt */
public final class SegmentInfo {

    /* renamed from: a */
    private final int f31486a;

    /* renamed from: b */
    private final LatLng f31487b;

    /* renamed from: c */
    private final LatLng f31488c;

    /* renamed from: d */
    private final int f31489d;

    public static /* synthetic */ SegmentInfo copy$default(SegmentInfo segmentInfo, int i, LatLng latLng, LatLng latLng2, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = segmentInfo.f31486a;
        }
        if ((i3 & 2) != 0) {
            latLng = segmentInfo.f31487b;
        }
        if ((i3 & 4) != 0) {
            latLng2 = segmentInfo.f31488c;
        }
        if ((i3 & 8) != 0) {
            i2 = segmentInfo.f31489d;
        }
        return segmentInfo.copy(i, latLng, latLng2, i2);
    }

    public final int component1() {
        return this.f31486a;
    }

    public final LatLng component2() {
        return this.f31487b;
    }

    public final LatLng component3() {
        return this.f31488c;
    }

    public final int component4() {
        return this.f31489d;
    }

    public final SegmentInfo copy(int i, LatLng latLng, LatLng latLng2, int i2) {
        Intrinsics.checkNotNullParameter(latLng, "point_s");
        Intrinsics.checkNotNullParameter(latLng2, "point_e");
        return new SegmentInfo(i, latLng, latLng2, i2);
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof SegmentInfo)) {
            return false;
        }
        SegmentInfo segmentInfo = (SegmentInfo) obj;
        return this.f31486a == segmentInfo.f31486a && Intrinsics.areEqual((Object) this.f31487b, (Object) segmentInfo.f31487b) && Intrinsics.areEqual((Object) this.f31488c, (Object) segmentInfo.f31488c) && this.f31489d == segmentInfo.f31489d;
    }

    public int hashCode() {
        return (((((this.f31486a * 31) + this.f31487b.hashCode()) * 31) + this.f31488c.hashCode()) * 31) + this.f31489d;
    }

    public String toString() {
        return "SegmentInfo(index=" + this.f31486a + ", point_s=" + this.f31487b + ", point_e=" + this.f31488c + ", segDis=" + this.f31489d + VersionRange.RIGHT_OPEN;
    }

    public SegmentInfo(int i, LatLng latLng, LatLng latLng2, int i2) {
        Intrinsics.checkNotNullParameter(latLng, "point_s");
        Intrinsics.checkNotNullParameter(latLng2, "point_e");
        this.f31486a = i;
        this.f31487b = latLng;
        this.f31488c = latLng2;
        this.f31489d = i2;
    }

    public final int getIndex() {
        return this.f31486a;
    }

    public final LatLng getPoint_e() {
        return this.f31488c;
    }

    public final LatLng getPoint_s() {
        return this.f31487b;
    }

    public final int getSegDis() {
        return this.f31489d;
    }
}
