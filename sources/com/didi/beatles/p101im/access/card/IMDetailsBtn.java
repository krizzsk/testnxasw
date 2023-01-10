package com.didi.beatles.p101im.access.card;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.beatles.p101im.resource.IMResource;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.access.card.IMDetailsBtn */
public class IMDetailsBtn extends LinearLayout {

    /* renamed from: a */
    private TextView f10555a;

    /* renamed from: b */
    private ImageView f10556b;

    public IMDetailsBtn(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMDetailsBtn(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMDetailsBtn(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9213a();
    }

    /* renamed from: a */
    private void m9213a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.im_msg_card_btn, this, true);
        this.f10555a = (TextView) inflate.findViewById(R.id.detail_tv);
        this.f10556b = (ImageView) inflate.findViewById(R.id.detail_iv);
        this.f10555a.setText(IMResource.getString(R.string.im_nomix_see_details));
        this.f10555a.setTextColor(IMResource.getColor(R.color.im_nomix_detail_btn_color));
        this.f10556b.setImageResource(IMResource.getDrawableID(R.drawable.im_nomix_follow_bts_arrow));
    }
}
