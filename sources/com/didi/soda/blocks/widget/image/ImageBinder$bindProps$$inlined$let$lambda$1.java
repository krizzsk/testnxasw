package com.didi.soda.blocks.widget.image;

import android.view.ViewTreeObserver;
import java.util.HashMap;
import kotlin.Metadata;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\u0011\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H\u0016¨\u0006\u0004¸\u0006\u0000"}, mo148868d2 = {"com/didi/soda/blocks/widget/image/ImageBinder$bindProps$1$2", "Landroid/view/ViewTreeObserver$OnPreDrawListener;", "onPreDraw", "", "soda-compose-android_release"}, mo148869k = 1, mo148870mv = {1, 1, 16})
/* compiled from: ImageBinder.kt */
public final class ImageBinder$bindProps$$inlined$let$lambda$1 implements ViewTreeObserver.OnPreDrawListener {
    final /* synthetic */ HashMap $props$inlined;
    final /* synthetic */ ImageBinder this$0;

    ImageBinder$bindProps$$inlined$let$lambda$1(ImageBinder imageBinder, HashMap hashMap) {
        this.this$0 = imageBinder;
        this.$props$inlined = hashMap;
    }

    public boolean onPreDraw() {
        int width = ((RoundedImageView) this.this$0.getView()).getWidth();
        int height = ((RoundedImageView) this.this$0.getView()).getHeight();
        ImageBinder imageBinder = this.this$0;
        imageBinder.loadImage(imageBinder.getSrc(), this.this$0.getPlaceholder(), width, height, this.this$0.getOriginSource());
        ViewTreeObserver viewTreeObserver = ((RoundedImageView) this.this$0.getView()).getViewTreeObserver();
        if (viewTreeObserver != null) {
            viewTreeObserver.removeOnPreDrawListener(this);
        }
        this.this$0.setObserver((ViewTreeObserver.OnPreDrawListener) null);
        return true;
    }
}
