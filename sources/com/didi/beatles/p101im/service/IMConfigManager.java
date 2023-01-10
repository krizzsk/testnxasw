package com.didi.beatles.p101im.service;

import com.didi.beatles.p101im.access.IMContext;

/* renamed from: com.didi.beatles.im.service.IMConfigManager */
public class IMConfigManager extends IMBaseProvider {

    /* renamed from: a */
    private IMContext f11423a;

    /* renamed from: b */
    private long f11424b;

    protected IMConfigManager(IMServiceProvider iMServiceProvider) {
        super(iMServiceProvider);
    }

    public void init(IMContext iMContext) {
        this.f11423a = iMContext;
        this.f11424b = iMContext.getUid();
        this.mProvider.getDaoManager().init(this.f11424b);
        this.mProvider.getFileManager().init(this.f11424b);
    }

    public long getLoginId() {
        return this.f11424b;
    }
}
