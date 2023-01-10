package com.didi.global.fintech.cashier.core.presenter;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;

@Metadata(mo148867d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo148868d2 = {"<anonymous>", ""}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GlobalCashierPayPresenter.kt */
final class GlobalCashierPayPresenter$doPay$3 extends Lambda implements Function0<Unit> {
    final /* synthetic */ GlobalCashierPayPresenter this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    GlobalCashierPayPresenter$doPay$3(GlobalCashierPayPresenter globalCashierPayPresenter) {
        super(0);
        this.this$0 = globalCashierPayPresenter;
    }

    /* JADX WARNING: Removed duplicated region for block: B:22:0x007a  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0094  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void invoke() {
        /*
            r17 = this;
            r0 = r17
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r1 = r0.this$0
            java.lang.Class<com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor> r2 = com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor.class
            com.didi.global.fintech.cashier.core.api.ICashierBaseProcessor r1 = r1.getProcessor(r2)
            r2 = r1
            com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor r2 = (com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor) r2
            if (r2 != 0) goto L_0x0010
            goto L_0x0018
        L_0x0010:
            r3 = 0
            r4 = 0
            r6 = 2
            r7 = 0
            com.didi.global.fintech.cashier.core.api.ICashierOperateProcessor.DefaultImpls.loading$default(r2, r3, r4, r6, r7)
        L_0x0018:
            java.util.ArrayList r1 = new java.util.ArrayList
            r1.<init>()
            java.util.List r1 = (java.util.List) r1
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r2 = r0.this$0
            java.util.List r2 = r2.getMSelectPayments()
            java.lang.Iterable r2 = (java.lang.Iterable) r2
            java.util.Iterator r2 = r2.iterator()
        L_0x002b:
            boolean r3 = r2.hasNext()
            r4 = 0
            if (r3 == 0) goto L_0x00a1
            java.lang.Object r3 = r2.next()
            com.didi.global.fintech.cashier.model.net.response.Payment r3 = (com.didi.global.fintech.cashier.model.net.response.Payment) r3
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo r5 = r3.getInstallment()
            if (r5 != 0) goto L_0x0040
        L_0x003e:
            r5 = r4
            goto L_0x0074
        L_0x0040:
            java.util.List r5 = r5.getSuggestPlans()
            if (r5 != 0) goto L_0x0047
            goto L_0x003e
        L_0x0047:
            java.lang.Iterable r5 = (java.lang.Iterable) r5
            java.util.Iterator r5 = r5.iterator()
        L_0x004d:
            boolean r6 = r5.hasNext()
            if (r6 == 0) goto L_0x006a
            java.lang.Object r6 = r5.next()
            r7 = r6
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r7 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r7
            java.lang.Boolean r7 = r7.getSelected()
            r8 = 1
            java.lang.Boolean r8 = java.lang.Boolean.valueOf(r8)
            boolean r7 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r7, (java.lang.Object) r8)
            if (r7 == 0) goto L_0x004d
            goto L_0x006b
        L_0x006a:
            r6 = r4
        L_0x006b:
            com.didi.global.fintech.cashier.model.net.response.Payment$InstallmentVo$PlansVo r6 = (com.didi.global.fintech.cashier.model.net.response.Payment.InstallmentVo.PlansVo) r6
            if (r6 != 0) goto L_0x0070
            goto L_0x003e
        L_0x0070:
            java.lang.Integer r5 = r6.getNumber()
        L_0x0074:
            java.lang.Integer r6 = r3.getChannelId()
            if (r5 == 0) goto L_0x0094
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r7 = new com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo
            r8 = 3
            r7.<init>(r4, r4, r8, r4)
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r3 = r3.getExtraInfo()
            if (r3 != 0) goto L_0x0087
            goto L_0x008b
        L_0x0087:
            java.lang.String r4 = r3.getCardIndex()
        L_0x008b:
            r7.setCardIndex(r4)
            r7.setInstallmentNumber(r5)
            kotlin.Unit r3 = kotlin.Unit.INSTANCE
            goto L_0x0098
        L_0x0094:
            com.didi.global.fintech.cashier.model.net.response.Payment$ExtraInfo r7 = r3.getExtraInfo()
        L_0x0098:
            com.didi.global.fintech.cashier.model.net.response.BasicPayment r3 = new com.didi.global.fintech.cashier.model.net.response.BasicPayment
            r3.<init>(r6, r7)
            r1.add(r3)
            goto L_0x002b
        L_0x00a1:
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r2 = r0.this$0
            java.util.List r2 = r2.getMExtraPayments()
            java.util.Collection r2 = (java.util.Collection) r2
            r1.addAll(r2)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r2 = r0.this$0
            com.didi.global.fintech.cashier.model.net.request.PrepayRequest r3 = new com.didi.global.fintech.cashier.model.net.request.PrepayRequest
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 0
            r11 = 0
            r12 = 0
            r13 = 0
            r14 = 0
            r15 = 511(0x1ff, float:7.16E-43)
            r16 = 0
            r5 = r3
            r5.<init>(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r5 = r0.this$0
            java.lang.String r6 = r5.getMOutTradeId()
            if (r6 != 0) goto L_0x00cb
            java.lang.String r6 = ""
        L_0x00cb:
            r3.setOut_trade_id(r6)
            java.lang.String r6 = r5.getMPasswordToken()
            if (r6 != 0) goto L_0x00d5
            goto L_0x00d8
        L_0x00d5:
            r3.setPassword_token(r6)
        L_0x00d8:
            java.lang.Boolean r6 = r5.getMBoletoConfirm()
            if (r6 != 0) goto L_0x00df
            goto L_0x00ea
        L_0x00df:
            boolean r6 = r6.booleanValue()
            java.lang.Boolean r6 = java.lang.Boolean.valueOf(r6)
            r3.setPay_tip_confirmed(r6)
        L_0x00ea:
            java.lang.String r6 = "merchant_wsgenv"
            java.lang.Object r6 = r5.getParamByName(r6)
            java.lang.String r6 = (java.lang.String) r6
            r3.setMerchant_wsgenv(r6)
            java.util.List r6 = r3.getUser_select()
            java.util.Collection r1 = (java.util.Collection) r1
            r6.addAll(r1)
            com.didi.global.fintech.cashier.model.net.request.PrepayRequest$ThirdParty r1 = r3.getThird_party()
            com.didi.global.fintech.cashier.model.net.request.PrepayRequest$ThreeDSV2 r6 = r5.getMThreeDSV2()
            r1.setThree_ds_v2(r6)
            java.lang.String r1 = r5.getMCvv()
            r3.setCvv(r1)
            com.didi.global.fintech.cashier.user.model.CashierParam r1 = r5.getMCashierParam()
            if (r1 != 0) goto L_0x0118
            r1 = r4
            goto L_0x011c
        L_0x0118:
            java.lang.String r1 = r1.getBizDeviceInfo()
        L_0x011c:
            r3.setBiz_device_info(r1)
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            r2.prePay(r3)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r1 = r0.this$0
            r1.setMCvv(r4)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r1 = r0.this$0
            r1.setMPasswordToken(r4)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r1 = r0.this$0
            r1.setMThreeDSV2(r4)
            com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter r1 = r0.this$0
            r1.setMBoletoConfirm(r4)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.core.presenter.GlobalCashierPayPresenter$doPay$3.invoke():void");
    }
}
