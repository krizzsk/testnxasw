package com.jumio.ale.swig;

import java.io.FilterOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ALEOutputStream extends FilterOutputStream {

    /* renamed from: a */
    public ALERequest f57349a;

    /* renamed from: b */
    public OutputStream f57350b;

    /* renamed from: c */
    public byte[] f57351c;

    /* renamed from: d */
    public int f57352d;

    /* renamed from: e */
    public boolean f57353e;

    public ALEOutputStream(OutputStream outputStream, ALERequest aLERequest, int i) throws Exception {
        this(outputStream, aLERequest, (ALEHeader) null, i);
    }

    public void close() throws IOException {
        if (!this.f57353e) {
            this.f57353e = true;
            try {
                byte[] bArr = new byte[this.f57349a.calculateRequestFinish()];
                this.f57351c = bArr;
                this.f57352d = this.f57349a.finishRequest(bArr);
            } catch (Exception unused) {
                this.f57351c = null;
                this.f57352d = 0;
            }
            try {
                flush();
            } catch (IOException unused2) {
            }
            this.f57350b.close();
        }
    }

    public void flush() throws IOException {
        byte[] bArr = this.f57351c;
        if (bArr != null) {
            this.f57350b.write(bArr, 0, this.f57352d);
            this.f57351c = null;
        }
        this.f57350b.flush();
    }

    public void write(byte[] bArr, int i, int i2) throws IOException {
        if (i == 0 && i2 == bArr.length) {
            write(bArr);
            return;
        }
        byte[] bArr2 = new byte[i2];
        System.arraycopy(bArr, i, bArr2, 0, i2);
        write(bArr2);
    }

    public ALEOutputStream(OutputStream outputStream, ALERequest aLERequest, ALEHeader aLEHeader, int i) throws Exception {
        super(outputStream);
        this.f57349a = null;
        this.f57352d = 0;
        this.f57353e = false;
        this.f57350b = outputStream;
        this.f57349a = aLERequest;
        byte[] bArr = new byte[aLERequest.calculateRequestInit(aLEHeader, i)];
        this.f57351c = bArr;
        int initRequest = aLERequest.initRequest(aLEHeader, i, bArr);
        this.f57352d = initRequest;
        outputStream.write(this.f57351c, 0, initRequest);
    }

    public void write(byte[] bArr) throws IOException {
        byte[] bArr2 = new byte[this.f57349a.calculateRequestUpdate(bArr.length)];
        this.f57351c = bArr2;
        try {
            int updateRequest = this.f57349a.updateRequest(bArr, bArr2);
            this.f57352d = updateRequest;
            byte[] bArr3 = this.f57351c;
            if (bArr3 != null) {
                this.f57350b.write(bArr3, 0, updateRequest);
                this.f57351c = null;
                this.f57352d = 0;
            }
        } catch (Exception e) {
            throw new IOException(e);
        }
    }
}
