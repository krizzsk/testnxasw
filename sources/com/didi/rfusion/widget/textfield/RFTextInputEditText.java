package com.didi.rfusion.widget.textfield;

import android.content.Context;
import android.graphics.Point;
import android.graphics.Rect;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewParent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;
import com.didi.rfusion.material.internal.RFManufacturerUtils;
import com.didi.rfusion.widget.RFEditText;
import com.taxis99.R;

class RFTextInputEditText extends RFEditText {

    /* renamed from: a */
    private final Rect f36544a;

    /* renamed from: b */
    private boolean f36545b;

    public RFTextInputEditText(Context context) {
        this(context, (AttributeSet) null);
    }

    public RFTextInputEditText(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, R.attr.editTextStyle);
    }

    public RFTextInputEditText(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f36544a = new Rect();
        setTextInputLayoutFocusedRectEnabled(false);
    }

    /* access modifiers changed from: protected */
    public void onAttachedToWindow() {
        super.onAttachedToWindow();
        RFTextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && textInputLayout.isProvidingHint() && super.getHint() == null && RFManufacturerUtils.isMeizuDevice()) {
            setHint("");
        }
    }

    public CharSequence getHint() {
        RFTextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout == null || !textInputLayout.isProvidingHint()) {
            return super.getHint();
        }
        return textInputLayout.getHint();
    }

    public InputConnection onCreateInputConnection(EditorInfo editorInfo) {
        InputConnection onCreateInputConnection = super.onCreateInputConnection(editorInfo);
        if (onCreateInputConnection != null && editorInfo.hintText == null) {
            editorInfo.hintText = getHintFromLayout();
        }
        return onCreateInputConnection;
    }

    private RFTextInputLayout getTextInputLayout() {
        for (ViewParent parent = getParent(); parent instanceof View; parent = parent.getParent()) {
            if (parent instanceof RFTextInputLayout) {
                return (RFTextInputLayout) parent;
            }
        }
        return null;
    }

    private CharSequence getHintFromLayout() {
        RFTextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null) {
            return textInputLayout.getHint();
        }
        return null;
    }

    public void setTextInputLayoutFocusedRectEnabled(boolean z) {
        this.f36545b = z;
    }

    /* renamed from: a */
    public boolean mo94682a() {
        return this.f36545b;
    }

    public void getFocusedRect(Rect rect) {
        super.getFocusedRect(rect);
        RFTextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f36545b && rect != null) {
            textInputLayout.getFocusedRect(this.f36544a);
            rect.bottom = this.f36544a.bottom;
        }
    }

    public boolean getGlobalVisibleRect(Rect rect, Point point) {
        boolean globalVisibleRect = super.getGlobalVisibleRect(rect, point);
        RFTextInputLayout textInputLayout = getTextInputLayout();
        if (!(textInputLayout == null || !this.f36545b || rect == null)) {
            textInputLayout.getGlobalVisibleRect(this.f36544a, point);
            rect.bottom = this.f36544a.bottom;
        }
        return globalVisibleRect;
    }

    public boolean requestRectangleOnScreen(Rect rect) {
        boolean requestRectangleOnScreen = super.requestRectangleOnScreen(rect);
        RFTextInputLayout textInputLayout = getTextInputLayout();
        if (textInputLayout != null && this.f36545b) {
            this.f36544a.set(0, textInputLayout.getHeight() - 12, textInputLayout.getWidth(), textInputLayout.getHeight());
            textInputLayout.requestRectangleOnScreen(this.f36544a, true);
        }
        return requestRectangleOnScreen;
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        RFTextInputLayout textInputLayout = getTextInputLayout();
        if (Build.VERSION.SDK_INT < 23 && textInputLayout != null) {
            accessibilityNodeInfo.setText(m27508a(textInputLayout));
        }
    }

    /* renamed from: a */
    private String m27508a(RFTextInputLayout rFTextInputLayout) {
        Editable text = getText();
        CharSequence hint = rFTextInputLayout.getHint();
        boolean z = !TextUtils.isEmpty(text);
        boolean z2 = !TextUtils.isEmpty(hint);
        if (Build.VERSION.SDK_INT >= 17) {
            setLabelFor(R.id.textinput_helper_text);
        }
        String str = "";
        String charSequence = z2 ? hint.toString() : str;
        if (!z) {
            return !TextUtils.isEmpty(charSequence) ? charSequence : str;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(text);
        if (!TextUtils.isEmpty(charSequence)) {
            str = ", " + charSequence;
        }
        sb.append(str);
        return sb.toString();
    }
}
