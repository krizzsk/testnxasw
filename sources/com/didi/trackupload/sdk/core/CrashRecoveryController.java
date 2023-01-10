package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.utils.TrackLog;

public class CrashRecoveryController {

    /* renamed from: a */
    private static final String f46555a = "TrackCrashRecovery";

    private CrashRecoveryController() {
    }

    private static class SingletonHolder {
        static CrashRecoveryController INSTANCE = new CrashRecoveryController();

        private SingletonHolder() {
        }
    }

    public static CrashRecoveryController getInstance() {
        return SingletonHolder.INSTANCE;
    }

    public void init() {
        TrackLog.m34830d(f46555a, "run UploadCacheTask");
        CoreThread.post(new UploadCacheTask());
    }
}
