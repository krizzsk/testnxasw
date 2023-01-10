package com.didi.entrega.order.debt;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;

public class DebtOrderPayComponent extends MvpComponent<DebtOrderPayView, DebtOrderPayPresenter> {

    /* renamed from: a */
    private DebtOrderPayPresenter f22729a;

    public DebtOrderPayComponent(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public void onPageResult(Bundle bundle) {
        DebtOrderPayPresenter debtOrderPayPresenter = this.f22729a;
        if (debtOrderPayPresenter != null) {
            debtOrderPayPresenter.onPageResult(bundle);
        }
    }

    public boolean onHandleBack() {
        DebtOrderPayPresenter debtOrderPayPresenter = this.f22729a;
        if (debtOrderPayPresenter != null) {
            return debtOrderPayPresenter.onHandleBack();
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public DebtOrderPayView onCreateView() {
        return new DebtOrderPayView();
    }

    /* access modifiers changed from: protected */
    public DebtOrderPayPresenter onCreatePresenter() {
        DebtOrderPayPresenter debtOrderPayPresenter = new DebtOrderPayPresenter();
        this.f22729a = debtOrderPayPresenter;
        return debtOrderPayPresenter;
    }
}
