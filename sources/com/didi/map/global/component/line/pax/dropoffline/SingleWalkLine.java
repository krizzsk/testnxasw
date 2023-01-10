package com.didi.map.global.component.line.pax.dropoffline;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineExParam;
import com.didi.map.global.component.line.component.LineParams;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006J,\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0014J\u001c\u0010\u0018\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\u0015\u001a\u00020\u0016J\u0006\u0010\u0019\u001a\u00020\u000fJ\u000e\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bR\u000e\u0010\u0007\u001a\u00020\bXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo148868d2 = {"Lcom/didi/map/global/component/line/pax/dropoffline/SingleWalkLine;", "", "mContext", "Landroid/content/Context;", "mMap", "Lcom/didi/common/map/Map;", "(Landroid/content/Context;Lcom/didi/common/map/Map;)V", "TAG", "", "mLineA", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "mLineB", "mVisible", "", "createA", "", "routes", "", "Lcom/didi/common/map/model/LatLng;", "width", "", "spacing", "", "color", "createB", "destroy", "getWalkLineElemets", "", "Lcom/didi/common/map/internal/IMapElement;", "compLine_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SingleWalkLine.kt */
public final class SingleWalkLine {

    /* renamed from: a */
    private final String f28128a = "SingleWalkLine";

    /* renamed from: b */
    private Context f28129b;

    /* renamed from: c */
    private Map f28130c;

    /* renamed from: d */
    private ICompLineContract f28131d;

    /* renamed from: e */
    private ICompLineContract f28132e;

    /* renamed from: f */
    private boolean f28133f;

    public SingleWalkLine(Context context, Map map) {
        Intrinsics.checkNotNullParameter(context, "mContext");
        Intrinsics.checkNotNullParameter(map, "mMap");
        this.f28129b = context;
        this.f28130c = map;
        this.f28133f = true;
    }

    public final void createA(List<LatLng> list, int i, float f, int i2) {
        Intrinsics.checkNotNullParameter(list, "routes");
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            DLog.m10773d(this.f28128a, "createA param error: routes is null", new Object[0]);
            return;
        }
        DLog.m10773d(this.f28128a, "createA ", new Object[0]);
        LineParams lineParams = new LineParams(list, i2, i);
        lineParams.setDotSpace(f);
        lineParams.setDottedIconRes(5);
        ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT, this.f28130c, this.f28129b, lineParams);
        this.f28131d = createLineComponent;
        if (createLineComponent != null) {
            createLineComponent.setLineVisible(this.f28133f);
        }
        ICompLineContract iCompLineContract = this.f28131d;
        if (iCompLineContract != null) {
            iCompLineContract.start();
        }
    }

    public final void createB(List<LatLng> list, float f) {
        Intrinsics.checkNotNullParameter(list, "routes");
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            DLog.m10773d(this.f28128a, "createB param error: routes is null", new Object[0]);
            return;
        }
        DLog.m10773d(this.f28128a, "createB ", new Object[0]);
        LineParams lineParams = new LineParams(list, 0, 0);
        lineParams.setDotSpace(f);
        lineParams.setDottedIconRes(R.drawable.blue_dot);
        LineExParam lineExParam = new LineExParam();
        lineExParam.setHasDotLineZoomListener(true);
        lineExParam.setPulseAnimDuration(1000);
        lineParams.setExParam(lineExParam);
        ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_DOT_PULSE, this.f28130c, this.f28129b, lineParams);
        this.f28132e = createLineComponent;
        if (createLineComponent != null) {
            createLineComponent.setLineVisible(this.f28133f);
        }
        ICompLineContract iCompLineContract = this.f28132e;
        if (iCompLineContract != null) {
            iCompLineContract.start();
        }
    }

    public final List<IMapElement> getWalkLineElemets() {
        DLog.m10773d(this.f28128a, "getWalkLine elements ", new Object[0]);
        ICompLineContract iCompLineContract = this.f28131d;
        if (iCompLineContract == null) {
            ICompLineContract iCompLineContract2 = this.f28132e;
            if (iCompLineContract2 == null) {
                DLog.m10773d(this.f28128a, "getWalkLine null", new Object[0]);
                return null;
            } else if (iCompLineContract2 == null) {
                return null;
            } else {
                return iCompLineContract2.getBestViewElements();
            }
        } else if (iCompLineContract == null) {
            return null;
        } else {
            return iCompLineContract.getBestViewElements();
        }
    }

    public final void destroy() {
        ICompLineContract iCompLineContract = this.f28131d;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
        this.f28131d = null;
        ICompLineContract iCompLineContract2 = this.f28132e;
        if (iCompLineContract2 != null) {
            iCompLineContract2.destroy();
        }
        this.f28132e = null;
        this.f28129b = null;
        this.f28130c = null;
    }
}
