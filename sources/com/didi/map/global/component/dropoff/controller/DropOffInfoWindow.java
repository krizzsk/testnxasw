package com.didi.map.global.component.dropoff.controller;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class DropOffInfoWindow {

    /* renamed from: a */
    private View f27735a;

    /* renamed from: b */
    private TextView f27736b;

    public View getView(Context context, String str) {
        if (this.f27735a == null) {
            View inflate = LayoutInflater.from(context).inflate(R.layout.layout_dropoff_rec_marker_bubble_view, (ViewGroup) null, false);
            this.f27735a = inflate;
            this.f27736b = (TextView) inflate.findViewById(R.id.dropoff_bubble_name);
        }
        if (!TextUtils.isEmpty(str)) {
            this.f27736b.setText(str);
        }
        return this.f27735a;
    }
}
