package com.didi.component.splitfare.presenter;

import com.didi.component.common.base.BaseExpressPresenter;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.splitfare.view.ISplitFareView;
import java.util.HashMap;
import java.util.Map;

public class AbsSplitFarePresenter<V extends ISplitFareView> extends BaseExpressPresenter<V> {

    /* renamed from: a */
    private Map<String, BaseEventPublisher.OnEventListener> f17849a = new HashMap();

    public AbsSplitFarePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void subscribe(String str, BaseEventPublisher.OnEventListener onEventListener) {
        if (!this.f17849a.containsKey(str)) {
            this.f17849a.put(str, onEventListener);
            super.subscribe(str, onEventListener);
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        for (Map.Entry next : this.f17849a.entrySet()) {
            unsubscribe((String) next.getKey(), (BaseEventPublisher.OnEventListener) next.getValue());
        }
        super.onRemove();
    }
}
