package com.didi.beatles.p101im;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import com.didi.beatles.p101im.access.IMContext;
import com.didi.beatles.p101im.access.audio.IMAudioConfig;
import com.didi.beatles.p101im.access.briage.IMCustomChatRowProviderImpl;
import com.didi.beatles.p101im.access.style.IMStyleManager;
import com.didi.beatles.p101im.access.style.custom.IMCustomResBuilder;
import com.didi.beatles.p101im.access.style.custom.IMCustomViewBuilder;
import com.didi.beatles.p101im.access.utils.IMBusinessConfig;
import com.didi.beatles.p101im.utils.C4786I;
import com.didi.beatles.p101im.utils.IMLog;
import com.didi.beatles.p101im.views.IMCustomChatRowProvider;
import com.didichuxing.apollo.sdk.Apollo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.IMContextInfoHelper */
public class IMContextInfoHelper {

    /* renamed from: a */
    private static IMContext f10525a = null;

    /* renamed from: b */
    private static final String f10526b = "im-sdk";

    /* renamed from: c */
    private static Context f10527c = null;

    /* renamed from: d */
    private static boolean f10528d = false;

    /* renamed from: e */
    private static boolean f10529e = false;

    /* renamed from: f */
    private static IMAudioConfig f10530f = null;

    /* renamed from: g */
    private static int f10531g = -1;

    /* renamed from: h */
    private static int f10532h = -1;

    /* renamed from: i */
    private static int f10533i = -1;

    /* renamed from: j */
    private static boolean f10534j = false;

    /* renamed from: k */
    private static boolean f10535k = false;

    public static boolean getBottomConfig(int i) {
        return true;
    }

    public static ArrayList<String> getEmojiList() {
        return null;
    }

    public static int getRecentMessagesCount4Feed(long j) {
        return j == 1153205327579062703L ? 2 : 6;
    }

    @Deprecated
    public static boolean isCipherDisable() {
        return true;
    }

    public static void inject(Context context, IMContext iMContext) {
        f10525a = iMContext;
        f10527c = context.getApplicationContext();
        IMCommonContextInfoHelper.inject(context, iMContext);
    }

    public static boolean isInject() {
        return f10525a != null;
    }

    public static boolean isUseFeed() {
        if (!f10529e) {
            IMContext iMContext = f10525a;
            f10528d = iMContext != null ? iMContext.showFeed() : false;
            f10529e = true;
        }
        return f10528d;
    }

    public static String locationTopScheme() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.locationTopScheme();
        }
        return null;
    }

    public static void destory() {
        if (f10525a != null) {
            f10525a = null;
        }
    }

    public static boolean isLogingNow() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.isLoginNow();
        }
        return false;
    }

    public static long getUid() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.getUid();
        }
        return 0;
    }

    public static String getToken() {
        IMContext iMContext = f10525a;
        return iMContext != null ? iMContext.getToken() : "ErrorToken";
    }

    public static String getAppVersion() {
        IMContext iMContext = f10525a;
        return iMContext != null ? iMContext.getVersionName() : "ErrorVersion";
    }

    public static Context getContext() {
        return f10527c;
    }

    public static String getDeviceId() {
        IMContext iMContext = f10525a;
        return iMContext != null ? iMContext.getDeviceId() : "ErrorDeviceId";
    }

    public static IMContext getInfoProvider() {
        return f10525a;
    }

    public static IMCustomChatRowProvider getRegisterMessageCardView() {
        return new IMCustomChatRowProviderImpl(f10527c);
    }

    public static Class<?> getAppMainClass() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.getAppMainClass();
        }
        return null;
    }

    public static boolean isMainActivityAlive() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.isMainActivityAlive();
        }
        return false;
    }

    public static Uri getNotificationSoundUri() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.getNotificationSoundUri();
        }
        return null;
    }

    public static ArrayList<String> getQuickReplyList(int i) {
        IMContext iMContext = f10525a;
        if (iMContext != null && iMContext.getQuickReplyList(i) != null && f10525a.getQuickReplyList(i).size() > 0) {
            return f10525a.getQuickReplyList(i);
        }
        ArrayList<String> arrayList = new ArrayList<>();
        Context context = f10527c;
        if (context != null) {
            String[] stringArray = context.getResources().getStringArray(R.array.im_default_word_list);
            if (stringArray != null && stringArray.length > 0) {
                for (String add : stringArray) {
                    arrayList.add(add);
                }
            }
        } else {
            IMLog.m10021e(f10526b, "get local default quicklist failed because mcontext is null");
        }
        return arrayList;
    }

    public static String getBusinessPayload(String str) {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.getPayload(str);
        }
        IMLog.m10020d(f10526b, "getBusinessPayload failed while sInfoProvider is null !");
        return null;
    }

    public static boolean isUseInnerStorage() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.isUseInnerStorage();
        }
        return false;
    }

    public static boolean isPad() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.isPad();
        }
        return false;
    }

    public static int getAppChannel() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.getAppChannel();
        }
        return 0;
    }

    public static int getActivityTheme() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.getActivityTheme();
        }
        return 0;
    }

    public static String getWebActivityScheme() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.getWebActivityScheme();
        }
        return null;
    }

    public static boolean handLink(Context context, String str) {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.handLink(context, str);
        }
        return false;
    }

    public static String setSettingPageScheme() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.setSettingPageScheme();
        }
        return null;
    }

    public static Locale getLocale() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.getLocale();
        }
        return null;
    }

    public static String getPackageName() {
        Context context = f10527c;
        return context != null ? context.getPackageName() : "null";
    }

    public static IMAudioConfig getAudioConfig() {
        if (f10530f == null) {
            IMAudioConfig iMAudioConfig = null;
            IMContext iMContext = f10525a;
            if (iMContext != null) {
                iMAudioConfig = iMContext.getAudioConfig();
            }
            if (iMAudioConfig == null) {
                iMAudioConfig = new IMAudioConfig();
            }
            f10530f = iMAudioConfig;
        }
        return f10530f;
    }

    public static IMBusinessConfig getDefaultBusinessConfig() {
        IMContext iMContext = f10525a;
        if (iMContext != null) {
            return iMContext.getDefaultBusinessConfig();
        }
        return null;
    }

    public static boolean isMoveCipher() {
        IMContext iMContext = f10525a;
        if (iMContext != null && iMContext.isMoveInnerStorage()) {
            return true;
        }
        if (f10531g < 0) {
            f10531g = ((Integer) Apollo.getToggle("IM_Config_Encrypt_China").getExperiment().getParam("is_open_encrypt", 0)).intValue();
        }
        if (1 == f10531g) {
            return true;
        }
        return false;
    }

    public static boolean isNewInnerFlow() {
        IMContext iMContext = f10525a;
        if (iMContext != null && iMContext.isMoveInnerStorage()) {
            return true;
        }
        if (f10532h < 0) {
            f10532h = ((Integer) Apollo.getToggle("IM_Config_Decrypt_China_Android").getExperiment().getParam("is_open_decrypt", 0)).intValue();
        }
        if (1 == f10532h) {
            return true;
        }
        return false;
    }

    public static boolean enableSendImage() {
        return Build.VERSION.SDK_INT >= 21;
    }

    public static IMStyleManager.Style getStyle() {
        IMContext iMContext = f10525a;
        if (iMContext == null) {
            return IMStyleManager.Style.DEFAULT;
        }
        return iMContext.getIMStyle();
    }

    public static IMCustomViewBuilder getCustomViewBuilder() {
        IMContext iMContext = f10525a;
        if (iMContext == null) {
            return null;
        }
        return iMContext.getCustomViewBuilder();
    }

    public static IMCustomResBuilder getCustomResBuilder() {
        IMContext iMContext = f10525a;
        if (iMContext == null) {
            return null;
        }
        return iMContext.getCustomResBuilder();
    }

    public static boolean isUseDecorFloatStyle() {
        if (!f10535k) {
            IMContext iMContext = f10525a;
            boolean z = iMContext != null && iMContext.useDecorFloatStyle();
            f10534j = z;
            f10535k = true;
            IMLog.m10020d(f10526b, C4786I.m9980t("[isUseDecorFloatStyle] -> ", Boolean.valueOf(z)));
        }
        return f10534j;
    }
}
