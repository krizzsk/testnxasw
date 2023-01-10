package com.didi.map.global.flow.scene.order.serving.carpool;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.text.TextUtils;
import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Marker;
import com.didi.common.map.model.Padding;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.collide.CollideStrategyFactory;
import com.didi.map.global.component.collide.ICollideStrategy;
import com.didi.map.global.component.collide.strategy2.IDMarkerContractV2;
import com.didi.map.global.component.collide.strategy2.RouteInfo;
import com.didi.map.global.component.collide.util.StrategyUtil;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.scene.order.serving.components.MarkerManager;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class SctxWayPointsMgr implements ISctxCarpoolMgr {

    /* renamed from: a */
    private static final String f29242a = "SctxWayPointsMgr";

    /* renamed from: b */
    private IFetchCarpoolInfo f29243b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMarkersCompContract f29244c;

    /* renamed from: d */
    private CarpoolBubble f29245d;

    /* renamed from: e */
    private List<MarkerPassPoint> f29246e;

    /* renamed from: f */
    private ICollideStrategy f29247f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<LatLng> f29248g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Marker f29249h;

    /* renamed from: i */
    private boolean f29250i = true;

    /* renamed from: j */
    private Context f29251j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public Map f29252k;

    /* renamed from: l */
    private MarkerManager f29253l;

    public SctxWayPointsMgr(Context context, MarkerManager markerManager, Map map) {
        this.f29253l = markerManager;
        this.f29252k = map;
        this.f29251j = context;
    }

    public void destroy() {
        ICollideStrategy iCollideStrategy = this.f29247f;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
            this.f29247f = null;
        }
        IMarkersCompContract iMarkersCompContract = this.f29244c;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.destroy();
            this.f29244c = null;
        }
        List<MarkerPassPoint> list = this.f29246e;
        if (list != null) {
            list.clear();
            this.f29246e = null;
        }
        this.f29245d = null;
    }

    public void setCarpoolInfoFetcher(IFetchCarpoolInfo iFetchCarpoolInfo) {
        this.f29243b = iFetchCarpoolInfo;
    }

    /* renamed from: a */
    private void m22698a() {
        if (this.f29247f == null) {
            this.f29247f = CollideStrategyFactory.getCollideStrategyV2(new IDMarkerContractV2() {
                public int getEnableLabelPosition(String str) {
                    return 170;
                }

                public int getHot(String str) {
                    return 0;
                }

                public boolean isCanWork() {
                    return true;
                }

                public boolean isLabelDirectClockwise() {
                    return true;
                }

                public Map getMap() {
                    return SctxWayPointsMgr.this.f29252k;
                }

                public void setLabelDirect(String str, int i) {
                    SystemUtils.log(6, "ccc", str + ", setLabelDirect " + i, (Throwable) null, "com.didi.map.global.flow.scene.order.serving.carpool.SctxWayPointsMgr$1", 92);
                    if (SctxWayPointsMgr.this.f29244c != null) {
                        SctxWayPointsMgr.this.f29244c.updateMarkerLabelDirect(str, i);
                    }
                }

                public int getCurrentLabelPosition(String str) {
                    if (SctxWayPointsMgr.this.f29244c != null) {
                        return SctxWayPointsMgr.this.f29244c.getMarkerLabelDirect(str);
                    }
                    return 128;
                }

                public List<RouteInfo> getDisabledLines() {
                    ArrayList arrayList = new ArrayList();
                    if (SctxWayPointsMgr.this.f29248g != null) {
                        arrayList.add(new RouteInfo(SctxWayPointsMgr.this.f29248g));
                    }
                    return arrayList;
                }

                public List<Rect> getDisabledRect() {
                    ArrayList arrayList = new ArrayList();
                    if (SctxWayPointsMgr.this.f29249h != null && SctxWayPointsMgr.this.f29249h.isVisible()) {
                        arrayList.add(StrategyUtil.getMarkerRect(SctxWayPointsMgr.this.f29252k, SctxWayPointsMgr.this.f29249h, (Padding) null, true));
                    }
                    return arrayList;
                }
            });
        }
        if (this.f29244c == null) {
            MarkersComponent markersComponent = new MarkersComponent();
            this.f29244c = markersComponent;
            markersComponent.create(this.f29251j, this.f29252k);
        }
        if (this.f29245d == null) {
            this.f29245d = new CarpoolBubble();
        }
        if (this.f29246e == null) {
            this.f29246e = new ArrayList();
        }
    }

    /* renamed from: a */
    private void m22699a(List<MarkerPassPoint> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            for (MarkerPassPoint next : list) {
                if (!m22700a(this.f29246e, next)) {
                    if (next.lastOrderEndPoint) {
                        try {
                            this.f29253l.addMarker(MapElementId.ID_MARKER_WAYPOINT, new LatLng((double) next.data.point.lat.floatValue(), (double) next.data.point.lng.floatValue()), true);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else {
                        MarkerModel markerModel = new MarkerModel();
                        markerModel.setMarkerIcon(next.bmp);
                        markerModel.setClickable(false);
                        markerModel.setId(next.markerId);
                        markerModel.setAnchorU(0.5f);
                        markerModel.setAnchorV(0.5f);
                        markerModel.setPoint(new LatLng((double) next.data.point.lat.floatValue(), (double) next.data.point.lng.floatValue()));
                        markerModel.setZOrder(102);
                        if (!TextUtils.isEmpty(next.label)) {
                            markerModel.setLabelDirection(128);
                            markerModel.setAddressName(next.label);
                            markerModel.setLabelZIndex(102);
                            markerModel.setLabelView(this.f29245d);
                        }
                        markerModel.setStrategy(this.f29247f);
                        this.f29244c.addNewMarkerToComponent(markerModel, (MarkersComponent.ImageNetWorkCallback) null);
                    }
                    this.f29246e.add(next);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m22700a(List<MarkerPassPoint> list, MarkerPassPoint markerPassPoint) {
        if (!(CollectionUtil.isEmpty((Collection<?>) this.f29246e) || markerPassPoint == null || markerPassPoint.data == null)) {
            for (MarkerPassPoint next : list) {
                if (!(next == null || next.data == null)) {
                    if (!(next.data.odType == null || markerPassPoint.data.odType == null || !next.data.odType.equals(markerPassPoint.data.odType)) || (next.data.odType == null && markerPassPoint.data.odType == null)) {
                        if (!(((next.data.orderId == null || markerPassPoint.data.orderId == null || !next.data.orderId.equals(markerPassPoint.data.orderId)) && (next.data.orderId != null || markerPassPoint.data.orderId != null)) || next.data.point == null || markerPassPoint.data.point == null || next.data.point.lat == null || markerPassPoint.data.point.lat == null || !next.data.point.lat.equals(markerPassPoint.data.point.lat) || next.data.point.lng == null || markerPassPoint.data.point.lng == null || !next.data.point.lng.equals(markerPassPoint.data.point.lng))) {
                            if ((!(next.label == null || markerPassPoint.label == null || !next.label.equals(markerPassPoint.label)) || (next.label == null && markerPassPoint.label == null)) && next.lastOrderEndPoint == markerPassPoint.lastOrderEndPoint) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    /* renamed from: b */
    private void m22703b(List<MarkerPassPoint> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f29246e)) {
            ArrayList arrayList = new ArrayList();
            for (MarkerPassPoint next : this.f29246e) {
                if (m22700a(list, next)) {
                    arrayList.add(next);
                } else if (next.lastOrderEndPoint) {
                    this.f29253l.removeMarker(MapElementId.ID_MARKER_WAYPOINT);
                } else {
                    this.f29244c.removeMarker(next.markerId);
                }
            }
            this.f29246e.clear();
            this.f29246e = arrayList;
        }
    }

    /* renamed from: b */
    private void m22702b() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f29246e) && this.f29244c != null) {
            for (MarkerPassPoint markerPassPoint : this.f29246e) {
                this.f29244c.removeMarker(markerPassPoint.markerId);
            }
            this.f29246e.clear();
            this.f29246e = new ArrayList();
        }
    }

    public List<IMapElement> getSctxWayPoints() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f29246e) || this.f29244c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MarkerPassPoint markerPassPoint : this.f29246e) {
            List<Marker> markers = this.f29244c.getMarkers(markerPassPoint.markerId);
            if (!CollectionUtil.isEmpty((Collection<?>) markers)) {
                arrayList.addAll(markers);
            }
        }
        return arrayList;
    }

    public void onFinishFetchingCarpoolPoint(boolean z, List<OdPoint> list, List<LatLng> list2, Marker marker, Bitmap bitmap, Bitmap bitmap2) {
        Bitmap bitmap3 = bitmap;
        Bitmap bitmap4 = bitmap2;
        if (this.f29250i) {
            m22698a();
            if (CollectionUtil.isEmpty((Collection<?>) list) && list.size() > 1) {
                DLog.m10773d(f29242a, "onFinishFetchingCarpoolPoint() odPoints: null", new Object[0]);
                m22702b();
            } else if (bitmap4 != null && bitmap3 != null) {
                ArrayList arrayList = new ArrayList();
                for (int i = 0; i < list.size() - 1; i++) {
                    OdPoint odPoint = list.get(i);
                    MarkerPassPoint markerPassPoint = new MarkerPassPoint();
                    markerPassPoint.markerId = odPoint.hashCode() + "id";
                    if (odPoint.odType != null && odPoint.odType.intValue() == 0) {
                        markerPassPoint.bmp = bitmap3;
                    } else if (odPoint.odType != null && odPoint.odType.intValue() == 1) {
                        markerPassPoint.bmp = bitmap4;
                        if (z && odPoint.pointType != null && odPoint.pointType.intValue() == 2) {
                            markerPassPoint.lastOrderEndPoint = true;
                        }
                    } else if (odPoint.odType != null && odPoint.odType.intValue() == 2) {
                        try {
                            markerPassPoint.bmp = BitmapFactory.decodeResource(this.f29251j.getResources(), this.f29253l.getMarkerIconResId(MapElementId.ID_MARKER_ODPOINT));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    markerPassPoint.data = odPoint;
                    arrayList.add(markerPassPoint);
                }
                IFetchCarpoolInfo iFetchCarpoolInfo = this.f29243b;
                if (iFetchCarpoolInfo != null) {
                    List<CarpoolInfo> onFetch = iFetchCarpoolInfo.onFetch();
                    if (CollectionUtil.isEmpty((Collection<?>) onFetch) || CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                        DLog.m10773d(f29242a, "onFinishFetchingCarpoolPoint() infoList: null", new Object[0]);
                    } else {
                        for (int i2 = 0; i2 < onFetch.size(); i2++) {
                            CarpoolInfo carpoolInfo = onFetch.get(i2);
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                MarkerPassPoint markerPassPoint2 = (MarkerPassPoint) arrayList.get(i3);
                                OdPoint odPoint2 = markerPassPoint2.data;
                                if (!(odPoint2 == null || odPoint2.point == null || carpoolInfo == null)) {
                                    LatLng latLng = new LatLng((double) odPoint2.point.lat.floatValue(), (double) odPoint2.point.lng.floatValue());
                                    DLog.m10773d(f29242a, "onFinishFetchingCarpoolPoint() odPoints loop: " + odPoint2, new Object[0]);
                                    DLog.m10773d(f29242a, "onFinishFetchingCarpoolPoint() infoList loop: " + carpoolInfo, new Object[0]);
                                    if (odPoint2.orderId != null && !TextUtils.isEmpty(carpoolInfo.orderId) && odPoint2.orderId.toString().equals(carpoolInfo.orderId) && ((odPoint2.odType == null || odPoint2.odType.intValue() == carpoolInfo.type) && LatLngUtils.locateCorrect(latLng))) {
                                        markerPassPoint2.label = carpoolInfo.msg;
                                    }
                                }
                            }
                        }
                    }
                }
                this.f29248g = list2;
                this.f29249h = marker;
                m22703b((List<MarkerPassPoint>) arrayList);
                m22699a((List<MarkerPassPoint>) arrayList);
            }
        }
    }

    public void setCarpoolShowBubblesEnabled(boolean z) {
        if (!z) {
            destroy();
        }
        this.f29250i = z;
    }

    class MarkerPassPoint {
        public Bitmap bmp;
        public OdPoint data;
        public String label;
        public boolean lastOrderEndPoint;
        public String markerId;

        MarkerPassPoint() {
        }
    }
}
