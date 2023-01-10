package com.didi.entrega.customer.widget.text;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public final class TextNumberWatcher implements TextWatcher {

    /* renamed from: a */
    private static final String f22469a = "TextNumberWatcher";

    /* renamed from: b */
    private OnChangedListener f22470b;

    /* renamed from: c */
    private EditText f22471c;

    /* renamed from: d */
    private int f22472d;

    /* renamed from: e */
    private boolean f22473e = true;

    /* renamed from: f */
    private String f22474f;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    private TextNumberWatcher(EditText editText, int i, OnChangedListener onChangedListener) {
        this.f22471c = editText;
        editText.addTextChangedListener(this);
        this.f22472d = i;
        this.f22470b = onChangedListener;
    }

    public static TextWatcher watch(EditText editText, int i, OnChangedListener onChangedListener) {
        return new TextNumberWatcher(editText, i, onChangedListener);
    }

    public void afterTextChanged(Editable editable) {
        if (!this.f22473e) {
            this.f22473e = true;
            return;
        }
        String obj = editable.toString();
        this.f22474f = obj;
        int length = obj.length();
        int i = this.f22472d;
        if (length > i) {
            this.f22473e = false;
            String substring = this.f22474f.substring(0, i);
            this.f22474f = substring;
            this.f22471c.setText(substring);
            if (this.f22474f.length() >= 1) {
                this.f22471c.setSelection(this.f22474f.length());
            }
        }
        OnChangedListener onChangedListener = this.f22470b;
        if (onChangedListener != null) {
            onChangedListener.onChanged(this.f22474f);
        }
    }
}
