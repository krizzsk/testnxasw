package com.didi.soda.order.component.evaluate;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationResultEntity;

public class OrderEvaluateComponent extends MvpComponent<OrderEvaluateView, OrderEvaluatePresenter> {

    /* renamed from: a */
    private OrderEvaluatePresenter f45937a;

    public OrderEvaluateComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void goBack() {
        this.f45937a.closePage(false, (OrderEvaluationResultEntity) null);
    }

    /* access modifiers changed from: protected */
    public OrderEvaluateView onCreateView() {
        return new OrderEvaluateView();
    }

    /* access modifiers changed from: protected */
    public OrderEvaluatePresenter onCreatePresenter() {
        OrderEvaluatePresenter orderEvaluatePresenter = new OrderEvaluatePresenter();
        this.f45937a = orderEvaluatePresenter;
        return orderEvaluatePresenter;
    }
}
