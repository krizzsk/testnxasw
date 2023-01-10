package com.didi.component.base;

import com.didi.component.core.IComponent;
import com.didi.component.core.IComponentGroup;
import com.didi.component.core.IPresenter;
import com.didi.component.core.IView;
import java.util.HashMap;
import java.util.Map;

public abstract class BaseComponentGroup<V extends IView, P extends IPresenter> extends BaseComponent<V, P> implements IComponentGroup {

    /* renamed from: a */
    private Map<String, IComponent> f12816a = new HashMap();

    public boolean autoInflateChildView() {
        return true;
    }

    public void onChildComponentCreated(String str, IComponent iComponent) {
        this.f12816a.put(str, iComponent);
    }

    public IComponent findComponentByName(String str) {
        return this.f12816a.get(str);
    }
}
