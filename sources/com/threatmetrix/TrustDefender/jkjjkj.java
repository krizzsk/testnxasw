package com.threatmetrix.TrustDefender;

import com.didi.rfusion.config.RFLocale;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.threatmetrix.TrustDefender.TMXProfilingModule.BuildConfig;
import com.threatmetrix.TrustDefender.tqttqq;
import com.threatmetrix.TrustDefender.yyyyqy;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.atomic.AtomicLong;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;

public class jkjjkj {
    private static final String b0064dd006400640064 = yyyyqy.b0074t007400740074t(jkjjkj.class);
    public static final boolean bd0064d006400640064 = false;
    public static final String version = "6.3-80";
    private final AtomicLong b00640064d006400640064;
    public final long b0064d0064006400640064;
    @Nonnull
    public final String b00730073ssss;
    @Nullable
    public final String b0073s0073sss;
    @Nullable
    public final String b0073sssss;
    public final tqtqqt bd00640064006400640064;
    private final long bdd0064006400640064;
    public long bs00730073sss;
    @Nullable
    public final String bs0073ssss;
    @Nonnull
    public final String bss0073sss;

    public static class GenericLocation {
        public final double b007300730073sss;
        public final boolean b00730073s0073ss;
        public final Float b0073ss0073ss;
        public final boolean bs0073s0073ss;
        public final double bsss0073ss;

        public GenericLocation(double d, double d2, Float f, boolean z, boolean z2) {
            this.b007300730073sss = d;
            this.bsss0073ss = d2;
            this.b0073ss0073ss = f;
            this.bs0073s0073ss = z;
            this.b00730073s0073ss = z2;
        }
    }

    public static class kkjjkj {
        public final int b0073007300730073ss;
        public final int b0073s00730073ss;
        public final int bs007300730073ss;
        public final int bss00730073ss;
        public final boolean bssss0073s;

        public kkjjkj(int i, int i2, int i3, int i4, boolean z) {
            this.bss00730073ss = i;
            this.b0073s00730073ss = i2;
            this.bs007300730073ss = i3;
            this.b0073007300730073ss = i4;
            this.bssss0073s = z;
        }
    }

    public jkjjkj(tqtqqt tqtqqt, long j, AtomicLong atomicLong, long j2) {
        this.b0064d0064006400640064 = j;
        this.b00640064d006400640064 = atomicLong;
        this.bd00640064006400640064 = tqtqqt;
        String b006800680068h00680068 = jkkjjj.b006800680068h00680068(tqtqqt);
        this.b0073sssss = b006800680068h00680068;
        this.bs0073ssss = jkkjjj.bh0068hh00680068(b006800680068h00680068);
        String b0079y00790079yy = this.bd00640064006400640064.b0079y00790079yy();
        b0079y00790079yy = yqqyqq.bi0069i0069i0069(b0079y00790079yy) ? "TrustDefenderSDK" : b0079y00790079yy;
        this.bss0073sss = "http://" + b0079y00790079yy;
        this.b00730073ssss = "http://" + b0079y00790079yy + "/mobile";
        this.b0073s0073sss = yqqyqq.b0069iii00690069(tqqtqq.buu0075uu0075(tqtqqt));
        this.bdd0064006400640064 = j2;
        this.bs00730073sss = 0;
        qqyyyy.b0079y0079007900790079().b0071qqqqq();
    }

    private List<String> b00730073s007300730073s(@Nonnull yyqyqy yyqyqy) {
        String str = this.bd00640064006400640064.bll006C006C006C006C.getApplicationInfo().nativeLibraryDir;
        String concat = str.concat("/lib".concat(BuildConfig.JNI_FILENAME).concat(".so"));
        ArrayList arrayList = new ArrayList();
        arrayList.add(concat);
        String bgg0067ggg = yyqyqy.bgg0067ggg(qqyyqy.bp00700070p0070p);
        if (yqqyqq.b0069ii0069i0069(bgg0067ggg)) {
            String concat2 = str.concat("/lib".concat(bgg0067ggg).concat(".so"));
            if (yqqyqq.b0069ii0069i0069(concat2)) {
                arrayList.add(concat2);
            }
        }
        String bgg0067ggg2 = yyqyqy.bgg0067ggg(qqyyqy.b007000700070p0070p);
        if (yqqyqq.b0069ii0069i0069(bgg0067ggg2)) {
            String concat3 = str.concat("/lib".concat(bgg0067ggg2).concat(".so"));
            if (yqqyqq.b0069ii0069i0069(concat3)) {
                arrayList.add(concat3);
            }
        }
        return arrayList;
    }

    public void b0073ss007300730073s(String str, yqyyyq yqyyyq, @Nullable String str2, boolean z) throws InterruptedException {
        long b0076v00760076v0076 = tqttqq.tttttq.b0076v00760076v0076();
        qqyyyy.b0079y0079007900790079().bq0071qqqq(this.b00640064d006400640064.get(), new ttqqqt(this.bd00640064006400640064, this.b0073sssss, str, str2, jjkjkj.b00730073ss0073s, (yqqqqq) null, (GenericLocation) null, (Map<String, String>) null, yqyyyq, new kkkkjj()), false, z);
        this.bs00730073sss = tqttqq.tttttq.b0076v00760076v0076() - b0076v00760076v0076;
    }

    public String bs0073s007300730073s(Set<String> set, List<String> list, Map<String, String> map) {
        String str;
        String str2;
        String bqq00710071qq = yyqyyy.bqq00710071qq(this.bd00640064006400640064);
        qqyyyq bxxxx00780078 = qqyyyq.bxxxx00780078();
        String str3 = "";
        if (map == null || (str = map.get(qqqqyq.b0062006200620062bb)) == null) {
            str = str3;
        }
        String str4 = "{\"cpo\":" + this.b0064d0064006400640064 + ",\"dyo\":" + this.b00640064d006400640064.longValue() + ",\"psi\":" + bxxxx00780078.bx00780078x00780078() + ",\"pri\":" + this.bs00730073sss + ",\"cpi\":" + bxxxx00780078.bxx0078x00780078() + ",\"ori\":" + Const.jsQuote + str + Const.jsQuote;
        if (bxxxx00780078.bx00780078x00780078() > 1) {
            str4 = str4 + ",\"lsi\":\"" + bxxxx00780078.b00780078xx00780078() + "\",\"lps\":\"" + bxxxx00780078.bx0078xx00780078() + "\",\"lpi\":" + bxxxx00780078.b0078xxx00780078();
        }
        if ((this.b00640064d006400640064.get() & 1073741824) != 0) {
            String bq0071qq00710071 = yyqyyy.bq0071qq00710071(this.bd00640064006400640064);
            String bqqq007100710071 = yyqyyy.bqqq007100710071();
            if (list != null) {
                str2 = str3;
                for (String next : list) {
                    if (!Boolean.parseBoolean(str2)) {
                        str2 = qqqyqy.bg00670067g0067g().b0067g0067gg0067(next);
                    }
                }
            } else {
                str2 = str3;
            }
            if (yqqyqq.b0069ii0069i0069(bq0071qq00710071)) {
                str4 = str4 + ",\"dbg\":" + bq0071qq00710071;
            }
            if (yqqyqq.b0069ii0069i0069(bqqq007100710071)) {
                str4 = str4 + ",\"jdwp\":" + bqqq007100710071;
            }
            if (yqqyqq.b0069ii0069i0069(str2)) {
                str4 = str4 + ",\"djni\":" + str2;
            }
        }
        if (yqqyqq.b0069ii0069i0069(bqq00710071qq)) {
            str4 = str4 + ",\"adb\":" + bqq00710071qq;
        }
        qqqtqt.b0079007900790079yy(set);
        String byy0079y0079y = qqqtqt.byy0079y0079y();
        if (yqqyqq.b0069ii0069i0069(byy0079y0079y)) {
            str4 = str4 + ",\"dper\":" + byy0079y0079y;
        }
        StringBuilder sb = new StringBuilder();
        sb.append(str4);
        sb.append(",\"mif\":\"");
        long j = this.bdd0064006400640064;
        sb.append(j > 0 ? Long.toString(j) : str3);
        sb.append(Const.jsQuote);
        String sb2 = sb.toString();
        if (map != null) {
            str3 = map.get(yyyyyq.CRASH_LOG_STRING.b00780078x00780078x());
        }
        StringBuilder sb3 = new StringBuilder();
        sb3.append(sb2);
        sb3.append(",\"crs\":\"");
        sb3.append(yqqyqq.b0069ii0069i0069(str3) ? "1" : "0");
        sb3.append(Const.jsQuote);
        return sb3.toString() + "}";
    }

    @Nonnull
    public qttttt bss0073007300730073s(@Nonnull yqqqqq yqqqqq, @Nonnull String str, @Nonnull String str2, @Nullable GenericLocation genericLocation, @Nullable Map<String, String> map, @Nonnull yyqyqy yyqyqy, boolean z) throws InterruptedException {
        yyqyqy yyqyqy2;
        yqqqqq yqqqqq2 = yqqqqq;
        String str3 = str;
        String str4 = str2;
        Map<String, String> map2 = map;
        yyqyqy yyqyqy3 = yyqyqy;
        kkkkjj kkkkjj = new kkkkjj();
        qqyyyy.b0079y0079007900790079().bq0071qqqq(this.b00640064d006400640064.get(), new ttqqqt(this.bd00640064006400640064, this.b0073sssss, "", "", jjkjkj.b00730073ss0073s, yqqqqq, genericLocation, map, (yqyyyq) null, kkkkjj), true, !z);
        Map<String, String> by00790079007900790079 = qqyyyy.b0079y0079007900790079().by00790079007900790079(this.b00640064d006400640064.get(), !z);
        qttttt qttttt = new qttttt();
        qttttt.byyy007900790079(255);
        qttttt.byyyy00790079("w", yqqqqq2.bm006Dmm006D006D);
        qttttt.by0079yy00790079("lh", this.b00730073ssss, true);
        qttttt.by0079yy00790079("dr", this.bss0073sss, true);
        qttttt.byyyy00790079("hh", yqqyqq.b0069i00690069i0069(str3 + str4));
        qttttt.byyyy00790079("lq", this.b0073s0073sss);
        qttttt.byyyy00790079("ani", this.b0073sssss);
        if (map2 != null && !map.isEmpty()) {
            qttttt.b00790079yy00790079(map2);
        }
        if (z) {
            qttttt.byyyy00790079("apd", String.valueOf(qqyyyq.bxxxx00780078().bxx0078x00780078()));
            yyqyqy2 = yyqyqy;
            qttttt.b0079yyy00790079("atr", bs0073s007300730073s(yyqyqy.bt00740074007400740074(), b00730073s007300730073s(yyqyqy2), by00790079007900790079), 2048);
            String bsss007300730073s = kkkkjj.bsss007300730073s(qqyyyq.bxxxx00780078().b0078x0078x00780078());
            if (bsss007300730073s != null) {
                qttttt.byyyy00790079("sp", bsss007300730073s);
            }
            if ((this.b00640064d006400640064.get() & qqqqqy.baa00610061aa) != 0) {
                qttttt.b0079yyy00790079("rsp", new qyqyyq().b0069iiiii(this.bd00640064006400640064.bll006C006C006C006C, str3, yqqqqq2.b006D006D006Dm006D006D), -1);
            }
        } else {
            yyqyqy2 = yyqyqy;
        }
        qttttt qttttt2 = new qttttt();
        qttttt2.byyyy00790079("org_id", str3);
        qttttt2.byyyy00790079("session_id", str4);
        qttttt2.byyyy00790079("nonce", yqqqqq2.b006D006Dmm006D006D);
        qttttt2.byyyy00790079("h", "0");
        qttttt2.byyyy00790079("m", "2");
        for (Map.Entry next : by00790079007900790079.entrySet()) {
            if (!((String) next.getKey()).startsWith(qqqqyq.bb006200620062bb)) {
                if (((String) next.getKey()).startsWith("sid_")) {
                    qttttt2.byyyy00790079((String) next.getKey(), (String) next.getValue());
                } else {
                    qttttt.b0079yyy00790079((String) next.getKey(), (String) next.getValue(), -1);
                }
            }
        }
        Map<String, String> bt0074t007400740074 = yyqyqy2.bt0074t007400740074(this.b00640064d006400640064.get());
        if (bt0074t007400740074 != null && bt0074t007400740074.containsKey(yyyyyq.APP_HASHES.b00780078x00780078x())) {
            qttttt2.byyyy00790079(yyyyyq.APP_HASHES.b00780078x00780078x(), bt0074t007400740074.get(yyyyyq.APP_HASHES.b00780078x00780078x()));
        }
        kkkkjj kkkkjj2 = kkkkjj;
        kkkkjj2.b0073s0073s00730073s("Params without xor", "pwx");
        String b007900790079y00790079 = qttttt.b007900790079y00790079();
        kkkkjj2.b0073s0073s00730073s("URL encoding", "ue");
        String str5 = b0064dd006400640064;
        yyyyqy.qyyyqy.bt0074tttt(str5, "encoded ja = " + qttttt);
        qttttt2.byyyy00790079(RFLocale.JAPANESE, yqqyqq.bii0069006900690069(b007900790079y00790079, str4));
        kkkkjj2.b0073s0073s00730073s("Params xor'd", "pxd");
        return qttttt2;
    }
}
