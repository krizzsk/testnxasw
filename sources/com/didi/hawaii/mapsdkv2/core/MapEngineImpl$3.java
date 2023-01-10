package com.didi.hawaii.mapsdkv2.core;

import com.didi.hawaii.mapsdkv2.jni.SwigMJOCallback;

class MapEngineImpl$3 extends SwigMJOCallback {
    final /* synthetic */ C9944f this$0;

    MapEngineImpl$3(C9944f fVar) {
        this.this$0 = fVar;
    }

    public void OnMJOEvent(int i, int i2) {
        if (this.this$0.f26286g != null) {
            this.this$0.f26286g.onMJOEvent((long) i, i2);
        }
    }
}
