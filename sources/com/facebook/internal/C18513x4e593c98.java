package com.facebook.internal;

import android.os.RemoteException;
import com.android.installreferrer.api.InstallReferrerClient;
import com.android.installreferrer.api.InstallReferrerStateListener;
import com.android.installreferrer.api.ReferrerDetails;
import com.facebook.internal.InstallReferrerUtil;
import com.facebook.internal.instrument.crashshield.CrashShieldHandler;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo148867d1 = {"\u0000\u0019\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016J\u0010\u0010\u0004\u001a\u00020\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u0017¨\u0006\u0007"}, mo148868d2 = {"com/facebook/internal/InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1", "Lcom/android/installreferrer/api/InstallReferrerStateListener;", "onInstallReferrerServiceDisconnected", "", "onInstallReferrerSetupFinished", "responseCode", "", "facebook-core_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* renamed from: com.facebook.internal.InstallReferrerUtil$tryConnectReferrerInfo$installReferrerStateListener$1 */
/* compiled from: InstallReferrerUtil.kt */
public final class C18513x4e593c98 implements InstallReferrerStateListener {
    final /* synthetic */ InstallReferrerUtil.Callback $callback;
    final /* synthetic */ InstallReferrerClient $referrerClient;

    public void onInstallReferrerServiceDisconnected() {
    }

    C18513x4e593c98(InstallReferrerClient installReferrerClient, InstallReferrerUtil.Callback callback) {
        this.$referrerClient = installReferrerClient;
        this.$callback = callback;
    }

    public void onInstallReferrerSetupFinished(int i) {
        if (!CrashShieldHandler.isObjectCrashing(this)) {
            if (i == 0) {
                try {
                    ReferrerDetails installReferrer = this.$referrerClient.getInstallReferrer();
                    Intrinsics.checkNotNullExpressionValue(installReferrer, "{\n                      referrerClient.installReferrer\n                    }");
                    String installReferrer2 = installReferrer.getInstallReferrer();
                    if (installReferrer2 != null && (StringsKt.contains$default((CharSequence) installReferrer2, (CharSequence) "fb", false, 2, (Object) null) || StringsKt.contains$default((CharSequence) installReferrer2, (CharSequence) "facebook", false, 2, (Object) null))) {
                        this.$callback.onReceiveReferrerUrl(installReferrer2);
                    }
                    InstallReferrerUtil.INSTANCE.updateReferrer();
                } catch (RemoteException unused) {
                }
            } else if (i == 2) {
                try {
                    InstallReferrerUtil.INSTANCE.updateReferrer();
                } catch (Throwable th) {
                    CrashShieldHandler.handleThrowable(th, this);
                }
            }
        }
    }
}
