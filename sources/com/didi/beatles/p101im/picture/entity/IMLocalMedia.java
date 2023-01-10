package com.didi.beatles.p101im.picture.entity;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;

/* renamed from: com.didi.beatles.im.picture.entity.IMLocalMedia */
public class IMLocalMedia implements Parcelable {
    public static final Parcelable.Creator<IMLocalMedia> CREATOR = new Parcelable.Creator<IMLocalMedia>() {
        public IMLocalMedia createFromParcel(Parcel parcel) {
            return new IMLocalMedia(parcel);
        }

        public IMLocalMedia[] newArray(int i) {
            return new IMLocalMedia[i];
        }
    };

    /* renamed from: a */
    private String f11220a;

    /* renamed from: b */
    private String f11221b;

    /* renamed from: c */
    private String f11222c;

    /* renamed from: d */
    private long f11223d;

    /* renamed from: e */
    private boolean f11224e;

    /* renamed from: f */
    private boolean f11225f;

    /* renamed from: g */
    private int f11226g;

    /* renamed from: h */
    private int f11227h;

    /* renamed from: i */
    private String f11228i;

    /* renamed from: j */
    private boolean f11229j;

    /* renamed from: k */
    private int f11230k;

    /* renamed from: l */
    private int f11231l;

    /* renamed from: m */
    private long f11232m;
    public int position;

    public int describeContents() {
        return 0;
    }

    public IMLocalMedia() {
    }

    public IMLocalMedia(String str, long j, int i, String str2) {
        this.f11220a = str;
        this.f11223d = j;
        this.f11227h = i;
        this.f11228i = str2;
    }

    public IMLocalMedia(String str, long j, int i, String str2, int i2, int i3, int i4) {
        this.f11220a = str;
        this.f11223d = j;
        this.f11227h = i;
        this.f11228i = str2;
        this.f11230k = i2;
        this.f11231l = i3;
        this.f11232m = (long) i4;
    }

    public IMLocalMedia(String str, long j, boolean z, int i, int i2, int i3) {
        this.f11220a = str;
        this.f11223d = j;
        this.f11224e = z;
        this.position = i;
        this.f11226g = i2;
        this.f11227h = i3;
    }

    public String getPictureType() {
        if (TextUtils.isEmpty(this.f11228i)) {
            this.f11228i = "image/jpeg";
        }
        return this.f11228i;
    }

    public void setPictureType(String str) {
        this.f11228i = str;
    }

    public String getPath() {
        return this.f11220a;
    }

    public void setPath(String str) {
        this.f11220a = str;
    }

    public String getCompressPath() {
        return this.f11221b;
    }

    public void setCompressPath(String str) {
        this.f11221b = str;
    }

    public String getCutPath() {
        return this.f11222c;
    }

    public void setCutPath(String str) {
        this.f11222c = str;
    }

    public long getDuration() {
        return this.f11223d;
    }

    public void setDuration(long j) {
        this.f11223d = j;
    }

    public boolean isChecked() {
        return this.f11224e;
    }

    public void setChecked(boolean z) {
        this.f11224e = z;
    }

    public boolean isCut() {
        return this.f11225f;
    }

    public void setCut(boolean z) {
        this.f11225f = z;
    }

    public int getPosition() {
        return this.position;
    }

    public void setPosition(int i) {
        this.position = i;
    }

    public int getNum() {
        return this.f11226g;
    }

    public void setNum(int i) {
        this.f11226g = i;
    }

    public int getMimeType() {
        return this.f11227h;
    }

    public void setMimeType(int i) {
        this.f11227h = i;
    }

    public boolean isCompressed() {
        return this.f11229j;
    }

    public void setCompressed(boolean z) {
        this.f11229j = z;
    }

    public int getWidth() {
        return this.f11230k;
    }

    public void setWidth(int i) {
        this.f11230k = i;
    }

    public int getHeight() {
        return this.f11231l;
    }

    public void setHeight(int i) {
        this.f11231l = i;
    }

    public long getSize() {
        return this.f11232m;
    }

    public void setSize(long j) {
        this.f11232m = j;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f11220a);
        parcel.writeString(this.f11221b);
        parcel.writeString(this.f11222c);
        parcel.writeLong(this.f11223d);
        parcel.writeByte(this.f11224e ? (byte) 1 : 0);
        parcel.writeByte(this.f11225f ? (byte) 1 : 0);
        parcel.writeInt(this.position);
        parcel.writeInt(this.f11226g);
        parcel.writeInt(this.f11227h);
        parcel.writeString(this.f11228i);
        parcel.writeByte(this.f11229j ? (byte) 1 : 0);
        parcel.writeInt(this.f11230k);
        parcel.writeInt(this.f11231l);
        parcel.writeLong(this.f11232m);
    }

    protected IMLocalMedia(Parcel parcel) {
        this.f11220a = parcel.readString();
        this.f11221b = parcel.readString();
        this.f11222c = parcel.readString();
        this.f11223d = parcel.readLong();
        boolean z = true;
        this.f11224e = parcel.readByte() != 0;
        this.f11225f = parcel.readByte() != 0;
        this.position = parcel.readInt();
        this.f11226g = parcel.readInt();
        this.f11227h = parcel.readInt();
        this.f11228i = parcel.readString();
        this.f11229j = parcel.readByte() == 0 ? false : z;
        this.f11230k = parcel.readInt();
        this.f11231l = parcel.readInt();
        this.f11232m = parcel.readLong();
    }
}
