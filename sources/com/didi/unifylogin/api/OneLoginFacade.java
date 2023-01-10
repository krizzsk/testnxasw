package com.didi.unifylogin.api;

import android.content.Context;
import com.didichuxing.foundation.spi.ServiceLoader;

public class OneLoginFacade {

    /* renamed from: a */
    private static final String f47317a = "OneLoginFacade";

    /* renamed from: b */
    private static ILoginActionApi f47318b = ((ILoginActionApi) m35205a(ILoginActionApi.class));

    /* renamed from: c */
    private static ILoginStoreApi f47319c = ((ILoginStoreApi) m35205a(ILoginStoreApi.class));

    /* renamed from: d */
    private static ILoginFunctionApi f47320d = ((ILoginFunctionApi) m35205a(ILoginFunctionApi.class));

    /* renamed from: e */
    private static ILoginConfigApi f47321e = ((ILoginConfigApi) m35205a(ILoginConfigApi.class));

    /* renamed from: f */
    private static ILoginFacade f47322f = ((ILoginFacade) m35205a(ILoginFacade.class));

    public static ILoginActionApi getAction() {
        return f47318b;
    }

    public static ILoginStoreApi getStore() {
        return f47319c;
    }

    public static ILoginFunctionApi getFunction() {
        return f47320d;
    }

    public static ILoginConfigApi getConfigApi() {
        return f47321e;
    }

    public static void init(Context context, LoginInitParam loginInitParam) {
        f47322f.init(context, loginInitParam);
    }

    public static void agentInstance(Context context, LoginInitParam loginInitParam, ILoginActionApi iLoginActionApi, ILoginStoreApi iLoginStoreApi, ILoginFunctionApi iLoginFunctionApi, ILoginConfigApi iLoginConfigApi, ILoginFacade iLoginFacade) {
        f47318b = iLoginActionApi;
        f47319c = iLoginStoreApi;
        f47320d = iLoginFunctionApi;
        f47321e = iLoginConfigApi;
        f47322f = iLoginFacade;
        iLoginFacade.init(context, loginInitParam);
    }

    /* renamed from: a */
    private static <S> S m35205a(Class<S> cls) {
        ServiceLoader<S> load = ServiceLoader.load(cls);
        if (load == null) {
            return null;
        }
        return load.get();
    }
}
