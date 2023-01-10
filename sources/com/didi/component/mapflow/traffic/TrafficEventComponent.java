package com.didi.component.mapflow.traffic;

import android.view.ViewGroup;
import com.didi.component.base.BaseComponent;
import com.didi.component.common.base.ComponentRegister;
import com.didi.component.core.ComponentParams;

@ComponentRegister(product = "ride", type = "passenger_map_push_card")
public class TrafficEventComponent extends BaseComponent<TrafficEventView, TrafficEventPresenter> {
    /* access modifiers changed from: protected */
    public TrafficEventView onCreateView(ComponentParams componentParams, ViewGroup viewGroup) {
        return new TrafficEventView(componentParams.bizCtx.getContext(), viewGroup);
    }

    /* access modifiers changed from: protected */
    public TrafficEventPresenter onCreatePresenter(ComponentParams componentParams) {
        return new TrafficEventPresenter(componentParams);
    }
}
