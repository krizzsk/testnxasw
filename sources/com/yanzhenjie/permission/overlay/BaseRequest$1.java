package com.yanzhenjie.permission.overlay;

import android.content.Context;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;

class BaseRequest$1 implements Rationale<Void> {
    final /* synthetic */ C21718a this$0;

    BaseRequest$1(C21718a aVar) {
        this.this$0 = aVar;
    }

    public void showRationale(Context context, Void voidR, RequestExecutor requestExecutor) {
        requestExecutor.execute();
    }
}
