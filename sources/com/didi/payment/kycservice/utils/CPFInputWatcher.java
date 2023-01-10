package com.didi.payment.kycservice.utils;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;

public class CPFInputWatcher implements TextWatcher {

    /* renamed from: a */
    int f33458a = 0;

    /* renamed from: b */
    int f33459b = 0;

    /* renamed from: c */
    boolean f33460c;

    /* renamed from: d */
    int f33461d = 0;

    /* renamed from: e */
    int f33462e = 0;

    /* renamed from: f */
    private EditText f33463f;

    /* renamed from: g */
    private StringBuffer f33464g = new StringBuffer();

    public CPFInputWatcher(EditText editText) {
        this.f33463f = editText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f33458a = charSequence.length();
        if (this.f33464g.length() > 0) {
            StringBuffer stringBuffer = this.f33464g;
            stringBuffer.delete(0, stringBuffer.length());
        }
        this.f33462e = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (charSequence.charAt(i4) == '.' || charSequence.charAt(i4) == '-') {
                this.f33462e++;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f33459b = charSequence.length();
        this.f33464g.append(charSequence.toString());
        if (this.f33459b == this.f33458a || this.f33460c) {
            this.f33460c = false;
        } else {
            this.f33460c = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f33460c) {
            int i = 0;
            while (i < this.f33464g.length()) {
                if (this.f33464g.charAt(i) == '.' || this.f33464g.charAt(i) == '-') {
                    this.f33464g.deleteCharAt(i);
                } else {
                    i++;
                }
            }
            int length = this.f33464g.length() / 3;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f33464g.length(); i3++) {
                if (length > 0) {
                    for (int i4 = 1; i4 <= length; i4++) {
                        if (i3 == (i4 * 3) + (i4 - 1)) {
                            if (i2 < 2) {
                                this.f33464g.insert(i3, '.');
                            } else {
                                this.f33464g.insert(i3, '-');
                            }
                            i2++;
                        }
                    }
                }
            }
            String stringBuffer = this.f33464g.toString();
            int selectionEnd = this.f33463f.getSelectionEnd();
            this.f33461d = selectionEnd;
            int i5 = this.f33462e;
            if (i2 > i5) {
                this.f33461d = selectionEnd + (i2 - i5);
            }
            int min = Math.min(this.f33461d, stringBuffer.length());
            this.f33461d = min;
            int max = Math.max(min, 0);
            this.f33461d = max;
            this.f33461d = Math.min(max, 14);
            this.f33463f.setText(stringBuffer);
            Selection.setSelection(this.f33463f.getText(), this.f33461d);
            this.f33460c = false;
        }
    }
}
