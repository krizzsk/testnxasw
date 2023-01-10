package com.didi.onekeyshare.callback.intercept;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import java.io.ByteArrayOutputStream;

public final class BitmapUtil {

    /* renamed from: a */
    private static final int f32225a = 500;

    /* renamed from: b */
    private static final int f32226b = 400;

    public static byte[] compressionByte(byte[] bArr) {
        if (bArr == null || bArr.length == 0) {
            return null;
        }
        Bitmap decodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(decodeByteArray, 500, 400, true);
        decodeByteArray.recycle();
        return m24491a(createScaledBitmap, true);
    }

    /* renamed from: a */
    private static byte[] m24491a(Bitmap bitmap, boolean z) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        if (z) {
            bitmap.recycle();
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        try {
            byteArrayOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return byteArray;
    }
}
