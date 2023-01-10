package com.didi.sdk.apm.ext;

import android.util.Log;

public class AndroidPrintStream extends LoggingPrintStream {

    /* renamed from: a */
    private final int f37785a;

    /* renamed from: b */
    private final String f37786b;

    public AndroidPrintStream(int i, String str) {
        if (str != null) {
            this.f37785a = i;
            this.f37786b = str;
            return;
        }
        throw new NullPointerException("tag");
    }

    /* access modifiers changed from: protected */
    public void log(String str) {
        Log.println(this.f37785a, this.f37786b, str);
    }
}
