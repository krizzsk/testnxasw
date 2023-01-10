package com.didi.drouter.remote;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.lifecycle.LifecycleOwner;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.Map;

class RemoteCommand implements Parcelable {
    public static final Parcelable.Creator<RemoteCommand> CREATOR = new Parcelable.Creator<RemoteCommand>() {
        public RemoteCommand createFromParcel(Parcel parcel) {
            return new RemoteCommand(parcel);
        }

        public RemoteCommand[] newArray(int i) {
            return new RemoteCommand[i];
        }
    };

    /* renamed from: a */
    static final int f21009a = 0;

    /* renamed from: b */
    static final int f21010b = 1;

    /* renamed from: c */
    static final int f21011c = 2;

    /* renamed from: d */
    static final int f21012d = 3;

    /* renamed from: e */
    int f21013e;

    /* renamed from: f */
    RemoteBridge f21014f;

    /* renamed from: g */
    WeakReference<LifecycleOwner> f21015g;

    /* renamed from: h */
    String f21016h;

    /* renamed from: i */
    IBinder f21017i;

    /* renamed from: j */
    boolean f21018j;

    /* renamed from: k */
    int f21019k;

    /* renamed from: l */
    Bundle f21020l;

    /* renamed from: m */
    Map<String, Object> f21021m;

    /* renamed from: n */
    Class<?> f21022n;

    /* renamed from: o */
    String f21023o;

    /* renamed from: p */
    Object f21024p;

    /* renamed from: q */
    String f21025q;

    /* renamed from: r */
    Object[] f21026r;

    /* renamed from: s */
    Object[] f21027s;

    /* renamed from: t */
    Object[] f21028t;

    /* renamed from: u */
    private final int f21029u;

    public int describeContents() {
        return 0;
    }

    RemoteCommand(int i) {
        this.f21029u = i;
    }

    RemoteCommand(Parcel parcel) {
        Class<RemoteCommand> cls = RemoteCommand.class;
        int readInt = parcel.readInt();
        this.f21029u = readInt;
        if (readInt == 0) {
            this.f21016h = parcel.readString();
            this.f21017i = parcel.readStrongBinder();
            this.f21020l = parcel.readBundle(Bundle.class.getClassLoader());
            this.f21021m = (Map) RemoteStream.m17774b(parcel.readValue(cls.getClassLoader()));
        }
        boolean z = true;
        if (this.f21029u == 1) {
            this.f21018j = parcel.readInt() != 1 ? false : z;
            this.f21019k = parcel.readInt();
            this.f21020l = parcel.readBundle(Bundle.class.getClassLoader());
            this.f21021m = (Map) RemoteStream.m17774b(parcel.readValue(cls.getClassLoader()));
        }
        if (this.f21029u == 2) {
            this.f21022n = (Class) parcel.readSerializable();
            this.f21023o = parcel.readString();
            this.f21024p = RemoteStream.m17774b(parcel.readValue(cls.getClassLoader()));
            this.f21025q = parcel.readString();
            this.f21026r = (Object[]) RemoteStream.m17774b(parcel.readValue(cls.getClassLoader()));
            this.f21027s = (Object[]) RemoteStream.m17774b(parcel.readValue(cls.getClassLoader()));
        }
        if (this.f21029u == 3) {
            this.f21028t = (Object[]) RemoteStream.m17774b(parcel.readValue(cls.getClassLoader()));
        }
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f21029u);
        if (this.f21029u == 0) {
            parcel.writeString(this.f21016h);
            parcel.writeStrongBinder(this.f21017i);
            parcel.writeBundle(this.f21020l);
            parcel.writeValue(RemoteStream.m17772a(this.f21021m));
        }
        if (this.f21029u == 1) {
            parcel.writeInt(this.f21018j ? 1 : 0);
            parcel.writeInt(this.f21019k);
            parcel.writeBundle(this.f21020l);
            parcel.writeValue(RemoteStream.m17772a(this.f21021m));
        }
        if (this.f21029u == 2) {
            parcel.writeSerializable(this.f21022n);
            parcel.writeString(this.f21023o);
            parcel.writeValue(RemoteStream.m17772a(this.f21024p));
            parcel.writeString(this.f21025q);
            parcel.writeValue(RemoteStream.m17772a(this.f21026r));
            parcel.writeValue(RemoteStream.m17772a(this.f21027s));
        }
        if (this.f21029u == 3) {
            parcel.writeValue(RemoteStream.m17772a(this.f21028t));
        }
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof RemoteCommand)) {
            return false;
        }
        RemoteCommand remoteCommand = (RemoteCommand) obj;
        if (this.f21029u != remoteCommand.f21029u || !m17771a(this.f21016h, remoteCommand.f21016h) || !m17771a(this.f21022n, remoteCommand.f21022n) || !m17771a(this.f21023o, remoteCommand.f21023o) || !m17771a(this.f21024p, remoteCommand.f21024p) || !m17771a(this.f21025q, remoteCommand.f21025q) || !m17771a(this.f21014f, remoteCommand.f21014f)) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private static boolean m17771a(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public int hashCode() {
        return Arrays.hashCode(new Object[]{Integer.valueOf(this.f21029u), this.f21016h, this.f21022n, this.f21023o, this.f21024p, this.f21025q, this.f21014f});
    }

    public String toString() {
        int i = this.f21029u;
        if (i == 0) {
            return "request uri: " + this.f21016h;
        } else if (i == 1) {
            return "request result";
        } else {
            if (i == 2) {
                return "service:" + this.f21022n.getSimpleName() + " methodName:" + this.f21025q;
            } else if (i == 3) {
                return "service_callback";
            } else {
                return super.toString();
            }
        }
    }
}
