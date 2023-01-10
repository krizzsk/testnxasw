package com.didi.soda.business.component.search.helper;

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

public class MenuSearchView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f42274a;

    /* renamed from: b */
    private View f42275b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f42276c;

    /* renamed from: d */
    private ImageView f42277d;

    /* renamed from: e */
    private LottieLoadingView f42278e;

    public MenuSearchView(Context context) {
        super(context);
        this.f42274a = context;
        m31776a();
    }

    public MenuSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f42274a = context;
        m31776a();
    }

    public EditText getEditView() {
        return this.f42276c;
    }

    public View getSearchButton() {
        return this.f42275b;
    }

    public void showOrHideLoading(boolean z) {
        m31778b();
        if (z) {
            this.f42278e.setVisibility(0);
            if (!this.f42278e.isRunning()) {
                this.f42278e.start();
            }
            this.f42277d.setVisibility(8);
            return;
        }
        this.f42278e.stop();
        this.f42278e.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KeyboardUtils.hideSoftInput(getContext(), this.f42276c);
    }

    /* renamed from: a */
    private void m31776a() {
        LayoutInflater.from(this.f42274a).inflate(R.layout.customer_component_menu_search, this);
        this.f42275b = findViewById(R.id.customer_iv_address_search_icon);
        this.f42278e = (LottieLoadingView) findViewById(R.id.customer_la_address_search_loading);
        this.f42276c = (EditText) findViewById(R.id.customer_custom_address_search);
        ImageView imageView = (ImageView) findViewById(R.id.customer_iv_cancel);
        this.f42277d = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                MenuSearchView.this.f42276c.setText("");
            }
        });
        this.f42276c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    KeyboardUtils.showSoftInput(MenuSearchView.this.f42274a, view);
                } else {
                    KeyboardUtils.hideSoftInput(MenuSearchView.this.f42274a, view);
                }
                MenuSearchView.this.m31778b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m31778b() {
        if (TextUtils.isEmpty(this.f42276c.getText().toString())) {
            this.f42277d.setVisibility(8);
        } else {
            this.f42277d.setVisibility(0);
        }
    }
}
