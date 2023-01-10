package com.didi.global.fintech.cashier.p118ui.widget.popup;

import android.view.View;
import com.didi.global.fintech.cashier.p118ui.widget.popup.model.CashierBubbleArrow;
import com.didi.global.fintech.cashier.p118ui.widget.popup.model.CashierBubbleBaseModel;
import com.didi.global.fintech.cashier.p118ui.widget.popup.model.CashierTextModel;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.popup.b */
/* compiled from: CashierPopupModel */
class C9112b {

    /* renamed from: a */
    public CashierTextModel f23864a;

    /* renamed from: b */
    public String f23865b;

    /* renamed from: c */
    public int f23866c;

    /* renamed from: d */
    public String f23867d;

    /* renamed from: e */
    public String f23868e;

    /* renamed from: f */
    public CashierBubbleArrow f23869f;

    /* renamed from: g */
    public View.OnClickListener f23870g;

    C9112b(CashierBubbleBaseModel cashierBubbleBaseModel, View.OnClickListener onClickListener) {
        this.f23864a = cashierBubbleBaseModel.text;
        this.f23865b = cashierBubbleBaseModel.icon;
        this.f23866c = cashierBubbleBaseModel.cancelable;
        this.f23867d = cashierBubbleBaseModel.background_color;
        this.f23868e = cashierBubbleBaseModel.url;
        this.f23869f = cashierBubbleBaseModel.arrow;
        this.f23870g = onClickListener;
    }
}
