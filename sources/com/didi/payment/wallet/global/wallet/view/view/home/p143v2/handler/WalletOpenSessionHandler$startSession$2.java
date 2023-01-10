package com.didi.payment.wallet.global.wallet.view.view.home.p143v2.handler;

import com.didi.drouter.router.Request;
import com.didi.drouter.router.Result;
import com.didi.drouter.router.RouterHelper;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.wallet.global.prepaidcard.resp.OpenSessionResp;
import com.didi.payment.wallet.global.riskcontrol.IRiskControlCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import org.greenrobot.eventbus.EventBus;

@Metadata(mo148867d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo148868d2 = {"com/didi/payment/wallet/global/wallet/view/view/home/v2/handler/WalletOpenSessionHandler$startSession$2", "Lcom/didi/payment/wallet/global/riskcontrol/IRiskControlCallback;", "onResult", "", "res", "", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.handler.WalletOpenSessionHandler$startSession$2 */
/* compiled from: WalletOpenSessionHandler.kt */
public final class WalletOpenSessionHandler$startSession$2 implements IRiskControlCallback {
    final /* synthetic */ Function1<String, Unit> $callback;
    final /* synthetic */ Request $request;
    final /* synthetic */ OpenSessionResp $resp;
    final /* synthetic */ Result $result;

    WalletOpenSessionHandler$startSession$2(Function1<? super String, Unit> function1, OpenSessionResp openSessionResp, Result result, Request request) {
        this.$callback = function1;
        this.$resp = openSessionResp;
        this.$result = result;
        this.$request = request;
    }

    public void onResult(int i) {
        if (i == 1) {
            Function1<String, Unit> function1 = this.$callback;
            OpenSessionResp.Data data = this.$resp.getData();
            function1.invoke(data == null ? null : data.getStatus());
            EventBus.getDefault().post(new WalletRefreshDataEvent());
        } else if (i == 3) {
            this.$result.putExtra("result", i);
            RouterHelper.release(this.$request);
        }
    }
}
