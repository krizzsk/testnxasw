package com.koushikdutta.async.util;

import android.os.Handler;
import com.koushikdutta.async.AsyncServer;
import com.koushikdutta.async.callback.ValueCallback;
import java.util.ArrayList;
import java.util.List;

public class ThrottleTimeout<T> extends TimeoutBase {

    /* renamed from: a */
    ValueCallback<List<T>> f58315a;

    /* renamed from: b */
    ArrayList<T> f58316b = new ArrayList<>();

    /* renamed from: c */
    ThrottleMode f58317c = ThrottleMode.Collect;

    /* renamed from: d */
    Object f58318d;

    public enum ThrottleMode {
        Collect,
        Meter
    }

    public ThrottleTimeout(AsyncServer asyncServer, long j, ValueCallback<List<T>> valueCallback) {
        super(asyncServer, j);
        this.f58315a = valueCallback;
    }

    public ThrottleTimeout(Handler handler, long j, ValueCallback<List<T>> valueCallback) {
        super(handler, j);
        this.f58315a = valueCallback;
    }

    public void setCallback(ValueCallback<List<T>> valueCallback) {
        this.f58315a = valueCallback;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m44201a() {
        this.f58318d = null;
        ArrayList arrayList = new ArrayList(this.f58316b);
        this.f58316b.clear();
        this.f58315a.onResult(arrayList);
    }

    public synchronized void postThrottled(T t) {
        this.handlerish.post(new Runnable(t) {
            public final /* synthetic */ Object f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                ThrottleTimeout.this.m44202a(this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m44202a(Object obj) {
        this.f58316b.add(obj);
        if (this.f58317c == ThrottleMode.Collect) {
            this.handlerish.removeAllCallbacks(this.f58318d);
            this.f58318d = this.handlerish.postDelayed(new Runnable() {
                public final void run() {
                    ThrottleTimeout.this.m44201a();
                }
            }, this.delay);
        } else if (this.f58318d == null) {
            m44201a();
            this.f58318d = this.handlerish.postDelayed(new Runnable() {
                public final void run() {
                    ThrottleTimeout.this.m44201a();
                }
            }, this.delay);
        }
    }

    public void setThrottleMode(ThrottleMode throttleMode) {
        this.f58317c = throttleMode;
    }
}
