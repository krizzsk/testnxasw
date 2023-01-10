package com.didi.map.sdk.sharetrack.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class OrderInfo implements Parcelable {
    public static final Parcelable.Creator<OrderInfo> CREATOR = new Parcelable.Creator<OrderInfo>() {
        public OrderInfo createFromParcel(Parcel parcel) {
            return new OrderInfo(parcel);
        }

        public OrderInfo[] newArray(int i) {
            return new OrderInfo[i];
        }
    };

    /* renamed from: a */
    private long f31101a;

    /* renamed from: b */
    private String f31102b = "";

    /* renamed from: c */
    private int f31103c;

    /* renamed from: d */
    private String f31104d;

    /* renamed from: e */
    private String f31105e;

    public int describeContents() {
        return 0;
    }

    public OrderInfo() {
    }

    protected OrderInfo(Parcel parcel) {
        this.f31101a = parcel.readLong();
        this.f31102b = parcel.readString();
        this.f31103c = parcel.readInt();
        this.f31104d = parcel.readString();
        this.f31105e = parcel.readString();
    }

    public long getPassengerId() {
        return this.f31101a;
    }

    public void setPassengerId(long j) {
        this.f31101a = j;
    }

    public String getOrderId() {
        return this.f31102b;
    }

    public void setOrderId(String str) {
        this.f31102b = str;
    }

    public int getOrderStage() {
        return this.f31103c;
    }

    public void setOrderStage(int i) {
        this.f31103c = i;
    }

    public String getPassengerHeadUrl() {
        return this.f31104d;
    }

    public void setPassengerHeadUrl(String str) {
        this.f31104d = str;
    }

    public String getPassengerPhoneNumber() {
        return this.f31105e;
    }

    public void setPassengerPhoneNumber(String str) {
        this.f31105e = str;
    }

    public String toString() {
        return "OrderInfo{passengerId=" + this.f31101a + ", orderId='" + this.f31102b + '\'' + ", orderStage=" + this.f31103c + ", passengerHeadUrl='" + this.f31104d + '\'' + ", passengerPhoneNumber='" + this.f31105e + '\'' + '}';
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f31101a);
        parcel.writeString(this.f31102b);
        parcel.writeInt(this.f31103c);
        parcel.writeString(this.f31104d);
        parcel.writeString(this.f31105e);
    }
}
