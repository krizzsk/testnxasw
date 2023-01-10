package com.didi.component.bubbleLayout.impl;

import android.view.View;
import android.view.ViewGroup;
import com.didi.component.bubbleLayout.AbsBubbleLayoutPresenter;
import com.didi.component.bubbleLayout.IBubbleLayoutView;
import com.didi.component.bubbleLayout.anycar.AnycarBubbleLayout;
import com.didi.component.bubbleLayout.view.BubbleAnimationLayout;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IViewContainer;

public class BubbleLayoutView implements IBubbleLayoutView, IViewContainer {

    /* renamed from: a */
    private BubbleAnimationLayout f12964a;

    /* renamed from: b */
    private AnycarBubbleLayout f12965b;

    /* renamed from: c */
    private AbsBubbleLayoutPresenter f12966c;

    public BubbleLayoutView(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f12964a = new BubbleAnimationLayout(componentParams.getActivity());
    }

    public View getView() {
        return this.f12964a;
    }

    public void setPresenter(AbsBubbleLayoutPresenter absBubbleLayoutPresenter) {
        this.f12966c = absBubbleLayoutPresenter;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        AbsBubbleLayoutPresenter absBubbleLayoutPresenter = this.f12966c;
        if (absBubbleLayoutPresenter != null) {
            absBubbleLayoutPresenter.setComponentCreator(iComponentCreator);
        }
    }
}
