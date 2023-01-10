package com.didi.beatles.p101im.p102db.entity;

import android.os.Parcel;
import android.os.Parcelable;

/* renamed from: com.didi.beatles.im.db.entity.IMMessageDaoEntity */
public class IMMessageDaoEntity implements Parcelable {
    public static final Parcelable.Creator<IMMessageDaoEntity> CREATOR = new Parcelable.Creator<IMMessageDaoEntity>() {
        public IMMessageDaoEntity[] newArray(int i) {
            return new IMMessageDaoEntity[i];
        }

        public IMMessageDaoEntity createFromParcel(Parcel parcel) {
            return new IMMessageDaoEntity(parcel);
        }
    };

    /* renamed from: A */
    private String f11013A;

    /* renamed from: a */
    private Long f11014a;

    /* renamed from: b */
    private long f11015b;

    /* renamed from: c */
    private long f11016c;

    /* renamed from: d */
    private long f11017d;

    /* renamed from: e */
    private int f11018e;

    /* renamed from: f */
    private int f11019f;

    /* renamed from: g */
    private long f11020g;

    /* renamed from: h */
    private long f11021h;

    /* renamed from: i */
    private int f11022i;

    /* renamed from: j */
    private int f11023j;

    /* renamed from: k */
    private int f11024k;

    /* renamed from: l */
    private String f11025l;

    /* renamed from: m */
    private String f11026m;

    /* renamed from: n */
    private String f11027n;

    /* renamed from: o */
    private String f11028o;

    /* renamed from: p */
    private String f11029p;

    /* renamed from: q */
    private String f11030q;

    /* renamed from: r */
    private int f11031r;

    /* renamed from: s */
    private int f11032s;

    /* renamed from: t */
    private int f11033t;

    /* renamed from: u */
    private int f11034u;

    /* renamed from: v */
    private int f11035v;

    /* renamed from: w */
    private Boolean f11036w;

    /* renamed from: x */
    private int f11037x;

    /* renamed from: y */
    private int f11038y;

    /* renamed from: z */
    private String f11039z;

    public int describeContents() {
        return 0;
    }

    public IMMessageDaoEntity() {
    }

    public IMMessageDaoEntity(Long l) {
        this.f11014a = l;
    }

    public IMMessageDaoEntity(Long l, long j, long j2, long j3, int i, int i2, long j4, long j5, int i3, int i4, int i5, String str, String str2, String str3, String str4, String str5, String str6, int i6, int i7, int i8, int i9, int i10, Boolean bool, int i11, int i12, String str7, String str8) {
        this.f11014a = l;
        this.f11015b = j;
        this.f11016c = j2;
        this.f11017d = j3;
        this.f11018e = i;
        this.f11019f = i2;
        this.f11020g = j4;
        this.f11021h = j5;
        this.f11022i = i3;
        this.f11023j = i4;
        this.f11024k = i5;
        this.f11025l = str;
        this.f11026m = str2;
        this.f11027n = str3;
        this.f11028o = str4;
        this.f11029p = str5;
        this.f11030q = str6;
        this.f11031r = i6;
        this.f11032s = i7;
        this.f11033t = i8;
        this.f11034u = i9;
        this.f11035v = i10;
        this.f11036w = bool;
        this.f11037x = i11;
        this.f11038y = i12;
        this.f11039z = str7;
        this.f11013A = str8;
    }

    public Long getId() {
        return this.f11014a;
    }

    public void setId(Long l) {
        this.f11014a = l;
    }

    public long getMessage_id() {
        return this.f11015b;
    }

    public void setMessage_id(long j) {
        this.f11015b = j;
    }

    public long getUnique_id() {
        return this.f11016c;
    }

    public void setUnique_id(long j) {
        this.f11016c = j;
    }

    public String getUnique_cloud_msg_id() {
        return this.f11013A;
    }

    public void setUnique_cloud_msg_id(String str) {
        this.f11013A = str;
    }

    public long getSession_id() {
        return this.f11017d;
    }

    public void setSession_id(long j) {
        this.f11017d = j;
    }

    public int getType() {
        return this.f11018e;
    }

    public void setType(int i) {
        this.f11018e = i;
    }

    public int getCategory() {
        return this.f11019f;
    }

    public void setCategory(int i) {
        this.f11019f = i;
    }

    public long getSend_uid() {
        return this.f11020g;
    }

    public void setSend_uid(long j) {
        this.f11020g = j;
    }

    public long getCreate_time() {
        return this.f11021h;
    }

    public void setCreate_time(long j) {
        this.f11021h = j;
    }

    public int getBusiness_id() {
        return this.f11022i;
    }

    public void setBusiness_id(int i) {
        this.f11022i = i;
    }

    public int getPriority() {
        return this.f11023j;
    }

    public void setPriority(int i) {
        this.f11023j = i;
    }

    public int getStatus() {
        return this.f11024k;
    }

    public void setStatus(int i) {
        this.f11024k = i;
    }

    public String getText_content() {
        return this.f11025l;
    }

    public void setText_content(String str) {
        this.f11025l = str;
    }

    public String getFile_uri() {
        return this.f11026m;
    }

    public void setFile_uri(String str) {
        this.f11026m = str;
    }

    public String getGift_ns() {
        return this.f11027n;
    }

    public void setGift_ns(String str) {
        this.f11027n = str;
    }

    public String getGift_ftoken() {
        return this.f11028o;
    }

    public void setGift_ftoken(String str) {
        this.f11028o = str;
    }

    public String getGift_fid() {
        return this.f11029p;
    }

    public void setGift_fid(String str) {
        this.f11029p = str;
    }

    public String getFile_name() {
        return this.f11030q;
    }

    public void setFile_name(String str) {
        this.f11030q = str;
    }

    public int getHeight() {
        return this.f11031r;
    }

    public void setHeight(int i) {
        this.f11031r = i;
    }

    public int getWidth() {
        return this.f11032s;
    }

    public void setWidth(int i) {
        this.f11032s = i;
    }

    public int getSec() {
        return this.f11033t;
    }

    public void setSec(int i) {
        this.f11033t = i;
    }

    public int getSize() {
        return this.f11034u;
    }

    public void setSize(int i) {
        this.f11034u = i;
    }

    public int getSys_type() {
        return this.f11035v;
    }

    public void setSys_type(int i) {
        this.f11035v = i;
    }

    public Boolean getIsRead() {
        return this.f11036w;
    }

    public void setIsRead(Boolean bool) {
        this.f11036w = bool;
    }

    public int getReserveInt1() {
        return this.f11037x;
    }

    public void setReserveInt1(int i) {
        this.f11037x = i;
    }

    public int getReserveInt2() {
        return this.f11038y;
    }

    public void setReserveInt2(int i) {
        this.f11038y = i;
    }

    public String getReserveStr3() {
        return this.f11039z;
    }

    public void setReserveStr3(String str) {
        this.f11039z = str;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeLong(this.f11014a.longValue());
        parcel.writeLong(this.f11015b);
        parcel.writeLong(this.f11016c);
        parcel.writeLong(this.f11017d);
        parcel.writeInt(this.f11018e);
        parcel.writeInt(this.f11019f);
        parcel.writeLong(this.f11020g);
        parcel.writeLong(this.f11021h);
        parcel.writeInt(this.f11022i);
        parcel.writeInt(this.f11023j);
        parcel.writeInt(this.f11024k);
        parcel.writeString(this.f11025l);
        parcel.writeString(this.f11026m);
        parcel.writeString(getGift_ns());
        parcel.writeString(this.f11028o);
        parcel.writeString(this.f11029p);
        parcel.writeString(this.f11030q);
        parcel.writeInt(this.f11031r);
        parcel.writeInt(this.f11032s);
        parcel.writeInt(this.f11033t);
        parcel.writeInt(this.f11034u);
        parcel.writeInt(this.f11035v);
        parcel.writeByte(this.f11036w.booleanValue() ? (byte) 1 : 0);
        parcel.writeInt(this.f11037x);
        parcel.writeInt(this.f11038y);
        parcel.writeString(this.f11039z);
        parcel.writeString(this.f11013A);
    }

    public IMMessageDaoEntity(Parcel parcel) {
        this.f11014a = Long.valueOf(parcel.readLong());
        this.f11015b = parcel.readLong();
        this.f11016c = parcel.readLong();
        this.f11017d = parcel.readLong();
        this.f11018e = parcel.readInt();
        this.f11019f = parcel.readInt();
        this.f11020g = parcel.readLong();
        this.f11021h = parcel.readLong();
        this.f11022i = parcel.readInt();
        this.f11023j = parcel.readInt();
        this.f11024k = parcel.readInt();
        this.f11025l = parcel.readString();
        this.f11026m = parcel.readString();
        this.f11027n = parcel.readString();
        this.f11028o = parcel.readString();
        this.f11029p = parcel.readString();
        this.f11030q = parcel.readString();
        this.f11031r = parcel.readInt();
        this.f11032s = parcel.readInt();
        this.f11033t = parcel.readInt();
        this.f11034u = parcel.readInt();
        this.f11035v = parcel.readInt();
        this.f11036w = Boolean.valueOf(parcel.readByte() != 0);
        this.f11037x = parcel.readInt();
        this.f11038y = parcel.readInt();
        this.f11039z = parcel.readString();
        this.f11013A = parcel.readString();
    }
}
