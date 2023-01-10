package com.didi.map.global.flow.scene.order.confirm.component;

import com.didi.common.map.model.LatLng;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B+\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bR\u0011\u0010\t\u001a\u00020\n¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\fR\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/component/LineParam;", "", "lineId", "", "points", "", "Lcom/didi/common/map/model/LatLng;", "lineBubbleContent", "", "isSelect", "", "(JLjava/util/List;Ljava/lang/String;Z)V", "()Z", "getLineBubbleContent", "()Ljava/lang/String;", "getLineId", "()J", "getPoints", "()Ljava/util/List;", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: LineParam.kt */
public final class LineParam {

    /* renamed from: a */
    private final long f29102a;

    /* renamed from: b */
    private final List<LatLng> f29103b;

    /* renamed from: c */
    private final String f29104c;

    /* renamed from: d */
    private final boolean f29105d;

    public LineParam(long j, List<LatLng> list, String str, boolean z) {
        Intrinsics.checkNotNullParameter(list, "points");
        Intrinsics.checkNotNullParameter(str, "lineBubbleContent");
        this.f29102a = j;
        this.f29103b = list;
        this.f29104c = str;
        this.f29105d = z;
    }

    public final long getLineId() {
        return this.f29102a;
    }

    public final List<LatLng> getPoints() {
        return this.f29103b;
    }

    public final String getLineBubbleContent() {
        return this.f29104c;
    }

    public final boolean isSelect() {
        return this.f29105d;
    }
}
