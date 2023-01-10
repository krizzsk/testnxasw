package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import com.didi.sdk.apm.SystemUtils;
import com.google.android.gms.internal.base.zau;

/* compiled from: com.google.android.gms:play-services-base@@18.1.0 */
final class zabh extends zau {
    final /* synthetic */ zabi zaa;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    zabh(zabi zabi, Looper looper) {
        super(looper);
        this.zaa = zabi;
    }

    public final void handleMessage(Message message) {
        int i = message.what;
        if (i == 1) {
            ((zabg) message.obj).zab(this.zaa);
        } else if (i != 2) {
            int i2 = message.what;
            SystemUtils.log(5, "GACStateManager", "Unknown message id: " + i2, (Throwable) null, "com.google.android.gms.common.api.internal.zabh", 5);
        } else {
            throw ((RuntimeException) message.obj);
        }
    }
}
