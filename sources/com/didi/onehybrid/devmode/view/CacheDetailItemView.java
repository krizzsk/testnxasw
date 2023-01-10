package com.didi.onehybrid.devmode.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class CacheDetailItemView {

    /* renamed from: a */
    private TextView f32036a;

    /* renamed from: b */
    private TextView f32037b;

    /* renamed from: c */
    private View f32038c;

    public CacheDetailItemView(Context context) {
        m24408a(context);
    }

    /* renamed from: a */
    private void m24408a(Context context) {
        View inflate = ((LayoutInflater) context.getSystemService("layout_inflater")).inflate(R.layout.cache_item_detail_layout, (ViewGroup) null);
        this.f32038c = inflate;
        this.f32036a = (TextView) inflate.findViewById(R.id.tv_cache_size);
        this.f32037b = (TextView) this.f32038c.findViewById(R.id.tv_cache_md5);
    }

    public View getRoot() {
        return this.f32038c;
    }

    public void setCacheSize(String str) {
        this.f32036a.setText(str);
    }

    public void setCacheMd5(String str) {
        this.f32037b.setText(str);
    }
}
