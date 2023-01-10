package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.log.HWLog;
import com.didi.hawaii.mapsdkv2.jni.SwigBlockEventCallback;

class MapEngineImpl$4 extends SwigBlockEventCallback {
    final /* synthetic */ C9944f this$0;

    MapEngineImpl$4(C9944f fVar) {
        this.this$0 = fVar;
    }

    public void OnBlockEvent(int i, long j, double d, double d2) {
        if (this.this$0.f26287h != null) {
            HWLog.m20433i("OnBlockEvent", "swigBlockEventCallback type = " + i);
            this.this$0.f26287h.onBlockEvent(j, d, d2);
        }
    }
}
