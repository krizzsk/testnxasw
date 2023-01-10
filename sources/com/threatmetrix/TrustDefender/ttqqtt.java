package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.Map;

public class ttqqtt extends tqqqqt {
    private static final String br0072007200720072r = yyyyqy.b0074t007400740074t(ttqqtt.class);
    private String b00720072007200720072r;
    private String brrrrr0072;

    public ttqqtt(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.DEVICE_FONT_COUNT.b00780078x00780078x(), this.brrrrr0072);
            map.put(yyyyyq.DEVICE_FONT_HASH.b00780078x00780078x(), yqqyqq.b006900690069i00690069(this.b00720072007200720072r));
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (this.brrrrr0072 == null || this.b00720072007200720072r == null) {
            StringBuilder sb = new StringBuilder();
            String bqqqqq0071 = yyqyyy.bqqqqq0071(sb);
            this.b00720072007200720072r = bqqqqq0071;
            if (bqqqqq0071 != null) {
                this.brrrrr0072 = sb.toString();
            }
            String str = br0072007200720072r;
            yyyyqy.qyyyqy.bt0074tttt(str, "Got " + this.brrrrr0072 + " fonts gives: " + this.b00720072007200720072r);
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_FONT;
    }
}
