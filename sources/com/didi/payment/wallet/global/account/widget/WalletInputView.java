package com.didi.payment.wallet.global.account.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.taxis99.R;

public class WalletInputView extends RelativeLayout {

    /* renamed from: a */
    private TextView f34272a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f34273b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public EditText f34274c;

    /* renamed from: d */
    private View f34275d;

    /* renamed from: e */
    private int f34276e;

    public WalletInputView(Context context) {
        this(context, (AttributeSet) null);
    }

    public WalletInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public WalletInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m26187a(context);
    }

    /* renamed from: a */
    private void m26187a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.wallet_input_view, this, true);
        this.f34272a = (TextView) findViewById(R.id.wallet_input_title);
        this.f34273b = (ImageView) findViewById(R.id.wallet_delete_btn);
        this.f34274c = (EditText) findViewById(R.id.wallet_input_et);
        this.f34275d = findViewById(R.id.wallet_input_bottom_line);
        m26186a();
    }

    /* renamed from: a */
    private void m26186a() {
        this.f34273b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                WalletInputView.this.f34274c.setText("");
            }
        });
        this.f34274c.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(WalletInputView.this.f34274c.getText().toString())) {
                    WalletInputView.this.f34273b.setVisibility(8);
                } else {
                    WalletInputView.this.f34273b.setVisibility(0);
                }
            }
        });
        this.f34274c.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                WalletInputView.this.m26189a(z);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26189a(boolean z) {
        if (z) {
            if (!TextUtils.isEmpty(this.f34274c.getText().toString())) {
                this.f34273b.setVisibility(0);
            }
            this.f34275d.setBackgroundColor(getContext().getResources().getColor(R.color.wallet_common_black));
            return;
        }
        this.f34273b.setVisibility(8);
        this.f34275d.setBackgroundColor(getContext().getResources().getColor(R.color.wallet_item_divider));
    }

    public void initConfig(String str, int i, int i2) {
        this.f34272a.setText(str);
        this.f34274c.setInputType(i2);
        this.f34274c.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        this.f34276e = i;
    }

    public String getInputString() {
        return this.f34274c.getText().toString();
    }

    public void setInputString(String str) {
        this.f34274c.setText(str);
    }

    public void setTextChangeListener(TextWatcher textWatcher) {
        this.f34274c.addTextChangedListener(textWatcher);
    }

    public void setFilter(InputFilter inputFilter) {
        this.f34274c.setFilters(new InputFilter[]{inputFilter, new InputFilter.LengthFilter(this.f34276e)});
    }
}
