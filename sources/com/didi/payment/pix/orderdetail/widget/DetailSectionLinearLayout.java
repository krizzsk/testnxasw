package com.didi.payment.pix.orderdetail.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.widget.LinearLayout;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010#H\u0015J\u0018\u0010$\u001a\u00020!2\u0006\u0010%\u001a\u00020\u00062\u0006\u0010&\u001a\u00020\u0006H\u0014J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u0006R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0011\"\u0004\b\u0016\u0010\u0013R\u001a\u0010\u0017\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0011\"\u0004\b\u0019\u0010\u0013R\u001a\u0010\u001a\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u0011\"\u0004\b\u001c\u0010\u0013R\u001a\u0010\u001d\u001a\u00020\u0006X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u0011\"\u0004\b\u001f\u0010\u0013¨\u0006)"}, mo148868d2 = {"Lcom/didi/payment/pix/orderdetail/widget/DetailSectionLinearLayout;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "TYPE_FOOTER", "", "TYPE_HEADER", "TYPE_MIDDLE", "definePath", "Landroid/graphics/Path;", "getDefinePath", "()Landroid/graphics/Path;", "setDefinePath", "(Landroid/graphics/Path;)V", "displayType", "getDisplayType", "()I", "setDisplayType", "(I)V", "radiusBottom", "getRadiusBottom", "setRadiusBottom", "radiusTop", "getRadiusTop", "setRadiusTop", "selfHeight", "getSelfHeight", "setSelfHeight", "selfWidth", "getSelfWidth", "setSelfWidth", "onDraw", "", "canvas", "Landroid/graphics/Canvas;", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "setType", "type", "wallet-service-pix_globalRelease"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: DetailSectionLinearLayout.kt */
public final class DetailSectionLinearLayout extends LinearLayout {

    /* renamed from: a */
    private int f33645a = 20;

    /* renamed from: b */
    private int f33646b = 10;

    /* renamed from: c */
    private Path f33647c = new Path();

    /* renamed from: d */
    private int f33648d;

    /* renamed from: e */
    private int f33649e;

    /* renamed from: f */
    private int f33650f;

    /* renamed from: g */
    private int f33651g = 1;

    /* renamed from: h */
    private int f33652h = 2;

    /* renamed from: i */
    private int f33653i = this.f33650f;

    public DetailSectionLinearLayout(Context context) {
        super(context);
    }

    public final int getRadiusTop() {
        return this.f33645a;
    }

    public final void setRadiusTop(int i) {
        this.f33645a = i;
    }

    public final int getRadiusBottom() {
        return this.f33646b;
    }

    public final void setRadiusBottom(int i) {
        this.f33646b = i;
    }

    public final Path getDefinePath() {
        return this.f33647c;
    }

    public final void setDefinePath(Path path) {
        Intrinsics.checkNotNullParameter(path, "<set-?>");
        this.f33647c = path;
    }

    public final int getSelfWidth() {
        return this.f33648d;
    }

    public final void setSelfWidth(int i) {
        this.f33648d = i;
    }

    public final int getSelfHeight() {
        return this.f33649e;
    }

    public final void setSelfHeight(int i) {
        this.f33649e = i;
    }

    public final int getDisplayType() {
        return this.f33653i;
    }

    public final void setDisplayType(int i) {
        this.f33653i = i;
    }

    public final void setType(int i) {
        this.f33653i = Math.abs(i % 3);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        this.f33648d = getMeasuredWidth();
        this.f33649e = getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = this.f33653i;
        if (i == this.f33650f) {
            this.f33647c.moveTo(0.0f, (float) this.f33645a);
            int i2 = this.f33645a;
            this.f33647c.addArc(new RectF(new Rect(0, 0, i2, i2)), 180.0f, 270.0f);
            this.f33647c.lineTo((float) (getMeasuredWidth() - this.f33645a), 0.0f);
            this.f33647c.addArc(new RectF(new Rect(getMeasuredWidth() - this.f33645a, 0, getMeasuredWidth(), this.f33645a)), 270.0f, 360.0f);
            this.f33647c.lineTo((float) getMeasuredWidth(), (float) (getMeasuredHeight() - this.f33646b));
            this.f33647c.addArc(new RectF(new Rect(getMeasuredWidth() - this.f33646b, getMeasuredHeight() - this.f33646b, getMeasuredWidth(), getMeasuredHeight())), 270.0f, 180.0f);
            this.f33647c.lineTo((float) this.f33646b, (float) getMeasuredHeight());
            int measuredHeight = getMeasuredHeight();
            int i3 = this.f33646b;
            this.f33647c.addArc(new RectF(new Rect(0, measuredHeight - i3, i3, getMeasuredHeight())), 360.0f, 270.0f);
            this.f33647c.close();
        } else if (i == this.f33651g) {
            this.f33647c.moveTo(0.0f, (float) this.f33645a);
            int i4 = this.f33645a;
            this.f33647c.addArc(new RectF(new Rect(0, 0, i4, i4)), 180.0f, 270.0f);
            this.f33647c.lineTo((float) (getMeasuredWidth() - this.f33645a), 0.0f);
            this.f33647c.addArc(new RectF(new Rect(getMeasuredWidth() - this.f33645a, 0, getMeasuredWidth(), this.f33645a)), 270.0f, 360.0f);
            this.f33647c.lineTo((float) getMeasuredWidth(), (float) (getMeasuredHeight() - this.f33646b));
            this.f33647c.addArc(new RectF(new Rect(getMeasuredWidth() - this.f33646b, getMeasuredHeight() - this.f33646b, getMeasuredWidth(), getMeasuredHeight())), 270.0f, 180.0f);
            this.f33647c.lineTo((float) this.f33646b, (float) getMeasuredHeight());
            int measuredHeight2 = getMeasuredHeight();
            int i5 = this.f33646b;
            this.f33647c.addArc(new RectF(new Rect(0, measuredHeight2 - i5, i5, getMeasuredHeight())), 360.0f, 270.0f);
            this.f33647c.close();
        }
        super.onDraw(canvas);
    }
}
