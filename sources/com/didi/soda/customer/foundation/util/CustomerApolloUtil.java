package com.didi.soda.customer.foundation.util;

import android.text.TextUtils;
import com.didi.foundation.sdk.utils.FoundationApolloUtil;
import com.didi.global.globalgenerickit.utils.JsonUtil;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.blocks.optimize.BlocksOptimizeModel;
import com.didi.soda.blocks.track.TrackConfig;
import com.didi.soda.customer.app.FixInfo;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.biz.popdialog.ApolloModel;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.coordshop.ApolloCoordConfig;
import com.didi.soda.customer.downgrade.DowngradeConfig;
import com.didi.soda.customer.downgrade.LimitVisitEntity;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.ActInfoEntity;
import com.didi.soda.customer.foundation.storage.AppConfigStorage;
import com.didi.soda.customer.foundation.storage.model.AppConfig;
import com.didi.soda.customer.foundation.util.startup.FallbackController;
import com.didi.soda.customer.map.model.CustomerMapStyle;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.topgun.manager.HomeStartUpRepo;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.net.RequestHandler;
import com.didichuxing.apollo.sdk.net.RequestParams;
import com.google.gson.reflect.TypeToken;
import global.didi.pay.presenter.GlobalBubbleShowHelper;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

public final class CustomerApolloUtil {

    /* renamed from: A */
    private static final String f43737A = "global_C_Android_open_start_up";

    /* renamed from: B */
    private static final String f43738B = "address_homepage_uid";

    /* renamed from: C */
    private static final String f43739C = "global_soda_im_map_has_max_distance";
    public static final String CUSTOMER_LONG_CONNECTION = "GJHWM_C";
    public static final String CUSTOMER_NET_DETECT_MONITOR = "sailing_net_detect_monitor_experiments";

    /* renamed from: D */
    private static final String f43740D = "global_customer_appsflyer_destory_control";

    /* renamed from: E */
    private static final String f43741E = "global_C_Android_get_fragment_way";

    /* renamed from: F */
    private static final String f43742F = "global_customer_feedback_pannel_config";

    /* renamed from: G */
    private static final String f43743G = "global_C_Android_map_new_render";

    /* renamed from: H */
    private static final String f43744H = "global_customer_flutter_semantics_off";
    public static final String HTTPDNS_NAMESPACE = "httpdns_android_waimai";

    /* renamed from: I */
    private static final String f43745I = "sa_promotion_method_ab_test";

    /* renamed from: J */
    private static final String f43746J = "global_C_open_preload_h5";

    /* renamed from: K */
    private static final String f43747K = "global_C_open_mock_location";

    /* renamed from: L */
    private static final String f43748L = "global_C_open_fix_bad_parcelable";

    /* renamed from: M */
    private static final String f43749M = "global_customer_recshop_config";

    /* renamed from: N */
    private static final String f43750N = "global_C_Android_tab_bar_fallback";

    /* renamed from: O */
    private static final String f43751O = "whitelist";

    /* renamed from: P */
    private static final String f43752P = "experiment";

    /* renamed from: Q */
    private static final String f43753Q = "params";

    /* renamed from: R */
    private static final String f43754R = "message";

    /* renamed from: S */
    private static final String f43755S = "global_customer_show_NA_pop_new";

    /* renamed from: T */
    private static final String f43756T = "global_C_customer_limit_visit";

    /* renamed from: U */
    private static final String f43757U = "global_C_negative_comment_select_reason";

    /* renamed from: V */
    private static final String f43758V = "C_User_preference";

    /* renamed from: W */
    private static final String f43759W = "Envelope_promocode_experiment";

    /* renamed from: X */
    private static int f43760X = -1;

    /* renamed from: Y */
    private static boolean f43761Y = false;

    /* renamed from: Z */
    private static boolean f43762Z = false;

    /* renamed from: a */
    private static final String f43763a = "CustomerApolloUtil";

    /* renamed from: aa */
    private static final String f43764aa = "citymap";

    /* renamed from: ab */
    private static final String f43765ab = "global_customer_disable_tabbar_imageview_placeholder";

    /* renamed from: ac */
    private static final String f43766ac = "ShopDesign_all";

    /* renamed from: ad */
    private static final String f43767ad = "customer_ab_test_name_map";

    /* renamed from: ae */
    private static final String f43768ae = "global_food_didipay_version_controll";

    /* renamed from: af */
    private static final String f43769af = "global_C_aether_Android_optimize";

    /* renamed from: ag */
    private static final String f43770ag = "global_C_aether_track_config";

    /* renamed from: b */
    private static final String f43771b = "global_customer_addr_gps_timeout";

    /* renamed from: c */
    private static final String f43772c = "global_customer_random_balance_verify";

    /* renamed from: d */
    private static final String f43773d = "global_C_web_url_append_params_hosts";

    /* renamed from: e */
    private static final String f43774e = "global_C_web_intercept_url_key";

    /* renamed from: f */
    private static final String f43775f = "soda_web_locale_exchange_host";

    /* renamed from: g */
    private static final String f43776g = "global_order_im_switch";

    /* renamed from: h */
    private static final String f43777h = "global_customer_im_merchant_voice_input_disable_config";

    /* renamed from: i */
    private static final String f43778i = "soda_order_polling_driver_duration";

    /* renamed from: j */
    private static final String f43779j = "soda_rate_dialog_duration";

    /* renamed from: k */
    private static final String f43780k = "global_C_Android_google_play_checker";

    /* renamed from: l */
    private static final String f43781l = "soda_order_polling_bd_distance";

    /* renamed from: m */
    private static final String f43782m = "global_C_Android_map_lazyload";

    /* renamed from: n */
    private static final String f43783n = "global_C_Android_webview_omega";

    /* renamed from: o */
    private static final String f43784o = "global_customer_addr_back_time";

    /* renamed from: p */
    private static final String f43785p = "global_C_place_order_tip_dialog";

    /* renamed from: q */
    private static final String f43786q = "global_customer_android_kotlin_on";

    /* renamed from: r */
    private static final String f43787r = "global_customer_add_cart_queue_strategy_params";

    /* renamed from: s */
    private static final String f43788s = "global_C_bill_price_anim";

    /* renamed from: t */
    private static final String f43789t = "android_customer_googlemap_style";

    /* renamed from: u */
    private static final String f43790u = "global_customer_android_in_app_review";

    /* renamed from: v */
    private static final String f43791v = "global_C_Android_dependency_downgrade";

    /* renamed from: w */
    private static final String f43792w = "global_C_appsflyer_omega_switch";

    /* renamed from: x */
    private static final String f43793x = "global_C_RLink_organic_city2url_map";

    /* renamed from: y */
    private static final String f43794y = "global_customer_ios_webpage_appendquery_toggle";

    /* renamed from: z */
    private static final String f43795z = "sailing_c_im_map_max_distance";

    public static int getNewBusinessFeedType() {
        return 3;
    }

    public static boolean isFlutterSemanticsOff() {
        return true;
    }

    private CustomerApolloUtil() {
    }

    public static void addParameters() {
        Apollo.setRequestHandler(new RequestHandler() {
            public void handleRequestParams(RequestParams requestParams) {
                String countryCode = LocationUtil.getCountryCode();
                if (countryCode == null) {
                    countryCode = "";
                }
                requestParams.addParam("location_country", countryCode);
                requestParams.addParam("rlab_location_country", countryCode);
                requestParams.addParam("rlab_county_id", String.valueOf(LocationUtil.getCountyId()));
                requestParams.addParam("rlab_county_group_id", String.valueOf(LocationUtil.getCountyGroupId()));
                requestParams.addParam("rlab_business_id", AppConst.BUSINESS_ID);
            }
        });
    }

    public static List<String> getKotlinOnPageList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f43786q);
        if (jsonToggle != null) {
            return m32681a(jsonToggle, "message");
        }
        return null;
    }

    public static boolean getSALandingShowAddr() {
        try {
            IToggle toggle = Apollo.getToggle(f43745I, false);
            if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("group", 0)).intValue() != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isOpenPreloadH5() {
        try {
            IToggle toggle = Apollo.getToggle(f43746J, true);
            if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("is_open", 1)).intValue() != 1) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isOpenMockLocation() {
        try {
            return Apollo.getToggle(f43747K, false).allow();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static FixInfo isFixBadParcel() {
        try {
            IToggle toggle = Apollo.getToggle(f43748L, false);
            if (toggle.allow()) {
                return FixInfo.Companion.create(true, (String) toggle.getExperiment().getParam("phone_model", ""), ((Integer) toggle.getExperiment().getParam("with_brand", 0)).intValue() == 1);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return FixInfo.Companion.create(false, "", false);
    }

    public static ApolloCoordConfig getCoordShopConfig() {
        try {
            IToggle toggle = Apollo.getToggle(f43749M, true);
            if (toggle.allow()) {
                return ApolloCoordConfig.Companion.create((String) toggle.getExperiment().getParam("shop_minvisible_json", ""), ((Integer) toggle.getExperiment().getParam("home_maxvisible", 0)).intValue());
            }
            return null;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Boolean isOpenTabFallback() {
        try {
            return Boolean.valueOf(Apollo.getToggle(f43750N, false).allow());
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static Map<String, Object> getOrganicCityMap() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f43793x);
        if (jsonToggle != null) {
            return m32682b(jsonToggle, f43764aa);
        }
        return null;
    }

    public static boolean isValidateCardEnable() {
        try {
            IToggle toggle = Apollo.getToggle(f43772c, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static List<String> getAppendParameterList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f43773d);
        if (jsonToggle != null) {
            return m32681a(jsonToggle, f43751O);
        }
        return null;
    }

    public static List<String> getBlackList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f43774e);
        if (jsonToggle != null) {
            return m32681a(jsonToggle, "blocklist");
        }
        return null;
    }

    public static List<String> getReplaceLocaleList() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f43775f);
        if (jsonToggle != null) {
            return m32681a(jsonToggle, f43751O);
        }
        return null;
    }

    public static boolean isOpenWebAppendParam() {
        try {
            IToggle toggle = Apollo.getToggle(f43794y, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isSkipPromoCode() {
        try {
            IToggle toggle = Apollo.getToggle(f43759W, false);
            if (toggle != null) {
                return toggle.allow();
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return true;
        }
    }

    public static FallbackController.FallbackModel getFallbackToggleModel() {
        try {
            FallbackController.FallbackModel fallbackModel = new FallbackController.FallbackModel();
            boolean z = false;
            IToggle toggle = Apollo.getToggle(f43737A, false);
            if (toggle == null || !toggle.allow()) {
                return fallbackModel;
            }
            IExperiment experiment = toggle.getExperiment();
            fallbackModel.isOpen = true;
            fallbackModel.isOpenLazyComponent = ((Integer) experiment.getParam("open_lazy_comp", 0)).intValue() == 1;
            fallbackModel.isOpenDelayFlutter = ((Integer) experiment.getParam("open_delay_flutter", 0)).intValue() == 1;
            fallbackModel.isOpenPreLoc = ((Integer) experiment.getParam("open_pre_loc", 0)).intValue() == 1;
            fallbackModel.isCloseSplashPost = ((Integer) experiment.getParam("close_splash_post", 0)).intValue() == 1;
            fallbackModel.isOpenPreFeed = ((Integer) experiment.getParam("open_pre_feed", 0)).intValue() == 1;
            if (((Integer) experiment.getParam("remove_set_view", 0)).intValue() == 1) {
                z = true;
            }
            fallbackModel.isRemoveSetView = z;
            return fallbackModel;
        } catch (Exception e) {
            e.printStackTrace();
            return new FallbackController.FallbackModel();
        }
    }

    public static boolean isRequestFacebookUserPostsPermission() {
        try {
            IToggle toggle = Apollo.getToggle("facebook_verification_permissions", false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isSelectReason() {
        try {
            IToggle toggle = Apollo.getToggle(f43757U, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isImEnterAvild() {
        try {
            IToggle toggle = Apollo.getToggle(f43776g, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static DowngradeConfig getDownGradeConfig() {
        try {
            IToggle toggle = Apollo.getToggle(f43791v, false);
            if (toggle != null && toggle.allow()) {
                DowngradeConfig downgradeConfig = new DowngradeConfig();
                IExperiment experiment = toggle.getExperiment();
                downgradeConfig.mToggle = 1;
                downgradeConfig.mDowngradeMap = ((Integer) experiment.getParam("dg_map", 0)).intValue();
                downgradeConfig.mDowngradeIM = ((Integer) experiment.getParam("dg_im", 0)).intValue();
                downgradeConfig.mDowngradeShare = ((Integer) experiment.getParam("dg_share", 0)).intValue();
                downgradeConfig.mDowngradeFacebookLogin = ((Integer) experiment.getParam("dg_third_login_facebook", 0)).intValue();
                downgradeConfig.mDowngradeGoogleLogin = ((Integer) experiment.getParam("dg_third_login_google", 0)).intValue();
                return downgradeConfig;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new DowngradeConfig();
    }

    public static int naPopDialogInterval() {
        int i = f43760X;
        if (i > 0) {
            return i;
        }
        return m32679a(30, f43755S);
    }

    public static String getIMQuickMessages() {
        return FoundationApolloUtil.getIMQuickMessages("sailing_rlab_founding_configuration");
    }

    public static boolean isConfigMerchantComment() {
        try {
            String iMQuickMessages = getIMQuickMessages();
            if (TextUtils.isEmpty(iMQuickMessages) || new JSONObject(iMQuickMessages).optJSONObject("merchant") == null) {
                return false;
            }
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static String getAudioInputEnableIMMessage() {
        JSONObject jsonToggle = Apollo.getJsonToggle(f43777h);
        if (jsonToggle != null) {
            try {
                JSONObject jSONObject = jsonToggle.getJSONObject(f43752P);
                JSONObject jSONObject2 = jSONObject != null ? jSONObject.getJSONObject("params") : null;
                String optString = jSONObject2 != null ? jSONObject2.optString("message") : null;
                LogUtil.m32588i(f43763a, "IM Common words from ab: " + optString);
                return optString;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int getPollingDuration() {
        return m32679a(10, f43778i);
    }

    public static int getPollingBDDistance() {
        return m32679a(100, f43781l);
    }

    public static int getImMapMaxDistance() {
        return m32679a(1500, f43795z);
    }

    public static int getRateDialogShowInterval() {
        return m32679a(0, f43779j);
    }

    public static boolean isGoogleInAppReviewMode() {
        try {
            IToggle toggle = Apollo.getToggle(f43790u, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isOmegaTrack() {
        try {
            IToggle toggle = Apollo.getToggle(f43792w, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getBackGorundRefreshShortTime() {
        return m32680a(1, f43784o, "short");
    }

    public static int getBackGorundRefreshLongTime() {
        return m32680a(15, f43784o, "long");
    }

    public static boolean isGooglePlayCheckerOn() {
        try {
            IToggle toggle = Apollo.getToggle(f43780k, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isMapLazyLoadOn() {
        try {
            IToggle toggle = Apollo.getToggle(f43782m, true);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static LimitVisitEntity getLimitVisitConfig() {
        LimitVisitEntity limitVisitEntity = new LimitVisitEntity();
        try {
            IToggle toggle = Apollo.getToggle(f43756T, false);
            if (toggle != null && toggle.allow()) {
                IExperiment experiment = toggle.getExperiment();
                limitVisitEntity.isOpen = true;
                limitVisitEntity.limitTime = ((Integer) experiment.getParam("limit_time", 0)).intValue();
                limitVisitEntity.limitRandomTime = ((Integer) experiment.getParam("limit_random_plus_time", 0)).intValue();
                String str = (String) experiment.getParam("whiteAPIList", "");
                if (!TextUtils.isEmpty(str)) {
                    String[] split = str.split(",");
                    if (split.length > 0) {
                        limitVisitEntity.blackList = new ArrayList<>();
                        for (String trim : split) {
                            limitVisitEntity.blackList.add(trim.trim());
                        }
                    }
                }
                return limitVisitEntity;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return limitVisitEntity;
    }

    public static boolean isWebViewOmegaOn() {
        try {
            IToggle toggle = Apollo.getToggle(f43783n, true);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    public static boolean isNetDetectEnable() {
        try {
            IToggle toggle = Apollo.getToggle("sailing_net_detect_monitor_experiments", false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static int getStartGpsTimeout() {
        return m32680a(4000, f43771b, "androidStart");
    }

    public static int getBackGpsTimeout() {
        return m32680a(4000, f43771b, "androidBack");
    }

    public static int getAddCartMaxNum() {
        return m32680a(15, f43787r, "cartCapacity");
    }

    public static int getAddCartDelayTime() {
        return m32680a(200, f43787r, "taskCommitInterval");
    }

    public static boolean hasMapMaxDistance() {
        return m32680a(0, f43739C, "noMaxDistance") == 0;
    }

    public static boolean isPlaceOrderTipDialog() {
        if (f43761Y) {
            return f43762Z;
        }
        f43761Y = true;
        try {
            IToggle toggle = Apollo.getToggle(f43785p, false);
            if (toggle != null) {
                boolean allow = toggle.allow();
                f43762Z = allow;
                return allow;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        f43762Z = false;
        return false;
    }

    public static String getHomeFeedbackBtnConfig() {
        try {
            return (String) Apollo.getToggle(f43742F).getExperiment().getParam("btnList", "");
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean isBillPriceAnimOn() {
        try {
            return Apollo.getToggle(f43788s).allow();
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public static void go2EfoOrNot(ActInfoEntity actInfoEntity, String str, int i) {
        try {
            IToggle toggle = Apollo.getToggle(f43758V);
            IExperiment experiment = toggle.getExperiment();
            String str2 = (String) experiment.getParam("url", "");
            String json = GsonUtil.toJson(actInfoEntity);
            UrlBuilder create = UrlBuilder.create(str2);
            String build = create.appendParam("scene", i + "").appendParam(Const.PageParams.COMPONENT_ID, str).appendParam(Const.PageParams.ACT_INFO, json).build();
            AppConfigStorage appConfigStorage = (AppConfigStorage) SingletonFactory.get(AppConfigStorage.class);
            AppConfig data = appConfigStorage.getData();
            if (toggle.allow() && experiment != null && !TextUtils.isEmpty(str2) && ((Boolean) ((HomeStartUpRepo) RepoFactory.getRepo(HomeStartUpRepo.class)).getValue()).booleanValue() && Math.abs(System.currentTimeMillis() - data.landEFO) >= GlobalBubbleShowHelper.ONE_WEEK) {
                data.landEFO = System.currentTimeMillis();
                appConfigStorage.setData(data);
                ((HomeStartUpRepo) RepoFactory.getRepo(HomeStartUpRepo.class)).setValue(false);
                SchemeHelper.dispatchMsg(build);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static CustomerMapStyle getCustomerGoogleMapStyle() {
        try {
            IExperiment experiment = Apollo.getToggle(f43789t).getExperiment();
            CustomerMapStyle customerMapStyle = new CustomerMapStyle();
            customerMapStyle.styleJson = (String) experiment.getParam("style_jsonString", "");
            boolean z = false;
            if (((Integer) experiment.getParam("building_enable", 0)).intValue() == 1) {
                z = true;
            }
            customerMapStyle.buildingEnable = z;
            return customerMapStyle;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static ApolloModel getAFDestroySwitch() {
        ApolloModel apolloModel = new ApolloModel(true, 5000);
        try {
            IToggle toggle = Apollo.getToggle(f43740D, true);
            if (toggle != null) {
                apolloModel.setOpen(toggle.allow());
                if (toggle.allow()) {
                    apolloModel.setTimeout(((Integer) toggle.getExperiment().getParam("unregister_time_out", 5000)).intValue());
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return apolloModel;
    }

    public static boolean createFragmentAllowNull() {
        try {
            if (((Integer) Apollo.getToggle(f43741E).getExperiment().getParam("is_open", 1)).intValue() == 1) {
                return true;
            }
            return false;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    /* renamed from: a */
    private static int m32679a(int i, String str) {
        return m32680a(i, str, "interval");
    }

    /* renamed from: a */
    private static int m32680a(int i, String str, String str2) {
        JSONObject jsonToggle = Apollo.getJsonToggle(str);
        if (jsonToggle != null) {
            try {
                JSONObject jSONObject = jsonToggle.getJSONObject(f43752P);
                JSONObject jSONObject2 = null;
                if (jSONObject != null) {
                    jSONObject2 = jSONObject.getJSONObject("params");
                }
                return jSONObject2 != null ? jSONObject2.optInt(str2, i) : i;
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return i;
    }

    /* renamed from: a */
    private static List<String> m32681a(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(f43752P);
                JSONObject jSONObject3 = jSONObject2 != null ? jSONObject2.getJSONObject("params") : null;
                String optString = jSONObject3 != null ? jSONObject3.optString(str) : null;
                if (!TextUtil.isEmpty(optString)) {
                    String[] split = optString.split(",");
                    if (split.length > 0) {
                        return new ArrayList(Arrays.asList(split));
                    }
                }
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /* renamed from: b */
    private static Map<String, Object> m32682b(JSONObject jSONObject, String str) {
        if (jSONObject != null) {
            try {
                JSONObject jSONObject2 = jSONObject.getJSONObject(f43752P);
                JSONObject jSONObject3 = jSONObject2 != null ? jSONObject2.getJSONObject("params") : null;
                return JsonUtil.jsonToMap(jSONObject3 != null ? jSONObject3.optString(str) : null);
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public static int getLocationSettingShownInterval() {
        IToggle toggle = Apollo.getToggle(f43738B);
        if (toggle.allow()) {
            return ((Integer) toggle.getExperiment().getParam("hour", 0)).intValue();
        }
        return 0;
    }

    public static boolean tabBarPlaceHolderSwitch() {
        try {
            IToggle toggle = Apollo.getToggle(f43765ab, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean isMapNewRender() {
        try {
            IToggle toggle = Apollo.getToggle(f43743G, false);
            if (toggle != null) {
                return toggle.allow();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    public static String getNativeFintechState() {
        try {
            return Apollo.getToggle(f43768ae).getExperiment().getStringParam("sdkVersion", "");
        } catch (Throwable th) {
            th.printStackTrace();
            return null;
        }
    }

    public static String getCustomerAbName() {
        IToggle toggle = Apollo.getToggle(f43767ad);
        if (toggle.allow()) {
            return toggle.getExperiment().getStringParam("shopRedsign", "");
        }
        return null;
    }

    public static BlocksOptimizeModel getBlocksOptimizeToggleModel() {
        try {
            BlocksOptimizeModel blocksOptimizeModel = new BlocksOptimizeModel();
            boolean z = false;
            IToggle toggle = Apollo.getToggle(f43769af, false);
            if (toggle == null || !toggle.allow()) {
                return blocksOptimizeModel;
            }
            IExperiment experiment = toggle.getExperiment();
            blocksOptimizeModel.setOpen(true);
            blocksOptimizeModel.setOpenResultCache(((Integer) experiment.getParam("open_result_cache", 1)).intValue() == 1);
            blocksOptimizeModel.setOpenRegularReplace(((Integer) experiment.getParam("open_regular_replace", 1)).intValue() == 1);
            blocksOptimizeModel.setOpenGsonReplace(((Integer) experiment.getParam("open_gson_replace", 1)).intValue() == 1);
            if (((Integer) experiment.getParam("open_gallery", 0)).intValue() == 1) {
                z = true;
            }
            blocksOptimizeModel.setOpenGallery(z);
            return blocksOptimizeModel;
        } catch (Exception e) {
            e.printStackTrace();
            return new BlocksOptimizeModel();
        }
    }

    public static TrackConfig getTrackConfig() {
        try {
            TrackConfig trackConfig = new TrackConfig();
            IToggle toggle = Apollo.getToggle(f43770ag, false);
            if (toggle == null || !toggle.allow()) {
                return trackConfig;
            }
            IExperiment experiment = toggle.getExperiment();
            trackConfig.setOpen(true);
            String stringParam = experiment.getStringParam("rateConfig", "");
            if (TextUtils.isEmpty(stringParam)) {
                return trackConfig;
            }
            trackConfig.setRateConfig((ArrayList) GsonUtil.fromJson(stringParam, new TypeToken<ArrayList<TrackConfig.TemplateRate>>() {
            }.getType()));
            return trackConfig;
        } catch (Exception e) {
            e.printStackTrace();
            return new TrackConfig();
        }
    }
}
