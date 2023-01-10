package com.didi.map.global.flow.scene.order.serving.components.guideentrance;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.common.map.MapView;
import com.didi.common.map.listener.OnMarkerClickListener;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.InfoWindow;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.LatLngUtils;
import com.didi.common.map.util.MapUtils;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.streetview.StreetVersion;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.EntrancePriorityManager;
import com.didi.map.global.flow.scene.order.serving.components.guideentrance.StreetViewEntranceManager;
import com.didi.map.global.flow.scene.order.serving.param.ServingParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowOmegaUtil;
import com.didi.map.global.flow.widget.RoundImageView;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.sdk.poibase.model.guideentrance.GuideEntranceResult;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class GuideEntranceMarker implements OnMarkerClickListener, EntrancePriorityManager.EntranceCallback {

    /* renamed from: a */
    private static final String f29364a = "GuideEntranceMarker";

    /* renamed from: A */
    private boolean f29365A = true;

    /* renamed from: B */
    private StreetViewEntranceManager.StreetLoadCallback f29366B = new StreetViewEntranceManager.StreetLoadCallback() {
        public void onStreetLoadSuccess() {
            boolean unused = GuideEntranceMarker.this.f29388w = true;
            DLog.m10773d(GuideEntranceMarker.f29364a, "StreetLoadSuccess", new Object[0]);
            if (GuideEntranceMarker.this.f29379n == 3) {
                GuideEntranceMarker.this.m22783e();
            }
        }

        public void onStreetLoadFails() {
            boolean unused = GuideEntranceMarker.this.f29388w = false;
            DLog.m10773d(GuideEntranceMarker.f29364a, "StreetLoadFails", new Object[0]);
        }

        public void onStreetInvalid() {
            boolean unused = GuideEntranceMarker.this.f29388w = false;
            GuideEntranceMarker.this.m22788j();
        }
    };

    /* renamed from: b */
    private MapView f29367b;

    /* renamed from: c */
    private Marker f29368c;

    /* renamed from: d */
    private int f29369d = 131;

    /* renamed from: e */
    private View f29370e;

    /* renamed from: f */
    private FrameLayout f29371f;

    /* renamed from: g */
    private View f29372g;

    /* renamed from: h */
    private RoundImageView f29373h;

    /* renamed from: i */
    private TextView f29374i;

    /* renamed from: j */
    private RoundImageView f29375j;

    /* renamed from: k */
    private ServingParam f29376k;

    /* renamed from: l */
    private Marker f29377l;

    /* renamed from: m */
    private LatLng f29378m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f29379n = 0;

    /* renamed from: o */
    private EntrancePriorityManager f29380o;

    /* renamed from: p */
    private AREntranceManager f29381p;

    /* renamed from: q */
    private RealSceneEntranceManager f29382q;

    /* renamed from: r */
    private StreetViewEntranceManager f29383r;

    /* renamed from: s */
    private boolean f29384s = true;
    public boolean sceneValid;

    /* renamed from: t */
    private GuideEntranceResult.EntranceType f29385t;

    /* renamed from: u */
    private List<GuideEntranceResult.EntranceType> f29386u;

    /* renamed from: v */
    private Context f29387v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f29388w = false;

    /* renamed from: x */
    private boolean f29389x = false;

    /* renamed from: y */
    private boolean f29390y;

    /* renamed from: z */
    private boolean f29391z;

    public GuideEntranceMarker(MapView mapView, Marker marker, LatLng latLng, ServingParam servingParam) {
        if (servingParam != null && mapView != null) {
            this.f29367b = mapView;
            this.f29377l = marker;
            this.f29378m = latLng;
            this.f29376k = servingParam;
            Context context = servingParam.getContext();
            this.f29387v = context;
            if (context != null) {
                m22775a();
                EntrancePriorityManager instance = EntrancePriorityManager.getInstance();
                this.f29380o = instance;
                if (instance != null) {
                    this.f29391z = false;
                    this.f29389x = false;
                    instance.getEntrancePriorities(this.f29387v, this.f29367b.getMap(), m22778b(), this);
                }
            }
        }
    }

    /* renamed from: a */
    private void m22775a() {
        View inflate = LayoutInflater.from(this.f29387v).inflate(R.layout.guide_entrance_marker, (ViewGroup) null, false);
        this.f29370e = inflate;
        Drawable drawable = this.f29370e.getResources().getDrawable(R.drawable.arrow_right);
        drawable.setAutoMirrored(true);
        ((ImageView) inflate.findViewById(R.id.arrow)).setImageDrawable(drawable);
        this.f29371f = (FrameLayout) this.f29370e.findViewById(R.id.content_container);
        this.f29375j = (RoundImageView) this.f29370e.findViewById(R.id.street_view_icon);
        this.f29372g = this.f29370e.findViewById(R.id.entrance_container);
        this.f29373h = (RoundImageView) this.f29370e.findViewById(R.id.entrance_icon);
        this.f29374i = (TextView) this.f29370e.findViewById(R.id.entrance_text);
    }

    /* renamed from: b */
    private EntranceParam m22778b() {
        CommonMarkerParam markerParam;
        EntranceParam entranceParam = new EntranceParam();
        ServingParam servingParam = this.f29376k;
        if (!(servingParam == null || (markerParam = servingParam.getMarkerParam(MapElementId.ID_MARKER_START)) == null || this.f29376k.getOrderParams() == null)) {
            entranceParam.selectLat = markerParam.getPoint();
            entranceParam.latLng = markerParam.getPoint();
            entranceParam.displayName = markerParam.getAddressName();
            entranceParam.poiId = markerParam.getPoiId();
            entranceParam.orderId = this.f29376k.getOrderParams().orderId;
            entranceParam.orderStatus = this.f29376k.getOrderParams().orderStage;
            entranceParam.orderType = this.f29376k.getOrderParams().orderType;
            entranceParam.isCarpool = this.f29376k.getOrderParams().isCarpoolOrder();
            entranceParam.srcTag = this.f29376k.getOrderParams().srcTag;
            entranceParam.walkGuideLink = this.f29376k.getOrderParams().stationWalkGuideLink;
            entranceParam.walkGuidePhoto = this.f29376k.getOrderParams().stationWalkGuidePhoto;
        }
        return entranceParam;
    }

    public void location(DIDILocation dIDILocation) {
        AREntranceManager aREntranceManager = this.f29381p;
        if (aREntranceManager != null) {
            aREntranceManager.setCurrentLocation(dIDILocation);
        }
    }

    public void update(ServingParam servingParam, LatLng latLng) {
        MapView mapView;
        Context context;
        if (latLng != null) {
            this.f29378m = latLng;
        }
        if (servingParam != null) {
            this.f29376k = servingParam;
        }
        EntrancePriorityManager entrancePriorityManager = this.f29380o;
        if (entrancePriorityManager != null && (mapView = this.f29367b) != null && (context = this.f29387v) != null) {
            this.f29391z = false;
            this.f29389x = false;
            entrancePriorityManager.getEntrancePriorities(context, mapView.getMap(), m22778b(), this);
        }
    }

    public void updateDestinationPosition(LatLng latLng) {
        AREntranceManager aREntranceManager = this.f29381p;
        if (aREntranceManager != null) {
            aREntranceManager.updateStartPosition(latLng);
        }
    }

    public Marker getMarker() {
        return this.f29368c;
    }

    public void onOrderStateChanged(int i) {
        AREntranceManager aREntranceManager = this.f29381p;
        if (aREntranceManager != null) {
            aREntranceManager.onOrderStateChanged(i);
        }
    }

    /* renamed from: c */
    private void m22780c() {
        int dp2px = DisplayUtils.dp2px(this.f29387v, 13.0f);
        int dp2px2 = DisplayUtils.dp2px(this.f29387v, 6.0f);
        int dp2px3 = DisplayUtils.dp2px(this.f29387v, 7.0f);
        int dp2px4 = DisplayUtils.dp2px(this.f29387v, 2.0f);
        if (this.f29384s) {
            this.f29375j.setCornersRadius(dp2px, dp2px, dp2px2, dp2px);
            this.f29373h.setCornersRadius(dp2px, dp2px, dp2px2, dp2px);
            this.f29371f.setBackground(this.f29387v.getResources().getDrawable(R.drawable.guide_entrance_bg_shape));
            ((FrameLayout.LayoutParams) this.f29371f.getLayoutParams()).setMargins(dp2px3, 0, 0, dp2px4);
        } else {
            this.f29375j.setCornersRadius(dp2px, dp2px, dp2px, dp2px2);
            this.f29373h.setCornersRadius(dp2px, dp2px, dp2px, dp2px2);
            this.f29371f.setBackground(this.f29387v.getResources().getDrawable(R.drawable.guide_entrance_bg_shape_left));
            ((FrameLayout.LayoutParams) this.f29371f.getLayoutParams()).setMargins(0, 0, dp2px3, dp2px4);
        }
        this.f29375j.invalidate();
        this.f29373h.invalidate();
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x002d, code lost:
        if (r0 != 5) goto L_0x00ca;
     */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m22782d() {
        /*
            r5 = this;
            android.content.Context r0 = r5.f29387v
            r1 = 0
            if (r0 == 0) goto L_0x00ca
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f29375j
            if (r0 == 0) goto L_0x00ca
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f29373h
            if (r0 == 0) goto L_0x00ca
            android.widget.FrameLayout r0 = r5.f29371f
            if (r0 == 0) goto L_0x00ca
            android.widget.TextView r0 = r5.f29374i
            if (r0 != 0) goto L_0x0017
            goto L_0x00ca
        L_0x0017:
            r5.m22780c()
            int r0 = r5.f29379n
            r2 = 8
            if (r0 == 0) goto L_0x00c0
            r3 = 1
            if (r0 == r3) goto L_0x009b
            r4 = 2
            if (r0 == r4) goto L_0x0076
            r4 = 3
            if (r0 == r4) goto L_0x0056
            r4 = 4
            if (r0 == r4) goto L_0x0031
            r4 = 5
            if (r0 == r4) goto L_0x0056
            goto L_0x00ca
        L_0x0031:
            android.view.View r0 = r5.f29372g
            r0.setVisibility(r1)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f29375j
            r0.setVisibility(r2)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f29373h
            r1 = 2131233648(0x7f080b70, float:1.808344E38)
            r0.setImageResource(r1)
            android.widget.TextView r0 = r5.f29374i
            android.view.View r1 = r5.f29370e
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131952762(0x7f13047a, float:1.9541976E38)
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            return r3
        L_0x0056:
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f29375j
            r0.setVisibility(r1)
            android.view.View r0 = r5.f29372g
            r0.setVisibility(r2)
            com.didi.map.global.flow.scene.order.serving.components.guideentrance.StreetViewEntranceManager r0 = r5.f29383r
            if (r0 == 0) goto L_0x0075
            android.view.View r0 = r0.getSmallStreetView()
            if (r0 == 0) goto L_0x0075
            android.graphics.Bitmap r0 = com.didi.common.map.util.MapUtils.getViewBitmap(r0)
            if (r0 == 0) goto L_0x0075
            com.didi.map.global.flow.widget.RoundImageView r1 = r5.f29375j
            r1.setImageBitmap(r0)
        L_0x0075:
            return r3
        L_0x0076:
            android.view.View r0 = r5.f29372g
            r0.setVisibility(r1)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f29375j
            r0.setVisibility(r2)
            android.widget.TextView r0 = r5.f29374i
            android.view.View r1 = r5.f29370e
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131952872(0x7f1304e8, float:1.95422E38)
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f29373h
            r1 = 2131233649(0x7f080b71, float:1.8083441E38)
            r0.setImageResource(r1)
            return r3
        L_0x009b:
            android.view.View r0 = r5.f29372g
            r0.setVisibility(r1)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f29375j
            r0.setVisibility(r2)
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f29373h
            r1 = 2131233645(0x7f080b6d, float:1.8083433E38)
            r0.setImageResource(r1)
            android.widget.TextView r0 = r5.f29374i
            android.view.View r1 = r5.f29370e
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131952868(0x7f1304e4, float:1.954219E38)
            java.lang.String r1 = r1.getString(r2)
            r0.setText(r1)
            return r3
        L_0x00c0:
            com.didi.map.global.flow.widget.RoundImageView r0 = r5.f29375j
            r0.setVisibility(r2)
            android.view.View r0 = r5.f29372g
            r0.setVisibility(r2)
        L_0x00ca:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.scene.order.serving.components.guideentrance.GuideEntranceMarker.m22782d():boolean");
    }

    public boolean isShowed() {
        return this.f29389x;
    }

    public void updateBubbleDirection(boolean z) {
        if (!this.f29389x || this.f29384s != z) {
            this.f29384s = z;
            this.f29390y = true;
            m22783e();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m22783e() {
        if (m22787i()) {
            m22776a(false);
            m22786h();
            if (m22782d() && this.sceneValid) {
                this.f29389x = true;
                m22784f();
            }
        }
    }

    public void setVisible(boolean z) {
        this.f29365A = z;
        Marker marker = this.f29368c;
        if (marker != null) {
            marker.setVisible(z);
        }
    }

    /* renamed from: f */
    private void m22784f() {
        MapView mapView = this.f29367b;
        if (mapView != null && mapView.getMap() != null && LatLngUtils.locateCorrect(this.f29378m)) {
            m22788j();
            Bitmap viewBitmap = MapUtils.getViewBitmap(this.f29370e);
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(this.f29378m).icon(BitmapDescriptorFactory.fromBitmap(viewBitmap)).zIndex(this.f29369d);
            markerOptions.clickable(true).visible(true);
            if (this.f29384s) {
                markerOptions.anchor(0.0f, 1.0f);
            } else {
                markerOptions.anchor(1.0f, 1.0f);
            }
            Marker addMarker = this.f29367b.getMap().addMarker(markerOptions);
            this.f29368c = addMarker;
            addMarker.setVisible(this.f29365A);
            this.f29367b.getMap().addOnMarkerClickListener(this);
            Marker marker = this.f29368c;
            if (marker != null) {
                marker.hideInfoWindow();
            }
        }
    }

    /* renamed from: g */
    private boolean m22785g() {
        ServingParam servingParam = this.f29376k;
        if (servingParam == null || servingParam.getOrderParams() == null || this.f29376k.getOrderParams().srcTag == null) {
            return false;
        }
        return DepartureConstants.SRCTAG_DIDIFENCE_AIRPORT.equals(this.f29376k.getOrderParams().srcTag);
    }

    public void onPrioritySuccess(GuideEntranceResult guideEntranceResult) {
        ServingParam servingParam;
        ServingParam servingParam2;
        if (guideEntranceResult == null || guideEntranceResult.availDisplayTypes == null || guideEntranceResult.availDisplayTypes.size() <= 0) {
            destroy();
            return;
        }
        this.f29391z = true;
        ArrayList<GuideEntranceResult.EntranceType> arrayList = guideEntranceResult.availDisplayTypes;
        this.f29386u = arrayList;
        GuideEntranceResult.EntranceType entranceType = arrayList.get(0);
        if (entranceType != null) {
            this.f29379n = entranceType.type;
        }
        ServingParam servingParam3 = this.f29376k;
        String str = (servingParam3 == null || servingParam3.getOrderParams() == null) ? "" : this.f29376k.getOrderParams().orderId;
        for (GuideEntranceResult.EntranceType next : this.f29386u) {
            int i = next.type;
            if (i != 1) {
                if (i == 2) {
                    this.f29385t = next;
                    if (this.f29382q == null && m22785g()) {
                        m22791m();
                        this.f29382q = RealSceneEntranceManager.getInstance(this.f29376k);
                    }
                } else if (i != 3) {
                    if (i == 4) {
                        m22790l();
                        if (!(this.f29367b == null || (servingParam2 = this.f29376k) == null)) {
                            AREntranceManager aREntranceManager = new AREntranceManager(this.f29387v, servingParam2, true);
                            this.f29381p = aREntranceManager;
                            aREntranceManager.setOutdoor(true);
                        }
                    } else if (i == 5 && !m22785g()) {
                        m22789k();
                        if (!(this.f29376k == null || next == null || next.extendInfo == null)) {
                            this.f29385t = next;
                            this.f29383r = new StreetViewEntranceManager(this.f29387v, StreetVersion.STREET_V2, "", next.extendInfo.streetViewUrl, next.extendInfo.tripId, str, this.f29366B);
                        }
                    }
                } else if (!m22785g()) {
                    m22789k();
                    if (!(this.f29376k == null || next == null || next.extendInfo == null)) {
                        this.f29385t = next;
                        this.f29383r = new StreetViewEntranceManager(this.f29387v, StreetVersion.STREET_V1, "", next.extendInfo.streetViewUrl, next.extendInfo.tripId, str, this.f29366B);
                    }
                }
            } else if (m22785g()) {
                m22790l();
                if (!(this.f29367b == null || (servingParam = this.f29376k) == null)) {
                    AREntranceManager aREntranceManager2 = new AREntranceManager(this.f29387v, servingParam, false);
                    this.f29381p = aREntranceManager2;
                    aREntranceManager2.setOutdoor(false);
                }
            }
        }
        m22783e();
    }

    /* renamed from: h */
    private void m22786h() {
        InfoWindow infoWindow;
        Marker marker = this.f29377l;
        if (marker != null && marker != null && marker.isInfoWindowShown() && (infoWindow = this.f29377l.getInfoWindow()) != null) {
            infoWindow.setPosition(InfoWindow.Position.LEFT_BOTTOM);
        }
    }

    /* renamed from: i */
    private boolean m22787i() {
        GuideEntranceResult.EntranceType entranceType;
        if (!this.f29390y || !this.f29391z) {
            return false;
        }
        int i = this.f29379n;
        if (i == 3) {
            return this.f29388w;
        }
        if (i == 5) {
            GuideEntranceResult.EntranceType entranceType2 = this.f29385t;
            if (entranceType2 == null || entranceType2.extendInfo == null || TextUtils.isEmpty(this.f29385t.extendInfo.streetViewUrl)) {
                return false;
            }
            return true;
        } else if (i != 2 || (entranceType = this.f29385t) == null || entranceType.extendInfo == null || (!TextUtils.isEmpty(this.f29385t.extendInfo.walkGuidePhoto) && !TextUtils.isEmpty(this.f29385t.extendInfo.walkGuideLink))) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: a */
    private void m22776a(boolean z) {
        String str;
        String str2;
        long j;
        AREntranceManager aREntranceManager;
        String str3;
        String str4 = "";
        if (this.f29379n != 1 || (aREntranceManager = this.f29381p) == null) {
            j = -1;
            str2 = str4;
            str = str2;
        } else {
            if (aREntranceManager.arParams != null) {
                str4 = this.f29381p.arParams.get("model");
                str3 = this.f29381p.arParams.get("session");
            } else {
                str3 = str4;
            }
            j = this.f29381p.getLoadTime();
            str = str3;
            str2 = str4;
        }
        long j2 = j;
        ServingParam servingParam = this.f29376k;
        String str5 = (servingParam == null || servingParam.getOrderParams() == null) ? "-1" : this.f29376k.getOrderParams().orderStage == 0 ? "1" : "2";
        if (this.f29367b != null) {
            MapFlowOmegaUtil.trackGuideEntranceShowOrClick(this.f29379n, this.f29376k.getOrderParams().orderId, System.currentTimeMillis(), str2, str, j2, str5, z, this.f29367b.getMapVendor());
        }
    }

    public void onPriorityFail() {
        destroy();
    }

    public void destroy() {
        this.f29388w = false;
        m22791m();
        m22790l();
        m22789k();
        m22788j();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m22788j() {
        MapView mapView = this.f29367b;
        if (mapView != null && mapView.getMap() != null) {
            this.f29367b.getMap().remove(this.f29368c);
            this.f29367b.getMap().removeOnMarkerClickListener(this);
            this.f29368c = null;
        }
    }

    /* renamed from: k */
    private void m22789k() {
        StreetViewEntranceManager streetViewEntranceManager = this.f29383r;
        if (streetViewEntranceManager != null) {
            streetViewEntranceManager.destroy();
            this.f29383r = null;
        }
    }

    /* renamed from: l */
    private void m22790l() {
        AREntranceManager aREntranceManager = this.f29381p;
        if (aREntranceManager != null) {
            aREntranceManager.destroy();
            this.f29381p = null;
        }
    }

    /* renamed from: m */
    private void m22791m() {
        RealSceneEntranceManager realSceneEntranceManager = this.f29382q;
        if (realSceneEntranceManager != null) {
            realSceneEntranceManager.destroy();
            this.f29382q = null;
        }
    }

    public boolean onMarkerClick(Marker marker) {
        if (FastClickUtil.isFastClick()) {
            return false;
        }
        boolean z = (marker == null || this.f29368c == null || TextUtils.isEmpty(marker.getId())) ? false : true;
        Marker marker2 = this.f29377l;
        if (!z || (!marker.getId().equals(this.f29368c.getId()) && (marker2 == null || !marker.getId().equals(marker2.getId())))) {
            return false;
        }
        m22792n();
        m22776a(true);
        return true;
    }

    /* renamed from: n */
    private void m22792n() {
        StreetViewEntranceManager streetViewEntranceManager;
        if (this.f29365A) {
            int i = this.f29379n;
            if (i != 1) {
                if (i == 2) {
                    RealSceneEntranceManager realSceneEntranceManager = this.f29382q;
                    if (realSceneEntranceManager != null) {
                        realSceneEntranceManager.showReal();
                        return;
                    }
                    return;
                } else if (i == 3) {
                    StreetViewEntranceManager streetViewEntranceManager2 = this.f29383r;
                    if (streetViewEntranceManager2 != null) {
                        streetViewEntranceManager2.showBigStreet();
                        return;
                    }
                    return;
                } else if (i != 4) {
                    if (i == 5 && (streetViewEntranceManager = this.f29383r) != null) {
                        streetViewEntranceManager.loadAndShowStreetView();
                        return;
                    }
                    return;
                }
            }
            AREntranceManager aREntranceManager = this.f29381p;
            if (aREntranceManager != null) {
                aREntranceManager.showAR();
            }
        }
    }
}
