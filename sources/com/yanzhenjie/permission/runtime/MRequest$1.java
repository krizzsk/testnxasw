package com.yanzhenjie.permission.runtime;

import android.content.Context;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import java.util.List;

class MRequest$1 implements Rationale<List<String>> {
    final /* synthetic */ C21722b this$0;

    MRequest$1(C21722b bVar) {
        this.this$0 = bVar;
    }

    public void showRationale(Context context, List<String> list, RequestExecutor requestExecutor) {
        requestExecutor.execute();
    }
}
