package com.didiglobal.p205sa.biz.component.xengine;

import com.didi.component.never.core.ComponentParams;
import com.didi.xengine.XEngine;
import com.didi.xengine.request.XECacheParamsImpl;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0005\u001a\u00020\u0006H\u0016J!\u0010\u0007\u001a\u00020\b2\b\u0010\u0002\u001a\u0004\u0018\u00010\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016¢\u0006\u0002\u0010\f¨\u0006\r"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/component/xengine/SAXEnginePresenter;", "Lcom/didiglobal/sa/biz/component/xengine/AbsSAXEnginePresenter;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "getScene", "", "setCache", "", "Lcom/didi/xengine/request/XECacheParamsImpl;", "isDefault", "", "(Lcom/didi/xengine/request/XECacheParamsImpl;Ljava/lang/Boolean;)V", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.xengine.SAXEnginePresenter */
/* compiled from: SAXEnginePresenter.kt */
public final class SAXEnginePresenter extends AbsSAXEnginePresenter {
    public String getScene() {
        return "sa_home";
    }

    public SAXEnginePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void setCache(XECacheParamsImpl xECacheParamsImpl, Boolean bool) {
        XEngine engine;
        if (xECacheParamsImpl != null && (engine = getEngine()) != null) {
            engine.setCache(xECacheParamsImpl, bool);
        }
    }
}
