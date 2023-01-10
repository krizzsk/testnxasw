package com.didichuxing.bigdata.p174dp.locsdk;

import android.content.Context;
import com.didichuxing.bigdata.p174dp.locsdk.LocDataDef;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.CellManagerWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.GPSFLPUnifier;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.GpsManager;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.LocationStorage;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.LocationUpdateInternalListener;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.OSNLPManager;
import com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3.WifiManagerWrapper;
import com.didichuxing.bigdata.p174dp.locsdk.utils.ApolloProxy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocBusinessHelper */
public class DIDILocBusinessHelper implements IDIDILocBusinessHelper {

    /* renamed from: a */
    private static final String f48331a = "DIDILocBusinessHelperImpl";

    /* renamed from: b */
    private final int f48332b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public Queue<DIDILocation> f48333c;

    /* renamed from: d */
    private LocationUpdateInternalListener f48334d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f48335e;

    /* renamed from: f */
    private Context f48336f;

    private DIDILocBusinessHelper() {
        this.f48332b = 20;
        this.f48333c = new ArrayBlockingQueue(20);
        this.f48334d = new LocationUpdateInternalListener() {
            public void onLocationErr(ErrInfo errInfo, long j) {
            }

            public void onLocationUpdate(DIDILocation dIDILocation, long j) {
                if (DIDILocBusinessHelper.this.f48335e || !DIDILocation.SOURCE_FLP_INERTIAL.equals(dIDILocation.getSource())) {
                    if (DIDILocBusinessHelper.this.f48333c.size() == 20) {
                        DIDILocBusinessHelper.this.f48333c.remove();
                    }
                    DIDILocBusinessHelper.this.f48333c.offer(dIDILocation);
                }
            }
        };
        this.f48335e = false;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.DIDILocBusinessHelper$SingletonHolder */
    private static class SingletonHolder {
        static DIDILocBusinessHelper sInstance = new DIDILocBusinessHelper();

        private SingletonHolder() {
        }
    }

    public static DIDILocBusinessHelper getInstance() {
        return SingletonHolder.sInstance;
    }

    public List<DIDILocation> getRecentEffectiveLocations(int i) {
        ArrayList arrayList = new ArrayList();
        List<DIDILocation> recentLocations = LocationStorage.getInstance().getRecentLocations(i);
        if (recentLocations != null) {
            for (DIDILocation next : recentLocations) {
                if (System.currentTimeMillis() - next.getLocalTime() <= 30000) {
                    arrayList.add(DIDILocation.cloneFrom(next));
                }
            }
        }
        return arrayList;
    }

    public List<DIDILocation> getRecentLocations(int i) {
        ArrayList arrayList = new ArrayList();
        List<DIDILocation> recentLocations = LocationStorage.getInstance().getRecentLocations(i);
        if (recentLocations != null) {
            for (DIDILocation cloneFrom : recentLocations) {
                arrayList.add(DIDILocation.cloneFrom(cloneFrom));
            }
        }
        return arrayList;
    }

    public void init(Context context) {
        this.f48336f = context;
        GPSFLPUnifier.getInstance().addPassiveListener(this.f48334d);
        this.f48335e = ApolloProxy.getInstance().enableInertialVDRAsNormal();
    }

    public void destroy() {
        GPSFLPUnifier.getInstance().removePassiveListener(this.f48334d);
        this.f48335e = false;
    }

    public List<DIDILocation> getRecentGPSLocations(int i) {
        ArrayList arrayList = new ArrayList(Arrays.asList(this.f48333c.toArray(new DIDILocation[0])));
        int size = arrayList.size();
        if (size <= 0) {
            return arrayList;
        }
        if (i >= size) {
            i = size;
        }
        List<DIDILocation> subList = arrayList.subList(size - i, size);
        ArrayList arrayList2 = new ArrayList();
        for (DIDILocation cloneFrom : subList) {
            arrayList2.add(DIDILocation.cloneFrom(cloneFrom));
        }
        return arrayList2;
    }

    public DIDILocation getNewestGeneratedLoc(int i) {
        int nLPCoordinateType = FLPDiffInfoGetter.getInstance().getNLPCoordinateType();
        DIDILocation loadFromGps = DIDILocation.loadFromGps(GpsManager.getInstance().getGPSLocation());
        DIDILocation nLPLocation = OSNLPManager.getInstance().getNLPLocation(nLPCoordinateType);
        DIDILocation lastKnownLocation = LocationStorage.getInstance().getLastKnownLocation();
        if (i == 0) {
            return m36205a(m36205a(lastKnownLocation, loadFromGps), nLPLocation);
        }
        if (i != 1) {
            if (i == 2) {
                if (lastKnownLocation != null && !"gps".equals(lastKnownLocation.getProvider())) {
                    return m36205a(lastKnownLocation, nLPLocation);
                }
                if (nLPLocation != null) {
                    return nLPLocation;
                }
            }
        } else if (lastKnownLocation != null && "gps".equals(lastKnownLocation.getProvider())) {
            return m36205a(lastKnownLocation, loadFromGps);
        } else {
            if (loadFromGps != null) {
                return loadFromGps;
            }
        }
        return null;
    }

    public List<LocDataDef.LocWifiInfo> getCurrentWifiList() {
        return WifiManagerWrapper.getInstance().getValidAPs(true);
    }

    public LocDataDef.LocCellInfo getCurrentCellInfo() {
        return CellManagerWrapper.getInstance().getCurrentCellInfo(this.f48336f);
    }

    /* renamed from: a */
    private DIDILocation m36205a(DIDILocation dIDILocation, DIDILocation dIDILocation2) {
        if (dIDILocation != null && dIDILocation2 != null) {
            return dIDILocation.getLocalTime() > dIDILocation2.getLocalTime() ? dIDILocation : dIDILocation2;
        }
        if (dIDILocation != null) {
            return dIDILocation;
        }
        if (dIDILocation2 != null) {
            return dIDILocation2;
        }
        return null;
    }
}
