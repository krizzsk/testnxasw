package com.didi.beatles.p101im.service;

import android.content.Context;
import com.didi.beatles.p101im.IMContextInfoHelper;

/* renamed from: com.didi.beatles.im.service.IMServiceProvider */
public class IMServiceProvider {

    /* renamed from: f */
    private static IMServiceProvider f11431f;

    /* renamed from: a */
    private IMDownloadManager f11432a;

    /* renamed from: b */
    private IMConfigManager f11433b;

    /* renamed from: c */
    private IMFileManager f11434c;

    /* renamed from: d */
    private IMDaoManager f11435d;

    /* renamed from: e */
    private Context f11436e;

    public static IMServiceProvider getInstance() {
        if (f11431f == null) {
            f11431f = new IMServiceProvider();
        }
        return f11431f;
    }

    public IMServiceProvider init() {
        this.f11436e = IMContextInfoHelper.getContext();
        this.f11434c = new IMFileManager(this);
        this.f11432a = new IMDownloadManager(this);
        if (this.f11435d == null) {
            this.f11435d = new IMDaoManager(this);
        }
        if (this.f11433b == null) {
            this.f11433b = new IMConfigManager(this);
        }
        this.f11433b.init(IMContextInfoHelper.getInfoProvider());
        return this;
    }

    public void destroy() {
        IMDaoManager iMDaoManager = this.f11435d;
        if (iMDaoManager != null) {
            iMDaoManager.close();
            this.f11435d = null;
        }
        if (this.f11433b != null) {
            this.f11433b = null;
        }
    }

    private IMServiceProvider() {
    }

    public Context getContext() {
        return this.f11436e;
    }

    public IMDownloadManager getDownloadManager() {
        return this.f11432a;
    }

    public IMConfigManager getConfigManager() {
        return this.f11433b;
    }

    public IMFileManager getFileManager() {
        return this.f11434c;
    }

    public IMDaoManager getDaoManager() {
        return this.f11435d;
    }
}
