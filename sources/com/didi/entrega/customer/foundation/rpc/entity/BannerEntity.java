package com.didi.entrega.customer.foundation.rpc.entity;

import android.os.Parcel;
import android.os.Parcelable;

public class BannerEntity implements Parcelable, IEntity {
    public static final Parcelable.Creator<BannerEntity> CREATOR = new Parcelable.Creator<BannerEntity>() {
        public BannerEntity createFromParcel(Parcel parcel) {
            return new BannerEntity(parcel);
        }

        public BannerEntity[] newArray(int i) {
            return new BannerEntity[i];
        }
    };
    private static final long serialVersionUID = -7002550069555204355L;

    /* renamed from: id */
    public String f21862id;
    public String img;
    public String url;

    public int describeContents() {
        return 0;
    }

    public String toString() {
        return "BannerEntity: { img = " + this.img + ", url = " + this.url + " }";
    }

    protected BannerEntity(Parcel parcel) {
        this.f21862id = parcel.readString();
        this.img = parcel.readString();
        this.url = parcel.readString();
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f21862id);
        parcel.writeString(this.img);
        parcel.writeString(this.url);
    }
}
