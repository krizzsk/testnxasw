package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\b\n\u0000\n\u0002\u0018\u0002\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", "Lcom/didi/global/fintech/cashier/model/net/request/GetCVVInfoRequest;", "it"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierNetPresenter.kt */
final class GlobalCashierNetPresenter$getCvvInfo$1 extends Lambda implements Function1<GetCVVInfoRequest, GetCVVInfoRequest> {
    final /* synthetic */ GlobalCashierNetPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierNetPresenter$getCvvInfo$1(GlobalCashierNetPresenter globalCashierNetPresenter) {
        super(1);
        this.this$0 = globalCashierNetPresenter;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x000e, code lost:
        r0 = (com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest) r0.process(r3);
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest invoke(com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest r3) {
        /*
            r2 = this;
            java.lang.String r0 = "it"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r3, r0)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierNetPresenter r0 = r2.this$0
            com.didi.global.fintech.cashier.network.processor.GlobalCommonParamsProcessor r0 = r0.getParamsProcessor()
            if (r0 != 0) goto L_0x000e
            goto L_0x001b
        L_0x000e:
            r1 = r3
            com.didi.global.fintech.cashier.model.net.request.CashierRequestCommonParams r1 = (com.didi.global.fintech.cashier.model.net.request.CashierRequestCommonParams) r1
            com.didi.global.fintech.cashier.model.net.request.CashierRequestCommonParams r0 = r0.process(r1)
            com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest r0 = (com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest) r0
            if (r0 != 0) goto L_0x001a
            goto L_0x001b
        L_0x001a:
            r3 = r0
        L_0x001b:
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierNetPresenter$getCvvInfo$1.invoke(com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest):com.didi.global.fintech.cashier.model.net.request.GetCVVInfoRequest");
    }
}
