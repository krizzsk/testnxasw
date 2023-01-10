package com.didi.map.utils;

import android.graphics.Bitmap;
import android.graphics.Matrix;
import com.didi.soda.blocks.constant.Const;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, mo148868d2 = {"Lcom/didi/map/utils/BitmapUtil;", "", "()V", "scaleBitmap", "Landroid/graphics/Bitmap;", "src", "scale", "", "base-sync-trip_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: BitmapUtil.kt */
public final class BitmapUtil {
    public static final BitmapUtil INSTANCE = new BitmapUtil();

    private BitmapUtil() {
    }

    public final Bitmap scaleBitmap(Bitmap bitmap, float f) {
        Intrinsics.checkNotNullParameter(bitmap, Const.BlockParamConst.SRC);
        try {
            Matrix matrix = new Matrix();
            matrix.postScale(f, f);
            Bitmap createBitmap = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
            Intrinsics.checkNotNullExpressionValue(createBitmap, "createBitmap(src, 0, 0, src.width, src.height, matrix, true)");
            return createBitmap;
        } catch (Exception unused) {
            return bitmap;
        }
    }
}
