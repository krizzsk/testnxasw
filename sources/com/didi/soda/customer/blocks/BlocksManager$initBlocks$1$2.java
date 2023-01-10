package com.didi.soda.customer.blocks;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.didi.soda.blocks.sdk.config.IBlocksImageLoader;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000+\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J<\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\b\u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u000b2\u0006\u0010\r\u001a\u00020\u000bH\u0016¨\u0006\u000e"}, mo148868d2 = {"com/didi/soda/customer/blocks/BlocksManager$initBlocks$1$2", "Lcom/didi/soda/blocks/sdk/config/IBlocksImageLoader;", "setImage", "", "url", "", "placeholder", "Landroid/graphics/drawable/Drawable;", "view", "Landroid/widget/ImageView;", "width", "", "height", "originSource", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BlocksManager.kt */
public final class BlocksManager$initBlocks$1$2 implements IBlocksImageLoader {
    BlocksManager$initBlocks$1$2() {
    }

    public void setImage(String str, Drawable drawable, ImageView imageView, int i, int i2, int i3) {
        FlyImageLoader.ImageRequestWrapper imageRequestWrapper;
        Intrinsics.checkNotNullParameter(str, "url");
        if (imageView != null) {
            if (i3 == 1 || i == 0 || i2 == 0) {
                imageRequestWrapper = FlyImageLoader.loadImageUnspecified(imageView.getContext(), str);
            } else if (Math.abs(i2 - i) < Math.abs(i2 - ((i * 3) / 4))) {
                imageRequestWrapper = FlyImageLoader.loadImage1x1(imageView.getContext(), str);
            } else {
                imageRequestWrapper = FlyImageLoader.loadImage4x3(imageView.getContext(), str);
            }
            if (drawable != null) {
                imageRequestWrapper.placeholder(drawable);
            }
            imageRequestWrapper.into(imageView);
        }
    }
}
