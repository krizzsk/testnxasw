package com.didi.component.deeplink;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;
import com.didi.app.router.PageRouter;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.event.DeepLinkEvent;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.helper.SceneHelper;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.ActivityStack;
import com.didi.sdk.app.DidiLoadDexActivity;
import com.didi.sdk.app.MainActivity;
import com.didi.sdk.app.SchemeDispatcher;
import com.didi.sdk.app.scheme.AbsSchemeDispatcherFilter;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.splash.SplashActivity;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didichuxing.bigdata.p174dp.locsdk.DIDILocation;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.sdk.poibase.CallFrom;
import com.sdk.poibase.PoiBaseApiFactory;
import com.sdk.poibase.model.IHttpListener;
import com.sdk.poibase.model.reverse.ReverseGeoParam;
import com.sdk.poibase.model.reverse.ReverseGeoResult;
import com.taxis99.R;
import java.io.IOException;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ServiceProvider({AbsSchemeDispatcherFilter.class})
public class GoogleSendOrderSchemeFilter extends AbsSchemeDispatcherFilter {

    /* renamed from: a */
    private static final String f14606a = "taxis99";

    /* renamed from: b */
    private static final String f14607b = "globalOneTravel";

    /* renamed from: c */
    private static final String f14608c = "taxis99OneTravel";

    /* renamed from: d */
    private static final String f14609d = "call";

    /* renamed from: e */
    private static final String f14610e = "ride";

    /* renamed from: f */
    private static final String f14611f = "/sendorder";

    /* renamed from: g */
    private static final String f14612g = "no_res";

    /* renamed from: h */
    private static final String f14613h = "client_id";

    /* renamed from: i */
    private static final String f14614i = "deep_link_product_id";

    /* renamed from: j */
    private static final String f14615j = "product_id";

    /* renamed from: k */
    private static final String f14616k = "eta_seconds";

    /* renamed from: l */
    private static final String f14617l = "pickup_latitude";

    /* renamed from: m */
    private static final String f14618m = "pickup_longitude";

    /* renamed from: n */
    private static final String f14619n = "pickup_title";

    /* renamed from: o */
    private static final String f14620o = "pickup_formatted_address";

    /* renamed from: p */
    private static final String f14621p = "dropoff_latitude";

    /* renamed from: q */
    private static final String f14622q = "dropoff_longitude";

    /* renamed from: r */
    private static final String f14623r = "dropoff_title";

    /* renamed from: s */
    private static final String f14624s = "dropoff_formatted_address";

    /* renamed from: t */
    private static final String f14625t = "call_from";

    /* renamed from: u */
    private static final String f14626u = "order_source";

    /* renamed from: v */
    private static final String f14627v = "car_level";

    /* renamed from: w */
    private Context f14628w;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public String f14629x = "app_default_reversegeo_poiid";

    /* renamed from: a */
    private int m12110a(int i) {
        if (i == 316) {
            return 1300;
        }
        if (i == 375) {
            return 2400;
        }
        if (i == 378) {
            return 3000;
        }
        if (i == 383) {
            return 3100;
        }
        if (i == 326) {
            return 1700;
        }
        if (i == 327) {
            return 1900;
        }
        switch (i) {
            case 401:
                return 3700;
            case 402:
                return 3800;
            case 403:
                return 3900;
            case 404:
                return 4000;
            case 405:
                return 4100;
            case 406:
                return 4200;
            case 407:
                return 4300;
            default:
                return i;
        }
    }

    /* renamed from: b */
    private int m12123b(int i) {
        switch (i) {
            case 16:
                return 316;
            case 17:
                return 327;
            case 18:
                return 326;
            default:
                switch (i) {
                    case 30:
                        return 375;
                    case 31:
                        return 378;
                    case 32:
                        return 383;
                    default:
                        switch (i) {
                            case 41:
                                return 401;
                            case 42:
                                return 402;
                            case 43:
                                return 403;
                            case 44:
                                return 404;
                            case 45:
                                return 405;
                            case 46:
                                return 406;
                            case 47:
                                return 407;
                            default:
                                return i;
                        }
                }
        }
    }

    public boolean doFilter(Intent intent, SchemeDispatcher schemeDispatcher) {
        if (!m12122a(intent)) {
            return false;
        }
        this.f14628w = schemeDispatcher.getApplicationContext();
        SceneHelper.getInstance().isDeepLinkFromGoogle = true;
        try {
            final Uri data = intent.getData();
            DIDILocation lastLocation = LocationPerformer.getInstance().getLastLocation();
            if (lastLocation == null) {
                LocationPerformer.getInstance().addLocationListener(new ILocation.ILocationChangedListener() {
                    public void onLocationChanged(DIDILocation dIDILocation) {
                        LocationPerformer.getInstance().removeLocationListener(this);
                        GoogleSendOrderSchemeFilter.this.m12115a(data, dIDILocation);
                    }
                });
                LocationPerformer.getInstance().start(schemeDispatcher.getApplicationContext());
            } else {
                m12115a(data, lastLocation);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        m12118a(schemeDispatcher);
        return true;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12115a(final Uri uri, final DIDILocation dIDILocation) {
        ReverseGeoParam reverseGeoParam = new ReverseGeoParam();
        reverseGeoParam.productId = BusinessDataUtil.getProductId();
        String a = m12113a(uri, f14621p);
        String a2 = m12113a(uri, f14622q);
        if (!TextUtils.isEmpty(a)) {
            reverseGeoParam.select_lat = Double.parseDouble(a);
        }
        if (!TextUtils.isEmpty(a2)) {
            reverseGeoParam.select_lng = Double.parseDouble(a2);
        }
        reverseGeoParam.uid = PaxEnvironment.getInstance().getUid();
        reverseGeoParam.appVersion = PaxEnvironment.getInstance().getAppVersion();
        reverseGeoParam.cityId = PaxEnvironment.getInstance().getCityId();
        reverseGeoParam.countryId = PaxEnvironment.getInstance().getCountryCode();
        reverseGeoParam.mapType = NationComponentDataUtil.getMapTypeString();
        if (dIDILocation != null) {
            reverseGeoParam.user_loc_lat = dIDILocation.getLatitude();
            reverseGeoParam.user_loc_lng = dIDILocation.getLongitude();
            reverseGeoParam.accuracy = dIDILocation.getAccuracy();
            reverseGeoParam.provider = dIDILocation.getProvider();
        }
        reverseGeoParam.phone = NationComponentDataUtil.getPhone();
        reverseGeoParam.token = NationComponentDataUtil.getToken();
        reverseGeoParam.lang = NationTypeUtil.getNationComponentData().getLocaleCode();
        reverseGeoParam.callFrom = CallFrom.GOOGLEMAP;
        PoiBaseApiFactory.createDidiApi(this.f14628w).reverseGeo(reverseGeoParam, new IHttpListener<ReverseGeoResult>() {
            public void onSuccess(ReverseGeoResult reverseGeoResult) {
                if (reverseGeoResult == null || CollectionUtil.isEmpty((Collection<?>) reverseGeoResult.result) || reverseGeoResult.result.get(0) == null || reverseGeoResult.result.get(0).base_info == null || TextUtils.isEmpty(reverseGeoResult.result.get(0).base_info.poi_id)) {
                    String unused = GoogleSendOrderSchemeFilter.this.f14629x = "app_default_reversegeo_poiid";
                } else {
                    String unused2 = GoogleSendOrderSchemeFilter.this.f14629x = reverseGeoResult.result.get(0).base_info.poi_id;
                }
                GoogleSendOrderSchemeFilter.this.m12121a(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, (Object) GoogleSendOrderSchemeFilter.this.m12124b(uri, dIDILocation));
            }

            public void onFail(IOException iOException) {
                String unused = GoogleSendOrderSchemeFilter.this.f14629x = "app_default_reversegeo_poiid";
                GoogleSendOrderSchemeFilter.this.m12121a(BaseEventKeys.Service.DeepLink.EVENT_HAND_DEEP_LINK, (Object) GoogleSendOrderSchemeFilter.this.m12124b(uri, dIDILocation));
            }
        });
    }

    /* renamed from: a */
    private void m12118a(SchemeDispatcher schemeDispatcher) {
        if (!ActivityLifecycleManager.getInstance().isMainActivityRunning()) {
            schemeDispatcher.startActivity(new Intent(schemeDispatcher, DidiLoadDexActivity.class));
            schemeDispatcher.finish();
        } else if (ActivityStack.size() <= 1) {
            schemeDispatcher.finish();
        } else {
            Activity takeInstance = ActivityStack.takeInstance(1);
            if (!(takeInstance instanceof MainActivity) && !(takeInstance instanceof SplashActivity)) {
                Intent intent = new Intent();
                intent.putExtra(f14612g, true);
                intent.addFlags(View.STATUS_BAR_TRANSIENT);
                intent.addFlags(268435456);
                intent.setPackage(schemeDispatcher.getPackageName());
                PageRouter.getInstance().startMainActivity(schemeDispatcher, new Intent());
                schemeDispatcher.finish();
            }
        }
    }

    /* renamed from: a */
    private boolean m12122a(Intent intent) {
        Uri data;
        if (intent == null || (data = intent.getData()) == null) {
            return false;
        }
        if (f14606a.equalsIgnoreCase(data.getScheme()) || "globalOneTravel".equalsIgnoreCase(data.getScheme()) || "taxis99OneTravel".equalsIgnoreCase(data.getScheme())) {
            String host = data.getHost();
            if ("call".equalsIgnoreCase(host)) {
                return true;
            }
            if (!"ride".equals(host) || !f14611f.equals(data.getPath())) {
                return false;
            }
            return true;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public DeepLinkEvent m12124b(Uri uri, DIDILocation dIDILocation) {
        String a = m12113a(uri, "client_id");
        Uri c = m12127c(m12128d(uri, dIDILocation), dIDILocation);
        String a2 = m12113a(c, f14614i);
        if (TextUtils.isEmpty(a2)) {
            a2 = m12113a(c, "product_id");
        }
        String a3 = m12113a(c, f14616k);
        m12113a(c, "order_source");
        DeepLinkEvent deepLinkEvent = new DeepLinkEvent();
        deepLinkEvent.mPickUpAddr = m12111a(c);
        deepLinkEvent.mDropOffAddr = m12126b(c);
        try {
            deepLinkEvent.mBid = m12123b(Integer.parseInt(a2));
        } catch (NumberFormatException e) {
            e.printStackTrace();
            deepLinkEvent.mBid = -1;
        }
        try {
            deepLinkEvent.mCarLevel = Integer.parseInt(m12113a(c, "car_level"));
        } catch (NumberFormatException e2) {
            e2.printStackTrace();
            deepLinkEvent.mCarLevel = 0;
        }
        if (deepLinkEvent.mCarLevel == 0 && deepLinkEvent.mBid > 0) {
            deepLinkEvent.mCarLevel = m12110a(deepLinkEvent.mBid);
        }
        deepLinkEvent.mTransportTime = 0;
        m12120a(a, deepLinkEvent, a3);
        return deepLinkEvent;
    }

    /* renamed from: c */
    private Uri m12127c(Uri uri, DIDILocation dIDILocation) {
        boolean z;
        Context context;
        int i;
        String a = m12113a(uri, f14621p);
        String a2 = m12113a(uri, f14622q);
        String trim = m12113a(uri, f14623r).trim();
        String trim2 = m12113a(uri, f14624s).trim();
        Uri.Builder buildUpon = uri.buildUpon();
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2)) {
            buildUpon.appendQueryParameter(f14621p, String.valueOf(dIDILocation.getLatitude()));
            buildUpon.appendQueryParameter(f14622q, String.valueOf(dIDILocation.getLongitude()));
            z = true;
        } else {
            z = false;
        }
        if (z) {
            context = this.f14628w;
            i = R.string.global_sug_current_location;
        } else {
            context = this.f14628w;
            i = R.string.deeplink_pin_location;
        }
        String string = context.getString(i);
        if (TextUtils.isEmpty(trim) && !TextUtils.isEmpty(trim2)) {
            buildUpon.appendQueryParameter(f14623r, trim2);
        }
        if (TextUtils.isEmpty(trim2) && !TextUtils.isEmpty(trim)) {
            buildUpon.appendQueryParameter(f14624s, trim);
        }
        if (TextUtils.isEmpty(trim) && TextUtils.isEmpty(trim2)) {
            buildUpon.appendQueryParameter(f14623r, string);
            buildUpon.appendQueryParameter(f14624s, string);
        }
        return buildUpon.build();
    }

    /* renamed from: d */
    private Uri m12128d(Uri uri, DIDILocation dIDILocation) {
        boolean z;
        Context context;
        int i;
        String a = m12113a(uri, f14617l);
        String a2 = m12113a(uri, f14618m);
        String trim = m12113a(uri, f14619n).trim();
        String trim2 = m12113a(uri, f14620o).trim();
        Uri.Builder buildUpon = uri.buildUpon();
        if (TextUtils.isEmpty(a) || TextUtils.isEmpty(a2)) {
            buildUpon.appendQueryParameter(f14617l, String.valueOf(dIDILocation.getLatitude()));
            buildUpon.appendQueryParameter(f14618m, String.valueOf(dIDILocation.getLongitude()));
            z = true;
        } else {
            z = false;
        }
        if (z) {
            context = this.f14628w;
            i = R.string.global_sug_current_location;
        } else {
            context = this.f14628w;
            i = R.string.deeplink_pin_location;
        }
        String string = context.getString(i);
        if (TextUtils.isEmpty(trim) && !TextUtils.isEmpty(trim2)) {
            buildUpon.appendQueryParameter(f14619n, trim2);
        }
        if (TextUtils.isEmpty(trim2) && !TextUtils.isEmpty(trim)) {
            buildUpon.appendQueryParameter(f14620o, trim);
        }
        if (TextUtils.isEmpty(trim) && TextUtils.isEmpty(trim2)) {
            buildUpon.appendQueryParameter(f14619n, string);
            buildUpon.appendQueryParameter(f14620o, string);
        }
        return buildUpon.build();
    }

    /* renamed from: a */
    private Address m12111a(Uri uri) {
        return m12112a(m12113a(uri, f14617l), m12113a(uri, f14618m), m12113a(uri, f14619n), m12113a(uri, f14620o));
    }

    /* renamed from: b */
    private Address m12126b(Uri uri) {
        Address a = m12112a(m12113a(uri, f14621p), m12113a(uri, f14622q), m12113a(uri, f14623r), m12113a(uri, f14624s));
        if (a != null) {
            a.setUid(this.f14629x);
        }
        return a;
    }

    /* renamed from: a */
    private Address m12112a(String str, String str2, String str3, String str4) {
        double doubleValue = NumberUtil.strToDouble(str).doubleValue();
        double doubleValue2 = NumberUtil.strToDouble(str2).doubleValue();
        if (doubleValue == 0.0d || doubleValue2 == 0.0d) {
            return null;
        }
        Address address = new Address();
        address.setLatitude(doubleValue);
        address.setLongitude(doubleValue2);
        address.setAddress(str4);
        address.setName(str3);
        address.cityId = -1;
        address.setDisplayName(str4);
        address.setFullName(str3);
        return address;
    }

    /* renamed from: a */
    private String m12113a(Uri uri, String str) {
        String str2;
        try {
            List<String> queryParameters = uri.getQueryParameters(str);
            if (queryParameters == null || queryParameters.isEmpty()) {
                str2 = "";
            } else {
                str2 = queryParameters.get(queryParameters.size() - 1);
            }
            if ("null".equalsIgnoreCase(str2)) {
                return "";
            }
            if (TextUtils.isEmpty(str2)) {
                return "";
            }
            return str2;
        } catch (Exception unused) {
            return "";
        }
    }

    /* renamed from: a */
    private void m12119a(String str) {
        m12121a(str, (Object) null);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12121a(String str, Object obj) {
        if (!TextUtils.isEmpty(str)) {
            BaseEventPublisher.getPublisher().removeStickyEvent(str);
            BaseEventPublisher.getPublisher().publishSticky(str, obj);
        }
    }

    /* renamed from: a */
    private void m12120a(String str, DeepLinkEvent deepLinkEvent, String str2) {
        if (deepLinkEvent != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("fr", str);
            if (deepLinkEvent.mPickUpAddr != null) {
                hashMap.put("from_lat", Double.valueOf(deepLinkEvent.mPickUpAddr.latitude));
                hashMap.put("from_lng", Double.valueOf(deepLinkEvent.mPickUpAddr.longitude));
                hashMap.put("from_address", deepLinkEvent.mPickUpAddr.address);
            }
            if (deepLinkEvent.mDropOffAddr != null) {
                hashMap.put("to_lat", Double.valueOf(deepLinkEvent.mDropOffAddr.latitude));
                hashMap.put("to_lng", Double.valueOf(deepLinkEvent.mDropOffAddr.longitude));
                hashMap.put("to_address", deepLinkEvent.mDropOffAddr.address);
            }
            hashMap.put("g_BizId", Integer.valueOf(deepLinkEvent.mBid));
            hashMap.put("eta", str2);
            GlobalOmegaUtils.trackEvent("gp_webRedirection_bubble_sw", (Map<String, Object>) hashMap);
        }
    }
}
