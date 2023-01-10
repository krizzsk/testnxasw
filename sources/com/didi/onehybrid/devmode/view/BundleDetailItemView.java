package com.didi.onehybrid.devmode.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class BundleDetailItemView {

    /* renamed from: a */
    private TextView f32033a;

    /* renamed from: b */
    private TextView f32034b;

    /* renamed from: c */
    private View f32035c;

    public BundleDetailItemView(Context context) {
        m24407a(context);
    }

    /* renamed from: a */
    private void m24407a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.all_offline_bundle_item_detail_layout, (ViewGroup) null);
        this.f32035c = inflate;
        this.f32033a = (TextView) inflate.findViewById(R.id.tv_all_offline_item_bundle_name);
        this.f32034b = (TextView) this.f32035c.findViewById(R.id.tv_all_offline_item_bundle_size);
    }

    public View getRoot() {
        return this.f32035c;
    }

    public void setBundleName(String str) {
        this.f32033a.setText(str);
    }

    public void setBundleSize(String str) {
        this.f32034b.setText(str);
    }
}
