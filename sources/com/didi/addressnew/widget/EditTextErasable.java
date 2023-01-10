package com.didi.addressnew.widget;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.animation.Animation;
import android.view.animation.CycleInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.TextView;
import androidx.appcompat.widget.AppCompatEditText;
import com.didi.addressnew.util.ViewUtils;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;

public class EditTextErasable extends AppCompatEditText implements TextWatcher {

    /* renamed from: a */
    ArrayList<TextWatcher> f9482a;

    /* renamed from: b */
    private Drawable f9483b;

    /* renamed from: c */
    private OnClearListener f9484c;

    /* renamed from: d */
    private boolean f9485d;

    public interface OnClearListener {
        void onClear(String str);
    }

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public EditTextErasable(Context context) {
        this(context, (AttributeSet) null);
    }

    public EditTextErasable(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 16842862);
    }

    public EditTextErasable(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f9482a = new ArrayList<>(2);
        this.f9484c = null;
        this.f9485d = false;
        m8233a();
    }

    public void setOnClearListener(OnClearListener onClearListener) {
        this.f9484c = onClearListener;
    }

    /* renamed from: a */
    private void m8233a() {
        setPadding(getPaddingStart(), getPaddingTop(), getPaddingEnd() + getDrawablePadding(), getPaddingBottom());
        this.f9483b = getResources().getDrawable(R.drawable.poi_one_address_edittext_delete);
        int dip2px = ViewUtils.dip2px(getContext(), (float) 16);
        this.f9483b.setBounds(0, 0, dip2px, dip2px);
        setClearIconVisible(false);
        addTextChangedListener(this);
        setHighlightColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_normal_hint));
        setCompoundDrawablePadding(getDefaultDrawablePadding());
    }

    /* renamed from: a */
    private boolean m8234a(MotionEvent motionEvent) {
        if (ViewUtils.isRTL()) {
            return ((float) (getLeft() + (getDrawablePadding() + (this.f9483b.getIntrinsicWidth() * 3)))) > motionEvent.getX();
        }
        return ((float) (getRight() - (getDrawablePadding() + (this.f9483b.getIntrinsicWidth() * 3)))) < motionEvent.getX();
    }

    private int getDrawablePadding() {
        return Math.round(Resources.getSystem().getDisplayMetrics().density * 10.0f);
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (m8234a(motionEvent)) {
            if (motionEvent.getAction() == 0) {
                this.f9485d = true;
            }
            if (this.f9485d && motionEvent.getAction() == 1) {
                if (this.f9484c != null && isClearIconVisible()) {
                    this.f9484c.onClear(getText() != null ? getText().toString() : "");
                    setText("");
                }
                setClearIconVisible(false);
            }
            if (motionEvent.getAction() == 1 || motionEvent.getAction() == 3) {
                this.f9485d = false;
            }
            return true;
        }
        try {
            return super.onTouchEvent(motionEvent);
        } catch (Exception e) {
            SystemUtils.log(6, "sfs", "onTouchEvent() EditTextErasable err msg: " + e.getMessage(), (Throwable) null, "com.didi.addressnew.widget.EditTextErasable", 114);
            return false;
        }
    }

    public void setClearIconVisible(boolean z) {
        Drawable drawable = z ? this.f9483b : null;
        if (ViewUtils.isRTL()) {
            Drawable endDrawable = getEndDrawable();
            if (endDrawable != null) {
                setCompoundDrawables(drawable, getCompoundDrawables()[1], endDrawable, getCompoundDrawables()[3]);
                setCompoundDrawablePadding(getDefaultDrawablePadding());
                return;
            }
            return;
        }
        Drawable startDrawable = getStartDrawable();
        if (startDrawable != null) {
            setCompoundDrawables(startDrawable, getCompoundDrawables()[1], drawable, getCompoundDrawables()[3]);
            setCompoundDrawablePadding(getDefaultDrawablePadding());
        }
    }

    public boolean isClearIconVisible() {
        Drawable drawable;
        if (ViewUtils.isRTL()) {
            drawable = getStartDrawable();
        } else {
            drawable = getEndDrawable();
        }
        return drawable != null;
    }

    public Drawable getStartDrawable() {
        return getCompoundDrawables()[0];
    }

    public Drawable getEndDrawable() {
        return getCompoundDrawables()[2];
    }

    public void setText(String str) {
        super.setText(str, TextView.BufferType.EDITABLE);
    }

    /* access modifiers changed from: protected */
    public void onFocusChanged(boolean z, int i, Rect rect) {
        try {
            super.onFocusChanged(z, i, rect);
        } catch (Exception e) {
            SystemUtils.log(6, "sfs", "onFocusChanged() EditTextErasable err msg: " + e.getMessage(), (Throwable) null, "com.didi.addressnew.widget.EditTextErasable", 168);
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        if (hasFocus()) {
            setClearIconVisible(charSequence.length() > 0);
        }
    }

    public void setShakeAnimation() {
        setAnimation(shakeAnimation(5));
    }

    public static Animation shakeAnimation(int i) {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 10.0f, 0.0f, 0.0f);
        translateAnimation.setInterpolator(new CycleInterpolator((float) i));
        translateAnimation.setDuration(1000);
        return translateAnimation;
    }

    public void addTextChangedListener(TextWatcher textWatcher) {
        if (!this.f9482a.contains(textWatcher)) {
            super.addTextChangedListener(textWatcher);
            this.f9482a.add(textWatcher);
        }
    }

    public void removeTextChangedListener(TextWatcher textWatcher) {
        super.removeTextChangedListener(textWatcher);
        this.f9482a.remove(textWatcher);
    }

    public boolean requestFocus(int i, Rect rect) {
        return super.requestFocus(i, rect);
    }

    private int getDefaultDrawablePadding() {
        return ViewUtils.dip2px(getContext(), 10.0f);
    }
}
