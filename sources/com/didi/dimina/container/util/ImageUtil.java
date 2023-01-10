package com.didi.dimina.container.util;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.text.TextUtils;
import java.io.ByteArrayOutputStream;

public final class ImageUtil {
    public static Bitmap getBitmap(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return BitmapFactory.decodeFile(str);
    }

    public static byte[] compressByQuality(Bitmap bitmap, int i) {
        return m16827a(bitmap, i, false);
    }

    /* renamed from: a */
    private static byte[] m16827a(Bitmap bitmap, int i, boolean z) {
        if (m16826a(bitmap)) {
            return null;
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, i, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (z && !bitmap.isRecycled()) {
            bitmap.recycle();
        }
        return byteArray;
    }

    /* renamed from: a */
    private static boolean m16826a(Bitmap bitmap) {
        return bitmap == null || bitmap.getWidth() == 0 || bitmap.getHeight() == 0;
    }
}
