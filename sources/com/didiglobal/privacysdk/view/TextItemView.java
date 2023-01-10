package com.didiglobal.privacysdk.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didiglobal.privacysdk.GlobalPrivacySDK;
import com.taxis99.R;

public class TextItemView extends FrameLayout {

    /* renamed from: a */
    private TextView f53242a;

    /* renamed from: b */
    private TextView f53243b;

    /* renamed from: c */
    private View f53244c;

    /* renamed from: d */
    private View f53245d;

    public TextItemView(Context context) {
        super(context);
        m39814a(context);
    }

    public TextItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m39814a(context);
    }

    public TextItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m39814a(context);
    }

    /* renamed from: a */
    private void m39814a(Context context) {
        LayoutInflater.from(context).inflate(R.layout.global_privacy_text_item, this, true);
        this.f53242a = (TextView) findViewById(R.id.title);
        if (GlobalPrivacySDK.isItemTitleBold()) {
            this.f53242a.setTypeface(Typeface.DEFAULT_BOLD);
        }
        this.f53243b = (TextView) findViewById(R.id.description);
        this.f53244c = findViewById(R.id.bottom);
        this.f53245d = findViewById(R.id.divider);
    }

    public void setDividerVisibility(int i) {
        this.f53245d.setVisibility(i);
    }

    public void setTitle(int i) {
        setTitle(getContext().getResources().getString(i));
    }

    public void setTitle(String str) {
        this.f53242a.setText(str);
    }

    public void setDescText(int i) {
        setDescText((CharSequence) getContext().getResources().getString(i));
    }

    public void setDescText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            this.f53243b.setText(charSequence);
            this.f53243b.setVisibility(0);
            this.f53244c.setVisibility(8);
        }
    }

    public void setDescTextColor(int i) {
        this.f53243b.setTextColor(i);
    }

    public void setDescVisibility(int i) {
        this.f53243b.setVisibility(i);
    }
}
