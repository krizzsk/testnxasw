package com.didi.global.fintech.cashier.p118ui.widget;

import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Parcelable;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.passenger.C11267R;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

/* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView */
public class LabelsView extends ViewGroup implements View.OnClickListener, View.OnLongClickListener {

    /* renamed from: F */
    private static final String f23787F = "key_super_state";

    /* renamed from: G */
    private static final String f23788G = "key_text_color_state";

    /* renamed from: H */
    private static final String f23789H = "key_text_size_state";

    /* renamed from: I */
    private static final String f23790I = "key_bg_res_id_state";

    /* renamed from: J */
    private static final String f23791J = "key_padding_state";

    /* renamed from: K */
    private static final String f23792K = "key_word_margin_state";

    /* renamed from: L */
    private static final String f23793L = "key_line_margin_state";

    /* renamed from: M */
    private static final String f23794M = "key_select_type_state";

    /* renamed from: N */
    private static final String f23795N = "key_max_select_state";

    /* renamed from: O */
    private static final String f23796O = "key_min_select_state";

    /* renamed from: P */
    private static final String f23797P = "key_max_lines_state";

    /* renamed from: Q */
    private static final String f23798Q = "key_max_columns_state";

    /* renamed from: R */
    private static final String f23799R = "key_indicator_state";

    /* renamed from: S */
    private static final String f23800S = "key_labels_state";

    /* renamed from: T */
    private static final String f23801T = "key_select_labels_state";

    /* renamed from: U */
    private static final String f23802U = "key_select_compulsory_state";

    /* renamed from: V */
    private static final String f23803V = "key_label_width_state";

    /* renamed from: W */
    private static final String f23804W = "key_label_height_state";

    /* renamed from: X */
    private static final String f23805X = "key_label_gravity_state";

    /* renamed from: Y */
    private static final String f23806Y = "key_single_line_state";

    /* renamed from: Z */
    private static final String f23807Z = "key_text_style_state";

    /* renamed from: v */
    private static final int f23808v = 2131434514;

    /* renamed from: w */
    private static final int f23809w = 2131434515;

    /* renamed from: A */
    private int f23810A;

    /* renamed from: B */
    private OnLabelClickListener f23811B;

    /* renamed from: C */
    private OnLabelLongClickListener f23812C;

    /* renamed from: D */
    private OnLabelSelectChangeListener f23813D;

    /* renamed from: E */
    private OnSelectChangeIntercept f23814E;

    /* renamed from: a */
    private Context f23815a;

    /* renamed from: b */
    private ColorStateList f23816b;

    /* renamed from: c */
    private float f23817c;

    /* renamed from: d */
    private Drawable f23818d;

    /* renamed from: e */
    private int f23819e = -2;

    /* renamed from: f */
    private int f23820f = -2;

    /* renamed from: g */
    private int f23821g = 17;

    /* renamed from: h */
    private int f23822h;

    /* renamed from: i */
    private int f23823i;

    /* renamed from: j */
    private int f23824j;

    /* renamed from: k */
    private int f23825k;

    /* renamed from: l */
    private int f23826l;

    /* renamed from: m */
    private int f23827m;

    /* renamed from: n */
    private SelectType f23828n;

    /* renamed from: o */
    private int f23829o;

    /* renamed from: p */
    private int f23830p;

    /* renamed from: q */
    private int f23831q;

    /* renamed from: r */
    private int f23832r;

    /* renamed from: s */
    private boolean f23833s = false;

    /* renamed from: t */
    private boolean f23834t = false;

    /* renamed from: u */
    private boolean f23835u;

    /* renamed from: x */
    private ArrayList<Object> f23836x = new ArrayList<>();

    /* renamed from: y */
    private ArrayList<Integer> f23837y = new ArrayList<>();

    /* renamed from: z */
    private ArrayList<Integer> f23838z = new ArrayList<>();

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$LabelTextProvider */
    public interface LabelTextProvider<T> {
        CharSequence getLabelText(TextView textView, int i, T t);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$OnLabelClickListener */
    public interface OnLabelClickListener {
        void onLabelClick(TextView textView, Object obj, int i);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$OnLabelLongClickListener */
    public interface OnLabelLongClickListener {
        boolean onLabelLongClick(TextView textView, Object obj, int i);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$OnLabelSelectChangeListener */
    public interface OnLabelSelectChangeListener {
        void onLabelSelectChange(TextView textView, Object obj, boolean z, int i);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$OnSelectChangeIntercept */
    public interface OnSelectChangeIntercept {
        boolean onIntercept(TextView textView, Object obj, boolean z, boolean z2, int i);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$Selectable */
    public interface Selectable {
        boolean isSelected();

        void onSelected(boolean z);
    }

    /* renamed from: com.didi.global.fintech.cashier.ui.widget.LabelsView$SelectType */
    public enum SelectType {
        NONE(1),
        SINGLE(2),
        SINGLE_IRREVOCABLY(3),
        MULTI(4);
        
        int value;

        private SelectType(int i) {
            this.value = i;
        }

        static SelectType get(int i) {
            if (i == 1) {
                return NONE;
            }
            if (i == 2) {
                return SINGLE;
            }
            if (i == 3) {
                return SINGLE_IRREVOCABLY;
            }
            if (i != 4) {
                return NONE;
            }
            return MULTI;
        }
    }

    public LabelsView(Context context) {
        super(context);
        this.f23815a = context;
        m19270a();
    }

    public LabelsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f23815a = context;
        m19272a(context, attributeSet);
        m19270a();
    }

    public LabelsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f23815a = context;
        m19272a(context, attributeSet);
        m19270a();
    }

    /* renamed from: a */
    private void m19272a(Context context, AttributeSet attributeSet) {
        if (attributeSet != null) {
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.LabelsView);
            this.f23828n = SelectType.get(obtainStyledAttributes.getInt(18, 1));
            this.f23829o = obtainStyledAttributes.getInteger(16, 0);
            this.f23830p = obtainStyledAttributes.getInteger(17, 0);
            this.f23831q = obtainStyledAttributes.getInteger(15, 0);
            this.f23832r = obtainStyledAttributes.getInteger(14, 0);
            this.f23835u = obtainStyledAttributes.getBoolean(0, false);
            this.f23821g = obtainStyledAttributes.getInt(3, this.f23821g);
            this.f23819e = obtainStyledAttributes.getLayoutDimension(12, this.f23819e);
            this.f23820f = obtainStyledAttributes.getLayoutDimension(5, this.f23820f);
            if (obtainStyledAttributes.hasValue(4)) {
                this.f23816b = obtainStyledAttributes.getColorStateList(4);
            } else {
                this.f23816b = ColorStateList.valueOf(-16777216);
            }
            this.f23817c = obtainStyledAttributes.getDimension(11, (float) m19269a(14.0f));
            if (obtainStyledAttributes.hasValue(6)) {
                int dimensionPixelOffset = obtainStyledAttributes.getDimensionPixelOffset(6, 0);
                this.f23825k = dimensionPixelOffset;
                this.f23824j = dimensionPixelOffset;
                this.f23823i = dimensionPixelOffset;
                this.f23822h = dimensionPixelOffset;
            } else {
                this.f23822h = obtainStyledAttributes.getDimensionPixelOffset(8, m19276b(10.0f));
                this.f23823i = obtainStyledAttributes.getDimensionPixelOffset(10, m19276b(5.0f));
                this.f23824j = obtainStyledAttributes.getDimensionPixelOffset(9, m19276b(10.0f));
                this.f23825k = obtainStyledAttributes.getDimensionPixelOffset(7, m19276b(5.0f));
            }
            this.f23827m = obtainStyledAttributes.getDimensionPixelOffset(13, m19276b(5.0f));
            this.f23826l = obtainStyledAttributes.getDimensionPixelOffset(20, m19276b(5.0f));
            if (obtainStyledAttributes.hasValue(2)) {
                int resourceId = obtainStyledAttributes.getResourceId(2, 0);
                if (resourceId != 0) {
                    this.f23818d = ContextCompat.getDrawable(this.f23815a, resourceId);
                } else {
                    this.f23818d = new ColorDrawable(obtainStyledAttributes.getColor(2, 0));
                }
            } else {
                this.f23818d = ContextCompat.getDrawable(this.f23815a, R.drawable.shape_label_bg);
            }
            this.f23833s = obtainStyledAttributes.getBoolean(19, false);
            this.f23834t = obtainStyledAttributes.getBoolean(1, false);
            obtainStyledAttributes.recycle();
        }
    }

    /* renamed from: a */
    private void m19270a() {
        if (isInEditMode()) {
            ArrayList arrayList = new ArrayList();
            arrayList.add("Label 1");
            arrayList.add("Label 2");
            arrayList.add("Label 3");
            arrayList.add("Label 4");
            arrayList.add("Label 5");
            arrayList.add("Label 6");
            arrayList.add("Label 7");
            setLabels(arrayList);
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        if (this.f23833s) {
            m19271a(i, i2);
        } else {
            m19278b(i, i2);
        }
    }

    /* renamed from: a */
    private void m19271a(int i, int i2) {
        int childCount = getChildCount();
        int i3 = 0;
        int i4 = 0;
        int i5 = 0;
        for (int i6 = 0; i6 < childCount; i6++) {
            int i7 = this.f23832r;
            if (i7 > 0 && i6 == i7) {
                break;
            }
            View childAt = getChildAt(i6);
            measureChild(childAt, i, i2);
            i4 += childAt.getMeasuredWidth();
            if (i6 != childCount - 1) {
                i4 += this.f23826l;
            }
            i5 = Math.max(i5, childAt.getMeasuredHeight());
        }
        setMeasuredDimension(m19279c(i, i4 + getPaddingLeft() + getPaddingRight()), m19279c(i2, i5 + getPaddingTop() + getPaddingBottom()));
        if (childCount > 0) {
            i3 = 1;
        }
        this.f23810A = i3;
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0039, code lost:
        r10 = r10 - 1;
     */
    /* renamed from: b */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m19278b(int r14, int r15) {
        /*
            r13 = this;
            int r0 = r13.getChildCount()
            int r1 = android.view.View.MeasureSpec.getSize(r14)
            int r2 = r13.getPaddingLeft()
            int r1 = r1 - r2
            int r2 = r13.getPaddingRight()
            int r1 = r1 - r2
            r2 = 1
            r3 = 0
            r4 = 0
            r5 = 0
            r6 = 0
            r7 = 0
            r8 = 0
            r9 = 0
            r10 = 1
        L_0x001b:
            if (r4 >= r0) goto L_0x0079
            android.view.View r11 = r13.getChildAt(r4)
            r13.measureChild(r11, r14, r15)
            int r12 = r11.getMeasuredWidth()
            int r12 = r12 + r5
            if (r12 > r1) goto L_0x0031
            int r12 = r13.f23832r
            if (r12 <= 0) goto L_0x0047
            if (r6 != r12) goto L_0x0047
        L_0x0031:
            int r10 = r10 + 1
            int r6 = r13.f23831q
            if (r6 <= 0) goto L_0x003c
            if (r10 <= r6) goto L_0x003c
        L_0x0039:
            int r10 = r10 + -1
            goto L_0x0079
        L_0x003c:
            int r6 = r13.f23827m
            int r8 = r8 + r6
            int r8 = r8 + r7
            int r9 = java.lang.Math.max(r9, r5)
            r5 = 0
            r6 = 0
            r7 = 0
        L_0x0047:
            int r12 = r11.getMeasuredWidth()
            int r5 = r5 + r12
            int r6 = r6 + r2
            int r11 = r11.getMeasuredHeight()
            int r7 = java.lang.Math.max(r7, r11)
            int r11 = r0 + -1
            if (r4 == r11) goto L_0x0076
            int r11 = r13.f23826l
            int r12 = r5 + r11
            if (r12 <= r1) goto L_0x0075
            int r10 = r10 + 1
            int r6 = r13.f23831q
            if (r6 <= 0) goto L_0x0068
            if (r10 <= r6) goto L_0x0068
            goto L_0x0039
        L_0x0068:
            int r6 = r13.f23827m
            int r8 = r8 + r6
            int r8 = r8 + r7
            int r5 = java.lang.Math.max(r9, r5)
            r9 = r5
            r5 = 0
            r6 = 0
            r7 = 0
            goto L_0x0076
        L_0x0075:
            int r5 = r5 + r11
        L_0x0076:
            int r4 = r4 + 1
            goto L_0x001b
        L_0x0079:
            int r8 = r8 + r7
            int r1 = java.lang.Math.max(r9, r5)
            int r2 = r13.getPaddingLeft()
            int r1 = r1 + r2
            int r2 = r13.getPaddingRight()
            int r1 = r1 + r2
            int r14 = r13.m19279c(r14, r1)
            int r1 = r13.getPaddingTop()
            int r8 = r8 + r1
            int r1 = r13.getPaddingBottom()
            int r8 = r8 + r1
            int r15 = r13.m19279c(r15, r8)
            r13.setMeasuredDimension(r14, r15)
            if (r0 <= 0) goto L_0x00a0
            r3 = r10
        L_0x00a0:
            r13.f23810A = r3
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.global.fintech.cashier.p118ui.widget.LabelsView.m19278b(int, int):void");
    }

    /* renamed from: c */
    private int m19279c(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i);
        int size = View.MeasureSpec.getSize(i);
        if (mode == 1073741824) {
            i2 = size;
        } else if (mode == Integer.MIN_VALUE) {
            i2 = Math.min(i2, size);
        }
        return resolveSizeAndState(Math.max(i2, getSuggestedMinimumWidth()), i, 0);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int paddingLeft = getPaddingLeft();
        int paddingTop = getPaddingTop();
        int i7 = i3 - i;
        int childCount = getChildCount();
        int i8 = 1;
        int i9 = 0;
        int i10 = 0;
        int i11 = 0;
        while (i9 < childCount) {
            View childAt = getChildAt(i9);
            if (!this.f23833s && (i7 < childAt.getMeasuredWidth() + paddingLeft + getPaddingRight() || ((i6 = this.f23832r) > 0 && i10 == i6))) {
                i8++;
                int i12 = this.f23831q;
                if (i12 <= 0 || i8 <= i12) {
                    paddingLeft = getPaddingLeft();
                    paddingTop = paddingTop + this.f23827m + i11;
                    i10 = 0;
                    i11 = 0;
                } else {
                    return;
                }
            }
            if (!this.f23833s || (i5 = this.f23832r) <= 0 || i10 != i5) {
                childAt.layout(paddingLeft, paddingTop, childAt.getMeasuredWidth() + paddingLeft, childAt.getMeasuredHeight() + paddingTop);
                paddingLeft = paddingLeft + childAt.getMeasuredWidth() + this.f23826l;
                i11 = Math.max(i11, childAt.getMeasuredHeight());
                i10++;
                i9++;
            } else {
                return;
            }
        }
    }

    /* access modifiers changed from: protected */
    public Parcelable onSaveInstanceState() {
        Bundle bundle = new Bundle();
        bundle.putParcelable(f23787F, super.onSaveInstanceState());
        ColorStateList colorStateList = this.f23816b;
        if (colorStateList != null) {
            bundle.putParcelable(f23788G, colorStateList);
        }
        bundle.putFloat(f23789H, this.f23817c);
        bundle.putInt(f23803V, this.f23819e);
        bundle.putInt(f23804W, this.f23820f);
        bundle.putInt(f23805X, this.f23821g);
        bundle.putIntArray(f23791J, new int[]{this.f23822h, this.f23823i, this.f23824j, this.f23825k});
        bundle.putInt(f23792K, this.f23826l);
        bundle.putInt(f23793L, this.f23827m);
        bundle.putInt(f23794M, this.f23828n.value);
        bundle.putInt(f23795N, this.f23829o);
        bundle.putInt(f23796O, this.f23830p);
        bundle.putInt(f23797P, this.f23831q);
        bundle.putInt(f23798Q, this.f23832r);
        bundle.putBoolean(f23799R, this.f23835u);
        if (!this.f23837y.isEmpty()) {
            bundle.putIntegerArrayList(f23801T, this.f23837y);
        }
        if (!this.f23838z.isEmpty()) {
            bundle.putIntegerArrayList(f23802U, this.f23838z);
        }
        bundle.putBoolean(f23806Y, this.f23833s);
        bundle.putBoolean(f23807Z, this.f23834t);
        return bundle;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (parcelable instanceof Bundle) {
            Bundle bundle = (Bundle) parcelable;
            super.onRestoreInstanceState(bundle.getParcelable(f23787F));
            ColorStateList colorStateList = (ColorStateList) bundle.getParcelable(f23788G);
            if (colorStateList != null) {
                setLabelTextColor(colorStateList);
            }
            setLabelTextSize(bundle.getFloat(f23789H, this.f23817c));
            this.f23819e = bundle.getInt(f23803V, this.f23819e);
            this.f23820f = bundle.getInt(f23804W, this.f23820f);
            setLabelGravity(bundle.getInt(f23805X, this.f23821g));
            int[] intArray = bundle.getIntArray(f23791J);
            if (intArray != null && intArray.length == 4) {
                setLabelTextPadding(intArray[0], intArray[1], intArray[2], intArray[3]);
            }
            setWordMargin(bundle.getInt(f23792K, this.f23826l));
            setLineMargin(bundle.getInt(f23793L, this.f23827m));
            setSelectType(SelectType.get(bundle.getInt(f23794M, this.f23828n.value)));
            setMaxSelect(bundle.getInt(f23795N, this.f23829o));
            setMinSelect(bundle.getInt(f23796O, this.f23830p));
            setMaxLines(bundle.getInt(f23797P, this.f23831q));
            setMaxLines(bundle.getInt(f23798Q, this.f23832r));
            setIndicator(bundle.getBoolean(f23799R, this.f23835u));
            setSingleLine(bundle.getBoolean(f23806Y, this.f23833s));
            setTextBold(bundle.getBoolean(f23807Z, this.f23834t));
            ArrayList<Integer> integerArrayList = bundle.getIntegerArrayList(f23802U);
            if (integerArrayList != null && !integerArrayList.isEmpty()) {
                setCompulsorys((List<Integer>) integerArrayList);
            }
            ArrayList<Integer> integerArrayList2 = bundle.getIntegerArrayList(f23801T);
            if (integerArrayList2 != null && !integerArrayList2.isEmpty()) {
                int size = integerArrayList2.size();
                int[] iArr = new int[size];
                for (int i = 0; i < size; i++) {
                    iArr[i] = integerArrayList2.get(i).intValue();
                }
                setSelects(iArr);
                return;
            }
            return;
        }
        super.onRestoreInstanceState(parcelable);
    }

    public void setLabels(List<String> list) {
        setLabels(list, new LabelTextProvider<String>() {
            public CharSequence getLabelText(TextView textView, int i, String str) {
                return str.trim();
            }
        });
    }

    public <T> void setLabels(List<T> list, LabelTextProvider<T> labelTextProvider) {
        m19280c();
        removeAllViews();
        this.f23836x.clear();
        if (list != null) {
            this.f23836x.addAll(list);
            int size = list.size();
            for (int i = 0; i < size; i++) {
                m19274a(list.get(i), i, labelTextProvider);
            }
            m19277b();
        }
        if (this.f23828n == SelectType.SINGLE_IRREVOCABLY) {
            setSelects(0);
        }
    }

    public <T> List<T> getLabels() {
        return this.f23836x;
    }

    /* renamed from: a */
    private <T> void m19274a(T t, int i, LabelTextProvider<T> labelTextProvider) {
        TextView textView = new TextView(this.f23815a);
        textView.setPadding(this.f23822h, this.f23823i, this.f23824j, this.f23825k);
        textView.setTextSize(0, this.f23817c);
        textView.setGravity(this.f23821g);
        textView.setTextColor(this.f23816b);
        textView.setBackgroundDrawable(this.f23818d.getConstantState().newDrawable());
        textView.setTag(f23808v, t);
        textView.setTag(f23809w, Integer.valueOf(i));
        textView.setOnClickListener(this);
        textView.setOnLongClickListener(this);
        textView.getPaint().setFakeBoldText(this.f23834t);
        addView(textView, this.f23819e, this.f23820f);
        textView.setText(labelTextProvider.getLabelText(textView, i, t));
    }

    /* renamed from: b */
    private void m19277b() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((TextView) getChildAt(i)).setClickable((this.f23811B == null && this.f23812C == null && this.f23828n == SelectType.NONE) ? false : true);
        }
    }

    public void onClick(View view) {
        int i;
        AutoTrackHelper.trackViewOnClick(view);
        if (view instanceof TextView) {
            TextView textView = (TextView) view;
            if (!this.f23835u && this.f23828n != SelectType.NONE) {
                boolean z = true;
                if (textView.isSelected()) {
                    if (!((this.f23828n == SelectType.MULTI && this.f23838z.contains((Integer) textView.getTag(f23809w))) || (this.f23828n == SelectType.MULTI && this.f23837y.size() <= this.f23830p)) && this.f23828n != SelectType.SINGLE_IRREVOCABLY) {
                        z = false;
                    }
                    if (!z && !m19275a(textView)) {
                        m19273a(textView, false);
                    }
                } else if (this.f23828n == SelectType.SINGLE || this.f23828n == SelectType.SINGLE_IRREVOCABLY) {
                    if (!m19275a(textView)) {
                        m19280c();
                        m19273a(textView, true);
                    }
                } else if (this.f23828n == SelectType.MULTI && (((i = this.f23829o) <= 0 || i > this.f23837y.size()) && !m19275a(textView))) {
                    m19273a(textView, true);
                }
            }
            OnLabelClickListener onLabelClickListener = this.f23811B;
            if (onLabelClickListener != null) {
                onLabelClickListener.onLabelClick(textView, textView.getTag(f23808v), ((Integer) textView.getTag(f23809w)).intValue());
            }
        }
    }

    public boolean onLongClick(View view) {
        if (!(view instanceof TextView)) {
            return false;
        }
        TextView textView = (TextView) view;
        OnLabelLongClickListener onLabelLongClickListener = this.f23812C;
        if (onLabelLongClickListener != null) {
            return onLabelLongClickListener.onLabelLongClick(textView, textView.getTag(f23808v), ((Integer) textView.getTag(f23809w)).intValue());
        }
        return false;
    }

    /* renamed from: a */
    private void m19273a(TextView textView, boolean z) {
        if (textView.isSelected() != z) {
            textView.setSelected(z);
            if (z) {
                this.f23837y.add((Integer) textView.getTag(f23809w));
            } else {
                this.f23837y.remove((Integer) textView.getTag(f23809w));
            }
            OnLabelSelectChangeListener onLabelSelectChangeListener = this.f23813D;
            if (onLabelSelectChangeListener != null) {
                onLabelSelectChangeListener.onLabelSelectChange(textView, textView.getTag(f23808v), z, ((Integer) textView.getTag(f23809w)).intValue());
            }
        }
    }

    /* renamed from: a */
    private boolean m19275a(TextView textView) {
        OnSelectChangeIntercept onSelectChangeIntercept = this.f23814E;
        if (onSelectChangeIntercept != null) {
            if (onSelectChangeIntercept.onIntercept(textView, textView.getTag(f23808v), textView.isSelected(), !textView.isSelected(), ((Integer) textView.getTag(f23809w)).intValue())) {
                return true;
            }
        }
        return false;
    }

    public void clearAllSelect() {
        if (this.f23828n == SelectType.SINGLE_IRREVOCABLY) {
            return;
        }
        if (this.f23828n != SelectType.MULTI || this.f23838z.isEmpty()) {
            m19280c();
        } else {
            m19281d();
        }
    }

    /* renamed from: c */
    private void m19280c() {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            m19273a((TextView) getChildAt(i), false);
        }
        this.f23837y.clear();
    }

    /* renamed from: d */
    private void m19281d() {
        int childCount = getChildCount();
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < childCount; i++) {
            if (!this.f23838z.contains(Integer.valueOf(i))) {
                m19273a((TextView) getChildAt(i), false);
                arrayList.add(Integer.valueOf(i));
            }
        }
        this.f23837y.removeAll(arrayList);
    }

    public void setSelects(List<Integer> list) {
        if (list != null) {
            int size = list.size();
            int[] iArr = new int[size];
            for (int i = 0; i < size; i++) {
                iArr[i] = list.get(i).intValue();
            }
            setSelects(iArr);
        }
    }

    public void setSelects(int... iArr) {
        if (this.f23828n != SelectType.NONE) {
            ArrayList arrayList = new ArrayList();
            int childCount = getChildCount();
            int i = (this.f23828n == SelectType.SINGLE || this.f23828n == SelectType.SINGLE_IRREVOCABLY) ? 1 : this.f23829o;
            for (int i2 : iArr) {
                if (i2 < childCount) {
                    TextView textView = (TextView) getChildAt(i2);
                    if (!arrayList.contains(textView)) {
                        m19273a(textView, true);
                        arrayList.add(textView);
                    }
                    if (i > 0 && arrayList.size() == i) {
                        break;
                    }
                }
            }
            for (int i3 = 0; i3 < childCount; i3++) {
                TextView textView2 = (TextView) getChildAt(i3);
                if (!arrayList.contains(textView2)) {
                    m19273a(textView2, false);
                }
            }
        }
    }

    public void setCompulsorys(List<Integer> list) {
        if (this.f23828n == SelectType.MULTI && list != null) {
            this.f23838z.clear();
            this.f23838z.addAll(list);
            m19280c();
            setSelects(list);
        }
    }

    public void setCompulsorys(int... iArr) {
        if (this.f23828n == SelectType.MULTI && iArr != null) {
            ArrayList arrayList = new ArrayList(iArr.length);
            for (int valueOf : iArr) {
                arrayList.add(Integer.valueOf(valueOf));
            }
            setCompulsorys((List<Integer>) arrayList);
        }
    }

    public List<Integer> getCompulsorys() {
        return this.f23838z;
    }

    public void clearCompulsorys() {
        if (this.f23828n == SelectType.MULTI && !this.f23838z.isEmpty()) {
            this.f23838z.clear();
            m19280c();
        }
    }

    public List<Integer> getSelectLabels() {
        ArrayList arrayList = new ArrayList();
        arrayList.addAll(this.f23837y);
        return arrayList;
    }

    public <T> List<T> getSelectLabelDatas() {
        ArrayList arrayList = new ArrayList();
        int size = this.f23837y.size();
        for (int i = 0; i < size; i++) {
            Object tag = getChildAt(this.f23837y.get(i).intValue()).getTag(f23808v);
            if (tag != null) {
                arrayList.add(tag);
            }
        }
        return arrayList;
    }

    public void setLabelBackgroundResource(int i) {
        setLabelBackgroundDrawable(ContextCompat.getDrawable(this.f23815a, i));
    }

    public void setLabelBackgroundColor(int i) {
        setLabelBackgroundDrawable(new ColorDrawable(i));
    }

    public void setLabelBackgroundDrawable(Drawable drawable) {
        this.f23818d = drawable;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((TextView) getChildAt(i)).setBackground(this.f23818d.getConstantState().newDrawable());
        }
    }

    public void setLabelTextPadding(int i, int i2, int i3, int i4) {
        if (this.f23822h != i || this.f23823i != i2 || this.f23824j != i3 || this.f23825k != i4) {
            this.f23822h = i;
            this.f23823i = i2;
            this.f23824j = i3;
            this.f23825k = i4;
            int childCount = getChildCount();
            for (int i5 = 0; i5 < childCount; i5++) {
                ((TextView) getChildAt(i5)).setPadding(i, i2, i3, i4);
            }
        }
    }

    public int getTextPaddingLeft() {
        return this.f23822h;
    }

    public int getTextPaddingTop() {
        return this.f23823i;
    }

    public int getTextPaddingRight() {
        return this.f23824j;
    }

    public int getTextPaddingBottom() {
        return this.f23825k;
    }

    public void setLabelTextSize(float f) {
        if (this.f23817c != f) {
            this.f23817c = f;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                ((TextView) getChildAt(i)).setTextSize(0, f);
            }
        }
    }

    public float getLabelTextSize() {
        return this.f23817c;
    }

    public void setLabelTextColor(int i) {
        setLabelTextColor(ColorStateList.valueOf(i));
    }

    public void setLabelTextColor(ColorStateList colorStateList) {
        this.f23816b = colorStateList;
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            ((TextView) getChildAt(i)).setTextColor(this.f23816b);
        }
    }

    public ColorStateList getLabelTextColor() {
        return this.f23816b;
    }

    public void setLabelGravity(int i) {
        if (this.f23821g != i) {
            this.f23821g = i;
            int childCount = getChildCount();
            for (int i2 = 0; i2 < childCount; i2++) {
                ((TextView) getChildAt(i2)).setGravity(i);
            }
        }
    }

    public int getLabelGravity() {
        return this.f23821g;
    }

    public void setTextBold(boolean z) {
        if (this.f23834t != z) {
            this.f23834t = z;
            int childCount = getChildCount();
            for (int i = 0; i < childCount; i++) {
                TextView textView = (TextView) getChildAt(i);
                textView.getPaint().setFakeBoldText(this.f23834t);
                textView.invalidate();
            }
        }
    }

    public boolean isTextBold() {
        return this.f23834t;
    }

    public void setLineMargin(int i) {
        if (this.f23827m != i) {
            this.f23827m = i;
            requestLayout();
        }
    }

    public int getLineMargin() {
        return this.f23827m;
    }

    public void setWordMargin(int i) {
        if (this.f23826l != i) {
            this.f23826l = i;
            requestLayout();
        }
    }

    public int getWordMargin() {
        return this.f23826l;
    }

    public void setSelectType(SelectType selectType) {
        if (this.f23828n != selectType) {
            this.f23828n = selectType;
            m19280c();
            if (this.f23828n == SelectType.SINGLE_IRREVOCABLY) {
                setSelects(0);
            }
            if (this.f23828n != SelectType.MULTI) {
                this.f23838z.clear();
            }
            m19277b();
        }
    }

    public SelectType getSelectType() {
        return this.f23828n;
    }

    public void setMaxSelect(int i) {
        if (this.f23829o != i) {
            this.f23829o = i;
            if (this.f23828n == SelectType.MULTI) {
                m19280c();
            }
        }
    }

    public int getMaxSelect() {
        return this.f23829o;
    }

    public void setMinSelect(int i) {
        this.f23830p = i;
    }

    public int getMinSelect() {
        return this.f23830p;
    }

    public void setMaxLines(int i) {
        if (this.f23831q != i) {
            this.f23831q = i;
            requestLayout();
        }
    }

    public int getMaxLines() {
        return this.f23831q;
    }

    public void setMaxColumns(int i) {
        if (this.f23832r != i) {
            this.f23832r = i;
            requestLayout();
        }
    }

    public int getMaxColumns() {
        return this.f23832r;
    }

    public void setIndicator(boolean z) {
        this.f23835u = z;
    }

    public boolean isIndicator() {
        return this.f23835u;
    }

    public void setSingleLine(boolean z) {
        if (this.f23833s != z) {
            this.f23833s = z;
            requestLayout();
        }
    }

    public boolean isSingleLine() {
        return this.f23833s;
    }

    public int getLines() {
        return this.f23810A;
    }

    public void setOnLabelClickListener(OnLabelClickListener onLabelClickListener) {
        this.f23811B = onLabelClickListener;
        m19277b();
    }

    public void setOnLabelLongClickListener(OnLabelLongClickListener onLabelLongClickListener) {
        this.f23812C = onLabelLongClickListener;
        m19277b();
    }

    public void setOnLabelSelectChangeListener(OnLabelSelectChangeListener onLabelSelectChangeListener) {
        this.f23813D = onLabelSelectChangeListener;
    }

    public void setOnSelectChangeIntercept(OnSelectChangeIntercept onSelectChangeIntercept) {
        this.f23814E = onSelectChangeIntercept;
    }

    /* renamed from: a */
    private int m19269a(float f) {
        return (int) TypedValue.applyDimension(2, f, getResources().getDisplayMetrics());
    }

    /* renamed from: b */
    private int m19276b(float f) {
        return (int) TypedValue.applyDimension(1, f, getResources().getDisplayMetrics());
    }
}
