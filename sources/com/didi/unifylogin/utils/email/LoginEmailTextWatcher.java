package com.didi.unifylogin.utils.email;

import android.text.Editable;
import android.widget.Button;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;

public class LoginEmailTextWatcher extends LoginTextWatcher {

    /* renamed from: a */
    Button f47658a;

    public LoginEmailTextWatcher(Button button) {
        this.f47658a = button;
    }

    public void afterTextChanged(Editable editable) {
        setButtonEnabled(editable.toString());
    }

    public void setButtonEnabled(String str) {
        Button button = this.f47658a;
        if (button != null) {
            button.setEnabled(EmailUtils.isEmail(str));
        }
    }
}
