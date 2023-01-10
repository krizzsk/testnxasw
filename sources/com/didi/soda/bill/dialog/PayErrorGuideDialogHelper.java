package com.didi.soda.bill.dialog;

import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0006\u0010\u000e\u001a\u00020\u000fJ<\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\u0010\u0010\u0015\u001a\f\u0012\u0004\u0012\u00020\u000f0\u0016j\u0002`\u00172\u0010\u0010\u0018\u001a\f\u0012\u0004\u0012\u00020\u000f0\u0016j\u0002`\u0019R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u001c\u0010\u000b\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u0006\"\u0004\b\r\u0010\b¨\u0006\u001a"}, mo148868d2 = {"Lcom/didi/soda/bill/dialog/PayErrorGuideDialogHelper;", "", "()V", "cartId", "", "getCartId", "()Ljava/lang/String;", "setCartId", "(Ljava/lang/String;)V", "payFailGuideFloatingView", "Lcom/didi/soda/bill/dialog/PayFailGuideFloatingView;", "shopId", "getShopId", "setShopId", "hidePayFailGuideView", "", "showPayFailGuideView", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "alert", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/AlertEntity;", "recommendPayCallback", "Lkotlin/Function0;", "Lcom/didi/soda/bill/dialog/RecommendPayCallback;", "otherPayCallback", "Lcom/didi/soda/bill/dialog/OtherPayCallback;", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: PayErrorGuideDialogHelper.kt */
public final class PayErrorGuideDialogHelper {

    /* renamed from: a */
    private String f41703a;

    /* renamed from: b */
    private String f41704b;

    /* renamed from: c */
    private PayFailGuideFloatingView f41705c;

    public final String getCartId() {
        return this.f41703a;
    }

    public final void setCartId(String str) {
        this.f41703a = str;
    }

    public final String getShopId() {
        return this.f41704b;
    }

    public final void setShopId(String str) {
        this.f41704b = str;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:5:0x003f, code lost:
        r2 = r2.payChannel;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void showPayFailGuideView(com.didi.app.nova.skeleton.ScopeContext r4, com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity r5, kotlin.jvm.functions.Function0<kotlin.Unit> r6, kotlin.jvm.functions.Function0<kotlin.Unit> r7) {
        /*
            r3 = this;
            java.lang.String r0 = "scopeContext"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r4, r0)
            java.lang.String r0 = "recommendPayCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.lang.String r0 = "otherPayCallback"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r7, r0)
            if (r5 != 0) goto L_0x0014
            goto L_0x005e
        L_0x0014:
            r3.hidePayFailGuideView()
            r0 = 0
            r3.f41705c = r0
            com.didi.soda.bill.dialog.PayFailGuideFloatingView r1 = new com.didi.soda.bill.dialog.PayFailGuideFloatingView
            r1.<init>()
            com.didi.soda.bill.dialog.PayFailGuideFloatingView r6 = r1.setRecommendCallback(r6)
            com.didi.soda.bill.dialog.PayFailGuideFloatingView r6 = r6.setOtherPayCallback(r7)
            com.didi.soda.bill.dialog.PayFailGuideFloatingView r6 = r6.setAlertEntity(r5)
            r3.f41705c = r6
            com.didi.soda.bill.BillOmegaHelper$Companion r6 = com.didi.soda.bill.BillOmegaHelper.Companion
            java.lang.String r7 = r3.getCartId()
            java.lang.String r1 = r3.getShopId()
            com.didi.soda.customer.foundation.rpc.entity.bill.AlertExtraEntity r2 = r5.getExtra()
            if (r2 != 0) goto L_0x003f
        L_0x003d:
            r2 = r0
            goto L_0x004a
        L_0x003f:
            com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity r2 = r2.payChannel
            if (r2 != 0) goto L_0x0044
            goto L_0x003d
        L_0x0044:
            int r2 = r2.channelId
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
        L_0x004a:
            com.didi.soda.customer.foundation.rpc.entity.bill.AlertExtraEntity r5 = r5.getExtra()
            if (r5 != 0) goto L_0x0051
            goto L_0x0053
        L_0x0051:
            java.lang.String r0 = r5.payChannelRecommendList
        L_0x0053:
            r6.tracePayErrorGuideDialogSW(r7, r1, r2, r0)
            com.didi.soda.bill.dialog.PayFailGuideFloatingView r5 = r3.f41705c
            if (r5 != 0) goto L_0x005b
            goto L_0x005e
        L_0x005b:
            r5.show(r4)
        L_0x005e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.bill.dialog.PayErrorGuideDialogHelper.showPayFailGuideView(com.didi.app.nova.skeleton.ScopeContext, com.didi.soda.customer.foundation.rpc.entity.bill.AlertEntity, kotlin.jvm.functions.Function0, kotlin.jvm.functions.Function0):void");
    }

    public final void hidePayFailGuideView() {
        PayFailGuideFloatingView payFailGuideFloatingView = this.f41705c;
        if (payFailGuideFloatingView != null) {
            payFailGuideFloatingView.dismiss();
        }
    }
}
