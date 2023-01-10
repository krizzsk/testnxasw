package com.didi.dqr.datamatrix.encoder;

import androidx.core.view.InputDeviceCompat;

/* renamed from: com.didi.dqr.datamatrix.encoder.b */
/* compiled from: Base256Encoder */
final class C8428b implements C8432f {
    /* renamed from: a */
    public int mo63288a() {
        return 5;
    }

    C8428b() {
    }

    /* renamed from: a */
    public void mo63289a(C8433g gVar) {
        StringBuilder sb = new StringBuilder();
        sb.append(0);
        while (true) {
            if (!gVar.mo63306h()) {
                break;
            }
            sb.append(gVar.mo63298b());
            gVar.f20519a++;
            if (HighLevelEncoder.m17240a(gVar.mo63292a(), gVar.f20519a, mo63288a()) != mo63288a()) {
                gVar.mo63299b(0);
                break;
            }
        }
        int length = sb.length() - 1;
        int e = gVar.mo63303e() + length + 1;
        gVar.mo63301c(e);
        boolean z = gVar.mo63308j().getDataCapacity() - e > 0;
        if (gVar.mo63306h() || z) {
            if (length <= 249) {
                sb.setCharAt(0, (char) length);
            } else if (length <= 1555) {
                sb.setCharAt(0, (char) ((length / 250) + 249));
                sb.insert(1, (char) (length % 250));
            } else {
                throw new IllegalStateException("Message length not in valid ranges: " + length);
            }
        }
        int length2 = sb.length();
        for (int i = 0; i < length2; i++) {
            gVar.mo63293a(m17258a(sb.charAt(i), gVar.mo63303e() + 1));
        }
    }

    /* renamed from: a */
    private static char m17258a(char c, int i) {
        int i2 = c + ((i * 149) % 255) + 1;
        return i2 <= 255 ? (char) i2 : (char) (i2 + InputDeviceCompat.SOURCE_ANY);
    }
}
