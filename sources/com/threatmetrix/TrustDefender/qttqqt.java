package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class qttqqt extends tqqqqt {
    private String b006Cl006C006C006C006C;
    private String b0072rrrrr;
    private String bl006C006C006C006C006C;
    private String br0072rrrr;

    public qttqqt(long j) {
        super(j);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.DEVICE_HARDWARE_ID.b00780078x00780078x(), yqqyqq.b006900690069i00690069(this.b006Cl006C006C006C006C));
            map.put(yyyyyq.DEVICE_SERIAL.b00780078x00780078x(), yqqyqq.b006900690069i00690069(this.bl006C006C006C006C006C));
            map.put(yyyyyq.DEVICE_LOCAL_STORAGE_COOKIE.b00780078x00780078x(), yqqyqq.b006900690069i00690069(this.b0072rrrrr));
            map.put(yyyyyq.DEVICE_FLASH_COOKIE.b00780078x00780078x(), yqqyqq.b006900690069i00690069(this.br0072rrrr));
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null) {
            if (this.b006Cl006C006C006C006C == null) {
                this.b006Cl006C006C006C006C = jkkjjj.bhh0068h00680068(ttqqqt.byy0079yyy());
            }
            if (this.bl006C006C006C006C006C == null) {
                this.bl006C006C006C006C006C = jkkjjj.b0068hh006800680068(ttqqqt.byy0079yyy());
            }
            if (this.b0072rrrrr == null || this.br0072rrrr == null) {
                String b00680068h006800680068 = jkkjjj.b00680068h006800680068(ttqqqt.byy0079yyy());
                if (this.b0072rrrrr == null) {
                    this.b0072rrrrr = jkkjjj.bhhh006800680068(b00680068h006800680068);
                }
                if (this.br0072rrrr == null) {
                    this.br0072rrrr = jkkjjj.b00680068hh00680068(ttqqqt.by00790079yyy(), b00680068h006800680068, this.b006Cl006C006C006C006C, ttqqqt.byy0079yyy());
                }
            }
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_COOKIE;
    }
}
