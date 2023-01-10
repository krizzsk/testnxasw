package com.didi.entrega.address.list.component.search.widget;

import android.content.Context;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.entrega.customer.foundation.util.KeyboardUtils;
import com.didi.entrega.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class AddressSearchView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f21318a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f21319b;

    /* renamed from: c */
    private ImageView f21320c;

    /* renamed from: d */
    private LottieLoadingView f21321d;

    public AddressSearchView(Context context) {
        super(context);
        this.f21318a = context;
        m18004a();
    }

    public AddressSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f21318a = context;
        m18004a();
    }

    public void showOrHideLoading(boolean z) {
        m18006b();
        if (z) {
            this.f21321d.setVisibility(0);
            if (!this.f21321d.isRunning()) {
                this.f21321d.start();
            }
            this.f21320c.setVisibility(8);
            return;
        }
        this.f21321d.stop();
        this.f21321d.setVisibility(8);
    }

    public void addTextWatcher(TextWatcher textWatcher) {
        this.f21319b.addTextChangedListener(textWatcher);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f21319b.setFilters(inputFilterArr);
    }

    public void focus() {
        this.f21319b.requestFocus();
    }

    public void clearText() {
        this.f21319b.setText("");
    }

    public void setTextHint(String str) {
        this.f21319b.setHint(str);
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KeyboardUtils.hideSoftInput(getContext(), this.f21319b);
    }

    /* renamed from: a */
    private void m18004a() {
        LayoutInflater.from(this.f21318a).inflate(R.layout.entrega_customer_component_address_search, this);
        this.f21321d = (LottieLoadingView) findViewById(R.id.customer_la_address_search_loading);
        this.f21319b = (EditText) findViewById(R.id.customer_custom_address_search);
        ImageView imageView = (ImageView) findViewById(R.id.customer_iv_cancel);
        this.f21320c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressSearchView.this.f21319b.setText("");
            }
        });
        this.f21319b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    KeyboardUtils.showSoftInput(AddressSearchView.this.f21318a, view);
                } else {
                    KeyboardUtils.hideSoftInput(AddressSearchView.this.f21318a, view);
                }
            }
        });
    }

    /* renamed from: b */
    private void m18006b() {
        if (TextUtils.isEmpty(this.f21319b.getText().toString())) {
            this.f21320c.setVisibility(8);
        } else {
            this.f21320c.setVisibility(0);
        }
    }
}
