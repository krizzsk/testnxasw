package com.didi.beatles.p101im.views;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p101im.access.utils.IMTextUtils;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.IMPadCommonWordItemView */
public class IMPadCommonWordItemView extends FrameLayout {

    /* renamed from: a */
    private static final String f11748a = IMPadCommonWordItemView.class.getSimpleName();

    /* renamed from: b */
    private static final float f11749b = 0.93f;

    /* renamed from: c */
    private RelativeLayout f11750c;

    /* renamed from: d */
    private TextView f11751d;

    /* renamed from: e */
    private TextView f11752e;

    public IMPadCommonWordItemView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMPadCommonWordItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMPadCommonWordItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10081a(context);
    }

    /* renamed from: a */
    private void m10081a(Context context) {
        inflate(context, R.layout.im_pad_common_word_item, this);
        this.f11750c = (RelativeLayout) findViewById(R.id.im_pad_item_container);
        this.f11751d = (TextView) findViewById(R.id.im_pad_item_main_tv);
        this.f11752e = (TextView) findViewById(R.id.im_pad_item_sub_tv);
    }

    public void bind(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (!str.contains(IMTextUtils.DEVIDER_TAG)) {
                this.f11751d.setText(str);
                this.f11752e.setVisibility(8);
                return;
            }
            this.f11752e.setVisibility(0);
            this.f11751d.setText(IMTextUtils.getTitle(str));
            this.f11752e.setText(IMTextUtils.getContent(str));
        }
    }

    /* access modifiers changed from: protected */
    public void dispatchSetPressed(boolean z) {
        super.dispatchSetPressed(z);
        m10082a(z);
    }

    /* renamed from: a */
    private void m10082a(boolean z) {
        RelativeLayout relativeLayout = this.f11750c;
        float f = f11749b;
        relativeLayout.setScaleX(z ? f11749b : 1.0f);
        RelativeLayout relativeLayout2 = this.f11750c;
        if (!z) {
            f = 1.0f;
        }
        relativeLayout2.setScaleY(f);
    }
}
