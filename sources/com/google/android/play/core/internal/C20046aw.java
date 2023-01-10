package com.google.android.play.core.internal;

import android.os.Build;
import java.io.File;

/* renamed from: com.google.android.play.core.internal.aw */
public final class C20046aw {
    /* renamed from: a */
    public static C20045av m42170a() {
        if (Build.VERSION.SDK_INT >= 21) {
            switch (Build.VERSION.SDK_INT) {
                case 21:
                    return new C20052bb();
                case 22:
                    return new C20053bc();
                case 23:
                    return new C20057bg();
                case 24:
                    return new C20058bh();
                case 25:
                    return new C20059bi();
                case 26:
                    return new C20062bl();
                case 27:
                    if (Build.VERSION.PREVIEW_SDK_INT == 0) {
                        return new C20063bm();
                    }
                    break;
            }
            return new C20065bo();
        }
        throw new AssertionError("Unsupported Android Version");
    }

    /* renamed from: a */
    public static String m42171a(File file) {
        if (file.getName().endsWith(".apk")) {
            String str = "";
            String replaceFirst = file.getName().replaceFirst("(_\\d+)?\\.apk", str);
            if (replaceFirst.equals("base-master")) {
                return str;
            }
            String str2 = "base-";
            if (replaceFirst.startsWith(str2)) {
                str = "config.";
            } else {
                replaceFirst = replaceFirst.replace("-", ".config.");
                str2 = ".config.master";
            }
            return replaceFirst.replace(str2, str);
        }
        throw new IllegalArgumentException("Non-apk found in splits directory.");
    }

    /* renamed from: a */
    public static <T> void m42172a(T t, Object obj) {
        if (t == null) {
            throw new NullPointerException((String) obj);
        }
    }

    /* renamed from: a */
    public static void m42173a(boolean z, Object obj) {
        if (!z) {
            throw new IllegalStateException(String.valueOf(obj));
        }
    }
}
