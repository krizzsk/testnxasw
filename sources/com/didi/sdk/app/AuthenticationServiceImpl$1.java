package com.didi.sdk.app;

import android.app.Activity;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.swarm.toolkit.AuthenticationChangeEvent;

class AuthenticationServiceImpl$1 implements LoginListeners.LoginListener {
    final /* synthetic */ C12834a this$0;

    public void onCancel() {
    }

    AuthenticationServiceImpl$1(C12834a aVar) {
        this.this$0 = aVar;
    }

    public void onSuccess(Activity activity, String str) {
        this.this$0.m28658a(new AuthenticationChangeEvent(this.this$0, true));
    }
}
