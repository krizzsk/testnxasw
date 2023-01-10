package com.didi.map.global.component.dropoff.core;

import android.content.Context;
import com.didi.common.map.Map;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.dropoff.DropOffCompParam;
import com.didi.map.global.component.dropoff.core.DropOffContract;
import com.didi.map.global.component.dropoff.data.DropOffDataTask;
import com.didi.map.global.component.dropoff.data.DropOffDataTaskParam;
import com.didi.map.global.component.dropoff.data.IDropOffDataTask;
import com.didi.map.global.component.dropoff.model.DropOffAddress;
import com.didi.map.global.component.dropoff.model.DropOffAddressExtendInfo;
import com.didi.map.global.component.dropoff.model.DropOffLocationInfo;
import com.didi.map.global.component.dropoff.util.DropOffAddressUtils;
import com.didi.map.global.component.dropoff.util.DropOffOmegaTracker;
import com.didi.map.global.component.dropoff.util.DropOffUtils;
import com.didi.map.global.component.recmarker.model.RecPoint;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.destpoi.DestPoiReverseInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class DropOffPresenter implements DropOffContract.Presenter, IDropOffDataTask.TaskCallback {

    /* renamed from: a */
    private Context f27737a;

    /* renamed from: b */
    private Map f27738b;

    /* renamed from: c */
    private DropOffContract.View f27739c;

    /* renamed from: d */
    private DropOffCompParam f27740d;

    /* renamed from: e */
    private IDropOffDataTask f27741e;

    /* renamed from: f */
    private int f27742f;

    /* renamed from: g */
    private DropOffDataTaskParam f27743g;

    /* renamed from: h */
    private DropOffLocationInfo f27744h;

    /* renamed from: i */
    private DestPoiReverseInfo f27745i;

    /* renamed from: j */
    private List<RpcPoi> f27746j;

    /* renamed from: k */
    private RpcPoi f27747k;

    /* renamed from: l */
    private DropOffAddress f27748l;

    /* renamed from: m */
    private boolean f27749m = true;

    /* renamed from: n */
    private int f27750n;

    /* renamed from: o */
    private final int f27751o = 1;

    public DropOffPresenter(DropOffContract.View view, DropOffCompParam dropOffCompParam) {
        this.f27739c = view;
        this.f27740d = dropOffCompParam;
        DropOffLocationInfo locationInfo = dropOffCompParam.getLocationInfo();
        this.f27744h = locationInfo;
        if (locationInfo.sugPoi != null) {
            this.f27750n = this.f27744h.sugPoi.operationType;
        }
    }

    public void setContext(Context context, Map map) {
        this.f27737a = context;
        this.f27738b = map;
    }

    public void getDiscountData() {
        DropOffAddress dropOffAddress = new DropOffAddress();
        dropOffAddress.setAddress(this.f27744h.sugPoi);
        if (this.f27744h.extendInfo != null) {
            DropOffAddressExtendInfo dropOffAddressExtendInfo = new DropOffAddressExtendInfo();
            dropOffAddressExtendInfo.setBubbleText(this.f27744h.extendInfo.title_tip);
            dropOffAddressExtendInfo.setMainTitle(this.f27744h.extendInfo.mainTitleDesc);
            dropOffAddressExtendInfo.setSubTitle(this.f27744h.extendInfo.subTitleDesc);
            dropOffAddress.setExtendInfo(dropOffAddressExtendInfo);
        }
        this.f27748l = dropOffAddress;
        this.f27739c.showCardView(dropOffAddress);
        this.f27739c.refreshPinView(this.f27748l);
        this.f27739c.onAddressFetchResult(true, this.f27748l);
    }

    public void startDataTask(DropOffLocationInfo dropOffLocationInfo, boolean z) {
        int i;
        m21903b();
        this.f27744h = dropOffLocationInfo;
        if (z) {
            i = 1;
        } else {
            i = this.f27750n;
        }
        this.f27750n = i;
        int i2 = this.f27742f + 1;
        this.f27742f = i2;
        DropOffDataTaskParam build = new DropOffDataTaskParam.Builder(i2, this).mapType(m21901a()).userOperationType(String.valueOf(this.f27750n)).locationInfo(dropOffLocationInfo).reqCallerId(this.f27740d.getReqCallerId()).build();
        this.f27743g = build;
        DropOffDataTask dropOffDataTask = new DropOffDataTask(this.f27737a, build);
        this.f27741e = dropOffDataTask;
        dropOffDataTask.start();
    }

    public RpcPoi getAdsorptionPoi() {
        return this.f27747k;
    }

    public List<RpcPoi> getReconmmendRpcPois() {
        return this.f27746j;
    }

    /* renamed from: a */
    private String m21901a() {
        Map map = this.f27738b;
        return (map == null || map.getMapVendor() == null) ? "gmap" : this.f27738b.getMapVendor().toString();
    }

    /* renamed from: b */
    private void m21903b() {
        IDropOffDataTask iDropOffDataTask = this.f27741e;
        if (iDropOffDataTask != null) {
            iDropOffDataTask.stop();
        }
    }

    public void onDataStart() {
        DropOffContract.View view;
        if (this.f27742f == this.f27741e.getId() && (view = this.f27739c) != null) {
            view.onDataLoading();
        }
    }

    public void onDataFailed() {
        if (this.f27742f == this.f27741e.getId() && this.f27739c != null) {
            this.f27747k = null;
            this.f27746j = null;
            if (this.f27748l == null) {
                DropOffAddress dropOffAddress = new DropOffAddress();
                dropOffAddress.setAddress(this.f27744h.sugPoi);
                this.f27748l = dropOffAddress;
                DropOffUtils.LOGD(" first request failed ");
            } else {
                DropOffAddress dropOffAddress2 = new DropOffAddress();
                Address clone = this.f27748l.getAddress().clone();
                LatLng mapCenterPoint = DropOffUtils.getMapCenterPoint(this.f27738b);
                clone.latitude = mapCenterPoint.latitude;
                clone.longitude = mapCenterPoint.longitude;
                clone.displayName = this.f27737a.getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                dropOffAddress2.setAddress(clone);
                this.f27748l = dropOffAddress2;
                DropOffUtils.LOGD(" map drag request failed ");
            }
            this.f27739c.showCardView(this.f27748l);
            this.f27739c.refreshPinView(this.f27748l);
            this.f27739c.onAddressFetchResult(false, this.f27748l);
        }
    }

    public void onDataSuccess(DestPoiReverseInfo destPoiReverseInfo) {
        if (this.f27742f == this.f27741e.getId() && this.f27739c != null) {
            m21902a(destPoiReverseInfo);
        }
    }

    /* renamed from: a */
    private void m21902a(DestPoiReverseInfo destPoiReverseInfo) {
        if (destPoiReverseInfo == null) {
            onDataFailed();
            return;
        }
        DropOffUtils.LOGD(" request successful ");
        this.f27745i = destPoiReverseInfo;
        ArrayList<RpcPoi> arrayList = destPoiReverseInfo.recEndPoints;
        this.f27746j = arrayList;
        this.f27747k = DropOffAddressUtils.findRecAbsorbPoi(arrayList);
        DropOffUtils.LOGD(" adsorption poi = " + this.f27747k);
        RecPoint recPoint = null;
        RpcPoi rpcPoi = this.f27747k;
        if (rpcPoi != null) {
            recPoint = DropOffAddressUtils.getRecPointList(Arrays.asList(new RpcPoi[]{rpcPoi})).get(0);
        }
        this.f27739c.showReconmmnedMarkers(DropOffAddressUtils.getRecPointList(this.f27746j), recPoint);
        DropOffAddress a = m21900a(this.f27747k);
        this.f27748l = a;
        if (a != null) {
            this.f27739c.showCardView(a);
        }
        this.f27739c.refreshPinView(this.f27748l);
        this.f27739c.onAddressFetchResult(true, this.f27748l);
        if (this.f27749m) {
            DropOffOmegaTracker.trackPageShow(this.f27744h, this.f27746j, this.f27747k, this.f27750n, this.f27745i.searchId);
            this.f27749m = false;
        }
    }

    /* renamed from: a */
    private DropOffAddress m21900a(RpcPoi rpcPoi) {
        int i = 0;
        boolean z = rpcPoi != null;
        if (this.f27745i != null && (rpcPoi == null || !LatLngUtils.locateCorrect(rpcPoi.base_info.lat, rpcPoi.base_info.lng))) {
            ArrayList<RpcPoi> arrayList = this.f27745i.result;
            if (!CollectionUtil.isEmpty((Collection<?>) arrayList)) {
                rpcPoi = arrayList.get(0);
                z = false;
            }
        }
        if (rpcPoi == null) {
            return null;
        }
        if (this.f27745i.recEndPoints != null) {
            i = this.f27745i.recEndPoints.size();
        }
        DestPoiReverseInfo destPoiReverseInfo = this.f27745i;
        return DropOffAddressUtils.createDropOffAddress(rpcPoi, z, i, destPoiReverseInfo != null ? destPoiReverseInfo.language : "", this.f27750n);
    }

    public RpcPoi getNeareatReconmmendPoi(LatLng latLng) {
        RpcPoi findNearestPoi = DropOffAddressUtils.findNearestPoi(latLng, this.f27746j);
        this.f27747k = findNearestPoi;
        return findNearestPoi;
    }

    public DropOffAddress getDropOffAddress(RpcPoi rpcPoi) {
        DropOffAddress a = m21900a(rpcPoi);
        this.f27748l = a;
        return a;
    }

    public void destroy() {
        m21903b();
        this.f27741e = null;
        this.f27745i = null;
        this.f27748l = null;
        this.f27746j = null;
        this.f27747k = null;
    }
}
