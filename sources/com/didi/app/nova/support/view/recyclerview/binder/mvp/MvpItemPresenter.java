package com.didi.app.nova.support.view.recyclerview.binder.mvp;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemView;

public abstract class MvpItemPresenter<V extends MvpItemView, T> {

    /* renamed from: a */
    private V f10434a;

    /* renamed from: b */
    private T f10435b;

    /* access modifiers changed from: protected */
    public void onAttach() {
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo46191a(V v) {
        this.f10434a = v;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo46192a(T t) {
        this.f10435b = t;
    }

    public final Context getContext() {
        V v = this.f10434a;
        if (v != null) {
            return v.getContext();
        }
        throw new IllegalStateException("View not callAttach to this view of " + getClass().getName());
    }

    public final V getItemView() {
        return this.f10434a;
    }

    public final T getItem() {
        return this.f10435b;
    }
}
