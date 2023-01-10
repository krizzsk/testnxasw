package com.didi.dimina.starbox.p108ui.base;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.dimina.container.util.LogUtil;
import com.didi.dimina.starbox.p108ui.base.AbsViewBinder;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* renamed from: com.didi.dimina.starbox.ui.base.AbsRecyclerAdapter */
public abstract class AbsRecyclerAdapter<T extends AbsViewBinder, V> extends RecyclerView.Adapter<T> {

    /* renamed from: a */
    private static final String f19978a = "AbsRecyclerAdapter";

    /* renamed from: b */
    private List<V> f19979b;

    /* renamed from: c */
    private LayoutInflater f19980c;

    /* access modifiers changed from: protected */
    public abstract View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int i);

    /* access modifiers changed from: protected */
    public abstract T createViewHolder(View view, int i);

    public AbsRecyclerAdapter(Context context) {
        if (context == null) {
            LogUtil.m16840e(f19978a, "Context should not be null");
            return;
        }
        this.f19979b = new ArrayList();
        this.f19980c = LayoutInflater.from(context);
    }

    public final T onCreateViewHolder(ViewGroup viewGroup, int i) {
        return createViewHolder(createView(this.f19980c, viewGroup, i), i);
    }

    public final void onBindViewHolder(T t, int i) {
        V v = this.f19979b.get(i);
        t.setData(v);
        t.bind(v, i);
    }

    public int getItemCount() {
        return this.f19979b.size();
    }

    public void append(V v) {
        if (v != null) {
            this.f19979b.add(v);
            notifyDataSetChanged();
        }
    }

    public void append(V v, int i) {
        if (v != null) {
            if (i < 0) {
                i = 0;
            } else if (i > this.f19979b.size()) {
                i = this.f19979b.size();
            }
            this.f19979b.add(i, v);
            notifyDataSetChanged();
        }
    }

    public final void append(Collection<V> collection) {
        if (collection != null && collection.size() != 0) {
            this.f19979b.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public final void clear() {
        if (!this.f19979b.isEmpty()) {
            this.f19979b.clear();
            notifyDataSetChanged();
        }
    }

    public final void remove(V v) {
        if (v != null && this.f19979b.contains(v)) {
            this.f19979b.remove(v);
            notifyDataSetChanged();
        }
    }

    public final void remove(int i) {
        if (i < this.f19979b.size()) {
            this.f19979b.remove(i);
            notifyDataSetChanged();
        }
    }

    public final void remove(Collection<V> collection) {
        if (collection != null && collection.size() != 0 && this.f19979b.removeAll(collection)) {
            notifyDataSetChanged();
        }
    }

    public void setData(Collection<V> collection) {
        if (collection != null && collection.size() != 0) {
            if (this.f19979b.size() > 0) {
                this.f19979b.clear();
            }
            this.f19979b.addAll(collection);
            notifyDataSetChanged();
        }
    }

    public List<V> getData() {
        return new ArrayList(this.f19979b);
    }
}
