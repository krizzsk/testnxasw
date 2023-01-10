package com.didi.dcrypto.util.network;

import android.content.Context;
import java.util.HashMap;

public class CommonProxyHolder {

    /* renamed from: a */
    private static ICommonProxy f18400a;

    public interface ICommonProxy {
        void doLogin(Context context);

        HashMap<String, Object> getBaseParams(Context context);

        Object getTerminalId(Context context);

        boolean isLogin(Context context);
    }

    public static ICommonProxy getProxy() {
        return f18400a;
    }

    public static void setProxy(ICommonProxy iCommonProxy) {
        f18400a = iCommonProxy;
    }
}
