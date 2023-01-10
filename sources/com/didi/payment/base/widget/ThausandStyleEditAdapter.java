package com.didi.payment.base.widget;

import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.widget.EditText;
import com.didi.payment.base.widget.CommonEditText;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;

public class ThausandStyleEditAdapter extends CommonEditText.EditStyleAdapter {

    /* renamed from: c */
    private static String f32601c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f32602d;

    /* renamed from: a */
    private int f32603a = 13;

    /* renamed from: b */
    private int f32604b = 2;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public int f32605e = 2;

    public ThausandStyleEditAdapter() {
    }

    public ThausandStyleEditAdapter(int i, int i2) {
        if (i > 0) {
            this.f32603a = i;
        }
        if (i2 >= 0) {
            this.f32604b = i2;
        }
    }

    public void init() {
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"))).getDecimalFormatSymbols();
        f32601c = Character.toString(decimalFormatSymbols.getGroupingSeparator());
        f32602d = Character.toString(decimalFormatSymbols.getDecimalSeparator());
    }

    public int getDecimalNumber() {
        return this.f32605e;
    }

    public void setDecimalNumber(int i) {
        this.f32605e = i;
    }

    public String trimStringToNormalDecimalFormat(String str) {
        String replaceAll = str.replaceAll("\\" + f32601c, "");
        return replaceAll.replaceAll("\\" + f32602d, "\\.");
    }

    public TextWatcher getWatcher() {
        return new CommonEditText.NumberTextWatcherForThousand(this.mEdittext, f32602d, f32601c);
    }

    /* access modifiers changed from: protected */
    public void bindEditText(EditText editText) {
        super.bindEditText(editText);
        this.mEdittext.setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                String obj = spanned.toString();
                if (ThausandStyleEditAdapter.this.f32605e == 0 && charSequence.equals(ThausandStyleEditAdapter.f32602d)) {
                    return "";
                }
                if (charSequence.equals(ThausandStyleEditAdapter.f32602d) && obj.length() == 0) {
                    return "0" + ThausandStyleEditAdapter.f32602d;
                } else if (!obj.contains(ThausandStyleEditAdapter.f32602d) || i4 - obj.indexOf(ThausandStyleEditAdapter.f32602d) < ThausandStyleEditAdapter.this.f32605e + 1) {
                    return null;
                } else {
                    return "";
                }
            }
        }, new InputFilter.LengthFilter(this.f32603a)});
    }
}
