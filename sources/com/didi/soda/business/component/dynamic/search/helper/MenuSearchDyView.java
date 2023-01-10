package com.didi.soda.business.component.dynamic.search.helper;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class MenuSearchDyView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f42223a;

    /* renamed from: b */
    private View f42224b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f42225c;

    /* renamed from: d */
    private ImageView f42226d;

    /* renamed from: e */
    private LottieLoadingView f42227e;

    /* renamed from: f */
    private View f42228f;

    public MenuSearchDyView(Context context) {
        super(context);
        this.f42223a = context;
        m31738a();
    }

    public MenuSearchDyView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f42223a = context;
        m31738a();
    }

    public EditText getEditView() {
        return this.f42225c;
    }

    public View getSearchButton() {
        return this.f42224b;
    }

    public void showOrHideLoading(boolean z) {
        m31740b();
        if (z) {
            this.f42227e.setVisibility(0);
            if (!this.f42227e.isRunning()) {
                this.f42227e.start();
            }
            this.f42226d.setVisibility(8);
            this.f42228f.setVisibility(8);
            this.f42224b.setVisibility(8);
            return;
        }
        this.f42227e.stop();
        this.f42227e.setVisibility(8);
        this.f42228f.setVisibility(0);
        this.f42224b.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KeyboardUtils.hideSoftInput(getContext(), this.f42225c);
    }

    /* renamed from: a */
    private void m31738a() {
        LayoutInflater.from(this.f42223a).inflate(R.layout.customer_component_dy_menu_search, this);
        this.f42224b = findViewById(R.id.customer_iv_search);
        this.f42227e = (LottieLoadingView) findViewById(R.id.customer_la_search_loading);
        this.f42225c = (EditText) findViewById(R.id.customer_custom_business_search);
        this.f42226d = (ImageView) findViewById(R.id.customer_iv_cancel);
        this.f42228f = findViewById(R.id.v_line);
        this.f42226d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuSearchDyView.this.f42225c.setText("");
            }
        });
        this.f42225c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    KeyboardUtils.showSoftInput(MenuSearchDyView.this.f42223a, view);
                } else {
                    KeyboardUtils.hideSoftInput(MenuSearchDyView.this.f42223a, view);
                }
                MenuSearchDyView.this.m31740b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m31740b() {
        if (TextUtils.isEmpty(this.f42225c.getText().toString())) {
            this.f42226d.setVisibility(8);
        } else {
            this.f42226d.setVisibility(0);
        }
    }
}
