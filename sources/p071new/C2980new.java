package p071new;

import com.iproov.sdk.IProov;
import com.iproov.sdk.core.exception.IProovException;

/* renamed from: new.new */
/* compiled from: ErrorListenerEvent */
public class C2980new extends C2974case {

    /* renamed from: a */
    private final IProovException f6928a;

    public C2980new(IProovException iProovException) {
        this.f6928a = iProovException;
    }

    /* renamed from: do */
    public void mo29847do(IProov.Listener listener) {
        listener.onError(this.f6928a);
    }

    /* renamed from: do */
    public boolean mo29848do() {
        return true;
    }
}
