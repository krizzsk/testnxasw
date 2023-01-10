package com.didi.entrega.customer.widget.loading.render;

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
    private static final int f22413b = 0;

    /* renamed from: c */
    private static final int f22414c = 1;

    /* renamed from: d */
    private static final int f22415d = 2;

    /* renamed from: e */
    private int f22416e = 0;

    /* renamed from: f */
    private Bitmap f22417f;

    /* renamed from: g */
    private Bitmap f22418g;

    /* renamed from: h */
    private Rect f22419h;

    /* renamed from: i */
    private Rect f22420i;

    /* renamed from: j */
    private RectF f22421j;

    /* renamed from: k */
    private RectF f22422k;

    /* renamed from: l */
    private int f22423l;

    /* renamed from: m */
    private int f22424m;

    /* renamed from: n */
    private int f22425n;

    /* renamed from: o */
    private int f22426o;

    /* renamed from: p */
    private int f22427p;

    /* renamed from: q */
    private int f22428q;

    public void computeRender(float f) {
        int i = this.f22427p;
        int i2 = this.f22423l;
        float f2 = ((float) (i + i2)) * f;
        int i3 = this.f22416e;
        if (i3 == 1) {
            this.f22421j.offsetTo(((float) (-i2)) + f2, 0.0f);
            this.f22422k.offsetTo(((float) (-(this.f22427p + this.f22423l))) + f2, 0.0f);
        } else if (i3 == 2) {
            this.f22421j.offsetTo(((float) (-i2)) + f2, 0.0f);
        }
    }

    public void draw(Canvas canvas, Rect rect) {
        if (this.f22418g != null && this.f22417f != null) {
            canvas.save();
            canvas.drawBitmap(this.f22418g, this.f22420i, this.f22422k, (Paint) null);
            canvas.drawBitmap(this.f22417f, this.f22419h, this.f22421j, (Paint) null);
            canvas.restore();
        }
    }

    public Rect getBorder() {
        return new Rect(0, 0, this.f22427p, this.f22428q);
    }

    public void onAnimationCancel(Animator animator) {
        super.onAnimationCancel(animator);
        m18470a(0);
    }

    public void onAnimationRepeat(Animator animator) {
        super.onAnimationRepeat(animator);
        m18470a(2);
    }

    public View onCreateView(Context context, Bundle bundle) {
        View onCreateView = super.onCreateView(context, bundle);
        this.f22417f = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Head::Image::ID", R.drawable.img_loading_head));
        this.f22418g = BitmapFactory.decodeResource(context.getResources(), bundle.getInt("Loading::Gradient::Body::Image::ID", R.drawable.img_loading_body));
        Bitmap bitmap = this.f22417f;
        if (bitmap != null) {
            this.f22423l = bitmap.getWidth();
            this.f22424m = this.f22417f.getHeight();
            this.f22419h = new Rect(0, 0, this.f22423l, this.f22424m);
            this.f22421j = new RectF(this.f22419h);
            Bitmap bitmap2 = this.f22418g;
            if (bitmap2 != null) {
                this.f22425n = bitmap2.getWidth();
                this.f22426o = this.f22418g.getHeight();
                this.f22420i = new Rect(0, 0, this.f22425n, this.f22426o);
                this.f22422k = new RectF(this.f22420i);
            }
        }
        return onCreateView;
    }

    public void onLayoutView(View view, ViewGroup viewGroup, ViewGroup viewGroup2) {
        super.onLayoutView(view, viewGroup, viewGroup2);
        this.f22427p = view.getMeasuredWidth();
        this.f22428q = Math.max(this.f22426o, this.f22424m);
    }

    public void onStartLoading() {
        m18470a(1);
        super.onStartLoading();
    }

    public void onStopLoading() {
        m18470a(0);
        super.onStopLoading();
    }

    /* renamed from: a */
    private void m18470a(int i) {
        if (i == 0) {
            this.f22421j.left = (float) (-this.f22423l);
            this.f22421j.right = 0.0f;
            this.f22422k.left = (float) (-this.f22425n);
            this.f22422k.right = 0.0f;
        } else if (i == 1) {
            this.f22421j.left = (float) (-this.f22423l);
            this.f22421j.right = 0.0f;
            this.f22422k.left = (float) (-(this.f22427p + this.f22423l));
            this.f22422k.right = (float) (-this.f22423l);
        } else if (i == 2) {
            this.f22421j.left = (float) (-this.f22423l);
            this.f22421j.right = 0.0f;
            this.f22422k.left = 0.0f;
            this.f22422k.right = (float) this.f22427p;
        }
        this.f22421j.top = 0.0f;
        this.f22421j.bottom = (float) this.f22428q;
        this.f22422k.top = 0.0f;
        this.f22422k.bottom = (float) this.f22428q;
        this.f22416e = i;
    }
}
