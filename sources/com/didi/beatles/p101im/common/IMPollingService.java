package com.didi.beatles.p101im.common;

import android.app.IntentService;
import android.content.Intent;
import com.didi.beatles.p101im.manager.IMManager;
import com.didi.beatles.p101im.utils.IMLog;

/* renamed from: com.didi.beatles.im.common.IMPollingService */
public class IMPollingService extends IntentService {
    public static final String ACTION = "im.service.IMPollingService";

    public IMPollingService() {
        super("IMPollingService");
    }

    /* access modifiers changed from: protected */
    public void onHandleIntent(Intent intent) {
        IMLog.m10021e(IMPollingService.class.getSimpleName(), "IMPollingService");
        IMManager.getInstance().pullMessage(0, -1, 3);
    }
}
