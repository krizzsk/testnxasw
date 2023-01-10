package com.didi.app.router.sidebar;

import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.BusinessContextManager;
import com.didi.sdk.sidebar.templet.ManualLinker;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didi/app/router/sidebar/OnePrivacyDRouterHandler;", "Lcom/didi/app/router/sidebar/BaseSideBarDRouterHandler;", "()V", "callRealHandle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "TheOneSDKGlobal_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OnePrivacyDRouterHandler.kt */
public final class OnePrivacyDRouterHandler extends BaseSideBarDRouterHandler {
    public void callRealHandle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        ManualLinker manualLinker = new ManualLinker();
        BaseBusinessContext curBusinessContext = BusinessContextManager.getInstance().getCurBusinessContext();
        if (curBusinessContext != null) {
            manualLinker.toPrivacy(curBusinessContext);
        }
    }
}
