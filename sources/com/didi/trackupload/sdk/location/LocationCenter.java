package com.didi.trackupload.sdk.location;

import android.content.Context;
import android.os.SystemClock;
import com.didi.mapbizinterface.track.MapTrackExtraDataConverter;
import com.didi.trackupload.sdk.core.UploadFlags;
import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.storage.TrackDataStorage;
import com.didi.trackupload.sdk.utils.ApolloUtils;
import com.didi.trackupload.sdk.utils.LocUtils;
import com.didi.trackupload.sdk.utils.LogStringUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.sdu.didi.protobuf.MapTrackExtraPointData;
import global.didi.pay.newview.pix.IPixView;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;

public class LocationCenter {
    public static final String TAG = "TrackLoc";

    /* renamed from: a */
    private ILocationClient f46657a;

    /* renamed from: b */
    private long f46658b;

    /* renamed from: c */
    private long f46659c;

    /* renamed from: d */
    private volatile DIDILocation f46660d;

    /* renamed from: e */
    private TrackLocationInfo f46661e;

    private LocationCenter() {
        this.f46661e = null;
        this.f46657a = new DIDILocationClient();
    }

    public void setSubtitudeLoc(DIDILocation dIDILocation) {
        if (ApolloUtils.isAllowSubtitudeLoc()) {
            this.f46660d = dIDILocation;
            TrackLog.m34830d(TAG, "setSubtitudeLoc " + LogStringUtils.parseDIDILocation(dIDILocation));
        }
    }

    private static class SingletonHolder {
        static final LocationCenter INSTANCE = new LocationCenter();

        private SingletonHolder() {
        }
    }

    public static LocationCenter getIntance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(Context context) {
        TrackLog.m34830d(TAG, IPixView.PAGE_STATUS_INIT);
        this.f46657a.init(context);
    }

    public boolean isLocationServiceAlive() {
        return this.f46657a.isLocationServiceAlive();
    }

    public void requestNormalLocationUpdates(TrackLocationListener trackLocationListener, long j) {
        TrackLog.m34830d(TAG, "requestNormalLocationUpdates intervalMillis=" + j);
        this.f46657a.requestNormalLocationUpdates(trackLocationListener, j);
        this.f46658b = j;
    }

    public void removeNormalLocationUpdates() {
        TrackLog.m34830d(TAG, "removeNormalLocationUpdates");
        this.f46657a.removeNormalLocationUpdates();
        this.f46658b = -1;
    }

    public long getNormalLocationUpdateIntervalMillis() {
        return this.f46658b;
    }

    public void requestDirectNotifyLocationUpdates(TrackLocationListener trackLocationListener, long j) {
        TrackLog.m34830d(TAG, "requestDirectNotifyLocationUpdates intervalMillis=" + j);
        this.f46657a.requestDirectNotifyLocationUpdates(trackLocationListener, j);
        this.f46659c = j;
    }

    public void removeDirectNotifyLocationUpdates() {
        TrackLog.m34830d(TAG, "removeDirectNotifyLocationUpdates");
        this.f46657a.removeDirectNotifyLocationUpdates();
        this.f46659c = -1;
    }

    public long getDirectNotifyLocationUpdateIntervalMillis() {
        return this.f46659c;
    }

    public TrackLocationInfo requestLocationOnceSync(long j) {
        TrackLog.m34830d(TAG, "requestLocationOnceSync");
        LocationOnceLatch locationOnceLatch = new LocationOnceLatch();
        this.f46657a.requestLocationUpdateOnce(locationOnceLatch);
        return locationOnceLatch.waitForResult(j);
    }

    public void requestLocationOnceAsync(TrackLocationListener trackLocationListener) {
        TrackLog.m34830d(TAG, "requestLocationOnceAsync");
        this.f46657a.requestLocationUpdateOnce(trackLocationListener);
    }

    public TrackLocationInfo getLastEffectiveLocation() {
        if (this.f46660d != null && LocUtils.isSubtitudeLocEffective(this.f46660d.getLocalTime())) {
            return LocUtils.buildLocationInfo(this.f46660d);
        }
        DIDILocation lastLocation = this.f46657a.getLastLocation();
        if (lastLocation == null || !LocUtils.isLocEffective(lastLocation.getLocalTime())) {
            return null;
        }
        return LocUtils.buildLocationInfo(lastLocation);
    }

    public String getLastError() {
        return this.f46657a.getLastError();
    }

    public List<TrackLocationInfo> getRecentLocations(int i) {
        ArrayList arrayList = new ArrayList();
        List<DIDILocation> recentLocations = this.f46657a.getRecentLocations(i);
        if (recentLocations != null) {
            for (DIDILocation buildLocationInfo : recentLocations) {
                arrayList.add(LocUtils.buildLocationInfo(buildLocationInfo));
            }
        }
        return arrayList;
    }

    private class LocationOnceLatch extends CountDownLatch implements TrackLocationListener {
        TrackLocationInfo mResult = null;

        LocationOnceLatch() {
            super(1);
        }

        /* access modifiers changed from: package-private */
        public TrackLocationInfo waitForResult(long j) {
            try {
                if (await(j, TimeUnit.MILLISECONDS)) {
                    return this.mResult;
                }
                return null;
            } catch (InterruptedException unused) {
                return null;
            }
        }

        public void onLocationChanged(TrackLocationInfo trackLocationInfo) {
            TrackLog.m34830d(LocationCenter.TAG, "LocationOnceLatch onLocationChanged loc=" + LogStringUtils.parseLocationInfo(trackLocationInfo));
            this.mResult = trackLocationInfo;
            countDown();
        }

        public void onLocationError(int i, String str) {
            TrackLog.m34830d(LocationCenter.TAG, "LocationOnceLatch onLocationError errCode=" + i + " errMsg=" + str);
            countDown();
        }
    }

    public TrackLocationInfo getRetrievedLocInfoRecord() {
        return this.f46661e;
    }

    public TrackLocationInfo retrieveCurrentLocation(long j) {
        this.f46661e = null;
        boolean hasFlag = UploadFlags.hasFlag(j, 4);
        TrackLocationInfo lastEffectiveLocation = getIntance().getLastEffectiveLocation();
        if (lastEffectiveLocation != null) {
            TrackLog.m34830d(TAG, "getLocFromLocCache");
            this.f46661e = new TrackLocationInfo.Builder(lastEffectiveLocation).map_extra_point_data((MapTrackExtraPointData) null).build();
        }
        TrackLocationInfo lastEffectiveLoc = TrackDataStorage.getInstance().getLastEffectiveLoc();
        if (lastEffectiveLoc != null) {
            TrackLog.m34830d(TAG, "getLocFromDBCache");
            this.f46661e = new TrackLocationInfo.Builder(lastEffectiveLoc).map_extra_message_data(MapTrackExtraDataConverter.convert2MessageData(lastEffectiveLoc.map_extra_point_data)).map_extra_point_data((MapTrackExtraPointData) null).build();
        }
        if (hasFlag) {
            long elapsedRealtime = SystemClock.elapsedRealtime();
            TrackLocationInfo requestLocationOnceSync = getIntance().requestLocationOnceSync(10000);
            if (requestLocationOnceSync != null) {
                TrackLog.m34830d(TAG, "getLocFromLocOnce timediff=" + (SystemClock.elapsedRealtime() - elapsedRealtime) + "ms");
                this.f46661e = new TrackLocationInfo.Builder(requestLocationOnceSync).map_extra_point_data((MapTrackExtraPointData) null).build();
            }
        }
        if (this.f46661e == null) {
            TrackLog.m34830d(TAG, "getLocFail");
        }
        return this.f46661e;
    }
}
