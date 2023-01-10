package com.didiglobal.passenger.brz.component;

import android.content.Context;
import android.content.Intent;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BrazilCarTypeUtil;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.groupform.presenter.AbsGroupFormPresenter;
import com.didi.component.service.activity.rgltaxiguide.RegularTaxiGuideActivity;

public class BrzGroupFormPresenter extends AbsGroupFormPresenter {

    /* renamed from: a */
    private Context f52807a;

    public BrzGroupFormPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f52807a = componentParams.bizCtx.getContext();
        BrazilCarTypeUtil.initOptionsApollo();
    }

    /* access modifiers changed from: protected */
    public void handleTwoPriceSelectSeatConfirmEvent() {
        onConfirmPriceIntercept();
    }

    public void onConfirmPriceIntercept() {
        if (!m39630b() && !showPinInputPage()) {
            onConfirmPrice();
        }
    }

    public void onConfirmPrice() {
        m39631c();
    }

    /* renamed from: b */
    private boolean m39630b() {
        if (!isPricingTaxi() || GlobalSPUtil.getRegularTaxiGuideHasShow(this.f52807a)) {
            return false;
        }
        GlobalSPUtil.setRegularTaxiGuideHasShow(this.f52807a, true);
        startActivityForResult(RegularTaxiGuideActivity.getIntent(this.f52807a), 100);
        return true;
    }

    public boolean isPricingTaxi() {
        if (FormStore.getInstance().getCarLevel() == 1800) {
            return true;
        }
        return super.isPricingTaxi();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i == 100 && !showPinInputPage()) {
            m39631c();
        }
        super.onActivityResult(i, i2, intent);
    }

    /* renamed from: c */
    private void m39631c() {
        if (BusinessDataUtil.isPriceValid(FormStore.getInstance().getNewEstimateItem())) {
            super.onConfirmPrice();
        }
    }
}
