package com.yanzhenjie.permission.runtime;

import android.os.AsyncTask;
import java.util.List;

class MRequest$2 extends AsyncTask<Void, Void, List<String>> {
    final /* synthetic */ C21722b this$0;

    MRequest$2(C21722b bVar) {
        this.this$0 = bVar;
    }

    /* access modifiers changed from: protected */
    public List<String> doInBackground(Void... voidArr) {
        return C21722b.m44630b(C21722b.f59004b, this.this$0.f59005c, this.this$0.f59006d);
    }

    /* access modifiers changed from: protected */
    public void onPostExecute(List<String> list) {
        if (list.isEmpty()) {
            this.this$0.m44631b();
        } else {
            this.this$0.m44629a(list);
        }
    }
}
