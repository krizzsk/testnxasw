package com.didi.global.fintech.cashier.fastpay.presenter;

import com.didi.global.fintech.cashier.fastpay.contract.IFastPayNetPresenter;
import com.didi.global.fintech.cashier.model.net.response.fastpay.FastPayInfoResponse;
import com.didi.global.fintech.cashier.network.callback.CashierNetCallback;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/network/callback/CashierNetCallback;", "Lcom/didi/global/fintech/cashier/model/net/response/fastpay/FastPayInfoResponse;"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FastPayNetPresenter.kt */
final class FastPayNetPresenter$fastPayInfoCallback$2 extends Lambda implements Function0<CashierNetCallback<FastPayInfoResponse>> {
    final /* synthetic */ FastPayNetPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    FastPayNetPresenter$fastPayInfoCallback$2(FastPayNetPresenter fastPayNetPresenter) {
        super(0);
        this.this$0 = fastPayNetPresenter;
    }

    public final CashierNetCallback<FastPayInfoResponse> invoke() {
        FastPayNetPresenter fastPayNetPresenter = this.this$0;
        return fastPayNetPresenter.m19197a(new Function1<FastPayInfoResponse, Unit>(fastPayNetPresenter) {
            public /* bridge */ /* synthetic */ Object invoke(Object obj) {
                invoke((FastPayInfoResponse) obj);
                return Unit.INSTANCE;
            }

            public final void invoke(FastPayInfoResponse fastPayInfoResponse) {
                Intrinsics.checkNotNullParameter(fastPayInfoResponse, "p0");
                ((FastPayNetPresenter) this.receiver).onFastPayInfoResponse(fastPayInfoResponse);
            }
        }, IFastPayNetPresenter.API.GET_FAST_PAY_INFO);
    }
}
