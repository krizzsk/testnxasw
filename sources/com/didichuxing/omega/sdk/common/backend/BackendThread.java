package com.didichuxing.omega.sdk.common.backend;

import android.content.Context;

public class BackendThread extends Thread {
    private static final long VERY_SHORT_SLEEP_INTERVAL = 15000;
    private static boolean isFirstStart = true;
    private static volatile boolean isUploading = false;
    private static Context mContext;
    private volatile boolean needShutdown;

    private BackendThread() {
        this.needShutdown = false;
        setName("OmegaSDK.BackendThread");
        setPriority(1);
        start();
    }

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static BackendThread instance = new BackendThread();

        private SingletonHolder() {
        }
    }

    public static BackendThread getInstance() {
        return SingletonHolder.instance;
    }

    public void init(Context context) {
        mContext = context;
    }

    public void wakeup() {
        if (!isUploading) {
            interrupt();
        }
    }

    public void shutdown() {
        this.needShutdown = true;
    }

    /* JADX WARNING: No exception handlers in catch block: Catch:{  } */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void run() {
        /*
            r4 = this;
        L_0x0000:
            boolean r0 = r4.needShutdown
            if (r0 != 0) goto L_0x0077
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.SWITCH_EVENT
            r1 = 0
            if (r0 != 0) goto L_0x001a
            isUploading = r1
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.isDebugModel()
            if (r0 != 0) goto L_0x0000
            int r0 = com.didichuxing.omega.sdk.common.OmegaConfig.BACKEND_THREAD_RUN_INTERVAL     // Catch:{ InterruptedException -> 0x0018 }
            long r0 = (long) r0     // Catch:{ InterruptedException -> 0x0018 }
            java.lang.Thread.sleep(r0)     // Catch:{ InterruptedException -> 0x0018 }
            goto L_0x0000
        L_0x0018:
            goto L_0x0000
        L_0x001a:
            boolean r0 = isFirstStart
            if (r0 == 0) goto L_0x0028
            r2 = 15000(0x3a98, double:7.411E-320)
            java.lang.Thread.sleep(r2)     // Catch:{ InterruptedException -> 0x0026 }
            isFirstStart = r1     // Catch:{ InterruptedException -> 0x0026 }
            goto L_0x0028
        L_0x0026:
            isFirstStart = r1
        L_0x0028:
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.isDebugModel()
            if (r0 != 0) goto L_0x0032
            boolean r0 = isFirstStart
            if (r0 != 0) goto L_0x0000
        L_0x0032:
            r0 = 1
            isUploading = r0
            int r0 = com.didichuxing.omega.sdk.analysis.EventSendQueue.size()     // Catch:{ Exception -> 0x006c }
            if (r0 <= 0) goto L_0x0044
            com.didichuxing.omega.sdk.common.record.EventsRecord r0 = com.didichuxing.omega.sdk.analysis.EventSendQueue.dumpRecord()     // Catch:{ Exception -> 0x006c }
            if (r0 == 0) goto L_0x0044
            com.didichuxing.omega.sdk.common.record.RecordStorage.save(r0)     // Catch:{ Exception -> 0x006c }
        L_0x0044:
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.isDebugModel()     // Catch:{ Exception -> 0x006c }
            if (r0 != 0) goto L_0x0058
            com.didichuxing.omega.sdk.analysis.OMGUserStateSetting$OMGUserState r0 = com.didichuxing.omega.sdk.analysis.OMGUserStateSetting.getUserState()     // Catch:{ Exception -> 0x006c }
            com.didichuxing.omega.sdk.analysis.OMGUserStateSetting$OMGUserState r2 = com.didichuxing.omega.sdk.analysis.OMGUserStateSetting.OMGUserState.OMGUserStateFullAuthorized     // Catch:{ Exception -> 0x006c }
            if (r0 != r2) goto L_0x005d
            boolean r0 = com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector.getAppInSync()     // Catch:{ Exception -> 0x006c }
            if (r0 == 0) goto L_0x005d
        L_0x0058:
            android.content.Context r0 = mContext     // Catch:{ Exception -> 0x006c }
            com.didichuxing.omega.sdk.common.backend.UploadStrategy.upload(r0)     // Catch:{ Exception -> 0x006c }
        L_0x005d:
            isUploading = r1     // Catch:{ Exception -> 0x006c }
            boolean r0 = com.didichuxing.omega.sdk.common.OmegaConfig.isDebugModel()     // Catch:{ Exception -> 0x006c }
            if (r0 != 0) goto L_0x0000
            int r0 = com.didichuxing.omega.sdk.common.OmegaConfig.BACKEND_THREAD_RUN_INTERVAL     // Catch:{  }
            long r0 = (long) r0     // Catch:{  }
            java.lang.Thread.sleep(r0)     // Catch:{  }
            goto L_0x0000
        L_0x006c:
            r0 = move-exception
            java.lang.Throwable r0 = r0.getCause()
            java.lang.String r1 = "BackendThread"
            com.didichuxing.omega.sdk.common.utils.OLog.m38207e(r1, r0)
            goto L_0x0000
        L_0x0077:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didichuxing.omega.sdk.common.backend.BackendThread.run():void");
    }
}
