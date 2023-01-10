package com.didi.unifylogin.utils.phone;

import android.text.Editable;
import android.widget.Button;
import android.widget.EditText;
import com.didi.sdk.util.TextUtil;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didichuxing.drtl.tookit.DRtlToolkit;

public class LoginPhoneTextWatcher extends LoginTextWatcher {

    /* renamed from: a */
    Button f47659a;

    /* renamed from: b */
    boolean f47660b = false;

    /* renamed from: c */
    private EditText f47661c;

    /* renamed from: d */
    private boolean f47662d = true;

    public LoginPhoneTextWatcher(Button button) {
        this.f47659a = button;
    }

    public LoginPhoneTextWatcher(Button button, EditText editText) {
        this.f47659a = button;
        this.f47661c = editText;
    }

    public void afterTextChanged(Editable editable) {
        String obj = editable.toString();
        setButtonEnabled(obj);
        String specialPhone = PhoneUtils.toSpecialPhone(obj);
        if (!specialPhone.equals(obj) && !this.f47660b) {
            this.f47660b = true;
            editable.replace(0, editable.length(), specialPhone, 0, specialPhone.length());
            this.f47660b = false;
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        super.onTextChanged(charSequence, i, i2, i3);
        if (DRtlToolkit.rtl()) {
            try {
                if (!this.f47662d) {
                    if (this.f47661c.getSelectionStart() == 4) {
                        this.f47661c.setSelection(5);
                    }
                    if (this.f47661c.getSelectionStart() == 8) {
                        this.f47661c.setSelection(9);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public void setButtonEnabled(String str) {
        String normalPhone = PhoneUtils.toNormalPhone(str);
        if (this.f47659a != null) {
            if (TextUtil.isEmpty(normalPhone) || !PhoneUtils.isNum(normalPhone)) {
                this.f47659a.setEnabled(false);
            } else {
                this.f47659a.setEnabled(true);
            }
        }
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (!DRtlToolkit.rtl()) {
            return;
        }
        if (i3 == 0) {
            try {
                this.f47662d = true;
            } catch (Exception e) {
                e.printStackTrace();
            }
        } else if (this.f47661c.getSelectionStart() == 4 && i3 == i2) {
            this.f47662d = true;
        } else {
            this.f47662d = false;
        }
    }
}
