package com.google.p209a.p211b.p212a.p213a.p214a;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.p209a.p210a.C18662a;
import com.google.p209a.p210a.C18665d;

/* renamed from: com.google.a.b.a.a.a.e */
/* compiled from: IInstallServiceCallback */
public abstract class C18670e extends C18662a implements C18668c {
    public C18670e() {
        super("com.google.android.play.core.install.protocol.IInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo138981a(int i, Parcel parcel) throws RemoteException {
        if (i == 1) {
            mo138991a((Bundle) C18665d.m40747a(parcel, Bundle.CREATOR));
        } else if (i == 2) {
            mo138992b((Bundle) C18665d.m40747a(parcel, Bundle.CREATOR));
        } else if (i != 3) {
            return false;
        } else {
            C18665d.m40747a(parcel, Bundle.CREATOR);
            mo138990a();
        }
        return true;
    }
}
