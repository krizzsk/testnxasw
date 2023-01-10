package com.didi.map.global.flow.scene.minibus.component;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.Marker;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.component.streetview.StreetVersion;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusGuideComponentParam;
import com.didi.map.global.flow.scene.minibus.scene.service.MiniBusStreetParam;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.EntranceParam;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.EntrancePriorityManager;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.StreetViewEntranceManager;
import com.didi.map.global.flow.scene.order.serving.param.OrderParams;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.model.omega.GlobalOmegaTracker;
import com.sdk.poibase.model.guideentrance.GuideEntranceResult;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class MiniBusGuideEntranceComponent implements EntrancePriorityManager.EntranceCallback {

    /* renamed from: a */
    private static final String f28849a = "MiniBusGuideEntranceMarker";

    /* renamed from: b */
    private EntrancePriorityManager f28850b;

    /* renamed from: c */
    private List<GuideEntranceResult.EntranceType> f28851c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public StreetViewEntranceManager f28852d;

    /* renamed from: e */
    private boolean f28853e;

    /* renamed from: f */
    private IconLabelMarker f28854f;

    /* renamed from: g */
    private Context f28855g;

    /* renamed from: h */
    private Map f28856h;

    /* renamed from: i */
    private MiniBusGuideComponentParam f28857i;

    /* renamed from: j */
    private boolean f28858j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f28859k = false;

    /* renamed from: l */
    private StreetViewEntranceManager.StreetLoadCallback f28860l = new StreetViewEntranceManager.StreetLoadCallback() {
        public void onStreetLoadSuccess() {
            DLog.m10773d(MiniBusGuideEntranceComponent.f28849a, "StreetLoadSuccess", new Object[0]);
            boolean unused = MiniBusGuideEntranceComponent.this.f28859k = true;
            MiniBusGuideEntranceComponent.this.m22478b();
            if (MiniBusGuideEntranceComponent.this.f28852d != null && MiniBusGuideEntranceComponent.this.f28852d.isStreetViewShow()) {
                MiniBusGuideEntranceComponent.this.m22472a(2);
            }
        }

        public void onStreetLoadFails() {
            DLog.m10773d(MiniBusGuideEntranceComponent.f28849a, "StreetLoadFails", new Object[0]);
            boolean unused = MiniBusGuideEntranceComponent.this.f28859k = false;
        }

        public void onStreetInvalid() {
            DLog.m10773d(MiniBusGuideEntranceComponent.f28849a, "StreetInvalid", new Object[0]);
            boolean unused = MiniBusGuideEntranceComponent.this.f28859k = false;
            MiniBusGuideEntranceComponent.this.destroy();
        }
    };

    public MiniBusGuideEntranceComponent(Map map, Context context, MiniBusGuideComponentParam miniBusGuideComponentParam) {
        this.f28856h = map;
        this.f28855g = context;
        this.f28857i = miniBusGuideComponentParam;
        m22471a();
    }

    /* renamed from: a */
    private void m22471a() {
        Map map;
        if (this.f28857i != null) {
            if (this.f28850b == null) {
                this.f28850b = EntrancePriorityManager.getInstance();
            }
            EntrancePriorityManager entrancePriorityManager = this.f28850b;
            if (entrancePriorityManager != null && (map = this.f28856h) != null) {
                this.f28858j = false;
                entrancePriorityManager.getEntrancePriorities(this.f28855g, map, m22482f(), this);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m22478b() {
        DLog.m10773d(f28849a, "showBubble-->hasPriority" + this.f28858j + "sceneValid-->" + this.f28853e, new Object[0]);
        if (this.f28858j && this.f28853e) {
            m22483g();
        }
    }

    /* renamed from: c */
    private boolean m22479c() {
        MiniBusGuideComponentParam miniBusGuideComponentParam = this.f28857i;
        if (miniBusGuideComponentParam == null || miniBusGuideComponentParam.getOrderParams() == null || this.f28857i.getOrderParams().srcTag == null) {
            return false;
        }
        return DepartureConstants.SRCTAG_DIDIFENCE_AIRPORT.equals(this.f28857i.getOrderParams().srcTag);
    }

    public void onPrioritySuccess(GuideEntranceResult guideEntranceResult) {
        if (guideEntranceResult == null || guideEntranceResult.availDisplayTypes == null || guideEntranceResult.availDisplayTypes.size() <= 0) {
            destroy();
            return;
        }
        this.f28858j = true;
        ArrayList<GuideEntranceResult.EntranceType> arrayList = guideEntranceResult.availDisplayTypes;
        this.f28851c = arrayList;
        for (GuideEntranceResult.EntranceType next : arrayList) {
            if (next.type == 2) {
                if (!m22479c()) {
                    m22481e();
                    if (!(this.f28857i == null || next == null || next.extendInfo == null)) {
                        String str = "";
                        String addressName = this.f28857i.getStreetParam() != null ? this.f28857i.getStreetParam().getAddressName() : str;
                        if (this.f28857i.getOrderParams() != null) {
                            str = this.f28857i.getOrderParams().orderId;
                        }
                        this.f28852d = new StreetViewEntranceManager(this.f28855g, StreetVersion.STREET_V3, addressName, next.extendInfo.walkGuidePhoto, next.extendInfo.tripId, str, this.f28860l);
                    }
                } else {
                    DLog.m10773d(f28849a, "current position is in airport fence", new Object[0]);
                }
            }
        }
        m22478b();
    }

    public void onPriorityFail() {
        DLog.m10773d(f28849a, "walkGuideLine network error", new Object[0]);
        destroy();
    }

    public void destroy() {
        this.f28859k = false;
        m22481e();
        m22480d();
    }

    /* renamed from: d */
    private void m22480d() {
        IconLabelMarker iconLabelMarker = this.f28854f;
        if (iconLabelMarker != null) {
            iconLabelMarker.destory();
            this.f28854f = null;
        }
    }

    /* renamed from: e */
    private void m22481e() {
        StreetViewEntranceManager streetViewEntranceManager = this.f28852d;
        if (streetViewEntranceManager != null) {
            streetViewEntranceManager.destroy();
            this.f28852d = null;
        }
    }

    /* renamed from: f */
    private EntranceParam m22482f() {
        EntranceParam entranceParam = new EntranceParam();
        MiniBusGuideComponentParam miniBusGuideComponentParam = this.f28857i;
        if (miniBusGuideComponentParam != null) {
            OrderParams orderParams = miniBusGuideComponentParam.getOrderParams();
            MiniBusStreetParam streetParam = this.f28857i.getStreetParam();
            if (!(streetParam == null || orderParams == null)) {
                entranceParam.selectLat = streetParam.getAddressPosition();
                entranceParam.latLng = streetParam.getAddressPosition();
                entranceParam.displayName = streetParam.getAddressName();
                entranceParam.poiId = streetParam.getAddressPoiId();
                entranceParam.walkGuidePhoto = streetParam.getStreetViewUrl();
                entranceParam.orderId = orderParams.orderId;
                entranceParam.orderStatus = orderParams.orderStage;
                entranceParam.orderType = orderParams.orderType;
                entranceParam.isCarpool = false;
                entranceParam.srcTag = "mini_bus_src";
                entranceParam.walkGuideLink = streetParam.getStreetViewUrl();
                entranceParam.walkGuidePhoto = streetParam.getStreetViewUrl();
            }
        }
        return entranceParam;
    }

    /* renamed from: g */
    private void m22483g() {
        IconLabelMarker iconLabelMarker;
        View smallStreetView;
        StreetViewEntranceManager streetViewEntranceManager;
        View smallStreetView2;
        if (this.f28857i != null && this.f28856h != null) {
            if (this.f28854f == null) {
                DLog.m10773d(f28849a, "create streetView bubble marker", new Object[0]);
                MiniBusStreetParam streetParam = this.f28857i.getStreetParam();
                if (streetParam != null && (streetViewEntranceManager = this.f28852d) != null && (smallStreetView2 = streetViewEntranceManager.getSmallStreetView()) != null) {
                    this.f28854f = new IconLabelMarker(this.f28856h, MapElementId.ID_MARKER_START_NAV.name(), this.f28855g).create(new IconLabelMarker.IconLabelMarkerInfo.Builder().latlng(streetParam.getAddressPosition()).markerIcon(MapUtils.getViewBitmap(smallStreetView2)).markerIconAnchorU(-0.05f).markerIconAnchorV(1.1f).isClickable(true).markerIconZIndex(204).build());
                    m22472a(0);
                    this.f28856h.addOnMarkerClickListener(new OnMarkerClickListener() {
                        public final boolean onMarkerClick(Marker marker) {
                            return MiniBusGuideEntranceComponent.this.m22475a(marker);
                        }
                    });
                    return;
                }
                return;
            }
            DLog.m10773d(f28849a, "update streetView marker icon", new Object[0]);
            if (this.f28852d != null && (iconLabelMarker = this.f28854f) != null && iconLabelMarker.getIconMarker() != null && (smallStreetView = this.f28852d.getSmallStreetView()) != null) {
                this.f28854f.getIconMarker().setIcon(this.f28855g, BitmapDescriptorFactory.fromBitmap(MapUtils.getViewBitmap(smallStreetView)));
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ boolean m22475a(Marker marker) {
        List<GuideEntranceResult.EntranceType> list;
        IconLabelMarker iconLabelMarker = this.f28854f;
        if (iconLabelMarker == null || marker == null || marker != iconLabelMarker.getIconMarker() || (list = this.f28851c) == null || list.get(0) == null || this.f28851c.get(0).extendInfo == null || TextUtils.isEmpty(this.f28851c.get(0).extendInfo.walkGuidePhoto)) {
            DLog.m10773d(f28849a, "streetViewURL is empty，click invalid", new Object[0]);
            return false;
        }
        m22484h();
        return true;
    }

    /* renamed from: h */
    private void m22484h() {
        StreetViewEntranceManager streetViewEntranceManager = this.f28852d;
        if (streetViewEntranceManager != null) {
            streetViewEntranceManager.showBigStreet();
        }
        m22472a(1);
        if (this.f28859k) {
            m22472a(2);
        }
    }

    public void setSceneValid(boolean z) {
        this.f28853e = z;
    }

    public List<IMapElement> getMarker() {
        ArrayList arrayList = new ArrayList();
        IconLabelMarker iconLabelMarker = this.f28854f;
        if (iconLabelMarker != null && !CollectionUtil.isEmpty((Collection<?>) iconLabelMarker.getMarkers())) {
            arrayList.addAll(this.f28854f.getMarkers());
        }
        return arrayList;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m22472a(int i) {
        HashMap hashMap = new HashMap();
        MiniBusGuideComponentParam miniBusGuideComponentParam = this.f28857i;
        if (!(miniBusGuideComponentParam == null || miniBusGuideComponentParam.getOrderParams() == null)) {
            hashMap.put("order_id", this.f28857i.getOrderParams().orderId);
        }
        if (i == 0) {
            GlobalOmegaTracker.trackEvent("ibt_gp_minibus_streetview_sw", hashMap);
        } else if (i == 1) {
            GlobalOmegaTracker.trackEvent("ibt_gp_minibus_streetview_ck", hashMap);
        } else if (i == 2) {
            GlobalOmegaTracker.trackEvent("ibt_gp_minibus_streetview_pic_sw", hashMap);
        }
    }
}
