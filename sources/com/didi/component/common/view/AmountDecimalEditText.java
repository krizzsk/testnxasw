package com.didi.component.common.view;

import android.content.Context;
import android.text.Editable;
import android.text.InputFilter;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.widget.EditText;
import androidx.appcompat.widget.AppCompatEditText;
import com.global.didi.elvish.Elvish;
import java.util.StringTokenizer;

public class AmountDecimalEditText extends AppCompatEditText {

    /* renamed from: a */
    private static final int f13646a = 13;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public int f13647b = 2;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f13648c = "";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public String f13649d = ".";
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f13650e = true;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public CustomizedAfterTextChangeListener f13651f;

    public interface CustomizedAfterTextChangeListener {
        void afterTextChanged(String str);
    }

    /* renamed from: a */
    private boolean m11391a(int i) {
        return i >= 0 && i <= 10;
    }

    public void setCustomizedAfterTextChangeListener(CustomizedAfterTextChangeListener customizedAfterTextChangeListener) {
        this.f13651f = customizedAfterTextChangeListener;
    }

    public AmountDecimalEditText(Context context) {
        super(context);
        m11393b();
    }

    public AmountDecimalEditText(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11393b();
    }

    public AmountDecimalEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m11393b();
    }

    public void setAllowZero(boolean z) {
        this.f13650e = z;
    }

    /* renamed from: a */
    private void m11390a() {
        StringBuilder sb = new StringBuilder("0");
        if (m11391a(this.f13647b)) {
            if (this.f13647b > 0) {
                sb.append(this.f13649d);
            }
            for (int i = this.f13647b; i > 0; i--) {
                sb.append("0");
            }
        }
    }

    /* renamed from: b */
    private void m11393b() {
        int numberPrecision = Elvish.Companion.getInstance().getNumberPrecision(1);
        if (m11391a(numberPrecision)) {
            this.f13647b = numberPrecision;
        }
        String decimalSymbol = Elvish.Companion.getInstance().getDecimalSymbol();
        if (!TextUtils.isEmpty(decimalSymbol)) {
            this.f13649d = decimalSymbol;
        }
        String groupSymbol = Elvish.Companion.getInstance().getGroupSymbol();
        if (groupSymbol != null && !this.f13649d.equals(groupSymbol)) {
            this.f13648c = groupSymbol;
        }
        setImeOptions(6);
        m11390a();
        if (this.f13647b <= 0) {
            setKeyListener(DigitsKeyListener.getInstance("0123456789"));
        } else {
            setKeyListener(DigitsKeyListener.getInstance("0123456789" + this.f13649d));
        }
        setFilters(new InputFilter[]{new InputFilter() {
            public CharSequence filter(CharSequence charSequence, int i, int i2, Spanned spanned, int i3, int i4) {
                String obj = spanned != null ? spanned.toString() : "";
                if (AmountDecimalEditText.this.f13647b == 0 && charSequence != null && charSequence.equals(AmountDecimalEditText.this.f13649d)) {
                    return "";
                }
                if (charSequence != null && charSequence.equals(AmountDecimalEditText.this.f13649d) && obj.length() == 0) {
                    return "0" + AmountDecimalEditText.this.f13649d;
                } else if (!obj.contains(AmountDecimalEditText.this.f13649d) || i4 - obj.indexOf(AmountDecimalEditText.this.f13649d) < AmountDecimalEditText.this.f13647b + 1) {
                    return null;
                } else {
                    return "";
                }
            }
        }, new InputFilter.LengthFilter(13)});
        addTextChangedListener(new NumberTextWatcherForThousand(this));
    }

    public int getDecimalNumber() {
        return this.f13647b;
    }

    public void setDecimalNumber(int i) {
        if (m11391a(i)) {
            this.f13647b = i;
            m11390a();
        }
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
            String editTextString = getEditTextString(this.editText);
            try {
                this.editText.removeTextChangedListener(this);
                if (editTextString != null && !editTextString.equals("")) {
                    if (editTextString.startsWith(AmountDecimalEditText.this.f13649d)) {
                        EditText editText2 = this.editText;
                        editText2.setText("0" + AmountDecimalEditText.this.f13649d);
                    }
                    if (editTextString.startsWith("0")) {
                        if (!editTextString.startsWith("0" + AmountDecimalEditText.this.f13649d)) {
                            if (!AmountDecimalEditText.this.f13650e) {
                                this.editText.setText("");
                            } else {
                                this.editText.setText("0");
                            }
                        }
                    }
                    this.editText.setText(getDecimalFormat(getEditTextString(this.editText).replace(AmountDecimalEditText.this.f13648c, "")));
                    this.editText.setSelection(getEditTextString(this.editText).length());
                }
                this.editText.addTextChangedListener(this);
            } catch (Exception e) {
                e.printStackTrace();
                this.editText.addTextChangedListener(this);
            }
            String editTextString2 = getEditTextString(this.editText);
            if (AmountDecimalEditText.this.f13651f != null) {
                AmountDecimalEditText.this.f13651f.afterTextChanged(editTextString2);
            }
            if (editTextString2.contains(AmountDecimalEditText.this.f13649d) || AmountDecimalEditText.this.f13647b <= 0) {
                this.editText.setKeyListener(DigitsKeyListener.getInstance("0123456789"));
                return;
            }
            EditText editText3 = this.editText;
            editText3.setKeyListener(DigitsKeyListener.getInstance("0123456789" + AmountDecimalEditText.this.f13649d));
        }

        private String getEditTextString(EditText editText2) {
            Editable text = editText2 != null ? editText2.getText() : null;
            return text != null ? text.toString() : "";
        }

        public String getDecimalFormat(String str) {
            String str2;
            StringTokenizer stringTokenizer = new StringTokenizer(str, AmountDecimalEditText.this.f13649d);
            if (stringTokenizer.countTokens() > 1) {
                str = stringTokenizer.nextToken();
                str2 = stringTokenizer.nextToken();
            } else {
                str2 = "";
            }
            StringBuilder sb = new StringBuilder();
            int length = str.length() - 1;
            if (str.charAt(str.length() - 1) == AmountDecimalEditText.this.f13649d.charAt(0)) {
                length--;
                sb = new StringBuilder(AmountDecimalEditText.this.f13649d);
            }
            int i = 0;
            while (length >= 0) {
                if (i == 3) {
                    sb.insert(0, AmountDecimalEditText.this.f13648c);
                    i = 0;
                }
                sb.insert(0, str.charAt(length));
                i++;
                length--;
            }
            if (AmountDecimalEditText.this.f13647b > 0 && str2 != null && str2.length() > 0) {
                if (str2.length() <= AmountDecimalEditText.this.f13647b) {
                    sb.append(AmountDecimalEditText.this.f13649d);
                    sb.append(str2);
                } else {
                    sb.append(AmountDecimalEditText.this.f13649d);
                    sb.append(str2.substring(0, AmountDecimalEditText.this.f13647b));
                }
            }
            return sb.toString();
        }
    }
}
