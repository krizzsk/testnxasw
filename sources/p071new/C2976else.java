package p071new;

import com.iproov.sdk.IProov;

/* renamed from: new.else */
/* compiled from: ProcessingListenerEvent */
public class C2976else extends C2974case {

    /* renamed from: a */
    private final double f6925a;

    /* renamed from: b */
    private final String f6926b;

    public C2976else(double d, String str) {
        this.f6925a = d;
        this.f6926b = str;
    }

    /* renamed from: do */
    public void mo29847do(IProov.Listener listener) {
        listener.onProcessing(this.f6925a, this.f6926b);
    }
}
