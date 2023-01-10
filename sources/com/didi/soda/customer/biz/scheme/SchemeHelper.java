package com.didi.soda.customer.biz.scheme;

import android.net.Uri;
import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.wallet.open.DidiWalletFactory;
import com.didi.payment.wallet.open.param.GlobalWalletParam;
import com.didi.soda.customer.app.CustomerActivityManager;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.AppConst;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.foundation.log.RecordTracker;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.ParamsHelper;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.param.GlobalParam;
import com.didi.soda.customer.foundation.tracker.param.GuideParam;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.NetWorkUtils;
import com.didi.soda.customer.foundation.util.NumberParseUtil;
import com.didi.soda.customer.foundation.util.UiHandlerUtil;
import com.didi.soda.customer.immap.IMMapHelper;
import com.didi.soda.customer.p165h5.CustomerWebActivity;
import com.didi.soda.pay.BindCardHelper;
import com.didi.soda.router.DiRouter;
import com.didi.soda.router.Request;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import p218io.flutter.embedding.android.registry.NFlutterContainerRegistry;

public class SchemeHelper {
    public static final String FROM_DYNAMIC = "dynamic";
    public static final String FROM_OTHER = "other";
    public static final String FROM_WEB = "webPage";
    public static final boolean NOT_COLD_LAUNCH = false;
    public static final String SCHEME_FROM = "schem_from";
    public static final String WALLET_BIND_CARD_PATH = "bindCardPage";
    public static final String WALLET_PATH = "walletPage";

    /* renamed from: a */
    private static final String f43116a = "SchemeHelper";

    /* renamed from: b */
    private static final int f43117b = 5000;

    /* renamed from: c */
    private static final String f43118c = "gsodacustomer";

    /* renamed from: d */
    private static final String f43119d = "globalOneTravel";

    /* renamed from: e */
    private static final String f43120e = "bsodacustomer";

    /* renamed from: f */
    private static final String f43121f = "taxis99OneTravel";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public static Request.Builder f43122g;

    /* renamed from: h */
    private static Runnable f43123h = new Runnable() {
        public void run() {
            Request.Builder unused = SchemeHelper.f43122g = null;
        }
    };

    public static void dispatchMsg(String str) {
        if (!TextUtils.isEmpty(str)) {
            dispatchMsg(Uri.parse(str), false);
        }
    }

    public static void dispatchMsg(Uri uri, String str, String str2, boolean z) {
        dispatchMsg(uri, str, str2, (ScopeContext) null, z);
    }

    public static void dispatchMsgForPageResultByPage(Uri uri, String str, String str2, ScopeContext scopeContext, boolean z) {
        dispatchMsg(uri, str, str2, scopeContext, z);
    }

    public static void dispatchMsg(Uri uri, String str, String str2, ScopeContext scopeContext, boolean z) {
        if (m32256b(uri)) {
            CustomerActivityManager.getInstance().popToRoot();
        }
        LogUtil.m32588i(f43116a, "dispatchMsg curTime=" + System.currentTimeMillis());
        if (NetWorkUtils.isHttpUri(uri)) {
            LogUtil.m32588i(f43116a, "dispatchMsg -> isHttpUri");
            DiRouter.request().path("webPage").putString("url", uri.toString()).putString("title", str2).open();
        } else if (!isSodaSchemeUri(uri)) {
            LogUtil.m32588i(f43116a, "dispatchMsg -> NotSodaSchemeUri");
            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SCHEME).addModuleName("scheme").addErrorType("fail").addErrorMsg(uri.toString()).build().trackError();
        } else if (!m32254a(uri)) {
            if (m32259e(uri)) {
                Uri.Builder buildUpon = uri.buildUpon();
                buildUpon.appendQueryParameter("path", "/order_page");
                uri = buildUpon.build();
            }
            m32250a(uri, str, scopeContext, z);
        }
    }

    public static void dispatchMsg(Uri uri, boolean z) {
        dispatchMsg(uri, "other", "", z);
    }

    /* renamed from: a */
    private static boolean m32254a(Uri uri) {
        if (m32257c(uri)) {
            DidiWalletFactory.createGlobalWalletApi().openWallet(GlobalContext.getContext(), (GlobalWalletParam) null);
            return true;
        } else if (m32258d(uri)) {
            String queryParameter = uri.getQueryParameter(ParamConst.PARAM_BIND_TYPE);
            String queryParameter2 = uri.getQueryParameter("resource_id");
            DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
            addCardParam.bindType = TextUtils.isEmpty(queryParameter) ? 14 : NumberParseUtil.parseInt(queryParameter);
            addCardParam.isShowLoading = true;
            addCardParam.isSignAfterOrder = true;
            addCardParam.productLine = AppConst.BUSINESS_ID;
            if (TextUtils.isEmpty(queryParameter2)) {
                queryParameter2 = "";
            }
            addCardParam.resourceId = queryParameter2;
            BindCardHelper.bindCard(addCardParam, 1);
            return true;
        } else if (!m32260f(uri)) {
            return false;
        } else {
            IMMapHelper.startNavIMMap(uri.toString());
            return true;
        }
    }

    public static boolean isSodaSchemeUri(Uri uri) {
        if (uri != null && !TextUtils.isEmpty(uri.getHost())) {
            String scheme = uri.getScheme();
            String host = uri.getHost();
            if (!TextUtils.isEmpty(scheme) && !TextUtils.isEmpty(host)) {
                return "soda".equals(host);
            }
        }
        return false;
    }

    /* renamed from: b */
    private static boolean m32256b(Uri uri) {
        if (CustomerActivityManager.getInstance().findActivityTop(CustomerWebActivity.class) || (uri.getQueryParameter("from") != null && Const.H5Params.FROM_XIAOXIHAO.equals(uri.getQueryParameter("from")))) {
            return true;
        }
        if (TextUtils.isEmpty(uri.getQueryParameter("url")) || !"1".equals(Uri.parse(uri.getQueryParameter("url")).getQueryParameter("nativeWebUIType"))) {
            return false;
        }
        return true;
    }

    /* renamed from: c */
    private static boolean m32257c(Uri uri) {
        if (uri == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.trim().contains("walletPage");
    }

    /* renamed from: d */
    private static boolean m32258d(Uri uri) {
        if (uri == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.trim().contains(WALLET_BIND_CARD_PATH);
    }

    /* renamed from: e */
    private static boolean m32259e(Uri uri) {
        if (uri == null) {
            return false;
        }
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.trim().contains("orderPage");
    }

    /* renamed from: f */
    private static boolean m32260f(Uri uri) {
        LogUtil.m32584d("TAG", "isIMLocationSchemeUri" + uri);
        if (uri == null) {
            return false;
        }
        LogUtil.m32584d("TAG", "isIMLocationSchemeUri" + uri.toString());
        String path = uri.getPath();
        if (TextUtils.isEmpty(path)) {
            return false;
        }
        return path.contains("beatles_im_location");
    }

    public static void delayOpenPage() {
        if (f43122g != null) {
            LogUtil.m32588i(f43116a, "延迟跳转 curTime=" + System.currentTimeMillis());
            f43122g.open();
            f43122g = null;
        }
    }

    public static void recycle() {
        LogUtil.m32588i(f43116a, "清空缓存");
        f43122g = null;
    }

    /* renamed from: a */
    private static void m32250a(Uri uri, String str, ScopeContext scopeContext, boolean z) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path) || path.trim().equals("//") || path.trim().equals("/") || path.trim().contains("homePage")) {
            path = "taxis99OneTravel://soda";
        }
        LogUtil.m32588i(f43116a, "routePath = " + path);
        Request.Builder request = DiRouter.request();
        m32252a(request, uri, z);
        if ("webPage".equals(str)) {
            request.path(path).putString("schem_from", "webPage");
        } else if ("dynamic".equals(str)) {
            request.path(path).putString("schem_from", "dynamic");
        } else {
            request.path("taxis99OneTravel://soda");
        }
        request.putString("schemeAssistPath", path);
        request.putInt("schemeRouterTag", 1);
        if (scopeContext != null) {
            request.setFromPage(scopeContext);
        }
        if (GlobalContext.isFragmentInited()) {
            LogUtil.m32588i(f43116a, "直接跳转");
            request.open();
            f43122g = null;
            return;
        }
        LogUtil.m32588i(f43116a, "延迟跳转－存储数据");
        f43122g = request;
        UiHandlerUtil.removeCallbacks(f43123h);
        UiHandlerUtil.postDelayed(f43123h, 5000);
    }

    public static void flutterOpenSodaPage(String str, HashMap<String, Object> hashMap, String str2) {
        Uri uri;
        Request.Builder builder;
        try {
            uri = Uri.parse(str);
        } catch (Exception unused) {
            uri = null;
        }
        if (!m32254a(uri)) {
            if (str.startsWith("http") || str.startsWith("https")) {
                builder = DiRouter.request().path("webPage");
                hashMap.put("url", m32249a(str, ParamsHelper.getFlutterRouterCommonParam()));
                hashMap.put("removesFromViewOnPush", false);
            } else if (m32255a(str)) {
                Uri parse = Uri.parse(str);
                String path = parse.getPath();
                builder = DiRouter.request().path(path);
                if (TextUtils.isEmpty(path) || path.trim().equals("//") || path.trim().equals("/") || path.trim().contains("homePage")) {
                    path = "taxis99OneTravel://soda";
                    builder = DiRouter.request().path(path);
                    builder.putString("schemeAssistPath", path);
                    builder.putInt("schemeRouterTag", 1);
                }
                m32251a(builder, parse);
                str = path;
            } else {
                builder = DiRouter.request().path(str);
            }
            RecordTracker.Builder.create().setTag(f43116a).setMessage("onOpenFlutterContainer").setLogCategory("c-data|").setOtherParam("path", str).setOtherParam("param", hashMap != null ? hashMap.toString() : "null").build().info();
            if (hashMap == null || hashMap.size() == 0) {
                builder.open();
                return;
            }
            for (String next : hashMap.keySet()) {
                Object obj = hashMap.get(next);
                m32253a(builder, next, obj);
                m32253a(builder, next.toLowerCase(), obj);
            }
            builder.setFromPage(NFlutterContainerRegistry.getContainer(str2).getScopeContext());
            builder.open();
        }
    }

    /* renamed from: a */
    private static void m32253a(Request.Builder builder, String str, Object obj) {
        if (obj instanceof String) {
            builder.putString(str, (String) obj);
        } else if (obj instanceof Boolean) {
            builder.putBoolean(str, ((Boolean) obj).booleanValue());
        } else if (obj instanceof Integer) {
            builder.putInt(str, ((Integer) obj).intValue());
        } else if (obj instanceof Long) {
            builder.putLong(str, ((Long) obj).longValue());
        } else if (obj instanceof Double) {
            builder.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Serializable) {
            builder.putSerializable(str, (Serializable) obj);
        }
    }

    /* renamed from: a */
    private static String m32249a(String str, Map<String, String> map) {
        if (str == null || str.isEmpty()) {
            return str;
        }
        StringBuffer stringBuffer = new StringBuffer();
        Matcher matcher = Pattern.compile("\\$\\{(.+?)\\}").matcher(str);
        while (matcher.find()) {
            String str2 = map.get(matcher.group(1));
            if (str2 != null) {
                matcher.appendReplacement(stringBuffer, str2);
            }
        }
        matcher.appendTail(stringBuffer);
        return stringBuffer.toString();
    }

    /* renamed from: a */
    private static void m32252a(Request.Builder builder, Uri uri, boolean z) {
        if (!TextUtils.isEmpty(uri.getQuery())) {
            GlobalParam.ExternalGlobalParam externalGlobalParam = new GlobalParam.ExternalGlobalParam();
            GuideParam guideParam = new GuideParam();
            for (String next : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(next);
                LogUtil.m32588i(f43116a, "params[" + next + ":" + queryParameter + com.didichuxing.bigdata.p174dp.locsdk.Const.jaRight);
                if (!externalGlobalParam.fetchParam(next, queryParameter, z)) {
                    if (guideParam.fetchParam(next, queryParameter)) {
                        OmegaCommonParamHelper.updateGuideParamByScheme(guideParam);
                    } else {
                        builder.putString(next.toLowerCase(), queryParameter);
                    }
                }
            }
            if (externalGlobalParam.hasData()) {
                OmegaCommonParamHelper.setExternalGlobalParam(externalGlobalParam);
            }
        }
    }

    /* renamed from: a */
    private static void m32251a(Request.Builder builder, Uri uri) {
        if (!TextUtils.isEmpty(uri.getQuery())) {
            for (String next : uri.getQueryParameterNames()) {
                builder.putString(next, uri.getQueryParameter(next));
            }
        }
    }

    /* renamed from: a */
    private static boolean m32255a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (str.startsWith("bsodacustomer") || str.startsWith("bsodacustomer") || str.startsWith("taxis99OneTravel") || str.startsWith("gsodacustomer") || str.startsWith("globalOneTravel")) {
            return true;
        }
        return false;
    }
}
