package com.didi.soda.customer.widget.loading.render;

import android.animation.Animator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import com.taxis99.R;

public class GradientLoadingRender extends AnimationLoadingRender {
    public static final String K_BODY_IMAGE_RESOURCE_ID = "Loading::Gradient::Body::Image::ID";
    public static final String K_HEAD_IMAGE_RESOURCE_ID = "Loading::Gradient::Head::Image::ID";

    /* renamed from: b */
    private static final int f44656b = 0;

    /* renamed from: c */
    private static final int f44657c = 1;

    /* renamed from: d */
    private static final int f44658d = 2;

    /* renamed from: e */
    private int f44659e = 0;

    /* renamed from: f */
    private Bitmap f44660f;

    /* renamed from: g */
    private Bitmap f44661g;

    /* renamed from: h */
    private Rect f44662h;

    /* renamed from: i */
    private Rect f44663i;

    /* renamed from: j */
    private RectF f44664j;

    /* renamed from: k */
    private RectF f44665k;

    /* renamed from: l */
    private int f44666l;

    /* renamed from: m */
    private int f44667m;

    /* renamed from: n */
    private int f44668n;

    /* renamed from: o */
    private int f44669o;

    /* renamed from: p */
    private int f44670p;

    /* renamed from: q */
    private int f44671q;

    public void computeRender(float f) {
        int i = this.f44670p;
        int i2 = this.f44666l;
        float f2 = ((float) (i + i2)) * f;
        int i3 = this.f44659e;
        if (i3 == 1) {
            this.f44664j.offsetTo(((float) (-i2)) + f2, 0.0f);
            this.f44665k.offsetTo(((float) (-(this.f44670p + this.f44666l))) + f2, 0.0f);
        } else if (i3 == 2) {
            this.f44664j.offsetTo(((float) (-i2)) + f2, 0.0f);
        }
    }

    public void draw(Canvas canvas, Rect rect) {
        if (this.f44661g != null && this.f44660f != null) {
            canvas.save();
            canvas.drawBitmap(this.f44661g, this.f44663i, this.f44665k, (Paint) null);
            canvas.drawBitmap(this.f44660f, this.f44662h, this.f44664j, (Paint) null);
            canvas.restore();
        }
    }

    public Rect getBorder() {
        return new Rect(0, 0, this.f44670p, this.f44671q);
    }

    public void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        m33158a(0);
    }

    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        m33158a(2);
    }

    public View onCreateView(Context context, Bundle bundle) {
        View onCreateView = super.onCreateView(context, bundle);
        this.f44660f = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Head::Image::ID", R.drawable.img_loading_head));
        this.f44661g = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Body::Image::ID", R.drawable.img_loading_body));
        Bitmap bitmap = this.f44660f;
        if (bitmap != null) {
            this.f44666l = bitmap.getWidth();
            this.f44667m = this.f44660f.getHeight();
            this.f44662h = new Rect(0, 0, this.f44666l, this.f44667m);
            this.f44664j = new RectF(this.f44662h);
            Bitmap bitmap2 = this.f44661g;
            if (bitmap2 != null) {
                this.f44668n = bitmap2.getWidth();
                this.f44669o = this.f44661g.getHeight();
                this.f44663i = new Rect(0, 0, this.f44668n, this.f44669o);
                this.f44665k = new RectF(this.f44663i);
            }
        }
        return onCreateView;
    }

    public void onLayoutView(View view, ViewGroup viewGroup, ViewGroup viewGroup2) {
        super.onLayoutView(view, viewGroup, viewGroup2);
        this.f44670p = view.getMeasuredWidth();
        this.f44671q = Math.max(this.f44669o, this.f44667m);
    }

    public void onStartLoading() {
        m33158a(1);
        super.onStartLoading();
    }

    public void onStopLoading() {
        m33158a(0);
        super.onStopLoading();
    }

    /* renamed from: a */
    private void m33158a(int i) {
        if (i == 0) {
            this.f44664j.left = (float) (-this.f44666l);
            this.f44664j.right = 0.0f;
            this.f44665k.left = (float) (-this.f44668n);
            this.f44665k.right = 0.0f;
        } else if (i == 1) {
            this.f44664j.left = (float) (-this.f44666l);
            this.f44664j.right = 0.0f;
            this.f44665k.left = (float) (-(this.f44670p + this.f44666l));
            this.f44665k.right = (float) (-this.f44666l);
        } else if (i == 2) {
            this.f44664j.left = (float) (-this.f44666l);
            this.f44664j.right = 0.0f;
            this.f44665k.left = 0.0f;
            this.f44665k.right = (float) this.f44670p;
        }
        this.f44664j.top = 0.0f;
        this.f44664j.bottom = (float) this.f44671q;
        this.f44665k.top = 0.0f;
        this.f44665k.bottom = (float) this.f44671q;
        this.f44659e = i;
    }
}
