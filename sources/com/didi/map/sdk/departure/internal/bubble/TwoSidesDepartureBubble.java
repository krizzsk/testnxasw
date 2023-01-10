package com.didi.map.sdk.departure.internal.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class TwoSidesDepartureBubble extends DepartureBubble {

    /* renamed from: a */
    private CharSequence f30602a;

    /* renamed from: b */
    private CharSequence f30603b;

    /* renamed from: c */
    private CharSequence f30604c;

    /* renamed from: d */
    private ViewGroup f30605d;

    public TwoSidesDepartureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_map_departure_two_sides_bubble_view, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tv_left_first)).setText(this.f30602a);
        ((TextView) inflate.findViewById(R.id.tv_left_second)).setText(this.f30603b);
        ((TextView) inflate.findViewById(R.id.tv_right)).setText(this.f30604c);
        this.f30605d = (ViewGroup) inflate.findViewById(R.id.layout_content);
        return inflate;
    }

    public TwoSidesDepartureBubble setLeftFirstLineText(CharSequence charSequence) {
        this.f30602a = charSequence;
        return this;
    }

    public TwoSidesDepartureBubble setLeftSecondLineText(CharSequence charSequence) {
        this.f30603b = charSequence;
        return this;
    }

    public TwoSidesDepartureBubble setRightText(CharSequence charSequence) {
        this.f30604c = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f30605d.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f30605d.setVisibility(4);
    }
}
