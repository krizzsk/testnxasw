package com.didi.payment.kycservice.kyc.fragment;

import androidx.fragment.app.FragmentActivity;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import kotlin.Metadata;

@Metadata(mo148867d1 = {"\u0000\u0018\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032,\u0010\u0004\u001a(\u0012\f\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006 \u0007*\u0014\u0012\u000e\b\u0001\u0012\n \u0007*\u0004\u0018\u00010\u00060\u0006\u0018\u00010\u00050\u0005H\n"}, mo148868d2 = {"<anonymous>", "", "granted", "", "<anonymous parameter 1>", "", "", "kotlin.jvm.PlatformType"}, mo148869k = 3, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: SignUp99PayFragment.kt */
final class SignUp99PayFragment$requestLocationPermission$1 implements PermissionCallback {
    final /* synthetic */ SignUp99PayFragment this$0;

    SignUp99PayFragment$requestLocationPermission$1(SignUp99PayFragment signUp99PayFragment) {
        this.this$0 = signUp99PayFragment;
    }

    public final void isAllGranted(boolean z, String[] strArr) {
        FragmentActivity activity;
        if (z && (activity = this.this$0.getActivity()) != null) {
            activity.finish();
        }
    }
}
