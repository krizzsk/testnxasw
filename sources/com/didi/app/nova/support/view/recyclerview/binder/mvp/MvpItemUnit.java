package com.didi.app.nova.support.view.recyclerview.binder.mvp;

import android.content.Context;
import com.didi.app.nova.support.view.recyclerview.binder.ItemViewHolder;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemPresenter;
import com.didi.app.nova.support.view.recyclerview.binder.mvp.MvpItemView;

public abstract class MvpItemUnit<V extends MvpItemView<P, VH>, P extends MvpItemPresenter<V, T>, T, VH extends ItemViewHolder<T>> {

    /* renamed from: a */
    private static final int f10436a = 2;

    /* renamed from: b */
    private static final int f10437b = 4;

    /* renamed from: c */
    private int f10438c;

    /* renamed from: d */
    private V f10439d;

    /* renamed from: e */
    private P f10440e;

    /* access modifiers changed from: protected */
    public void onAttach() {
    }

    /* access modifiers changed from: protected */
    public void onBind() {
    }

    /* access modifiers changed from: protected */
    public abstract P onCreatePresenter();

    /* access modifiers changed from: protected */
    public abstract V onCreateView();

    /* access modifiers changed from: protected */
    public void onDetach() {
    }

    /* access modifiers changed from: protected */
    public void setupItemView(V v) {
    }

    /* access modifiers changed from: protected */
    public void setupPresenter(P p) {
    }

    /* renamed from: b */
    private void m9113b(VH vh) {
        Context context = vh.itemView.getContext();
        this.f10439d = onCreateView();
        P onCreatePresenter = onCreatePresenter();
        this.f10440e = onCreatePresenter;
        this.f10439d.mo46216a(onCreatePresenter);
        this.f10440e.mo46191a(this.f10439d);
        this.f10439d.mo46214a(context);
        this.f10440e.mo46192a(vh.getItem());
        this.f10439d.mo46215a(vh);
        setupItemView(this.f10439d);
        setupPresenter(this.f10440e);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo46200a(VH vh) {
        m9115d();
        m9113b(vh);
        this.f10439d.updateView(vh);
        onBind();
        if (isAttached()) {
            mo46199a();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo46199a() {
        m9112b(4);
        m9111a(2);
        onAttach();
        this.f10439d.onAttach();
        this.f10440e.onAttach();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo46201b() {
        m9112b(2);
        m9111a(4);
        onDetach();
        this.f10439d.onDetach();
        this.f10440e.onDetach();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo46202c() {
        m9115d();
    }

    /* renamed from: d */
    private void m9115d() {
        if (isAttached()) {
            mo46201b();
        }
        V v = this.f10439d;
        if (v != null) {
            v.onDestroy();
        }
        P p = this.f10440e;
        if (p != null) {
            p.onDestroy();
        }
        this.f10439d = null;
        this.f10440e = null;
    }

    public boolean isAttached() {
        ItemViewHolder viewHolder;
        V v = this.f10439d;
        if (v == null || (viewHolder = v.getViewHolder()) == null || viewHolder.itemView == null || viewHolder.itemView.getParent() == null) {
            return false;
        }
        return true;
    }

    public boolean hasAttachFlag() {
        return m9114c(2);
    }

    /* renamed from: a */
    private void m9111a(int i) {
        this.f10438c = i | this.f10438c;
    }

    /* renamed from: b */
    private void m9112b(int i) {
        this.f10438c = (~i) & this.f10438c;
    }

    /* renamed from: c */
    private boolean m9114c(int i) {
        return (i & this.f10438c) != 0;
    }

    /* access modifiers changed from: protected */
    public P getItemPresenter() {
        return this.f10440e;
    }

    /* access modifiers changed from: protected */
    public V getItemView() {
        return this.f10439d;
    }
}
