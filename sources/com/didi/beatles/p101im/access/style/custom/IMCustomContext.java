package com.didi.beatles.p101im.access.style.custom;

import com.didi.beatles.p101im.module.entity.IMBusinessParam;
import com.didi.beatles.p101im.module.entity.IMSession;
import java.lang.ref.WeakReference;
import java.util.ArrayList;

/* renamed from: com.didi.beatles.im.access.style.custom.IMCustomContext */
public final class IMCustomContext {

    /* renamed from: a */
    private final ArrayList<WeakReference<IMCustomView>> f10685a = new ArrayList<>();

    /* renamed from: b */
    private IMSession f10686b;

    /* renamed from: c */
    private IMBusinessParam f10687c;

    public IMCustomContext(IMSession iMSession, IMBusinessParam iMBusinessParam) {
        this.f10686b = iMSession;
        this.f10687c = iMBusinessParam;
    }

    public void setSession(IMSession iMSession) {
        this.f10686b = iMSession;
        int i = 0;
        while (i < this.f10685a.size()) {
            IMCustomView iMCustomView = (IMCustomView) this.f10685a.get(i).get();
            if (iMCustomView == null) {
                this.f10685a.remove(i);
                i--;
            } else {
                iMCustomView.onSessionUpdate(iMSession);
            }
            i++;
        }
    }

    public IMSession getSession() {
        return this.f10686b;
    }

    public void setParam(IMBusinessParam iMBusinessParam) {
        this.f10687c = iMBusinessParam;
    }

    public IMBusinessParam getParam() {
        return this.f10687c;
    }

    public void addIMCustomView(IMCustomView iMCustomView) {
        this.f10685a.add(new WeakReference(iMCustomView));
        if (iMCustomView != null) {
            iMCustomView.onSessionUpdate(getSession());
        }
    }
}
