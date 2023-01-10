package com.didi.dvm.patch.dvm_patch;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.omega.sdk.Omega;
import com.didichuxing.request.ServerParam;
import com.didiglobal.ddmirror.monitor.PrismConstants;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import java.io.File;
import java.io.IOException;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DVMPatchManager {

    /* renamed from: a */
    static File f21153a;

    /* renamed from: b */
    static File f21154b;

    /* renamed from: c */
    static EventTracker f21155c = new C8556a();

    /* renamed from: d */
    static WeakReference<DvmPatchPlugin> f21156d;

    /* renamed from: e */
    static String f21157e = "";

    /* renamed from: f */
    static String f21158f;

    /* renamed from: g */
    static String f21159g;

    /* renamed from: h */
    static Context f21160h;

    /* renamed from: i */
    static Set<String> f21161i;

    /* renamed from: j */
    static Boolean f21162j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public static JSONObject f21163k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public static JSONObject f21164l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public static Logger f21165m = LoggerFactory.getLogger("DVMPatchManager");

    /* renamed from: n */
    private static List<String> f21166n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public static Map<String, PatchElement> f21167o = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: p */
    public static Map<String, PatchElement> f21168p = new ConcurrentHashMap();
    public static File tempDir;

    /* renamed from: m */
    private static boolean m17864m() {
        return false;
    }

    public static void setEventTracker(EventTracker eventTracker) {
        if (eventTracker != null) {
            f21155c = eventTracker;
        }
    }

    public static IToggle getToggle() {
        return Apollo.getToggle(m17849a());
    }

    /* renamed from: a */
    static String m17849a() {
        return "dvm_config_" + f21157e;
    }

    public static void setShowDebugTag(Boolean bool) {
        f21162j = bool;
    }

    public static void addDebugPatch(String str) {
        if (f21166n == null) {
            f21166n = new ArrayList();
        }
        f21166n.add(str);
    }

    public static File getDvmPatchDir(String str) {
        return new File(f21154b, str);
    }

    public static void init(Context context, String str) {
        f21160h = context;
        f21157e = str;
        f21153a = new File(f21160h.getFilesDir(), "dvm");
        f21154b = new File(f21153a, "patches");
        tempDir = new File(f21160h.getCacheDir(), "dvm");
        Omega.init(f21160h);
        try {
            PackageInfo packageInfo = SystemUtils.getPackageInfo(f21160h.getPackageManager(), f21160h.getPackageName(), 0);
            f21158f = "" + packageInfo.versionCode;
            f21159g = packageInfo.versionName;
            Logger logger = f21165m;
            logger.debug("DVM PatchPlugin oid:" + Omega.getOmegaIdSafety() + ",isInDebugModel=" + m17864m(), new Object[0]);
            if (m17864m()) {
                for (int i = 0; i < f21166n.size(); i++) {
                    PatchElement patchElement = (PatchElement) new Gson().fromJson(f21166n.get(i), PatchElement.class);
                    f21167o.put(patchElement.getPackageName(), patchElement);
                }
                m17862k();
            } else if (!m17861j()) {
                Logger logger2 = f21165m;
                logger2.debug("DVM PatchPlugin ab is not allowed (ab key= " + m17849a() + ")", new Object[0]);
            } else {
                HashMap hashMap = new HashMap();
                hashMap.put("appKey", str);
                hashMap.put("oid", Omega.getOmegaIdSafety());
                hashMap.put("os_type", "android");
                hashMap.put(ServerParam.PARAM_OS_VERSION, Build.VERSION.RELEASE);
                Bff.call(new IBffProxy.Ability.Builder(f21160h, "flutter/hotFix").setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
                    public void onSuccess(JsonObject jsonObject) {
                        Logger c = DVMPatchManager.f21165m;
                        c.debug("DVM PatchPlugin response:" + jsonObject, new Object[0]);
                        PatchResponse patchResponse = (PatchResponse) new Gson().fromJson((JsonElement) jsonObject, PatchResponse.class);
                        if (patchResponse.hasData()) {
                            DVMPatchManager.f21168p.clear();
                            DVMPatchManager.f21167o.clear();
                            for (Map.Entry next : patchResponse.data.patchDataMap.entrySet()) {
                                PatchElement patchElement = (PatchElement) next.getValue();
                                patchElement.f21171id = (String) next.getKey();
                                boolean isVersionMatch = patchElement.isVersionMatch();
                                Logger c2 = DVMPatchManager.f21165m;
                                c2.debug("patch id:" + patchElement.f21171id + ",action:" + patchElement.action + ",isVersionMatch:" + isVersionMatch, new Object[0]);
                                if (!patchElement.isIdAvailable()) {
                                    Logger c3 = DVMPatchManager.f21165m;
                                    c3.debug("id:" + patchElement.f21171id + " id is not available", new Object[0]);
                                    HashMap hashMap = new HashMap();
                                    hashMap.put("id", patchElement.f21171id);
                                    DVMPatchManager.f21155c.mo63966a("tech_dvm_patch_parse_packageid_error", hashMap);
                                } else if (patchElement.action == PatchElement.ACTION_ADD_AND_UPDATE && isVersionMatch) {
                                    PatchElement patchElement2 = (PatchElement) DVMPatchManager.f21167o.get(patchElement.getPackageName());
                                    if (patchElement2 == null) {
                                        DVMPatchManager.f21167o.put(patchElement.getPackageName(), patchElement);
                                    } else if (patchElement.version > patchElement2.version) {
                                        DVMPatchManager.f21167o.put(patchElement.getPackageName(), patchElement);
                                    }
                                } else if (patchElement.action == PatchElement.ACTION_ROLLBACK) {
                                    DVMPatchManager.f21168p.put(patchElement.f21171id, patchElement);
                                }
                            }
                            DVMPatchManager.m17862k();
                        }
                    }

                    public void onFailure(IOException iOException) {
                        iOException.printStackTrace();
                        HashMap hashMap = new HashMap();
                        hashMap.put("vn", DVMPatchManager.f21159g);
                        hashMap.put(PrismConstants.Symbol.VIEW_CLASS, DVMPatchManager.f21158f);
                        hashMap.put("e", iOException.toString());
                        hashMap.put(RavenKey.STACK, EventTracker.getStackTrace(iOException));
                        DVMPatchManager.f21155c.mo63966a("tech_dvm_patch_request_error", hashMap);
                    }
                }).build());
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
    }

    /* renamed from: j */
    private static boolean m17861j() {
        return ((Integer) getParam("enable", 1)).intValue() == 1;
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public static void m17862k() {
        f21161i = Collections.synchronizedSet(new HashSet());
        for (Map.Entry<String, PatchElement> value : f21167o.entrySet()) {
            f21161i.add(((PatchElement) value.getValue()).f21171id);
        }
        if (f21167o.size() > 0 || f21168p.size() > 0) {
            new Thread(new Runnable() {
                public void run() {
                    DVMPatchManager.m17863l();
                }
            }).start();
        } else {
            takeEffect(true);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public static void m17863l() {
        try {
            for (Map.Entry<String, PatchElement> value : f21168p.entrySet()) {
                ((PatchElement) value.getValue()).rollback();
            }
            DVMPatchDownloader dVMPatchDownloader = new DVMPatchDownloader();
            for (Map.Entry<String, PatchElement> value2 : f21167o.entrySet()) {
                PatchElement patchElement = (PatchElement) value2.getValue();
                if (!patchElement.isVersionMatch()) {
                    Logger logger = f21165m;
                    logger.debug(patchElement.f21171id + " is not Version Match", new Object[0]);
                } else if (patchElement.isDownloaded()) {
                    Logger logger2 = f21165m;
                    logger2.debug(patchElement.f21171id + " is Downloaded", new Object[0]);
                } else {
                    dVMPatchDownloader.addTask(patchElement);
                }
            }
            dVMPatchDownloader.start();
        } catch (Exception e) {
            e.printStackTrace();
            HashMap hashMap = new HashMap();
            hashMap.put("response", f21167o.toString());
            hashMap.put("vn", f21159g);
            hashMap.put(PrismConstants.Symbol.VIEW_CLASS, f21158f);
            hashMap.put("e", e.toString());
            hashMap.put(RavenKey.STACK, EventTracker.getStackTrace(e));
            f21155c.mo63966a("tech_dvm_patch_request_error", hashMap);
        }
    }

    public static <T> T getParam(String str, T t) {
        try {
            return Apollo.getToggle(m17849a()).getExperiment().getParam(str, t);
        } catch (Exception e) {
            f21165m.error(e.getMessage(), new Object[0]);
            return t;
        }
    }

    /* renamed from: a */
    static JSONObject m17850a(DvmPatchPlugin dvmPatchPlugin) {
        f21156d = new WeakReference<>(dvmPatchPlugin);
        if (m17864m() || m17861j()) {
            JSONObject jSONObject = new JSONObject();
            JSONObject jSONObject2 = new JSONObject();
            m17853b();
            try {
                if (!m17864m()) {
                    jSONObject.put("showDebug", ((Integer) getParam("show_banner", 0)).intValue() == 1);
                } else if (f21162j != null) {
                    jSONObject.put("showDebug", f21162j.booleanValue());
                }
                jSONObject.put("data", jSONObject2);
                Iterator<String> keys = f21163k.keys();
                boolean z = false;
                while (keys.hasNext()) {
                    String next = keys.next();
                    PatchElement fromControlFile = PatchElement.fromControlFile(f21163k.getJSONObject(next));
                    fromControlFile.f21171id = next;
                    if (!fromControlFile.selfChecking().f21172ok) {
                        z = true;
                    } else {
                        String nameSpace = fromControlFile.getNameSpace();
                        JSONArray optJSONArray = jSONObject2.optJSONArray(nameSpace);
                        if (optJSONArray == null) {
                            optJSONArray = new JSONArray();
                            jSONObject2.put(nameSpace, optJSONArray);
                        }
                        optJSONArray.put(fromControlFile.getPatchInfo());
                    }
                }
                if (z) {
                    takeEffect(true);
                }
                f21165m.debug(jSONObject.toString(), new Object[0]);
                return jSONObject;
            } catch (Exception e) {
                f21165m.error("getPatchesInfo error", (Throwable) e);
                return null;
            }
        } else {
            f21165m.debug("getPatchesInfo ab is not allow", new Object[0]);
            return null;
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:19:0x003f A[SYNTHETIC, Splitter:B:19:0x003f] */
    /* JADX WARNING: Removed duplicated region for block: B:27:0x004c A[SYNTHETIC, Splitter:B:27:0x004c] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static org.json.JSONObject readFile2JSON(java.io.File r4) {
        /*
            boolean r0 = r4.exists()
            r1 = 0
            if (r0 != 0) goto L_0x0008
            return r1
        L_0x0008:
            java.io.FileInputStream r0 = new java.io.FileInputStream     // Catch:{ IOException -> 0x0033, JSONException -> 0x0031, all -> 0x002f }
            r0.<init>(r4)     // Catch:{ IOException -> 0x0033, JSONException -> 0x0031, all -> 0x002f }
            int r4 = r0.available()     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            byte[] r4 = new byte[r4]     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            r0.read(r4)     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            java.lang.String r2 = new java.lang.String     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            java.lang.String r3 = "UTF-8"
            r2.<init>(r4, r3)     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            org.json.JSONObject r4 = new org.json.JSONObject     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            r4.<init>(r2)     // Catch:{ IOException -> 0x002d, JSONException -> 0x002b }
            r0.close()     // Catch:{ IOException -> 0x0026 }
            goto L_0x002a
        L_0x0026:
            r0 = move-exception
            r0.printStackTrace()
        L_0x002a:
            return r4
        L_0x002b:
            r4 = move-exception
            goto L_0x0035
        L_0x002d:
            r4 = move-exception
            goto L_0x0035
        L_0x002f:
            r4 = move-exception
            goto L_0x004a
        L_0x0031:
            r4 = move-exception
            goto L_0x0034
        L_0x0033:
            r4 = move-exception
        L_0x0034:
            r0 = r1
        L_0x0035:
            com.didi.sdk.logging.Logger r2 = f21165m     // Catch:{ all -> 0x0048 }
            java.lang.String r3 = "readFile2JSON error"
            r2.error((java.lang.String) r3, (java.lang.Throwable) r4)     // Catch:{ all -> 0x0048 }
            if (r0 == 0) goto L_0x0047
            r0.close()     // Catch:{ IOException -> 0x0043 }
            goto L_0x0047
        L_0x0043:
            r4 = move-exception
            r4.printStackTrace()
        L_0x0047:
            return r1
        L_0x0048:
            r4 = move-exception
            r1 = r0
        L_0x004a:
            if (r1 == 0) goto L_0x0054
            r1.close()     // Catch:{ IOException -> 0x0050 }
            goto L_0x0054
        L_0x0050:
            r0 = move-exception
            r0.printStackTrace()
        L_0x0054:
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.DVMPatchManager.readFile2JSON(java.io.File):org.json.JSONObject");
    }

    /* renamed from: b */
    static void m17853b() {
        if (f21163k == null) {
            try {
                f21163k = new JSONObject(SystemUtils.getSharedPreferences(f21160h, "___dvm", 0).getString(ParamKeys.PARAM_CONTROL, "{}"));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            if (f21163k == null) {
                f21163k = new JSONObject();
            }
        }
    }

    public static void takeEffect(final boolean z) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    for (Map.Entry value : DVMPatchManager.f21167o.entrySet()) {
                        PatchElement patchElement = (PatchElement) value.getValue();
                        if (patchElement.selfChecking().f21172ok) {
                            jSONObject.put(patchElement.f21171id, patchElement.getControlInfo());
                        }
                    }
                    JSONObject unused = DVMPatchManager.f21164l = DVMPatchManager.f21163k;
                    JSONObject unused2 = DVMPatchManager.f21163k = jSONObject;
                    if (z) {
                        if (DVMPatchManager.f21164l != null && DVMPatchManager.f21164l.toString().equals(jSONObject.toString())) {
                            DVMPatchManager.f21165m.debug("save control file : is same,ignore", new Object[0]);
                            return;
                        }
                        SharedPreferences.Editor edit = SystemUtils.getSharedPreferences(DVMPatchManager.f21160h, "___dvm", 0).edit();
                        String jSONObject2 = DVMPatchManager.f21163k.toString();
                        edit.putString(ParamKeys.PARAM_CONTROL, jSONObject2).apply();
                        Logger c = DVMPatchManager.f21165m;
                        c.debug("save control file :" + jSONObject2, new Object[0]);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0004, code lost:
        r0 = (com.didi.dvm.patch.dvm_patch.DvmPatchPlugin) r0.get();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static void tryRefresh() {
        /*
            java.lang.ref.WeakReference<com.didi.dvm.patch.dvm_patch.DvmPatchPlugin> r0 = f21156d
            if (r0 == 0) goto L_0x001d
            java.lang.Object r0 = r0.get()
            com.didi.dvm.patch.dvm_patch.DvmPatchPlugin r0 = (com.didi.dvm.patch.dvm_patch.DvmPatchPlugin) r0
            if (r0 == 0) goto L_0x001d
            android.os.Handler r1 = new android.os.Handler
            android.os.Looper r2 = android.os.Looper.getMainLooper()
            r1.<init>(r2)
            com.didi.dvm.patch.dvm_patch.DVMPatchManager$4 r2 = new com.didi.dvm.patch.dvm_patch.DVMPatchManager$4
            r2.<init>()
            r1.post(r2)
        L_0x001d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dvm.patch.dvm_patch.DVMPatchManager.tryRefresh():void");
    }
}
