package com.didi.map.global.sctx.server;

class SctxOraDataProvider$1 implements Runnable {
    final /* synthetic */ C10641a this$0;
    final /* synthetic */ byte[] val$response;
    final /* synthetic */ long val$routeId;

    SctxOraDataProvider$1(C10641a aVar, byte[] bArr, long j) {
        this.this$0 = aVar;
        this.val$response = bArr;
        this.val$routeId = j;
    }

    public void run() {
        if (!this.this$0.mStop) {
            this.this$0.m23449a(this.val$response, this.val$routeId);
        }
    }
}
