package com.didi.dimina.container.secondparty.permission.notify;

import android.content.Context;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;

class BaseRequest$1 implements Rationale<Void> {
    final /* synthetic */ C8204a this$0;

    BaseRequest$1(C8204a aVar) {
        this.this$0 = aVar;
    }

    public void showRationale(Context context, Void voidR, RequestExecutor requestExecutor) {
        requestExecutor.execute();
    }
}
