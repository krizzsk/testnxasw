package com.didiglobal.privacysdk;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.didiglobal.privacysdk.GlobalPrivacyListeners;

public class GlobalPrivacySDK {

    /* renamed from: a */
    private static GlobalPrivacyThemeOptions f53103a = new GlobalPrivacyThemeOptions();

    /* renamed from: b */
    private static GlobalPrivacyListeners.WebViewListener f53104b;

    /* renamed from: c */
    private static GlobalPrivacyListeners.GetCommonInfoListener f53105c;

    /* renamed from: d */
    private static GlobalPrivacyListeners.ItemDisplayListener f53106d;

    /* renamed from: e */
    private static GlobalPrivacyListeners.IAppInfo f53107e;

    /* renamed from: f */
    private static GlobalPrivacyListeners.OnItemClickedListener f53108f;

    /* renamed from: g */
    private static GlobalPrivacyListeners.BaseActivityDelegate f53109g;

    /* renamed from: h */
    private static boolean f53110h;

    /* renamed from: i */
    private static int f53111i;

    /* renamed from: j */
    private static boolean f53112j = true;

    /* renamed from: k */
    private static boolean f53113k = false;

    /* renamed from: l */
    private static String f53114l = "";

    public static void init(GlobalPrivacyInitParam globalPrivacyInitParam) {
        f53104b = globalPrivacyInitParam.webViewListener;
        f53105c = globalPrivacyInitParam.getCommonInfoListener;
        f53107e = globalPrivacyInitParam.appInfo;
        f53108f = globalPrivacyInitParam.onItemClickedListener;
        f53109g = globalPrivacyInitParam.baseActivityDelegate;
        GlobalPrivacyListeners.IAppInfo iAppInfo = f53107e;
        if (iAppInfo != null) {
            f53106d = iAppInfo.getItemDisplayListener();
        }
        if (f53106d == null) {
            f53106d = new GlobalPrivacyListeners.ItemDisplayListener() {
                public boolean displayDeleteAccount() {
                    return false;
                }

                public boolean displayDiscountEmail() {
                    return false;
                }

                public boolean displayDiscountPush() {
                    return false;
                }

                public boolean displayDownloadData() {
                    return false;
                }

                public boolean displayLocationShare() {
                    return false;
                }

                public boolean displaySms() {
                    return false;
                }

                public boolean displaySystemPermission() {
                    return false;
                }
            };
        }
        f53110h = globalPrivacyInitParam.configThemeResInt;
        f53111i = globalPrivacyInitParam.themeResInt;
        f53112j = globalPrivacyInitParam.itemTitleBold;
        f53113k = globalPrivacyInitParam.finishActivityWhenAppRestarted;
        f53114l = globalPrivacyInitParam.downloadDataUrl;
    }

    public static void go2PrivacyActivity(Context context) {
        m39759a(context, PrivacyActivity.class);
    }

    public static GlobalPrivacyThemeOptions getGlobalPrivacyThemeOptions() {
        return f53103a;
    }

    public static void setGlobalPrivacyThemeOptions(GlobalPrivacyThemeOptions globalPrivacyThemeOptions) {
        f53103a = globalPrivacyThemeOptions;
    }

    public static GlobalPrivacyListeners.WebViewListener getWebViewListener() {
        return f53104b;
    }

    public static GlobalPrivacyListeners.GetCommonInfoListener getCommonInfoListener() {
        return f53105c;
    }

    public static String getAccountType() {
        GlobalPrivacyListeners.GetCommonInfoListener commonInfoListener = getCommonInfoListener();
        return commonInfoListener != null ? commonInfoListener.getAccountType() : "";
    }

    public static String getUserId() {
        GlobalPrivacyListeners.GetCommonInfoListener commonInfoListener = getCommonInfoListener();
        return commonInfoListener != null ? commonInfoListener.getUserId() : "";
    }

    public static String getToken() {
        GlobalPrivacyListeners.GetCommonInfoListener commonInfoListener = getCommonInfoListener();
        return commonInfoListener != null ? commonInfoListener.getToken() : "";
    }

    public static String getAppId(Context context) {
        GlobalPrivacyListeners.GetCommonInfoListener commonInfoListener = getCommonInfoListener();
        return commonInfoListener != null ? commonInfoListener.getAppId(context) : "";
    }

    public static String getAppType(Context context) {
        GlobalPrivacyListeners.GetCommonInfoListener commonInfoListener = getCommonInfoListener();
        return commonInfoListener != null ? commonInfoListener.getAppType(context) : "";
    }

    public static GlobalPrivacyListeners.ItemDisplayListener getItemDisplayListener() {
        return f53106d;
    }

    public static GlobalPrivacyListeners.IAppInfo getAppInfo() {
        return f53107e;
    }

    public static GlobalPrivacyListeners.OnItemClickedListener getOnItemClickedListener() {
        return f53108f;
    }

    public static void setOnItemClickedListener(GlobalPrivacyListeners.OnItemClickedListener onItemClickedListener) {
        f53108f = onItemClickedListener;
    }

    public static GlobalPrivacyListeners.BaseActivityDelegate getBaseActivityDelegate() {
        return f53109g;
    }

    public static boolean hasConfigThemeResInt() {
        return f53110h;
    }

    public static int getThemeResInt() {
        return f53111i;
    }

    public static boolean isItemTitleBold() {
        return f53112j;
    }

    public static boolean isFinishActivityWhenAppRestarted() {
        return f53113k;
    }

    public static String getDownloadDataUrl() {
        return f53114l;
    }

    /* renamed from: a */
    private static void m39759a(Context context, Class<?> cls) {
        Intent intent = new Intent(context, cls);
        if (!(context instanceof Activity)) {
            intent.addFlags(268435456);
        }
        context.startActivity(intent);
    }
}
