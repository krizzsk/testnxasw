package com.didi.component.comp_config.presenter;

import android.content.Context;
import android.os.Bundle;
import com.didi.component.comp_config.AbsConfigPresenter;
import com.didi.sdk.app.BusinessContext;

public class ConfigPresenter extends AbsConfigPresenter {

    /* renamed from: a */
    private Context f13976a;

    public ConfigPresenter(BusinessContext businessContext) {
        super(businessContext);
        this.f13976a = businessContext.getContext();
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }
}
