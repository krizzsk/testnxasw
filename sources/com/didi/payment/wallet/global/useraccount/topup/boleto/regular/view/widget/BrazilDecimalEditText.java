package com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.widget;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.payment.wallet.global.useraccount.topup.boleto.regular.view.activities.WalletBoletoCashinActivity;
import com.taxis99.R;
import java.text.DecimalFormat;
import java.text.DecimalFormatSymbols;
import java.util.Locale;
import java.util.StringTokenizer;

public class BrazilDecimalEditText extends AppCompatEditText {

    /* renamed from: a */
    private static final int f34536a = 13;

    /* renamed from: b */
    private static final int f34537b = 2;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static String f34538d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static String f34539e;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f34540c;

    public BrazilDecimalEditText(Context context) {
        this(context, (AttributeSet) null, R.attr.editTextStyle);
    }

    public BrazilDecimalEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public BrazilDecimalEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34540c = 2;
        m26332c();
    }

    /* renamed from: c */
    private void m26332c() {
        DecimalFormatSymbols decimalFormatSymbols = ((DecimalFormat) DecimalFormat.getInstance(new Locale("pt", "BR"))).getDecimalFormatSymbols();
        f34538d = Character.toString(decimalFormatSymbols.getGroupingSeparator());
        f34539e = Character.toString(decimalFormatSymbols.getDecimalSeparator());
        setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                String obj = spanned.toString();
                if (BrazilDecimalEditText.this.f34540c == 0 && charSequence.equals(BrazilDecimalEditText.f34539e)) {
                    return "";
                }
                if (charSequence.equals(BrazilDecimalEditText.f34539e) && obj.length() == 0) {
                    return "0" + BrazilDecimalEditText.f34539e;
                } else if (!obj.contains(BrazilDecimalEditText.f34539e) || i4 - obj.indexOf(BrazilDecimalEditText.f34539e) < BrazilDecimalEditText.this.f34540c + 1) {
                    return null;
                } else {
                    return "";
                }
            }
        }, new InputFilter.LengthFilter(13)});
        addTextChangedListener(new NumberTextWatcherForThousand(this));
    }

    public int getDecimalNumber() {
        return this.f34540c;
    }

    public void setDecimalNumber(int i) {
        this.f34540c = i;
    }

    public static String trimStringToNormalDecimalFormat(String str) {
        String replaceAll = str.replaceAll("\\" + f34538d, "");
        return replaceAll.replaceAll("\\" + f34539e, "\\.");
    }

    class NumberTextWatcherForThousand implements TextWatcher {
        EditText editText;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public NumberTextWatcherForThousand(EditText editText2) {
            this.editText = editText2;
        }

        public void afterTextChanged(Editable editable) {
            try {
                this.editText.removeTextChangedListener(this);
                String obj = this.editText.getText().toString();
                if (!obj.equals("")) {
                    if (obj.startsWith(BrazilDecimalEditText.f34539e)) {
                        EditText editText2 = this.editText;
                        editText2.setText("0" + BrazilDecimalEditText.f34539e);
                    }
                    if (obj.startsWith("0")) {
                        if (!obj.startsWith("0" + BrazilDecimalEditText.f34539e)) {
                            this.editText.setText("");
                        }
                    }
                    this.editText.setText(getDecimalFormat(this.editText.getText().toString().replaceAll("\\" + BrazilDecimalEditText.f34538d, "")));
                    this.editText.setSelection(this.editText.getText().toString().length());
                }
                this.editText.addTextChangedListener(this);
            } catch (Exception e) {
                e.printStackTrace();
                this.editText.addTextChangedListener(this);
            }
            if (editable.toString().contains(BrazilDecimalEditText.f34539e)) {
                this.editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
            } else {
                EditText editText3 = this.editText;
                editText3.setKeyListener(DigitsKeyListener.getInstance("0123456789" + BrazilDecimalEditText.f34539e));
            }
            if (BrazilDecimalEditText.this.getContext() instanceof WalletBoletoCashinActivity) {
                ((WalletBoletoCashinActivity) BrazilDecimalEditText.this.getContext()).updateUIAfterEditTextChanged();
            }
        }

        public String getDecimalFormat(String str) {
            String str2;
            StringTokenizer stringTokenizer = new StringTokenizer(str, BrazilDecimalEditText.f34539e);
            if (stringTokenizer.countTokens() > 1) {
                str = stringTokenizer.nextToken();
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length() - 1;
            if (str.charAt(str.length() - 1) == BrazilDecimalEditText.f34539e.charAt(0)) {
                length--;
                sb = new StringBuilder(BrazilDecimalEditText.f34539e);
            }
            int i = 0;
            while (length >= 0) {
                if (i == 3) {
                    sb.insert(0, BrazilDecimalEditText.f34538d);
                    i = 0;
                }
                sb.insert(0, str.charAt(length));
                i++;
                length--;
            }
            if (str2.length() > 0) {
                sb.append(BrazilDecimalEditText.f34539e);
                sb.append(str2);
            }
            return sb.toString();
        }
    }
}
