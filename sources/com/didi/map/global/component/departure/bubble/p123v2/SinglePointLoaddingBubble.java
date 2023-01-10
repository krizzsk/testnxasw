package com.didi.map.global.component.departure.bubble.p123v2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.map.global.component.departure.bubble.DepartureBubble;
import com.taxis99.R;

/* renamed from: com.didi.map.global.component.departure.bubble.v2.SinglePointLoaddingBubble */
public class SinglePointLoaddingBubble extends DepartureBubble {

    /* renamed from: a */
    private ViewGroup f27180a;

    public SinglePointLoaddingBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bubble_v2_single_point_loadding_layout, viewGroup, false);
        this.f27180a = (ViewGroup) inflate.findViewById(R.id.layout_content);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f27180a.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f27180a.setVisibility(4);
    }
}
