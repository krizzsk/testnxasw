package p071new;

import com.iproov.sdk.IProov;

/* renamed from: new.goto */
/* compiled from: SuccessListenerEvent */
public class C2978goto extends C2974case {

    /* renamed from: a */
    private final IProov.SuccessResult f6927a;

    public C2978goto(IProov.SuccessResult successResult) {
        this.f6927a = successResult;
    }

    /* renamed from: do */
    public void mo29847do(IProov.Listener listener) {
        listener.onSuccess(this.f6927a);
    }

    /* renamed from: do */
    public boolean mo29848do() {
        return true;
    }
}
