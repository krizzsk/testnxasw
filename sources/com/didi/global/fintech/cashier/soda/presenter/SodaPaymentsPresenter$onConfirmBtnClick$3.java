package com.didi.global.fintech.cashier.soda.presenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SodaPaymentsPresenter.kt */
final class SodaPaymentsPresenter$onConfirmBtnClick$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ SodaPaymentsPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    SodaPaymentsPresenter$onConfirmBtnClick$3(SodaPaymentsPresenter sodaPaymentsPresenter) {
        super(0);
        this.this$0 = sodaPaymentsPresenter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x0078  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0092  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r9 = this;
            com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter r0 = r9.this$0
            java.lang.Class<com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor> r1 = com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor.class
            com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor r0 = r0.getProcessor(r1)
            r1 = r0
            com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor r1 = (com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor) r1
            if (r1 != 0) goto L_0x000e
            goto L_0x0016
        L_0x000e:
            r2 = 0
            r3 = 0
            r5 = 2
            r6 = 0
            com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor.DefaultImpls.loading$default(r1, r2, r3, r5, r6)
        L_0x0016:
            java.util.ArrayList r0 = new java.util.ArrayList
            r0.<init>()
            java.util.List r0 = (java.util.List) r0
            com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter r1 = r9.this$0
            java.util.List r1 = r1.getMSelectPayments()
            java.lang.Iterable r1 = (java.lang.Iterable) r1
            java.util.Iterator r1 = r1.iterator()
        L_0x0029:
            boolean r2 = r1.hasNext()
            r3 = 1
            r4 = 0
            if (r2 == 0) goto L_0x009f
            java.lang.Object r2 = r1.next()
            com.didi.global.fintech.cashier.model.net.response.Payment r2 = (com.didi.global.fintech.cashier.model.net.response.Payment) r2
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo r5 = r2.getInstallment()
            if (r5 != 0) goto L_0x003f
        L_0x003d:
            r3 = r4
            goto L_0x0072
        L_0x003f:
            java.util.List r5 = r5.getSuggestPlans()
            if (r5 != 0) goto L_0x0046
            goto L_0x003d
        L_0x0046:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x004c:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x0068
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r7 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r7
            java.lang.Boolean r7 = r7.getSelected()
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r3)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x004c
            goto L_0x0069
        L_0x0068:
            r6 = r4
        L_0x0069:
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r6 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r6
            if (r6 != 0) goto L_0x006e
            goto L_0x003d
        L_0x006e:
            java.lang.Integer r3 = r6.getNumber()
        L_0x0072:
            java.lang.Integer r5 = r2.getChannelId()
            if (r3 == 0) goto L_0x0092
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r6 = new com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo
            r7 = 3
            r6.<init>(r4, r4, r7, r4)
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r2 = r2.getExtraInfo()
            if (r2 != 0) goto L_0x0085
            goto L_0x0089
        L_0x0085:
            java.lang.String r4 = r2.getCardIndex()
        L_0x0089:
            r6.setCardIndex(r4)
            r6.setInstallmentNumber(r3)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x0096
        L_0x0092:
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r6 = r2.getExtraInfo()
        L_0x0096:
            com.didi.global.fintech.cashier.model.net.response.BasicPayment r2 = new com.didi.global.fintech.cashier.model.net.response.BasicPayment
            r2.<init>(r5, r6)
            r0.add(r2)
            goto L_0x0029
        L_0x009f:
            com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter r1 = r9.this$0
            java.util.List r1 = r1.getMExtraPayments()
            java.util.Collection r1 = (java.util.Collection) r1
            r0.addAll(r1)
            com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter r1 = r9.this$0
            r1.m19223a(r3, r0)
            com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter r0 = r9.this$0
            r0.setMCvv(r4)
            com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter r0 = r9.this$0
            r0.setMPasswordToken(r4)
            com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter r0 = r9.this$0
            r0.setMThreeDSV2(r4)
            com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter r0 = r9.this$0
            r0.setMBoletoConfirm(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.soda.presenter.SodaPaymentsPresenter$onConfirmBtnClick$3.invoke():void");
    }
}
