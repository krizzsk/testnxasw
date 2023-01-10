package com.didi.dimina.container.p065ui.tabbar.BadgeView;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PointF;
import java.lang.ref.WeakReference;
import java.lang.reflect.Array;
import java.util.Random;

/* renamed from: com.didi.dimina.container.ui.tabbar.BadgeView.BadgeAnimator */
public class BadgeAnimator extends ValueAnimator {

    /* renamed from: a */
    private BitmapFragment[][] f19695a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public WeakReference<QBadgeView> f19696b;

    public BadgeAnimator(Bitmap bitmap, PointF pointF, QBadgeView qBadgeView) {
        this.f19696b = new WeakReference<>(qBadgeView);
        setFloatValues(new float[]{0.0f, 1.0f});
        setDuration(500);
        this.f19695a = m16747a(bitmap, pointF);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                QBadgeView qBadgeView = (QBadgeView) BadgeAnimator.this.f19696b.get();
                if (qBadgeView == null || !qBadgeView.isShown()) {
                    BadgeAnimator.this.cancel();
                } else {
                    qBadgeView.invalidate();
                }
            }
        });
        addListener(new AnimatorListenerAdapter() {
            public void onAnimationEnd(Animator animator) {
                QBadgeView qBadgeView = (QBadgeView) BadgeAnimator.this.f19696b.get();
                if (qBadgeView != null) {
                    qBadgeView.reset();
                }
            }
        });
    }

    public void draw(Canvas canvas) {
        for (int i = 0; i < this.f19695a.length; i++) {
            int i2 = 0;
            while (true) {
                BitmapFragment[][] bitmapFragmentArr = this.f19695a;
                if (i2 >= bitmapFragmentArr[i].length) {
                    break;
                }
                bitmapFragmentArr[i][i2].update(Float.parseFloat(getAnimatedValue().toString()), canvas);
                i2++;
            }
        }
    }

    /* renamed from: a */
    private BitmapFragment[][] m16747a(Bitmap bitmap, PointF pointF) {
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        float min = ((float) Math.min(width, height)) / 6.0f;
        float width2 = pointF.x - (((float) bitmap.getWidth()) / 2.0f);
        float height2 = pointF.y - (((float) bitmap.getHeight()) / 2.0f);
        int[] iArr = new int[2];
        iArr[1] = (int) (((float) width) / min);
        iArr[0] = (int) (((float) height) / min);
        BitmapFragment[][] bitmapFragmentArr = (BitmapFragment[][]) Array.newInstance(BitmapFragment.class, iArr);
        for (int i = 0; i < bitmapFragmentArr.length; i++) {
            for (int i2 = 0; i2 < bitmapFragmentArr[i].length; i2++) {
                BitmapFragment bitmapFragment = new BitmapFragment();
                float f = ((float) i2) * min;
                float f2 = ((float) i) * min;
                bitmapFragment.color = bitmap.getPixel((int) f, (int) f2);
                bitmapFragment.f19697x = f + width2;
                bitmapFragment.f19698y = f2 + height2;
                bitmapFragment.size = min;
                bitmapFragment.maxSize = Math.max(width, height);
                bitmapFragmentArr[i][i2] = bitmapFragment;
            }
        }
        bitmap.recycle();
        return bitmapFragmentArr;
    }

    /* renamed from: com.didi.dimina.container.ui.tabbar.BadgeView.BadgeAnimator$BitmapFragment */
    private class BitmapFragment {
        int color;
        int maxSize;
        Paint paint;
        Random random = new Random();
        float size;

        /* renamed from: x */
        float f19697x;

        /* renamed from: y */
        float f19698y;

        public BitmapFragment() {
            Paint paint2 = new Paint();
            this.paint = paint2;
            paint2.setAntiAlias(true);
            this.paint.setStyle(Paint.Style.FILL);
        }

        public void update(float f, Canvas canvas) {
            this.paint.setColor(this.color);
            this.f19697x += ((float) this.random.nextInt(this.maxSize)) * 0.1f * (this.random.nextFloat() - 0.5f);
            float nextInt = this.f19698y + (((float) this.random.nextInt(this.maxSize)) * 0.1f * (this.random.nextFloat() - 0.5f));
            this.f19698y = nextInt;
            float f2 = this.f19697x;
            float f3 = this.size;
            canvas.drawCircle(f2, nextInt, f3 - (f * f3), this.paint);
        }
    }
}
