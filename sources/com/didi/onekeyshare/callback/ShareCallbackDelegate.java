package com.didi.onekeyshare.callback;

import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.track.OmegaTrack;
import java.util.Map;

public class ShareCallbackDelegate implements ICallback.IPlatformShareCallback {

    /* renamed from: a */
    private ICallback.IPlatformShareCallback f32221a;

    /* renamed from: b */
    private Map<String, String> f32222b;

    public ShareCallbackDelegate(ICallback.IPlatformShareCallback iPlatformShareCallback, Map<String, String> map) {
        this.f32221a = iPlatformShareCallback;
        this.f32222b = map;
    }

    public void onComplete(SharePlatform sharePlatform) {
        if (sharePlatform != null) {
            OmegaTrack.trackShareResult(sharePlatform.platformName(), this.f32222b, "success");
        }
        ICallback.IPlatformShareCallback iPlatformShareCallback = this.f32221a;
        if (iPlatformShareCallback != null) {
            iPlatformShareCallback.onComplete(sharePlatform);
        }
    }

    public void onError(SharePlatform sharePlatform) {
        if (sharePlatform != null) {
            OmegaTrack.trackShareResult(sharePlatform.platformName(), this.f32222b, "fail");
        }
        ICallback.IPlatformShareCallback iPlatformShareCallback = this.f32221a;
        if (iPlatformShareCallback != null) {
            iPlatformShareCallback.onError(sharePlatform);
        }
    }

    public void onCancel(SharePlatform sharePlatform) {
        if (sharePlatform != null) {
            OmegaTrack.trackShareResult(sharePlatform.platformName(), this.f32222b, "cancel");
        }
        ICallback.IPlatformShareCallback iPlatformShareCallback = this.f32221a;
        if (iPlatformShareCallback != null) {
            iPlatformShareCallback.onCancel(sharePlatform);
        }
    }
}
