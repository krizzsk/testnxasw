package com.didi.foundation.sdk.swarm;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.foundation.sdk.service.AccountService;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.swarm.toolkit.AuthenticationChangeEvent;
import com.didichuxing.swarm.toolkit.AuthenticationService;
import com.didichuxing.swarm.toolkit.OnAuthenticationStateChangeListener;
import java.util.Vector;

public final class AuthenticationServiceImpl implements AuthenticationService {
    public static final String ACTION_SIGN_IN = "com.didi.action.loginIn";
    public static final String ACTION_SIGN_OUT = "com.didi.action.loginOut";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Logger f23199a = LoggerFactory.getLogger("AuthenticationService");

    /* renamed from: b */
    private final Vector<OnAuthenticationStateChangeListener> f23200b = new Vector<>();

    public AuthenticationServiceImpl(Application application) {
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction(ACTION_SIGN_IN);
        intentFilter.addAction(ACTION_SIGN_OUT);
        try {
            application.registerReceiver(new BroadcastReceiver() {
                public void onReceive(Context context, Intent intent) {
                    Logger a = AuthenticationServiceImpl.f23199a;
                    a.debug("intent: " + intent, new Object[0]);
                    if (intent != null) {
                        String action = intent.getAction();
                        boolean equals = AuthenticationServiceImpl.ACTION_SIGN_IN.equals(action);
                        boolean equals2 = AuthenticationServiceImpl.ACTION_SIGN_OUT.equals(action);
                        if (equals) {
                            AuthenticationServiceImpl.this.m19093a(new AuthenticationChangeEvent(AuthenticationServiceImpl.this, true));
                        }
                        if (equals2) {
                            AuthenticationServiceImpl.this.m19093a(new AuthenticationChangeEvent(AuthenticationServiceImpl.this, false));
                        }
                    }
                }
            }, intentFilter);
        } catch (Exception e) {
            Log.d("Context", "registerReceiver", e);
        }
    }

    public boolean isAuthenticated() {
        return AccountService.getInstance().isAuthenticated();
    }

    public String getToken() {
        return AccountService.getInstance().getToken();
    }

    public void addAuthenticationChangeListener(OnAuthenticationStateChangeListener onAuthenticationStateChangeListener) {
        this.f23200b.add(onAuthenticationStateChangeListener);
    }

    public void removeAuthenticationChangeListener(OnAuthenticationStateChangeListener onAuthenticationStateChangeListener) {
        this.f23200b.remove(onAuthenticationStateChangeListener);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m19093a(AuthenticationChangeEvent authenticationChangeEvent) {
        if (!this.f23200b.isEmpty()) {
            Vector<OnAuthenticationStateChangeListener> vector = this.f23200b;
            for (OnAuthenticationStateChangeListener onAuthenticationStateChanged : (OnAuthenticationStateChangeListener[]) vector.toArray(new OnAuthenticationStateChangeListener[vector.size()])) {
                onAuthenticationStateChanged.onAuthenticationStateChanged(authenticationChangeEvent);
            }
        }
    }
}
