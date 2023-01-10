package com.yanzhenjie.permission.runtime;

import android.os.AsyncTask;
import java.util.List;

class LRequest$1 extends AsyncTask<Void, Void, List<String>> {
    final /* synthetic */ C21721a this$0;

    LRequest$1(C21721a aVar) {
        this.this$0 = aVar;
    }

    /* access modifiers changed from: protected */
    public List<String> doInBackground(Void... voidArr) {
        return C21721a.m44620b(C21721a.f58998a, this.this$0.f58999b, this.this$0.f59000c);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<String> list) {
        if (list.isEmpty()) {
            this.this$0.m44621b();
        } else {
            this.this$0.m44619a(list);
        }
    }
}
