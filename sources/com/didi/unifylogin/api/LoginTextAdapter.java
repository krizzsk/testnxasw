package com.didi.unifylogin.api;

import android.content.Context;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.utils.phone.PhoneUtils;

public class LoginTextAdapter {
    private FragmentMessenger messenger;

    public DialogText getResPwdWarnDialog(Context context) {
        return null;
    }

    public String getSetPwdSubTitle(Context context) {
        return null;
    }

    public String getInputPhoneSubTitle(Context context) {
        return LoginThirdApi.m35200b();
    }

    public String getThirdPartyTitlebar(Context context) {
        return LoginThirdApi.m35201c();
    }

    public String getInputNewPhoneTitle(Context context) {
        return LoginThirdApi.m35202d();
    }

    public String getInputNewPhoneSubTitle(Context context) {
        return LoginThirdApi.m35203e();
    }

    public String getInputCodeTitle(Context context) {
        return LoginThirdApi.m35204f();
    }

    public String getInputNewPhoneTel(Context context) {
        return LoginThirdApi.m35198a();
    }

    public static class DialogText {
        public String msg;
        public String negativeBtnTxt;
        public String positiveBtnTxt;
        public String title;

        public DialogText(String str, String str2, String str3, String str4) {
            this.title = str;
            this.msg = str2;
            this.positiveBtnTxt = str3;
            this.negativeBtnTxt = str4;
        }
    }

    public final void setMessage(FragmentMessenger fragmentMessenger) {
        this.messenger = fragmentMessenger;
    }

    /* access modifiers changed from: protected */
    public final String getCell() {
        return this.messenger.getCell();
    }

    /* access modifiers changed from: protected */
    public final String getHideCell() {
        return PhoneUtils.hideMiddleDigital(this.messenger.getCell());
    }
}
