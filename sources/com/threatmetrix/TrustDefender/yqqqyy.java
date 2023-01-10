package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class yqqqyy extends tqqqqt {
    public static final int b00660066f006600660066 = 4;
    public static final int b0066ff006600660066 = 1;
    public static final int bf0066f006600660066 = 2;
    private String b0066f0066006600660066;
    private String b0070ppppp;
    private String bf00660066006600660066;
    private String bff0066006600660066;

    public yqqqyy(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.LOCATION_LATITUDE.b00780078x00780078x(), this.bff0066006600660066);
            map.put(yyyyyq.LOCATION_LONGITUDE.b00780078x00780078x(), this.b0066f0066006600660066);
            map.put(yyyyyq.LOCATION_ACCURACY.b00780078x00780078x(), this.bf00660066006600660066);
            map.put(yyyyyq.LOCATION_MOCK_STATUS.b00780078x00780078x(), this.b0070ppppp);
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null && ttqqqt.b007900790079yyy() != null) {
            this.bff0066006600660066 = String.valueOf(ttqqqt.b007900790079yyy().b007300730073sss);
            this.b0066f0066006600660066 = String.valueOf(ttqqqt.b007900790079yyy().bsss0073ss);
            this.bf00660066006600660066 = ttqqqt.b007900790079yyy().b0073ss0073ss == null ? "" : String.valueOf(ttqqqt.b007900790079yyy().b0073ss0073ss);
            int i = 0;
            if (yyqyyy.bq00710071q00710071(ttqqqt.byy0079yyy())) {
                i = 2;
            }
            if (ttqqqt.b007900790079yyy().bs0073s0073ss) {
                i |= 1;
            }
            if (ttqqqt.b007900790079yyy().b00730073s0073ss) {
                i |= 4;
            }
            this.b0070ppppp = String.valueOf(i);
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_LOCATION;
    }
}
