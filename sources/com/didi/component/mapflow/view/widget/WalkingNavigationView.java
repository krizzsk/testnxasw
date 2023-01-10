package com.didi.component.mapflow.view.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.UiUtils;
import com.didi.travel.psnger.model.response.StationBoardHintModel;
import com.taxis99.R;

public class WalkingNavigationView extends LinearLayout {

    /* renamed from: a */
    private TextView f16383a;

    /* renamed from: b */
    private ImageView f16384b;

    /* renamed from: c */
    private View f16385c;

    /* renamed from: d */
    private LinearLayout f16386d;

    /* renamed from: e */
    private Context f16387e;

    /* renamed from: f */
    private ImageView f16388f;

    public WalkingNavigationView(Context context) {
        super(context);
        m13732a(context);
        this.f16387e = context;
    }

    public WalkingNavigationView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m13732a(context);
    }

    public WalkingNavigationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m13732a(context);
    }

    public WalkingNavigationView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m13732a(context);
    }

    /* renamed from: a */
    private void m13732a(Context context) {
        inflate(context, R.layout.walking_navigation_layout, this);
        this.f16384b = (ImageView) findViewById(R.id.iv_leftView);
        this.f16383a = (TextView) findViewById(R.id.tv_text);
        this.f16385c = findViewById(R.id.v_tail);
        this.f16386d = (LinearLayout) findViewById(R.id.ll_brand);
        this.f16388f = (ImageView) findViewById(R.id.ic_arrow);
    }

    public void setText(String str) {
        this.f16383a.setText(str);
    }

    public void setTextColor(String str) {
        this.f16383a.setText(str);
    }

    public void setBackGroundColor(String str) {
        setBrandBackground(str);
        setTailBackGround(str);
    }

    private void setBrandBackground(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setColor(Color.parseColor(str));
            gradientDrawable.setCornerRadius((float) UiUtils.dip2px(getContext(), 8.0f));
            this.f16386d.setBackground(gradientDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void setTailBackGround(String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        try {
            gradientDrawable.setColor(Color.parseColor(str));
            this.f16385c.setBackground(gradientDrawable);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void setDate(StationBoardHintModel stationBoardHintModel, boolean z) {
        if (!TextUtils.isEmpty(stationBoardHintModel.mBgColor)) {
            setBackGroundColor(stationBoardHintModel.mBgColor);
        }
        if (!TextUtils.isEmpty(stationBoardHintModel.mIcon)) {
            ((RequestBuilder) Glide.with(this.f16387e).load(stationBoardHintModel.mIcon).placeholder(z ? R.drawable.icon_walking_navigation_bus : R.drawable.icon_walking_navigation_end)).into(this.f16384b);
        }
        if (!TextUtils.isEmpty(stationBoardHintModel.mText)) {
            setText(stationBoardHintModel.mText);
        }
        if (stationBoardHintModel.mShowArrow == 0) {
            this.f16388f.setVisibility(8);
        } else if (stationBoardHintModel.mShowArrow == 1) {
            this.f16388f.setVisibility(0);
        }
    }
}
