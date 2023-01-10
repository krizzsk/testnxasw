package com.didi.payment.wallet_ui.push;

import android.app.Activity;
import android.app.Application;
import android.os.Bundle;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0005¢\u0006\u0002\u0010\u0002J\u001a\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010\t\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0018\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\r\u001a\u00020\bH\u0016J\u0010\u0010\u000e\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016J\u0010\u0010\u000f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0016¨\u0006\u0011"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/push/WalletPushLifecycle;", "Landroid/app/Application$ActivityLifecycleCallbacks;", "()V", "onActivityCreated", "", "activity", "Landroid/app/Activity;", "savedInstanceState", "Landroid/os/Bundle;", "onActivityDestroyed", "onActivityPaused", "onActivityResumed", "onActivitySaveInstanceState", "outState", "onActivityStarted", "onActivityStopped", "Companion", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: WalletPushLifecycle.kt */
public final class WalletPushLifecycle implements Application.ActivityLifecycleCallbacks {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static volatile boolean f35681a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static byte[] f35682b = new byte[0];
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static WeakReference<Activity> f35683c;

    public void onActivityCreated(Activity activity, Bundle bundle) {
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public void onActivityDestroyed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
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

    @Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\"\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\r¨\u0006\u0012"}, mo148868d2 = {"Lcom/didi/payment/wallet_ui/push/WalletPushLifecycle$Companion;", "", "()V", "hasRegister", "", "registerLock", "", "topActivityReference", "Ljava/lang/ref/WeakReference;", "Landroid/app/Activity;", "getTopActivityReference", "()Ljava/lang/ref/WeakReference;", "setTopActivityReference", "(Ljava/lang/ref/WeakReference;)V", "register", "", "context", "Landroid/content/Context;", "wallet-ui_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: WalletPushLifecycle.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX WARNING: Code restructure failed: missing block: B:19:0x0038, code lost:
            return;
         */
        /* Code decompiled incorrectly, please refer to instructions dump. */
        public final void register(android.content.Context r3) {
            /*
                r2 = this;
                if (r3 == 0) goto L_0x003c
                boolean r0 = com.didi.payment.wallet_ui.push.WalletPushLifecycle.f35681a
                if (r0 == 0) goto L_0x0009
                goto L_0x003c
            L_0x0009:
                byte[] r0 = com.didi.payment.wallet_ui.push.WalletPushLifecycle.f35682b
                monitor-enter(r0)
                boolean r1 = com.didi.payment.wallet_ui.push.WalletPushLifecycle.f35681a     // Catch:{ all -> 0x0039 }
                if (r1 == 0) goto L_0x0016
                monitor-exit(r0)
                return
            L_0x0016:
                android.content.Context r3 = r3.getApplicationContext()     // Catch:{ all -> 0x0039 }
                boolean r1 = r3 instanceof android.app.Application     // Catch:{ all -> 0x0039 }
                if (r1 == 0) goto L_0x0021
                android.app.Application r3 = (android.app.Application) r3     // Catch:{ all -> 0x0039 }
                goto L_0x0022
            L_0x0021:
                r3 = 0
            L_0x0022:
                if (r3 != 0) goto L_0x0025
                goto L_0x0037
            L_0x0025:
                com.didi.payment.wallet_ui.push.WalletPushLifecycle r1 = new com.didi.payment.wallet_ui.push.WalletPushLifecycle     // Catch:{ all -> 0x0039 }
                r1.<init>()     // Catch:{ all -> 0x0039 }
                android.app.Application$ActivityLifecycleCallbacks r1 = (android.app.Application.ActivityLifecycleCallbacks) r1     // Catch:{ all -> 0x0039 }
                r3.registerActivityLifecycleCallbacks(r1)     // Catch:{ all -> 0x0039 }
                com.didi.payment.wallet_ui.push.WalletPushLifecycle$Companion r3 = com.didi.payment.wallet_ui.push.WalletPushLifecycle.Companion     // Catch:{ all -> 0x0039 }
                r3 = 1
                com.didi.payment.wallet_ui.push.WalletPushLifecycle.f35681a = r3     // Catch:{ all -> 0x0039 }
                kotlin.Unit r3 = kotlin.Unit.INSTANCE     // Catch:{ all -> 0x0039 }
            L_0x0037:
                monitor-exit(r0)
                return
            L_0x0039:
                r3 = move-exception
                monitor-exit(r0)
                throw r3
            L_0x003c:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet_ui.push.WalletPushLifecycle.Companion.register(android.content.Context):void");
        }

        public final WeakReference<Activity> getTopActivityReference() {
            return WalletPushLifecycle.f35683c;
        }

        public final void setTopActivityReference(WeakReference<Activity> weakReference) {
            WalletPushLifecycle.f35683c = weakReference;
        }
    }

    public void onActivityResumed(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        f35683c = new WeakReference<>(activity);
        WalletPushManager.Companion.showPushDialog();
    }
}
