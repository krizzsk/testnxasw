package com.didi.map.global.component.departure.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class SingleDepartureBubble extends DepartureBubble {

    /* renamed from: a */
    private ViewGroup f27165a;

    /* renamed from: b */
    private TextView f27166b;

    /* renamed from: c */
    private CharSequence f27167c;

    /* renamed from: d */
    private int f27168d = 0;

    public SingleDepartureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public SingleDepartureBubble setText(CharSequence charSequence) {
        this.f27167c = charSequence;
        return this;
    }

    public SingleDepartureBubble setMaxEms(int i) {
        this.f27168d = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bubble_departure_single_view, viewGroup, false);
        this.f27165a = (ViewGroup) inflate.findViewById(R.id.layout_content);
        this.f27166b = (TextView) inflate.findViewById(R.id.tv_text);
        if (this.f27168d <= 0 || this.f27167c.length() <= this.f27168d) {
            this.f27166b.setText(this.f27167c);
        } else {
            this.f27166b.setText(this.f27167c.subSequence(0, this.f27168d) + "...");
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f27165a.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f27165a.setVisibility(4);
    }
}
