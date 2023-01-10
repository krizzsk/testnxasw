package com.google.android.play.core.assetpacks;

import com.google.android.play.core.tasks.OnFailureListener;

/* renamed from: com.google.android.play.core.assetpacks.h */
final /* synthetic */ class C19997h implements OnFailureListener {

    /* renamed from: a */
    static final OnFailureListener f56007a = new C19997h();

    private C19997h() {
    }

    public final void onFailure(Exception exc) {
        C19999j.f56010a.mo164271d(String.format("Could not sync active asset packs. %s", new Object[]{exc}), new Object[0]);
    }
}
