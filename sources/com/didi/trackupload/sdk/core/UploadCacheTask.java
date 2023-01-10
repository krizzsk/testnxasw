package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.TrackController;
import com.didi.trackupload.sdk.core.UploadController;
import com.didi.trackupload.sdk.core.UploadTask;
import com.didi.trackupload.sdk.utils.ApolloUtils;
import com.didi.trackupload.sdk.utils.TrackLog;
import java.util.Map;

public class UploadCacheTask implements UploadTask.OnExecuteCompletedListenser, Runnable {

    /* renamed from: a */
    private static final String f46572a = "TrackUploadCacheTask";

    /* renamed from: b */
    private static final int f46573b = 3;

    /* renamed from: c */
    private static final long f46574c;

    /* renamed from: d */
    private static final long f46575d;

    /* renamed from: e */
    private long f46576e = 0;

    static {
        long[] requestRecoverUploadParams = ApolloUtils.requestRecoverUploadParams();
        f46574c = requestRecoverUploadParams[0];
        f46575d = requestRecoverUploadParams[1];
        TrackLog.m34830d(f46572a, "startDelay=" + f46574c + " retryDelay=" + f46575d);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m34745a(UploadResult uploadResult) {
        UploadTask uploadTask = new UploadTask((Map<String, UploadController.UploadClient>) null, UploadFlags.m34754a(262144, 2, 4), this);
        if (uploadResult == null) {
            this.f46576e = 0;
            TrackLog.m34830d(f46572a, "upload task=" + uploadTask.toHexString() + " delay=" + f46574c);
            uploadTask.mo115963a(f46574c);
        } else if (uploadResult == UploadResult.ERR_PARAMS_BIZ_NODES) {
            this.f46576e = 0;
            TrackLog.m34830d(f46572a, "upload task ignored due to empty track nodes");
        } else if (TrackController.getIntance().getRunningClientSize() != 0) {
            TrackLog.m34830d(f46572a, "upload task ignored due to client exists");
        } else if (uploadResult == UploadResult.ERR_OK) {
            this.f46576e = 0;
            TrackLog.m34830d(f46572a, "upload task=" + uploadTask.toHexString() + " delay=0");
            uploadTask.mo115963a(0);
        } else {
            long j = this.f46576e;
            if (j < 3) {
                this.f46576e = j + 1;
                TrackLog.m34830d(f46572a, "upload task=" + uploadTask.toHexString() + " delay=" + f46575d);
                uploadTask.mo115963a(f46575d);
            }
        }
    }

    public void run() {
        if (CoreThread.ensureCoreThread()) {
            m34745a((UploadResult) null);
        }
    }

    public void onExecuteCompleted(final UploadResult uploadResult) {
        CoreThread.post(new Runnable() {
            public void run() {
                UploadCacheTask.this.m34745a(uploadResult);
            }
        });
    }
}
