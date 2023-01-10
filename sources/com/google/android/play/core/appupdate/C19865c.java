package com.google.android.play.core.appupdate;

import android.os.Bundle;
import android.os.Handler;
import android.os.ResultReceiver;
import com.google.android.play.core.tasks.C20237i;

/* renamed from: com.google.android.play.core.appupdate.c */
final class C19865c extends ResultReceiver {

    /* renamed from: a */
    final /* synthetic */ C20237i f55553a;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    C19865c(Handler handler, C20237i iVar) {
        super(handler);
        this.f55553a = iVar;
    }

    public final void onReceiveResult(int i, Bundle bundle) {
        C20237i iVar;
        int i2 = 1;
        if (i == 1) {
            iVar = this.f55553a;
            i2 = -1;
        } else if (i != 2) {
            iVar = this.f55553a;
        } else {
            iVar = this.f55553a;
            i2 = 0;
        }
        iVar.mo164557b(Integer.valueOf(i2));
    }
}
