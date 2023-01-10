package com.didi.sdk.global.base;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import com.didi.passenger.C11267R;
import java.util.ArrayList;
import java.util.List;

public class FlowLayout extends ViewGroup {
    public static final int SPACING_ALIGN = -65537;
    public static final int SPACING_AUTO = -65536;

    /* renamed from: a */
    private static final String f38821a = FlowLayout.class.getSimpleName();

    /* renamed from: b */
    private static final int f38822b = -65538;

    /* renamed from: c */
    private static final int f38823c = -1;

    /* renamed from: d */
    private static final int f38824d = -65536;

    /* renamed from: e */
    private static final boolean f38825e = true;

    /* renamed from: f */
    private static final int f38826f = 0;

    /* renamed from: g */
    private static final int f38827g = -65538;

    /* renamed from: h */
    private static final float f38828h = 0.0f;

    /* renamed from: i */
    private static final boolean f38829i = false;

    /* renamed from: j */
    private static final int f38830j = Integer.MAX_VALUE;

    /* renamed from: k */
    private boolean f38831k;

    /* renamed from: l */
    private int f38832l;

    /* renamed from: m */
    private int f38833m;

    /* renamed from: n */
    private int f38834n;

    /* renamed from: o */
    private float f38835o;

    /* renamed from: p */
    private float f38836p;

    /* renamed from: q */
    private boolean f38837q;

    /* renamed from: r */
    private int f38838r;

    /* renamed from: s */
    private int f38839s;

    /* renamed from: t */
    private int f38840t;

    /* renamed from: u */
    private int f38841u;

    /* renamed from: v */
    private List<Float> f38842v;

    /* renamed from: w */
    private List<Integer> f38843w;

    /* renamed from: x */
    private List<Integer> f38844x;

    /* renamed from: y */
    private List<Integer> f38845y;

    public FlowLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public FlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f38831k = true;
        this.f38832l = 0;
        this.f38833m = 0;
        this.f38834n = -65538;
        this.f38835o = 0.0f;
        this.f38836p = 0.0f;
        this.f38837q = false;
        this.f38838r = Integer.MAX_VALUE;
        this.f38839s = -1;
        this.f38840t = -65536;
        this.f38842v = new ArrayList();
        this.f38843w = new ArrayList();
        this.f38844x = new ArrayList();
        this.f38845y = new ArrayList();
        TypedArray obtainStyledAttributes = context.getTheme().obtainStyledAttributes(attributeSet, C11267R.styleable.FlowLayout, 0, 0);
        try {
            this.f38831k = obtainStyledAttributes.getBoolean(3, true);
            this.f38832l = m29225a(obtainStyledAttributes, 1, (int) m29223a(0.0f));
            this.f38833m = m29225a(obtainStyledAttributes, 5, (int) m29223a(0.0f));
            this.f38834n = m29225a(obtainStyledAttributes, 2, -65538);
            this.f38835o = (float) m29225a(obtainStyledAttributes, 6, (int) m29223a(0.0f));
            this.f38838r = obtainStyledAttributes.getInt(4, Integer.MAX_VALUE);
            this.f38837q = obtainStyledAttributes.getBoolean(8, false);
            this.f38839s = obtainStyledAttributes.getInt(0, -1);
            this.f38840t = obtainStyledAttributes.getInt(7, -65536);
        } finally {
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private int m29225a(TypedArray typedArray, int i, int i2) {
        TypedValue typedValue = new TypedValue();
        typedArray.getValue(i, typedValue);
        if (typedValue.type == 5) {
            return typedArray.getDimensionPixelSize(i, i2);
        }
        return typedArray.getInt(i, i2);
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int i3;
        int i4;
        int i5;
        float f;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        float f2;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        View view;
        int i19;
        int i20;
        super.onMeasure(i, i2);
        int size = View.MeasureSpec.getSize(i);
        int mode = View.MeasureSpec.getMode(i);
        int size2 = View.MeasureSpec.getSize(i2);
        int mode2 = View.MeasureSpec.getMode(i2);
        this.f38842v.clear();
        this.f38843w.clear();
        this.f38844x.clear();
        this.f38845y.clear();
        int childCount = getChildCount();
        int paddingLeft = (size - getPaddingLeft()) - getPaddingRight();
        boolean z = mode != 0 && this.f38831k;
        if (this.f38832l == -65536 && mode == 0) {
            i3 = 0;
        } else {
            i3 = this.f38832l;
        }
        float f3 = i3 == -65536 ? (float) this.f38833m : (float) i3;
        int i21 = 0;
        int i22 = 0;
        int i23 = 0;
        int i24 = 0;
        int i25 = 0;
        int i26 = 0;
        int i27 = 0;
        while (i23 < childCount) {
            float f4 = f3;
            View childAt = getChildAt(i23);
            int i28 = i21;
            if (childAt.getVisibility() == 8) {
                int i29 = i;
                i8 = i23;
                i14 = i3;
                i10 = mode;
                i7 = mode2;
                i9 = childCount;
                f2 = f4;
                i15 = i22;
                i12 = size;
                i13 = i28;
                int i30 = i2;
                i11 = size2;
            } else {
                ViewGroup.LayoutParams layoutParams = childAt.getLayoutParams();
                if (layoutParams instanceof ViewGroup.MarginLayoutParams) {
                    i9 = childCount;
                    i17 = i28;
                    i11 = size2;
                    i18 = i22;
                    i8 = i23;
                    i7 = mode2;
                    f2 = f4;
                    i12 = size;
                    view = childAt;
                    i16 = i3;
                    i10 = mode;
                    measureChildWithMargins(childAt, i, 0, i2, i26);
                    ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) layoutParams;
                    i20 = marginLayoutParams.leftMargin + marginLayoutParams.rightMargin;
                    i19 = marginLayoutParams.topMargin + marginLayoutParams.bottomMargin;
                    int i31 = i;
                    int i32 = i2;
                } else {
                    i8 = i23;
                    i16 = i3;
                    i10 = mode;
                    i7 = mode2;
                    i9 = childCount;
                    f2 = f4;
                    i17 = i28;
                    i12 = size;
                    i11 = size2;
                    i18 = i22;
                    view = childAt;
                    measureChild(view, i, i2);
                    i20 = 0;
                    i19 = 0;
                }
                i15 = i20 + view.getMeasuredWidth();
                int measuredHeight = view.getMeasuredHeight() + i19;
                if (!z || i25 + i15 <= paddingLeft) {
                    i14 = i16;
                    i13 = i17 + 1;
                    i25 = (int) (((float) i25) + ((float) i15) + f2);
                    i15 += i18;
                    i27 = Math.max(i27, measuredHeight);
                } else {
                    i14 = i16;
                    this.f38842v.add(Float.valueOf(m29226b(i14, paddingLeft, i18, i17)));
                    this.f38845y.add(Integer.valueOf(i17));
                    this.f38843w.add(Integer.valueOf(i27));
                    int i33 = (int) f2;
                    this.f38844x.add(Integer.valueOf(i25 - i33));
                    if (this.f38842v.size() <= this.f38838r) {
                        i26 += i27;
                    }
                    i24 = Math.max(i24, i25);
                    i25 = i15 + i33;
                    i27 = measuredHeight;
                    i13 = 1;
                }
            }
            i22 = i15;
            i23 = i8 + 1;
            i3 = i14;
            i21 = i13;
            f3 = f2;
            size = i12;
            size2 = i11;
            mode = i10;
            childCount = i9;
            mode2 = i7;
        }
        int i34 = i21;
        int i35 = i3;
        int i36 = size;
        int i37 = mode;
        int i38 = size2;
        int i39 = mode2;
        int i40 = i22;
        float f5 = f3;
        int i41 = i27;
        int i42 = this.f38834n;
        if (i42 == -65537) {
            if (this.f38842v.size() >= 1) {
                List<Float> list = this.f38842v;
                list.add(list.get(list.size() - 1));
            } else {
                this.f38842v.add(Float.valueOf(m29226b(i35, paddingLeft, i40, i34)));
            }
        } else if (i42 != -65538) {
            this.f38842v.add(Float.valueOf(m29226b(i42, paddingLeft, i40, i34)));
        } else {
            this.f38842v.add(Float.valueOf(m29226b(i35, paddingLeft, i40, i34)));
        }
        this.f38845y.add(Integer.valueOf(i34));
        this.f38843w.add(Integer.valueOf(i41));
        this.f38844x.add(Integer.valueOf(i25 - ((int) f5)));
        if (this.f38842v.size() <= this.f38838r) {
            i26 += i41;
        }
        int max = Math.max(i24, i25);
        if (i35 == -65536) {
            i5 = i36;
            i4 = i5;
        } else if (i37 == 0) {
            i5 = max + getPaddingLeft() + getPaddingRight();
            i4 = i36;
        } else {
            i4 = i36;
            i5 = Math.min(max + getPaddingLeft() + getPaddingRight(), i4);
        }
        int paddingTop = i26 + getPaddingTop() + getPaddingBottom();
        int min = Math.min(this.f38842v.size(), this.f38838r);
        if (this.f38835o == -65536.0f && i39 == 0) {
            f = 0.0f;
        } else {
            f = this.f38835o;
        }
        if (f == -65536.0f) {
            if (min > 1) {
                this.f38836p = (float) ((i38 - paddingTop) / (min - 1));
            } else {
                this.f38836p = 0.0f;
            }
            paddingTop = i38;
            i6 = paddingTop;
        } else {
            this.f38836p = f;
            if (min > 1) {
                if (i39 == 0) {
                    paddingTop = (int) (((float) paddingTop) + (f * ((float) (min - 1))));
                } else {
                    i6 = i38;
                    paddingTop = Math.min((int) (((float) paddingTop) + (f * ((float) (min - 1)))), i6);
                }
            }
            i6 = i38;
        }
        this.f38841u = paddingTop;
        setMeasuredDimension(i37 == 1073741824 ? i4 : i5, i39 == 1073741824 ? i6 : paddingTop);
    }

    /* access modifiers changed from: protected */
    /* JADX WARNING: Removed duplicated region for block: B:13:0x005c  */
    /* JADX WARNING: Removed duplicated region for block: B:44:0x0172  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void onLayout(boolean r24, int r25, int r26, int r27, int r28) {
        /*
            r23 = this;
            r0 = r23
            int r1 = r23.getPaddingLeft()
            int r2 = r23.getPaddingRight()
            int r3 = r23.getPaddingTop()
            int r4 = r23.getPaddingBottom()
            boolean r5 = r0.f38837q
            if (r5 == 0) goto L_0x001c
            int r5 = r23.getWidth()
            int r5 = r5 - r2
            goto L_0x001d
        L_0x001c:
            r5 = r1
        L_0x001d:
            int r6 = r0.f38839s
            r7 = r6 & 112(0x70, float:1.57E-43)
            r6 = r6 & 7
            r8 = 80
            r9 = 16
            if (r7 == r9) goto L_0x0034
            if (r7 == r8) goto L_0x002c
            goto L_0x003e
        L_0x002c:
            int r7 = r28 - r26
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.f38841u
            int r7 = r7 - r4
            goto L_0x003d
        L_0x0034:
            int r7 = r28 - r26
            int r7 = r7 - r3
            int r7 = r7 - r4
            int r4 = r0.f38841u
            int r7 = r7 - r4
            int r7 = r7 / 2
        L_0x003d:
            int r3 = r3 + r7
        L_0x003e:
            int r4 = r1 + r2
            int r7 = r27 - r25
            r10 = 0
            int r11 = r0.m29224a(r6, r7, r4, r10)
            int r5 = r5 + r11
            int r11 = r0.f38840t
            r11 = r11 & 112(0x70, float:1.57E-43)
            java.util.List<java.lang.Integer> r12 = r0.f38845y
            int r12 = r12.size()
            r13 = 0
            r14 = 0
        L_0x0054:
            int r15 = r0.f38838r
            int r15 = java.lang.Math.min(r12, r15)
            if (r13 >= r15) goto L_0x016c
            java.util.List<java.lang.Integer> r15 = r0.f38845y
            java.lang.Object r15 = r15.get(r13)
            java.lang.Integer r15 = (java.lang.Integer) r15
            int r15 = r15.intValue()
            java.util.List<java.lang.Integer> r9 = r0.f38843w
            java.lang.Object r9 = r9.get(r13)
            java.lang.Integer r9 = (java.lang.Integer) r9
            int r9 = r9.intValue()
            java.util.List<java.lang.Float> r8 = r0.f38842v
            java.lang.Object r8 = r8.get(r13)
            java.lang.Float r8 = (java.lang.Float) r8
            float r8 = r8.floatValue()
            r10 = 0
        L_0x0081:
            r16 = r1
            if (r10 >= r15) goto L_0x0136
            int r1 = r23.getChildCount()
            if (r14 >= r1) goto L_0x0136
            int r1 = r14 + 1
            android.view.View r14 = r0.getChildAt(r14)
            r26 = r1
            int r1 = r14.getVisibility()
            r27 = r12
            r12 = 8
            if (r1 != r12) goto L_0x00a4
            r14 = r26
            r12 = r27
            r1 = r16
            goto L_0x0081
        L_0x00a4:
            int r10 = r10 + 1
            android.view.ViewGroup$LayoutParams r1 = r14.getLayoutParams()
            boolean r12 = r1 instanceof android.view.ViewGroup.MarginLayoutParams
            if (r12 == 0) goto L_0x00c6
            android.view.ViewGroup$MarginLayoutParams r1 = (android.view.ViewGroup.MarginLayoutParams) r1
            int r12 = r1.leftMargin
            r28 = r10
            int r10 = r1.rightMargin
            r17 = r10
            int r10 = r1.topMargin
            int r1 = r1.bottomMargin
            r18 = r4
            r22 = r15
            r15 = r12
            r12 = r17
            r17 = r22
            goto L_0x00d0
        L_0x00c6:
            r28 = r10
            r18 = r4
            r17 = r15
            r1 = 0
            r10 = 0
            r12 = 0
            r15 = 0
        L_0x00d0:
            int r4 = r14.getMeasuredWidth()
            int r19 = r14.getMeasuredHeight()
            int r20 = r3 + r10
            r21 = r6
            r6 = 80
            if (r11 != r6) goto L_0x00ea
            int r10 = r3 + r9
            int r10 = r10 - r1
            int r20 = r10 - r19
            r1 = r20
            r6 = 16
            goto L_0x00f9
        L_0x00ea:
            r6 = 16
            if (r11 != r6) goto L_0x00f7
            int r10 = r9 - r10
            int r10 = r10 - r1
            int r10 = r10 - r19
            int r10 = r10 / 2
            int r20 = r20 + r10
        L_0x00f7:
            r1 = r20
        L_0x00f9:
            int r10 = r1 + r19
            boolean r6 = r0.f38837q
            if (r6 == 0) goto L_0x0111
            int r6 = r5 - r12
            r19 = r11
            int r11 = r6 - r4
            r14.layout(r11, r1, r6, r10)
            float r1 = (float) r5
            float r4 = (float) r4
            float r4 = r4 + r8
            float r5 = (float) r15
            float r4 = r4 + r5
            float r5 = (float) r12
            float r4 = r4 + r5
            float r1 = r1 - r4
            goto L_0x0122
        L_0x0111:
            r19 = r11
            int r6 = r5 + r15
            int r11 = r6 + r4
            r14.layout(r6, r1, r11, r10)
            float r1 = (float) r5
            float r4 = (float) r4
            float r4 = r4 + r8
            float r5 = (float) r15
            float r4 = r4 + r5
            float r5 = (float) r12
            float r4 = r4 + r5
            float r1 = r1 + r4
        L_0x0122:
            int r1 = (int) r1
            r5 = r1
            r14 = r26
            r12 = r27
            r10 = r28
            r1 = r16
            r15 = r17
            r4 = r18
            r11 = r19
            r6 = r21
            goto L_0x0081
        L_0x0136:
            r18 = r4
            r21 = r6
            r19 = r11
            r27 = r12
            boolean r1 = r0.f38837q
            if (r1 == 0) goto L_0x0148
            int r1 = r23.getWidth()
            int r1 = r1 - r2
            goto L_0x014a
        L_0x0148:
            r1 = r16
        L_0x014a:
            int r13 = r13 + 1
            r5 = r18
            r4 = r21
            int r6 = r0.m29224a(r4, r7, r5, r13)
            int r1 = r1 + r6
            float r3 = (float) r3
            float r6 = (float) r9
            float r8 = r0.f38836p
            float r6 = r6 + r8
            float r3 = r3 + r6
            int r3 = (int) r3
            r12 = r27
            r6 = r4
            r4 = r5
            r11 = r19
            r8 = 80
            r9 = 16
            r10 = 0
            r5 = r1
            r1 = r16
            goto L_0x0054
        L_0x016c:
            int r1 = r23.getChildCount()
            if (r14 >= r1) goto L_0x0187
            android.view.View r1 = r0.getChildAt(r14)
            int r2 = r1.getVisibility()
            r3 = 8
            if (r2 != r3) goto L_0x0180
            r2 = 0
            goto L_0x0184
        L_0x0180:
            r2 = 0
            r1.layout(r2, r2, r2, r2)
        L_0x0184:
            int r14 = r14 + 1
            goto L_0x016c
        L_0x0187:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.global.base.FlowLayout.onLayout(boolean, int, int, int, int):void");
    }

    /* renamed from: a */
    private int m29224a(int i, int i2, int i3, int i4) {
        if (this.f38832l == -65536 || i4 >= this.f38844x.size() || i4 >= this.f38845y.size() || this.f38845y.get(i4).intValue() <= 0) {
            return 0;
        }
        if (i == 1) {
            return ((i2 - i3) - this.f38844x.get(i4).intValue()) / 2;
        }
        if (i != 5) {
            return 0;
        }
        return (i2 - i3) - this.f38844x.get(i4).intValue();
    }

    /* access modifiers changed from: protected */
    public ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return new ViewGroup.MarginLayoutParams(layoutParams);
    }

    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new ViewGroup.MarginLayoutParams(getContext(), attributeSet);
    }

    public boolean isFlow() {
        return this.f38831k;
    }

    public void setFlow(boolean z) {
        this.f38831k = z;
        requestLayout();
    }

    public int getChildSpacing() {
        return this.f38832l;
    }

    public void setChildSpacing(int i) {
        this.f38832l = i;
        requestLayout();
    }

    public int getChildSpacingForLastRow() {
        return this.f38834n;
    }

    public void setChildSpacingForLastRow(int i) {
        this.f38834n = i;
        requestLayout();
    }

    public float getRowSpacing() {
        return this.f38835o;
    }

    public void setRowSpacing(float f) {
        this.f38835o = f;
        requestLayout();
    }

    public int getMaxRows() {
        return this.f38838r;
    }

    public void setMaxRows(int i) {
        this.f38838r = i;
        requestLayout();
    }

    public void setGravity(int i) {
        if (this.f38839s != i) {
            this.f38839s = i;
            requestLayout();
        }
    }

    public void setRowVerticalGravity(int i) {
        if (this.f38840t != i) {
            this.f38840t = i;
            requestLayout();
        }
    }

    public boolean isRtl() {
        return this.f38837q;
    }

    public void setRtl(boolean z) {
        this.f38837q = z;
        requestLayout();
    }

    public int getMinChildSpacing() {
        return this.f38833m;
    }

    public void setMinChildSpacing(int i) {
        this.f38833m = i;
        requestLayout();
    }

    public int getRowsCount() {
        return this.f38845y.size();
    }

    /* renamed from: b */
    private float m29226b(int i, int i2, int i3, int i4) {
        if (i != -65536) {
            return (float) i;
        }
        if (i4 > 1) {
            return (float) ((i2 - i3) / (i4 - 1));
        }
        return 0.0f;
    }

    /* renamed from: a */
    private float m29223a(float f) {
        return TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
