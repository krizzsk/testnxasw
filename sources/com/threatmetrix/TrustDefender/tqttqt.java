package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class tqttqt extends tqqqqt {
    private long b0072007200720072rr;
    private long b0072r00720072rr;
    private String b0072rrr0072r;
    private long br007200720072rr;
    private String brrrr0072r;

    public tqttqt(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.DEVICE_STATE.b00780078x00780078x(), yqqyqq.b006900690069i00690069(this.brrrr0072r));
            String b00780078x00780078x = yyyyyq.DEVICE_BOOT_TIME.b00780078x00780078x();
            long j = this.b0072r00720072rr;
            String str = "";
            map.put(b00780078x00780078x, j == 0 ? str : String.valueOf(j));
            String b00780078x00780078x2 = yyyyyq.DEVICE_FREE_SPACE.b00780078x00780078x();
            long j2 = this.br007200720072rr;
            map.put(b00780078x00780078x2, j2 == 0 ? str : String.valueOf(j2));
            String b00780078x00780078x3 = yyyyyq.DEVICE_TOTAL_SPACE.b00780078x00780078x();
            long j3 = this.b0072007200720072rr;
            if (j3 != 0) {
                str = String.valueOf(j3);
            }
            map.put(b00780078x00780078x3, str);
            map.put(yyyyyq.DEVICE_BATTERY_STATUS.b00780078x00780078x(), this.b0072rrr0072r);
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null) {
            this.b0072rrr0072r = yqqyqq.b0069i006900690069i(yyqyyy.bq0071qq0071q(ttqqqt.byy0079yyy()));
            this.b0072r00720072rr = yyqyyy.b00710071qq0071q();
            this.br007200720072rr = yyqyyy.bq0071qqq0071();
            this.b0072007200720072rr = yyqyyy.b0071qqq00710071();
            this.brrrr0072r = yyqyyy.b0071q007100710071q(this.br007200720072rr, this.b0072r00720072rr);
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_DEVICE_STATE;
    }
}
