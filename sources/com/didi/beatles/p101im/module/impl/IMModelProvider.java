package com.didi.beatles.p101im.module.impl;

import com.didi.beatles.p101im.module.IIMGlobalModule;
import com.didi.beatles.p101im.module.IIMMessageModule;
import com.didi.beatles.p101im.module.IIMSessionModule;
import com.didi.beatles.p101im.module.IIMUserModule;
import com.didi.beatles.p101im.module.IMErrorCallback;
import com.didi.beatles.p101im.service.IMServiceProvider;

/* renamed from: com.didi.beatles.im.module.impl.IMModelProvider */
public class IMModelProvider {

    /* renamed from: a */
    private IMMessageModule f11155a;

    /* renamed from: b */
    private IMSessionModule f11156b;

    /* renamed from: c */
    private IMUserModule f11157c;

    /* renamed from: d */
    private IMGlobalModule f11158d;

    /* renamed from: e */
    private IMServiceProvider f11159e;

    /* renamed from: f */
    private IMErrorCallback f11160f;

    private IMModelProvider() {
    }

    public static IMModelProvider getInstance() {
        return Holder.INSTANCE;
    }

    public void init(IMServiceProvider iMServiceProvider) {
        this.f11159e = iMServiceProvider;
        if (this.f11155a == null) {
            IMMessageModule iMMessageModule = new IMMessageModule(this);
            this.f11155a = iMMessageModule;
            iMMessageModule.onStart();
        }
        if (this.f11156b == null) {
            IMSessionModule iMSessionModule = new IMSessionModule(this);
            this.f11156b = iMSessionModule;
            iMSessionModule.onStart();
        }
        if (this.f11157c == null) {
            IMUserModule iMUserModule = new IMUserModule(this);
            this.f11157c = iMUserModule;
            iMUserModule.onStart();
        }
        if (this.f11158d == null) {
            IMGlobalModule iMGlobalModule = new IMGlobalModule(this);
            this.f11158d = iMGlobalModule;
            iMGlobalModule.onStart();
        }
    }

    public void destroy() {
        synchronized (this) {
            if (this.f11155a != null) {
                this.f11155a.onStop();
                this.f11155a = null;
            }
            if (this.f11156b != null) {
                this.f11156b.onStop();
                this.f11156b = null;
            }
            if (this.f11157c != null) {
                this.f11157c.onStop();
                this.f11157c = null;
            }
            if (this.f11158d != null) {
                this.f11158d.onStop();
                this.f11158d = null;
            }
        }
    }

    public IMServiceProvider getIMServiceProvider() {
        return this.f11159e;
    }

    public IIMMessageModule getMessageModule() {
        return this.f11155a;
    }

    public IIMUserModule getUserModule() {
        return this.f11157c;
    }

    public IIMSessionModule getSessionModule() {
        return this.f11156b;
    }

    public IIMGlobalModule getGlobalModule() {
        return this.f11158d;
    }

    public void registerErrorCallback(IMErrorCallback iMErrorCallback) {
        this.f11160f = iMErrorCallback;
    }

    public void unregisterErrorCallback() {
        this.f11160f = null;
    }

    public IMErrorCallback getErrorCallback() {
        return this.f11160f;
    }

    /* renamed from: com.didi.beatles.im.module.impl.IMModelProvider$Holder */
    private static final class Holder {
        /* access modifiers changed from: private */
        public static final IMModelProvider INSTANCE = new IMModelProvider();

        private Holder() {
        }
    }
}
