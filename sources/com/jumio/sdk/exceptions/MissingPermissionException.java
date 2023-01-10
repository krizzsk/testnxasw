package com.jumio.sdk.exceptions;

import java.util.Arrays;

public class MissingPermissionException extends Exception {

    /* renamed from: a */
    public String[] f57936a;

    public MissingPermissionException(String[] strArr) {
        super(m43864a(strArr));
        this.f57936a = (String[]) Arrays.copyOf(strArr, strArr.length);
    }

    /* renamed from: a */
    public static String m43864a(String[] strArr) {
        StringBuilder sb = new StringBuilder("On devices running Android Marshmallow (6.0) you need to acquire the following permissions dynamically before starting the SDK: ");
        for (String append : strArr) {
            sb.append(append);
            sb.append("\n");
        }
        sb.append("On any other API level permissions must be declared in the AndroidManifest. More information about that can be found here: https://developer.android.com/training/permissions/requesting.html");
        return sb.toString();
    }

    public String[] getPermissions() {
        return this.f57936a;
    }

    public MissingPermissionException(String str) {
        this(new String[]{str});
        this.f57936a = new String[]{str};
    }
}
