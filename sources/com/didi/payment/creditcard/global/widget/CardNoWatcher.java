package com.didi.payment.creditcard.global.widget;

import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.widget.EditText;
import com.didi.payment.base.utils.RTLUtil;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;

public class CardNoWatcher implements TextWatcher {

    /* renamed from: a */
    int f33046a = 0;

    /* renamed from: b */
    int f33047b = 0;

    /* renamed from: c */
    boolean f33048c;

    /* renamed from: d */
    int f33049d = 0;

    /* renamed from: e */
    int f33050e = 0;

    /* renamed from: f */
    private EditText f33051f;

    /* renamed from: g */
    private StringBuffer f33052g = new StringBuffer();

    /* renamed from: h */
    private CardBinCheckListener f33053h;

    public interface CardBinCheckListener {
        void check(String str);

        void reset(String str);
    }

    public CardNoWatcher(EditText editText) {
        this.f33051f = editText;
    }

    public void setCheckListener(CardBinCheckListener cardBinCheckListener) {
        this.f33053h = cardBinCheckListener;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f33046a = charSequence.length();
        if (this.f33052g.length() > 0) {
            StringBuffer stringBuffer = this.f33052g;
            stringBuffer.delete(0, stringBuffer.length());
        }
        this.f33050e = 0;
        for (int i4 = 0; i4 < charSequence.length(); i4++) {
            if (charSequence.charAt(i4) == ' ') {
                this.f33050e++;
            }
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f33047b = charSequence.length();
        this.f33052g.append(charSequence.toString());
        if (this.f33047b == this.f33046a || this.f33048c) {
            this.f33048c = false;
        } else {
            this.f33048c = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f33048c) {
            int i = 0;
            while (i < this.f33052g.length()) {
                if (this.f33052g.charAt(i) == ' ') {
                    this.f33052g.deleteCharAt(i);
                } else {
                    i++;
                }
            }
            int length = this.f33052g.length() / 4;
            int i2 = 0;
            for (int i3 = 0; i3 < this.f33052g.length(); i3++) {
                if (length > 0) {
                    for (int i4 = 1; i4 <= length; i4++) {
                        if (i3 == (i4 * 4) + (i4 - 1)) {
                            this.f33052g.insert(i3, ' ');
                            i2++;
                        }
                    }
                }
            }
            String stringBuffer = this.f33052g.toString();
            int selectionEnd = this.f33051f.getSelectionEnd();
            this.f33049d = selectionEnd;
            int i5 = this.f33050e;
            if (i2 > i5) {
                this.f33049d = selectionEnd + (i2 - i5);
            }
            int min = Math.min(this.f33049d, stringBuffer.length());
            this.f33049d = min;
            int max = Math.max(min, 0);
            this.f33049d = max;
            this.f33049d = Math.min(max, 23);
            this.f33051f.setText(stringBuffer);
            Selection.setSelection(this.f33051f.getText(), this.f33049d);
            this.f33048c = false;
            String replaceAllSpace = PaymentTextUtil.replaceAllSpace(editable.toString());
            if (replaceAllSpace.length() < 6) {
                CardBinCheckListener cardBinCheckListener = this.f33053h;
                if (cardBinCheckListener != null) {
                    cardBinCheckListener.reset(replaceAllSpace);
                    return;
                }
                return;
            }
            CardBinCheckListener cardBinCheckListener2 = this.f33053h;
            if (cardBinCheckListener2 != null) {
                cardBinCheckListener2.check(replaceAllSpace);
            }
        } else if (RTLUtil.isInRTLMode()) {
            int min2 = Math.min(this.f33049d, this.f33051f.getText() != null ? this.f33051f.getText().length() : 0);
            this.f33049d = min2;
            this.f33049d = Math.max(min2, 0);
            Selection.setSelection(this.f33051f.getText(), this.f33049d);
        }
    }
}
