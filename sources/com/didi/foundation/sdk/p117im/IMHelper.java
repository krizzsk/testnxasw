package com.didi.foundation.sdk.p117im;

import android.app.Activity;
import android.app.Application;
import com.didi.beatles.p101im.access.IMAssister;
import com.didi.beatles.p101im.access.IMContext;
import com.didi.beatles.p101im.access.IMEngine;
import com.didi.foundation.sdk.depsdowngrade.DependencyDowngradeToggle;
import com.didi.foundation.sdk.log.LogService;
import com.didi.foundation.sdk.login.LoginCallbacks;
import com.didi.foundation.sdk.login.LoginService;
import com.didi.sdk.logging.Logger;
import com.didichuxing.foundation.spi.ServiceLoader;

/* renamed from: com.didi.foundation.sdk.im.IMHelper */
public final class IMHelper {

    /* renamed from: a */
    static Logger f23031a = LogService.getLogger("IMHelper");

    /* renamed from: b */
    private static Application f23032b;

    /* renamed from: c */
    private static IMContext f23033c;

    /* renamed from: d */
    private static IMAssister f23034d;

    /* renamed from: e */
    private static IMContextProvider f23035e;

    static {
        if (DependencyDowngradeToggle.getInstance().isDowngradeIM()) {
            f23031a.warn("Initialize downgrade!", new Object[0]);
        } else {
            m19002b();
        }
    }

    /* renamed from: b */
    private static void m19002b() {
        f23035e = (IMContextProvider) ServiceLoader.load(IMContextProvider.class).get();
        Logger logger = f23031a;
        logger.debug("sIMContextProvider: " + f23035e, new Object[0]);
        if (f23035e == null) {
            f23031a.warn("static block: IMContextProvider implementation not found!", new Object[0]);
            return;
        }
        LoginService instance = LoginService.getInstance();
        instance.addLoginListener(new LoginCallbacks.LoginListener() {
            public void onCancel() {
            }

            public void onSuccess(Activity activity, String str) {
                IMHelper.f23031a.debug("onLoginSuccess and init IM engine", new Object[0]);
                IMHelper.initIMEngine(activity.getApplication());
            }
        });
        instance.addLogoutListener(new LoginCallbacks.LoginOutListener() {
            public void onSuccess() {
                IMHelper.f23031a.debug("onLogoutSuccess and release IM engine", new Object[0]);
                IMHelper.m19003c();
            }
        });
    }

    private IMHelper() {
    }

    public static void initIMEngine(Application application) {
        if (DependencyDowngradeToggle.getInstance().isDowngradeIM()) {
            f23031a.warn("initIMEngine: Downgrade and return", new Object[0]);
            return;
        }
        IMContextProvider iMContextProvider = f23035e;
        if (iMContextProvider == null) {
            f23031a.warn("initIMEngine: IMContextProvider implementation not found!", new Object[0]);
            return;
        }
        f23032b = application;
        if (f23033c == null) {
            f23033c = new C8943b(application, iMContextProvider);
        }
        if (f23034d == null) {
            f23034d = new C8942a();
        }
        try {
            IMEngine.getInstance(application).initIMEngine(f23033c, f23034d);
            if (f23035e.getIMResource() != null) {
                IMEngine.getInstance(application).registerIMResource(f23035e.getIMResource());
            }
        } catch (Exception e) {
            Logger logger = f23031a;
            logger.error("init IM error: " + e, new Object[0]);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static void m19003c() {
        if (f23035e == null) {
            f23031a.warn("releaseIMEngine: IMContextProvider implementation not found!", new Object[0]);
            return;
        }
        IMEngine.getInstance(f23032b).destroyIMEngine();
        f23033c = null;
        f23034d = null;
        f23032b = null;
    }
}
