package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.bw */
public abstract class C20073bw extends C20100k implements C20074bx {
    public C20073bw() {
        super("com.google.android.play.core.splitinstall.protocol.ISplitInstallServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo164262a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                mo164314c(parcel.readInt(), (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                mo164307a(readInt);
                return true;
            case 4:
                mo164308a(parcel.readInt(), (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 5:
                mo164312b(parcel.readInt(), (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 6:
                mo164317e((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                mo164310a((List<Bundle>) parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 8:
                mo164316d((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 9:
                mo164309a((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Bundle bundle2 = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                mo164311b();
                return true;
            case 11:
                Bundle bundle3 = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                mo164306a();
                return true;
            case 12:
                mo164313b((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                mo164315c((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            default:
                return false;
        }
    }
}
