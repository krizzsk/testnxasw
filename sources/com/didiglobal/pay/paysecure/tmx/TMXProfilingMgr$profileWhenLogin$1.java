package com.didiglobal.pay.paysecure.tmx;

import android.app.Activity;
import android.app.Application;
import com.didi.unifylogin.listener.LoginListeners;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u001f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u001c\u0010\u0004\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016¨\u0006\t"}, mo148868d2 = {"com/didiglobal/pay/paysecure/tmx/TMXProfilingMgr$profileWhenLogin$1", "Lcom/didi/unifylogin/listener/LoginListeners$LoginListener;", "onCancel", "", "onSuccess", "activity", "Landroid/app/Activity;", "token", "", "paysecure_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: TMXProfilingMgr.kt */
public final class TMXProfilingMgr$profileWhenLogin$1 implements LoginListeners.LoginListener {
    final /* synthetic */ Application $context;

    public void onCancel() {
    }

    TMXProfilingMgr$profileWhenLogin$1(Application application) {
        this.$context = application;
    }

    public void onSuccess(Activity activity, String str) {
        TMXProfilingMgr.INSTANCE.doWork(this.$context, "FROM_LOGIN");
    }
}
