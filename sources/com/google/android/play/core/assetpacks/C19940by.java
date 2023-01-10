package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

/* renamed from: com.google.android.play.core.assetpacks.by */
final class C19940by extends OutputStream {

    /* renamed from: a */
    private final C19973dd f55831a = new C19973dd();

    /* renamed from: b */
    private final File f55832b;

    /* renamed from: c */
    private final C19987dr f55833c;

    /* renamed from: d */
    private long f55834d;

    /* renamed from: e */
    private long f55835e;

    /* renamed from: f */
    private FileOutputStream f55836f;

    /* renamed from: g */
    private C19993dx f55837g;

    C19940by(File file, C19987dr drVar) {
        this.f55832b = file;
        this.f55833c = drVar;
    }

    public final void write(int i) throws IOException {
        write(new byte[]{(byte) i});
    }

    public final void write(byte[] bArr) throws IOException {
        write(bArr, 0, bArr.length);
    }

    public final void write(byte[] bArr, int i, int i2) throws IOException {
        int i3;
        while (i2 > 0) {
            if (this.f55834d == 0 && this.f55835e == 0) {
                int a = this.f55831a.mo164192a(bArr, i, i2);
                if (a != -1) {
                    i += a;
                    i2 -= a;
                    C19993dx a2 = this.f55831a.mo164193a();
                    this.f55837g = a2;
                    if (a2.mo164231g()) {
                        this.f55834d = 0;
                        this.f55833c.mo164219b(this.f55837g.mo164232h(), this.f55837g.mo164232h().length);
                        this.f55835e = (long) this.f55837g.mo164232h().length;
                    } else if (!this.f55837g.mo164225b() || this.f55837g.mo164224a()) {
                        byte[] h = this.f55837g.mo164232h();
                        this.f55833c.mo164219b(h, h.length);
                        this.f55834d = this.f55837g.mo164227d();
                    } else {
                        this.f55833c.mo164214a(this.f55837g.mo164232h());
                        File file = new File(this.f55832b, this.f55837g.mo164226c());
                        file.getParentFile().mkdirs();
                        this.f55834d = this.f55837g.mo164227d();
                        this.f55836f = new FileOutputStream(file);
                    }
                } else {
                    return;
                }
            }
            if (!this.f55837g.mo164224a()) {
                if (this.f55837g.mo164231g()) {
                    this.f55833c.mo164211a(this.f55835e, bArr, i, i2);
                    this.f55835e += (long) i2;
                    i3 = i2;
                } else if (this.f55837g.mo164225b()) {
                    i3 = (int) Math.min((long) i2, this.f55834d);
                    this.f55836f.write(bArr, i, i3);
                    long j = this.f55834d - ((long) i3);
                    this.f55834d = j;
                    if (j == 0) {
                        this.f55836f.close();
                    }
                } else {
                    i3 = (int) Math.min((long) i2, this.f55834d);
                    int length = this.f55837g.mo164232h().length;
                    this.f55833c.mo164211a((((long) length) + this.f55837g.mo164227d()) - this.f55834d, bArr, i, i3);
                    this.f55834d -= (long) i3;
                }
                i += i3;
                i2 -= i3;
            }
        }
    }
}
