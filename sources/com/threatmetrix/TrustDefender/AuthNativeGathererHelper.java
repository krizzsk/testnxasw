package com.threatmetrix.TrustDefender;

import android.content.ContentResolver;
import android.content.Context;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class AuthNativeGathererHelper {
    public static int b006C006Cl006Cl006C = 2;
    public static int bl006Cl006Cl006C = 1;

    public static int b006Cll006Cl006C() {
        return 0;
    }

    public static int blll006Cl006C() {
        return 24;
    }

    @Nonnull
    public native String[] attestStrongID(String str, String str2, Context context, int i);

    public boolean b006Aj006A006Aj006A(String str, String str2) throws UnsatisfiedLinkError {
        if (((blll006Cl006C() + bl006Cl006Cl006C) * blll006Cl006C()) % b006C006Cl006Cl006C != b006Cll006Cl006C()) {
            bl006Cl006Cl006C = 43;
        }
        System.loadLibrary(str);
        return init(str2);
    }

    public native int cancel();

    public native long getTamperCode(int i);

    public native boolean init(String str);

    @Nullable
    public native String sha256HexEncode(byte[] bArr);

    @Nullable
    public native byte[] sign(byte[] bArr, ContentResolver contentResolver);
}
