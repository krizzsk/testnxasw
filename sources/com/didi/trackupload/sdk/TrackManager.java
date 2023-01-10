package com.didi.trackupload.sdk;

import android.content.Context;
import android.util.Log;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.utils.TrackLog;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;

public class TrackManager {

    /* renamed from: a */
    private static final String f46544a = "TrackManager";

    private TrackManager() {
        TrackLog.m34830d(f46544a, "TrackManager newInstance hashcode=0x" + Integer.toHexString(hashCode()));
    }

    private static class SingletonHolder {
        static final TrackManager INSTANCE = new TrackManager();

        private SingletonHolder() {
        }
    }

    public static TrackManager getIntance() {
        return SingletonHolder.INSTANCE;
    }

    public int init(Context context, TrackInitParams trackInitParams) {
        if (!(context == null || trackInitParams == null)) {
            TrackController.getIntance().mo115845a(context, trackInitParams);
        }
        int a = TrackController.getIntance().mo115841a();
        TrackLog.m34830d(f46544a, "init version=1.0.002");
        TrackLog.m34830d(f46544a, "init err=" + TrackErrInfo.toErrString(a) + " context=" + context + " params=" + trackInitParams);
        StringBuilder sb = new StringBuilder();
        sb.append("init trace=");
        sb.append(Log.getStackTraceString(new Throwable()));
        TrackLog.m34830d(f46544a, sb.toString());
        return a;
    }

    public TrackClient createTrackClient(TrackClientType trackClientType, String str) {
        TrackClient a = TrackController.getIntance().mo115844a(trackClientType, str);
        TrackLog.m34830d(f46544a, "createTrackClient client=" + a);
        return a;
    }

    public int startTrackOnce(TrackClientType trackClientType, String str, ITrackDataDelegate iTrackDataDelegate) {
        TrackOnceClient trackOnceClient = new TrackOnceClient(trackClientType, str);
        trackOnceClient.mo115877a(iTrackDataDelegate);
        int a = trackOnceClient.mo115876a();
        TrackLog.m34830d(f46544a, "startTrackOnce err=" + TrackErrInfo.toErrString(a) + " client=" + trackOnceClient);
        return a;
    }

    @Deprecated
    public void setSubtitudeLoc(DIDILocation dIDILocation) {
        LocationCenter.getIntance().setSubtitudeLoc(dIDILocation);
    }
}
