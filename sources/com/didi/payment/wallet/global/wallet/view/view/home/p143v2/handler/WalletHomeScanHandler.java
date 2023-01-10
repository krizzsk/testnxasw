package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.handler;

import android.content.Context;
import com.didi.drouter.router.IRouterHandler;
import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.payment.wallet.global.wallet.view.view.home.p143v2.tool.WalletHomeController;
import com.didiglobal.scan.GlobalScan;
import com.didiglobal.scan.data.ManualInputInfoItem;
import com.didiglobal.scan.delegate.ScanSchemeDispatcherDelegate;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\t"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/handler/WalletHomeScanHandler;", "Lcom/didi/drouter/router/IRouterHandler;", "()V", "handle", "", "request", "Lcom/didi/drouter/router/Request;", "result", "Lcom/didi/drouter/router/Result;", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletHomeScanHandler */
/* compiled from: WalletHomeScanHandler.kt */
public final class WalletHomeScanHandler implements IRouterHandler {
    public void handle(Request request, Result result) {
        Intrinsics.checkNotNullParameter(request, "request");
        Intrinsics.checkNotNullParameter(result, "result");
        List arrayList = new ArrayList();
        ManualInputInfoItem manualInputInfoItem = new ManualInputInfoItem();
        manualInputInfoItem.setActionType(ScanSchemeDispatcherDelegate.ActionType.PIX.getType());
        WalletHomeController.Companion companion = WalletHomeController.Companion;
        Context context = request.getContext();
        Intrinsics.checkNotNullExpressionValue(context, "request.context");
        companion.executeForTerminalId(context, new WalletHomeScanHandler$handle$1(manualInputInfoItem), new WalletHomeScanHandler$handle$2(manualInputInfoItem));
        manualInputInfoItem.setScheme(request.getInt("kycStatus") == 6 ? "GuaranaOneTravel://one/pix_scan_manual" : "99pay://one/pix_register?source=2");
        arrayList.add(manualInputInfoItem);
        GlobalScan globalScan = GlobalScan.INSTANCE;
        GlobalScan.ScanFrom scanFrom = GlobalScan.ScanFrom.WALLET;
        Context context2 = request.getContext();
        Intrinsics.checkNotNullExpressionValue(context2, "request.context");
        globalScan.start(scanFrom, context2, 0, arrayList);
    }
}
