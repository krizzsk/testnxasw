package com.didi.soda.customer.widget.goodsV2.stepper;

public class GoodsStepperModel {

    /* renamed from: a */
    private int f44529a = 0;
    public int mCurQuantityNumber = 0;
    public boolean mIsAddEnabled = true;

    public void syncLastQuantityNumber() {
        this.f44529a = this.mCurQuantityNumber;
    }

    public boolean needExpand() {
        return this.f44529a == 0 && this.mCurQuantityNumber > 0;
    }

    public boolean needCollapse() {
        return this.f44529a > 0 && this.mCurQuantityNumber == 0;
    }

    public boolean isNumDiff() {
        return this.f44529a != this.mCurQuantityNumber;
    }
}
