package com.google.android.play.core.internal;

import android.os.IBinder;

/* renamed from: com.google.android.play.core.internal.ai */
final /* synthetic */ class C20032ai implements IBinder.DeathRecipient {

    /* renamed from: a */
    private final C20040aq f56064a;

    C20032ai(C20040aq aqVar) {
        this.f56064a = aqVar;
    }

    public final void binderDied() {
        this.f56064a.mo164281c();
    }
}
