package com.didi.app.nova.support.view.recyclerview.binder.mvp;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemPresenter;

public abstract class MvpItemView<P extends MvpItemPresenter, VH extends ItemViewHolder> {

    /* renamed from: a */
    private P f10441a;

    /* renamed from: b */
    private VH f10442b;

    /* renamed from: c */
    private Context f10443c;

    /* access modifiers changed from: protected */
    public void onAttach() {
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
    }

    /* access modifiers changed from: protected */
    public void onDetach() {
    }

    /* access modifiers changed from: protected */
    public abstract void updateView(VH vh);

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo46216a(P p) {
        this.f10441a = p;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo46214a(Context context) {
        this.f10443c = context;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo46215a(VH vh) {
        this.f10442b = vh;
    }

    public final Context getContext() {
        return this.f10443c;
    }

    public final P getItemPresenter() {
        return this.f10441a;
    }

    public final VH getViewHolder() {
        return this.f10442b;
    }
}
