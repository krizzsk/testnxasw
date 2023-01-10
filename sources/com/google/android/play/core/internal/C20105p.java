package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;

/* renamed from: com.google.android.play.core.internal.p */
public abstract class C20105p extends C20100k implements C20106q {
    public C20105p() {
        super("com.google.android.play.core.appupdate.protocol.IAppUpdateServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo164262a(int i, Parcel parcel) throws RemoteException {
        if (i == 2) {
            mo163994a((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
            return true;
        } else if (i != 3) {
            return false;
        } else {
            mo163995b((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
            return true;
        }
    }
}
