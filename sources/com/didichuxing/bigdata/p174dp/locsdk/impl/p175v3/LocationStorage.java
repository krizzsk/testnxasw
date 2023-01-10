package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import android.content.Context;
import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.utils.OmegaUtils;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationStorage */
public class LocationStorage {
    public static final String ACTION_UPDATE_CURRENT_LOCATION = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.LocationStorage.ACTION_UPDATE_CURRENT_LOCATION";
    public static final String INTENT_EXTRA_DATA_LOCATION = "com.didichuxing.bigdata.dp.com.didichuxing.bigdata.dp.locsdk.LocationStorage.INTENT_EXTRA_DATA_LOCATION";

    /* renamed from: a */
    private volatile DIDILocation f48547a;

    /* renamed from: b */
    private final int f48548b;

    /* renamed from: c */
    private Queue<DIDILocation> f48549c;

    /* renamed from: d */
    private Context f48550d;

    /* renamed from: e */
    private String f48551e;

    private LocationStorage() {
        this.f48547a = null;
        this.f48548b = 20;
        this.f48549c = new ArrayBlockingQueue(20);
    }

    public void init(Context context) {
        this.f48550d = context;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocationStorage$SingletonHolder */
    private static class SingletonHolder {
        static LocationStorage sInstance = new LocationStorage();

        private SingletonHolder() {
        }
    }

    public static LocationStorage getInstance() {
        return SingletonHolder.sInstance;
    }

    public void setAppId(String str) {
        this.f48551e = str;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121126a(DIDILocation dIDILocation, String str) {
        DIDILocation dIDILocation2 = this.f48547a;
        this.f48547a = dIDILocation;
        m36420a(this.f48547a);
        OmegaUtils.trackLocTimestampMonotonic(dIDILocation2, this.f48547a, str);
        if (dIDILocation2 == null || Double.compare(dIDILocation2.getLongitude(), dIDILocation.getLongitude()) != 0 || Double.compare(dIDILocation2.getLatitude(), dIDILocation.getLatitude()) != 0 || Float.compare(dIDILocation2.getAccuracy(), dIDILocation.getAccuracy()) != 0 || dIDILocation2.getTime() != dIDILocation.getTime()) {
            if (this.f48549c.size() == 20) {
                this.f48549c.remove();
            }
            this.f48549c.offer(dIDILocation);
        }
    }

    /* renamed from: a */
    private void m36420a(DIDILocation dIDILocation) {
        Intent intent = new Intent(ACTION_UPDATE_CURRENT_LOCATION);
        intent.putExtra(INTENT_EXTRA_DATA_LOCATION, dIDILocation);
        LocalBroadcastManager.getInstance(this.f48550d).sendBroadcast(intent);
    }

    public DIDILocation getLastKnownLocation() {
        if (this.f48547a != null && System.currentTimeMillis() - this.f48547a.getLocalTime() > 30000) {
            this.f48547a.setEffective(false);
        }
        m36419a();
        return this.f48547a;
    }

    public List<DIDILocation> getRecentLocations(int i) {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.f48549c.toArray(new DIDILocation[0])));
        int size = arrayList.size();
        if (size <= 0) {
            return arrayList;
        }
        if (i >= size) {
            i = size;
        }
        return arrayList.subList(size - i, size);
    }

    /* renamed from: a */
    private void m36419a() {
        float f;
        boolean z;
        boolean z2 = false;
        if (this.f48547a != null) {
            z = this.f48547a.isEffective();
            f = this.f48547a.getAccuracy();
        } else {
            f = -1.0f;
            z = false;
        }
        String str = this.f48551e;
        if (this.f48547a != null) {
            z2 = true;
        }
        OmegaUtils.trackLastKnowResult(str, z, z2, f);
    }
}
