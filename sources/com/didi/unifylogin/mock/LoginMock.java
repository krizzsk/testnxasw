package com.didi.unifylogin.mock;

import com.didi.unifylogin.base.net.LoginNet;

public class LoginMock {
    public static boolean IS_MOCK = false;

    /* renamed from: a */
    private static LoginNet f47481a;

    public static LoginNet getNetBiz() {
        return f47481a;
    }

    public static void setNetBiz(LoginNet loginNet) {
        f47481a = loginNet;
    }
}
