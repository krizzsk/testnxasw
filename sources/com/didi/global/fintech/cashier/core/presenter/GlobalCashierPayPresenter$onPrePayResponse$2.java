package com.didi.global.fintech.cashier.core.presenter;

import com.didi.global.fintech.cashier.core.api.ICashier3DSProcessor;
import com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor;
import com.didi.global.fintech.cashier.core.contract.IGlobalCashierActionInterceptCallback;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;
import com.didi.global.fintech.cashier.model.net.response.GlobalCashierAdyen3DSModel;
import com.didi.global.fintech.cashier.model.net.response.PrepayResponse;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPayPresenter.kt */
final class GlobalCashierPayPresenter$onPrePayResponse$2 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PrepayResponse $response;
    final /* synthetic */ GlobalCashierPayPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPayPresenter$onPrePayResponse$2(GlobalCashierPayPresenter globalCashierPayPresenter, PrepayResponse prepayResponse) {
        super(0);
        this.this$0 = globalCashierPayPresenter;
        this.$response = prepayResponse;
    }

    public final void invoke() {
        ICashierOperateProcessor iCashierOperateProcessor;
        IGlobalCashierActionInterceptCallback actionInterceptHandler = this.this$0.getActionInterceptHandler();
        GlobalCashierAdyen3DSModel globalCashierAdyen3DSModel = null;
        if (actionInterceptHandler != null) {
            CashierAction nextStep = this.$response.getNextStep();
            actionInterceptHandler.onActionInterceptJumpThirdPage(nextStep == null ? null : nextStep.getAction());
        }
        GlobalCashierPayPresenter globalCashierPayPresenter = this.this$0;
        CashierAction nextStep2 = this.$response.getNextStep();
        boolean z = true;
        if (!(nextStep2 != null && !nextStep2.showLoadingView())) {
            globalCashierPayPresenter = null;
        }
        if (!(globalCashierPayPresenter == null || (iCashierOperateProcessor = (ICashierOperateProcessor) globalCashierPayPresenter.getProcessor(ICashierOperateProcessor.class)) == null)) {
            iCashierOperateProcessor.dismissLoading();
        }
        GlobalCashierPayPresenter globalCashierPayPresenter2 = this.this$0;
        CashierAction nextStep3 = this.$response.getNextStep();
        if (nextStep3 == null || !nextStep3.threeDS()) {
            z = false;
        }
        if (!z) {
            globalCashierPayPresenter2 = null;
        }
        if (globalCashierPayPresenter2 != null) {
            PrepayResponse prepayResponse = this.$response;
            ICashier3DSProcessor iCashier3DSProcessor = (ICashier3DSProcessor) globalCashierPayPresenter2.getProcessor(ICashier3DSProcessor.class);
            if (iCashier3DSProcessor != null) {
                CashierAction nextStep4 = prepayResponse.getNextStep();
                if (nextStep4 != null) {
                    globalCashierAdyen3DSModel = nextStep4.threeDSData();
                }
                iCashier3DSProcessor.adyenActionHandle(globalCashierAdyen3DSModel);
            }
        }
    }
}
