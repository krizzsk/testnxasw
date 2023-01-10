package com.didi.map.global.component.departure.bubble;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.cardview.widget.CardView;
import com.bumptech.glide.Glide;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.component.departure.model.AddressWalkGuide;
import com.taxis99.R;

public class DepartureWalkGuide extends CardView {

    /* renamed from: a */
    private int f27158a;

    /* renamed from: b */
    private int f27159b;

    /* renamed from: c */
    private int f27160c;

    /* renamed from: d */
    private ImageView f27161d;

    /* renamed from: e */
    private AddressWalkGuide f27162e;

    public DepartureWalkGuide(Context context) {
        this(context, (AttributeSet) null);
    }

    public DepartureWalkGuide(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DepartureWalkGuide(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f27158a = DisplayUtils.dp2px(context, 80.0f);
        this.f27159b = DisplayUtils.dp2px(context, 80.0f);
        this.f27160c = DisplayUtils.dp2px(context, 20.0f);
        setRadius((float) DisplayUtils.dp2px(context, 15.0f));
        this.f27161d = (ImageView) LayoutInflater.from(context).inflate(R.layout.layout_map_departure_walk_guide, this).findViewById(R.id.departure_image_guide);
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        ImageView imageView = this.f27161d;
        if (imageView != null) {
            imageView.setOnClickListener(onClickListener);
        }
    }

    public void setData(AddressWalkGuide addressWalkGuide) {
        if (addressWalkGuide != null && addressWalkGuide.isValid()) {
            this.f27162e = addressWalkGuide;
            Glide.with(getContext()).load(addressWalkGuide.getGuidePhoto()).into(this.f27161d);
        }
    }

    public int getWIDTH() {
        return this.f27158a;
    }

    public int getHEIGHT() {
        return this.f27159b;
    }

    public int getANGLE() {
        return this.f27160c;
    }
}
