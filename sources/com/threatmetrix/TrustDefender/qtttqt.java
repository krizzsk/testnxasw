package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class qtttqt extends tqqqqt {
    private int b00720072rr0072r;
    private int br0072rr0072r;

    public qtttqt(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            String b00780078x00780078x = yyyyyq.DEVICE_DISPLAY_RESOLUTION.b00780078x00780078x();
            map.put(b00780078x00780078x, Math.max(this.br0072rr0072r, this.b00720072rr0072r) + "x" + Math.min(this.br0072rr0072r, this.b00720072rr0072r));
            map.put(qqqqyq.b0062006200620062bb, this.br0072rr0072r >= this.b00720072rr0072r ? "landscape" : "portrait");
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null) {
            ttttqt ttttqt = new ttttqt(ttqqqt.byy0079yyy());
            this.br0072rr0072r = ttttqt.b0079yy00790079y();
            this.b00720072rr0072r = ttttqt.b007900790079y0079y();
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_DISPLAY;
    }
}
