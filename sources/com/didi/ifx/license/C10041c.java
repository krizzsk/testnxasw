package com.didi.ifx.license;

import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import java.util.Map;

/* renamed from: com.didi.ifx.license.c */
/* compiled from: IFXTracker */
class C10041c {

    /* renamed from: a */
    boolean f26637a = false;

    /* renamed from: b */
    IFXTrackCallback f26638b = null;

    C10041c() {
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo77461a(String str, Map<String, Object> map) {
        if (this.f26637a) {
            IFXTrackCallback iFXTrackCallback = this.f26638b;
            if (iFXTrackCallback != null) {
                iFXTrackCallback.trackEvent(str, map);
                return;
            }
            return;
        }
        OmegaSDKAdapter.trackEvent(str, map);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo77460a(String str, Throwable th) {
        if (this.f26637a) {
            IFXTrackCallback iFXTrackCallback = this.f26638b;
            if (iFXTrackCallback != null) {
                iFXTrackCallback.trackError(str, th);
                return;
            }
            return;
        }
        OmegaSDK.trackError(str, th);
    }
}
