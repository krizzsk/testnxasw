package com.didi.beatles.p101im.views.imageView;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p101im.views.IMProfileTextView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.imageView.IMProfileCircleImageView */
public class IMProfileCircleImageView extends RelativeLayout {

    /* renamed from: a */
    private IMCircleImageView f12124a;

    /* renamed from: b */
    private IMProfileTextView f12125b;

    public IMProfileCircleImageView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public IMProfileCircleImageView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMProfileCircleImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m10409a();
    }

    /* renamed from: a */
    private void m10409a() {
        LayoutInflater.from(getContext()).inflate(R.layout.imageview_circle_profile, this, true);
        this.f12124a = (IMCircleImageView) findViewById(R.id.circle_iv);
        this.f12125b = (IMProfileTextView) findViewById(R.id.profile_tv);
    }

    public void setImageSrc(Object obj, int i) {
        BtsImageLoader.getInstance().loadInto(obj, (View) this.f12124a, (int) R.drawable.bts_im_general_default_avatar);
    }

    public void setText(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f12125b.setVisibility(8);
            return;
        }
        this.f12125b.setVisibility(0);
        this.f12125b.setText(str);
    }
}
