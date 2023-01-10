package com.didi.component.business.deeplink.jumpstrategy;

import android.app.Activity;
import android.net.Uri;
import com.didi.safetoolkit.business.sdk.SafeToolKit;

/* renamed from: com.didi.component.business.deeplink.jumpstrategy.c */
/* compiled from: SafeCenterDeepLink */
class C5180c implements INewActivityDeepLink {
    C5180c() {
    }

    public void deepLink(Activity activity, Uri uri) {
        SafeToolKit.getIns().startSafeCenterPage(activity);
    }
}
