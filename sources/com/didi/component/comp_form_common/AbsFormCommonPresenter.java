package com.didi.component.comp_form_common;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.sdk.app.BusinessContext;

public abstract class AbsFormCommonPresenter extends IPresenter<AbsFormCommonView> {

    /* renamed from: a */
    private final String f14054a = getClass().getSimpleName();

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14055b = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (!AbsFormCommonPresenter.this.m11655b() && BaseEventKeys.Confirm.EVENT_FORM_ITEM_CHANGE.equals(str)) {
                ((AbsFormCommonView) AbsFormCommonPresenter.this.mView).setData(FormStore.getInstance().getSubstituteCallIcon(), FormStore.getInstance().getSubstituteCallText());
            }
        }
    };

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14056c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (TextUtils.equals(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, str)) {
                ((AbsFormCommonView) AbsFormCommonPresenter.this.mView).hide();
            }
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<Boolean> f14057d = new BaseEventPublisher.OnEventListener<Boolean>() {
        public void onEvent(String str, Boolean bool) {
            if (TextUtils.equals(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, str)) {
                ((AbsFormCommonView) AbsFormCommonPresenter.this.mView).show();
            }
        }
    };
    protected BusinessContext mBizCtx;

    /* access modifiers changed from: private */
    /* renamed from: b */
    public boolean m11655b() {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        return confirmListener != null && confirmListener.getIsAnyCar();
    }

    public AbsFormCommonPresenter(BusinessContext businessContext) {
        super(businessContext.getContext());
        this.mBizCtx = businessContext;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Confirm.EVENT_FORM_ITEM_CHANGE, this.f14055b);
        subscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f14056c);
        subscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f14057d);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.Confirm.EVENT_FORM_ITEM_CHANGE, this.f14055b);
        unsubscribe(BaseEventKeys.Estimate.ESTIMATE_IS_LOADING, this.f14056c);
        unsubscribe(BaseEventKeys.Estimate.NEW_ESTIMATE_RESULT, this.f14057d);
    }
}
