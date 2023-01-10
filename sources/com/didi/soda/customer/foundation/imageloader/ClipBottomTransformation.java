package com.didi.soda.customer.foundation.imageloader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import com.bumptech.glide.util.C1850Util;
import java.nio.ByteBuffer;
import java.security.MessageDigest;

public class ClipBottomTransformation extends BitmapTransformation {

    /* renamed from: a */
    private static final String f43503a = "com.didi.soda.customer.foundation.imageloader.ClipBottomTransformation";

    /* renamed from: b */
    private static final byte[] f43504b = f43503a.getBytes(CHARSET);

    /* renamed from: c */
    private int f43505c;

    /* renamed from: d */
    private int f43506d;

    /* renamed from: e */
    private int f43507e;

    /* renamed from: f */
    private int f43508f;

    public ClipBottomTransformation(Context context, int i, int i2, int i3) {
        this.f43505c = i3;
        this.f43506d = i;
        this.f43507e = i2;
        this.f43508f = (i + String.valueOf(i2) + i3).hashCode();
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        messageDigest.update(f43504b);
        messageDigest.update(ByteBuffer.allocate(4).putInt(this.f43508f).array());
    }

    public boolean equals(Object obj) {
        if (obj instanceof ClipBottomTransformation) {
            ClipBottomTransformation clipBottomTransformation = (ClipBottomTransformation) obj;
            return clipBottomTransformation.f43505c == this.f43505c && clipBottomTransformation.f43506d == this.f43506d && clipBottomTransformation.f43507e == this.f43507e;
        }
    }

    public int hashCode() {
        return C1850Util.hashCode(672007565, C1850Util.hashCode(this.f43508f));
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Bitmap bitmap2;
        int width = bitmap.getWidth();
        Bitmap bitmap3 = bitmapPool.get(width, bitmap.getHeight(), bitmap.getConfig() != null ? bitmap.getConfig() : Bitmap.Config.ARGB_8888);
        if (bitmap3 == null) {
            bitmap2 = Bitmap.createBitmap(width, (this.f43507e * width) / this.f43506d, Bitmap.Config.ARGB_8888);
        } else {
            int i3 = (this.f43507e * width) / this.f43506d;
            if (i3 > bitmap3.getHeight()) {
                i3 = bitmap3.getHeight();
            }
            bitmap2 = Bitmap.createBitmap(bitmap3, 0, 0, width > bitmap3.getWidth() ? bitmap3.getWidth() : width, i3);
        }
        bitmap2.setHasAlpha(true);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        canvas.drawBitmap(bitmap2, (Rect) null, new Rect(0, 0, this.f43506d, this.f43507e), paint);
        RectF rectF = new RectF(0.0f, 0.0f, (float) width, (float) ((this.f43507e * width) / this.f43506d));
        int i4 = this.f43505c;
        canvas.drawRoundRect(rectF, (float) i4, (float) i4, paint);
        return bitmap2;
    }
}
