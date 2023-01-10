package com.didiglobal.pay.paysecure.tmx;

import android.app.Application;
import android.os.CountDownTimer;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0007"}, mo148868d2 = {"com/didiglobal/pay/paysecure/tmx/TMXProfilingMgr$register$timer$1", "Landroid/os/CountDownTimer;", "onFinish", "", "onTick", "millisUntilFinished", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: TMXProfilingMgr.kt */
public final class TMXProfilingMgr$register$timer$1 extends CountDownTimer {
    final /* synthetic */ Application $context;

    public void onTick(long j) {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    TMXProfilingMgr$register$timer$1(Application application, long j, long j2) {
        super(j, j2);
        this.$context = application;
    }

    public void onFinish() {
        TMXProfilingMgr.INSTANCE.m39668a(this.$context);
    }
}
