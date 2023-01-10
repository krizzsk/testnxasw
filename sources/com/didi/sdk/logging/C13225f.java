package com.didi.sdk.logging;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* renamed from: com.didi.sdk.logging.f */
/* compiled from: ResilientFileOutputStream */
class C13225f extends OutputStream {

    /* renamed from: a */
    protected OutputStream f39315a = new BufferedOutputStream(this.f39318d);

    /* renamed from: b */
    protected boolean f39316b = true;

    /* renamed from: c */
    private File f39317c;

    /* renamed from: d */
    private FileOutputStream f39318d;

    /* renamed from: e */
    private C13224e f39319e;

    C13225f(File file, boolean z) throws FileNotFoundException {
        this.f39317c = file;
        this.f39318d = new FileOutputStream(file, z);
    }

    /* renamed from: f */
    private boolean m29628f() {
        return this.f39319e != null && !this.f39316b;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (!m29628f()) {
            try {
                this.f39315a.write(bArr, i, i2);
                m29629g();
            } catch (IOException e) {
                mo99026a(e);
            }
        } else if (!this.f39319e.mo99024a()) {
            mo99031e();
        }
    }

    public void write(int i) {
        if (!m29628f()) {
            try {
                this.f39315a.write(i);
                m29629g();
            } catch (IOException e) {
                mo99026a(e);
            }
        } else if (!this.f39319e.mo99024a()) {
            mo99031e();
        }
    }

    public void flush() {
        OutputStream outputStream = this.f39315a;
        if (outputStream != null) {
            try {
                outputStream.flush();
                m29629g();
            } catch (IOException e) {
                mo99026a(e);
            }
        }
    }

    /* renamed from: a */
    public FileChannel mo99025a() {
        if (this.f39315a == null) {
            return null;
        }
        return this.f39318d.getChannel();
    }

    /* renamed from: b */
    public File mo99027b() {
        return this.f39317c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo99028c() {
        return "mFile [" + this.f39317c + Const.jaRight;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public OutputStream mo99030d() throws IOException {
        this.f39318d = new FileOutputStream(this.f39317c, true);
        return new BufferedOutputStream(this.f39318d);
    }

    /* renamed from: g */
    private void m29629g() {
        if (this.f39319e != null) {
            this.f39319e = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo99026a(IOException iOException) {
        this.f39316b = false;
        if (this.f39319e == null) {
            this.f39319e = new C13224e();
        }
    }

    public void close() throws IOException {
        OutputStream outputStream = this.f39315a;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* JADX WARNING: Can't wrap try/catch for region: R(5:0|1|2|3|5) */
    /* JADX WARNING: Code restructure failed: missing block: B:6:?, code lost:
        return;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:2:0x0003 */
    /* renamed from: e */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void mo99031e() {
        /*
            r1 = this;
            r1.close()     // Catch:{ IOException -> 0x0003 }
        L_0x0003:
            java.io.OutputStream r0 = r1.mo99030d()     // Catch:{ IOException -> 0x000c }
            r1.f39315a = r0     // Catch:{ IOException -> 0x000c }
            r0 = 1
            r1.f39316b = r0     // Catch:{ IOException -> 0x000c }
        L_0x000c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.logging.C13225f.mo99031e():void");
    }
}
