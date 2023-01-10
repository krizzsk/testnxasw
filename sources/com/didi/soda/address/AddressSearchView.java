package com.didi.soda.address;

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
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.widget.loading.LottieLoadingView;
import com.taxis99.R;

public class AddressSearchView extends RelativeLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f41338a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EditText f41339b;

    /* renamed from: c */
    private ImageView f41340c;

    /* renamed from: d */
    private LottieLoadingView f41341d;

    public AddressSearchView(Context context) {
        super(context);
        this.f41338a = context;
        m31019a();
    }

    public AddressSearchView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f41338a = context;
        m31019a();
    }

    public void showOrHideLoading(boolean z) {
        m31021b();
        if (z) {
            this.f41341d.setVisibility(0);
            if (!this.f41341d.isRunning()) {
                this.f41341d.start();
            }
            this.f41340c.setVisibility(8);
            return;
        }
        this.f41341d.stop();
        this.f41341d.setVisibility(8);
    }

    public void addTextWatcher(TextWatcher textWatcher) {
        this.f41339b.addTextChangedListener(textWatcher);
    }

    public void setFilters(InputFilter[] inputFilterArr) {
        this.f41339b.setFilters(inputFilterArr);
    }

    public void focus() {
        this.f41339b.requestFocus();
    }

    public void clearText() {
        this.f41339b.setText("");
    }

    /* access modifiers changed from: protected */
    public void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        KeyboardUtils.hideSoftInput(getContext(), this.f41339b);
    }

    /* renamed from: a */
    private void m31019a() {
        LayoutInflater.from(this.f41338a).inflate(R.layout.customer_component_address_search, this);
        this.f41341d = (LottieLoadingView) findViewById(R.id.customer_la_address_search_loading);
        this.f41339b = (EditText) findViewById(R.id.customer_custom_address_search);
        ImageView imageView = (ImageView) findViewById(R.id.customer_iv_cancel);
        this.f41340c = imageView;
        imageView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AddressSearchView.this.f41339b.setText("");
            }
        });
        this.f41339b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    KeyboardUtils.showSoftInput(AddressSearchView.this.f41338a, view);
                } else {
                    KeyboardUtils.hideSoftInput(AddressSearchView.this.f41338a, view);
                }
            }
        });
    }

    /* renamed from: b */
    private void m31021b() {
        if (TextUtils.isEmpty(this.f41339b.getText().toString())) {
            this.f41340c.setVisibility(8);
        } else {
            this.f41340c.setVisibility(0);
        }
    }
}
