package com.threatmetrix.TrustDefender;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.threatmetrix.TrustDefender.jkjjkj;
import com.threatmetrix.TrustDefender.tqqqqt;
import java.util.Map;

public class qyyyqq extends tqqqqt {
    private jkjjkj.kkjjkj b0062b0062b0062b;

    public qyyyqq(long j, boolean z, boolean z2) {
        super(j, z, z2);
    }

    private String b0069iii0069i() {
        if (this.b0062b0062b0062b == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder(Const.joLeft);
        boolean z = true;
        boolean z2 = false;
        if (this.b0062b0062b0062b.bs007300730073ss >= 0) {
            sb.append("\"mlc\":");
            sb.append(this.b0062b0062b0062b.bs007300730073ss);
            z = false;
        }
        if (this.b0062b0062b0062b.b0073007300730073ss >= 0) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append("\"mls\":");
            sb.append(this.b0062b0062b0062b.b0073007300730073ss);
        }
        if (this.b0062b0062b0062b.bss00730073ss >= 0) {
            if (z) {
                z = false;
            } else {
                sb.append(",");
            }
            sb.append("\"slc\":");
            sb.append(this.b0062b0062b0062b.bss00730073ss);
        }
        if (this.b0062b0062b0062b.b0073s00730073ss >= 0) {
            if (!z) {
                sb.append(",");
                z2 = z;
            }
            sb.append("\"sls\":");
            sb.append(this.b0062b0062b0062b.b0073s00730073ss);
            z = z2;
        }
        if (this.b0062b0062b0062b.bssss0073s || this.b0062b0062b0062b.bs007300730073ss >= 0 || this.b0062b0062b0062b.b0073007300730073ss >= 0) {
            if (!z) {
                sb.append(",");
            }
            sb.append("\"tda\":");
            sb.append(this.b0062b0062b0062b.bssss0073s);
        }
        sb.append("}");
        return sb.length() > 2 ? sb.toString() : "";
    }

    public void b007500750075u0075u(Map<String, String> map) {
        if (map != null) {
            map.put(yyyyyq.SHARED_LIB_INFO.b00780078x00780078x(), b0069iii0069i());
        }
    }

    public void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException {
        if (this.b0062b0062b0062b == null) {
            this.b0062b0062b0062b = yyqyyy.bqqq0071q0071();
        }
    }

    public tqqqqt.qtqqqt bu00750075u0075u() {
        return tqqqqt.qtqqqt.COLLECTOR_TYPE_SHARED_LIB;
    }
}
