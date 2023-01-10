package com.didi.map.global.model.location;

import android.content.Context;
import android.text.TextUtils;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p174dp.locsdk.once.DIDILocNlpOnceManager;
import com.didichuxing.bigdata.p174dp.locsdk.once.DIDILocationUpdateOnceParam;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class NLPLocationListener implements DIDILocationListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f29855a;

    /* renamed from: b */
    private LocationRegisterParam f29856b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<DIDILocationListener> f29857c = new ArrayList();

    /* renamed from: d */
    private String f29858d = "LocationListener-->didi";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public DIDILocation f29859e;

    /* renamed from: f */
    private long f29860f;

    public void onLocationError(int i, ErrInfo errInfo) {
    }

    public void onStatusUpdate(String str, int i, String str2) {
    }

    public NLPLocationListener(LocationRegisterParam locationRegisterParam, Context context) {
        this.f29856b = locationRegisterParam;
        this.f29855a = context;
    }

    public void registerLocationListener(DIDILocationListener dIDILocationListener, DIDILocationUpdateOption.IntervalMode intervalMode) {
        List<DIDILocationListener> list = this.f29857c;
        if (list == null || list.isEmpty()) {
            this.f29857c = new ArrayList();
            this.f29860f = System.currentTimeMillis();
            DIDILocationManager instance = DIDILocationManager.getInstance(this.f29855a);
            if (instance != null) {
                DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
                defaultLocationUpdateOption.setModuleKey("didi.map.global.common.model");
                defaultLocationUpdateOption.setInterval(DIDILocationUpdateOption.IntervalMode.HIGH_FREQUENCY);
                instance.setCoordinateType(0);
                instance.setOnlyOSLocationAbroad(true);
                instance.removeLocationUpdates(this);
                instance.requestLocationUpdates(this, defaultLocationUpdateOption);
            }
        }
        this.f29857c.add(dIDILocationListener);
    }

    public void unRegisterLocationListener(DIDILocationListener dIDILocationListener) {
        List<DIDILocationListener> list = this.f29857c;
        if (list != null) {
            list.remove(dIDILocationListener);
            if (this.f29857c.isEmpty()) {
                DIDILocationManager instance = DIDILocationManager.getInstance(this.f29855a);
                if (instance != null) {
                    instance.removeLocationUpdates(this);
                    this.f29857c = null;
                }
                this.f29860f = 0;
                DLog.m10773d(this.f29858d, "自建定位NLP已经销毁", new Object[0]);
            }
        }
    }

    public void updateNlpParam(LocationRegisterParam locationRegisterParam) {
        this.f29856b = locationRegisterParam;
    }

    public DIDILocation getLastKnownLocation() {
        return this.f29859e;
    }

    public DIDILocation getLastKnownLocationFlp(Context context) {
        DIDILocationManager instance = DIDILocationManager.getInstance(context);
        if (instance != null) {
            return instance.getLastKnownLocation();
        }
        return null;
    }

    /* renamed from: a */
    private void m23119a() {
        LocationRegisterParam locationRegisterParam = this.f29856b;
        if (locationRegisterParam != null && this.f29855a != null && locationRegisterParam.getNlpRegisterParam() != null) {
            DIDILocationUpdateOnceParam dIDILocationUpdateOnceParam = new DIDILocationUpdateOnceParam();
            if (!TextUtils.isEmpty(this.f29856b.getNlpRegisterParam().getmCallFrom())) {
                dIDILocationUpdateOnceParam.setCallFrom(this.f29856b.getNlpRegisterParam().getmCallFrom());
            }
            dIDILocationUpdateOnceParam.setEntrance(PaxEnvironment.getInstance().getEntrance().toString());
            dIDILocationUpdateOnceParam.setModuleKey("map-mylocation");
            dIDILocationUpdateOnceParam.setTimeOut(this.f29856b.getNlpRegisterParam().getmConnectTimeOut());
            DIDILocNlpOnceManager.getInstance(this.f29855a).requestLocationUpdateOnce(m23125c(), dIDILocationUpdateOnceParam, 3);
        }
    }

    /* renamed from: b */
    private boolean m23124b() {
        LocationRegisterParam locationRegisterParam = this.f29856b;
        int frequency = (locationRegisterParam == null || locationRegisterParam.getNlpRegisterParam() == null) ? 2000 : this.f29856b.getNlpRegisterParam().getFrequency();
        boolean z = false;
        if (this.f29860f != 0 && System.currentTimeMillis() - this.f29860f > ((long) frequency)) {
            z = true;
        }
        if (z) {
            this.f29860f = System.currentTimeMillis();
        }
        return z;
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        if (m23124b()) {
            m23119a();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m23121a(DIDILocation dIDILocation) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f29857c)) {
            for (DIDILocationListener next : this.f29857c) {
                if (next != null) {
                    next.onLocationChanged(dIDILocation);
                }
            }
            this.f29859e = dIDILocation;
        }
    }

    /* renamed from: c */
    private DIDILocationListener m23125c() {
        return new DIDILocationListener() {
            public void onLocationChanged(DIDILocation dIDILocation) {
                NLPLocationListener.this.m23121a(dIDILocation);
                DIDILocation unused = NLPLocationListener.this.f29859e = dIDILocation;
            }

            public void onLocationError(int i, ErrInfo errInfo) {
                NLPLocationListener nLPLocationListener = NLPLocationListener.this;
                nLPLocationListener.m23121a(nLPLocationListener.getLastKnownLocationFlp(nLPLocationListener.f29855a));
            }

            public void onStatusUpdate(String str, int i, String str2) {
                if (!CollectionUtil.isEmpty((Collection<?>) NLPLocationListener.this.f29857c)) {
                    for (DIDILocationListener dIDILocationListener : NLPLocationListener.this.f29857c) {
                        if (dIDILocationListener != null) {
                            dIDILocationListener.onStatusUpdate(str, i, str2);
                        }
                    }
                }
            }
        };
    }
}
