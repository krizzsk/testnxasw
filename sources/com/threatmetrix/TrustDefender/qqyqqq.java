package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class qqyqqq extends tqqqqt {
    private String b006D006Dmm006Dm;
    private String bm006Dmm006Dm;

    public qqyqqq(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            String b00780078x00780078x = yyyyyq.SUBSCRIBER_CELL_INFO.b00780078x00780078x();
            String str = this.bm006Dmm006Dm;
            String str2 = "";
            map.put(b00780078x00780078x, str == null ? str2 : yqqyqq.biii006900690069(str, 2048));
            String b00780078x00780078x2 = yyyyyq.SUBSCRIBER_CELL_ID.b00780078x00780078x();
            String str3 = this.b006D006Dmm006Dm;
            if (str3 != null) {
                str2 = str3;
            }
            map.put(b00780078x00780078x2, str2);
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null) {
            this.bm006Dmm006Dm = yyqyyy.bq00710071q0071q(ttqqqt.byy0079yyy());
            this.b006D006Dmm006Dm = yyqyyy.b0071q0071q0071q(ttqqqt.byy0079yyy());
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_SUBSCRIBER;
    }
}
