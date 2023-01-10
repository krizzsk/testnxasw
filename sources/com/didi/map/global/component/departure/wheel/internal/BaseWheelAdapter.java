package com.didi.map.global.component.departure.wheel.internal;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.List;

public abstract class BaseWheelAdapter<T> extends BaseAdapter {

    /* renamed from: a */
    private int f27687a = 3;

    /* renamed from: b */
    private boolean f27688b = false;

    /* renamed from: c */
    private int f27689c = -1;

    /* renamed from: d */
    private OnClickListener f27690d;
    protected List<T> mList = null;

    public interface OnClickListener {
        void onPositionClick(int i);
    }

    /* access modifiers changed from: protected */
    public abstract View bindView(int i, View view, ViewGroup viewGroup);

    public final void setCurrentPosition(int i) {
        this.f27689c = i;
    }

    public void setOnClickListener(OnClickListener onClickListener) {
        this.f27690d = onClickListener;
    }

    public final int getCount() {
        if (!WheelUtils.isEmpty(this.mList)) {
            return (this.mList.size() + this.f27687a) - 1;
        }
        return 0;
    }

    public final long getItemId(int i) {
        if (!WheelUtils.isEmpty(this.mList)) {
            i %= this.mList.size();
        }
        return (long) i;
    }

    public final T getItem(int i) {
        if (WheelUtils.isEmpty(this.mList)) {
            return null;
        }
        List<T> list = this.mList;
        return list.get(i % list.size());
    }

    public boolean areAllItemsEnabled() {
        return !this.f27688b;
    }

    public boolean isEnabled(int i) {
        if (!this.f27688b || i != this.f27689c + (this.f27687a / 2)) {
            return false;
        }
        return true;
    }

    public final View getView(int i, View view, ViewGroup viewGroup) {
        int i2;
        View view2;
        int i3 = this.f27687a;
        if (i >= i3 / 2 && i < (i3 / 2) + this.mList.size()) {
            i2 = i - (this.f27687a / 2);
        } else {
            i2 = -1;
        }
        if (i2 == -1) {
            view2 = bindView(0, view, viewGroup);
        } else {
            view2 = bindView(i2, view, viewGroup);
        }
        if (i2 == -1) {
            view2.setVisibility(4);
        } else {
            view2.setVisibility(0);
        }
        if (this.f27690d != null) {
            view2.setOnClickListener(new View.OnClickListener(i2) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    BaseWheelAdapter.this.m21887a(this.f$1, view);
                }
            });
        }
        return view2;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m21887a(int i, View view) {
        this.f27690d.onPositionClick(i);
    }

    public final BaseWheelAdapter<T> setClickable(boolean z) {
        if (z != this.f27688b) {
            this.f27688b = z;
            super.notifyDataSetChanged();
        }
        return this;
    }

    public final BaseWheelAdapter<T> setWheelSize(int i) {
        this.f27687a = i;
        super.notifyDataSetChanged();
        return this;
    }

    public final BaseWheelAdapter<T> setData(List<T> list) {
        this.mList = list;
        super.notifyDataSetChanged();
        return this;
    }

    @Deprecated
    public final void notifyDataSetChanged() {
        super.notifyDataSetChanged();
    }

    @Deprecated
    public final void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
    }
}
