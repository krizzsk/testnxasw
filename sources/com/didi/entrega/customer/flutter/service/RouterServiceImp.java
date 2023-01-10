package com.didi.entrega.customer.flutter.service;

import com.didi.drouter.api.DRouter;
import com.didi.entrega.uni_entrega_business.router.GLEUniRouterService;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0016¨\u0006\u0007"}, mo148868d2 = {"Lcom/didi/entrega/customer/flutter/service/RouterServiceImp;", "Lcom/didi/entrega/uni_entrega_business/router/GLEUniRouterService;", "()V", "openDIDIRouterPage", "", "url", "", "entrega-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: RouterServiceImp.kt */
public final class RouterServiceImp implements GLEUniRouterService {
    public void openDIDIRouterPage(String str) {
        if (str != null) {
            DRouter.build(str).start();
        }
    }
}
