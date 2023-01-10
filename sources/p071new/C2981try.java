package p071new;

import com.iproov.sdk.IProov;

/* renamed from: new.try */
/* compiled from: FailureListenerEvent */
public class C2981try extends C2974case {

    /* renamed from: a */
    private final IProov.FailureResult f6929a;

    public C2981try(IProov.FailureResult failureResult) {
        this.f6929a = failureResult;
    }

    /* renamed from: do */
    public void mo29847do(IProov.Listener listener) {
        listener.onFailure(this.f6929a);
    }

    /* renamed from: do */
    public boolean mo29848do() {
        return true;
    }
}
