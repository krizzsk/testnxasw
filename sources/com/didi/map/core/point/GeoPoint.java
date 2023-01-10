package com.didi.map.core.point;

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
    private int f27006a;

    /* renamed from: b */
    private int f27007b;

    public int describeContents() {
        return 0;
    }

    public GeoPoint() {
        this.f27006a = -35000001;
        this.f27007b = -135000001;
    }

    public GeoPoint(GeoPoint geoPoint) {
        this();
        this.f27006a = geoPoint.f27006a;
        this.f27007b = geoPoint.f27007b;
    }

    public GeoPoint(int i, int i2) {
        this.f27006a = i;
        this.f27007b = i2;
    }

    public int getLatitudeE6() {
        return this.f27006a;
    }

    public int getLongitudeE6() {
        return this.f27007b;
    }

    public void setLatitudeE6(int i) {
        this.f27006a = i;
    }

    public void setLongitudeE6(int i) {
        this.f27007b = i;
    }

    public void setGeoPoint(GeoPoint geoPoint) {
        this.f27006a = geoPoint.getLatitudeE6();
        this.f27007b = geoPoint.getLongitudeE6();
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof GeoPoint)) {
            return false;
        }
        GeoPoint geoPoint = (GeoPoint) obj;
        if (this.f27006a == geoPoint.f27006a && this.f27007b == geoPoint.f27007b) {
            return true;
        }
        return false;
    }

    public String toString() {
        return (((double) this.f27007b) / 1000000.0d) + "," + (((double) this.f27006a) / 1000000.0d);
    }

    public static GeoPoint formString(String str) {
        GeoPoint geoPoint = new GeoPoint();
        if (str != null) {
            try {
                String[] split = str.split(",");
                if (split.length == 2) {
                    geoPoint.f27006a = Integer.parseInt(split[0]);
                    geoPoint.f27007b = Integer.parseInt(split[1]);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return geoPoint;
    }

    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.f27006a);
        parcel.writeInt(this.f27007b);
    }

    private GeoPoint(Parcel parcel) {
        this.f27006a = parcel.readInt();
        this.f27007b = parcel.readInt();
    }
}
