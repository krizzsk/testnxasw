package com.didi.map.global.sctx.server;

class SctxOraDataProviderTwo$1 implements Runnable {
    final /* synthetic */ C10642b this$0;
    final /* synthetic */ byte[] val$response;
    final /* synthetic */ long val$routeId;

    SctxOraDataProviderTwo$1(C10642b bVar, byte[] bArr, long j) {
        this.this$0 = bVar;
        this.val$response = bArr;
        this.val$routeId = j;
    }

    public void run() {
        if (!this.this$0.mStop) {
            this.this$0.m23456a(this.val$response, this.val$routeId);
        }
    }
}
