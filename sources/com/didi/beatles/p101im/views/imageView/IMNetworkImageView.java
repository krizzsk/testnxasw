package com.didi.beatles.p101im.views.imageView;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import androidx.appcompat.widget.AppCompatImageView;
import com.didi.beatles.p101im.utils.imageloader.BtsImageLoader;

/* renamed from: com.didi.beatles.im.views.imageView.IMNetworkImageView */
public class IMNetworkImageView extends AppCompatImageView {

    /* renamed from: a */
    private BtsImageLoader f12122a;

    /* renamed from: b */
    private String f12123b;

    public IMNetworkImageView(Context context) {
        super(context);
    }

    public IMNetworkImageView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public IMNetworkImageView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    /* renamed from: a */
    private void m10408a() {
        if (this.f12122a == null) {
            this.f12122a = BtsImageLoader.getInstance();
            if (getContext() != null) {
                this.f12122a.with(getContext());
            }
        }
    }

    public String getImageSourceUrl() {
        return this.f12123b;
    }

    public void loadImageUrl(String str, int i) {
        m10408a();
        if (!str.equals(this.f12123b)) {
            this.f12123b = str;
            if (i == -1) {
                this.f12122a.loadInto(str, this);
            } else {
                this.f12122a.loadInto((Object) str, (View) this, i);
            }
        }
    }
}
