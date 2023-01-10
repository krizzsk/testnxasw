package com.didiglobal.p205sa.biz.tab.router;

import android.content.Intent;
import android.net.Uri;
import android.view.View;
import com.didi.app.router.PageRouter;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.sdk.app.ActivityLifecycleManager;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.app.SuperAppBusinessManager;
import com.didi.sdk.app.business.SaTabIds;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.SaApolloUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\b\u0010\u0007\u001a\u00020\bH\u0002J\u0018\u0010\t\u001a\u00020\b2\u0006\u0010\n\u001a\u00020\u00042\u0006\u0010\u000b\u001a\u00020\u0004H\u0002J\u0018\u0010\f\u001a\u00020\b2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010H\u0016¨\u0006\u0011"}, mo148868d2 = {"Lcom/didiglobal/sa/biz/tab/router/SaBackHomeRouter;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "checkParamsTabIdIsLegal", "", "tabId", "", "clearTop", "", "doReturnHomeAction", "needClearTop", "needPopBack", "handle", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "biz-library_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didiglobal.sa.biz.tab.router.SaBackHomeRouter */
/* compiled from: SaBackHomeRouter.kt */
public final class SaBackHomeRouter implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        if (SaApolloUtil.INSTANCE.getSaState()) {
            boolean isMainActivityOnTop = ActivityLifecycleManager.getInstance().isMainActivityOnTop();
            if (SaApolloUtil.INSTANCE.getSaOneState()) {
                Uri uri = request.getUri();
                Intrinsics.checkNotNullExpressionValue(uri, "request.uri");
                String queryParameter = uri.getQueryParameter(ParamConst.PARAM_TAB_ID);
                if (queryParameter == null) {
                    queryParameter = null;
                }
                if (m40129a(queryParameter)) {
                    int queryParameter2 = uri.getQueryParameter("force_close");
                    if (queryParameter2 == null) {
                        queryParameter2 = 0;
                    }
                    boolean saTabShow = SuperAppBusinessManager.INSTANCE.getSaTabShow();
                    String str = NationTypeUtil.getNationComponentData().getProductPreFix() + "OneTravel://one/switch_tab?tab_id=" + queryParameter;
                    if (!Intrinsics.areEqual(queryParameter2, (Object) 0)) {
                        m40128a(!isMainActivityOnTop, !saTabShow);
                        UiThreadHandler.getsUiHandler().post(new Runnable(str) {
                            public final /* synthetic */ String f$0;

                            {
                                this.f$0 = r1;
                            }

                            public final void run() {
                                SaBackHomeRouter.m40130b(this.f$0);
                            }
                        });
                    } else if (isMainActivityOnTop && saTabShow) {
                        DRouter.build(str).start();
                    }
                }
            } else {
                m40128a(!isMainActivityOnTop, !SuperAppBusinessManager.INSTANCE.isSaRealShow());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m40130b(String str) {
        Intrinsics.checkNotNullParameter(str, "$switchUrl");
        DRouter.build(str).start();
    }

    /* renamed from: a */
    private final void m40128a(boolean z, boolean z2) {
        BusinessContext commonBusinessContext;
        INavigation navigation;
        if (z) {
            m40127a();
        }
        if (z2 && (commonBusinessContext = SuperAppBusinessManager.INSTANCE.getCommonBusinessContext()) != null && (navigation = commonBusinessContext.getNavigation()) != null) {
            navigation.popBackStack(2);
        }
    }

    /* renamed from: a */
    private final void m40127a() {
        Intent intent = new Intent();
        intent.addFlags(View.STATUS_BAR_TRANSIENT);
        PageRouter.getInstance().startMainActivity(DIDIApplication.getAppContext(), intent);
    }

    /* renamed from: a */
    private final boolean m40129a(String str) {
        SaTabIds saTabIds;
        if (str == null) {
            return false;
        }
        SaTabIds[] values = SaTabIds.values();
        int length = values.length;
        int i = 0;
        while (true) {
            if (i >= length) {
                saTabIds = null;
                break;
            }
            saTabIds = values[i];
            i++;
            if (Intrinsics.areEqual((Object) str, (Object) saTabIds.getId())) {
                break;
            }
        }
        if (saTabIds != null) {
            return true;
        }
        return false;
    }
}
