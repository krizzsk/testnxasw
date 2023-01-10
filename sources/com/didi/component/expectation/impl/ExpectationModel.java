package com.didi.component.expectation.impl;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.common.push.model.ExpectationManagementModel;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.expectation.AbsExpectationPresenter;

public class ExpectationModel<P extends AbsExpectationPresenter<?>> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public P f15442a;

    /* renamed from: b */
    private final BaseEventPublisher.OnEventListener<Integer> f15443b = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            ExpectationModel.this.f15442a.onFinishAnimate(num.intValue());
        }
    };

    /* renamed from: c */
    private final BaseEventPublisher.OnEventListener<ExpectationManagementModel> f15444c = new BaseEventPublisher.OnEventListener<ExpectationManagementModel>() {
        public void onEvent(String str, ExpectationManagementModel expectationManagementModel) {
            ExpectationModel.this.f15442a.processDuseInfo(expectationManagementModel);
        }
    };

    /* renamed from: d */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f15445d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            ExpectationModel.this.f15442a.onTipsClick();
        }
    };

    public void setPresenter(P p) {
        this.f15442a = p;
    }

    public void subscribe() {
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_TRANSITION_START, this.f15443b);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_EXPECTATION_MANAGEMENT, this.f15444c);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Expectation.EVENT_EXPECTATION_SHOW_TIPS, this.f15445d);
    }

    public void unSubscribe() {
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.NewXpanel.EVENT_XPANEL_NEW_TRANSITION_START, this.f15443b);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAIT_4_RSP_EXPECTATION_MANAGEMENT, this.f15444c);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Expectation.EVENT_EXPECTATION_SHOW_TIPS, this.f15445d);
    }
}
