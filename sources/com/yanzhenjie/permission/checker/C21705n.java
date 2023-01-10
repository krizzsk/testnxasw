package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.net.sip.SipManager;
import android.net.sip.SipProfile;
import com.didi.global.fintech.cashier.model.net.request.CashierAction;

/* renamed from: com.yanzhenjie.permission.checker.n */
/* compiled from: SipTest */
class C21705n implements PermissionTest {

    /* renamed from: a */
    private Context f58962a;

    C21705n(Context context) {
        this.f58962a = context;
    }

    /* renamed from: a */
    public boolean mo178868a() throws Throwable {
        SipManager newInstance;
        if (!SipManager.isApiSupported(this.f58962a) || (newInstance = SipManager.newInstance(this.f58962a)) == null) {
            return true;
        }
        SipProfile.Builder builder = new SipProfile.Builder("Permission", "127.0.0.1");
        builder.setPassword(CashierAction.ACTION_PASSWORD);
        SipProfile build = builder.build();
        newInstance.open(build);
        newInstance.close(build.getUriString());
        return true;
    }
}
