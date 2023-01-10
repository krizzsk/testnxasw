package com.didi.beatles.p101im.views.bottombar.tab;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.beatles.p101im.utils.IMViewUtil;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.bottombar.tab.IMBtmTabContentView */
public class IMBtmTabContentView extends LinearLayout {

    /* renamed from: a */
    private static final String f11955a = IMBtmTabContentView.class.getSimpleName();

    /* renamed from: b */
    private ImageView f11956b;

    /* renamed from: c */
    private TextView f11957c;

    /* renamed from: d */
    private View f11958d;

    public IMBtmTabContentView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMBtmTabContentView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMBtmTabContentView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        setOrientation(0);
        inflate(context, R.layout.im_btm_tab_content_view, this);
        this.f11956b = (ImageView) findViewById(R.id.im_tab_icon);
        this.f11957c = (TextView) findViewById(R.id.im_tab_text);
        this.f11958d = findViewById(R.id.im_tab_dot);
    }

    public void bindData(String str, int i) {
        this.f11956b.setImageResource(i);
        this.f11957c.setText(str);
    }

    public void setSelected(boolean z) {
        super.setSelected(z);
    }

    public void setDotVisible(int i) {
        if (i == 0) {
            IMViewUtil.show(this.f11958d);
        } else {
            IMViewUtil.hide(this.f11958d);
        }
    }
}
