package com.didi.dimina.container.secondparty.permission.runtime;

import android.os.AsyncTask;
import java.util.List;

class LRequest$1 extends AsyncTask<Void, Void, List<String>> {
    final /* synthetic */ C8213a this$0;

    LRequest$1(C8213a aVar) {
        this.this$0 = aVar;
    }

    /* access modifiers changed from: protected */
    public List<String> doInBackground(Void... voidArr) {
        return C8213a.m16374b(C8213a.f19277a, this.this$0.f19278b, this.this$0.f19279c);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<String> list) {
        if (list.isEmpty()) {
            this.this$0.m16375b();
        } else {
            this.this$0.m16373a(list);
        }
    }
}
