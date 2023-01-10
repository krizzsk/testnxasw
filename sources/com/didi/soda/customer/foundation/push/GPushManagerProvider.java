package com.didi.soda.customer.foundation.push;

import android.content.Context;
import com.didi.foundation.sdk.push.LogListener;
import com.didi.foundation.sdk.push.PushMessageReceiver;
import com.didi.foundation.sdk.push.PushParam;
import com.didi.soda.customer.foundation.push.base.BasePushService;
import com.didi.soda.customer.foundation.util.ThreadPoolManager;

public final class GPushManagerProvider {

    /* renamed from: a */
    private BasePushService f43540a;

    private GPushManagerProvider() {
        this.f43540a = new BasePushService();
    }

    public static GPushManagerProvider getInstance() {
        return Holder.PROVIDER;
    }

    public void init(Context context, PushParam pushParam, LogListener logListener) {
        this.f43540a.init(context, pushParam, logListener);
    }

    public void registerPushReceiver(PushMessageReceiver pushMessageReceiver) {
        this.f43540a.registerReceiver(pushMessageReceiver);
    }

    public void unregisterPushReceiver(PushMessageReceiver pushMessageReceiver) {
        this.f43540a.unregisterReceiver(pushMessageReceiver);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m32598a(Context context, PushParam pushParam) {
        this.f43540a.uploadPushParam(context, pushParam);
    }

    public void uploadPushParam(Context context, PushParam pushParam) {
        ThreadPoolManager.getInstance().execute(new Runnable(context, pushParam) {
            public final /* synthetic */ Context f$1;
            public final /* synthetic */ PushParam f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                GPushManagerProvider.this.m32598a(this.f$1, this.f$2);
            }
        });
    }

    private static final class Holder {
        public static final GPushManagerProvider PROVIDER = new GPushManagerProvider();

        private Holder() {
        }
    }
}
