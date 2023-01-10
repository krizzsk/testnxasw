package com.didi.component.never.core.container;

import android.os.Bundle;
import android.view.ViewGroup;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentProxy;
import com.didi.component.never.core.IComponentEx;
import com.didi.component.never.core.IView;
import com.didi.component.never.core.container.ContainerPresenter;

public abstract class ContainerComponent<P extends ContainerPresenter> implements IComponentEx {

    /* renamed from: a */
    private P f16493a;

    /* renamed from: b */
    private ComponentParams f16494b;

    /* renamed from: c */
    private ComponentProxy<IView, P> f16495c = null;

    public <T> T getExtra(String str) {
        return null;
    }

    public ViewGroup.LayoutParams getLayoutParams(ComponentParams componentParams) {
        return null;
    }

    public IView getView() {
        return null;
    }

    /* access modifiers changed from: protected */
    public abstract P onCreatePresenter(ComponentParams componentParams);

    public boolean recreateWhenNodeChange(ComponentParams componentParams) {
        return true;
    }

    public void setExtras(Bundle bundle) {
    }

    public void init(ComponentParams componentParams, ViewGroup viewGroup) {
        this.f16494b = componentParams;
        ComponentProxy<IView, P> componentProxy = this.f16495c;
        this.f16493a = componentProxy == null ? onCreatePresenter(componentParams) : (ContainerPresenter) componentProxy.onCreatePresenter(componentParams);
    }

    public void setComponentProxy(ComponentProxy componentProxy) {
        this.f16495c = componentProxy;
    }

    public P getPresenter() {
        return this.f16493a;
    }

    public ComponentParams getParams() {
        return this.f16494b;
    }
}
