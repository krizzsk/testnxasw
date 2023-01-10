package com.didi.map.global.component.departure.canoe.reverse;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.LatLngUtils;
import com.didi.map.global.component.departure.canoe.reverse.ReverseTaskParam;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.map.global.component.departure.model.DepartureLocationInfo;
import com.didi.map.global.component.departure.util.DepartureUtils;
import com.didi.map.global.model.location.LocationHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p174dp.locsdk.Utils;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.poi.ReverseStationsInfo;
import com.yanzhenjie.permission.runtime.Permission;

public class DepartureReverseManager implements ReverseTaskCallback {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f27233a;

    /* renamed from: b */
    private final int f27234b = 1;

    /* renamed from: c */
    private int f27235c;

    /* renamed from: d */
    private ReverseTask f27236d;

    /* renamed from: e */
    private ReverseTaskParam f27237e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public DepartureLocationInfo f27238f;

    /* renamed from: g */
    private IReverseCallback f27239g;

    /* renamed from: h */
    private DepartureAddress f27240h;

    /* renamed from: i */
    private ReverseStationsInfo f27241i;

    /* renamed from: j */
    private boolean f27242j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f27243k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public LatLng f27244l;

    /* renamed from: m */
    private final int f27245m = 30;

    /* renamed from: n */
    private DIDILocationListener f27246n = new DIDILocationListener() {
        public void onLocationError(int i, ErrInfo errInfo) {
        }

        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (dIDILocation != null && !DepartureReverseManager.this.f27243k) {
                if (DepartureReverseManager.this.f27233a == null || (DepartureReverseManager.isLocationPermissionGranted(DepartureReverseManager.this.f27233a) && !DepartureReverseManager.isSystemLocationOff(DepartureReverseManager.this.f27233a))) {
                    LatLng latLng = new LatLng(dIDILocation.getLatitude(), dIDILocation.getLongitude());
                    if (LatLngUtils.locateCorrect(latLng)) {
                        if (DepartureReverseManager.this.f27238f == null) {
                            DepartureLocationInfo unused = DepartureReverseManager.this.f27238f = new DepartureLocationInfo((LatLng) null, (Address) null, "wgs84");
                        }
                        if (DepartureReverseManager.this.f27244l == null || DepartureReverseManager.this.m21533a(latLng)) {
                            DepartureReverseManager.this.f27238f.latLng = latLng;
                            DepartureReverseManager.this.m21532a();
                        }
                        LatLng unused2 = DepartureReverseManager.this.f27244l = latLng;
                    }
                }
            }
        }
    };

    public DepartureReverseManager(Context context, IReverseCallback iReverseCallback) {
        this.f27233a = context;
        this.f27239g = iReverseCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m21533a(LatLng latLng) {
        return ((int) DDSphericalUtil.computeDistanceBetween(this.f27244l, latLng)) > 30;
    }

    public void reverseForce() {
        LatLng latLng;
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.f27233a).getLastKnownLocation();
        if (lastKnownLocation != null) {
            latLng = new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
            if (!LatLngUtils.locateCorrect(latLng)) {
                IReverseCallback iReverseCallback = this.f27239g;
                if (iReverseCallback != null) {
                    iReverseCallback.onReverseFailed();
                    return;
                }
                return;
            }
        } else {
            latLng = null;
        }
        if (this.f27238f == null) {
            this.f27238f = new DepartureLocationInfo((LatLng) null, (Address) null, "wgs84");
        }
        this.f27238f.latLng = latLng;
        m21532a();
    }

    public void reverse() {
        if (!this.f27242j) {
            LocationHelper.registerListener(this.f27233a, DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY, this.f27246n);
            this.f27242j = true;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m21532a() {
        m21540c();
        int i = this.f27235c + 1;
        this.f27235c = i;
        ReverseTaskParam build = new ReverseTaskParam.Builder(i, this).mapType("gmap").locationInfo(this.f27238f).reqCallerId(CallFrom.HOME_PAGE_DRAG).build();
        this.f27237e = build;
        ReverseTask reverseTask = new ReverseTask(this.f27233a, build);
        this.f27236d = reverseTask;
        reverseTask.start();
    }

    public void onDataStart() {
        IReverseCallback iReverseCallback;
        if (this.f27236d.getId() == this.f27235c && (iReverseCallback = this.f27239g) != null) {
            iReverseCallback.onLoading();
        }
    }

    public void onDataFailed(int i) {
        IReverseCallback iReverseCallback;
        if (this.f27236d.getId() == this.f27235c && (iReverseCallback = this.f27239g) != null) {
            iReverseCallback.onReverseFailed();
        }
    }

    public void onDataSuccess(ReverseStationsInfo reverseStationsInfo) {
        if (this.f27236d.getId() == this.f27235c && this.f27239g != null) {
            this.f27241i = reverseStationsInfo;
            DepartureAddress b = m21538b();
            this.f27240h = b;
            if (b == null) {
                this.f27239g.onReverseFailed();
                return;
            }
            DLog.m36225d("address = " + this.f27240h);
            this.f27239g.onReverseSuccess(this.f27240h);
        }
    }

    /* renamed from: b */
    private DepartureAddress m21538b() {
        if (this.f27241i == null) {
            return null;
        }
        DepartureAddress departureAddress = new DepartureAddress();
        RpcPoi departureAddress2 = this.f27241i.getDepartureAddress();
        boolean z = false;
        departureAddress.setRecommendPoi(false);
        if (departureAddress2 != null) {
            departureAddress.setAddress(DepartureUtils.getAddressByRpcPoi(departureAddress2, false, this.f27241i.language, 1));
            if (departureAddress2.base_info != null) {
                departureAddress.setIsAirPortPickUpPoint(departureAddress2.base_info.isAirPortPickUpPoint);
                departureAddress.setCountryId(departureAddress2.base_info.countryId);
                departureAddress.setCountryCode(departureAddress2.base_info.countryCode);
            }
            if (departureAddress2.extend_info != null) {
                departureAddress.setPickIconUrl(departureAddress2.extend_info.pickIconUrl);
                departureAddress.setEta(departureAddress2.extend_info.eta);
                departureAddress.setStartParkingProperty(departureAddress2.extend_info.startParkingProperty);
                if (departureAddress2.extend_info.pictureStyle != 1) {
                    z = true;
                }
                departureAddress.setShowRealPicInXpanel(z);
            }
        }
        return departureAddress;
    }

    /* renamed from: c */
    private void m21540c() {
        ReverseTask reverseTask = this.f27236d;
        if (reverseTask != null) {
            reverseTask.stop();
        }
    }

    public void destroy() {
        LocationHelper.unRegisterListener(this.f27233a, this.f27246n);
        this.f27246n = null;
        this.f27242j = false;
        this.f27243k = true;
        ReverseTask reverseTask = this.f27236d;
        if (reverseTask != null) {
            reverseTask.destroy();
        }
        this.f27236d = null;
        this.f27235c = 0;
        this.f27241i = null;
        this.f27233a = null;
    }

    public static boolean isLocationPermissionGranted(Context context) {
        return Utils.checkSystemPermission(context, Permission.ACCESS_FINE_LOCATION) == 0 || Utils.checkSystemPermission(context, Permission.ACCESS_COARSE_LOCATION) == 0;
    }

    public static boolean isSystemLocationOff(Context context) {
        return DIDILocationManager.getInstance(context).isLocationSwitchOff();
    }
}
