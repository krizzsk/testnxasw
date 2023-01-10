package com.google.android.play.core.internal;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.Signature;
import android.os.Build;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.play.core.splitcompat.C20164p;

/* renamed from: com.google.android.play.core.internal.bz */
public final class C20076bz {

    /* renamed from: a */
    private static final C20030ag f56100a = new C20030ag("PhoneskyVerificationUtils");

    /* renamed from: a */
    public static boolean m42267a(Context context) {
        try {
            Signature[] signatureArr = SystemUtils.getPackageInfo(context.getPackageManager(), "com.android.vending", 64).signatures;
            if (signatureArr == null || (r1 = signatureArr.length) == 0) {
                f56100a.mo164271d("Phonesky package is not signed -- possibly self-built package. Could not verify.", new Object[0]);
                return false;
            }
            for (Signature byteArray : signatureArr) {
                String a = C20164p.m42451a(byteArray.toByteArray());
                if ("8P1sW0EPJcslw7UzRsiXL64w-O50Ed-RBICtay1g24M".equals(a)) {
                    return true;
                }
                if ((Build.TAGS.contains("dev-keys") || Build.TAGS.contains("test-keys")) && "GXWy8XF3vIml3_MfnmSmyuKBpT3B0dWbHRR_4cgq-gA".equals(a)) {
                    return true;
                }
            }
            return false;
        } catch (PackageManager.NameNotFoundException unused) {
        }
    }
}
