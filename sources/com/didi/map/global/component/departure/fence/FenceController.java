package com.didi.map.global.component.departure.fence;

import com.didi.common.map.Map;
import com.didi.common.map.internal.IMapElement;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.model.Polygon;
import com.didi.common.map.model.PolygonOptions;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.common.map.util.PolygonUtil;
import com.didi.map.global.component.departure.DepartureConstants;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureFenceOptions;
import com.didi.map.global.component.departure.util.DepartureUtils;
import com.didi.map.global.component.departure.util.FenceUtils;
import com.sdk.poibase.model.poi.AroundFenceInfo;
import com.sdk.poibase.model.poi.FenceInfo;
import com.sdk.poibase.model.poi.FenceLatLng;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

public class FenceController {

    /* renamed from: a */
    private static final String f27402a = "FenceController";

    /* renamed from: b */
    private Map f27403b;

    /* renamed from: c */
    private IFence f27404c;

    /* renamed from: d */
    private DepartureAddress f27405d;

    /* renamed from: e */
    private DepartureFenceOptions f27406e;

    /* renamed from: f */
    private int f27407f = DepartureConstants.FENCE_FILL_COLOR;

    /* renamed from: g */
    private int f27408g = DepartureConstants.FENCE_STROKE_COLOR;

    /* renamed from: h */
    private int f27409h = 2;

    /* renamed from: i */
    private int f27410i = DepartureConstants.NO_PARKING_FENCE_FILL_COLOR;

    /* renamed from: j */
    private int f27411j = DepartureConstants.NO_PARKING_FENCE_STROKE_COLOR;

    /* renamed from: k */
    private int f27412k = 2;

    public FenceController(Map map, DepartureFenceOptions departureFenceOptions) {
        this.f27403b = map;
        this.f27406e = departureFenceOptions;
    }

    public void showFence(DepartureAddress departureAddress) {
        removeFence();
        if (departureAddress == null) {
            this.f27405d = null;
            return;
        }
        FenceInfo fenceInfo = departureAddress.getFenceInfo();
        if (fenceInfo == null || fenceInfo.drawFence == 0 || CollectionUtil.isEmpty((Collection<?>) fenceInfo.polygon)) {
            m21748a("FenceController.showFence addFence fail, return fenceInfo=" + fenceInfo);
            this.f27405d = null;
            return;
        }
        this.f27405d = departureAddress;
        m21748a("FenceController.showFence addFence ok , " + fenceInfo);
        int i = 1;
        if (fenceInfo.fenceType != 1) {
            i = departureAddress.getZoneType();
        }
        Fence fence = new Fence(m21746a(fenceInfo.polygon, i), DepartureConstants.FENCE_TAG);
        this.f27404c = fence;
        fence.addToMap(this.f27403b);
    }

    public void removeFence() {
        this.f27405d = null;
        IFence iFence = this.f27404c;
        if (iFence != null) {
            iFence.remove();
            DLog.m10773d(f27402a, "删除围栏" + this.f27404c.hashCode(), new Object[0]);
            this.f27404c = null;
        }
    }

    public void showAroundFenceList(ArrayList<AroundFenceInfo> arrayList) {
        removeAroundFenceList();
        if (arrayList != null && !arrayList.isEmpty() && this.f27403b != null) {
            Iterator<AroundFenceInfo> it = arrayList.iterator();
            while (it.hasNext()) {
                AroundFenceInfo next = it.next();
                if (next.polygon != null && !next.polygon.isEmpty()) {
                    PolygonOptions polygonOptions = new PolygonOptions();
                    for (FenceLatLng next2 : next.polygon) {
                        polygonOptions.add(new LatLng(next2.lat, next2.lng));
                    }
                    polygonOptions.setPolygonPatternType(0);
                    polygonOptions.fillColor(this.f27410i).strokeColor(this.f27411j).strokeWidth((float) DisplayUtils.dp2px(this.f27403b.getContext(), (float) this.f27412k));
                    m21748a("FenceController.showAroundFenceList ok");
                    this.f27403b.addPolygon(DepartureConstants.NO_PARKING_FENCE_TAG, polygonOptions).setData(next.fenceId);
                }
            }
        }
    }

    public void removeAroundFenceList() {
        Map map = this.f27403b;
        if (map != null) {
            map.removeElementGroupByTag(DepartureConstants.NO_PARKING_FENCE_TAG);
        }
    }

    public int isInFence(LatLng latLng) {
        boolean z;
        if (latLng == null) {
            return 2;
        }
        FenceInfo fenceInfo = getFenceInfo();
        boolean z2 = false;
        if (fenceInfo != null) {
            z = FenceUtils.positionIsInFence(this.f27403b, fenceInfo, latLng);
            if (z) {
                return fenceInfo.fenceType;
            }
        } else {
            z = false;
        }
        if (z) {
            return 2;
        }
        if (isInAroundFence(latLng) != null) {
            z2 = true;
        }
        return z2 ? 3 : 2;
    }

    public String isInAroundFence(LatLng latLng) {
        ArrayList<IMapElement> elementGroup;
        Map map = this.f27403b;
        if (map == null || latLng == null || (elementGroup = map.getElementGroup(DepartureConstants.NO_PARKING_FENCE_TAG)) == null || elementGroup.isEmpty()) {
            return null;
        }
        Iterator<IMapElement> it = elementGroup.iterator();
        while (it.hasNext()) {
            IMapElement next = it.next();
            if (next instanceof Polygon) {
                Polygon polygon = (Polygon) next;
                ArrayList arrayList = new ArrayList();
                for (LatLng next2 : polygon.getBounderPoints()) {
                    arrayList.add(new LatLng(next2.latitude, next2.longitude));
                }
                if (PolygonUtil.contains(this.f27403b, (List<LatLng>) arrayList, new LatLng(latLng.latitude, latLng.longitude))) {
                    return (String) polygon.getData();
                }
            }
        }
        return null;
    }

    public int getFenceType() {
        return getFenceType(DepartureUtils.getMapCenterPoint(this.f27403b));
    }

    public int getFenceType(LatLng latLng) {
        DepartureAddress departureAddress = this.f27405d;
        int zoneType = departureAddress != null ? departureAddress.getZoneType() : 2;
        if (zoneType == 2 && isInAroundFence(latLng) != null) {
            zoneType = 1;
        }
        m21748a("FenceController.getFenceType zoneType=" + zoneType);
        return zoneType;
    }

    public FenceInfo getFenceInfo() {
        DepartureAddress departureAddress = this.f27405d;
        if (departureAddress != null) {
            return departureAddress.getFenceInfo();
        }
        return null;
    }

    /* renamed from: a */
    private FenceOptions m21746a(List<FenceLatLng> list, int i) {
        if (this.f27403b == null) {
            return null;
        }
        FenceOptions fenceOptions = new FenceOptions();
        ArrayList arrayList = new ArrayList();
        m21747a();
        arrayList.add(FenceUtils.convert2FencePolygon(list));
        fenceOptions.setFences(arrayList);
        fenceOptions.setLimitZoom(13.0d);
        if (i == 0) {
            fenceOptions.setFillColor(this.f27407f);
            fenceOptions.setStrokeColor(this.f27408g);
            fenceOptions.setStrokeWidth((float) DisplayUtils.dp2px(this.f27403b.getContext(), (float) this.f27409h));
        } else if (i == 1) {
            fenceOptions.setFillColor(this.f27410i);
            fenceOptions.setStrokeColor(this.f27411j);
            fenceOptions.setStrokeWidth((float) DisplayUtils.dp2px(this.f27403b.getContext(), (float) this.f27412k));
        }
        return fenceOptions;
    }

    /* renamed from: a */
    private void m21747a() {
        DepartureFenceOptions departureFenceOptions = this.f27406e;
        if (departureFenceOptions != null) {
            if (departureFenceOptions.fenceFillColor != 0) {
                this.f27407f = this.f27406e.fenceFillColor;
            }
            if (this.f27406e.fenceStrokeColor != 0) {
                this.f27408g = this.f27406e.fenceStrokeColor;
            }
            if (this.f27406e.fenceStrokeWidth != 0) {
                this.f27409h = this.f27406e.fenceStrokeWidth;
            }
            if (this.f27406e.noParkingFenceFillColor != 0) {
                this.f27410i = this.f27406e.noParkingFenceFillColor;
            }
            if (this.f27406e.noParkingFenceStrokeColor != 0) {
                this.f27411j = this.f27406e.noParkingFenceStrokeColor;
            }
            if (this.f27406e.noParkingFenceStrokeWidth != 0) {
                this.f27412k = this.f27406e.noParkingFenceStrokeWidth;
            }
        }
    }

    /* renamed from: a */
    private void m21748a(String str) {
        DLog.m10773d("DepartureCompDebug", "FenceController: " + str, new Object[0]);
    }

    public void setFenceVisible(boolean z) {
        IFence iFence = this.f27404c;
        if (iFence != null) {
            iFence.setFenceVisible(z);
        }
        Map map = this.f27403b;
        if (map != null) {
            map.setGroupElementVisible(DepartureConstants.NO_PARKING_FENCE_TAG, z);
        }
    }
}
