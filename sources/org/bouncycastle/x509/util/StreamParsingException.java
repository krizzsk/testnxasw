package org.bouncycastle.x509.util;

public class StreamParsingException extends Exception {

    /* renamed from: _e */
    Throwable f8421_e;

    public StreamParsingException(String str, Throwable th) {
        super(str);
        this.f8421_e = th;
    }

    public Throwable getCause() {
        return this.f8421_e;
    }
}
