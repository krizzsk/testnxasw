package com.didi.aoe.library.core.pojos;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.Arrays;

public final class Message implements Parcelable {
    public static final Parcelable.Creator<Message> CREATOR = new Parcelable.Creator<Message>() {
        public Message createFromParcel(Parcel parcel) {
            return new Message(parcel);
        }

        public Message[] newArray(int i) {
            return new Message[i];
        }
    };

    /* renamed from: a */
    private int f10043a;

    /* renamed from: b */
    private int f10044b;

    /* renamed from: c */
    private byte[] f10045c;

    public int describeContents() {
        return 0;
    }

    public Message() {
    }

    public Message(byte[] bArr) {
        this(1, 0, bArr);
    }

    public Message(int i, int i2, byte[] bArr) {
        this.f10043a = i;
        this.f10044b = i2;
        this.f10045c = bArr;
    }

    private Message(Parcel parcel) {
        this.f10043a = parcel.readInt();
        this.f10044b = parcel.readInt();
        this.f10045c = parcel.createByteArray();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f10043a);
        parcel.writeInt(this.f10044b);
        parcel.writeByteArray(this.f10045c);
    }

    public int getPartNum() {
        return this.f10043a;
    }

    public void setPartNum(int i) {
        this.f10043a = i;
    }

    public int getPartIndex() {
        return this.f10044b;
    }

    public void setPartIndex(int i) {
        this.f10044b = i;
    }

    public byte[] getData() {
        return this.f10045c;
    }

    public void setData(byte[] bArr) {
        this.f10045c = bArr;
    }

    public String toString() {
        return "Message{partNum=" + this.f10043a + ", partIndex=" + this.f10044b + ", data=" + Arrays.toString(this.f10045c) + '}';
    }
}
