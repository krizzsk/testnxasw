package com.didi.global.loading.render;

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

    /* renamed from: b */
    private static final int f24578b = 0;

    /* renamed from: c */
    private static final int f24579c = 1;

    /* renamed from: d */
    private static final int f24580d = 2;
    public static final String kBodyImageResourceId = "Loading::Gradient::Body::Image::ID";
    public static final String kHeadImageResourceId = "Loading::Gradient::Head::Image::ID";

    /* renamed from: e */
    private int f24581e = 0;

    /* renamed from: f */
    private Bitmap f24582f;

    /* renamed from: g */
    private Bitmap f24583g;

    /* renamed from: h */
    private Rect f24584h;

    /* renamed from: i */
    private Rect f24585i;

    /* renamed from: j */
    private RectF f24586j;

    /* renamed from: k */
    private RectF f24587k;

    /* renamed from: l */
    private int f24588l;

    /* renamed from: m */
    private int f24589m;

    /* renamed from: n */
    private int f24590n;

    /* renamed from: o */
    private int f24591o;

    /* renamed from: p */
    private int f24592p;

    /* renamed from: q */
    private int f24593q;

    public View onCreateView(Context context, Bundle bundle) {
        View onCreateView = super.onCreateView(context, bundle);
        this.f24582f = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Head::Image::ID", R.drawable.img_loading_head));
        this.f24583g = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Body::Image::ID", R.drawable.img_loading_body));
        Bitmap bitmap = this.f24582f;
        if (bitmap != null) {
            this.f24588l = bitmap.getWidth();
            this.f24589m = this.f24582f.getHeight();
            this.f24584h = new Rect(0, 0, this.f24588l, this.f24589m);
            this.f24586j = new RectF(this.f24584h);
            Bitmap bitmap2 = this.f24583g;
            if (bitmap2 != null) {
                this.f24590n = bitmap2.getWidth();
                this.f24591o = this.f24583g.getHeight();
                this.f24585i = new Rect(0, 0, this.f24590n, this.f24591o);
                this.f24587k = new RectF(this.f24585i);
            }
        }
        return onCreateView;
    }

    public void onLayoutView(View view, ViewGroup viewGroup, ViewGroup viewGroup2) {
        this.f24592p = view.getMeasuredWidth();
        this.f24593q = Math.max(this.f24591o, this.f24589m);
        super.onLayoutView(view, viewGroup, viewGroup2);
    }

    public void computeRender(float f) {
        int i = this.f24592p;
        int i2 = this.f24588l;
        float f2 = ((float) (i + i2)) * f;
        int i3 = this.f24581e;
        if (i3 == 1) {
            this.f24586j.offsetTo(((float) (-i2)) + f2, 0.0f);
            this.f24587k.offsetTo(((float) (-(this.f24592p + this.f24588l))) + f2, 0.0f);
        } else if (i3 == 2) {
            this.f24586j.offsetTo(((float) (-i2)) + f2, 0.0f);
        }
    }

    public Rect getBorder() {
        return new Rect(0, 0, this.f24592p, this.f24593q);
    }

    public void draw(Canvas canvas, Rect rect) {
        if (this.f24583g != null && this.f24582f != null) {
            canvas.save();
            canvas.drawBitmap(this.f24583g, this.f24585i, this.f24587k, (Paint) null);
            canvas.drawBitmap(this.f24582f, this.f24584h, this.f24586j, (Paint) null);
            canvas.restore();
        }
    }

    public void onStartLoading() {
        m19754a(1);
        super.onStartLoading();
    }

    public void onStopLoading() {
        m19754a(0);
        super.onStopLoading();
    }

    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        m19754a(2);
    }

    public void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        m19754a(0);
    }

    /* renamed from: a */
    private void m19754a(int i) {
        if (i == 0) {
            this.f24586j.left = (float) (-this.f24588l);
            this.f24586j.right = 0.0f;
            this.f24587k.left = (float) (-this.f24590n);
            this.f24587k.right = 0.0f;
        } else if (i == 1) {
            this.f24586j.left = (float) (-this.f24588l);
            this.f24586j.right = 0.0f;
            this.f24587k.left = (float) (-(this.f24592p + this.f24588l));
            this.f24587k.right = (float) (-this.f24588l);
        } else if (i == 2) {
            this.f24586j.left = (float) (-this.f24588l);
            this.f24586j.right = 0.0f;
            this.f24587k.left = 0.0f;
            this.f24587k.right = (float) this.f24592p;
        }
        this.f24586j.top = 0.0f;
        this.f24586j.bottom = (float) this.f24593q;
        this.f24587k.top = 0.0f;
        this.f24587k.bottom = (float) this.f24593q;
        this.f24581e = i;
    }
}
