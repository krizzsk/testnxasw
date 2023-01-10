package com.didi.unifylogin.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import com.didi.unifylogin.utils.phone.PhoneUtils;

public class CPFWatcher implements TextWatcher {

    /* renamed from: a */
    private static final int f47565a = 14;

    /* renamed from: b */
    private static final char f47566b = '.';

    /* renamed from: c */
    private static final char f47567c = '-';

    /* renamed from: d */
    private static final int f47568d = 3;

    /* renamed from: e */
    private static final int f47569e = 7;

    /* renamed from: f */
    private static final int f47570f = 11;

    /* renamed from: g */
    private EditText f47571g;

    /* renamed from: h */
    private Button f47572h;

    /* renamed from: i */
    private TextView f47573i;

    /* renamed from: j */
    private String f47574j;

    /* renamed from: k */
    private boolean f47575k;

    public CPFWatcher(EditText editText, Button button, TextView textView) {
        this.f47571g = editText;
        this.f47572h = button;
        this.f47573i = textView;
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        this.f47574j = charSequence.toString();
        if (this.f47573i.getVisibility() != 0) {
            this.f47573i.setVisibility(0);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        int length = this.f47571g.getText().length();
        if (length > 14) {
            this.f47571g.getText().delete(14, length);
        } else if (length < this.f47574j.length()) {
            String str = this.f47574j;
            char charAt = str.charAt(str.length() - 1);
            if (charAt == '.' || charAt == '-') {
                this.f47571g.getText().delete(length - 1, length);
            }
        }
        if (this.f47575k) {
            this.f47575k = false;
        } else {
            this.f47575k = true;
        }
    }

    public void afterTextChanged(Editable editable) {
        if (this.f47575k) {
            boolean z = editable.length() >= this.f47574j.length();
            if (PhoneUtils.isNum(CommonUtils.deleteNonNum(editable.toString()))) {
                this.f47572h.setEnabled(true);
            } else {
                this.f47572h.setEnabled(false);
            }
            String a = m35694a(editable.toString());
            int selectionEnd = this.f47571g.getSelectionEnd();
            if (z) {
                selectionEnd = (selectionEnd + a.length()) - this.f47571g.getText().length();
            }
            int min = Math.min(a.length(), Math.max(0, selectionEnd));
            this.f47571g.setText(a);
            this.f47571g.setSelection(min);
        }
    }

    /* renamed from: a */
    private String m35694a(String str) {
        if (str == null) {
            return "";
        }
        String deleteNonNum = CommonUtils.deleteNonNum(str);
        if (deleteNonNum.length() > 11) {
            deleteNonNum = deleteNonNum.substring(0, 11);
        }
        StringBuilder sb = new StringBuilder(deleteNonNum);
        m35695a(sb, 3, '.');
        m35695a(sb, 7, '.');
        m35695a(sb, 11, f47567c);
        return sb.toString();
    }

    /* renamed from: a */
    private void m35695a(StringBuilder sb, int i, char c) {
        if (sb.length() == i) {
            sb.insert(i, c);
        }
        if (sb.length() > i && sb.charAt(i) != c) {
            sb.insert(i, c);
        }
    }
}
