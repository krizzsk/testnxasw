package com.didiglobal.comp.carmodellist.button;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.view.autofill.AutofillValue;
import android.widget.LinearLayout;
import com.didiglobal.comp.carmodellist.button.AnyCarRadioButtonView;
import java.util.List;

public class AnyCarRadioButton extends LinearLayout {

    /* renamed from: a */
    private static final String f52343a = AnyCarRadioButton.class.getSimpleName();

    /* renamed from: b */
    private Context f52344b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f52345c = -1;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public AnyCarRadioButtonView.OnCheckedChangeListener f52346d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f52347e = false;

    /* renamed from: f */
    private OnCheckedChangeListener f52348f;

    /* renamed from: g */
    private PassThroughHierarchyChangeListener f52349g;

    /* renamed from: h */
    private boolean f52350h;

    public interface OnCheckedChangeListener {
        void onCheckedChanged(AnyCarRadioButton anyCarRadioButton, AnyCarRadioButtonView anyCarRadioButtonView, int i);
    }

    public AnyCarRadioButton(Context context) {
        super(context);
        this.f52344b = context;
        m39349a();
    }

    public AnyCarRadioButton(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f52344b = context;
        m39349a();
    }

    /* renamed from: a */
    private void m39349a() {
        this.f52346d = new CheckedStateTracker();
        PassThroughHierarchyChangeListener passThroughHierarchyChangeListener = new PassThroughHierarchyChangeListener();
        this.f52349g = passThroughHierarchyChangeListener;
        super.setOnHierarchyChangeListener(passThroughHierarchyChangeListener);
    }

    public void setOnHierarchyChangeListener(ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener) {
        ViewGroup.OnHierarchyChangeListener unused = this.f52349g.mOnHierarchyChangeListener = onHierarchyChangeListener;
    }

    /* access modifiers changed from: protected */
    public void onFinishInflate() {
        super.onFinishInflate();
        int i = this.f52345c;
        if (i != -1) {
            this.f52347e = true;
            m39350a(i, true);
            this.f52347e = false;
            m39353a((AnyCarRadioButtonView) null, this.f52345c);
        }
    }

    public void addView(View view, int i, ViewGroup.LayoutParams layoutParams) {
        if (view instanceof AnyCarRadioButtonView) {
            AnyCarRadioButtonView anyCarRadioButtonView = (AnyCarRadioButtonView) view;
            if (anyCarRadioButtonView.isChecked()) {
                this.f52347e = true;
                int i2 = this.f52345c;
                if (i2 != -1) {
                    m39350a(i2, false);
                }
                this.f52347e = false;
                m39353a(anyCarRadioButtonView, anyCarRadioButtonView.getId());
            }
        }
        super.addView(view, i, layoutParams);
    }

    public void setRadioViewList(List<AnyCarRadioButtonView> list) {
        if (list == null || list.size() == 0) {
            throw new IllegalArgumentException("AnyCarRadioButton must have children !");
        }
        for (int i = 0; i < list.size(); i++) {
            AnyCarRadioButtonView anyCarRadioButtonView = list.get(i);
            if (anyCarRadioButtonView.getExtLayoutParams() == null) {
                addView(anyCarRadioButtonView);
            } else {
                addView(anyCarRadioButtonView, anyCarRadioButtonView.getExtLayoutParams());
            }
        }
    }

    public void check(int i) {
        if (i == -1 || i != this.f52345c) {
            int i2 = this.f52345c;
            if (i2 != -1) {
                m39350a(i2, false);
            }
            if (i != -1) {
                m39350a(i, true);
            }
            m39353a((AnyCarRadioButtonView) null, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39353a(AnyCarRadioButtonView anyCarRadioButtonView, int i) {
        this.f52345c = i;
        OnCheckedChangeListener onCheckedChangeListener = this.f52348f;
        if (onCheckedChangeListener != null) {
            if (anyCarRadioButtonView != null) {
                onCheckedChangeListener.onCheckedChanged(this, anyCarRadioButtonView, i);
                return;
            }
            View findViewById = findViewById(i);
            if (findViewById != null && (findViewById instanceof AnyCarRadioButtonView)) {
                this.f52348f.onCheckedChanged(this, (AnyCarRadioButtonView) findViewById, this.f52345c);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m39350a(int i, boolean z) {
        View findViewById = findViewById(i);
        if (findViewById != null && (findViewById instanceof AnyCarRadioButtonView)) {
            ((AnyCarRadioButtonView) findViewById).setChecked(z);
        }
    }

    public int getCheckedRadioButtonId() {
        return this.f52345c;
    }

    public void clearCheck() {
        check(-1);
    }

    public void setDisable(boolean z) {
        this.f52350h = z;
        setChildRadioBtnDisable(z);
    }

    private void setChildRadioBtnDisable(boolean z) {
        int childCount = getChildCount();
        if (childCount > 0) {
            for (int i = 0; i < childCount; i++) {
                View childAt = getChildAt(i);
                if (childAt instanceof AnyCarRadioButtonView) {
                    ((AnyCarRadioButtonView) childAt).setDisable(z);
                }
            }
        }
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.f52348f = onCheckedChangeListener;
    }

    public LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return new LayoutParams(getContext(), attributeSet);
    }

    /* access modifiers changed from: protected */
    public boolean checkLayoutParams(ViewGroup.LayoutParams layoutParams) {
        return layoutParams instanceof LayoutParams;
    }

    /* access modifiers changed from: protected */
    public LinearLayout.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(-2, -2);
    }

    public CharSequence getAccessibilityClassName() {
        return AnyCarRadioButton.class.getName();
    }

    public static class LayoutParams extends LinearLayout.LayoutParams {
        public LayoutParams(Context context, AttributeSet attributeSet) {
            super(context, attributeSet);
        }

        public LayoutParams(int i, int i2) {
            super(i, i2);
        }

        public LayoutParams(int i, int i2, float f) {
            super(i, i2, f);
        }

        public LayoutParams(ViewGroup.LayoutParams layoutParams) {
            super(layoutParams);
        }

        public LayoutParams(ViewGroup.MarginLayoutParams marginLayoutParams) {
            super(marginLayoutParams);
        }

        /* access modifiers changed from: protected */
        public void setBaseAttributes(TypedArray typedArray, int i, int i2) {
            if (typedArray.hasValue(i)) {
                this.width = typedArray.getLayoutDimension(i, "layout_width");
            } else {
                this.width = -2;
            }
            if (typedArray.hasValue(i2)) {
                this.height = typedArray.getLayoutDimension(i2, "layout_height");
            } else {
                this.height = -2;
            }
        }
    }

    private class CheckedStateTracker implements AnyCarRadioButtonView.OnCheckedChangeListener {
        private CheckedStateTracker() {
        }

        public void onCheckedChanged(AnyCarRadioButtonView anyCarRadioButtonView, boolean z) {
            if (!AnyCarRadioButton.this.f52347e) {
                boolean unused = AnyCarRadioButton.this.f52347e = true;
                if (AnyCarRadioButton.this.f52345c != -1) {
                    AnyCarRadioButton anyCarRadioButton = AnyCarRadioButton.this;
                    anyCarRadioButton.m39350a(anyCarRadioButton.f52345c, false);
                }
                boolean unused2 = AnyCarRadioButton.this.f52347e = false;
                AnyCarRadioButton.this.m39353a(anyCarRadioButtonView, anyCarRadioButtonView.getId());
            }
        }
    }

    private class PassThroughHierarchyChangeListener implements ViewGroup.OnHierarchyChangeListener {
        /* access modifiers changed from: private */
        public ViewGroup.OnHierarchyChangeListener mOnHierarchyChangeListener;

        private PassThroughHierarchyChangeListener() {
        }

        public void onChildViewAdded(View view, View view2) {
            if (view == AnyCarRadioButton.this && (view2 instanceof AnyCarRadioButtonView)) {
                if (view2.getId() == -1) {
                    view2.setId(View.generateViewId());
                }
                ((AnyCarRadioButtonView) view2).setOnCheckedChangeWidgetListener(AnyCarRadioButton.this.f52346d);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewAdded(view, view2);
            }
        }

        public void onChildViewRemoved(View view, View view2) {
            if (view == AnyCarRadioButton.this && (view2 instanceof AnyCarRadioButtonView)) {
                ((AnyCarRadioButtonView) view2).setOnCheckedChangeWidgetListener((AnyCarRadioButtonView.OnCheckedChangeListener) null);
            }
            ViewGroup.OnHierarchyChangeListener onHierarchyChangeListener = this.mOnHierarchyChangeListener;
            if (onHierarchyChangeListener != null) {
                onHierarchyChangeListener.onChildViewRemoved(view, view2);
            }
        }
    }

    public void autofill(AutofillValue autofillValue) {
        View childAt;
        if (isEnabled() && autofillValue.isList() && (childAt = getChildAt(autofillValue.getListValue())) != null) {
            check(childAt.getId());
        }
    }

    public int getAutofillType() {
        return isEnabled() ? 3 : 0;
    }

    public AutofillValue getAutofillValue() {
        if (!isEnabled()) {
            return null;
        }
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            if (getChildAt(i).getId() == this.f52345c) {
                return AutofillValue.forList(i);
            }
        }
        return null;
    }
}
