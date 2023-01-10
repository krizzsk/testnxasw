package com.yanzhenjie.permission.runtime.setting;

import com.yanzhenjie.permission.source.Source;

public class AllRequest implements SettingRequest {

    /* renamed from: a */
    private Source f59011a;

    public AllRequest(Source source) {
        this.f59011a = source;
    }

    public void start(int i) {
        new SettingPage(this.f59011a).start(i);
    }
}
