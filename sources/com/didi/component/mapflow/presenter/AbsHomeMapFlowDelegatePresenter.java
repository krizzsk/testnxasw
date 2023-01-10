package com.didi.component.mapflow.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.mapflow.view.IMapFlowDelegateView;

public abstract class AbsHomeMapFlowDelegatePresenter extends AbsBeforeOrderMapFlowDelegatePresenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f16212a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f16213b = 0;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f16214c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f16215d = true;

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<Integer> f16216e = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            int unused = AbsHomeMapFlowDelegatePresenter.this.f16212a = num.intValue();
            ((IMapFlowDelegateView) AbsHomeMapFlowDelegatePresenter.this.mView).addBottomMask(AbsHomeMapFlowDelegatePresenter.this.f16212a + (AbsHomeMapFlowDelegatePresenter.this.f16215d ? AbsHomeMapFlowDelegatePresenter.this.f16214c : 0) + AbsHomeMapFlowDelegatePresenter.this.f16213b);
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<Integer> f16217f = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            int unused = AbsHomeMapFlowDelegatePresenter.this.f16213b = num.intValue();
            AbsHomeMapFlowDelegatePresenter absHomeMapFlowDelegatePresenter = AbsHomeMapFlowDelegatePresenter.this;
            int unused2 = absHomeMapFlowDelegatePresenter.f16212a = absHomeMapFlowDelegatePresenter.mBusinessContext.getBizBarHeight();
            ((IMapFlowDelegateView) AbsHomeMapFlowDelegatePresenter.this.mView).addBottomMask(AbsHomeMapFlowDelegatePresenter.this.f16212a + (AbsHomeMapFlowDelegatePresenter.this.f16215d ? AbsHomeMapFlowDelegatePresenter.this.f16214c : 0) + AbsHomeMapFlowDelegatePresenter.this.f16213b);
        }
    };

    /* renamed from: g */
    private BaseEventPublisher.OnEventListener<Integer> f16218g = new BaseEventPublisher.OnEventListener<Integer>() {
        public void onEvent(String str, Integer num) {
            int unused = AbsHomeMapFlowDelegatePresenter.this.f16214c = num.intValue();
            AbsHomeMapFlowDelegatePresenter absHomeMapFlowDelegatePresenter = AbsHomeMapFlowDelegatePresenter.this;
            int unused2 = absHomeMapFlowDelegatePresenter.f16212a = absHomeMapFlowDelegatePresenter.mBusinessContext.getBizBarHeight();
            ((IMapFlowDelegateView) AbsHomeMapFlowDelegatePresenter.this.mView).addBottomMask(AbsHomeMapFlowDelegatePresenter.this.f16212a + (AbsHomeMapFlowDelegatePresenter.this.f16215d ? AbsHomeMapFlowDelegatePresenter.this.f16214c : 0) + AbsHomeMapFlowDelegatePresenter.this.f16213b);
        }
    };

    public AbsHomeMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe("event_show_new_sug_page", this.mShowNewSugPageListener);
        subscribe(BaseEventKeys.Home.EVENT_SHOW_NAV_BAR, this.f16216e);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f16217f);
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f16218g);
        setCurrentPage("home");
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe("event_show_new_sug_page", this.mShowNewSugPageListener);
        unsubscribe(BaseEventKeys.Home.EVENT_SHOW_NAV_BAR, this.f16216e);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f16217f);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f16218g);
        setCurrentPage("");
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        unsubscribe("event_show_new_sug_page", this.mShowNewSugPageListener);
        unsubscribe(BaseEventKeys.Home.EVENT_SHOW_NAV_BAR, this.f16216e);
        unsubscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f16217f);
        unsubscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f16218g);
        ((IMapFlowDelegateView) this.mView).removeBottomMask();
        setCurrentPage("");
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        subscribe("event_show_new_sug_page", this.mShowNewSugPageListener);
        subscribe(BaseEventKeys.Home.EVENT_SHOW_NAV_BAR, this.f16216e);
        subscribe(BaseEventKeys.XPanel.EVENT_HEIGHT_CHANGED, this.f16217f);
        subscribe(BaseEventKeys.XBanner.EVENT_XBANNER_GET_HEIGHT, this.f16218g);
        setCurrentPage("home");
    }
}
