package com.didi.beatles.p101im;

import android.content.Context;
import android.os.Looper;
import com.didi.beatles.p101im.access.IMCommonContext;
import com.didi.beatles.p101im.access.audio.IMAudioConfig;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.utils.UiThreadHandler;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.IMCommonContextInfoHelper */
public class IMCommonContextInfoHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static volatile IMCommonContext f10519a = null;

    /* renamed from: b */
    private static final String f10520b = "im-sdk";

    /* renamed from: c */
    private static Context f10521c;

    /* renamed from: d */
    private static boolean f10522d;

    /* renamed from: e */
    private static boolean f10523e;

    /* renamed from: f */
    private static IMAudioConfig f10524f;

    public static boolean getBottomConfig(int i) {
        return true;
    }

    public static ArrayList<String> getEmojiList() {
        return null;
    }

    public static int getRecentMessagesCount4Feed(long j) {
        return j == 1153205327579062703L ? 2 : 6;
    }

    public static void inject(Context context, IMCommonContext iMCommonContext) {
        f10519a = iMCommonContext;
        f10521c = context.getApplicationContext();
    }

    public static boolean isInject() {
        return f10519a != null;
    }

    public static boolean isUseFeed() {
        if (!f10523e) {
            f10522d = f10519a != null ? f10519a.showFeed() : false;
            f10523e = true;
        }
        return f10522d;
    }

    public static void destory() {
        if (f10519a == null) {
            return;
        }
        if (Thread.currentThread() == Looper.getMainLooper().getThread()) {
            f10519a = null;
        } else {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    IMCommonContext unused = IMCommonContextInfoHelper.f10519a = null;
                }
            });
        }
    }

    public static boolean isLogingNow() {
        if (f10519a != null) {
            return f10519a.isLoginNow();
        }
        return false;
    }

    public static long getUid() {
        if (f10519a != null) {
            return f10519a.getUid();
        }
        return 0;
    }

    public static String getToken() {
        return f10519a != null ? f10519a.getToken() : "ErrorToken";
    }

    public static String getAppVersion() {
        return f10519a != null ? f10519a.getVersionName() : "ErrorVersion";
    }

    public static Context getContext() {
        return f10521c;
    }

    public static String getDeviceId() {
        return f10519a != null ? f10519a.getDeviceId() : "ErrorDeviceId";
    }

    public static IMCommonContext getInfoProvider() {
        return f10519a;
    }

    public static Class<?> getAppMainClass() {
        if (f10519a != null) {
            return f10519a.getAppMainClass();
        }
        return null;
    }

    public static boolean isMainActivityAlive() {
        if (f10519a != null) {
            return f10519a.isMainActivityAlive();
        }
        return false;
    }

    public static String getBusinessPayload(String str) {
        if (f10519a != null) {
            return f10519a.getPayload(str);
        }
        IMLog.m10020d(f10520b, "getBusinessPayload failed while sInfoProvider is null !");
        return null;
    }

    public static boolean isUseInnerStorage() {
        if (f10519a != null) {
            return f10519a.isUseInnerStorage();
        }
        return false;
    }

    public static boolean isPad() {
        if (f10519a != null) {
            return f10519a.isPad();
        }
        return false;
    }

    public static int getAppChannel() {
        if (f10519a != null) {
            return f10519a.getAppChannel();
        }
        return 0;
    }

    public static int getActivityTheme() {
        if (f10519a != null) {
            return f10519a.getActivityTheme();
        }
        return 0;
    }

    public static String getWebActivityScheme() {
        if (f10519a != null) {
            return f10519a.getWebActivityScheme();
        }
        return null;
    }

    public static boolean handLink(Context context, String str) {
        if (f10519a != null) {
            return f10519a.handLink(context, str);
        }
        return false;
    }

    public static String setSettingPageScheme() {
        if (f10519a != null) {
            return f10519a.setSettingPageScheme();
        }
        return null;
    }

    public static Locale getLocale() {
        if (f10519a != null) {
            return f10519a.getLocale();
        }
        return null;
    }

    public static String getPackageName() {
        Context context = f10521c;
        return context != null ? context.getPackageName() : "null";
    }

    public static IMAudioConfig getAudioConfig() {
        if (f10524f == null) {
            IMAudioConfig iMAudioConfig = null;
            if (f10519a != null) {
                iMAudioConfig = f10519a.getAudioConfig();
            }
            if (iMAudioConfig == null) {
                iMAudioConfig = new IMAudioConfig();
            }
            f10524f = iMAudioConfig;
        }
        return f10524f;
    }
}
