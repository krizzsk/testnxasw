package com.didi.map.global.sctx.widget;

import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.global.component.line.component.traffic.ITrafficLine;
import com.didi.map.global.component.line.component.traffic.TrafficData;
import com.didi.map.sdk.proto.driver_gl.TrafficItem;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

@Metadata(mo148867d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\u001a\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u0018\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013J\u000e\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017J\u0006\u0010\u0018\u001a\u00020\bJ\u0010\u0010\u0019\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006J\u0014\u0010\u001a\u001a\u00020\b2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001c0\u0013R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/map/global/sctx/widget/CompLineDelegateN;", "", "()V", "compTrafficLine", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "trafficOptions", "Lcom/didi/map/global/sctx/widget/TrafficOptions;", "addToMap", "", "map", "Lcom/didi/common/map/Map;", "animatorOptions", "Lcom/didi/map/global/sctx/widget/TrafficLineAnimatorOptions;", "erase", "segmentIndex", "", "car", "Lcom/didi/common/map/model/LatLng;", "getLines", "", "Lcom/didi/common/map/model/Line;", "highLight", "show", "", "remove", "setTrafficOptions", "updateTraffic", "sTrafficData", "Lcom/didi/map/sdk/proto/driver_gl/TrafficItem;", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CompLineDelegateN.kt */
public final class CompLineDelegateN {

    /* renamed from: a */
    private TrafficOptions f30157a;

    /* renamed from: b */
    private ICompLineContract f30158b;

    public final void setTrafficOptions(TrafficOptions trafficOptions) {
        this.f30157a = trafficOptions;
    }

    public final void addToMap(Map map) {
        addToMap(map, (TrafficLineAnimatorOptions) null);
    }

    public final void addToMap(Map map, TrafficLineAnimatorOptions trafficLineAnimatorOptions) {
        TrafficOptions trafficOptions;
        Long l;
        if (map != null && (trafficOptions = this.f30157a) != null) {
            LineExParam lineExParam = new LineExParam();
            List list = null;
            if (trafficLineAnimatorOptions == null) {
                l = null;
            } else {
                l = Long.valueOf(trafficLineAnimatorOptions.duration);
            }
            boolean z = false;
            lineExParam.setLineExtensionAnimDuration(l == null ? 0 : (int) l.longValue());
            lineExParam.setHasLineExtensionAnim(trafficLineAnimatorOptions != null && trafficLineAnimatorOptions.duration > 0);
            lineExParam.setLineMinorColor(trafficOptions.lineMinorColor);
            List<TrafficData> list2 = trafficOptions.trafficDatas;
            if (list2 != null) {
                Iterable<TrafficData> iterable = list2;
                Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(iterable, 10));
                for (TrafficData trafficData : iterable) {
                    TrafficData trafficData2 = new TrafficData();
                    trafficData2.color = trafficData.color;
                    trafficData2.fromIndex = trafficData.fromIndex;
                    trafficData2.toIndex = trafficData.toIndex;
                    trafficData2.minorColor = trafficData.minorColor;
                    arrayList.add(trafficData2);
                }
                list = (List) arrayList;
            }
            LineParams lineParams = new LineParams(list, trafficOptions.points, trafficOptions.lineColor, DisplayUtils.px2dp(map.getContext(), (float) trafficOptions.lineWidth));
            lineParams.setClickable(trafficOptions.clickable);
            if (trafficOptions.drawLineType == 2) {
                z = true;
            }
            lineParams.setEnableEarthWormLine(z);
            lineParams.setExParam(lineExParam);
            lineParams.setDidiColor(1);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_TRAFFIC, map, map.getContext(), lineParams);
            this.f30158b = createLineComponent;
            if (createLineComponent != null) {
                createLineComponent.setListener(new CompLineDelegateN$addToMap$1(trafficLineAnimatorOptions));
            }
            ICompLineContract iCompLineContract = this.f30158b;
            if (iCompLineContract != null) {
                iCompLineContract.start();
            }
        }
    }

    public final void remove() {
        ICompLineContract iCompLineContract = this.f30158b;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
    }

    public final void erase(int i, LatLng latLng) {
        if (latLng != null) {
            ICompLineContract iCompLineContract = this.f30158b;
            ITrafficLine iTrafficLine = iCompLineContract instanceof ITrafficLine ? (ITrafficLine) iCompLineContract : null;
            if (iTrafficLine != null) {
                iTrafficLine.erase(i, latLng);
            }
        }
    }

    public final List<Line> getLines() {
        ICompLineContract iCompLineContract = this.f30158b;
        List<Line> list = null;
        ITrafficLine iTrafficLine = iCompLineContract instanceof ITrafficLine ? (ITrafficLine) iCompLineContract : null;
        if (iTrafficLine != null) {
            list = iTrafficLine.getLines();
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public final void highLight(boolean z) {
        ICompLineContract iCompLineContract = this.f30158b;
        ITrafficLine iTrafficLine = iCompLineContract instanceof ITrafficLine ? (ITrafficLine) iCompLineContract : null;
        if (iTrafficLine != null) {
            iTrafficLine.highLight(z);
        }
    }

    public final void updateTraffic(List<TrafficItem> list) {
        Intrinsics.checkNotNullParameter(list, "sTrafficData");
        List arrayList = new ArrayList();
        for (TrafficItem next : list) {
            TrafficData trafficData = new TrafficData();
            Integer num = next.startIndex;
            Intrinsics.checkNotNullExpressionValue(num, "item.startIndex");
            trafficData.fromIndex = num.intValue();
            Integer num2 = next.endIndex;
            Intrinsics.checkNotNullExpressionValue(num2, "item.endIndex");
            trafficData.toIndex = num2.intValue();
            if (next.status != null) {
                Integer num3 = next.status;
                Intrinsics.checkNotNullExpressionValue(num3, "item.status");
                if (num3.intValue() >= 0) {
                    StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
                    Integer num4 = next.status;
                    Intrinsics.checkNotNullExpressionValue(num4, "item.status");
                    String format = String.format("#%06X", Arrays.copyOf(new Object[]{Integer.valueOf(num4.intValue() & 16777215)}, 1));
                    Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
                    trafficData.color = Color.parseColor(format);
                    arrayList.add(trafficData);
                }
            }
            trafficData.color = -1;
            arrayList.add(trafficData);
        }
        ICompLineContract iCompLineContract = this.f30158b;
        ITrafficLine iTrafficLine = iCompLineContract instanceof ITrafficLine ? (ITrafficLine) iCompLineContract : null;
        if (iTrafficLine != null) {
            iTrafficLine.updateTraffic(arrayList);
        }
    }
}
