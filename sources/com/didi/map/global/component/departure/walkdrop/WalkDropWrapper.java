package com.didi.map.global.component.departure.walkdrop;

import android.content.Context;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import com.didi.common.map.Map;
import com.didi.common.map.MapVendor;
import com.didi.common.map.model.BitmapDescriptorFactory;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.MarkerOptions;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.IDepartureCompContract;
import com.didi.map.global.component.departure.apolllo.WalkDropApollo;
import com.didi.map.global.component.departure.model.AddressExtendInfo;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.util.DepartureUtils;
import com.didi.map.global.component.line.excomponent.GuideLine;
import com.didi.map.global.component.line.excomponent.GuideLineParam;
import com.didi.map.global.component.line.pax.walkanddropoff.IWalkAndDropOffLine;
import com.didi.map.global.component.line.pax.walkanddropoff.WalkAndDropOffLineImpl;
import com.didi.map.global.component.line.pax.walkanddropoff.WalkDropOffParam;
import com.didi.map.global.component.line.pax.walkanddropoff.onWalkDropChangeListener;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.routesearchsdk.CallFrom;
import com.taxis99.R;

public class WalkDropWrapper implements IWalkDropWrapper {

    /* renamed from: a */
    private static final String f27655a = "WalkDropWrapper";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f27656b;

    /* renamed from: c */
    private Map f27657c;

    /* renamed from: d */
    private GuideLine f27658d;

    /* renamed from: e */
    private IWalkAndDropOffLine f27659e;

    /* renamed from: f */
    private boolean f27660f;

    /* renamed from: g */
    private boolean f27661g;

    /* renamed from: h */
    private int f27662h;

    /* renamed from: i */
    private Marker f27663i;

    /* renamed from: j */
    private Address f27664j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public DepartureAddress f27665k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public IDepartureCompContract.IDepartureComponentCallback f27666l;

    public WalkDropWrapper(Context context, Map map) {
        this.f27656b = context;
        this.f27657c = map;
        DLog.m10773d(f27655a, "构造", new Object[0]);
    }

    /* renamed from: a */
    private boolean m21858a() {
        Map map;
        if (!WalkDropApollo.Companion.getHms_enable() && (map = this.f27657c) != null && map.getMapVendor() == MapVendor.HUAWEI) {
            DLog.m10773d(f27655a, "huawei not support", new Object[0]);
            return false;
        } else if (!this.f27660f || !WalkDropApollo.Companion.getEnable() || this.f27662h == 1) {
            DLog.m10773d(f27655a, "final not support", new Object[0]);
            return false;
        } else {
            DLog.m10773d(f27655a, "apollo is allow", new Object[0]);
            return true;
        }
    }

    /* renamed from: b */
    private void m21860b() {
        LatLng latLng;
        if (this.f27661g && !m21858a()) {
            this.f27658d = new GuideLine();
            DIDILocation lastKnownLocation = LocationHelper.getLastKnownLocation(this.f27656b);
            if (lastKnownLocation == null) {
                latLng = null;
            } else {
                latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            }
            this.f27658d.setConfigParam(new GuideLineParam(-13386753, latLng, DepartureUtils.getMapCenterPoint(this.f27657c)));
            this.f27658d.create(this.f27656b, this.f27657c);
            this.f27658d.setVisible(!m21858a());
            DLog.m10773d(f27655a, "createGuideLine", new Object[0]);
        }
    }

    /* renamed from: c */
    private void m21862c() {
        if (m21858a()) {
            this.f27659e = new WalkAndDropOffLineImpl();
            WalkDropOffParam walkDropOffParam = new WalkDropOffParam();
            walkDropOffParam.setToken(PaxEnvironment.getInstance().getToken());
            walkDropOffParam.setProductId(PaxEnvironment.getInstance().getProductId());
            walkDropOffParam.setPhoneNum(PaxEnvironment.getInstance().getPhoneNumber());
            walkDropOffParam.setPassengerId(Long.parseLong(PaxEnvironment.getInstance().getUid()));
            walkDropOffParam.setCountryId(PaxEnvironment.getInstance().getCountryCode());
            walkDropOffParam.setAnimate(true);
            walkDropOffParam.setCallFrom(CallFrom.ORDERROUTEAPI_BUBBLE);
            walkDropOffParam.setDropOffLineColor(this.f27656b.getResources().getColor(R.color.map_departure_dropoff_line_color));
            walkDropOffParam.setDropOffLineWidth(6);
            walkDropOffParam.setWalkLineAWidth(6);
            walkDropOffParam.setWalkLineASpace(10.0f);
            walkDropOffParam.setWalkLineAColor(Color.parseColor("#999999"));
            walkDropOffParam.setWalkLineBSpace(20.0f);
            this.f27659e.setConfigParam(walkDropOffParam);
            this.f27659e.create(this.f27656b, this.f27657c);
            this.f27659e.setOnWalkDropChangeListener(new onWalkDropChangeListener() {
                public void onPickPointSnapRoute(LatLng latLng) {
                    if (WalkDropWrapper.this.f27665k != null && WalkDropWrapper.this.f27665k.getZoneType() != 0 && WalkDropWrapper.this.f27665k.getExtendInfo() != null && WalkDropWrapper.this.f27665k.isRecommendPoi() && WalkDropApollo.Companion.getSubtitle_adsorbed() && DDSphericalUtil.computeDistanceBetween(latLng, WalkDropWrapper.this.f27665k.getPosition()) > 11.0d) {
                        String string = WalkDropWrapper.this.f27656b.getResources().getString(R.string.GRider_reveal_Please_go_iCIQ);
                        AddressExtendInfo extendInfo = WalkDropWrapper.this.f27665k.getExtendInfo();
                        extendInfo.setSubNoticeTitle("{\"text\":\"" + string + "\",\"info\":[{\"start\":\"0\",\"length\":\"" + string.length() + "\",\"color\":\"#5DD1AF\",\"bold\":1,\"through\":0,\"link\":\"\"}]}");
                        DLog.m10773d(WalkDropWrapper.f27655a, "onPickPointSnapRoute  update title", new Object[0]);
                        if (WalkDropWrapper.this.f27666l != null) {
                            WalkDropWrapper.this.f27666l.onDepartureAddressChanged(WalkDropWrapper.this.f27665k);
                        }
                    }
                }
            });
            DLog.m10773d(f27655a, "createWalkDropLine", new Object[0]);
        }
    }

    /* renamed from: d */
    private void m21863d() {
        if (m21858a() && this.f27664j != null && this.f27657c != null) {
            MarkerOptions markerOptions = new MarkerOptions();
            markerOptions.position(new LatLng(this.f27664j.getLatitude(), this.f27664j.getLongitude())).icon(BitmapDescriptorFactory.fromBitmap(BitmapFactory.decodeResource(this.f27656b.getResources(), R.drawable.departure_map_icon_destination))).zIndex(100).visible(true);
            this.f27663i = this.f27657c.addMarker(markerOptions);
            DLog.m10773d(f27655a, "addOrderDestMarker", new Object[0]);
        }
    }

    /* renamed from: e */
    private void m21864e() {
        Map map;
        Marker marker = this.f27663i;
        if (marker != null && (map = this.f27657c) != null) {
            map.remove(marker);
            this.f27663i = null;
            DLog.m10773d(f27655a, "removeOrderDestMarker", new Object[0]);
        }
    }

    public void onCameraChange(LatLng latLng) {
        GuideLine guideLine = this.f27658d;
        if (guideLine != null && guideLine.isVisible()) {
            this.f27658d.updateEndPosition(latLng);
        }
    }

    public void onReceiveLocationUpdate(DIDILocation dIDILocation) {
        GuideLine guideLine = this.f27658d;
        if (guideLine != null && dIDILocation != null && guideLine.isVisible()) {
            this.f27658d.updateStartPosition(new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude()));
        }
    }

    public void onMapDragStart() {
        this.f27665k = null;
        DLog.m10773d(f27655a, "onMapDragStart", new Object[0]);
    }

    public void onMapDragEnd() {
        DLog.m10773d(f27655a, "onMapDragEnd", new Object[0]);
    }

    public void onRequestFail() {
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f27659e;
        if (iWalkAndDropOffLine != null) {
            iWalkAndDropOffLine.removeAllLine();
        }
        this.f27665k = null;
        DLog.m10773d(f27655a, "onRequestFail", new Object[0]);
    }

    public void onRspAirport() {
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f27659e;
        if (iWalkAndDropOffLine != null) {
            iWalkAndDropOffLine.removeAllLine();
        }
        DLog.m10773d(f27655a, "onRspAirport", new Object[0]);
    }

    public void onNormalReverseGeo() {
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f27659e;
        if (iWalkAndDropOffLine != null) {
            iWalkAndDropOffLine.removeAllLine();
        }
        DLog.m10773d(f27655a, "onNormalReverseGeo", new Object[0]);
    }

    public void onRequestStart() {
        this.f27665k = null;
        DLog.m10773d(f27655a, "onRequestStart：", new Object[0]);
    }

    public void onNormalAdsorbedOk(LatLng latLng, DepartureAddress departureAddress) {
        IWalkAndDropOffLine iWalkAndDropOffLine;
        if (latLng == null || (iWalkAndDropOffLine = this.f27659e) == null || this.f27664j == null) {
            IWalkAndDropOffLine iWalkAndDropOffLine2 = this.f27659e;
            if (iWalkAndDropOffLine2 != null) {
                iWalkAndDropOffLine2.removeAllLine();
            }
        } else {
            iWalkAndDropOffLine.updateLines(m21857a(latLng), m21857a(new LatLng(this.f27664j.getLatitude(), this.f27664j.getLongitude())));
        }
        DLog.m10773d(f27655a, "onNormalAdsorbedOk：", new Object[0]);
        this.f27665k = departureAddress;
    }

    public void onNormalAdsorbedFail(LatLng latLng) {
        if (latLng == null || this.f27659e == null || this.f27664j == null || !WalkDropApollo.Companion.getDropline_enable()) {
            IWalkAndDropOffLine iWalkAndDropOffLine = this.f27659e;
            if (iWalkAndDropOffLine != null) {
                iWalkAndDropOffLine.removeAllLine();
            }
        } else {
            this.f27659e.updateLines(m21857a(latLng), m21857a(new LatLng(this.f27664j.getLatitude(), this.f27664j.getLongitude())));
        }
        this.f27665k = null;
        DLog.m10773d(f27655a, "onNormalAdsorbedFail：", new Object[0]);
    }

    /* renamed from: a */
    private DoublePoint m21857a(LatLng latLng) {
        return new DoublePoint.Builder().lat(Float.valueOf((float) latLng.latitude)).lng(Float.valueOf((float) latLng.longitude)).dlat(Double.valueOf(latLng.latitude)).dlng(Double.valueOf(latLng.longitude)).build();
    }

    public void setDestPoint(Address address) {
        this.f27664j = address;
        DLog.m10773d(f27655a, "setDestPoint：", new Object[0]);
    }

    public void setGuideLineEnable(boolean z) {
        this.f27661g = z;
        DLog.m10773d(f27655a, "setGuideLineEnable：" + z, new Object[0]);
    }

    public void setWalkDropEnable(boolean z) {
        this.f27660f = z;
        DLog.m10773d(f27655a, "setWalkDropEnable：" + z, new Object[0]);
    }

    public void setSceneType(int i) {
        this.f27662h = i;
        DLog.m10773d(f27655a, "setSceneType：" + i, new Object[0]);
    }

    public void onCreate() {
        DLog.m10773d(f27655a, "onCreate：", new Object[0]);
        m21860b();
        m21862c();
        m21863d();
    }

    public void onDestroy() {
        GuideLine guideLine = this.f27658d;
        if (guideLine != null) {
            guideLine.destroy();
            this.f27658d = null;
        }
        IWalkAndDropOffLine iWalkAndDropOffLine = this.f27659e;
        if (iWalkAndDropOffLine != null) {
            iWalkAndDropOffLine.destroy();
            this.f27659e = null;
        }
        m21864e();
        DLog.m10773d(f27655a, "onDestroy：", new Object[0]);
    }

    public boolean isRecMarkerVisible() {
        if (!m21858a()) {
            return true;
        }
        DLog.m10773d(f27655a, "isRecMarkerVisible : " + WalkDropApollo.Companion.getRecpoint_enable(), new Object[0]);
        return WalkDropApollo.Companion.getRecpoint_enable();
    }

    public void setDepartureCallback(IDepartureCompContract.IDepartureComponentCallback iDepartureComponentCallback) {
        this.f27666l = iDepartureComponentCallback;
    }
}
