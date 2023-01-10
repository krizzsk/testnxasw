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
import com.didi.map.global.component.collide.strategy4.IDMarkerContractV4;
import com.didi.map.global.component.collide.util.StrategyUtil;
import com.didi.map.global.component.markers.IMarkersCompContract;
import com.didi.map.global.component.markers.MarkersComponent;
import com.didi.map.global.component.markers.view.IconLabelMarker;
import com.didi.map.global.component.markers.view.MarkerModel;
import com.didi.map.global.flow.scene.order.serving.components.MarkerManager;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.map.global.flow.utils.MapFlowApolloUtils;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import com.didi.sdk.apm.SystemUtils;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;

public class SctxWayPointsMgrTwo implements ISctxCarpoolMgr {

    /* renamed from: a */
    private static final String f29254a = "SctxWayPointsMgr";

    /* renamed from: b */
    private IFetchCarpoolInfo f29255b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public IMarkersCompContract f29256c;

    /* renamed from: d */
    private CarpoolBubble f29257d;

    /* renamed from: e */
    private List<MarkerPassPoint> f29258e;

    /* renamed from: f */
    private ICollideStrategy f29259f;

    /* renamed from: g */
    private ICollideStrategy f29260g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public List<LatLng> f29261h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Marker f29262i;

    /* renamed from: j */
    private boolean f29263j = true;

    /* renamed from: k */
    private Context f29264k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public Map f29265l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public MarkerManager f29266m;
    protected boolean mEnableTripWaypointCollide;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public HashMap<String, IconLabelMarker> f29267n;

    public SctxWayPointsMgrTwo(Context context, MarkerManager markerManager, Map map) {
        this.f29266m = markerManager;
        this.f29265l = map;
        this.f29264k = context;
        this.f29267n = new HashMap<>();
        this.mEnableTripWaypointCollide = MapFlowApolloUtils.enableTripWaypointCollide();
    }

    public void destroy() {
        ICollideStrategy iCollideStrategy = this.f29259f;
        if (iCollideStrategy != null) {
            iCollideStrategy.onDestroy();
            this.f29259f = null;
        }
        IMarkersCompContract iMarkersCompContract = this.f29256c;
        if (iMarkersCompContract != null) {
            iMarkersCompContract.destroy();
            this.f29256c = null;
        }
        List<MarkerPassPoint> list = this.f29258e;
        if (list != null) {
            list.clear();
            this.f29258e = null;
        }
        this.f29257d = null;
    }

    public void setCarpoolInfoFetcher(IFetchCarpoolInfo iFetchCarpoolInfo) {
        this.f29255b = iFetchCarpoolInfo;
    }

    /* renamed from: a */
    private void m22707a() {
        if (this.f29259f == null) {
            this.f29259f = CollideStrategyFactory.getCollideStrategyV2(new IDMarkerContractV2() {
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
                    return SctxWayPointsMgrTwo.this.f29265l;
                }

                public void setLabelDirect(String str, int i) {
                    SystemUtils.log(6, "ccc", str + ", setLabelDirect " + i, (Throwable) null, "com.didi.map.global.flow.scene.order.serving.carpool.SctxWayPointsMgrTwo$1", 101);
                    if (SctxWayPointsMgrTwo.this.f29256c != null) {
                        SctxWayPointsMgrTwo.this.f29256c.updateMarkerLabelDirect(str, i);
                    }
                }

                public int getCurrentLabelPosition(String str) {
                    if (SctxWayPointsMgrTwo.this.f29256c != null) {
                        return SctxWayPointsMgrTwo.this.f29256c.getMarkerLabelDirect(str);
                    }
                    return 128;
                }

                public List<RouteInfo> getDisabledLines() {
                    ArrayList arrayList = new ArrayList();
                    if (SctxWayPointsMgrTwo.this.f29261h != null) {
                        arrayList.add(new RouteInfo(SctxWayPointsMgrTwo.this.f29261h));
                    }
                    return arrayList;
                }

                public List<Rect> getDisabledRect() {
                    ArrayList arrayList = new ArrayList();
                    if (SctxWayPointsMgrTwo.this.f29262i != null && SctxWayPointsMgrTwo.this.f29262i.isVisible()) {
                        arrayList.add(StrategyUtil.getMarkerRect(SctxWayPointsMgrTwo.this.f29265l, SctxWayPointsMgrTwo.this.f29262i, (Padding) null, true));
                    }
                    return arrayList;
                }
            });
        }
        if (this.f29260g == null) {
            this.f29260g = CollideStrategyFactory.getCollideStrategyV4(new IDMarkerContractV4() {
                public int getEnableLabelPosition(String str) {
                    return 85;
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
                    return SctxWayPointsMgrTwo.this.f29265l;
                }

                public void setLabelDirect(String str, int i) {
                    IMarkersCompContract markersCompContract;
                    SystemUtils.log(6, "ccc", str + ", setLabelDirect " + i, (Throwable) null, "com.didi.map.global.flow.scene.order.serving.carpool.SctxWayPointsMgrTwo$2", 165);
                    if (SctxWayPointsMgrTwo.this.f29266m != null && (markersCompContract = SctxWayPointsMgrTwo.this.f29266m.getMarkersCompContract()) != null) {
                        markersCompContract.updateMarkerLabelDirect(str, i);
                    }
                }

                public int getCurrentLabelPosition(String str) {
                    IMarkersCompContract markersCompContract;
                    if (SctxWayPointsMgrTwo.this.f29266m == null || (markersCompContract = SctxWayPointsMgrTwo.this.f29266m.getMarkersCompContract()) == null) {
                        return 1;
                    }
                    return markersCompContract.getMarkerLabelDirect(str);
                }

                public List<Rect> getDisabledRect(String str) {
                    Marker iconMarker;
                    Marker marker;
                    ArrayList arrayList = new ArrayList();
                    if (SctxWayPointsMgrTwo.this.f29266m != null) {
                        Marker iconMarker2 = SctxWayPointsMgrTwo.this.f29266m.getIconMarker(MapElementId.ID_MARKER_START);
                        if (iconMarker2 != null) {
                            arrayList.add(StrategyUtil.getMarkerRect(SctxWayPointsMgrTwo.this.f29265l, iconMarker2, (Padding) null, true));
                        }
                        Marker labelMarker = SctxWayPointsMgrTwo.this.f29266m.getLabelMarker(MapElementId.ID_MARKER_START);
                        if (labelMarker != null) {
                            arrayList.add(StrategyUtil.getMarkerRect(SctxWayPointsMgrTwo.this.f29265l, labelMarker, (Padding) null, true));
                        }
                        if (str != null && !str.equals(MapElementId.ID_MARKER_WAYPOINT.toString())) {
                            Marker iconMarker3 = SctxWayPointsMgrTwo.this.f29266m.getIconMarker(MapElementId.ID_MARKER_WAYPOINT);
                            if (iconMarker3 != null) {
                                arrayList.add(StrategyUtil.getMarkerRect(SctxWayPointsMgrTwo.this.f29265l, iconMarker3, (Padding) null, true));
                            }
                            Marker labelMarker2 = SctxWayPointsMgrTwo.this.f29266m.getLabelMarker(MapElementId.ID_MARKER_WAYPOINT);
                            if (labelMarker2 != null) {
                                arrayList.add(StrategyUtil.getMarkerRect(SctxWayPointsMgrTwo.this.f29265l, labelMarker2, (Padding) null, true));
                            }
                        }
                        if (SctxWayPointsMgrTwo.this.f29267n != null && SctxWayPointsMgrTwo.this.f29267n.size() > 0) {
                            for (IconLabelMarker iconLabelMarker : SctxWayPointsMgrTwo.this.f29267n.values()) {
                                if (iconLabelMarker.getMarkId() != null && !iconLabelMarker.getMarkId().equals(str)) {
                                    if (!(iconLabelMarker == null || iconLabelMarker.getLabelMarker() == null || (marker = iconLabelMarker.getLabelMarker().getMarker()) == null)) {
                                        arrayList.add(StrategyUtil.getMarkerRect(SctxWayPointsMgrTwo.this.f29265l, marker, (Padding) null, true));
                                    }
                                    if (!(iconLabelMarker == null || (iconMarker = iconLabelMarker.getIconMarker()) == null)) {
                                        arrayList.add(StrategyUtil.getMarkerRect(SctxWayPointsMgrTwo.this.f29265l, iconMarker, (Padding) null, true));
                                    }
                                }
                            }
                        }
                    }
                    return arrayList;
                }
            });
        }
        if (this.f29256c == null) {
            MarkersComponent markersComponent = new MarkersComponent();
            this.f29256c = markersComponent;
            markersComponent.create(this.f29264k, this.f29265l);
        }
        if (this.f29257d == null) {
            this.f29257d = new CarpoolBubble();
        }
        if (this.f29258e == null) {
            this.f29258e = new ArrayList();
        }
    }

    /* renamed from: a */
    private void m22708a(List<MarkerPassPoint> list) {
        IconLabelMarker iconLabelMarker;
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            for (MarkerPassPoint next : list) {
                if (!m22709a(this.f29258e, next)) {
                    if (next.lastOrderEndPoint) {
                        try {
                            LatLng latLng = new LatLng((double) next.data.point.lat.floatValue(), (double) next.data.point.lng.floatValue());
                            if (this.mEnableTripWaypointCollide) {
                                this.f29266m.addMarker(MapElementId.ID_MARKER_WAYPOINT, (String) null, latLng, this.f29260g, true);
                            } else {
                                this.f29266m.addMarker(MapElementId.ID_MARKER_WAYPOINT, latLng, true);
                            }
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } else if (next.isSerialOrder) {
                        try {
                            this.f29266m.setOdPointMarkerIconStyle(true);
                            LatLng latLng2 = new LatLng((double) next.data.point.lat.floatValue(), (double) next.data.point.lng.floatValue());
                            if (this.mEnableTripWaypointCollide) {
                                iconLabelMarker = this.f29266m.addMarker(MapElementId.ID_MARKER_ODPOINT, next.markerId, latLng2, this.f29260g, true);
                            } else {
                                iconLabelMarker = this.f29266m.addMarker(MapElementId.ID_MARKER_ODPOINT, next.markerId, latLng2, (ICollideStrategy) null, true);
                            }
                            this.f29267n.put(next.markerId, iconLabelMarker);
                        } catch (Exception e2) {
                            e2.printStackTrace();
                        }
                    } else {
                        this.f29266m.setOdPointMarkerIconStyle(false);
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
                            markerModel.setLabelView(this.f29257d);
                        }
                        markerModel.setStrategy(this.f29259f);
                        this.f29256c.addNewMarkerToComponent(markerModel, (MarkersComponent.ImageNetWorkCallback) null);
                    }
                    this.f29258e.add(next);
                }
            }
        }
    }

    /* renamed from: a */
    private boolean m22709a(List<MarkerPassPoint> list, MarkerPassPoint markerPassPoint) {
        if (!(CollectionUtil.isEmpty((Collection<?>) this.f29258e) || markerPassPoint == null || markerPassPoint.data == null)) {
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
    private void m22712b(List<MarkerPassPoint> list) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f29258e)) {
            ArrayList arrayList = new ArrayList();
            for (MarkerPassPoint next : this.f29258e) {
                if (m22709a(list, next)) {
                    arrayList.add(next);
                } else if (next.lastOrderEndPoint) {
                    this.f29266m.removeMarker(MapElementId.ID_MARKER_WAYPOINT);
                } else if (next.isSerialOrder) {
                    IconLabelMarker iconLabelMarker = this.f29267n.get(next.markerId);
                    if (iconLabelMarker != null) {
                        this.f29266m.removeMarker(iconLabelMarker.getMarkId());
                        IMarkersCompContract iMarkersCompContract = this.f29256c;
                        if (iMarkersCompContract != null) {
                            iMarkersCompContract.removeMarker(iconLabelMarker.getMarkId());
                        }
                        iconLabelMarker.destory();
                    }
                    this.f29267n.remove(next.markerId);
                } else {
                    this.f29266m.removeMarker(next.markerId);
                    IMarkersCompContract iMarkersCompContract2 = this.f29256c;
                    if (iMarkersCompContract2 != null) {
                        iMarkersCompContract2.removeMarker(next.markerId);
                    }
                }
            }
            this.f29258e.clear();
            this.f29258e = arrayList;
        }
    }

    /* renamed from: b */
    private void m22711b() {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f29258e) && this.f29256c != null) {
            for (MarkerPassPoint next : this.f29258e) {
                if (next.isSerialOrder) {
                    IconLabelMarker iconLabelMarker = this.f29267n.get(next.markerId);
                    if (iconLabelMarker != null) {
                        this.f29266m.removeMarker(iconLabelMarker.getMarkId());
                        IMarkersCompContract iMarkersCompContract = this.f29256c;
                        if (iMarkersCompContract != null) {
                            iMarkersCompContract.removeMarker(iconLabelMarker.getMarkId());
                        }
                        iconLabelMarker.destory();
                    }
                    this.f29267n.remove(next.markerId);
                } else {
                    this.f29266m.removeMarker(next.markerId);
                    IMarkersCompContract iMarkersCompContract2 = this.f29256c;
                    if (iMarkersCompContract2 != null) {
                        iMarkersCompContract2.removeMarker(next.markerId);
                    }
                }
            }
            this.f29258e.clear();
            this.f29258e = new ArrayList();
        }
    }

    public List<IMapElement> getSctxWayPoints() {
        if (CollectionUtil.isEmpty((Collection<?>) this.f29258e) || this.f29256c == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (MarkerPassPoint next : this.f29258e) {
            List<Marker> markers = this.f29256c.getMarkers(next.markerId);
            if (!CollectionUtil.isEmpty((Collection<?>) markers)) {
                arrayList.addAll(markers);
            }
            try {
                List<Marker> markers2 = this.f29266m.getMarkersCompContract().getMarkers(next.markerId);
                if (!CollectionUtil.isEmpty((Collection<?>) markers2)) {
                    arrayList.addAll(markers2);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return arrayList;
    }

    public void onFinishFetchingCarpoolPoint(boolean z, List<OdPoint> list, List<LatLng> list2, Marker marker, Bitmap bitmap, Bitmap bitmap2) {
        boolean z2 = z;
        Bitmap bitmap3 = bitmap;
        Bitmap bitmap4 = bitmap2;
        if (this.f29263j) {
            m22707a();
            if (CollectionUtil.isEmpty((Collection<?>) list) && list.size() > 1) {
                DLog.m10773d(f29254a, "onFinishFetchingCarpoolPoint() odPoints: null", new Object[0]);
                m22711b();
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
                        if (z2 && odPoint.pointType != null && odPoint.pointType.intValue() == 2) {
                            markerPassPoint.lastOrderEndPoint = true;
                        }
                    } else if (odPoint.odType != null && odPoint.odType.intValue() == 2) {
                        try {
                            markerPassPoint.bmp = BitmapFactory.decodeResource(this.f29264k.getResources(), this.f29266m.getMarkerIconResId(MapElementId.ID_MARKER_ODPOINT));
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                    markerPassPoint.data = odPoint;
                    markerPassPoint.isSerialOrder = z2;
                    arrayList.add(markerPassPoint);
                }
                IFetchCarpoolInfo iFetchCarpoolInfo = this.f29255b;
                if (iFetchCarpoolInfo != null) {
                    List<CarpoolInfo> onFetch = iFetchCarpoolInfo.onFetch();
                    if (CollectionUtil.isEmpty((Collection<?>) onFetch) || CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                        DLog.m10773d(f29254a, "onFinishFetchingCarpoolPoint() infoList: null", new Object[0]);
                    } else {
                        for (int i2 = 0; i2 < onFetch.size(); i2++) {
                            CarpoolInfo carpoolInfo = onFetch.get(i2);
                            for (int i3 = 0; i3 < arrayList.size(); i3++) {
                                MarkerPassPoint markerPassPoint2 = (MarkerPassPoint) arrayList.get(i3);
                                OdPoint odPoint2 = markerPassPoint2.data;
                                if (!(odPoint2 == null || odPoint2.point == null || carpoolInfo == null)) {
                                    LatLng latLng = new LatLng((double) odPoint2.point.lat.floatValue(), (double) odPoint2.point.lng.floatValue());
                                    DLog.m10773d(f29254a, "onFinishFetchingCarpoolPoint() odPoints loop: " + odPoint2, new Object[0]);
                                    DLog.m10773d(f29254a, "onFinishFetchingCarpoolPoint() infoList loop: " + carpoolInfo, new Object[0]);
                                    if (odPoint2.orderId != null && !TextUtils.isEmpty(carpoolInfo.orderId) && odPoint2.orderId.toString().equals(carpoolInfo.orderId) && ((odPoint2.odType == null || odPoint2.odType.intValue() == carpoolInfo.type) && LatLngUtils.locateCorrect(latLng))) {
                                        markerPassPoint2.label = carpoolInfo.msg;
                                    }
                                }
                            }
                        }
                    }
                }
                this.f29261h = list2;
                this.f29262i = marker;
                m22712b((List<MarkerPassPoint>) arrayList);
                m22708a((List<MarkerPassPoint>) arrayList);
            }
        }
    }

    public void setCarpoolShowBubblesEnabled(boolean z) {
        if (!z) {
            destroy();
        }
        this.f29263j = z;
    }

    class MarkerPassPoint {
        public Bitmap bmp;
        public OdPoint data;
        public boolean isSerialOrder;
        public String label;
        public boolean lastOrderEndPoint;
        public String markerId;

        MarkerPassPoint() {
        }
    }
}
