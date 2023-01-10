package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class tqqtqt extends tqqqqt {
    private String b0072rr0072rr;
    private int brrr0072rr = 0;

    public tqqtqt(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.DEVICE_ENCRYPTION_STATUS.b00780078x00780078x(), String.valueOf(this.brrr0072rr));
            map.put(yyyyyq.DEVICE_DEV_ENABLED_STATUS.b00780078x00780078x(), this.b0072rr0072rr);
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null) {
            this.brrr0072rr = yyqyyy.b00710071q00710071q(ttqqqt.byy0079yyy());
            String bq0071q00710071q = yyqyyy.bq0071q00710071q(ttqqqt.byy0079yyy());
            this.b0072rr0072rr = bq0071q00710071q;
            if (bq0071q00710071q != null) {
                this.b0072rr0072rr = String.valueOf(bq0071q00710071q.compareTo("1") == 0);
            }
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_DEVICE_ENCRYPT_AND_STATUS;
    }
}
