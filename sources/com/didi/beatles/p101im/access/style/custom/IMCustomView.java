package com.didi.beatles.p101im.access.style.custom;

import com.didi.beatles.p101im.module.entity.IMBusinessParam;
import com.didi.beatles.p101im.module.entity.IMSession;

/* renamed from: com.didi.beatles.im.access.style.custom.IMCustomView */
public abstract class IMCustomView {

    /* renamed from: a */
    private IMCustomContext f10688a;

    public void onSessionUpdate(IMSession iMSession) {
    }

    public final void bindIMContext(IMCustomContext iMCustomContext) {
        if (iMCustomContext != null) {
            iMCustomContext.addIMCustomView(this);
        }
        this.f10688a = iMCustomContext;
    }

    public final IMSession getSession() {
        IMCustomContext iMCustomContext = this.f10688a;
        if (iMCustomContext == null) {
            return null;
        }
        return iMCustomContext.getSession();
    }

    public final IMBusinessParam getBusinessParam() {
        IMCustomContext iMCustomContext = this.f10688a;
        if (iMCustomContext == null) {
            return null;
        }
        return iMCustomContext.getParam();
    }
}
