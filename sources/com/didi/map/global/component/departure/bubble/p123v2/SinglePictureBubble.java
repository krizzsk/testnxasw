package com.didi.map.global.component.departure.bubble.p123v2;

import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.core.graphics.drawable.RoundedBitmapDrawable;
import androidx.core.graphics.drawable.RoundedBitmapDrawableFactory;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.didi.common.map.util.DLog;
import com.didi.map.global.component.departure.bubble.DepartureBubble;
import com.taxis99.R;

/* renamed from: com.didi.map.global.component.departure.bubble.v2.SinglePictureBubble */
public class SinglePictureBubble extends DepartureBubble {

    /* renamed from: a */
    private CharSequence f27177a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f27178b;

    /* renamed from: c */
    private View f27179c = null;

    public SinglePictureBubble(ViewGroup viewGroup) {
        super(viewGroup);
    }

    public SinglePictureBubble setUrl(Context context, CharSequence charSequence) {
        this.f27177a = charSequence;
        this.f27178b = context;
        return this;
    }

    /* access modifiers changed from: protected */
    public View getView(ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.bubble_v2_single_pic_layout, viewGroup, false);
        this.f27179c = inflate;
        final ImageView imageView = (ImageView) inflate.findViewById(R.id.iv_pic);
        try {
            ((RequestBuilder) Glide.with(this.f27178b).asBitmap().load((Object) this.f27177a).centerCrop()).into(new BitmapImageViewTarget(imageView) {
                /* access modifiers changed from: protected */
                public void setResource(Bitmap bitmap) {
                    RoundedBitmapDrawable create = RoundedBitmapDrawableFactory.create(SinglePictureBubble.this.f27178b.getResources(), bitmap);
                    create.setCornerRadius(15.0f);
                    imageView.setImageDrawable(create);
                }
            });
        } catch (Exception e) {
            DLog.m10773d("glide", "glide load  Exception:" + e.toString(), new Object[0]);
        }
        return this.f27179c;
    }

    /* access modifiers changed from: protected */
    public void setContentVisible() {
        this.f27179c.setVisibility(0);
    }

    /* access modifiers changed from: protected */
    public void setContentInvisible() {
        this.f27179c.setVisibility(4);
    }
}
