package com.didi.soda.customer.component.flutterordermap;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class OrderMapComponent extends MvpComponent<OrderMapView, OrderMapPresenter> {

    /* renamed from: a */
    private OrderMapPresenter f43377a;

    public OrderMapComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public OrderMapView onCreateView() {
        return new OrderMapView();
    }

    /* access modifiers changed from: protected */
    public OrderMapPresenter onCreatePresenter() {
        OrderMapPresenter orderMapPresenter = new OrderMapPresenter();
        this.f43377a = orderMapPresenter;
        return orderMapPresenter;
    }
}
