package com.didi.payment.base.adapter;

import android.content.Context;
import android.util.SparseArray;
import android.view.View;
import androidx.recyclerview.widget.RecyclerView;

public class BaseViewHolder extends RecyclerView.ViewHolder {

    /* renamed from: a */
    private final SparseArray<View> f32313a = new SparseArray<>();

    public BaseViewHolder(View view) {
        super(view);
    }

    public <V extends View> V findViewById(int i) {
        V v = (View) this.f32313a.get(i);
        if (v != null) {
            return v;
        }
        V findViewById = this.itemView.findViewById(i);
        if (findViewById == null) {
            return null;
        }
        this.f32313a.put(i, findViewById);
        return findViewById;
    }

    public Context getContext() {
        return this.itemView.getContext();
    }
}
