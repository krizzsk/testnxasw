package com.didi.map.global.flow.scene.order.confirm.normal.line;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.component.ICompLineContract;
import com.didi.map.global.component.line.data.LineDataFactory;
import com.didi.map.global.component.line.data.param.RouteLineRequest;
import com.didi.map.global.component.line.data.route.BaseLineRoute;
import com.didi.map.global.flow.scene.order.confirm.component.OnElementShowCallback;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener;
import com.didi.map.global.flow.scene.order.confirm.normal.line.IRouteLineWrap;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import com.didi.map.sdk.proto.driver_gl.TravelMode;
import com.didichuxing.routesearchsdk.CallFrom;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000l\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\b\u0007\u0018\u0000 )2\u00020\u0001:\u0001)B#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0013\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0014H\u0016J\u0010\u0010\u0016\u001a\u00020\u00142\u0006\u0010\u0017\u001a\u00020\u0018H\u0016J\b\u0010\u0019\u001a\u00020\u0014H\u0002J\u0010\u0010\u001a\u001a\n\u0012\u0004\u0012\u00020\u001c\u0018\u00010\u001bH\u0016J2\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010!\u001a\u00020 2\u000e\u0010\"\u001a\n\u0012\u0004\u0012\u00020 \u0018\u00010#2\u0006\u0010$\u001a\u00020\u000eH\u0002J\b\u0010%\u001a\u00020\fH\u0016J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020\fH\u0016J\u0012\u0010(\u001a\u00020\u00142\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eXD¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000¨\u0006*"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/normal/line/SingleRouteLineWrap;", "Lcom/didi/map/global/flow/scene/order/confirm/normal/line/IRouteLineWrap;", "mContext", "Landroid/content/Context;", "mMap", "Lcom/didi/common/map/Map;", "mParam", "Lcom/didi/map/global/flow/scene/order/confirm/normal/line/BubbleLineParam;", "(Landroid/content/Context;Lcom/didi/common/map/Map;Lcom/didi/map/global/flow/scene/order/confirm/normal/line/BubbleLineParam;)V", "elementShowCallback", "Lcom/didi/map/global/flow/scene/order/confirm/component/OnElementShowCallback;", "isRouteLineVisible", "", "lineZIndex", "", "mLineRouteRequest", "Lcom/didi/map/global/component/line/data/route/BaseLineRoute;", "mRouteLine", "Lcom/didi/map/global/component/line/component/ICompLineContract;", "create", "", "destroy", "drawLine", "bubbleId", "", "drawRouteLine", "getBestViewElements", "", "Lcom/didi/common/map/internal/IMapElement;", "getRoutePlanRequest", "Lcom/didi/map/global/component/line/data/param/RouteLineRequest;", "start", "Lcom/didi/common/map/model/LatLng;", "end", "wayPoint", "", "bizGroup", "hasLine", "setLineVisible", "visible", "setOnElementShowCallback", "Companion", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SingleRouteLineWrap.kt */
public final class SingleRouteLineWrap implements IRouteLineWrap {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: i */
    private static final String f29231i = "SingleRouteLineWrap";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Context f29232a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final Map f29233b;

    /* renamed from: c */
    private final BubbleLineParam f29234c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f29235d = 100;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ICompLineContract f29236e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f29237f = true;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public OnElementShowCallback f29238g;

    /* renamed from: h */
    private BaseLineRoute<?> f29239h;

    public void create() {
    }

    public SingleRouteLineWrap(Context context, Map map, BubbleLineParam bubbleLineParam) {
        this.f29232a = context;
        this.f29233b = map;
        this.f29234c = bubbleLineParam;
    }

    public String getDefaultBubbleContent() {
        return IRouteLineWrap.DefaultImpls.getDefaultBubbleContent(this);
    }

    public long getDefaultRouteId() {
        return IRouteLineWrap.DefaultImpls.getDefaultRouteId(this);
    }

    public String getOptionBubbleContent() {
        return IRouteLineWrap.DefaultImpls.getOptionBubbleContent(this);
    }

    public long getOptionRouteId() {
        return IRouteLineWrap.DefaultImpls.getOptionRouteId(this);
    }

    public long getSelectedRouteId() {
        return IRouteLineWrap.DefaultImpls.getSelectedRouteId(this);
    }

    public boolean hasMultiLine() {
        return IRouteLineWrap.DefaultImpls.hasMultiLine(this);
    }

    public void onlyShowDefaultLine(boolean z) {
        IRouteLineWrap.DefaultImpls.onlyShowDefaultLine(this, z);
    }

    public void setEpfOrderType(EpfOrderType epfOrderType) {
        IRouteLineWrap.DefaultImpls.setEpfOrderType(this, epfOrderType);
    }

    public void setLineSelectedListener(ILineSelectedListener iLineSelectedListener) {
        IRouteLineWrap.DefaultImpls.setLineSelectedListener(this, iLineSelectedListener);
    }

    public void setMarkersCollide(List<? extends Marker> list) {
        IRouteLineWrap.DefaultImpls.setMarkersCollide(this, list);
    }

    public void setUseCache(boolean z) {
        IRouteLineWrap.DefaultImpls.setUseCache(this, z);
    }

    /* renamed from: a */
    private final void m22696a() {
        BubbleLineParam bubbleLineParam;
        DLog.m10773d(f29231i, "绘制 routeLineComponent", new Object[0]);
        if (this.f29233b != null && this.f29232a != null && (bubbleLineParam = this.f29234c) != null && bubbleLineParam.getCommonLineParam() != null) {
            CommonLineParam commonLineParam = this.f29234c.getCommonLineParam();
            BaseLineRoute<?> createLineRoute = LineDataFactory.createLineRoute(this.f29232a, LineDataFactory.LineDataType.ROUTE_PLAN);
            this.f29239h = createLineRoute;
            if (createLineRoute != null) {
                LatLng startPoint = commonLineParam.getStartPoint();
                Intrinsics.checkNotNullExpressionValue(startPoint, "param.startPoint");
                LatLng endPoint = commonLineParam.getEndPoint();
                Intrinsics.checkNotNullExpressionValue(endPoint, "param.endPoint");
                createLineRoute.start(m22695a(startPoint, endPoint, commonLineParam.getWayPoints(), this.f29234c.getBizGroup()), new SingleRouteLineWrap$drawRouteLine$1(commonLineParam, this));
            }
        }
    }

    /* renamed from: a */
    private final RouteLineRequest m22695a(LatLng latLng, LatLng latLng2, List<LatLng> list, int i) {
        RouteLineRequest routeLineRequest = new RouteLineRequest(CallFrom.ORDERROUTEAPI_BUBBLE, PaxEnvironment.getInstance().getProductId(), latLng, latLng2, TravelMode.DRIVING);
        routeLineRequest.setWayPoint(list);
        routeLineRequest.setBizGroup(i);
        return routeLineRequest;
    }

    public void drawLine(String str) {
        Intrinsics.checkNotNullParameter(str, "bubbleId");
        m22696a();
    }

    public void destroy() {
        BaseLineRoute<?> baseLineRoute = this.f29239h;
        if (baseLineRoute != null) {
            baseLineRoute.destroy();
        }
        this.f29239h = null;
        ICompLineContract iCompLineContract = this.f29236e;
        if (iCompLineContract != null) {
            iCompLineContract.destroy();
        }
        this.f29236e = null;
    }

    public List<IMapElement> getBestViewElements() {
        ICompLineContract iCompLineContract = this.f29236e;
        if (iCompLineContract == null) {
            return null;
        }
        return iCompLineContract.getBestViewElements();
    }

    public void setLineVisible(boolean z) {
        ICompLineContract iCompLineContract = this.f29236e;
        if (iCompLineContract != null) {
            iCompLineContract.setLineVisible(z);
        }
        this.f29237f = z;
    }

    public boolean hasLine() {
        return this.f29236e != null;
    }

    public void setOnElementShowCallback(OnElementShowCallback onElementShowCallback) {
        this.f29238g = onElementShowCallback;
    }

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/normal/line/SingleRouteLineWrap$Companion;", "", "()V", "TAG", "", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: SingleRouteLineWrap.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}
