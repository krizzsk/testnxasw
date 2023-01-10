package com.threatmetrix.TrustDefender;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Nullable;

public abstract class tqqqqt {
    private static final String blll006Cl006C = yyyyqy.b0074t007400740074t(tqqqqt.class);
    private final boolean b006C006Cl006Cl006C;
    private String b006Cl006C006Cl006C;
    private final long b006Cll006Cl006C;
    private final boolean bl006Cl006Cl006C;
    private List<tqqqqt> bll006C006Cl006C;

    public enum qtqqqt {
        COLLECTOR_TYPE_LOCALE_INFO("li"),
        COLLECTOR_TYPE_TIMEZONE_INFO("ti"),
        COLLECTOR_TYPE_DEVICE_NAME("dn"),
        COLLECTOR_TYPE_COOKIE("ci"),
        COLLECTOR_TYPE_SIM("si"),
        COLLECTOR_TYPE_DISPLAY("di"),
        COLLECTOR_TYPE_FINGERPRINT("dfi"),
        COLLECTOR_TYPE_SELF_HASH("shi"),
        COLLECTOR_TYPE_FONT("fi"),
        COLLECTOR_TYPE_DEVICE_STATE("dsi"),
        COLLECTOR_TYPE_NETWORK("ni"),
        COLLECTOR_TYPE_SUBSCRIBER("sin"),
        COLLECTOR_TYPE_ADVERTISING_ID("ai"),
        COLLECTOR_TYPE_SELINUX_MODE("sm"),
        COLLECTOR_TYPE_SHARED_LIB("sli"),
        COLLECTOR_TYPE_CONNECTIONS("cin"),
        COLLECTOR_TYPE_APP_INSTALLATION("ini"),
        COLLECTOR_TYPE_SYSTEM_PROXY("pi"),
        COLLECTOR_TYPE_CPU_CORE("cpi"),
        COLLECTOR_TYPE_MALICIOUS_APPS("mai"),
        COLLECTOR_TYPE_DEVICE("dei"),
        COLLECTOR_TYPE_DEVICE_ENCRYPT_AND_STATUS("den"),
        COLLECTOR_TYPE_PLUGIN_DETECTION("pdi"),
        COLLECTOR_TYPE_TAMPER_CODE("tc"),
        COLLECTOR_TYPE_EMULATOR("epi"),
        COLLECTOR_TYPE_LOCATION("loi"),
        COLLECTOR_TYPE_ROOT_DETECTION("rdi"),
        COLLECTOR_TYPE_PUSH_TOKEN("pti"),
        COLLECTOR_TYPE_FINGERPRINT_CAPS("fci"),
        COLLECTOR_TYPE_STRONG_ID("sii"),
        COLLECTOR_TYPE_PHONE_CALL("pci");
        
        private final String bl006C006C006Cl006C;

        private qtqqqt(String str) {
            this.bl006C006C006Cl006C = str;
        }

        public String b00760076v007600760076() {
            return this.bl006C006C006Cl006C;
        }
    }

    public tqqqqt(long j) {
        this(j, false, true);
    }

    public tqqqqt(long j, boolean z, boolean z2) {
        this.b006Cll006Cl006C = j;
        this.bl006Cl006Cl006C = z;
        this.b006C006Cl006Cl006C = z2;
    }

    private void b0076v0076007600760076(@Nullable yqyyyq yqyyyq) throws InterruptedException {
        if (yqyyyq != null && yqyyyq.bx0078xxx0078()) {
            throw new InterruptedException();
        }
    }

    public abstract void b007500750075u0075u(Map<String, String> map);

    public abstract void b0075u0075u0075u(ttqqqt ttqqqt, Map<String, String> map) throws InterruptedException;

    public String b0079yyyyy() {
        return this.b006Cl006C006Cl006C;
    }

    public abstract qtqqqt bu00750075u0075u();

    public void bv00760076007600760076(long j, ttqqqt ttqqqt, boolean z, boolean z2) throws InterruptedException {
        if (ttqqqt != null) {
            this.b006Cl006C006Cl006C = "";
            HashMap hashMap = null;
            try {
                if (this.bll006C006Cl006C != null && !this.bll006C006Cl006C.isEmpty()) {
                    hashMap = new HashMap();
                    for (tqqqqt next : this.bll006C006Cl006C) {
                        if (next != null) {
                            next.bv00760076007600760076(j, ttqqqt, z, z2);
                            next.by0079yyyy(j, hashMap, z2);
                            if (yqqyqq.b0069ii0069i0069(next.b0079yyyyy())) {
                                this.b006Cl006C006Cl006C += next.b0079yyyyy();
                            }
                        }
                    }
                }
                boolean z3 = this.bl006Cl006Cl006C == z;
                if (z2) {
                    z3 &= this.b006C006Cl006Cl006C;
                }
                if (z3) {
                    b0076v0076007600760076(ttqqqt.by0079y0079yy());
                    if (this.b006Cll006Cl006C == 0 || (j & this.b006Cll006Cl006C) != 0) {
                        b0075u0075u0075u(ttqqqt, hashMap);
                        if (ttqqqt.byy00790079yy() != null) {
                            ttqqqt.byy00790079yy().b0073s0073s00730073s(bu00750075u0075u().name(), bu00750075u0075u().b00760076v007600760076());
                        }
                    }
                }
            } catch (InterruptedException e) {
                throw e;
            } catch (Throwable th) {
                this.b006Cl006C006Cl006C += th.toString() + "(" + bu00750075u0075u().b00760076v007600760076() + ");";
                yyyyqy.bt0074t00740074t(blll006Cl006C, "exception occurred: " + th.toString());
            }
        }
    }

    public void bvv0076007600760076(tqqqqt tqqqqt) {
        if (tqqqqt != null) {
            if (this.bll006C006Cl006C == null) {
                this.bll006C006Cl006C = new ArrayList();
            }
            this.bll006C006Cl006C.add(tqqqqt);
        }
    }

    public void by0079yyyy(long j, Map<String, String> map, boolean z) {
        if (map != null) {
            List<tqqqqt> list = this.bll006C006Cl006C;
            if (list != null && !list.isEmpty()) {
                for (tqqqqt by0079yyyy : this.bll006C006Cl006C) {
                    by0079yyyy.by0079yyyy(j, map, z);
                }
            }
            if (!z || this.b006C006Cl006Cl006C) {
                long j2 = this.b006Cll006Cl006C;
                if (j2 == 0 || (j & j2) != 0) {
                    b007500750075u0075u(map);
                }
            }
        }
    }
}
