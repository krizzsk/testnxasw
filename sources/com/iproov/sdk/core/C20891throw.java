package com.iproov.sdk.core;

import android.content.Context;
import android.os.Build;

/* renamed from: com.iproov.sdk.core.throw */
/* compiled from: NonDeterministicSecurity */
public class C20891throw {

    /* renamed from: do */
    public static int f57187do;

    public C20891throw(Context context) {
        m43451a(context);
        m43450a();
    }

    /* renamed from: a */
    private void m43451a(Context context) {
        C20781b.m43065a(C20888super.AND20, (Object) Boolean.FALSE);
        C20781b.m43065a(C20888super.AND21, (Object) Integer.valueOf(f57187do));
    }

    /* renamed from: a */
    private void m43450a() {
        C20781b.m43065a(C20888super.AND22, (Object) Build.BOARD);
        C20781b.m43065a(C20888super.AND23, (Object) Build.BOOTLOADER);
        C20781b.m43065a(C20888super.AND24, (Object) Build.BRAND);
        C20781b.m43065a(C20888super.AND25, (Object) Build.CPU_ABI);
        C20781b.m43065a(C20888super.AND26, (Object) Build.CPU_ABI2);
        C20781b.m43065a(C20888super.AND27, (Object) Build.HOST);
        C20781b.m43065a(C20888super.AND28, (Object) Build.DEVICE);
        C20781b.m43065a(C20888super.AND29, (Object) Build.HARDWARE);
        C20781b.m43065a(C20888super.AND30, (Object) Build.MANUFACTURER);
        C20781b.m43065a(C20888super.AND31, (Object) Build.MODEL);
        C20781b.m43065a(C20888super.AND32, (Object) Build.PRODUCT);
    }
}
