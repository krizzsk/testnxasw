package com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.didi.passenger.C11267R;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.List;
import rui.config.RConfigConstants;

@Deprecated
public class SideBar extends View {

    /* renamed from: a */
    private int f34453a;

    /* renamed from: b */
    private int f34454b;

    /* renamed from: c */
    private int f34455c;

    /* renamed from: d */
    private int f34456d;

    /* renamed from: e */
    private String[] f34457e;

    /* renamed from: f */
    private Context f34458f;

    /* renamed from: g */
    private float f34459g;

    /* renamed from: h */
    private float f34460h;

    /* renamed from: i */
    private float f34461i;

    /* renamed from: j */
    private int f34462j;

    /* renamed from: k */
    private int f34463k;

    /* renamed from: l */
    private TextPaint f34464l;

    /* renamed from: m */
    private List<String> f34465m;

    /* renamed from: n */
    private int f34466n;

    /* renamed from: o */
    private OnSideBarTouchListener f34467o;

    public SideBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f34453a = (int) TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics());
        this.f34454b = -7829368;
        this.f34455c = 0;
        this.f34456d = 0;
        this.f34457e = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, C17272q.f51679a, C17272q.f51680b, "Z", RConfigConstants.KEYWORD_COLOR_SIGN};
        this.f34466n = -1;
        m26281a(context, attributeSet);
    }

    /* renamed from: a */
    private void m26281a(Context context, AttributeSet attributeSet) {
        this.f34458f = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.SideBar, 0, 0);
        for (int i = 0; i < obtainStyledAttributes.getIndexCount(); i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 2) {
                this.f34453a = obtainStyledAttributes.getDimensionPixelSize(index, this.f34453a);
            } else if (index == 1) {
                this.f34454b = obtainStyledAttributes.getColor(index, this.f34454b);
            } else if (index == 0) {
                this.f34455c = obtainStyledAttributes.getColor(index, this.f34455c);
            } else if (index == 3) {
                this.f34456d = obtainStyledAttributes.getColor(index, this.f34456d);
            }
        }
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f34464l = textPaint;
        textPaint.setColor(this.f34454b);
        this.f34464l.setTextSize((float) this.f34453a);
        this.f34464l.setAntiAlias(true);
        setBackgroundColor(this.f34455c);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f34460h = (float) i;
        float f = (float) i2;
        String[] strArr = this.f34457e;
        float length = (1.0f * f) / ((float) strArr.length);
        this.f34461i = length;
        this.f34459g = (f - (length * ((float) strArr.length))) / 2.0f;
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        if (mode2 == Integer.MIN_VALUE || mode == Integer.MIN_VALUE) {
            getMaxTextSize();
            if (mode2 == Integer.MIN_VALUE) {
                size2 = this.f34457e.length * (this.f34463k + ViewUtil.dip2px(this.f34458f, 5.0f));
            }
            if (mode == Integer.MIN_VALUE) {
                size = this.f34462j + ViewUtil.dip2px(this.f34458f, 5.0f);
            }
        }
        setMeasuredDimension(size, size2);
    }

    private void getMaxTextSize() {
        for (String str : this.f34457e) {
            this.f34462j = (int) Math.max((float) this.f34462j, this.f34464l.measureText(str));
            this.f34463k = Math.max(this.f34463k, ViewUtil.getTextHeight(this.f34464l, str));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = 0;
        while (true) {
            String[] strArr = this.f34457e;
            if (i < strArr.length) {
                String str = strArr[i];
                float f = this.f34459g;
                float f2 = this.f34461i;
                canvas.drawText(str, (this.f34460h - ((float) ViewUtil.getTextWidth(this.f34464l, str))) / 2.0f, f + (((float) i) * f2) + ((f2 + ((float) ViewUtil.getTextHeight(this.f34464l, str))) / 2.0f), this.f34464l);
                i++;
            } else {
                return;
            }
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:6:0x000e, code lost:
        if (r0 != 3) goto L_0x008c;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean onTouchEvent(android.view.MotionEvent r6) {
        /*
            r5 = this;
            int r0 = r6.getAction()
            r1 = -1
            r2 = 1
            if (r0 == 0) goto L_0x0021
            if (r0 == r2) goto L_0x0012
            r3 = 2
            if (r0 == r3) goto L_0x0021
            r6 = 3
            if (r0 == r6) goto L_0x0012
            goto L_0x008c
        L_0x0012:
            r5.f34466n = r1
            int r6 = r5.f34455c
            r5.setBackgroundColor(r6)
            com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.OnSideBarTouchListener r6 = r5.f34467o
            if (r6 == 0) goto L_0x008c
            r6.onTouchEnd()
            goto L_0x008c
        L_0x0021:
            java.util.List<java.lang.String> r0 = r5.f34465m
            if (r0 == 0) goto L_0x008c
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x002c
            goto L_0x008c
        L_0x002c:
            float r0 = r6.getY()
            float r3 = r5.f34459g
            float r0 = r0 - r3
            float r3 = r5.f34461i
            float r0 = r0 / r3
            int r0 = (int) r0
            int r3 = r5.f34466n
            if (r0 != r3) goto L_0x003c
            return r2
        L_0x003c:
            int r6 = r6.getAction()
            if (r6 != 0) goto L_0x0047
            int r6 = r5.f34456d
            r5.setBackgroundColor(r6)
        L_0x0047:
            if (r0 < 0) goto L_0x008c
            java.lang.String[] r6 = r5.f34457e
            int r6 = r6.length
            if (r0 >= r6) goto L_0x008c
            r5.f34466n = r0
            com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.OnSideBarTouchListener r6 = r5.f34467o
            if (r6 == 0) goto L_0x008c
            r6 = 0
        L_0x0055:
            java.util.List<java.lang.String> r3 = r5.f34465m
            int r3 = r3.size()
            if (r6 >= r3) goto L_0x008c
            java.lang.String[] r3 = r5.f34457e
            r3 = r3[r0]
            java.util.List<java.lang.String> r4 = r5.f34465m
            java.lang.Object r4 = r4.get(r6)
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0077
            com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.OnSideBarTouchListener r1 = r5.f34467o
            java.lang.String[] r3 = r5.f34457e
            r0 = r3[r0]
            r1.onTouch(r0, r6)
            goto L_0x008c
        L_0x0077:
            java.util.List<java.lang.String> r3 = r5.f34465m
            int r3 = r3.size()
            int r3 = r3 - r2
            if (r6 != r3) goto L_0x0089
            com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.OnSideBarTouchListener r3 = r5.f34467o
            java.lang.String[] r4 = r5.f34457e
            r4 = r4[r0]
            r3.onTouch(r4, r1)
        L_0x0089:
            int r6 = r6 + 1
            goto L_0x0055
        L_0x008c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet.global.useraccount.topup.boleto.addresspatch.widget.sidebar.SideBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnSideBarTouchListener(List<String> list, OnSideBarTouchListener onSideBarTouchListener) {
        this.f34465m = list;
        this.f34467o = onSideBarTouchListener;
    }
}
