package com.didi.mapbizinterface.track;

import android.content.Context;
import com.didi.mapbizinterface.common.AppStateMonitor;
import com.didi.mapbizinterface.common.NetStateManager;
import com.didi.mapbizinterface.utils.ApolloUtils;
import com.didi.mapbizinterface.utils.ThreadDispatcher;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.sdu.didi.protobuf.AppPage;
import com.sdu.didi.protobuf.AppState;
import com.sdu.didi.protobuf.MapTrackExtraMessageData;
import com.sdu.didi.protobuf.MapTrackExtraPointData;
import com.sdu.didi.protobuf.SimpleLocationInfo;
import java.util.ArrayList;
import java.util.List;

public class MapTrackExtraDataProvider {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile boolean f31533a;

    private MapTrackExtraDataProvider() {
        this.f31533a = false;
    }

    private static class SingletonHolder {
        static MapTrackExtraDataProvider INSTANCE = new MapTrackExtraDataProvider();

        private SingletonHolder() {
        }
    }

    public static MapTrackExtraDataProvider getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init(final Context context) {
        ThreadDispatcher.runOnMainThread(new Runnable() {
            public void run() {
                if (context != null && !MapTrackExtraDataProvider.this.f31533a) {
                    boolean unused = MapTrackExtraDataProvider.this.f31533a = true;
                    AppStateMonitor.getInstance().init(context);
                    NetStateManager.getInstance().init(context);
                }
            }
        });
    }

    public MapTrackExtraMessageData getExtraTrackMessageData(TrackMessageParams trackMessageParams) {
        DIDILocation dIDILocation = null;
        MapTrackExtraMessageData.Builder flp_strategy = new MapTrackExtraMessageData.Builder().satellite_num(Integer.valueOf(m24099a(trackMessageParams != null ? trackMessageParams.f31537c : null))).network_state(NetStateManager.getInstance().getNetworkState()).signal_level(Integer.valueOf(NetStateManager.getInstance().getSignalLevel())).flp_strategy(m24104b(trackMessageParams != null ? trackMessageParams.f31537c : null));
        if (trackMessageParams != null) {
            dIDILocation = trackMessageParams.f31537c;
        }
        MapTrackExtraMessageData build = flp_strategy.original_loc_source(m24107d(dIDILocation)).app_state(m24100a()).app_page(m24103b()).track_sdk_flag(Integer.valueOf((trackMessageParams == null || trackMessageParams.f31538d == null) ? 0 : trackMessageParams.f31538d.intValue())).vdr_locations(m24106c()).build();
        if (ApolloUtils.isDebugLogEnabled()) {
            try {
                SystemUtils.log(3, "snser", String.valueOf(build), (Throwable) null, "com.didi.mapbizinterface.track.MapTrackExtraDataProvider", 77);
            } catch (Exception unused) {
            }
        }
        return build;
    }

    public MapTrackExtraPointData getExtraTrackPointData(TrackPointParams trackPointParams) {
        DIDILocation dIDILocation = null;
        MapTrackExtraPointData.Builder app_state = new MapTrackExtraPointData.Builder().satellite_num(Integer.valueOf(m24099a(trackPointParams != null ? trackPointParams.f31539a : null))).original_loc_source(m24107d(trackPointParams != null ? trackPointParams.f31539a : null)).app_state(m24100a());
        if (trackPointParams != null) {
            dIDILocation = trackPointParams.f31539a;
        }
        MapTrackExtraPointData build = app_state.flp_simplified_strategy(m24105c(dIDILocation)).build();
        if (ApolloUtils.isDebugLogEnabled()) {
            try {
                SystemUtils.log(3, "snser", String.valueOf(build), (Throwable) null, "com.didi.mapbizinterface.track.MapTrackExtraDataProvider", 98);
            } catch (Exception unused) {
            }
        }
        return build;
    }

    public void updateBizInfo(int i, Object obj) {
        BizInfoProvider.m24094a().mo85925a(i, obj);
    }

    /* renamed from: a */
    private int m24099a(DIDILocation dIDILocation) {
        if (dIDILocation == null || dIDILocation.getExtra() == null) {
            return -1;
        }
        return dIDILocation.getExtra().getInt(DIDILocation.EXTRA_KEY_FIX_LOC_SATELLITE_NUM, -1);
    }

    /* renamed from: b */
    private String m24104b(DIDILocation dIDILocation) {
        if (dIDILocation == null || dIDILocation.getExtra() == null) {
            return null;
        }
        return dIDILocation.getExtra().getString(DIDILocation.EXTRA_KEY_FLP_STRATEGY, (String) null);
    }

    /* renamed from: c */
    private String m24105c(DIDILocation dIDILocation) {
        if (dIDILocation == null || dIDILocation.getExtra() == null) {
            return null;
        }
        return dIDILocation.getExtra().getString(DIDILocation.EXTRA_KEY_SIMPLIFIED_FLP_STRATEGY, (String) null);
    }

    /* renamed from: d */
    private String m24107d(DIDILocation dIDILocation) {
        if (dIDILocation != null) {
            return dIDILocation.getSource();
        }
        return null;
    }

    /* renamed from: com.didi.mapbizinterface.track.MapTrackExtraDataProvider$2 */
    static /* synthetic */ class C110642 {

        /* renamed from: $SwitchMap$com$didi$mapbizinterface$common$AppStateMonitor$AppState */
        static final /* synthetic */ int[] f31534xe1aa486a;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|6) */
        /* JADX WARNING: Code restructure failed: missing block: B:7:?, code lost:
            return;
         */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        static {
            /*
                com.didi.mapbizinterface.common.AppStateMonitor$AppState[] r0 = com.didi.mapbizinterface.common.AppStateMonitor.AppState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31534xe1aa486a = r0
                com.didi.mapbizinterface.common.AppStateMonitor$AppState r1 = com.didi.mapbizinterface.common.AppStateMonitor.AppState.FOREGROUND     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31534xe1aa486a     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.mapbizinterface.common.AppStateMonitor$AppState r1 = com.didi.mapbizinterface.common.AppStateMonitor.AppState.BACKGROUND     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.mapbizinterface.track.MapTrackExtraDataProvider.C110642.<clinit>():void");
        }
    }

    /* renamed from: a */
    private AppState m24100a() {
        int i = C110642.f31534xe1aa486a[AppStateMonitor.getInstance().getAppState().ordinal()];
        if (i == 1) {
            return AppState.FOREGROUND_ACTIVE;
        }
        if (i != 2) {
            return null;
        }
        return AppState.BACKGROUND;
    }

    /* renamed from: b */
    private AppPage m24103b() {
        Object a = BizInfoProvider.m24094a().mo85923a(4097);
        if (a instanceof AppPage) {
            return (AppPage) a;
        }
        return AppPage.OTHERS;
    }

    /* renamed from: c */
    private List<SimpleLocationInfo> m24106c() {
        if (!NetStateManager.getInstance().isNetAvailable()) {
            return new ArrayList();
        }
        List<DIDILocation> a = BizInfoProvider.m24094a().mo85924a(4098, DIDILocation.class, 60);
        ArrayList arrayList = new ArrayList();
        for (DIDILocation next : a) {
            arrayList.add(new SimpleLocationInfo.Builder().lat(Double.valueOf(next.getLatitude())).lng(Double.valueOf(next.getLongitude())).speed(Double.valueOf((double) next.getSpeed())).direction(Double.valueOf((double) next.getBearing())).time64_loc(Long.valueOf(next.getTime())).build());
        }
        return arrayList;
    }
}
