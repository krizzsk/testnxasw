package com.koushikdutta.async.http.server;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import java.nio.ByteBuffer;

public class BoundaryEmitter extends FilteredDataEmitter {

    /* renamed from: j */
    static final /* synthetic */ boolean f58275j = (!BoundaryEmitter.class.desiredAssertionStatus());

    /* renamed from: a */
    private byte[] f58276a;

    /* renamed from: i */
    int f58277i = 2;

    /* access modifiers changed from: protected */
    public void onBoundaryEnd() {
    }

    /* access modifiers changed from: protected */
    public void onBoundaryStart() {
    }

    public void setBoundary(String str) {
        this.f58276a = ("\r\n--" + str).getBytes();
    }

    public String getBoundary() {
        if (this.f58276a == null) {
            return null;
        }
        byte[] bArr = this.f58276a;
        return new String(bArr, 4, bArr.length - 4);
    }

    public String getBoundaryStart() {
        if (f58275j || this.f58276a != null) {
            byte[] bArr = this.f58276a;
            return new String(bArr, 2, bArr.length - 2);
        }
        throw new AssertionError();
    }

    public String getBoundaryEnd() {
        if (f58275j || this.f58276a != null) {
            return getBoundaryStart() + "--\r\n";
        }
        throw new AssertionError();
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (this.f58277i > 0) {
            ByteBuffer obtain = ByteBufferList.obtain(this.f58276a.length);
            obtain.put(this.f58276a, 0, this.f58277i);
            obtain.flip();
            byteBufferList.addFirst(obtain);
            this.f58277i = 0;
        }
        int remaining = byteBufferList.remaining();
        byte[] bArr = new byte[remaining];
        byteBufferList.get(bArr);
        int i = 0;
        int i2 = 0;
        while (i < remaining) {
            int i3 = this.f58277i;
            if (i3 >= 0) {
                byte b = bArr[i];
                byte[] bArr2 = this.f58276a;
                if (b == bArr2[i3]) {
                    int i4 = i3 + 1;
                    this.f58277i = i4;
                    if (i4 == bArr2.length) {
                        this.f58277i = -1;
                    }
                } else if (i3 > 0) {
                    i -= i3;
                    this.f58277i = 0;
                }
            } else if (i3 == -1) {
                if (bArr[i] == 13) {
                    this.f58277i = -4;
                    int length = (i - i2) - this.f58276a.length;
                    if (!(i2 == 0 && length == 0)) {
                        ByteBuffer put = ByteBufferList.obtain(length).put(bArr, i2, length);
                        put.flip();
                        ByteBufferList byteBufferList2 = new ByteBufferList();
                        byteBufferList2.add(put);
                        super.onDataAvailable(this, byteBufferList2);
                    }
                    onBoundaryStart();
                } else if (bArr[i] == 45) {
                    this.f58277i = -2;
                } else {
                    report(new MimeEncodingException("Invalid multipart/form-data. Expected \r or -"));
                    return;
                }
            } else if (i3 == -2) {
                if (bArr[i] == 45) {
                    this.f58277i = -3;
                } else {
                    report(new MimeEncodingException("Invalid multipart/form-data. Expected -"));
                    return;
                }
            } else if (i3 == -3) {
                if (bArr[i] == 13) {
                    this.f58277i = -4;
                    int i5 = i - i2;
                    ByteBuffer put2 = ByteBufferList.obtain((i5 - this.f58276a.length) - 2).put(bArr, i2, (i5 - this.f58276a.length) - 2);
                    put2.flip();
                    ByteBufferList byteBufferList3 = new ByteBufferList();
                    byteBufferList3.add(put2);
                    super.onDataAvailable(this, byteBufferList3);
                    onBoundaryEnd();
                } else {
                    report(new MimeEncodingException("Invalid multipart/form-data. Expected \r"));
                    return;
                }
            } else if (i3 == -4) {
                if (bArr[i] == 10) {
                    i2 = i + 1;
                    this.f58277i = 0;
                } else {
                    report(new MimeEncodingException("Invalid multipart/form-data. Expected \n"));
                }
            } else if (f58275j) {
                report(new MimeEncodingException("Invalid multipart/form-data. Unknown state?"));
            } else {
                throw new AssertionError();
            }
            i++;
        }
        if (i2 < remaining) {
            int max = (remaining - i2) - Math.max(this.f58277i, 0);
            ByteBuffer put3 = ByteBufferList.obtain(max).put(bArr, i2, max);
            put3.flip();
            ByteBufferList byteBufferList4 = new ByteBufferList();
            byteBufferList4.add(put3);
            super.onDataAvailable(this, byteBufferList4);
        }
    }
}
