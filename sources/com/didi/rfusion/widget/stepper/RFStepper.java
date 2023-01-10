package com.didi.rfusion.widget.stepper;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.passenger.C11267R;
import com.didi.rfusion.utils.RFResUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.rfusion.widget.RFTextView;
import com.taxis99.R;

public class RFStepper extends ConstraintLayout {

    /* renamed from: a */
    private static final String f36481a = "RFStepper";

    /* renamed from: b */
    private static final int f36482b = 0;

    /* renamed from: c */
    private static final int f36483c = 999;

    /* renamed from: d */
    private static final int f36484d = 1;

    /* renamed from: e */
    private static final int f36485e = 1;

    /* renamed from: f */
    private static final int f36486f = 999;

    /* renamed from: g */
    private static final int f36487g = 1;

    /* renamed from: h */
    private static final int f36488h = -1;

    /* renamed from: i */
    private RFIconView f36489i;

    /* renamed from: j */
    private RFTextView f36490j;

    /* renamed from: k */
    private RFIconView f36491k;

    /* renamed from: l */
    private FrameLayout f36492l;

    /* renamed from: m */
    private FrameLayout f36493m;

    /* renamed from: n */
    private OnStepperChangedListener f36494n;

    /* renamed from: o */
    private int f36495o;

    /* renamed from: p */
    private int f36496p;

    /* renamed from: q */
    private int f36497q;

    /* renamed from: r */
    private int f36498r;

    /* renamed from: s */
    private int f36499s;

    /* renamed from: t */
    private boolean f36500t;

    /* renamed from: u */
    private boolean f36501u;

    public static abstract class OnStepperChangedListener {
        public abstract void onStepperChanged(int i, int i2, int i3);

        public boolean onStepperIntercepted(int i, int i2, int i3) {
            return false;
        }
    }

    public RFStepper(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFStepper(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public RFStepper(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36496p = 1;
        this.f36497q = 999;
        this.f36500t = true;
        this.f36501u = true;
        m27471a();
        m27474a(attributeSet);
    }

    /* renamed from: a */
    private void m27471a() {
        LayoutInflater.from(getContext()).inflate(R.layout.rf_stepper, this);
        this.f36489i = (RFIconView) findViewById(R.id.rf_tv_minus);
        this.f36491k = (RFIconView) findViewById(R.id.rf_tv_plus);
        this.f36490j = (RFTextView) findViewById(R.id.rf_tv_value);
        this.f36489i.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RFStepper.this.m27477b(view);
            }
        });
        this.f36491k.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                RFStepper.this.m27475a(view);
            }
        });
        m27476b();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m27477b(View view) {
        m27473a(1, getCurValue() - getStepValue(), true, true);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m27475a(View view) {
        m27473a(2, getCurValue() + getStepValue(), true, true);
    }

    /* renamed from: b */
    private void m27476b() {
        this.f36492l = (FrameLayout) findViewById(R.id.rf_fl_minus_hot_space);
        this.f36493m = (FrameLayout) findViewById(R.id.rf_fl_plus_hot_space);
        post(new Runnable() {
            public final void run() {
                RFStepper.this.m27479d();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public /* synthetic */ void m27479d() {
        Rect rect = new Rect();
        Rect rect2 = new Rect();
        rect.set(0, 0, this.f36492l.getWidth(), this.f36492l.getHeight());
        rect2.set(0, 0, this.f36493m.getWidth(), this.f36493m.getHeight());
        this.f36492l.setTouchDelegate(new TouchDelegate(rect, this.f36489i));
        this.f36493m.setTouchDelegate(new TouchDelegate(rect2, this.f36491k));
    }

    /* renamed from: a */
    private void m27474a(AttributeSet attributeSet) {
        TypedArray obtainStyledAttributes = getContext().obtainStyledAttributes(attributeSet, C11267R.styleable.RFStepper);
        int i = obtainStyledAttributes.getInt(7, 1);
        int i2 = obtainStyledAttributes.getInt(5, 1);
        int i3 = obtainStyledAttributes.getInt(4, 999);
        int i4 = obtainStyledAttributes.getInt(0, -1);
        int i5 = obtainStyledAttributes.getInt(6, 1);
        boolean z = obtainStyledAttributes.getBoolean(3, true);
        boolean z2 = obtainStyledAttributes.getBoolean(1, true);
        boolean z3 = obtainStyledAttributes.getBoolean(2, true);
        obtainStyledAttributes.recycle();
        if (i4 < 0) {
            i4 = i2;
        }
        m27472a(i);
        setStepValue(i5);
        setDefaultValue(i4);
        setMinValue(i2);
        setMaxValue(i3);
        setEnabled(z);
        setEnableMinusAction(z2);
        setEnablePlusAction(z3);
    }

    public void setEnabled(boolean z) {
        super.setEnabled(z);
        m27478c();
    }

    public void setEnablePlusAction(boolean z) {
        this.f36500t = z;
        m27478c();
    }

    public boolean isEnablePlusAction() {
        return this.f36500t;
    }

    public void setEnableMinusAction(boolean z) {
        this.f36501u = z;
        m27478c();
    }

    public boolean isEnableMinusAction() {
        return this.f36501u;
    }

    public void setSpec(int i) {
        if (this.f36495o != i) {
            m27472a(i);
        }
    }

    public void setMinValue(int i) {
        int a = m27470a(i, true);
        this.f36496p = a;
        if (a > this.f36498r) {
            m27473a(0, a, true, false);
        }
        m27478c();
    }

    public int getMinValue() {
        return this.f36496p;
    }

    public void setMaxValue(int i) {
        int a = m27470a(i, false);
        this.f36497q = a;
        if (a < this.f36498r) {
            m27473a(0, a, true, false);
        }
        m27478c();
    }

    public int getMaxValue() {
        return this.f36497q;
    }

    public void setStepValue(int i) {
        this.f36499s = i;
        m27478c();
    }

    public int getStepValue() {
        return this.f36499s;
    }

    public void setCurValue(int i) {
        setCurValue(i, true);
    }

    public void setCurValue(int i, boolean z) {
        m27473a(0, i, z, true);
    }

    /* renamed from: a */
    private void m27473a(int i, int i2, boolean z, boolean z2) {
        OnStepperChangedListener onStepperChangedListener;
        int i3 = this.f36498r;
        if (i3 != i2) {
            int max = Math.max(this.f36496p, Math.min(this.f36497q, i2));
            if (!z || (onStepperChangedListener = this.f36494n) == null) {
                this.f36498r = max;
                RFTextView rFTextView = this.f36490j;
                rFTextView.setText("" + this.f36498r);
            } else {
                if (z2) {
                    z2 = onStepperChangedListener.onStepperIntercepted(i, i3, max);
                }
                if (!z2) {
                    this.f36498r = max;
                    RFTextView rFTextView2 = this.f36490j;
                    rFTextView2.setText("" + this.f36498r);
                    this.f36494n.onStepperChanged(i, i3, this.f36498r);
                }
            }
            m27478c();
        }
    }

    public int getCurValue() {
        return this.f36498r;
    }

    public void setOnStepperChangedListener(OnStepperChangedListener onStepperChangedListener) {
        this.f36494n = onStepperChangedListener;
    }

    /* renamed from: a */
    private void m27472a(int i) {
        int i2;
        int i3;
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f36490j.getLayoutParams();
        ViewGroup.LayoutParams layoutParams = this.f36492l.getLayoutParams();
        ViewGroup.LayoutParams layoutParams2 = this.f36493m.getLayoutParams();
        if (i == 0) {
            i2 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_operation_size_large);
            marginLayoutParams.width = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_size_large);
            marginLayoutParams.leftMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_margin_width_large);
            marginLayoutParams.rightMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_margin_width_large);
            i3 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_operation_hot_space_width_large);
            this.f36490j.setTextSize(0, RFResUtils.getDimens(getContext(), R.dimen.f_04_app_48_pad_32));
        } else {
            i2 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_operation_size_small);
            marginLayoutParams.width = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_size_small);
            marginLayoutParams.leftMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_margin_width_small);
            marginLayoutParams.rightMargin = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_content_margin_width_small);
            i3 = (int) RFResUtils.getDimens(getContext(), R.dimen.rf_stepper_operation_hot_space_width_small);
            this.f36490j.setTextSize(0, RFResUtils.getDimens(getContext(), R.dimen.f_07_app_36_pad_24));
        }
        layoutParams.width = i3;
        layoutParams.height = i2;
        this.f36492l.setLayoutParams(layoutParams);
        layoutParams2.width = i3;
        layoutParams2.height = i2;
        this.f36493m.setLayoutParams(layoutParams2);
        float f = (float) i2;
        this.f36489i.setTextSize(0, f);
        this.f36491k.setTextSize(0, f);
        this.f36495o = i;
    }

    private void setDefaultValue(int i) {
        this.f36498r = i;
        RFTextView rFTextView = this.f36490j;
        rFTextView.setText("" + this.f36498r);
    }

    /* renamed from: a */
    private int m27470a(int i, boolean z) {
        int i2;
        int max = Math.max(0, Math.min(999, i));
        if (z) {
            i2 = this.f36497q;
            if (max <= i2) {
                return max;
            }
        } else {
            i2 = this.f36496p;
            if (max >= i2) {
                return max;
            }
        }
        return i2;
    }

    /* renamed from: c */
    private void m27478c() {
        boolean z = false;
        if (!isEnabled()) {
            this.f36489i.setEnabled(false);
            this.f36491k.setEnabled(false);
            this.f36490j.setEnabled(false);
            return;
        }
        if (this.f36501u) {
            this.f36489i.setEnabled(this.f36498r - this.f36499s >= this.f36496p);
        } else {
            this.f36489i.setEnabled(false);
        }
        if (this.f36500t) {
            RFIconView rFIconView = this.f36491k;
            if (this.f36498r + this.f36499s <= this.f36497q) {
                z = true;
            }
            rFIconView.setEnabled(z);
            return;
        }
        this.f36491k.setEnabled(false);
    }
}
