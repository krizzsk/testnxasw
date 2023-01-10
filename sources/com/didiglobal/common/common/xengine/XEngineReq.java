package com.didiglobal.common.common.xengine;

import com.didi.sdk.apm.SystemUtils;
import com.didi.xengine.request.XEBizParamsImpl;
import com.didi.xengine.request.XECacheParamsImpl;
import com.didi.xengine.request.XECommitBizParams;
import com.didi.xengine.request.XEDispatchBizParams;
import com.didi.xengine.request.XEngineReqUtil;

public class XEngineReq {

    /* renamed from: a */
    private static final String f52315a = XEngineReq.class.getSimpleName();

    /* renamed from: b */
    private static final String f52316b = "eevee";

    /* renamed from: c */
    private static final XEngineReqUtil f52317c = new XEngineReqUtil("eevee");

    public static void pageRequest(String str) {
        f52317c.pageRequest(str);
        SystemUtils.log(3, f52315a, "pageRequest: ", new Exception(), "com.didiglobal.common.common.xengine.XEngineReq", 29);
    }

    public static void pageRequest(String str, Boolean bool) {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.scene = str;
        xEBizParamsImpl.requestCache = bool;
        f52317c.pageRequest(xEBizParamsImpl);
    }

    public static void pageRequest(XEBizParamsImpl xEBizParamsImpl) {
        f52317c.pageRequest(xEBizParamsImpl);
    }

    public static void simpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        f52317c.simpleRequest(xEBizParamsImpl);
    }

    public static void simpleRequest(String str, String... strArr) {
        f52317c.simpleRequest(str, strArr);
    }

    public static void engineCommit(XECommitBizParams xECommitBizParams) {
        f52317c.engineCommit(xECommitBizParams);
    }

    public static void engineDispatch(XEDispatchBizParams xEDispatchBizParams) {
        f52317c.engineDispatch(xEDispatchBizParams);
    }

    public static void setDefaultCache(XECacheParamsImpl xECacheParamsImpl) {
        f52317c.setCache(xECacheParamsImpl, true);
    }

    public static void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
        f52317c.setCache(xECacheParamsImpl, bool);
    }
}
