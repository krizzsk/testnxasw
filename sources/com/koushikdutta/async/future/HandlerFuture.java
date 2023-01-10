package com.koushikdutta.async.future;

import android.os.Handler;
import android.os.Looper;

public class HandlerFuture<T> extends SimpleFuture<T> {

    /* renamed from: a */
    Handler f58104a;

    public HandlerFuture() {
        Looper myLooper = Looper.myLooper();
        this.f58104a = new Handler(myLooper == null ? Looper.getMainLooper() : myLooper);
    }

    public void setCallback(final FutureCallback<T> futureCallback) {
        super.setCallback(new FutureCallback<T>() {
            public void onCompleted(final Exception exc, final T t) {
                if (Looper.myLooper() == HandlerFuture.this.f58104a.getLooper()) {
                    futureCallback.onCompleted(exc, t);
                } else {
                    HandlerFuture.this.f58104a.post(new Runnable() {
                        public void run() {
                            C211431.this.onCompleted(exc, t);
                        }
                    });
                }
            }
        });
    }
}
