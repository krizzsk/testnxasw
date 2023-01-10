package com.didi.onekeyshare.callback;

import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.track.OmegaTrack;
import java.util.Map;

public class ShareCallbackDelegate2 implements ICallback.IPlatformShareCallback2 {

    /* renamed from: a */
    private ICallback.IPlatformShareCallback2 f32223a;

    /* renamed from: b */
    private Map<String, String> f32224b;

    public ShareCallbackDelegate2(ICallback.IPlatformShareCallback2 iPlatformShareCallback2, Map<String, String> map) {
        this.f32223a = iPlatformShareCallback2;
        this.f32224b = map;
    }

    public void onComplete(SharePlatform sharePlatform) {
        if (sharePlatform != null) {
            OmegaTrack.trackShareResult(sharePlatform.platformName(), this.f32224b, "success");
        }
        ICallback.IPlatformShareCallback2 iPlatformShareCallback2 = this.f32223a;
        if (iPlatformShareCallback2 != null) {
            iPlatformShareCallback2.onComplete(sharePlatform);
        }
    }

    public void onError(SharePlatform sharePlatform) {
        if (sharePlatform != null) {
            OmegaTrack.trackShareResult(sharePlatform.platformName(), this.f32224b, "fail");
        }
        ICallback.IPlatformShareCallback2 iPlatformShareCallback2 = this.f32223a;
        if (iPlatformShareCallback2 != null) {
            iPlatformShareCallback2.onError(sharePlatform);
        }
    }

    public void onCancel(SharePlatform sharePlatform) {
        if (sharePlatform != null) {
            OmegaTrack.trackShareResult(sharePlatform.platformName(), this.f32224b, "cancel");
        }
        ICallback.IPlatformShareCallback2 iPlatformShareCallback2 = this.f32223a;
        if (iPlatformShareCallback2 != null) {
            iPlatformShareCallback2.onCancel(sharePlatform);
        }
    }

    public void onError(SharePlatform sharePlatform, int i) {
        if (sharePlatform != null) {
            OmegaTrack.trackShareResult(sharePlatform.platformName(), this.f32224b, "fail");
        }
        ICallback.IPlatformShareCallback2 iPlatformShareCallback2 = this.f32223a;
        if (iPlatformShareCallback2 != null) {
            iPlatformShareCallback2.onError(sharePlatform, i);
        }
    }
}
