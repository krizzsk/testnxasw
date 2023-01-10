package com.didi.dimina.container.mina;

import java.util.ArrayList;
import java.util.List;

public class DMFrontBackgroundManager {

    /* renamed from: a */
    private final List<IDMCommonAction<Void>> f18766a = new ArrayList();

    /* renamed from: b */
    private final List<IDMCommonAction<Void>> f18767b = new ArrayList();

    /* renamed from: c */
    private boolean f18768c = true;

    public void registerFrontCallback(IDMCommonAction<Void> iDMCommonAction) {
        this.f18766a.add(iDMCommonAction);
    }

    public void unRegisterFrontCallback(IDMCommonAction<Void> iDMCommonAction) {
        this.f18766a.remove(iDMCommonAction);
    }

    public void registerBackgroundCallback(IDMCommonAction<Void> iDMCommonAction) {
        this.f18767b.add(iDMCommonAction);
    }

    public void unRegisterBackgroundCallback(IDMCommonAction<Void> iDMCommonAction) {
        this.f18767b.remove(iDMCommonAction);
    }

    public void hookFrontCallback() {
        this.f18768c = true;
        for (IDMCommonAction iDMCommonAction : new ArrayList(this.f18766a)) {
            if (iDMCommonAction != null) {
                iDMCommonAction.callback(null);
            }
        }
    }

    public void hookBackgroundCallback() {
        this.f18768c = false;
        for (IDMCommonAction iDMCommonAction : new ArrayList(this.f18767b)) {
            if (iDMCommonAction != null) {
                iDMCommonAction.callback(null);
            }
        }
    }

    public boolean inFrontStatus() {
        return this.f18768c;
    }
}
