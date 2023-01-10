package com.didi.sdk.view.picker;

import com.didi.sdk.view.picker.NumberPickerView;

class PickerBaseFree$1 implements NumberPickerView.OnValueChangeListener {
    final /* synthetic */ C14068a this$0;
    final /* synthetic */ int val$finalI;

    PickerBaseFree$1(C14068a aVar, int i) {
        this.this$0 = aVar;
        this.val$finalI = i;
    }

    public void onValueChange(NumberPickerView numberPickerView, int i, int i2) {
        if (this.this$0.isAdded()) {
            int[] iArr = this.this$0.mCurAllIndex;
            int i3 = this.val$finalI;
            iArr[i3] = i2;
            this.this$0.m30637a(i3 + 1);
            C14068a aVar = this.this$0;
            aVar.onWheelChanged(aVar.getSelectedData(), this.this$0.getSelectedIndex());
            if (this.this$0.mIsResultRealTime) {
                this.this$0.confirmSelectAndCallback();
            }
        }
    }
}
