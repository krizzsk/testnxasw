package com.google.p209a.p211b.p212a.p213a.p214a;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import com.google.p209a.p210a.C18663b;
import com.google.p209a.p210a.C18665d;
import java.util.List;

/* renamed from: com.google.a.b.a.a.a.d */
/* compiled from: IInstallService */
public final class C18669d extends C18663b implements C18667b {
    C18669d(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.install.protocol.IInstallService");
    }

    /* renamed from: a */
    public final void mo138989a(String str, List<Bundle> list, Bundle bundle, C18668c cVar) throws RemoteException {
        Parcel a = mo138984a();
        a.writeString(str);
        a.writeTypedList(list);
        C18665d.m40749a(a, (Parcelable) bundle);
        C18665d.m40748a(a, (IInterface) cVar);
        mo138987b(1, a);
    }

    /* renamed from: a */
    public final void mo138988a(String str, Bundle bundle, C18668c cVar) throws RemoteException {
        Parcel a = mo138984a();
        a.writeString(str);
        C18665d.m40749a(a, (Parcelable) bundle);
        C18665d.m40748a(a, (IInterface) cVar);
        mo138987b(2, a);
    }
}
