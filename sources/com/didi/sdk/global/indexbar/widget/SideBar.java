package com.didi.sdk.global.indexbar.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.text.TextPaint;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import androidx.exifinterface.media.ExifInterface;
import com.didi.passenger.C11267R;
import com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener;
import com.didi.sdk.global.indexbar.utils.ViewUtil;
import com.google.android.gms.ads.RequestConfiguration;
import java.util.List;
import rui.config.RConfigConstants;

@Deprecated
public class SideBar extends View {

    /* renamed from: a */
    private int f38950a;

    /* renamed from: b */
    private int f38951b;

    /* renamed from: c */
    private int f38952c;

    /* renamed from: d */
    private int f38953d;

    /* renamed from: e */
    private String[] f38954e;

    /* renamed from: f */
    private Context f38955f;

    /* renamed from: g */
    private float f38956g;

    /* renamed from: h */
    private float f38957h;

    /* renamed from: i */
    private float f38958i;

    /* renamed from: j */
    private int f38959j;

    /* renamed from: k */
    private int f38960k;

    /* renamed from: l */
    private TextPaint f38961l;

    /* renamed from: m */
    private List<String> f38962m;

    /* renamed from: n */
    private int f38963n;

    /* renamed from: o */
    private OnSideBarTouchListener f38964o;

    public SideBar(Context context) {
        this(context, (AttributeSet) null);
    }

    public SideBar(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public SideBar(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f38950a = (int) TypedValue.applyDimension(2, 12.0f, getResources().getDisplayMetrics());
        this.f38951b = -7829368;
        this.f38952c = 0;
        this.f38953d = 0;
        this.f38954e = new String[]{ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, "B", "C", "D", ExifInterface.LONGITUDE_EAST, "F", RequestConfiguration.MAX_AD_CONTENT_RATING_G, "H", "I", "J", "K", "L", "M", "N", "O", "P", "Q", "R", ExifInterface.LATITUDE_SOUTH, "T", "U", ExifInterface.GPS_MEASUREMENT_INTERRUPTED, ExifInterface.LONGITUDE_WEST, C17272q.f51679a, C17272q.f51680b, "Z", RConfigConstants.KEYWORD_COLOR_SIGN};
        this.f38963n = -1;
        m29290a(context, attributeSet);
    }

    /* renamed from: a */
    private void m29290a(Context context, AttributeSet attributeSet) {
        this.f38955f = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.SideBar, 0, 0);
        for (int i = 0; i < obtainStyledAttributes.getIndexCount(); i++) {
            int index = obtainStyledAttributes.getIndex(i);
            if (index == 2) {
                this.f38950a = obtainStyledAttributes.getDimensionPixelSize(index, this.f38950a);
            } else if (index == 1) {
                this.f38951b = obtainStyledAttributes.getColor(index, this.f38951b);
            } else if (index == 0) {
                this.f38952c = obtainStyledAttributes.getColor(index, this.f38952c);
            } else if (index == 3) {
                this.f38953d = obtainStyledAttributes.getColor(index, this.f38953d);
            }
        }
        obtainStyledAttributes.recycle();
        TextPaint textPaint = new TextPaint();
        this.f38961l = textPaint;
        textPaint.setColor(this.f38951b);
        this.f38961l.setTextSize((float) this.f38950a);
        this.f38961l.setAntiAlias(true);
        setBackgroundColor(this.f38952c);
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        this.f38957h = (float) i;
        float f = (float) i2;
        String[] strArr = this.f38954e;
        float length = (1.0f * f) / ((float) strArr.length);
        this.f38958i = length;
        this.f38956g = (f - (length * ((float) strArr.length))) / 2.0f;
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
                size2 = this.f38954e.length * (this.f38960k + ViewUtil.dip2px(this.f38955f, 5.0f));
            }
            if (mode == Integer.MIN_VALUE) {
                size = this.f38959j + ViewUtil.dip2px(this.f38955f, 5.0f);
            }
        }
        setMeasuredDimension(size, size2);
    }

    private void getMaxTextSize() {
        for (String str : this.f38954e) {
            this.f38959j = (int) Math.max((float) this.f38959j, this.f38961l.measureText(str));
            this.f38960k = Math.max(this.f38960k, ViewUtil.getTextHeight(this.f38961l, str));
        }
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        int i = 0;
        while (true) {
            String[] strArr = this.f38954e;
            if (i < strArr.length) {
                String str = strArr[i];
                float f = this.f38956g;
                float f2 = this.f38958i;
                canvas.drawText(str, (this.f38957h - ((float) ViewUtil.getTextWidth(this.f38961l, str))) / 2.0f, f + (((float) i) * f2) + ((f2 + ((float) ViewUtil.getTextHeight(this.f38961l, str))) / 2.0f), this.f38961l);
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
            r5.f38963n = r1
            int r6 = r5.f38952c
            r5.setBackgroundColor(r6)
            com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener r6 = r5.f38964o
            if (r6 == 0) goto L_0x008c
            r6.onTouchEnd()
            goto L_0x008c
        L_0x0021:
            java.util.List<java.lang.String> r0 = r5.f38962m
            if (r0 == 0) goto L_0x008c
            boolean r0 = r0.isEmpty()
            if (r0 == 0) goto L_0x002c
            goto L_0x008c
        L_0x002c:
            float r0 = r6.getY()
            float r3 = r5.f38956g
            float r0 = r0 - r3
            float r3 = r5.f38958i
            float r0 = r0 / r3
            int r0 = (int) r0
            int r3 = r5.f38963n
            if (r0 != r3) goto L_0x003c
            return r2
        L_0x003c:
            int r6 = r6.getAction()
            if (r6 != 0) goto L_0x0047
            int r6 = r5.f38953d
            r5.setBackgroundColor(r6)
        L_0x0047:
            if (r0 < 0) goto L_0x008c
            java.lang.String[] r6 = r5.f38954e
            int r6 = r6.length
            if (r0 >= r6) goto L_0x008c
            r5.f38963n = r0
            com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener r6 = r5.f38964o
            if (r6 == 0) goto L_0x008c
            r6 = 0
        L_0x0055:
            java.util.List<java.lang.String> r3 = r5.f38962m
            int r3 = r3.size()
            if (r6 >= r3) goto L_0x008c
            java.lang.String[] r3 = r5.f38954e
            r3 = r3[r0]
            java.util.List<java.lang.String> r4 = r5.f38962m
            java.lang.Object r4 = r4.get(r6)
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0077
            com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener r1 = r5.f38964o
            java.lang.String[] r3 = r5.f38954e
            r0 = r3[r0]
            r1.onTouch(r0, r6)
            goto L_0x008c
        L_0x0077:
            java.util.List<java.lang.String> r3 = r5.f38962m
            int r3 = r3.size()
            int r3 = r3 - r2
            if (r6 != r3) goto L_0x0089
            com.didi.sdk.global.indexbar.listener.OnSideBarTouchListener r3 = r5.f38964o
            java.lang.String[] r4 = r5.f38954e
            r4 = r4[r0]
            r3.onTouch(r4, r1)
        L_0x0089:
            int r6 = r6 + 1
            goto L_0x0055
        L_0x008c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.indexbar.widget.SideBar.onTouchEvent(android.view.MotionEvent):boolean");
    }

    public void setOnSideBarTouchListener(List<String> list, OnSideBarTouchListener onSideBarTouchListener) {
        this.f38962m = list;
        this.f38964o = onSideBarTouchListener;
    }
}
