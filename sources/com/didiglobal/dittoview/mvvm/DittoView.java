package com.didiglobal.dittoview.mvvm;

import android.view.View;

public class DittoView {

    /* renamed from: a */
    private View f52460a;

    /* renamed from: b */
    private DittoViewBinder f52461b;

    public View getView() {
        return this.f52460a;
    }

    public DittoView(DittoViewBinder dittoViewBinder, View view) {
        this.f52461b = dittoViewBinder;
        this.f52460a = view;
    }

    public void bind(DittoData dittoData) {
        this.f52461b.bind(this.f52460a, dittoData);
    }
}
