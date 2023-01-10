package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bt */
public final class C20070bt extends C20099j implements C20072bv {
    C20070bt(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.splitinstall.protocol.ISplitInstallService");
    }

    /* renamed from: a */
    public final void mo164298a(String str, int i, Bundle bundle, C20074bx bxVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        a.writeInt(i);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) bxVar);
        mo164353a(4, a);
    }

    /* renamed from: a */
    public final void mo164299a(String str, int i, C20074bx bxVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        a.writeInt(i);
        C20101l.m42321a(a, (IInterface) bxVar);
        mo164353a(5, a);
    }

    /* renamed from: a */
    public final void mo164300a(String str, C20074bx bxVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42321a(a, (IInterface) bxVar);
        mo164353a(6, a);
    }

    /* renamed from: a */
    public final void mo164301a(String str, List<Bundle> list, Bundle bundle, C20074bx bxVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        a.writeTypedList(list);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) bxVar);
        mo164353a(2, a);
    }

    /* renamed from: b */
    public final void mo164302b(String str, List<Bundle> list, Bundle bundle, C20074bx bxVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        a.writeTypedList(list);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) bxVar);
        mo164353a(7, a);
    }

    /* renamed from: c */
    public final void mo164303c(String str, List<Bundle> list, Bundle bundle, C20074bx bxVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        a.writeTypedList(list);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) bxVar);
        mo164353a(8, a);
    }

    /* renamed from: d */
    public final void mo164304d(String str, List<Bundle> list, Bundle bundle, C20074bx bxVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        a.writeTypedList(list);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) bxVar);
        mo164353a(13, a);
    }

    /* renamed from: e */
    public final void mo164305e(String str, List<Bundle> list, Bundle bundle, C20074bx bxVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        a.writeTypedList(list);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) bxVar);
        mo164353a(14, a);
    }
}
