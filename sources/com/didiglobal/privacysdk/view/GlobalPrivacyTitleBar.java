package com.didiglobal.privacysdk.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.taxis99.R;

public class GlobalPrivacyTitleBar extends FrameLayout {

    /* renamed from: a */
    private ViewGroup f53223a;

    /* renamed from: b */
    private ImageView f53224b;

    /* renamed from: c */
    private ImageView f53225c;

    /* renamed from: d */
    private TextView f53226d;

    /* renamed from: e */
    private TextView f53227e;

    public GlobalPrivacyTitleBar(Context context) {
        super(context);
        m39810a(context);
    }

    public GlobalPrivacyTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m39810a(context);
    }

    public GlobalPrivacyTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m39810a(context);
    }

    /* renamed from: a */
    private void m39810a(Context context) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.global_privacy_title_bar, this);
        this.f53223a = (ViewGroup) inflate.findViewById(R.id.img_left_small_container);
        this.f53224b = (ImageView) inflate.findViewById(R.id.img_left_small);
        this.f53225c = (ImageView) inflate.findViewById(R.id.img_left_large);
        this.f53226d = (TextView) inflate.findViewById(R.id.txt_title_mid);
        this.f53227e = (TextView) inflate.findViewById(R.id.txt_title_left);
    }

    public void setLeftImgRes(int i) {
        this.f53225c.setImageResource(i);
        this.f53225c.setVisibility(0);
        this.f53223a.setVisibility(8);
    }

    public void setLeftSmallImgRes(int i) {
        this.f53224b.setBackgroundResource(i);
        this.f53225c.setVisibility(8);
        this.f53223a.setVisibility(0);
    }

    public void setOnLeftImgClickListener(View.OnClickListener onClickListener) {
        this.f53223a.setOnClickListener(onClickListener);
        this.f53225c.setOnClickListener(onClickListener);
    }

    public void setLeftTitle(int i) {
        this.f53227e.setText(i);
        this.f53227e.setVisibility(0);
        this.f53226d.setVisibility(8);
    }

    public void setMidTitle(int i) {
        this.f53226d.setText(i);
        this.f53226d.setVisibility(0);
        this.f53227e.setVisibility(8);
    }

    public void setTitleColor(int i) {
        this.f53226d.setTextColor(i);
        this.f53227e.setTextColor(i);
    }
}
