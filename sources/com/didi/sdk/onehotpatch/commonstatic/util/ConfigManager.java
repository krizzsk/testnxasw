package com.didi.sdk.onehotpatch.commonstatic.util;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import com.didi.dynamic.manager.utils.SharedPreferencesWrapper;
import com.didi.sdk.onehotpatch.commonstatic.log.Logger;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import global.didi.pay.newview.pix.IPixView;
import java.lang.reflect.Method;

public class ConfigManager {
    public static void init(final Context context) {
        new Handler(Looper.getMainLooper()).post(new Runnable() {
            public void run() {
                try {
                    Method declaredMethod = Class.forName(ApolloInvoker.class.getName(), false, context.getClassLoader()).getDeclaredMethod(IPixView.PAGE_STATUS_INIT, new Class[]{Context.class});
                    declaredMethod.setAccessible(true);
                    declaredMethod.invoke((Object) null, new Object[]{context});
                    Logger.info("ConfigManager.init ok", new Object[0]);
                } catch (Exception e) {
                    Logger.warn(e);
                }
            }
        });
    }

    /* access modifiers changed from: private */
    public static SharedPreferencesWrapper getSp(Context context) {
        return SharedPreferencesWrapper.m17955of(context, "hotpatch_config", 0);
    }

    public static boolean getBoolean(Context context, String str, boolean z) {
        return getSp(context).getBoolean(str, z);
    }

    public static boolean isSwitchAndroid12() {
        return Apollo.getToggle("hotfix_support12", false).allow();
    }

    public static int getInt(Context context, String str, int i) {
        return getSp(context).getInt(str, i);
    }

    public static String getString(Context context, String str, String str2) {
        return getSp(context).getString(str, str2);
    }

    static class ApolloInvoker {
        ApolloInvoker() {
        }

        static void init(final Context context) {
            Apollo.addToggleStateChangeListener(new OnToggleStateChangeListener() {
                /* JADX WARNING: Can't wrap try/catch for region: R(10:4|5|6|(4:9|(2:11|28)(2:12|29)|27|7)|13|14|(4:17|(2:19|32)(2:20|(2:22|33)(2:23|34))|30|15)|31|24|37) */
                /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x004d */
                /* JADX WARNING: Removed duplicated region for block: B:17:0x0057 A[Catch:{ all -> 0x0089 }] */
                /* Code decompiled incorrectly, please refer to instructions dump. */
                public void onStateChanged() {
                    /*
                        r6 = this;
                        java.lang.String r0 = "hotpatch_config"
                        com.didichuxing.apollo.sdk.IToggle r0 = com.didichuxing.apollo.sdk.Apollo.getToggle(r0)     // Catch:{ all -> 0x0089 }
                        boolean r1 = r0.allow()     // Catch:{ all -> 0x0089 }
                        if (r1 == 0) goto L_0x008d
                        com.didichuxing.apollo.sdk.IExperiment r0 = r0.getExperiment()     // Catch:{ all -> 0x0089 }
                        java.lang.String r1 = "config"
                        java.lang.String r2 = "{}"
                        java.lang.Object r0 = r0.getParam(r1, r2)     // Catch:{ all -> 0x0089 }
                        java.lang.String r0 = (java.lang.String) r0     // Catch:{ all -> 0x0089 }
                        org.json.JSONObject r1 = new org.json.JSONObject     // Catch:{ all -> 0x0089 }
                        r1.<init>(r0)     // Catch:{ all -> 0x0089 }
                        android.content.Context r0 = r1     // Catch:{ all -> 0x0089 }
                        com.didi.dynamic.manager.utils.SharedPreferencesWrapper r0 = com.didi.sdk.onehotpatch.commonstatic.util.ConfigManager.getSp(r0)     // Catch:{ all -> 0x0089 }
                        com.didi.dynamic.manager.utils.SharedPreferencesWrapper$Editor r2 = r0.edit()     // Catch:{ all -> 0x0089 }
                        java.util.Map r0 = r0.getAll()     // Catch:{ Exception -> 0x004d }
                        java.util.Set r0 = r0.keySet()     // Catch:{ Exception -> 0x004d }
                        java.util.Iterator r0 = r0.iterator()     // Catch:{ Exception -> 0x004d }
                    L_0x0036:
                        boolean r3 = r0.hasNext()     // Catch:{ Exception -> 0x004d }
                        if (r3 == 0) goto L_0x004d
                        java.lang.Object r3 = r0.next()     // Catch:{ Exception -> 0x004d }
                        java.lang.String r3 = (java.lang.String) r3     // Catch:{ Exception -> 0x004d }
                        boolean r4 = r1.has(r3)     // Catch:{ Exception -> 0x004d }
                        if (r4 == 0) goto L_0x0049
                        goto L_0x0036
                    L_0x0049:
                        r2.remove((java.lang.String) r3)     // Catch:{ Exception -> 0x004d }
                        goto L_0x0036
                    L_0x004d:
                        java.util.Iterator r0 = r1.keys()     // Catch:{ all -> 0x0089 }
                    L_0x0051:
                        boolean r3 = r0.hasNext()     // Catch:{ all -> 0x0089 }
                        if (r3 == 0) goto L_0x0085
                        java.lang.Object r3 = r0.next()     // Catch:{ all -> 0x0089 }
                        java.lang.String r3 = (java.lang.String) r3     // Catch:{ all -> 0x0089 }
                        java.lang.Object r4 = r1.get(r3)     // Catch:{ all -> 0x0089 }
                        boolean r5 = r4 instanceof java.lang.Boolean     // Catch:{ all -> 0x0089 }
                        if (r5 == 0) goto L_0x006f
                        java.lang.Boolean r4 = (java.lang.Boolean) r4     // Catch:{ all -> 0x0089 }
                        boolean r4 = r4.booleanValue()     // Catch:{ all -> 0x0089 }
                        r2.putBoolean((java.lang.String) r3, (boolean) r4)     // Catch:{ all -> 0x0089 }
                        goto L_0x0051
                    L_0x006f:
                        boolean r5 = r4 instanceof java.lang.Integer     // Catch:{ all -> 0x0089 }
                        if (r5 == 0) goto L_0x007d
                        java.lang.Integer r4 = (java.lang.Integer) r4     // Catch:{ all -> 0x0089 }
                        int r4 = r4.intValue()     // Catch:{ all -> 0x0089 }
                        r2.putInt((java.lang.String) r3, (int) r4)     // Catch:{ all -> 0x0089 }
                        goto L_0x0051
                    L_0x007d:
                        java.lang.String r4 = java.lang.String.valueOf(r4)     // Catch:{ all -> 0x0089 }
                        r2.putString((java.lang.String) r3, (java.lang.String) r4)     // Catch:{ all -> 0x0089 }
                        goto L_0x0051
                    L_0x0085:
                        r2.apply()     // Catch:{ all -> 0x0089 }
                        goto L_0x008d
                    L_0x0089:
                        r0 = move-exception
                        com.didi.sdk.onehotpatch.commonstatic.log.Logger.warn(r0)
                    L_0x008d:
                        return
                    */
                    throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.onehotpatch.commonstatic.util.ConfigManager.ApolloInvoker.C135141.onStateChanged():void");
                }
            });
        }
    }
}
