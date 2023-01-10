package com.didi.map.global.sctx.widget;

import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Line;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.map.sdk.nav.traffic.ITrafficLine;
import com.didi.map.sdk.nav.traffic.TrafficData;
import com.didi.map.sdk.nav.traffic.TrafficOptions;
import com.didi.map.sdk.nav.traffic.model.TrafficLineAnimatorOptions;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;

@Metadata(mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\u001c\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0016J\u001a\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u000e\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013H\u0016J\u0010\u0010\u0015\u001a\u00020\b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\b\u0010\u0018\u001a\u00020\bH\u0016J\u0012\u0010\u0019\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016R\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/map/global/sctx/widget/CompLineDelegate;", "Lcom/didi/map/sdk/nav/traffic/ITrafficLine;", "()V", "compTrafficLine", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "trafficOptions", "Lcom/didi/map/sdk/nav/traffic/TrafficOptions;", "addToMap", "", "map", "Lcom/didi/common/map/Map;", "animatorOptions", "Lcom/didi/map/sdk/nav/traffic/model/TrafficLineAnimatorOptions;", "erase", "segmentIndex", "", "car", "Lcom/didi/common/map/model/LatLng;", "getLines", "", "Lcom/didi/common/map/model/Line;", "highLight", "show", "", "remove", "setTrafficOptions", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CompLineDelegate.kt */
public final class CompLineDelegate implements ITrafficLine {

    /* renamed from: a */
    private TrafficOptions f30155a;

    /* renamed from: b */
    private ICompLineContract f30156b;

    public void setTrafficOptions(TrafficOptions trafficOptions) {
        this.f30155a = trafficOptions;
    }

    public void addToMap(Map map) {
        addToMap(map, (TrafficLineAnimatorOptions) null);
    }

    public void addToMap(Map map, TrafficLineAnimatorOptions trafficLineAnimatorOptions) {
        TrafficOptions trafficOptions;
        Long l;
        if (map != null && (trafficOptions = this.f30155a) != null) {
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
                    com.didi.map.global.component.line.component.traffic.TrafficData trafficData2 = new com.didi.map.global.component.line.component.traffic.TrafficData();
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
            this.f30156b = createLineComponent;
            if (createLineComponent != null) {
                createLineComponent.setListener(new CompLineDelegate$addToMap$1(trafficLineAnimatorOptions));
            }
            ICompLineContract iCompLineContract = this.f30156b;
            if (iCompLineContract != null) {
                iCompLineContract.start();
            }
        }
    }

    public void remove() {
        ICompLineContract iCompLineContract = this.f30156b;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
    }

    public void erase(int i, LatLng latLng) {
        if (latLng != null) {
            ICompLineContract iCompLineContract = this.f30156b;
            com.didi.map.global.component.line.component.traffic.ITrafficLine iTrafficLine = iCompLineContract instanceof com.didi.map.global.component.line.component.traffic.ITrafficLine ? (com.didi.map.global.component.line.component.traffic.ITrafficLine) iCompLineContract : null;
            if (iTrafficLine != null) {
                iTrafficLine.erase(i, latLng);
            }
        }
    }

    public List<Line> getLines() {
        ICompLineContract iCompLineContract = this.f30156b;
        List<Line> list = null;
        com.didi.map.global.component.line.component.traffic.ITrafficLine iTrafficLine = iCompLineContract instanceof com.didi.map.global.component.line.component.traffic.ITrafficLine ? (com.didi.map.global.component.line.component.traffic.ITrafficLine) iCompLineContract : null;
        if (iTrafficLine != null) {
            list = iTrafficLine.getLines();
        }
        return list == null ? CollectionsKt.emptyList() : list;
    }

    public void highLight(boolean z) {
        ICompLineContract iCompLineContract = this.f30156b;
        com.didi.map.global.component.line.component.traffic.ITrafficLine iTrafficLine = iCompLineContract instanceof com.didi.map.global.component.line.component.traffic.ITrafficLine ? (com.didi.map.global.component.line.component.traffic.ITrafficLine) iCompLineContract : null;
        if (iTrafficLine != null) {
            iTrafficLine.highLight(z);
        }
    }
}
