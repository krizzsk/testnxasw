package com.didi.component.common.util;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.BitmapTransformation;
import java.security.MessageDigest;

public class GlideCircleTransform extends BitmapTransformation {

    /* renamed from: a */
    private Paint f13595a;

    /* renamed from: b */
    private float f13596b;

    /* renamed from: c */
    private int f13597c = 0;

    /* renamed from: d */
    private int f13598d = 0;

    /* renamed from: e */
    private int f13599e = 0;

    public void updateDiskCacheKey(MessageDigest messageDigest) {
    }

    public GlideCircleTransform(Context context) {
    }

    public GlideCircleTransform(Context context, float f, int i) {
        this.f13596b = Resources.getSystem().getDisplayMetrics().density * f;
        this.f13596b = UIUtils.dip2px(context, f);
        Paint paint = new Paint();
        this.f13595a = paint;
        paint.setDither(true);
        this.f13595a.setAntiAlias(true);
        this.f13595a.setColor(i);
        this.f13595a.setStyle(Paint.Style.STROKE);
        this.f13595a.setStrokeWidth(this.f13596b);
    }

    public GlideCircleTransform(Context context, float f, int i, int i2, int i3) {
        this.f13596b = Resources.getSystem().getDisplayMetrics().density * f;
        this.f13596b = UIUtils.dip2px(context, f);
        Paint paint = new Paint();
        this.f13595a = paint;
        paint.setDither(true);
        this.f13595a.setAntiAlias(true);
        this.f13595a.setColor(i);
        this.f13595a.setStyle(Paint.Style.STROKE);
        this.f13595a.setStrokeWidth(this.f13596b);
        this.f13598d = i3;
        this.f13597c = i2;
        this.f13599e = i;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        if (this.f13598d > 0) {
            return m11366a(bitmapPool, bitmap, i, i2);
        }
        return m11365a(bitmapPool, bitmap);
    }

    /* renamed from: a */
    private Bitmap m11365a(BitmapPool bitmapPool, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        int min = (int) (((float) Math.min(bitmap.getWidth(), bitmap.getHeight())) - (this.f13596b / 2.0f));
        Bitmap createBitmap = Bitmap.createBitmap(bitmap, (bitmap.getWidth() - min) / 2, (bitmap.getHeight() - min) / 2, min, min);
        Bitmap bitmap2 = bitmapPool.get(min, min, Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(min, min, Bitmap.Config.ARGB_8888);
        }
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(createBitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        float f = ((float) min) / 2.0f;
        canvas.drawCircle(f, f, f, paint);
        Paint paint2 = this.f13595a;
        if (paint2 != null) {
            canvas.drawCircle(f, f, f - (this.f13596b / 2.0f), paint2);
        }
        return bitmap2;
    }

    /* renamed from: a */
    private Bitmap m11366a(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        if (bitmap == null) {
            return null;
        }
        int i3 = this.f13598d;
        bitmapPool.get(i3, i3, Bitmap.Config.ARGB_8888);
        int i4 = this.f13598d;
        Bitmap createBitmap = Bitmap.createBitmap(i4, i4, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        Paint paint = new Paint();
        paint.setColor(this.f13599e);
        paint.setAntiAlias(true);
        int i5 = this.f13598d;
        RectF rectF = new RectF(new Rect(0, 0, i5, i5));
        int i6 = this.f13598d;
        canvas.drawRoundRect(rectF, (float) i6, (float) i6, paint);
        return m11364a(makeRoundCorner(createBitmap, this.f13598d, this.f13599e), makeRoundCorner(bitmap, (int) (((float) this.f13598d) - (this.f13596b * 2.0f)), 0));
    }

    public Bitmap makeRoundCorner(Bitmap bitmap, int i, int i2) {
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        if (i2 == 0) {
            i2 = -1;
        }
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, i, i);
        RectF rectF = new RectF(rect);
        paint.setAntiAlias(true);
        canvas.drawARGB(0, 0, 0, 0);
        paint.setColor(i2);
        float f = (float) i;
        canvas.drawRoundRect(rectF, f, f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(Bitmap.createScaledBitmap(bitmap, i, i, true), rect, rect, paint);
        return createBitmap;
    }

    /* renamed from: a */
    private Bitmap m11364a(Bitmap bitmap, Bitmap bitmap2) {
        int i = this.f13598d;
        Bitmap createBitmap = Bitmap.createBitmap(i, i, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(createBitmap);
        int i2 = this.f13598d;
        Bitmap createScaledBitmap = Bitmap.createScaledBitmap(bitmap, i2, i2, true);
        int i3 = this.f13598d;
        Rect rect = new Rect(0, 0, i3, i3);
        int i4 = this.f13598d;
        canvas.drawBitmap(createScaledBitmap, rect, new Rect(0, 0, i4, i4), (Paint) null);
        int i5 = this.f13598d;
        float f = this.f13596b;
        Bitmap createScaledBitmap2 = Bitmap.createScaledBitmap(bitmap2, (int) (((float) i5) - (f * 2.0f)), (int) (((float) i5) - (f * 2.0f)), true);
        int i6 = this.f13598d;
        float f2 = this.f13596b;
        Rect rect2 = new Rect(0, 0, (int) (((float) i6) - (f2 * 2.0f)), (int) (((float) i6) - (f2 * 2.0f)));
        float f3 = this.f13596b;
        int i7 = this.f13598d;
        canvas.drawBitmap(createScaledBitmap2, rect2, new Rect((int) f3, (int) f3, (int) (((float) i7) - f3), (int) (((float) i7) - f3)), (Paint) null);
        return createBitmap;
    }
}
