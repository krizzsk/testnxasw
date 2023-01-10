package com.didi.map.global.sctx.server;

import com.didi.map.global.sctx.case_parser.model.SctxCaseCode;
import java.util.concurrent.TimeoutException;

class SctxOraDataProvider$2 implements Runnable {
    final /* synthetic */ C10641a this$0;
    final /* synthetic */ Throwable val$e;
    final /* synthetic */ String val$err;

    SctxOraDataProvider$2(C10641a aVar, Throwable th, String str) {
        this.this$0 = aVar;
        this.val$e = th;
        this.val$err = str;
    }

    public void run() {
        if (this.this$0.mDataCallback != null && !this.this$0.mStop) {
            if (this.this$0.sctxCaseParser != null && this.this$0.sctxCaseParser.isEnable()) {
                this.this$0.sctxCaseParser.recordJumpCode(this.val$e instanceof TimeoutException ? SctxCaseCode.ORA_REQUEST_TIMEOUT : SctxCaseCode.ORA_REQUEST_ERROR);
            }
            this.this$0.mDataCallback.onError(this.val$err);
        }
    }
}
