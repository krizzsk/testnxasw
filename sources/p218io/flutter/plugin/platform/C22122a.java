package p218io.flutter.plugin.platform;

import android.view.View;
import android.view.accessibility.AccessibilityEvent;
import p218io.flutter.view.AccessibilityBridge;

/* renamed from: io.flutter.plugin.platform.a */
/* compiled from: AccessibilityEventsDelegate */
class C22122a {

    /* renamed from: a */
    private AccessibilityBridge f60655a;

    C22122a() {
    }

    /* renamed from: a */
    public boolean mo182688a(View view, View view2, AccessibilityEvent accessibilityEvent) {
        AccessibilityBridge accessibilityBridge = this.f60655a;
        if (accessibilityBridge == null) {
            return false;
        }
        return accessibilityBridge.externalViewRequestSendAccessibilityEvent(view, view2, accessibilityEvent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo182687a(AccessibilityBridge accessibilityBridge) {
        this.f60655a = accessibilityBridge;
    }
}
