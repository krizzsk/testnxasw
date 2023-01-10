package com.google.android.play.core.assetpacks;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Enumeration;

/* renamed from: com.google.android.play.core.assetpacks.dc */
public final class C19972dc extends InputStream {

    /* renamed from: a */
    private final Enumeration<File> f55927a;

    /* renamed from: b */
    private InputStream f55928b;

    public C19972dc(Enumeration<File> enumeration) throws IOException {
        this.f55927a = enumeration;
        mo164188a();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo164188a() throws IOException {
        InputStream inputStream = this.f55928b;
        if (inputStream != null) {
            inputStream.close();
        }
        this.f55928b = this.f55927a.hasMoreElements() ? new FileInputStream(this.f55927a.nextElement()) : null;
    }

    public final void close() throws IOException {
        super.close();
        InputStream inputStream = this.f55928b;
        if (inputStream != null) {
            inputStream.close();
            this.f55928b = null;
        }
    }

    public final int read() throws IOException {
        while (true) {
            InputStream inputStream = this.f55928b;
            if (inputStream == null) {
                return -1;
            }
            int read = inputStream.read();
            if (read != -1) {
                return read;
            }
            mo164188a();
        }
    }

    public final int read(byte[] bArr, int i, int i2) throws IOException {
        if (this.f55928b == null) {
            return -1;
        }
        if (bArr == null) {
            throw null;
        } else if (i < 0 || i2 < 0 || i2 > bArr.length - i) {
            throw new IndexOutOfBoundsException();
        } else if (i2 == 0) {
            return 0;
        } else {
            do {
                int read = this.f55928b.read(bArr, i, i2);
                if (read > 0) {
                    return read;
                }
                mo164188a();
            } while (this.f55928b != null);
            return -1;
        }
    }
}
