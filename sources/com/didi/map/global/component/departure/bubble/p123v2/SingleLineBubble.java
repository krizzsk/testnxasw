package com.didi.map.global.component.departure.bubble.p123v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.map.global.component.departure.bubble.DepartureBubble;
import com.taxis99.R;

/* renamed from: com.didi.map.global.component.departure.bubble.v2.SingleLineBubble */
public class SingleLineBubble extends DepartureBubble {

    /* renamed from: a */
    private ViewGroup f27173a;

    /* renamed from: b */
    private TextView f27174b;

    /* renamed from: c */
    private CharSequence f27175c;

    /* renamed from: d */
    private int f27176d = 0;

    public SingleLineBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public SingleLineBubble setText(CharSequence charSequence) {
        this.f27175c = charSequence;
        return this;
    }

    public SingleLineBubble setMaxEms(int i) {
        this.f27176d = i;
        return this;
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bubble_v2_single_text_layout, viewGroup, false);
        this.f27173a = (ViewGroup) inflate.findViewById(R.id.layout_content);
        this.f27174b = (TextView) inflate.findViewById(R.id.tv_text);
        if (this.f27176d <= 0 || this.f27175c.length() <= this.f27176d) {
            this.f27174b.setText(this.f27175c);
        } else {
            this.f27174b.setText(this.f27175c.subSequence(0, this.f27176d) + "...");
        }
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f27173a.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f27173a.setVisibility(4);
    }
}
