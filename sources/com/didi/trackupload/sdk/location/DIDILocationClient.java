package com.didi.trackupload.sdk.location;

import android.content.Context;
import com.didi.trackupload.sdk.utils.LocUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocBusinessHelper;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import java.util.List;

public class DIDILocationClient implements ILocationClient {

    /* renamed from: a */
    private static final String f46649a = "TRACK_UPLOAD_SDK";

    /* renamed from: b */
    private static final String f46650b = "DIDILocationClient";

    /* renamed from: c */
    private DIDILocationManager f46651c;

    /* renamed from: d */
    private Integer f46652d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public TrackLocationListener f46653e;

    /* renamed from: f */
    private DIDILocationListener f46654f = new DIDILocationListener() {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            DIDILocationClient dIDILocationClient = DIDILocationClient.this;
            dIDILocationClient.m34818a(dIDILocationClient.f46653e, dIDILocation);
            DIDILocationClient.this.m34819a((Integer) 0);
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            DIDILocationClient dIDILocationClient = DIDILocationClient.this;
            dIDILocationClient.m34817a(dIDILocationClient.f46653e, i, errInfo);
            DIDILocationClient dIDILocationClient2 = DIDILocationClient.this;
            if (errInfo != null) {
                i = errInfo.getErrNo();
            }
            dIDILocationClient2.m34819a(Integer.valueOf(i));
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TrackLocationListener f46655g;

    /* renamed from: h */
    private DIDILocationListener f46656h = new DIDILocationListener() {
        public void onStatusUpdate(String str, int i, String str2) {
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            DIDILocationClient dIDILocationClient = DIDILocationClient.this;
            dIDILocationClient.m34818a(dIDILocationClient.f46655g, dIDILocation);
            DIDILocationClient.this.m34819a((Integer) 0);
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            DIDILocationClient dIDILocationClient = DIDILocationClient.this;
            dIDILocationClient.m34817a(dIDILocationClient.f46655g, i, errInfo);
            DIDILocationClient dIDILocationClient2 = DIDILocationClient.this;
            if (errInfo != null) {
                i = errInfo.getErrNo();
            }
            dIDILocationClient2.m34819a(Integer.valueOf(i));
        }
    };

    public void init(Context context) {
        if (context != null) {
            DIDILocationManager instance = DIDILocationManager.getInstance(context.getApplicationContext());
            this.f46651c = instance;
            instance.requestLocationUpdateOnce(new DIDILocationListener() {
                public void onStatusUpdate(String str, int i, String str2) {
                }

                public void onLocationChanged(DIDILocation dIDILocation) {
                    DIDILocationClient.this.m34819a((Integer) 0);
                }

                public void onLocationError(int i, ErrInfo errInfo) {
                    DIDILocationClient dIDILocationClient = DIDILocationClient.this;
                    if (errInfo != null) {
                        i = errInfo.getErrNo();
                    }
                    dIDILocationClient.m34819a(Integer.valueOf(i));
                }
            }, f46649a);
        }
    }

    public boolean isLocationServiceAlive() {
        DIDILocationManager dIDILocationManager = this.f46651c;
        return dIDILocationManager != null && dIDILocationManager.isRunning();
    }

    public void requestNormalLocationUpdates(TrackLocationListener trackLocationListener, long j) {
        DIDILocationUpdateOption a;
        if (this.f46651c != null && trackLocationListener != null && (a = m34812a(j, false)) != null) {
            this.f46653e = trackLocationListener;
            this.f46651c.requestLocationUpdates(this.f46654f, a);
        }
    }

    public void removeNormalLocationUpdates() {
        DIDILocationManager dIDILocationManager = this.f46651c;
        if (dIDILocationManager != null && this.f46653e != null) {
            this.f46653e = null;
            dIDILocationManager.removeLocationUpdates(this.f46654f);
        }
    }

    public void requestDirectNotifyLocationUpdates(TrackLocationListener trackLocationListener, long j) {
        DIDILocationUpdateOption a;
        if (this.f46651c != null && trackLocationListener != null && (a = m34812a(j, true)) != null) {
            this.f46655g = trackLocationListener;
            this.f46651c.requestLocationUpdates(this.f46656h, a);
            TrackLog.m34830d(f46650b, "register direct listener[" + this.f46656h.hashCode() + ":" + j + Const.jaRight);
        }
    }

    public void removeDirectNotifyLocationUpdates() {
        DIDILocationManager dIDILocationManager = this.f46651c;
        if (dIDILocationManager != null && this.f46655g != null) {
            this.f46655g = null;
            dIDILocationManager.removeLocationUpdates(this.f46656h);
        }
    }

    public void requestLocationUpdateOnce(final TrackLocationListener trackLocationListener) {
        DIDILocationManager dIDILocationManager = this.f46651c;
        if (dIDILocationManager != null) {
            dIDILocationManager.requestLocationUpdateOnce(new DIDILocationListener() {
                public void onStatusUpdate(String str, int i, String str2) {
                }

                public void onLocationChanged(DIDILocation dIDILocation) {
                    DIDILocationClient.this.m34818a(trackLocationListener, dIDILocation);
                    DIDILocationClient.this.m34819a((Integer) 0);
                }

                public void onLocationError(int i, ErrInfo errInfo) {
                    DIDILocationClient.this.m34817a(trackLocationListener, i, errInfo);
                    DIDILocationClient dIDILocationClient = DIDILocationClient.this;
                    if (errInfo != null) {
                        i = errInfo.getErrNo();
                    }
                    dIDILocationClient.m34819a(Integer.valueOf(i));
                }
            }, f46649a);
        }
    }

    public DIDILocation getLastLocation() {
        DIDILocationManager dIDILocationManager = this.f46651c;
        if (dIDILocationManager != null) {
            return dIDILocationManager.getLastKnownLocation();
        }
        return null;
    }

    public String getLastError() {
        return String.valueOf(m34813a());
    }

    public List<DIDILocation> getRecentLocations(int i) {
        return DIDILocBusinessHelper.getInstance().getRecentEffectiveLocations(5);
    }

    /* renamed from: a */
    private DIDILocationUpdateOption m34812a(long j, boolean z) {
        DIDILocationUpdateOption.IntervalMode a = m34811a(j);
        if (a == null) {
            return null;
        }
        DIDILocationUpdateOption dIDILocationUpdateOption = new DIDILocationUpdateOption();
        dIDILocationUpdateOption.setModuleKey(f46649a);
        dIDILocationUpdateOption.setInterval(a);
        dIDILocationUpdateOption.setDirectNotify(z);
        return dIDILocationUpdateOption;
    }

    /* renamed from: a */
    private DIDILocationUpdateOption.IntervalMode m34811a(long j) {
        for (DIDILocationUpdateOption.IntervalMode intervalMode : DIDILocationUpdateOption.IntervalMode.values()) {
            if (intervalMode.getValue() == j) {
                return intervalMode;
            }
        }
        return null;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34818a(TrackLocationListener trackLocationListener, DIDILocation dIDILocation) {
        if (trackLocationListener != null) {
            trackLocationListener.onLocationChanged(LocUtils.buildLocationInfo(dIDILocation));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34817a(TrackLocationListener trackLocationListener, int i, ErrInfo errInfo) {
        if (trackLocationListener != null) {
            if (errInfo != null) {
                i = errInfo.getErrNo();
            }
            trackLocationListener.onLocationError(i, errInfo != null ? errInfo.getErrMessage() : "null");
        }
    }

    /* renamed from: a */
    private synchronized Integer m34813a() {
        return this.f46652d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public synchronized void m34819a(Integer num) {
        this.f46652d = num;
    }
}
