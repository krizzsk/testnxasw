package com.didi.globalsafetoolkit.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.globalsafetoolkit.util.SfViewUtils;
import com.didi.passenger.C11267R;
import com.taxis99.R;

public class SfCommonTitleBar extends RelativeLayout {

    /* renamed from: a */
    private ImageView f25213a;

    /* renamed from: b */
    private ImageView f25214b;

    /* renamed from: c */
    private TextView f25215c;

    /* renamed from: d */
    private TextView f25216d;

    /* renamed from: e */
    private FrameLayout f25217e;

    /* renamed from: f */
    private int f25218f;

    public SfCommonTitleBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public SfCommonTitleBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SfCommonTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.SfCommonTitleBar);
        Drawable drawable = obtainStyledAttributes.getDrawable(0);
        Drawable drawable2 = obtainStyledAttributes.getDrawable(2);
        Drawable drawable3 = obtainStyledAttributes.getDrawable(3);
        String string = obtainStyledAttributes.getString(4);
        int i2 = obtainStyledAttributes.getInt(5, 0);
        this.f25218f = obtainStyledAttributes.getDimensionPixelSize(1, SfViewUtils.dp2px(context, 54.0f));
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.sf_common_titlebar, this, true);
        ImageView imageView = (ImageView) findViewById(R.id.sf_left_btn);
        this.f25213a = imageView;
        imageView.setContentDescription(context.getString(R.string.sf_title_bar_cancel_dest));
        this.f25214b = (ImageView) findViewById(R.id.sf_right_btn);
        this.f25215c = (TextView) findViewById(R.id.sf_tv_right_btn);
        this.f25216d = (TextView) findViewById(R.id.sf_title_text);
        this.f25217e = (FrameLayout) findViewById(R.id.sf_loading);
        inflate.setBackground(drawable);
        if (drawable2 != null) {
            this.f25213a.setImageDrawable(drawable2);
        }
        if (drawable3 != null) {
            this.f25214b.setVisibility(0);
            this.f25214b.setImageDrawable(drawable3);
            this.f25215c.setVisibility(8);
        }
        setTitleText(TextUtils.isEmpty(string) ? "" : string);
        if (i2 == 1) {
            TextView textView = this.f25216d;
            textView.setTypeface(textView.getTypeface(), 1);
        }
        obtainStyledAttributes.recycle();
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        ViewGroup.LayoutParams layoutParams = getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = this.f25218f;
            setLayoutParams(layoutParams);
        }
    }

    public void setLeftBtnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f25213a.setOnClickListener(onClickListener);
        }
    }

    public void setRightBtnClickListener(View.OnClickListener onClickListener) {
        if (onClickListener != null) {
            this.f25214b.setOnClickListener(onClickListener);
        }
    }

    public void setLeftBtnSrc(int i) {
        if (i != 0) {
            this.f25213a.setImageResource(i);
        }
    }

    public void setRightBtnSrc(int i) {
        if (i != 0) {
            this.f25214b.setVisibility(0);
            this.f25214b.setImageResource(i);
        }
    }

    public void setRightBtnVisible(int i) {
        ImageView imageView = this.f25214b;
        if (imageView != null) {
            imageView.setVisibility(i);
        }
    }

    public void setRightTextView(String str, View.OnClickListener onClickListener) {
        if (TextUtils.isEmpty(str)) {
            this.f25215c.setVisibility(8);
            return;
        }
        this.f25215c.setVisibility(0);
        this.f25215c.setText(str);
        this.f25215c.setOnClickListener(onClickListener);
    }

    public void setTitleText(String str) {
        this.f25216d.setText(str);
    }

    public FrameLayout getLoadingFallback() {
        return this.f25217e;
    }
}
