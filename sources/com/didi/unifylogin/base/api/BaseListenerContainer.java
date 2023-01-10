package com.didi.unifylogin.base.api;

import com.didi.unifylogin.base.log.LogListener;
import com.didi.unifylogin.base.net.LoginNetModeListener;
import com.didi.unifylogin.base.net.LoginNetParamListener;

public class BaseListenerContainer {

    /* renamed from: a */
    private static LoginNetParamListener f47331a;

    /* renamed from: b */
    private static LogListener f47332b;

    /* renamed from: c */
    private static LoginNetModeListener f47333c;

    public static LoginNetParamListener getNetParamListener() {
        return f47331a;
    }

    public static void setNetParamListener(LoginNetParamListener loginNetParamListener) {
        f47331a = loginNetParamListener;
    }

    public static LogListener getLogListener() {
        return f47332b;
    }

    public static void setLogListener(LogListener logListener) {
        f47332b = logListener;
    }

    public static LoginNetModeListener getNetModeListener() {
        return f47333c;
    }

    public static void setNetModeListener(LoginNetModeListener loginNetModeListener) {
        f47333c = loginNetModeListener;
    }
}
