package com.didi.dimina.container.secondparty.permission.checker;

import android.content.Context;
import android.os.Build;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;

public final class StrictChecker implements PermissionChecker {
    public boolean hasPermission(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        for (String a : strArr) {
            if (!m16330a(context, a)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasPermission(Context context, List<String> list) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        for (String a : list) {
            if (!m16330a(context, a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m16330a(Context context, String str) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -1888586689:
                    if (str.equals(Permission.ACCESS_FINE_LOCATION)) {
                        c = 3;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals(Permission.ACCESS_COARSE_LOCATION)) {
                        c = 2;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals(Permission.CAMERA)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals(Permission.RECORD_AUDIO)) {
                        c = 4;
                        break;
                    }
                    break;
                case 1977429404:
                    if (str.equals(Permission.READ_CONTACTS)) {
                        c = 1;
                        break;
                    }
                    break;
            }
            if (c == 1) {
                return m16333d(context);
            }
            if (c == 2) {
                return m16329a(context);
            }
            if (c == 3) {
                return m16331b(context);
            }
            if (c != 4) {
                return true;
            }
            return m16332c(context);
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m16329a(Context context) throws Throwable {
        return new C8196b(context).mo60862a();
    }

    /* renamed from: b */
    private static boolean m16331b(Context context) throws Throwable {
        return new C8197c(context).mo60862a();
    }

    /* renamed from: c */
    private static boolean m16332c(Context context) throws Throwable {
        return new C8198d(context).mo60862a();
    }

    /* renamed from: d */
    private static boolean m16333d(Context context) throws Throwable {
        return new C8195a(context).mo60862a();
    }
}
