package com.didi.soda.customer.foundation.rpc;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import com.didi.foundation.sdk.utils.LocalizationUtils;
import com.didi.global.fintech.cashier.user.facade.CashierFacade;
import com.didi.sdk.security.SecurityUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.SccManager;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.util.CipherUtil;
import com.didi.soda.customer.foundation.util.CustomerSystemUtil;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.foundation.util.UrlBuilder;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didichuxing.omega.sdk.Omega;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

public final class ParamsHelper {

    /* renamed from: A */
    private static final String f43563A = "poiName";
    public static final String APP_UNI_ID = "appUniId";

    /* renamed from: B */
    private static final String f43564B = "poiCityId";

    /* renamed from: C */
    private static final String f43565C = "poiCountyId";
    public static final String CASHIER_SDK_VERSION = "cashierSDKVersion";

    /* renamed from: D */
    private static final String f43566D = "poiCountyGroupId";

    /* renamed from: E */
    private static final String f43567E = "enterChannel";

    /* renamed from: F */
    private static final String f43568F = "extActivityId";
    public static final String FLUTTER_APP_PLATFORM = "appPlatform";
    public static final String FLUTTER_APP_VERSION = "appVersion";
    public static final String FLUTTER_BRAND_NAME = "brandName";
    public static final String FLUTTER_BUILD_TYPE = "buildType";
    public static final String FLUTTER_CALLING_CODE = "callingCode";
    public static final String FLUTTER_COUNTRY = "country";
    public static final String FLUTTER_HAS_STATUS_BAR_DRAWABLE = "hasStatusbarDrawable";
    public static final String FLUTTER_IMMERSIVE_STATUSBAR_HEIGHT = "immersiveStatusbarHeight";
    public static final String FLUTTER_IS_EMBED = "isEmbed";
    public static final String FLUTTER_LANG = "lang";
    public static final String FLUTTER_LOCALE = "locale";
    public static final String FLUTTER_MANUFACTURER = "manufacturer";
    public static final String FLUTTER_MODEL = "model";
    public static final String FLUTTER_OS_VERSION = "osVersion";
    public static final String FLUTTER_SEMANTICS_ENABLE = "semanticsTurnOff";
    public static final String FLUTTER_SODA_TYPE = "sodaType";
    public static final String FLUTTER_STATUS_BAR_HEIGHT = "statusbarHeight";
    public static final String FLUTTER_TIME_OFFSET = "timeOffset";
    public static final String FLUTTER_TOKEN = "token";
    public static final String FLUTTER_UTC_OFFSET = "utcOffset";
    public static final String FROM_TYPE = "fromType";

    /* renamed from: G */
    private static final String f43569G = "firstActivityId";

    /* renamed from: H */
    private static final String f43570H = "firstChannelId";
    public static final String H5_BRIDGE_STATUS_BAR_HEIGHT = "statusBarHeight";

    /* renamed from: I */
    private static final String f43571I = "locale";

    /* renamed from: J */
    private static final String f43572J = "lang";

    /* renamed from: K */
    private static final String f43573K = "dataType";

    /* renamed from: L */
    private static final String f43574L = "terminalId";

    /* renamed from: M */
    private static final String f43575M = "mapType";

    /* renamed from: N */
    private static final String f43576N = "imei";
    public static final String NATIVE = "NATIVE";

    /* renamed from: O */
    private static final String f43577O = "ip";

    /* renamed from: P */
    private static final String f43578P = "locationType";
    public static final String PARAM_MS_CHANNEL = "soda_ms_channel";

    /* renamed from: Q */
    private static final String f43579Q = "operatorName";

    /* renamed from: R */
    private static final String f43580R = "linuxKernel";

    /* renamed from: S */
    private static final String f43581S = "wifiName";

    /* renamed from: T */
    private static final String f43582T = "requestId";
    public static final String TEST_CONFIG = "testConfig";

    /* renamed from: U */
    private static final String f43583U = "soda_from";

    /* renamed from: V */
    private static final String f43584V = "scc";

    /* renamed from: W */
    private static final String f43585W = "scg";

    /* renamed from: X */
    private static final String f43586X = "sci";

    /* renamed from: Y */
    private static final String f43587Y = "businessType";

    /* renamed from: Z */
    private static final String f43588Z = "brand";

    /* renamed from: a */
    private static final String f43589a = "|";

    /* renamed from: aa */
    private static final String f43590aa = "terminalType";

    /* renamed from: ab */
    private static final String f43591ab = "poiCountryCode";

    /* renamed from: ac */
    private static final String f43592ac = "countryCode";

    /* renamed from: ad */
    private static final String f43593ad = "oid";

    /* renamed from: ae */
    private static final String f43594ae = "product_id";

    /* renamed from: af */
    private static final String f43595af = "utc_offset";

    /* renamed from: ag */
    private static final String f43596ag = "city_id";

    /* renamed from: ah */
    private static final String f43597ah = "os_type";

    /* renamed from: ai */
    private static final String f43598ai = "didi_pass_app_type";

    /* renamed from: aj */
    private static Calendar f43599aj = null;

    /* renamed from: b */
    private static final int f43600b = 2;

    /* renamed from: c */
    private static final String f43601c = "16";

    /* renamed from: d */
    private static final String f43602d = "token";

    /* renamed from: e */
    private static final String f43603e = "appVersion";

    /* renamed from: f */
    private static final String f43604f = "versionCode";

    /* renamed from: g */
    private static final String f43605g = "osType";

    /* renamed from: h */
    private static final String f43606h = "osVersion";

    /* renamed from: i */
    private static final String f43607i = "suuid";

    /* renamed from: j */
    private static final String f43608j = "uuid";

    /* renamed from: k */
    private static final String f43609k = "deviceId";

    /* renamed from: l */
    private static final String f43610l = "clientType";

    /* renamed from: m */
    private static final String f43611m = "lat";

    /* renamed from: n */
    private static final String f43612n = "lng";

    /* renamed from: o */
    private static final String f43613o = "bizId";

    /* renamed from: p */
    private static final String f43614p = "deviceType";

    /* renamed from: q */
    private static final String f43615q = "cityId";

    /* renamed from: r */
    private static final String f43616r = "countyId";

    /* renamed from: s */
    private static final String f43617s = "countyGroupId";

    /* renamed from: t */
    private static final String f43618t = "networkType";

    /* renamed from: u */
    private static final String f43619u = "poiId";

    /* renamed from: v */
    private static final String f43620v = "poiLat";

    /* renamed from: w */
    private static final String f43621w = "poiLng";

    /* renamed from: x */
    private static final String f43622x = "channel";

    /* renamed from: y */
    private static final String f43623y = "timestamp";

    /* renamed from: z */
    private static final String f43624z = "deviceBrand";

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
        hashMap.put(f43613o, AppConst.BUSINESS_ID);
        hashMap.put("appVersion", SystemUtil.getVersionName(context));
        hashMap.put("versionCode", Integer.valueOf(SystemUtil.getVersionCode()));
        hashMap.put("osType", 2);
        hashMap.put("osVersion", Build.VERSION.RELEASE);
        hashMap.put(f43614p, SystemUtil.getModel());
        hashMap.put(f43624z, CustomerSystemUtil.getDeviceBrand());
        hashMap.put(f43610l, 9);
        hashMap.put("businessType", 2);
        hashMap.put("brand", 3);
        hashMap.put(f43590aa, 2);
        hashMap.put("networkType", NetWorkUtils.getNetworkType(context));
        hashMap.put("suuid", SecurityUtil.getSUUID());
        hashMap.put("uuid", SecurityUtil.getUUID());
        hashMap.put(f43609k, CustomerSystemUtil.getDeviceId());
        hashMap.put("lat", Double.valueOf(LocationUtil.getCurrentLat()));
        hashMap.put("lng", Double.valueOf(LocationUtil.getCurrentLng()));
        hashMap.put("cityId", Integer.valueOf(LocationUtil.getCityId()));
        hashMap.put("countyId", Long.valueOf(LocationUtil.getCountyId()));
        hashMap.put("countyGroupId", Long.valueOf(LocationUtil.getCountyGroupId()));
        hashMap.put("poiId", LocationUtil.getPoiId());
        hashMap.put(f43620v, Double.valueOf(LocationUtil.getPoiLat()));
        hashMap.put(f43621w, Double.valueOf(LocationUtil.getPoiLng()));
        hashMap.put(f43564B, Integer.valueOf(LocationUtil.getPoiCityId()));
        hashMap.put(f43565C, Long.valueOf(LocationUtil.getPoiCountyId()));
        hashMap.put(f43566D, Long.valueOf(LocationUtil.getPoiCountyGroupId()));
        hashMap.put(f43563A, LocationUtil.getPoiDisplayName());
        hashMap.put("channel", SystemUtil.getChannelId());
        hashMap.put("timestamp", Long.valueOf(Clock.timeAtSeconds()));
        hashMap.put(f43567E, OmegaCommonParamHelper.getChannelId());
        hashMap.put(f43568F, OmegaCommonParamHelper.getActivityId());
        hashMap.put(f43569G, OmegaCommonParamHelper.getFirstActivityId());
        hashMap.put(f43570H, OmegaCommonParamHelper.getFirstChannelId());
        hashMap.put("imei", SystemUtil.getIMEI());
        hashMap.put("ip", CustomerSystemUtil.getLocalIpAddress(context));
        hashMap.put(f43580R, CustomerSystemUtil.getKernelVersion());
        hashMap.put(f43575M, CustomerSystemUtil.getMapType());
        hashMap.put(f43578P, Integer.valueOf(CustomerSystemUtil.getLocationType()));
        hashMap.put(f43581S, CustomerSystemUtil.getSsId(context));
        hashMap.put(f43582T, m32604c());
        hashMap.put("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        hashMap.put("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        hashMap.put("dataType", "16");
        hashMap.put("terminalId", 300106);
        hashMap.put(f43591ab, LocationUtil.getPoiCountryCode());
        hashMap.put("countryCode", LocationUtil.getCountryCode());
        hashMap.put("oid", Omega.getOmegaIdSafety());
        hashMap.put(TEST_CONFIG, ABConfigHelper.Companion.getAllConfig());
        hashMap.put(PARAM_MS_CHANNEL, String.valueOf(GlobalContext.isGmsChannel() ^ true ? 1 : 0));
        hashMap.put(CASHIER_SDK_VERSION, CashierFacade.getInstance().getSdkVersion());
        hashMap.put("fromType", NATIVE);
        hashMap.put(APP_UNI_ID, GlobalContext.getContext().getPackageName());
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
        buildUpon.appendQueryParameter(f43620v, String.valueOf(LocationUtil.getPoiLat()));
        buildUpon.appendQueryParameter(f43621w, String.valueOf(LocationUtil.getPoiLng()));
        buildUpon.appendQueryParameter(f43564B, String.valueOf(LocationUtil.getPoiCityId()));
        buildUpon.appendQueryParameter(f43565C, String.valueOf(LocationUtil.getPoiCountyId()));
        buildUpon.appendQueryParameter(f43566D, String.valueOf(LocationUtil.getPoiCountyGroupId()));
        buildUpon.appendQueryParameter(f43583U, "1");
        buildUpon.appendQueryParameter(f43591ab, LocationUtil.getPoiCountryCode());
        buildUpon.appendQueryParameter("countryCode", LocationUtil.getCountryCode());
        buildUpon.appendQueryParameter("terminalId", String.valueOf(300106));
        buildUpon.appendQueryParameter("locale", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getCurrentLocaleTag());
        buildUpon.appendQueryParameter("lang", ((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLangTag());
        buildUpon.appendQueryParameter(PARAM_MS_CHANNEL, String.valueOf(GlobalContext.isGmsChannel() ^ true ? 1 : 0));
        return buildUpon.build().toString();
    }

    public static String addDiDiPassParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        Uri.Builder buildUpon = Uri.parse(str).buildUpon();
        String token = LoginUtil.getToken();
        if (!TextUtil.isEmpty(token)) {
            buildUpon.appendQueryParameter("token", token);
        }
        buildUpon.appendQueryParameter("product_id", String.valueOf(601)).appendQueryParameter("utc_offset", String.valueOf(LocalizationUtils.getTimeZoneUtcOffset())).appendQueryParameter("city_id", String.valueOf(LocationUtil.getCityId())).appendQueryParameter("os_type", String.valueOf(getClientType())).appendQueryParameter(f43598ai, GlobalContext.isEmbed() ? "1" : "0");
        return buildUpon.build().toString();
    }

    public static String addGetCommonParams(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        String scc = ((SccManager) SingletonFactory.get(SccManager.class)).getScc();
        UrlBuilder appendParam = UrlBuilder.create(str).appendParam(f43585W, m32602a()).appendParam(f43586X, m32603b());
        if (!TextUtils.isEmpty(scc)) {
            appendParam.appendParam(f43584V, scc);
        }
        return appendParam.build();
    }

    /* renamed from: a */
    private static String m32602a() {
        Calendar d = m32605d();
        d.setTimeInMillis(TimeUnit.SECONDS.toMillis(Clock.timeAtSeconds()));
        return CipherUtil.md5(String.format("%.2f", new Object[]{Double.valueOf(LocationUtil.getCurrentLat())}) + "|" + String.format("%.2f", new Object[]{Double.valueOf(LocationUtil.getCurrentLng())}) + "|" + d.get(11));
    }

    /* renamed from: b */
    private static String m32603b() {
        return CustomerSystemUtil.getDeviceId() + "|" + 2;
    }

    /* renamed from: c */
    private static String m32604c() {
        return CipherUtil.md5(CustomerSystemUtil.getDeviceId() + "_" + Clock.timeAtSeconds());
    }

    /* renamed from: d */
    private static Calendar m32605d() {
        if (f43599aj == null) {
            f43599aj = Calendar.getInstance();
        }
        return f43599aj;
    }
}
