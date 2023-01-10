package com.didi.sdk.audiorecorder.utils.log;

import com.didichuxing.bigdata.p174dp.locsdk.Const;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.channels.FileChannel;

/* renamed from: com.didi.sdk.audiorecorder.utils.log.b */
/* compiled from: ResilientFileOutputStream */
final class C12951b extends OutputStream {

    /* renamed from: a */
    protected OutputStream f38372a;

    /* renamed from: b */
    protected boolean f38373b = true;

    /* renamed from: c */
    private File f38374c;

    /* renamed from: d */
    private FileOutputStream f38375d;

    /* renamed from: e */
    private C12950a f38376e;

    public C12951b(File file, boolean z) throws FileNotFoundException {
        this.f38374c = file;
        this.f38375d = new FileOutputStream(file, z);
        this.f38372a = new BufferedOutputStream(this.f38375d);
        this.f38373b = true;
    }

    /* renamed from: f */
    private boolean m28938f() {
        return this.f38376e != null && !this.f38373b;
    }

    public void write(byte[] bArr, int i, int i2) {
        if (!m28938f()) {
            try {
                this.f38372a.write(bArr, i, i2);
                m28939g();
            } catch (IOException e) {
                mo97692a(e);
            }
        } else if (!this.f38376e.mo97690a()) {
            mo97697e();
        }
    }

    public void write(int i) {
        if (!m28938f()) {
            try {
                this.f38372a.write(i);
                m28939g();
            } catch (IOException e) {
                mo97692a(e);
            }
        } else if (!this.f38376e.mo97690a()) {
            mo97697e();
        }
    }

    public void flush() {
        OutputStream outputStream = this.f38372a;
        if (outputStream != null) {
            try {
                outputStream.flush();
                m28939g();
            } catch (IOException e) {
                mo97692a(e);
            }
        }
    }

    /* renamed from: a */
    public FileChannel mo97691a() {
        if (this.f38372a == null) {
            return null;
        }
        return this.f38375d.getChannel();
    }

    /* renamed from: b */
    public File mo97693b() {
        return this.f38374c;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public String mo97694c() {
        return "mFile [" + this.f38374c + Const.jaRight;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: d */
    public OutputStream mo97696d() throws IOException {
        this.f38375d = new FileOutputStream(this.f38374c, true);
        return new BufferedOutputStream(this.f38375d);
    }

    /* renamed from: g */
    private void m28939g() {
        if (this.f38376e != null) {
            this.f38376e = null;
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo97692a(IOException iOException) {
        this.f38373b = false;
        if (this.f38376e == null) {
            this.f38376e = new C12950a();
        }
    }

    public void close() throws IOException {
        OutputStream outputStream = this.f38372a;
        if (outputStream != null) {
            outputStream.close();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: e */
    public void mo97697e() {
        try {
            close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            this.f38372a = mo97696d();
            this.f38373b = true;
        } catch (IOException e2) {
            e2.printStackTrace();
        }
    }
}
