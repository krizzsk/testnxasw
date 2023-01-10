package com.didi.global.fintech.cashier.p118ui.widget.popup;

import android.view.View;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.CashierPopup$3 */
class CashierPopup$3 implements Runnable {
    final /* synthetic */ C9111a this$0;
    final /* synthetic */ View val$v;
    final /* synthetic */ int val$x;
    final /* synthetic */ int val$y;

    CashierPopup$3(C9111a aVar, View view, int i, int i2) {
        this.this$0 = aVar;
        this.val$v = view;
        this.val$x = i;
        this.val$y = i2;
    }

    public void run() {
        try {
            this.this$0.showAsDropDown(this.val$v, this.val$x, this.val$y);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
