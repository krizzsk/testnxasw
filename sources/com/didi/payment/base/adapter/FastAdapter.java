package com.didi.payment.base.adapter;

import android.view.LayoutInflater;
import android.view.ViewGroup;

public abstract class FastAdapter<T> extends BaseAdapter<T, BaseViewHolder> {

    /* renamed from: a */
    private final int f32314a;
    protected LayoutInflater inflater;

    public FastAdapter(int i) {
        this.f32314a = i;
    }

    public BaseViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        if (this.inflater == null) {
            this.inflater = LayoutInflater.from(viewGroup.getContext());
        }
        return new BaseViewHolder(this.inflater.inflate(i, viewGroup, false));
    }

    public int getItemViewType(int i) {
        return this.f32314a;
    }
}
