package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.accessibility.AccessibilityEvent;
import android.view.accessibility.AccessibilityNodeInfo;
import android.widget.RelativeLayout;

public class RelativeLayoutAccessibleForCheck extends RelativeLayout {

    /* renamed from: a */
    private boolean f47124a = false;

    /* renamed from: b */
    private boolean f47125b = false;

    public RelativeLayoutAccessibleForCheck(Context context) {
        super(context);
    }

    public RelativeLayoutAccessibleForCheck(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public RelativeLayoutAccessibleForCheck(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setCheckEnable(boolean z) {
        this.f47125b = z;
    }

    public void setCheck(boolean z) {
        this.f47124a = z;
    }

    public void onPopulateAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onPopulateAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setChecked(this.f47124a);
    }

    public void onInitializeAccessibilityNodeInfo(AccessibilityNodeInfo accessibilityNodeInfo) {
        super.onInitializeAccessibilityNodeInfo(accessibilityNodeInfo);
        accessibilityNodeInfo.setChecked(this.f47124a);
        accessibilityNodeInfo.setCheckable(this.f47125b);
    }

    public void onInitializeAccessibilityEvent(AccessibilityEvent accessibilityEvent) {
        super.onInitializeAccessibilityEvent(accessibilityEvent);
        accessibilityEvent.setChecked(this.f47124a);
    }
}
