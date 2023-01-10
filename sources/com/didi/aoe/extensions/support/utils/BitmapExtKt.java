package com.didi.aoe.extensions.support.utils;

import android.graphics.Bitmap;
import android.os.Build;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148866bv = {1, 0, 3}, mo148867d1 = {"\u0000\f\n\u0000\n\u0002\u0010\b\n\u0002\u0018\u0002\n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002¨\u0006\u0003"}, mo148868d2 = {"getCompatAllocationByteCount", "", "Landroid/graphics/Bitmap;", "support_release"}, mo148869k = 2, mo148870mv = {1, 1, 15})
/* compiled from: BitmapExt.kt */
public final class BitmapExtKt {
    public static final int getCompatAllocationByteCount(Bitmap bitmap) {
        Intrinsics.checkParameterIsNotNull(bitmap, "$this$getCompatAllocationByteCount");
        if (Build.VERSION.SDK_INT >= 19) {
            return bitmap.getAllocationByteCount();
        }
        return bitmap.getByteCount();
    }
}
