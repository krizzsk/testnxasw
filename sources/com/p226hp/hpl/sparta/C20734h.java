package com.p226hp.hpl.sparta;

import com.didi.beatles.p101im.access.utils.IMTextUtils;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.IOException;
import java.io.Reader;
import java.util.Hashtable;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.apache.commons.p074io.IOUtils;
import org.osgi.framework.VersionRange;

/* renamed from: com.hp.hpl.sparta.h */
/* compiled from: ParseCharStream */
class C20734h implements ParseSource {

    /* renamed from: N */
    private static final int f56758N = 255;

    /* renamed from: a */
    public static final int f56759a = 100;

    /* renamed from: b */
    private static final boolean f56760b = true;

    /* renamed from: c */
    private static final boolean f56761c = false;

    /* renamed from: d */
    private static final char[] f56762d = {'.', '-', '_', ':'};

    /* renamed from: e */
    private static final int f56763e = 128;

    /* renamed from: f */
    private static final boolean[] f56764f = new boolean[128];

    /* renamed from: g */
    private static final char[] f56765g = "<!--".toCharArray();

    /* renamed from: h */
    private static final char[] f56766h = "-->".toCharArray();

    /* renamed from: i */
    private static final char[] f56767i = "<?".toCharArray();

    /* renamed from: j */
    private static final char[] f56768j = "?>".toCharArray();

    /* renamed from: k */
    private static final char[] f56769k = "<!DOCTYPE".toCharArray();

    /* renamed from: l */
    private static final char[] f56770l = "<?xml".toCharArray();

    /* renamed from: m */
    private static final char[] f56771m = "encoding".toCharArray();

    /* renamed from: n */
    private static final char[] f56772n = "version".toCharArray();

    /* renamed from: o */
    private static final char[] f56773o = {'_', '.', ':', '-'};

    /* renamed from: p */
    private static final char[] f56774p = "<!".toCharArray();

    /* renamed from: q */
    private static final char[] f56775q = "&#".toCharArray();

    /* renamed from: r */
    private static final char[] f56776r = "<!ENTITY".toCharArray();

    /* renamed from: s */
    private static final char[] f56777s = "NDATA".toCharArray();

    /* renamed from: t */
    private static final char[] f56778t = "SYSTEM".toCharArray();

    /* renamed from: u */
    private static final char[] f56779u = "PUBLIC".toCharArray();

    /* renamed from: v */
    private static final char[] f56780v = "<![CDATA[".toCharArray();

    /* renamed from: w */
    private static final char[] f56781w = "]]>".toCharArray();

    /* renamed from: x */
    private static final char[] f56782x = "/>".toCharArray();

    /* renamed from: y */
    private static final char[] f56783y = "</".toCharArray();

    /* renamed from: A */
    private String f56784A;

    /* renamed from: B */
    private final Reader f56785B;

    /* renamed from: C */
    private final Hashtable f56786C;

    /* renamed from: D */
    private final Hashtable f56787D;

    /* renamed from: E */
    private final ParseLog f56788E;

    /* renamed from: F */
    private final String f56789F;

    /* renamed from: G */
    private int f56790G;

    /* renamed from: H */
    private boolean f56791H;

    /* renamed from: I */
    private final int f56792I;

    /* renamed from: J */
    private final char[] f56793J;

    /* renamed from: K */
    private int f56794K;

    /* renamed from: L */
    private int f56795L;

    /* renamed from: M */
    private boolean f56796M;

    /* renamed from: O */
    private final char[] f56797O;

    /* renamed from: P */
    private int f56798P;

    /* renamed from: Q */
    private final C20728b f56799Q;

    /* renamed from: R */
    private final ParseHandler f56800R;

    /* renamed from: z */
    private String f56801z;

    /* renamed from: e */
    private static boolean m42808e(char c) {
        if (c == 183 || c == 903 || c == 1600 || c == 3654 || c == 3782 || c == 12293 || c == 720 || c == 721 || c == 12445 || c == 12446) {
            return true;
        }
        switch (c) {
            case 12337:
            case 12338:
            case 12339:
            case 12340:
            case 12341:
                return true;
            default:
                switch (c) {
                    case 12540:
                    case 12541:
                    case 12542:
                        return true;
                    default:
                        return false;
                }
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final String mo171211b() {
        return "";
    }

    public C20734h(String str, char[] cArr, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this(str, (Reader) null, cArr, parseLog, str2, parseHandler);
    }

    public C20734h(String str, Reader reader, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        this(str, reader, (char[]) null, parseLog, str2, parseHandler);
    }

    public C20734h(String str, Reader reader, char[] cArr, ParseLog parseLog, String str2, ParseHandler parseHandler) throws ParseException, EncodingMismatchException, IOException {
        String str3;
        this.f56784A = null;
        this.f56786C = new Hashtable();
        this.f56787D = new Hashtable();
        this.f56790G = -2;
        this.f56791H = false;
        this.f56792I = 1024;
        this.f56794K = 0;
        this.f56795L = 0;
        this.f56796M = false;
        this.f56797O = new char[255];
        this.f56798P = -1;
        this.f56798P = 1;
        this.f56799Q = null;
        this.f56788E = parseLog == null ? DEFAULT_LOG : parseLog;
        if (str2 == null) {
            str3 = null;
        } else {
            str3 = str2.toLowerCase();
        }
        this.f56789F = str3;
        this.f56786C.put("lt", IMTextUtils.STREET_IMAGE_TAG_START);
        this.f56786C.put("gt", IMTextUtils.STREET_IMAGE_TAG_END);
        this.f56786C.put("amp", ParamKeys.SIGN_AND);
        this.f56786C.put("apos", "'");
        this.f56786C.put("quot", Const.jsQuote);
        if (cArr != null) {
            this.f56793J = cArr;
            this.f56794K = 0;
            this.f56795L = cArr.length;
            this.f56796M = true;
            this.f56785B = null;
        } else {
            this.f56785B = reader;
            this.f56793J = new char[1024];
            m42805d();
        }
        this.f56801z = str;
        this.f56800R = parseHandler;
        parseHandler.setParseSource(this);
        m42825v();
        this.f56800R.startDocument();
        Element X = m42788X();
        String str4 = this.f56784A;
        if (str4 != null && !str4.equals(X.getTagName())) {
            this.f56788E.warning("DOCTYPE name \"" + this.f56784A + "\" not same as tag name, \"" + X.getTagName() + "\" of root element", this.f56801z, getLineNumber());
        }
        while (m42819p()) {
            m42820q();
        }
        Reader reader2 = this.f56785B;
        if (reader2 != null) {
            reader2.close();
        }
        this.f56800R.endDocument();
    }

    public String toString() {
        return this.f56801z;
    }

    public String getSystemId() {
        return this.f56801z;
    }

    public int getLineNumber() {
        return this.f56798P;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo171210a() {
        return this.f56790G;
    }

    /* renamed from: d */
    private int m42805d() throws IOException {
        if (this.f56796M) {
            return -1;
        }
        if (this.f56795L == this.f56793J.length) {
            this.f56795L = 0;
            this.f56794K = 0;
        }
        Reader reader = this.f56785B;
        char[] cArr = this.f56793J;
        int i = this.f56795L;
        int read = reader.read(cArr, i, cArr.length - i);
        if (read <= 0) {
            this.f56796M = true;
            return -1;
        }
        this.f56795L += read;
        return read;
    }

    /* renamed from: a */
    private int m42793a(int i) throws IOException {
        int i2;
        int i3;
        if (this.f56796M) {
            return -1;
        }
        int i4 = 0;
        if (this.f56793J.length - this.f56794K < i) {
            int i5 = 0;
            while (true) {
                i2 = this.f56794K;
                int i6 = i2 + i5;
                i3 = this.f56795L;
                if (i6 >= i3) {
                    break;
                }
                char[] cArr = this.f56793J;
                cArr[i5] = cArr[i2 + i5];
                i5++;
            }
            int i7 = i3 - i2;
            this.f56795L = i7;
            this.f56794K = 0;
            i4 = i7;
        }
        int d = m42805d();
        if (d != -1) {
            return i4 + d;
        }
        if (i4 == 0) {
            return -1;
        }
        return i4;
    }

    /* renamed from: e */
    private final char m42807e() throws ParseException, IOException {
        if (this.f56794K < this.f56795L || m42805d() != -1) {
            if (this.f56793J[this.f56794K] == 10) {
                this.f56798P++;
            }
            char[] cArr = this.f56793J;
            int i = this.f56794K;
            this.f56794K = i + 1;
            return cArr[i];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    /* renamed from: f */
    private final char m42809f() throws ParseException, IOException {
        if (this.f56794K < this.f56795L || m42805d() != -1) {
            return this.f56793J[this.f56794K];
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    /* renamed from: a */
    private final void m42794a(char c) throws ParseException, IOException {
        char e = m42807e();
        if (e != c) {
            throw new ParseException(this, e, c);
        }
    }

    /* renamed from: b */
    private final boolean m42799b(char c) throws ParseException, IOException {
        if (this.f56794K < this.f56795L || m42805d() != -1) {
            return this.f56793J[this.f56794K] == c;
        }
        throw new ParseException(this, "unexpected end of expression.");
    }

    /* renamed from: a */
    private final char m42791a(char c, char c2) throws ParseException, IOException {
        char e = m42807e();
        if (e == c || e == c2) {
            return e;
        }
        throw new ParseException(this, e, new char[]{c, c2});
    }

    /* renamed from: a */
    private final char m42792a(char c, char c2, char c3, char c4) throws ParseException, IOException {
        char e = m42807e();
        if (e == c || e == c2 || e == c3 || e == c4) {
            return e;
        }
        throw new ParseException(this, e, new char[]{c, c2, c3, c4});
    }

    /* renamed from: b */
    private final boolean m42800b(char c, char c2) throws ParseException, IOException {
        if (this.f56794K >= this.f56795L && m42805d() == -1) {
            return false;
        }
        char c3 = this.f56793J[this.f56794K];
        if (c3 == c || c3 == c2) {
            return true;
        }
        return false;
    }

    /* renamed from: b */
    private final boolean m42801b(char c, char c2, char c3, char c4) throws ParseException, IOException {
        if (this.f56794K >= this.f56795L && m42805d() == -1) {
            return false;
        }
        char c5 = this.f56793J[this.f56794K];
        if (c5 == c || c5 == c2 || c5 == c3 || c5 == c4) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private static final boolean m42796a(char c, char[] cArr) {
        for (char c2 : cArr) {
            if (c == c2) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private final void m42810g() throws ParseException, IOException {
        m42792a(' ', 9, CharUtils.f7473CR, 10);
        while (m42801b(' ', 9, CharUtils.f7473CR, 10)) {
            m42807e();
        }
    }

    /* renamed from: h */
    private final boolean m42811h() throws ParseException, IOException {
        return m42801b(' ', 9, CharUtils.f7473CR, 10);
    }

    static {
        for (char c = 0; c < 128; c = (char) (c + 1)) {
            f56764f[c] = m42806d(c);
        }
    }

    /* renamed from: i */
    private boolean m42812i() throws ParseException, IOException {
        char f = m42809f();
        return f < 128 ? f56764f[f] : m42806d(f);
    }

    /* renamed from: c */
    private static boolean m42804c(char c) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(Character.toLowerCase(c)) != -1;
    }

    /* renamed from: d */
    private static boolean m42806d(char c) {
        return Character.isDigit(c) || m42804c(c) || m42796a(c, f56762d) || m42808e(c);
    }

    /* renamed from: j */
    private final String m42813j() throws ParseException, IOException {
        this.f56797O[0] = m42814k();
        int i = 1;
        StringBuffer stringBuffer = null;
        while (m42812i()) {
            if (i >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i);
                    stringBuffer.append(this.f56797O, 0, i);
                } else {
                    stringBuffer.append(this.f56797O, 0, i);
                }
                i = 0;
            }
            this.f56797O[i] = m42807e();
            i++;
        }
        if (stringBuffer == null) {
            return Sparta.intern(new String(this.f56797O, 0, i));
        }
        stringBuffer.append(this.f56797O, 0, i);
        return stringBuffer.toString();
    }

    /* renamed from: k */
    private char m42814k() throws ParseException, IOException {
        char e = m42807e();
        if (m42804c(e) || e == '_' || e == ':') {
            return e;
        }
        throw new ParseException(this, e, "letter, underscore, colon");
    }

    /* renamed from: l */
    private final String m42815l() throws ParseException, IOException {
        char a = m42791a('\'', (char) Typography.quote);
        StringBuffer stringBuffer = new StringBuffer();
        while (!m42799b(a)) {
            if (m42779O()) {
                stringBuffer.append(m42778N());
            } else if (m42776L()) {
                stringBuffer.append(m42775K());
            } else {
                stringBuffer.append(m42807e());
            }
        }
        m42794a(a);
        return stringBuffer.toString();
    }

    /* renamed from: m */
    private final boolean m42816m() throws ParseException, IOException {
        return m42800b('\'', Typography.quote);
    }

    /* renamed from: n */
    private final void m42817n() throws ParseException, IOException {
        char e = m42807e();
        while (m42809f() != e) {
            m42807e();
        }
        m42794a(e);
    }

    /* renamed from: o */
    private final void m42818o() throws ParseException, IOException {
        m42817n();
    }

    /* renamed from: p */
    private boolean m42819p() throws ParseException, IOException {
        return m42822s() || m42824u() || m42811h();
    }

    /* renamed from: q */
    private void m42820q() throws ParseException, IOException {
        if (m42822s()) {
            m42821r();
        } else if (m42824u()) {
            m42823t();
        } else if (m42811h()) {
            m42810g();
        } else {
            throw new ParseException(this, "expecting comment or processing instruction or space");
        }
    }

    /* renamed from: r */
    private final void m42821r() throws ParseException, IOException {
        m42795a(f56765g);
        while (!m42802b(f56766h)) {
            m42807e();
        }
        m42795a(f56766h);
    }

    /* renamed from: s */
    private final boolean m42822s() throws ParseException, IOException {
        return m42802b(f56765g);
    }

    /* renamed from: t */
    private final void m42823t() throws ParseException, IOException {
        m42795a(f56767i);
        while (!m42802b(f56768j)) {
            m42807e();
        }
        m42795a(f56768j);
    }

    /* renamed from: u */
    private final boolean m42824u() throws ParseException, IOException {
        return m42802b(f56767i);
    }

    /* renamed from: v */
    private void m42825v() throws ParseException, EncodingMismatchException, IOException {
        if (m42828y()) {
            m42827x();
        }
        while (m42819p()) {
            m42820q();
        }
        if (m42826w()) {
            m42770F();
            while (m42819p()) {
                m42820q();
            }
        }
    }

    /* renamed from: w */
    private boolean m42826w() throws ParseException, IOException {
        return m42802b(f56769k);
    }

    /* renamed from: x */
    private void m42827x() throws ParseException, EncodingMismatchException, IOException {
        m42795a(f56770l);
        m42766B();
        if (m42811h()) {
            m42810g();
        }
        if (m42829z()) {
            String A = m42765A();
            if (this.f56789F != null && !A.toLowerCase().equals(this.f56789F)) {
                throw new EncodingMismatchException(this.f56801z, A, this.f56789F);
            }
        }
        while (!m42802b(f56768j)) {
            m42807e();
        }
        m42795a(f56768j);
    }

    /* renamed from: y */
    private boolean m42828y() throws ParseException, IOException {
        return m42802b(f56770l);
    }

    /* renamed from: z */
    private boolean m42829z() throws ParseException, IOException {
        return m42802b(f56771m);
    }

    /* renamed from: A */
    private String m42765A() throws ParseException, IOException {
        m42795a(f56771m);
        m42767C();
        char a = m42791a('\'', (char) Typography.quote);
        StringBuffer stringBuffer = new StringBuffer();
        while (!m42799b(a)) {
            stringBuffer.append(m42807e());
        }
        m42794a(a);
        return stringBuffer.toString();
    }

    /* renamed from: B */
    private void m42766B() throws ParseException, IOException {
        m42810g();
        m42795a(f56772n);
        m42767C();
        char a = m42791a('\'', (char) Typography.quote);
        m42769E();
        m42794a(a);
    }

    /* renamed from: C */
    private final void m42767C() throws ParseException, IOException {
        if (m42811h()) {
            m42810g();
        }
        m42794a('=');
        if (m42811h()) {
            m42810g();
        }
    }

    /* renamed from: D */
    private boolean m42768D() throws ParseException, IOException {
        char f = m42809f();
        return Character.isDigit(f) || ('a' <= f && f <= 'z') || (('Z' <= f && f <= 'Z') || m42796a(f, f56773o));
    }

    /* renamed from: E */
    private void m42769E() throws ParseException, IOException {
        m42807e();
        while (m42768D()) {
            m42807e();
        }
    }

    /* renamed from: F */
    private void m42770F() throws ParseException, IOException {
        m42795a(f56769k);
        m42810g();
        this.f56784A = m42813j();
        if (m42811h()) {
            m42810g();
            if (!m42799b((char) Typography.greater) && !m42799b((char) VersionRange.LEFT_CLOSED)) {
                this.f56791H = true;
                m42782R();
                if (m42811h()) {
                    m42810g();
                }
            }
        }
        if (m42799b((char) VersionRange.LEFT_CLOSED)) {
            m42807e();
            while (!m42799b((char) VersionRange.RIGHT_CLOSED)) {
                if (m42772H()) {
                    m42771G();
                } else {
                    m42773I();
                }
            }
            m42794a((char) VersionRange.RIGHT_CLOSED);
            if (m42811h()) {
                m42810g();
            }
        }
        m42794a((char) Typography.greater);
    }

    /* renamed from: G */
    private void m42771G() throws ParseException, IOException {
        if (m42779O()) {
            m42778N();
        } else {
            m42810g();
        }
    }

    /* renamed from: H */
    private boolean m42772H() throws ParseException, IOException {
        return m42779O() || m42811h();
    }

    /* renamed from: I */
    private void m42773I() throws ParseException, IOException {
        if (m42824u()) {
            m42823t();
        } else if (m42822s()) {
            m42821r();
        } else if (m42781Q()) {
            m42780P();
        } else if (m42802b(f56774p)) {
            while (!m42799b((char) Typography.greater)) {
                if (m42800b('\'', Typography.quote)) {
                    char e = m42807e();
                    while (!m42799b(e)) {
                        m42807e();
                    }
                    m42794a(e);
                } else {
                    m42807e();
                }
            }
            m42794a((char) Typography.greater);
        } else {
            throw new ParseException(this, "expecting processing instruction, comment, or \"<!\"");
        }
    }

    /* renamed from: J */
    private char m42774J() throws ParseException, IOException {
        int i;
        m42795a(f56775q);
        if (m42799b('x')) {
            m42807e();
            i = 16;
        } else {
            i = 10;
        }
        int i2 = 0;
        while (!m42799b(';')) {
            int i3 = i2 + 1;
            this.f56797O[i2] = m42807e();
            if (i3 >= 255) {
                this.f56788E.warning("Tmp buffer overflow on readCharRef", this.f56801z, getLineNumber());
                return ' ';
            }
            i2 = i3;
        }
        m42794a(';');
        String str = new String(this.f56797O, 0, i2);
        try {
            return (char) Integer.parseInt(str, i);
        } catch (NumberFormatException unused) {
            ParseLog parseLog = this.f56788E;
            StringBuilder sb = new StringBuilder();
            sb.append(Const.jsQuote);
            sb.append(str);
            sb.append("\" is not a valid ");
            sb.append(i == 16 ? "hexadecimal" : "decimal");
            sb.append(" number");
            parseLog.warning(sb.toString(), this.f56801z, getLineNumber());
            return ' ';
        }
    }

    /* renamed from: K */
    private final char[] m42775K() throws ParseException, IOException {
        if (!m42802b(f56775q)) {
            return m42777M().toCharArray();
        }
        return new char[]{m42774J()};
    }

    /* renamed from: L */
    private final boolean m42776L() throws ParseException, IOException {
        return m42799b((char) Typography.amp);
    }

    /* renamed from: M */
    private String m42777M() throws ParseException, IOException {
        m42794a((char) Typography.amp);
        String j = m42813j();
        String str = (String) this.f56786C.get(j);
        if (str == null) {
            if (this.f56791H) {
                ParseLog parseLog = this.f56788E;
                parseLog.warning(ParamKeys.SIGN_AND + j + "; not found -- possibly defined in external DTD)", this.f56801z, getLineNumber());
            } else {
                ParseLog parseLog2 = this.f56788E;
                parseLog2.warning("No declaration of &" + j + ";", this.f56801z, getLineNumber());
            }
            str = "";
        }
        m42794a(';');
        return str;
    }

    /* renamed from: N */
    private String m42778N() throws ParseException, IOException {
        m42794a('%');
        String j = m42813j();
        String str = (String) this.f56787D.get(j);
        if (str == null) {
            ParseLog parseLog = this.f56788E;
            parseLog.warning("No declaration of %" + j + ";", this.f56801z, getLineNumber());
            str = "";
        }
        m42794a(';');
        return str;
    }

    /* renamed from: O */
    private boolean m42779O() throws ParseException, IOException {
        return m42799b('%');
    }

    /* renamed from: P */
    private void m42780P() throws ParseException, IOException {
        String str;
        String str2;
        m42795a(f56776r);
        m42810g();
        if (m42799b('%')) {
            m42794a('%');
            m42810g();
            String j = m42813j();
            m42810g();
            if (m42816m()) {
                str2 = m42815l();
            } else {
                str2 = m42782R();
            }
            this.f56787D.put(j, str2);
        } else {
            String j2 = m42813j();
            m42810g();
            if (m42816m()) {
                str = m42815l();
            } else if (m42783S()) {
                str = m42782R();
                if (m42811h()) {
                    m42810g();
                }
                if (m42802b(f56777s)) {
                    m42795a(f56777s);
                    m42810g();
                    m42813j();
                }
            } else {
                throw new ParseException(this, "expecting double-quote, \"PUBLIC\" or \"SYSTEM\" while reading entity declaration");
            }
            this.f56786C.put(j2, str);
        }
        if (m42811h()) {
            m42810g();
        }
        m42794a((char) Typography.greater);
    }

    /* renamed from: Q */
    private boolean m42781Q() throws ParseException, IOException {
        return m42802b(f56776r);
    }

    /* renamed from: R */
    private String m42782R() throws ParseException, IOException {
        if (m42802b(f56778t)) {
            m42795a(f56778t);
        } else if (m42802b(f56779u)) {
            m42795a(f56779u);
            m42810g();
            m42818o();
        } else {
            throw new ParseException(this, "expecting \"SYSTEM\" or \"PUBLIC\" while reading external ID");
        }
        m42810g();
        m42817n();
        return "(WARNING: external ID not read)";
    }

    /* renamed from: S */
    private boolean m42783S() throws ParseException, IOException {
        return m42802b(f56778t) || m42802b(f56779u);
    }

    /* renamed from: a */
    private final void m42795a(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f56795L - this.f56794K >= length || m42793a(length) > 0) {
            char[] cArr2 = this.f56793J;
            int i = this.f56795L;
            this.f56790G = cArr2[i - 1];
            if (i - this.f56794K >= length) {
                int i2 = 0;
                while (i2 < length) {
                    if (this.f56793J[this.f56794K + i2] == cArr[i2]) {
                        i2++;
                    } else {
                        throw new ParseException(this, new String(this.f56793J, this.f56794K, length), cArr);
                    }
                }
                this.f56794K += length;
                return;
            }
            throw new ParseException(this, "end of XML file", cArr);
        }
        this.f56790G = -1;
        throw new ParseException(this, "end of XML file", cArr);
    }

    /* renamed from: b */
    private final boolean m42802b(char[] cArr) throws ParseException, IOException {
        int length = cArr.length;
        if (this.f56795L - this.f56794K >= length || m42793a(length) > 0) {
            char[] cArr2 = this.f56793J;
            int i = this.f56795L;
            this.f56790G = cArr2[i - 1];
            if (i - this.f56794K < length) {
                return false;
            }
            for (int i2 = 0; i2 < length; i2++) {
                if (this.f56793J[this.f56794K + i2] != cArr[i2]) {
                    return false;
                }
            }
            return true;
        }
        this.f56790G = -1;
        return false;
    }

    /* renamed from: T */
    private String m42784T() throws ParseException, IOException {
        char a = m42791a('\'', (char) Typography.quote);
        StringBuffer stringBuffer = new StringBuffer();
        while (!m42799b(a)) {
            if (m42776L()) {
                stringBuffer.append(m42775K());
            } else {
                stringBuffer.append(m42807e());
            }
        }
        m42794a(a);
        return stringBuffer.toString();
    }

    /* renamed from: U */
    private void m42785U() throws ParseException, IOException {
        int i;
        loop0:
        while (true) {
            i = 0;
            while (!m42799b((char) Typography.less) && !m42799b((char) Typography.amp) && !m42802b(f56781w)) {
                this.f56797O[i] = m42807e();
                if (this.f56797O[i] == 13 && m42809f() == 10) {
                    this.f56797O[i] = m42807e();
                }
                i++;
                if (i == 255) {
                    this.f56800R.characters(this.f56797O, 0, 255);
                }
            }
        }
        if (i > 0) {
            this.f56800R.characters(this.f56797O, 0, i);
        }
    }

    /* renamed from: V */
    private void m42786V() throws ParseException, IOException {
        m42795a(f56780v);
        StringBuffer stringBuffer = null;
        int i = 0;
        while (!m42802b(f56781w)) {
            if (i >= 255) {
                if (stringBuffer == null) {
                    stringBuffer = new StringBuffer(i);
                    stringBuffer.append(this.f56797O, 0, i);
                } else {
                    stringBuffer.append(this.f56797O, 0, i);
                }
                i = 0;
            }
            this.f56797O[i] = m42807e();
            i++;
        }
        m42795a(f56781w);
        if (stringBuffer != null) {
            stringBuffer.append(this.f56797O, 0, i);
            char[] charArray = stringBuffer.toString().toCharArray();
            this.f56800R.characters(charArray, 0, charArray.length);
            return;
        }
        this.f56800R.characters(this.f56797O, 0, i);
    }

    /* renamed from: W */
    private boolean m42787W() throws ParseException, IOException {
        return m42802b(f56780v);
    }

    /* renamed from: X */
    private final Element m42788X() throws ParseException, IOException {
        Element element = new Element();
        boolean a = m42797a(element);
        this.f56800R.startElement(element);
        if (a) {
            m42790Z();
            m42803c(element);
        }
        this.f56800R.endElement(element);
        return element;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public ParseLog mo171212c() {
        return this.f56788E;
    }

    /* renamed from: a */
    private boolean m42797a(Element element) throws ParseException, IOException {
        m42794a((char) Typography.less);
        element.setTagName(m42813j());
        while (m42811h()) {
            m42810g();
            if (!m42800b(IOUtils.DIR_SEPARATOR_UNIX, Typography.greater)) {
                m42798b(element);
            }
        }
        if (m42811h()) {
            m42810g();
        }
        boolean b = m42799b((char) Typography.greater);
        if (b) {
            m42794a((char) Typography.greater);
        } else {
            m42795a(f56782x);
        }
        return b;
    }

    /* renamed from: b */
    private void m42798b(Element element) throws ParseException, IOException {
        String j = m42813j();
        m42767C();
        String T = m42784T();
        if (element.getAttribute(j) != null) {
            ParseLog parseLog = this.f56788E;
            parseLog.warning("Element " + this + " contains attribute " + j + "more than once", this.f56801z, getLineNumber());
        }
        element.setAttribute(j, T);
    }

    /* renamed from: c */
    private void m42803c(Element element) throws ParseException, IOException {
        m42795a(f56783y);
        String j = m42813j();
        if (!j.equals(element.getTagName())) {
            ParseLog parseLog = this.f56788E;
            parseLog.warning("end tag (" + j + ") does not match begin tag (" + element.getTagName() + ")", this.f56801z, getLineNumber());
        }
        if (m42811h()) {
            m42810g();
        }
        m42794a((char) Typography.greater);
    }

    /* renamed from: Y */
    private boolean m42789Y() throws ParseException, IOException {
        return m42802b(f56783y);
    }

    /* renamed from: Z */
    private void m42790Z() throws ParseException, IOException {
        m42785U();
        boolean z = true;
        while (z) {
            if (!m42789Y()) {
                if (m42776L()) {
                    char[] K = m42775K();
                    this.f56800R.characters(K, 0, K.length);
                } else if (m42787W()) {
                    m42786V();
                } else if (m42824u()) {
                    m42823t();
                } else if (m42822s()) {
                    m42821r();
                } else if (m42799b((char) Typography.less)) {
                    m42788X();
                }
                m42785U();
            }
            z = false;
            m42785U();
        }
    }
}
