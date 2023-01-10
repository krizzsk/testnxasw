package com.didi.soda.customer.biz.popdialog.natived;

import android.view.ViewGroup;
import com.didi.app.nova.skeleton.mvp.MvpComponent;
import com.didi.soda.customer.biz.popdialog.natived.Contract;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;

public class PopDialogComponent extends MvpComponent<Contract.AbsPopDialogView, Contract.AbsPopDialogPresenter> {

    /* renamed from: a */
    private final NAPopDialogEntity f43075a;

    /* renamed from: b */
    private final PopDialogFactory f43076b = new PopDialogFactory();

    PopDialogComponent(ViewGroup viewGroup, NAPopDialogEntity nAPopDialogEntity) {
        super(viewGroup);
        this.f43075a = nAPopDialogEntity;
    }

    /* access modifiers changed from: protected */
    public Contract.AbsPopDialogPresenter onCreatePresenter() {
        return this.f43076b.mo108516a(this.f43075a);
    }

    /* access modifiers changed from: protected */
    public Contract.AbsPopDialogView onCreateView() {
        return this.f43076b.mo108517a(this.f43075a.popupType);
    }
}
