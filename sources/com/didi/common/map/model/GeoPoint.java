package com.didi.common.map.model;

import android.os.Parcel;
import android.os.Parcelable;

public class GeoPoint implements Parcelable {
    public static final Parcelable.Creator<GeoPoint> CREATOR = new Parcelable.Creator<GeoPoint>() {
        public GeoPoint createFromParcel(Parcel parcel) {
            return new GeoPoint(parcel);
        }

        public GeoPoint[] newArray(int i) {
            return new GeoPoint[i];
        }
    };

    /* renamed from: a */
    private int f12649a;

    /* renamed from: b */
    private int f12650b;

    public int describeContents() {
        return 0;
    }

    public GeoPoint() {
        this.f12649a = -35000001;
        this.f12650b = -135000001;
    }

    public GeoPoint(GeoPoint geoPoint) {
        this();
        this.f12649a = geoPoint.f12649a;
        this.f12650b = geoPoint.f12650b;
    }

    public GeoPoint(int i, int i2) {
        this.f12649a = i;
        this.f12650b = i2;
    }

    private GeoPoint(Parcel parcel) {
        this.f12649a = parcel.readInt();
        this.f12650b = parcel.readInt();
    }

    public static GeoPoint formString(String str) {
        GeoPoint geoPoint = new GeoPoint();
        if (str != null) {
            try {
                String[] split = str.split(",");
                if (split.length == 2) {
                    geoPoint.f12649a = Integer.parseInt(split[0]);
                    geoPoint.f12650b = Integer.parseInt(split[1]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return geoPoint;
    }

    public int getLatitudeE6() {
        return this.f12649a;
    }

    public void setLatitudeE6(int i) {
        this.f12649a = i;
    }

    public int getLongitudeE6() {
        return this.f12650b;
    }

    public void setLongitudeE6(int i) {
        this.f12650b = i;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.f12649a = geoPoint.getLatitudeE6();
        this.f12650b = geoPoint.getLongitudeE6();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.f12649a == geoPoint.f12649a && this.f12650b == geoPoint.f12650b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return (((double) this.f12650b) / 1000000.0d) + "," + (((double) this.f12649a) / 1000000.0d);
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f12649a);
        parcel.writeInt(this.f12650b);
    }
}
