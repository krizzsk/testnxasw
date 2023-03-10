package com.didichuxing.omega.sdk.common.utils;

public class Constants {
    public static final String ANR_SEQ = "a_seq";
    public static final String CRASH_SEQ = "c_seq";
    public static final String DEFAULT_ENCODING = "UTF-8";
    public static final String DIR_STORAGE_CACHE_ROOT = "omegacache";
    public static final String DIR_STORAGE_ROOT = "omega";
    public static final String EVENT_OMGHourly = "OMGHourly";
    public static final String EVENT_OMG_APP_IN = "OMGBecomeActive";
    public static final String EVENT_OMG_APP_JUMP = "OMGAppJump";
    public static final String EVENT_OMG_APP_OUT = "OMGEnterBackground";
    public static final String EVENT_OMG_APP_START = "OMGInit";
    public static final String EVENT_OMG_ERROR = "OMGError";
    public static final String EVENT_OMG_GOOD = "OMGGood";
    public static final String EVENT_OMG_H5_JS_ERROR = "OMGH5JsError";
    public static final String EVENT_OMG_H5_URL_ERROR = "OMGH5UrlError";
    public static final String EVENT_OMG_H5_WEB_FINISH = "OMGH5WebFinish";
    public static final String EVENT_OMG_H5_WEB_OPEN = "OMGH5WebOpen";
    public static final String EVENT_OMG_H5_WEB_START = "OMGH5WebStart";
    public static final String EVENT_OMG_ODAT = "OMGODAT";
    public static final String EVENT_OMG_PAGE_PAUSE = "OMGPagePause";
    public static final String EVENT_OMG_PAGE_RESUME = "OMGPageResume";
    public static final String EVENT_OMG_SCREENSHOT = "OMGScreenshot";
    public static final String EVENT_OMG_SNIPER = "OMGSniper";
    public static final String EVENT_OMG_SYNC = "OMGSync";
    public static final String EVENT_OMG_UI = "OMGUI";
    public static final String FEEDBACK_SEQ = "f_seq";
    public static final String FILE_ANR_RECORD_PREFIX = "omega_a_";
    public static final String FILE_COUNTER_CACHE = "c.cache";
    public static final String FILE_CRASH_RECORD_PREFIX = "omega_c_";
    public static final String FILE_EVENTS_RECORD_PREFIX = "omega_e_";
    public static final String FILE_EVENT_CACHE = "e.cache";
    public static final String FILE_EVENT_MMKV_CACHE = "omega_e_cache_";
    public static final String FILE_LAG_RECORD_PREFIX = "omega_l_";
    public static final String FILE_NATIVE_CRASH_RECORD_PREFIX = "omega_nc_";
    public static final String FILE_OAID_PEM = "omega_oaid.pem";
    public static final String FILE_OOM_HPROF_PREFIX = "omega_oom_";
    public static final String FILE_REMOTE_CONFIG = "remote.conf";
    public static final int HTTP_SENDER_CHUNKED_SIZE = 8192;
    public static final int HTTP_SENDER_CHUNKED_THRESHOLD = 1048576;
    public static final int HTTP_SENDER_CONNECTION_TIMEOUT = 30000;
    public static final int HTTP_SENDER_READ_BUFFER_SIZE = 8192;
    public static final int HTTP_SENDER_READ_TIMEOUT = 30000;
    public static final String JSON_EVENT_KEY_EVENT_ID = "e";
    public static final String JSON_EVENT_KEY_EVENT_LABEL = "l";
    public static final String JSON_EVENT_KEY_EXTRA_ATTR = "ex";
    public static final String JSON_EVENT_KEY_FROM = "f";
    public static final String JSON_EVENT_KEY_MID = "mid";
    public static final String JSON_EVENT_KEY_SEQUENCE = "q";
    public static final String JSON_EVENT_KEY_TIMESTAMP = "ts";
    public static final String JSON_KEY_APP_BUILD_VERSION = "ab";
    public static final String JSON_KEY_APP_LABEL = "al";
    public static final String JSON_KEY_APP_NAME = "an";
    public static final String JSON_KEY_APP_STARTUP_TIME = "ast";
    public static final String JSON_KEY_APP_STATUS_INFO = "asi";
    public static final String JSON_KEY_APP_VERSION = "av";
    public static final String JSON_KEY_APP_VERSION_NUMBER = "avn";
    public static final String JSON_KEY_BATTERY_PERCENT = "bp";
    public static final String JSON_KEY_BRAND = "b";
    public static final String JSON_KEY_CHANNEL = "ch";
    public static final String JSON_KEY_CITY_ID = "cityid";
    public static final String JSON_KEY_COUNTY_ID = "coi";
    public static final String JSON_KEY_CUR_PAGE = "cp";
    public static final String JSON_KEY_CUSTOM_APP_VERSION = "cvn";
    public static final String JSON_KEY_CUSTOM_LOCALE = "le";
    public static final String JSON_KEY_DAILING_COUNTRY_CODE = "dcc";
    public static final String JSON_KEY_DEBUG_MODEL = "dm";
    public static final String JSON_KEY_DISPLAY = "dp";
    public static final String JSON_KEY_ENCRYPTED_PHONE = "tn";
    public static final String JSON_KEY_EVENTS = "es";
    public static final String JSON_KEY_FOURGROUND = "if";
    public static final String JSON_KEY_FRAGMENT_HISTORY = "fh";
    public static final String JSON_KEY_GAID = "gaid";
    public static final String JSON_KEY_GETUI_CID = "ucid";
    public static final String JSON_KEY_GLOBAL_ATTRS_JSON = "glb";
    public static final String JSON_KEY_GOOGLE_PLAY_SERVICE_INFO = "gpsi";
    public static final String JSON_KEY_HAID = "haid";
    public static final String JSON_KEY_INERNAL_STORAGE_INFO = "isi";
    public static final String JSON_KEY_LATITUDE = "lat";
    public static final String JSON_KEY_LOCALE = "loc";
    public static final String JSON_KEY_LOGCAT = "logcat";
    public static final String JSON_KEY_LONGITUDE = "lng";
    public static final String JSON_KEY_MEM_INFO = "mi";
    public static final String JSON_KEY_MODEL = "m";
    public static final String JSON_KEY_MOMENT_ID = "mid";
    public static final String JSON_KEY_NET_INFO = "ni";
    public static final String JSON_KEY_NET_TYPE = "nt";
    public static final String JSON_KEY_NEW_APP_VERSION = "nav";
    public static final String JSON_KEY_OMEGA_ID = "oid";
    public static final String JSON_KEY_OMEGA_OAID = "oaid";
    public static final String JSON_KEY_OMG_H_CI = "omgci";
    public static final String JSON_KEY_OMG_H_PL = "omgpl";
    public static final String JSON_KEY_OMG_KY = "omg_ky";
    public static final String JSON_KEY_OMG_OI = "omg_oi";
    public static final String JSON_KEY_ORIGIN_APP_NAME = "oan";
    public static final String JSON_KEY_ORIGIN_APP_VERSION = "oav";
    public static final String JSON_KEY_OS_TYPE = "ot";
    public static final String JSON_KEY_OS_VERSION = "ov";
    public static final String JSON_KEY_OS_VERSION_NUMBER = "ovn";
    public static final String JSON_KEY_PAGE_HISTORY = "ph";
    public static final String JSON_KEY_PAGE_PAGE_HISTORY = "pph";
    public static final String JSON_KEY_PHONE = "tel";
    public static final String JSON_KEY_PHONE_TIME = "pt";
    public static final String JSON_KEY_PLUGIN_INFO = "dycplugin";
    public static final String JSON_KEY_POLICY_ID = "pid";
    public static final String JSON_KEY_PRISM_SID = "prism-sid";
    public static final String JSON_KEY_RECORD_ID = "rid";
    public static final String JSON_KEY_SCREENSHOTS = "screenshots";
    public static final String JSON_KEY_SCREEN_INFO = "si";
    public static final String JSON_KEY_SCREEN_SIZE = "ss";
    public static final String JSON_KEY_SDK_VERSION = "sv";
    public static final String JSON_KEY_SEQ = "seq";
    public static final String JSON_KEY_SESSION_ID = "sid";
    public static final String JSON_KEY_SYS_MEM_INFO = "smi";
    public static final String JSON_KEY_SYS_STARTUP_TIME = "sst";
    public static final String JSON_KEY_TIME_OFFSET = "tc";
    public static final String JSON_KEY_USER_DEVICE_ID = "udid";
    public static final String JSON_KEY_USER_ID = "uid";
    public static final String JSON_KEY_USER_SUUID = "usid";
    public static final String JSON_KEY_USER_TOKEN = "utk";
    public static final String JSON_KEY_UTC_OFFSET = "uo";
    public static final String LAG_SEQ = "l_seq";
    public static final String LOG_DEBUG_FILE = "omegasdk.log";
    public static final String LOG_TAG = "omegasdk";
    public static final String OMG_DUMP_HPROF = "OMGDumpHprof";
    public static final String OMG_NET_ERROR = "OmegaNetError";
    public static final String OMG_UPLOAD_HPROF = "OMGUploadHprof";
    public static final String PATCH_VERSION = "patch_version";
    public static final String SAFE_BATTERY_EVENT = "OMGSafeBattery";
    public static final String SAFE_BAT_SIGNAL_EVENT = "OMGSafeEnv";
    public static final String SAFE_CLICK_MENU_EVENT = "OMGSafeClickMenu";
    public static final String SAFE_LONG_PRESSED_POWER_EVENT = "OMGSafeLongPressedPower";
    public static final String SAFE_SIGNAL_EVENT = "OMGSafeSignal";
    public static final String SAFE_TYPING_EVENT = "OMGSafeTyping";
    public static final String STAT_APPIN = "s_appin";
    public static final String STAT_SEQ = "s_seq";
    public static final String UPLOAD_HEADER_MSG_ID = "msgid";
    public static final String UPLOAD_HEADER_OMEGA_ID = "oid";
    public static final String UPLOAD_HEADER_SEQ = "seq";
    public static final String UPPER_LIMIT_ANR_EVENT_KEY = "upper_limit_anr";
    public static final String UPPER_LIMIT_CDN_DETECT_EVENT_KEY = "upper_limit_cdn_detect_overload";
    public static final String UPPER_LIMIT_CDN_DETECT_ODAY_KEY = "upper_limit_cdn_detect_oday";
    public static final String UPPER_LIMIT_CPU_USE_EVENT_KEY = "upper_limit_cpu_overload";
    public static final String UPPER_LIMIT_CRASH_EVENT_KEY = "upper_limit_crash";
    public static final String UPPER_LIMIT_DISK_DETECT_COUNT_EVENT_KEY = "upper_limit_disk_detect_count_event_key";
    public static final String UPPER_LIMIT_LAG_EVENT_KEY = "upper_limit_lag";
    public static final String UPPER_LIMIT_MEM_USE_EVENT_KEY = "upper_limit_mem_overload";
    public static final String UPPER_LIMIT_NATIVE_CRASH_EVENT_KEY = "upper_limit_native_crash";
    public static final String UPPER_LIMIT_OBJ_LEAKED_EVENT_KEY = "upper_limit_obj_leaked_event_key";
    public static final String UPPER_LIMIT_SOCKET_EVENT_KEY = "upper_limit_socket_key";
    public static final String UPPER_LIMIT_THREAD_COUNT_EVENT_KEY = "upper_limit_thread_count_event_key";
    public static final String UPPER_LIMIT_TRAFFIC_EVENT_KEY = "upper_limit_traffic_key";
}
