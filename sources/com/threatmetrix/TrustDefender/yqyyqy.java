package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.Map;
import javax.annotation.Nonnull;

public class yqyyqy extends tqqqqt {
    private static final String b0070007000700070pp = "SHENASE_H";
    private static final int b00700070p0070pp = 1;
    private static final int b0070p00700070pp = 4;
    private static final String b0070ppp0070p = "SHENASE_A";
    private static final String bp007000700070pp = "SHENASE_D";
    private static final String bp0070p0070pp = yyyyqy.b0074t007400740074t(yqyyqy.class);
    private static final int bpp00700070pp = 2;
    private static final String bpppp0070p = "SHENASE_S";
    public int bp0070pp0070p;

    public yqyyqy(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    public static boolean b0074tt0074t0074() {
        return tqttqq.ttttqq.qqqqtq.b006E006En006En006E <= 28;
    }

    private int bt0074t0074t0074(@Nonnull tqtqqt tqtqqt, String str, String str2, String str3, String str4, String str5) {
        int i;
        tqtqqt tqtqqt2 = tqtqqt;
        String bqqq0071qq = yyqyyy.bqqq0071qq();
        if (bqqq0071qq != null) {
            String str6 = bp0070p0070pp;
            yyyyqy.qyyyqy.bt00740074ttt(str6, "Hooking application detected " + bqqq0071qq);
            i = 1;
        } else {
            i = 0;
        }
        if (!qqqyqy.bg00670067g0067g().b00670067ggg0067() && qqqyqy.bg00670067g0067g().bgg0067gg0067()) {
            i |= 2;
        }
        int i2 = i;
        if (yqqyqq.b006900690069ii0069(str2) && new qyyyyy(tqtqqt, str, b0070ppp0070p, str2, (String) null, false).by0079y007900790079(tqtqqt)) {
            i2 |= 4;
        }
        if (new qyyyyy(tqtqqt, str, bp007000700070pp, str5, jkkjjj.b006800680068h00680068(tqtqqt), true).by0079y007900790079(tqtqqt)) {
            i2 |= 4;
        }
        if (!b0074tt0074t0074() || i2 != 0) {
            return i2;
        }
        tqtqqt tqtqqt3 = tqtqqt;
        String str7 = str;
        return (new qyyyyy(tqtqqt3, str7, bpppp0070p, str3, jkkjjj.b0068hh006800680068(tqtqqt), true).by0079y007900790079(tqtqqt) || new qyyyyy(tqtqqt3, str7, b0070007000700070pp, str4, jkkjjj.bhh0068h00680068(tqtqqt), true).by0079y007900790079(tqtqqt)) ? i2 | 4 : i2;
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null && this.bp0070pp0070p != 0) {
            map.put(yyyyyq.MALICIOUS_APP_STATUS.b00780078x00780078x(), String.valueOf(this.bp0070pp0070p));
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null && ttqqqt.byyy0079yy() != null && map != null && this.bp0070pp0070p == 0) {
            this.bp0070pp0070p = bt0074t0074t0074(ttqqqt.byy0079yyy(), ttqqqt.b0079yy0079yy(), map.get(yyyyyq.ADVERTISING_ID.b00780078x00780078x()), map.get(yyyyyq.DEVICE_SERIAL.b00780078x00780078x()), map.get(yyyyyq.DEVICE_HARDWARE_ID.b00780078x00780078x()), ttqqqt.by00790079yyy());
            if (ttqqqt.byyy0079yy().bg00670067ggg()) {
                this.bp0070pp0070p |= 2;
            }
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_MALICIOUS_APPS;
    }
}
