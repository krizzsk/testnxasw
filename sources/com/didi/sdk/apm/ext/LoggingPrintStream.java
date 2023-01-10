package com.didi.sdk.apm.ext;

import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.nio.ByteBuffer;
import java.nio.CharBuffer;
import java.nio.charset.Charset;
import java.nio.charset.CharsetDecoder;
import java.nio.charset.CoderResult;
import java.nio.charset.CodingErrorAction;
import java.util.Formatter;
import java.util.Locale;

public abstract class LoggingPrintStream extends PrintStream {

    /* renamed from: a */
    private final StringBuilder f37787a = new StringBuilder();

    /* renamed from: b */
    private ByteBuffer f37788b;

    /* renamed from: c */
    private CharBuffer f37789c;

    /* renamed from: d */
    private CharsetDecoder f37790d;

    /* renamed from: e */
    private final Formatter f37791e = new Formatter(this.f37787a, (Locale) null);

    public boolean checkError() {
        return false;
    }

    public void close() {
    }

    /* access modifiers changed from: protected */
    public abstract void log(String str);

    /* access modifiers changed from: protected */
    public void setError() {
    }

    protected LoggingPrintStream() {
        super(new OutputStream() {
            public void write(int i) throws IOException {
                throw new AssertionError();
            }
        });
    }

    public synchronized void flush() {
        m28488a(true);
    }

    /* renamed from: a */
    private void m28488a(boolean z) {
        int length = this.f37787a.length();
        int i = 0;
        while (i < length) {
            int indexOf = this.f37787a.indexOf("\n", i);
            if (indexOf == -1) {
                break;
            }
            log(this.f37787a.substring(i, indexOf));
            i = indexOf + 1;
        }
        if (z) {
            if (i < length) {
                log(this.f37787a.substring(i));
            }
            this.f37787a.setLength(0);
            return;
        }
        this.f37787a.delete(0, i);
    }

    public void write(int i) {
        write(new byte[]{(byte) i}, 0, 1);
    }

    public void write(byte[] bArr) {
        write(bArr, 0, bArr.length);
    }

    public synchronized void write(byte[] bArr, int i, int i2) {
        CoderResult decode;
        if (this.f37790d == null) {
            this.f37788b = ByteBuffer.allocate(80);
            this.f37789c = CharBuffer.allocate(80);
            this.f37790d = Charset.defaultCharset().newDecoder().onMalformedInput(CodingErrorAction.REPLACE).onUnmappableCharacter(CodingErrorAction.REPLACE);
        }
        int i3 = i2 + i;
        while (i < i3) {
            int min = Math.min(this.f37788b.remaining(), i3 - i);
            this.f37788b.put(bArr, i, min);
            i += min;
            this.f37788b.flip();
            do {
                decode = this.f37790d.decode(this.f37788b, this.f37789c, false);
                this.f37789c.flip();
                this.f37787a.append(this.f37789c);
                this.f37789c.clear();
            } while (decode.isOverflow());
            this.f37788b.compact();
        }
        m28488a(false);
    }

    public PrintStream format(String str, Object... objArr) {
        return format(Locale.getDefault(), str, objArr);
    }

    public PrintStream printf(String str, Object... objArr) {
        return format(str, objArr);
    }

    public PrintStream printf(Locale locale, String str, Object... objArr) {
        return format(locale, str, objArr);
    }

    public synchronized PrintStream format(Locale locale, String str, Object... objArr) {
        if (str != null) {
            this.f37791e.format(locale, str, objArr);
            m28488a(false);
        } else {
            throw new NullPointerException("format");
        }
        return this;
    }

    public synchronized void print(char[] cArr) {
        this.f37787a.append(cArr);
        m28488a(false);
    }

    public synchronized void print(char c) {
        this.f37787a.append(c);
        if (c == 10) {
            m28488a(false);
        }
    }

    public synchronized void print(double d) {
        this.f37787a.append(d);
    }

    public synchronized void print(float f) {
        this.f37787a.append(f);
    }

    public synchronized void print(int i) {
        this.f37787a.append(i);
    }

    public synchronized void print(long j) {
        this.f37787a.append(j);
    }

    public synchronized void print(Object obj) {
        this.f37787a.append(obj);
        m28488a(false);
    }

    public synchronized void print(String str) {
        this.f37787a.append(str);
        m28488a(false);
    }

    public synchronized void print(boolean z) {
        this.f37787a.append(z);
    }

    public synchronized void println() {
        m28488a(true);
    }

    public synchronized void println(char[] cArr) {
        this.f37787a.append(cArr);
        m28488a(true);
    }

    public synchronized void println(char c) {
        this.f37787a.append(c);
        m28488a(true);
    }

    public synchronized void println(double d) {
        this.f37787a.append(d);
        m28488a(true);
    }

    public synchronized void println(float f) {
        this.f37787a.append(f);
        m28488a(true);
    }

    public synchronized void println(int i) {
        this.f37787a.append(i);
        m28488a(true);
    }

    public synchronized void println(long j) {
        this.f37787a.append(j);
        m28488a(true);
    }

    public synchronized void println(Object obj) {
        this.f37787a.append(obj);
        m28488a(true);
    }

    public synchronized void println(String str) {
        if (this.f37787a.length() != 0 || str == null) {
            this.f37787a.append(str);
            m28488a(true);
        } else {
            int length = str.length();
            int i = 0;
            while (i < length) {
                int indexOf = str.indexOf(10, i);
                if (indexOf == -1) {
                    break;
                }
                log(str.substring(i, indexOf));
                i = indexOf + 1;
            }
            if (i < length) {
                log(str.substring(i));
            }
        }
    }

    public synchronized void println(boolean z) {
        this.f37787a.append(z);
        m28488a(true);
    }

    public synchronized PrintStream append(char c) {
        print(c);
        return this;
    }

    public synchronized PrintStream append(CharSequence charSequence) {
        this.f37787a.append(charSequence);
        m28488a(false);
        return this;
    }

    public synchronized PrintStream append(CharSequence charSequence, int i, int i2) {
        this.f37787a.append(charSequence, i, i2);
        m28488a(false);
        return this;
    }
}
