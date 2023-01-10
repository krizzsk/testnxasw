package com.threatmetrix.TrustDefender;

import com.threatmetrix.TrustDefender.tqqqqt;
import com.threatmetrix.TrustDefender.tqttqq;
import java.util.ArrayList;
import java.util.Map;

public class qqqqtt extends tqqqqt {
    public String b0072rr00720072r;
    public String br0072r00720072r;

    public qqqqtt(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.EM_PATH_COUNT.b00780078x00780078x(), this.b0072rr00720072r);
            map.put(yyyyyq.EM_PATH_STR.b00780078x00780078x(), yqqyqq.biii006900690069(this.br0072r00720072r, 1024));
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        ArrayList arrayList = new ArrayList(2);
        String by0079y00790079y = by0079y00790079y();
        if (by0079y00790079y != null) {
            arrayList.add("cpu_abi:" + by0079y00790079y);
        }
        String bg0067gg0067g = qqqyqy.bg00670067g0067g().bg0067gg0067g();
        if (bg0067gg0067g != null && b00790079y00790079y(bg0067gg0067g)) {
            arrayList.add("arch:" + bg0067gg0067g);
        }
        if (!(ttqqqt.byy0079yyy() == null || ttqqqt.b00790079y0079yy() == null || ttqqqt.b00790079y0079yy().bmmm006D006D006D.isEmpty())) {
            arrayList.addAll(yyqyyy.b0071qq0071qq(ttqqqt.byy0079yyy(), ttqqqt.b00790079y0079yy().bmmm006D006D006D));
        }
        if (!arrayList.isEmpty()) {
            this.b0072rr00720072r = String.valueOf(arrayList.size());
            this.br0072r00720072r = yqqyqq.bii00690069i0069(arrayList, ";", true);
        }
    }

    public boolean b00790079y00790079y(String str) {
        return "x86_64".equals(str) || "x86".equals(str) || "i386".equals(str);
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_EMULATOR;
    }

    public String by0079y00790079y() {
        String[] strArr;
        String str = tqttqq.ttttqq.b006E006Ennn006E;
        if (b00790079y00790079y(str)) {
            return str;
        }
        String str2 = tqttqq.ttttqq.bnn006Enn006E;
        if (b00790079y00790079y(str2)) {
            return str2;
        }
        if (!(tqttqq.ttttqq.qqqqtq.b006E006En006En006E < tqttqq.ttttqq.tqqqtq.bn006En006E006E006E || (strArr = tqttqq.ttttqq.b006En006Enn006E) == null || strArr.length == 0)) {
            for (String str3 : strArr) {
                if (b00790079y00790079y(str3)) {
                    return str3;
                }
            }
        }
        return null;
    }
}
