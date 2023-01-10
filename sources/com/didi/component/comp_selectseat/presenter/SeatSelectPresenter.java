package com.didi.component.comp_selectseat.presenter;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.comp_selectseat.AbsSeatSelectPresenter;
import com.didi.sdk.app.BusinessContext;

public class SeatSelectPresenter extends AbsSeatSelectPresenter {

    /* renamed from: a */
    private Context f14249a;

    public SeatSelectPresenter(BusinessContext businessContext) {
        super(businessContext);
        this.f14249a = businessContext.getContext();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }
}
