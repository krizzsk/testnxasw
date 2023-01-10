package com.didi.app.nova.support.view.recyclerview.data;

import androidx.recyclerview.widget.ListUpdateCallback;
import com.didi.app.nova.support.view.recyclerview.adapter.NovaRecyclerAdapter;
import java.util.ArrayList;
import java.util.List;

public class BaseDataManager<T> implements ListUpdateCallback {

    /* renamed from: a */
    private final NovaRecyclerAdapter f10444a;
    protected List<T> mDataList = new ArrayList();

    public BaseDataManager(NovaRecyclerAdapter novaRecyclerAdapter) {
        this.f10444a = novaRecyclerAdapter;
    }

    public void move(int i, int i2) {
        T t = this.mDataList.get(i);
        this.mDataList.remove(i);
        this.mDataList.add(i2, t);
        onMoved(i, i2);
    }

    public final int getCount() {
        return this.mDataList.size();
    }

    public final T get(int i) {
        return this.mDataList.get(i);
    }

    public int size() {
        return this.mDataList.size();
    }

    public void onInserted(int i, int i2) {
        this.f10444a.notifyBinderItemRangeInserted(this, i, i2);
    }

    public void onRemoved(int i, int i2) {
        this.f10444a.notifyBinderItemRangeRemoved(this, i, i2);
    }

    public void onMoved(int i, int i2) {
        this.f10444a.notifyBinderItemMoved(this, i, i2);
    }

    public void onChanged(int i, int i2, Object obj) {
        this.f10444a.notifyBinderItemRangeChanged(this, i, i2, obj);
    }
}
