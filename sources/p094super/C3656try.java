package p094super;

import android.content.Context;
import android.text.TextUtils;
import androidx.exifinterface.media.ExifInterface;
import com.didi.raven.config.RavenConfigKey;
import com.didi.raven.config.RavenKey;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import com.facebook.appevents.UserDataStore;
import com.iproov.sdk.core.C20884new;
import java.util.HashMap;
import java.util.Map;
import kotlin.text.Typography;
import p094super.C3641break;
import p095switch.C3678this;
import p095switch.C3679throw;
import p235do.C21825goto;
import p235do.C21828this;

/* renamed from: super.try */
/* compiled from: LightingModel */
public class C3656try {

    /* renamed from: a */
    private static final String f8729a = ("🕯 " + C3656try.class.getSimpleName());

    /* renamed from: A */
    private Double f8730A = null;

    /* renamed from: B */
    private boolean f8731B = false;

    /* renamed from: C */
    private boolean f8732C = false;

    /* renamed from: D */
    private boolean f8733D = false;

    /* renamed from: E */
    private double f8734E = 1.0d;

    /* renamed from: F */
    private boolean f8735F = false;

    /* renamed from: G */
    private boolean f8736G = false;

    /* renamed from: H */
    private double f8737H = 0.0d;

    /* renamed from: I */
    private C3653if f8738I;

    /* renamed from: J */
    private C3653if f8739J;

    /* renamed from: b */
    private final C3649else f8740b;

    /* renamed from: c */
    private final C21825goto f8741c;

    /* renamed from: d */
    private final C3678this f8742d = new C3678this(0.4d);

    /* renamed from: e */
    private final C3678this f8743e = new C3678this(0.4d);

    /* renamed from: f */
    private Double f8744f = null;

    /* renamed from: g */
    private double f8745g = 0.01d;

    /* renamed from: h */
    private double f8746h = 0.0d;

    /* renamed from: i */
    private double f8747i = 0.0d;

    /* renamed from: j */
    private double f8748j = 1.8d;

    /* renamed from: k */
    private double f8749k = 100.0d;

    /* renamed from: l */
    private double f8750l = 0.0d;

    /* renamed from: m */
    private C21828this f8751m = null;

    /* renamed from: n */
    private boolean f8752n = false;

    /* renamed from: o */
    private boolean f8753o = false;

    /* renamed from: p */
    private boolean f8754p = false;

    /* renamed from: q */
    private C3641break f8755q;

    /* renamed from: r */
    private C3641break f8756r;

    /* renamed from: s */
    private C3641break f8757s;

    /* renamed from: t */
    private C3641break f8758t;

    /* renamed from: u */
    private C3641break f8759u;

    /* renamed from: v */
    private C3641break f8760v;

    /* renamed from: w */
    private C3641break f8761w;

    /* renamed from: x */
    private C3641break f8762x;

    /* renamed from: y */
    private double f8763y = 0.0d;

    /* renamed from: z */
    private double f8764z = 0.0d;

    C3656try(Context context, C3649else elseR, C21825goto gotoR) {
        this.f8741c = gotoR;
        this.f8740b = elseR;
        m7369i();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ double m7355a(double d, char c, double d2) throws C3648do {
        return d <= d2 ? 1.0d : 0.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ double m7356a(String str, C3641break.C3642do doVar) throws C3648do {
        return m7359b(doVar.m46653new());
    }

    /* renamed from: a */
    private double m7357a(C3641break breakR, String str) throws C3647case {
        try {
            return breakR.mo43439if(Constants.FILE_ANR_KEY, this.f8746h).mo43439if("c", m7372l()).mo43439if("e", this.f8763y).mo43439if("i", this.f8749k).mo43439if(CampaignValue.f43060b, this.f8748j).mo43439if(RavenKey.STACK, m7373m()).mo43439if("so", m7374n()).mo43439if(RavenKey.TYPE, this.f8745g).mo43439if(RavenKey.VERSION, this.f8764z).mo43440if("vo", this.f8730A).mo43439if("z", m7367g()).mo43433do(str);
        } catch (C3648do e) {
            throw new C3647case(e);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static /* synthetic */ double m7360b(double d, char c, double d2) throws C3648do {
        return d >= d2 ? 1.0d : 0.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ double m7361b(String str, C3641break.C3642do doVar) throws C3648do {
        return m7354a(doVar.m46653new());
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static /* synthetic */ double m7362c(double d, char c, double d2) throws C3648do {
        return (1.0d == d || 1.0d == d2) ? 1.0d : 0.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static /* synthetic */ double m7364d(double d, char c, double d2) throws C3648do {
        return (1.0d == d && 1.0d == d2) ? 1.0d : 0.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static /* synthetic */ double m7365e(double d, char c, double d2) throws C3648do {
        return d < d2 ? 1.0d : 0.0d;
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public static /* synthetic */ double m7366f(double d, char c, double d2) throws C3648do {
        return d > d2 ? 1.0d : 0.0d;
    }

    /* renamed from: g */
    private double m7367g() {
        Double d = this.f8741c.mo171494do();
        if (d == null) {
            return 1.0d;
        }
        return d.doubleValue();
    }

    /* renamed from: h */
    private C3641break m7368h() {
        return new C3641break().mo43436do("clamp", (C3641break.C3643for) $$Lambda$try$kozmd1uJiryx6KSmvIadJxruVQ.INSTANCE).mo43438do(new C3641break.C3645new(Typography.greater, 10, 10, 66, false, $$Lambda$try$Q3PRFwOYFZaSyUyUULJqkEDdcro.INSTANCE)).mo43438do(new C3641break.C3645new(Typography.less, 10, 10, 66, false, $$Lambda$try$aeqZ9oOdZGftGBc4HXyftfOVEk.INSTANCE)).mo43438do(new C3641break.C3645new(Typography.amp, 5, 5, 66, false, $$Lambda$try$kqP4vL7z98n6oRLBoOSnw9odGEo.INSTANCE)).mo43438do(new C3641break.C3645new('|', 5, 5, 66, false, $$Lambda$try$zL41xe9pXdqbnsOqqR_06aM93IM.INSTANCE)).mo43438do(new C3641break.C3645new(Typography.pound, 10, 10, 66, false, $$Lambda$try$E9G8bZUgcDOxXx_q7K0wTwdVbk.INSTANCE)).mo43438do(new C3641break.C3645new(Typography.euro, 10, 10, 66, false, $$Lambda$try$XdQ__PUdIdtNPoD4lqfa4y328xo.INSTANCE)).mo43436do("h", (C3641break.C3643for) new C3641break.C3643for() {
            /* renamed from: do */
            public final double mo43432do(String str, C3641break.C3642do doVar) {
                return C3656try.this.m7361b(str, doVar);
            }
        }).mo43436do("ho", (C3641break.C3643for) new C3641break.C3643for() {
            /* renamed from: do */
            public final double mo43432do(String str, C3641break.C3642do doVar) {
                return C3656try.this.m7356a(str, doVar);
            }
        }).mo43434do(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, C3652goto.m7337a()).mo43439if("F", this.f8750l);
    }

    /* renamed from: i */
    private void m7369i() {
        this.f8755q = m7368h();
        this.f8756r = m7368h();
        this.f8757s = m7368h();
        this.f8758t = m7368h();
        this.f8759u = m7368h();
        this.f8760v = m7368h();
        this.f8761w = m7368h();
        this.f8762x = m7368h();
    }

    /* renamed from: l */
    private double m7372l() {
        return ((Double) C3679throw.m7439do(this.f8742d.mo43504do(), Double.valueOf(-1.0d))).doubleValue();
    }

    /* renamed from: m */
    private double m7373m() {
        return ((Double) C3679throw.m7439do(this.f8743e.mo43504do(), Double.valueOf(-1.0d))).doubleValue();
    }

    /* renamed from: n */
    private double m7374n() {
        return ((Double) C3679throw.m7439do(this.f8744f, Double.valueOf(m7373m()))).doubleValue();
    }

    /* renamed from: p */
    private synchronized Map<String, Double> m7376p() {
        HashMap hashMap;
        hashMap = new HashMap();
        hashMap.put("F", Double.valueOf(this.f8750l));
        hashMap.put(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS, Double.valueOf(C3652goto.m7337a()));
        hashMap.put(Constants.FILE_ANR_KEY, Double.valueOf(this.f8746h));
        hashMap.put("c", Double.valueOf(m7372l()));
        hashMap.put("e", Double.valueOf(this.f8763y));
        hashMap.put("hMedian", Double.valueOf(m7354a(0.5d)));
        hashMap.put("hoMedian", Double.valueOf(m7359b(0.5d)));
        hashMap.put("i", Double.valueOf(this.f8749k));
        double d = 1.0d;
        hashMap.put("qi", Double.valueOf(this.f8752n ? 1.0d : 0.0d));
        hashMap.put(CampaignValue.f43060b, Double.valueOf(this.f8748j));
        hashMap.put("qn", Double.valueOf(this.f8753o ? 1.0d : 0.0d));
        hashMap.put(RavenKey.STACK, Double.valueOf(m7373m()));
        hashMap.put("so", Double.valueOf(m7374n()));
        hashMap.put(RavenKey.TYPE, Double.valueOf(this.f8745g));
        hashMap.put("qt", Double.valueOf(this.f8754p ? 1.0d : 0.0d));
        hashMap.put(RavenKey.VERSION, Double.valueOf(this.f8764z));
        hashMap.put("z", Double.valueOf(m7367g()));
        hashMap.put("vo", this.f8730A);
        hashMap.put("tb", Double.valueOf(this.f8733D ? 1.0d : 0.0d));
        hashMap.put("tc", Double.valueOf(this.f8731B ? 1.0d : 0.0d));
        hashMap.put("tf", Double.valueOf(this.f8732C ? 1.0d : 0.0d));
        hashMap.put("sd", Double.valueOf(this.f8734E));
        hashMap.put("su", Double.valueOf(this.f8735F ? 1.0d : 0.0d));
        if (!this.f8736G) {
            d = 0.0d;
        }
        hashMap.put("sl", Double.valueOf(d));
        hashMap.put(RavenConfigKey.PHONE, Double.valueOf(this.f8737H));
        C21828this thisR = this.f8751m;
        if (thisR != null) {
            m7358a((Map<String, Double>) hashMap, "sa", thisR.m48235throw());
            m7358a((Map<String, Double>) hashMap, "sb", this.f8751m.m48237while());
            m7358a((Map<String, Double>) hashMap, "eb", this.f8751m.m48221case());
            m7358a((Map<String, Double>) hashMap, "mm", this.f8751m.m48223class());
            m7358a((Map<String, Double>) hashMap, "cs", this.f8751m.m48227for());
            m7358a((Map<String, Double>) hashMap, "sm", this.f8751m.m48226final());
            m7358a((Map<String, Double>) hashMap, "cc", this.f8751m.m48231new());
            m7358a((Map<String, Double>) hashMap, UserDataStore.STATE, this.f8751m.m48224const());
            m7358a((Map<String, Double>) hashMap, UserDataStore.CITY, this.f8751m.m48236try());
            m7358a((Map<String, Double>) hashMap, "gc", this.f8751m.m48234this());
            m7358a((Map<String, Double>) hashMap, "wb", this.f8751m.m48230native());
            m7358a((Map<String, Double>) hashMap, "dr", this.f8751m.m48229import());
            m7358a((Map<String, Double>) hashMap, "ma", this.f8751m.m48222catch());
            m7358a((Map<String, Double>) hashMap, "sf", this.f8751m.m48233super());
        }
        return hashMap;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo43482a() {
        return this.f8731B;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized boolean mo43484b() {
        return this.f8732C;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public synchronized boolean mo43486c() {
        return this.f8733D;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public synchronized double mo43487d() {
        return this.f8734E;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public synchronized void mo43488e() {
        this.f8739J = this.f8738I;
        this.f8744f = this.f8743e.mo43504do();
        this.f8730A = Double.valueOf(this.f8764z);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: f */
    public String mo43489f() {
        Map<String, Double> p = m7376p();
        return TextUtils.join("\n", new String[]{"<- tc: " + this.f8740b.m46660this(), "<- tf: " + this.f8740b.m46654break(), "<- tb: " + this.f8740b.m46658goto(), "<- sd: " + this.f8740b.m46661try(), "<- ev: " + this.f8740b.m46659new(), "<- su: " + this.f8740b.m46656else(), "<- sl: " + this.f8740b.m46655case(), "<- cl: " + this.f8740b.m46657for(), "A = " + C20884new.m43433if(p.get(ExifInterface.GPS_MEASUREMENT_IN_PROGRESS)), "F = " + C20884new.m43433if(p.get("F")) + " z = " + C20884new.m43433if(p.get("z")), "a = " + C20884new.m43433if(p.get(Constants.FILE_ANR_KEY)), "c = " + C20884new.m43433if(p.get("c")), "e = " + C20884new.m43433if(p.get("e")), "h[o](0.5) = " + C20884new.m43433if(p.get("hMedian")) + " [" + C20884new.m43433if(p.get("hoMedian")) + Const.jaRight, "i = " + C20884new.m43433if(p.get("i")), "n = " + C20884new.m43433if(p.get(CampaignValue.f43060b)), "s[o] = " + C20884new.m43433if(p.get(RavenKey.STACK)) + " [" + C20884new.m43433if(p.get("so")) + Const.jaRight, "t = " + C20884new.m43433if(p.get(RavenKey.TYPE)), "v[o] = " + C20884new.m43433if(p.get(RavenKey.VERSION)) + " [" + C20884new.m43433if(p.get("vo")) + Const.jaRight, "p = " + C20884new.m43433if(p.get(RavenConfigKey.PHONE)), "ld = " + C20884new.m43433if(p.get("ld")), "-> tc = " + C20884new.m43431do(p.get("tc")) + " tf = " + C20884new.m43431do(p.get("tf")) + " tb = " + C20884new.m43431do(p.get("tb")) + " sd = " + C20884new.m43431do(p.get("sd")) + " su = " + C20884new.m43431do(p.get("su")) + " sl = " + C20884new.m43431do(p.get("sl"))});
    }

    /* renamed from: b */
    private double m7359b(double d) {
        Double d2 = this.f8744f;
        if (d2 == null) {
            d2 = this.f8743e.mo43504do();
        }
        C3653if ifVar = this.f8739J;
        if (ifVar == null) {
            ifVar = this.f8738I;
        }
        if (d2 == null || ifVar == null) {
            return -1.0d;
        }
        return ((double) ifVar.mo43471do(d)) / 255.0d;
    }

    /* renamed from: j */
    private double m7370j() {
        double d = this.f8745g;
        double d2 = 0.0d;
        if (d > 0.0d) {
            double d3 = this.f8748j;
            if (d3 > 0.0d) {
                d2 = Math.log((d3 * d3) / d) / Math.log(2.0d);
            }
        }
        StringBuilder sb = new StringBuilder();
        sb.append("C.Lux calculateExposureValue: ");
        sb.append(d2);
        return d2;
    }

    /* renamed from: o */
    private void m7375o() throws C3647case {
        double a = m7357a(this.f8762x, this.f8740b.mo43457h());
        if (a < 0.0d || a > 100000.0d || this.f8745g > 10.0d) {
            String.format("C.Lux error: the value of %f is out of range!", new Object[]{Double.valueOf(a)});
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("C.Lux calculated: ");
        sb.append(a);
        this.f8742d.mo43505do(Double.valueOf(a));
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized boolean mo43483a(long j) throws C3647case {
        boolean z;
        double d = ((double) j) / 1000.0d;
        this.f8737H = d;
        z = m7357a(this.f8760v.mo43439if(RavenConfigKey.PHONE, d), this.f8740b.mo43453f()) == 1.0d;
        this.f8735F = z;
        return z;
    }

    /* renamed from: k */
    private double m7371k() {
        Double d = this.f8742d.mo43504do();
        if (d == null) {
            return -1.0d;
        }
        return Math.log(d.doubleValue()) / Math.log(2.0d);
    }

    /* renamed from: a */
    private double m7354a(double d) {
        C3653if ifVar;
        if (this.f8743e.mo43504do() == null || (ifVar = this.f8738I) == null) {
            return -1.0d;
        }
        return ((double) ifVar.mo43471do(d)) / 255.0d;
    }

    /* renamed from: a */
    private void m7358a(Map<String, Double> map, String str, Double d) {
        if (d != null && !d.isNaN() && !d.isInfinite()) {
            map.put(str, d);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized C3655this mo43477a(boolean z) throws C3647case {
        this.f8763y = m7370j();
        double d = this.f8747i;
        if (d == 0.0d) {
            d = m7371k();
        }
        this.f8764z = d;
        this.f8730A = Double.valueOf(d);
        if (z) {
            this.f8764z = m7357a(this.f8759u, this.f8740b.mo43451e());
        }
        m7375o();
        boolean z2 = true;
        this.f8731B = m7357a(this.f8756r, this.f8740b.mo43445a()) == 1.0d;
        this.f8732C = m7357a(this.f8755q, this.f8740b.mo43446b()) == 1.0d;
        if (m7357a(this.f8757s, this.f8740b.mo43448c()) != 1.0d) {
            z2 = false;
        }
        this.f8733D = z2;
        this.f8734E = m7357a(this.f8758t, this.f8740b.mo43450d());
        return new C3655this(m7376p());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public synchronized boolean mo43485b(long j) throws C3647case {
        boolean z;
        double d = ((double) j) / 1000.0d;
        this.f8737H = d;
        z = m7357a(this.f8761w.mo43439if(RavenConfigKey.PHONE, d), this.f8740b.mo43455g()) == 1.0d;
        this.f8736G = z;
        return z;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo43478a(C21828this thisR) {
        StringBuilder sb = new StringBuilder();
        sb.append("C.Lux exifData: ");
        sb.append(thisR);
        this.f8746h = ((Double) C3679throw.m7439do(thisR.mo180448do(), Double.valueOf(0.0d))).doubleValue();
        Double d = thisR.m48220break();
        boolean z = true;
        this.f8752n = d != null;
        this.f8749k = ((Double) C3679throw.m7439do(d, Double.valueOf(100.0d))).doubleValue();
        Double d2 = thisR.m48232public();
        this.f8753o = d2 != null;
        this.f8748j = ((Double) C3679throw.m7439do(d2, Double.valueOf(1.8d))).doubleValue();
        this.f8747i = ((Double) C3679throw.m7439do(thisR.mo180453if(), Double.valueOf(0.0d))).doubleValue();
        Double d3 = thisR.m48225else();
        if (d3 == null) {
            z = false;
        }
        this.f8754p = z;
        this.f8745g = ((Double) C3679throw.m7439do(d3, Double.valueOf(0.01d))).doubleValue();
        this.f8750l = ((Double) C3679throw.m7439do(thisR.m48228goto(), Double.valueOf(this.f8750l))).doubleValue();
        this.f8751m = thisR;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo43479a(Double d) {
        if (d != null) {
            this.f8743e.mo43505do(d);
        } else {
            this.f8743e.mo43506if();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo43480a(Float f) {
        if (f != null) {
            this.f8750l = (double) f.floatValue();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public synchronized void mo43481a(C3653if ifVar) {
        this.f8738I = ifVar;
    }
}
