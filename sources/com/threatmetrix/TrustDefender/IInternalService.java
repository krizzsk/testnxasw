package com.threatmetrix.TrustDefender;

import android.os.Binder;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import com.threatmetrix.TrustDefender.nlunsxbsempjyxm.jkkjkk;
import java.util.ArrayList;
import java.util.List;

public interface IInternalService extends IInterface {

    public static class Default implements IInternalService {
        public IBinder asBinder() {
            return null;
        }

        public List<String> getResults(List<String> list) throws RemoteException {
            return null;
        }
    }

    public static abstract class Stub extends Binder implements IInternalService {
        private static final String b00660066ff0066f = jkkjkk.b0062bbbbbb("ITQ\u0011VIRD?QI@NKAO\u0004)FHEE\u0014442://;u\u0010\u000f38(4/!+\u0011\".1#\u001c\u001d", 'y', 222, 1);
        public static final int bff0066f0066f = 1;

        public private static class yqyyyy implements IInternalService {
            public static IInternalService sDefaultImpl;
            private IBinder b0066f0066f0066f;

            public yqyyyy(IBinder iBinder) {
                this.b0066f0066f0066f = iBinder;
            }

            public IBinder asBinder() {
                return this.b0066f0066f0066f;
            }

            public String getInterfaceDescriptor() {
                return jkkjkk.bb0062bbbbb("LYX\u001aaVaURf`Yih`p'NmqprCeggqhjx5QRxq|p|dw\u0006\u000b~y|", 'h', 4);
            }

            public List<String> getResults(List<String> list) throws RemoteException {
                Parcel obtain = Parcel.obtain();
                Parcel obtain2 = Parcel.obtain();
                try {
                    obtain.writeInterfaceToken(jkkjkk.b0062bbbbbb("Xed&mbma^rleutl|3Zy}|~Oqss}tv\u0005A]^\u0005\f}\f\t|\tp\u0004\u0012\u0017\u000b\u0006\t", 28, '\'', 0));
                    obtain.writeStringList(list);
                    if (!this.b0066f0066f0066f.transact(1, obtain, obtain2, 0) && Stub.getDefaultImpl() != null) {
                        return Stub.getDefaultImpl().getResults(list);
                    }
                    obtain2.readException();
                    ArrayList<String> createStringArrayList = obtain2.createStringArrayList();
                    obtain2.recycle();
                    obtain.recycle();
                    return createStringArrayList;
                } finally {
                    obtain2.recycle();
                    obtain.recycle();
                }
            }
        }

        public Stub() {
            attachInterface(this, jkkjkk.bb0062bbbbb("mxu5zmvhcumdroes(Mjlii8XXV^SS_\u001a43W\\LXSEO5FRUG@A", 'z', 1));
        }

        public static IInternalService asInterface(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface queryLocalInterface = iBinder.queryLocalInterface(jkkjkk.bb0062bbbbb("\u001f*'f,\u001f(\u001a\u0015'\u001f\u0016$!\u0017%Y~\u001c\u001e\u001b\u001bi\n\n\b\u0010\u0005\u0005\u0011Ked\t\u000e}\n\u0005v\u0001fw\u0004\u0007xqr", 161, 1));
            return (queryLocalInterface == null || !(queryLocalInterface instanceof IInternalService)) ? new yqyyyy(iBinder) : (IInternalService) queryLocalInterface;
        }

        public static IInternalService getDefaultImpl() {
            return yqyyyy.sDefaultImpl;
        }

        public static boolean setDefaultImpl(IInternalService iInternalService) {
            if (yqyyyy.sDefaultImpl != null) {
                throw new IllegalStateException(jkkjkk.b0062bbbbbb("\u0018\u000b\u001bk\u000e\u0010\f!\u0019\"w\u001d!\u001eZ\\T\u0019\u0018$%\u001f\u001f[15(#&", 138, 'f', 0));
            } else if (iInternalService == null) {
                return false;
            } else {
                yqyyyy.sDefaultImpl = iInternalService;
                return true;
            }
        }

        public IBinder asBinder() {
            return this;
        }

        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String bb0062bbbbb = jkkjkk.bb0062bbbbb("fsr4{p{ol\u0001zs\u0004\u0003z\u000bAh\b\f\u000b\r]\u0002\u0002\f\u0003\u0005\u0013Okl\u0013\u001a\f\u001a\u0017\u000b\u0017~\u0012 %\u0019\u0014\u0017", 128, 5);
            if (i == 1) {
                parcel.enforceInterface(bb0062bbbbb);
                List<String> results = getResults(parcel.createStringArrayList());
                parcel2.writeNoException();
                parcel2.writeStringList(results);
                return true;
            } else if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            } else {
                parcel2.writeString(bb0062bbbbb);
                return true;
            }
        }
    }

    List<String> getResults(List<String> list) throws RemoteException;
}
