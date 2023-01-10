package com.didi.dimina.container.p065ui.pickerview.adapter;

import com.didi.dimina.container.p065ui.wheelview.adapter.WheelAdapter;

/* renamed from: com.didi.dimina.container.ui.pickerview.adapter.NumericWheelAdapter */
public class NumericWheelAdapter implements WheelAdapter {

    /* renamed from: a */
    private final int f4514a;

    /* renamed from: b */
    private final int f4515b;

    public NumericWheelAdapter(int i, int i2) {
        this.f4514a = i;
        this.f4515b = i2;
    }

    public Object getItem(int i) {
        if (i < 0 || i >= getItemsCount()) {
            return 0;
        }
        return Integer.valueOf(this.f4514a + i);
    }

    public int getItemsCount() {
        return (this.f4515b - this.f4514a) + 1;
    }

    public int indexOf(Object obj) {
        try {
            return ((Integer) obj).intValue() - this.f4514a;
        } catch (Exception unused) {
            return -1;
        }
    }
}
