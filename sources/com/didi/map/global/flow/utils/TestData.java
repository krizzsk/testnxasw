package com.didi.map.global.flow.utils;

import com.didi.map.sdk.proto.driver_gl.DoublePoint;
import com.didi.map.sdk.proto.driver_gl.OdPoint;
import java.util.ArrayList;
import java.util.List;

public class TestData {

    /* renamed from: a */
    private static int f29798a;

    public static List getOdPoints() {
        int i = f29798a;
        if (i <= 10) {
            f29798a = i + 1;
            return getOdPoints1();
        } else if (i <= 10 || i > 20) {
            int i2 = f29798a;
            if (i2 <= 20 || i2 > 30) {
                int i3 = f29798a;
                if (i3 <= 30 || i3 > 40) {
                    return getOdPoints1();
                }
                int i4 = i3 + 1;
                f29798a = i4;
                if (i4 == 40) {
                    f29798a = 0;
                }
                return getOdPoints4();
            }
            f29798a = i2 + 1;
            return getOdPoints3();
        } else {
            f29798a = i + 1;
            return getOdPoints2();
        }
    }

    public static List getOdPoints1() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf(-23.568027f)).lng(Float.valueOf(-46.68883f)).build()).pointType(2).odType(2).build());
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf(-23.56643f)).lng(Float.valueOf(-46.68471f)).build()).pointType(2).odType(2).build());
        OdPoint.Builder builder = new OdPoint.Builder();
        DoublePoint.Builder builder2 = new DoublePoint.Builder();
        Float valueOf = Float.valueOf(-23.565403f);
        DoublePoint.Builder lat = builder2.lat(valueOf);
        Float valueOf2 = Float.valueOf(-46.682304f);
        arrayList.add(builder.point(lat.lng(valueOf2).build()).pointType(2).odType(1).build());
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(valueOf).lng(valueOf2).build()).pointType(2).odType(0).build());
        return arrayList;
    }

    public static List getOdPoints2() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf(-23.568027f)).lng(Float.valueOf(-46.68883f)).build()).pointType(2).odType(1).build());
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf(-23.56643f)).lng(Float.valueOf(-46.68471f)).build()).pointType(2).odType(2).build());
        OdPoint.Builder builder = new OdPoint.Builder();
        DoublePoint.Builder builder2 = new DoublePoint.Builder();
        Float valueOf = Float.valueOf(-23.565403f);
        DoublePoint.Builder lat = builder2.lat(valueOf);
        Float valueOf2 = Float.valueOf(-46.682304f);
        arrayList.add(builder.point(lat.lng(valueOf2).build()).pointType(2).odType(2).build());
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(valueOf).lng(valueOf2).build()).pointType(2).odType(0).build());
        return arrayList;
    }

    public static List getOdPoints3() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf(-23.56668f)).lng(Float.valueOf(-46.68532f)).build()).pointType(2).odType(2).build());
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf(-23.56643f)).lng(Float.valueOf(-46.68471f)).build()).pointType(2).odType(2).build());
        OdPoint.Builder builder = new OdPoint.Builder();
        DoublePoint.Builder builder2 = new DoublePoint.Builder();
        Float valueOf = Float.valueOf(-23.565403f);
        DoublePoint.Builder lat = builder2.lat(valueOf);
        Float valueOf2 = Float.valueOf(-46.682304f);
        arrayList.add(builder.point(lat.lng(valueOf2).build()).pointType(2).odType(1).build());
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(valueOf).lng(valueOf2).build()).pointType(2).odType(0).build());
        return arrayList;
    }

    public static List getOdPoints4() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(Float.valueOf(-23.56668f)).lng(Float.valueOf(-46.68532f)).build()).pointType(2).odType(2).build());
        OdPoint.Builder builder = new OdPoint.Builder();
        DoublePoint.Builder builder2 = new DoublePoint.Builder();
        Float valueOf = Float.valueOf(-23.565403f);
        DoublePoint.Builder lat = builder2.lat(valueOf);
        Float valueOf2 = Float.valueOf(-46.682304f);
        arrayList.add(builder.point(lat.lng(valueOf2).build()).pointType(2).odType(1).build());
        arrayList.add(new OdPoint.Builder().point(new DoublePoint.Builder().lat(valueOf).lng(valueOf2).build()).pointType(2).odType(0).build());
        return arrayList;
    }
}
