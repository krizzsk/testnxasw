package com.koushikdutta.async.http.filter;

import com.koushikdutta.async.ByteBufferList;
import com.koushikdutta.async.C21121Util;
import com.koushikdutta.async.DataEmitter;
import com.koushikdutta.async.FilteredDataEmitter;
import org.apache.commons.lang3.CharUtils;

public class ChunkedInputFilter extends FilteredDataEmitter {

    /* renamed from: b */
    static final /* synthetic */ boolean f58247b = (!ChunkedInputFilter.class.desiredAssertionStatus());

    /* renamed from: a */
    ByteBufferList f58248a = new ByteBufferList();

    /* renamed from: c */
    private int f58249c = 0;

    /* renamed from: d */
    private int f58250d = 0;

    /* renamed from: e */
    private State f58251e = State.CHUNK_LEN;

    private enum State {
        CHUNK_LEN,
        CHUNK_LEN_CR,
        CHUNK_LEN_CRLF,
        CHUNK,
        CHUNK_CR,
        CHUNK_CRLF,
        COMPLETE,
        ERROR
    }

    /* renamed from: a */
    private boolean m44178a(char c, char c2) {
        if (c == c2) {
            return true;
        }
        this.f58251e = State.ERROR;
        report(new ChunkedDataException(c2 + " was expected, got " + c));
        return false;
    }

    /* renamed from: a */
    private boolean m44177a(char c) {
        return m44178a(c, 10);
    }

    /* renamed from: b */
    private boolean m44179b(char c) {
        return m44178a(c, CharUtils.f7473CR);
    }

    /* access modifiers changed from: protected */
    public void report(Exception exc) {
        if (exc == null && this.f58251e != State.COMPLETE) {
            exc = new ChunkedDataException("chunked input ended before final chunk");
        }
        super.report(exc);
    }

    public void onDataAvailable(DataEmitter dataEmitter, ByteBufferList byteBufferList) {
        if (this.f58251e == State.ERROR) {
            byteBufferList.recycle();
            return;
        }
        while (byteBufferList.remaining() > 0) {
            try {
                switch (C212051.f58252x1736c154[this.f58251e.ordinal()]) {
                    case 1:
                        char byteChar = byteBufferList.getByteChar();
                        if (byteChar == 13) {
                            this.f58251e = State.CHUNK_LEN_CR;
                        } else {
                            int i = this.f58249c * 16;
                            this.f58249c = i;
                            if (byteChar >= 'a' && byteChar <= 'f') {
                                this.f58249c = i + (byteChar - 'a') + 10;
                            } else if (byteChar >= '0' && byteChar <= '9') {
                                this.f58249c += byteChar - '0';
                            } else if (byteChar < 'A' || byteChar > 'F') {
                                report(new ChunkedDataException("invalid chunk length: " + byteChar));
                                return;
                            } else {
                                this.f58249c += (byteChar - 'A') + 10;
                            }
                        }
                        this.f58250d = this.f58249c;
                        break;
                    case 2:
                        if (m44177a(byteBufferList.getByteChar())) {
                            this.f58251e = State.CHUNK;
                            break;
                        } else {
                            return;
                        }
                    case 3:
                        int min = Math.min(this.f58250d, byteBufferList.remaining());
                        int i2 = this.f58250d - min;
                        this.f58250d = i2;
                        if (i2 == 0) {
                            this.f58251e = State.CHUNK_CR;
                        }
                        if (min != 0) {
                            byteBufferList.get(this.f58248a, min);
                            C21121Util.emitAllData(this, this.f58248a);
                            break;
                        } else {
                            break;
                        }
                    case 4:
                        if (m44179b(byteBufferList.getByteChar())) {
                            this.f58251e = State.CHUNK_CRLF;
                            break;
                        } else {
                            return;
                        }
                    case 5:
                        if (m44177a(byteBufferList.getByteChar())) {
                            if (this.f58249c > 0) {
                                this.f58251e = State.CHUNK_LEN;
                            } else {
                                this.f58251e = State.COMPLETE;
                                report((Exception) null);
                            }
                            this.f58249c = 0;
                            break;
                        } else {
                            return;
                        }
                    case 6:
                        if (!f58247b) {
                            throw new AssertionError();
                        }
                        return;
                }
            } catch (Exception e) {
                report(e);
                return;
            }
        }
    }

    /* renamed from: com.koushikdutta.async.http.filter.ChunkedInputFilter$1 */
    static /* synthetic */ class C212051 {

        /* renamed from: $SwitchMap$com$koushikdutta$async$http$filter$ChunkedInputFilter$State */
        static final /* synthetic */ int[] f58252x1736c154;

        /* JADX WARNING: Can't wrap try/catch for region: R(14:0|1|2|3|4|5|6|7|8|9|10|11|12|14) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.koushikdutta.async.http.filter.ChunkedInputFilter$State[] r0 = com.koushikdutta.async.http.filter.ChunkedInputFilter.State.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f58252x1736c154 = r0
                com.koushikdutta.async.http.filter.ChunkedInputFilter$State r1 = com.koushikdutta.async.http.filter.ChunkedInputFilter.State.CHUNK_LEN     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f58252x1736c154     // Catch:{ NoSuchFieldError -> 0x001d }
                com.koushikdutta.async.http.filter.ChunkedInputFilter$State r1 = com.koushikdutta.async.http.filter.ChunkedInputFilter.State.CHUNK_LEN_CR     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f58252x1736c154     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.koushikdutta.async.http.filter.ChunkedInputFilter$State r1 = com.koushikdutta.async.http.filter.ChunkedInputFilter.State.CHUNK     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = f58252x1736c154     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.koushikdutta.async.http.filter.ChunkedInputFilter$State r1 = com.koushikdutta.async.http.filter.ChunkedInputFilter.State.CHUNK_CR     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = f58252x1736c154     // Catch:{ NoSuchFieldError -> 0x003e }
                com.koushikdutta.async.http.filter.ChunkedInputFilter$State r1 = com.koushikdutta.async.http.filter.ChunkedInputFilter.State.CHUNK_CRLF     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = f58252x1736c154     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.koushikdutta.async.http.filter.ChunkedInputFilter$State r1 = com.koushikdutta.async.http.filter.ChunkedInputFilter.State.COMPLETE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.koushikdutta.async.http.filter.ChunkedInputFilter.C212051.<clinit>():void");
        }
    }
}
