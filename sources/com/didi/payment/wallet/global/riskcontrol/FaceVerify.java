package com.didi.payment.wallet.global.riskcontrol;

import android.content.Context;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleCoroutineScope;
import androidx.lifecycle.LifecycleOwnerKt;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001:\u0001\u001dB7\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0005\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u001a\u0010\u0018\u001a\u00020\u00192\b\u0010\b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\u001bH\u0002J\u000e\u0010\u001c\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001bR\u001c\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u000f\"\u0004\b\u0015\u0010\u0011R\u001c\u0010\b\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u000f\"\u0004\b\u0017\u0010\u0011¨\u0006\u001e"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/FaceVerify;", "", "context", "Landroid/content/Context;", "faceSessionId", "", "faceBizCode", "scene", "sessionId", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "getFaceBizCode", "()Ljava/lang/String;", "setFaceBizCode", "(Ljava/lang/String;)V", "riskControlModel", "Lcom/didi/payment/wallet/global/riskcontrol/RiskControlModel;", "getScene", "setScene", "getSessionId", "setSessionId", "getFaceResult", "", "callback", "Lcom/didi/payment/wallet/global/riskcontrol/FaceVerify$IFaceCallback;", "startFaceVerify", "IFaceCallback", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: FaceVerify.kt */
public final class FaceVerify {

    /* renamed from: a */
    private Context f34315a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f34316b;

    /* renamed from: c */
    private String f34317c;

    /* renamed from: d */
    private String f34318d;

    /* renamed from: e */
    private String f34319e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final RiskControlModel f34320f;

    @Metadata(mo148867d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo148868d2 = {"Lcom/didi/payment/wallet/global/riskcontrol/FaceVerify$IFaceCallback;", "", "onResult", "", "result", "", "wallet_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: FaceVerify.kt */
    public interface IFaceCallback {
        void onResult(int i);
    }

    public FaceVerify(Context context, String str, String str2, String str3, String str4) {
        this.f34315a = context;
        this.f34316b = str;
        this.f34317c = str2;
        this.f34318d = str3;
        this.f34319e = str4;
        this.f34320f = new RiskControlModel(context);
    }

    public final Context getContext() {
        return this.f34315a;
    }

    public final void setContext(Context context) {
        this.f34315a = context;
    }

    public final String getFaceBizCode() {
        return this.f34317c;
    }

    public final String getScene() {
        return this.f34318d;
    }

    public final String getSessionId() {
        return this.f34319e;
    }

    public final void setFaceBizCode(String str) {
        this.f34317c = str;
    }

    public final void setScene(String str) {
        this.f34318d = str;
    }

    public final void setSessionId(String str) {
        this.f34319e = str;
    }

    public final void startFaceVerify(IFaceCallback iFaceCallback) {
        LifecycleCoroutineScope lifecycleScope;
        Intrinsics.checkNotNullParameter(iFaceCallback, "callback");
        Context context = this.f34315a;
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) != null) {
            lifecycleScope.launchWhenResumed(new FaceVerify$startFaceVerify$1(this, iFaceCallback, (Continuation<? super FaceVerify$startFaceVerify$1>) null));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m26214a(String str, IFaceCallback iFaceCallback) {
        LifecycleCoroutineScope lifecycleScope;
        Context context = this.f34315a;
        FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
        if (fragmentActivity != null && (lifecycleScope = LifecycleOwnerKt.getLifecycleScope(fragmentActivity)) != null) {
            lifecycleScope.launchWhenResumed(new FaceVerify$getFaceResult$1(iFaceCallback, this, str, (Continuation<? super FaceVerify$getFaceResult$1>) null));
        }
    }
}
