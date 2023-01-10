package com.didi.map.sdk.navtracker;

import android.content.Context;
import android.util.Base64;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.navtracker.log.DLog;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONObject;

public class TrackerUploader {

    /* renamed from: a */
    private static final String f31024a = TrackerUploader.class.getSimpleName();

    /* renamed from: b */
    private static String f31025b = "https://apimap.didiglobal.com/metric/google/statements/";

    /* renamed from: c */
    private static int f31026c = 1;

    /* renamed from: d */
    private static int f31027d = 2;

    /* renamed from: e */
    private static ExecutorService f31028e = Executors.newSingleThreadExecutor();

    /* renamed from: a */
    static void m23798a(Context context, TrackerNavInfo trackerNavInfo, String str) {
        if (!ApolloUtil.INSTANCE.isNeedUploadByGoogleStatements()) {
            DLog.m23804d(f31024a, "[uploadNavInfo] do not upload due to Apollo global_map_nav_usage_ora_toggle", new Object[0]);
            return;
        }
        if (!TrackerNetUtils.isInitialized()) {
            TrackerNetUtils.init(context);
        }
        ExecutorService executorService = f31028e;
        if (executorService == null) {
            TrackerOmegaUtil.trackOraFail(106);
        } else {
            executorService.execute(new Runnable(context, trackerNavInfo, str) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ TrackerNavInfo f$1;
                public final /* synthetic */ String f$2;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                    this.f$2 = r3;
                }

                public final void run() {
                    TrackerUploader.m23802b(this.f$0, this.f$1, this.f$2);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m23802b(Context context, TrackerNavInfo trackerNavInfo, String str) {
        Gson gson = new Gson();
        ArrayList arrayList = new ArrayList();
        try {
            TrackerNavInfo[] trackerNavInfoArr = (TrackerNavInfo[]) gson.fromJson(TrackerPreference.getNavTrackList(context), TrackerNavInfo[].class);
            if (trackerNavInfoArr != null && trackerNavInfoArr.length > 0) {
                Collections.addAll(arrayList, trackerNavInfoArr);
            }
            arrayList.add(trackerNavInfo);
            TrackerPreference.setNavTrackList(gson.toJson((Object) arrayList), context);
            m23799a(context, str, f31027d, true);
        } catch (Exception e) {
            TrackerOmegaUtil.trackOraFailWithMsg(104, e.getMessage());
        }
    }

    /* renamed from: a */
    static void m23797a(Context context, TrackerMapInfo trackerMapInfo) {
        if (!ApolloUtil.INSTANCE.isNeedUploadByGoogleStatements()) {
            DLog.m23804d(f31024a, "[uploadMapInfo] do not upload due to Apollo global_map_nav_usage_ora_toggle", new Object[0]);
            return;
        }
        if (!TrackerNetUtils.isInitialized()) {
            TrackerNetUtils.init(context);
        }
        ExecutorService executorService = f31028e;
        if (executorService == null) {
            TrackerOmegaUtil.trackOraFail(106);
        } else {
            executorService.execute(new Runnable(context, trackerMapInfo) {
                public final /* synthetic */ Context f$0;
                public final /* synthetic */ TrackerMapInfo f$1;

                {
                    this.f$0 = r1;
                    this.f$1 = r2;
                }

                public final void run() {
                    TrackerUploader.m23801b(this.f$0, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ void m23801b(Context context, TrackerMapInfo trackerMapInfo) {
        Gson gson = new Gson();
        ArrayList arrayList = new ArrayList();
        try {
            TrackerMapInfo[] trackerMapInfoArr = (TrackerMapInfo[]) gson.fromJson(TrackerPreference.getMapTrackList(context), TrackerMapInfo[].class);
            if (trackerMapInfoArr != null && trackerMapInfoArr.length > 0) {
                Collections.addAll(arrayList, trackerMapInfoArr);
            }
            if (trackerMapInfo != null) {
                arrayList.add(trackerMapInfo);
            }
            m23800a(arrayList);
            if (arrayList.size() != 0) {
                TrackerPreference.setMapTrackList(gson.toJson((Object) arrayList), context);
                m23799a(context, UUID.randomUUID().toString(), f31026c, TrackerAdditionInfo.m23795a());
            }
        } catch (Exception e) {
            TrackerOmegaUtil.trackOraFailWithMsg(104, e.getMessage());
        }
    }

    /* renamed from: a */
    private static void m23799a(Context context, String str, int i, boolean z) {
        String str2;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("token", str);
            jSONObject.put("operationType", Integer.valueOf(i));
            if (i == f31026c) {
                str2 = TrackerPreference.getMapTrackList(context);
            } else {
                str2 = TrackerPreference.getNavTrackList(context);
            }
            jSONObject.put("message", Base64.encodeToString(str2.getBytes(), 0).replace("\n", ""));
            DLog.m23804d(f31024a, "upload params:" + jSONObject.toString(), new Object[0]);
            String str3 = PlatInfo.getInstance().getApiMapDomain() + "/metric/google/statements/";
            f31025b = str3;
            byte[] doPost = TrackerNetUtils.doPost(str3, jSONObject.toString().getBytes());
            if (doPost == null || doPost.length <= 0) {
                TrackerOmegaUtil.trackOraFail(102);
                return;
            }
            int i2 = new JSONObject(new String(doPost)).getInt("Code");
            if (i2 == 0) {
                String str4 = f31024a;
                StringBuilder sb = new StringBuilder();
                sb.append("track success with type: ");
                sb.append(i == f31026c ? "map" : "nav");
                DLog.m23804d(str4, sb.toString(), new Object[0]);
                if (z) {
                    m23796a(context, i);
                    return;
                }
                return;
            }
            DLog.m23804d(f31024a, "track failed: " + i2, new Object[0]);
            TrackerOmegaUtil.trackOraFailWithMsg(101, "" + i2);
        } catch (Exception e) {
            TrackerOmegaUtil.trackOraFailWithMsg(104, e.getMessage());
        }
    }

    /* renamed from: a */
    private static void m23796a(Context context, int i) {
        if (i == f31026c) {
            TrackerPreference.setMapTrackList("", context);
        } else if (i == f31027d) {
            TrackerPreference.setNavTrackList("", context);
        }
    }

    /* renamed from: a */
    private static void m23800a(List<TrackerMapInfo> list) {
        if (list != null && list.size() != 0) {
            try {
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                Iterator<TrackerMapInfo> it = list.iterator();
                while (it.hasNext()) {
                    TrackerMapInfo next = it.next();
                    if (currentTimeMillis - Long.valueOf(next.f31011dt).longValue() > 604800) {
                        it.remove();
                    } else {
                        next.countryCode = TrackerAdditionInfo.countryCode;
                        next.userId = TrackerAdditionInfo.usrId;
                        next.phoneNumber = TrackerAdditionInfo.phoneNum;
                        next.appVersion = TrackerAdditionInfo.appVersion;
                    }
                }
            } catch (Exception unused) {
            }
        }
    }
}
