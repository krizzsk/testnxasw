package com.didi.map.sdk.departure.internal.bubble;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.taxis99.R;

public class SingleDepartureBubble extends DepartureBubble {

    /* renamed from: a */
    private CharSequence f30600a;

    /* renamed from: b */
    private ViewGroup f30601b;

    public SingleDepartureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public SingleDepartureBubble setText(CharSequence charSequence) {
        this.f30600a = charSequence;
        return this;
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.layout_map_departure_single_bubble_view, viewGroup, false);
        ((TextView) inflate.findViewById(R.id.tv_text)).setText(this.f30600a);
        this.f30601b = (ViewGroup) inflate.findViewById(R.id.layout_content);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f30601b.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f30601b.setVisibility(4);
    }
}
