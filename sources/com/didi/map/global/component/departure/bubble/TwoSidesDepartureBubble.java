package com.didi.map.global.component.departure.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class TwoSidesDepartureBubble extends DepartureBubble {

    /* renamed from: a */
    private CharSequence f27169a;

    /* renamed from: b */
    private CharSequence f27170b;

    /* renamed from: c */
    private CharSequence f27171c;

    /* renamed from: d */
    private ViewGroup f27172d;

    public TwoSidesDepartureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bubble_departure_two_sides_view, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tv_left_first)).setText(this.f27169a);
        ((TextView) inflate.findViewById(R.id.tv_left_second)).setText(this.f27170b);
        ((TextView) inflate.findViewById(R.id.tv_right)).setText(this.f27171c);
        this.f27172d = (ViewGroup) inflate.findViewById(R.id.layout_content);
        return inflate;
    }

    public TwoSidesDepartureBubble setLeftFirstLineText(CharSequence charSequence) {
        this.f27169a = charSequence;
        return this;
    }

    public TwoSidesDepartureBubble setLeftSecondLineText(CharSequence charSequence) {
        this.f27170b = charSequence;
        return this;
    }

    public TwoSidesDepartureBubble setRightText(CharSequence charSequence) {
        this.f27171c = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f27172d.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f27172d.setVisibility(4);
    }
}
