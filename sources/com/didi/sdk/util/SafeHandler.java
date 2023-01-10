package com.didi.sdk.util;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import androidx.fragment.app.Fragment;
import com.didi.sdk.log.Logger;
import com.didi.sdk.log.Printer;

public class SafeHandler extends Handler {

    /* renamed from: a */
    private Fragment f40400a;

    public SafeHandler(Fragment fragment) {
        this.f40400a = fragment;
    }

    public SafeHandler(Fragment fragment, Looper looper) {
        super(looper);
        this.f40400a = fragment;
    }

    public void dispatchMessage(Message message) {
        if (!this.f40400a.isAdded()) {
            Printer t = Logger.m29541t("SafeHandler");
            t.mo98894e("fragment is not add +" + message, new Object[0]);
            return;
        }
        super.dispatchMessage(message);
    }
}
