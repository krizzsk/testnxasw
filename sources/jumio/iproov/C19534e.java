package jumio.iproov;

import com.iproov.sdk.IProov;
import com.iproov.sdk.core.exception.IProovException;
import kotlin.jvm.internal.Intrinsics;

/* renamed from: jumio.iproov.e */
/* compiled from: IproovScanPart.kt */
public final class C19534e implements IProov.Listener {

    /* renamed from: a */
    public IProov.Listener f55487a;

    /* renamed from: a */
    public final void mo148827a(IProov.Listener listener) {
        this.f55487a = listener;
    }

    public void onCancelled() {
        IProov.Listener listener = this.f55487a;
        if (listener != null) {
            listener.onCancelled();
        }
    }

    public void onConnected() {
        IProov.Listener listener = this.f55487a;
        if (listener != null) {
            listener.onConnected();
        }
    }

    public void onConnecting() {
        IProov.Listener listener = this.f55487a;
        if (listener != null) {
            listener.onConnecting();
        }
    }

    public void onError(IProovException iProovException) {
        Intrinsics.checkNotNullParameter(iProovException, "p0");
        IProov.Listener listener = this.f55487a;
        if (listener != null) {
            listener.onError(iProovException);
        }
    }

    public void onFailure(IProov.FailureResult failureResult) {
        Intrinsics.checkNotNullParameter(failureResult, "p0");
        IProov.Listener listener = this.f55487a;
        if (listener != null) {
            listener.onFailure(failureResult);
        }
    }

    public void onProcessing(double d, String str) {
        IProov.Listener listener = this.f55487a;
        if (listener != null) {
            listener.onProcessing(d, str);
        }
    }

    public void onSuccess(IProov.SuccessResult successResult) {
        Intrinsics.checkNotNullParameter(successResult, "p0");
        IProov.Listener listener = this.f55487a;
        if (listener != null) {
            listener.onSuccess(successResult);
        }
    }
}
