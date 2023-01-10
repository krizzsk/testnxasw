package com.yanzhenjie.permission.source;

import android.content.Context;
import android.content.Intent;

public class WrapperSource extends Source {

    /* renamed from: a */
    private Source f59037a;

    public WrapperSource(Source source) {
        this.f59037a = source;
    }

    public Context getContext() {
        return this.f59037a.getContext();
    }

    public void startActivity(Intent intent) {
        this.f59037a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f59037a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        return this.f59037a.isShowRationalePermission(str);
    }
}
