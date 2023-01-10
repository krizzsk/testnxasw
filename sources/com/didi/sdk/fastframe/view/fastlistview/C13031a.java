package com.didi.sdk.fastframe.view.fastlistview;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* renamed from: com.didi.sdk.fastframe.view.fastlistview.a */
/* compiled from: ViewHolder */
class C13031a {

    /* renamed from: a */
    private SparseArray<View> f38695a = new SparseArray<>();

    /* renamed from: b */
    private View f38696b;

    private C13031a(Context context, ViewGroup viewGroup, int i) {
        View inflate = LayoutInflater.from(context).inflate(i, viewGroup, false);
        this.f38696b = inflate;
        inflate.setTag(this);
    }

    /* renamed from: a */
    static C13031a m29171a(Context context, View view, ViewGroup viewGroup, int i) {
        if (view == null) {
            return new C13031a(context, viewGroup, i);
        }
        return (C13031a) view.getTag();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo98125a(int i) {
        View view = this.f38695a.get(i);
        if (view != null) {
            return view;
        }
        View findViewById = this.f38696b.findViewById(i);
        this.f38695a.put(i, findViewById);
        return findViewById;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public View mo98124a() {
        return this.f38696b;
    }
}
