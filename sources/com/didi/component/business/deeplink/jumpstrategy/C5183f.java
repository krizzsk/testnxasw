package com.didi.component.business.deeplink.jumpstrategy;

import android.app.Activity;
import android.net.Uri;
import com.didi.safetoolkit.business.sdk.SafeToolKit;

/* renamed from: com.didi.component.business.deeplink.jumpstrategy.f */
/* compiled from: SosDeepLink */
class C5183f implements INewActivityDeepLink {
    C5183f() {
    }

    public void deepLink(Activity activity, Uri uri) {
        SafeToolKit.getIns().startEmergencyAssistanceActivity(activity);
    }
}
