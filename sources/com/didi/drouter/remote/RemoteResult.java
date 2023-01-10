package com.didi.drouter.remote;

import android.os.Parcel;
import android.os.Parcelable;

class RemoteResult implements Parcelable {
    public static final Parcelable.Creator<RemoteResult> CREATOR = new Parcelable.Creator<RemoteResult>() {
        public RemoteResult createFromParcel(Parcel parcel) {
            return new RemoteResult(parcel);
        }

        public RemoteResult[] newArray(int i) {
            return new RemoteResult[i];
        }
    };

    /* renamed from: a */
    static final String f21036a = "executing";

    /* renamed from: b */
    static final String f21037b = "success";

    /* renamed from: c */
    static final String f21038c = "fail";

    /* renamed from: d */
    String f21039d;

    /* renamed from: e */
    Object f21040e;

    public int describeContents() {
        return 0;
    }

    RemoteResult(String str) {
        this.f21039d = str;
    }

    RemoteResult(Parcel parcel) {
        this.f21039d = parcel.readString();
        this.f21040e = RemoteStream.m17774b(parcel.readValue(RemoteResult.class.getClassLoader()));
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f21039d);
        parcel.writeValue(RemoteStream.m17772a(this.f21040e));
    }
}
