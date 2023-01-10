package com.didi.soda.order.component.receipt;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class OrderReceiptComponent extends MvpComponent<OrderReceiptView, C14897a> {
    public OrderReceiptComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public OrderReceiptView onCreateView() {
        return new OrderReceiptView();
    }

    /* access modifiers changed from: protected */
    public C14897a onCreatePresenter() {
        return new C14897a();
    }
}
