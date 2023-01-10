package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.ad */
public abstract class C20027ad extends C20100k implements C20028ae {
    public C20027ad() {
        super("com.google.android.play.core.inappreview.protocol.IInAppReviewServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo164262a(int i, Parcel parcel) throws RemoteException {
        if (i != 2) {
            return false;
        }
        mo164263a((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
        return true;
    }
}
