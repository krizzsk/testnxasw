package com.didi.map.core.p122ui.callback;

import androidx.activity.ComponentActivity;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.Observer;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didi.map.core.ui.callback.ProtectedUnPeekLiveData */
public class ProtectedUnPeekLiveData<T> extends LiveData<T> {

    /* renamed from: a */
    private final HashMap<Integer, Boolean> f27008a = new HashMap<>();
    protected boolean isAllowNullValue;

    public void observeInActivity(ComponentActivity componentActivity, Observer<? super T> observer) {
        m21258a(Integer.valueOf(System.identityHashCode(componentActivity.getViewModelStore())), (LifecycleOwner) componentActivity, observer);
    }

    public void observeInFragment(Fragment fragment, Observer<? super T> observer) {
        m21258a(Integer.valueOf(System.identityHashCode(fragment.getViewModelStore())), fragment.getViewLifecycleOwner(), observer);
    }

    /* renamed from: a */
    private void m21258a(Integer num, LifecycleOwner lifecycleOwner, Observer<? super T> observer) {
        if (this.f27008a.get(num) == null) {
            this.f27008a.put(num, true);
        }
        super.observe(lifecycleOwner, new Observer(num, observer) {
            public final /* synthetic */ Integer f$1;
            public final /* synthetic */ Observer f$2;

            {
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void onChanged(Object obj) {
                ProtectedUnPeekLiveData.this.m21259a(this.f$1, this.f$2, obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21259a(Integer num, Observer observer, Object obj) {
        if (!this.f27008a.get(num).booleanValue()) {
            this.f27008a.put(num, true);
            if (obj != null || this.isAllowNullValue) {
                observer.onChanged(obj);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void setValue(T t) {
        if (t != null || this.isAllowNullValue) {
            for (Map.Entry<Integer, Boolean> value : this.f27008a.entrySet()) {
                value.setValue(false);
            }
            super.setValue(t);
        }
    }

    /* access modifiers changed from: protected */
    public void clear() {
        super.setValue(null);
    }
}
