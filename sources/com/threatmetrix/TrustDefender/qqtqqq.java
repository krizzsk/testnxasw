package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class qqtqqq extends tqqqqt {
    private String b0077ww007700770077;

    public qqtqqq(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null && yqqyqq.b006900690069ii0069(this.b0077ww007700770077)) {
            map.put(yyyyyq.ADVERTISING_ID.b00780078x00780078x(), this.b0077ww007700770077);
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null) {
            if (yqqyqq.b0069ii0069i0069(ttqqqt.b00790079yyyy())) {
                this.b0077ww007700770077 = ttqqqt.b00790079yyyy();
            } else if (yqqyqq.bi0069i0069i0069(this.b0077ww007700770077)) {
                this.b0077ww007700770077 = yyqyyy.b0071q00710071qq(ttqqqt.byy0079yyy());
            }
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_ADVERTISING_ID;
    }
}
