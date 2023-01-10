package com.didi.map.global.flow.scene.order.confirm.normal.line;

import android.content.Context;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.line.data.LineDataFactory;
import com.didi.map.global.component.line.data.param.BubblePageLineRequest;
import com.didi.map.global.component.line.data.route.BaseLineRoute;
import com.didi.map.global.flow.scene.order.confirm.component.LineParam;
import com.didi.map.global.flow.scene.order.confirm.component.MultiLineComponent;
import com.didi.map.global.flow.scene.order.confirm.component.MultiLineParam;
import com.didi.map.global.flow.scene.order.confirm.component.OnElementShowCallback;
import com.didi.map.global.flow.scene.order.confirm.normal.ILineSelectedListener;
import com.didi.map.global.flow.scene.param.CommonLineParam;
import com.didi.map.global.flow.utils.OraDataUtils;
import com.didi.map.sdk.proto.driver_gl.BubblePageRes;
import com.didi.map.sdk.proto.driver_gl.EpfOrderType;
import com.didi.map.sdk.proto.driver_gl.EstimateInfo;
import com.didi.map.sdk.proto.driver_gl.EstimatedPriceRoute;
import com.didi.map.sdk.proto.driver_gl.LabelItem;
import com.sdk.poibase.store.PoiStore;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

@Metadata(mo148867d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0016\u0018\u0000 R2\u00020\u0001:\u0001RB#\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\b\u0010&\u001a\u00020'H\u0016J6\u0010(\u001a\u00020'2\b\u0010)\u001a\u0004\u0018\u00010*2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010$H\u0002J \u0010(\u001a\u00020'2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u00100\u001a\u0004\u0018\u00010\u000eH\u0002J\b\u00101\u001a\u00020'H\u0016J\u0010\u00102\u001a\u00020'2\u0006\u00103\u001a\u00020\u000eH\u0016J\u0010\u00104\u001a\n\u0012\u0004\u0012\u000205\u0018\u00010$H\u0016J\b\u00106\u001a\u00020\u000eH\u0016J\b\u00107\u001a\u00020\u0011H\u0016J\b\u00108\u001a\u00020\u000eH\u0016J\b\u00109\u001a\u00020\u0011H\u0016J2\u0010:\u001a\u0004\u0018\u00010;2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020,2\u000e\u0010.\u001a\n\u0012\u0004\u0012\u00020,\u0018\u00010\u00142\u0006\u0010<\u001a\u00020=H\u0002J\b\u0010>\u001a\u00020\u0011H\u0016J\b\u0010?\u001a\u00020\fH\u0016J\b\u0010@\u001a\u00020\fH\u0016J\u0010\u0010A\u001a\u00020'2\u0006\u0010B\u001a\u00020\fH\u0016J\b\u0010C\u001a\u00020'H\u0002J\u0012\u0010D\u001a\u00020'2\b\u0010E\u001a\u0004\u0018\u00010\nH\u0016J\u0012\u0010F\u001a\u00020'2\b\u0010G\u001a\u0004\u0018\u00010\u0019H\u0016J\u0010\u0010H\u001a\u00020'2\u0006\u0010I\u001a\u00020\fH\u0016J\u0018\u0010J\u001a\u00020'2\u000e\u0010K\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$H\u0016J\u0012\u0010L\u001a\u00020'2\b\u0010M\u001a\u0004\u0018\u00010\u001bH\u0016J\u0010\u0010N\u001a\u00020'2\u0006\u0010O\u001a\u00020\fH\u0016J\b\u0010P\u001a\u00020'H\u0002J\b\u0010Q\u001a\u00020'H\u0002R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0013\u001a\n\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0019X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u001a\u001a\u0004\u0018\u00010\u001bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u001eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001f\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010 \u001a\u0004\u0018\u00010!X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u0016\u0010#\u001a\n\u0012\u0004\u0012\u00020%\u0018\u00010$X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0004¢\u0006\u0002\n\u0000¨\u0006S"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/normal/line/MultiRouteLineWrap;", "Lcom/didi/map/global/flow/scene/order/confirm/normal/line/IRouteLineWrap;", "mContext", "Landroid/content/Context;", "mMap", "Lcom/didi/common/map/Map;", "param", "Lcom/didi/map/global/flow/scene/order/confirm/normal/line/BubbleLineParam;", "(Landroid/content/Context;Lcom/didi/common/map/Map;Lcom/didi/map/global/flow/scene/order/confirm/normal/line/BubbleLineParam;)V", "epfOrderType", "Lcom/didi/map/sdk/proto/driver_gl/EpfOrderType;", "isRouteLineVisible", "", "mBubbleId", "", "mBuddleContent", "mDefaultLineId", "", "mDestroy", "mLineParams", "", "Lcom/didi/map/global/flow/scene/order/confirm/component/LineParam;", "mLineRouteRequest", "Lcom/didi/map/global/component/line/data/route/BaseLineRoute;", "mListener", "Lcom/didi/map/global/flow/scene/order/confirm/normal/ILineSelectedListener;", "mOnElementShowCallback", "Lcom/didi/map/global/flow/scene/order/confirm/component/OnElementShowCallback;", "mOnlyShowDefaultLine", "mRouteLine", "Lcom/didi/map/global/flow/scene/order/confirm/component/MultiLineComponent;", "mSelectedLineId", "mStore", "Lcom/sdk/poibase/store/PoiStore;", "mUseCache", "markersCollide", "", "Lcom/didi/common/map/model/Marker;", "create", "", "createRouteLine", "res", "Lcom/didi/map/sdk/proto/driver_gl/BubblePageRes;", "start", "Lcom/didi/common/map/model/LatLng;", "end", "wayPoint", "lineParams", "educBubbleContent", "destroy", "drawLine", "bubbleId", "getBestViewElements", "Lcom/didi/common/map/internal/IMapElement;", "getDefaultBubbleContent", "getDefaultRouteId", "getOptionBubbleContent", "getOptionRouteId", "getRoutePlanRequest", "Lcom/didi/map/global/component/line/data/param/BubblePageLineRequest;", "bizGroup", "", "getSelectedRouteId", "hasLine", "hasMultiLine", "onlyShowDefaultLine", "showDefaultLine", "planMultiLine", "setEpfOrderType", "type", "setLineSelectedListener", "listener", "setLineVisible", "visible", "setMarkersCollide", "sizes", "setOnElementShowCallback", "elementShowCallback", "setUseCache", "useCache", "showDefaultLineFromCache", "showMultiLineFromCache", "Companion", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: MultiRouteLineWrap.kt */
public final class MultiRouteLineWrap implements IRouteLineWrap {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String Key_ShowedEducBubble = "HasShowEducBubble";
    public static final String TAG = "MultiRouteLineWrap";

    /* renamed from: a */
    private final Context f29204a;

    /* renamed from: b */
    private final Map f29205b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final BubbleLineParam f29206c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public MultiLineComponent f29207d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ILineSelectedListener f29208e;

    /* renamed from: f */
    private boolean f29209f = true;

    /* renamed from: g */
    private PoiStore f29210g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f29211h;

    /* renamed from: i */
    private OnElementShowCallback f29212i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public long f29213j;

    /* renamed from: k */
    private long f29214k;

    /* renamed from: l */
    private boolean f29215l = true;

    /* renamed from: m */
    private boolean f29216m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public List<LineParam> f29217n;

    /* renamed from: o */
    private String f29218o;

    /* renamed from: p */
    private List<? extends Marker> f29219p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public String f29220q;

    /* renamed from: r */
    private BaseLineRoute<?> f29221r;

    /* renamed from: s */
    private EpfOrderType f29222s = EpfOrderType.NormalType;

    public MultiRouteLineWrap(Context context, Map map, BubbleLineParam bubbleLineParam) {
        this.f29204a = context;
        this.f29205b = map;
        this.f29206c = bubbleLineParam;
    }

    @Metadata(mo148867d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/map/global/flow/scene/order/confirm/normal/line/MultiRouteLineWrap$Companion;", "", "()V", "Key_ShowedEducBubble", "", "TAG", "sdk-mapflow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: MultiRouteLineWrap.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public void drawLine(String str) {
        List<LineParam> list;
        Intrinsics.checkNotNullParameter(str, "bubbleId");
        this.f29220q = str;
        if (!this.f29215l || (list = this.f29217n) == null) {
            m22694c();
            return;
        }
        if (!this.f29216m) {
            Intrinsics.checkNotNull(list);
            if (list.size() < 2) {
                m22694c();
                return;
            }
        }
        List<LineParam> list2 = this.f29217n;
        Intrinsics.checkNotNull(list2);
        if (list2.size() == 1) {
            m22690a();
            return;
        }
        if (this.f29216m) {
            List<LineParam> list3 = this.f29217n;
            Intrinsics.checkNotNull(list3);
            if (list3.size() > 1) {
                m22690a();
                return;
            }
        }
        List<LineParam> list4 = this.f29217n;
        Intrinsics.checkNotNull(list4);
        if (list4.size() == 2) {
            m22693b();
        } else {
            m22694c();
        }
    }

    /* renamed from: a */
    private final void m22690a() {
        List arrayList = new ArrayList();
        List<LineParam> list = this.f29217n;
        Intrinsics.checkNotNull(list);
        LineParam lineParam = list.get(0);
        arrayList.add(new LineParam(lineParam.getLineId(), lineParam.getPoints(), lineParam.getLineBubbleContent(), true));
        m22692a(arrayList, this.f29218o);
    }

    /* renamed from: b */
    private final void m22693b() {
        List arrayList = new ArrayList();
        List<LineParam> list = this.f29217n;
        Intrinsics.checkNotNull(list);
        for (LineParam next : list) {
            arrayList.add(new LineParam(next.getLineId(), next.getPoints(), next.getLineBubbleContent(), next.getLineId() == this.f29213j));
        }
        m22692a(arrayList, this.f29218o);
    }

    public void create() {
        this.f29211h = false;
    }

    public void destroy() {
        BaseLineRoute<?> baseLineRoute = this.f29221r;
        if (baseLineRoute != null) {
            baseLineRoute.destroy();
        }
        this.f29221r = null;
        MultiLineComponent multiLineComponent = this.f29207d;
        if (multiLineComponent != null) {
            multiLineComponent.destroy();
        }
        this.f29207d = null;
        this.f29211h = true;
    }

    public List<IMapElement> getBestViewElements() {
        MultiLineComponent multiLineComponent = this.f29207d;
        if (multiLineComponent == null) {
            return null;
        }
        return multiLineComponent.getBestViewElements();
    }

    public void setLineVisible(boolean z) {
        MultiLineComponent multiLineComponent = this.f29207d;
        if (multiLineComponent != null) {
            multiLineComponent.setAllLineVisible(z);
        }
        this.f29209f = z;
    }

    public void setLineSelectedListener(ILineSelectedListener iLineSelectedListener) {
        this.f29208e = iLineSelectedListener;
    }

    public void setMarkersCollide(List<? extends Marker> list) {
        this.f29219p = list;
    }

    public void setEpfOrderType(EpfOrderType epfOrderType) {
        if (epfOrderType != null) {
            this.f29222s = epfOrderType;
        }
    }

    /* renamed from: c */
    private final void m22694c() {
        try {
            if (this.f29205b != null && this.f29204a != null && this.f29206c != null) {
                if (this.f29206c.getCommonLineParam() != null) {
                    Ref.ObjectRef objectRef = new Ref.ObjectRef();
                    objectRef.element = this.f29206c.getCommonLineParam();
                    this.f29221r = LineDataFactory.createLineRoute(this.f29204a, LineDataFactory.LineDataType.ROUTE_BUBBLE_PAGE);
                    LatLng startPoint = ((CommonLineParam) objectRef.element).getStartPoint();
                    Intrinsics.checkNotNullExpressionValue(startPoint, "commonLineParam.startPoint");
                    LatLng endPoint = ((CommonLineParam) objectRef.element).getEndPoint();
                    Intrinsics.checkNotNullExpressionValue(endPoint, "commonLineParam.endPoint");
                    BubblePageLineRequest a = m22689a(startPoint, endPoint, ((CommonLineParam) objectRef.element).getWayPoints(), this.f29206c.getBizGroup());
                    BubblePageRes bubblePageInCache = BubblePageCache.getInstance().getBubblePageInCache(((CommonLineParam) objectRef.element).getStartPoint(), ((CommonLineParam) objectRef.element).getEndPoint(), ((CommonLineParam) objectRef.element).getWayPoints());
                    if (bubblePageInCache == null) {
                        BaseLineRoute<?> baseLineRoute = this.f29221r;
                        if (baseLineRoute != null) {
                            baseLineRoute.start(a, new MultiRouteLineWrap$planMultiLine$1(this, objectRef));
                        }
                    } else if (this.f29207d == null && !this.f29211h) {
                        DLog.m10773d("BubblePage", "get route back from cache.", new Object[0]);
                        m22691a(bubblePageInCache, ((CommonLineParam) objectRef.element).getStartPoint(), ((CommonLineParam) objectRef.element).getEndPoint(), ((CommonLineParam) objectRef.element).getWayPoints());
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0016, code lost:
        r4 = r4.getStartAddress();
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final com.didi.map.global.component.line.data.param.BubblePageLineRequest m22689a(com.didi.common.map.model.LatLng r4, com.didi.common.map.model.LatLng r5, java.util.List<com.didi.common.map.model.LatLng> r6, int r7) {
        /*
            r3 = this;
            com.didi.map.global.component.line.data.param.BubblePageLineRequest r0 = new com.didi.map.global.component.line.data.param.BubblePageLineRequest
            com.didichuxing.routesearchsdk.CallFrom r1 = com.didichuxing.routesearchsdk.CallFrom.ORDERROUTEAPI_BUBBLE
            com.didi.map.sdk.env.PaxEnvironment r2 = com.didi.map.sdk.env.PaxEnvironment.getInstance()
            java.lang.String r2 = r2.getProductId()
            r0.<init>(r1, r2, r4, r5)
            com.didi.map.global.flow.scene.order.confirm.normal.line.BubbleLineParam r4 = r3.f29206c
            r5 = 0
            if (r4 != 0) goto L_0x0016
        L_0x0014:
            r4 = r5
            goto L_0x0023
        L_0x0016:
            com.didi.sdk.address.address.entity.Address r4 = r4.getStartAddress()
            if (r4 != 0) goto L_0x001d
            goto L_0x0014
        L_0x001d:
            int r4 = r4.cityId
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
        L_0x0023:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r4)
            int r4 = r4.intValue()
            r0.setStartCityId(r4)
            com.didi.map.global.flow.scene.order.confirm.normal.line.BubbleLineParam r4 = r3.f29206c
            com.didi.sdk.address.address.entity.Address r4 = r4.getEndAddress()
            if (r4 != 0) goto L_0x0036
            goto L_0x003c
        L_0x0036:
            int r4 = r4.cityId
            java.lang.Integer r5 = java.lang.Integer.valueOf(r4)
        L_0x003c:
            kotlin.jvm.internal.Intrinsics.checkNotNull(r5)
            int r4 = r5.intValue()
            r0.setEndCityId(r4)
            com.didi.map.sdk.proto.driver_gl.EpfOrderType r4 = r3.f29222s
            r0.setEpfOrderType(r4)
            com.didi.sdk.map.language.LocaleCodeHolder r4 = com.didi.sdk.map.language.LocaleCodeHolder.getInstance()
            java.lang.String r4 = r4.getCurrentLang()
            r0.setCurrentLang(r4)
            r0.setWayPoint(r6)
            r0.setBizGroup(r7)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.confirm.normal.line.MultiRouteLineWrap.m22689a(com.didi.common.map.model.LatLng, com.didi.common.map.model.LatLng, java.util.List, int):com.didi.map.global.component.line.data.param.BubblePageLineRequest");
    }

    public void setOnElementShowCallback(OnElementShowCallback onElementShowCallback) {
        this.f29212i = onElementShowCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m22691a(BubblePageRes bubblePageRes, LatLng latLng, LatLng latLng2, List<LatLng> list) {
        List<EstimatedPriceRoute> list2;
        Integer num;
        LabelItem labelItem;
        Iterable<IndexedValue> withIndex;
        boolean z;
        Long l;
        BubblePageRes bubblePageRes2 = bubblePageRes;
        LatLng latLng3 = latLng;
        LatLng latLng4 = latLng2;
        List<LatLng> list3 = list;
        if (bubblePageRes2 == null) {
            DLog.m10773d("BubblePage", "BubblePageRes is null", new Object[0]);
            return;
        }
        EstimateInfo estimateInfo = bubblePageRes2.estimateInfo;
        String str = null;
        if (estimateInfo == null) {
            list2 = null;
        } else {
            list2 = estimateInfo.route;
        }
        List<LineParam> arrayList = new ArrayList<>();
        long selectedRouteId = BubblePageCache.getInstance().getSelectedRouteId(latLng3, latLng4, list3);
        long defaultRouteId = BubblePageCache.getInstance().getDefaultRouteId(latLng3, latLng4, list3);
        if (!(selectedRouteId == 0 || defaultRouteId == 0)) {
            this.f29213j = selectedRouteId;
            this.f29214k = defaultRouteId;
        }
        if (!(list2 == null || (withIndex = CollectionsKt.withIndex(list2)) == null)) {
            for (IndexedValue indexedValue : withIndex) {
                int component1 = indexedValue.component1();
                EstimatedPriceRoute estimatedPriceRoute = (EstimatedPriceRoute) indexedValue.component2();
                long j = this.f29213j;
                if (j == 0 || (l = estimatedPriceRoute.routeID) == null || j != l.longValue()) {
                    if (this.f29213j == 0 && this.f29214k == 0 && component1 == 0) {
                        Long l2 = estimatedPriceRoute.routeID;
                        Intrinsics.checkNotNullExpressionValue(l2, "route.routeID");
                        this.f29213j = l2.longValue();
                        Long l3 = estimatedPriceRoute.routeID;
                        Intrinsics.checkNotNullExpressionValue(l3, "route.routeID");
                        this.f29214k = l3.longValue();
                    } else {
                        z = false;
                        Long l4 = estimatedPriceRoute.routeID;
                        Intrinsics.checkNotNullExpressionValue(l4, "route.routeID");
                        long longValue = l4.longValue();
                        List<LatLng> convertToLatLngList = OraDataUtils.convertToLatLngList(estimatedPriceRoute.geo);
                        Intrinsics.checkNotNullExpressionValue(convertToLatLngList, "convertToLatLngList(route.geo)");
                        String str2 = estimatedPriceRoute.routeLabel;
                        Intrinsics.checkNotNullExpressionValue(str2, "route.routeLabel");
                        LineParam lineParam = new LineParam(longValue, convertToLatLngList, str2, z);
                        DLog.m10773d("BubblePage", "label:" + estimatedPriceRoute.routeLabel + ",routeId:" + estimatedPriceRoute.routeID, new Object[0]);
                        arrayList.add(lineParam);
                    }
                }
                z = true;
                Long l42 = estimatedPriceRoute.routeID;
                Intrinsics.checkNotNullExpressionValue(l42, "route.routeID");
                long longValue2 = l42.longValue();
                List<LatLng> convertToLatLngList2 = OraDataUtils.convertToLatLngList(estimatedPriceRoute.geo);
                Intrinsics.checkNotNullExpressionValue(convertToLatLngList2, "convertToLatLngList(route.geo)");
                String str22 = estimatedPriceRoute.routeLabel;
                Intrinsics.checkNotNullExpressionValue(str22, "route.routeLabel");
                LineParam lineParam2 = new LineParam(longValue2, convertToLatLngList2, str22, z);
                DLog.m10773d("BubblePage", "label:" + estimatedPriceRoute.routeLabel + ",routeId:" + estimatedPriceRoute.routeID, new Object[0]);
                arrayList.add(lineParam2);
            }
        }
        this.f29217n = arrayList;
        if (list2 == null) {
            num = null;
        } else {
            num = Integer.valueOf(list2.size());
        }
        if (num != null && num.intValue() == 2) {
            EstimatedPriceRoute estimatedPriceRoute2 = list2.get(1);
            List<LabelItem> list4 = estimatedPriceRoute2 == null ? null : estimatedPriceRoute2.label;
            if (!(list4 == null || (labelItem = list4.get(0)) == null)) {
                str = labelItem.buddleContent;
            }
            this.f29218o = str;
        }
        if (!this.f29216m || arrayList.size() <= 1) {
            m22692a(arrayList, this.f29218o);
        } else {
            m22692a(arrayList.subList(0, 1), this.f29218o);
        }
    }

    /* renamed from: a */
    private final void m22692a(List<LineParam> list, String str) {
        PoiStore poiStore;
        if (list.size() != 0) {
            int i = 0;
            DLog.m10773d(TAG, Intrinsics.stringPlus("line size:", Integer.valueOf(list.size())), new Object[0]);
            MultiLineParam multiLineParam = new MultiLineParam(list, new MultiRouteLineWrap$createRouteLine$lineParam$1(this), new MultiRouteLineWrap$createRouteLine$lineParam$2(this));
            if (this.f29210g == null) {
                this.f29210g = PoiStore.getInstance(this.f29204a);
            }
            PoiStore poiStore2 = this.f29210g;
            Boolean valueOf = poiStore2 == null ? null : Boolean.valueOf(poiStore2.getBoolean(Key_ShowedEducBubble, false));
            boolean z = valueOf != null ? !valueOf.booleanValue() : false;
            if (list.size() == 2 && (poiStore = this.f29210g) != null) {
                poiStore.putAndSave(Key_ShowedEducBubble, true);
            }
            BubbleLineParam bubbleLineParam = this.f29206c;
            if (bubbleLineParam != null) {
                CommonLineParam commonLineParam = bubbleLineParam.getCommonLineParam();
                i = commonLineParam.getLineWidth() == 0 ? 6 : commonLineParam.getLineWidth();
            }
            multiLineParam.setSelectLineColor(Color.parseColor("#33BBFF"));
            multiLineParam.setSelectLineWidth(i);
            multiLineParam.setUnSelectLineColor(Color.parseColor("#A6DFFF"));
            multiLineParam.setUnSelectLineWidth(i);
            multiLineParam.setShowEducBubble(z);
            multiLineParam.setMarkersCollide(this.f29219p);
            if (list.size() == 2 && str != null) {
                multiLineParam.setEducBubbleContent(str);
            }
            MultiLineComponent multiLineComponent = this.f29207d;
            if (multiLineComponent != null) {
                multiLineComponent.destroy();
            }
            MultiLineComponent multiLineComponent2 = new MultiLineComponent(this.f29204a, this.f29205b);
            this.f29207d = multiLineComponent2;
            if (multiLineComponent2 != null) {
                multiLineComponent2.setConfigParam(multiLineParam);
            }
            MultiLineComponent multiLineComponent3 = this.f29207d;
            if (multiLineComponent3 != null) {
                multiLineComponent3.setBubblePositionCallback(this.f29212i);
            }
            MultiLineComponent multiLineComponent4 = this.f29207d;
            if (multiLineComponent4 != null) {
                multiLineComponent4.start();
            }
        }
    }

    public void onlyShowDefaultLine(boolean z) {
        this.f29216m = z;
    }

    public void setUseCache(boolean z) {
        this.f29215l = z;
    }

    public boolean hasLine() {
        MultiLineComponent multiLineComponent = this.f29207d;
        if (multiLineComponent == null) {
            return false;
        }
        return multiLineComponent.hasLine();
    }

    public long getDefaultRouteId() {
        return this.f29214k;
    }

    public long getSelectedRouteId() {
        return this.f29213j;
    }

    public long getOptionRouteId() {
        List<LineParam> list = this.f29217n;
        if (list == null) {
            return 0;
        }
        Intrinsics.checkNotNull(list);
        if (list.size() <= 1) {
            return 0;
        }
        List<LineParam> list2 = this.f29217n;
        Intrinsics.checkNotNull(list2);
        return list2.get(1).getLineId();
    }

    public String getDefaultBubbleContent() {
        List<LineParam> list = this.f29217n;
        if (list == null) {
            return "";
        }
        Intrinsics.checkNotNull(list);
        if (list.size() <= 0) {
            return "";
        }
        List<LineParam> list2 = this.f29217n;
        Intrinsics.checkNotNull(list2);
        return list2.get(0).getLineBubbleContent();
    }

    public String getOptionBubbleContent() {
        List<LineParam> list = this.f29217n;
        if (list == null) {
            return "";
        }
        Intrinsics.checkNotNull(list);
        if (list.size() <= 1) {
            return "";
        }
        List<LineParam> list2 = this.f29217n;
        Intrinsics.checkNotNull(list2);
        return list2.get(1).getLineBubbleContent();
    }

    public boolean hasMultiLine() {
        List<LineParam> list = this.f29217n;
        if (list == null) {
            return false;
        }
        Intrinsics.checkNotNull(list);
        return list.size() > 1;
    }
}
