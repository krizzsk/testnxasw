package com.didi.rfusion.widget.textfield;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.ColorStateList;
import android.content.res.TypedArray;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.appcompat.content.res.AppCompatResources;
import androidx.core.graphics.drawable.DrawableCompat;
import androidx.core.text.BidiFormatter;
import androidx.core.view.AccessibilityDelegateCompat;
import androidx.core.view.GravityCompat;
import androidx.core.view.MarginLayoutParamsCompat;
import androidx.core.view.ViewCompat;
import androidx.core.view.accessibility.AccessibilityNodeInfoCompat;
import androidx.core.widget.TextViewCompat;
import androidx.customview.view.AbsSavedState;
import com.didi.app.nova.support.util.ViewUtils;
import com.didi.passenger.C11267R;
import com.didi.rfusion.material.animation.RFAnimationUtils;
import com.didi.rfusion.material.internal.RFCheckableIconButton;
import com.didi.rfusion.material.internal.RFCheckableImageButton;
import com.didi.rfusion.material.internal.RFCollapsingTextHelper;
import com.didi.rfusion.material.internal.RFDescendantOffsetUtils;
import com.didi.rfusion.utils.RFFontUtils;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFTextView;
import com.didi.rfusion.widget.textfield.drawable.RFCutoutDrawable;
import com.didi.rfusion.widget.textfield.drawable.RFUnderlineDrawable;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.taxis99.R;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.Arrays;
import java.util.Iterator;
import java.util.LinkedHashSet;

public class RFTextInputLayout extends LinearLayout {
    public static final int BOX_BACKGROUND_OUTLINE = 2;
    public static final int BOX_BACKGROUND_UNDERLINE = 1;
    public static final int COUNTER_INNER = 0;
    public static final int COUNTER_OUTER = 1;
    public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
        public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
            return new SavedState(parcel, classLoader);
        }

        public SavedState createFromParcel(Parcel parcel) {
            return new SavedState(parcel, (ClassLoader) null);
        }

        public SavedState[] newArray(int i) {
            return new SavedState[i];
        }
    };
    public static final int END_ICON_NONE = 0;
    public static final int END_ICON_PASSWORD_TOGGLE = 1;

    /* renamed from: c */
    private static final String f36546c = "RFTextField";

    /* renamed from: d */
    private static final int f36547d = -1;

    /* renamed from: e */
    private static final float f36548e = 0.75f;

    /* renamed from: f */
    private static final int f36549f = 167;

    /* renamed from: g */
    private static final int f36550g = -1;

    /* renamed from: h */
    private static final int f36551h = 0;

    /* renamed from: A */
    private final SparseArray<C12402b> f36552A;

    /* renamed from: B */
    private final LinkedHashSet<OnEndIconChangedListener> f36553B;

    /* renamed from: C */
    private ValueAnimator f36554C;

    /* renamed from: D */
    private final Rect f36555D;

    /* renamed from: E */
    private final Rect f36556E;

    /* renamed from: F */
    private final RectF f36557F;

    /* renamed from: G */
    private boolean f36558G;

    /* renamed from: H */
    private boolean f36559H;

    /* renamed from: I */
    private boolean f36560I;

    /* renamed from: J */
    private boolean f36561J;

    /* renamed from: K */
    private boolean f36562K;

    /* renamed from: L */
    private boolean f36563L;
    /* access modifiers changed from: private */

    /* renamed from: M */
    public boolean f36564M;

    /* renamed from: N */
    private boolean f36565N;

    /* renamed from: O */
    private Drawable f36566O;

    /* renamed from: P */
    private int f36567P;

    /* renamed from: Q */
    private Drawable f36568Q;

    /* renamed from: R */
    private Drawable f36569R;

    /* renamed from: S */
    private int f36570S;
    /* access modifiers changed from: private */

    /* renamed from: T */
    public boolean f36571T;

    /* renamed from: U */
    private int f36572U;

    /* renamed from: V */
    private int f36573V;

    /* renamed from: W */
    private int f36574W;

    /* renamed from: X */
    private int f36575X;

    /* renamed from: Y */
    private int f36576Y;

    /* renamed from: Z */
    private int f36577Z;

    /* renamed from: a */
    EditText f36578a;

    /* renamed from: aA */
    private CharSequence f36579aA;
    /* access modifiers changed from: private */

    /* renamed from: aB */
    public boolean f36580aB;
    /* access modifiers changed from: private */

    /* renamed from: aC */
    public boolean f36581aC;

    /* renamed from: aD */
    private int f36582aD;

    /* renamed from: aE */
    private boolean f36583aE;

    /* renamed from: aF */
    private boolean f36584aF;

    /* renamed from: aG */
    private CharSequence f36585aG;

    /* renamed from: aH */
    private CharSequence f36586aH;

    /* renamed from: aI */
    private CharSequence f36587aI;

    /* renamed from: aJ */
    private CharSequence f36588aJ;

    /* renamed from: aK */
    private int f36589aK;

    /* renamed from: aL */
    private View.OnLongClickListener f36590aL;

    /* renamed from: aM */
    private Drawable f36591aM;

    /* renamed from: aN */
    private boolean f36592aN;

    /* renamed from: aa */
    private int f36593aa;

    /* renamed from: ab */
    private int f36594ab;

    /* renamed from: ac */
    private int f36595ac;

    /* renamed from: ad */
    private int f36596ad;

    /* renamed from: ae */
    private int f36597ae;

    /* renamed from: af */
    private int f36598af;

    /* renamed from: ag */
    private int f36599ag;

    /* renamed from: ah */
    private int f36600ah;
    /* access modifiers changed from: private */

    /* renamed from: ai */
    public GradientDrawable f36601ai;

    /* renamed from: aj */
    private ValueAnimator f36602aj;

    /* renamed from: ak */
    private ColorStateList f36603ak;

    /* renamed from: al */
    private ColorStateList f36604al;

    /* renamed from: am */
    private ColorStateList f36605am;

    /* renamed from: an */
    private int f36606an;

    /* renamed from: ao */
    private int f36607ao;

    /* renamed from: ap */
    private ColorStateList f36608ap;

    /* renamed from: aq */
    private int f36609aq;

    /* renamed from: ar */
    private int f36610ar;

    /* renamed from: as */
    private int f36611as;
    /* access modifiers changed from: private */

    /* renamed from: at */
    public int f36612at;

    /* renamed from: au */
    private ColorStateList f36613au;
    /* access modifiers changed from: private */

    /* renamed from: av */
    public int f36614av;

    /* renamed from: aw */
    private int f36615aw;

    /* renamed from: ax */
    private ColorStateList f36616ax;

    /* renamed from: ay */
    private ColorStateList f36617ay;

    /* renamed from: az */
    private ColorStateList f36618az;

    /* renamed from: b */
    final RFCollapsingTextHelper f36619b;

    /* renamed from: i */
    private LinearLayout f36620i;

    /* renamed from: j */
    private FrameLayout f36621j;

    /* renamed from: k */
    private LinearLayout f36622k;

    /* renamed from: l */
    private FrameLayout f36623l;

    /* renamed from: m */
    private LinearLayout f36624m;

    /* renamed from: n */
    private FrameLayout f36625n;

    /* renamed from: o */
    private LinearLayout f36626o;

    /* renamed from: p */
    private RFCheckableImageButton f36627p;

    /* renamed from: q */
    private RFCheckableIconButton f36628q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public RFCheckableIconButton f36629r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public RFCheckableImageButton f36630s;

    /* renamed from: t */
    private RFTextView f36631t;

    /* renamed from: u */
    private RFTextView f36632u;

    /* renamed from: v */
    private RFTextView f36633v;

    /* renamed from: w */
    private RFTextView f36634w;

    /* renamed from: x */
    private final C12403c f36635x;

    /* renamed from: y */
    private final LinkedHashSet<OnEditTextAttachedListener> f36636y;

    /* renamed from: z */
    private C12401a f36637z;

    @Retention(RetentionPolicy.SOURCE)
    public @interface BoxBackgroundMode {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface CounterLocation {
    }

    @Retention(RetentionPolicy.SOURCE)
    public @interface EndIconMode {
    }

    public interface OnEditTextAttachedListener {
        void onEditTextAttached(RFTextInputLayout rFTextInputLayout);
    }

    public interface OnEndIconChangedListener {
        void onEndIconChanged(RFTextInputLayout rFTextInputLayout, int i);
    }

    public RFTextInputLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFTextInputLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFTextInputLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Context context2 = context;
        this.f36635x = new C12403c(this);
        this.f36619b = new RFCollapsingTextHelper(this);
        this.f36636y = new LinkedHashSet<>();
        this.f36552A = new SparseArray<>();
        this.f36553B = new LinkedHashSet<>();
        this.f36555D = new Rect();
        this.f36556E = new Rect();
        this.f36557F = new RectF();
        this.f36572U = -1;
        this.f36573V = -1;
        setOrientation(1);
        setWillNotDraw(false);
        setAddStatesFromChildren(true);
        inflate(getContext(), R.layout.rf_text_input, this);
        m27567j();
        m27568k();
        m27566i();
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.RFTextInputLayout);
        String string = obtainStyledAttributes.getString(14);
        String string2 = obtainStyledAttributes.getString(15);
        String string3 = obtainStyledAttributes.getString(13);
        String string4 = obtainStyledAttributes.getString(3);
        String string5 = obtainStyledAttributes.getString(11);
        boolean z = obtainStyledAttributes.getBoolean(7, false);
        int i2 = obtainStyledAttributes.getInt(8, 1);
        int i3 = obtainStyledAttributes.getInt(9, -1);
        boolean z2 = obtainStyledAttributes.getBoolean(12, false);
        boolean z3 = obtainStyledAttributes.getBoolean(6, true);
        int i4 = obtainStyledAttributes.getInt(5, 1);
        ColorStateList colorStateList = obtainStyledAttributes.getColorStateList(4);
        setInnerEndIconMode(z2 ? 1 : 0);
        setEnableClearText(z3);
        setHint((CharSequence) string4);
        setDefaultHintTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setHintTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_1_0_000000));
        setHelperTextEnabled(false);
        setHelperTextTextAppearance(R.style.rf_text_field_helper);
        setHelperTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setHelperText(string5);
        setErrorIconEnabled(true);
        setErrorEnabled(false);
        setErrorTextAppearance(R.style.rf_text_field_error);
        setErrorTextColor(RFResUtils.getColorStateList(R.color.rf_color_alert_red_100_FF4E45));
        setCounterEnabled(z);
        setCounterLocation(i2);
        setCounterTextAppearance(R.style.rf_text_field_counter);
        setCounterMaxLength(i3);
        setCounterTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setCounterOverflowTextColor(RFResUtils.getColorStateList(R.color.rf_color_alert_red_100_FF4E45));
        setCounterOverflowTextAppearance(R.style.rf_text_field_counter_overflow);
        setPlaceholderTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setPlaceholderTextAppearance(R.style.rf_text_field_placeholder);
        setPlaceholderText(string3);
        setPrefixText(string);
        setPrefixTextAppearance(R.style.rf_text_field_prefix);
        setPrefixTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setSuffixText(string2);
        setSuffixTextAppearance(R.style.rf_text_field_suffix);
        setSuffixTextColor(RFResUtils.getColorStateList(R.color.rf_color_gery_3_60_999999));
        setMinWidth(obtainStyledAttributes.getDimensionPixelSize(2, -1));
        setMaxWidth(obtainStyledAttributes.getDimensionPixelSize(1, -1));
        setEnabled(obtainStyledAttributes.getBoolean(0, true));
        setBoxBackgroundMode(i4);
        if (colorStateList != null) {
            int defaultColor = colorStateList.getDefaultColor();
            this.f36576Y = defaultColor;
            this.f36575X = defaultColor;
            this.f36577Z = colorStateList.getColorForState(new int[]{-16842910}, -1);
            this.f36593aa = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
            this.f36594ab = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        } else {
            this.f36575X = 0;
            this.f36576Y = 0;
            this.f36577Z = 0;
            this.f36593aa = 0;
            this.f36594ab = 0;
        }
        ViewCompat.setImportantForAccessibility(this, 2);
        if (Build.VERSION.SDK_INT >= 26) {
            ViewCompat.setImportantForAutofill(this, 1);
        }
        Drawable drawable = RFResUtils.getDrawable(context2, R.drawable.rf_icon_tip);
        this.f36591aM = drawable;
        drawable.setBounds(0, 0, (int) RFResUtils.getDimens(context2, R.dimen.rf_dimen_32), (int) RFResUtils.getDimens(context2, R.dimen.rf_dimen_32));
    }

    /* renamed from: i */
    private void m27566i() {
        ValueAnimator ofFloat = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        this.f36602aj = ofFloat;
        ofFloat.setDuration(100);
        this.f36602aj.addListener(new Animator.AnimatorListener() {
            public void onAnimationCancel(Animator animator) {
            }

            public void onAnimationRepeat(Animator animator) {
            }

            public void onAnimationStart(Animator animator) {
                ((RFUnderlineDrawable) RFTextInputLayout.this.f36601ai).setStreamProgress(0.0f);
            }

            public void onAnimationEnd(Animator animator) {
                RFTextInputLayout rFTextInputLayout = RFTextInputLayout.this;
                int unused = rFTextInputLayout.f36614av = rFTextInputLayout.f36612at;
                boolean unused2 = RFTextInputLayout.this.f36571T = true;
                ((RFUnderlineDrawable) RFTextInputLayout.this.f36601ai).completeStream();
            }
        });
        this.f36602aj.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            public final void onAnimationUpdate(ValueAnimator valueAnimator) {
                RFTextInputLayout.this.m27541a(valueAnimator);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27541a(ValueAnimator valueAnimator) {
        ((RFUnderlineDrawable) this.f36601ai).setStreamProgress(((Float) valueAnimator.getAnimatedValue()).floatValue());
    }

    /* renamed from: j */
    private void m27567j() {
        this.f36620i = (LinearLayout) findViewById(R.id.rf_ll_frame);
        this.f36621j = (FrameLayout) findViewById(R.id.rf_fl_input_frame);
        this.f36622k = (LinearLayout) findViewById(R.id.rf_ll_start_layout);
        this.f36623l = (FrameLayout) findViewById(R.id.rf_fl_start_outer_frame);
        this.f36624m = (LinearLayout) findViewById(R.id.rf_ll_end_layout);
        this.f36625n = (FrameLayout) findViewById(R.id.rf_fl_inner_end_icon_frame);
        this.f36626o = (LinearLayout) findViewById(R.id.rf_ll_normal_end_icon_container);
        this.f36627p = (RFCheckableImageButton) findViewById(R.id.rf_cib_error_icon);
        this.f36630s = (RFCheckableImageButton) findViewById(R.id.rf_cib_outer_end_icon);
        this.f36631t = (RFTextView) findViewById(R.id.rf_tv_prefix);
        this.f36632u = (RFTextView) findViewById(R.id.rf_tv_suffix);
        this.f36628q = (RFCheckableIconButton) findViewById(R.id.rf_cib_clear_icon);
        this.f36629r = (RFCheckableIconButton) findViewById(R.id.rf_cib_inner_end_icon);
        this.f36620i.setAddStatesFromChildren(true);
        this.f36621j.setAddStatesFromChildren(true);
        ViewCompat.setAccessibilityLiveRegion(this.f36631t, 1);
        ViewCompat.setAccessibilityLiveRegion(this.f36632u, 1);
    }

    /* renamed from: k */
    private void m27568k() {
        this.f36560I = true;
        this.f36559H = true;
        this.f36558G = true;
        this.f36584aF = true;
        this.f36598af = 1;
        this.f36599ag = 1;
        this.f36597ae = 1;
        this.f36595ac = getContext().getResources().getDimensionPixelOffset(R.dimen.mtrl_textinput_box_label_cutout_padding);
        RFResUtils.getColorStateList(getContext(), R.color.rf_color_gery_17_0_33000000);
        this.f36612at = RFResUtils.getColor(getContext(), R.color.rf_color_gery_1_0_000000);
        this.f36610ar = RFResUtils.getColor(getContext(), R.color.rf_color_gery_17_0_33000000);
        this.f36615aw = RFResUtils.getColor(getContext(), R.color.rf_color_gery_3_60);
        this.f36611as = RFResUtils.getColor(getContext(), R.color.rf_color_gery_13_0_B3000000);
        setBoxStrokeErrorColor(RFResUtils.getColorStateList(getContext(), R.color.rf_color_alert_red_100_FF4E45));
        this.f36552A.append(1, new C12405e(this));
        this.f36552A.append(0, new C12404d(this));
        this.f36637z = new C12401a(this);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        EditText editText = this.f36578a;
        if (editText != null) {
            Rect rect = this.f36555D;
            RFDescendantOffsetUtils.getDescendantRect(this, editText, rect);
            if (this.f36584aF) {
                this.f36619b.setCollapsedTextSize(this.f36578a.getTextSize() * 0.75f);
                this.f36619b.setTypefaces(RFFontUtils.getFontTypeFace(getContext(), 3));
                this.f36619b.setExpandedTextSize(this.f36578a.getTextSize());
                m27578u();
                int gravity = this.f36578a.getGravity();
                this.f36619b.setCollapsedTextGravity((gravity & Const.iDefCgiSig) | 48);
                this.f36619b.setExpandedTextGravity(gravity);
                this.f36619b.setCollapsedBounds(m27539a(rect));
                this.f36619b.setExpandedBounds(m27553b(rect));
                this.f36619b.recalculate();
                if (m27524O() && !this.f36561J) {
                    m27525P();
                }
            }
        }
    }

    /* renamed from: a */
    private Rect m27539a(Rect rect) {
        if (this.f36578a != null) {
            Rect rect2 = this.f36556E;
            boolean z = ViewCompat.getLayoutDirection(this) == 1;
            rect2.bottom = rect.bottom;
            int i = this.f36574W;
            if (i == 1) {
                rect2.left = m27535a(rect.left, z);
                rect2.top = rect.top - m27569l();
                rect2.right = m27551b(rect.right, z);
            } else if (i != 2) {
                rect2.left = m27535a(rect.left, z);
                rect2.top = getPaddingTop();
                rect2.right = m27551b(rect.right, z);
            } else {
                rect2.left = rect.left + this.f36578a.getPaddingLeft();
                rect2.top = rect.top - m27569l();
                rect2.right = rect.right - this.f36578a.getPaddingRight();
            }
            return rect2;
        }
        throw new IllegalStateException();
    }

    /* renamed from: b */
    private Rect m27553b(Rect rect) {
        if (this.f36578a != null) {
            Rect rect2 = this.f36556E;
            float expandedTextHeight = this.f36619b.getExpandedTextHeight();
            rect2.left = rect.left + this.f36578a.getCompoundPaddingLeft();
            rect2.top = m27536a(rect, expandedTextHeight);
            rect2.right = rect.right - this.f36578a.getCompoundPaddingRight();
            rect2.bottom = m27537a(rect, rect2, expandedTextHeight);
            return rect2;
        }
        throw new IllegalStateException();
    }

    /* renamed from: l */
    private int m27569l() {
        float collapsedTextHeight;
        if (!this.f36584aF) {
            return 0;
        }
        int i = this.f36574W;
        if (i == 1) {
            collapsedTextHeight = this.f36619b.getCollapsedTextHeight();
        } else if (i != 2) {
            return 0;
        } else {
            collapsedTextHeight = this.f36619b.getCollapsedTextHeight() / 2.0f;
        }
        return (int) collapsedTextHeight;
    }

    /* renamed from: a */
    private int m27536a(Rect rect, float f) {
        return rect.top + this.f36578a.getCompoundPaddingTop();
    }

    /* renamed from: a */
    private int m27537a(Rect rect, Rect rect2, float f) {
        return rect.bottom - this.f36578a.getCompoundPaddingBottom();
    }

    /* renamed from: m */
    private boolean m27570m() {
        return this.f36578a.getMinLines() <= 1;
    }

    /* renamed from: a */
    private int m27535a(int i, boolean z) {
        return i + this.f36578a.getPaddingLeft();
    }

    /* renamed from: b */
    private int m27551b(int i, boolean z) {
        return i - this.f36578a.getPaddingRight();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        int mode = View.MeasureSpec.getMode(i2);
        ViewGroup.LayoutParams layoutParams = this.f36620i.getLayoutParams();
        if (mode == 1073741824) {
            if (layoutParams.height != 0) {
                LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams(layoutParams);
                layoutParams2.weight = 1.0f;
                layoutParams2.height = 0;
                this.f36620i.setLayoutParams(layoutParams2);
            }
        } else if (layoutParams.height != -2) {
            LinearLayout.LayoutParams layoutParams3 = new LinearLayout.LayoutParams(layoutParams);
            layoutParams3.weight = 0.0f;
            layoutParams3.height = -2;
            this.f36620i.setLayoutParams(layoutParams3);
        }
        super.onMeasure(i, i2);
        boolean n = m27571n();
        boolean V = m27531V();
        if (n || V) {
            this.f36578a.post(new Runnable() {
                public final void run() {
                    RFTextInputLayout.this.m27534Y();
                }
            });
        }
        m27572o();
        m27580w();
        m27581x();
    }

    /* access modifiers changed from: private */
    /* renamed from: Y */
    public /* synthetic */ void m27534Y() {
        this.f36578a.requestLayout();
    }

    /* renamed from: n */
    private boolean m27571n() {
        int max;
        if (this.f36578a == null || this.f36578a.getMeasuredHeight() >= (max = Math.max(this.f36624m.getMeasuredHeight(), this.f36622k.getMeasuredHeight()))) {
            return false;
        }
        this.f36578a.setMinimumHeight(max);
        return true;
    }

    /* renamed from: o */
    private void m27572o() {
        EditText editText;
        if (this.f36634w != null && (editText = this.f36578a) != null) {
            this.f36634w.setGravity(editText.getGravity());
            this.f36634w.setPadding(this.f36578a.getCompoundPaddingLeft(), this.f36578a.getCompoundPaddingTop(), this.f36578a.getCompoundPaddingRight(), this.f36578a.getCompoundPaddingBottom());
        }
    }

    /* access modifiers changed from: protected */
    public void drawableStateChanged() {
        if (!this.f36565N) {
            boolean z = true;
            this.f36565N = true;
            super.drawableStateChanged();
            int[] drawableState = getDrawableState();
            RFCollapsingTextHelper rFCollapsingTextHelper = this.f36619b;
            boolean state = rFCollapsingTextHelper != null ? rFCollapsingTextHelper.setState(drawableState) | false : false;
            if (this.f36578a != null) {
                if (!ViewCompat.isLaidOut(this) || !isEnabled()) {
                    z = false;
                }
                mo94696a(z);
            }
            mo94690a();
            mo94707e();
            if (state) {
                invalidate();
            }
            this.f36565N = false;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94690a() {
        if (m27573p()) {
            ViewCompat.setBackground(this.f36620i, this.f36601ai);
        }
    }

    /* renamed from: p */
    private boolean m27573p() {
        EditText editText = this.f36578a;
        return (editText == null || this.f36601ai == null || editText.getBackground() != null) ? false : true;
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        m27542a(canvas);
    }

    /* renamed from: a */
    private void m27542a(Canvas canvas) {
        if (!this.f36584aF) {
            return;
        }
        if (isCollapsedHintEnabled() || this.f36561J) {
            this.f36619b.draw(canvas);
        }
    }

    public int getBaseline() {
        EditText editText = this.f36578a;
        if (editText != null) {
            return editText.getBaseline() + getPaddingTop() + m27569l();
        }
        return super.getBaseline();
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof EditText) {
            FrameLayout.LayoutParams layoutParams2 = new FrameLayout.LayoutParams(layoutParams);
            layoutParams2.gravity = (layoutParams2.gravity & Const.iDefCgiSig) | 16;
            this.f36621j.addView(view, layoutParams2);
            this.f36620i.setLayoutParams(layoutParams);
            m27578u();
            setEditText((EditText) view);
            return;
        }
        super.addView(view, i, layoutParams);
    }

    public void setEnabled(boolean z) {
        m27544a((ViewGroup) this, z);
        super.setEnabled(z);
    }

    /* renamed from: a */
    private static void m27544a(ViewGroup viewGroup, boolean z) {
        int childCount = viewGroup.getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = viewGroup.getChildAt(i);
            childAt.setEnabled(z);
            if (childAt instanceof ViewGroup) {
                m27544a((ViewGroup) childAt, z);
            }
        }
    }

    public void setBoxBackgroundMode(int i) {
        if (i != this.f36574W) {
            this.f36574W = i;
            if (this.f36578a != null) {
                m27574q();
            }
        }
    }

    public void setBoxBackgroundColor(int i) {
        if (this.f36575X != i) {
            this.f36575X = i;
            this.f36576Y = i;
            this.f36593aa = i;
            this.f36594ab = i;
            m27518I();
        }
    }

    public void setBoxBackgroundColorStateList(ColorStateList colorStateList) {
        int defaultColor = colorStateList.getDefaultColor();
        this.f36576Y = defaultColor;
        this.f36575X = defaultColor;
        this.f36577Z = colorStateList.getColorForState(new int[]{-16842910}, -1);
        this.f36593aa = colorStateList.getColorForState(new int[]{16842908, 16842910}, -1);
        this.f36594ab = colorStateList.getColorForState(new int[]{16843623, 16842910}, -1);
        m27518I();
    }

    public int getBoxBackgroundMode() {
        return this.f36574W;
    }

    public int getBoxBackgroundColor() {
        return this.f36575X;
    }

    public void setCounterLocation(int i) {
        if (i != this.f36600ah) {
            if (!isCounterEnabled()) {
                this.f36600ah = i;
                return;
            }
            setCounterEnabled(false);
            this.f36600ah = i;
            setCounterEnabled(true);
        }
    }

    public int getCounterLocation() {
        return this.f36600ah;
    }

    /* renamed from: q */
    private void m27574q() {
        m27575r();
        mo94690a();
        mo94707e();
        m27576s();
        m27578u();
    }

    /* renamed from: r */
    private void m27575r() {
        int i = this.f36574W;
        if (i == 1) {
            this.f36601ai = new RFUnderlineDrawable();
        } else if (i != 2) {
            throw new IllegalArgumentException(this.f36574W + " is illegal; only @BoxBackgroundMode constants are supported.");
        } else if (!this.f36584aF || (this.f36601ai instanceof RFCutoutDrawable)) {
            this.f36601ai = new GradientDrawable();
        } else {
            this.f36601ai = new RFCutoutDrawable();
        }
    }

    /* renamed from: s */
    private void m27576s() {
        EditText editText = this.f36578a;
        if (editText != null) {
            int i = this.f36574W;
            if (i == 1) {
                ViewCompat.setPaddingRelative(editText, ViewCompat.getPaddingStart(editText), RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_16), ViewCompat.getPaddingEnd(this.f36578a), RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_20));
            } else if (i == 2) {
                ViewCompat.setPaddingRelative(editText, RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_18), RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_24), RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_18), RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_24));
            }
        }
    }

    private void setBoxStrokeErrorColor(ColorStateList colorStateList) {
        if (this.f36613au != colorStateList) {
            this.f36613au = colorStateList;
            mo94707e();
        }
    }

    private void setHelperTextTextAppearance(int i) {
        this.f36635x.mo94822c(i);
    }

    private void setHelperTextColor(ColorStateList colorStateList) {
        this.f36635x.mo94817b(colorStateList);
    }

    private void setErrorTextAppearance(int i) {
        this.f36635x.mo94816b(i);
    }

    private void setErrorTextColor(ColorStateList colorStateList) {
        this.f36635x.mo94809a(colorStateList);
    }

    private void setCounterTextAppearance(int i) {
        if (this.f36606an != i) {
            this.f36606an = i;
            m27577t();
        }
    }

    /* access modifiers changed from: package-private */
    public void setCounterTextColor(ColorStateList colorStateList) {
        if (this.f36604al != colorStateList) {
            this.f36604al = colorStateList;
            m27577t();
        }
    }

    /* renamed from: t */
    private void m27577t() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        RFTextView rFTextView = this.f36633v;
        if (rFTextView != null) {
            mo94693a(rFTextView, this.f36583aE ? this.f36607ao : this.f36606an);
            if (!this.f36583aE && (colorStateList2 = this.f36604al) != null) {
                this.f36633v.setTextColor(colorStateList2);
            }
            if (this.f36583aE && (colorStateList = this.f36605am) != null) {
                this.f36633v.setTextColor(colorStateList);
            }
        }
    }

    private void setCounterOverflowTextAppearance(int i) {
        if (this.f36607ao != i) {
            this.f36607ao = i;
            m27577t();
        }
    }

    private void setCounterOverflowTextColor(ColorStateList colorStateList) {
        if (this.f36605am != colorStateList) {
            this.f36605am = colorStateList;
            m27577t();
        }
    }

    /* access modifiers changed from: package-private */
    public void setHintTextAppearance(int i) {
        this.f36619b.setCollapsedTextAppearance(i);
        this.f36616ax = this.f36619b.getCollapsedTextColor();
        if (this.f36578a != null) {
            mo94696a(false);
        }
    }

    /* access modifiers changed from: package-private */
    public void setHintTextColor(ColorStateList colorStateList) {
        if (this.f36616ax != colorStateList) {
            if (this.f36603ak == null) {
                this.f36619b.setCollapsedTextColor(colorStateList);
            }
            this.f36616ax = colorStateList;
            if (this.f36578a != null) {
                mo94696a(false);
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void setDefaultHintTextColor(ColorStateList colorStateList) {
        this.f36603ak = colorStateList;
        this.f36616ax = colorStateList;
        if (this.f36578a != null) {
            mo94696a(false);
        }
    }

    public void setTextInputAccessibilityDelegate(AccessibilityDelegate accessibilityDelegate) {
        EditText editText = this.f36578a;
        if (editText != null) {
            ViewCompat.setAccessibilityDelegate(editText, accessibilityDelegate);
        }
    }

    /* access modifiers changed from: package-private */
    public void setHintAnimationEnabled(boolean z) {
        this.f36560I = z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public boolean mo94700b() {
        return this.f36558G;
    }

    /* access modifiers changed from: package-private */
    public void setExpandedHintEnabled(boolean z) {
        if (this.f36558G != z) {
            this.f36558G = z;
            mo94696a(false);
        }
    }

    public boolean isHintAnimationEnabled() {
        return this.f36560I;
    }

    /* access modifiers changed from: protected */
    public void setCollapsedHintEnabled(boolean z) {
        if (this.f36559H != z) {
            this.f36559H = z;
            mo94696a(false);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isCollapsedHintEnabled() {
        return this.f36559H;
    }

    private void setEditText(EditText editText) {
        if (this.f36578a == null) {
            this.f36578a = editText;
            setMinWidth(this.f36572U);
            setMaxWidth(this.f36573V);
            m27574q();
            setTextInputAccessibilityDelegate(new AccessibilityDelegate(this));
            this.f36619b.setTypefaces(this.f36578a.getTypeface());
            this.f36619b.setExpandedTextSize(this.f36578a.getTextSize());
            int gravity = this.f36578a.getGravity();
            this.f36619b.setCollapsedTextGravity((gravity & Const.iDefCgiSig) | 48);
            this.f36619b.setExpandedTextGravity(gravity);
            this.f36578a.addTextChangedListener(new TextWatcher() {
                public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                }

                public void afterTextChanged(Editable editable) {
                    RFTextInputLayout rFTextInputLayout = RFTextInputLayout.this;
                    rFTextInputLayout.mo94696a(!rFTextInputLayout.f36564M);
                    if (RFTextInputLayout.this.f36581aC) {
                        RFTextInputLayout.this.mo94692a(editable.length());
                    }
                    if (RFTextInputLayout.this.f36580aB) {
                        RFTextInputLayout.this.m27554b(editable.length());
                    }
                }
            });
            if (this.f36603ak == null) {
                this.f36603ak = this.f36578a.getHintTextColors();
            }
            if (this.f36584aF) {
                if (TextUtils.isEmpty(this.f36586aH)) {
                    CharSequence hint = this.f36578a.getHint();
                    this.f36585aG = hint;
                    setHint(hint);
                    this.f36578a.setHint((CharSequence) null);
                }
                this.f36563L = true;
            }
            if (this.f36633v != null) {
                mo94692a(this.f36578a.getText().length());
            }
            mo94690a();
            this.f36635x.mo94824d();
            this.f36622k.bringToFront();
            this.f36624m.bringToFront();
            m27579v();
            m27580w();
            m27581x();
            if (!isEnabled()) {
                editText.setEnabled(false);
            }
            m27548a(false, true);
            return;
        }
        throw new IllegalArgumentException("We already have an EditText, can only have one");
    }

    /* renamed from: u */
    private void m27578u() {
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f36620i.getLayoutParams();
        int l = m27569l();
        if (l != layoutParams.topMargin) {
            layoutParams.topMargin = l;
            requestLayout();
        }
    }

    /* renamed from: v */
    private void m27579v() {
        Iterator it = this.f36636y.iterator();
        while (it.hasNext()) {
            ((OnEditTextAttachedListener) it.next()).onEditTextAttached(this);
        }
    }

    public EditText getEditText() {
        return this.f36578a;
    }

    public void setMaxWidth(int i) {
        this.f36573V = i;
        EditText editText = this.f36578a;
        if (editText != null && i != -1) {
            editText.setMaxWidth(i);
        }
    }

    public int getMaxWidth() {
        return this.f36573V;
    }

    public void setMinWidth(int i) {
        this.f36572U = i;
        EditText editText = this.f36578a;
        if (editText != null && i != -1) {
            editText.setMinWidth(i);
        }
    }

    public int getMinWidth() {
        return this.f36572U;
    }

    public void setPasswordVisibilityToggleEnabled(boolean z) {
        if (z && this.f36589aK != 1) {
            setInnerEndIconMode(1);
        } else if (!z) {
            setInnerEndIconMode(0);
        }
    }

    public boolean isPasswordVisibilityToggleEnabled() {
        return this.f36589aK == 1;
    }

    public void setPrefixText(CharSequence charSequence) {
        this.f36587aI = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f36631t.setText(charSequence);
        m27529T();
    }

    /* renamed from: w */
    private void m27580w() {
        if (this.f36578a != null) {
            ViewCompat.setPaddingRelative(this.f36622k, m27582y() ? 0 : ViewCompat.getPaddingStart(this.f36578a), this.f36578a.getCompoundPaddingTop(), (int) RFResUtils.getDimens(R.dimen.rf_dimen_8), this.f36578a.getCompoundPaddingBottom());
        }
    }

    public CharSequence getPrefixText() {
        return this.f36587aI;
    }

    /* access modifiers changed from: package-private */
    public void setPrefixTextColor(ColorStateList colorStateList) {
        this.f36631t.setTextColor(colorStateList);
    }

    public void setSuffixText(CharSequence charSequence) {
        this.f36588aJ = TextUtils.isEmpty(charSequence) ? null : charSequence;
        this.f36632u.setText(charSequence);
        m27530U();
    }

    /* access modifiers changed from: package-private */
    public void setSuffixTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.f36632u, i);
    }

    /* renamed from: x */
    private void m27581x() {
        if (this.f36578a != null) {
            LinearLayout linearLayout = this.f36624m;
            ViewCompat.setPaddingRelative(linearLayout, linearLayout.getPaddingLeft(), this.f36578a.getPaddingTop(), ViewCompat.getPaddingEnd(this.f36578a), this.f36578a.getPaddingBottom());
        }
    }

    /* access modifiers changed from: package-private */
    public void setSuffixTextColor(ColorStateList colorStateList) {
        this.f36632u.setTextColor(colorStateList);
    }

    public CharSequence getSuffixText() {
        return this.f36588aJ;
    }

    public void setStartView(View view, FrameLayout.LayoutParams layoutParams) {
        this.f36623l.removeAllViews();
        this.f36623l.addView(view, layoutParams);
        m27531V();
    }

    /* renamed from: y */
    private boolean m27582y() {
        return this.f36623l.getChildCount() > 0;
    }

    public void setEndIconDrawable(int i) {
        setEndIconDrawable(i != 0 ? AppCompatResources.getDrawable(getContext(), i) : null);
    }

    public void setEndIconDrawable(Drawable drawable) {
        if (drawable == null) {
            this.f36630s.setVisibility(8);
            return;
        }
        this.f36630s.setVisibility(0);
        this.f36630s.setImageDrawable(drawable);
        refreshEndIconDrawableState();
    }

    public void setEndIconCheckable(boolean z) {
        this.f36630s.setCheckable(z);
    }

    public boolean isEndIconCheckable() {
        return this.f36630s.isCheckable();
    }

    public void setEndIconOnClickListener(View.OnClickListener onClickListener) {
        m27546a(this.f36630s, onClickListener, this.f36590aL);
    }

    public void setEndIconOnLongClickListener(View.OnLongClickListener onLongClickListener) {
        this.f36590aL = onLongClickListener;
        m27547a(this.f36630s, onLongClickListener);
    }

    public void refreshEndIconDrawableState() {
        m27545a(this.f36630s, this.f36617ay);
    }

    public void setHintEnabled(boolean z) {
        if (z != this.f36584aF) {
            this.f36584aF = z;
            if (!z) {
                this.f36563L = false;
                if (!TextUtils.isEmpty(this.f36586aH) && TextUtils.isEmpty(this.f36578a.getHint())) {
                    this.f36578a.setHint(this.f36586aH);
                }
                setHintInternal((CharSequence) null);
            } else {
                CharSequence hint = this.f36578a.getHint();
                if (!TextUtils.isEmpty(hint)) {
                    if (TextUtils.isEmpty(this.f36586aH)) {
                        setHint(hint);
                    }
                    this.f36578a.setHint((CharSequence) null);
                }
                this.f36563L = true;
            }
            if (this.f36578a != null) {
                m27578u();
            }
        }
    }

    public void setHint(CharSequence charSequence) {
        if (this.f36584aF) {
            setHintInternal(charSequence);
            sendAccessibilityEvent(2048);
        }
    }

    public void setHint(int i) {
        setHint(i != 0 ? getResources().getText(i) : null);
    }

    private void setHintInternal(CharSequence charSequence) {
        if (!TextUtils.equals(charSequence, this.f36586aH)) {
            this.f36586aH = charSequence;
            this.f36619b.setText(charSequence);
        }
    }

    public CharSequence getHint() {
        if (this.f36584aF) {
            return this.f36586aH;
        }
        return null;
    }

    public boolean isHintEnabled() {
        return this.f36584aF;
    }

    private void setPlaceholderTextEnabled(boolean z) {
        if (this.f36580aB != z) {
            if (z) {
                RFTextView rFTextView = new RFTextView(getContext());
                this.f36634w = rFTextView;
                ViewCompat.setAccessibilityLiveRegion(rFTextView, 1);
                setPlaceholderTextAppearance(this.f36609aq);
                setPlaceholderTextColor(this.f36608ap);
                m27583z();
            } else {
                m27510A();
                this.f36634w = null;
            }
            this.f36580aB = z;
        }
    }

    /* renamed from: z */
    private void m27583z() {
        RFTextView rFTextView = this.f36634w;
        if (rFTextView != null) {
            this.f36621j.addView(rFTextView);
            this.f36634w.setVisibility(0);
        }
    }

    /* renamed from: A */
    private void m27510A() {
        RFTextView rFTextView = this.f36634w;
        if (rFTextView != null) {
            rFTextView.setVisibility(8);
        }
    }

    public void setPlaceholderText(CharSequence charSequence) {
        if (!this.f36580aB || !TextUtils.isEmpty(charSequence)) {
            if (!this.f36580aB) {
                setPlaceholderTextEnabled(true);
            }
            this.f36579aA = charSequence;
        } else {
            setPlaceholderTextEnabled(false);
        }
        m27511B();
    }

    public CharSequence getPlaceholderText() {
        if (this.f36580aB) {
            return this.f36579aA;
        }
        return null;
    }

    public void setPlaceholderTextColor(ColorStateList colorStateList) {
        if (this.f36608ap != colorStateList) {
            this.f36608ap = colorStateList;
            RFTextView rFTextView = this.f36634w;
            if (rFTextView != null && colorStateList != null) {
                rFTextView.setTextColor(colorStateList);
            }
        }
    }

    private void setPlaceholderTextAppearance(int i) {
        this.f36609aq = i;
        RFTextView rFTextView = this.f36634w;
        if (rFTextView != null) {
            TextViewCompat.setTextAppearance(rFTextView, i);
        }
    }

    private void setPrefixTextAppearance(int i) {
        TextViewCompat.setTextAppearance(this.f36631t, i);
    }

    /* renamed from: B */
    private void m27511B() {
        EditText editText = this.f36578a;
        m27554b(editText == null ? 0 : editText.getText().length());
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m27554b(int i) {
        if (i != 0 || this.f36561J) {
            m27513D();
        } else {
            m27512C();
        }
    }

    /* renamed from: C */
    private void m27512C() {
        RFTextView rFTextView = this.f36634w;
        if (rFTextView != null && this.f36580aB) {
            rFTextView.setText(this.f36579aA);
            this.f36634w.setVisibility(0);
            this.f36634w.bringToFront();
        }
    }

    /* renamed from: D */
    private void m27513D() {
        RFTextView rFTextView = this.f36634w;
        if (rFTextView != null && this.f36580aB) {
            rFTextView.setText((CharSequence) null);
            this.f36634w.setVisibility(4);
        }
    }

    public void setHelperTextEnabled(boolean z) {
        this.f36635x.mo94820b(z);
    }

    public void setHelperText(CharSequence charSequence) {
        if (!TextUtils.isEmpty(charSequence)) {
            if (!isHelperTextEnabled()) {
                setHelperTextEnabled(true);
            }
            this.f36635x.mo94812a(charSequence);
        } else if (isHelperTextEnabled()) {
            setHelperTextEnabled(false);
        }
    }

    public CharSequence getHelperText() {
        if (this.f36635x.mo94826f()) {
            return this.f36635x.mo94832l();
        }
        return null;
    }

    public boolean isHelperTextEnabled() {
        return this.f36635x.mo94826f();
    }

    private void setErrorEnabled(boolean z) {
        this.f36635x.mo94813a(z);
    }

    public void setErrorIconEnabled(boolean z) {
        this.f36592aN = z;
        mo94707e();
    }

    public void setError(CharSequence charSequence) {
        if (!this.f36635x.mo94825e()) {
            if (!TextUtils.isEmpty(charSequence)) {
                setErrorEnabled(true);
            } else {
                return;
            }
        }
        if (!TextUtils.isEmpty(charSequence)) {
            this.f36635x.mo94819b(charSequence);
            return;
        }
        this.f36635x.mo94815b();
        setErrorEnabled(false);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo94701c() {
        m27545a(this.f36627p, this.f36618az);
    }

    public CharSequence getError() {
        if (this.f36635x.mo94825e()) {
            return this.f36635x.mo94831k();
        }
        return null;
    }

    public boolean getErrorIconEnabled() {
        return this.f36592aN;
    }

    public void setCounterEnabled(boolean z) {
        if (this.f36581aC != z) {
            if (z) {
                RFTextView rFTextView = new RFTextView(getContext());
                this.f36633v = rFTextView;
                rFTextView.setMaxLines(1);
                int i = this.f36600ah;
                if (i == 0) {
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    layoutParams.gravity = GravityCompat.END;
                    layoutParams.rightMargin = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_18);
                    layoutParams.bottomMargin = RFResUtils.getDimensionPixelSize(R.dimen.rf_dimen_24);
                    this.f36620i.addView(this.f36633v, layoutParams);
                } else if (i == 1) {
                    this.f36635x.mo94811a((TextView) this.f36633v, 2);
                    MarginLayoutParamsCompat.setMarginStart((ViewGroup.MarginLayoutParams) this.f36633v.getLayoutParams(), (int) RFResUtils.getDimens(getContext(), R.dimen.rf_dimen_16));
                }
                m27515F();
                m27514E();
            } else {
                int i2 = this.f36600ah;
                if (i2 == 0) {
                    this.f36620i.removeView(this.f36633v);
                } else if (i2 == 1) {
                    this.f36635x.mo94818b(this.f36633v, 2);
                }
                this.f36633v = null;
            }
            this.f36581aC = z;
        }
    }

    public void setCounterMaxLength(int i) {
        if (this.f36582aD != i) {
            if (i > 0) {
                this.f36582aD = i;
            } else {
                this.f36582aD = -1;
            }
            if (this.f36581aC) {
                m27514E();
            }
        }
    }

    /* renamed from: E */
    private void m27514E() {
        if (this.f36633v != null) {
            EditText editText = this.f36578a;
            mo94692a(editText == null ? 0 : editText.getText().length());
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94692a(int i) {
        boolean z = this.f36583aE;
        int i2 = this.f36582aD;
        if (i2 == -1) {
            this.f36633v.setText(String.valueOf(i));
            this.f36633v.setContentDescription((CharSequence) null);
            this.f36583aE = false;
        } else {
            boolean z2 = i > i2;
            this.f36583aE = z2;
            if (z != z2) {
                m27515F();
            }
            this.f36633v.setText(BidiFormatter.getInstance().unicodeWrap(getContext().getString(R.string.rf_text_input_counter_pattern, new Object[]{Integer.valueOf(i), Integer.valueOf(this.f36582aD)})));
        }
        if (this.f36578a != null && z != this.f36583aE) {
            mo94696a(false);
            mo94707e();
            mo94690a();
        }
    }

    /* renamed from: F */
    private void m27515F() {
        ColorStateList colorStateList;
        ColorStateList colorStateList2;
        RFTextView rFTextView = this.f36633v;
        if (rFTextView != null) {
            mo94693a(rFTextView, this.f36583aE ? this.f36607ao : this.f36606an);
            if (!this.f36583aE && (colorStateList2 = this.f36604al) != null) {
                this.f36633v.setTextColor(colorStateList2);
            }
            if (this.f36583aE && (colorStateList = this.f36605am) != null) {
                this.f36633v.setTextColor(colorStateList);
            }
        }
    }

    public int getCounterMaxLength() {
        return this.f36582aD;
    }

    /* access modifiers changed from: package-private */
    public CharSequence getCounterOverflowDescription() {
        RFTextView rFTextView;
        if (!this.f36581aC || !this.f36583aE || (rFTextView = this.f36633v) == null) {
            return null;
        }
        return rFTextView.getContentDescription();
    }

    public boolean isCounterEnabled() {
        return this.f36581aC;
    }

    public void addOnEditTextAttachedListener(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.f36636y.add(onEditTextAttachedListener);
        if (this.f36578a != null) {
            onEditTextAttachedListener.onEditTextAttached(this);
        }
    }

    public void removeOnEditTextAttachedListener(OnEditTextAttachedListener onEditTextAttachedListener) {
        this.f36636y.remove(onEditTextAttachedListener);
    }

    public void clearOnEditTextAttachedListeners() {
        this.f36636y.clear();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public final boolean mo94703d() {
        return this.f36561J;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94693a(RFTextView rFTextView, int i) {
        try {
            TextViewCompat.setTextAppearance(rFTextView, i);
            if (Build.VERSION.SDK_INT >= 23) {
                int defaultColor = rFTextView.getTextColors().getDefaultColor();
            }
        } catch (Exception unused) {
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94696a(boolean z) {
        m27548a(z, false);
    }

    /* renamed from: a */
    private void m27548a(boolean z, boolean z2) {
        ColorStateList colorStateList;
        int i;
        boolean isEnabled = isEnabled();
        EditText editText = this.f36578a;
        boolean z3 = editText != null && !TextUtils.isEmpty(editText.getText());
        EditText editText2 = this.f36578a;
        boolean z4 = editText2 != null && editText2.hasFocus();
        boolean h = this.f36635x.mo94828h();
        ColorStateList colorStateList2 = this.f36603ak;
        if (colorStateList2 != null) {
            this.f36619b.setCollapsedTextColor(colorStateList2);
            this.f36619b.setExpandedTextColor(this.f36603ak);
        }
        if (!isEnabled) {
            ColorStateList colorStateList3 = this.f36603ak;
            if (colorStateList3 != null) {
                i = colorStateList3.getColorForState(new int[]{-16842910}, this.f36615aw);
            } else {
                i = this.f36615aw;
            }
            this.f36619b.setCollapsedTextColor(ColorStateList.valueOf(i));
            this.f36619b.setExpandedTextColor(ColorStateList.valueOf(i));
        } else if (h) {
            this.f36619b.setCollapsedTextColor(this.f36603ak);
        } else if (this.f36583aE && this.f36633v != null) {
            this.f36619b.setCollapsedTextColor(this.f36603ak);
        } else if (z4 && (colorStateList = this.f36616ax) != null) {
            this.f36619b.setCollapsedTextColor(colorStateList);
        }
        if (z3 || !this.f36558G || (isEnabled() && z4)) {
            if (z2 || this.f36561J) {
                m27557b(z);
            }
        } else if (z2 || !this.f36561J) {
            m27560c(z);
        }
        if (this.f36578a != null) {
            setHintTextColor(this.f36616ax);
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Code restructure failed: missing block: B:5:0x000d, code lost:
        r0 = r5.f36578a;
     */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo94707e() {
        /*
            r5 = this;
            android.graphics.drawable.GradientDrawable r0 = r5.f36601ai
            if (r0 != 0) goto L_0x0005
            return
        L_0x0005:
            boolean r0 = r5.isFocused()
            r1 = 0
            r2 = 1
            if (r0 != 0) goto L_0x001a
            android.widget.EditText r0 = r5.f36578a
            if (r0 == 0) goto L_0x0018
            boolean r0 = r0.hasFocus()
            if (r0 == 0) goto L_0x0018
            goto L_0x001a
        L_0x0018:
            r0 = 0
            goto L_0x001b
        L_0x001a:
            r0 = 1
        L_0x001b:
            boolean r3 = r5.isHovered()
            if (r3 != 0) goto L_0x002e
            android.widget.EditText r3 = r5.f36578a
            if (r3 == 0) goto L_0x002c
            boolean r3 = r3.isHovered()
            if (r3 == 0) goto L_0x002c
            goto L_0x002e
        L_0x002c:
            r3 = 0
            goto L_0x002f
        L_0x002e:
            r3 = 1
        L_0x002f:
            boolean r4 = r5.isEnabled()
            if (r4 != 0) goto L_0x003d
            r5.m27517H()
            int r4 = r5.f36615aw
            r5.f36614av = r4
            goto L_0x0099
        L_0x003d:
            com.didi.rfusion.widget.textfield.c r4 = r5.f36635x
            boolean r4 = r4.mo94828h()
            if (r4 == 0) goto L_0x0059
            r5.m27517H()
            android.content.res.ColorStateList r4 = r5.f36613au
            if (r4 == 0) goto L_0x0050
            r5.m27558b((boolean) r0, (boolean) r3)
            goto L_0x0099
        L_0x0050:
            com.didi.rfusion.widget.textfield.c r4 = r5.f36635x
            int r4 = r4.mo94833m()
            r5.f36614av = r4
            goto L_0x0099
        L_0x0059:
            boolean r4 = r5.f36583aE
            if (r4 == 0) goto L_0x0075
            com.didi.rfusion.widget.RFTextView r4 = r5.f36633v
            if (r4 == 0) goto L_0x0075
            r5.m27517H()
            android.content.res.ColorStateList r4 = r5.f36613au
            if (r4 == 0) goto L_0x006c
            r5.m27558b((boolean) r0, (boolean) r3)
            goto L_0x0099
        L_0x006c:
            com.didi.rfusion.widget.RFTextView r4 = r5.f36633v
            int r4 = r4.getCurrentTextColor()
            r5.f36614av = r4
            goto L_0x0099
        L_0x0075:
            if (r0 == 0) goto L_0x0086
            int r4 = r5.f36574W
            if (r4 != r2) goto L_0x0081
            boolean r4 = r5.m27516G()
            if (r4 != 0) goto L_0x0099
        L_0x0081:
            int r4 = r5.f36612at
            r5.f36614av = r4
            goto L_0x0099
        L_0x0086:
            if (r3 == 0) goto L_0x0090
            r5.m27517H()
            int r4 = r5.f36611as
            r5.f36614av = r4
            goto L_0x0099
        L_0x0090:
            r5.m27517H()
            int r4 = r5.f36610ar
            r5.f36614av = r4
            r5.f36571T = r1
        L_0x0099:
            com.didi.rfusion.widget.textfield.c r4 = r5.f36635x
            boolean r4 = r4.mo94825e()
            if (r4 == 0) goto L_0x00ae
            com.didi.rfusion.widget.textfield.c r4 = r5.f36635x
            boolean r4 = r4.mo94828h()
            if (r4 == 0) goto L_0x00ae
            boolean r4 = r5.f36592aN
            if (r4 == 0) goto L_0x00ae
            r1 = 1
        L_0x00ae:
            r5.setErrorIconVisible(r1)
            r5.refreshEndIconDrawableState()
            if (r0 == 0) goto L_0x00c1
            boolean r1 = r5.isEnabled()
            if (r1 == 0) goto L_0x00c1
            int r1 = r5.f36599ag
            r5.f36597ae = r1
            goto L_0x00c5
        L_0x00c1:
            int r1 = r5.f36598af
            r5.f36597ae = r1
        L_0x00c5:
            int r1 = r5.f36574W
            r4 = 2
            if (r1 != r4) goto L_0x00cd
            r5.m27526Q()
        L_0x00cd:
            int r1 = r5.f36574W
            if (r1 != r2) goto L_0x00f0
            boolean r1 = r5.isEnabled()
            if (r1 != 0) goto L_0x00dc
            int r0 = r5.f36577Z
            r5.f36575X = r0
            goto L_0x00f0
        L_0x00dc:
            if (r3 == 0) goto L_0x00e5
            if (r0 != 0) goto L_0x00e5
            int r0 = r5.f36594ab
            r5.f36575X = r0
            goto L_0x00f0
        L_0x00e5:
            if (r0 == 0) goto L_0x00ec
            int r0 = r5.f36593aa
            r5.f36575X = r0
            goto L_0x00f0
        L_0x00ec:
            int r0 = r5.f36576Y
            r5.f36575X = r0
        L_0x00f0:
            r5.m27518I()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.textfield.RFTextInputLayout.mo94707e():void");
    }

    /* renamed from: G */
    private boolean m27516G() {
        if (this.f36602aj.isRunning()) {
            return true;
        }
        if (this.f36571T) {
            return false;
        }
        this.f36602aj.start();
        return true;
    }

    /* renamed from: H */
    private void m27517H() {
        if (this.f36602aj.isRunning()) {
            this.f36602aj.end();
        }
    }

    /* renamed from: b */
    private void m27558b(boolean z, boolean z2) {
        m27517H();
        int defaultColor = this.f36613au.getDefaultColor();
        int colorForState = this.f36613au.getColorForState(new int[]{16843623, 16842910}, defaultColor);
        int colorForState2 = this.f36613au.getColorForState(new int[]{16843518, 16842910}, defaultColor);
        if (z) {
            this.f36614av = colorForState2;
        } else if (z2) {
            this.f36614av = colorForState;
        } else {
            this.f36614av = defaultColor;
        }
    }

    /* renamed from: I */
    private void m27518I() {
        if (this.f36601ai != null) {
            if (m27520K()) {
                this.f36601ai.setStroke(this.f36597ae, this.f36614av);
                this.f36601ai.setCornerRadius(RFResUtils.getDimens(R.dimen.rf_dimen_8));
            }
            if (m27521L()) {
                this.f36601ai.setStroke(this.f36597ae, this.f36614av);
                ((RFUnderlineDrawable) this.f36601ai).setStreamColor(RFResUtils.getColor(R.color.rf_color_gery_1_0_000000));
            }
            this.f36601ai.setColor(this.f36575X);
            invalidate();
        }
    }

    /* renamed from: J */
    private void m27519J() {
        invalidate();
    }

    /* renamed from: K */
    private boolean m27520K() {
        return this.f36574W == 2 && m27522M();
    }

    /* renamed from: L */
    private boolean m27521L() {
        return this.f36574W == 1 && m27522M();
    }

    /* renamed from: M */
    private boolean m27522M() {
        return this.f36597ae > -1 && this.f36614av != 0;
    }

    public void setEnableClearText(boolean z) {
        if (this.f36562K != z) {
            if (z) {
                this.f36637z.mo94806a();
            } else {
                this.f36637z.mo94807b();
                setClearIconVisible(false);
            }
            this.f36562K = z;
        }
    }

    public boolean isEnableClearText() {
        return this.f36562K;
    }

    /* renamed from: N */
    private boolean m27523N() {
        return this.f36626o.getVisibility() == 0 && this.f36628q.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    public void setClearIconVisible(boolean z) {
        if (ViewUtils.isVisible(this.f36628q) != z) {
            this.f36628q.setVisibility(z ? 0 : 8);
            m27531V();
        }
    }

    /* access modifiers changed from: package-private */
    public void setClearIconCheckable(boolean z) {
        this.f36628q.setCheckable(z);
    }

    /* access modifiers changed from: package-private */
    public void setClearIconOnClickListener(View.OnClickListener onClickListener) {
        this.f36628q.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public RFCheckableIconButton getClearIcon() {
        return this.f36628q;
    }

    /* access modifiers changed from: package-private */
    public void setInnerEndIconMode(int i) {
        int i2 = this.f36589aK;
        this.f36589aK = i;
        m27559c(i2);
        setInnerEndIconVisible(i != 0);
        getInnerEndIconDelegate().mo94806a();
    }

    /* access modifiers changed from: package-private */
    public void setInnerEndIconOnClickListener(View.OnClickListener onClickListener) {
        this.f36629r.setOnClickListener(onClickListener);
    }

    /* access modifiers changed from: package-private */
    public RFCheckableIconButton getInnerEndIconView() {
        return this.f36629r;
    }

    private C12402b getInnerEndIconDelegate() {
        C12402b bVar = this.f36552A.get(this.f36589aK);
        return bVar != null ? bVar : this.f36552A.get(0);
    }

    /* renamed from: c */
    private void m27559c(int i) {
        Iterator it = this.f36553B.iterator();
        while (it.hasNext()) {
            ((OnEndIconChangedListener) it.next()).onEndIconChanged(this, i);
        }
    }

    /* access modifiers changed from: package-private */
    public void setInnerEndIconCheckable(boolean z) {
        this.f36629r.setCheckable(z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public boolean mo94708f() {
        return this.f36629r.isCheckable();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94695a(String str, String str2) {
        this.f36629r.setIcon(str, str2);
    }

    /* access modifiers changed from: package-private */
    public void setInnerEndIconVisible(boolean z) {
        if (mo94709g() != z) {
            this.f36629r.setVisibility(z ? 0 : 8);
            m27531V();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: g */
    public boolean mo94709g() {
        return this.f36626o.getVisibility() == 0 && this.f36629r.getVisibility() == 0;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94694a(OnEndIconChangedListener onEndIconChangedListener) {
        this.f36553B.add(onEndIconChangedListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo94699b(OnEndIconChangedListener onEndIconChangedListener) {
        this.f36553B.remove(onEndIconChangedListener);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: h */
    public void mo94728h() {
        this.f36553B.clear();
    }

    /* renamed from: b */
    private void m27557b(boolean z) {
        ValueAnimator valueAnimator = this.f36554C;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f36554C.cancel();
        }
        if (!z || !this.f36560I) {
            this.f36619b.setExpansionFraction(1.0f);
        } else {
            mo94691a(1.0f);
        }
        if (m27524O()) {
            m27525P();
        }
        this.f36561J = false;
        m27511B();
        m27529T();
        m27530U();
    }

    /* renamed from: c */
    private void m27560c(boolean z) {
        GradientDrawable gradientDrawable;
        ValueAnimator valueAnimator = this.f36554C;
        if (valueAnimator != null && valueAnimator.isRunning()) {
            this.f36554C.cancel();
        }
        if (!z || !this.f36560I) {
            this.f36619b.setExpansionFraction(0.0f);
        } else {
            mo94691a(0.0f);
        }
        if (m27524O() && (gradientDrawable = this.f36601ai) != null && ((RFCutoutDrawable) gradientDrawable).hasCutout()) {
            m27527R();
        }
        this.f36561J = true;
        m27513D();
        m27529T();
        m27530U();
    }

    /* renamed from: O */
    private boolean m27524O() {
        return this.f36584aF && !TextUtils.isEmpty(this.f36586aH) && (this.f36601ai instanceof RFCutoutDrawable) && isCollapsedHintEnabled();
    }

    /* renamed from: P */
    private void m27525P() {
        if (m27524O()) {
            RectF rectF = this.f36557F;
            this.f36619b.getCollapsedTextActualBounds(rectF, this.f36578a.getWidth(), this.f36578a.getGravity());
            this.f36596ad = this.f36597ae;
            rectF.bottom = rectF.top + ((float) this.f36596ad);
            m27543a(rectF);
            rectF.offset((float) (-getPaddingLeft()), (float) (-getPaddingTop()));
            ((RFCutoutDrawable) this.f36601ai).setCutout(rectF);
        }
    }

    /* renamed from: Q */
    private void m27526Q() {
        if (m27524O() && !this.f36561J && this.f36596ad != this.f36597ae) {
            m27527R();
            m27525P();
        }
    }

    /* renamed from: R */
    private void m27527R() {
        GradientDrawable gradientDrawable;
        if (m27524O() && (gradientDrawable = this.f36601ai) != null) {
            ((RFCutoutDrawable) gradientDrawable).removeCutout();
        }
    }

    /* renamed from: a */
    private void m27543a(RectF rectF) {
        rectF.left -= (float) this.f36595ac;
        rectF.right += (float) this.f36595ac;
    }

    public boolean isProvidingHint() {
        return this.f36563L;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo94691a(float f) {
        if (this.f36619b.getExpansionFraction() != f) {
            if (this.f36554C == null) {
                ValueAnimator valueAnimator = new ValueAnimator();
                this.f36554C = valueAnimator;
                valueAnimator.setInterpolator(RFAnimationUtils.FAST_OUT_SLOW_IN_INTERPOLATOR);
                this.f36554C.setDuration(167);
                this.f36554C.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    public void onAnimationUpdate(ValueAnimator valueAnimator) {
                        RFTextInputLayout.this.f36619b.setExpansionFraction(((Float) valueAnimator.getAnimatedValue()).floatValue());
                    }
                });
            }
            this.f36554C.setFloatValues(new float[]{this.f36619b.getExpansionFraction(), f});
            this.f36554C.start();
        }
    }

    private void setErrorIconVisible(boolean z) {
        int i = 0;
        this.f36627p.setVisibility(z ? 0 : 8);
        LinearLayout linearLayout = this.f36626o;
        if (z) {
            i = 8;
        }
        linearLayout.setVisibility(i);
        m27531V();
    }

    /* renamed from: S */
    private boolean m27528S() {
        return this.f36627p.getVisibility() == 0;
    }

    /* renamed from: T */
    private void m27529T() {
        this.f36631t.setVisibility((this.f36587aI == null || mo94703d()) ? 8 : 0);
        m27531V();
    }

    /* renamed from: U */
    private void m27530U() {
        this.f36632u.getVisibility();
        int i = 0;
        boolean z = this.f36588aJ != null && !mo94703d();
        RFTextView rFTextView = this.f36632u;
        if (!z) {
            i = 8;
        }
        rFTextView.setVisibility(i);
        m27531V();
    }

    /* JADX WARNING: Removed duplicated region for block: B:20:0x0069  */
    /* JADX WARNING: Removed duplicated region for block: B:32:0x00bf  */
    /* renamed from: V */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean m27531V() {
        /*
            r10 = this;
            android.widget.EditText r0 = r10.f36578a
            r1 = 0
            if (r0 != 0) goto L_0x0006
            return r1
        L_0x0006:
            boolean r0 = r10.m27532W()
            r2 = 0
            r3 = 3
            r4 = 2
            r5 = 1
            if (r0 == 0) goto L_0x0049
            android.widget.LinearLayout r0 = r10.f36622k
            int r0 = r0.getMeasuredWidth()
            android.widget.EditText r6 = r10.f36578a
            int r6 = r6.getPaddingLeft()
            int r0 = r0 - r6
            android.graphics.drawable.Drawable r6 = r10.f36566O
            if (r6 == 0) goto L_0x0025
            int r6 = r10.f36567P
            if (r6 == r0) goto L_0x0031
        L_0x0025:
            android.graphics.drawable.ColorDrawable r6 = new android.graphics.drawable.ColorDrawable
            r6.<init>()
            r10.f36566O = r6
            r10.f36567P = r0
            r6.setBounds(r1, r1, r0, r5)
        L_0x0031:
            android.widget.EditText r0 = r10.f36578a
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r0)
            r6 = r0[r1]
            android.graphics.drawable.Drawable r7 = r10.f36566O
            if (r6 == r7) goto L_0x0062
            android.widget.EditText r6 = r10.f36578a
            r8 = r0[r5]
            r9 = r0[r4]
            r0 = r0[r3]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r6, r7, r8, r9, r0)
            goto L_0x0060
        L_0x0049:
            android.graphics.drawable.Drawable r0 = r10.f36566O
            if (r0 == 0) goto L_0x0062
            android.widget.EditText r0 = r10.f36578a
            android.graphics.drawable.Drawable[] r0 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r0)
            android.widget.EditText r6 = r10.f36578a
            r7 = r0[r5]
            r8 = r0[r4]
            r0 = r0[r3]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r6, r2, r7, r8, r0)
            r10.f36566O = r2
        L_0x0060:
            r0 = 1
            goto L_0x0063
        L_0x0062:
            r0 = 0
        L_0x0063:
            boolean r6 = r10.m27533X()
            if (r6 == 0) goto L_0x00bf
            android.widget.LinearLayout r2 = r10.f36624m
            int r2 = r2.getMeasuredWidth()
            android.widget.EditText r6 = r10.f36578a
            int r6 = r6.getPaddingRight()
            int r2 = r2 - r6
            android.widget.EditText r6 = r10.f36578a
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r6)
            android.graphics.drawable.Drawable r7 = r10.f36568Q
            if (r7 == 0) goto L_0x0097
            int r8 = r10.f36570S
            if (r8 == r2) goto L_0x0097
            r10.f36570S = r2
            r7.setBounds(r1, r1, r2, r5)
            android.widget.EditText r0 = r10.f36578a
            r1 = r6[r1]
            r2 = r6[r5]
            android.graphics.drawable.Drawable r4 = r10.f36568Q
            r3 = r6[r3]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r2, r4, r3)
            goto L_0x00e0
        L_0x0097:
            android.graphics.drawable.Drawable r7 = r10.f36568Q
            if (r7 != 0) goto L_0x00a7
            android.graphics.drawable.ColorDrawable r7 = new android.graphics.drawable.ColorDrawable
            r7.<init>()
            r10.f36568Q = r7
            r10.f36570S = r2
            r7.setBounds(r1, r1, r2, r5)
        L_0x00a7:
            r2 = r6[r4]
            android.graphics.drawable.Drawable r7 = r10.f36568Q
            if (r2 == r7) goto L_0x00bd
            r0 = r6[r4]
            r10.f36569R = r0
            android.widget.EditText r0 = r10.f36578a
            r1 = r6[r1]
            r2 = r6[r5]
            r3 = r6[r3]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r2, r7, r3)
            goto L_0x00e0
        L_0x00bd:
            r5 = r0
            goto L_0x00e0
        L_0x00bf:
            android.graphics.drawable.Drawable r6 = r10.f36568Q
            if (r6 == 0) goto L_0x00e1
            android.widget.EditText r6 = r10.f36578a
            android.graphics.drawable.Drawable[] r6 = androidx.core.widget.TextViewCompat.getCompoundDrawablesRelative(r6)
            r4 = r6[r4]
            android.graphics.drawable.Drawable r7 = r10.f36568Q
            if (r4 != r7) goto L_0x00dd
            android.widget.EditText r0 = r10.f36578a
            r1 = r6[r1]
            r4 = r6[r5]
            android.graphics.drawable.Drawable r7 = r10.f36569R
            r3 = r6[r3]
            androidx.core.widget.TextViewCompat.setCompoundDrawablesRelative(r0, r1, r4, r7, r3)
            goto L_0x00de
        L_0x00dd:
            r5 = r0
        L_0x00de:
            r10.f36568Q = r2
        L_0x00e0:
            r0 = r5
        L_0x00e1:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.rfusion.widget.textfield.RFTextInputLayout.m27531V():boolean");
    }

    /* renamed from: W */
    private boolean m27532W() {
        return (this.f36623l.getChildCount() > 0 || this.f36587aI != null) && this.f36622k.getMeasuredWidth() > 0;
    }

    /* renamed from: X */
    private boolean m27533X() {
        return (m27528S() || m27523N() || mo94709g() || this.f36630s.getVisibility() == 0 || this.f36588aJ != null) && this.f36624m.getMeasuredWidth() > 0;
    }

    /* renamed from: a */
    private void m27545a(RFCheckableImageButton rFCheckableImageButton, ColorStateList colorStateList) {
        Drawable drawable = rFCheckableImageButton.getDrawable();
        if (rFCheckableImageButton.getDrawable() != null && colorStateList != null && colorStateList.isStateful()) {
            int colorForState = colorStateList.getColorForState(m27550a(rFCheckableImageButton), colorStateList.getDefaultColor());
            Drawable mutate = DrawableCompat.wrap(drawable).mutate();
            DrawableCompat.setTintList(mutate, ColorStateList.valueOf(colorForState));
            rFCheckableImageButton.setImageDrawable(mutate);
        }
    }

    /* renamed from: a */
    private int[] m27550a(RFCheckableImageButton rFCheckableImageButton) {
        int[] drawableState = getDrawableState();
        int[] drawableState2 = rFCheckableImageButton.getDrawableState();
        int length = drawableState.length;
        int[] copyOf = Arrays.copyOf(drawableState, drawableState.length + drawableState2.length);
        System.arraycopy(drawableState2, 0, copyOf, length, drawableState2.length);
        return copyOf;
    }

    public Parcelable onSaveInstanceState() {
        SavedState savedState = new SavedState(super.onSaveInstanceState());
        if (this.f36635x.mo94828h()) {
            savedState.error = getError();
        }
        boolean z = true;
        savedState.isOuterEndIconChecked = this.f36630s.getVisibility() == 0 && this.f36630s.isChecked();
        if (this.f36629r.getVisibility() != 0 || !this.f36629r.isChecked()) {
            z = false;
        }
        savedState.isInnerEndIconChecked = z;
        savedState.hintText = getHint();
        savedState.helperText = getHelperText();
        savedState.placeholderText = getPlaceholderText();
        return savedState;
    }

    /* access modifiers changed from: protected */
    public void onRestoreInstanceState(Parcelable parcelable) {
        if (!(parcelable instanceof SavedState)) {
            super.onRestoreInstanceState(parcelable);
            return;
        }
        SavedState savedState = (SavedState) parcelable;
        super.onRestoreInstanceState(savedState.getSuperState());
        setError(savedState.error);
        if (savedState.isOuterEndIconChecked) {
            this.f36630s.post(new Runnable() {
                public void run() {
                    RFTextInputLayout.this.f36630s.performClick();
                    RFTextInputLayout.this.f36630s.jumpDrawablesToCurrentState();
                }
            });
        }
        if (savedState.isInnerEndIconChecked) {
            this.f36629r.post(new Runnable() {
                public void run() {
                    RFTextInputLayout.this.f36629r.performClick();
                    RFTextInputLayout.this.f36629r.jumpDrawablesToCurrentState();
                }
            });
        }
        setHint(savedState.hintText);
        setHelperText(savedState.helperText);
        setPlaceholderText(savedState.placeholderText);
        requestLayout();
    }

    /* access modifiers changed from: protected */
    public void dispatchRestoreInstanceState(SparseArray<Parcelable> sparseArray) {
        this.f36564M = true;
        super.dispatchRestoreInstanceState(sparseArray);
        this.f36564M = false;
    }

    /* renamed from: a */
    private static void m27546a(RFCheckableImageButton rFCheckableImageButton, View.OnClickListener onClickListener, View.OnLongClickListener onLongClickListener) {
        rFCheckableImageButton.setOnClickListener(onClickListener);
        m27555b(rFCheckableImageButton, onLongClickListener);
    }

    /* renamed from: a */
    private static void m27547a(RFCheckableImageButton rFCheckableImageButton, View.OnLongClickListener onLongClickListener) {
        rFCheckableImageButton.setOnLongClickListener(onLongClickListener);
        m27555b(rFCheckableImageButton, onLongClickListener);
    }

    /* renamed from: b */
    private static void m27555b(RFCheckableImageButton rFCheckableImageButton, View.OnLongClickListener onLongClickListener) {
        boolean hasOnClickListeners = ViewCompat.hasOnClickListeners(rFCheckableImageButton);
        boolean z = false;
        int i = 1;
        boolean z2 = onLongClickListener != null;
        if (hasOnClickListeners || z2) {
            z = true;
        }
        rFCheckableImageButton.setFocusable(z);
        rFCheckableImageButton.setClickable(hasOnClickListeners);
        rFCheckableImageButton.setPressed(hasOnClickListeners);
        rFCheckableImageButton.setLongClickable(z2);
        if (!z) {
            i = 2;
        }
        ViewCompat.setImportantForAccessibility(rFCheckableImageButton, i);
    }

    static class SavedState extends AbsSavedState {
        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.ClassLoaderCreator<SavedState>() {
            public SavedState createFromParcel(Parcel parcel, ClassLoader classLoader) {
                return new SavedState(parcel, classLoader);
            }

            public SavedState createFromParcel(Parcel parcel) {
                return new SavedState(parcel, (ClassLoader) null);
            }

            public SavedState[] newArray(int i) {
                return new SavedState[i];
            }
        };
        CharSequence error;
        CharSequence helperText;
        CharSequence hintText;
        boolean isInnerEndIconChecked;
        boolean isOuterEndIconChecked;
        CharSequence placeholderText;

        SavedState(Parcelable parcelable) {
            super(parcelable);
        }

        SavedState(Parcel parcel, ClassLoader classLoader) {
            super(parcel, classLoader);
            this.error = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            boolean z = false;
            this.isOuterEndIconChecked = parcel.readInt() == 1;
            this.hintText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.helperText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.placeholderText = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.isInnerEndIconChecked = parcel.readInt() == 1 ? true : z;
        }

        public void writeToParcel(Parcel parcel, int i) {
            super.writeToParcel(parcel, i);
            TextUtils.writeToParcel(this.error, parcel, i);
            parcel.writeInt(this.isOuterEndIconChecked ? 1 : 0);
            TextUtils.writeToParcel(this.hintText, parcel, i);
            TextUtils.writeToParcel(this.helperText, parcel, i);
            TextUtils.writeToParcel(this.placeholderText, parcel, i);
            parcel.writeInt(this.isInnerEndIconChecked ? 1 : 0);
        }

        public String toString() {
            return "RFTextInputLayout.SavedState{" + Integer.toHexString(System.identityHashCode(this)) + " error=" + this.error + " hint=" + this.hintText + " helperText=" + this.helperText + " placeholderText=" + this.placeholderText + "}";
        }
    }

    public static class AccessibilityDelegate extends AccessibilityDelegateCompat {
        private final RFTextInputLayout layout;

        public AccessibilityDelegate(RFTextInputLayout rFTextInputLayout) {
            this.layout = rFTextInputLayout;
        }

        public void onInitializeAccessibilityNodeInfo(View view, AccessibilityNodeInfoCompat accessibilityNodeInfoCompat) {
            super.onInitializeAccessibilityNodeInfo(view, accessibilityNodeInfoCompat);
            EditText editText = this.layout.getEditText();
            Editable text = editText != null ? editText.getText() : null;
            CharSequence hint = this.layout.getHint();
            CharSequence error = this.layout.getError();
            CharSequence placeholderText = this.layout.getPlaceholderText();
            int counterMaxLength = this.layout.getCounterMaxLength();
            CharSequence counterOverflowDescription = this.layout.getCounterOverflowDescription();
            boolean z = !TextUtils.isEmpty(text);
            boolean z2 = !TextUtils.isEmpty(hint);
            boolean z3 = !this.layout.mo94703d();
            boolean z4 = !TextUtils.isEmpty(error);
            boolean z5 = z4 || !TextUtils.isEmpty(counterOverflowDescription);
            String charSequence = z2 ? hint.toString() : "";
            if (z) {
                accessibilityNodeInfoCompat.setText(text);
            } else if (!TextUtils.isEmpty(charSequence)) {
                accessibilityNodeInfoCompat.setText(charSequence);
                if (z3 && placeholderText != null) {
                    accessibilityNodeInfoCompat.setText(charSequence + ", " + placeholderText);
                }
            } else if (placeholderText != null) {
                accessibilityNodeInfoCompat.setText(placeholderText);
            }
            if (!TextUtils.isEmpty(charSequence)) {
                if (Build.VERSION.SDK_INT >= 26) {
                    accessibilityNodeInfoCompat.setHintText(charSequence);
                } else {
                    if (z) {
                        charSequence = text + ", " + charSequence;
                    }
                    accessibilityNodeInfoCompat.setText(charSequence);
                }
                accessibilityNodeInfoCompat.setShowingHintText(!z);
            }
            if (text == null || text.length() != counterMaxLength) {
                counterMaxLength = -1;
            }
            accessibilityNodeInfoCompat.setMaxTextLength(counterMaxLength);
            if (z5) {
                if (!z4) {
                    error = counterOverflowDescription;
                }
                accessibilityNodeInfoCompat.setError(error);
            }
        }
    }
}
