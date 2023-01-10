package com.didichuxing.bigdata.p174dp.locsdk.impl.p175v3;

import android.content.Context;
import android.os.Build;
import android.util.Pair;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocationUpdateOption;
import com.didichuxing.bigdata.p174dp.locsdk.DLog;
import com.didichuxing.bigdata.p174dp.locsdk.ErrInfo;
import com.didichuxing.bigdata.p174dp.locsdk.PermissionSwitchUtils;
import com.didichuxing.bigdata.p174dp.locsdk.net.NetUtils;
import com.didichuxing.bigdata.p174dp.locsdk.utils.TraceUtils;
import com.didichuxing.bigdata.p174dp.locsdk.utils.Utils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import rui.config.RConfigConstants;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocConfessor */
class LocConfessor {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public volatile boolean f48528a = false;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public volatile boolean f48529b = false;

    /* renamed from: c */
    private Context f48530c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public volatile long f48531d = DIDILocationUpdateOption.IntervalMode.NORMAL.getValue();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public Runnable f48532e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public volatile LocationUpdateInternalListener f48533f;

    /* renamed from: g */
    private LocationUpdateInternalListener f48534g;

    /* renamed from: h */
    private int f48535h;

    /* renamed from: i */
    private long f48536i;

    /* renamed from: j */
    private List<Pair<String, Long>> f48537j;

    /* renamed from: k */
    private StringBuilder f48538k = new StringBuilder("");
    /* access modifiers changed from: private */

    /* renamed from: l */
    public long f48539l = 0;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public C15953c f48540m;

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocConfessor$RetrieveLocationCallback */
    interface RetrieveLocationCallback {
        void onLocationChanged(DIDILocation dIDILocation);

        void onLocationError(int i, ErrInfo errInfo);
    }

    /* renamed from: b */
    private void m36401b(long j) {
    }

    /* renamed from: a */
    public String mo121099a() {
        return String.valueOf(m36404d());
    }

    /* renamed from: d */
    private StringBuilder m36404d() {
        return this.f48538k;
    }

    /* renamed from: a */
    private void m36397a(StringBuilder sb) {
        this.f48538k = sb;
    }

    /* renamed from: a */
    public void mo121103a(List<Pair<String, Long>> list) {
        this.f48537j = list;
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocConfessor$RetriveLocLoopTask */
    private class RetriveLocLoopTask implements Runnable {
        public RetriveLocLoopTask() {
        }

        public void run() {
            if (LocConfessor.this.f48529b && LocConfessor.this.f48540m != null) {
                LocConfessor.this.m36406e();
                if (LocConfessor.this.f48539l > DIDILocationUpdateOption.IntervalMode.BATTERY_SAVE.getValue()) {
                    LocConfessor locConfessor = LocConfessor.this;
                    long unused = locConfessor.f48539l = locConfessor.f48531d;
                }
                C15953c b = LocConfessor.this.f48540m;
                LocConfessor locConfessor2 = LocConfessor.this;
                b.mo121174a((RetrieveLocationCallback) new RetrieveLocationCallbackImpl(locConfessor2.f48539l));
                if (LocConfessor.this.f48529b && ThreadDispatcher.getWorkThread().isAlive()) {
                    ThreadDispatcher.getWorkThread().postDelayed(LocConfessor.this.f48532e, LocConfessor.this.f48531d);
                    LocConfessor locConfessor3 = LocConfessor.this;
                    long unused2 = locConfessor3.f48539l = locConfessor3.f48539l + LocConfessor.this.f48531d;
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m36406e() {
        this.f48540m.mo121178b(this.f48531d);
    }

    protected LocConfessor(Context context) {
        this.f48530c = context;
        NetUtils.init(context);
        this.f48535h = Utils.getCoordinateType();
    }

    /* renamed from: a */
    public void mo121101a(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f48533f = locationUpdateInternalListener;
    }

    /* renamed from: b */
    public void mo121106b(LocationUpdateInternalListener locationUpdateInternalListener) {
        this.f48534g = locationUpdateInternalListener;
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public synchronized void mo121102a(String str) {
        DLog.m36225d("LocConfessor:start");
        if (!this.f48528a) {
            C15953c createLocationStrategy = LocationStrategyFactory.getIntance().createLocationStrategy(this.f48530c, this.f48535h);
            this.f48540m = createLocationStrategy;
            createLocationStrategy.mo121175a(this.f48534g);
            this.f48540m.mo121173a(this.f48531d);
            this.f48540m.mo121176a(str);
            this.f48532e = new RetriveLocLoopTask();
            ThreadDispatcher.getWorkThread().post(this.f48532e);
            this.f48529b = true;
            this.f48528a = true;
        }
    }

    /* access modifiers changed from: protected */
    /* renamed from: b */
    public synchronized void mo121105b() {
        if (this.f48528a) {
            if (this.f48540m != null) {
                this.f48540m.mo121172a();
                this.f48540m.mo121175a((LocationUpdateInternalListener) null);
                this.f48540m = null;
            }
            ThreadDispatcher.getWorkThread().removeCallbacks(this.f48532e);
            this.f48532e = null;
            this.f48529b = false;
            this.f48539l = 0;
            this.f48531d = DIDILocationUpdateOption.IntervalMode.NORMAL.getValue();
            this.f48533f = null;
            this.f48534g = null;
            this.f48528a = false;
        }
    }

    /* renamed from: c */
    public long mo121107c() {
        return this.f48531d;
    }

    /* renamed from: a */
    public void mo121100a(final long j) {
        C15953c cVar = this.f48540m;
        if (cVar != null) {
            cVar.mo121173a(j);
        }
        if (!this.f48528a) {
            this.f48539l = 0;
            this.f48531d = j;
        } else if (ThreadDispatcher.getWorkThread().isAlive()) {
            ThreadDispatcher.getWorkThread().post(new Runnable() {
                public void run() {
                    if (LocConfessor.this.f48528a) {
                        long unused = LocConfessor.this.f48539l = 0;
                        long unused2 = LocConfessor.this.f48531d = j;
                        ThreadDispatcher.getWorkThread().removeCallbacks(LocConfessor.this.f48532e);
                        ThreadDispatcher.getWorkThread().post(LocConfessor.this.f48532e);
                    }
                }
            });
        }
        if (!this.f48530c.getPackageName().equals("com.sdu.didi.gsui")) {
            return;
        }
        if (j == DIDILocationUpdateOption.IntervalMode.NORMAL.getValue() || j == DIDILocationUpdateOption.IntervalMode.BATTERY_SAVE.getValue()) {
            PermissionSwitchUtils.PermissionSwitchState permissionSwitchState = PermissionSwitchUtils.getPermissionSwitchState(this.f48530c);
            HashMap hashMap = new HashMap();
            hashMap.put("phone", TraceUtils.getPhone(this.f48530c));
            hashMap.put("ui_version", Build.ID);
            hashMap.put("sdk_version", String.valueOf(11016));
            hashMap.put("location_switch_level", String.valueOf(Utils.getLocationSwitchLevel(this.f48530c)));
            hashMap.put("location_permission", String.valueOf(Utils.getLocationPermissionLevel(this.f48530c)));
            hashMap.put("pemissiomDIDINLPManagern_switch_state", String.valueOf(permissionSwitchState.ordinal()));
            OmegaSDKAdapter.trackEvent("pemission_switch_state", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo121104a(Set<LocationListenerWrapper> set) {
        if (set != null) {
            StringBuilder sb = new StringBuilder();
            StringBuilder sb2 = new StringBuilder();
            for (LocationListenerWrapper next : set) {
                sb.append(next.getOption().getModuleKey());
                sb.append(":");
                sb.append(next.getListener());
                sb.append("@");
                sb.append(next.getOption().getInterval().getValue());
                sb.append(RConfigConstants.KEYWORD_COLOR_SIGN);
                sb2.append(next.getOption().getModuleKey());
                sb2.append(":");
                sb2.append(next.getOption().getHexModuleKey());
                sb2.append(RConfigConstants.KEYWORD_COLOR_SIGN);
            }
            if (sb.length() > 0) {
                sb.deleteCharAt(sb.length() - 1);
            }
            if (sb2.length() > 0) {
                sb2.deleteCharAt(sb2.length() - 1);
            }
            m36397a(sb);
            C15953c cVar = this.f48540m;
            if (cVar != null) {
                cVar.mo121177a(m36404d());
            }
            DLog.m36225d("updateListenerInfo listeners=" + sb.toString());
            DLog.m36225d("updateListenerInfo moduleKeys=" + sb2.toString());
        }
    }

    /* renamed from: com.didichuxing.bigdata.dp.locsdk.impl.v3.LocConfessor$RetrieveLocationCallbackImpl */
    private class RetrieveLocationCallbackImpl implements RetrieveLocationCallback {
        private long mIntervalCount;

        RetrieveLocationCallbackImpl(long j) {
            this.mIntervalCount = j;
        }

        public void onLocationChanged(DIDILocation dIDILocation) {
            if (LocConfessor.this.f48533f != null) {
                dIDILocation.getExtra().putInt(DIDILocation.EXTRA_KEY_FIX_LOC_SATELLITE_NUM, GpsManager.getInstance().getFixLocSatelliteNum());
                dIDILocation.getExtra().putFloat(DIDILocation.EXTRA_KEY_GPS_SIGNAL_LEVEL, GpsManager.getInstance().getGpsSignalLevel());
                LocConfessor.this.f48533f.onLocationUpdate(dIDILocation, this.mIntervalCount);
            }
        }

        public void onLocationError(int i, ErrInfo errInfo) {
            if (LocConfessor.this.f48533f != null) {
                LocConfessor.this.f48533f.onLocationErr(errInfo, this.mIntervalCount);
            }
        }
    }
}
