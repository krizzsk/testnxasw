package com.threatmetrix.TrustDefender;

import android.media.AudioManager;
import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class qtqtqq extends tqqqqt {
    public int b006En006E006Enn;

    public qtqtqq(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.IN_CALL_STATUS.b00780078x00780078x(), String.valueOf(this.b006En006E006Enn));
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null) {
            this.b006En006E006Enn = 0;
            Object systemService = ttqqqt.byy0079yyy().bll006C006C006C006C.getSystemService("audio");
            if (systemService instanceof AudioManager) {
                int mode = ((AudioManager) systemService).getMode();
                if (mode == 2 || mode == 3) {
                    this.b006En006E006Enn = 1;
                }
            }
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_PHONE_CALL;
    }
}
