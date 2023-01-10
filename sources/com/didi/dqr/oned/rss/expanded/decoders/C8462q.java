package com.didi.dqr.oned.rss.expanded.decoders;

import com.didi.dqr.FormatException;
import com.didi.dqr.NotFoundException;
import com.didi.dqr.common.BitArray;
import kotlin.text.Typography;
import org.apache.commons.p074io.IOUtils;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.dqr.oned.rss.expanded.decoders.q */
/* compiled from: GeneralAppIdDecoder */
final class C8462q {

    /* renamed from: a */
    private final BitArray f20732a;

    /* renamed from: b */
    private final CurrentParsingState f20733b = new CurrentParsingState();

    /* renamed from: c */
    private final StringBuilder f20734c = new StringBuilder();

    C8462q(BitArray bitArray) {
        this.f20732a = bitArray;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public String mo63402a(StringBuilder sb, int i) throws NotFoundException, FormatException {
        String str = null;
        while (true) {
            C8458m a = mo63401a(i, str);
            String a2 = C8461p.m17448a(a.mo63390a());
            if (a2 != null) {
                sb.append(a2);
            }
            String valueOf = a.mo63391b() ? String.valueOf(a.mo63392c()) : null;
            if (i == a.mo63399g()) {
                return sb.toString();
            }
            i = a.mo63399g();
            str = valueOf;
        }
    }

    /* renamed from: a */
    private boolean m17452a(int i) {
        if (i + 7 <= this.f20732a.getSize()) {
            int i2 = i;
            while (true) {
                int i3 = i + 3;
                if (i2 >= i3) {
                    return this.f20732a.get(i3);
                }
                if (this.f20732a.get(i2)) {
                    return true;
                }
                i2++;
            }
        } else if (i + 4 <= this.f20732a.getSize()) {
            return true;
        } else {
            return false;
        }
    }

    /* renamed from: b */
    private C8459n m17454b(int i) throws FormatException {
        int i2 = i + 7;
        if (i2 > this.f20732a.getSize()) {
            int a = mo63400a(i, 4);
            if (a == 0) {
                return new C8459n(this.f20732a.getSize(), 10, 10);
            }
            return new C8459n(this.f20732a.getSize(), a - 1, 10);
        }
        int a2 = mo63400a(i, 7) - 8;
        return new C8459n(i2, a2 / 11, a2 % 11);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63400a(int i, int i2) {
        return m17450a(this.f20732a, i, i2);
    }

    /* renamed from: a */
    static int m17450a(BitArray bitArray, int i, int i2) {
        int i3 = 0;
        for (int i4 = 0; i4 < i2; i4++) {
            if (bitArray.get(i + i4)) {
                i3 |= 1 << ((i2 - i4) - 1);
            }
        }
        return i3;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public C8458m mo63401a(int i, String str) throws FormatException {
        this.f20734c.setLength(0);
        if (str != null) {
            this.f20734c.append(str);
        }
        this.f20733b.mo63373a(i);
        C8458m a = m17451a();
        if (a == null || !a.mo63391b()) {
            return new C8458m(this.f20733b.mo63372a(), this.f20734c.toString());
        }
        return new C8458m(this.f20733b.mo63372a(), this.f20734c.toString(), a.mo63392c());
    }

    /* renamed from: a */
    private C8458m m17451a() throws FormatException {
        boolean z;
        C8456k kVar;
        do {
            int a = this.f20733b.mo63372a();
            if (this.f20733b.mo63375b()) {
                kVar = m17457d();
                z = kVar.mo63387b();
            } else if (this.f20733b.mo63377d()) {
                kVar = m17455c();
                z = kVar.mo63387b();
            } else {
                kVar = m17453b();
                z = kVar.mo63387b();
            }
            if (!(a != this.f20733b.mo63372a()) && !z) {
                break;
            }
        } while (!z);
        return kVar.mo63386a();
    }

    /* renamed from: b */
    private C8456k m17453b() throws FormatException {
        C8458m mVar;
        while (m17452a(this.f20733b.mo63372a())) {
            C8459n b = m17454b(this.f20733b.mo63372a());
            this.f20733b.mo63373a(b.mo63399g());
            if (b.mo63396d()) {
                if (b.mo63397e()) {
                    mVar = new C8458m(this.f20733b.mo63372a(), this.f20734c.toString());
                } else {
                    mVar = new C8458m(this.f20733b.mo63372a(), this.f20734c.toString(), b.mo63394b());
                }
                return new C8456k(mVar, true);
            }
            this.f20734c.append(b.mo63393a());
            if (b.mo63397e()) {
                return new C8456k(new C8458m(this.f20733b.mo63372a(), this.f20734c.toString()), true);
            }
            this.f20734c.append(b.mo63394b());
        }
        if (m17463i(this.f20733b.mo63372a())) {
            this.f20733b.mo63379f();
            this.f20733b.mo63374b(4);
        }
        return new C8456k(false);
    }

    /* renamed from: c */
    private C8456k m17455c() throws FormatException {
        while (m17456c(this.f20733b.mo63372a())) {
            C8457l d = m17458d(this.f20733b.mo63372a());
            this.f20733b.mo63373a(d.mo63399g());
            if (d.mo63389b()) {
                return new C8456k(new C8458m(this.f20733b.mo63372a(), this.f20734c.toString()), true);
            }
            this.f20734c.append(d.mo63388a());
        }
        if (m17462h(this.f20733b.mo63372a())) {
            this.f20733b.mo63374b(3);
            this.f20733b.mo63378e();
        } else if (m17461g(this.f20733b.mo63372a())) {
            if (this.f20733b.mo63372a() + 5 < this.f20732a.getSize()) {
                this.f20733b.mo63374b(5);
            } else {
                this.f20733b.mo63373a(this.f20732a.getSize());
            }
            this.f20733b.mo63379f();
        }
        return new C8456k(false);
    }

    /* renamed from: d */
    private C8456k m17457d() {
        while (m17459e(this.f20733b.mo63372a())) {
            C8457l f = m17460f(this.f20733b.mo63372a());
            this.f20733b.mo63373a(f.mo63399g());
            if (f.mo63389b()) {
                return new C8456k(new C8458m(this.f20733b.mo63372a(), this.f20734c.toString()), true);
            }
            this.f20734c.append(f.mo63388a());
        }
        if (m17462h(this.f20733b.mo63372a())) {
            this.f20733b.mo63374b(3);
            this.f20733b.mo63378e();
        } else if (m17461g(this.f20733b.mo63372a())) {
            if (this.f20733b.mo63372a() + 5 < this.f20732a.getSize()) {
                this.f20733b.mo63374b(5);
            } else {
                this.f20733b.mo63373a(this.f20732a.getSize());
            }
            this.f20733b.mo63380g();
        }
        return new C8456k(false);
    }

    /* renamed from: c */
    private boolean m17456c(int i) {
        int a;
        if (i + 5 > this.f20732a.getSize()) {
            return false;
        }
        int a2 = mo63400a(i, 5);
        if (a2 >= 5 && a2 < 16) {
            return true;
        }
        if (i + 7 > this.f20732a.getSize()) {
            return false;
        }
        int a3 = mo63400a(i, 7);
        if (a3 >= 64 && a3 < 116) {
            return true;
        }
        if (i + 8 <= this.f20732a.getSize() && (a = mo63400a(i, 8)) >= 232 && a < 253) {
            return true;
        }
        return false;
    }

    /* renamed from: d */
    private C8457l m17458d(int i) throws FormatException {
        char c;
        int a = mo63400a(i, 5);
        if (a == 15) {
            return new C8457l(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new C8457l(i + 5, (char) ((a + 48) - 5));
        }
        int a2 = mo63400a(i, 7);
        if (a2 >= 64 && a2 < 90) {
            return new C8457l(i + 7, (char) (a2 + 1));
        }
        if (a2 >= 90 && a2 < 116) {
            return new C8457l(i + 7, (char) (a2 + 7));
        }
        switch (mo63400a(i, 8)) {
            case 232:
                c = '!';
                break;
            case 233:
                c = Typography.quote;
                break;
            case 234:
                c = '%';
                break;
            case 235:
                c = Typography.amp;
                break;
            case 236:
                c = '\'';
                break;
            case 237:
                c = VersionRange.LEFT_OPEN;
                break;
            case 238:
                c = VersionRange.RIGHT_OPEN;
                break;
            case 239:
                c = '*';
                break;
            case 240:
                c = '+';
                break;
            case 241:
                c = ',';
                break;
            case 242:
                c = '-';
                break;
            case 243:
                c = '.';
                break;
            case 244:
                c = IOUtils.DIR_SEPARATOR_UNIX;
                break;
            case 245:
                c = ':';
                break;
            case 246:
                c = ';';
                break;
            case 247:
                c = Typography.less;
                break;
            case 248:
                c = '=';
                break;
            case 249:
                c = Typography.greater;
                break;
            case 250:
                c = '?';
                break;
            case 251:
                c = '_';
                break;
            case 252:
                c = ' ';
                break;
            default:
                throw FormatException.getFormatInstance();
        }
        return new C8457l(i + 8, c);
    }

    /* renamed from: e */
    private boolean m17459e(int i) {
        int a;
        if (i + 5 > this.f20732a.getSize()) {
            return false;
        }
        int a2 = mo63400a(i, 5);
        if (a2 >= 5 && a2 < 16) {
            return true;
        }
        if (i + 6 <= this.f20732a.getSize() && (a = mo63400a(i, 6)) >= 16 && a < 63) {
            return true;
        }
        return false;
    }

    /* renamed from: f */
    private C8457l m17460f(int i) {
        char c;
        int a = mo63400a(i, 5);
        if (a == 15) {
            return new C8457l(i + 5, '$');
        }
        if (a >= 5 && a < 15) {
            return new C8457l(i + 5, (char) ((a + 48) - 5));
        }
        int a2 = mo63400a(i, 6);
        if (a2 >= 32 && a2 < 58) {
            return new C8457l(i + 6, (char) (a2 + 33));
        }
        switch (a2) {
            case 58:
                c = '*';
                break;
            case 59:
                c = ',';
                break;
            case 60:
                c = '-';
                break;
            case 61:
                c = '.';
                break;
            case 62:
                c = IOUtils.DIR_SEPARATOR_UNIX;
                break;
            default:
                throw new IllegalStateException("Decoding invalid alphanumeric value: " + a2);
        }
        return new C8457l(i + 6, c);
    }

    /* renamed from: g */
    private boolean m17461g(int i) {
        int i2;
        if (i + 1 > this.f20732a.getSize()) {
            return false;
        }
        int i3 = 0;
        while (i3 < 5 && (i2 = i3 + i) < this.f20732a.getSize()) {
            if (i3 == 2) {
                if (!this.f20732a.get(i + 2)) {
                    return false;
                }
            } else if (this.f20732a.get(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }

    /* renamed from: h */
    private boolean m17462h(int i) {
        int i2 = i + 3;
        if (i2 > this.f20732a.getSize()) {
            return false;
        }
        while (i < i2) {
            if (this.f20732a.get(i)) {
                return false;
            }
            i++;
        }
        return true;
    }

    /* renamed from: i */
    private boolean m17463i(int i) {
        int i2;
        if (i + 1 > this.f20732a.getSize()) {
            return false;
        }
        int i3 = 0;
        while (i3 < 4 && (i2 = i3 + i) < this.f20732a.getSize()) {
            if (this.f20732a.get(i2)) {
                return false;
            }
            i3++;
        }
        return true;
    }
}
