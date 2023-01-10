package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class qyyyyq extends tqqqqt {
    public boolean b006100610061a0061a = false;
    public String ba00610061a0061a;

    public qyyyyq(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.PLUGIN_PATH_STR.b00780078x00780078x(), this.b006100610061a0061a ? this.ba00610061a0061a : qqqqyq.bbbbb0062b);
            this.b006100610061a0061a = false;
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null) {
            this.ba00610061a0061a = yyqyyy.b00710071q0071qq(ttqqqt.byy0079yyy());
            this.b006100610061a0061a = true;
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_PLUGIN_DETECTION;
    }
}
