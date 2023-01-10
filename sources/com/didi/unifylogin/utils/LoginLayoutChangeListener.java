package com.didi.unifylogin.utils;

import android.content.Context;
import android.view.View;
import android.widget.ScrollView;
import com.didi.sdk.util.UiThreadHandler;

public class LoginLayoutChangeListener implements View.OnLayoutChangeListener {

    /* renamed from: a */
    private static final String f47588a = "LoginLayoutChangeListener";

    /* renamed from: b */
    private int f47589b = 0;

    /* renamed from: c */
    private int f47590c = 0;

    /* renamed from: d */
    private Context f47591d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ScrollView f47592e;

    public LoginLayoutChangeListener(Context context, ScrollView scrollView, int i) {
        this.f47591d = context;
        this.f47592e = scrollView;
        this.f47589b = i;
        this.f47590c = i / 3;
    }

    public void onLayoutChange(View view, int i, int i2, int i3, final int i4, int i5, int i6, int i7, final int i8) {
        if (i8 != 0 && i4 != 0 && i8 - i4 > this.f47590c && this.f47592e != null) {
            LoginLog.write("LoginLayoutChangeListener: scrollTo " + i8 + "-" + i4);
            UiThreadHandler.postDelayed(new Runnable() {
                public void run() {
                    LoginLayoutChangeListener.this.f47592e.scrollTo(0, i8 - i4);
                }
            }, 100);
        }
    }
}
