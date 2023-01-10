package com.didi.map.global.model.location;

import android.content.Context;
import com.didi.common.map.util.CollectionUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class FLPLocationListener implements DIDILocationListener {

    /* renamed from: a */
    private Context f29845a;

    /* renamed from: b */
    private LocationRegisterParam f29846b;

    /* renamed from: c */
    private List<DIDILocationListener> f29847c = new ArrayList();

    /* renamed from: d */
    private String f29848d = "LocationListener-->google";

    public FLPLocationListener(LocationRegisterParam locationRegisterParam, Context context) {
        this.f29846b = locationRegisterParam;
        this.f29845a = context;
    }

    public void registerLocationListener(DIDILocationListener dIDILocationListener, DIDILocationUpdateOption.IntervalMode intervalMode) {
        List<DIDILocationListener> list = this.f29847c;
        if (list == null || list.isEmpty()) {
            this.f29847c = new ArrayList();
            m23113a(intervalMode);
        }
        this.f29847c.add(dIDILocationListener);
    }

    /* renamed from: a */
    private void m23113a(DIDILocationUpdateOption.IntervalMode intervalMode) {
        DIDILocationManager instance = DIDILocationManager.getInstance(this.f29845a);
        if (instance != null) {
            DIDILocationUpdateOption defaultLocationUpdateOption = instance.getDefaultLocationUpdateOption();
            defaultLocationUpdateOption.setModuleKey("didi.map.global.common.model");
            defaultLocationUpdateOption.setInterval(intervalMode);
            instance.setCoordinateType(0);
            instance.setOnlyOSLocationAbroad(true);
            instance.removeLocationUpdates(this);
            instance.requestLocationUpdates(this, defaultLocationUpdateOption);
        }
    }

    public void unRegisterLocationListener(DIDILocationListener dIDILocationListener) {
        DIDILocationManager instance;
        List<DIDILocationListener> list = this.f29847c;
        if (list != null) {
            list.remove(dIDILocationListener);
            if (this.f29847c.isEmpty() && (instance = DIDILocationManager.getInstance(this.f29845a)) != null) {
                instance.removeLocationUpdates(this);
                this.f29847c = null;
            }
        }
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f29847c)) {
            for (DIDILocationListener next : this.f29847c) {
                if (next != null) {
                    next.onLocationChanged(dIDILocation);
                }
            }
        }
    }

    public void onLocationError(int i, ErrInfo errInfo) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f29847c)) {
            for (DIDILocationListener next : this.f29847c) {
                if (next != null) {
                    next.onLocationError(i, errInfo);
                }
            }
        }
    }

    public void onStatusUpdate(String str, int i, String str2) {
        if (!CollectionUtil.isEmpty((Collection<?>) this.f29847c)) {
            for (DIDILocationListener next : this.f29847c) {
                if (next != null) {
                    next.onStatusUpdate(str, i, str2);
                }
            }
        }
    }

    public DIDILocation getLastKnownLocation(Context context) {
        DIDILocationManager instance = DIDILocationManager.getInstance(context);
        if (instance != null) {
            return instance.getLastKnownLocation();
        }
        return null;
    }
}
