package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.handler;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.global.wallet.view.activity.WalletMainListActivity;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.WalletSideBarActivity;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeController;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/handler/WalletSideBarHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletSideBarHandler */
/* compiled from: WalletSideBarHandler.kt */
public final class WalletSideBarHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        Context context = request.getContext();
        Activity activity = context instanceof Activity ? (Activity) context : null;
        Intent intent = new Intent();
        if (activity != null) {
            Context context2 = activity;
            if (WalletHomeController.Companion.getWalletHomeVersion(context2, 1) == 2) {
                intent.setClass(context2, new WalletSideBarActivity().getClass());
                intent.putExtra("ext", request.getString("ext"));
                activity.startActivity(intent);
                return;
            }
            intent.setClass(context2, WalletMainListActivity.class);
            activity.startActivity(intent);
            return;
        }
        intent.addFlags(268435456);
        WalletHomeController.Companion companion = WalletHomeController.Companion;
        Context context3 = request.getContext();
        Intrinsics.checkNotNullExpressionValue(context3, "request.context");
        if (companion.getWalletHomeVersion(context3, 1) == 2) {
            intent.setClass(request.getContext(), new WalletSideBarActivity().getClass());
            intent.putExtra("ext", request.getString("ext"));
            request.getContext().startActivity(intent);
            return;
        }
        intent.setClass(request.getContext(), WalletMainListActivity.class);
        request.getContext().startActivity(intent);
    }
}
