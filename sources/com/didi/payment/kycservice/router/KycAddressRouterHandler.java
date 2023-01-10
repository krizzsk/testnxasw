package com.didi.payment.kycservice.router;

import android.os.Bundle;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.kycservice.constant.KycConstants;
import com.didi.payment.kycservice.kyc.SignUpPageScene;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didi/payment/kycservice/router/KycAddressRouterHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "kyc-service_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: KycAddressRouterHandler.kt */
public final class KycAddressRouterHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        String queryParameter = request.getUri().getQueryParameter("typeId");
        String queryParameter2 = request.getUri().getQueryParameter("blockId");
        Bundle bundle = new Bundle();
        bundle.putString("scene", SignUpPageScene.FULL_KYC_EXTRA.getSceneTag());
        if (queryParameter == null) {
            queryParameter = "1";
        }
        bundle.putString("typeId", queryParameter);
        bundle.putString("blockId", queryParameter2);
        ((Request) DRouter.build(KycConstants.Router.KYC_REGISTER_ROUTER).putExtras(bundle)).start(request.getContext());
    }
}
