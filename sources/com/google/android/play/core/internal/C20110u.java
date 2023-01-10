package com.google.android.play.core.internal;

import android.os.Bundle;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.List;

/* renamed from: com.google.android.play.core.internal.u */
public abstract class C20110u extends C20100k implements C20111v {
    public C20110u() {
        super("com.google.android.play.core.assetpacks.protocol.IAssetModuleServiceCallback");
    }

    /* access modifiers changed from: protected */
    /* renamed from: a */
    public final boolean mo164262a(int i, Parcel parcel) throws RemoteException {
        switch (i) {
            case 2:
                mo164063a(parcel.readInt(), (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 3:
                int readInt = parcel.readInt();
                Bundle bundle = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                mo164062a(readInt);
                return true;
            case 4:
                int readInt2 = parcel.readInt();
                Bundle bundle2 = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                mo164068b(readInt2);
                return true;
            case 5:
                mo164066a((List<Bundle>) parcel.createTypedArrayList(Bundle.CREATOR));
                return true;
            case 6:
                Bundle bundle3 = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                mo164069b((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 7:
                mo164064a((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 8:
                Bundle bundle4 = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                mo164071c((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 10:
                Bundle bundle5 = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                mo164073d((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 11:
                mo164065a((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR), (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 12:
                mo164070b((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR), (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 13:
                mo164072c((Bundle) C20101l.m42320a(parcel, Bundle.CREATOR), (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR));
                return true;
            case 14:
                Bundle bundle6 = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                Bundle bundle7 = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                mo164067b();
                return true;
            case 15:
                Bundle bundle8 = (Bundle) C20101l.m42320a(parcel, Bundle.CREATOR);
                mo164061a();
                return true;
            default:
                return false;
        }
    }
}
