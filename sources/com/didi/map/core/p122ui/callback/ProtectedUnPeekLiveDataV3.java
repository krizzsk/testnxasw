package com.didi.map.core.p122ui.callback;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.Timer;
import java.util.TimerTask;

@Deprecated
/* renamed from: com.didi.map.core.ui.callback.ProtectedUnPeekLiveDataV3 */
public class ProtectedUnPeekLiveDataV3<T> extends LiveData<T> {
    protected int DELAY_TO_CLEAR_EVENT = 1000;

    /* renamed from: a */
    private boolean f27009a;

    /* renamed from: b */
    private boolean f27010b = true;

    /* renamed from: c */
    private boolean f27011c;

    /* renamed from: d */
    private Timer f27012d = new Timer();

    /* renamed from: e */
    private TimerTask f27013e;
    protected boolean isAllowNullValue;
    protected boolean isAllowToClear = true;

    public void observe(LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        super.observe(lifecycleOwner, new Observer(observer) {
            public final /* synthetic */ Observer f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                ProtectedUnPeekLiveDataV3.this.m21261a(this.f$1, obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21261a(Observer observer, Object obj) {
        if (this.f27009a) {
            this.f27010b = true;
            this.f27011c = false;
            this.f27009a = false;
        } else if (!this.f27010b) {
            this.f27010b = true;
            this.f27011c = true;
            observer.onChanged(obj);
        } else if (this.f27011c) {
            observer.onChanged(obj);
        }
    }

    public void observeForever(Observer<? super T> observer) {
        throw new IllegalArgumentException("Do not use observeForever for communication between pages to avoid lifecycle security issues");
    }

    /* access modifiers changed from: protected */
    public void setValue(T t) {
        if (this.f27009a || this.isAllowNullValue || t != null) {
            this.f27010b = false;
            this.f27011c = false;
            super.setValue(t);
            TimerTask timerTask = this.f27013e;
            if (timerTask != null) {
                timerTask.cancel();
                this.f27012d.purge();
            }
            if (t != null) {
                C100911 r4 = new TimerTask() {
                    public void run() {
                        ProtectedUnPeekLiveDataV3.this.m21260a();
                    }
                };
                this.f27013e = r4;
                this.f27012d.schedule(r4, (long) this.DELAY_TO_CLEAR_EVENT);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21260a() {
        if (this.isAllowToClear) {
            this.f27009a = true;
            super.postValue(null);
            return;
        }
        this.f27010b = true;
        this.f27011c = false;
    }
}
