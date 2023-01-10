package com.didi.map.sdk.nav.car;

import com.didi.common.map.MapVendor;
import com.didi.common.map.util.DLog;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;

public class DriverCarNewAnimApollo {

    /* renamed from: a */
    private static final String f30841a = "DriverCarNewAnimApollo";

    /* renamed from: b */
    private MapVendor f30842b;

    /* renamed from: c */
    private boolean f30843c;

    /* renamed from: d */
    private float f30844d;

    /* renamed from: e */
    private float f30845e;

    /* renamed from: f */
    private int f30846f;

    /* renamed from: g */
    private int f30847g;

    /* renamed from: h */
    private float f30848h;

    /* renamed from: i */
    private float f30849i;

    /* renamed from: j */
    private float f30850j;

    private static class Holder {
        static DriverCarNewAnimApollo instance = new DriverCarNewAnimApollo();

        private Holder() {
        }
    }

    public static DriverCarNewAnimApollo getInstance() {
        return Holder.instance;
    }

    private DriverCarNewAnimApollo() {
        this.f30843c = false;
        this.f30844d = 0.6f;
        this.f30845e = 0.6f;
        this.f30846f = 35;
        this.f30847g = 30;
        this.f30848h = 16.5f;
        this.f30849i = 18.25f;
        this.f30850j = 1.1f;
        IToggle toggle = Apollo.getToggle("global_map_driver_car_up_anim_opt_ab");
        if (toggle == null || !toggle.allow()) {
            this.f30843c = false;
            DLog.m10773d(f30841a, "global_map_driver_car_up_anim_opt_ab not allow", new Object[0]);
        } else if (toggle.getExperiment() != null) {
            try {
                boolean z = true;
                if (((Integer) toggle.getExperiment().getParam("enable", 0)).intValue() != 1) {
                    z = false;
                }
                this.f30843c = z;
                this.f30844d = Float.parseFloat((String) toggle.getExperiment().getParam("car_padding_top_ratio_google", "0.6"));
                this.f30845e = Float.parseFloat((String) toggle.getExperiment().getParam("car_padding_top_ratio_hawaii", "0.6"));
                this.f30846f = ((Integer) toggle.getExperiment().getParam("map_tilt_google", 35)).intValue();
                this.f30847g = ((Integer) toggle.getExperiment().getParam("map_tilt_hawaii", 30)).intValue();
                this.f30848h = Float.parseFloat((String) toggle.getExperiment().getParam("max_zoom_google", "16.5"));
                this.f30849i = Float.parseFloat((String) toggle.getExperiment().getParam("max_zoom_hawaii", "18.25"));
                this.f30850j = Float.parseFloat((String) toggle.getExperiment().getParam("car_zoom_ratio", "1.1"));
                DLog.m10773d(f30841a, "global_map_driver_car_up_anim_opt_ab allow and param: " + m23720a(), new Object[0]);
            } catch (Exception e) {
                DLog.m10773d(f30841a, " apllo exc: " + e.getMessage(), new Object[0]);
            }
        } else {
            this.f30843c = false;
            DLog.m10773d(f30841a, "global_map_driver_car_up_anim_opt_ab allow but with error", new Object[0]);
        }
    }

    public boolean enable() {
        return this.f30842b != MapVendor.HUAWEI && this.f30843c;
    }

    public void setMapVendor(MapVendor mapVendor) {
        DLog.m10773d(f30841a, "DriverCarAnim vendor: " + mapVendor, new Object[0]);
        this.f30842b = mapVendor;
    }

    public float getCarPaddingTopRatio() {
        if (this.f30842b == MapVendor.DIDI) {
            return this.f30845e;
        }
        return this.f30844d;
    }

    public int getMapTiltValue() {
        int i;
        if (this.f30842b == MapVendor.DIDI) {
            i = this.f30847g;
        } else {
            i = this.f30846f;
        }
        if (i < 0 || i >= 90) {
            return 45;
        }
        return i;
    }

    public float getMaxZoomLevel() {
        if (this.f30842b == MapVendor.DIDI) {
            return this.f30849i;
        }
        return this.f30848h;
    }

    public float getCarZoomRatio() {
        return this.f30850j;
    }

    /* renamed from: a */
    private String m23720a() {
        return "DriverCarNewAnimApollo{enable=" + this.f30843c + ", car_padding_top_ratio_google=" + this.f30844d + ", car_padding_top_ratio_hawaii=" + this.f30845e + ", map_tilt_google=" + this.f30846f + ", map_tilt_hawaii=" + this.f30847g + ", max_zoom_google=" + this.f30848h + ", max_zoom_hawaii=" + this.f30849i + ", car_zoom_ratio=" + this.f30850j + '}';
    }
}
