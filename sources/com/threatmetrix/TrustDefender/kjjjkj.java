package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import com.threatmetrix.TrustDefender.yyqyyy;
import java.util.Map;
import java.util.TimeZone;

public class kjjjkj extends tqqqqt {
    private int b006400640064d00640064;
    private int bd00640064d00640064;
    private String bddd006400640064;

    public kjjjkj(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.TIMEZONE_GMT_OFFSET.b00780078x00780078x(), String.valueOf(this.bd00640064d00640064));
            map.put(yyyyyq.TIMEZONE_DST_DIFF.b00780078x00780078x(), String.valueOf(this.b006400640064d00640064));
            map.put(yyyyyq.TIMEZONE_NAME.b00780078x00780078x(), this.bddd006400640064);
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) {
        this.b006400640064d00640064 = 0;
        this.bd00640064d00640064 = 0;
        this.bddd006400640064 = null;
        yyqyyy.yyyqyy yyyqyy = new yyqyyy.yyyqyy();
        if (yyqyyy.bqqqq00710071(yyyqyy)) {
            this.b006400640064d00640064 = yyyqyy.bff0066f00660066;
            this.bd00640064d00640064 = yyyqyy.b00660066ff00660066;
        }
        this.bddd006400640064 = TimeZone.getDefault().getID();
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_TIMEZONE_INFO;
    }
}
