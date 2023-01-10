package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.Map;

public class qqtqqt extends tqqqqt {
    private static final String bl006Cl006C006C006C = yyyyqy.b0074t007400740074t(qqtqqt.class);
    public String b006C006Cl006C006C006C;

    public qqtqqt(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.CONNECTIONS_INFO.b00780078x00780078x(), yqqyqq.biii006900690069(this.b006C006Cl006C006C006C, 1024));
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        String str;
        if (ttqqqt.byy0079yyy() != null) {
            String b00670067gg0067g = qqqyqy.bg00670067g0067g().b00670067gg0067g(ttqqqt.byy0079yyy());
            this.b006C006Cl006C006C006C = b00670067gg0067g;
            String str2 = bl006Cl006C006C006C;
            if (b00670067gg0067g == null) {
                str = "No connections info";
            } else {
                str = "Get connections info" + this.b006C006Cl006C006C006C;
            }
            yyyyqy.qyyyqy.bt0074tttt(str2, str);
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_CONNECTIONS;
    }
}
