package com.didi.payment.transfer.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import com.didi.payment.base.widget.CommonEditText;

public class BankCardInputWatcher implements TextWatcher {

    /* renamed from: a */
    int f34037a = 0;

    /* renamed from: b */
    int f34038b = 0;

    /* renamed from: c */
    boolean f34039c;

    /* renamed from: d */
    int f34040d = 0;

    /* renamed from: e */
    int f34041e = 0;

    /* renamed from: f */
    private CommonEditText f34042f;

    /* renamed from: g */
    private StringBuffer f34043g = new StringBuffer();

    public BankCardInputWatcher(CommonEditText commonEditText) {
        this.f34042f = commonEditText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f34037a = charSequence.length();
        if (this.f34043g.length() > 0) {
            StringBuffer stringBuffer = this.f34043g;
            stringBuffer.delete(0, stringBuffer.length());
        }
        this.f34041e = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (charSequence.charAt(i4) == ' ') {
                this.f34041e++;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f34038b = charSequence.length();
        this.f34043g.append(charSequence.toString());
        if (this.f34038b == this.f34037a || this.f34039c) {
            this.f34039c = false;
        } else {
            this.f34039c = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f34039c) {
            int i = 0;
            while (i < this.f34043g.length()) {
                if (this.f34043g.charAt(i) == ' ') {
                    this.f34043g.deleteCharAt(i);
                } else {
                    i++;
                }
            }
            int length = this.f34043g.length() / 4;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f34043g.length(); i3++) {
                if (length > 0) {
                    for (int i4 = 1; i4 <= length; i4++) {
                        if (i3 == (i4 * 4) + (i4 - 1)) {
                            this.f34043g.insert(i3, ' ');
                            i2++;
                        }
                    }
                }
            }
            String stringBuffer = this.f34043g.toString();
            int selectionEnd = this.f34042f.getSelectionEnd();
            this.f34040d = selectionEnd;
            int i5 = this.f34041e;
            if (i2 > i5) {
                this.f34040d = selectionEnd + (i2 - i5);
            }
            int min = Math.min(this.f34040d, stringBuffer.length());
            this.f34040d = min;
            int max = Math.max(min, 0);
            this.f34040d = max;
            this.f34040d = Math.min(max, 17);
            this.f34042f.setText(stringBuffer);
            Selection.setSelection(this.f34042f.getText(), this.f34040d);
            this.f34039c = false;
        }
    }
}
