package com.didi.sdk.messagecenter;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.didi.sdk.messagecenter.interfaces.IStore;
import com.didi.sdk.messagecenter.interfaces.ISubscribe;
import com.didi.sdk.messagecenter.model.PushMessage;

/* renamed from: com.didi.sdk.messagecenter.b */
/* compiled from: SubscribeCenter */
class C13295b implements ISubscribe {

    /* renamed from: a */
    private static ISubscribe f39529a;

    /* renamed from: b */
    private IStore f39530b = new C13296c();

    /* renamed from: c */
    private final LifecycleObserver f39531c = new SubscribeCenter$1(this);

    private C13295b() {
    }

    /* renamed from: a */
    public static ISubscribe m29758a() {
        if (f39529a == null) {
            synchronized (C13295b.class) {
                if (f39529a == null) {
                    f39529a = new C13295b();
                }
            }
        }
        return f39529a;
    }

    public ISubscribe.ISubscribeWrapper bind(Object obj) {
        return new C13297d(obj, this.f39530b);
    }

    public ISubscribe.ISubscribeWrapper autoBind(LifecycleOwner lifecycleOwner) {
        if (lifecycleOwner != null) {
            Lifecycle lifecycle = lifecycleOwner.getLifecycle();
            if (lifecycle != null) {
                lifecycle.addObserver(this.f39531c);
                return new C13297d(lifecycleOwner, this.f39530b);
            }
            throw new IllegalArgumentException("lifecycle is null");
        }
        throw new IllegalArgumentException("lifecycleOwner is null");
    }

    public void release(Object obj) {
        this.f39530b.remove(obj);
    }

    public void release(Object obj, Class<? extends PushMessage> cls) {
        this.f39530b.removeMessage(obj, cls);
    }
}
