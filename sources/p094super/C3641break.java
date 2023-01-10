package p094super;

import androidx.exifinterface.media.ExifInterface;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import com.facebook.AuthenticationTokenClaims;
import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;
import kotlin.text.Typography;
import org.apache.commons.p074io.IOUtils;
import org.osgi.framework.VersionRange;

/* renamed from: super.break */
/* compiled from: MathEval */
public class C3641break {

    /* renamed from: a */
    private static final C3645new f8696a = new C3645new(0, 0, 0, 66, false, (C3646try) null);

    /* renamed from: b */
    private C3645new[] f8697b = new C3645new[256];

    /* renamed from: c */
    private final SortedMap<String, Double> f8698c;

    /* renamed from: d */
    private final SortedMap<String, Double> f8699d;

    /* renamed from: e */
    private final SortedMap<String, C3643for> f8700e;

    /* renamed from: f */
    private final SortedMap<String, C3643for> f8701f;

    /* renamed from: g */
    private boolean f8702g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public String f8703h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public int f8704i;

    /* renamed from: super.break$do */
    /* compiled from: MathEval */
    public final class C3642do {

        /* renamed from: do */
        final int f8705do;

        /* renamed from: if */
        int f8706if;

        C3642do(int i, int i2) {
            this.f8705do = i2;
            this.f8706if = i + 1;
            this.f8706if = C3641break.this.m7289a(C3641break.this.f8703h, this.f8706if, i2 - 1);
        }

        /* renamed from: do */
        private double m7310do() {
            if (C3641break.this.f8703h.charAt(this.f8706if) == ',') {
                this.f8706if++;
            }
            double a = C3641break.this.m7286a(this.f8706if, this.f8705do);
            this.f8706if = C3641break.this.f8704i;
            return a;
        }

        /* renamed from: for  reason: not valid java name */
        public boolean m46652for() {
            return C3641break.this.f8703h.charAt(this.f8706if) != ')';
        }

        /* access modifiers changed from: package-private */
        /* renamed from: if */
        public int mo43442if() {
            return this.f8706if;
        }

        /* renamed from: new  reason: not valid java name */
        public double m46653new() {
            if (m46652for()) {
                return m7310do();
            }
            throw C3641break.this.m7294a(this.f8706if, "Function has too few arguments");
        }
    }

    /* renamed from: super.break$for */
    /* compiled from: MathEval */
    public interface C3643for {
        /* renamed from: do */
        double mo43432do(String str, C3642do doVar) throws C3648do;
    }

    /* renamed from: super.break$new */
    /* compiled from: MathEval */
    public static final class C3645new {

        /* renamed from: case  reason: not valid java name */
        final C3646try f62296case;

        /* renamed from: do */
        final char f8709do;

        /* renamed from: for  reason: not valid java name */
        final int f62297for;

        /* renamed from: if */
        final int f8710if;

        /* renamed from: new  reason: not valid java name */
        final int f62298new;

        /* renamed from: try  reason: not valid java name */
        final boolean f62299try;

        public C3645new(char c, int i, C3646try tryR) {
            this(c, i, i, 66, false, tryR);
        }

        public String toString() {
            return "MathOperator['" + this.f8709do + "']";
        }

        C3645new(char c, int i, int i2, int i3, boolean z, C3646try tryR) {
            this.f8709do = c;
            this.f8710if = i;
            this.f62297for = i2;
            this.f62298new = i3;
            this.f62299try = z;
            this.f62296case = tryR;
        }
    }

    /* renamed from: super.break$try */
    /* compiled from: MathEval */
    public interface C3646try {
        /* renamed from: do */
        double mo43431do(double d, char c, double d2) throws C3648do;
    }

    static {
        C3644if ifVar = C3644if.f8707do;
    }

    public C3641break() {
        C3644if.m7314if(this);
        this.f8698c = new TreeMap();
        this.f8699d = new TreeMap();
        mo43434do(ExifInterface.LONGITUDE_EAST, 2.718281828459045d);
        mo43434do("Euler", 0.577215664901533d);
        mo43434do("LN2", 0.693147180559945d);
        mo43434do("LN10", 2.302585092994046d);
        mo43434do("LOG2E", 1.442695040888963d);
        mo43434do("LOG10E", 0.434294481903252d);
        mo43434do("PHI", 1.618033988749895d);
        mo43434do("PI", 3.141592653589793d);
        Comparator comparator = String.CASE_INSENSITIVE_ORDER;
        this.f8700e = new TreeMap(comparator);
        this.f8701f = new TreeMap(comparator);
        C3644if.m7313do(this);
        this.f8702g = false;
        this.f8704i = 0;
    }

    /* renamed from: c */
    private double m7301c(int i, int i2) {
        while (i < i2 && Character.isWhitespace(this.f8703h.charAt(i2))) {
            i2--;
        }
        String substring = this.f8703h.substring(i, i2 + 1);
        Double d = (Double) this.f8698c.get(substring);
        if (d != null) {
            return d.doubleValue();
        }
        Double d2 = (Double) this.f8699d.get(substring);
        if (d2 != null) {
            return d2.doubleValue();
        }
        if (this.f8702g) {
            return 0.0d;
        }
        throw m7294a(i, "Unrecognized constant or variable \"" + substring + Const.jsQuote);
    }

    /* renamed from: super.break$if */
    /* compiled from: MathEval */
    static class C3644if implements C3643for, C3646try {

        /* renamed from: break  reason: not valid java name */
        private static final C3645new f62285break;

        /* renamed from: case  reason: not valid java name */
        private static final C3645new f62286case;

        /* renamed from: catch  reason: not valid java name */
        private static final C3645new f62287catch;

        /* renamed from: class  reason: not valid java name */
        private static final C3645new f62288class;

        /* renamed from: const  reason: not valid java name */
        private static final C3645new f62289const;

        /* renamed from: do */
        static final C3644if f8707do;

        /* renamed from: else  reason: not valid java name */
        private static final C3645new f62290else;

        /* renamed from: for  reason: not valid java name */
        private static final C3645new f62291for;

        /* renamed from: goto  reason: not valid java name */
        private static final C3645new f62292goto;

        /* renamed from: if */
        private static final C3645new f8708if;

        /* renamed from: new  reason: not valid java name */
        private static final C3645new f62293new;

        /* renamed from: this  reason: not valid java name */
        private static final C3645new f62294this;

        /* renamed from: try  reason: not valid java name */
        private static final C3645new f62295try;

        static {
            C3644if ifVar = new C3644if();
            f8707do = ifVar;
            C3644if ifVar2 = ifVar;
            f8708if = new C3645new('=', 99, 99, 82, true, ifVar2);
            f62291for = new C3645new('^', 80, 81, 66, false, ifVar2);
            f62293new = new C3645new(Typography.plusMinus, 60, 60, 82, true, ifVar2);
            f62295try = new C3645new('*', 40, ifVar);
            f62286case = new C3645new(Typography.times, 40, ifVar);
            f62290else = new C3645new(Typography.middleDot, 40, ifVar);
            f62292goto = new C3645new(VersionRange.LEFT_OPEN, 40, ifVar);
            f62294this = new C3645new(IOUtils.DIR_SEPARATOR_UNIX, 40, ifVar);
            f62285break = new C3645new(247, 40, ifVar);
            f62287catch = new C3645new('%', 40, ifVar);
            f62288class = new C3645new('+', 20, ifVar);
            f62289const = new C3645new('-', 20, ifVar);
        }

        private C3644if() {
        }

        /* renamed from: if */
        static void m7314if(C3641break breakR) {
            breakR.mo43438do(f8708if);
            breakR.mo43438do(f62291for);
            breakR.mo43438do(f62293new);
            breakR.mo43438do(f62295try);
            breakR.mo43438do(f62286case);
            breakR.mo43438do(f62290else);
            breakR.mo43438do(f62292goto);
            breakR.mo43438do(f62294this);
            breakR.mo43438do(f62285break);
            breakR.mo43438do(f62287catch);
            breakR.mo43438do(f62288class);
            breakR.mo43438do(f62289const);
        }

        /* renamed from: do */
        public double mo43431do(double d, char c, double d2) {
            if (c == '%') {
                return d % d2;
            }
            if (c == '(') {
                return d * d2;
            }
            if (c == '-') {
                return d - d2;
            }
            if (c == '/') {
                return d / d2;
            }
            if (c == '=') {
                return d2;
            }
            if (c == '^') {
                return Math.pow(d, d2);
            }
            if (c == 177) {
                return -d2;
            }
            if (c == 183) {
                return d * d2;
            }
            if (c == 215) {
                return d * d2;
            }
            if (c == 247) {
                return d / d2;
            }
            if (c == '*') {
                return d * d2;
            }
            if (c == '+') {
                return d + d2;
            }
            throw new UnsupportedOperationException("MathEval internal operator setup is incorrect - internal operator \"" + c + "\" not handled");
        }

        /* renamed from: do */
        public double mo43432do(String str, C3642do doVar) throws C3648do {
            char lowerCase = Character.toLowerCase(str.charAt(0));
            if (lowerCase != 'a') {
                if (lowerCase != 'c') {
                    if (lowerCase != 'e') {
                        if (lowerCase != 'f') {
                            if (lowerCase != 'l') {
                                if (lowerCase != 'm') {
                                    switch (lowerCase) {
                                        case 'r':
                                            if (str.equalsIgnoreCase("random")) {
                                                return Math.random();
                                            }
                                            if (str.equalsIgnoreCase("round")) {
                                                return (double) Math.round(doVar.m46653new());
                                            }
                                            if (str.equalsIgnoreCase("roundHE")) {
                                                return Math.rint(doVar.m46653new());
                                            }
                                            break;
                                        case 's':
                                            if (str.equalsIgnoreCase("signum")) {
                                                return Math.signum(doVar.m46653new());
                                            }
                                            if (str.equalsIgnoreCase("sin")) {
                                                return Math.sin(doVar.m46653new());
                                            }
                                            if (str.equalsIgnoreCase("sinh")) {
                                                return Math.sinh(doVar.m46653new());
                                            }
                                            if (str.equalsIgnoreCase("sqrt")) {
                                                return Math.sqrt(doVar.m46653new());
                                            }
                                            break;
                                        case 't':
                                            if (str.equalsIgnoreCase("tan")) {
                                                return Math.tan(doVar.m46653new());
                                            }
                                            if (str.equalsIgnoreCase("tanh")) {
                                                return Math.tanh(doVar.m46653new());
                                            }
                                            if (str.equalsIgnoreCase("toDegrees")) {
                                                return Math.toDegrees(doVar.m46653new());
                                            }
                                            if (str.equalsIgnoreCase("toRadians")) {
                                                return Math.toRadians(doVar.m46653new());
                                            }
                                            break;
                                        case 'u':
                                            if (str.equalsIgnoreCase("ulp")) {
                                                return Math.ulp(doVar.m46653new());
                                            }
                                            break;
                                    }
                                } else if (str.equalsIgnoreCase("max")) {
                                    return Math.max(doVar.m46653new(), doVar.m46653new());
                                } else {
                                    if (str.equalsIgnoreCase("min")) {
                                        return Math.min(doVar.m46653new(), doVar.m46653new());
                                    }
                                }
                            } else if (str.equalsIgnoreCase("log")) {
                                return Math.log(doVar.m46653new());
                            } else {
                                if (str.equalsIgnoreCase("log10")) {
                                    return Math.log10(doVar.m46653new());
                                }
                                if (str.equalsIgnoreCase("log1p")) {
                                    return Math.log1p(doVar.m46653new());
                                }
                            }
                        } else if (str.equalsIgnoreCase("floor")) {
                            return Math.floor(doVar.m46653new());
                        }
                    } else if (str.equalsIgnoreCase(AuthenticationTokenClaims.JSON_KEY_EXP)) {
                        return Math.exp(doVar.m46653new());
                    } else {
                        if (str.equalsIgnoreCase("expm1")) {
                            return Math.expm1(doVar.m46653new());
                        }
                    }
                } else if (str.equalsIgnoreCase("cbrt")) {
                    return Math.cbrt(doVar.m46653new());
                } else {
                    if (str.equalsIgnoreCase("ceil")) {
                        return Math.ceil(doVar.m46653new());
                    }
                    if (str.equalsIgnoreCase("cos")) {
                        return Math.cos(doVar.m46653new());
                    }
                    if (str.equalsIgnoreCase("cosh")) {
                        return Math.cosh(doVar.m46653new());
                    }
                }
            } else if (str.equalsIgnoreCase("abs")) {
                return Math.abs(doVar.m46653new());
            } else {
                if (str.equalsIgnoreCase("acos")) {
                    return Math.acos(doVar.m46653new());
                }
                if (str.equalsIgnoreCase("asin")) {
                    return Math.asin(doVar.m46653new());
                }
                if (str.equalsIgnoreCase("atan")) {
                    return Math.atan(doVar.m46653new());
                }
            }
            throw new UnsupportedOperationException("MathEval internal function setup is incorrect - internal function \"" + str + "\" not handled");
        }

        /* renamed from: do */
        static void m7313do(C3641break breakR) {
            C3644if ifVar = f8707do;
            breakR.mo43436do("abs", (C3643for) ifVar);
            breakR.mo43436do("acos", (C3643for) ifVar);
            breakR.mo43436do("asin", (C3643for) ifVar);
            breakR.mo43436do("atan", (C3643for) ifVar);
            breakR.mo43436do("cbrt", (C3643for) ifVar);
            breakR.mo43436do("ceil", (C3643for) ifVar);
            breakR.mo43436do("cos", (C3643for) ifVar);
            breakR.mo43436do("cosh", (C3643for) ifVar);
            breakR.mo43436do(AuthenticationTokenClaims.JSON_KEY_EXP, (C3643for) ifVar);
            breakR.mo43436do("expm1", (C3643for) ifVar);
            breakR.mo43436do("floor", (C3643for) ifVar);
            breakR.mo43436do("log", (C3643for) ifVar);
            breakR.mo43436do("log10", (C3643for) ifVar);
            breakR.mo43436do("log1p", (C3643for) ifVar);
            breakR.mo43436do("max", (C3643for) ifVar);
            breakR.mo43436do("min", (C3643for) ifVar);
            breakR.mo43437do("random", ifVar, true);
            breakR.mo43436do("round", (C3643for) ifVar);
            breakR.mo43436do("roundHE", (C3643for) ifVar);
            breakR.mo43436do("signum", (C3643for) ifVar);
            breakR.mo43436do("sin", (C3643for) ifVar);
            breakR.mo43436do("sinh", (C3643for) ifVar);
            breakR.mo43436do("sqrt", (C3643for) ifVar);
            breakR.mo43436do("tan", (C3643for) ifVar);
            breakR.mo43436do("tanh", (C3643for) ifVar);
            breakR.mo43436do("toDegrees", (C3643for) ifVar);
            breakR.mo43436do("toRadians", (C3643for) ifVar);
            breakR.mo43436do("ulp", (C3643for) ifVar);
        }
    }

    /* renamed from: if */
    public C3641break mo43439if(String str, double d) {
        return mo43440if(str, Double.valueOf(d));
    }

    /* renamed from: if */
    public C3641break mo43440if(String str, Double d) {
        m7297a(str);
        if (d == null) {
            this.f8699d.remove(str);
        } else {
            this.f8699d.put(str, d);
        }
        return this;
    }

    /* renamed from: do */
    public C3641break mo43434do(String str, double d) {
        return mo43435do(str, Double.valueOf(d));
    }

    /* renamed from: do */
    public C3641break mo43435do(String str, Double d) {
        if (this.f8698c.get(str) == null) {
            m7297a(str);
            this.f8698c.put(str, d);
            return this;
        }
        throw new IllegalArgumentException("Constants may not be redefined");
    }

    /* renamed from: a */
    private void m7297a(String str) {
        if (!Character.isLetter(str.charAt(0))) {
            throw new IllegalArgumentException("Names for constants, variables and functions must start with a letter");
        } else if (str.indexOf(40) != -1 || str.indexOf(41) != -1) {
            throw new IllegalArgumentException("Names for constants, variables and functions may not contain a parenthesis");
        }
    }

    /* renamed from: do */
    public C3641break mo43438do(C3645new newR) {
        char c = newR.f8709do;
        C3645new[] newArr = this.f8697b;
        if (c >= newArr.length) {
            C3645new[] newArr2 = new C3645new[(c + (c % 255) + 1)];
            System.arraycopy(newArr, 0, newArr2, 0, newArr.length);
            this.f8697b = newArr2;
        }
        this.f8697b[newR.f8709do] = newR;
        return this;
    }

    /* renamed from: b */
    private double m7299b(int i, int i2) {
        int i3 = i;
        while (i3 <= i2 && this.f8703h.charAt(i3) != '(') {
            i3++;
        }
        String trim = this.f8703h.substring(i, i3).trim();
        C3642do doVar = new C3642do(i3, i2);
        try {
            C3643for forR = (C3643for) this.f8700e.get(trim);
            if (forR != null) {
                double d = forR.mo43432do(trim, doVar);
                if (!doVar.m46652for()) {
                    this.f8704i = doVar.mo43442if();
                    return d;
                }
                throw m7294a(doVar.mo43442if(), "Function has too many arguments");
            }
            C3643for forR2 = (C3643for) this.f8701f.get(trim);
            if (forR2 != null) {
                double d2 = forR2.mo43432do(trim, doVar);
                if (!doVar.m46652for()) {
                    this.f8704i = doVar.mo43442if();
                    return d2;
                }
                throw m7294a(doVar.mo43442if(), "Function has too many arguments");
            }
            throw m7294a(i, "Function \"" + trim + "\" not recognized");
        } catch (C3648do e) {
            throw e;
        } catch (NoSuchMethodError unused) {
            throw m7294a(i, "Function not supported in this JVM: \"" + trim + Const.jsQuote);
        } catch (UnsupportedOperationException e2) {
            throw m7294a(i, e2.getMessage());
        } catch (Throwable th) {
            throw m7295a(i, "Unexpected exception parsing function arguments", th);
        }
    }

    /* renamed from: do */
    public C3641break mo43436do(String str, C3643for forR) {
        return mo43437do(str, forR, false);
    }

    /* renamed from: do */
    public C3641break mo43437do(String str, C3643for forR, boolean z) {
        m7297a(str);
        if (forR == null) {
            this.f8700e.remove(str);
            this.f8701f.remove(str);
        } else if (z) {
            this.f8700e.remove(str);
            this.f8701f.put(str, forR);
        } else {
            this.f8700e.put(str, forR);
            this.f8701f.remove(str);
        }
        return this;
    }

    /* renamed from: do */
    public double mo43433do(String str) throws NumberFormatException, C3648do {
        this.f8703h = str;
        this.f8704i = 0;
        return m7286a(0, str.length() - 1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public double m7286a(int i, int i2) throws NumberFormatException, C3648do {
        return m7287a(i, i2, 0.0d, f8696a, m7293a('='));
    }

    /* JADX WARNING: Removed duplicated region for block: B:53:0x00fa  */
    /* JADX WARNING: Removed duplicated region for block: B:58:0x011c  */
    /* JADX WARNING: Removed duplicated region for block: B:62:0x0140  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0139 A[SYNTHETIC] */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private double m7287a(int r22, int r23, double r24, p094super.C3641break.C3645new r26, p094super.C3641break.C3645new r27) throws java.lang.NumberFormatException, p094super.C3648do {
        /*
            r21 = this;
            r7 = r21
            r8 = r23
            super.break$new r0 = f8696a
            r1 = r22
            r9 = r24
            r11 = r27
            r2 = r0
            r0 = r1
        L_0x000e:
            java.lang.String r3 = r7.f8703h
            int r12 = r7.m7289a((java.lang.String) r3, (int) r0, (int) r8)
            r13 = 76
            if (r12 > r8) goto L_0x017d
            r0 = r12
        L_0x0019:
            if (r0 > r8) goto L_0x003b
            java.lang.String r1 = r7.f8703h
            char r1 = r1.charAt(r0)
            super.break$new r2 = r7.m7293a((char) r1)
            super.break$new r3 = f8696a
            if (r2 == r3) goto L_0x002f
            boolean r1 = r2.f62299try
            if (r1 == 0) goto L_0x003b
            r2 = r3
            goto L_0x0038
        L_0x002f:
            r3 = 41
            if (r1 == r3) goto L_0x003b
            r3 = 44
            if (r1 != r3) goto L_0x0038
            goto L_0x003b
        L_0x0038:
            int r0 = r0 + 1
            goto L_0x0019
        L_0x003b:
            java.lang.String r1 = r7.f8703h
            char r1 = r1.charAt(r12)
            boolean r3 = java.lang.Character.isLetter(r1)
            int r4 = r11.f62298new
            if (r4 == r13) goto L_0x005d
            r4 = 43
            if (r1 != r4) goto L_0x0053
            r3 = r9
            r9 = r2
            r2 = r26
            goto L_0x0151
        L_0x0053:
            r4 = 45
            if (r1 != r4) goto L_0x005d
            r2 = 177(0xb1, float:2.48E-43)
            super.break$new r2 = r7.m7293a((char) r2)
        L_0x005d:
            r14 = 82
            r15 = 40
            if (r12 != r0) goto L_0x0070
            int r4 = r11.f62298new
            if (r4 == r13) goto L_0x006b
            int r4 = r2.f62298new
            if (r4 != r14) goto L_0x0070
        L_0x006b:
            r3 = 9221120237041090560(0x7ff8000000000000, double:NaN)
        L_0x006d:
            r6 = r2
            goto L_0x00f0
        L_0x0070:
            if (r1 != r15) goto L_0x0095
            int r0 = r12 + 1
            double r0 = r7.m7286a((int) r0, (int) r8)
            java.lang.String r2 = r7.f8703h
            int r3 = r7.f8704i
            int r3 = r3 + 1
            int r2 = r7.m7289a((java.lang.String) r2, (int) r3, (int) r8)
            if (r2 > r8) goto L_0x008f
            java.lang.String r3 = r7.f8703h
            char r3 = r3.charAt(r2)
            super.break$new r3 = r7.m7293a((char) r3)
            goto L_0x0091
        L_0x008f:
            super.break$new r3 = f8696a
        L_0x0091:
            r6 = r3
            r3 = r0
            r0 = r2
            goto L_0x00f0
        L_0x0095:
            if (r3 == 0) goto L_0x00b9
            char r1 = r2.f8709do
            if (r1 != r15) goto L_0x00b9
            double r0 = r7.m7299b(r12, r8)
            java.lang.String r2 = r7.f8703h
            int r3 = r7.f8704i
            int r3 = r3 + 1
            int r2 = r7.m7289a((java.lang.String) r2, (int) r3, (int) r8)
            if (r2 > r8) goto L_0x00b6
            java.lang.String r3 = r7.f8703h
            char r3 = r3.charAt(r2)
            super.break$new r3 = r7.m7293a((char) r3)
            goto L_0x0091
        L_0x00b6:
            super.break$new r3 = f8696a
            goto L_0x0091
        L_0x00b9:
            if (r3 == 0) goto L_0x00c2
            int r1 = r0 + -1
            double r3 = r7.m7301c(r12, r1)
            goto L_0x006d
        L_0x00c2:
            java.lang.String r1 = r7.f8703h     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r3 = "0x"
            boolean r1 = r7.m7298a((java.lang.String) r1, (int) r12, (java.lang.String) r3)     // Catch:{ NumberFormatException -> 0x0158 }
            if (r1 == 0) goto L_0x00e0
            java.lang.String r1 = r7.f8703h     // Catch:{ NumberFormatException -> 0x0158 }
            int r3 = r12 + 2
            java.lang.String r1 = r1.substring(r3, r0)     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r1 = r1.trim()     // Catch:{ NumberFormatException -> 0x0158 }
            r3 = 16
            long r3 = java.lang.Long.parseLong(r1, r3)     // Catch:{ NumberFormatException -> 0x0158 }
            double r3 = (double) r3     // Catch:{ NumberFormatException -> 0x0158 }
            goto L_0x006d
        L_0x00e0:
            java.lang.String r1 = r7.f8703h     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r1 = r1.substring(r12, r0)     // Catch:{ NumberFormatException -> 0x0158 }
            java.lang.String r1 = r1.trim()     // Catch:{ NumberFormatException -> 0x0158 }
            double r3 = java.lang.Double.parseDouble(r1)     // Catch:{ NumberFormatException -> 0x0158 }
            goto L_0x006d
        L_0x00f0:
            int r1 = r7.m7290a((p094super.C3641break.C3645new) r11, (int) r13)
            int r2 = r7.m7290a((p094super.C3641break.C3645new) r6, (int) r14)
            if (r1 >= r2) goto L_0x011c
            int r1 = r0 + 1
            r0 = r21
            r2 = r23
            r5 = r11
            double r0 = r0.m7287a(r1, r2, r3, r5, r6)
            int r2 = r7.f8704i
            if (r2 > r8) goto L_0x0114
            java.lang.String r3 = r7.f8703h
            char r3 = r3.charAt(r2)
            super.break$new r3 = r7.m7293a((char) r3)
            goto L_0x0116
        L_0x0114:
            super.break$new r3 = f8696a
        L_0x0116:
            r17 = r0
            r16 = r2
            r5 = r3
            goto L_0x0121
        L_0x011c:
            r16 = r0
            r17 = r3
            r5 = r6
        L_0x0121:
            r0 = r21
            r1 = r12
            r2 = r9
            r4 = r11
            r9 = r5
            r5 = r17
            double r0 = r0.m7285a((int) r1, (double) r2, (p094super.C3641break.C3645new) r4, (double) r5)
            r2 = r26
            int r3 = r7.m7290a((p094super.C3641break.C3645new) r2, (int) r13)
            int r4 = r7.m7290a((p094super.C3641break.C3645new) r9, (int) r14)
            if (r3 < r4) goto L_0x0140
            r2 = r9
            r4 = r2
            r9 = r0
            r1 = r12
            r12 = r16
            goto L_0x017e
        L_0x0140:
            char r3 = r9.f8709do
            if (r3 != r15) goto L_0x014d
            int r3 = r16 + -1
            r11 = r9
            r19 = r0
            r0 = r3
            r3 = r19
            goto L_0x0151
        L_0x014d:
            r3 = r0
            r11 = r9
            r0 = r16
        L_0x0151:
            int r0 = r0 + 1
            r2 = r9
            r1 = r12
            r9 = r3
            goto L_0x000e
        L_0x0158:
            java.lang.StringBuilder r1 = new java.lang.StringBuilder
            r1.<init>()
            java.lang.String r2 = "Invalid numeric value \""
            r1.append(r2)
            java.lang.String r2 = r7.f8703h
            java.lang.String r0 = r2.substring(r12, r0)
            java.lang.String r0 = r0.trim()
            r1.append(r0)
            java.lang.String r0 = "\""
            r1.append(r0)
            java.lang.String r0 = r1.toString()
            super.do r0 = r7.m7294a((int) r12, (java.lang.String) r0)
            throw r0
        L_0x017d:
            r4 = r11
        L_0x017e:
            if (r12 <= r8) goto L_0x01af
            super.break$new r0 = f8696a
            if (r4 == r0) goto L_0x01af
            int r0 = r4.f62298new
            if (r0 != r13) goto L_0x0192
            r5 = 9221120237041090560(0x7ff8000000000000, double:NaN)
            r0 = r21
            r2 = r9
            double r9 = r0.m7285a((int) r1, (double) r2, (p094super.C3641break.C3645new) r4, (double) r5)
            goto L_0x01af
        L_0x0192:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r1 = "Expression ends with a blank operand after operator '"
            r0.append(r1)
            char r1 = r2.f8709do
            r0.append(r1)
            java.lang.String r1 = "'"
            r0.append(r1)
            java.lang.String r0 = r0.toString()
            super.do r0 = r7.m7294a((int) r12, (java.lang.String) r0)
            throw r0
        L_0x01af:
            r7.f8704i = r12
            return r9
        */
        throw new UnsupportedOperationException("Method not decompiled: p094super.C3641break.m7287a(int, int, double, super.break$new, super.break$new):double");
    }

    /* renamed from: a */
    private C3645new m7293a(char c) {
        C3645new newR;
        C3645new[] newArr = this.f8697b;
        if (c >= newArr.length || (newR = newArr[c]) == null) {
            return f8696a;
        }
        return newR;
    }

    /* renamed from: a */
    private int m7290a(C3645new newR, int i) {
        if (newR == null) {
            return Integer.MIN_VALUE;
        }
        int i2 = newR.f62298new;
        if (i2 == 66 || i2 != i) {
            return i == 76 ? newR.f8710if : newR.f62297for;
        }
        return Integer.MAX_VALUE;
    }

    /* renamed from: a */
    private double m7285a(int i, double d, C3645new newR, double d2) {
        if (newR.f62298new != 82 && Double.isNaN(d)) {
            throw m7294a(i, "Mathematical NaN detected in right-operand");
        } else if (newR.f62298new == 76 || !Double.isNaN(d2)) {
            try {
                return newR.f62296case.mo43431do(d, newR.f8709do, d2);
            } catch (C3648do e) {
                throw m7295a(i, "Mathematical expression \"" + this.f8703h + "\" failed to evaluate", (Throwable) e);
            } catch (UnsupportedOperationException unused) {
                while (i > 0 && m7293a(this.f8703h.charAt(i)) == null) {
                    i--;
                }
                throw m7294a(i, "Operator \"" + newR.f8709do + "\" not handled by math engine (Programmer error: The list of operators is inconsistent within the engine)");
            }
        } else {
            throw m7294a(i, "Mathematical NaN detected in left-operand");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public C3648do m7294a(int i, String str) {
        return new C3648do(str + " at offset " + i + " in expression \"" + this.f8703h + Const.jsQuote);
    }

    /* renamed from: a */
    private C3648do m7295a(int i, String str, Throwable th) {
        StringBuilder sb = new StringBuilder();
        sb.append(str);
        sb.append(" at offset ");
        sb.append(i);
        sb.append(" in expression \"");
        sb.append(this.f8703h);
        sb.append("\" (Cause: ");
        sb.append(th.getMessage() != null ? th.getMessage() : th.toString());
        sb.append(")");
        return new C3648do(sb.toString());
    }

    /* renamed from: a */
    private boolean m7298a(String str, int i, String str2) {
        return str.regionMatches(true, i, str2, 0, str2.length());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public int m7289a(String str, int i, int i2) {
        while (i <= i2 && Character.isWhitespace(str.charAt(i))) {
            i++;
        }
        return i;
    }
}
