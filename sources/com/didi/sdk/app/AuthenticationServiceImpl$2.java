package com.didi.sdk.app;

import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.swarm.toolkit.AuthenticationChangeEvent;

class AuthenticationServiceImpl$2 implements LoginListeners.LoginOutListener {
    final /* synthetic */ C12834a this$0;

    AuthenticationServiceImpl$2(C12834a aVar) {
        this.this$0 = aVar;
    }

    public void onSuccess() {
        this.this$0.m28658a(new AuthenticationChangeEvent(this.this$0, false));
    }
}
