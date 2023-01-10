package com.didiglobal.privacysdk.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didiglobal.privacysdk.GlobalPrivacySDK;
import com.taxis99.R;

public class TextComponentView extends LinearLayout {

    /* renamed from: a */
    private ViewGroup f53233a;

    /* renamed from: b */
    private TextView f53234b;

    /* renamed from: c */
    private TextView f53235c;

    /* renamed from: d */
    private View f53236d;

    /* renamed from: e */
    private TextView f53237e;

    /* renamed from: f */
    private ImageView f53238f;

    /* renamed from: g */
    private View f53239g;

    /* renamed from: h */
    private TextView f53240h;

    /* renamed from: i */
    private TextView f53241i;

    public TextComponentView(Context context) {
        super(context);
    }

    public TextComponentView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TextComponentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        this.f53233a = (ViewGroup) findViewById(R.id.title_container);
        this.f53234b = (TextView) findViewById(R.id.sidebar_nav_item_name);
        this.f53235c = (TextView) findViewById(R.id.sidebar_nav_item_right_des);
        this.f53236d = findViewById(R.id.setting_list_item_arrow);
        this.f53238f = (ImageView) findViewById(R.id.item_icon);
        this.f53237e = (TextView) findViewById(R.id.item_tip);
        this.f53239g = findViewById(R.id.divider);
        this.f53240h = (TextView) findViewById(R.id.item_right_des_tip);
        this.f53241i = (TextView) findViewById(R.id.description);
        if (GlobalPrivacySDK.isItemTitleBold()) {
            this.f53234b.setTypeface(Typeface.DEFAULT_BOLD);
        }
    }

    public void hideDivider() {
        this.f53239g.setVisibility(8);
    }

    public void setOnItemClickListener(View.OnClickListener onClickListener) {
        this.f53233a.setOnClickListener(onClickListener);
    }

    public void setName(int i) {
        setName(getContext().getResources().getString(i));
    }

    public void setName(String str) {
        this.f53234b.setText(str);
    }

    public void setRightDes(int i) {
        setRightDes(getContext().getResources().getString(i));
    }

    public void setRightDes(String str) {
        this.f53235c.setVisibility(0);
        this.f53235c.setText(str);
    }

    public void setRightDesColor(int i) {
        this.f53235c.setTextColor(i);
    }

    public void setRightDesTipVisible() {
        this.f53240h.setVisibility(0);
    }

    public void setTip(String str) {
        this.f53237e.setVisibility(0);
        this.f53237e.setText(str);
    }

    public void setIcon(Bitmap bitmap) {
        this.f53238f.setVisibility(0);
        this.f53238f.setImageBitmap(bitmap);
    }

    public void setRightArrowVisible(int i) {
        this.f53236d.setVisibility(i);
    }

    public void setDescText(int i) {
        setDescText((CharSequence) getContext().getResources().getString(i));
    }

    public void setDescText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f53241i.setText(charSequence);
            this.f53241i.setVisibility(0);
        }
    }

    public void setDescTextColor(int i) {
        this.f53241i.setTextColor(i);
    }

    public void setDescVisibility(int i) {
        this.f53241i.setVisibility(i);
    }
}
