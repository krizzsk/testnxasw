package com.didichuxing.carsliding.model;

import android.text.TextUtils;
import com.didi.common.map.model.BitmapDescriptor;

public class Driver {

    /* renamed from: a */
    private String f48913a;

    /* renamed from: b */
    private BitmapDescriptor f48914b;

    /* renamed from: c */
    private VectorCoordinateList f48915c;

    public Driver(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f48913a = str;
            return;
        }
        throw new NullPointerException("The id can't be Null!");
    }

    public String getId() {
        return this.f48913a;
    }

    public BitmapDescriptor getBitmap() {
        return this.f48914b;
    }

    public void setBitmap(BitmapDescriptor bitmapDescriptor) {
        this.f48914b = bitmapDescriptor;
    }

    public VectorCoordinateList getVectorCoordinateList() {
        return this.f48915c;
    }

    public void setVectorCoordinateList(VectorCoordinateList vectorCoordinateList) {
        this.f48915c = vectorCoordinateList;
    }

    public boolean equals(Object obj) {
        if (obj == null || !(obj instanceof Driver)) {
            return false;
        }
        Driver driver = (Driver) obj;
        if (TextUtils.isEmpty(this.f48913a) || TextUtils.isEmpty(driver.getId())) {
            return false;
        }
        return this.f48913a.equals(driver.getId());
    }

    public int hashCode() {
        if (TextUtils.isEmpty(this.f48913a)) {
            return 0;
        }
        return this.f48913a.hashCode();
    }

    public String toString() {
        return "{id=" + this.f48913a + "vectorCoordinateList=" + this.f48915c + "}";
    }
}
