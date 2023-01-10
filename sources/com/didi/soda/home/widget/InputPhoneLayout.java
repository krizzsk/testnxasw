package com.didi.soda.home.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;

public class InputPhoneLayout extends ConstraintLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EditText f45851a;

    /* renamed from: b */
    private LinearLayout f45852b;

    /* renamed from: c */
    private TextView f45853c;

    public InputPhoneLayout(Context context) {
        super(context);
        m34008a();
    }

    public InputPhoneLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m34008a();
    }

    public InputPhoneLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m34008a();
    }

    public void focus() {
        this.f45851a.post(new Runnable() {
            public final void run() {
                InputPhoneLayout.this.m34010b();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m34010b() {
        this.f45851a.requestFocus();
    }

    public EditText getEditTextView() {
        return this.f45851a;
    }

    public String getPhone() {
        return this.f45851a.getText().toString();
    }

    public void setOnCodeClickListener(View.OnClickListener onClickListener) {
        this.f45852b.setOnClickListener(onClickListener);
    }

    public void updateCode(String str) {
        this.f45853c.setText(str);
    }

    /* renamed from: a */
    private void m34008a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_view_home_input_phone, this);
        this.f45852b = (LinearLayout) findViewById(R.id.customer_ll_input_code_layout);
        this.f45853c = (TextView) findViewById(R.id.customer_tv_code_text);
        EditText editText = (EditText) findViewById(R.id.customer_custom_input_phone);
        this.f45851a = editText;
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                InputPhoneLayout.this.m34009a(view, z);
            }
        });
        this.f45851a.setTextSize(1, 16.0f);
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(this.f45851a, IToolsService.FontType.LIGHT);
        this.f45851a.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (TextUtils.isEmpty(editable)) {
                    InputPhoneLayout.this.f45851a.setTextSize(1, 16.0f);
                    ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(InputPhoneLayout.this.f45851a, IToolsService.FontType.LIGHT);
                    return;
                }
                InputPhoneLayout.this.f45851a.setTextSize(1, 24.0f);
                ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(InputPhoneLayout.this.f45851a, IToolsService.FontType.MEDIUM);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m34009a(View view, boolean z) {
        if (z) {
            KeyboardUtils.showSoftInput(getContext(), view);
        } else {
            KeyboardUtils.hideSoftInput(getContext(), view);
        }
    }
}
