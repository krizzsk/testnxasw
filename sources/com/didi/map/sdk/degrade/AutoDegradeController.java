package com.didi.map.sdk.degrade;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import com.didi.map.sdk.navtracker.TrackerPreference;
import com.didi.map.sdk.navtracker.log.DLog;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class AutoDegradeController {

    /* renamed from: a */
    private static String f30535a = "sp_map_degrade";

    /* renamed from: b */
    private static String f30536b = "sp_map_degrade_data_didi";

    /* renamed from: c */
    private static String f30537c = "sp_map_degrade_data_google";

    /* renamed from: d */
    private static AutoDegradeController f30538d;

    /* renamed from: e */
    private Context f30539e;

    /* renamed from: f */
    private ApolloGetter f30540f = ApolloGetter.get();

    /* renamed from: g */
    private boolean f30541g;

    /* renamed from: h */
    private ICrashMonitor f30542h;

    /* renamed from: i */
    private DegradeCacheData f30543i;

    /* renamed from: j */
    private DegradeMode f30544j = DegradeMode.GOOGLE;

    private AutoDegradeController(Context context) {
        this.f30539e = context.getApplicationContext();
        if (this.f30540f != null) {
            DLog.m23804d("ccc", "mApolloGetter:" + this.f30540f.toString(), new Object[0]);
            return;
        }
        DLog.m23804d("ccc", "mApolloGetter is null, break", new Object[0]);
    }

    public static AutoDegradeController getInstance(Context context) {
        if (f30538d == null) {
            synchronized (AutoDegradeController.class) {
                if (f30538d == null) {
                    f30538d = new AutoDegradeController(context);
                }
            }
        }
        return f30538d;
    }

    public ApolloGetter getApolloGetter() {
        return this.f30540f;
    }

    public boolean isNeedDegradeToLaunch(DegradeMode degradeMode) {
        long j;
        long j2;
        if (this.f30540f == null) {
            DLog.m23804d("ccc", "mApolloGetter is null return false", new Object[0]);
            return false;
        }
        DLog.m23804d("ccc", "isNeedDegradeToLaunch:" + degradeMode.toString(), new Object[0]);
        this.f30544j = degradeMode;
        String str = "";
        if (degradeMode == DegradeMode.DIDI) {
            str = SystemUtils.getSharedPreferences(this.f30539e, f30535a, 0).getString(f30536b, str);
        } else if (degradeMode == DegradeMode.GOOGLE) {
            str = SystemUtils.getSharedPreferences(this.f30539e, f30535a, 0).getString(f30537c, str);
        }
        if (!TextUtils.isEmpty(str)) {
            try {
                DegradeCacheData degradeCacheData = (DegradeCacheData) new Gson().fromJson(str, DegradeCacheData.class);
                this.f30543i = degradeCacheData;
                degradeCacheData.doLog();
                if (this.f30540f.valid_time != -1) {
                    j = this.f30543i.createTime;
                    j2 = (long) (this.f30540f.valid_time * 1000);
                } else {
                    j = this.f30543i.createTime;
                    j2 = this.f30543i.validTime * 1000 * 60 * 10;
                }
                long j3 = j + j2;
                if (this.f30543i.tag && j3 > System.currentTimeMillis()) {
                    return true;
                }
                if (this.f30543i.tag && j3 <= System.currentTimeMillis()) {
                    DLog.m23804d("ccc", "isNeedDegrade: 恢复", new Object[0]);
                    m23562a();
                }
            } catch (Exception e) {
                DLog.m23804d("ccc", "isNeedDegrade: " + e.toString(), new Object[0]);
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m23562a() {
        if (this.f30539e != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("time", Long.valueOf(System.currentTimeMillis() / 1000));
            hashMap.put("app_name", this.f30539e.getPackageName());
            hashMap.put("os", 1);
            hashMap.put("phone_num", TrackerPreference.getPhoneNum(this.f30539e));
            hashMap.put("country_code", TrackerPreference.getCountryCode(this.f30539e));
            hashMap.put("app_version", TrackerPreference.getAppVersion(this.f30539e));
            hashMap.put("user_id", TrackerPreference.getUserId(this.f30539e));
            OmegaSDKAdapter.trackEvent("tech_global_map_degrade_stop", (Map<String, Object>) hashMap);
            DLog.m23804d("ccc", "triggered tech_global_map_degrade_stop", new Object[0]);
        }
    }

    public void onAppLaunched(DegradeMode degradeMode) {
        DegradeCacheData degradeCacheData;
        DLog.m23804d("ccc", "onAppLaunched", new Object[0]);
        if (this.f30540f == null) {
            DLog.m23804d("ccc", "onAppLaunched but apollo is null", new Object[0]);
        } else if (this.f30544j == DegradeMode.GOOGLE && this.f30540f.down_gmap_mode != 1) {
            DLog.m23804d("ccc", "onAppLaunched but GoogleMap should not auto degrade", new Object[0]);
        } else if (this.f30544j != DegradeMode.DIDI || this.f30540f.down_dmap_mode == 1) {
            if (!this.f30541g && this.f30544j == degradeMode && (degradeCacheData = this.f30543i) != null) {
                if (degradeCacheData.launch_near_time != -1) {
                    this.f30543i.list = null;
                    this.f30543i.validTime = -1;
                    this.f30543i.createTime = -1;
                    this.f30543i.tag = false;
                    this.f30543i.count = 0;
                }
                this.f30543i.launch_near_time = System.currentTimeMillis();
                SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f30539e, f30535a, 0).edit();
                DLog.m23804d("ccc", "onAppLaunched-doLog", new Object[0]);
                this.f30543i.doLog();
                if (this.f30544j == DegradeMode.DIDI) {
                    edit.putString(f30536b, new Gson().toJson((Object) this.f30543i));
                } else if (this.f30544j == DegradeMode.GOOGLE) {
                    edit.putString(f30537c, new Gson().toJson((Object) this.f30543i));
                }
                edit.apply();
            }
            this.f30541g = true;
            if (this.f30544j == degradeMode) {
                m23564b();
            }
        } else {
            DLog.m23804d("ccc", "onAppLaunched but DDMap should not auto degrade", new Object[0]);
        }
    }

    public boolean isDebug(Context context) {
        return (context.getApplicationInfo() == null || (context.getApplicationInfo().flags & 2) == 0) ? false : true;
    }

    /* renamed from: b */
    private void m23564b() {
        Context context;
        if (this.f30541g && (context = this.f30539e) != null) {
            if (this.f30542h == null) {
                this.f30542h = CrashMonitorFactory.create(context);
            }
            this.f30542h.start(new ICrashListener() {
                public final void onCrashed(String str) {
                    AutoDegradeController.this.m23563a(str);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m23563a(String str) {
        if (this.f30540f == null) {
            DLog.m23804d("ccc", "mApolloGetter is null and do not monitor", new Object[0]);
            return;
        }
        if (this.f30543i == null) {
            this.f30543i = new DegradeCacheData();
        }
        DLog.m23804d("ccc", "startCrashMonitor---1 reason:" + str, new Object[0]);
        this.f30543i.launch_near_time = -1;
        if (this.f30543i.list == null) {
            this.f30543i.list = new ArrayList();
        }
        this.f30543i.list.add(new CrashDetail(System.currentTimeMillis(), str));
        DLog.m23804d("ccc", "startCrashMonitor---2 crash item size: " + this.f30543i.list.size(), new Object[0]);
        int i = 0;
        for (int size = this.f30543i.list.size() - 1; size >= 0; size--) {
            DLog.m23804d("ccc", "startCrashMonitor---3", new Object[0]);
            CrashDetail crashDetail = this.f30543i.list.get(size);
            if (crashDetail != null) {
                if (System.currentTimeMillis() - crashDetail.time > ((long) (this.f30540f.time_range * 1000))) {
                    this.f30543i.list.remove(crashDetail);
                    DLog.m23804d("ccc", "startCrashMonitor---4", new Object[0]);
                } else if (!TextUtils.isEmpty(this.f30540f.key)) {
                    DLog.m23804d("ccc", "startCrashMonitor---5", new Object[0]);
                    if (!TextUtils.isEmpty(crashDetail.stack)) {
                        DLog.m23804d("ccc", "startCrashMonitor---6", new Object[0]);
                        if (crashDetail.stack.contains(this.f30540f.key)) {
                            DLog.m23804d("ccc", "startCrashMonitor---7", new Object[0]);
                            i++;
                        }
                    }
                } else {
                    DLog.m23804d("ccc", "startCrashMonitor---8", new Object[0]);
                }
            }
        }
        DLog.m23804d("ccc", "count =" + i, new Object[0]);
        if (i >= this.f30540f.crash_count) {
            DLog.m23804d("ccc", "startCrashMonitor---9", new Object[0]);
            this.f30543i.list = null;
            this.f30543i.tag = true;
            this.f30543i.count++;
            this.f30543i.createTime = System.currentTimeMillis();
            DegradeCacheData degradeCacheData = this.f30543i;
            degradeCacheData.validTime = (long) (degradeCacheData.count * 2);
        }
        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(this.f30539e, f30535a, 0).edit();
        DLog.m23804d("ccc", "startCrashMonitor--11", new Object[0]);
        this.f30543i.doLog();
        if (this.f30544j == DegradeMode.DIDI) {
            edit.putString(f30536b, new Gson().toJson((Object) this.f30543i));
        } else if (this.f30544j == DegradeMode.GOOGLE) {
            edit.putString(f30537c, new Gson().toJson((Object) this.f30543i));
        }
        edit.commit();
    }

    public void clearAllCachedData(DegradeMode degradeMode) {
        try {
            SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(this.f30539e, f30535a, 0);
            if (sharedPreferences != null) {
                SharedPreferences.Editor edit = sharedPreferences.edit();
                if (degradeMode == DegradeMode.DIDI) {
                    edit.putString(f30536b, "").apply();
                } else if (degradeMode == DegradeMode.GOOGLE) {
                    edit.putString(f30537c, "").apply();
                }
                DLog.m23804d("ccc", "all data delete", new Object[0]);
            }
        } catch (Exception unused) {
        }
    }
}
