package com.didiglobal.dittoview.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;
import android.graphics.drawable.BitmapDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import com.didiglobal.dittoview.IParser;
import com.didiglobal.dittoview.IView;
import com.facebook.yoga.YogaAlign;
import com.facebook.yoga.YogaNode;
import com.facebook.yoga.android.YogaLayout;
import org.xmlpull.v1.XmlPullParser;

public class DittoYogaLayout extends YogaLayout implements IParser, IView {

    /* renamed from: a */
    private Context f52530a;

    /* renamed from: b */
    private YogaNode f52531b;

    /* renamed from: c */
    private boolean f52532c;

    /* renamed from: d */
    private Path f52533d;

    /* renamed from: e */
    private Paint f52534e;

    /* renamed from: f */
    private RectF f52535f;

    /* renamed from: g */
    private float f52536g;

    /* renamed from: h */
    private float[] f52537h;

    /* renamed from: i */
    private boolean f52538i;

    /* renamed from: j */
    private int f52539j;

    /* renamed from: k */
    private int f52540k;

    /* renamed from: l */
    private float f52541l;

    /* renamed from: m */
    private float f52542m;

    /* renamed from: n */
    private float f52543n;

    /* renamed from: o */
    private RectF f52544o;

    /* renamed from: p */
    private int f52545p;

    /* renamed from: q */
    private int f52546q;

    /* renamed from: r */
    private int f52547r;

    /* renamed from: s */
    private int f52548s;

    /* renamed from: t */
    private boolean f52549t;

    /* renamed from: u */
    private float f52550u;

    /* renamed from: v */
    private float f52551v;

    /* renamed from: w */
    private float f52552w;

    /* renamed from: x */
    private float f52553x;

    /* renamed from: y */
    private float f52554y;

    /* renamed from: z */
    private Paint f52555z;

    public View getView() {
        return this;
    }

    public void onParseEnd() {
    }

    public DittoYogaLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public DittoYogaLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public DittoYogaLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f52537h = new float[8];
        this.f52538i = false;
        this.f52544o = new RectF();
        this.f52549t = false;
        this.f52551v = -1.0f;
        this.f52552w = -1.0f;
        this.f52553x = -1.0f;
        this.f52554y = -1.0f;
        this.f52530a = context;
        this.f52531b = getYogaNode();
        this.f52535f = new RectF();
        this.f52533d = new Path();
        Paint paint = new Paint();
        this.f52534e = paint;
        paint.setAntiAlias(true);
        this.f52534e.setColor(0);
        this.f52534e.setStyle(Paint.Style.STROKE);
    }

    public void parse(XmlPullParser xmlPullParser) {
        String attributeValue = xmlPullParser.getAttributeValue((String) null, "flex-direction");
        String attributeValue2 = xmlPullParser.getAttributeValue((String) null, "flex-wrap");
        String attributeValue3 = xmlPullParser.getAttributeValue((String) null, "justify-content");
        String attributeValue4 = xmlPullParser.getAttributeValue((String) null, "align-items");
        String attributeValue5 = xmlPullParser.getAttributeValue((String) null, "align-content");
        if (!TextUtils.isEmpty(attributeValue)) {
            this.f52531b.setFlexDirection(getFlexDirection(attributeValue));
        }
        if (!TextUtils.isEmpty(attributeValue2)) {
            this.f52531b.setWrap(getFlexWrap(attributeValue2));
        }
        if (!TextUtils.isEmpty(attributeValue3)) {
            this.f52531b.setJustifyContent(getJustifyContent(attributeValue3));
        }
        if (!TextUtils.isEmpty(attributeValue4)) {
            this.f52531b.setAlignItems(getAlignItems(attributeValue4));
        }
        if (!TextUtils.isEmpty(attributeValue5)) {
            this.f52531b.setAlignContent(getAlignContent(attributeValue5));
        }
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void parse(java.lang.String r2, java.lang.String r3, com.facebook.yoga.YogaNode r4) {
        /*
            r1 = this;
            int r4 = r2.hashCode()
            r0 = 0
            switch(r4) {
                case -1930482377: goto L_0x004f;
                case -1802500706: goto L_0x0045;
                case -903579360: goto L_0x003b;
                case 109780401: goto L_0x0031;
                case 122090044: goto L_0x0027;
                case 587430648: goto L_0x001d;
                case 695731883: goto L_0x0013;
                case 715446705: goto L_0x0009;
                default: goto L_0x0008;
            }
        L_0x0008:
            goto L_0x0059
        L_0x0009:
            java.lang.String r4 = "align-content"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0059
            r4 = 4
            goto L_0x005a
        L_0x0013:
            java.lang.String r4 = "flex-direction"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0059
            r4 = 0
            goto L_0x005a
        L_0x001d:
            java.lang.String r4 = "align-items"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0059
            r4 = 3
            goto L_0x005a
        L_0x0027:
            java.lang.String r4 = "justify-content"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0059
            r4 = 2
            goto L_0x005a
        L_0x0031:
            java.lang.String r4 = "style"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0059
            r4 = 6
            goto L_0x005a
        L_0x003b:
            java.lang.String r4 = "shadow"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0059
            r4 = 5
            goto L_0x005a
        L_0x0045:
            java.lang.String r4 = "flex-wrap"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0059
            r4 = 1
            goto L_0x005a
        L_0x004f:
            java.lang.String r4 = "masksToBounds"
            boolean r4 = r2.equals(r4)
            if (r4 == 0) goto L_0x0059
            r4 = 7
            goto L_0x005a
        L_0x0059:
            r4 = -1
        L_0x005a:
            switch(r4) {
                case 0: goto L_0x00be;
                case 1: goto L_0x00b4;
                case 2: goto L_0x00aa;
                case 3: goto L_0x00a0;
                case 4: goto L_0x0096;
                case 5: goto L_0x00c7;
                case 6: goto L_0x00c7;
                case 7: goto L_0x0074;
                default: goto L_0x005d;
            }
        L_0x005d:
            java.lang.IllegalArgumentException r3 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r4 = new java.lang.StringBuilder
            r4.<init>()
            java.lang.String r0 = "Unknown view param: "
            r4.append(r0)
            r4.append(r2)
            java.lang.String r2 = r4.toString()
            r3.<init>(r2)
            throw r3
        L_0x0074:
            java.lang.Integer r2 = java.lang.Integer.valueOf(r3)
            int r2 = r2.intValue()
            if (r2 != 0) goto L_0x00c7
            android.view.ViewParent r2 = r1.getParent()
            android.view.ViewGroup r2 = (android.view.ViewGroup) r2
            if (r2 == 0) goto L_0x008d
            r2.setClipChildren(r0)
            r2.setClipToPadding(r0)
            goto L_0x00c7
        L_0x008d:
            com.didiglobal.dittoview.view.DittoYogaLayout$1 r2 = new com.didiglobal.dittoview.view.DittoYogaLayout$1
            r2.<init>()
            r1.post(r2)
            goto L_0x00c7
        L_0x0096:
            com.facebook.yoga.YogaNode r2 = r1.f52531b
            com.facebook.yoga.YogaAlign r3 = r1.getAlignContent(r3)
            r2.setAlignContent(r3)
            goto L_0x00c7
        L_0x00a0:
            com.facebook.yoga.YogaNode r2 = r1.f52531b
            com.facebook.yoga.YogaAlign r3 = r1.getAlignItems(r3)
            r2.setAlignItems(r3)
            goto L_0x00c7
        L_0x00aa:
            com.facebook.yoga.YogaNode r2 = r1.f52531b
            com.facebook.yoga.YogaJustify r3 = r1.getJustifyContent(r3)
            r2.setJustifyContent(r3)
            goto L_0x00c7
        L_0x00b4:
            com.facebook.yoga.YogaNode r2 = r1.f52531b
            com.facebook.yoga.YogaWrap r3 = r1.getFlexWrap(r3)
            r2.setWrap(r3)
            goto L_0x00c7
        L_0x00be:
            com.facebook.yoga.YogaNode r2 = r1.f52531b
            com.facebook.yoga.YogaFlexDirection r3 = r1.getFlexDirection(r3)
            r2.setFlexDirection(r3)
        L_0x00c7:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.view.DittoYogaLayout.parse(java.lang.String, java.lang.String, com.facebook.yoga.YogaNode):void");
    }

    /* JADX WARNING: Removed duplicated region for block: B:17:0x0037  */
    /* JADX WARNING: Removed duplicated region for block: B:25:0x0058  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.yoga.YogaWrap getFlexWrap(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = -1039592053(0xffffffffc209158b, float:-34.271038)
            r2 = 2
            r3 = 1
            if (r0 == r1) goto L_0x002a
            r1 = -749527969(0xffffffffd3531c5f, float:-9.0671409E11)
            if (r0 == r1) goto L_0x0020
            r1 = 3657802(0x37d04a, float:5.125672E-39)
            if (r0 == r1) goto L_0x0016
            goto L_0x0034
        L_0x0016:
            java.lang.String r0 = "wrap"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 1
            goto L_0x0035
        L_0x0020:
            java.lang.String r0 = "wrap-reverse"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 2
            goto L_0x0035
        L_0x002a:
            java.lang.String r0 = "nowrap"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0034
            r0 = 0
            goto L_0x0035
        L_0x0034:
            r0 = -1
        L_0x0035:
            if (r0 == 0) goto L_0x0058
            if (r0 == r3) goto L_0x0055
            if (r0 != r2) goto L_0x003e
            com.facebook.yoga.YogaWrap r5 = com.facebook.yoga.YogaWrap.WRAP_REVERSE
            return r5
        L_0x003e:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown enum value: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0055:
            com.facebook.yoga.YogaWrap r5 = com.facebook.yoga.YogaWrap.WRAP
            return r5
        L_0x0058:
            com.facebook.yoga.YogaWrap r5 = com.facebook.yoga.YogaWrap.NO_WRAP
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.view.DittoYogaLayout.getFlexWrap(java.lang.String):com.facebook.yoga.YogaWrap");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.yoga.YogaFlexDirection getFlexDirection(java.lang.String r5) {
        /*
            r4 = this;
            int r0 = r5.hashCode()
            r1 = 3
            r2 = 2
            r3 = 1
            switch(r0) {
                case -1448970769: goto L_0x0029;
                case -1354837162: goto L_0x001f;
                case 113114: goto L_0x0015;
                case 1272730475: goto L_0x000b;
                default: goto L_0x000a;
            }
        L_0x000a:
            goto L_0x0033
        L_0x000b:
            java.lang.String r0 = "column-reverse"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 1
            goto L_0x0034
        L_0x0015:
            java.lang.String r0 = "row"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 2
            goto L_0x0034
        L_0x001f:
            java.lang.String r0 = "column"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 0
            goto L_0x0034
        L_0x0029:
            java.lang.String r0 = "row-reverse"
            boolean r0 = r5.equals(r0)
            if (r0 == 0) goto L_0x0033
            r0 = 3
            goto L_0x0034
        L_0x0033:
            r0 = -1
        L_0x0034:
            if (r0 == 0) goto L_0x005c
            if (r0 == r3) goto L_0x0059
            if (r0 == r2) goto L_0x0056
            if (r0 != r1) goto L_0x003f
            com.facebook.yoga.YogaFlexDirection r5 = com.facebook.yoga.YogaFlexDirection.ROW_REVERSE
            return r5
        L_0x003f:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown enum value: "
            r1.append(r2)
            r1.append(r5)
            java.lang.String r5 = r1.toString()
            r0.<init>(r5)
            throw r0
        L_0x0056:
            com.facebook.yoga.YogaFlexDirection r5 = com.facebook.yoga.YogaFlexDirection.ROW
            return r5
        L_0x0059:
            com.facebook.yoga.YogaFlexDirection r5 = com.facebook.yoga.YogaFlexDirection.COLUMN_REVERSE
            return r5
        L_0x005c:
            com.facebook.yoga.YogaFlexDirection r5 = com.facebook.yoga.YogaFlexDirection.COLUMN
            return r5
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.view.DittoYogaLayout.getFlexDirection(java.lang.String):com.facebook.yoga.YogaFlexDirection");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.yoga.YogaJustify getJustifyContent(java.lang.String r6) {
        /*
            r5 = this;
            int r0 = r6.hashCode()
            r1 = 4
            r2 = 3
            r3 = 2
            r4 = 1
            switch(r0) {
                case -1364013995: goto L_0x0034;
                case -46581362: goto L_0x002a;
                case 441309761: goto L_0x0020;
                case 1742952711: goto L_0x0016;
                case 1937124468: goto L_0x000c;
                default: goto L_0x000b;
            }
        L_0x000b:
            goto L_0x003e
        L_0x000c:
            java.lang.String r0 = "space-around"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 4
            goto L_0x003f
        L_0x0016:
            java.lang.String r0 = "flex-end"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 2
            goto L_0x003f
        L_0x0020:
            java.lang.String r0 = "space-between"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 3
            goto L_0x003f
        L_0x002a:
            java.lang.String r0 = "flex-start"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 0
            goto L_0x003f
        L_0x0034:
            java.lang.String r0 = "center"
            boolean r0 = r6.equals(r0)
            if (r0 == 0) goto L_0x003e
            r0 = 1
            goto L_0x003f
        L_0x003e:
            r0 = -1
        L_0x003f:
            if (r0 == 0) goto L_0x006c
            if (r0 == r4) goto L_0x0069
            if (r0 == r3) goto L_0x0066
            if (r0 == r2) goto L_0x0063
            if (r0 != r1) goto L_0x004c
            com.facebook.yoga.YogaJustify r6 = com.facebook.yoga.YogaJustify.SPACE_AROUND
            return r6
        L_0x004c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown enum value: "
            r1.append(r2)
            r1.append(r6)
            java.lang.String r6 = r1.toString()
            r0.<init>(r6)
            throw r0
        L_0x0063:
            com.facebook.yoga.YogaJustify r6 = com.facebook.yoga.YogaJustify.SPACE_BETWEEN
            return r6
        L_0x0066:
            com.facebook.yoga.YogaJustify r6 = com.facebook.yoga.YogaJustify.FLEX_END
            return r6
        L_0x0069:
            com.facebook.yoga.YogaJustify r6 = com.facebook.yoga.YogaJustify.CENTER
            return r6
        L_0x006c:
            com.facebook.yoga.YogaJustify r6 = com.facebook.yoga.YogaJustify.FLEX_START
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.view.DittoYogaLayout.getJustifyContent(java.lang.String):com.facebook.yoga.YogaJustify");
    }

    /* JADX WARNING: Can't fix incorrect switch cases order */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.facebook.yoga.YogaAlign getAlignItems(java.lang.String r4) {
        /*
            r3 = this;
            int r0 = r4.hashCode()
            switch(r0) {
                case -1881872635: goto L_0x004e;
                case -1720785339: goto L_0x0044;
                case -1364013995: goto L_0x003a;
                case -46581362: goto L_0x0030;
                case 3005871: goto L_0x0026;
                case 441309761: goto L_0x001c;
                case 1742952711: goto L_0x0012;
                case 1937124468: goto L_0x0008;
                default: goto L_0x0007;
            }
        L_0x0007:
            goto L_0x0058
        L_0x0008:
            java.lang.String r0 = "space-around"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 7
            goto L_0x0059
        L_0x0012:
            java.lang.String r0 = "flex-end"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 3
            goto L_0x0059
        L_0x001c:
            java.lang.String r0 = "space-between"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 6
            goto L_0x0059
        L_0x0026:
            java.lang.String r0 = "auto"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 0
            goto L_0x0059
        L_0x0030:
            java.lang.String r0 = "flex-start"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 1
            goto L_0x0059
        L_0x003a:
            java.lang.String r0 = "center"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 2
            goto L_0x0059
        L_0x0044:
            java.lang.String r0 = "baseline"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 5
            goto L_0x0059
        L_0x004e:
            java.lang.String r0 = "stretch"
            boolean r0 = r4.equals(r0)
            if (r0 == 0) goto L_0x0058
            r0 = 4
            goto L_0x0059
        L_0x0058:
            r0 = -1
        L_0x0059:
            switch(r0) {
                case 0: goto L_0x0088;
                case 1: goto L_0x0085;
                case 2: goto L_0x0082;
                case 3: goto L_0x007f;
                case 4: goto L_0x007c;
                case 5: goto L_0x0079;
                case 6: goto L_0x0076;
                case 7: goto L_0x0073;
                default: goto L_0x005c;
            }
        L_0x005c:
            java.lang.IllegalArgumentException r0 = new java.lang.IllegalArgumentException
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Unknown enum value: "
            r1.append(r2)
            r1.append(r4)
            java.lang.String r4 = r1.toString()
            r0.<init>(r4)
            throw r0
        L_0x0073:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.SPACE_AROUND
            return r4
        L_0x0076:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.SPACE_BETWEEN
            return r4
        L_0x0079:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.BASELINE
            return r4
        L_0x007c:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.STRETCH
            return r4
        L_0x007f:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.FLEX_END
            return r4
        L_0x0082:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.CENTER
            return r4
        L_0x0085:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.FLEX_START
            return r4
        L_0x0088:
            com.facebook.yoga.YogaAlign r4 = com.facebook.yoga.YogaAlign.AUTO
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.dittoview.view.DittoYogaLayout.getAlignItems(java.lang.String):com.facebook.yoga.YogaAlign");
    }

    public YogaAlign getAlignContent(String str) {
        return getAlignItems(str);
    }

    public void setBorder(DittoBorder dittoBorder) {
        this.f52532c = true;
        float borderWidth = dittoBorder.getBorderWidth();
        this.f52536g = borderWidth;
        this.f52534e.setStrokeWidth(borderWidth);
        this.f52534e.setColor(dittoBorder.getBorderColor());
    }

    /* access modifiers changed from: protected */
    public void dispatchDraw(Canvas canvas) {
        if (this.f52538i || this.f52549t) {
            this.f52544o.left = (float) this.f52545p;
            this.f52544o.top = (float) this.f52546q;
            this.f52544o.right = (float) (getWidth() - this.f52547r);
            this.f52544o.bottom = (float) (getHeight() - this.f52548s);
            int i = (int) (this.f52544o.bottom - this.f52544o.top);
            if (this.f52551v == -1.0f && this.f52553x == -1.0f && this.f52552w == -1.0f && this.f52554y == -1.0f) {
                Path path = new Path();
                float f = this.f52550u;
                float f2 = (float) (i / 2);
                if (f > f2) {
                    path.addRoundRect(this.f52544o, f2, f2, Path.Direction.CW);
                } else {
                    path.addRoundRect(this.f52544o, f, f, Path.Direction.CW);
                }
                canvas.clipPath(path);
            } else {
                float[] cornerValue = getCornerValue(i);
                Path path2 = new Path();
                path2.addRoundRect((float) this.f52545p, (float) this.f52546q, (float) (getWidth() - this.f52547r), (float) (getHeight() - this.f52548s), cornerValue, Path.Direction.CW);
                canvas.clipPath(path2);
            }
        }
        super.dispatchDraw(canvas);
        if (this.f52532c) {
            this.f52533d.reset();
            this.f52535f.left = this.f52536g / 2.0f;
            this.f52535f.top = this.f52536g / 2.0f;
            this.f52535f.right = ((float) getMeasuredWidth()) - (this.f52536g / 2.0f);
            this.f52535f.bottom = ((float) getMeasuredHeight()) - (this.f52536g / 2.0f);
            this.f52533d.addRoundRect(this.f52535f, this.f52537h, Path.Direction.CW);
            canvas.drawPath(this.f52533d, this.f52534e);
        }
    }

    public void setCorner(DittoCorner dittoCorner) {
        float[] fArr = this.f52537h;
        float leftTopCorner = dittoCorner.getLeftTopCorner();
        fArr[1] = leftTopCorner;
        fArr[0] = leftTopCorner;
        float[] fArr2 = this.f52537h;
        float rightTopCorner = dittoCorner.getRightTopCorner();
        fArr2[3] = rightTopCorner;
        fArr2[2] = rightTopCorner;
        float[] fArr3 = this.f52537h;
        float rightBottomCorner = dittoCorner.getRightBottomCorner();
        fArr3[5] = rightBottomCorner;
        fArr3[4] = rightBottomCorner;
        float[] fArr4 = this.f52537h;
        float leftBottomCorner = dittoCorner.getLeftBottomCorner();
        fArr4[7] = leftBottomCorner;
        fArr4[6] = leftBottomCorner;
        if (!dittoCorner.isEmpty) {
            this.f52549t = true;
            this.f52550u = dittoCorner.getCornerRadius();
        }
    }

    /* access modifiers changed from: protected */
    public void onSizeChanged(int i, int i2, int i3, int i4) {
        super.onSizeChanged(i, i2, i3, i4);
        if (i > 0 && i2 > 0 && this.f52538i) {
            m39446a(i, i2);
        }
    }

    public void setShadow(DittoShadow dittoShadow) {
        this.f52538i = true;
        this.f52540k = dittoShadow.getShadowRadius();
        this.f52539j = dittoShadow.getShadowColor();
        this.f52542m = dittoShadow.getShadowOffsetX();
        this.f52543n = dittoShadow.getShadowOffsetY();
        this.f52541l = dittoShadow.getShadowOpacity();
        float abs = Math.abs(this.f52542m);
        int i = this.f52540k;
        if (abs > ((float) i)) {
            if (this.f52542m > 0.0f) {
                this.f52542m = (float) i;
            } else {
                this.f52542m = (float) (-i);
            }
        }
        float abs2 = Math.abs(this.f52543n);
        int i2 = this.f52540k;
        if (abs2 > ((float) i2)) {
            if (this.f52543n > 0.0f) {
                this.f52543n = (float) i2;
            } else {
                this.f52543n = (float) (-i2);
            }
        }
        m39445a();
        setPadding();
    }

    /* renamed from: a */
    private void m39445a() {
        Paint paint = new Paint();
        this.f52555z = paint;
        paint.setStyle(Paint.Style.FILL);
        this.f52555z.setDither(true);
        this.f52555z.setAntiAlias(true);
        this.f52555z.setAlpha((int) (this.f52541l * 255.0f));
    }

    /* renamed from: a */
    private void m39446a(int i, int i2) {
        if (this.f52538i) {
            BitmapDrawable bitmapDrawable = new BitmapDrawable(m39444a(i, i2, this.f52550u, (float) this.f52540k, this.f52542m, this.f52543n, this.f52539j, -1));
            if (Build.VERSION.SDK_INT <= 16) {
                setBackgroundDrawable(bitmapDrawable);
            } else {
                setBackground(bitmapDrawable);
            }
        }
    }

    public void setPadding() {
        if (this.f52538i) {
            int abs = this.f52540k + ((int) Math.abs(this.f52542m));
            int abs2 = this.f52540k + ((int) Math.abs(this.f52543n));
            this.f52545p = abs;
            this.f52546q = abs2;
            this.f52547r = abs;
            this.f52548s = abs2;
            setPadding(abs, abs2, abs, abs2);
        }
    }

    /* renamed from: a */
    private Bitmap m39444a(int i, int i2, float f, float f2, float f3, float f4, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        int i8;
        float f5 = f3 / 4.0f;
        float f6 = f4 / 4.0f;
        int i9 = i / 4;
        if (i9 == 0) {
            i9 = 1;
        }
        int i10 = i2 / 4;
        if (i10 == 0) {
            i10 = 1;
        }
        float f7 = f / 4.0f;
        float f8 = f2 / 4.0f;
        Bitmap createBitmap = Bitmap.createBitmap(i9, i10, Bitmap.Config.ARGB_4444);
        Canvas canvas = new Canvas(createBitmap);
        RectF rectF = new RectF(f8, f8, ((float) i9) - f8, ((float) i10) - f8);
        if (f6 > 0.0f) {
            rectF.top += f6;
            rectF.bottom -= f6;
        } else if (f6 < 0.0f) {
            rectF.top += Math.abs(f6);
            rectF.bottom -= Math.abs(f6);
        }
        if (f5 > 0.0f) {
            rectF.left += f5;
            rectF.right -= f5;
        } else if (f5 < 0.0f) {
            rectF.left += Math.abs(f5);
            rectF.right -= Math.abs(f5);
        }
        this.f52555z.setColor(i4);
        if (!isInEditMode()) {
            this.f52555z.setShadowLayer(f8 / 2.0f, f5, f6, i3);
        }
        if (this.f52553x == -1.0f && this.f52551v == -1.0f && this.f52552w == -1.0f && this.f52554y == -1.0f) {
            canvas.drawRoundRect(rectF, f7, f7, this.f52555z);
        } else {
            this.f52544o.left = (float) this.f52545p;
            this.f52544o.top = (float) this.f52546q;
            this.f52544o.right = (float) (getWidth() - this.f52547r);
            this.f52544o.bottom = (float) (getHeight() - this.f52548s);
            float f9 = this.f52551v;
            if (f9 == -1.0f) {
                i5 = ((int) this.f52550u) / 4;
            } else {
                i5 = ((int) f9) / 4;
            }
            float f10 = this.f52553x;
            if (f10 == -1.0f) {
                i6 = ((int) this.f52550u) / 4;
            } else {
                i6 = ((int) f10) / 4;
            }
            float f11 = this.f52552w;
            if (f11 == -1.0f) {
                i7 = ((int) this.f52550u) / 4;
            } else {
                i7 = ((int) f11) / 4;
            }
            float f12 = this.f52554y;
            if (f12 == -1.0f) {
                i8 = ((int) this.f52550u) / 4;
            } else {
                i8 = ((int) f12) / 4;
            }
            float f13 = (float) i5;
            float f14 = (float) i7;
            float f15 = (float) i8;
            float f16 = (float) i6;
            float[] fArr = {f13, f13, f14, f14, f15, f15, f16, f16};
            Path path = new Path();
            path.addRoundRect(rectF, fArr, Path.Direction.CW);
            canvas.drawPath(path, this.f52555z);
        }
        return createBitmap;
    }

    public float[] getCornerValue(int i) {
        float f = this.f52551v;
        if (f == -1.0f) {
            f = this.f52550u;
        }
        int i2 = (int) f;
        int i3 = i / 2;
        if (i2 > i3) {
            i2 = i3;
        }
        float f2 = this.f52552w;
        if (f2 == -1.0f) {
            f2 = this.f52550u;
        }
        int i4 = (int) f2;
        if (i4 > i3) {
            i4 = i3;
        }
        float f3 = this.f52554y;
        if (f3 == -1.0f) {
            f3 = this.f52550u;
        }
        int i5 = (int) f3;
        if (i5 > i3) {
            i5 = i3;
        }
        float f4 = this.f52553x;
        int i6 = f4 == -1.0f ? (int) this.f52550u : (int) f4;
        if (i6 <= i3) {
            i3 = i6;
        }
        float f5 = (float) i2;
        float f6 = (float) i4;
        float f7 = (float) i5;
        float f8 = (float) i3;
        return new float[]{f5, f5, f6, f6, f7, f7, f8, f8};
    }
}
