package com.didi.sdk.view.titlebar;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.sdk.view.dialog.ProductControllerStyleManager;
import com.taxis99.R;

public class CommonPopupTitleBar extends RelativeLayout {

    /* renamed from: a */
    private TextView f41024a;

    /* renamed from: b */
    private TextView f41025b;

    /* renamed from: c */
    private TextView f41026c;

    /* renamed from: d */
    private TextView f41027d;

    public CommonPopupTitleBar(Context context) {
        super(context);
        m30756a();
    }

    public CommonPopupTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m30756a();
    }

    public CommonPopupTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m30756a();
    }

    public CommonPopupTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m30756a();
    }

    public TextView getTvTitle() {
        return this.f41026c;
    }

    public void setLeft(String str, View.OnClickListener onClickListener) {
        this.f41024a.setVisibility(0);
        this.f41024a.setText(str);
        this.f41024a.setOnClickListener(onClickListener);
    }

    public void setLeftText(String str) {
        this.f41024a.setVisibility(0);
        this.f41024a.setText(str);
    }

    public void setRightText(String str) {
        this.f41025b.setVisibility(0);
        this.f41025b.setText(str);
    }

    public void setLeft(View.OnClickListener onClickListener) {
        this.f41024a.setVisibility(0);
        this.f41024a.setOnClickListener(onClickListener);
    }

    public void setRight(String str, View.OnClickListener onClickListener) {
        this.f41025b.setVisibility(0);
        this.f41025b.setText(str);
        this.f41025b.setOnClickListener(onClickListener);
    }

    public void setMessage(String str) {
        this.f41027d.setVisibility(0);
        this.f41027d.setText(str);
    }

    public void setRight(View.OnClickListener onClickListener) {
        this.f41025b.setVisibility(0);
        this.f41025b.setOnClickListener(onClickListener);
    }

    public void setTitle(String str) {
        this.f41026c.setVisibility(0);
        this.f41026c.setText(str);
    }

    /* renamed from: a */
    private void m30756a() {
        LayoutInflater.from(getContext()).inflate(R.layout.v_common_popup_title_bar, this, true);
        this.f41024a = (TextView) findViewById(R.id.tv_cancel);
        this.f41025b = (TextView) findViewById(R.id.tv_confirm);
        this.f41026c = (TextView) findViewById(R.id.tv_title);
        this.f41027d = (TextView) findViewById(R.id.tv_message);
        int productBasicColor = ProductControllerStyleManager.getInstance().getProductThemeStyle().getProductBasicColor();
        if (productBasicColor != 0) {
            this.f41025b.setTextColor(productBasicColor);
        }
    }
}
