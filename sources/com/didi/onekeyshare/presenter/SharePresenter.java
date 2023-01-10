package com.didi.onekeyshare.presenter;

import android.app.Activity;
import com.didi.onekeyshare.callback.ICallback;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.model.IShareModel;
import com.didi.onekeyshare.model.ShareModel;
import com.didi.onekeyshare.track.OmegaTrack;
import com.didi.onekeyshare.view.IShareView;
import com.didi.onekeyshare.wrapper.ShareWrapper;
import java.util.List;
import java.util.Map;

public class SharePresenter implements ISharePresenter {

    /* renamed from: a */
    private IShareView f32230a;

    /* renamed from: b */
    private IShareModel f32231b = new ShareModel();

    /* renamed from: c */
    private ICallback.IPlatformCallback f32232c;

    /* renamed from: d */
    private ICallback.IShareCallback f32233d;

    /* renamed from: e */
    private ICallback.IPlatformShareCallback f32234e;

    /* renamed from: f */
    private Activity f32235f;

    public SharePresenter(Activity activity, IShareView iShareView) {
        this.f32230a = iShareView;
        this.f32235f = activity;
    }

    public void setCallback(ICallback iCallback) {
        if (iCallback != null) {
            if (iCallback instanceof ICallback.IPlatformCallback) {
                this.f32232c = (ICallback.IPlatformCallback) iCallback;
            }
            if (iCallback instanceof ICallback.IPlatformShareCallback) {
                this.f32234e = (ICallback.IPlatformShareCallback) iCallback;
            }
            if (iCallback instanceof ICallback.IShareCallback) {
                this.f32233d = (ICallback.IShareCallback) iCallback;
            }
        }
    }

    public void setShareInfo(List<OneKeyShareInfo> list) {
        this.f32231b.setShareInfo(list);
        this.f32230a.updateShareView(list);
    }

    public List<OneKeyShareInfo> getShareInfo() {
        return this.f32231b.getShareInfo();
    }

    public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
        share(oneKeyShareInfo);
    }

    public void onCancel() {
        m24498a();
    }

    public void onShow(List<OneKeyShareInfo> list) {
        if (list != null && this.f32230a.getContext() != null) {
            OmegaTrack.trackSharePagedShow(this.f32230a.getContext(), list);
        }
    }

    /* access modifiers changed from: protected */
    public void share(OneKeyShareInfo oneKeyShareInfo) {
        if (oneKeyShareInfo != null && oneKeyShareInfo.platform != null && oneKeyShareInfo.platform != SharePlatform.UNKNOWN) {
            m24499a(oneKeyShareInfo.platform);
            if (oneKeyShareInfo != null) {
                ShareWrapper.shareToPlatform(this.f32235f, oneKeyShareInfo, this.f32234e);
            }
        }
    }

    /* renamed from: a */
    private void m24498a() {
        ICallback.IShareCallback iShareCallback = this.f32233d;
        if (iShareCallback != null) {
            iShareCallback.onCancel();
        }
    }

    /* renamed from: a */
    private void m24499a(SharePlatform sharePlatform) {
        ICallback.IPlatformCallback iPlatformCallback = this.f32232c;
        if (iPlatformCallback != null) {
            iPlatformCallback.onClickPlatform(sharePlatform);
        }
        IShareView iShareView = this.f32230a;
        if (iShareView != null) {
            OmegaTrack.trackShareChannelClick(iShareView.getContext().getString(sharePlatform.alias()), (Map) null);
        }
    }
}
