package com.didi.payment.transfer;

import android.content.Context;
import com.didi.payment.base.proxy.ConfigProxyHolder;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

public class DebugUtil {

    /* renamed from: a */
    private static final String f33831a = "wallet_transfer";

    /* renamed from: b */
    private static Logger f33832b = LoggerFactory.getLogger(f33831a);

    @Deprecated
    public static boolean isInDebugMode() {
        return false;
    }

    public static void log(String str, Object... objArr) {
    }

    public static void showShortToast(Context context, String str) {
    }

    public static void showShortToast(Context context, String str, int i) {
    }

    public static void justLog(String str, Object... objArr) {
        f33832b.debug(str, objArr);
    }

    public static boolean isAppInDebugMode() {
        ConfigProxyHolder.IConfigProxy proxy = ConfigProxyHolder.getProxy();
        return proxy != null && proxy.isDebugMode();
    }
}
