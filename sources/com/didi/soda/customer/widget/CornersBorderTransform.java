package com.didi.soda.customer.widget;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.Shader;
import com.bumptech.glide.load.engine.bitmap_recycle.BitmapPool;
import com.bumptech.glide.load.resource.bitmap.CenterCrop;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 )2\u00020\u0001:\u0001)B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0003¢\u0006\u0002\u0010\u0007J0\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00032\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u0012H\u0002J\u0013\u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0002J\b\u0010\u001a\u001a\u00020\u001bH\u0002J\b\u0010\u001c\u001a\u00020\u0005H\u0016J\u001c\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u001eH\u0002J*\u0010\"\u001a\u0004\u0018\u00010\u001e2\u0006\u0010\u001f\u001a\u00020 2\u0006\u0010#\u001a\u00020\u001e2\u0006\u0010$\u001a\u00020\u00052\u0006\u0010%\u001a\u00020\u0005H\u0014J\u0010\u0010&\u001a\u00020\u000e2\u0006\u0010'\u001a\u00020(H\u0016R\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b¨\u0006*"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/CornersBorderTransform;", "Lcom/bumptech/glide/load/resource/bitmap/CenterCrop;", "mRadius", "", "mBorderColor", "", "mBorderWidth", "(FIF)V", "getMBorderColor", "()I", "getMBorderWidth", "()F", "getMRadius", "drawRoundRect", "", "canvas", "Landroid/graphics/Canvas;", "paint", "Landroid/graphics/Paint;", "width", "height", "borderPaint", "equals", "", "other", "", "getKey", "", "hashCode", "roundCrop", "Landroid/graphics/Bitmap;", "pool", "Lcom/bumptech/glide/load/engine/bitmap_recycle/BitmapPool;", "source", "transform", "toTransform", "outWidth", "outHeight", "updateDiskCacheKey", "messageDigest", "Ljava/security/MessageDigest;", "Companion", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: CornersBorderTransform.kt */
public final class CornersBorderTransform extends CenterCrop {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: ID */
    public static final String f44063ID = "com.didi.soda.customer.widget.CornersBorderTransform";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public static final byte[] f44064d;

    /* renamed from: a */
    private final float f44065a;

    /* renamed from: b */
    private final int f44066b;

    /* renamed from: c */
    private final float f44067c;

    public CornersBorderTransform(float f, int i, float f2) {
        this.f44065a = f;
        this.f44066b = i;
        this.f44067c = f2;
    }

    public final int getMBorderColor() {
        return this.f44066b;
    }

    public final float getMBorderWidth() {
        return this.f44067c;
    }

    public final float getMRadius() {
        return this.f44065a;
    }

    @Metadata(mo148867d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0012\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\t"}, mo148868d2 = {"Lcom/didi/soda/customer/widget/CornersBorderTransform$Companion;", "", "()V", "ID", "", "ID_BYTES", "", "getID_BYTES", "()[B", "customer-aar_brazilEmbedRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
    /* compiled from: CornersBorderTransform.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final byte[] getID_BYTES() {
            return CornersBorderTransform.f44064d;
        }
    }

    static {
        Charset charset = CenterCrop.CHARSET;
        Intrinsics.checkNotNullExpressionValue(charset, "CHARSET");
        byte[] bytes = f44063ID.getBytes(charset);
        Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
        f44064d = bytes;
    }

    /* access modifiers changed from: protected */
    public Bitmap transform(BitmapPool bitmapPool, Bitmap bitmap, int i, int i2) {
        Intrinsics.checkNotNullParameter(bitmapPool, "pool");
        Intrinsics.checkNotNullParameter(bitmap, "toTransform");
        return m32830a(bitmapPool, super.transform(bitmapPool, bitmap, i, i2));
    }

    /* renamed from: a */
    private final Bitmap m32830a(BitmapPool bitmapPool, Bitmap bitmap) {
        if (bitmap == null) {
            return null;
        }
        Bitmap bitmap2 = bitmapPool.get(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        if (bitmap2 == null) {
            bitmap2 = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        }
        Intrinsics.checkNotNull(bitmap2);
        Canvas canvas = new Canvas(bitmap2);
        Paint paint = new Paint();
        paint.setShader(new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP));
        paint.setAntiAlias(true);
        if (this.f44067c > 0.0f) {
            Paint paint2 = new Paint(1);
            paint2.setColor(this.f44066b);
            paint2.setStyle(Paint.Style.STROKE);
            paint2.setStrokeWidth(this.f44067c);
            m32832a(canvas, paint, (float) bitmap.getWidth(), (float) bitmap.getHeight(), paint2);
        } else {
            RectF rectF = new RectF(0.0f, 0.0f, (float) bitmap.getWidth(), (float) bitmap.getHeight());
            float f = this.f44065a;
            canvas.drawRoundRect(rectF, f, f, paint);
        }
        return bitmap2;
    }

    /* renamed from: a */
    private final void m32832a(Canvas canvas, Paint paint, float f, float f2, Paint paint2) {
        float f3 = this.f44067c / ((float) 2);
        Path path = new Path();
        float[] fArr = new float[8];
        int i = 15;
        for (int i2 = 3; i2 >= 0; i2--) {
            int i3 = i2 * 2;
            int i4 = i & 1;
            float f4 = 0.0f;
            fArr[i3 + 1] = i4 > 0 ? this.f44065a : 0.0f;
            if (i4 > 0) {
                f4 = this.f44065a;
            }
            fArr[i3] = f4;
            i >>= 1;
        }
        path.addRoundRect(new RectF(f3, f3, f - f3, f2 - f3), fArr, Path.Direction.CW);
        canvas.drawPath(path, paint);
        canvas.drawPath(path, paint2);
    }

    public boolean equals(Object obj) {
        if (obj instanceof CornersBorderTransform) {
            return Intrinsics.areEqual((Object) m32831a(), (Object) ((CornersBorderTransform) obj).m32831a());
        }
        return false;
    }

    public int hashCode() {
        return m32831a().hashCode();
    }

    /* renamed from: a */
    private final String m32831a() {
        return "com.didi.soda.customer.widget.CornersBorderTransform_" + this.f44065a + '_' + this.f44066b + '_' + this.f44067c;
    }

    public void updateDiskCacheKey(MessageDigest messageDigest) {
        Intrinsics.checkNotNullParameter(messageDigest, "messageDigest");
        String a = m32831a();
        Charset charset = CenterCrop.CHARSET;
        Intrinsics.checkNotNullExpressionValue(charset, "CHARSET");
        if (a != null) {
            byte[] bytes = a.getBytes(charset);
            Intrinsics.checkNotNullExpressionValue(bytes, "(this as java.lang.String).getBytes(charset)");
            messageDigest.update(bytes);
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
    }
}
