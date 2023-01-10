package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.r */
public final class C20107r extends C20099j implements C20109t {
    C20107r(IBinder iBinder) {
        super(iBinder, "com.google.android.play.core.assetpacks.protocol.IAssetModuleService");
    }

    /* renamed from: a */
    public final void mo164359a(String str, Bundle bundle, Bundle bundle2, C20111v vVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42322a(a, (Parcelable) bundle2);
        C20101l.m42321a(a, (IInterface) vVar);
        mo164353a(6, a);
    }

    /* renamed from: a */
    public final void mo164360a(String str, Bundle bundle, C20111v vVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) vVar);
        mo164353a(5, a);
    }

    /* renamed from: a */
    public final void mo164361a(String str, List<Bundle> list, Bundle bundle, C20111v vVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        a.writeTypedList(list);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) vVar);
        mo164353a(2, a);
    }

    /* renamed from: b */
    public final void mo164362b(String str, Bundle bundle, Bundle bundle2, C20111v vVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42322a(a, (Parcelable) bundle2);
        C20101l.m42321a(a, (IInterface) vVar);
        mo164353a(7, a);
    }

    /* renamed from: b */
    public final void mo164363b(String str, Bundle bundle, C20111v vVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) vVar);
        mo164353a(10, a);
    }

    /* renamed from: b */
    public final void mo164364b(String str, List<Bundle> list, Bundle bundle, C20111v vVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        a.writeTypedList(list);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) vVar);
        mo164353a(14, a);
    }

    /* renamed from: c */
    public final void mo164365c(String str, Bundle bundle, Bundle bundle2, C20111v vVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42322a(a, (Parcelable) bundle2);
        C20101l.m42321a(a, (IInterface) vVar);
        mo164353a(9, a);
    }

    /* renamed from: c */
    public final void mo164366c(String str, List<Bundle> list, Bundle bundle, C20111v vVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        a.writeTypedList(list);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42321a(a, (IInterface) vVar);
        mo164353a(12, a);
    }

    /* renamed from: d */
    public final void mo164367d(String str, Bundle bundle, Bundle bundle2, C20111v vVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42322a(a, (Parcelable) bundle2);
        C20101l.m42321a(a, (IInterface) vVar);
        mo164353a(11, a);
    }

    /* renamed from: e */
    public final void mo164368e(String str, Bundle bundle, Bundle bundle2, C20111v vVar) throws RemoteException {
        Parcel a = mo164352a();
        a.writeString(str);
        C20101l.m42322a(a, (Parcelable) bundle);
        C20101l.m42322a(a, (Parcelable) bundle2);
        C20101l.m42321a(a, (IInterface) vVar);
        mo164353a(13, a);
    }
}
