package com.didi.beatles.p101im.module;

import com.didi.beatles.p101im.api.entity.IMBaseResponse;
import com.didi.beatles.p101im.module.entity.IMBusinessParam;
import com.didi.beatles.p101im.module.impl.IMModelProvider;
import com.didi.beatles.p101im.p102db.dao.DaoSession;
import com.didi.beatles.p101im.service.IMServiceProvider;
import com.didi.beatles.p101im.task.IMTaskJob;

/* renamed from: com.didi.beatles.im.module.IMBaseModule */
public class IMBaseModule {
    protected DaoSession mDaoSession;
    protected IMModelProvider mModelProvider;
    protected IMServiceProvider mServiceProvider;

    public void onStart() {
    }

    public void onStop() {
    }

    protected IMBaseModule(IMModelProvider iMModelProvider) {
        this.mModelProvider = iMModelProvider;
        IMServiceProvider iMServiceProvider = iMModelProvider.getIMServiceProvider();
        this.mServiceProvider = iMServiceProvider;
        if (iMServiceProvider != null) {
            this.mDaoSession = iMServiceProvider.getDaoManager().getDaoSession();
        }
    }

    /* access modifiers changed from: protected */
    public IMServiceProvider getServiceProvider() {
        return this.mServiceProvider;
    }

    protected static void handleResponseError(IMBaseResponse iMBaseResponse, IMTaskJob iMTaskJob) {
        if (iMBaseResponse != null && !iMBaseResponse.isSuccess()) {
            iMTaskJob.setError(iMBaseResponse.errno);
            iMTaskJob.setNetErrorMessage(iMBaseResponse.errmsg);
        }
    }

    /* access modifiers changed from: protected */
    public IMErrorCallback getErrorCallback() {
        return this.mModelProvider.getErrorCallback();
    }

    /* access modifiers changed from: protected */
    public boolean shouldAddUserInfoReqParams(IMBusinessParam iMBusinessParam) {
        if (iMBusinessParam == null) {
            return false;
        }
        return iMBusinessParam.isSecretValid();
    }
}
