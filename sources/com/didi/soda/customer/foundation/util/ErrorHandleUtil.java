package com.didi.soda.customer.foundation.util;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;

public final class ErrorHandleUtil {

    /* renamed from: a */
    private static final String f43832a = "ErrorHandleUtil";

    /* renamed from: b */
    private static ErrorHandleListener f43833b;

    public interface ErrorHandleListener {
        void onErrorHandle(SFRpcException sFRpcException);
    }

    private ErrorHandleUtil() {
    }

    public static void setErrorHandleListener(ErrorHandleListener errorHandleListener) {
        if (errorHandleListener == null || f43833b == null) {
            f43833b = errorHandleListener;
        } else {
            LogUtil.m32586e(f43832a, "ErrorHandleListener can only set once.");
        }
    }

    public static void setError(SFRpcException sFRpcException) {
        ErrorHandleListener errorHandleListener = f43833b;
        if (errorHandleListener != null) {
            errorHandleListener.onErrorHandle(sFRpcException);
        }
    }
}
