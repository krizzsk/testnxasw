package com.didi.map.global.component.line.pax.walkanddropoff;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.component.CompLineFactory;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.component.LineParams;
import com.didi.security.uuid.Constants;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J4\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0010\u001a\u00020\b2\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015J\u0006\u0010\u0017\u001a\u00020\u000eJ\u000e\u0010\u0018\u001a\n\u0012\u0004\u0012\u00020\u0019\u0018\u00010\u0012J&\u0010\u001a\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J&\u0010\u001c\u001a\u00020\u000e2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00130\u00122\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0015H\u0002J\u000e\u0010\u001d\u001a\u00020\u000e2\u0006\u0010\u001e\u001a\u00020\nR\u0010\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fXD¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo148868d2 = {"Lcom/didi/map/global/component/line/pax/walkanddropoff/DropOffLine;", "", "()V", "mContext", "Landroid/content/Context;", "mDropOffLine", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "mMap", "Lcom/didi/common/map/Map;", "mVisible", "", "tag", "", "create", "", "context", "map", "list", "", "Lcom/didi/common/map/model/LatLng;", "width", "", "color", "destroy", "getDropOffLine", "Lcom/didi/common/map/internal/IMapElement;", "initGoogleLine", "points", "initLine", "setVisible", "visible", "compLine_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DropOffLine.kt */
public final class DropOffLine {

    /* renamed from: a */
    private final String f28162a = "DropOffLine";

    /* renamed from: b */
    private ICompLineContract f28163b;

    /* renamed from: c */
    private Map f28164c;

    /* renamed from: d */
    private Context f28165d;

    /* renamed from: e */
    private boolean f28166e = true;

    public final void create(Context context, Map map, List<LatLng> list, int i, int i2) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(map, "map");
        Intrinsics.checkNotNullParameter(list, "list");
        DLog.m10773d(this.f28162a, Constants.CREATE_NAME, new Object[0]);
        if (CollectionUtil.isEmpty((Collection<?>) list)) {
            DLog.m10773d(this.f28162a, "create return", new Object[0]);
            return;
        }
        this.f28164c = map;
        this.f28165d = context;
        this.f28166e = true;
        m22098a(list, i, i2);
    }

    /* renamed from: a */
    private final void m22098a(List<LatLng> list, int i, int i2) {
        if (this.f28164c != null) {
            m22099b(list, i, i2);
        }
    }

    /* renamed from: b */
    private final void m22099b(List<LatLng> list, int i, int i2) {
        if (this.f28163b == null && this.f28164c != null) {
            LineParams lineParams = new LineParams(list, i2, i);
            lineParams.setZIndex(10);
            ICompLineContract createLineComponent = CompLineFactory.createLineComponent(CompLineFactory.LineType.LINE_COMMON, this.f28164c, this.f28165d, lineParams);
            this.f28163b = createLineComponent;
            if (createLineComponent != null) {
                createLineComponent.setLineVisible(this.f28166e);
                createLineComponent.start();
            }
        }
    }

    public final void destroy() {
        DLog.m10773d(this.f28162a, "destroy", new Object[0]);
        ICompLineContract iCompLineContract = this.f28163b;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
        this.f28163b = null;
        this.f28164c = null;
        this.f28166e = true;
    }

    public final List<IMapElement> getDropOffLine() {
        ICompLineContract iCompLineContract = this.f28163b;
        if (iCompLineContract == null) {
            return null;
        }
        List<IMapElement> bestViewElements = iCompLineContract.getBestViewElements();
        DLog.m10773d(this.f28162a, Intrinsics.stringPlus("getDropOffLine size= ", Integer.valueOf(bestViewElements.size())), new Object[0]);
        return bestViewElements;
    }

    public final void setVisible(boolean z) {
        DLog.m10773d(this.f28162a, "setVisible", new Object[0]);
        this.f28166e = z;
        ICompLineContract iCompLineContract = this.f28163b;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
    }
}
