package com.google.maps.android.data.kml;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.google.maps.android.data.Geometry;
import com.google.maps.android.data.MultiGeometry;
import java.util.ArrayList;

public class KmlMultiGeometry extends MultiGeometry {
    public KmlMultiGeometry(ArrayList<Geometry> arrayList) {
        super(arrayList);
    }

    public ArrayList<Geometry> getGeometryObject() {
        return new ArrayList<>(super.getGeometryObject());
    }

    public String toString() {
        return getGeometryType() + Const.joLeft + "\n geometries=" + getGeometryObject() + "\n}\n";
    }
}
