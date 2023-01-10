package com.didi.dimina.container.secondparty.permission.source;

import android.content.Context;
import android.content.Intent;

public class WrapperSource extends Source {

    /* renamed from: a */
    private final Source f19316a;

    public WrapperSource(Source source) {
        this.f19316a = source;
    }

    public Context getContext() {
        return this.f19316a.getContext();
    }

    public void startActivity(Intent intent) {
        this.f19316a.startActivity(intent);
    }

    public void startActivityForResult(Intent intent, int i) {
        this.f19316a.startActivityForResult(intent, i);
    }

    public boolean isShowRationalePermission(String str) {
        return this.f19316a.isShowRationalePermission(str);
    }
}
