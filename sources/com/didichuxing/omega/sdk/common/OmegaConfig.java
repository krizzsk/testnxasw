package com.didichuxing.omega.sdk.common;

import android.text.TextUtils;
import androidx.work.PeriodicWorkRequest;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import global.didi.pay.presenter.GlobalBubbleShowHelper;
import java.util.ArrayList;
import java.util.List;

public class OmegaConfig {
    static final /* synthetic */ boolean $assertionsDisabled = false;
    public static int ACTIVITY_QUEUE_MAX_LEN = 10;
    public static String ANR_FILTER_REG = null;
    public static int ANR_FILTER_TYPE = 2;
    public static final int ANR_LOG_FILE_LENGTH = 3145728;
    public static String APP_ISSUE = "";
    public static long APP_USAGE_STAT_INTERVAL = 10000;
    public static int ASYNC_INIT_DELAY = 300;
    public static int BACKEND_THREAD_RUN_INTERVAL = 900000;
    public static long CAL_START_INTERVEL = 30000;
    public static String CHANNEL = "";
    public static int COUNTY_ID = 0;
    public static float CRASH_SCREENSHOT_SCALE = 0.38f;
    public static String CUSTOM_APP_NAME = "";
    public static String CUSTOM_APP_VERSION = "";
    public static long CUSTOM_TIME_OFFSET = 0;
    public static boolean DEBUG_MODEL = false;
    private static boolean DEBUG_MODEL_SECURITY = false;
    public static String DEBUG_TEMP_OMEGA_ID = null;
    public static long DEFAULT_SIZE_DIVIDE_HPROF = 10485760;
    public static float ENABLE_RATE = 1.0f;
    public static long EVENT_SEND_QUEUE_MAX_DELAY = PeriodicWorkRequest.MIN_PERIODIC_INTERVAL_MILLIS;
    public static long EVENT_SEND_QUEUE_MAX_DELAY_MULTIPLE_APP_OUT = 6;
    public static int EVENT_SEND_QUEUE_MAX_NUMBER = 30;
    public static int EX_LOW_BATTERY_THRESHOLD = 5;
    public static boolean EX_SWITCH_BATTERY_MONITOR = false;
    public static long FPS_DETECT_INTERVAL = 60000;
    public static long FPS_DETECT_INTERVAL_FOR_ANR_TRACE = 1000;
    public static int FPS_LATEST_CACHE_NUM = 60;
    public static long HOTPATCH_VERSION = -1;
    public static int HTTP_SENDER_RETRY_TIMES = 1;
    public static volatile boolean IS_INIT = false;
    public static long LAG_TIME = 3000;
    public static boolean LOGCAT_ONLY_MY_APP = false;
    public static int LOGCAT_TAIL_COUNT = 300;
    public static int LOGCAT_TAIL_MAX_COUNT = 1000;
    public static boolean LOG_PAGE_DURATION = false;
    public static boolean LOG_PRINT = true;
    public static int MAX_NET_CACHE_SIZE = 500;
    public static long MOMENT_ID_INTERVAL = 1800000;
    public static long NATIVE_CRASH_EXPIRE_MS = GlobalBubbleShowHelper.ONE_WEEK;
    public static boolean NATIVE_CRASH_SAVE_LOGCAT = false;
    public static boolean NET_DIAG_USE_MEMORY_CACHE = true;
    public static final String NO_RESULT = "";
    public static String OMEGA_OAID = "";
    public static double OMGVI_DELAY_TIME = 300.0d;
    public static String PHONE_NUMBER = "";
    public static int PIC_COMPRESS_QUALITY = 70;
    public static float PIC_IMAGE_SIZE = 1080.0f;
    public static String PLUGIN_INFO = null;
    public static final String[] PREDEFINED_HTTP_TRANSACTION_KEYS = {"url", "time", Constants.STATE_CODE, Constants.ERROR_CODE, "down", "up"};
    public static boolean PRE_INIT_ANR = false;
    public static final String PROTOCOL_HTTP = "http://";
    public static final String PROTOCOL_HTTPS = "https://";
    public static long RECORD_EXPIRE_MS = GlobalBubbleShowHelper.ONE_WEEK;
    public static int[] SAFE_BATTERY_THRESHOLD = {5, 10, 20};
    public static long SAFE_SIGNAL_DURATION = 30000;
    public static double SCREENSHOT_SAMPLE_RATE = 0.001d;
    public static String SDK_VERSION = "3.4.10-GLOBAL-IMPROVE-HMS";
    public static int SEND_EVENT_BACKEND_THREAD_RUN_INTERVAL = 300000;
    public static long SIZE_DIVIDE_DUMP_FILE = 10485760;
    public static long SNIPER_BG_WAIT_TIME = 15000;
    public static boolean SWITCH_APP_USAGE_STAT = false;
    public static boolean SWITCH_ATUO_EVENT_INPUT = false;
    public static boolean SWITCH_CRASH = true;
    public static volatile boolean SWITCH_EVENT = true;
    public static boolean SWITCH_EVENT_PERSISTENT = true;
    public static boolean SWITCH_FULL_AUTO_UI = true;
    public static boolean SWITCH_FULL_AUTO_UI_ENV = true;
    public static boolean SWITCH_H5_HIJACK = false;
    public static boolean SWITCH_OMEGA_ENENT_TRACK_PRISM = true;
    public static boolean SWITCH_OMEGA_TRACKER_NEWEDITION = true;
    public static boolean SWITCH_OMG_HOURLY = true;
    public static boolean SWITCH_OMG_INSTALLEDAPPS = true;
    public static boolean SWITCH_OMG_SNIPER = false;
    public static boolean SWITCH_OOM_DUMP = false;
    public static boolean SWITCH_PRINT_TRACE_LOG = false;
    public static boolean SWITCH_PUT_LOCATION_BACKGROUND = true;
    public static boolean SWITCH_SAFE_BATTERY = false;
    public static long SWITCH_SAFE_FREQUENCY = PeriodicWorkRequest.MIN_PERIODIC_FLEX_MILLIS;
    public static boolean SWITCH_SAFE_POLLING = false;
    public static boolean SWITCH_SAFE_SIGNAL = false;
    public static boolean SWITCH_SAVED_STATE_SYNC = false;
    public static boolean SWITCH_SCREENSHOT = false;
    public static boolean SWITCH_SYNC = true;
    public static boolean SWITCH_UPLOAD_HPROF = false;
    public static boolean SWITCH_UPLOAD_OOM_DUMP = false;
    public static boolean SWITCH_USE_HTTPS = true;
    public static final long SYNC_NETWORK_ERROR_RETRY_DELAY = 600000;
    public static int SYNC_REMOTE_INTERVAL = 3600000;
    public static boolean TIMEOUT_EXCEPTION_CRASH_CATCH = true;
    public static String TOAST_CRASH_TEXT = null;
    public static final String UPLOAD_ANR_PATH = "/api/crash/android";
    public static final String UPLOAD_CDN_PATH = "/cdn/android";
    public static final String UPLOAD_CRASH_PATH = "/api/crash/android";
    public static final String UPLOAD_EVENTS_DEBUG_PATH = "/api/statdebug/android";
    public static final String UPLOAD_EVENTS_PATH = "/api/stat/android";
    private static String UPLOAD_HOST = "omgup.didiglobal.com";
    public static final String UPLOAD_OAID_ERROR_PATH = "/syncconfig/cert/oaid/error";
    public static final String UPLOAD_OAID_PATH = "/syncconfig/cert/oaid/get";
    public static final String UPLOAD_REALTIME_PATH = "/api/realtime/stat/android";
    public static final String UPLOAD_SYNC_PATH = "/syncconfig/android";
    public static int UPPER_LIMIT_ANR_EVENT_PER_DAY = 10;
    public static int UPPER_LIMIT_CRASH_EVENT_PER_DAY = 150;
    public static int UPPER_LIMIT_LAG_EVENT_PER_DAY = 10;
    public static int UPPER_LIMIT_NATIVE_CRASH_EVENT_PER_DAY = 10;
    public static long VALIDITY_PERIOD_DUMP_FILE = 86400000;
    private static boolean YUNMACHINE_AVAILABLE = false;
    public static List<String> blackList = new ArrayList();
    public static int cityIdFromH5 = 0;
    public static IGetCityId iGetCityId;
    public static IGetDailingCountryCode iGetDailingCountryCode;
    public static IGetDidiToken iGetDidiToken;
    public static IGetPhone iGetPhone;
    public static IGetUid iGetUid;
    public static ILocale iLocale = null;
    public static ILocation iLocation;
    public static List<IInitListener> initListenerList = new ArrayList();
    private static int isHavePrismTool;
    public static boolean isUnwind = false;
    private static List<IOaidObserver> mOaidObserverList = new ArrayList();
    public static String phoneNumberFromH5 = null;
    private static List<String> pnBlackList = new ArrayList();
    public static String userIdFromH5 = "";

    public interface IGetCityId {
        int getCityId();
    }

    public interface IGetDailingCountryCode {
        String getDailingCountryCode();
    }

    public interface IGetDidiToken {
        String getDidiToken();
    }

    public interface IGetPhone {
        String getPhone();
    }

    public interface IGetUid {
        String getDidiPassengerUid();
    }

    public interface IInitListener {
        void initFinished();
    }

    public interface ILocale {
        String getLocale();
    }

    public interface ILocation {
        double[] getLocation();
    }

    public interface IOaidObserver {
        void oaidSuccess(String str);
    }

    public static void setUnwindUser(boolean z) {
        isUnwind = z;
    }

    public static void addBlackPages(List<String> list) {
        blackList.addAll(list);
    }

    public static void addPnBlackList(List<String> list) {
        pnBlackList.addAll(list);
    }

    public static void addPnBlackItem(String str) {
        pnBlackList.add(str);
    }

    public static String encryptBlackItem(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        for (int i = 0; i < pnBlackList.size(); i++) {
            String str2 = pnBlackList.get(i);
            if (!TextUtils.isEmpty(str2) && str.startsWith(str2)) {
                return str.replace(str2, "*");
            }
        }
        return str;
    }

    public static void addOaidObserver(IOaidObserver iOaidObserver) {
        if (iOaidObserver != null) {
            mOaidObserverList.add(iOaidObserver);
        }
    }

    public static void removeOaidObserver(IOaidObserver iOaidObserver) {
        if (iOaidObserver != null) {
            mOaidObserverList.remove(iOaidObserver);
        }
    }

    public static void notifyOaid(String str) {
        if (!TextUtils.isEmpty(str)) {
            for (int i = 0; i < mOaidObserverList.size(); i++) {
                IOaidObserver iOaidObserver = mOaidObserverList.get(i);
                if (iOaidObserver != null) {
                    iOaidObserver.oaidSuccess(str);
                }
            }
        }
    }

    public static boolean setDebugModel() {
        StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
        if (stackTrace == null || stackTrace.length == 0) {
            return DEBUG_MODEL_SECURITY;
        }
        for (StackTraceElement stackTraceElement : stackTrace) {
            if (stackTraceElement != null) {
                String stackTraceElement2 = stackTraceElement.toString();
                if (!TextUtils.isEmpty(stackTraceElement2) && stackTraceElement2.startsWith("com.didichuxing.omega.sdk.analysis.AnalysisActivityListener.reportOmgAppJump")) {
                    DEBUG_MODEL_SECURITY = true;
                    return true;
                }
            }
        }
        return DEBUG_MODEL_SECURITY;
    }

    public static boolean isDebugModel() {
        if (isPrismToolInit()) {
            return DEBUG_MODEL_SECURITY || DEBUG_MODEL;
        }
        return DEBUG_MODEL_SECURITY;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private static boolean isPrismToolInit() {
        /*
            int r0 = isHavePrismTool
            r1 = 1
            r2 = 0
            if (r1 != r0) goto L_0x0007
            return r2
        L_0x0007:
            java.lang.String r0 = "com.xiaojuchefu.prism.tool.PrismTool"
            java.lang.Class r0 = java.lang.Class.forName(r0)     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0010
            return r2
        L_0x0010:
            java.lang.String r3 = "sPrismTool"
            java.lang.reflect.Field r0 = r0.getDeclaredField(r3)     // Catch:{ all -> 0x0025 }
            if (r0 != 0) goto L_0x0019
            return r2
        L_0x0019:
            r0.setAccessible(r1)
            r3 = 0
            java.lang.Object r0 = r0.get(r3)     // Catch:{  }
            if (r0 != 0) goto L_0x0024
            return r2
        L_0x0024:
            return r1
        L_0x0025:
            return r2
        L_0x0026:
            isHavePrismTool = r1
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.OmegaConfig.isPrismToolInit():boolean");
    }

    public static void setUploadHost(String str) {
        UPLOAD_HOST = str;
    }

    public static String getUploadHost() {
        return UPLOAD_HOST;
    }

    public static boolean getYunStatus() {
        return YUNMACHINE_AVAILABLE;
    }

    private static void setYunStatus(Boolean bool) {
        YUNMACHINE_AVAILABLE = bool.booleanValue();
    }
}
