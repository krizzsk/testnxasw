package com.didi.component.mapflow.view.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.taxis99.R;

public class StartDestAbnormalDrawerView extends LinearLayout {

    /* renamed from: a */
    private TextView f16378a;

    /* renamed from: b */
    private TextView f16379b;

    /* renamed from: c */
    private LinearLayout f16380c;

    /* renamed from: d */
    private LinearLayout f16381d;

    /* renamed from: e */
    private LinearLayout f16382e;

    public StartDestAbnormalDrawerView(Context context) {
        super(context);
        m13731a(context);
    }

    /* renamed from: a */
    private void m13731a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.global_map_start_end_dot, this, true);
        this.f16380c = (LinearLayout) findViewById(R.id.star_layout);
        this.f16378a = (TextView) findViewById(R.id.tv_start_text);
        this.f16381d = (LinearLayout) findViewById(R.id.destination_layout);
        this.f16379b = (TextView) findViewById(R.id.tv_end_text);
        this.f16382e = (LinearLayout) findViewById(R.id.start_or_dest_layout);
    }

    public void setOnlyStart(String str) {
        int i = 0;
        this.f16382e.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        LinearLayout linearLayout = this.f16380c;
        if (TextUtils.isEmpty(str)) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.f16378a.setText(str);
        this.f16381d.setVisibility(8);
    }

    public void setOnlyDest(String str) {
        int i = 0;
        this.f16382e.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        LinearLayout linearLayout = this.f16381d;
        if (TextUtils.isEmpty(str)) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        this.f16379b.setText(str);
        this.f16380c.setVisibility(8);
    }

    public void setStartDest(String str, String str2) {
        int i = 8;
        if (!TextUtils.isEmpty(str) || !TextUtils.isEmpty(str2)) {
            this.f16382e.setVisibility(0);
        } else {
            this.f16382e.setVisibility(8);
        }
        this.f16380c.setVisibility(TextUtils.isEmpty(str) ? 8 : 0);
        this.f16378a.setText(str);
        LinearLayout linearLayout = this.f16381d;
        if (!TextUtils.isEmpty(str2)) {
            i = 0;
        }
        linearLayout.setVisibility(i);
        this.f16379b.setText(str2);
    }
}
