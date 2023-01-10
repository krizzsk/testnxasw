package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class qqyyqq extends tqqqqt {
    public int b00620062006200620062b;
    public String b0062b006200620062b;
    public int bb0062006200620062b;
    public String bbb006200620062b;

    public qqyyqq(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            if (yqqyqq.b0069ii0069i0069(this.bbb006200620062b)) {
                map.put(yyyyyq.DEVICE_SIM_IMEI_1.b00780078x00780078x(), yqqyqq.b006900690069i00690069(this.bbb006200620062b));
            }
            if (yqqyqq.b0069ii0069i0069(this.b0062b006200620062b)) {
                map.put(yyyyyq.DEVICE_SIM_IMEI_2.b00780078x00780078x(), yqqyqq.b006900690069i00690069(this.b0062b006200620062b));
            }
            if (this.bb0062006200620062b != 0) {
                map.put(yyyyyq.DEVICE_SIM_STATE_1.b00780078x00780078x(), String.valueOf(this.bb0062006200620062b));
            }
            if (this.b00620062006200620062b != 0) {
                map.put(yyyyyq.DEVICE_SIM_STATE_2.b00780078x00780078x(), String.valueOf(this.b00620062006200620062b));
            }
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) {
        if (ttqqqt.byy0079yyy() != null && this.bb0062006200620062b == 0) {
            this.bbb006200620062b = jkkjjj.b0068h0068h00680068(ttqqqt.byy0079yyy(), 0);
            this.bb0062006200620062b = jkkjjj.bh0068h006800680068(ttqqqt.byy0079yyy(), 0);
            String b0068h0068h00680068 = jkkjjj.b0068h0068h00680068(ttqqqt.byy0079yyy(), 1);
            this.b0062b006200620062b = b0068h0068h00680068;
            if (!yqqyqq.b0069ii0069i0069(b0068h0068h00680068) || !yqqyqq.b0069ii0069i0069(this.bbb006200620062b) || !this.b0062b006200620062b.equals(this.bbb006200620062b)) {
                this.b00620062006200620062b = jkkjjj.bh0068h006800680068(ttqqqt.byy0079yyy(), 1);
                return;
            }
            this.b0062b006200620062b = "";
            this.b00620062006200620062b = 0;
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_SIM;
    }
}
