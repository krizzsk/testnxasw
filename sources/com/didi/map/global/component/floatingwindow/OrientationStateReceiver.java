package com.didi.map.global.component.floatingwindow;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.view.Display;
import android.view.WindowManager;
import com.didi.map.global.component.floatingwindow.OrientationStateChangeCallback;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo148867d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001c\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo148868d2 = {"Lcom/didi/map/global/component/floatingwindow/OrientationStateReceiver;", "Landroid/content/BroadcastReceiver;", "callback", "Lcom/didi/map/global/component/floatingwindow/OrientationStateChangeCallback;", "(Lcom/didi/map/global/component/floatingwindow/OrientationStateChangeCallback;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "compFloatingWindow_release"}, mo148869k = 1, mo148870mv = {1, 5, 1}, mo148872xi = 48)
/* compiled from: OrientationStateReceiver.kt */
public final class OrientationStateReceiver extends BroadcastReceiver {

    /* renamed from: a */
    private final OrientationStateChangeCallback f27884a;

    public OrientationStateReceiver(OrientationStateChangeCallback orientationStateChangeCallback) {
        Intrinsics.checkNotNullParameter(orientationStateChangeCallback, "callback");
        this.f27884a = orientationStateChangeCallback;
    }

    public void onReceive(Context context, Intent intent) {
        OrientationStateChangeCallback.OrientationState orientationState;
        Integer num = null;
        Object systemService = context == null ? null : context.getSystemService("window");
        WindowManager windowManager = systemService instanceof WindowManager ? (WindowManager) systemService : null;
        if (windowManager != null) {
            Display defaultDisplay = windowManager.getDefaultDisplay();
            if (defaultDisplay != null) {
                num = Integer.valueOf(defaultDisplay.getRotation());
            }
            if (num != null && num.intValue() == 0) {
                orientationState = OrientationStateChangeCallback.OrientationState.VERTICAL;
            } else if (num != null && num.intValue() == 1) {
                orientationState = OrientationStateChangeCallback.OrientationState.LEFT_HORIZONTAL;
            } else if (num != null && num.intValue() == 2) {
                orientationState = OrientationStateChangeCallback.OrientationState.REVERSE_VERTICAL;
            } else if (num != null && num.intValue() == 3) {
                orientationState = OrientationStateChangeCallback.OrientationState.RIGHT_HORIZONTAL;
            } else {
                orientationState = OrientationStateChangeCallback.OrientationState.OTHER;
            }
            this.f27884a.stateChange(orientationState);
        }
    }
}
