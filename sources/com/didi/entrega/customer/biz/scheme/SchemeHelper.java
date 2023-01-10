package com.didi.entrega.customer.biz.scheme;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.tracker.param.GlobalParam;
import com.didi.entrega.customer.foundation.util.NetWorkUtils;
import com.didi.entrega.customer.foundation.util.UiHandlerUtil;
import com.didi.entrega.customer.immap.IMMapHelper;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.IOneSdkService;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.Request;
import com.didi.sdk.global.DidiGlobalPayApiFactory;
import com.didi.sdk.global.DidiGlobalPayMethodListData;
import com.didichuxing.bigdata.p174dp.locsdk.Const;

public class SchemeHelper {
    public static final String FROM_OTHER = "other";
    public static final String FROM_WEB = "webPage";
    public static final boolean NOT_COLD_LAUNCH = false;
    public static final String SCHEME_FROM = "schem_from";

    /* renamed from: a */
    private static final String f21685a = "SchemeHelper";

    /* renamed from: b */
    private static final int f21686b = 5000;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Request.Builder f21687c;

    /* renamed from: d */
    private static Runnable f21688d = new Runnable() {
        public void run() {
            Request.Builder unused = SchemeHelper.f21687c = null;
        }
    };

    public static void dispatchMsg(String str) {
        if (!TextUtils.isEmpty(str)) {
            dispatchMsg(Uri.parse(str), false);
        }
    }

    public static void dispatchMsg(Uri uri, String str, String str2, boolean z) {
        if (uri.getQueryParameter("closeSideMenu") != null && "1".equals(uri.getQueryParameter("closeSideMenu"))) {
            ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).closeSideMenu();
        }
        LogUtil.m18185i(f21685a, "dispatchMsg curTime=" + System.currentTimeMillis());
        if (NetWorkUtils.isHttpUri(uri)) {
            LogUtil.m18185i(f21685a, "dispatchMsg -> isHttpUri");
            DiRouter.request().path("webPage").putString("url", uri.toString()).putString("title", str2).open();
        } else if (!RouteValidation.isEntregaSchemeUri(uri)) {
            LogUtil.m18185i(f21685a, "dispatchMsg -> NotEntregaSchemeUri");
            ErrorTracker.create(ErrorConst.ErrorName.SAILING_C_SCHEME).addModuleName("scheme").addErrorType("fail").addErrorMsg(uri.toString()).build().trackError();
        } else if (RouteValidation.isWalletSchemeUri(uri)) {
            DidiGlobalPayApiFactory.createDidiPay().startPayMethodListActivity((Activity) GlobalContext.getContext(), 1, new DidiGlobalPayMethodListData.PayMethodListParam(DidiGlobalPayMethodListData.Entrance.FROM_SIDEBAR));
        } else if (RouteValidation.isIMLocationSchemeUri(uri)) {
            IMMapHelper.startNavIMMap(uri.toString());
        } else {
            m18121a(uri, str, z);
        }
    }

    public static void dispatchMsg(Uri uri, boolean z) {
        dispatchMsg(uri, "other", "", z);
    }

    public static void delayOpenPage() {
        if (f21687c != null) {
            LogUtil.m18185i(f21685a, "延迟跳转 curTime=" + System.currentTimeMillis());
            f21687c.open();
            f21687c = null;
        }
    }

    public static void recycle() {
        LogUtil.m18185i(f21685a, "清空缓存");
        f21687c = null;
    }

    /* renamed from: a */
    private static void m18121a(Uri uri, String str, boolean z) {
        String path = uri.getPath();
        if (TextUtils.isEmpty(path) || path.trim().equals("//") || path.trim().equals("/") || path.trim().contains("homePage")) {
            path = "taxis99OneTravel://sodaEntrega";
        }
        LogUtil.m18185i(f21685a, "routePath = " + path);
        Request.Builder request = DiRouter.request();
        m18122a(request, uri, z);
        if ("webPage".equals(str)) {
            request.path(path).putString("schem_from", "webPage");
        } else {
            request.path("taxis99OneTravel://sodaEntrega");
        }
        request.putString("schemeAssistPath", path);
        request.putInt("schemeRouterTag", 1);
        if (GlobalContext.isFragmentInited()) {
            LogUtil.m18185i(f21685a, "直接跳转");
            request.open();
            f21687c = null;
            return;
        }
        LogUtil.m18185i(f21685a, "延迟跳转－存储数据");
        f21687c = request;
        UiHandlerUtil.removeCallbacks(f21688d);
        UiHandlerUtil.postDelayed(f21688d, 5000);
    }

    /* renamed from: a */
    private static void m18122a(Request.Builder builder, Uri uri, boolean z) {
        if (!TextUtils.isEmpty(uri.getQuery())) {
            GlobalParam.ExternalGlobalParam externalGlobalParam = new GlobalParam.ExternalGlobalParam();
            for (String next : uri.getQueryParameterNames()) {
                String queryParameter = uri.getQueryParameter(next);
                LogUtil.m18185i(f21685a, "params[" + next + ":" + queryParameter + Const.jaRight);
                if (!externalGlobalParam.fetchParam(next, queryParameter, z)) {
                    builder.putString(next, queryParameter);
                }
            }
            if (externalGlobalParam.hasData()) {
                OmegaCommonParamHelper.setExternalGlobalParam(externalGlobalParam);
            }
        }
    }
}
