package com.didi.map.global.flow.utils;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.dimina.container.secondparty.trace.TraceActionServiceImpl;
import com.didi.map.global.flow.scene.vamos.sctx.driver.omega.VamosDriverSctxOmegaUtil;
import com.didi.map.global.flow.toolkit.nav.VamosNavModel;
import com.didi.map.global.flow.toolkit.nav.VamosNavSelectActivity;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class VamosNavUtils {

    /* renamed from: a */
    private static final String f29799a = (VamosNavUtils.class.getSimpleName() + "||");

    /* renamed from: b */
    private static String f29800b = "";

    /* renamed from: c */
    private static String f29801c = "";

    /* renamed from: d */
    private static String f29802d = "";

    /* renamed from: e */
    private static Map<String, String> f29803e = new HashMap();

    /* renamed from: f */
    private static boolean f29804f = false;

    /* renamed from: g */
    private static double f29805g;

    /* renamed from: h */
    private static double f29806h;
    public static String sCurChoice = "";

    static {
        m23090a();
        m23094b();
    }

    public static void checkAndStartNavigation(Context context, double d, double d2) {
        if (context == null) {
            trackEventOpenNavAppFailed();
            return;
        }
        f29805g = d;
        f29806h = d2;
        if (!TextUtils.isEmpty(sCurChoice) && !m23093a(context, sCurChoice)) {
            sCurChoice = "";
        }
        if (TextUtils.isEmpty(sCurChoice)) {
            m23091a(context);
            return;
        }
        startNavDirectly(context);
        trackEventClickNavBtn(1);
    }

    /* renamed from: a */
    private static void m23091a(Context context) {
        Intent intent = new Intent(context, VamosNavSelectActivity.class);
        intent.setFlags(268435456);
        context.startActivity(intent);
    }

    public static void startNavDirectly(Context context) {
        if (f29800b.equals(sCurChoice)) {
            m23092a(context, f29805g, f29806h);
        } else if (f29801c.equals(sCurChoice)) {
            m23095b(context, f29805g, f29806h);
        }
    }

    public static List<VamosNavModel> getCurNavAppList(Context context) {
        ArrayList arrayList = new ArrayList();
        Map<String, String> map = f29803e;
        if (map == null) {
            return arrayList;
        }
        if (map.containsKey(f29800b)) {
            String str = f29800b;
            arrayList.add(new VamosNavModel("Google Maps", str, m23093a(context, str)));
        }
        if (f29803e.containsKey(f29801c)) {
            String str2 = f29801c;
            arrayList.add(new VamosNavModel("Waze", str2, m23093a(context, str2)));
        }
        return arrayList;
    }

    /* renamed from: a */
    private static boolean m23093a(Context context, String str) {
        Intent intent;
        if (context.getPackageManager() == null) {
            return false;
        }
        try {
            intent = context.getPackageManager().getLaunchIntentForPackage(str);
        } catch (Exception e) {
            String str2 = f29799a;
            DLog.m10773d(str2, "PMS ex:" + e.getMessage(), new Object[0]);
            intent = null;
        }
        if (intent != null) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static void m23092a(Context context, double d, double d2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("https://www.google.com/maps/dir/?api=1&destination=" + d + "," + d2 + "&travelmode=driving&dir_action=navigate"));
            intent.setPackage("com.google.android.apps.maps");
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            trackEventOpenNavAppFailed();
            String str = f29799a;
            DLog.m10773d(str, "google nav failed:" + e.getMessage(), new Object[0]);
        }
    }

    /* renamed from: b */
    private static void m23095b(Context context, double d, double d2) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW", Uri.parse("waze://?ll=" + d + "," + d2 + "&navigate=yes"));
            intent.setFlags(268435456);
            context.startActivity(intent);
        } catch (Exception e) {
            trackEventOpenNavAppFailed();
            String str = f29799a;
            DLog.m10773d(str, "waze nav failed:" + e.getMessage(), new Object[0]);
        }
    }

    public static void goToGooglePlay(Context context, String str) {
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse("market://details?id=" + str));
            intent.setPackage(f29802d);
            if (intent.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent);
                return;
            }
            Intent intent2 = new Intent("android.intent.action.VIEW");
            intent2.setData(Uri.parse("https://play.google.com/store/apps/details?id=" + str));
            if (intent2.resolveActivity(context.getPackageManager()) != null) {
                context.startActivity(intent2);
            } else {
                DLog.m10773d(f29799a, "google play launch failed, no browser no store", new Object[0]);
            }
        } catch (Exception e) {
            String str2 = f29799a;
            DLog.m10773d(str2, "google play launch failed:" + e.getMessage(), new Object[0]);
        }
    }

    /* renamed from: a */
    private static void m23090a() {
        if (TextUtils.isEmpty(f29800b) || TextUtils.isEmpty(f29801c) || TextUtils.isEmpty(f29802d)) {
            IToggle toggle = Apollo.getToggle("global_map_nav_pkg_name");
            if (toggle.allow()) {
                String str = (String) toggle.getExperiment().getParam(TraceActionServiceImpl.PKG, "");
                if (!TextUtils.isEmpty(str)) {
                    try {
                        JSONObject jSONObject = new JSONObject(str);
                        f29800b = jSONObject.getString("pkgGoogleMap");
                        f29801c = jSONObject.getString("pkgWazeMap");
                        f29802d = jSONObject.getString("pkgPlayStore");
                    } catch (Exception e) {
                        DLog.m10773d(f29799a, e.toString(), new Object[0]);
                    }
                }
            }
            if (TextUtils.isEmpty(f29800b) || TextUtils.isEmpty(f29801c) || TextUtils.isEmpty(f29802d)) {
                f29800b = "com.google.android.apps.maps";
                f29801c = "com.waze";
                f29802d = "com.android.vending";
            }
        }
    }

    /* renamed from: b */
    private static void m23094b() {
        f29803e.put(f29800b, "1");
        f29803e.put(f29801c, "2");
        String navFilter = MapFlowApolloUtils.getNavFilter();
        if (!TextUtils.isEmpty(navFilter)) {
            try {
                JSONArray jSONArray = new JSONArray(navFilter);
                int length = jSONArray.length();
                for (int i = 0; i < length; i++) {
                    JSONObject optJSONObject = jSONArray.optJSONObject(i);
                    if (optJSONObject != null) {
                        String optString = optJSONObject.optString("navi_type");
                        String a = m23089a(optString);
                        if (!f29804f && !"unknown".equals(a)) {
                            f29803e.clear();
                            f29804f = true;
                        }
                        f29803e.put(a, optString);
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0025  */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x002d  */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static java.lang.String m23089a(java.lang.String r3) {
        /*
            int r0 = r3.hashCode()
            r1 = 49
            r2 = 1
            if (r0 == r1) goto L_0x0018
            r1 = 50
            if (r0 == r1) goto L_0x000e
            goto L_0x0022
        L_0x000e:
            java.lang.String r0 = "2"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0022
            r3 = 1
            goto L_0x0023
        L_0x0018:
            java.lang.String r0 = "1"
            boolean r3 = r3.equals(r0)
            if (r3 == 0) goto L_0x0022
            r3 = 0
            goto L_0x0023
        L_0x0022:
            r3 = -1
        L_0x0023:
            if (r3 == 0) goto L_0x002d
            if (r3 == r2) goto L_0x002a
            java.lang.String r3 = "unknown"
            return r3
        L_0x002a:
            java.lang.String r3 = f29801c
            return r3
        L_0x002d:
            java.lang.String r3 = f29800b
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.map.global.flow.utils.VamosNavUtils.m23089a(java.lang.String):java.lang.String");
    }

    public static void trackEventOpenNavAppFailed() {
        VamosDriverSctxOmegaUtil.onOpenNavAppFail();
    }

    public static void trackEventClickNavBtn(int i) {
        int i2;
        if (f29800b.equals(sCurChoice)) {
            i2 = 1;
        } else {
            i2 = f29801c.equals(sCurChoice) ? 2 : -1;
        }
        VamosDriverSctxOmegaUtil.onNavBtnClick(i2, i);
    }

    public static void clearChoiceCache() {
        sCurChoice = "";
    }
}
