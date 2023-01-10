package com.didi.component.common.pininput;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.pininput.PinUploader;
import com.didi.component.common.util.GLog;
import com.didi.component.core.PresenterGroup;
import com.didi.usercenter.api.UserCenterFacade;
import com.didi.usercenter.entity.UserInfo;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;

public class PinInputPresenter extends PresenterGroup<IPinInputView> {
    public static final int PIN_LENGTH = 3;

    /* renamed from: a */
    private static final String f13507a = "PinInputPresenter";

    /* renamed from: b */
    private boolean f13508b;

    public PinInputPresenter(Context context, Bundle bundle) {
        super(context, bundle);
    }

    public synchronized void createPin(String str) {
        if (m11284a(str) && !this.f13508b) {
            ((IPinInputView) this.mView).showUploadingDialog();
            m11283a(NationComponentDataUtil.getToken(), str);
        }
    }

    /* renamed from: a */
    private boolean m11284a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return str.matches("^\\d{3}$");
        }
        return false;
    }

    /* renamed from: a */
    private void m11283a(final String str, String str2) {
        new PinUploader(this.mContext).uploadPin(str2, new RpcService.Callback<PinUploader.Response>() {
            public void onSuccess(PinUploader.Response response) {
                GLog.m11354d(PinInputPresenter.f13507a, "upload pin response: " + response);
                if (response == null || response.code != 0) {
                    PinInputPresenter.this.m11287c();
                    return;
                }
                UserCenterFacade.getIns().fetchUserInfo(PinInputPresenter.this.mContext, str, NationComponentDataUtil.getCurrentLan(), new RpcService.Callback<UserInfo>() {
                    public void onSuccess(UserInfo userInfo) {
                        GLog.m11354d(PinInputPresenter.f13507a, "fetchUserInfo onSuccess: " + userInfo);
                        if (!TextUtils.isEmpty(userInfo.getPin())) {
                            PinInputPresenter.this.m11285b();
                        } else {
                            PinInputPresenter.this.m11287c();
                        }
                    }

                    public void onFailure(IOException iOException) {
                        GLog.m11355d(PinInputPresenter.f13507a, "fetchUserInfo onFail", iOException);
                        PinInputPresenter.this.m11287c();
                    }
                });
            }

            public void onFailure(IOException iOException) {
                GLog.m11355d(PinInputPresenter.f13507a, "upload pin failed", iOException);
                PinInputPresenter.this.m11287c();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public synchronized void m11285b() {
        ((IPinInputView) this.mView).dismissUploadingDialog();
        ((IPinInputView) this.mView).showPinCreatedView();
        this.f13508b = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public synchronized void m11287c() {
        ((IPinInputView) this.mView).dismissUploadingDialog();
        ((IPinInputView) this.mView).showUploadFailedToast();
        this.f13508b = false;
    }
}
