package com.didi.app.nova.support.view.recyclerview.adapter;

import com.didi.app.nova.support.view.recyclerview.binder.ItemBinder;
import com.didi.app.nova.support.view.recyclerview.data.ChildDataListManager;
import java.util.List;

public final class SimpleRecyclerAdapter<T, B extends ItemBinder> extends NovaRecyclerAdapter {

    /* renamed from: a */
    private final ChildDataListManager<T> f10432a;

    public SimpleRecyclerAdapter() {
        ChildDataListManager<T> childDataListManager = new ChildDataListManager<>(this);
        this.f10432a = childDataListManager;
        addDataManager(childDataListManager);
    }

    public SimpleRecyclerAdapter(B b) {
        ChildDataListManager<T> childDataListManager = new ChildDataListManager<>(this);
        this.f10432a = childDataListManager;
        addDataManager(childDataListManager);
        registerBinder(b);
    }

    public final ChildDataListManager<T> getDataManager() {
        return this.f10432a;
    }

    public final void setData(List<T> list) {
        this.f10432a.set(list);
    }

    public void addData(List<T> list) {
        this.f10432a.addAll(list);
    }
}
