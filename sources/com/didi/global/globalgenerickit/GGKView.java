package com.didi.global.globalgenerickit;

import android.view.View;
import com.didiglobal.dittoview.impl.DittoViewBinderImpl;
import com.didiglobal.dittoview.mvvm.DittoData;

public class GGKView {

    /* renamed from: a */
    private View f23957a;

    /* renamed from: b */
    private GGKViewBinder f23958b;

    /* renamed from: c */
    private DittoViewBinderImpl f23959c;

    public View getView() {
        return this.f23957a;
    }

    public GGKView(GGKViewBinder gGKViewBinder, View view) {
        this.f23958b = gGKViewBinder;
        this.f23957a = view;
    }

    public GGKView(DittoViewBinderImpl dittoViewBinderImpl, View view) {
        this.f23957a = view;
        this.f23959c = dittoViewBinderImpl;
    }

    public void bind(GGKData gGKData) {
        this.f23958b.bind(this.f23957a, gGKData);
    }

    public void bind(DittoData dittoData) {
        this.f23959c.bind(this.f23957a, dittoData);
    }
}
