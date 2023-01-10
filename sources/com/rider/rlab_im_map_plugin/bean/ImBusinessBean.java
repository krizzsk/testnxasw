package com.rider.rlab_im_map_plugin.bean;

import android.os.Parcel;
import android.os.Parcelable;
import java.util.HashMap;

public class ImBusinessBean implements Parcelable {
    public static final Parcelable.Creator<ImBusinessBean> CREATOR = new Parcelable.Creator<ImBusinessBean>() {
        public ImBusinessBean createFromParcel(Parcel parcel) {
            return new ImBusinessBean(parcel);
        }

        public ImBusinessBean[] newArray(int i) {
            return new ImBusinessBean[i];
        }
    };

    /* renamed from: a */
    private double f58594a;

    /* renamed from: b */
    private double f58595b;

    /* renamed from: c */
    private int f58596c;

    /* renamed from: d */
    private int f58597d;

    /* renamed from: e */
    private HashMap<String, Object> f58598e;

    /* renamed from: f */
    private HashMap<String, Object> f58599f;

    /* renamed from: g */
    private String f58600g;

    /* renamed from: h */
    private String f58601h;

    /* renamed from: i */
    private String f58602i;

    /* renamed from: j */
    private String f58603j;

    /* renamed from: k */
    private String f58604k;

    public int describeContents() {
        return 0;
    }

    public ImBusinessBean() {
    }

    protected ImBusinessBean(Parcel parcel) {
        ClassLoader classLoader = Object.class.getClassLoader();
        this.f58594a = parcel.readDouble();
        this.f58595b = parcel.readDouble();
        this.f58597d = parcel.readInt();
        this.f58596c = parcel.readInt();
        this.f58598e = parcel.readHashMap(classLoader);
        this.f58600g = parcel.readString();
        this.f58601h = parcel.readString();
        this.f58602i = parcel.readString();
        this.f58603j = parcel.readString();
        this.f58604k = parcel.readString();
        this.f58599f = parcel.readHashMap(classLoader);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeDouble(this.f58594a);
        parcel.writeDouble(this.f58595b);
        parcel.writeInt(this.f58597d);
        parcel.writeInt(this.f58596c);
        parcel.writeMap(this.f58598e);
        parcel.writeString(this.f58600g);
        parcel.writeString(this.f58601h);
        parcel.writeString(this.f58602i);
        parcel.writeString(this.f58603j);
        parcel.writeString(this.f58604k);
        parcel.writeMap(this.f58599f);
    }

    public double getLat() {
        return this.f58594a;
    }

    public void setLat(double d) {
        this.f58594a = d;
    }

    public double getLng() {
        return this.f58595b;
    }

    public void setLng(double d) {
        this.f58595b = d;
    }

    public int getType() {
        return this.f58596c;
    }

    public void setType(int i) {
        this.f58596c = i;
    }

    public int getNav() {
        return this.f58597d;
    }

    public void setNav(int i) {
        this.f58597d = i;
    }

    public String getAddressName() {
        return this.f58600g;
    }

    public void setAddressName(String str) {
        this.f58600g = str;
    }

    public String getSectionName() {
        return this.f58601h;
    }

    public void setSectionName(String str) {
        this.f58601h = str;
    }

    public HashMap<String, Object> getMap() {
        return this.f58598e;
    }

    public void setMap(HashMap<String, Object> hashMap) {
        this.f58598e = hashMap;
    }

    public HashMap<String, Object> getOmegaParams() {
        return this.f58599f;
    }

    public void setOmegaParams(HashMap<String, Object> hashMap) {
        this.f58599f = hashMap;
    }

    public String getNetParams() {
        return this.f58602i;
    }

    public void setNetParams(String str) {
        this.f58602i = str;
    }

    public String getOrderId() {
        return this.f58603j;
    }

    public void setOrderId(String str) {
        this.f58603j = str;
    }

    public String getCOrderId() {
        return this.f58604k;
    }

    public void setCOrderId(String str) {
        this.f58604k = str;
    }
}
