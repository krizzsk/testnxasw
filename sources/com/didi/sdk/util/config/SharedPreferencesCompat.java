package com.didi.sdk.util.config;

import android.content.SharedPreferences;
import com.didi.payment.wallet.global.prepaidcard.PrepaidConstant;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class SharedPreferencesCompat {

    /* renamed from: a */
    private static Method f40447a;

    static {
        try {
            f40447a = SharedPreferences.Editor.class.getMethod(PrepaidConstant.SCENE_APPLY, new Class[0]);
        } catch (NoSuchMethodException unused) {
            f40447a = null;
        }
    }

    public static void apply(SharedPreferences.Editor editor) {
        Method method = f40447a;
        if (method != null) {
            try {
                method.invoke(editor, new Object[0]);
                return;
            } catch (IllegalAccessException | InvocationTargetException unused) {
            }
        }
        editor.commit();
    }
}
