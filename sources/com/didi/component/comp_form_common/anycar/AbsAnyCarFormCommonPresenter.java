package com.didi.component.comp_form_common.anycar;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.app.BusinessContext;

public abstract class AbsAnyCarFormCommonPresenter extends IPresenter<AbsAnyCarFormCommonView> {

    /* renamed from: a */
    private final String f14061a = getClass().getSimpleName();

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14062b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (AbsAnyCarFormCommonPresenter.this.m11661b() && BaseEventKeys.Confirm.EVENT_FORM_ITEM_CHANGE.equals(str)) {
                ((AbsAnyCarFormCommonView) AbsAnyCarFormCommonPresenter.this.mView).setData(FormStore.getInstance().getSubstituteCallIcon(), FormStore.getInstance().getSubstituteCallText());
            }
        }
    };

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14063c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, str)) {
                ((AbsAnyCarFormCommonView) AbsAnyCarFormCommonPresenter.this.mView).hide();
            }
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<Boolean> f14064d = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            ((AbsAnyCarFormCommonView) AbsAnyCarFormCommonPresenter.this.mView).show();
        }
    };
    protected BusinessContext mBizCtx;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m11661b() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        return confirmListener != null && confirmListener.getIsAnyCar();
    }

    public AbsAnyCarFormCommonPresenter(BusinessContext businessContext) {
        super(businessContext.getContext());
        this.mBizCtx = businessContext;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Confirm.EVENT_FORM_ITEM_CHANGE, this.f14062b);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f14063c);
        subscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f14064d);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Confirm.EVENT_FORM_ITEM_CHANGE, this.f14062b);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f14063c);
        unsubscribe(BaseEventKeys.AnyCar.ANYCAR_EYEBALL_RESPONSE, this.f14064d);
    }
}
