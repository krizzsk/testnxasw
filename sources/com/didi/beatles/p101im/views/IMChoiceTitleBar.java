package com.didi.beatles.p101im.views;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.beatles.p101im.resource.IMResource;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.IMChoiceTitleBar */
public class IMChoiceTitleBar extends RelativeLayout {

    /* renamed from: a */
    private TextView f11701a;

    /* renamed from: b */
    private TextView f11702b;

    /* renamed from: c */
    private TextView f11703c;

    public IMChoiceTitleBar(Context context) {
        super(context);
        m10060a();
    }

    public IMChoiceTitleBar(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10060a();
    }

    public IMChoiceTitleBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10060a();
    }

    public IMChoiceTitleBar(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
        m10060a();
    }

    /* renamed from: a */
    private void m10060a() {
        LayoutInflater.from(getContext()).inflate(R.layout.im_choice_title_bar, this, true);
        this.f11701a = (TextView) findViewById(R.id.left_tv);
        this.f11702b = (TextView) findViewById(R.id.middle_tv);
        this.f11703c = (TextView) findViewById(R.id.right_tv);
    }

    public TextView getLeftImgView() {
        return this.f11701a;
    }

    public TextView getRightTextView() {
        return this.f11703c;
    }

    public void setChoiceCount(int i) {
        setVisibility(0);
        if (i > 0) {
            if (i > 1) {
                this.f11702b.setText(String.format(IMResource.getString(R.string.im_have_choices), new Object[]{Integer.valueOf(i)}));
            } else {
                this.f11702b.setText(String.format(IMResource.getString(R.string.im_have_choice), new Object[]{Integer.valueOf(i)}));
            }
            this.f11703c.setClickable(true);
            this.f11703c.setTextColor(IMResource.getColor(R.color.im_nomix_orange));
            return;
        }
        this.f11702b.setText(IMResource.getString(R.string.im_choose_msg));
        this.f11703c.setClickable(false);
        this.f11703c.setTextColor(IMResource.getColor(R.color.bts_im_color_light_gray_s));
    }

    public void showChoiceBar() {
        setVisibility(0);
    }

    public void hideChoiceBar() {
        setVisibility(8);
    }
}
