package com.didi.component.evaluatequestion.impl.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.evaluatequestion.AbsEvaluateQuestionPresenter;
import com.didi.component.evaluatequestion.UnevaluatedViewModel;
import com.didi.component.evaluatequestion.impl.view.IEvaluatedView;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.model.response.CarEvaluateQuestionData;
import com.didi.travel.psnger.model.response.CarOrder;

public class EndServiceEvaluateQuestionPresenter extends AbsEvaluateQuestionPresenter {

    /* renamed from: a */
    private CloseEvaluateXPenal f15414a;

    /* renamed from: b */
    private CarEvaluateQuestionData f15415b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public UnevaluatedViewModel f15416c;

    public EndServiceEvaluateQuestionPresenter(ComponentParams componentParams) {
        super(componentParams);
        this.f15415b = (CarEvaluateQuestionData) componentParams.getExtra(BaseExtras.EndService.EXTRA_EVALUATE_QUESTION_DATA);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        m12711b();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        close();
        return true;
    }

    public void close() {
        ((IEvaluatedView) this.mView).close();
        doPublish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.EVALUATE_QUESTION);
    }

    public void onEvaluatedClicked(int i) {
        if (!Utils.isFastDoubleClick()) {
            m12708a(i);
        }
    }

    /* renamed from: b */
    private void m12711b() {
        this.f15416c = new UnevaluatedViewModel();
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            this.f15416c.parse(order.oid, this.f15415b);
            showUnevaluated(this.f15416c);
        }
    }

    /* renamed from: a */
    private void m12708a(final int i) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            ((IEvaluatedView) this.mView).getView().setVisibility(8);
            return;
        }
        UnevaluatedViewModel unevaluatedViewModel = this.f15416c;
        if (unevaluatedViewModel != null && unevaluatedViewModel.answers != null && this.f15416c.answers.length >= 2 && this.f15416c.answerState != null && this.f15416c.answerState.length >= 2) {
            int i2 = this.f15416c.answerState[i];
            String str = this.f15416c.answers[i];
            this.f15414a = new CloseEvaluateXPenal();
            ((IEvaluatedView) this.mView).showLoading();
            CarRequest.commitEvaluateQuestionData(this.mContext, order.getOid(), this.f15416c.questionID, i2, (String) null, str, this.f15416c.questionCaller, i, new ResponseListener<CarEvaluateQuestionData>() {
                public void onSuccess(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onSuccess(carEvaluateQuestionData);
                    ((IEvaluatedView) EndServiceEvaluateQuestionPresenter.this.mView).hideError();
                    EndServiceEvaluateQuestionPresenter endServiceEvaluateQuestionPresenter = EndServiceEvaluateQuestionPresenter.this;
                    endServiceEvaluateQuestionPresenter.showEvaluated(i, endServiceEvaluateQuestionPresenter.f15416c);
                    EndServiceEvaluateQuestionPresenter.this.m12712c();
                }

                public void onError(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onError(carEvaluateQuestionData);
                    ((IEvaluatedView) EndServiceEvaluateQuestionPresenter.this.mView).showError();
                }

                public void onFail(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onFail(carEvaluateQuestionData);
                    ((IEvaluatedView) EndServiceEvaluateQuestionPresenter.this.mView).showError();
                }

                public void onFinish(CarEvaluateQuestionData carEvaluateQuestionData) {
                    super.onFinish(carEvaluateQuestionData);
                    ((IEvaluatedView) EndServiceEvaluateQuestionPresenter.this.mView).hideLoading();
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m12712c() {
        UiThreadHandler.postDelayed(this.f15414a, 1000);
    }

    private class CloseEvaluateXPenal implements Runnable {
        private CloseEvaluateXPenal() {
        }

        public void run() {
            EndServiceEvaluateQuestionPresenter.this.doPublish(BaseEventKeys.Template.EVENT_HIDE_POPUP_COMPONENT, ComponentType.EVALUATE_QUESTION);
        }
    }
}
