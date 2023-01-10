package com.didi.soda.goodsV2.page;

import com.didi.soda.router.IInterceptor;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\n"}, mo148868d2 = {"Lcom/didi/soda/goodsV2/page/GoodsPurchasePageInterceptor;", "Lcom/didi/soda/router/IInterceptor;", "()V", "intercept", "", "request", "Lcom/didi/soda/router/Request;", "response", "Lcom/didi/soda/router/Response;", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: GoodsPurchasePageInterceptor.kt */
public final class GoodsPurchasePageInterceptor implements IInterceptor {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String TAG = "GoodsPurchasePageInterceptor";

    @Metadata(mo148867d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo148868d2 = {"Lcom/didi/soda/goodsV2/page/GoodsPurchasePageInterceptor$Companion;", "", "()V", "TAG", "", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: GoodsPurchasePageInterceptor.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:21:0x0052, code lost:
        if ((r2 == null || r2.length() == 0) != false) goto L_0x0054;
     */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:43:0x008e  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean intercept(com.didi.soda.router.Request r7, com.didi.soda.router.Response r8) {
        /*
            r6 = this;
            r8 = 0
            if (r7 != 0) goto L_0x0004
            return r8
        L_0x0004:
            android.os.Bundle r7 = r7.getExtras()
            java.lang.String r0 = "GoodsPurchasePageInterceptor"
            if (r7 != 0) goto L_0x0013
            java.lang.String r7 = "未传入商品信息"
            com.didi.soda.customer.foundation.log.util.LogUtil.m32586e((java.lang.String) r0, (java.lang.String) r7)
            goto L_0x0098
        L_0x0013:
            java.lang.String r1 = "shopid"
            java.lang.Object r1 = r7.get(r1)
            java.lang.String r1 = (java.lang.String) r1
            java.lang.String r2 = "itemid"
            java.lang.Object r2 = r7.get(r2)
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = "itementity"
            java.lang.Object r3 = r7.get(r3)
            com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity r3 = (com.didi.soda.customer.foundation.rpc.entity.GoodsItemEntity) r3
            java.lang.String r4 = "cartitementity"
            java.lang.Object r4 = r7.get(r4)
            r5 = 1
            if (r3 != 0) goto L_0x005a
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            if (r1 == 0) goto L_0x0041
            int r1 = r1.length()
            if (r1 != 0) goto L_0x003f
            goto L_0x0041
        L_0x003f:
            r1 = 0
            goto L_0x0042
        L_0x0041:
            r1 = 1
        L_0x0042:
            if (r1 != 0) goto L_0x0054
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            if (r2 == 0) goto L_0x0051
            int r1 = r2.length()
            if (r1 != 0) goto L_0x004f
            goto L_0x0051
        L_0x004f:
            r1 = 0
            goto L_0x0052
        L_0x0051:
            r1 = 1
        L_0x0052:
            if (r1 == 0) goto L_0x0065
        L_0x0054:
            java.lang.String r1 = "未指定结构体时，必须传入shopId和itemId"
            com.didi.soda.customer.foundation.log.util.LogUtil.m32586e((java.lang.String) r0, (java.lang.String) r1)
            goto L_0x0063
        L_0x005a:
            com.didi.soda.customer.foundation.rpc.entity.ItemNodeEntity r1 = r3.node
            if (r1 != 0) goto L_0x0065
            java.lang.String r1 = "item node == null"
            com.didi.soda.customer.foundation.log.util.LogUtil.m32586e((java.lang.String) r0, (java.lang.String) r1)
        L_0x0063:
            r1 = 1
            goto L_0x0066
        L_0x0065:
            r1 = 0
        L_0x0066:
            r2 = 0
            if (r4 == 0) goto L_0x008b
            java.lang.String r3 = "cart_id"
            java.lang.Object r7 = r7.get(r3)
            boolean r3 = r7 instanceof java.lang.String
            if (r3 == 0) goto L_0x0076
            java.lang.String r7 = (java.lang.String) r7
            goto L_0x0077
        L_0x0076:
            r7 = r2
        L_0x0077:
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x0081
            int r7 = r7.length()
            if (r7 != 0) goto L_0x0082
        L_0x0081:
            r8 = 1
        L_0x0082:
            if (r8 == 0) goto L_0x008b
            java.lang.String r7 = "cart not null, cartId is empty"
            com.didi.soda.customer.foundation.log.util.LogUtil.m32586e((java.lang.String) r0, (java.lang.String) r7)
            r8 = 1
            goto L_0x008c
        L_0x008b:
            r8 = r1
        L_0x008c:
            if (r8 == 0) goto L_0x0098
            r7 = 2131954229(0x7f130a35, float:1.9544951E38)
            java.lang.String r7 = com.didi.soda.customer.foundation.util.ResourceHelper.getString(r7)
            com.didi.soda.customer.foundation.util.ToastUtil.showCustomerErrorToast(r2, r7)
        L_0x0098:
            return r8
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.goodsV2.page.GoodsPurchasePageInterceptor.intercept(com.didi.soda.router.Request, com.didi.soda.router.Response):boolean");
    }
}
