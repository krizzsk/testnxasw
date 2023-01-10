package com.didi.payment.base.lifecycle;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import com.didi.onehybrid.jsbridge.CallbackFunction;
import com.didi.payment.base.view.webview.fusion.model.WalletCommonModule;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0000\n\u0002\u0010 \n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001a\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0014\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0018\u0010\u0015\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00052\u0006\u0010\u0016\u001a\u00020\u0011H\u0016J\u0010\u0010\u0017\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016J\u0010\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0005H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0004¢\u0006\u0002\n\u0000R>\u0010\u0006\u001a&\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005 \b*\u0012\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00050\u0005\u0018\u00010\t0\u00078FX\u0004¢\u0006\f\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u0006\u0019"}, mo148868d2 = {"Lcom/didi/payment/base/lifecycle/WalletActivityLifecycle;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "activities", "Ljava/util/LinkedList;", "Landroid/app/Activity;", "activityStack", "", "kotlin.jvm.PlatformType", "", "getActivityStack$annotations", "getActivityStack", "()Ljava/util/List;", "onActivityCreated", "", "activity", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "base_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletActivityLifecycle.kt */
public final class WalletActivityLifecycle implements Application.ActivityLifecycleCallbacks {
    public static final WalletActivityLifecycle INSTANCE = new WalletActivityLifecycle();

    /* renamed from: a */
    private static final LinkedList<Activity> f32368a = new LinkedList<>();

    @JvmStatic
    public static /* synthetic */ void getActivityStack$annotations() {
    }

    public void onActivityPaused(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(bundle, "outState");
    }

    public void onActivityStarted(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityStopped(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    private WalletActivityLifecycle() {
    }

    public static final List<Activity> getActivityStack() {
        return Collections.unmodifiableList(f32368a);
    }

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        f32368a.add(activity);
    }

    public void onActivityResumed(Activity activity) {
        CallbackFunction callbackFunction;
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual((Object) WalletCommonModule.driverWebName, (Object) activity.getClass().getSimpleName()) && (callbackFunction = WalletCommonModule.refreshCallback) != null) {
            callbackFunction.onCallBack(new Object[0]);
            WalletCommonModule.refreshCallback = null;
        }
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        if (Intrinsics.areEqual((Object) WalletCommonModule.driverWebName, (Object) activity.getClass().getSimpleName())) {
            WalletCommonModule.refreshCallback = null;
        }
        f32368a.remove(activity);
    }
}
