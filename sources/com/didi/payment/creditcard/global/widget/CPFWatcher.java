package com.didi.payment.creditcard.global.widget;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

public class CPFWatcher implements TextWatcher {

    /* renamed from: a */
    private static final int f33031a = 14;

    /* renamed from: b */
    private static final char f33032b = '.';

    /* renamed from: c */
    private static final char f33033c = '-';

    /* renamed from: d */
    private static final int f33034d = 3;

    /* renamed from: e */
    private static final int f33035e = 7;

    /* renamed from: f */
    private static final int f33036f = 11;

    /* renamed from: g */
    private EditText f33037g;

    /* renamed from: h */
    private String f33038h;

    /* renamed from: i */
    private boolean f33039i;

    public CPFWatcher(EditText editText) {
        this.f33037g = editText;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f33038h = charSequence.toString();
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int length = this.f33037g.getText().length();
        if (length > 14) {
            this.f33037g.getText().delete(14, length);
        } else if (length < this.f33038h.length()) {
            String str = this.f33038h;
            char charAt = str.charAt(str.length() - 1);
            if (charAt == '.' || charAt == '-') {
                this.f33037g.getText().delete(length - 1, length);
            }
        }
        if (this.f33039i) {
            this.f33039i = false;
        } else {
            this.f33039i = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f33039i) {
            boolean z = true;
            if (editable.length() < this.f33038h.length()) {
                z = false;
            }
            String a = m25119a(editable.toString());
            int selectionEnd = this.f33037g.getSelectionEnd();
            if (z) {
                selectionEnd = (selectionEnd + a.length()) - this.f33037g.getText().length();
            }
            int min = Math.min(a.length(), Math.max(0, selectionEnd));
            this.f33037g.setText(a);
            this.f33037g.setSelection(min);
        }
    }

    /* renamed from: a */
    private String m25119a(String str) {
        if (str == null) {
            return "";
        }
        String replace = str.replace(" ", "").replace(".", "").replace("-", "");
        if (replace.length() > 11) {
            replace = replace.substring(0, 11);
        }
        StringBuilder sb = new StringBuilder(replace);
        m25120a(sb, 3, '.');
        m25120a(sb, 7, '.');
        m25120a(sb, 11, f33033c);
        return sb.toString();
    }

    /* renamed from: a */
    private void m25120a(StringBuilder sb, int i, char c) {
        if (sb.length() == i) {
            sb.insert(i, c);
        }
        if (sb.length() > i && sb.charAt(i) != c) {
            sb.insert(i, c);
        }
    }
}
