package com.didi.soda.goodsV2.contract;

import com.didi.soda.customer.repo.model.ItemState;
import com.didi.soda.goods.contract.GoodsItemState;

public class GoodsAmountModel {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f44980a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f44981b;

    /* renamed from: c */
    private GoodsAmountListener f44982c;
    public int mActivityType;
    public String mBusinessId;
    public String mGoodsId;
    public GoodsItemState mGoodsItemState;
    public int mInitialAmount = 0;
    public String mItemUniKey;
    public int mMaxAmount;
    public int mMaxSaleAmount = 0;
    public int mMinAmount;

    public interface GoodsAmountListener {
        void exceedMaxAmount(int i);

        void exceedMaxSaleAmount(int i);

        void exceedMinAmount();
    }

    public boolean decreaseAmount(int i) {
        if (exceedMinAmount()) {
            GoodsAmountListener goodsAmountListener = this.f44982c;
            if (goodsAmountListener == null) {
                return false;
            }
            goodsAmountListener.exceedMinAmount();
            return false;
        }
        this.f44980a -= i;
        return true;
    }

    public boolean exceedMaxAmount() {
        return this.f44980a >= this.mMaxAmount;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:8:0x001c, code lost:
        r0 = r2.mMaxSaleAmount;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean exceedMaxSaleAmount() {
        /*
            r2 = this;
            int r0 = r2.mActivityType
            boolean r0 = com.didi.soda.goodsV2.helper.GoodsDataHelper.isSpecialPrice(r0)
            if (r0 != 0) goto L_0x0018
            int r0 = r2.mActivityType
            boolean r0 = com.didi.soda.goodsV2.helper.GoodsDataHelper.isRegularCustomer(r0)
            if (r0 != 0) goto L_0x0018
            int r0 = r2.mActivityType
            boolean r0 = com.didi.soda.goodsV2.helper.GoodsDataHelper.isEFO(r0)
            if (r0 == 0) goto L_0x002b
        L_0x0018:
            boolean r0 = r2.f44981b
            if (r0 != 0) goto L_0x002b
            int r0 = r2.mMaxSaleAmount
            if (r0 < 0) goto L_0x002b
            r1 = 2147483647(0x7fffffff, float:NaN)
            if (r0 >= r1) goto L_0x002b
            int r1 = r2.f44980a
            if (r1 < r0) goto L_0x002b
            r0 = 1
            goto L_0x002c
        L_0x002b:
            r0 = 0
        L_0x002c:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.goodsV2.contract.GoodsAmountModel.exceedMaxSaleAmount():boolean");
    }

    public boolean exceedMinAmount() {
        return this.f44980a <= this.mMinAmount;
    }

    public int getCurrentAmount() {
        return this.f44980a;
    }

    public boolean increaseAmount(int i) {
        if (exceedMaxAmount()) {
            GoodsAmountListener goodsAmountListener = this.f44982c;
            if (goodsAmountListener != null) {
                goodsAmountListener.exceedMaxAmount(this.mMaxAmount);
            }
            return false;
        } else if (exceedMaxSaleAmount() && this.f44982c != null) {
            return false;
        } else {
            this.f44980a += i;
            return true;
        }
    }

    public void setGoodsAmountListener(GoodsAmountListener goodsAmountListener) {
        this.f44982c = goodsAmountListener;
    }

    public void updateGoodsItemAmountModel(ItemState itemState) {
        if (this.mItemUniKey.equals(itemState.itemUniKey)) {
            this.f44980a = itemState.amount;
        }
    }

    public void clearAmount() {
        this.f44980a = 0;
    }

    public static class Builder {
        private GoodsAmountModel mGoodsAmountModel = new GoodsAmountModel();

        public GoodsAmountModel build() {
            return this.mGoodsAmountModel;
        }

        public Builder setBusinessId(String str) {
            this.mGoodsAmountModel.mBusinessId = str;
            return this;
        }

        public Builder setGoodsId(String str) {
            this.mGoodsAmountModel.mGoodsId = str;
            return this;
        }

        public Builder setItemUniKey(String str) {
            this.mGoodsAmountModel.mItemUniKey = str;
            return this;
        }

        public Builder setGoodsItemState(GoodsItemState goodsItemState) {
            this.mGoodsAmountModel.mGoodsItemState = goodsItemState;
            return this;
        }

        public Builder setInitialAmount(int i) {
            this.mGoodsAmountModel.mInitialAmount = i;
            int unused = this.mGoodsAmountModel.f44980a = i;
            return this;
        }

        public Builder setMaxAmount(int i) {
            this.mGoodsAmountModel.mMaxAmount = i;
            return this;
        }

        public Builder setMaxSaleAmount(int i) {
            this.mGoodsAmountModel.mMaxSaleAmount = i;
            return this;
        }

        public Builder setMinAmount(int i) {
            this.mGoodsAmountModel.mMinAmount = i;
            return this;
        }

        public Builder setActivityType(int i) {
            this.mGoodsAmountModel.mActivityType = i;
            return this;
        }

        public Builder setAllowOverAmoun(boolean z) {
            boolean unused = this.mGoodsAmountModel.f44981b = z;
            return this;
        }
    }
}
