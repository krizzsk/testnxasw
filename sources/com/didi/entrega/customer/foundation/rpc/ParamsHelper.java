package com.didi.entrega.customer.foundation.rpc;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.app.constant.AppConst;
import com.didi.entrega.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.entrega.customer.foundation.util.CipherUtil;
import com.didi.entrega.customer.foundation.util.CustomerSystemUtil;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.foundation.sdk.utils.LocalizationUtils;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didichuxing.omega.sdk.Omega;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

public final class ParamsHelper {

    /* renamed from: A */
    private static final String f21805A = "poiName";

    /* renamed from: B */
    private static final String f21806B = "poiCityId";

    /* renamed from: C */
    private static final String f21807C = "poiCountyId";

    /* renamed from: D */
    private static final String f21808D = "poiCountyGroupId";
    public static final String DATA_TYPE = "dataType";

    /* renamed from: E */
    private static final String f21809E = "enterChannel";

    /* renamed from: F */
    private static final String f21810F = "extActivityId";
    public static final String FLUTTER_APP_PLATFORM = "appPlatform";
    public static final String FLUTTER_APP_VERSION = "appVersion";
    public static final String FLUTTER_BRAND_NAME = "brandName";
    public static final String FLUTTER_BUILD_TYPE = "buildType";
    public static final String FLUTTER_CALLING_CODE = "callingCode";
    public static final String FLUTTER_COUNTRY = "country";
    public static final String FLUTTER_DEVICE_TOKEN = "deviceToken";
    public static final String FLUTTER_IMMERSIVE_STATUSBAR_HEIGHT = "immersiveStatusbarHeight";
    public static final String FLUTTER_IS_EMBED = "isEmbed";
    public static final String FLUTTER_KF_PAGE_SOURCE = "kfPageSource";
    public static final String FLUTTER_LANG = "lang";
    public static final String FLUTTER_LOCALE = "locale";
    public static final String FLUTTER_MANUFACTURER = "manufacturer";
    public static final String FLUTTER_MODEL = "model";
    public static final String FLUTTER_OS_VERSION = "osVersion";
    public static final String FLUTTER_SODA_TYPE = "sodaType";
    public static final String FLUTTER_STATUS_BAR_HEIGHT = "statusbarHeight";
    public static final String FLUTTER_TIME_OFFSET = "timeOffset";
    public static final String FLUTTER_TOKEN = "token";
    public static final String FLUTTER_UID = "uid";
    public static final String FLUTTER_UTC_OFFSET = "utcOffset";

    /* renamed from: G */
    private static final String f21811G = "firstActivityId";

    /* renamed from: H */
    private static final String f21812H = "firstChannelId";

    /* renamed from: I */
    private static final String f21813I = "locale";

    /* renamed from: J */
    private static final String f21814J = "lang";

    /* renamed from: K */
    private static final String f21815K = "terminalId";

    /* renamed from: L */
    private static final String f21816L = "mapType";

    /* renamed from: M */
    private static final String f21817M = "imei";

    /* renamed from: N */
    private static final String f21818N = "ip";

    /* renamed from: O */
    private static final String f21819O = "locationType";

    /* renamed from: P */
    private static final String f21820P = "linuxKernel";

    /* renamed from: Q */
    private static final String f21821Q = "wifiName";

    /* renamed from: R */
    private static final String f21822R = "requestId";

    /* renamed from: S */
    private static final String f21823S = "soda_from";

    /* renamed from: T */
    private static final String f21824T = "businessType";

    /* renamed from: U */
    private static final String f21825U = "brand";

    /* renamed from: V */
    private static final String f21826V = "terminalType";

    /* renamed from: W */
    private static final String f21827W = "sailingBizLine";

    /* renamed from: X */
    private static final String f21828X = "poiCountryCode";

    /* renamed from: Y */
    private static final String f21829Y = "countryCode";

    /* renamed from: Z */
    private static final String f21830Z = "oid";

    /* renamed from: a */
    private static final String f21831a = "|";

    /* renamed from: aa */
    private static final String f21832aa = "product_id";

    /* renamed from: ab */
    private static final String f21833ab = "utc_offset";

    /* renamed from: ac */
    private static final String f21834ac = "city_id";

    /* renamed from: ad */
    private static final String f21835ad = "os_type";

    /* renamed from: ae */
    private static Calendar f21836ae = null;

    /* renamed from: b */
    private static final int f21837b = 2;

    /* renamed from: c */
    private static final String f21838c = "16";

    /* renamed from: d */
    private static final String f21839d = "token";

    /* renamed from: e */
    private static final String f21840e = "appVersion";

    /* renamed from: f */
    private static final String f21841f = "versionCode";

    /* renamed from: g */
    private static final String f21842g = "osType";

    /* renamed from: h */
    private static final String f21843h = "osVersion";

    /* renamed from: i */
    private static final String f21844i = "suuid";

    /* renamed from: j */
    private static final String f21845j = "uuid";

    /* renamed from: k */
    private static final String f21846k = "deviceId";

    /* renamed from: l */
    private static final String f21847l = "clientType";

    /* renamed from: m */
    private static final String f21848m = "lat";

    /* renamed from: n */
    private static final String f21849n = "lng";

    /* renamed from: o */
    private static final String f21850o = "bizId";

    /* renamed from: p */
    private static final String f21851p = "deviceType";

    /* renamed from: q */
    private static final String f21852q = "cityId";

    /* renamed from: r */
    private static final String f21853r = "countyId";

    /* renamed from: s */
    private static final String f21854s = "countyGroupId";

    /* renamed from: t */
    private static final String f21855t = "networkType";

    /* renamed from: u */
    private static final String f21856u = "poiId";

    /* renamed from: v */
    private static final String f21857v = "poiLat";

    /* renamed from: w */
    private static final String f21858w = "poiLng";

    /* renamed from: x */
    private static final String f21859x = "channel";

    /* renamed from: y */
    private static final String f21860y = "timestamp";

    /* renamed from: z */
    private static final String f21861z = "deviceBrand";

    public static int getClientType() {
        return 2;
    }

    private ParamsHelper() {
    }

    public static Map<String, Object> getCommonParams() {
        HashMap hashMap = new HashMap();
        Context context = GlobalContext.getContext();
        String token = LoginUtil.getToken();
        if (!TextUtil.isEmpty(token)) {
            hashMap.put("token", token);
        }
        hashMap.put(f21850o, AppConst.BUSINESS_ID);
        hashMap.put("appVersion", SystemUtil.getVersionName(context));
        hashMap.put("versionCode", Integer.valueOf(SystemUtil.getVersionCode()));
        hashMap.put("osType", 2);
        hashMap.put("osVersion", Build.VERSION.RELEASE);
        hashMap.put(f21851p, SystemUtil.getModel());
        hashMap.put(f21861z, CustomerSystemUtil.getDeviceBrand());
        hashMap.put(f21847l, 9);
        hashMap.put("businessType", 2);
        hashMap.put("brand", 3);
        hashMap.put(f21826V, 2);
        hashMap.put("networkType", NetWorkUtils.getNetworkType(context));
        hashMap.put("suuid", SecurityUtil.getSUUID());
        hashMap.put("uuid", SecurityUtil.getUUID());
        hashMap.put(f21846k, CustomerSystemUtil.getDeviceId());
        hashMap.put("lat", Double.valueOf(LocationUtil.getCurrentLat()));
        hashMap.put("lng", Double.valueOf(LocationUtil.getCurrentLng()));
        hashMap.put("cityId", Integer.valueOf(LocationUtil.getCityId()));
        hashMap.put("countyId", Long.valueOf(LocationUtil.getCountyId()));
        hashMap.put("countyGroupId", Long.valueOf(LocationUtil.getCountyGroupId()));
        hashMap.put("poiId", LocationUtil.getPoiId());
        hashMap.put(f21857v, Double.valueOf(LocationUtil.getPoiLat()));
        hashMap.put(f21858w, Double.valueOf(LocationUtil.getPoiLng()));
        hashMap.put(f21806B, Integer.valueOf(LocationUtil.getPoiCityId()));
        hashMap.put(f21807C, Long.valueOf(LocationUtil.getPoiCountyId()));
        hashMap.put(f21808D, Long.valueOf(LocationUtil.getPoiCountyGroupId()));
        hashMap.put(f21805A, LocationUtil.getPoiDisplayName());
        hashMap.put("channel", SystemUtil.getChannelId());
        hashMap.put("timestamp", Long.valueOf(Clock.timeAtSeconds()));
        hashMap.put(f21809E, OmegaCommonParamHelper.getChannelId());
        hashMap.put(f21810F, OmegaCommonParamHelper.getActivityId());
        hashMap.put(f21811G, OmegaCommonParamHelper.getFirstActivityId());
        hashMap.put(f21812H, OmegaCommonParamHelper.getFirstChannelId());
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("ip", CustomerSystemUtil.getLocalIpAddress(context));
        hashMap.put(f21820P, CustomerSystemUtil.getKernelVersion());
        hashMap.put(f21816L, CustomerSystemUtil.getMapType());
        hashMap.put(f21819O, Integer.valueOf(CustomerSystemUtil.getLocationType()));
        hashMap.put(f21821Q, CustomerSystemUtil.getSsId(context));
        hashMap.put(f21822R, m18195a());
        hashMap.put("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        hashMap.put("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        hashMap.put(DATA_TYPE, "16");
        hashMap.put("terminalId", 300106);
        hashMap.put(f21828X, LocationUtil.getPoiCountryCode());
        hashMap.put("countryCode", LocationUtil.getCountryCode());
        hashMap.put("oid", Omega.getOmegaIdSafety());
        hashMap.put(f21827W, 2);
        return hashMap;
    }

    public static Map<String, String> getFlutterRouterCommonParam() {
        HashMap hashMap = new HashMap();
        Context context = GlobalContext.getContext();
        hashMap.put("brandName", "99");
        hashMap.put("country", LocationUtil.getCountryCode());
        hashMap.put("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        hashMap.put("isEmbed", GlobalContext.isEmbed() ? "1" : "0");
        hashMap.put("utcOffset", String.valueOf(LocalizationUtils.getTimeZoneUtcOffset()));
        hashMap.put("timeOffset", String.valueOf(Clock.timeAtSeconds()));
        String token = LoginUtil.getToken();
        if (!TextUtil.isEmpty(token)) {
            hashMap.put("token", token);
        }
        hashMap.put("appVersion", SystemUtil.getVersionName(context));
        hashMap.put("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        hashMap.put("sodaType", "c");
        hashMap.put("appPlatform", "3");
        hashMap.put(FLUTTER_KF_PAGE_SOURCE, "sodaEntrega");
        return hashMap;
    }

    public static String addCommonParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        for (Map.Entry next : getCommonParams().entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), "" + next.getValue());
        }
        return buildUpon.build().toString();
    }

    public static String addH5CommonParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        buildUpon.appendQueryParameter("poiId", LocationUtil.getPoiId());
        buildUpon.appendQueryParameter(f21857v, String.valueOf(LocationUtil.getPoiLat()));
        buildUpon.appendQueryParameter(f21858w, String.valueOf(LocationUtil.getPoiLng()));
        buildUpon.appendQueryParameter(f21806B, String.valueOf(LocationUtil.getPoiCityId()));
        buildUpon.appendQueryParameter(f21807C, String.valueOf(LocationUtil.getPoiCountyId()));
        buildUpon.appendQueryParameter(f21808D, String.valueOf(LocationUtil.getPoiCountyGroupId()));
        buildUpon.appendQueryParameter(f21823S, "1");
        buildUpon.appendQueryParameter(f21828X, LocationUtil.getPoiCountryCode());
        buildUpon.appendQueryParameter("countryCode", LocationUtil.getCountryCode());
        buildUpon.appendQueryParameter("terminalId", String.valueOf(300106));
        buildUpon.appendQueryParameter("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        buildUpon.appendQueryParameter("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        return buildUpon.build().toString();
    }

    /* renamed from: a */
    private static String m18195a() {
        return CipherUtil.md5(CustomerSystemUtil.getDeviceId() + "_" + Clock.timeAtSeconds());
    }
}
