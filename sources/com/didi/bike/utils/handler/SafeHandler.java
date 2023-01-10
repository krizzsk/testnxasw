package com.didi.bike.utils.handler;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.lang.ref.WeakReference;

public class SafeHandler<T> extends Handler {

    /* renamed from: a */
    private WeakReference<T> f12508a;

    public SafeHandler(T t) {
        this.f12508a = new WeakReference<>(t);
    }

    public SafeHandler(T t, Looper looper) {
        super(looper);
        this.f12508a = new WeakReference<>(t);
    }

    public void dispatchMessage(Message message) {
        if (this.f12508a.get() != null) {
            super.dispatchMessage(message);
        }
    }

    /* access modifiers changed from: protected */
    public T getTarget() {
        return this.f12508a.get();
    }
}
