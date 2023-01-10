package com.didi.soda.customer.foundation.util;

import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IOneSdkService;

public final class ToastUtil {

    /* renamed from: a */
    private static FrameLayout f43856a;

    public enum Type {
        SUCCESS,
        ERROR,
        NORMAL
    }

    private ToastUtil() {
    }

    public static void showCustomerToast(ScopeContext scopeContext, String str) {
        m32712a(scopeContext, str, Type.NORMAL);
    }

    public static void showCustomerSuccessToast(ScopeContext scopeContext, String str) {
        m32712a(scopeContext, str, Type.SUCCESS);
    }

    public static void showCustomerErrorToast(ScopeContext scopeContext, String str) {
        m32712a(scopeContext, str, Type.ERROR);
    }

    public static void bindToastContainer(FrameLayout frameLayout) {
        f43856a = frameLayout;
    }

    /* renamed from: a */
    private static void m32712a(ScopeContext scopeContext, String str, Type type) {
        new CustomerToastHelper(f43856a).showCustomerToast(scopeContext, str, type);
    }

    public static void makeText(String str) {
        ((IOneSdkService) CustomerServiceManager.getService(IOneSdkService.class)).toast(str);
    }
}
