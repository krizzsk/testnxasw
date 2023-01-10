package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.HashMap;
import java.util.Map;

public class jkkkjj extends tqqqqt {
    private final Map<String, String> b0064006400640064d0064 = new HashMap();

    public jkkkjj(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.TAMPER_CODE_BASE_MODULE.b00780078x00780078x(), this.b0064006400640064d0064.get(yyyyyq.TAMPER_CODE_BASE_MODULE.b00780078x00780078x()));
            map.put(yyyyyq.TAMPER_CODE_AUTH_MODULE.b00780078x00780078x(), this.b0064006400640064d0064.get(yyyyyq.TAMPER_CODE_AUTH_MODULE.b00780078x00780078x()));
            map.put(yyyyyq.TAMPER_CODE_BB_MODULE.b00780078x00780078x(), this.b0064006400640064d0064.get(yyyyyq.TAMPER_CODE_BB_MODULE.b00780078x00780078x()));
            map.put(yyyyyq.TAMPER_CODE_DSH_MODULE.b00780078x00780078x(), this.b0064006400640064d0064.get(yyyyyq.TAMPER_CODE_DSH_MODULE.b00780078x00780078x()));
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (ttqqqt.byy0079yyy() != null && ttqqqt.byyy0079yy() != null && ttqqqt.b00790079y0079yy() != null) {
            int bss0073s00730073s = bss0073s00730073s(ttqqqt.b00790079y0079yy().b006D006Dmm006D006D);
            this.b0064006400640064d0064.put(yyyyyq.TAMPER_CODE_BASE_MODULE.b00780078x00780078x(), Long.toString(qqqyqy.bg00670067g0067g().bg0067006700670067g(bss0073s00730073s)));
            this.b0064006400640064d0064.put(yyyyyq.TAMPER_CODE_AUTH_MODULE.b00780078x00780078x(), Long.toString(ttqqqt.byyy0079yy().b00670067gggg(qqyyqy.bp00700070p0070p, bss0073s00730073s).longValue()));
            this.b0064006400640064d0064.put(yyyyyq.TAMPER_CODE_BB_MODULE.b00780078x00780078x(), Long.toString(ttqqqt.byyy0079yy().b00670067gggg(qqyyqy.b0070p0070p0070p, bss0073s00730073s).longValue()));
            this.b0064006400640064d0064.put(yyyyyq.TAMPER_CODE_DSH_MODULE.b00780078x00780078x(), Long.toString(ttqqqt.byyy0079yy().b00670067gggg(qqyyqy.b007000700070p0070p, bss0073s00730073s).longValue()));
        }
    }

    public int bss0073s00730073s(String str) {
        int bi0069iii0069 = yqqyqq.bi0069iii0069(str);
        return (bi0069iii0069 % 20) + ((bi0069iii0069 % 3) * 21);
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_TAMPER_CODE;
    }
}
