package com.didi.dimina.container.p065ui.pickerview.adapter;

import com.didi.dimina.container.p065ui.wheelview.adapter.WheelAdapter;
import java.util.List;

/* renamed from: com.didi.dimina.container.ui.pickerview.adapter.ArrayWheelAdapter */
public class ArrayWheelAdapter<T> implements WheelAdapter {

    /* renamed from: a */
    private final List<T> f4513a;

    public ArrayWheelAdapter(List<T> list) {
        this.f4513a = list;
    }

    public Object getItem(int i) {
        return (i < 0 || i >= this.f4513a.size()) ? "" : this.f4513a.get(i);
    }

    public int getItemsCount() {
        return this.f4513a.size();
    }

    public int indexOf(Object obj) {
        return this.f4513a.indexOf(obj);
    }
}
