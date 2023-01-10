package com.didi.dimina.container.secondparty.permission.runtime;

import android.os.AsyncTask;
import java.util.List;

class MRequest$2 extends AsyncTask<Void, Void, List<String>> {
    final /* synthetic */ C8214b this$0;

    MRequest$2(C8214b bVar) {
        this.this$0 = bVar;
    }

    /* access modifiers changed from: protected */
    public List<String> doInBackground(Void... voidArr) {
        return C8214b.m16384b(C8214b.f19283b, this.this$0.f19284c, this.this$0.f19285d);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<String> list) {
        if (list.isEmpty()) {
            this.this$0.m16385b();
        } else {
            this.this$0.m16383a(list);
        }
    }
}
