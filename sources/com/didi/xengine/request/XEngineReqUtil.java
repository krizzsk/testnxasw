package com.didi.xengine.request;

import com.didi.xengine.config.EngineInitInstance;

public class XEngineReqUtil {

    /* renamed from: a */
    private final String f47857a;

    public XEngineReqUtil(String str) {
        this.f47857a = str;
    }

    public void pageRequest(String str) {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.scene = str;
        pageRequest(xEBizParamsImpl);
    }

    public void pageRequest(XEBizParamsImpl xEBizParamsImpl) {
        if (EngineInitInstance.getInstance().getConfig(this.f47857a) != null && EngineInitInstance.getInstance().getConfig(this.f47857a).getMethod() != null) {
            EngineInitInstance.getInstance().getConfig(this.f47857a).getMethod().pageRequest(xEBizParamsImpl);
        }
    }

    public void simpleRequest(XEBizParamsImpl xEBizParamsImpl) {
        if (EngineInitInstance.getInstance().getConfig(this.f47857a) != null && EngineInitInstance.getInstance().getConfig(this.f47857a).getMethod() != null) {
            EngineInitInstance.getInstance().getConfig(this.f47857a).getMethod().simpleRequest(xEBizParamsImpl);
        }
    }

    public void simpleRequest(String str, String... strArr) {
        XEBizParamsImpl xEBizParamsImpl = new XEBizParamsImpl();
        xEBizParamsImpl.requestKeys = strArr;
        xEBizParamsImpl.scene = str;
        simpleRequest(xEBizParamsImpl);
    }

    public void engineCommit(XECommitBizParams xECommitBizParams) {
        if (EngineInitInstance.getInstance().getConfig(this.f47857a) != null && EngineInitInstance.getInstance().getConfig(this.f47857a).getMethod() != null) {
            EngineInitInstance.getInstance().getConfig(this.f47857a).getMethod().engineCommit(xECommitBizParams);
        }
    }

    public void engineDispatch(XEDispatchBizParams xEDispatchBizParams) {
        if (EngineInitInstance.getInstance().getConfig(this.f47857a) != null && EngineInitInstance.getInstance().getConfig(this.f47857a).getMethod() != null) {
            EngineInitInstance.getInstance().getConfig(this.f47857a).getMethod().engineDispatch(xEDispatchBizParams);
        }
    }

    public void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
        if (EngineInitInstance.getInstance().getConfig(this.f47857a) != null && EngineInitInstance.getInstance().getConfig(this.f47857a).getMethod() != null) {
            EngineInitInstance.getInstance().getConfig(this.f47857a).getMethod().setCache(xECacheParamsImpl, bool);
        }
    }
}
