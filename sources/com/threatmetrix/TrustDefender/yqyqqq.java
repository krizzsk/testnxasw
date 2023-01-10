package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.Map;

public class yqyqqq extends tqqqqt {
    private static final String bmmmm006Dm = yyyyqy.b0074t007400740074t(yqyqqq.class);
    private qqqyqq b006Dmmm006Dm = null;

    public yqyqqq(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        qqqyqq qqqyqq;
        if (map != null && (qqqyqq = this.b006Dmmm006Dm) != null) {
            map.putAll(qqqyqq.b0069i0069006900690069());
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        String str;
        if (map != null && ttqqqt.byyy0079yy() != null && ttqqqt.byy0079yyy() != null && ttqqqt.b00790079y0079yy() != null) {
            String str2 = "";
            String str3 = map.get(yyyyyq.FIREBASE_PUSH_TOKEN.b00780078x00780078x());
            if (str3 != null) {
                str2 = str2.concat(str3);
            }
            String str4 = map.get(yyyyyq.FINGERPRINT_CAPS.b00780078x00780078x());
            if (str4 != null) {
                str2 = str2.concat(str4);
            }
            if (!(ttqqqt.b0079y0079yyy() == null || (str = ttqqqt.b0079y0079yyy().get(yyyyyq.STRONG_AUTH_STATUS.b00780078x00780078x())) == null)) {
                str2 = str2.concat(str);
            }
            qqqtqq btt0074007400740074 = ttqqqt.byyy0079yy().btt0074007400740074();
            if (btt0074007400740074 != null && btt0074007400740074.buuuuu0075()) {
                this.b006Dmmm006Dm = btt0074007400740074.buu007500750075u(ttqqqt.b00790079y0079yy().b006D006Dmm006D006D, str2, ttqqqt.byy0079yyy().bll006C006C006C006C);
            } else if (yyyqqq.isAvailable(ttqqqt.byy0079yyy().bll006C006C006C006C)) {
                this.b006Dmmm006Dm = yyyqqq.bi00690069006900690069(ttqqqt.b00790079y0079yy().b006D006Dmm006D006D, ttqqqt.byy0079yyy(), str2);
                yyyyqy.qyyyqy.bt0074tttt(bmmmm006Dm, "Hardware key is available");
            }
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_STRONG_ID;
    }
}
