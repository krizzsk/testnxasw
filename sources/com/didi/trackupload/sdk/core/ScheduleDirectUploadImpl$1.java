package com.didi.trackupload.sdk.core;

import com.didi.trackupload.sdk.datachannel.protobuf.TrackLocationInfo;
import com.didi.trackupload.sdk.location.LocationCenter;
import com.didi.trackupload.sdk.location.TrackLocationListener;
import com.didi.trackupload.sdk.utils.LogStringUtils;
import com.didi.trackupload.sdk.utils.TrackLog;

class ScheduleDirectUploadImpl$1 implements TrackLocationListener {
    final /* synthetic */ C15090a this$0;

    ScheduleDirectUploadImpl$1(C15090a aVar) {
        this.this$0 = aVar;
    }

    public void onLocationChanged(final TrackLocationInfo trackLocationInfo) {
        TrackLog.m34830d(LocationCenter.TAG, "onNormalLoc " + LogStringUtils.parseLocationInfo(trackLocationInfo));
        CoreThread.post(new Runnable() {
            public void run() {
                ScheduleDirectUploadImpl$1.this.this$0.m34786a(trackLocationInfo);
            }
        });
    }

    public void onLocationError(int i, String str) {
        TrackLog.m34830d(LocationCenter.TAG, "onNormalLocError errCode=" + i + " errMsg=" + str);
        CoreThread.post(new Runnable() {
            public void run() {
                ScheduleDirectUploadImpl$1.this.this$0.m34786a((TrackLocationInfo) null);
            }
        });
    }
}
