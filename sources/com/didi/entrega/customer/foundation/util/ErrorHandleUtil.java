package com.didi.entrega.customer.foundation.util;

import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.rpc.net.SFRpcException;

public final class ErrorHandleUtil {

    /* renamed from: a */
    private static final String f21986a = "ErrorHandleUtil";

    /* renamed from: b */
    private static ErrorHandleListener f21987b;

    public interface ErrorHandleListener {
        void onErrorHandle(SFRpcException sFRpcException);
    }

    private ErrorHandleUtil() {
    }

    public static void setErrorHandleListener(ErrorHandleListener errorHandleListener) {
        if (errorHandleListener == null || f21987b == null) {
            f21987b = errorHandleListener;
        } else {
            LogUtil.m18183e(f21986a, "ErrorHandleListener can only set once.");
        }
    }

    public static void setError(SFRpcException sFRpcException) {
        ErrorHandleListener errorHandleListener = f21987b;
        if (errorHandleListener != null) {
            errorHandleListener.onErrorHandle(sFRpcException);
        }
    }
}
