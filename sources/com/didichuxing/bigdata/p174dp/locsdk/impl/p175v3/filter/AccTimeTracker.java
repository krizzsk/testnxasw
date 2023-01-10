package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.filter;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.component.common.net.CarServerParam;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.filter.AccTimeTracker */
public class AccTimeTracker implements IAccTimeTracker {

    /* renamed from: a */
    private static final String f48632a = "AccTimeTracker| ";

    /* renamed from: b */
    private static final int f48633b = 60000;

    /* renamed from: c */
    private static final int f48634c = 1000;

    /* renamed from: d */
    private Context f48635d;

    /* renamed from: e */
    private boolean f48636e = false;

    /* renamed from: f */
    private List<AccTimeLocModel> f48637f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Handler f48638g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public long f48639h = -1;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public final Runnable f48640i = new Runnable() {
        public void run() {
            if (AccTimeTracker.this.f48639h < 0) {
                long unused = AccTimeTracker.this.f48639h = System.currentTimeMillis();
            }
            long currentTimeMillis = System.currentTimeMillis();
            if (currentTimeMillis - AccTimeTracker.this.f48639h >= 60000) {
                long unused2 = AccTimeTracker.this.f48639h = currentTimeMillis;
                AccTimeTracker.this.m36487a();
            }
            if (AccTimeTracker.this.f48638g != null) {
                AccTimeTracker.this.f48638g.postDelayed(AccTimeTracker.this.f48640i, 1000);
            }
        }
    };

    public AccTimeTracker(Context context) {
        this.f48635d = context;
        this.f48637f = new ArrayList();
        this.f48638g = new Handler(Looper.getMainLooper());
    }

    public void startTracking() {
        if (AccTimeFilterHelper.getInstance().shouldTrack() && !this.f48636e) {
            this.f48636e = true;
            Handler handler = this.f48638g;
            if (handler != null) {
                handler.post(this.f48640i);
            }
            DLog.m36225d("AccTimeTracker| start tracking");
        }
    }

    public void stopTracking() {
        if (AccTimeFilterHelper.getInstance().shouldTrack() && this.f48636e) {
            this.f48636e = false;
            Handler handler = this.f48638g;
            if (handler != null) {
                handler.removeCallbacks(this.f48640i);
            }
            List<AccTimeLocModel> list = this.f48637f;
            if (list != null) {
                list.clear();
            }
            DLog.m36225d("AccTimeTracker| stop tracking");
        }
    }

    public void updateNotifiedLocation(DIDILocation dIDILocation, String str) {
        Handler handler;
        if (AccTimeFilterHelper.getInstance().shouldTrack() && (handler = this.f48638g) != null) {
            handler.post(new Runnable(dIDILocation, str) {
                public final /* synthetic */ DIDILocation f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    AccTimeTracker.this.m36488a(this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m36488a(DIDILocation dIDILocation, String str) {
        if (dIDILocation != null) {
            AccTimeLocModel accTimeLocModel = new AccTimeLocModel();
            accTimeLocModel.lat = dIDILocation.getLatitude();
            accTimeLocModel.lng = dIDILocation.getLongitude();
            accTimeLocModel.timestampProduce = dIDILocation.getLocalTime();
            accTimeLocModel.timestampDriver = System.currentTimeMillis();
            accTimeLocModel.timestampNTP = dIDILocation.getTime();
            accTimeLocModel.typeStr = str;
            List<AccTimeLocModel> list = this.f48637f;
            if (list != null) {
                list.add(accTimeLocModel);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36487a() {
        List<AccTimeLocModel> list;
        try {
            Gson gson = new Gson();
            String str = "";
            if (this.f48637f != null && this.f48637f.size() > 0) {
                str = gson.toJson((Object) this.f48637f);
            }
            long currentTimeMillis = System.currentTimeMillis();
            int i = Utils.isLocationPermissionGranted(this.f48635d) ? 1 : 0;
            long driverId = PlatInfo.getInstance().getDriverId();
            HashMap hashMap = new HashMap();
            hashMap.put("list", str);
            hashMap.put("timestamp_upload", Long.valueOf(currentTimeMillis));
            hashMap.put("loc_permission", Integer.valueOf(i));
            hashMap.put(CarServerParam.PARAM_DRIVER_ID, Long.valueOf(driverId));
            OmegaSDKAdapter.trackEvent("map_location_strategy_source_bt", (Map<String, Object>) hashMap);
            StringBuilder sb = new StringBuilder();
            sb.append("AccTimeTracker| map_location_strategy_source_bt: flush all data, size is: ");
            sb.append(this.f48637f != null ? this.f48637f.size() : -1);
            sb.append(", timestamp_upload: ");
            sb.append(currentTimeMillis);
            sb.append(", loc_permission: ");
            sb.append(i);
            sb.append(", driver_id: ");
            sb.append(driverId);
            DLog.m36225d(sb.toString());
            list = this.f48637f;
            if (list == null) {
                return;
            }
        } catch (Exception e) {
            DLog.m36225d("AccTimeTracker| flush exception:" + e.getMessage() + ", " + e.getClass());
            list = this.f48637f;
            if (list == null) {
                return;
            }
        } catch (Throwable th) {
            List<AccTimeLocModel> list2 = this.f48637f;
            if (list2 != null) {
                list2.clear();
                DLog.m36225d("AccTimeTracker| data cleared");
            }
            throw th;
        }
        list.clear();
        DLog.m36225d("AccTimeTracker| data cleared");
    }
}
