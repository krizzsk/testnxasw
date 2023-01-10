package com.didi.dimina.container.secondparty.permission.install;

import android.content.Context;
import com.didi.dimina.container.secondparty.permission.Rationale;
import com.didi.dimina.container.secondparty.permission.RequestExecutor;
import java.io.File;

class BaseRequest$1 implements Rationale<File> {
    final /* synthetic */ C8201a this$0;

    BaseRequest$1(C8201a aVar) {
        this.this$0 = aVar;
    }

    public void showRationale(Context context, File file, RequestExecutor requestExecutor) {
        requestExecutor.execute();
    }
}
