package com.didi.beatles.p101im.manager;

import android.view.accessibility.AccessibilityManager;
import com.didi.beatles.p101im.IMContextInfoHelper;

/* renamed from: com.didi.beatles.im.manager.IMAccessibilityManager */
public class IMAccessibilityManager {

    /* renamed from: a */
    private static IMAccessibilityManager f11061a;

    /* renamed from: b */
    private AccessibilityManager f11062b;

    public static IMAccessibilityManager getInstance() {
        if (f11061a == null) {
            f11061a = new IMAccessibilityManager();
        }
        return f11061a;
    }

    private IMAccessibilityManager() {
        try {
            this.f11062b = (AccessibilityManager) IMContextInfoHelper.getContext().getSystemService("accessibility");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isEnabled() {
        AccessibilityManager accessibilityManager = this.f11062b;
        if (accessibilityManager != null) {
            return accessibilityManager.isEnabled();
        }
        return false;
    }
}
