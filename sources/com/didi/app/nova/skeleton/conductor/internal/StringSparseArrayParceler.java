package com.didi.app.nova.skeleton.conductor.internal;

import android.os.Parcel;
import android.os.Parcelable;
import android.util.SparseArray;

public class StringSparseArrayParceler implements Parcelable {
    public static final Parcelable.Creator<StringSparseArrayParceler> CREATOR = new Parcelable.Creator<StringSparseArrayParceler>() {
        public StringSparseArrayParceler createFromParcel(Parcel parcel) {
            return new StringSparseArrayParceler(parcel);
        }

        public StringSparseArrayParceler[] newArray(int i) {
            return new StringSparseArrayParceler[i];
        }
    };

    /* renamed from: a */
    private final SparseArray<String> f10242a;

    public int describeContents() {
        return 0;
    }

    public StringSparseArrayParceler(SparseArray<String> sparseArray) {
        this.f10242a = sparseArray;
    }

    private StringSparseArrayParceler(Parcel parcel) {
        this.f10242a = new SparseArray<>();
        int readInt = parcel.readInt();
        for (int i = 0; i < readInt; i++) {
            this.f10242a.put(parcel.readInt(), parcel.readString());
        }
    }

    public SparseArray<String> getStringSparseArray() {
        return this.f10242a;
    }

    public void writeToParcel(Parcel parcel, int i) {
        int size = this.f10242a.size();
        parcel.writeInt(size);
        for (int i2 = 0; i2 < size; i2++) {
            int keyAt = this.f10242a.keyAt(i2);
            parcel.writeInt(keyAt);
            parcel.writeString(this.f10242a.get(keyAt));
        }
    }
}
