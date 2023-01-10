package com.didi.rfusion.widget.badge;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.taxis99.R;

class RFBadgeV2 extends View implements C12351a {

    /* renamed from: b */
    private static final int f36094b = 99;

    /* renamed from: c */
    private static final int f36095c = 8;

    /* renamed from: d */
    private static final String f36096d = "+";

    /* renamed from: a */
    protected Paint.FontMetrics f36097a;

    /* renamed from: e */
    private int f36098e;

    /* renamed from: f */
    private int f36099f;

    /* renamed from: g */
    private String f36100g;

    /* renamed from: h */
    private Rect f36101h;

    /* renamed from: i */
    private TextPaint f36102i;

    /* renamed from: j */
    private float f36103j;

    /* renamed from: k */
    private int f36104k;

    /* renamed from: l */
    private RectF f36105l;

    /* renamed from: m */
    private Paint f36106m;

    /* renamed from: n */
    private int f36107n;

    /* renamed from: o */
    private int f36108o;

    /* renamed from: p */
    private int f36109p;

    /* renamed from: q */
    private int f36110q;

    /* renamed from: r */
    private int f36111r;

    public void hide() {
    }

    public void hideStock() {
    }

    public void show() {
    }

    public void showStock() {
    }

    public void showStock(int i) {
    }

    public RFBadgeV2(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFBadgeV2(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFBadgeV2(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36098e = 99;
        this.f36100g = "";
        m27173a(context);
    }

    /* renamed from: a */
    private void m27173a(Context context) {
        Resources resources = context.getResources();
        m27176b(resources);
        m27174a(resources);
        this.f36110q = resources.getDimensionPixelSize(R.dimen.rf_dimen_12);
        this.f36111r = resources.getDimensionPixelSize(R.dimen.rf_dimen_6);
    }

    /* renamed from: a */
    private void m27174a(Resources resources) {
        this.f36105l = new RectF();
        Paint paint = new Paint();
        this.f36106m = paint;
        paint.setAntiAlias(true);
        this.f36106m.setStyle(Paint.Style.FILL);
        this.f36108o = resources.getDimensionPixelSize(R.dimen.rf_dimen_8);
        this.f36109p = resources.getDimensionPixelSize(R.dimen.rf_dimen_20);
        int color = resources.getColor(R.color.rf_color_alert_red_100_FF4E45);
        this.f36107n = color;
        this.f36106m.setColor(color);
    }

    /* renamed from: b */
    private void m27176b(Resources resources) {
        this.f36101h = new Rect();
        TextPaint textPaint = new TextPaint();
        this.f36102i = textPaint;
        textPaint.setAntiAlias(true);
        this.f36102i.setSubpixelText(true);
        this.f36102i.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_ATOP));
        this.f36102i.setTextAlign(Paint.Align.CENTER);
        float dimensionPixelSize = (float) resources.getDimensionPixelSize(R.dimen.f_11_app_24_pad_14);
        this.f36103j = dimensionPixelSize;
        this.f36102i.setTextSize(dimensionPixelSize);
        int color = resources.getColor(R.color.rf_color_white_100_FFFFFF);
        this.f36104k = color;
        this.f36102i.setColor(color);
        this.f36097a = this.f36102i.getFontMetrics();
    }

    /* renamed from: a */
    private void m27175a(Canvas canvas) {
        Paint.FontMetrics fontMetrics = this.f36102i.getFontMetrics();
        float f = fontMetrics.descent - fontMetrics.ascent;
        if (TextUtils.isEmpty(this.f36100g)) {
            canvas.drawCircle(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f, (float) this.f36108o, this.f36106m);
        } else if (this.f36100g.length() == 1) {
            canvas.drawCircle(((float) getMeasuredWidth()) / 2.0f, ((float) getMeasuredHeight()) / 2.0f, (float) this.f36109p, this.f36106m);
            canvas.drawText(this.f36100g, ((float) getMeasuredWidth()) / 2.0f, (((float) getMeasuredHeight()) / 2.0f) + ((f / 2.0f) - fontMetrics.descent), this.f36102i);
        } else {
            this.f36102i.measureText(this.f36100g);
            this.f36105l.left = ((((float) getMeasuredWidth()) / 2.0f) - (((float) this.f36101h.width()) / 2.0f)) - ((float) this.f36110q);
            this.f36105l.top = ((((float) getMeasuredHeight()) / 2.0f) - (((float) this.f36101h.height()) / 2.0f)) - ((float) this.f36111r);
            this.f36105l.right = (float) getMeasuredWidth();
            this.f36105l.bottom = (float) getMeasuredHeight();
            RectF rectF = this.f36105l;
            int i = this.f36109p;
            canvas.drawRoundRect(rectF, (float) i, (float) i, this.f36106m);
            canvas.drawText(this.f36100g, this.f36105l.left + (this.f36105l.width() / 2.0f), (((this.f36105l.bottom + this.f36105l.top) - this.f36097a.bottom) - this.f36097a.top) / 2.0f, this.f36102i);
        }
    }

    /* renamed from: a */
    private void m27172a() {
        this.f36101h.left = 0;
        this.f36101h.top = 0;
        if (TextUtils.isEmpty(this.f36100g)) {
            this.f36101h.right = 0;
            this.f36101h.bottom = 0;
            return;
        }
        TextPaint textPaint = this.f36102i;
        String str = this.f36100g;
        textPaint.getTextBounds(str, 0, str.length(), this.f36101h);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        m27175a(canvas);
    }

    public void setMaxBadgeNumber(int i) {
        this.f36098e = i;
    }

    public int getMaxBadgeNumber() {
        return this.f36098e;
    }

    public void setBadgeNumber(int i) {
        this.f36099f = i;
        int i2 = this.f36098e;
        if (i <= i2) {
            this.f36100g = String.valueOf(i);
        } else if (i > i2) {
            this.f36100g = this.f36098e + "+";
        }
        m27172a();
        invalidate();
    }

    public int getBadgeNumber() {
        return this.f36099f;
    }

    public void setBadgeText(String str) {
        if (str.length() > 8) {
            this.f36100g = str.substring(0, 8);
        } else {
            this.f36100g = str;
        }
        m27172a();
        invalidate();
    }

    public String getBadgeText() {
        return this.f36100g;
    }

    public void clearContent() {
        this.f36100g = "";
        m27172a();
        invalidate();
    }
}
