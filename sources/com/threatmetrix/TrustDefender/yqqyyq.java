package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.List;
import java.util.Map;

public class yqqyyq extends tqqqqt {
    public String b0061006100610061a0061;
    public String ba006100610061a0061;

    public yqqyyq(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.ROOT_DETECTION_PATH_COUNT.b00780078x00780078x(), this.ba006100610061a0061);
            map.put(yyyyyq.ROOT_DETECTION_PATH_STR.b00780078x00780078x(), yqqyqq.biii006900690069(this.b0061006100610061a0061, 2048));
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null && ttqqqt.b00790079y0079yy() != null && !ttqqqt.b00790079y0079yy().b006D006D006Dm006D006D.isEmpty()) {
            List<String> b0071qq0071qq = yyqyyy.b0071qq0071qq(ttqqqt.byy0079yyy(), ttqqqt.b00790079y0079yy().b006D006D006Dm006D006D);
            this.ba006100610061a0061 = String.valueOf(b0071qq0071qq.size());
            this.b0061006100610061a0061 = yqqyqq.bii00690069i0069(b0071qq0071qq, ";", true);
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_ROOT_DETECTION;
    }
}
