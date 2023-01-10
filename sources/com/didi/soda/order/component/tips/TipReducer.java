package com.didi.soda.order.component.tips;

import android.content.Context;
import com.didi.soda.jadux.Reducer;

public class TipReducer implements Reducer<TipState> {

    /* renamed from: a */
    private Context f46033a;

    TipReducer(Context context) {
        this.f46033a = context;
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.didi.soda.order.component.tips.TipState reduce(com.didi.soda.order.component.tips.TipState r12, com.didi.soda.jadux.Action r13) {
        /*
            r11 = this;
            java.lang.String r0 = r13.getType()
            int r1 = r0.hashCode()
            r2 = 3
            r3 = 0
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r3)
            r5 = 2
            r6 = 1
            switch(r1) {
                case -1938510511: goto L_0x0032;
                case -1435283542: goto L_0x0028;
                case 1288389005: goto L_0x001e;
                case 1422577192: goto L_0x0014;
                default: goto L_0x0013;
            }
        L_0x0013:
            goto L_0x003c
        L_0x0014:
            java.lang.String r1 = "soda.bill.dialog/close_bubble"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003c
            r0 = 2
            goto L_0x003d
        L_0x001e:
            java.lang.String r1 = "soda.bill.dialog/select_tip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003c
            r0 = 0
            goto L_0x003d
        L_0x0028:
            java.lang.String r1 = "soda.bill.dialog/select_paycard"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003c
            r0 = 3
            goto L_0x003d
        L_0x0032:
            java.lang.String r1 = "soda.bill.dialog/input_tip"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L_0x003c
            r0 = 1
            goto L_0x003d
        L_0x003c:
            r0 = -1
        L_0x003d:
            r7 = 0
            r1 = 0
            if (r0 == 0) goto L_0x0130
            if (r0 == r6) goto L_0x0058
            if (r0 == r5) goto L_0x0054
            if (r0 == r2) goto L_0x004a
            goto L_0x0215
        L_0x004a:
            java.lang.Object r13 = r13.getPayload()
            com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity r13 = (com.didi.soda.customer.foundation.rpc.entity.PayChannelEntity) r13
            r12.mPaychannel = r13
            goto L_0x0215
        L_0x0054:
            r12.mBubbleTxt = r1
            goto L_0x0215
        L_0x0058:
            java.lang.Object r13 = r13.getPayload()
            java.lang.String r13 = (java.lang.String) r13
            java.lang.String r0 = r12.mNewInput
            r12.mNewInput = r13
            java.lang.String r2 = r12.mInput
            boolean r2 = r2.equals(r13)
            if (r2 != 0) goto L_0x0124
            boolean r2 = android.text.TextUtils.isEmpty(r13)
            if (r2 == 0) goto L_0x007e
            r12.mInput = r13
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r2 = r12.mTips
            r2.tipFeeValue = r7
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r2 = r12.mTips
            r2.tipPayValue = r7
            r12.mBubbleTxt = r1
            goto L_0x0124
        L_0x007e:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            int r2 = r2.intValue()
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r3 = r12.mConfig
            int r7 = r3.tipFeeType
            java.lang.String r8 = " "
            if (r7 != r6) goto L_0x00cd
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r5 = r12.mTips
            int r2 = r2 * 100
            long r6 = (long) r2
            r5.tipFeeValue = r6
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r2 = r12.mTips
            long r9 = r2.tipFeeValue
            int r2 = r3.maxTipFeePrice
            long r2 = (long) r2
            int r5 = (r9 > r2 ? 1 : (r9 == r2 ? 0 : -1))
            if (r5 > 0) goto L_0x00a9
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r2 = r12.mTips
            r2.tipPayValue = r6
            r12.mInput = r13
            r12.mBubbleTxt = r1
            goto L_0x010a
        L_0x00a9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = r11.f46033a
            r3 = 2131954072(0x7f130998, float:1.9544633E38)
            java.lang.String r2 = r2.getString(r3)
            r1.append(r2)
            r1.append(r8)
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r2 = r12.mConfig
            int r2 = r2.maxTipFeePrice
            int r2 = r2 / 100
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r12.mBubbleTxt = r1
            goto L_0x010a
        L_0x00cd:
            int r6 = r3.tipFeeType
            if (r6 != r5) goto L_0x010a
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r5 = r12.mTips
            long r6 = (long) r2
            r5.tipFeeValue = r6
            int r3 = r3.maxTipFeeRate
            if (r2 > r3) goto L_0x00e9
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r3 = r12.mTips
            long r5 = r12.mOrderPrice
            long r5 = r11.m34189a(r5, r2)
            r3.tipPayValue = r5
            r12.mInput = r13
            r12.mBubbleTxt = r1
            goto L_0x010a
        L_0x00e9:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            android.content.Context r2 = r11.f46033a
            r3 = 2131954071(0x7f130997, float:1.954463E38)
            java.lang.String r2 = r2.getString(r3)
            r1.append(r2)
            r1.append(r8)
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r2 = r12.mConfig
            int r2 = r2.maxTipFeeRate
            r1.append(r2)
            java.lang.String r1 = r1.toString()
            r12.mBubbleTxt = r1
        L_0x010a:
            java.util.Map<java.lang.Integer, java.lang.Boolean> r1 = r12.mSelectStatus
            java.util.Set r1 = r1.entrySet()
            java.util.Iterator r1 = r1.iterator()
        L_0x0114:
            boolean r2 = r1.hasNext()
            if (r2 == 0) goto L_0x0124
            java.lang.Object r2 = r1.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            r2.setValue(r4)
            goto L_0x0114
        L_0x0124:
            boolean r13 = r0.equals(r13)
            if (r13 == 0) goto L_0x0215
            java.lang.String r13 = r12.mInput
            r12.mNewInput = r13
            goto L_0x0215
        L_0x0130:
            java.lang.Object r13 = r13.getPayload()
            java.lang.Integer r13 = (java.lang.Integer) r13
            int r13 = r13.intValue()
            java.lang.Integer r0 = java.lang.Integer.valueOf(r13)
            r12.mCurrentSeleted = r0
            java.util.Map<java.lang.Integer, java.lang.Boolean> r0 = r12.mSelectStatus
            java.util.Set r0 = r0.entrySet()
            java.util.Iterator r0 = r0.iterator()
        L_0x014a:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x015a
            java.lang.Object r2 = r0.next()
            java.util.Map$Entry r2 = (java.util.Map.Entry) r2
            r2.setValue(r4)
            goto L_0x014a
        L_0x015a:
            java.util.Map<java.lang.Integer, java.lang.Boolean> r0 = r12.mSelectStatus
            java.lang.Integer r2 = java.lang.Integer.valueOf(r13)
            java.lang.Boolean r4 = java.lang.Boolean.valueOf(r6)
            r0.put(r2, r4)
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r0 = r12.mTips
            if (r0 != 0) goto L_0x0172
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r0 = new com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity
            r0.<init>()
            r12.mTips = r0
        L_0x0172:
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r0 = r12.mConfig
            if (r0 == 0) goto L_0x020f
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r0 = r12.mTips
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r2 = r12.mConfig
            int r2 = r2.tipFeeType
            r0.tipFeeType = r2
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r0 = r12.mConfig
            java.util.List<java.lang.Long> r0 = r0.tipFeeConfig
            int r0 = r0.size()
            if (r13 >= r0) goto L_0x0199
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r0 = r12.mConfig
            java.util.List<java.lang.Long> r0 = r0.tipFeeConfig
            java.lang.Object r13 = r0.get(r13)
            java.lang.Long r13 = (java.lang.Long) r13
            long r7 = r13.longValue()
            r12.mInputVisible = r3
            goto L_0x019b
        L_0x0199:
            r12.mInputVisible = r6
        L_0x019b:
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r13 = r12.mConfig
            int r13 = r13.tipFeeType
            if (r13 != r6) goto L_0x01c5
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r13 = r12.mTips
            r13.tipFeeValue = r7
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r13 = r12.mTips
            long r2 = r13.tipFeeValue
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r13 = r12.mConfig
            int r13 = r13.maxTipFeePrice
            long r4 = (long) r13
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x01bc
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r13 = r12.mTips
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r0 = r12.mConfig
            int r0 = r0.maxTipFeePrice
            long r2 = (long) r0
            r13.tipPayValue = r2
            goto L_0x020f
        L_0x01bc:
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r13 = r12.mTips
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r0 = r12.mTips
            long r2 = r0.tipFeeValue
            r13.tipPayValue = r2
            goto L_0x020f
        L_0x01c5:
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r13 = r12.mConfig
            int r13 = r13.tipFeeType
            if (r13 != r5) goto L_0x020f
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r13 = r12.mTips
            r13.tipFeeValue = r7
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r13 = r12.mTips
            long r2 = r12.mOrderPrice
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r0 = r12.mTips
            long r4 = r0.tipFeeValue
            int r0 = (int) r4
            long r2 = r11.m34189a(r2, r0)
            r13.tipPayValue = r2
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r13 = r12.mTips
            long r2 = r13.tipFeeValue
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r13 = r12.mConfig
            int r13 = r13.maxTipFeeRate
            long r4 = (long) r13
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x01f9
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r13 = r12.mTips
            long r2 = r12.mOrderPrice
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r0 = r12.mConfig
            int r0 = r0.maxTipFeeRate
            long r2 = r11.m34189a(r2, r0)
            r13.tipPayValue = r2
        L_0x01f9:
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r13 = r12.mTips
            long r2 = r13.tipPayValue
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r13 = r12.mConfig
            int r13 = r13.maxTipFeePrice
            long r4 = (long) r13
            int r13 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r13 <= 0) goto L_0x020f
            com.didi.soda.customer.foundation.rpc.entity.cart.TipFeeInfoEntity r13 = r12.mTips
            com.didi.soda.customer.foundation.rpc.entity.TipsConfigEntity r0 = r12.mConfig
            int r0 = r0.maxTipFeePrice
            long r2 = (long) r0
            r13.tipPayValue = r2
        L_0x020f:
            java.lang.String r13 = ""
            r12.mInput = r13
            r12.mBubbleTxt = r1
        L_0x0215:
            return r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.order.component.tips.TipReducer.reduce(com.didi.soda.order.component.tips.TipState, com.didi.soda.jadux.Action):com.didi.soda.order.component.tips.TipState");
    }

    /* renamed from: a */
    private long m34189a(long j, int i) {
        return Math.round((((double) j) * ((double) i)) / 100.0d);
    }
}
