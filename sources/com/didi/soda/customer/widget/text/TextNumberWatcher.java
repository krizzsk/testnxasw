package com.didi.soda.customer.widget.text;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class TextNumberWatcher implements TextWatcher {

    /* renamed from: a */
    private static final String f44799a = "TextNumberWatcher";

    /* renamed from: b */
    private OnChangedListener f44800b;

    /* renamed from: c */
    private EditText f44801c;

    /* renamed from: d */
    private int f44802d;

    /* renamed from: e */
    private boolean f44803e = true;

    /* renamed from: f */
    private String f44804f;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    private TextNumberWatcher(EditText editText, int i, OnChangedListener onChangedListener) {
        this.f44801c = editText;
        editText.addTextChangedListener(this);
        this.f44802d = i;
        this.f44800b = onChangedListener;
    }

    public static TextWatcher watch(EditText editText, int i, OnChangedListener onChangedListener) {
        return new TextNumberWatcher(editText, i, onChangedListener);
    }

    public void afterTextChanged(Editable editable) {
        if (!this.f44803e) {
            this.f44803e = true;
            return;
        }
        String obj = editable.toString();
        this.f44804f = obj;
        int length = obj.length();
        int i = this.f44802d;
        if (length > i) {
            this.f44803e = false;
            String substring = this.f44804f.substring(0, i);
            this.f44804f = substring;
            this.f44801c.setText(substring);
            if (this.f44804f.length() >= 1) {
                this.f44801c.setSelection(this.f44804f.length());
            }
        }
        OnChangedListener onChangedListener = this.f44800b;
        if (onChangedListener != null) {
            onChangedListener.onChanged(this.f44804f);
        }
    }
}
