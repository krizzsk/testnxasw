package com.didi.dqr.datamatrix.encoder;

import org.osgi.framework.VersionRange;

/* renamed from: com.didi.dqr.datamatrix.encoder.c */
/* compiled from: C40Encoder */
class C8429c implements C8432f {
    /* renamed from: a */
    public int mo63288a() {
        return 1;
    }

    C8429c() {
    }

    /* renamed from: a */
    public void mo63289a(C8433g gVar) {
        StringBuilder sb = new StringBuilder();
        while (true) {
            if (!gVar.mo63306h()) {
                break;
            }
            char b = gVar.mo63298b();
            gVar.f20519a++;
            int a = mo63290a(b, sb);
            int e = gVar.mo63303e() + ((sb.length() / 3) * 2);
            gVar.mo63301c(e);
            int dataCapacity = gVar.mo63308j().getDataCapacity() - e;
            if (gVar.mo63306h()) {
                if (sb.length() % 3 == 0 && HighLevelEncoder.m17240a(gVar.mo63292a(), gVar.f20519a, mo63288a()) != mo63288a()) {
                    gVar.mo63299b(0);
                    break;
                }
            } else {
                StringBuilder sb2 = new StringBuilder();
                if (sb.length() % 3 == 2 && dataCapacity != 2) {
                    a = m17261a(gVar, sb, sb2, a);
                }
                while (sb.length() % 3 == 1 && (a > 3 || dataCapacity != 1)) {
                    a = m17261a(gVar, sb, sb2, a);
                }
            }
        }
        mo63291b(gVar, sb);
    }

    /* renamed from: a */
    private int m17261a(C8433g gVar, StringBuilder sb, StringBuilder sb2, int i) {
        int length = sb.length();
        sb.delete(length - i, length);
        gVar.f20519a--;
        int a = mo63290a(gVar.mo63298b(), sb2);
        gVar.mo63310l();
        return a;
    }

    /* renamed from: a */
    static void m17263a(C8433g gVar, StringBuilder sb) {
        gVar.mo63297a(m17262a((CharSequence) sb));
        sb.delete(0, 3);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo63291b(C8433g gVar, StringBuilder sb) {
        int length = sb.length() % 3;
        int e = gVar.mo63303e() + ((sb.length() / 3) * 2);
        gVar.mo63301c(e);
        int dataCapacity = gVar.mo63308j().getDataCapacity() - e;
        if (length == 2) {
            sb.append(0);
            while (sb.length() >= 3) {
                m17263a(gVar, sb);
            }
            if (gVar.mo63306h()) {
                gVar.mo63293a(254);
            }
        } else if (dataCapacity == 1 && length == 1) {
            while (sb.length() >= 3) {
                m17263a(gVar, sb);
            }
            if (gVar.mo63306h()) {
                gVar.mo63293a(254);
            }
            gVar.f20519a--;
        } else if (length == 0) {
            while (sb.length() >= 3) {
                m17263a(gVar, sb);
            }
            if (dataCapacity > 0 || gVar.mo63306h()) {
                gVar.mo63293a(254);
            }
        } else {
            throw new IllegalStateException("Unexpected case. Please report!");
        }
        gVar.mo63299b(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public int mo63290a(char c, StringBuilder sb) {
        if (c == ' ') {
            sb.append(3);
            return 1;
        } else if (c >= '0' && c <= '9') {
            sb.append((char) ((c - '0') + 4));
            return 1;
        } else if (c >= 'A' && c <= 'Z') {
            sb.append((char) ((c - 'A') + 14));
            return 1;
        } else if (c < ' ') {
            sb.append(0);
            sb.append(c);
            return 2;
        } else if (c <= '/') {
            sb.append(1);
            sb.append((char) (c - '!'));
            return 2;
        } else if (c <= '@') {
            sb.append(1);
            sb.append((char) ((c - ':') + 15));
            return 2;
        } else if (c <= '_') {
            sb.append(1);
            sb.append((char) ((c - '[') + 22));
            return 2;
        } else if (c <= 127) {
            sb.append(2);
            sb.append((char) (c - '`'));
            return 2;
        } else {
            sb.append("\u0001\u001e");
            return mo63290a((char) (c - 128), sb) + 2;
        }
    }

    /* renamed from: a */
    private static String m17262a(CharSequence charSequence) {
        int charAt = (charSequence.charAt(0) * 1600) + (charSequence.charAt(1) * VersionRange.LEFT_OPEN) + charSequence.charAt(2) + 1;
        return new String(new char[]{(char) (charAt / 256), (char) (charAt % 256)});
    }
}
