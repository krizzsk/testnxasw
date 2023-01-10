package com.didi.component.common.widget;

import android.content.Context;
import android.content.res.Resources;
import android.content.res.TypedArray;
import android.os.Build;
import android.text.Editable;
import android.text.Layout;
import android.text.StaticLayout;
import android.text.TextPaint;
import android.text.TextWatcher;
import android.text.method.SingleLineTransformationMethod;
import android.text.method.TransformationMethod;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.View;
import android.widget.TextView;
import com.didi.passenger.C11267R;
import java.util.ArrayList;
import java.util.Iterator;

public class AutofitHelper {

    /* renamed from: a */
    private static final String f13759a = "AutoFitTextHelper";

    /* renamed from: b */
    private static final boolean f13760b = false;

    /* renamed from: c */
    private static final int f13761c = 8;

    /* renamed from: d */
    private static final float f13762d = 0.5f;

    /* renamed from: e */
    private TextView f13763e;

    /* renamed from: f */
    private TextPaint f13764f;

    /* renamed from: g */
    private float f13765g;

    /* renamed from: h */
    private int f13766h;

    /* renamed from: i */
    private float f13767i;

    /* renamed from: j */
    private float f13768j;

    /* renamed from: k */
    private float f13769k;

    /* renamed from: l */
    private boolean f13770l;

    /* renamed from: m */
    private boolean f13771m;

    /* renamed from: n */
    private ArrayList<OnTextSizeChangeListener> f13772n;

    /* renamed from: o */
    private TextWatcher f13773o = new AutofitTextWatcher();

    /* renamed from: p */
    private View.OnLayoutChangeListener f13774p = new AutofitOnLayoutChangeListener();

    public interface OnTextSizeChangeListener {
        void onTextSizeChange(float f, float f2);
    }

    public static AutofitHelper create(TextView textView) {
        return create(textView, (AttributeSet) null, 0);
    }

    public static AutofitHelper create(TextView textView, AttributeSet attributeSet) {
        return create(textView, attributeSet, 0);
    }

    public static AutofitHelper create(TextView textView, AttributeSet attributeSet, int i) {
        AutofitHelper autofitHelper = new AutofitHelper(textView);
        boolean z = true;
        if (attributeSet != null) {
            Context context = textView.getContext();
            float precision = autofitHelper.getPrecision();
            TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C11267R.styleable.AutofitTextView, i, 0);
            boolean z2 = obtainStyledAttributes.getBoolean(2, true);
            int dimensionPixelSize = obtainStyledAttributes.getDimensionPixelSize(0, (int) autofitHelper.getMinTextSize());
            float f = obtainStyledAttributes.getFloat(1, precision);
            obtainStyledAttributes.recycle();
            autofitHelper.setMinTextSize(0, (float) dimensionPixelSize).setPrecision(f);
            z = z2;
        }
        autofitHelper.setEnabled(z);
        return autofitHelper;
    }

    /* renamed from: a */
    private static void m11443a(TextView textView, TextPaint textPaint, float f, float f2, int i, float f3) {
        if (i > 0 && i != Integer.MAX_VALUE) {
            final TextView textView2 = textView;
            final float f4 = f2;
            final TextPaint textPaint2 = textPaint;
            final int i2 = i;
            final float f5 = f3;
            final float f6 = f;
            textView.post(new Runnable() {
                public void run() {
                    int width = (textView2.getWidth() - textView2.getPaddingLeft()) - textView2.getPaddingRight();
                    if (width > 0) {
                        CharSequence text = textView2.getText();
                        TransformationMethod transformationMethod = textView2.getTransformationMethod();
                        if (transformationMethod != null) {
                            text = transformationMethod.getTransformation(text, textView2);
                        }
                        CharSequence charSequence = text;
                        Context context = textView2.getContext();
                        Resources system = Resources.getSystem();
                        float f = f4;
                        if (context != null) {
                            system = context.getResources();
                        }
                        DisplayMetrics displayMetrics = system.getDisplayMetrics();
                        textPaint2.set(textView2.getPaint());
                        textPaint2.setTextSize(f);
                        if ((i2 == 1 && textPaint2.measureText(charSequence, 0, charSequence.length()) > ((float) width)) || AutofitHelper.m11446b(charSequence, textPaint2, f, (float) width, displayMetrics) > i2) {
                            f = AutofitHelper.m11445b(charSequence, textPaint2, (float) width, i2, 0.0f, f, f5, displayMetrics);
                        }
                        float f2 = f6;
                        if (f < f2) {
                            f = f2;
                        }
                        textView2.setTextSize(0, f);
                    }
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static float m11445b(CharSequence charSequence, TextPaint textPaint, float f, int i, float f2, float f3, float f4, DisplayMetrics displayMetrics) {
        StaticLayout staticLayout;
        int i2;
        float f5;
        TextPaint textPaint2 = textPaint;
        float f6 = f;
        int i3 = i;
        float f7 = (f2 + f3) / 2.0f;
        textPaint2.setTextSize(TypedValue.applyDimension(0, f7, displayMetrics));
        if (i3 != 1) {
            staticLayout = new StaticLayout(charSequence, textPaint, (int) f6, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true);
            i2 = staticLayout.getLineCount();
        } else {
            staticLayout = null;
            i2 = 1;
        }
        if (i2 > i3) {
            return f3 - f2 < f4 ? f2 : m11445b(charSequence, textPaint, f, i, f2, f7, f4, displayMetrics);
        }
        if (i2 < i3) {
            return m11445b(charSequence, textPaint, f, i, f7, f3, f4, displayMetrics);
        }
        float f8 = 0.0f;
        if (i3 == 1) {
            f5 = textPaint2.measureText(charSequence, 0, charSequence.length());
        } else {
            CharSequence charSequence2 = charSequence;
            for (int i4 = 0; i4 < i2; i4++) {
                if (staticLayout.getLineWidth(i4) > f8) {
                    f8 = staticLayout.getLineWidth(i4);
                }
            }
            f5 = f8;
        }
        if (f3 - f2 < f4) {
            return f2;
        }
        if (f5 > f6) {
            return m11445b(charSequence, textPaint, f, i, f2, f7, f4, displayMetrics);
        }
        return f5 < f6 ? m11445b(charSequence, textPaint, f, i, f7, f3, f4, displayMetrics) : f7;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static int m11446b(CharSequence charSequence, TextPaint textPaint, float f, float f2, DisplayMetrics displayMetrics) {
        textPaint.setTextSize(TypedValue.applyDimension(0, f, displayMetrics));
        return new StaticLayout(charSequence, textPaint, (int) f2, Layout.Alignment.ALIGN_NORMAL, 1.0f, 0.0f, true).getLineCount();
    }

    /* renamed from: a */
    private static int m11438a(TextView textView) {
        TransformationMethod transformationMethod = textView.getTransformationMethod();
        if (transformationMethod != null && (transformationMethod instanceof SingleLineTransformationMethod)) {
            return 1;
        }
        if (Build.VERSION.SDK_INT >= 16) {
            return textView.getMaxLines();
        }
        return -1;
    }

    private AutofitHelper(TextView textView) {
        float f = textView.getContext().getResources().getDisplayMetrics().scaledDensity;
        this.f13763e = textView;
        this.f13764f = new TextPaint();
        m11448c(textView.getTextSize());
        this.f13766h = m11438a(textView);
        this.f13767i = f * 8.0f;
        this.f13768j = this.f13765g;
        this.f13769k = 0.5f;
    }

    public AutofitHelper addOnTextSizeChangeListener(OnTextSizeChangeListener onTextSizeChangeListener) {
        if (this.f13772n == null) {
            this.f13772n = new ArrayList<>();
        }
        this.f13772n.add(onTextSizeChangeListener);
        return this;
    }

    public AutofitHelper removeOnTextSizeChangeListener(OnTextSizeChangeListener onTextSizeChangeListener) {
        ArrayList<OnTextSizeChangeListener> arrayList = this.f13772n;
        if (arrayList != null) {
            arrayList.remove(onTextSizeChangeListener);
        }
        return this;
    }

    public float getPrecision() {
        return this.f13769k;
    }

    public AutofitHelper setPrecision(float f) {
        if (this.f13769k != f) {
            this.f13769k = f;
            m11440a();
        }
        return this;
    }

    public float getMinTextSize() {
        return this.f13767i;
    }

    public AutofitHelper setMinTextSize(float f) {
        return setMinTextSize(2, f);
    }

    public AutofitHelper setMinTextSize(int i, float f) {
        Context context = this.f13763e.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        m11441a(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    /* renamed from: a */
    private void m11441a(float f) {
        if (f != this.f13767i) {
            this.f13767i = f;
            m11440a();
        }
    }

    public float getMaxTextSize() {
        return this.f13768j;
    }

    public AutofitHelper setMaxTextSize(float f) {
        return setMaxTextSize(2, f);
    }

    public AutofitHelper setMaxTextSize(int i, float f) {
        Context context = this.f13763e.getContext();
        Resources system = Resources.getSystem();
        if (context != null) {
            system = context.getResources();
        }
        m11447b(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        return this;
    }

    /* renamed from: b */
    private void m11447b(float f) {
        if (f != this.f13768j) {
            this.f13768j = f;
            m11440a();
        }
    }

    public int getMaxLines() {
        return this.f13766h;
    }

    public AutofitHelper setMaxLines(int i) {
        if (this.f13766h != i) {
            this.f13766h = i;
            m11440a();
        }
        return this;
    }

    public boolean isEnabled() {
        return this.f13770l;
    }

    public AutofitHelper setEnabled(boolean z) {
        if (this.f13770l != z) {
            this.f13770l = z;
            if (z) {
                this.f13763e.addTextChangedListener(this.f13773o);
                this.f13763e.addOnLayoutChangeListener(this.f13774p);
                m11440a();
            } else {
                this.f13763e.removeTextChangedListener(this.f13773o);
                this.f13763e.removeOnLayoutChangeListener(this.f13774p);
                this.f13763e.setTextSize(0, this.f13765g);
            }
        }
        return this;
    }

    public float getTextSize() {
        return this.f13765g;
    }

    public void setTextSize(float f) {
        setTextSize(2, f);
    }

    public void setTextSize(int i, float f) {
        if (!this.f13771m) {
            Context context = this.f13763e.getContext();
            Resources system = Resources.getSystem();
            if (context != null) {
                system = context.getResources();
            }
            m11448c(TypedValue.applyDimension(i, f, system.getDisplayMetrics()));
        }
    }

    /* renamed from: c */
    private void m11448c(float f) {
        if (this.f13765g != f) {
            this.f13765g = f;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11440a() {
        float textSize = this.f13763e.getTextSize();
        this.f13771m = true;
        m11443a(this.f13763e, this.f13764f, this.f13767i, this.f13768j, this.f13766h, this.f13769k);
        this.f13771m = false;
        float textSize2 = this.f13763e.getTextSize();
        if (textSize2 != textSize) {
            m11442a(textSize2, textSize);
        }
    }

    /* renamed from: a */
    private void m11442a(float f, float f2) {
        ArrayList<OnTextSizeChangeListener> arrayList = this.f13772n;
        if (arrayList != null) {
            Iterator<OnTextSizeChangeListener> it = arrayList.iterator();
            while (it.hasNext()) {
                it.next().onTextSizeChange(f, f2);
            }
        }
    }

    private class AutofitTextWatcher implements TextWatcher {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        private AutofitTextWatcher() {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            AutofitHelper.this.m11440a();
        }
    }

    private class AutofitOnLayoutChangeListener implements View.OnLayoutChangeListener {
        private AutofitOnLayoutChangeListener() {
        }

        public void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
            AutofitHelper.this.m11440a();
        }
    }
}
