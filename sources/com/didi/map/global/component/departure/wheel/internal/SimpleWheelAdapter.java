package com.didi.map.global.component.departure.wheel.internal;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;

public class SimpleWheelAdapter<T> extends BaseWheelAdapter<T> {

    /* renamed from: a */
    private Context f27695a;

    public SimpleWheelAdapter(Context context) {
        this.f27695a = context;
    }

    public View bindView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = new SimpleWheelItem(this.f27695a);
        }
        SimpleWheelItem simpleWheelItem = (SimpleWheelItem) view;
        Object item = getItem(i);
        if (item != null) {
            if (simpleWheelItem instanceof CharSequence) {
                simpleWheelItem.setText((CharSequence) item);
            } else {
                simpleWheelItem.setText(item.toString());
            }
        }
        return view;
    }
}
