package com.didi.component.payment.proxy;

import android.content.Context;
import android.view.View;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import global.didi.pay.IGlobalPayView;
import global.didi.pay.newview.NewGlobalPaymentView;

public class ViewProxy implements IView {

    /* renamed from: a */
    private IGlobalPayView f16954a;

    public void setPresenter(IPresenter iPresenter) {
    }

    public ViewProxy(Context context) {
        this.f16954a = new NewGlobalPaymentView(context);
    }

    public View getView() {
        return this.f16954a.getView();
    }

    public IGlobalPayView getRealView() {
        return this.f16954a;
    }
}
