package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Locale;
import java.util.Map;

public class tqtqqq extends tqqqqt {
    public static final int b00770077w007700770077 = 300;
    private static final String bw0077w007700770077 = yyyyqy.b0074t007400740074t(tqtqqq.class);
    public long b0077w0077007700770077;
    public long bww0077007700770077;

    public tqtqqq(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            String b00780078x00780078x = yyyyyq.APP_INSTALLATION_TIME.b00780078x00780078x();
            long j = this.bww0077007700770077;
            String str = null;
            map.put(b00780078x00780078x, j == 0 ? null : Long.toString(j));
            String b00780078x00780078x2 = yyyyyq.APP_MODIFICATION_TIME.b00780078x00780078x();
            long j2 = this.b0077w0077007700770077;
            if (j2 != 0) {
                str = Long.toString(j2);
            }
            map.put(b00780078x00780078x2, str);
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null && this.bww0077007700770077 == 0 && this.b0077w0077007700770077 == 0) {
            this.bww0077007700770077 = yyqyyy.bq007100710071qq(ttqqqt.byy0079yyy());
            this.b0077w0077007700770077 = yyqyyy.b0071007100710071qq(ttqqqt.byy0079yyy());
            buuu00750075u();
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_APP_INSTALLATION;
    }

    public void buuu00750075u() {
        long j = this.bww0077007700770077;
        if (j > this.b0077w0077007700770077) {
            this.b0077w0077007700770077 = 0;
            if (j - 0 >= 300) {
                String str = bw0077w007700770077;
                yyyyqy.bt0074007400740074t(str, "App install time is later than modify time: " + String.format(Locale.ENGLISH, "installTime[%d], modifyTime[%d]", new Object[]{Long.valueOf(this.bww0077007700770077), Long.valueOf(this.b0077w0077007700770077)}));
                this.bww0077007700770077 = 0;
            }
        }
    }
}
