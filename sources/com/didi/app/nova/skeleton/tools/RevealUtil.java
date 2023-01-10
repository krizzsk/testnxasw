package com.didi.app.nova.skeleton.tools;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.text.TextPaint;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.internal.Const;
import java.util.Random;

public final class RevealUtil {

    /* renamed from: a */
    private static final RevealUtil f10369a = new RevealUtil();

    /* renamed from: b */
    private static final int f10370b = 500;

    /* renamed from: c */
    private static final int f10371c = 150;

    /* renamed from: d */
    private static final float f10372d = 0.9f;

    /* renamed from: e */
    private static final int f10373e = 30;

    /* renamed from: f */
    private static final int f10374f = -65536;

    /* renamed from: g */
    private static final Random f10375g;

    /* renamed from: h */
    private final Paint f10376h;

    static {
        Random random = new Random();
        f10375g = random;
        random.setSeed(System.currentTimeMillis());
    }

    private RevealUtil() {
        Paint paint = new Paint();
        this.f10376h = paint;
        paint.setTextSize(30.0f);
        this.f10376h.setColor(-65536);
    }

    /* renamed from: a */
    private static int m9075a() {
        return Color.argb(255, f10375g.nextInt(256), f10375g.nextInt(256), f10375g.nextInt(256));
    }

    public static boolean isEnabled() {
        return Const.ENABLE_REVEAL;
    }

    public static void apply(String str, ViewGroup viewGroup) {
        Bitmap bitmap;
        if (isEnabled() && str != null && !str.isEmpty()) {
            Context context = viewGroup.getContext();
            TagFrame tagFrame = new TagFrame(context, m9075a(), str);
            tagFrame.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
            Drawable background = tagFrame.getBackground();
            if (background != null) {
                bitmap = m9076a(background);
            } else {
                bitmap = Bitmap.createBitmap(500, 150, Bitmap.Config.ARGB_8888);
            }
            BitmapDrawable bitmapDrawable = new BitmapDrawable(context.getResources(), bitmap);
            bitmapDrawable.setGravity(17);
            tagFrame.setBackground(bitmapDrawable);
            tagFrame.setAlpha(f10372d);
            viewGroup.addView(tagFrame);
        }
    }

    /* renamed from: a */
    private static Bitmap m9076a(Drawable drawable) {
        Bitmap bitmap;
        if (drawable instanceof BitmapDrawable) {
            BitmapDrawable bitmapDrawable = (BitmapDrawable) drawable;
            if (bitmapDrawable.getBitmap() != null) {
                return bitmapDrawable.getBitmap();
            }
        }
        if (drawable.getIntrinsicWidth() <= 0 || drawable.getIntrinsicHeight() <= 0) {
            bitmap = Bitmap.createBitmap(500, 150, Bitmap.Config.ARGB_8888);
        } else {
            bitmap = Bitmap.createBitmap(drawable.getIntrinsicWidth(), drawable.getIntrinsicHeight(), Bitmap.Config.ARGB_8888);
        }
        drawable.draw(new Canvas(bitmap));
        return bitmap;
    }

    static class TagFrame extends FrameLayout {
        private static Paint paint;
        private static TextPaint textPaint;
        private int color;
        private String text = null;

        public TagFrame(Context context) {
            super(context);
        }

        public TagFrame(Context context, int i, String str) {
            super(context);
            this.color = i;
            this.text = str;
        }

        /* access modifiers changed from: protected */
        public void onDraw(Canvas canvas) {
            super.onDraw(canvas);
            if (paint == null) {
                paint = new Paint();
            }
            paint.setColor(this.color);
            paint.setStyle(Paint.Style.STROKE);
            paint.setStrokeWidth(5.0f);
            canvas.drawRect(5.0f, 5.0f, (float) (getWidth() - 5), (float) (getHeight() - 5), paint);
            if (textPaint == null) {
                textPaint = new TextPaint();
            }
            textPaint.setTextSize(30.0f);
            textPaint.setColor(this.color);
            canvas.drawText(this.text, (((float) getWidth()) - textPaint.measureText(this.text)) / 2.0f, ((float) getHeight()) / 2.0f, textPaint);
        }
    }
}
