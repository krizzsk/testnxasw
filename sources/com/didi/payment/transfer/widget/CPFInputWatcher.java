package com.didi.payment.transfer.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.didi.payment.base.widget.CommonEditText;

public class CPFInputWatcher implements TextWatcher {

    /* renamed from: a */
    int f34044a = 0;

    /* renamed from: b */
    int f34045b = 0;

    /* renamed from: c */
    boolean f34046c;

    /* renamed from: d */
    int f34047d = 0;

    /* renamed from: e */
    int f34048e = 0;

    /* renamed from: f */
    private CommonEditText f34049f;

    /* renamed from: g */
    private StringBuffer f34050g = new StringBuffer();

    public CPFInputWatcher(CommonEditText commonEditText) {
        this.f34049f = commonEditText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f34044a = charSequence.length();
        if (this.f34050g.length() > 0) {
            StringBuffer stringBuffer = this.f34050g;
            stringBuffer.delete(0, stringBuffer.length());
        }
        this.f34048e = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (charSequence.charAt(i4) == '.' || charSequence.charAt(i4) == '-') {
                this.f34048e++;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f34045b = charSequence.length();
        this.f34050g.append(charSequence.toString());
        if (this.f34045b == this.f34044a || this.f34046c) {
            this.f34046c = false;
        } else {
            this.f34046c = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f34046c) {
            int i = 0;
            while (i < this.f34050g.length()) {
                if (this.f34050g.charAt(i) == '.' || this.f34050g.charAt(i) == '-') {
                    this.f34050g.deleteCharAt(i);
                } else {
                    i++;
                }
            }
            int length = this.f34050g.length() / 3;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f34050g.length(); i3++) {
                if (length > 0) {
                    for (int i4 = 1; i4 <= length; i4++) {
                        if (i3 == (i4 * 3) + (i4 - 1)) {
                            if (i2 < 2) {
                                this.f34050g.insert(i3, '.');
                            } else {
                                this.f34050g.insert(i3, '-');
                            }
                            i2++;
                        }
                    }
                }
            }
            String stringBuffer = this.f34050g.toString();
            int selectionEnd = this.f34049f.getSelectionEnd();
            this.f34047d = selectionEnd;
            int i5 = this.f34048e;
            if (i2 > i5) {
                this.f34047d = selectionEnd + (i2 - i5);
            }
            int min = Math.min(this.f34047d, stringBuffer.length());
            this.f34047d = min;
            int max = Math.max(min, 0);
            this.f34047d = max;
            this.f34047d = Math.min(max, 14);
            this.f34049f.setText(stringBuffer);
            Selection.setSelection(this.f34049f.getText(), this.f34047d);
            this.f34046c = false;
        }
    }
}
