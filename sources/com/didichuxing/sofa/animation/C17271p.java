package com.didichuxing.sofa.animation;

import android.view.View;
import com.didi.soda.customer.p165h5.hybird.model.GuideParamModel;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.lang.reflect.Method;
import rui.config.RConfigConstants;

/* renamed from: com.didichuxing.sofa.animation.p */
/* compiled from: FakeAnimatorHelper */
final class C17271p {

    /* renamed from: a */
    private static final String f51678a = "FakeAnimatorHelper";

    private C17271p() {
    }

    /* renamed from: a */
    private static String m38803a(String str, String str2) {
        if (str2 == null || str2.length() == 0) {
            return str;
        }
        char upperCase = Character.toUpperCase(str2.charAt(0));
        String substring = str2.substring(1);
        return str + upperCase + substring;
    }

    /* renamed from: a */
    private static Method m38804a(Class<? extends View> cls, String str, Class cls2) {
        Method method;
        try {
            method = cls.getMethod(str, new Class[]{cls2});
        } catch (NoSuchMethodException e) {
            LoggerUtil.m38757d(f51678a, "getPropertyFunction e: " + e);
            method = null;
        }
        if (method == null) {
            LoggerUtil.m38757d(f51678a, "Method " + str + "() with type " + cls2 + " not found on target class " + cls);
        }
        return method;
    }

    /* renamed from: a */
    static void m38805a(View view, String str, float f) {
        Class<?> cls = view.getClass();
        String a = m38803a(GuideParamModel.ACTION_SET, str);
        String str2 = Const.jaLeft + cls.getName() + RConfigConstants.KEYWORD_COLOR_SIGN + a + "(" + Float.TYPE.getName() + ")]";
        LoggerUtil.m38757d(f51678a, "invokeCustomSetter " + str2);
        Method a2 = m38804a((Class<? extends View>) cls, a, Float.TYPE);
        if (a2 != null) {
            try {
                a2.invoke(view, new Object[]{Float.valueOf(f)});
            } catch (Exception e) {
                LoggerUtil.m38757d(f51678a, "invokeCustomSetter e: " + e);
            }
        } else {
            LoggerUtil.m38757d(f51678a, "invokeCustomSetter " + str2 + " failed because of null setter");
        }
    }
}
